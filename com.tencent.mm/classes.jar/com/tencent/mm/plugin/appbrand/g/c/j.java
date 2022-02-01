package com.tencent.mm.plugin.appbrand.g.c;

import android.util.Xml;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g.c.b.a;
import com.tencent.mm.plugin.appbrand.g.c.b.b;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class j
{
  private XmlPullParser aWJ;
  
  private j()
  {
    AppMethodBeat.i(159015);
    this.aWJ = Xml.newPullParser();
    AppMethodBeat.o(159015);
  }
  
  private HashMap<String, a> E(InputStream paramInputStream)
  {
    AppMethodBeat.i(159018);
    localHashMap = new HashMap();
    for (;;)
    {
      try
      {
        this.aWJ.setInput(paramInputStream, "utf-8");
        this.aWJ.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
        i = this.aWJ.getEventType();
        if (i == 1) {
          continue;
        }
        paramInputStream = this.aWJ.getName();
        if (paramInputStream != null) {
          continue;
        }
        i = this.aWJ.next();
        continue;
      }
      catch (XmlPullParserException paramInputStream)
      {
        int i;
        a locala;
        int j;
        String str2;
        AppMethodBeat.o(159018);
        return localHashMap;
        if (i != 4) {
          continue;
        }
        String str1 = this.aWJ.getText().trim();
        locala.value = str1;
        localHashMap.put(paramInputStream, locala);
        new StringBuilder("name=").append(paramInputStream).append(", value=").append(str1);
        continue;
        if (i != 3) {
          continue;
        }
        localHashMap.put(paramInputStream, locala);
        continue;
        switch (i)
        {
        }
        continue;
      }
      catch (IOException paramInputStream)
      {
        continue;
      }
      i = this.aWJ.next();
      continue;
      locala = new a();
      j = this.aWJ.getAttributeCount();
      i = 0;
      if (i < j)
      {
        str1 = this.aWJ.getAttributeName(i);
        str2 = this.aWJ.getAttributeValue(i);
        locala.kel.put(str1, str2);
        new StringBuilder("attrName=").append(str1).append(", attrVal=").append(str2);
        i += 1;
      }
      else
      {
        i = this.aWJ.next();
        if (i != 2) {
          continue;
        }
        localHashMap.put(paramInputStream, locala);
      }
    }
  }
  
  public static b Ol(String paramString)
  {
    int j = 1;
    AppMethodBeat.i(159017);
    if (paramString == null)
    {
      AppMethodBeat.o(159017);
      return null;
    }
    b localb;
    if ((paramString.startsWith("NOTIFY")) || (paramString.startsWith("HTTP")))
    {
      localb = new b();
      paramString = paramString.split("\r\n");
      int i = j;
      String[] arrayOfString;
      if (paramString.length > 0)
      {
        arrayOfString = paramString[0].split(" ");
        if (!arrayOfString[0].startsWith("HTTP")) {
          break label168;
        }
        localb.put("VERSION", arrayOfString[0]);
        localb.put("RESPONSE_CODE", arrayOfString[1]);
        localb.put("RESPONSE_DESCRIPTION", arrayOfString[2]);
        i = j;
      }
      while (i < paramString.length)
      {
        arrayOfString = paramString[i];
        j = arrayOfString.indexOf(":");
        localb.put(arrayOfString.substring(0, j).toUpperCase(), arrayOfString.substring(j + 1, arrayOfString.length()).trim());
        i += 1;
        continue;
        label168:
        localb.put("METHOD", arrayOfString[0]);
        localb.put("PATH", arrayOfString[1]);
        localb.put("VERSION", arrayOfString[2]);
        i = j;
      }
    }
    for (paramString = localb;; paramString = null)
    {
      AppMethodBeat.o(159017);
      return paramString;
    }
  }
  
  public static j bfD()
  {
    AppMethodBeat.i(159016);
    j localj = new j();
    AppMethodBeat.o(159016);
    return localj;
  }
  
  /* Error */
  public final com.tencent.mm.plugin.appbrand.g.b.b F(InputStream paramInputStream)
  {
    // Byte code:
    //   0: ldc 174
    //   2: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 2
    //   7: monitorenter
    //   8: aload_0
    //   9: getfield 25	com/tencent/mm/plugin/appbrand/g/c/j:aWJ	Lorg/xmlpull/v1/XmlPullParser;
    //   12: aload_1
    //   13: ldc 41
    //   15: invokeinterface 47 3 0
    //   20: aload_0
    //   21: getfield 25	com/tencent/mm/plugin/appbrand/g/c/j:aWJ	Lorg/xmlpull/v1/XmlPullParser;
    //   24: invokeinterface 57 1 0
    //   29: istore_2
    //   30: new 176	com/tencent/mm/plugin/appbrand/g/b/b
    //   33: dup
    //   34: invokespecial 177	com/tencent/mm/plugin/appbrand/g/b/b:<init>	()V
    //   37: astore 4
    //   39: aconst_null
    //   40: astore_3
    //   41: aload 4
    //   43: astore_1
    //   44: iload_2
    //   45: iconst_1
    //   46: if_icmpeq +104 -> 150
    //   49: iload_2
    //   50: tableswitch	default:+22 -> 72, 2:+39->89, 3:+476->526
    //   73: astore_1
    //   74: aload_0
    //   75: getfield 25	com/tencent/mm/plugin/appbrand/g/c/j:aWJ	Lorg/xmlpull/v1/XmlPullParser;
    //   78: invokeinterface 64 1 0
    //   83: istore_2
    //   84: aload_1
    //   85: astore_3
    //   86: goto -45 -> 41
    //   89: aload_0
    //   90: getfield 25	com/tencent/mm/plugin/appbrand/g/c/j:aWJ	Lorg/xmlpull/v1/XmlPullParser;
    //   93: invokeinterface 61 1 0
    //   98: astore 5
    //   100: ldc 179
    //   102: aload 5
    //   104: invokevirtual 182	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   107: ifeq +53 -> 160
    //   110: aload_0
    //   111: getfield 25	com/tencent/mm/plugin/appbrand/g/c/j:aWJ	Lorg/xmlpull/v1/XmlPullParser;
    //   114: invokeinterface 185 1 0
    //   119: astore 5
    //   121: aload_3
    //   122: astore_1
    //   123: aload 5
    //   125: invokestatic 191	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   128: ifne -54 -> 74
    //   131: aload 4
    //   133: aload 5
    //   135: invokestatic 196	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   138: putfield 199	com/tencent/mm/plugin/appbrand/g/b/b:major	I
    //   141: aload_3
    //   142: astore_1
    //   143: goto -69 -> 74
    //   146: astore_1
    //   147: aload 4
    //   149: astore_1
    //   150: ldc 2
    //   152: monitorexit
    //   153: ldc 174
    //   155: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   158: aload_1
    //   159: areturn
    //   160: ldc 201
    //   162: aload 5
    //   164: invokevirtual 182	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   167: ifeq +39 -> 206
    //   170: aload_0
    //   171: getfield 25	com/tencent/mm/plugin/appbrand/g/c/j:aWJ	Lorg/xmlpull/v1/XmlPullParser;
    //   174: invokeinterface 185 1 0
    //   179: astore 5
    //   181: aload_3
    //   182: astore_1
    //   183: aload 5
    //   185: invokestatic 191	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   188: ifne -114 -> 74
    //   191: aload 4
    //   193: aload 5
    //   195: invokestatic 196	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   198: putfield 203	com/tencent/mm/plugin/appbrand/g/b/b:minor	I
    //   201: aload_3
    //   202: astore_1
    //   203: goto -129 -> 74
    //   206: ldc 205
    //   208: aload 5
    //   210: invokevirtual 182	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   213: ifeq +33 -> 246
    //   216: aload 4
    //   218: aload_0
    //   219: getfield 25	com/tencent/mm/plugin/appbrand/g/c/j:aWJ	Lorg/xmlpull/v1/XmlPullParser;
    //   222: invokeinterface 185 1 0
    //   227: putfield 208	com/tencent/mm/plugin/appbrand/g/b/b:dow	Ljava/lang/String;
    //   230: aload_3
    //   231: astore_1
    //   232: goto -158 -> 74
    //   235: astore_1
    //   236: ldc 2
    //   238: monitorexit
    //   239: ldc 174
    //   241: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   244: aload_1
    //   245: athrow
    //   246: ldc 210
    //   248: aload 5
    //   250: invokevirtual 182	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   253: ifeq +22 -> 275
    //   256: aload 4
    //   258: aload_0
    //   259: getfield 25	com/tencent/mm/plugin/appbrand/g/c/j:aWJ	Lorg/xmlpull/v1/XmlPullParser;
    //   262: invokeinterface 185 1 0
    //   267: putfield 213	com/tencent/mm/plugin/appbrand/g/b/b:kcP	Ljava/lang/String;
    //   270: aload_3
    //   271: astore_1
    //   272: goto -198 -> 74
    //   275: ldc 215
    //   277: aload 5
    //   279: invokevirtual 182	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   282: ifeq +22 -> 304
    //   285: aload 4
    //   287: aload_0
    //   288: getfield 25	com/tencent/mm/plugin/appbrand/g/c/j:aWJ	Lorg/xmlpull/v1/XmlPullParser;
    //   291: invokeinterface 185 1 0
    //   296: putfield 218	com/tencent/mm/plugin/appbrand/g/b/b:kcS	Ljava/lang/String;
    //   299: aload_3
    //   300: astore_1
    //   301: goto -227 -> 74
    //   304: ldc 220
    //   306: aload 5
    //   308: invokevirtual 182	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   311: ifeq +22 -> 333
    //   314: aload 4
    //   316: aload_0
    //   317: getfield 25	com/tencent/mm/plugin/appbrand/g/c/j:aWJ	Lorg/xmlpull/v1/XmlPullParser;
    //   320: invokeinterface 185 1 0
    //   325: putfield 223	com/tencent/mm/plugin/appbrand/g/b/b:kcQ	Ljava/lang/String;
    //   328: aload_3
    //   329: astore_1
    //   330: goto -256 -> 74
    //   333: ldc 225
    //   335: aload 5
    //   337: invokevirtual 182	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   340: ifeq +14 -> 354
    //   343: new 227	com/tencent/mm/plugin/appbrand/g/b/f
    //   346: dup
    //   347: invokespecial 228	com/tencent/mm/plugin/appbrand/g/b/f:<init>	()V
    //   350: astore_1
    //   351: goto -277 -> 74
    //   354: ldc 230
    //   356: aload 5
    //   358: invokevirtual 182	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   361: ifeq +27 -> 388
    //   364: aload_3
    //   365: astore_1
    //   366: aload_3
    //   367: ifnull -293 -> 74
    //   370: aload_3
    //   371: aload_0
    //   372: getfield 25	com/tencent/mm/plugin/appbrand/g/c/j:aWJ	Lorg/xmlpull/v1/XmlPullParser;
    //   375: invokeinterface 185 1 0
    //   380: putfield 233	com/tencent/mm/plugin/appbrand/g/b/f:hDZ	Ljava/lang/String;
    //   383: aload_3
    //   384: astore_1
    //   385: goto -311 -> 74
    //   388: ldc 235
    //   390: aload 5
    //   392: invokevirtual 182	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   395: ifeq +27 -> 422
    //   398: aload_3
    //   399: astore_1
    //   400: aload_3
    //   401: ifnull -327 -> 74
    //   404: aload_3
    //   405: aload_0
    //   406: getfield 25	com/tencent/mm/plugin/appbrand/g/c/j:aWJ	Lorg/xmlpull/v1/XmlPullParser;
    //   409: invokeinterface 185 1 0
    //   414: putfield 238	com/tencent/mm/plugin/appbrand/g/b/f:kdo	Ljava/lang/String;
    //   417: aload_3
    //   418: astore_1
    //   419: goto -345 -> 74
    //   422: ldc 240
    //   424: aload 5
    //   426: invokevirtual 182	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   429: ifeq +27 -> 456
    //   432: aload_3
    //   433: astore_1
    //   434: aload_3
    //   435: ifnull -361 -> 74
    //   438: aload_3
    //   439: aload_0
    //   440: getfield 25	com/tencent/mm/plugin/appbrand/g/c/j:aWJ	Lorg/xmlpull/v1/XmlPullParser;
    //   443: invokeinterface 185 1 0
    //   448: putfield 243	com/tencent/mm/plugin/appbrand/g/b/f:kdq	Ljava/lang/String;
    //   451: aload_3
    //   452: astore_1
    //   453: goto -379 -> 74
    //   456: ldc 245
    //   458: aload 5
    //   460: invokevirtual 182	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   463: ifeq +27 -> 490
    //   466: aload_3
    //   467: astore_1
    //   468: aload_3
    //   469: ifnull -395 -> 74
    //   472: aload_3
    //   473: aload_0
    //   474: getfield 25	com/tencent/mm/plugin/appbrand/g/c/j:aWJ	Lorg/xmlpull/v1/XmlPullParser;
    //   477: invokeinterface 185 1 0
    //   482: putfield 248	com/tencent/mm/plugin/appbrand/g/b/f:kdr	Ljava/lang/String;
    //   485: aload_3
    //   486: astore_1
    //   487: goto -413 -> 74
    //   490: aload_3
    //   491: astore_1
    //   492: ldc 250
    //   494: aload 5
    //   496: invokevirtual 182	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   499: ifeq -425 -> 74
    //   502: aload_3
    //   503: astore_1
    //   504: aload_3
    //   505: ifnull -431 -> 74
    //   508: aload_3
    //   509: aload_0
    //   510: getfield 25	com/tencent/mm/plugin/appbrand/g/c/j:aWJ	Lorg/xmlpull/v1/XmlPullParser;
    //   513: invokeinterface 185 1 0
    //   518: putfield 253	com/tencent/mm/plugin/appbrand/g/b/f:kdp	Ljava/lang/String;
    //   521: aload_3
    //   522: astore_1
    //   523: goto -449 -> 74
    //   526: aload_3
    //   527: astore_1
    //   528: ldc 225
    //   530: aload_0
    //   531: getfield 25	com/tencent/mm/plugin/appbrand/g/c/j:aWJ	Lorg/xmlpull/v1/XmlPullParser;
    //   534: invokeinterface 61 1 0
    //   539: invokevirtual 182	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   542: ifeq -468 -> 74
    //   545: aload_3
    //   546: astore_1
    //   547: aload_3
    //   548: ifnull -474 -> 74
    //   551: aload 4
    //   553: getfield 257	com/tencent/mm/plugin/appbrand/g/b/b:kcT	Ljava/util/ArrayList;
    //   556: aload_3
    //   557: invokevirtual 263	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   560: pop
    //   561: aconst_null
    //   562: astore_1
    //   563: goto -489 -> 74
    //   566: astore_1
    //   567: aconst_null
    //   568: astore_1
    //   569: goto -419 -> 150
    //   572: astore_1
    //   573: aconst_null
    //   574: astore_1
    //   575: goto -425 -> 150
    //   578: astore_1
    //   579: aload 4
    //   581: astore_1
    //   582: goto -432 -> 150
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	585	0	this	j
    //   0	585	1	paramInputStream	InputStream
    //   29	55	2	i	int
    //   40	517	3	localInputStream	InputStream
    //   37	543	4	localb	com.tencent.mm.plugin.appbrand.g.b.b
    //   98	397	5	str	String
    // Exception table:
    //   from	to	target	type
    //   74	84	146	org/xmlpull/v1/XmlPullParserException
    //   89	121	146	org/xmlpull/v1/XmlPullParserException
    //   123	141	146	org/xmlpull/v1/XmlPullParserException
    //   160	181	146	org/xmlpull/v1/XmlPullParserException
    //   183	201	146	org/xmlpull/v1/XmlPullParserException
    //   206	230	146	org/xmlpull/v1/XmlPullParserException
    //   246	270	146	org/xmlpull/v1/XmlPullParserException
    //   275	299	146	org/xmlpull/v1/XmlPullParserException
    //   304	328	146	org/xmlpull/v1/XmlPullParserException
    //   333	351	146	org/xmlpull/v1/XmlPullParserException
    //   354	364	146	org/xmlpull/v1/XmlPullParserException
    //   370	383	146	org/xmlpull/v1/XmlPullParserException
    //   388	398	146	org/xmlpull/v1/XmlPullParserException
    //   404	417	146	org/xmlpull/v1/XmlPullParserException
    //   422	432	146	org/xmlpull/v1/XmlPullParserException
    //   438	451	146	org/xmlpull/v1/XmlPullParserException
    //   456	466	146	org/xmlpull/v1/XmlPullParserException
    //   472	485	146	org/xmlpull/v1/XmlPullParserException
    //   492	502	146	org/xmlpull/v1/XmlPullParserException
    //   508	521	146	org/xmlpull/v1/XmlPullParserException
    //   528	545	146	org/xmlpull/v1/XmlPullParserException
    //   551	561	146	org/xmlpull/v1/XmlPullParserException
    //   8	39	235	finally
    //   74	84	235	finally
    //   89	121	235	finally
    //   123	141	235	finally
    //   150	153	235	finally
    //   160	181	235	finally
    //   183	201	235	finally
    //   206	230	235	finally
    //   236	239	235	finally
    //   246	270	235	finally
    //   275	299	235	finally
    //   304	328	235	finally
    //   333	351	235	finally
    //   354	364	235	finally
    //   370	383	235	finally
    //   388	398	235	finally
    //   404	417	235	finally
    //   422	432	235	finally
    //   438	451	235	finally
    //   456	466	235	finally
    //   472	485	235	finally
    //   492	502	235	finally
    //   508	521	235	finally
    //   528	545	235	finally
    //   551	561	235	finally
    //   8	39	566	org/xmlpull/v1/XmlPullParserException
    //   8	39	572	java/io/IOException
    //   74	84	578	java/io/IOException
    //   89	121	578	java/io/IOException
    //   123	141	578	java/io/IOException
    //   160	181	578	java/io/IOException
    //   183	201	578	java/io/IOException
    //   206	230	578	java/io/IOException
    //   246	270	578	java/io/IOException
    //   275	299	578	java/io/IOException
    //   304	328	578	java/io/IOException
    //   333	351	578	java/io/IOException
    //   354	364	578	java/io/IOException
    //   370	383	578	java/io/IOException
    //   388	398	578	java/io/IOException
    //   404	417	578	java/io/IOException
    //   422	432	578	java/io/IOException
    //   438	451	578	java/io/IOException
    //   456	466	578	java/io/IOException
    //   472	485	578	java/io/IOException
    //   492	502	578	java/io/IOException
    //   508	521	578	java/io/IOException
    //   528	545	578	java/io/IOException
    //   551	561	578	java/io/IOException
  }
  
  public final HashMap<String, a> Om(String paramString)
  {
    AppMethodBeat.i(159020);
    paramString = E(new ByteArrayInputStream(paramString.getBytes()));
    AppMethodBeat.o(159020);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g.c.j
 * JD-Core Version:    0.7.0.1
 */