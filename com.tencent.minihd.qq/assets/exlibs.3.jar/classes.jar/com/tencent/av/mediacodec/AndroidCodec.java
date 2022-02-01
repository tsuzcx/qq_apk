package com.tencent.av.mediacodec;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.av.config.BaseConfigParser;
import com.tencent.av.config.CodecConfigParser2;
import com.tencent.av.config.ConfigManager;
import com.tencent.av.utils.SoLoadUtil;
import com.tencent.qav.QavSDK;
import com.tencent.qav.log.AVLog;
import dalvik.system.DexClassLoader;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"NewApi"})
public class AndroidCodec
{
  public static String AVC_CODEC_MIME;
  public static int DEC_CODEC = 0;
  public static int ENC_CODEC = 1;
  public static String ForceIFrame;
  public static String HEVC_CODEC_MIME;
  public static final int SUPPORT_AVC_DEC = 1;
  public static final int SUPPORT_AVC_ENC = 2;
  public static final int SUPPORT_HEVC_DEC = 4;
  public static final int SUPPORT_HEVC_ENC = 8;
  public static final int SUPPORT_NONE = 0;
  private static final String TAG = "AndroidCodec";
  protected static final int TIMEOUT_US = 33000;
  protected static boolean fInvokeAPILevel21 = true;
  protected static Method fgetInputBuffer21;
  protected static Method fgetOutputBuffer21;
  protected static Method fgetOutputFormat21;
  protected static Method fsetParameters19;
  protected static boolean sLoaded;
  protected int mCodecType = DEC_CODEC;
  protected MediaFormat mFormat;
  protected ByteBuffer[] mInputBuffers;
  protected MediaCodec mMediaCodec;
  protected ByteBuffer[] mOutputBuffers;
  protected MediaFormat mOutputFormat;
  
  static
  {
    DEC_CODEC = 0;
    AVC_CODEC_MIME = "video/avc";
    HEVC_CODEC_MIME = "video/hevc";
    ForceIFrame = "request-sync";
    sLoaded = false;
  }
  
  public AndroidCodec()
  {
    invoke21Apis();
    if ((Build.VERSION.SDK_INT >= 19) && (fsetParameters19 == null)) {}
    try
    {
      fsetParameters19 = MediaCodec.class.getMethod("setParameters", new Class[] { Bundle.class });
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      fsetParameters19 = null;
    }
  }
  
