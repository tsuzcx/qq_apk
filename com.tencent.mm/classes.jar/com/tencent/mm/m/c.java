package com.tencent.mm.m;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ae;
import com.tencent.mm.vfs.i;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
{
  public static final String fHk;
  public SparseArray<d> fHj;
  
  static
  {
    AppMethodBeat.i(131986);
    fHk = ae.FfH + "configlist/";
    AppMethodBeat.o(131986);
  }
  
  public c()
  {
    AppMethodBeat.i(131970);
    this.fHj = new SparseArray();
    AppMethodBeat.o(131970);
  }
  
  public static int YO()
  {
    AppMethodBeat.i(131978);
    String str = ((a)g.ab(a.class)).Zd().getValue("VoiceVOIPSwitch");
    ad.d("MicroMsg.ConfigListDecoder", "voip is ".concat(String.valueOf(str)));
    try
    {
      i = bt.getInt(str, 0);
      ad.d("MicroMsg.ConfigListDecoder", "showVoiceVoipEntrance is ".concat(String.valueOf(i)));
      AppMethodBeat.o(131978);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.ConfigListDecoder", "exception:%s", new Object[] { bt.m(localException) });
        int i = 0;
      }
    }
  }
  
  public static String lj(int paramInt)
  {
    AppMethodBeat.i(131971);
    String str = fHk + "config_" + paramInt + ".xml";
    AppMethodBeat.o(131971);
    return str;
  }
  
  private void load(int paramInt)
  {
    AppMethodBeat.i(131977);
    InputStream localInputStream = null;
    BufferedReader localBufferedReader = null;
    InputStreamReader localInputStreamReader = null;
    Object localObject2 = localInputStreamReader;
    Object localObject1 = localBufferedReader;
    try
    {
      Object localObject4 = new com.tencent.mm.vfs.e(lj(paramInt));
      localObject2 = localInputStreamReader;
      localObject1 = localBufferedReader;
      if (((com.tencent.mm.vfs.e)localObject4).exists())
      {
        localObject2 = localInputStreamReader;
        localObject1 = localBufferedReader;
        localInputStream = i.ah((com.tencent.mm.vfs.e)localObject4);
        localObject2 = localInputStream;
        localObject1 = localInputStream;
        localInputStreamReader = new InputStreamReader(localInputStream, "utf-8");
        localObject2 = localInputStream;
        localObject1 = localInputStream;
        localBufferedReader = new BufferedReader(localInputStreamReader);
        localObject2 = localInputStream;
        localObject1 = localInputStream;
        localObject4 = new StringBuffer();
        for (;;)
        {
          localObject2 = localInputStream;
          localObject1 = localInputStream;
          String str = localBufferedReader.readLine();
          if (str == null) {
            break;
          }
          localObject2 = localInputStream;
          localObject1 = localInputStream;
          ((StringBuffer)localObject4).append(str);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localObject1 = localObject2;
      ad.e("MicroMsg.ConfigListDecoder", "exception:%s", new Object[] { bt.m(localException) });
      if (localObject2 != null)
      {
        try
        {
          ((InputStream)localObject2).close();
          AppMethodBeat.o(131977);
          return;
        }
        catch (IOException localIOException2)
        {
          ad.e("MicroMsg.ConfigListDecoder", "exception:%s", new Object[] { bt.m(localIOException2) });
          AppMethodBeat.o(131977);
          return;
        }
        localObject2 = localException;
        localObject1 = localException;
        w(paramInt, ((StringBuffer)localObject4).toString());
        localObject2 = localException;
        localObject1 = localException;
        localInputStreamReader.close();
        localObject2 = localException;
        localObject1 = localException;
        localBufferedReader.close();
        if (localException != null) {
          try
          {
            localException.close();
            AppMethodBeat.o(131977);
            return;
          }
          catch (IOException localIOException1)
          {
            ad.e("MicroMsg.ConfigListDecoder", "exception:%s", new Object[] { bt.m(localIOException1) });
            AppMethodBeat.o(131977);
            return;
          }
        }
      }
    }
    finally
    {
      if (localIOException2 != null) {}
      try
      {
        localIOException2.close();
        AppMethodBeat.o(131977);
        throw localObject3;
      }
      catch (IOException localIOException3)
      {
        for (;;)
        {
          ad.e("MicroMsg.ConfigListDecoder", "exception:%s", new Object[] { bt.m(localIOException3) });
        }
      }
      AppMethodBeat.o(131977);
    }
  }
  
  public final d YN()
  {
    AppMethodBeat.i(131976);
    if (this.fHj.get(1) == null) {
      load(1);
    }
    d locald = (d)this.fHj.get(1);
    AppMethodBeat.o(131976);
    return locald;
  }
  
  public final boolean YP()
  {
    boolean bool = true;
    AppMethodBeat.i(131979);
    if (bt.getInt(ad("ShowConfig", "hidePoiOversea"), 1) == 1) {}
    for (;;)
    {
      ad.d("MicroMsg.ConfigListDecoder", "isHidePoiOversea : ".concat(String.valueOf(bool)));
      AppMethodBeat.o(131979);
      return bool;
      bool = false;
    }
  }
  
  public final boolean YQ()
  {
    boolean bool = true;
    AppMethodBeat.i(131980);
    if (bt.getInt(ad("WebViewConfig", "disableWePkg"), 0) == 1) {}
    for (;;)
    {
      ad.d("MicroMsg.ConfigListDecoder", "disableWePkg : ".concat(String.valueOf(bool)));
      AppMethodBeat.o(131980);
      return bool;
      bool = false;
    }
  }
  
  public final String YR()
  {
    AppMethodBeat.i(131981);
    String str = ad("FreeWiFiConfig", "CheckURL");
    ad.d("MicroMsg.ConfigListDecoder", "get check url for free wifi : %s", new Object[] { str });
    AppMethodBeat.o(131981);
    return str;
  }
  
  public final boolean YS()
  {
    boolean bool = true;
    AppMethodBeat.i(131982);
    if (bt.getInt(ad("ShowConfig", "showRecvTmpMsgBtn"), 0) == 1) {}
    for (;;)
    {
      ad.d("MicroMsg.ConfigListDecoder", "isShowRecvTmpMsgBtn : ".concat(String.valueOf(bool)));
      AppMethodBeat.o(131982);
      return bool;
      bool = false;
    }
  }
  
  public final List<String> YT()
  {
    AppMethodBeat.i(131983);
    Object localObject1 = null;
    Object localObject3 = ad("IBeacon", "Content");
    Object localObject2;
    if (!bt.isNullOrNil((String)localObject3))
    {
      ArrayList localArrayList = new ArrayList();
      try
      {
        localObject3 = new JSONObject(((String)localObject3).replace(",}", "}")).keys();
        for (;;)
        {
          localObject1 = localArrayList;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject1 = ((Iterator)localObject3).next();
          if (localObject1 != null) {
            localArrayList.add(localObject1.toString());
          }
        }
        AppMethodBeat.o(131983);
      }
      catch (JSONException localJSONException)
      {
        ad.e("MicroMsg.ConfigListDecoder", "[oneliang] json parse exception: " + localJSONException.getMessage());
        localObject2 = localArrayList;
      }
    }
    return localObject2;
  }
  
  public final String YU()
  {
    AppMethodBeat.i(131984);
    String str = ad("MailApp", "MailAppRedirectUrAndroid");
    AppMethodBeat.o(131984);
    return str;
  }
  
  /* Error */
  public final boolean a(com.tencent.mm.vfs.e parame1, com.tencent.mm.vfs.e parame2)
  {
    // Byte code:
    //   0: ldc_w 295
    //   3: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokevirtual 140	com/tencent/mm/vfs/e:exists	()Z
    //   10: ifeq +438 -> 448
    //   13: aload_1
    //   14: invokevirtual 298	com/tencent/mm/vfs/e:isDirectory	()Z
    //   17: ifeq +92 -> 109
    //   20: aload_2
    //   21: invokevirtual 140	com/tencent/mm/vfs/e:exists	()Z
    //   24: ifne +8 -> 32
    //   27: aload_2
    //   28: invokevirtual 301	com/tencent/mm/vfs/e:mkdirs	()Z
    //   31: pop
    //   32: aload_1
    //   33: invokevirtual 305	com/tencent/mm/vfs/e:fhW	()[Lcom/tencent/mm/vfs/e;
    //   36: astore 5
    //   38: iconst_0
    //   39: istore_3
    //   40: iconst_0
    //   41: istore 4
    //   43: iload_3
    //   44: aload 5
    //   46: arraylength
    //   47: if_icmpge +53 -> 100
    //   50: aload 5
    //   52: iload_3
    //   53: aaload
    //   54: astore 6
    //   56: aload_0
    //   57: aload 6
    //   59: new 131	com/tencent/mm/vfs/e
    //   62: dup
    //   63: aload_2
    //   64: getfield 309	com/tencent/mm/vfs/e:mUri	Landroid/net/Uri;
    //   67: invokestatic 315	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   70: aload 6
    //   72: invokevirtual 318	com/tencent/mm/vfs/e:getName	()Ljava/lang/String;
    //   75: invokespecial 320	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   78: invokevirtual 322	com/tencent/mm/m/c:a	(Lcom/tencent/mm/vfs/e;Lcom/tencent/mm/vfs/e;)Z
    //   81: istore 4
    //   83: iload 4
    //   85: ifeq +8 -> 93
    //   88: aload_1
    //   89: invokevirtual 325	com/tencent/mm/vfs/e:delete	()Z
    //   92: pop
    //   93: iload_3
    //   94: iconst_1
    //   95: iadd
    //   96: istore_3
    //   97: goto -54 -> 43
    //   100: ldc_w 295
    //   103: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   106: iload 4
    //   108: ireturn
    //   109: aload_1
    //   110: invokestatic 146	com/tencent/mm/vfs/i:ah	(Lcom/tencent/mm/vfs/e;)Ljava/io/InputStream;
    //   113: astore 5
    //   115: aload_2
    //   116: invokestatic 329	com/tencent/mm/vfs/i:ai	(Lcom/tencent/mm/vfs/e;)Ljava/io/OutputStream;
    //   119: astore 7
    //   121: aload 7
    //   123: astore 6
    //   125: aload 5
    //   127: astore_2
    //   128: sipush 1024
    //   131: newarray byte
    //   133: astore 8
    //   135: aload 7
    //   137: astore 6
    //   139: aload 5
    //   141: astore_2
    //   142: aload 5
    //   144: aload 8
    //   146: invokevirtual 333	java/io/InputStream:read	([B)I
    //   149: istore_3
    //   150: iload_3
    //   151: iconst_m1
    //   152: if_icmpeq +80 -> 232
    //   155: aload 7
    //   157: astore 6
    //   159: aload 5
    //   161: astore_2
    //   162: aload 7
    //   164: aload 8
    //   166: iconst_0
    //   167: iload_3
    //   168: invokevirtual 339	java/io/OutputStream:write	([BII)V
    //   171: goto -36 -> 135
    //   174: astore_2
    //   175: aload 7
    //   177: astore_1
    //   178: aload_2
    //   179: astore 7
    //   181: aload_1
    //   182: astore 6
    //   184: aload 5
    //   186: astore_2
    //   187: ldc 78
    //   189: ldc 108
    //   191: iconst_1
    //   192: anewarray 4	java/lang/Object
    //   195: dup
    //   196: iconst_0
    //   197: aload 7
    //   199: invokestatic 112	com/tencent/mm/sdk/platformtools/bt:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   202: aastore
    //   203: invokestatic 116	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   206: aload 5
    //   208: ifnull +8 -> 216
    //   211: aload 5
    //   213: invokevirtual 172	java/io/InputStream:close	()V
    //   216: aload_1
    //   217: ifnull +7 -> 224
    //   220: aload_1
    //   221: invokevirtual 340	java/io/OutputStream:close	()V
    //   224: ldc_w 295
    //   227: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   230: iconst_0
    //   231: ireturn
    //   232: aload 7
    //   234: astore 6
    //   236: aload 5
    //   238: astore_2
    //   239: aload 7
    //   241: invokevirtual 343	java/io/OutputStream:flush	()V
    //   244: aload 7
    //   246: astore 6
    //   248: aload 5
    //   250: astore_2
    //   251: aload_1
    //   252: invokevirtual 325	com/tencent/mm/vfs/e:delete	()Z
    //   255: pop
    //   256: aload 5
    //   258: ifnull +8 -> 266
    //   261: aload 5
    //   263: invokevirtual 172	java/io/InputStream:close	()V
    //   266: aload 7
    //   268: ifnull +8 -> 276
    //   271: aload 7
    //   273: invokevirtual 340	java/io/OutputStream:close	()V
    //   276: ldc_w 295
    //   279: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   282: iconst_1
    //   283: ireturn
    //   284: astore_1
    //   285: ldc 78
    //   287: ldc 108
    //   289: iconst_1
    //   290: anewarray 4	java/lang/Object
    //   293: dup
    //   294: iconst_0
    //   295: aload_1
    //   296: invokestatic 112	com/tencent/mm/sdk/platformtools/bt:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   299: aastore
    //   300: invokestatic 116	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   303: goto -37 -> 266
    //   306: astore_1
    //   307: ldc 78
    //   309: ldc 108
    //   311: iconst_1
    //   312: anewarray 4	java/lang/Object
    //   315: dup
    //   316: iconst_0
    //   317: aload_1
    //   318: invokestatic 112	com/tencent/mm/sdk/platformtools/bt:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   321: aastore
    //   322: invokestatic 116	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   325: goto -49 -> 276
    //   328: astore_2
    //   329: ldc 78
    //   331: ldc 108
    //   333: iconst_1
    //   334: anewarray 4	java/lang/Object
    //   337: dup
    //   338: iconst_0
    //   339: aload_2
    //   340: invokestatic 112	com/tencent/mm/sdk/platformtools/bt:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   343: aastore
    //   344: invokestatic 116	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   347: goto -131 -> 216
    //   350: astore_1
    //   351: ldc 78
    //   353: ldc 108
    //   355: iconst_1
    //   356: anewarray 4	java/lang/Object
    //   359: dup
    //   360: iconst_0
    //   361: aload_1
    //   362: invokestatic 112	com/tencent/mm/sdk/platformtools/bt:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   365: aastore
    //   366: invokestatic 116	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   369: goto -145 -> 224
    //   372: astore_1
    //   373: aconst_null
    //   374: astore 6
    //   376: aconst_null
    //   377: astore_2
    //   378: aload_2
    //   379: ifnull +7 -> 386
    //   382: aload_2
    //   383: invokevirtual 172	java/io/InputStream:close	()V
    //   386: aload 6
    //   388: ifnull +8 -> 396
    //   391: aload 6
    //   393: invokevirtual 340	java/io/OutputStream:close	()V
    //   396: ldc_w 295
    //   399: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   402: aload_1
    //   403: athrow
    //   404: astore_2
    //   405: ldc 78
    //   407: ldc 108
    //   409: iconst_1
    //   410: anewarray 4	java/lang/Object
    //   413: dup
    //   414: iconst_0
    //   415: aload_2
    //   416: invokestatic 112	com/tencent/mm/sdk/platformtools/bt:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   419: aastore
    //   420: invokestatic 116	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   423: goto -37 -> 386
    //   426: astore_2
    //   427: ldc 78
    //   429: ldc 108
    //   431: iconst_1
    //   432: anewarray 4	java/lang/Object
    //   435: dup
    //   436: iconst_0
    //   437: aload_2
    //   438: invokestatic 112	com/tencent/mm/sdk/platformtools/bt:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   441: aastore
    //   442: invokestatic 116	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   445: goto -49 -> 396
    //   448: ldc_w 295
    //   451: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   454: iconst_0
    //   455: ireturn
    //   456: astore_1
    //   457: aconst_null
    //   458: astore 6
    //   460: aload 5
    //   462: astore_2
    //   463: goto -85 -> 378
    //   466: astore_1
    //   467: goto -89 -> 378
    //   470: astore 7
    //   472: aconst_null
    //   473: astore_1
    //   474: aconst_null
    //   475: astore 5
    //   477: goto -296 -> 181
    //   480: astore 7
    //   482: aconst_null
    //   483: astore_1
    //   484: goto -303 -> 181
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	487	0	this	c
    //   0	487	1	parame1	com.tencent.mm.vfs.e
    //   0	487	2	parame2	com.tencent.mm.vfs.e
    //   39	129	3	i	int
    //   41	66	4	bool	boolean
    //   36	440	5	localObject1	Object
    //   54	405	6	localObject2	Object
    //   119	153	7	localObject3	Object
    //   470	1	7	localException1	Exception
    //   480	1	7	localException2	Exception
    //   133	32	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   128	135	174	java/lang/Exception
    //   142	150	174	java/lang/Exception
    //   162	171	174	java/lang/Exception
    //   239	244	174	java/lang/Exception
    //   251	256	174	java/lang/Exception
    //   261	266	284	java/io/IOException
    //   271	276	306	java/io/IOException
    //   211	216	328	java/io/IOException
    //   220	224	350	java/io/IOException
    //   109	115	372	finally
    //   382	386	404	java/io/IOException
    //   391	396	426	java/io/IOException
    //   115	121	456	finally
    //   128	135	466	finally
    //   142	150	466	finally
    //   162	171	466	finally
    //   187	206	466	finally
    //   239	244	466	finally
    //   251	256	466	finally
    //   109	115	470	java/lang/Exception
    //   115	121	480	java/lang/Exception
  }
  
  public final String ad(String paramString1, String paramString2)
  {
    AppMethodBeat.i(131975);
    d locald = YN();
    if (locald == null)
    {
      AppMethodBeat.o(131975);
      return null;
    }
    if (locald.fHm.containsKey(paramString1))
    {
      paramString1 = (String)((HashMap)locald.fHm.get(paramString1)).get(paramString2);
      AppMethodBeat.o(131975);
      return paramString1;
    }
    AppMethodBeat.o(131975);
    return null;
  }
  
  public final String getMailAppEnterUlAndroid()
  {
    AppMethodBeat.i(131985);
    String str = ad("MailApp", "MailAppEnterMailAppUrlAndroid");
    AppMethodBeat.o(131985);
    return str;
  }
  
  public final void init()
  {
    AppMethodBeat.i(131973);
    int i = 0;
    while (i < d.fHl.length)
    {
      load(d.fHl[i]);
      i += 1;
    }
    AppMethodBeat.o(131973);
  }
  
  public final void w(int paramInt, String paramString)
  {
    AppMethodBeat.i(131974);
    d locald = new d(paramInt);
    locald.fHn = bw.K(paramString, "ConfigList");
    if (locald.fHn.containsKey(".ConfigList.$version")) {
      locald.version = bt.getInt((String)locald.fHn.get(".ConfigList.$version"), 0);
    }
    int i = 0;
    for (;;)
    {
      Object localObject1 = new StringBuilder(".ConfigList.Config");
      String str;
      int j;
      label186:
      Object localObject2;
      label215:
      Object localObject3;
      label255:
      StringBuilder localStringBuilder;
      if (i == 0)
      {
        paramString = "";
        localObject1 = paramString;
        if (locald.fHn.get((String)localObject1 + ".$name") == null) {
          break;
        }
        str = (String)locald.fHn.get((String)localObject1 + ".$name");
        if (str.equalsIgnoreCase("JDWebViewMenu")) {
          break label533;
        }
        j = 0;
        localObject2 = new StringBuilder().append((String)localObject1).append(".Item");
        if (j != 0) {
          break label506;
        }
        paramString = "";
        localObject2 = paramString;
        localObject3 = new StringBuilder().append((String)localObject1).append(".Item");
        if (j != 0) {
          break label515;
        }
        paramString = "";
        localObject3 = paramString + ".$key";
        localStringBuilder = new StringBuilder().append((String)localObject1).append(".Item");
        if (j != 0) {
          break label524;
        }
      }
      label515:
      label524:
      for (paramString = "";; paramString = Integer.valueOf(j))
      {
        paramString = paramString + ".$lang";
        if (!locald.fHn.containsKey(localObject2)) {
          break label533;
        }
        localObject3 = (String)locald.fHn.get(localObject3);
        localObject2 = (String)locald.fHn.get(localObject2);
        paramString = (String)locald.fHn.get(paramString);
        ad.d("MicroMsg.ConfigListInfo", "itemKey " + (String)localObject3 + " itemValue " + (String)localObject2 + " itemLang " + paramString);
        if ((paramString == null) || (d.pz(paramString)))
        {
          if (!locald.fHm.containsKey(str)) {
            locald.fHm.put(str, new HashMap());
          }
          ((HashMap)locald.fHm.get(str)).put(localObject3, localObject2);
        }
        j += 1;
        break label186;
        paramString = Integer.valueOf(i);
        break;
        label506:
        paramString = Integer.valueOf(j);
        break label215;
        paramString = Integer.valueOf(j);
        break label255;
      }
      label533:
      i += 1;
    }
    this.fHj.put(paramInt, locald);
    AppMethodBeat.o(131974);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.m.c
 * JD-Core Version:    0.7.0.1
 */