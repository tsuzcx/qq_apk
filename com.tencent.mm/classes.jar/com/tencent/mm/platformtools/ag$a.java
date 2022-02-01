package com.tencent.mm.platformtools;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.XmlResourceParser;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

public final class ag$a
{
  /* Error */
  public static int M(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: sipush 20750
    //   9: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   12: aload_0
    //   13: aload_1
    //   14: iconst_0
    //   15: invokevirtual 27	android/content/Context:createPackageContext	(Ljava/lang/String;I)Landroid/content/Context;
    //   18: astore 5
    //   20: aload 5
    //   22: ifnonnull +30 -> 52
    //   25: sipush 20750
    //   28: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: iconst_0
    //   32: ireturn
    //   33: astore_1
    //   34: ldc 32
    //   36: aload_1
    //   37: ldc 34
    //   39: iconst_0
    //   40: anewarray 4	java/lang/Object
    //   43: invokestatic 40	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   46: aconst_null
    //   47: astore 5
    //   49: goto -29 -> 20
    //   52: aload 5
    //   54: invokevirtual 44	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   57: astore 9
    //   59: new 46	android/content/res/Resources
    //   62: dup
    //   63: aload 9
    //   65: aload_0
    //   66: invokevirtual 50	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   69: invokevirtual 54	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   72: aconst_null
    //   73: invokespecial 58	android/content/res/Resources:<init>	(Landroid/content/res/AssetManager;Landroid/util/DisplayMetrics;Landroid/content/res/Configuration;)V
    //   76: astore 8
    //   78: aload 7
    //   80: astore_0
    //   81: aload 6
    //   83: astore_1
    //   84: aload 5
    //   86: aload 9
    //   88: invokestatic 61	com/tencent/mm/platformtools/ag$a:a	(Landroid/content/Context;Landroid/content/res/AssetManager;)Landroid/content/res/XmlResourceParser;
    //   91: astore 5
    //   93: aload 5
    //   95: ifnonnull +23 -> 118
    //   98: aload 5
    //   100: ifnull +10 -> 110
    //   103: aload 5
    //   105: invokeinterface 67 1 0
    //   110: sipush 20750
    //   113: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   116: iconst_0
    //   117: ireturn
    //   118: aload 5
    //   120: astore_0
    //   121: aload 5
    //   123: astore_1
    //   124: aload 5
    //   126: invokeinterface 71 1 0
    //   131: istore_2
    //   132: iload_2
    //   133: iconst_1
    //   134: if_icmpeq +306 -> 440
    //   137: iload_2
    //   138: tableswitch	default:+18 -> 156, 2:+60->198
    //   157: iconst_2
    //   158: astore_1
    //   159: aload 5
    //   161: invokeinterface 74 1 0
    //   166: istore_3
    //   167: iload_3
    //   168: istore_2
    //   169: goto -37 -> 132
    //   172: astore 6
    //   174: aload 5
    //   176: astore_0
    //   177: aload 5
    //   179: astore_1
    //   180: ldc 32
    //   182: aload 6
    //   184: ldc 34
    //   186: iconst_0
    //   187: anewarray 4	java/lang/Object
    //   190: invokestatic 40	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   193: iconst_0
    //   194: istore_2
    //   195: goto -63 -> 132
    //   198: aload 5
    //   200: astore_0
    //   201: aload 5
    //   203: astore_1
    //   204: aload 5
    //   206: invokeinterface 78 1 0
    //   211: astore 6
    //   213: aload 5
    //   215: astore_0
    //   216: aload 5
    //   218: astore_1
    //   219: aload 6
    //   221: invokestatic 84	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   224: ifne -68 -> 156
    //   227: aload 5
    //   229: astore_0
    //   230: aload 5
    //   232: astore_1
    //   233: aload 6
    //   235: ldc 86
    //   237: invokevirtual 92	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   240: ifeq -84 -> 156
    //   243: aload 5
    //   245: astore_0
    //   246: aload 5
    //   248: astore_1
    //   249: aload 5
    //   251: ldc 94
    //   253: ldc 96
    //   255: invokeinterface 100 3 0
    //   260: aload 8
    //   262: invokestatic 103	com/tencent/mm/platformtools/ag$a:a	(Ljava/lang/String;Landroid/content/res/Resources;)Ljava/lang/String;
    //   265: astore 6
    //   267: aload 5
    //   269: astore_0
    //   270: aload 5
    //   272: astore_1
    //   273: aload 6
    //   275: invokestatic 84	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   278: istore 4
    //   280: iload 4
    //   282: ifeq +23 -> 305
    //   285: aload 5
    //   287: ifnull +10 -> 297
    //   290: aload 5
    //   292: invokeinterface 67 1 0
    //   297: sipush 20750
    //   300: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   303: iconst_0
    //   304: ireturn
    //   305: aload 5
    //   307: astore_0
    //   308: aload 5
    //   310: astore_1
    //   311: aload 6
    //   313: iconst_0
    //   314: invokestatic 109	com/tencent/mm/sdk/platformtools/bt:getInt	(Ljava/lang/String;I)I
    //   317: istore_2
    //   318: aload 5
    //   320: ifnull +10 -> 330
    //   323: aload 5
    //   325: invokeinterface 67 1 0
    //   330: sipush 20750
    //   333: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   336: iload_2
    //   337: ireturn
    //   338: astore 6
    //   340: aload 5
    //   342: astore_0
    //   343: aload 5
    //   345: astore_1
    //   346: ldc 32
    //   348: aload 6
    //   350: ldc 34
    //   352: iconst_0
    //   353: anewarray 4	java/lang/Object
    //   356: invokestatic 40	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   359: goto -227 -> 132
    //   362: astore 5
    //   364: aload_0
    //   365: astore_1
    //   366: ldc 32
    //   368: aload 5
    //   370: ldc 34
    //   372: iconst_0
    //   373: anewarray 4	java/lang/Object
    //   376: invokestatic 40	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   379: aload_0
    //   380: ifnull +9 -> 389
    //   383: aload_0
    //   384: invokeinterface 67 1 0
    //   389: sipush 20750
    //   392: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   395: iconst_0
    //   396: ireturn
    //   397: astore 6
    //   399: aload 5
    //   401: astore_0
    //   402: aload 5
    //   404: astore_1
    //   405: ldc 32
    //   407: aload 6
    //   409: ldc 34
    //   411: iconst_0
    //   412: anewarray 4	java/lang/Object
    //   415: invokestatic 40	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   418: goto -286 -> 132
    //   421: astore_0
    //   422: aload_1
    //   423: ifnull +9 -> 432
    //   426: aload_1
    //   427: invokeinterface 67 1 0
    //   432: sipush 20750
    //   435: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   438: aload_0
    //   439: athrow
    //   440: aload 5
    //   442: ifnull -53 -> 389
    //   445: aload 5
    //   447: invokeinterface 67 1 0
    //   452: goto -63 -> 389
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	455	0	paramContext	Context
    //   0	455	1	paramString	String
    //   131	206	2	i	int
    //   166	2	3	j	int
    //   278	3	4	bool	boolean
    //   18	326	5	localObject1	Object
    //   362	84	5	localIOException1	java.io.IOException
    //   1	81	6	localObject2	Object
    //   172	11	6	localXmlPullParserException1	org.xmlpull.v1.XmlPullParserException
    //   211	101	6	str	String
    //   338	11	6	localXmlPullParserException2	org.xmlpull.v1.XmlPullParserException
    //   397	11	6	localIOException2	java.io.IOException
    //   4	75	7	localObject3	Object
    //   76	185	8	localResources	Resources
    //   57	30	9	localAssetManager	AssetManager
    // Exception table:
    //   from	to	target	type
    //   12	20	33	android/content/pm/PackageManager$NameNotFoundException
    //   124	132	172	org/xmlpull/v1/XmlPullParserException
    //   159	167	338	org/xmlpull/v1/XmlPullParserException
    //   84	93	362	java/io/IOException
    //   124	132	362	java/io/IOException
    //   180	193	362	java/io/IOException
    //   204	213	362	java/io/IOException
    //   219	227	362	java/io/IOException
    //   233	243	362	java/io/IOException
    //   249	267	362	java/io/IOException
    //   273	280	362	java/io/IOException
    //   311	318	362	java/io/IOException
    //   346	359	362	java/io/IOException
    //   405	418	362	java/io/IOException
    //   159	167	397	java/io/IOException
    //   84	93	421	finally
    //   124	132	421	finally
    //   159	167	421	finally
    //   180	193	421	finally
    //   204	213	421	finally
    //   219	227	421	finally
    //   233	243	421	finally
    //   249	267	421	finally
    //   273	280	421	finally
    //   311	318	421	finally
    //   346	359	421	finally
    //   366	379	421	finally
    //   405	418	421	finally
  }
  
  private static XmlResourceParser a(Context paramContext, AssetManager paramAssetManager)
  {
    int j = 1;
    AppMethodBeat.i(20751);
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
            AppMethodBeat.o(20751);
            return paramContext;
          }
        }
        i += 1;
      }
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext = paramAssetManager.openXmlResourceParser("AndroidManifest.xml");
      AppMethodBeat.o(20751);
    }
  }
  
  private static String a(String paramString, Resources paramResources)
  {
    AppMethodBeat.i(20752);
    if ((paramString == null) || (!paramString.startsWith("@")))
    {
      AppMethodBeat.o(20752);
      return paramString;
    }
    try
    {
      paramResources = paramResources.getString(Integer.parseInt(paramString.substring(1)));
      AppMethodBeat.o(20752);
      return paramResources;
    }
    catch (NumberFormatException paramResources)
    {
      AppMethodBeat.o(20752);
      return paramString;
    }
    catch (Resources.NotFoundException paramResources)
    {
      AppMethodBeat.o(20752);
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.platformtools.ag.a
 * JD-Core Version:    0.7.0.1
 */