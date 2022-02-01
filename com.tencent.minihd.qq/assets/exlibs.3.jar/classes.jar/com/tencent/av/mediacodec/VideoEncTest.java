package com.tencent.av.mediacodec;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.av.utils.ArrayUtils;
import com.tencent.qav.QavSDK;
import com.tencent.qav.log.AVLog;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.util.List;

public class VideoEncTest
  implements Runnable
{
  private static final String TAG = "VideoEncTest";
  private PlayerCallback mCallback;
  private volatile boolean mIsStopRequested;
  private int mLastErr = 1;
  private String mPlayFile;
  private int mQualityTest;
  private Thread mThread;
  private boolean mUseAsyncMode;
  
  public VideoEncTest(String paramString, boolean paramBoolean, PlayerCallback paramPlayerCallback)
  {
    this.mPlayFile = paramString;
    this.mCallback = paramPlayerCallback;
    this.mUseAsyncMode = paramBoolean;
    AndroidCodec.loadCodecLibrary();
    paramString = QavSDK.getInstance().getContext().getApplicationInfo();
    paramPlayerCallback = "PRODUCT=" + Build.PRODUCT.toLowerCase() + ";";
    paramPlayerCallback = paramPlayerCallback + "MODEL=" + Build.MODEL.toLowerCase() + ";";
    paramPlayerCallback = paramPlayerCallback + "SDK=" + Build.VERSION.SDK_INT + ";";
    paramPlayerCallback = paramPlayerCallback + "FINGERPRINT=" + Build.FINGERPRINT.toLowerCase() + ";";
    paramPlayerCallback = paramPlayerCallback + "MANUFACTURER=" + Build.MANUFACTURER.toLowerCase() + ";";
    paramPlayerCallback = paramPlayerCallback + "DATADIR=" + paramString.dataDir + ";";
    this.mQualityTest = QuaCreate(paramPlayerCallback + "LIBDIR=" + paramString.nativeLibraryDir + ";");
  }
  
  public static native void QuaClose(int paramInt);
  
  public static native int QuaCreate(String paramString);
  
  public static native int Quacaculatessim(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  static void ccvt_i420_nv12(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4)
  {
    int k = paramInt1 / 2;
    int m = paramInt2 / 2;
    System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte3, 0, paramInt1 * paramInt2);
    int i = 0;
    int j;
    while (i < m)
    {
      j = 0;
      while (j < k)
      {
        paramArrayOfByte3[(paramInt1 * paramInt2 + i * paramInt1 + j * 2)] = paramArrayOfByte1[(paramInt1 * paramInt2 + i * k + j)];
        paramArrayOfByte3[(paramInt1 * paramInt2 + i * paramInt1 + j * 2 + 1)] = paramArrayOfByte1[(paramInt1 * paramInt2 * 5 / 4 + i * k + j)];
        j += 1;
      }
      i += 1;
    }
    System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte4, 0, paramInt1 * paramInt2);
    i = 0;
    while (i < m)
    {
      j = 0;
      while (j < k)
      {
        paramArrayOfByte4[(paramInt1 * paramInt2 + i * paramInt1 + j * 2)] = paramArrayOfByte2[(paramInt1 * paramInt2 + i * k + j)];
        paramArrayOfByte4[(paramInt1 * paramInt2 + i * paramInt1 + j * 2 + 1)] = paramArrayOfByte2[(paramInt1 * paramInt2 * 5 / 4 + i * k + j)];
        j += 1;
      }
      i += 1;
    }
  }
  
  static byte[] getNextNALUnit(ByteBuffer paramByteBuffer, boolean paramBoolean)
  {
    if (paramByteBuffer == null) {}
    int m;
    do
    {
      do
      {
        return null;
        m = paramByteBuffer.remaining();
      } while (m <= 0);
      i = 0;
      while ((i < m) && (paramByteBuffer.get(i) == 0)) {
        i += 1;
      }
    } while ((i == m) || (i < 2) || (paramByteBuffer.get(i) != 1));
    int k = i + 1;
    int i = k;
    int j;
    for (;;)
    {
      j = i;
      if ((j < m) && (paramByteBuffer.get(j) != 1))
      {
        i = j + 1;
      }
      else
      {
        if (j == m)
        {
          if (!paramBoolean) {
            break;
          }
          i = m + 2;
        }
        do
        {
          j = i - 2;
          while (paramByteBuffer.get(j - 1) == 0) {
            j -= 1;
          }
          if (paramByteBuffer.get(j - 1) != 0) {
            break;
          }
          i = j;
        } while (paramByteBuffer.get(j - 2) == 0);
        i = j + 1;
      }
    }
    j -= k;
    byte[] arrayOfByte = new byte[j];
    paramByteBuffer.position(k);
    paramByteBuffer.get(arrayOfByte, 0, j);
    if (i + 2 < m)
    {
      paramByteBuffer.position(i - 2);
      return arrayOfByte;
    }
    paramByteBuffer.position(paramByteBuffer.limit());
    return arrayOfByte;
  }
  
  public static boolean isIDR(ByteBuffer paramByteBuffer)
  {
    boolean bool2 = false;
    byte[] arrayOfByte;
    do
    {
      arrayOfByte = getNextNALUnit(paramByteBuffer, true);
      bool1 = bool2;
      if (arrayOfByte == null) {
        break;
      }
    } while ((arrayOfByte[0] & 0x1F) != 5);
    boolean bool1 = true;
    return bool1;
  }
  
  /* Error */
  public static int readInputStreamToEncbuf(java.io.InputStream paramInputStream, int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: iconst_0
    //   5: ireturn
    //   6: aload_0
    //   7: aload_2
    //   8: iconst_0
    //   9: iload_1
    //   10: invokevirtual 180	java/io/InputStream:read	([BII)I
    //   13: iconst_m1
    //   14: if_icmpeq +38 -> 52
    //   17: getstatic 184	java/lang/System:out	Ljava/io/PrintStream;
    //   20: aload_2
    //   21: iconst_0
    //   22: iload_1
    //   23: invokevirtual 190	java/io/PrintStream:write	([BII)V
    //   26: aload_0
    //   27: aload_3
    //   28: iconst_0
    //   29: iload_1
    //   30: invokevirtual 180	java/io/InputStream:read	([BII)I
    //   33: iconst_m1
    //   34: if_icmpeq +27 -> 61
    //   37: getstatic 184	java/lang/System:out	Ljava/io/PrintStream;
    //   40: aload_3
    //   41: iconst_0
    //   42: iload_1
    //   43: invokevirtual 190	java/io/PrintStream:write	([BII)V
    //   46: aload_0
    //   47: invokevirtual 193	java/io/InputStream:close	()V
    //   50: iconst_1
    //   51: ireturn
    //   52: aload_0
    //   53: invokevirtual 193	java/io/InputStream:close	()V
    //   56: iconst_0
    //   57: ireturn
    //   58: astore_0
    //   59: iconst_0
    //   60: ireturn
    //   61: aload_0
    //   62: invokevirtual 193	java/io/InputStream:close	()V
    //   65: iconst_0
    //   66: ireturn
    //   67: astore_0
    //   68: iconst_0
    //   69: ireturn
    //   70: astore_2
    //   71: ldc 16
    //   73: ldc 195
    //   75: aload_2
    //   76: invokestatic 201	com/tencent/qav/log/AVLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   79: aload_0
    //   80: invokevirtual 193	java/io/InputStream:close	()V
    //   83: iconst_0
    //   84: ireturn
    //   85: astore_0
    //   86: iconst_0
    //   87: ireturn
    //   88: astore_2
    //   89: aload_0
    //   90: invokevirtual 193	java/io/InputStream:close	()V
    //   93: aload_2
    //   94: athrow
    //   95: astore_0
    //   96: goto -46 -> 50
    //   99: astore_0
    //   100: goto -7 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	paramInputStream	java.io.InputStream
    //   0	103	1	paramInt	int
    //   0	103	2	paramArrayOfByte1	byte[]
    //   0	103	3	paramArrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   52	56	58	java/io/IOException
    //   61	65	67	java/io/IOException
    //   6	46	70	java/lang/Exception
    //   79	83	85	java/io/IOException
    //   6	46	88	finally
    //   71	79	88	finally
    //   46	50	95	java/io/IOException
    //   89	93	99	java/io/IOException
  }
  
  public int getLastErr()
  {
    return this.mLastErr;
  }
  
  public int getTestResult()
  {
    return getLastErr();
  }
  
  public void play()
  {
    if ((this.mThread == null) || (!this.mThread.isAlive()))
    {
      this.mThread = new Thread(this, "VideoEncTest");
      this.mThread.start();
    }
  }
  
  public void run()
  {
    Object localObject1 = "";
    int k = 0;
    int i3 = 0;
    int i4 = -1;
    int i6 = -1;
    Object localObject6 = AndroidCodec.AVC_CODEC_MIME;
    int m = 0;
    Object localObject5 = AndroidCodec.getEncoderInfos((String)localObject6);
    int i = 0;
    Object localObject4 = localObject1;
    int n = k;
    int j = m;
    if (i < ((List)localObject5).size())
    {
      localObject4 = (MediaCodecInfo)((List)localObject5).get(i);
      localObject7 = AndroidCodec.getCodecCapabilities((MediaCodecInfo)localObject4, (String)localObject6);
      if (localObject7 == null) {}
      do
      {
        i += 1;
        break;
        localObject4 = ((MediaCodecInfo)localObject4).getName();
        localObject1 = localObject4;
      } while ("OMX.IMG.TOPAZ.VIDEO.Encoder".equals(localObject4));
      if (!ArrayUtils.contains(((MediaCodecInfo.CodecCapabilities)localObject7).colorFormats, 21)) {
        break label210;
      }
      n = 21;
    }
    for (j = i;; j = i)
    {
      AVLog.w("VideoEncTest", "run, useAsyncMode[" + this.mUseAsyncMode + "], colorFormat[" + n + "], selectedIndex[" + j + "]");
      if ((n == 19) || (n == 21)) {
        break label236;
      }
      setLastErr(-1, (String)localObject4, n, 0, 0, -1, -1);
      return;
      label210:
      localObject1 = localObject4;
      if (!ArrayUtils.contains(((MediaCodecInfo.CodecCapabilities)localObject7).colorFormats, 19)) {
        break;
      }
      n = 19;
    }
    label236:
    int i8 = 200;
    Object localObject7 = new AndroidCodec();
    localObject1 = MediaFormat.createVideoFormat((String)localObject6, 320, 240);
    ((MediaFormat)localObject1).setInteger("color-format", n);
    ((MediaFormat)localObject1).setInteger("frame-rate", 10);
    ((MediaFormat)localObject1).setInteger("bitrate", 204800);
    ((MediaFormat)localObject1).setInteger("i-frame-interval", 300);
    localObject4 = AndroidCodec.getCodecCapabilities((MediaCodecInfo)((List)localObject5).get(j), (String)localObject6);
    if (localObject4 != null)
    {
      i = 16;
      m = 0;
      if (m < ((MediaCodecInfo.CodecCapabilities)localObject4).profileLevels.length)
      {
        switch (localObject4.profileLevels[m].profile)
        {
        }
        for (;;)
        {
          m += 1;
          break;
          ((MediaFormat)localObject1).setInteger("profile", 1);
          k = i;
          if (i < localObject4.profileLevels[m].level) {
            k = localObject4.profileLevels[m].level;
          }
          ((MediaFormat)localObject1).setInteger("level", k);
          i = k;
        }
      }
    }
    String str = ((MediaCodecInfo)((List)localObject5).get(j)).getName();
    if (!((AndroidCodec)localObject7).init((MediaFormat)localObject1, str, null))
    {
      setLastErr(-3, str, n, 0, 0, -1, -1);
      return;
    }
    int i12;
    long l2;
    int i19;
    byte[][] arrayOfByte1;
    byte[][] arrayOfByte2;
    int i1;
    int i11;
    int i9;
    long l1;
    int i2;
    int i10;
    int i7;
    int i14;
    try
    {
      bool = ((AndroidCodec)localObject7).start();
      AVLog.w("VideoEncTest", "run, fstart[" + bool + "], codecName[" + str + "]");
      if (!bool)
      {
        setLastErr(-4, str, n, 0, 0, -1, -1);
        return;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        AVLog.w("VideoEncTest", "run fail.", localException1);
        boolean bool = false;
      }
      i = 0;
      i12 = 0;
      l2 = 0L;
      i13 = 0;
      i15 = 0;
      i16 = 0;
      i19 = 230400 / 2;
      i17 = 0;
      i18 = 0;
      arrayOfByte1 = new byte[2][];
      arrayOfByte1[0] = null;
      arrayOfByte1[1] = null;
      arrayOfByte1[0] = new byte[i19];
      arrayOfByte1[1] = new byte[i19];
      try
      {
        readInputStreamToEncbuf(new FileInputStream(new File(this.mPlayFile)), i19, arrayOfByte1[0], arrayOfByte1[1]);
        if ((arrayOfByte1[0] == null) || (arrayOfByte1[1] == null))
        {
          AVLog.e("VideoEncTest", "testHWCodecIfNeed read file to byte fail.");
          return;
        }
      }
      catch (Exception localException2)
      {
        AVLog.e("VideoEncTest", "run read file to byte fail.", localException2);
        return;
      }
      arrayOfByte2 = new byte[2][];
      arrayOfByte2[0] = null;
      arrayOfByte2[1] = null;
      k = i3;
      i1 = i4;
      j = i6;
      i11 = i17;
      i9 = i8;
      m = i13;
      i5 = i;
      l1 = l2;
      i2 = i18;
      i10 = i15;
      i7 = i16;
      i14 = i12;
      if (n == 21)
      {
        arrayOfByte2[0] = new byte[i19];
        arrayOfByte2[1] = new byte[i19];
        ccvt_i420_nv12(arrayOfByte1[0], arrayOfByte1[1], 320, 240, arrayOfByte2[0], arrayOfByte2[1]);
        i14 = i12;
        i7 = i16;
        i10 = i15;
        i2 = i18;
        l1 = l2;
        i5 = i;
        m = i13;
        i9 = i8;
        i11 = i17;
        j = i6;
        i1 = i4;
        k = i3;
      }
    }
    label1165:
    label1226:
    label1270:
    Object localObject3;
    do
    {
      do
      {
        if (i14 == 0)
        {
          i = k;
          i4 = i1;
          i13 = j;
        }
        for (;;)
        {
          try
          {
            if (this.mIsStopRequested) {
              break;
            }
            i3 = m;
            i12 = i5;
            l2 = l1;
            if (i5 != 0) {
              break label1270;
            }
            i = k;
            i4 = i1;
            i13 = j;
            localBufferData = ((AndroidCodec)localObject7).getInputBuffer();
            i3 = 0;
            localObject4 = localBufferData;
            if (localBufferData == null)
            {
              localObject5 = localBufferData;
              i = k;
              i4 = i1;
              i13 = j;
            }
          }
          catch (Exception localException4)
          {
            AndroidCodec.BufferData localBufferData;
            Object localObject2;
            AVLog.e("VideoEncTest", "run fail.", localException4);
            setLastErr(-9, str, n, 0, i, i4, i13);
            continue;
          }
          try
          {
            Thread.sleep(50L);
            localObject5 = localBufferData;
            i = k;
            i4 = i1;
            i13 = j;
            localObject4 = ((AndroidCodec)localObject7).getInputBuffer();
            i = i3 + 1;
            if (localObject4 == null) {
              continue;
            }
          }
          catch (Throwable localThrowable1)
          {
            i = k;
            i4 = i1;
            i13 = j;
            AVLog.e("VideoEncTest", "run fail.", localThrowable1);
            localObject4 = localObject5;
            continue;
          }
          if (localObject4 != null) {
            break label1165;
          }
          i = k;
          i4 = i1;
          i13 = j;
          if (this.mCallback != null)
          {
            i = k;
            i4 = i1;
            i13 = j;
            if (getLastErr() == 0)
            {
              i = k;
              i4 = i1;
              i13 = j;
              this.mCallback.onResult(getTestResult(), str, n, i2, k, i1, j);
            }
          }
          try
          {
            ((AndroidCodec)localObject7).stop();
            ((AndroidCodec)localObject7).release();
            return;
          }
          catch (Exception localException3)
          {
            AVLog.e("VideoEncTest", "run fail.", localException3);
            return;
          }
          localObject2 = localObject4;
          i3 = i;
          if (i > 8)
          {
            localObject5 = localObject4;
            i = k;
            i4 = i1;
            i13 = j;
            setLastErr(-5, str, n, 0, k, i1, j);
          }
        }
        if (m >= 100) {
          break label2378;
        }
        i = k;
        i4 = i1;
        i13 = j;
        ((AndroidCodec.BufferData)localObject4).buffer.clear();
        i3 = m & 0x1;
        if (n != 21) {
          break label2352;
        }
        i = k;
        i4 = i1;
        i13 = j;
        ((AndroidCodec.BufferData)localObject4).buffer.put(arrayOfByte2[i3]);
        i = k;
        i4 = i1;
        i13 = j;
        ((AndroidCodec)localObject7).queueInputBuffer(((AndroidCodec.BufferData)localObject4).index, i19, l1 * 100000L, 0);
        l2 = l1 + 1L;
        i3 = m + 1;
        i12 = i5;
        m = i3;
        i5 = i12;
        l1 = l2;
      } while (i14 != 0);
      i = k;
      i4 = i1;
      i13 = j;
      localObject3 = ((AndroidCodec)localObject7).dequeueOutputBuffer();
      m = i3;
      i5 = i12;
      l1 = l2;
    } while (localObject3 == null);
    i = k;
    i4 = i1;
    int i13 = j;
    int i20 = ((AndroidCodec.BufferData)localObject3).info.flags;
    int i5 = j;
    if ((i20 & 0x4) != 0)
    {
      i14 = 1;
      i = k;
      i4 = i1;
      i13 = j;
      i5 = i7 * 8 * 10 / ((i10 - 50) * 1024);
    }
    m = k;
    i8 = i1;
    int i17 = i11;
    int i18 = i9;
    int i15 = i2;
    int i16 = i10;
    i6 = i7;
    localObject5 = localObject3;
    if (i14 == 0)
    {
      i = k;
      i4 = i1;
      i13 = i5;
      m = k;
      i8 = i1;
      i17 = i11;
      i18 = i9;
      i15 = i2;
      i16 = i10;
      i6 = i7;
      localObject5 = localObject3;
      if (((AndroidCodec.BufferData)localObject3).index >= 0)
      {
        i = k;
        i4 = i1;
        i13 = i5;
        m = k;
        i8 = i1;
        i17 = i11;
        i18 = i9;
        i15 = i2;
        i16 = i10;
        i6 = i7;
        localObject5 = localObject3;
        if (((AndroidCodec.BufferData)localObject3).buffer != null)
        {
          i = k;
          i4 = i1;
          i13 = i5;
          m = i7 + ((AndroidCodec.BufferData)localObject3).info.size;
          i = k;
          i4 = i1;
          i13 = i5;
          localObject5 = new byte[((AndroidCodec.BufferData)localObject3).info.size];
          i = k;
          i4 = i1;
          i13 = i5;
          ((AndroidCodec.BufferData)localObject3).buffer.limit(((AndroidCodec.BufferData)localObject3).info.size);
          i = k;
          i4 = i1;
          i13 = i5;
          ((AndroidCodec.BufferData)localObject3).buffer.position(((AndroidCodec.BufferData)localObject3).info.size);
          i = k;
          i4 = i1;
          i13 = i5;
          ((AndroidCodec.BufferData)localObject3).buffer.flip();
          i = k;
          i4 = i1;
          i13 = i5;
          ((AndroidCodec.BufferData)localObject3).buffer.get((byte[])localObject5);
          j = k;
          localObject4 = localObject5;
          i7 = m;
          if (i20 == 2)
          {
            i = k;
            i4 = i1;
            i13 = i5;
            k = Quacaculatessim(this.mQualityTest, (byte[])localObject5, arrayOfByte1[0]);
            i = k;
            i4 = i1;
            i13 = i5;
            localObject6 = ((AndroidCodec)localObject7).dequeueOutputBuffer();
            j = k;
            localObject4 = localObject5;
            i7 = m;
            localObject3 = localObject6;
            if (localObject6 != null)
            {
              j = k;
              localObject4 = localObject5;
              i7 = m;
              localObject3 = localObject6;
              if (i14 == 0)
              {
                i = k;
                i4 = i1;
                i13 = i5;
                j = k;
                localObject4 = localObject5;
                i7 = m;
                localObject3 = localObject6;
                if (((AndroidCodec.BufferData)localObject6).index >= 0)
                {
                  i = k;
                  i4 = i1;
                  i13 = i5;
                  j = k;
                  localObject4 = localObject5;
                  i7 = m;
                  localObject3 = localObject6;
                  if (((AndroidCodec.BufferData)localObject6).buffer != null)
                  {
                    i = k;
                    i4 = i1;
                    i13 = i5;
                    i7 = m + ((AndroidCodec.BufferData)localObject6).info.size;
                    i = k;
                    i4 = i1;
                    i13 = i5;
                    localObject4 = new byte[((AndroidCodec.BufferData)localObject6).info.size];
                    i = k;
                    i4 = i1;
                    i13 = i5;
                    ((AndroidCodec.BufferData)localObject6).buffer.limit(((AndroidCodec.BufferData)localObject6).info.size);
                    i = k;
                    i4 = i1;
                    i13 = i5;
                    ((AndroidCodec.BufferData)localObject6).buffer.position(((AndroidCodec.BufferData)localObject6).info.size);
                    i = k;
                    i4 = i1;
                    i13 = i5;
                    ((AndroidCodec.BufferData)localObject6).buffer.flip();
                    i = k;
                    i4 = i1;
                    i13 = i5;
                    ((AndroidCodec.BufferData)localObject6).buffer.get((byte[])localObject4);
                    localObject3 = localObject6;
                    j = k;
                  }
                }
              }
            }
          }
          m = j;
          i8 = i1;
          i17 = i11;
          i18 = i9;
          i15 = i2;
          i16 = i10;
          i6 = i7;
          localObject5 = localObject3;
          if (localObject3 != null)
          {
            k = j;
            if (i10 >= 50) {
              break label2414;
            }
            i = j;
            i4 = i1;
            i13 = i5;
            k = Quacaculatessim(this.mQualityTest, (byte[])localObject4, arrayOfByte1[i11]);
            break label2414;
          }
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        m = k;
        i8 = i1;
        i17 = j;
        i18 = i9;
        i15 = i2;
        i16 = i10;
        i6 = i7;
        localObject5 = localObject3;
        if (i10 == 50)
        {
          i = k;
          i4 = i1;
          i13 = i5;
          i8 = i7 * 8 / 1024 / 5;
          i18 = i9 + 100;
          i = k;
          i4 = i8;
          i13 = i5;
          localObject4 = new Bundle();
          i = k;
          i4 = i8;
          i13 = i5;
          ((Bundle)localObject4).putInt(AndroidCodec.ForceIFrame, 1);
          i = k;
          i4 = i8;
          i13 = i5;
          ((Bundle)localObject4).putInt("video-bitrate", i18 * 1024);
          i = k;
          i4 = i8;
          i13 = i5;
          ((AndroidCodec)localObject7).setParameters((Bundle)localObject4);
          i6 = 0;
          localObject5 = localObject3;
          i16 = i10;
          i15 = i2;
          i17 = j;
          m = k;
        }
        if (localObject5 != null)
        {
          i = m;
          i4 = i8;
          i13 = i5;
          if (((AndroidCodec.BufferData)localObject5).buffer != null)
          {
            i = m;
            i4 = i8;
            i13 = i5;
            ((AndroidCodec)localObject7).releaseOutputBuffer(((AndroidCodec.BufferData)localObject5).index);
          }
        }
        i = m;
        i4 = i8;
        i13 = i5;
        try
        {
          Thread.sleep(30L);
          k = m;
          i1 = i8;
          j = i5;
          i11 = i17;
          i9 = i18;
          m = i3;
          i5 = i12;
          l1 = l2;
          i2 = i15;
          i10 = i16;
          i7 = i6;
        }
        catch (Throwable localThrowable2)
        {
          k = m;
          i1 = i8;
          j = i5;
          i11 = i17;
          i9 = i18;
          m = i3;
          i5 = i12;
          l1 = l2;
          i2 = i15;
          i10 = i16;
          i7 = i6;
        }
      }
      break;
      label2352:
      i = k;
      i4 = i1;
      i13 = j;
      ((AndroidCodec.BufferData)localObject4).buffer.put(arrayOfByte1[i3]);
      break label1226;
      label2378:
      i = k;
      i4 = i1;
      i13 = j;
      ((AndroidCodec)localObject7).queueInputBuffer(((AndroidCodec.BufferData)localObject4).index, 0, 0L, 4);
      i12 = 1;
      i3 = m;
      l2 = l1;
      break label1270;
      label2414:
      j = i11 ^ 0x1;
      i10 += 1;
      if (i10 == 1) {
        i2 = i3;
      }
    }
  }
  
  void setLastErr(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.mLastErr = paramInt1;
    if ((paramInt1 != 0) && (this.mCallback != null)) {
      this.mCallback.onResult(paramInt1, paramString, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    }
  }
  
  public void stop()
  {
    this.mIsStopRequested = true;
    QuaClose(this.mQualityTest);
  }
  
  public static abstract interface ErrorFlag
  {
    public static final int code_1 = -1;
    public static final int suc = 1;
  }
  
  public static abstract interface PlayerCallback
  {
    public abstract void onResult(int paramInt1, String paramString, int paramInt2, long paramLong, int paramInt3, int paramInt4, int paramInt5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.av.mediacodec.VideoEncTest
 * JD-Core Version:    0.7.0.1
 */