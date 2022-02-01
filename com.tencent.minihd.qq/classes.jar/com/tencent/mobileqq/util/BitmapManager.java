package com.tencent.mobileqq.util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.os.Build;
import android.util.Pair;
import java.io.InputStream;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kph;

public class BitmapManager
{
  public static final String a = "BitmapManager";
  private static ReferenceQueue jdField_a_of_type_JavaLangRefReferenceQueue = new ReferenceQueue();
  private static Map jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new HashMap());
  
  public static int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int j = paramOptions.outHeight;
    int k = paramOptions.outWidth;
    int i = 1;
    if ((j > paramInt2) || (k > paramInt1))
    {
      if (k > j) {
        i = Math.round(j / paramInt2);
      }
    }
    else {
      return i;
    }
    return Math.round(k / paramInt1);
  }
  
  public static Bitmap a(Resources paramResources, int paramInt)
  {
    a();
    localBitmapDecodeResult = new BitmapManager.BitmapDecodeResult();
    for (;;)
    {
      try
      {
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        if ((!"Xiaomi".equalsIgnoreCase(Build.MANUFACTURER)) || (!Build.MODEL.toUpperCase().startsWith("MI 2"))) {
          continue;
        }
        localObject = Bitmap.Config.ARGB_8888;
        localOptions.inPreferredConfig = ((Bitmap.Config)localObject);
        localBitmapDecodeResult.a = BitmapFactory.decodeResource(paramResources, paramInt, localOptions);
      }
      catch (OutOfMemoryError paramResources)
      {
        Object localObject;
        localBitmapDecodeResult.e = 1;
        continue;
      }
      catch (Throwable paramResources)
      {
        localBitmapDecodeResult.e = 3;
        continue;
      }
      if (localBitmapDecodeResult.a != null)
      {
        localBitmapDecodeResult.e = 0;
        paramResources = String.valueOf(localBitmapDecodeResult.a.hashCode());
        localObject = new kph(paramResources, localBitmapDecodeResult.a, jdField_a_of_type_JavaLangRefReferenceQueue);
        jdField_a_of_type_JavaUtilMap.put(paramResources, localObject);
      }
      return localBitmapDecodeResult.a;
      localObject = Bitmap.Config.RGB_565;
    }
  }
  
  public static Bitmap a(Resources paramResources, int paramInt1, int paramInt2, int paramInt3)
  {
    a();
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    BitmapFactory.decodeResource(paramResources, paramInt1, (BitmapFactory.Options)localObject);
    ((BitmapFactory.Options)localObject).inSampleSize = a((BitmapFactory.Options)localObject, paramInt2, paramInt3);
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
    paramResources = BitmapFactory.decodeResource(paramResources, paramInt1, (BitmapFactory.Options)localObject);
    if (paramResources != null)
    {
      localObject = String.valueOf(paramResources.hashCode());
      kph localkph = new kph((String)localObject, paramResources, jdField_a_of_type_JavaLangRefReferenceQueue);
      jdField_a_of_type_JavaUtilMap.put(localObject, localkph);
    }
    return paramResources;
  }
  
  public static Bitmap a(InputStream paramInputStream)
  {
    a();
    localBitmapDecodeResult = new BitmapManager.BitmapDecodeResult();
    for (;;)
    {
      try
      {
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        if ((!"Xiaomi".equalsIgnoreCase(Build.MANUFACTURER)) || (!Build.MODEL.toUpperCase().startsWith("MI 2"))) {
          continue;
        }
        localObject = Bitmap.Config.ARGB_8888;
        localOptions.inPreferredConfig = ((Bitmap.Config)localObject);
        localBitmapDecodeResult.a = BitmapFactory.decodeStream(paramInputStream, null, localOptions);
      }
      catch (OutOfMemoryError paramInputStream)
      {
        Object localObject;
        localBitmapDecodeResult.e = 1;
        continue;
      }
      catch (Throwable paramInputStream)
      {
        localBitmapDecodeResult.e = 3;
        continue;
      }
      if (localBitmapDecodeResult.a != null)
      {
        localBitmapDecodeResult.e = 0;
        paramInputStream = String.valueOf(localBitmapDecodeResult.a.hashCode());
        localObject = new kph(paramInputStream, localBitmapDecodeResult.a, jdField_a_of_type_JavaLangRefReferenceQueue);
        jdField_a_of_type_JavaUtilMap.put(paramInputStream, localObject);
      }
      return localBitmapDecodeResult.a;
      localObject = Bitmap.Config.RGB_565;
    }
  }
  
  public static Bitmap a(InputStream paramInputStream, Rect paramRect, int paramInt1, int paramInt2)
  {
    a();
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    BitmapFactory.decodeStream(paramInputStream, paramRect, (BitmapFactory.Options)localObject);
    ((BitmapFactory.Options)localObject).inSampleSize = a((BitmapFactory.Options)localObject, paramInt1, paramInt2);
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
    paramInputStream = BitmapFactory.decodeStream(paramInputStream, paramRect, (BitmapFactory.Options)localObject);
    if (paramInputStream != null)
    {
      paramRect = String.valueOf(paramInputStream.hashCode());
      localObject = new kph(paramRect, paramInputStream, jdField_a_of_type_JavaLangRefReferenceQueue);
      jdField_a_of_type_JavaUtilMap.put(paramRect, localObject);
    }
    return paramInputStream;
  }
  
  public static Bitmap a(String paramString)
  {
    return a(paramString, null);
  }
  
  public static Bitmap a(String paramString, int paramInt1, int paramInt2)
  {
    a();
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
    ((BitmapFactory.Options)localObject).inSampleSize = a((BitmapFactory.Options)localObject, paramInt1, paramInt2);
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
    paramString = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
    if (paramString != null)
    {
      localObject = String.valueOf(paramString.hashCode());
      kph localkph = new kph((String)localObject, paramString, jdField_a_of_type_JavaLangRefReferenceQueue);
      jdField_a_of_type_JavaUtilMap.put(localObject, localkph);
    }
    return paramString;
  }
  
  public static Bitmap a(String paramString, BitmapFactory.Options paramOptions)
  {
    return a(paramString, paramOptions, false);
  }
  
  public static Bitmap a(String paramString, BitmapFactory.Options paramOptions, boolean paramBoolean)
  {
    BitmapManager.BitmapDecodeResult localBitmapDecodeResult = new BitmapManager.BitmapDecodeResult();
    a(paramString, paramOptions, localBitmapDecodeResult, paramBoolean);
    return localBitmapDecodeResult.a;
  }
  
  public static Bitmap a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    a();
    localBitmapDecodeResult = new BitmapManager.BitmapDecodeResult();
    for (;;)
    {
      try
      {
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        if ((!"Xiaomi".equalsIgnoreCase(Build.MANUFACTURER)) || (!Build.MODEL.toUpperCase().startsWith("MI 2"))) {
          continue;
        }
        localObject = Bitmap.Config.ARGB_8888;
        localOptions.inPreferredConfig = ((Bitmap.Config)localObject);
        localBitmapDecodeResult.a = BitmapFactory.decodeByteArray(paramArrayOfByte, paramInt1, paramInt2, localOptions);
      }
      catch (OutOfMemoryError paramArrayOfByte)
      {
        Object localObject;
        localBitmapDecodeResult.e = 1;
        continue;
      }
      catch (Throwable paramArrayOfByte)
      {
        localBitmapDecodeResult.e = 3;
        continue;
      }
      if (localBitmapDecodeResult.a != null)
      {
        localBitmapDecodeResult.e = 0;
        paramArrayOfByte = String.valueOf(localBitmapDecodeResult.a.hashCode());
        localObject = new kph(paramArrayOfByte, localBitmapDecodeResult.a, jdField_a_of_type_JavaLangRefReferenceQueue);
        jdField_a_of_type_JavaUtilMap.put(paramArrayOfByte, localObject);
      }
      return localBitmapDecodeResult.a;
      localObject = Bitmap.Config.RGB_565;
    }
  }
  
  public static Bitmap a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a();
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    BitmapFactory.decodeByteArray(paramArrayOfByte, paramInt1, paramInt2, (BitmapFactory.Options)localObject);
    ((BitmapFactory.Options)localObject).inSampleSize = a((BitmapFactory.Options)localObject, paramInt3, paramInt4);
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
    paramArrayOfByte = BitmapFactory.decodeByteArray(paramArrayOfByte, paramInt1, paramInt2, (BitmapFactory.Options)localObject);
    if (paramArrayOfByte != null)
    {
      localObject = String.valueOf(paramArrayOfByte.hashCode());
      kph localkph = new kph((String)localObject, paramArrayOfByte, jdField_a_of_type_JavaLangRefReferenceQueue);
      jdField_a_of_type_JavaUtilMap.put(localObject, localkph);
    }
    return paramArrayOfByte;
  }
  
  public static String a()
  {
    a();
    long l = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024L;
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(String.format("heap used=%s\n", new Object[] { Long.valueOf(l) }));
    Iterator localIterator = jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    l = 0L;
    if (localIterator.hasNext())
    {
      Object localObject = (Reference)((Map.Entry)localIterator.next()).getValue();
      if (localObject == null) {
        break label201;
      }
      localObject = (Bitmap)((Reference)localObject).get();
      if (localObject == null) {
        break label201;
      }
      int i = ((Bitmap)localObject).getRowBytes();
      l += ((Bitmap)localObject).getHeight() * i;
    }
    label201:
    for (;;)
    {
      break;
      localStringBuffer.append("usedSize " + l / 1024L + "\n");
      localStringBuffer.append("images:" + jdField_a_of_type_JavaUtilMap);
      return localStringBuffer.toString();
    }
  }
  
  public static ArrayList a()
  {
    a();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Object localObject = (Reference)localEntry.getValue();
      if (localObject != null)
      {
        localObject = (Bitmap)((Reference)localObject).get();
        if (localObject != null)
        {
          int i = ((Bitmap)localObject).getRowBytes();
          long l = ((Bitmap)localObject).getHeight() * i;
          localArrayList.add(Pair.create(localEntry.getKey(), Long.valueOf(l)));
        }
      }
    }
    return localArrayList;
  }
  
  private static void a()
  {
    for (;;)
    {
      kph localkph = (kph)jdField_a_of_type_JavaLangRefReferenceQueue.poll();
      if (localkph == null) {
        break;
      }
      jdField_a_of_type_JavaUtilMap.remove(kph.a(localkph));
    }
  }
  
  public static void a(String paramString, BitmapFactory.Options paramOptions, BitmapManager.BitmapDecodeResult paramBitmapDecodeResult)
  {
    a(paramString, paramOptions, paramBitmapDecodeResult, false);
  }
  
  /* Error */
  public static void a(String paramString, BitmapFactory.Options paramOptions, BitmapManager.BitmapDecodeResult paramBitmapDecodeResult, boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 55	com/tencent/mobileqq/util/BitmapManager:a	()V
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 8
    //   9: aconst_null
    //   10: astore 7
    //   12: aconst_null
    //   13: astore 5
    //   15: new 291	java/io/File
    //   18: dup
    //   19: aload_0
    //   20: invokespecial 294	java/io/File:<init>	(Ljava/lang/String;)V
    //   23: astore 9
    //   25: aload 9
    //   27: ifnull +11 -> 38
    //   30: aload 9
    //   32: invokevirtual 297	java/io/File:exists	()Z
    //   35: ifne +21 -> 56
    //   38: aload_2
    //   39: iconst_2
    //   40: putfield 105	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:e	I
    //   43: iconst_0
    //   44: ifeq +11 -> 55
    //   47: new 299	java/lang/NullPointerException
    //   50: dup
    //   51: invokespecial 300	java/lang/NullPointerException:<init>	()V
    //   54: athrow
    //   55: return
    //   56: iload_3
    //   57: ifeq +63 -> 120
    //   60: aload_2
    //   61: aload_0
    //   62: aload_1
    //   63: invokestatic 151	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   66: putfield 102	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:a	Landroid/graphics/Bitmap;
    //   69: aload 5
    //   71: astore_1
    //   72: aload_1
    //   73: ifnull +7 -> 80
    //   76: aload_1
    //   77: invokevirtual 305	java/io/FileInputStream:close	()V
    //   80: aload_2
    //   81: getfield 102	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:a	Landroid/graphics/Bitmap;
    //   84: ifnull -29 -> 55
    //   87: aload_2
    //   88: iconst_0
    //   89: putfield 105	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:e	I
    //   92: new 115	kph
    //   95: dup
    //   96: aload_0
    //   97: aload_2
    //   98: getfield 102	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:a	Landroid/graphics/Bitmap;
    //   101: getstatic 30	com/tencent/mobileqq/util/BitmapManager:jdField_a_of_type_JavaLangRefReferenceQueue	Ljava/lang/ref/ReferenceQueue;
    //   104: invokespecial 118	kph:<init>	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/ref/ReferenceQueue;)V
    //   107: astore_1
    //   108: getstatic 25	com/tencent/mobileqq/util/BitmapManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   111: aload_0
    //   112: aload_1
    //   113: invokeinterface 124 3 0
    //   118: pop
    //   119: return
    //   120: new 302	java/io/FileInputStream
    //   123: dup
    //   124: aload 9
    //   126: invokespecial 308	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   129: astore 5
    //   131: aload 9
    //   133: invokevirtual 311	java/io/File:length	()J
    //   136: l2i
    //   137: istore 4
    //   139: iload 4
    //   141: newarray byte
    //   143: astore 6
    //   145: iload 4
    //   147: aload 5
    //   149: aload 6
    //   151: invokevirtual 315	java/io/FileInputStream:read	([B)I
    //   154: if_icmpeq +21 -> 175
    //   157: aload_2
    //   158: iconst_3
    //   159: putfield 105	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:e	I
    //   162: aload 5
    //   164: ifnull -109 -> 55
    //   167: aload 5
    //   169: invokevirtual 305	java/io/FileInputStream:close	()V
    //   172: return
    //   173: astore_0
    //   174: return
    //   175: aload_2
    //   176: aload 6
    //   178: iconst_0
    //   179: aload 6
    //   181: arraylength
    //   182: aload_1
    //   183: invokestatic 162	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   186: putfield 102	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:a	Landroid/graphics/Bitmap;
    //   189: aload 5
    //   191: astore_1
    //   192: goto -120 -> 72
    //   195: astore_1
    //   196: aload 6
    //   198: astore 5
    //   200: aload 5
    //   202: astore_1
    //   203: aload_2
    //   204: iconst_2
    //   205: putfield 105	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:e	I
    //   208: aload 5
    //   210: ifnull -130 -> 80
    //   213: aload 5
    //   215: invokevirtual 305	java/io/FileInputStream:close	()V
    //   218: goto -138 -> 80
    //   221: astore_1
    //   222: goto -142 -> 80
    //   225: astore_1
    //   226: aload 8
    //   228: astore 5
    //   230: aload 5
    //   232: astore_1
    //   233: aload_2
    //   234: iconst_1
    //   235: putfield 105	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:e	I
    //   238: aload 5
    //   240: ifnull -160 -> 80
    //   243: aload 5
    //   245: invokevirtual 305	java/io/FileInputStream:close	()V
    //   248: goto -168 -> 80
    //   251: astore_1
    //   252: goto -172 -> 80
    //   255: astore_1
    //   256: aload 7
    //   258: astore 5
    //   260: aload 5
    //   262: astore_1
    //   263: aload_2
    //   264: iconst_3
    //   265: putfield 105	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:e	I
    //   268: aload 5
    //   270: ifnull -190 -> 80
    //   273: aload 5
    //   275: invokevirtual 305	java/io/FileInputStream:close	()V
    //   278: goto -198 -> 80
    //   281: astore_1
    //   282: goto -202 -> 80
    //   285: astore_0
    //   286: aconst_null
    //   287: astore 5
    //   289: aload 5
    //   291: ifnull +8 -> 299
    //   294: aload 5
    //   296: invokevirtual 305	java/io/FileInputStream:close	()V
    //   299: aload_0
    //   300: athrow
    //   301: astore_0
    //   302: return
    //   303: astore_1
    //   304: goto -224 -> 80
    //   307: astore_1
    //   308: goto -9 -> 299
    //   311: astore_0
    //   312: goto -23 -> 289
    //   315: astore_0
    //   316: aload_1
    //   317: astore 5
    //   319: goto -30 -> 289
    //   322: astore_1
    //   323: goto -63 -> 260
    //   326: astore_1
    //   327: goto -97 -> 230
    //   330: astore_1
    //   331: goto -131 -> 200
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	334	0	paramString	String
    //   0	334	1	paramOptions	BitmapFactory.Options
    //   0	334	2	paramBitmapDecodeResult	BitmapManager.BitmapDecodeResult
    //   0	334	3	paramBoolean	boolean
    //   137	18	4	i	int
    //   13	305	5	localObject1	Object
    //   4	193	6	arrayOfByte	byte[]
    //   10	247	7	localObject2	Object
    //   7	220	8	localObject3	Object
    //   23	109	9	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   167	172	173	java/io/IOException
    //   15	25	195	java/io/FileNotFoundException
    //   30	38	195	java/io/FileNotFoundException
    //   38	43	195	java/io/FileNotFoundException
    //   60	69	195	java/io/FileNotFoundException
    //   120	131	195	java/io/FileNotFoundException
    //   213	218	221	java/io/IOException
    //   15	25	225	java/lang/OutOfMemoryError
    //   30	38	225	java/lang/OutOfMemoryError
    //   38	43	225	java/lang/OutOfMemoryError
    //   60	69	225	java/lang/OutOfMemoryError
    //   120	131	225	java/lang/OutOfMemoryError
    //   243	248	251	java/io/IOException
    //   15	25	255	java/lang/Throwable
    //   30	38	255	java/lang/Throwable
    //   38	43	255	java/lang/Throwable
    //   60	69	255	java/lang/Throwable
    //   120	131	255	java/lang/Throwable
    //   273	278	281	java/io/IOException
    //   15	25	285	finally
    //   30	38	285	finally
    //   38	43	285	finally
    //   60	69	285	finally
    //   120	131	285	finally
    //   47	55	301	java/io/IOException
    //   76	80	303	java/io/IOException
    //   294	299	307	java/io/IOException
    //   131	162	311	finally
    //   175	189	311	finally
    //   203	208	315	finally
    //   233	238	315	finally
    //   263	268	315	finally
    //   131	162	322	java/lang/Throwable
    //   175	189	322	java/lang/Throwable
    //   131	162	326	java/lang/OutOfMemoryError
    //   175	189	326	java/lang/OutOfMemoryError
    //   131	162	330	java/io/FileNotFoundException
    //   175	189	330	java/io/FileNotFoundException
  }
  
  public static Bitmap b(Resources paramResources, int paramInt)
  {
    a();
    BitmapManager.BitmapDecodeResult localBitmapDecodeResult = new BitmapManager.BitmapDecodeResult();
    try
    {
      localBitmapDecodeResult.a = BitmapFactory.decodeResource(paramResources, paramInt, new BitmapFactory.Options());
      if (localBitmapDecodeResult.a != null)
      {
        localBitmapDecodeResult.e = 0;
        paramResources = String.valueOf(localBitmapDecodeResult.a.hashCode());
        kph localkph = new kph(paramResources, localBitmapDecodeResult.a, jdField_a_of_type_JavaLangRefReferenceQueue);
        jdField_a_of_type_JavaUtilMap.put(paramResources, localkph);
      }
      return localBitmapDecodeResult.a;
    }
    catch (OutOfMemoryError paramResources)
    {
      for (;;)
      {
        localBitmapDecodeResult.e = 1;
      }
    }
    catch (Throwable paramResources)
    {
      for (;;)
      {
        localBitmapDecodeResult.e = 3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.util.BitmapManager
 * JD-Core Version:    0.7.0.1
 */