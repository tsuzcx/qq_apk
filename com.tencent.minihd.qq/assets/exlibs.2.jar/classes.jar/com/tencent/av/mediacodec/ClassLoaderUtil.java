package com.tencent.av.mediacodec;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.qav.QavSDK;
import com.tencent.qav.log.AVLog;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.Method;

public class ClassLoaderUtil
{
  private static final String TAG = "ClassLoaderUtil";
  private static volatile DexClassLoader sQavUtilClassLoader = null;
  
  public static Object getClassInstance(DexClassLoader paramDexClassLoader, String paramString)
  {
    if ((paramDexClassLoader != null) && (!TextUtils.isEmpty(paramString))) {
      try
      {
        paramDexClassLoader = paramDexClassLoader.loadClass(paramString).newInstance();
        return paramDexClassLoader;
      }
      catch (Exception paramDexClassLoader)
      {
        AVLog.d("ClassLoaderUtil", "getClassInstance fail.", paramDexClassLoader);
      }
    }
    return null;
  }
  
  public static DexClassLoader getDexClassLoader(Context paramContext, String paramString)
  {
    if (paramContext == null) {}
    do
    {
      return null;
      paramString = loadAssetsFile(paramContext, paramString);
    } while (TextUtils.isEmpty(paramString));
    try
    {
      paramContext = new DexClassLoader(paramString, paramContext.getDir("temp", 0).getAbsolutePath(), null, paramContext.getClassLoader());
      return paramContext;
    }
    catch (Exception paramContext)
    {
      AVLog.d("ClassLoaderUtil", "getDexClassLoader fail.", paramContext);
    }
    return null;
  }
  
  public static DexClassLoader getQavUtilClassLoader()
  {
    if (sQavUtilClassLoader == null) {}
    try
    {
      if (sQavUtilClassLoader == null) {
        sQavUtilClassLoader = getDexClassLoader(QavSDK.getInstance().getContext(), "libqav_utils.so");
      }
      return sQavUtilClassLoader;
    }
    finally {}
  }
  
  public static Object invokeMethodInDex(DexClassLoader paramDexClassLoader, Object paramObject, String paramString, Class[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    if ((paramDexClassLoader != null) && (!TextUtils.isEmpty(paramString)) && (paramObject != null)) {
      try
      {
        paramDexClassLoader = paramObject.getClass().getMethod(paramString, paramArrayOfClass);
        paramDexClassLoader.setAccessible(true);
        paramDexClassLoader = paramDexClassLoader.invoke(paramObject, paramArrayOfObject);
        return paramDexClassLoader;
      }
      catch (Exception paramDexClassLoader)
      {
        AVLog.d("ClassLoaderUtil", "invokeMethodInDex fail.", paramDexClassLoader);
      }
    }
    return null;
  }
  
  public static Object invokeMethodInDex(DexClassLoader paramDexClassLoader, String paramString1, String paramString2, Class[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    if ((paramDexClassLoader != null) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString1))) {
      try
      {
        paramString1 = paramDexClassLoader.loadClass(paramString1);
        paramDexClassLoader = paramString1.newInstance();
        paramString1 = paramString1.getMethod(paramString2, paramArrayOfClass);
        paramString1.setAccessible(true);
        paramDexClassLoader = paramString1.invoke(paramDexClassLoader, paramArrayOfObject);
        return paramDexClassLoader;
      }
      catch (Exception paramDexClassLoader)
      {
        AVLog.d("ClassLoaderUtil", "invokeMethodInDex fail.", paramDexClassLoader);
      }
    }
    return null;
  }
  
