package com.tencent.mm.plugin.ext.c;

import android.content.Context;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.plugin.ext.openapi.provider.ExtControlProviderOpenApi;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public final class c
{
  private static com.tencent.mm.sdk.b.c fjE = new c.1();
  private static HashSet<String> jLa = new HashSet();
  private static HashSet<String> jLb = new HashSet();
  private static ArrayList<a> jLc = new ArrayList();
  private static HashMap<String, e.a> jLd = new HashMap();
  
  public static void Ce(String paramString)
  {
    jLa.add(paramString);
  }
  
  public static void Cf(String paramString)
  {
    jLb.add(paramString);
  }
  
  public static e.a Cg(String paramString)
  {
    return (e.a)jLd.get(paramString);
  }
  
  public static boolean Ch(String paramString)
  {
    if (bk.bl(paramString)) {
      y.w("MicroMsg.ExtQbarDataManager", "hy: null in fastJudgeInWhitelist");
    }
    while (!jLa.contains(paramString)) {
      return false;
    }
    y.i("MicroMsg.ExtQbarDataManager", "hy: %s already in whitelist", new Object[] { paramString });
    return true;
  }
  
  public static boolean Ci(String paramString)
  {
    if (bk.bl(paramString)) {
      y.w("MicroMsg.ExtQbarDataManager", "hy: null in fastJudgeInBlacklist");
    }
    while (!jLb.contains(paramString)) {
      return false;
    }
    y.i("MicroMsg.ExtQbarDataManager", "hy: %s already in blacklist", new Object[] { paramString });
    return true;
  }
  
  public static b.b Cj(String paramString)
  {
    if (bk.bl(paramString))
    {
      y.w("MicroMsg.ExtQbarDataManager", "hy: url is null when get config");
      return b.b.jKY;
    }
    Iterator localIterator = jLc.iterator();
    Object localObject;
    label167:
    String[] arrayOfString;
    int j;
    int i;
    int k;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala.jKQ == b.a.jKS)
        {
          if (paramString.startsWith(locala.url))
          {
            y.i("MicroMsg.ExtQbarDataManager", "hy: match prefix: %s", new Object[] { locala.url });
            return locala.jKR;
          }
        }
        else
        {
          try
          {
            localObject = new URL(paramString).getHost();
            y.d("MicroMsg.ExtQbarDataManager", "hy: host is %s", new Object[] { localObject });
            if (!bk.H(new String[0])) {
              break label167;
            }
            y.w("MicroMsg.ExtQbarDataManager", "hy: no valid host");
          }
          catch (MalformedURLException localMalformedURLException)
          {
            y.printErrStackTrace("MicroMsg.ExtQbarDataManager", localMalformedURLException, "hy: error in url convert: %s", new Object[] { paramString });
          }
          continue;
          if (localMalformedURLException.jKQ == b.a.jKU)
          {
            if (localMalformedURLException.url.equals(localObject))
            {
              y.i("MicroMsg.ExtQbarDataManager", "hy: match domain: %s", new Object[] { localMalformedURLException.jKQ });
              return localMalformedURLException.jKR;
            }
          }
          else if (localMalformedURLException.jKQ == b.a.jKT)
          {
            arrayOfString = localMalformedURLException.url.split("\\.");
            localObject = ((String)localObject).split("\\.");
            if ((arrayOfString.length <= 0) || (localObject.length <= 0) || (arrayOfString.length > localObject.length)) {
              continue;
            }
            j = arrayOfString.length - 1;
            i = localObject.length - 1;
            k = 1;
          }
        }
      }
    }
    for (;;)
    {
      if ((j >= 0) && (i >= 0))
      {
        if (!arrayOfString[j].equals(localObject[i])) {
          k = 0;
        }
      }
      else
      {
        if (k == 0) {
          break;
        }
        y.i("MicroMsg.ExtQbarDataManager", "hy: match %s subdomain: %s", new Object[] { paramString, localMalformedURLException.url });
        return localMalformedURLException.jKR;
        y.e("MicroMsg.ExtQbarDataManager", "hy: damn it impossible!");
        break;
        return b.b.jKY;
      }
      j -= 1;
      i -= 1;
    }
  }
  
  public static void a(String paramString, e.a parama)
  {
    jLd.put(paramString, parama);
  }
  
  private static String aNG()
  {
    if (ExtControlProviderOpenApi.jJO) {}
    for (String str = h.getExternalStorageDirectory().getAbsolutePath() + File.separator + "extqbar";; str = ae.getContext().getFilesDir().getParent() + File.separator + "extqbar")
    {
      File localFile = new File(str);
      if (!localFile.exists())
      {
        y.i("MicroMsg.ExtQbarDataManager", "hy: face dir not exist. mk dir");
        localFile.mkdirs();
      }
      return str + File.separator + "ext_qbar_config.csv";
    }
  }
  
  /* Error */
  private static void aNH()
  {
    // Byte code:
    //   0: invokestatic 262	com/tencent/mm/plugin/ext/c/c:aNG	()Ljava/lang/String;
    //   3: invokestatic 267	com/tencent/mm/a/e:bK	(Ljava/lang/String;)Z
    //   6: ifne +29 -> 35
    //   9: ldc 67
    //   11: ldc_w 269
    //   14: invokestatic 75	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: invokestatic 275	com/tencent/mm/kernel/g:Dk	()Lcom/tencent/mm/ah/p;
    //   20: new 277	com/tencent/mm/pluginsdk/g/a/a/m
    //   23: dup
    //   24: bipush 46
    //   26: invokespecial 280	com/tencent/mm/pluginsdk/g/a/a/m:<init>	(I)V
    //   29: iconst_0
    //   30: invokevirtual 285	com/tencent/mm/ah/p:a	(Lcom/tencent/mm/ah/m;I)Z
    //   33: pop
    //   34: return
    //   35: invokestatic 262	com/tencent/mm/plugin/ext/c/c:aNG	()Ljava/lang/String;
    //   38: invokestatic 289	com/tencent/mm/a/e:bP	(Ljava/lang/String;)Ljava/lang/String;
    //   41: astore_3
    //   42: ldc 67
    //   44: ldc_w 291
    //   47: invokestatic 236	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   50: ldc 67
    //   52: ldc_w 293
    //   55: iconst_1
    //   56: anewarray 4	java/lang/Object
    //   59: dup
    //   60: iconst_0
    //   61: aload_3
    //   62: aastore
    //   63: invokestatic 296	com/tencent/mm/sdk/platformtools/y:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   66: aload_3
    //   67: invokestatic 65	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   70: ifeq +11 -> 81
    //   73: ldc 67
    //   75: ldc_w 298
    //   78: invokestatic 75	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   81: new 300	java/io/BufferedReader
    //   84: dup
    //   85: new 302	java/io/StringReader
    //   88: dup
    //   89: aload_3
    //   90: invokespecial 303	java/io/StringReader:<init>	(Ljava/lang/String;)V
    //   93: invokespecial 306	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   96: astore_3
    //   97: invokestatic 310	com/tencent/mm/sdk/platformtools/bk:UZ	()J
    //   100: lstore_1
    //   101: aload_3
    //   102: invokevirtual 313	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   105: astore 5
    //   107: aload 5
    //   109: ifnull +62 -> 171
    //   112: ldc 67
    //   114: ldc_w 315
    //   117: invokestatic 317	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   120: aload 5
    //   122: ldc_w 319
    //   125: invokevirtual 182	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   128: astore 4
    //   130: aload 4
    //   132: arraylength
    //   133: iconst_3
    //   134: if_icmpge +75 -> 209
    //   137: ldc 67
    //   139: ldc_w 321
    //   142: iconst_1
    //   143: anewarray 4	java/lang/Object
    //   146: dup
    //   147: iconst_0
    //   148: aload 5
    //   150: aastore
    //   151: invokestatic 323	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   154: goto -53 -> 101
    //   157: astore_3
    //   158: ldc 67
    //   160: aload_3
    //   161: ldc_w 325
    //   164: iconst_0
    //   165: anewarray 4	java/lang/Object
    //   168: invokestatic 165	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   171: ldc 67
    //   173: ldc_w 327
    //   176: iconst_1
    //   177: anewarray 4	java/lang/Object
    //   180: dup
    //   181: iconst_0
    //   182: lload_1
    //   183: invokestatic 331	com/tencent/mm/sdk/platformtools/bk:cp	(J)J
    //   186: invokestatic 337	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   189: aastore
    //   190: invokestatic 84	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   193: return
    //   194: astore_3
    //   195: ldc 67
    //   197: aload_3
    //   198: ldc_w 339
    //   201: iconst_0
    //   202: anewarray 4	java/lang/Object
    //   205: invokestatic 165	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   208: return
    //   209: new 117	com/tencent/mm/plugin/ext/c/a
    //   212: dup
    //   213: invokespecial 340	com/tencent/mm/plugin/ext/c/a:<init>	()V
    //   216: astore 5
    //   218: aload 5
    //   220: aload 4
    //   222: iconst_2
    //   223: aaload
    //   224: invokevirtual 343	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   227: putfield 130	com/tencent/mm/plugin/ext/c/a:url	Ljava/lang/String;
    //   230: ldc_w 345
    //   233: aload 4
    //   235: iconst_0
    //   236: aaload
    //   237: invokevirtual 348	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   240: ifeq +126 -> 366
    //   243: aload 5
    //   245: getstatic 351	com/tencent/mm/plugin/ext/c/b$b:jKX	Lcom/tencent/mm/plugin/ext/c/b$b;
    //   248: putfield 140	com/tencent/mm/plugin/ext/c/a:jKR	Lcom/tencent/mm/plugin/ext/c/b$b;
    //   251: ldc_w 353
    //   254: aload 4
    //   256: iconst_1
    //   257: aaload
    //   258: invokevirtual 348	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   261: ifeq +29 -> 290
    //   264: aload 5
    //   266: getstatic 126	com/tencent/mm/plugin/ext/c/b$a:jKS	Lcom/tencent/mm/plugin/ext/c/b$a;
    //   269: putfield 121	com/tencent/mm/plugin/ext/c/a:jKQ	Lcom/tencent/mm/plugin/ext/c/b$a;
    //   272: iconst_1
    //   273: istore_0
    //   274: iload_0
    //   275: ifeq -174 -> 101
    //   278: getstatic 32	com/tencent/mm/plugin/ext/c/c:jLc	Ljava/util/ArrayList;
    //   281: aload 5
    //   283: invokevirtual 354	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   286: pop
    //   287: goto -186 -> 101
    //   290: ldc_w 356
    //   293: aload 4
    //   295: iconst_1
    //   296: aaload
    //   297: invokevirtual 348	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   300: ifeq +16 -> 316
    //   303: aload 5
    //   305: getstatic 176	com/tencent/mm/plugin/ext/c/b$a:jKT	Lcom/tencent/mm/plugin/ext/c/b$a;
    //   308: putfield 121	com/tencent/mm/plugin/ext/c/a:jKQ	Lcom/tencent/mm/plugin/ext/c/b$a;
    //   311: iconst_1
    //   312: istore_0
    //   313: goto -39 -> 274
    //   316: ldc_w 358
    //   319: aload 4
    //   321: iconst_1
    //   322: aaload
    //   323: invokevirtual 348	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   326: ifeq +16 -> 342
    //   329: aload 5
    //   331: getstatic 168	com/tencent/mm/plugin/ext/c/b$a:jKU	Lcom/tencent/mm/plugin/ext/c/b$a;
    //   334: putfield 121	com/tencent/mm/plugin/ext/c/a:jKQ	Lcom/tencent/mm/plugin/ext/c/b$a;
    //   337: iconst_1
    //   338: istore_0
    //   339: goto -65 -> 274
    //   342: ldc 67
    //   344: ldc_w 360
    //   347: iconst_1
    //   348: anewarray 4	java/lang/Object
    //   351: dup
    //   352: iconst_0
    //   353: aload 4
    //   355: iconst_1
    //   356: aaload
    //   357: aastore
    //   358: invokestatic 323	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   361: iconst_0
    //   362: istore_0
    //   363: goto -89 -> 274
    //   366: ldc_w 362
    //   369: aload 4
    //   371: iconst_0
    //   372: aaload
    //   373: invokevirtual 348	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   376: ifeq +113 -> 489
    //   379: aload 5
    //   381: getstatic 365	com/tencent/mm/plugin/ext/c/b$b:jKW	Lcom/tencent/mm/plugin/ext/c/b$b;
    //   384: putfield 140	com/tencent/mm/plugin/ext/c/a:jKR	Lcom/tencent/mm/plugin/ext/c/b$b;
    //   387: ldc_w 353
    //   390: aload 4
    //   392: iconst_1
    //   393: aaload
    //   394: invokevirtual 348	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   397: ifeq +16 -> 413
    //   400: aload 5
    //   402: getstatic 126	com/tencent/mm/plugin/ext/c/b$a:jKS	Lcom/tencent/mm/plugin/ext/c/b$a;
    //   405: putfield 121	com/tencent/mm/plugin/ext/c/a:jKQ	Lcom/tencent/mm/plugin/ext/c/b$a;
    //   408: iconst_1
    //   409: istore_0
    //   410: goto -136 -> 274
    //   413: ldc_w 356
    //   416: aload 4
    //   418: iconst_1
    //   419: aaload
    //   420: invokevirtual 348	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   423: ifeq +16 -> 439
    //   426: aload 5
    //   428: getstatic 176	com/tencent/mm/plugin/ext/c/b$a:jKT	Lcom/tencent/mm/plugin/ext/c/b$a;
    //   431: putfield 121	com/tencent/mm/plugin/ext/c/a:jKQ	Lcom/tencent/mm/plugin/ext/c/b$a;
    //   434: iconst_1
    //   435: istore_0
    //   436: goto -162 -> 274
    //   439: ldc_w 358
    //   442: aload 4
    //   444: iconst_1
    //   445: aaload
    //   446: invokevirtual 348	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   449: ifeq +16 -> 465
    //   452: aload 5
    //   454: getstatic 168	com/tencent/mm/plugin/ext/c/b$a:jKU	Lcom/tencent/mm/plugin/ext/c/b$a;
    //   457: putfield 121	com/tencent/mm/plugin/ext/c/a:jKQ	Lcom/tencent/mm/plugin/ext/c/b$a;
    //   460: iconst_1
    //   461: istore_0
    //   462: goto -188 -> 274
    //   465: ldc 67
    //   467: ldc_w 367
    //   470: iconst_1
    //   471: anewarray 4	java/lang/Object
    //   474: dup
    //   475: iconst_0
    //   476: aload 4
    //   478: iconst_1
    //   479: aaload
    //   480: aastore
    //   481: invokestatic 323	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   484: iconst_0
    //   485: istore_0
    //   486: goto -212 -> 274
    //   489: ldc 67
    //   491: ldc_w 369
    //   494: iconst_1
    //   495: anewarray 4	java/lang/Object
    //   498: dup
    //   499: iconst_0
    //   500: aload 4
    //   502: iconst_0
    //   503: aaload
    //   504: aastore
    //   505: invokestatic 323	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   508: iconst_0
    //   509: istore_0
    //   510: goto -236 -> 274
    // Local variable table:
    //   start	length	slot	name	signature
    //   273	237	0	i	int
    //   100	83	1	l	long
    //   41	61	3	localObject1	Object
    //   157	4	3	localException	java.lang.Exception
    //   194	4	3	localIOException	java.io.IOException
    //   128	373	4	arrayOfString	String[]
    //   105	348	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   101	107	157	java/lang/Exception
    //   112	154	157	java/lang/Exception
    //   209	272	157	java/lang/Exception
    //   278	287	157	java/lang/Exception
    //   290	311	157	java/lang/Exception
    //   316	337	157	java/lang/Exception
    //   342	361	157	java/lang/Exception
    //   366	408	157	java/lang/Exception
    //   413	434	157	java/lang/Exception
    //   439	460	157	java/lang/Exception
    //   465	484	157	java/lang/Exception
    //   489	508	157	java/lang/Exception
    //   35	81	194	java/io/IOException
    //   81	101	194	java/io/IOException
    //   101	107	194	java/io/IOException
    //   112	154	194	java/io/IOException
    //   158	171	194	java/io/IOException
    //   171	193	194	java/io/IOException
    //   209	272	194	java/io/IOException
    //   278	287	194	java/io/IOException
    //   290	311	194	java/io/IOException
    //   316	337	194	java/io/IOException
    //   342	361	194	java/io/IOException
    //   366	408	194	java/io/IOException
    //   413	434	194	java/io/IOException
    //   439	460	194	java/io/IOException
    //   465	484	194	java/io/IOException
    //   489	508	194	java/io/IOException
  }
  
  public static void aNI()
  {
    aNH();
    com.tencent.mm.sdk.b.a.udP.c(fjE);
  }
  
  public static void aNJ()
  {
    com.tencent.mm.sdk.b.a.udP.d(fjE);
  }
  
  public static void clearCache()
  {
    jLd.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.c.c
 * JD-Core Version:    0.7.0.1
 */