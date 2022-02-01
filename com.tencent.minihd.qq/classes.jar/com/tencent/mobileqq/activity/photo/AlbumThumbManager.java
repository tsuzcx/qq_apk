package com.tencent.mobileqq.activity.photo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import com.tencent.component.network.utils.BytesBufferPool;
import com.tencent.component.network.utils.BytesBufferPool.BytesBuffer;
import com.tencent.mobileqq.transfile.bitmapcreator.BitmapDecoder;
import com.tencent.qphone.base.util.QLog;
import common.qzone.component.cache.common.BlobCache;
import common.qzone.component.cache.common.BlobCache.LookupRequest;
import common.qzone.component.util.SecurityUtil;
import grx;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.ByteBuffer;

public class AlbumThumbManager
{
  private static final int jdField_a_of_type_Int = 16;
  private static final BytesBufferPool jdField_a_of_type_ComTencentComponentNetworkUtilsBytesBufferPool = new BytesBufferPool(4, 204800);
  private static AlbumThumbManager jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumThumbManager;
  private static grx jdField_a_of_type_Grx;
  private static ByteBuffer jdField_a_of_type_JavaNioByteBuffer;
  private static final int b = 100;
  private static final int c = 4;
  private static final int d = 102400;
  private static final int e = 204800;
  private static final int f = 1048576;
  private static final int g = 2500;
  private static final int h = 52428800;
  private static final int i = 1;
  Context jdField_a_of_type_AndroidContentContext;
  BlobCache jdField_a_of_type_CommonQzoneComponentCacheCommonBlobCache;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  
  private AlbumThumbManager(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    a(paramContext);
  }
  
