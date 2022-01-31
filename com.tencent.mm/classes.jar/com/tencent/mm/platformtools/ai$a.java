package com.tencent.mm.platformtools;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.XmlResourceParser;
import java.lang.reflect.Method;

public final class ai$a
{
  /* Error */
  public static int J(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 8
    //   6: iconst_0
    //   7: istore_3
    //   8: aload_0
    //   9: aload_1
    //   10: iconst_0
    //   11: invokevirtual 21	android/content/Context:createPackageContext	(Ljava/lang/String;I)Landroid/content/Context;
    //   14: astore 6
    //   16: aload 6
    //   18: ifnonnull +26 -> 44
    //   21: iload_3
    //   22: istore_2
    //   23: iload_2
    //   24: ireturn
    //   25: astore_1
    //   26: ldc 23
    //   28: aload_1
    //   29: ldc 25
    //   31: iconst_0
    //   32: anewarray 4	java/lang/Object
    //   35: invokestatic 31	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   38: aconst_null
    //   39: astore 6
    //   41: goto -25 -> 16
    //   44: aload 6
    //   46: invokevirtual 35	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   49: astore 10
    //   51: new 37	android/content/res/Resources
    //   54: dup
    //   55: aload 10
    //   57: aload_0
    //   58: invokevirtual 41	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   61: invokevirtual 45	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   64: aconst_null
    //   65: invokespecial 49	android/content/res/Resources:<init>	(Landroid/content/res/AssetManager;Landroid/util/DisplayMetrics;Landroid/content/res/Configuration;)V
    //   68: astore 9
    //   70: aload 8
    //   72: astore_0
    //   73: aload 7
    //   75: astore_1
    //   76: aload 6
    //   78: aload 10
    //   80: invokestatic 52	com/tencent/mm/platformtools/ai$a:a	(Landroid/content/Context;Landroid/content/res/AssetManager;)Landroid/content/res/XmlResourceParser;
    //   83: astore 6
    //   85: aload 6
    //   87: ifnonnull +19 -> 106
    //   90: iload_3
    //   91: istore_2
    //   92: aload 6
    //   94: ifnull -71 -> 23
    //   97: aload 6
    //   99: invokeinterface 58 1 0
    //   104: iconst_0
    //   105: ireturn
    //   106: aload 6
    //   108: astore_0
    //   109: aload 6
    //   111: astore_1
    //   112: aload 6
    //   114: invokeinterface 62 1 0
    //   119: istore_2
    //   120: iload_2
    //   121: iconst_1
    //   122: if_icmpeq +292 -> 414
    //   125: iload_2
    //   126: tableswitch	default:+18 -> 144, 2:+62->188
    //   145: iconst_3
    //   146: astore_1
    //   147: aload 6
    //   149: invokeinterface 65 1 0
    //   154: istore 4
    //   156: iload 4
    //   158: istore_2
    //   159: goto -39 -> 120
    //   162: astore 7
    //   164: aload 6
    //   166: astore_0
    //   167: aload 6
    //   169: astore_1
    //   170: ldc 23
    //   172: aload 7
    //   174: ldc 25
    //   176: iconst_0
    //   177: anewarray 4	java/lang/Object
    //   180: invokestatic 31	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   183: iconst_0
    //   184: istore_2
    //   185: goto -65 -> 120
    //   188: aload 6
    //   190: astore_0
    //   191: aload 6
    //   193: astore_1
    //   194: aload 6
    //   196: invokeinterface 69 1 0
    //   201: astore 7
    //   203: aload 6
    //   205: astore_0
    //   206: aload 6
    //   208: astore_1
    //   209: aload 7
    //   211: invokestatic 75	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   214: ifne -70 -> 144
    //   217: aload 6
    //   219: astore_0
    //   220: aload 6
    //   222: astore_1
    //   223: aload 7
    //   225: ldc 77
    //   227: invokevirtual 83	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   230: ifeq -86 -> 144
    //   233: aload 6
    //   235: astore_0
    //   236: aload 6
    //   238: astore_1
    //   239: aload 6
    //   241: ldc 85
    //   243: ldc 87
    //   245: invokeinterface 91 3 0
    //   250: aload 9
    //   252: invokestatic 94	com/tencent/mm/platformtools/ai$a:a	(Ljava/lang/String;Landroid/content/res/Resources;)Ljava/lang/String;
    //   255: astore 7
    //   257: aload 6
    //   259: astore_0
    //   260: aload 6
    //   262: astore_1
    //   263: aload 7
    //   265: invokestatic 75	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   268: istore 5
    //   270: iload 5
    //   272: ifeq +19 -> 291
    //   275: iload_3
    //   276: istore_2
    //   277: aload 6
    //   279: ifnull -256 -> 23
    //   282: aload 6
    //   284: invokeinterface 58 1 0
    //   289: iconst_0
    //   290: ireturn
    //   291: aload 6
    //   293: astore_0
    //   294: aload 6
    //   296: astore_1
    //   297: aload 7
    //   299: iconst_0
    //   300: invokestatic 100	com/tencent/mm/platformtools/ah:getInt	(Ljava/lang/String;I)I
    //   303: istore_2
    //   304: iload_2
    //   305: istore_3
    //   306: iload_3
    //   307: istore_2
    //   308: aload 6
    //   310: ifnull -287 -> 23
    //   313: aload 6
    //   315: invokeinterface 58 1 0
    //   320: iload_3
    //   321: ireturn
    //   322: astore 7
    //   324: aload 6
    //   326: astore_0
    //   327: aload 6
    //   329: astore_1
    //   330: ldc 23
    //   332: aload 7
    //   334: ldc 25
    //   336: iconst_0
    //   337: anewarray 4	java/lang/Object
    //   340: invokestatic 31	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   343: goto -223 -> 120
    //   346: astore 6
    //   348: aload_0
    //   349: astore_1
    //   350: ldc 23
    //   352: aload 6
    //   354: ldc 25
    //   356: iconst_0
    //   357: anewarray 4	java/lang/Object
    //   360: invokestatic 31	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   363: iload_3
    //   364: istore_2
    //   365: aload_0
    //   366: ifnull -343 -> 23
    //   369: aload_0
    //   370: invokeinterface 58 1 0
    //   375: iconst_0
    //   376: ireturn
    //   377: astore 7
    //   379: aload 6
    //   381: astore_0
    //   382: aload 6
    //   384: astore_1
    //   385: ldc 23
    //   387: aload 7
    //   389: ldc 25
    //   391: iconst_0
    //   392: anewarray 4	java/lang/Object
    //   395: invokestatic 31	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   398: goto -278 -> 120
    //   401: astore_0
    //   402: aload_1
    //   403: ifnull +9 -> 412
    //   406: aload_1
    //   407: invokeinterface 58 1 0
    //   412: aload_0
    //   413: athrow
    //   414: iload_3
    //   415: istore_2
    //   416: aload 6
    //   418: ifnull -395 -> 23
    //   421: aload 6
    //   423: invokeinterface 58 1 0
    //   428: iconst_0
    //   429: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	430	0	paramContext	Context
    //   0	430	1	paramString	String
    //   22	394	2	i	int
    //   7	408	3	j	int
    //   154	3	4	k	int
    //   268	3	5	bool	boolean
    //   14	314	6	localObject1	Object
    //   346	76	6	localIOException1	java.io.IOException
    //   1	73	7	localObject2	Object
    //   162	11	7	localXmlPullParserException1	org.xmlpull.v1.XmlPullParserException
    //   201	97	7	str	String
    //   322	11	7	localXmlPullParserException2	org.xmlpull.v1.XmlPullParserException
    //   377	11	7	localIOException2	java.io.IOException
    //   4	67	8	localObject3	Object
    //   68	183	9	localResources	Resources
    //   49	30	10	localAssetManager	AssetManager
    // Exception table:
    //   from	to	target	type
    //   8	16	25	android/content/pm/PackageManager$NameNotFoundException
    //   112	120	162	org/xmlpull/v1/XmlPullParserException
    //   147	156	322	org/xmlpull/v1/XmlPullParserException
    //   76	85	346	java/io/IOException
    //   112	120	346	java/io/IOException
    //   170	183	346	java/io/IOException
    //   194	203	346	java/io/IOException
    //   209	217	346	java/io/IOException
    //   223	233	346	java/io/IOException
    //   239	257	346	java/io/IOException
    //   263	270	346	java/io/IOException
    //   297	304	346	java/io/IOException
    //   330	343	346	java/io/IOException
    //   385	398	346	java/io/IOException
    //   147	156	377	java/io/IOException
    //   76	85	401	finally
    //   112	120	401	finally
    //   147	156	401	finally
    //   170	183	401	finally
    //   194	203	401	finally
    //   209	217	401	finally
    //   223	233	401	finally
    //   239	257	401	finally
    //   263	270	401	finally
    //   297	304	401	finally
    //   330	343	401	finally
    //   350	363	401	finally
    //   385	398	401	finally
  }
  
