package com.tencent.mapsdk.internal;

import android.util.Log;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.mapsdk.core.components.protocol.jce.conf.CSFileUpdateReq;
import com.tencent.mapsdk.core.components.protocol.jce.conf.FileUpdateReq;
import com.tencent.mapsdk.core.components.protocol.jce.conf.FileUpdateRsp;
import com.tencent.mapsdk.core.components.protocol.jce.conf.SCFileUpdateRsp;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class pe
{
  private static final String a = "UTF-8";
  private WeakReference<pg> b;
  private List<FileUpdateReq> c;
  private String d;
  private String e;
  private String f;
  private int g;
  
  private gm.c a(FileUpdateRsp paramFileUpdateRsp)
  {
    AppMethodBeat.i(225515);
    if ((paramFileUpdateRsp == null) || (paramFileUpdateRsp.iRet != 0))
    {
      AppMethodBeat.o(225515);
      return null;
    }
    String str = paramFileUpdateRsp.sName;
    int i = -1;
    switch (str.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(225515);
        return null;
        if (str.equals("mapconfig"))
        {
          i = 0;
          continue;
          if (str.equals("indoormap_style"))
          {
            i = 1;
            continue;
            if (str.equals("indoormap_style_night"))
            {
              i = 2;
              continue;
              if (str.equals("indoorpoi_icon_3d"))
              {
                i = 3;
                continue;
                if (str.equals("indoorpoi_icon_3d_night"))
                {
                  i = 4;
                  continue;
                  if (str.equals("escalator_night"))
                  {
                    i = 5;
                    continue;
                    if (str.equals("poi_icon"))
                    {
                      i = 6;
                      continue;
                      if (str.equals("map_icon")) {
                        i = 7;
                      }
                    }
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    paramFileUpdateRsp = a(paramFileUpdateRsp, this.d, false);
    AppMethodBeat.o(225515);
    return paramFileUpdateRsp;
    paramFileUpdateRsp = a(paramFileUpdateRsp, this.d, true);
    AppMethodBeat.o(225515);
    return paramFileUpdateRsp;
    paramFileUpdateRsp = a(paramFileUpdateRsp, this.e, true);
    AppMethodBeat.o(225515);
    return paramFileUpdateRsp;
  }
  
  private gm.c a(FileUpdateRsp paramFileUpdateRsp, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(225529);
    if (paramFileUpdateRsp.iFileUpdated != 1)
    {
      AppMethodBeat.o(225529);
      return null;
    }
    String str = paramFileUpdateRsp.sName;
    Object localObject;
    if (str.equals("mapconfig")) {
      localObject = "mapconfig.dat";
    }
    for (;;)
    {
      paramString = new File(paramString + (String)localObject);
      localObject = a((String)localObject, paramFileUpdateRsp.sUpdateUrl, paramString);
      kh.c("net", "fileUpdateRsp.sName = " + paramFileUpdateRsp.sName);
      if (localObject == null) {
        break;
      }
      ((gm.c)localObject).a = paramFileUpdateRsp.sName;
      AppMethodBeat.o(225529);
      return localObject;
      if (str.equals("indoormap_style"))
      {
        localObject = "indoor_style.dat";
      }
      else if (str.equals("indoormap_style_night"))
      {
        localObject = "indoor_style_night.dat";
      }
      else if (str.equals("indoorpoi_icon_3d"))
      {
        localObject = "poi_icon_indoor_ex@2x.png";
      }
      else if (str.equals("indoorpoi_icon_3d_night"))
      {
        localObject = "poi_icon_indoor_ex_night@2x.png";
      }
      else
      {
        localObject = str;
        if (str.equals("escalator_night")) {
          localObject = "escalator_night.dat";
        }
      }
    }
    try
    {
      localObject = kq.a(paramString);
      kh.c("net", "fileMd5 = ".concat(String.valueOf(localObject)));
      if (!paramFileUpdateRsp.sMd5.equals(localObject))
      {
        paramString = new gm.c();
        paramString.a = paramFileUpdateRsp.sName;
        paramString.c = paramFileUpdateRsp.sMd5;
        paramString.d = ((String)localObject);
        kh.c("net", "error md5 1");
        AppMethodBeat.o(225529);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      kh.c(paramString.getMessage());
      localObject = new gm.c();
      ((gm.c)localObject).a = paramFileUpdateRsp.sName;
      kh.c("net", "error md5 2 " + paramString.getMessage());
      AppMethodBeat.o(225529);
      return localObject;
    }
    if (paramBoolean) {}
    try
    {
      kd.b(paramString, paramString.getParent());
      paramString.delete();
      if ((this.b != null) && (this.b.get() != null)) {
        ((pg)this.b.get()).a = true;
      }
      AppMethodBeat.o(225529);
      return null;
    }
    finally
    {
      kh.c(paramString.getMessage());
      paramString = new gm.c();
      paramString.a = paramFileUpdateRsp.sName;
      kh.c("net", "error unzip");
      AppMethodBeat.o(225529);
    }
    return paramString;
  }
  
  /* Error */
  private static gm.c a(String paramString1, String paramString2, File paramFile)
  {
    // Byte code:
    //   0: ldc 192
    //   2: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: sipush 200
    //   8: istore_3
    //   9: ldc 194
    //   11: new 88	java/lang/StringBuilder
    //   14: dup
    //   15: ldc 196
    //   17: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   20: aload_0
    //   21: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: ldc 198
    //   26: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_1
    //   30: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokestatic 116	com/tencent/mapsdk/internal/kh:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: ldc 194
    //   41: aload_1
    //   42: invokestatic 202	com/tencent/mapsdk/internal/kl:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   45: invokestatic 208	com/tencent/map/tools/net/NetManager:getInstance	()Lcom/tencent/map/tools/net/NetManager;
    //   48: invokevirtual 212	com/tencent/map/tools/net/NetManager:builder	()Lcom/tencent/map/tools/net/NetRequest$NetRequestBuilder;
    //   51: aload_1
    //   52: invokevirtual 218	com/tencent/map/tools/net/NetRequest$NetRequestBuilder:url	(Ljava/lang/String;)Lcom/tencent/map/tools/net/NetRequest$NetRequestBuilder;
    //   55: invokevirtual 222	com/tencent/map/tools/net/NetRequest$NetRequestBuilder:doStream	()Lcom/tencent/map/tools/net/NetResponse;
    //   58: astore 6
    //   60: iload_3
    //   61: istore 4
    //   63: iload_3
    //   64: istore 5
    //   66: aload 6
    //   68: getfield 227	com/tencent/map/tools/net/NetResponse:statusCode	I
    //   71: istore_3
    //   72: iload_3
    //   73: istore 4
    //   75: iload_3
    //   76: istore 5
    //   78: aload 6
    //   80: getfield 231	com/tencent/map/tools/net/NetResponse:dataStream	Ljava/io/InputStream;
    //   83: astore 8
    //   85: aload_2
    //   86: invokevirtual 234	java/io/File:exists	()Z
    //   89: ifne +25 -> 114
    //   92: aload_2
    //   93: invokevirtual 238	java/io/File:getParentFile	()Ljava/io/File;
    //   96: astore 7
    //   98: aload 7
    //   100: ifnull +9 -> 109
    //   103: aload 7
    //   105: invokevirtual 241	java/io/File:mkdirs	()Z
    //   108: pop
    //   109: aload_2
    //   110: invokevirtual 244	java/io/File:createNewFile	()Z
    //   113: pop
    //   114: new 246	java/io/FileOutputStream
    //   117: dup
    //   118: aload_2
    //   119: iconst_0
    //   120: invokespecial 249	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   123: astore_2
    //   124: aload 6
    //   126: astore 12
    //   128: iload_3
    //   129: istore 4
    //   131: aload_2
    //   132: astore 10
    //   134: aload 8
    //   136: astore 9
    //   138: aload 8
    //   140: aload_2
    //   141: invokestatic 254	com/tencent/mapsdk/internal/kb:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   144: pop2
    //   145: aload 8
    //   147: invokestatic 257	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   150: aload_2
    //   151: invokestatic 257	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   154: aload 6
    //   156: ifnull +11 -> 167
    //   159: aload 6
    //   161: getfield 231	com/tencent/map/tools/net/NetResponse:dataStream	Ljava/io/InputStream;
    //   164: invokestatic 257	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   167: ldc 194
    //   169: aload_1
    //   170: ldc_w 259
    //   173: iload_3
    //   174: invokestatic 264	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   177: invokestatic 267	com/tencent/mapsdk/internal/kl:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   180: ldc 194
    //   182: aload_1
    //   183: invokestatic 270	com/tencent/mapsdk/internal/kl:f	(Ljava/lang/String;Ljava/lang/String;)J
    //   186: pop2
    //   187: ldc 194
    //   189: new 88	java/lang/StringBuilder
    //   192: dup
    //   193: ldc_w 272
    //   196: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   199: aload_0
    //   200: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: ldc_w 274
    //   206: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: invokestatic 116	com/tencent/mapsdk/internal/kh:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   215: ldc 192
    //   217: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   220: aconst_null
    //   221: areturn
    //   222: astore 7
    //   224: aconst_null
    //   225: astore 11
    //   227: aconst_null
    //   228: astore_2
    //   229: aconst_null
    //   230: astore 6
    //   232: aload 11
    //   234: astore 12
    //   236: iload_3
    //   237: istore 4
    //   239: aload_2
    //   240: astore 10
    //   242: aload 6
    //   244: astore 9
    //   246: aload 7
    //   248: invokestatic 280	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   251: invokestatic 159	com/tencent/mapsdk/internal/kh:c	(Ljava/lang/String;)V
    //   254: aload 11
    //   256: astore 12
    //   258: iload_3
    //   259: istore 4
    //   261: aload_2
    //   262: astore 10
    //   264: aload 6
    //   266: astore 9
    //   268: new 118	com/tencent/mapsdk/internal/gm$c
    //   271: dup
    //   272: invokespecial 149	com/tencent/mapsdk/internal/gm$c:<init>	()V
    //   275: astore 8
    //   277: aload 11
    //   279: astore 12
    //   281: iload_3
    //   282: istore 4
    //   284: aload_2
    //   285: astore 10
    //   287: aload 6
    //   289: astore 9
    //   291: aload 8
    //   293: iload_3
    //   294: putfield 282	com/tencent/mapsdk/internal/gm$c:f	I
    //   297: aload 11
    //   299: astore 12
    //   301: iload_3
    //   302: istore 4
    //   304: aload_2
    //   305: astore 10
    //   307: aload 6
    //   309: astore 9
    //   311: ldc 194
    //   313: aload_1
    //   314: ldc_w 284
    //   317: aload 7
    //   319: invokestatic 280	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   322: invokestatic 267	com/tencent/mapsdk/internal/kl:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   325: aload 6
    //   327: invokestatic 257	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   330: aload_2
    //   331: invokestatic 257	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   334: aload 11
    //   336: ifnull +11 -> 347
    //   339: aload 11
    //   341: getfield 231	com/tencent/map/tools/net/NetResponse:dataStream	Ljava/io/InputStream;
    //   344: invokestatic 257	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   347: ldc 194
    //   349: aload_1
    //   350: ldc_w 259
    //   353: iload_3
    //   354: invokestatic 264	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   357: invokestatic 267	com/tencent/mapsdk/internal/kl:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   360: ldc 194
    //   362: aload_1
    //   363: invokestatic 270	com/tencent/mapsdk/internal/kl:f	(Ljava/lang/String;Ljava/lang/String;)J
    //   366: pop2
    //   367: ldc 194
    //   369: new 88	java/lang/StringBuilder
    //   372: dup
    //   373: ldc_w 272
    //   376: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   379: aload_0
    //   380: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: ldc_w 274
    //   386: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   392: invokestatic 116	com/tencent/mapsdk/internal/kh:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   395: ldc 192
    //   397: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   400: aload 8
    //   402: areturn
    //   403: astore_2
    //   404: aconst_null
    //   405: astore 12
    //   407: aconst_null
    //   408: astore 6
    //   410: aconst_null
    //   411: astore 7
    //   413: aload 7
    //   415: invokestatic 257	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   418: aload 6
    //   420: invokestatic 257	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   423: aload 12
    //   425: ifnull +11 -> 436
    //   428: aload 12
    //   430: getfield 231	com/tencent/map/tools/net/NetResponse:dataStream	Ljava/io/InputStream;
    //   433: invokestatic 257	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   436: ldc 194
    //   438: aload_1
    //   439: ldc_w 259
    //   442: iload_3
    //   443: invokestatic 264	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   446: invokestatic 267	com/tencent/mapsdk/internal/kl:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   449: ldc 194
    //   451: aload_1
    //   452: invokestatic 270	com/tencent/mapsdk/internal/kl:f	(Ljava/lang/String;Ljava/lang/String;)J
    //   455: pop2
    //   456: ldc 194
    //   458: new 88	java/lang/StringBuilder
    //   461: dup
    //   462: ldc_w 272
    //   465: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   468: aload_0
    //   469: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: ldc_w 274
    //   475: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   481: invokestatic 116	com/tencent/mapsdk/internal/kh:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   484: ldc 192
    //   486: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   489: aload_2
    //   490: athrow
    //   491: astore_2
    //   492: aconst_null
    //   493: astore 8
    //   495: aconst_null
    //   496: astore 7
    //   498: aload 6
    //   500: astore 12
    //   502: iload 4
    //   504: istore_3
    //   505: aload 8
    //   507: astore 6
    //   509: goto -96 -> 413
    //   512: astore_2
    //   513: aconst_null
    //   514: astore 7
    //   516: aload 6
    //   518: astore 12
    //   520: aload 7
    //   522: astore 6
    //   524: aload 8
    //   526: astore 7
    //   528: goto -115 -> 413
    //   531: astore_2
    //   532: iload 4
    //   534: istore_3
    //   535: aload 10
    //   537: astore 6
    //   539: aload 9
    //   541: astore 7
    //   543: goto -130 -> 413
    //   546: astore 7
    //   548: aconst_null
    //   549: astore_2
    //   550: aconst_null
    //   551: astore 8
    //   553: aload 6
    //   555: astore 11
    //   557: iload 5
    //   559: istore_3
    //   560: aload 8
    //   562: astore 6
    //   564: goto -332 -> 232
    //   567: astore 7
    //   569: aconst_null
    //   570: astore_2
    //   571: aload 6
    //   573: astore 11
    //   575: aload 8
    //   577: astore 6
    //   579: goto -347 -> 232
    //   582: astore 7
    //   584: aload 6
    //   586: astore 11
    //   588: aload 8
    //   590: astore 6
    //   592: goto -360 -> 232
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	595	0	paramString1	String
    //   0	595	1	paramString2	String
    //   0	595	2	paramFile	File
    //   8	552	3	i	int
    //   61	472	4	j	int
    //   64	494	5	k	int
    //   58	533	6	localObject1	Object
    //   96	8	7	localFile1	File
    //   222	96	7	localException1	Exception
    //   411	131	7	localObject2	Object
    //   546	1	7	localException2	Exception
    //   567	1	7	localException3	Exception
    //   582	1	7	localException4	Exception
    //   83	506	8	localObject3	Object
    //   136	404	9	localObject4	Object
    //   132	404	10	localFile2	File
    //   225	362	11	localObject5	Object
    //   126	393	12	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   45	60	222	java/lang/Exception
    //   45	60	403	finally
    //   66	72	491	finally
    //   78	85	491	finally
    //   85	98	512	finally
    //   103	109	512	finally
    //   109	114	512	finally
    //   114	124	512	finally
    //   138	145	531	finally
    //   246	254	531	finally
    //   268	277	531	finally
    //   291	297	531	finally
    //   311	325	531	finally
    //   66	72	546	java/lang/Exception
    //   78	85	546	java/lang/Exception
    //   85	98	567	java/lang/Exception
    //   103	109	567	java/lang/Exception
    //   109	114	567	java/lang/Exception
    //   114	124	567	java/lang/Exception
    //   138	145	582	java/lang/Exception
  }
  
  private static String a(String paramString)
  {
    AppMethodBeat.i(225549);
    if (paramString.equals("mapconfig"))
    {
      AppMethodBeat.o(225549);
      return "mapconfig.dat";
    }
    if (paramString.equals("indoormap_style"))
    {
      AppMethodBeat.o(225549);
      return "indoor_style.dat";
    }
    if (paramString.equals("indoormap_style_night"))
    {
      AppMethodBeat.o(225549);
      return "indoor_style_night.dat";
    }
    if (paramString.equals("indoorpoi_icon_3d"))
    {
      AppMethodBeat.o(225549);
      return "poi_icon_indoor_ex@2x.png";
    }
    if (paramString.equals("indoorpoi_icon_3d_night"))
    {
      AppMethodBeat.o(225549);
      return "poi_icon_indoor_ex_night@2x.png";
    }
    if (paramString.equals("escalator_night"))
    {
      AppMethodBeat.o(225549);
      return "escalator_night.dat";
    }
    AppMethodBeat.o(225549);
    return paramString;
  }
  
  private List<FileUpdateRsp> a(CSFileUpdateReq paramCSFileUpdateReq)
  {
    AppMethodBeat.i(225502);
    try
    {
      paramCSFileUpdateReq = ((cu)((di)cj.a(di.class)).h()).configFileUpdate(gw.h(), gw.d(), gw.k(), gw.f(), this.f, paramCSFileUpdateReq.toByteArray("UTF-8"));
      if ((paramCSFileUpdateReq == null) || (paramCSFileUpdateReq.data == null))
      {
        localObject = new StringBuilder("rsp = ");
        if (paramCSFileUpdateReq != null) {}
        for (paramCSFileUpdateReq = Integer.valueOf(paramCSFileUpdateReq.statusCode);; paramCSFileUpdateReq = "null")
        {
          kh.c("net", paramCSFileUpdateReq);
          AppMethodBeat.o(225502);
          return null;
        }
      }
      paramCSFileUpdateReq = new m(paramCSFileUpdateReq.data);
      paramCSFileUpdateReq.a("UTF-8");
      Object localObject = new SCFileUpdateRsp();
      ((SCFileUpdateRsp)localObject).readFrom(paramCSFileUpdateReq);
      kh.c("net", "scrsp.iRet = " + ((SCFileUpdateRsp)localObject).iRet);
      if (((SCFileUpdateRsp)localObject).iRet == 0)
      {
        paramCSFileUpdateReq = ((SCFileUpdateRsp)localObject).vItems;
        AppMethodBeat.o(225502);
        return paramCSFileUpdateReq;
      }
      AppMethodBeat.o(225502);
      return null;
    }
    catch (Exception paramCSFileUpdateReq)
    {
      kh.c(Log.getStackTraceString(paramCSFileUpdateReq));
      AppMethodBeat.o(225502);
    }
    return null;
  }
  
  private void a(gm.c paramc)
  {
    AppMethodBeat.i(225560);
    if (this.b != null)
    {
      localObject1 = (pg)this.b.get();
      if (localObject1 != null) {}
    }
    else
    {
      AppMethodBeat.o(225560);
      return;
    }
    Object localObject1 = (List)pg.e.get(((pg)localObject1).a());
    if (localObject1 == null) {}
    for (localObject1 = null; localObject1 == null; localObject1 = (WeakReference[])((List)localObject1).toArray(new WeakReference[((List)localObject1).size()]))
    {
      AppMethodBeat.o(225560);
      return;
    }
    int i = 0;
    while (i < localObject1.length)
    {
      if (localObject1[i] != null)
      {
        Object localObject2 = (bg)localObject1[i].get();
        if ((localObject2 != null) && (((bg)localObject2).b != null) && (((bg)localObject2).b.aB != null))
        {
          localObject2 = ((bg)localObject2).b.aB.d;
          if (localObject2 == null)
          {
            AppMethodBeat.o(225560);
            return;
          }
          paramc.b -= ((gq)localObject2).q();
          ((gq)localObject2).a().a(paramc);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(225560);
  }
  
  private FileUpdateReq b(String paramString)
  {
    AppMethodBeat.i(225569);
    if ((this.c == null) || (this.c.isEmpty()))
    {
      AppMethodBeat.o(225569);
      return null;
    }
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      FileUpdateReq localFileUpdateReq = (FileUpdateReq)localIterator.next();
      if (gz.a(localFileUpdateReq.sName, paramString))
      {
        AppMethodBeat.o(225569);
        return localFileUpdateReq;
      }
    }
    AppMethodBeat.o(225569);
    return null;
  }
  
  public final List<FileUpdateRsp> a(String paramString1, String paramString2, String paramString3, CSFileUpdateReq paramCSFileUpdateReq, pg parampg)
  {
    AppMethodBeat.i(225587);
    this.c = paramCSFileUpdateReq.vItems;
    this.d = paramString1;
    this.e = paramString2;
    this.b = new WeakReference(parampg);
    this.f = paramString3;
    paramString3 = a(paramCSFileUpdateReq);
    kh.c("net", "rspList = ".concat(String.valueOf(paramString3)));
    if ((paramString3 == null) || (paramString3.isEmpty()))
    {
      AppMethodBeat.o(225587);
      return null;
    }
    this.g = paramString3.size();
    paramCSFileUpdateReq = paramString3.iterator();
    while (paramCSFileUpdateReq.hasNext())
    {
      paramString2 = (FileUpdateRsp)paramCSFileUpdateReq.next();
      if ((paramString2 == null) || (paramString2.iRet != 0))
      {
        paramString1 = null;
        label138:
        if (paramString1 == null) {
          break label525;
        }
        paramString3 = b(paramString1.a);
        if (paramString3 == null) {
          break label517;
        }
      }
      label517:
      for (paramString1.e = paramString3.iVersion;; paramString1.e = -1)
      {
        paramString1.b = System.currentTimeMillis();
        a(paramString1);
        kh.c("net", "fileUpdateRsp = ".concat(String.valueOf(paramString2)));
        kh.c("net", "failUpdate = ".concat(String.valueOf(paramString1)));
        AppMethodBeat.o(225587);
        return null;
        paramString1 = paramString2.sName;
        label296:
        int i;
        switch (paramString1.hashCode())
        {
        default: 
          i = -1;
        }
        for (;;)
        {
          switch (i)
          {
          default: 
            paramString1 = null;
            break label138;
            if (!paramString1.equals("mapconfig")) {
              break label296;
            }
            i = 0;
            continue;
            if (!paramString1.equals("indoormap_style")) {
              break label296;
            }
            i = 1;
            continue;
            if (!paramString1.equals("indoormap_style_night")) {
              break label296;
            }
            i = 2;
            continue;
            if (!paramString1.equals("indoorpoi_icon_3d")) {
              break label296;
            }
            i = 3;
            continue;
            if (!paramString1.equals("indoorpoi_icon_3d_night")) {
              break label296;
            }
            i = 4;
            continue;
            if (!paramString1.equals("escalator_night")) {
              break label296;
            }
            i = 5;
            continue;
            if (!paramString1.equals("poi_icon")) {
              break label296;
            }
            i = 6;
            continue;
            if (!paramString1.equals("map_icon")) {
              break label296;
            }
            i = 7;
          }
        }
        paramString1 = a(paramString2, this.d, false);
        break;
        paramString1 = a(paramString2, this.d, true);
        break;
        paramString1 = a(paramString2, this.e, true);
        break;
      }
      label525:
      this.g -= 1;
    }
    if (this.g != 0)
    {
      AppMethodBeat.o(225587);
      return null;
    }
    AppMethodBeat.o(225587);
    return paramString3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.pe
 * JD-Core Version:    0.7.0.1
 */