  public static AlbumThumbManager a(Context paramContext)
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumThumbManager != null) {
      return jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumThumbManager;
    }
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumThumbManager != null)
      {
        paramContext = jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumThumbManager;
        return paramContext;
      }
    }
    finally {}
    paramContext = new AlbumThumbManager(paramContext);
    jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumThumbManager = paramContext;
    return paramContext;
  }
  
  /* Error */
  private void a(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 65	com/tencent/mobileqq/activity/photo/AlbumThumbManager:jdField_a_of_type_CommonQzoneComponentCacheCommonBlobCache	Lcommon/qzone/component/cache/common/BlobCache;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: new 67	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   21: getstatic 74	com/tencent/mobileqq/app/AppConstants:aI	Ljava/lang/String;
    //   24: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: ldc 80
    //   29: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: ldc 82
    //   34: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: astore_1
    //   41: new 88	java/io/File
    //   44: dup
    //   45: new 67	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   52: getstatic 74	com/tencent/mobileqq/app/AppConstants:aI	Ljava/lang/String;
    //   55: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: ldc 80
    //   60: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokespecial 91	java/io/File:<init>	(Ljava/lang/String;)V
    //   69: astore_2
    //   70: aload_2
    //   71: invokevirtual 95	java/io/File:exists	()Z
    //   74: ifne +8 -> 82
    //   77: aload_2
    //   78: invokevirtual 98	java/io/File:mkdirs	()Z
    //   81: pop
    //   82: aload_0
    //   83: new 100	common/qzone/component/cache/common/BlobCache
    //   86: dup
    //   87: aload_1
    //   88: sipush 2500
    //   91: ldc 25
    //   93: iconst_0
    //   94: iconst_1
    //   95: invokespecial 103	common/qzone/component/cache/common/BlobCache:<init>	(Ljava/lang/String;IIZI)V
    //   98: putfield 65	com/tencent/mobileqq/activity/photo/AlbumThumbManager:jdField_a_of_type_CommonQzoneComponentCacheCommonBlobCache	Lcommon/qzone/component/cache/common/BlobCache;
    //   101: goto -90 -> 11
    //   104: astore_1
    //   105: ldc 105
    //   107: iconst_2
    //   108: ldc 107
    //   110: aload_1
    //   111: invokestatic 112	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   114: goto -103 -> 11
    //   117: astore_1
    //   118: aload_0
    //   119: monitorexit
    //   120: aload_1
    //   121: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	this	AlbumThumbManager
    //   0	122	1	paramContext	Context
    //   69	9	2	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   41	82	104	java/lang/Exception
    //   82	101	104	java/lang/Exception
    //   2	7	117	finally
    //   14	41	117	finally
    //   41	82	117	finally
    //   82	101	117	finally
    //   105	114	117	finally
  }
  
  private boolean a(byte[] paramArrayOfByte, long paramLong, BytesBufferPool.BytesBuffer paramBytesBuffer)
  {
    if (paramArrayOfByte == null) {}
    BlobCache.LookupRequest localLookupRequest;
    do
    {
      do
      {
        return false;
        if (this.jdField_a_of_type_CommonQzoneComponentCacheCommonBlobCache != null) {
          break;
        }
        a(this.jdField_a_of_type_AndroidContentContext);
      } while (this.jdField_a_of_type_CommonQzoneComponentCacheCommonBlobCache == null);
      try
      {
        localLookupRequest = new BlobCache.LookupRequest();
        localLookupRequest.jdField_a_of_type_Long = paramLong;
        localLookupRequest.jdField_a_of_type_ArrayOfByte = paramBytesBuffer.jdField_a_of_type_ArrayOfByte;
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          if (!this.jdField_a_of_type_CommonQzoneComponentCacheCommonBlobCache.a(localLookupRequest)) {
            return false;
          }
        }
      }
      catch (IOException paramArrayOfByte)
      {
        QLog.e("AlbumThumbManager", 2, "getCacheData ioexception", paramArrayOfByte);
        return false;
      }
    } while (!a(paramArrayOfByte, localLookupRequest.jdField_a_of_type_ArrayOfByte));
    paramBytesBuffer.jdField_a_of_type_ArrayOfByte = localLookupRequest.jdField_a_of_type_ArrayOfByte;
    paramBytesBuffer.jdField_a_of_type_Int = paramArrayOfByte.length;
    paramBytesBuffer.b = (localLookupRequest.jdField_a_of_type_Int - paramBytesBuffer.jdField_a_of_type_Int);
    return true;
  }
  
  private boolean a(byte[] paramArrayOfByte, long paramLong, grx paramgrx)
  {
    if (paramArrayOfByte == null) {}
    BlobCache.LookupRequest localLookupRequest;
    do
    {
      do
      {
        return false;
        if (this.jdField_a_of_type_CommonQzoneComponentCacheCommonBlobCache != null) {
          break;
        }
        a(this.jdField_a_of_type_AndroidContentContext);
      } while (this.jdField_a_of_type_CommonQzoneComponentCacheCommonBlobCache == null);
      try
      {
        localLookupRequest = new BlobCache.LookupRequest();
        localLookupRequest.jdField_a_of_type_Long = paramLong;
        localLookupRequest.jdField_a_of_type_ArrayOfByte = paramgrx.jdField_a_of_type_ArrayOfByte;
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          if (!this.jdField_a_of_type_CommonQzoneComponentCacheCommonBlobCache.a(localLookupRequest)) {
            return false;
          }
        }
      }
      catch (IOException paramArrayOfByte)
      {
        QLog.e("AlbumThumbManager", 2, "getCacheData ioexception", paramArrayOfByte);
        return false;
      }
    } while (!a(paramArrayOfByte, localLookupRequest.jdField_a_of_type_ArrayOfByte, localLookupRequest.jdField_a_of_type_Int - 16, 16));
    paramgrx.jdField_a_of_type_ArrayOfByte = localLookupRequest.jdField_a_of_type_ArrayOfByte;
    paramgrx.jdField_a_of_type_Int = 0;
    paramgrx.b = (localLookupRequest.jdField_a_of_type_Int - 16);
    return true;
  }
  
  private static boolean a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int k = paramArrayOfByte1.length;
    if (paramArrayOfByte2.length < k) {
      return false;
    }
    int j = 0;
    for (;;)
    {
      if (j >= k) {
        break label34;
      }
      if (paramArrayOfByte1[j] != paramArrayOfByte2[j]) {
        break;
      }
      j += 1;
    }
    label34:
    return true;
  }
  
  private static boolean a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte1.length < paramInt2) {}
    while (paramArrayOfByte2.length < paramInt1 + paramInt2) {
      return false;
    }
    int j = 0;
    for (;;)
    {
      if (j >= paramInt2) {
        break label47;
      }
      if (paramArrayOfByte1[j] != paramArrayOfByte2[(paramInt1 + j)]) {
        break;
      }
      j += 1;
    }
    label47:
    return true;
  }
  
  private static byte[] a(Bitmap paramBitmap, int paramInt)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(65536);
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, paramInt, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
  
  public Bitmap a(URL arg1, BitmapDecoder paramBitmapDecoder)
  {
    try
    {
      if (jdField_a_of_type_Grx == null)
      {
        jdField_a_of_type_Grx = new grx(102400, null);
        jdField_a_of_type_JavaNioByteBuffer = ByteBuffer.wrap(jdField_a_of_type_Grx.jdField_a_of_type_ArrayOfByte);
      }
      jdField_a_of_type_JavaNioByteBuffer.clear();
      byte[] arrayOfByte = SecurityUtil.a(???.toString());
      if (arrayOfByte.length < 16) {
        arrayOfByte = a(arrayOfByte, 16);
      }
      for (;;)
      {
        long l = SecurityUtil.a(arrayOfByte);
        for (;;)
        {
          try
          {
            if (a(arrayOfByte, l, jdField_a_of_type_Grx)) {
              continue;
            }
            paramBitmapDecoder = paramBitmapDecoder.a(???);
            if (paramBitmapDecoder == null) {
              continue;
            }
            ??? = paramBitmapDecoder;
            if (paramBitmapDecoder.getConfig() == Bitmap.Config.RGB_565)
            {
              ??? = paramBitmapDecoder;
              if (jdField_a_of_type_JavaNioByteBuffer.remaining() >= paramBitmapDecoder.getHeight() * paramBitmapDecoder.getRowBytes() + 16 + 8)
              {
                paramBitmapDecoder.copyPixelsToBuffer(jdField_a_of_type_JavaNioByteBuffer);
                jdField_a_of_type_JavaNioByteBuffer.putInt(paramBitmapDecoder.getWidth());
                jdField_a_of_type_JavaNioByteBuffer.putInt(paramBitmapDecoder.getHeight());
                jdField_a_of_type_JavaNioByteBuffer.put(arrayOfByte, 0, 16);
              }
            }
          }
          catch (Throwable ???)
          {
            QLog.e("AlbumThumbManager", 2, "decode thumb", ???);
            ??? = null;
            continue;
            jdField_a_of_type_JavaNioByteBuffer.clear();
            jdField_a_of_type_JavaNioByteBuffer.put(jdField_a_of_type_Grx.jdField_a_of_type_ArrayOfByte, 0, jdField_a_of_type_Grx.b);
            int j = jdField_a_of_type_JavaNioByteBuffer.getInt(jdField_a_of_type_Grx.b - 8);
            int k = jdField_a_of_type_JavaNioByteBuffer.getInt(jdField_a_of_type_Grx.b - 4);
            if ((j <= 500) || (k <= 500)) {
              continue;
            }
            QLog.e("AlbumThumbManager", 2, "thumb bitmap is dirty:" + ???.toString());
            ??? = null;
            continue;
            ??? = Bitmap.createBitmap(j, k, Bitmap.Config.RGB_565);
            jdField_a_of_type_JavaNioByteBuffer.limit(jdField_a_of_type_Grx.b - 8);
            jdField_a_of_type_JavaNioByteBuffer.position(0);
            ???.copyPixelsFromBuffer(jdField_a_of_type_JavaNioByteBuffer);
            continue;
          }
          synchronized (this.jdField_a_of_type_JavaLangObject)
          {
            try
            {
              j = paramBitmapDecoder.getRowBytes();
              k = paramBitmapDecoder.getHeight();
              this.jdField_a_of_type_CommonQzoneComponentCacheCommonBlobCache.a(l, jdField_a_of_type_JavaNioByteBuffer.array(), j * k + 24);
              ??? = paramBitmapDecoder;
              return ???;
            }
            catch (IOException localIOException)
            {
              if (QLog.isColorLevel()) {
                QLog.e("AlbumThumbManager", 2, "decode thumb ioexception", localIOException);
              }
            }
          }
        }
      }
    }
    finally {}
  }
  
  public void a()
  {
    try
    {
      jdField_a_of_type_ComTencentComponentNetworkUtilsBytesBufferPool.a();
      jdField_a_of_type_Grx = null;
      jdField_a_of_type_JavaNioByteBuffer = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    paramInt = 0;
    while (paramInt < paramArrayOfByte.length)
    {
      arrayOfByte[paramInt] = paramArrayOfByte[paramInt];
      paramInt += 1;
    }
    return arrayOfByte;
  }
  
  /* Error */
  public Bitmap b(URL paramURL, BitmapDecoder paramBitmapDecoder)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 195	java/net/URL:toString	()Ljava/lang/String;
    //   4: invokestatic 200	common/qzone/component/util/SecurityUtil:a	(Ljava/lang/String;)[B
    //   7: astore 6
    //   9: getstatic 40	com/tencent/mobileqq/activity/photo/AlbumThumbManager:jdField_a_of_type_ComTencentComponentNetworkUtilsBytesBufferPool	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   12: invokevirtual 289	com/tencent/component/network/utils/BytesBufferPool:a	()Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;
    //   15: astore 5
    //   17: aload 6
    //   19: invokestatic 206	common/qzone/component/util/SecurityUtil:a	([B)J
    //   22: lstore_3
    //   23: aload_0
    //   24: aload 6
    //   26: lload_3
    //   27: aload 5
    //   29: invokespecial 291	com/tencent/mobileqq/activity/photo/AlbumThumbManager:a	([BJLcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;)Z
    //   32: ifne +123 -> 155
    //   35: aload_2
    //   36: aload_1
    //   37: invokeinterface 213 2 0
    //   42: astore_1
    //   43: aload_1
    //   44: ifnull +161 -> 205
    //   47: aload_1
    //   48: bipush 100
    //   50: invokestatic 293	com/tencent/mobileqq/activity/photo/AlbumThumbManager:a	(Landroid/graphics/Bitmap;I)[B
    //   53: astore 7
    //   55: aload 6
    //   57: arraylength
    //   58: aload 7
    //   60: arraylength
    //   61: iadd
    //   62: invokestatic 296	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   65: astore_2
    //   66: aload_2
    //   67: aload 6
    //   69: invokevirtual 298	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   72: pop
    //   73: aload_2
    //   74: aload 7
    //   76: invokevirtual 298	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   79: pop
    //   80: aload_0
    //   81: getfield 46	com/tencent/mobileqq/activity/photo/AlbumThumbManager:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   84: astore 6
    //   86: aload 6
    //   88: monitorenter
    //   89: aload_0
    //   90: getfield 65	com/tencent/mobileqq/activity/photo/AlbumThumbManager:jdField_a_of_type_CommonQzoneComponentCacheCommonBlobCache	Lcommon/qzone/component/cache/common/BlobCache;
    //   93: lload_3
    //   94: aload_2
    //   95: invokevirtual 251	java/nio/ByteBuffer:array	()[B
    //   98: invokevirtual 301	common/qzone/component/cache/common/BlobCache:a	(J[B)V
    //   101: aload 6
    //   103: monitorexit
    //   104: getstatic 40	com/tencent/mobileqq/activity/photo/AlbumThumbManager:jdField_a_of_type_ComTencentComponentNetworkUtilsBytesBufferPool	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   107: aload 5
    //   109: invokevirtual 304	com/tencent/component/network/utils/BytesBufferPool:a	(Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;)V
    //   112: aload_1
    //   113: areturn
    //   114: astore_2
    //   115: ldc 105
    //   117: iconst_2
    //   118: ldc_w 259
    //   121: aload_2
    //   122: invokestatic 112	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   125: goto -24 -> 101
    //   128: astore_1
    //   129: aload 6
    //   131: monitorexit
    //   132: aload_1
    //   133: athrow
    //   134: astore_1
    //   135: ldc 105
    //   137: iconst_2
    //   138: ldc_w 261
    //   141: aload_1
    //   142: invokestatic 112	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   145: getstatic 40	com/tencent/mobileqq/activity/photo/AlbumThumbManager:jdField_a_of_type_ComTencentComponentNetworkUtilsBytesBufferPool	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   148: aload 5
    //   150: invokevirtual 304	com/tencent/component/network/utils/BytesBufferPool:a	(Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;)V
    //   153: aconst_null
    //   154: areturn
    //   155: new 306	android/graphics/BitmapFactory$Options
    //   158: dup
    //   159: invokespecial 307	android/graphics/BitmapFactory$Options:<init>	()V
    //   162: astore_1
    //   163: aload_1
    //   164: getstatic 223	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   167: putfield 310	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   170: aload_1
    //   171: iconst_1
    //   172: putfield 313	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   175: aload 5
    //   177: getfield 126	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer:jdField_a_of_type_ArrayOfByte	[B
    //   180: aload 5
    //   182: getfield 137	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer:jdField_a_of_type_Int	I
    //   185: aload 5
    //   187: getfield 140	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer:b	I
    //   190: aload_1
    //   191: invokestatic 319	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   194: astore_1
    //   195: getstatic 40	com/tencent/mobileqq/activity/photo/AlbumThumbManager:jdField_a_of_type_ComTencentComponentNetworkUtilsBytesBufferPool	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   198: aload 5
    //   200: invokevirtual 304	com/tencent/component/network/utils/BytesBufferPool:a	(Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;)V
    //   203: aload_1
    //   204: areturn
    //   205: getstatic 40	com/tencent/mobileqq/activity/photo/AlbumThumbManager:jdField_a_of_type_ComTencentComponentNetworkUtilsBytesBufferPool	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   208: aload 5
    //   210: invokevirtual 304	com/tencent/component/network/utils/BytesBufferPool:a	(Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;)V
    //   213: goto -60 -> 153
    //   216: astore_1
    //   217: getstatic 40	com/tencent/mobileqq/activity/photo/AlbumThumbManager:jdField_a_of_type_ComTencentComponentNetworkUtilsBytesBufferPool	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   220: aload 5
    //   222: invokevirtual 304	com/tencent/component/network/utils/BytesBufferPool:a	(Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;)V
    //   225: aload_1
    //   226: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	227	0	this	AlbumThumbManager
    //   0	227	1	paramURL	URL
    //   0	227	2	paramBitmapDecoder	BitmapDecoder
    //   22	72	3	l	long
    //   15	206	5	localBytesBuffer	BytesBufferPool.BytesBuffer
    //   53	22	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   89	101	114	java/io/IOException
    //   89	101	128	finally
    //   101	104	128	finally
    //   115	125	128	finally
    //   129	132	128	finally
    //   23	43	134	java/lang/Throwable
    //   47	89	134	java/lang/Throwable
    //   132	134	134	java/lang/Throwable
    //   155	195	134	java/lang/Throwable
    //   23	43	216	finally
    //   47	89	216	finally
    //   132	134	216	finally
    //   135	145	216	finally
    //   155	195	216	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.AlbumThumbManager
 * JD-Core Version:    0.7.0.1
 */