  private static XmlResourceParser a(Context paramContext, AssetManager paramAssetManager)
  {
    int j = 1;
    try
    {
      String str2 = (String)Context.class.getMethod("getPackageResourcePath", new Class[0]).invoke(paramContext, new Object[0]);
      Method localMethod = AssetManager.class.getMethod("getCookieName", new Class[] { Integer.TYPE });
      String str1 = str2;
      int i = j;
      if (str2 == null)
      {
        str1 = str2;
        i = j;
        if (paramContext.getPackageName().equals("android"))
        {
          str1 = "/system/framework/framework-res.apk";
          i = j;
        }
      }
      while (i < 20)
      {
        if (str1 != null) {
          if (str1.equals(localMethod.invoke(paramAssetManager, new Object[] { Integer.valueOf(i) })))
          {
            paramContext = paramAssetManager.openXmlResourceParser(i, "AndroidManifest.xml");
            return paramContext;
          }
        }
        i += 1;
      }
      return paramAssetManager.openXmlResourceParser("AndroidManifest.xml");
    }
    catch (Exception paramContext) {}
  }
  
  private static String a(String paramString, Resources paramResources)
  {
    if ((paramString == null) || (!paramString.startsWith("@"))) {
      return paramString;
    }
    try
    {
      paramResources = paramResources.getString(Integer.parseInt(paramString.substring(1)));
      return paramResources;
    }
    catch (Resources.NotFoundException paramResources)
    {
      return paramString;
    }
    catch (NumberFormatException paramResources) {}
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.platformtools.ai.a
 * JD-Core Version:    0.7.0.1
 */