  public static boolean invokeMethodInDexWithException(DexClassLoader paramDexClassLoader, Object paramObject, String paramString, Class[] paramArrayOfClass, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
    throws Exception
  {
    if ((paramDexClassLoader != null) && (!TextUtils.isEmpty(paramString)) && (paramObject != null))
    {
      paramDexClassLoader = paramObject.getClass().getMethod(paramString, paramArrayOfClass);
      paramDexClassLoader.setAccessible(true);
      paramArrayOfObject2[0] = paramDexClassLoader.invoke(paramObject, paramArrayOfObject1);
      return true;
    }
    return false;
  }
  
  /* Error */
  private static String loadAssetsFile(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 11
    //   9: aconst_null
    //   10: astore 9
    //   12: aconst_null
    //   13: astore 7
    //   15: aconst_null
    //   16: astore 6
    //   18: aload 11
    //   20: astore_3
    //   21: aload 10
    //   23: astore 4
    //   25: aload 6
    //   27: astore 5
    //   29: aload_0
    //   30: invokevirtual 125	android/content/Context:getFilesDir	()Ljava/io/File;
    //   33: invokevirtual 68	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   36: astore 12
    //   38: aload 11
    //   40: astore_3
    //   41: aload 10
    //   43: astore 4
    //   45: aload 6
    //   47: astore 5
    //   49: new 127	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   56: aload 12
    //   58: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: getstatic 135	java/io/File:separator	Ljava/lang/String;
    //   64: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload_1
    //   68: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: astore 6
    //   76: aload 11
    //   78: astore_3
    //   79: aload 10
    //   81: astore 4
    //   83: aload 6
    //   85: astore 5
    //   87: new 64	java/io/File
    //   90: dup
    //   91: aload 6
    //   93: invokespecial 141	java/io/File:<init>	(Ljava/lang/String;)V
    //   96: astore 12
    //   98: aload 11
    //   100: astore_3
    //   101: aload 10
    //   103: astore 4
    //   105: aload 6
    //   107: astore 5
    //   109: aload 12
    //   111: invokevirtual 145	java/io/File:exists	()Z
    //   114: ifeq +20 -> 134
    //   117: aload 11
    //   119: astore_3
    //   120: aload 10
    //   122: astore 4
    //   124: aload 6
    //   126: astore 5
    //   128: aload 12
    //   130: invokevirtual 148	java/io/File:delete	()Z
    //   133: pop
    //   134: aload 11
    //   136: astore_3
    //   137: aload 10
    //   139: astore 4
    //   141: aload 6
    //   143: astore 5
    //   145: new 150	java/io/BufferedInputStream
    //   148: dup
    //   149: aload_0
    //   150: invokevirtual 154	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   153: aload_1
    //   154: invokevirtual 160	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   157: invokespecial 163	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   160: astore_0
    //   161: aload 12
    //   163: invokevirtual 166	java/io/File:createNewFile	()Z
    //   166: pop
    //   167: new 168	java/io/BufferedOutputStream
    //   170: dup
    //   171: new 170	java/io/FileOutputStream
    //   174: dup
    //   175: aload 12
    //   177: invokespecial 173	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   180: invokespecial 176	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   183: astore_1
    //   184: sipush 1024
    //   187: newarray byte
    //   189: astore_3
    //   190: aload_0
    //   191: aload_3
    //   192: iconst_0
    //   193: aload_3
    //   194: arraylength
    //   195: invokevirtual 180	java/io/BufferedInputStream:read	([BII)I
    //   198: istore_2
    //   199: iload_2
    //   200: iconst_m1
    //   201: if_icmpeq +48 -> 249
    //   204: aload_1
    //   205: aload_3
    //   206: iconst_0
    //   207: iload_2
    //   208: invokevirtual 184	java/io/BufferedOutputStream:write	([BII)V
    //   211: goto -21 -> 190
    //   214: astore 5
    //   216: aload_1
    //   217: astore_3
    //   218: aload_0
    //   219: astore 4
    //   221: ldc 8
    //   223: ldc 186
    //   225: aload 5
    //   227: invokestatic 48	com/tencent/qav/log/AVLog:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   230: aload_0
    //   231: ifnull +7 -> 238
    //   234: aload_0
    //   235: invokevirtual 189	java/io/BufferedInputStream:close	()V
    //   238: aload_1
    //   239: ifnull +7 -> 246
    //   242: aload_1
    //   243: invokevirtual 190	java/io/BufferedOutputStream:close	()V
    //   246: aload 6
    //   248: areturn
    //   249: aload_0
    //   250: ifnull +7 -> 257
    //   253: aload_0
    //   254: invokevirtual 189	java/io/BufferedInputStream:close	()V
    //   257: aload_1
    //   258: ifnull +105 -> 363
    //   261: aload_1
    //   262: invokevirtual 190	java/io/BufferedOutputStream:close	()V
    //   265: aload 6
    //   267: areturn
    //   268: astore_0
    //   269: aload 6
    //   271: areturn
    //   272: astore_0
    //   273: aload 4
    //   275: ifnull +8 -> 283
    //   278: aload 4
    //   280: invokevirtual 189	java/io/BufferedInputStream:close	()V
    //   283: aload_3
    //   284: ifnull +7 -> 291
    //   287: aload_3
    //   288: invokevirtual 190	java/io/BufferedOutputStream:close	()V
    //   291: aload_0
    //   292: athrow
    //   293: astore_0
    //   294: goto -37 -> 257
    //   297: astore_0
    //   298: goto -60 -> 238
    //   301: astore_0
    //   302: aload 6
    //   304: areturn
    //   305: astore_1
    //   306: goto -23 -> 283
    //   309: astore_1
    //   310: goto -19 -> 291
    //   313: astore_1
    //   314: aload 9
    //   316: astore_3
    //   317: aload_0
    //   318: astore 4
    //   320: aload_1
    //   321: astore_0
    //   322: goto -49 -> 273
    //   325: astore 5
    //   327: aload_1
    //   328: astore_3
    //   329: aload_0
    //   330: astore 4
    //   332: aload 5
    //   334: astore_0
    //   335: goto -62 -> 273
    //   338: astore_0
    //   339: aload 5
    //   341: astore 6
    //   343: aload_0
    //   344: astore 5
    //   346: aload 7
    //   348: astore_1
    //   349: aload 8
    //   351: astore_0
    //   352: goto -136 -> 216
    //   355: astore 5
    //   357: aload 7
    //   359: astore_1
    //   360: goto -144 -> 216
    //   363: aload 6
    //   365: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	366	0	paramContext	Context
    //   0	366	1	paramString	String
    //   198	10	2	i	int
    //   20	309	3	localObject1	Object
    //   23	308	4	localObject2	Object
    //   27	117	5	localObject3	Object
    //   214	12	5	localException1	Exception
    //   325	15	5	localObject4	Object
    //   344	1	5	localContext	Context
    //   355	1	5	localException2	Exception
    //   16	348	6	localObject5	Object
    //   13	345	7	localObject6	Object
    //   4	346	8	localObject7	Object
    //   10	305	9	localObject8	Object
    //   1	137	10	localObject9	Object
    //   7	128	11	localObject10	Object
    //   36	140	12	localObject11	Object
    // Exception table:
    //   from	to	target	type
    //   184	190	214	java/lang/Exception
    //   190	199	214	java/lang/Exception
    //   204	211	214	java/lang/Exception
    //   261	265	268	java/io/IOException
    //   29	38	272	finally
    //   49	76	272	finally
    //   87	98	272	finally
    //   109	117	272	finally
    //   128	134	272	finally
    //   145	161	272	finally
    //   221	230	272	finally
    //   253	257	293	java/io/IOException
    //   234	238	297	java/io/IOException
    //   242	246	301	java/io/IOException
    //   278	283	305	java/io/IOException
    //   287	291	309	java/io/IOException
    //   161	184	313	finally
    //   184	190	325	finally
    //   190	199	325	finally
    //   204	211	325	finally
    //   29	38	338	java/lang/Exception
    //   49	76	338	java/lang/Exception
    //   87	98	338	java/lang/Exception
    //   109	117	338	java/lang/Exception
    //   128	134	338	java/lang/Exception
    //   145	161	338	java/lang/Exception
    //   161	184	355	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.av.mediacodec.ClassLoaderUtil
 * JD-Core Version:    0.7.0.1
 */