  public static int checkSupportMediaCodecFeature(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 16) {}
    Object localObject2;
    do
    {
      do
      {
        return 0;
        if (Build.VERSION.SDK_INT < 21) {
          break;
        }
        invoke21Apis();
      } while (!fInvokeAPILevel21);
      if (!sLoaded)
      {
        loadCodecLibrary();
        if (sLoaded)
        {
          localObject1 = "PRODUCT=" + Build.PRODUCT.toLowerCase() + ";";
          localObject1 = (String)localObject1 + "MODEL=" + Build.MODEL.toLowerCase() + ";";
          localObject1 = (String)localObject1 + "SDK=" + Build.VERSION.SDK_INT + ";";
          localObject1 = (String)localObject1 + "FINGERPRINT=" + Build.FINGERPRINT.toLowerCase() + ";";
          localObject2 = (String)localObject1 + "MANUFACTURER=" + Build.MANUFACTURER.toLowerCase() + ";";
          localObject1 = paramContext.getApplicationInfo();
          localObject2 = (String)localObject2 + "DATADIR=" + ((ApplicationInfo)localObject1).dataDir + ";";
          NativeCodec.set_device_infos((String)localObject2 + "LIBDIR=" + ((ApplicationInfo)localObject1).nativeLibraryDir + ";");
        }
      }
    } while (!sLoaded);
    int j = 0;
    int i = 0;
    if (DeviceCheck.isAVCDecWhitelistDevices()) {
      if (DeviceCheck.isAVCDecSupportColorFormats())
      {
        i = 0 + 1;
        AVLog.w("AndroidCodec", "checkSupportMediaCodecFeature 白名单：支持H264解码");
      }
    }
    while (DeviceCheck.isAVCEncWhitelistDevices()) {
      if (DeviceCheck.isAVCEncSupportColorFormats())
      {
        AVLog.w("AndroidCodec", "checkSupportMediaCodecFeature 白名单：支持H264编码");
        return i + 2;
        AVLog.w("AndroidCodec", "checkSupportMediaCodecFeature 白名单：不支持H264解码");
        continue;
        localObject1 = ConfigManager.getInstance(paramContext).getParser();
        localObject2 = new CodecConfigParser2();
        if (((CodecConfigParser2)localObject2).getAVCDecoderAbility((BaseConfigParser)localObject1)) {
          if (DeviceCheck.isAVCDecSupportColorFormats())
          {
            i = 0 + 1;
            AVLog.w("AndroidCodec", "checkSupportMediaCodecFeature 配置下发: 支持H264解码");
          }
        }
        for (;;)
        {
          if (((CodecConfigParser2)localObject2).getHevcDecoderAbility((BaseConfigParser)localObject1))
          {
            if (DeviceCheck.isHevcDecSupportColorFormats())
            {
              i += 4;
              AVLog.w("AndroidCodec", "checkSupportMediaCodecFeature 配置下发：支持H265解码");
              break;
              AVLog.w("AndroidCodec", "checkSupportMediaCodecFeature 配置下发: 不支持H264解码");
              i = j;
              continue;
              AVLog.w("AndroidCodec", "checkSupportMediaCodecFeature 无H264解码配置");
              i = j;
              continue;
            }
            AVLog.w("AndroidCodec", "checkSupportMediaCodecFeature 配置下发：不支持H265解码");
            break;
          }
        }
        AVLog.w("AndroidCodec", "checkSupportMediaCodecFeature 无H265解码配置");
      }
      else
      {
        AVLog.w("AndroidCodec", "checkSupportMediaCodecFeature 白名单：不支持H264编码");
        return i;
      }
    }
    paramContext = ConfigManager.getInstance(paramContext).getParser();
    Object localObject1 = new CodecConfigParser2();
    if (((CodecConfigParser2)localObject1).getAVCEncoderAbility(paramContext)) {
      if (DeviceCheck.isAVCEncSupportColorFormats())
      {
        i += 2;
        AVLog.w("AndroidCodec", "checkSupportMediaCodecFeature 配置下发: 支持H264编码");
      }
    }
    while (((CodecConfigParser2)localObject1).getHevcEncoderAbility(paramContext)) {
      if (DeviceCheck.isHevcEncSupportColorFormats())
      {
        AVLog.w("AndroidCodec", "checkSupportMediaCodecFeature 配置下发：支持H265编码");
        return i + 8;
        AVLog.w("AndroidCodec", "checkSupportMediaCodecFeature 配置下发: 不支持H264编码");
        continue;
        AVLog.w("AndroidCodec", "checkSupportMediaCodecFeature 无H264编码配置");
      }
      else
      {
        AVLog.w("AndroidCodec", "checkSupportMediaCodecFeature 配置下发：不支持H265编码");
        return i;
      }
    }
    AVLog.w("AndroidCodec", "checkSupportMediaCodecFeature 无H265编码配置");
    return i;
  }
  
  public static MediaCodecInfo.CodecCapabilities getCodecCapabilities(MediaCodecInfo paramMediaCodecInfo, String paramString)
  {
    try
    {
      paramMediaCodecInfo = paramMediaCodecInfo.getCapabilitiesForType(paramString);
      return paramMediaCodecInfo;
    }
    catch (Exception paramMediaCodecInfo)
    {
      AVLog.e("AndroidCodec", "getCodecCapabilities fail.", paramMediaCodecInfo);
    }
    return null;
  }
  
  public static MediaCodecInfo getCodecInfo(String paramString)
  {
    int j = MediaCodecList.getCodecCount();
    int i = 0;
    while (i < j)
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      if (localMediaCodecInfo.getName().equalsIgnoreCase(paramString)) {
        return localMediaCodecInfo;
      }
      i += 1;
    }
    return null;
  }
  
  public static List<MediaCodecInfo> getDecoderInfos(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int k = MediaCodecList.getCodecCount();
    int i = 0;
    if (i < k)
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      if (localMediaCodecInfo.isEncoder()) {}
      for (;;)
      {
        i += 1;
        break;
        if ((!localMediaCodecInfo.getName().contains(".sw.")) && (!localMediaCodecInfo.getName().contains(".SW.")) && (!localMediaCodecInfo.getName().contains("google")) && (!localMediaCodecInfo.getName().contains("Google")) && (!localMediaCodecInfo.getName().contains("GOOGLE")))
        {
          String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
          int j = 0;
          while (j < arrayOfString.length)
          {
            if (arrayOfString[j].equalsIgnoreCase(paramString)) {
              localArrayList.add(localMediaCodecInfo);
            }
            j += 1;
          }
        }
      }
    }
    return localArrayList;
  }
  
  public static List<MediaCodecInfo> getEncoderInfos(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int k = MediaCodecList.getCodecCount();
    int i = 0;
    if (i < k)
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      if (!localMediaCodecInfo.isEncoder()) {}
      for (;;)
      {
        i += 1;
        break;
        if ((!localMediaCodecInfo.getName().contains(".sw.")) && (!localMediaCodecInfo.getName().contains(".SW.")) && (!localMediaCodecInfo.getName().contains("google")) && (!localMediaCodecInfo.getName().contains("Google")) && (!localMediaCodecInfo.getName().contains("GOOGLE")))
        {
          String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
          int j = 0;
          while (j < arrayOfString.length)
          {
            if (arrayOfString[j].equalsIgnoreCase(paramString)) {
              localArrayList.add(localMediaCodecInfo);
            }
            j += 1;
          }
        }
      }
    }
    return localArrayList;
  }
  
  protected static void invoke21Apis()
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    try
    {
      if (fgetInputBuffer21 == null) {
        fgetInputBuffer21 = MediaCodec.class.getMethod("getInputBuffer", new Class[] { Integer.TYPE });
      }
      if (fgetOutputBuffer21 == null) {
        fgetOutputBuffer21 = MediaCodec.class.getMethod("getOutputBuffer", new Class[] { Integer.TYPE });
      }
      if (fgetOutputFormat21 == null) {
        fgetOutputFormat21 = MediaCodec.class.getMethod("getOutputFormat", new Class[] { Integer.TYPE });
      }
      return;
    }
    catch (Exception localException)
    {
      fgetInputBuffer21 = null;
      fgetOutputBuffer21 = null;
      fgetOutputFormat21 = null;
      fInvokeAPILevel21 = false;
    }
  }
  
  public static void loadCodecLibrary()
  {
    if (!sLoaded) {}
    try
    {
      Context localContext = QavSDK.getInstance().getContext();
      SoLoadUtil.loadNativeLibrary(localContext, "stlport_shared");
      SoLoadUtil.loadNativeLibrary(localContext, "hwcodec");
      int i = NativeCodec.getVersion();
      sLoaded = true;
      AVLog.d("AndroidCodec", String.format("loadCodecLibrary success, version=%s", new Object[] { Integer.valueOf(i) }));
      return;
    }
    catch (Throwable localThrowable)
    {
      AVLog.d("AndroidCodec", "loadCodecLibrary fail.", localThrowable);
      sLoaded = false;
    }
  }
  
  public BufferData dequeueDecoderOutputBuffer(long paramLong)
  {
    for (;;)
    {
      long l2;
      int i;
      try
      {
        Object localObject1 = this.mMediaCodec;
        if (localObject1 == null)
        {
          localObject1 = null;
          return localObject1;
        }
        if (this.mCodecType != DEC_CODEC)
        {
          localObject1 = null;
          continue;
        }
        localObject1 = new BufferData();
        l1 = 0L;
        if (l1 >= paramLong) {
          break label382;
        }
        l2 = System.nanoTime();
        i = this.mMediaCodec.dequeueOutputBuffer(((BufferData)localObject1).info, 3000L);
        l2 = l1 + (System.nanoTime() - l2);
        switch (i)
        {
        case -3: 
          if (i < 0) {
            break label376;
          }
          if (Build.VERSION.SDK_INT > 20) {
            break label288;
          }
          ((BufferData)localObject1).buffer = this.mOutputBuffers[i];
          ((BufferData)localObject1).index = i;
          ((BufferData)localObject1).format = this.mOutputFormat;
          continue;
          this.mOutputBuffers = this.mMediaCodec.getOutputBuffers();
        }
      }
      finally {}
      localObject2.index = -3;
      long l1 = l2;
      continue;
      localObject2.index = -2;
      this.mOutputFormat = this.mMediaCodec.getOutputFormat();
      MediaFormat localMediaFormat = this.mOutputFormat;
      l1 = l2;
      if (localMediaFormat != null)
      {
        try
        {
          AVLog.d("AndroidCodec", String.format("dequeueDecoderOutputBuffer INFO_OUTPUT_FORMAT_CHANGED colorFormat=%s", new Object[] { Integer.valueOf(this.mOutputFormat.getInteger("color-format")) }));
          l1 = l2;
        }
        catch (Exception localException)
        {
          AVLog.e("AndroidCodec", "dequeueDecoderOutputBuffer get color format fail.", localException);
          l1 = l2;
        }
        continue;
        localObject2.index = -1;
        continue;
        label288:
        localObject2.index = i;
        try
        {
          localObject2.buffer = ((ByteBuffer)fgetOutputBuffer21.invoke(this.mMediaCodec, new Object[] { Integer.valueOf(i) }));
          localObject2.format = ((MediaFormat)fgetOutputFormat21.invoke(this.mMediaCodec, new Object[] { Integer.valueOf(i) }));
        }
        catch (Throwable localThrowable)
        {
          AVLog.d("AndroidCodec", "dequeueDecoderOutputBuffer fail.", localThrowable);
          localObject2.success = false;
        }
        continue;
        label376:
        Object localObject3 = null;
        continue;
        label382:
        localObject3 = null;
      }
    }
  }
  
  public BufferData dequeueOutputBuffer()
  {
    for (;;)
    {
      int i;
      try
      {
        Object localObject1 = this.mMediaCodec;
        if (localObject1 == null)
        {
          localObject1 = null;
          return localObject1;
        }
        localObject1 = new BufferData();
        i = this.mMediaCodec.dequeueOutputBuffer(((BufferData)localObject1).info, 33000L);
        switch (i)
        {
        case -3: 
          if (i < 0) {
            break label241;
          }
          if (Build.VERSION.SDK_INT > 20) {
            break label159;
          }
          ((BufferData)localObject1).buffer = this.mOutputBuffers[i];
          ((BufferData)localObject1).index = i;
          ((BufferData)localObject1).format = this.mOutputFormat;
          continue;
          this.mOutputBuffers = this.mMediaCodec.getOutputBuffers();
        }
      }
      finally {}
      localObject2.index = -3;
      break label249;
      localObject2.index = -2;
      this.mOutputFormat = this.mMediaCodec.getOutputFormat();
      break label249;
      localObject2.index = -1;
      continue;
      label159:
      localObject2.index = i;
      try
      {
        localObject2.buffer = ((ByteBuffer)fgetOutputBuffer21.invoke(this.mMediaCodec, new Object[] { Integer.valueOf(i) }));
        localObject2.format = ((MediaFormat)fgetOutputFormat21.invoke(this.mMediaCodec, new Object[] { Integer.valueOf(i) }));
      }
      catch (Throwable localThrowable)
      {
        AVLog.e("AndroidCodec", "dequeueOutputBuffer fail.", localThrowable);
        localObject2.success = false;
      }
      continue;
      label241:
      Object localObject3 = null;
      continue;
      continue;
      label249:
      localObject3 = null;
    }
  }
  
  public void flush()
  {
    if (this.mMediaCodec != null) {
      this.mMediaCodec.flush();
    }
  }
  
  /* Error */
  public BufferData getInputBuffer()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 396	com/tencent/av/mediacodec/AndroidCodec:mMediaCodec	Landroid/media/MediaCodec;
    //   4: ifnonnull +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 6	com/tencent/av/mediacodec/AndroidCodec$BufferData
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 399	com/tencent/av/mediacodec/AndroidCodec$BufferData:<init>	(Lcom/tencent/av/mediacodec/AndroidCodec;)V
    //   17: astore_2
    //   18: aload_0
    //   19: getfield 396	com/tencent/av/mediacodec/AndroidCodec:mMediaCodec	Landroid/media/MediaCodec;
    //   22: ldc2_w 462
    //   25: invokevirtual 472	android/media/MediaCodec:dequeueInputBuffer	(J)I
    //   28: istore_1
    //   29: iload_1
    //   30: iflt +99 -> 129
    //   33: getstatic 90	android/os/Build$VERSION:SDK_INT	I
    //   36: bipush 20
    //   38: if_icmpgt +29 -> 67
    //   41: aload_0
    //   42: monitorenter
    //   43: aload_2
    //   44: iload_1
    //   45: putfield 424	com/tencent/av/mediacodec/AndroidCodec$BufferData:index	I
    //   48: aload_2
    //   49: aload_0
    //   50: getfield 474	com/tencent/av/mediacodec/AndroidCodec:mInputBuffers	[Ljava/nio/ByteBuffer;
    //   53: iload_1
    //   54: aaload
    //   55: putfield 421	com/tencent/av/mediacodec/AndroidCodec$BufferData:buffer	Ljava/nio/ByteBuffer;
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_2
    //   61: areturn
    //   62: astore_2
    //   63: aload_0
    //   64: monitorexit
    //   65: aload_2
    //   66: athrow
    //   67: aload_0
    //   68: monitorenter
    //   69: aload_2
    //   70: iload_1
    //   71: putfield 424	com/tencent/av/mediacodec/AndroidCodec$BufferData:index	I
    //   74: aload_2
    //   75: getstatic 335	com/tencent/av/mediacodec/AndroidCodec:fgetInputBuffer21	Ljava/lang/reflect/Method;
    //   78: aload_0
    //   79: getfield 396	com/tencent/av/mediacodec/AndroidCodec:mMediaCodec	Landroid/media/MediaCodec;
    //   82: iconst_1
    //   83: anewarray 4	java/lang/Object
    //   86: dup
    //   87: iconst_0
    //   88: iload_1
    //   89: invokestatic 381	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   92: aastore
    //   93: invokevirtual 453	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   96: checkcast 455	java/nio/ByteBuffer
    //   99: putfield 421	com/tencent/av/mediacodec/AndroidCodec$BufferData:buffer	Ljava/nio/ByteBuffer;
    //   102: aload_0
    //   103: monitorexit
    //   104: aload_2
    //   105: areturn
    //   106: astore_2
    //   107: aload_0
    //   108: monitorexit
    //   109: aload_2
    //   110: athrow
    //   111: astore_3
    //   112: aload_2
    //   113: iconst_0
    //   114: putfield 460	com/tencent/av/mediacodec/AndroidCodec$BufferData:success	Z
    //   117: ldc 33
    //   119: ldc_w 476
    //   122: aload_3
    //   123: invokestatic 279	com/tencent/qav/log/AVLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   126: goto -24 -> 102
    //   129: aconst_null
    //   130: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	this	AndroidCodec
    //   28	61	1	i	int
    //   17	44	2	localBufferData1	BufferData
    //   62	43	2	localBufferData2	BufferData
    //   106	7	2	localObject	Object
    //   111	12	3	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   43	60	62	finally
    //   63	65	62	finally
    //   69	74	106	finally
    //   74	102	106	finally
    //   102	104	106	finally
    //   107	109	106	finally
    //   112	126	106	finally
    //   74	102	111	java/lang/Throwable
  }
  
  public ByteBuffer getInputBuffer(int paramInt)
  {
    try
    {
      ByteBuffer localByteBuffer = (ByteBuffer)fgetInputBuffer21.invoke(this.mMediaCodec, new Object[] { Integer.valueOf(paramInt) });
      return localByteBuffer;
    }
    catch (Exception localException)
    {
      AVLog.e("AndroidCodec", "getInputBuffer fail.", localException);
    }
    return null;
  }
  
  public ByteBuffer getOutputBuffer(int paramInt)
  {
    try
    {
      ByteBuffer localByteBuffer = (ByteBuffer)fgetOutputBuffer21.invoke(this.mMediaCodec, new Object[] { Integer.valueOf(paramInt) });
      return localByteBuffer;
    }
    catch (Exception localException)
    {
      AVLog.e("AndroidCodec", "getOutputBuffer fail.", localException);
    }
    return null;
  }
  
  public MediaFormat getOutputFormat(int paramInt)
  {
    try
    {
      MediaFormat localMediaFormat = (MediaFormat)fgetOutputFormat21.invoke(this.mMediaCodec, new Object[] { Integer.valueOf(paramInt) });
      return localMediaFormat;
    }
    catch (Exception localException)
    {
      AVLog.e("AndroidCodec", "getOutputFormat fail.", localException);
    }
    return null;
  }
  
  /* Error */
  public boolean init(MediaFormat paramMediaFormat, int paramInt, IMediaCodecCallback paramIMediaCodecCallback)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aload_0
    //   4: aload_1
    //   5: putfield 486	com/tencent/av/mediacodec/AndroidCodec:mFormat	Landroid/media/MediaFormat;
    //   8: aload_0
    //   9: iload_2
    //   10: putfield 82	com/tencent/av/mediacodec/AndroidCodec:mCodecType	I
    //   13: iload_2
    //   14: getstatic 58	com/tencent/av/mediacodec/AndroidCodec:DEC_CODEC	I
    //   17: if_icmpne +90 -> 107
    //   20: aload_0
    //   21: aload_0
    //   22: getfield 486	com/tencent/av/mediacodec/AndroidCodec:mFormat	Landroid/media/MediaFormat;
    //   25: ldc_w 488
    //   28: invokevirtual 492	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   31: invokestatic 496	android/media/MediaCodec:createDecoderByType	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   34: putfield 396	com/tencent/av/mediacodec/AndroidCodec:mMediaCodec	Landroid/media/MediaCodec;
    //   37: aload_0
    //   38: getfield 396	com/tencent/av/mediacodec/AndroidCodec:mMediaCodec	Landroid/media/MediaCodec;
    //   41: ifnull +41 -> 82
    //   44: iconst_0
    //   45: istore 4
    //   47: iload_2
    //   48: getstatic 56	com/tencent/av/mediacodec/AndroidCodec:ENC_CODEC	I
    //   51: if_icmpne +6 -> 57
    //   54: iconst_1
    //   55: istore 4
    //   57: aload_0
    //   58: aload_0
    //   59: getfield 396	com/tencent/av/mediacodec/AndroidCodec:mMediaCodec	Landroid/media/MediaCodec;
    //   62: aload_3
    //   63: invokevirtual 500	com/tencent/av/mediacodec/AndroidCodec:setMediaCodecCallback	(Landroid/media/MediaCodec;Lcom/tencent/av/mediacodec/IMediaCodecCallback;)Z
    //   66: pop
    //   67: aload_0
    //   68: getfield 396	com/tencent/av/mediacodec/AndroidCodec:mMediaCodec	Landroid/media/MediaCodec;
    //   71: aload_0
    //   72: getfield 486	com/tencent/av/mediacodec/AndroidCodec:mFormat	Landroid/media/MediaFormat;
    //   75: aconst_null
    //   76: aconst_null
    //   77: iload 4
    //   79: invokevirtual 504	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   82: aload_0
    //   83: getfield 396	com/tencent/av/mediacodec/AndroidCodec:mMediaCodec	Landroid/media/MediaCodec;
    //   86: ifnull +6 -> 92
    //   89: iconst_1
    //   90: istore 5
    //   92: iload 5
    //   94: ireturn
    //   95: astore_1
    //   96: ldc 33
    //   98: ldc_w 506
    //   101: aload_1
    //   102: invokestatic 279	com/tencent/qav/log/AVLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   105: iconst_0
    //   106: ireturn
    //   107: aload_0
    //   108: aload_0
    //   109: getfield 486	com/tencent/av/mediacodec/AndroidCodec:mFormat	Landroid/media/MediaFormat;
    //   112: ldc_w 488
    //   115: invokevirtual 492	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   118: invokestatic 509	android/media/MediaCodec:createEncoderByType	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   121: putfield 396	com/tencent/av/mediacodec/AndroidCodec:mMediaCodec	Landroid/media/MediaCodec;
    //   124: goto -87 -> 37
    //   127: astore_1
    //   128: ldc 33
    //   130: ldc_w 506
    //   133: aload_1
    //   134: invokestatic 279	com/tencent/qav/log/AVLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   137: iconst_0
    //   138: ireturn
    //   139: astore_1
    //   140: ldc 33
    //   142: ldc_w 506
    //   145: aload_1
    //   146: invokestatic 279	com/tencent/qav/log/AVLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   149: iconst_0
    //   150: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	this	AndroidCodec
    //   0	151	1	paramMediaFormat	MediaFormat
    //   0	151	2	paramInt	int
    //   0	151	3	paramIMediaCodecCallback	IMediaCodecCallback
    //   45	33	4	i	int
    //   1	92	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   20	37	95	java/lang/Exception
    //   107	124	127	java/lang/Exception
    //   37	44	139	java/lang/Exception
    //   47	54	139	java/lang/Exception
    //   57	82	139	java/lang/Exception
  }
  
  /* Error */
  public boolean init(MediaFormat paramMediaFormat, String paramString, android.view.Surface paramSurface, IMediaCodecCallback paramIMediaCodecCallback)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 7
    //   3: aload_0
    //   4: aload_1
    //   5: putfield 486	com/tencent/av/mediacodec/AndroidCodec:mFormat	Landroid/media/MediaFormat;
    //   8: aload_0
    //   9: aload_2
    //   10: invokestatic 513	android/media/MediaCodec:createByCodecName	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   13: putfield 396	com/tencent/av/mediacodec/AndroidCodec:mMediaCodec	Landroid/media/MediaCodec;
    //   16: iconst_0
    //   17: istore 6
    //   19: aload_2
    //   20: invokestatic 515	com/tencent/av/mediacodec/AndroidCodec:getCodecInfo	(Ljava/lang/String;)Landroid/media/MediaCodecInfo;
    //   23: astore_1
    //   24: iload 6
    //   26: istore 5
    //   28: aload_1
    //   29: ifnull +24 -> 53
    //   32: iload 6
    //   34: istore 5
    //   36: aload_1
    //   37: invokevirtual 306	android/media/MediaCodecInfo:isEncoder	()Z
    //   40: ifeq +13 -> 53
    //   43: iconst_1
    //   44: istore 5
    //   46: aload_0
    //   47: getstatic 56	com/tencent/av/mediacodec/AndroidCodec:ENC_CODEC	I
    //   50: putfield 82	com/tencent/av/mediacodec/AndroidCodec:mCodecType	I
    //   53: aload_0
    //   54: getfield 396	com/tencent/av/mediacodec/AndroidCodec:mMediaCodec	Landroid/media/MediaCodec;
    //   57: ifnull +29 -> 86
    //   60: aload_0
    //   61: aload_0
    //   62: getfield 396	com/tencent/av/mediacodec/AndroidCodec:mMediaCodec	Landroid/media/MediaCodec;
    //   65: aload 4
    //   67: invokevirtual 500	com/tencent/av/mediacodec/AndroidCodec:setMediaCodecCallback	(Landroid/media/MediaCodec;Lcom/tencent/av/mediacodec/IMediaCodecCallback;)Z
    //   70: pop
    //   71: aload_0
    //   72: getfield 396	com/tencent/av/mediacodec/AndroidCodec:mMediaCodec	Landroid/media/MediaCodec;
    //   75: aload_0
    //   76: getfield 486	com/tencent/av/mediacodec/AndroidCodec:mFormat	Landroid/media/MediaFormat;
    //   79: aload_3
    //   80: aconst_null
    //   81: iload 5
    //   83: invokevirtual 504	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   86: aload_0
    //   87: getfield 396	com/tencent/av/mediacodec/AndroidCodec:mMediaCodec	Landroid/media/MediaCodec;
    //   90: ifnull +6 -> 96
    //   93: iconst_1
    //   94: istore 7
    //   96: iload 7
    //   98: ireturn
    //   99: astore_1
    //   100: ldc 33
    //   102: ldc_w 506
    //   105: aload_1
    //   106: invokestatic 279	com/tencent/qav/log/AVLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   109: iconst_0
    //   110: ireturn
    //   111: astore_1
    //   112: ldc 33
    //   114: ldc_w 506
    //   117: aload_1
    //   118: invokestatic 279	com/tencent/qav/log/AVLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   121: iconst_0
    //   122: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	this	AndroidCodec
    //   0	123	1	paramMediaFormat	MediaFormat
    //   0	123	2	paramString	String
    //   0	123	3	paramSurface	android.view.Surface
    //   0	123	4	paramIMediaCodecCallback	IMediaCodecCallback
    //   26	56	5	i	int
    //   17	16	6	j	int
    //   1	96	7	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   8	16	99	java/lang/Exception
    //   53	86	111	java/lang/Exception
  }
  
  /* Error */
  public boolean init(MediaFormat paramMediaFormat, String paramString, IMediaCodecCallback paramIMediaCodecCallback)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: aload_0
    //   4: aload_1
    //   5: putfield 486	com/tencent/av/mediacodec/AndroidCodec:mFormat	Landroid/media/MediaFormat;
    //   8: iconst_0
    //   9: istore 5
    //   11: aload_2
    //   12: invokestatic 515	com/tencent/av/mediacodec/AndroidCodec:getCodecInfo	(Ljava/lang/String;)Landroid/media/MediaCodecInfo;
    //   15: astore_1
    //   16: iload 5
    //   18: istore 4
    //   20: aload_1
    //   21: ifnull +24 -> 45
    //   24: iload 5
    //   26: istore 4
    //   28: aload_1
    //   29: invokevirtual 306	android/media/MediaCodecInfo:isEncoder	()Z
    //   32: ifeq +13 -> 45
    //   35: iconst_1
    //   36: istore 4
    //   38: aload_0
    //   39: getstatic 56	com/tencent/av/mediacodec/AndroidCodec:ENC_CODEC	I
    //   42: putfield 82	com/tencent/av/mediacodec/AndroidCodec:mCodecType	I
    //   45: aload_0
    //   46: aload_2
    //   47: invokestatic 513	android/media/MediaCodec:createByCodecName	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   50: putfield 396	com/tencent/av/mediacodec/AndroidCodec:mMediaCodec	Landroid/media/MediaCodec;
    //   53: aload_0
    //   54: getfield 396	com/tencent/av/mediacodec/AndroidCodec:mMediaCodec	Landroid/media/MediaCodec;
    //   57: ifnull +28 -> 85
    //   60: aload_0
    //   61: aload_0
    //   62: getfield 396	com/tencent/av/mediacodec/AndroidCodec:mMediaCodec	Landroid/media/MediaCodec;
    //   65: aload_3
    //   66: invokevirtual 500	com/tencent/av/mediacodec/AndroidCodec:setMediaCodecCallback	(Landroid/media/MediaCodec;Lcom/tencent/av/mediacodec/IMediaCodecCallback;)Z
    //   69: pop
    //   70: aload_0
    //   71: getfield 396	com/tencent/av/mediacodec/AndroidCodec:mMediaCodec	Landroid/media/MediaCodec;
    //   74: aload_0
    //   75: getfield 486	com/tencent/av/mediacodec/AndroidCodec:mFormat	Landroid/media/MediaFormat;
    //   78: aconst_null
    //   79: aconst_null
    //   80: iload 4
    //   82: invokevirtual 504	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   85: aload_0
    //   86: getfield 396	com/tencent/av/mediacodec/AndroidCodec:mMediaCodec	Landroid/media/MediaCodec;
    //   89: ifnull +6 -> 95
    //   92: iconst_1
    //   93: istore 6
    //   95: iload 6
    //   97: ireturn
    //   98: astore_1
    //   99: ldc 33
    //   101: ldc_w 506
    //   104: aload_1
    //   105: invokestatic 279	com/tencent/qav/log/AVLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   108: iconst_0
    //   109: ireturn
    //   110: astore_1
    //   111: ldc 33
    //   113: ldc_w 506
    //   116: aload_1
    //   117: invokestatic 279	com/tencent/qav/log/AVLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   120: iconst_0
    //   121: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	this	AndroidCodec
    //   0	122	1	paramMediaFormat	MediaFormat
    //   0	122	2	paramString	String
    //   0	122	3	paramIMediaCodecCallback	IMediaCodecCallback
    //   18	63	4	i	int
    //   9	16	5	j	int
    //   1	95	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   45	53	98	java/lang/Exception
    //   53	85	110	java/lang/Exception
  }
  
  /* Error */
  public void queueInputBuffer(int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 396	com/tencent/av/mediacodec/AndroidCodec:mMediaCodec	Landroid/media/MediaCodec;
    //   6: astore 6
    //   8: aload 6
    //   10: ifnonnull +6 -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: aload_0
    //   17: getfield 396	com/tencent/av/mediacodec/AndroidCodec:mMediaCodec	Landroid/media/MediaCodec;
    //   20: iload_1
    //   21: iconst_0
    //   22: iload_2
    //   23: lload_3
    //   24: iload 5
    //   26: invokevirtual 521	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   29: goto -16 -> 13
    //   32: astore 6
    //   34: ldc 33
    //   36: ldc_w 523
    //   39: aload 6
    //   41: invokestatic 279	com/tencent/qav/log/AVLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   44: goto -31 -> 13
    //   47: astore 6
    //   49: aload_0
    //   50: monitorexit
    //   51: aload 6
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	AndroidCodec
    //   0	54	1	paramInt1	int
    //   0	54	2	paramInt2	int
    //   0	54	3	paramLong	long
    //   0	54	5	paramInt3	int
    //   6	3	6	localMediaCodec	MediaCodec
    //   32	8	6	localThrowable	Throwable
    //   47	5	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   16	29	32	java/lang/Throwable
    //   2	8	47	finally
    //   16	29	47	finally
    //   34	44	47	finally
  }
  
  public void release()
  {
    try
    {
      this.mInputBuffers = null;
      this.mOutputBuffers = null;
      if (this.mMediaCodec != null)
      {
        this.mMediaCodec.release();
        this.mMediaCodec = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public void releaseOutputBuffer(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 396	com/tencent/av/mediacodec/AndroidCodec:mMediaCodec	Landroid/media/MediaCodec;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 396	com/tencent/av/mediacodec/AndroidCodec:mMediaCodec	Landroid/media/MediaCodec;
    //   18: iload_1
    //   19: iconst_0
    //   20: invokevirtual 531	android/media/MediaCodec:releaseOutputBuffer	(IZ)V
    //   23: goto -12 -> 11
    //   26: astore_2
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_2
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	AndroidCodec
    //   0	31	1	paramInt	int
    //   6	2	2	localMediaCodec	MediaCodec
    //   26	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	26	finally
    //   14	23	26	finally
  }
  
  public boolean setMediaCodecCallback(MediaCodec paramMediaCodec, IMediaCodecCallback paramIMediaCodecCallback)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    DexClassLoader localDexClassLoader;
    Object localObject;
    if (paramIMediaCodecCallback != null)
    {
      bool1 = bool2;
      if (DeviceCheck.isSupportAsyncAPI())
      {
        localDexClassLoader = ClassLoaderUtil.getQavUtilClassLoader();
        localObject = ClassLoaderUtil.getClassInstance(localDexClassLoader, "com.tencent.av.mediacodec.MediaCodecWrapper");
        bool1 = bool2;
        if (localObject == null) {}
      }
    }
    try
    {
      Object[] arrayOfObject = new Object[1];
      bool1 = ClassLoaderUtil.invokeMethodInDexWithException(localDexClassLoader, localObject, "setCallback", new Class[] { MediaCodec.class, IMediaCodecCallback.class }, new Object[] { paramMediaCodec, paramIMediaCodecCallback }, arrayOfObject);
      return bool1;
    }
    catch (Exception paramMediaCodec)
    {
      AVLog.e("AndroidCodec", "setMediaCodecCallback fail.", paramMediaCodec);
    }
    return false;
  }
  
  public void setParameters(Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT < 19) {}
    while ((this.mMediaCodec == null) || (fsetParameters19 == null)) {
      return;
    }
    try
    {
      fsetParameters19.invoke(this.mMediaCodec, new Object[] { paramBundle });
      return;
    }
    catch (Throwable paramBundle)
    {
      AVLog.e("AndroidCodec", "setParameters fail.", paramBundle);
    }
  }
  
  public boolean start()
  {
    boolean bool = false;
    try
    {
      if (this.mMediaCodec != null)
      {
        this.mMediaCodec.start();
        if (Build.VERSION.SDK_INT <= 20) {
          try
          {
            this.mInputBuffers = this.mMediaCodec.getInputBuffers();
            this.mOutputBuffers = this.mMediaCodec.getOutputBuffers();
          }
          finally {}
        }
        bool = true;
      }
    }
    catch (Exception localException)
    {
      AVLog.e("AndroidCodec", "start fail.", localException);
      return false;
    }
    return bool;
  }
  
  public void stop()
  {
    if (this.mMediaCodec != null) {
      this.mMediaCodec.stop();
    }
  }
  
  public class BufferData
  {
    public ByteBuffer buffer;
    public MediaFormat format;
    public int index;
    public MediaCodec.BufferInfo info = new MediaCodec.BufferInfo();
    public boolean success = true;
    
    public BufferData() {}
  }
  
  public static class InputBufferData
  {
    public ByteBuffer buffer;
    public int index;
    public boolean processing = false;
    
    public InputBufferData(ByteBuffer paramByteBuffer, int paramInt)
    {
      this.buffer = paramByteBuffer;
      this.index = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.av.mediacodec.AndroidCodec
 * JD-Core Version:    0.7.0.1
 */