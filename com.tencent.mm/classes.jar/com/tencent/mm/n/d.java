package com.tencent.mm.n;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
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

public final class d
{
  public static final String gMf;
  public SparseArray<e> gMe;
  
  static
  {
    AppMethodBeat.i(131986);
    gMf = ar.NSe + "configlist/";
    AppMethodBeat.o(131986);
  }
  
  public d()
  {
    AppMethodBeat.i(131970);
    this.gMe = new SparseArray();
    AppMethodBeat.o(131970);
  }
  
  public static int aqw()
  {
    AppMethodBeat.i(131978);
    String str = ((a)g.af(a.class)).aqJ().getValue("VoiceVOIPSwitch");
    Log.d("MicroMsg.ConfigListDecoder", "voip is ".concat(String.valueOf(str)));
    try
    {
      i = Util.getInt(str, 0);
      Log.d("MicroMsg.ConfigListDecoder", "showVoiceVoipEntrance is ".concat(String.valueOf(i)));
      AppMethodBeat.o(131978);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.ConfigListDecoder", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
        int i = 0;
      }
    }
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
      Object localObject4 = new o(oH(paramInt));
      localObject2 = localInputStreamReader;
      localObject1 = localBufferedReader;
      if (((o)localObject4).exists())
      {
        localObject2 = localInputStreamReader;
        localObject1 = localBufferedReader;
        localInputStream = s.ao((o)localObject4);
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
      Log.e("MicroMsg.ConfigListDecoder", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
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
          Log.e("MicroMsg.ConfigListDecoder", "exception:%s", new Object[] { Util.stackTraceToString(localIOException2) });
          AppMethodBeat.o(131977);
          return;
        }
        localObject2 = localException;
        localObject1 = localException;
        y(paramInt, ((StringBuffer)localObject4).toString());
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
            Log.e("MicroMsg.ConfigListDecoder", "exception:%s", new Object[] { Util.stackTraceToString(localIOException1) });
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
          Log.e("MicroMsg.ConfigListDecoder", "exception:%s", new Object[] { Util.stackTraceToString(localIOException3) });
        }
      }
      AppMethodBeat.o(131977);
    }
  }
  
  public static String oH(int paramInt)
  {
    AppMethodBeat.i(131971);
    String str = gMf + "config_" + paramInt + ".xml";
    AppMethodBeat.o(131971);
    return str;
  }
  
  /* Error */
  public final boolean a(o paramo1, o paramo2)
  {
    // Byte code:
    //   0: ldc 182
    //   2: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokevirtual 132	com/tencent/mm/vfs/o:exists	()Z
    //   9: ifeq +434 -> 443
    //   12: aload_1
    //   13: invokevirtual 185	com/tencent/mm/vfs/o:isDirectory	()Z
    //   16: ifeq +91 -> 107
    //   19: aload_2
    //   20: invokevirtual 132	com/tencent/mm/vfs/o:exists	()Z
    //   23: ifne +8 -> 31
    //   26: aload_2
    //   27: invokevirtual 188	com/tencent/mm/vfs/o:mkdirs	()Z
    //   30: pop
    //   31: aload_1
    //   32: invokevirtual 192	com/tencent/mm/vfs/o:het	()[Lcom/tencent/mm/vfs/o;
    //   35: astore 5
    //   37: iconst_0
    //   38: istore_3
    //   39: iconst_0
    //   40: istore 4
    //   42: iload_3
    //   43: aload 5
    //   45: arraylength
    //   46: if_icmpge +53 -> 99
    //   49: aload 5
    //   51: iload_3
    //   52: aaload
    //   53: astore 6
    //   55: aload_0
    //   56: aload 6
    //   58: new 122	com/tencent/mm/vfs/o
    //   61: dup
    //   62: aload_2
    //   63: getfield 196	com/tencent/mm/vfs/o:mUri	Landroid/net/Uri;
    //   66: invokestatic 202	com/tencent/mm/vfs/aa:z	(Landroid/net/Uri;)Ljava/lang/String;
    //   69: aload 6
    //   71: invokevirtual 205	com/tencent/mm/vfs/o:getName	()Ljava/lang/String;
    //   74: invokespecial 207	com/tencent/mm/vfs/o:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   77: invokevirtual 209	com/tencent/mm/n/d:a	(Lcom/tencent/mm/vfs/o;Lcom/tencent/mm/vfs/o;)Z
    //   80: istore 4
    //   82: iload 4
    //   84: ifeq +8 -> 92
    //   87: aload_1
    //   88: invokevirtual 212	com/tencent/mm/vfs/o:delete	()Z
    //   91: pop
    //   92: iload_3
    //   93: iconst_1
    //   94: iadd
    //   95: istore_3
    //   96: goto -54 -> 42
    //   99: ldc 182
    //   101: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   104: iload 4
    //   106: ireturn
    //   107: aload_1
    //   108: invokestatic 138	com/tencent/mm/vfs/s:ao	(Lcom/tencent/mm/vfs/o;)Ljava/io/InputStream;
    //   111: astore 5
    //   113: aload_2
    //   114: invokestatic 216	com/tencent/mm/vfs/s:ap	(Lcom/tencent/mm/vfs/o;)Ljava/io/OutputStream;
    //   117: astore 7
    //   119: aload 7
    //   121: astore 6
    //   123: aload 5
    //   125: astore_2
    //   126: sipush 1024
    //   129: newarray byte
    //   131: astore 8
    //   133: aload 7
    //   135: astore 6
    //   137: aload 5
    //   139: astore_2
    //   140: aload 5
    //   142: aload 8
    //   144: invokevirtual 220	java/io/InputStream:read	([B)I
    //   147: istore_3
    //   148: iload_3
    //   149: iconst_m1
    //   150: if_icmpeq +79 -> 229
    //   153: aload 7
    //   155: astore 6
    //   157: aload 5
    //   159: astore_2
    //   160: aload 7
    //   162: aload 8
    //   164: iconst_0
    //   165: iload_3
    //   166: invokevirtual 226	java/io/OutputStream:write	([BII)V
    //   169: goto -36 -> 133
    //   172: astore_2
    //   173: aload 7
    //   175: astore_1
    //   176: aload_2
    //   177: astore 7
    //   179: aload_1
    //   180: astore 6
    //   182: aload 5
    //   184: astore_2
    //   185: ldc 78
    //   187: ldc 108
    //   189: iconst_1
    //   190: anewarray 4	java/lang/Object
    //   193: dup
    //   194: iconst_0
    //   195: aload 7
    //   197: invokestatic 112	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   200: aastore
    //   201: invokestatic 116	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   204: aload 5
    //   206: ifnull +8 -> 214
    //   209: aload 5
    //   211: invokevirtual 164	java/io/InputStream:close	()V
    //   214: aload_1
    //   215: ifnull +7 -> 222
    //   218: aload_1
    //   219: invokevirtual 227	java/io/OutputStream:close	()V
    //   222: ldc 182
    //   224: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   227: iconst_0
    //   228: ireturn
    //   229: aload 7
    //   231: astore 6
    //   233: aload 5
    //   235: astore_2
    //   236: aload 7
    //   238: invokevirtual 230	java/io/OutputStream:flush	()V
    //   241: aload 7
    //   243: astore 6
    //   245: aload 5
    //   247: astore_2
    //   248: aload_1
    //   249: invokevirtual 212	com/tencent/mm/vfs/o:delete	()Z
    //   252: pop
    //   253: aload 5
    //   255: ifnull +8 -> 263
    //   258: aload 5
    //   260: invokevirtual 164	java/io/InputStream:close	()V
    //   263: aload 7
    //   265: ifnull +8 -> 273
    //   268: aload 7
    //   270: invokevirtual 227	java/io/OutputStream:close	()V
    //   273: ldc 182
    //   275: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   278: iconst_1
    //   279: ireturn
    //   280: astore_1
    //   281: ldc 78
    //   283: ldc 108
    //   285: iconst_1
    //   286: anewarray 4	java/lang/Object
    //   289: dup
    //   290: iconst_0
    //   291: aload_1
    //   292: invokestatic 112	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   295: aastore
    //   296: invokestatic 116	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   299: goto -36 -> 263
    //   302: astore_1
    //   303: ldc 78
    //   305: ldc 108
    //   307: iconst_1
    //   308: anewarray 4	java/lang/Object
    //   311: dup
    //   312: iconst_0
    //   313: aload_1
    //   314: invokestatic 112	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   317: aastore
    //   318: invokestatic 116	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   321: goto -48 -> 273
    //   324: astore_2
    //   325: ldc 78
    //   327: ldc 108
    //   329: iconst_1
    //   330: anewarray 4	java/lang/Object
    //   333: dup
    //   334: iconst_0
    //   335: aload_2
    //   336: invokestatic 112	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   339: aastore
    //   340: invokestatic 116	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   343: goto -129 -> 214
    //   346: astore_1
    //   347: ldc 78
    //   349: ldc 108
    //   351: iconst_1
    //   352: anewarray 4	java/lang/Object
    //   355: dup
    //   356: iconst_0
    //   357: aload_1
    //   358: invokestatic 112	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   361: aastore
    //   362: invokestatic 116	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   365: goto -143 -> 222
    //   368: astore_1
    //   369: aconst_null
    //   370: astore 6
    //   372: aconst_null
    //   373: astore_2
    //   374: aload_2
    //   375: ifnull +7 -> 382
    //   378: aload_2
    //   379: invokevirtual 164	java/io/InputStream:close	()V
    //   382: aload 6
    //   384: ifnull +8 -> 392
    //   387: aload 6
    //   389: invokevirtual 227	java/io/OutputStream:close	()V
    //   392: ldc 182
    //   394: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   397: aload_1
    //   398: athrow
    //   399: astore_2
    //   400: ldc 78
    //   402: ldc 108
    //   404: iconst_1
    //   405: anewarray 4	java/lang/Object
    //   408: dup
    //   409: iconst_0
    //   410: aload_2
    //   411: invokestatic 112	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   414: aastore
    //   415: invokestatic 116	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   418: goto -36 -> 382
    //   421: astore_2
    //   422: ldc 78
    //   424: ldc 108
    //   426: iconst_1
    //   427: anewarray 4	java/lang/Object
    //   430: dup
    //   431: iconst_0
    //   432: aload_2
    //   433: invokestatic 112	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   436: aastore
    //   437: invokestatic 116	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   440: goto -48 -> 392
    //   443: ldc 182
    //   445: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   448: iconst_0
    //   449: ireturn
    //   450: astore_1
    //   451: aconst_null
    //   452: astore 6
    //   454: aload 5
    //   456: astore_2
    //   457: goto -83 -> 374
    //   460: astore_1
    //   461: goto -87 -> 374
    //   464: astore 7
    //   466: aconst_null
    //   467: astore_1
    //   468: aconst_null
    //   469: astore 5
    //   471: goto -292 -> 179
    //   474: astore 7
    //   476: aconst_null
    //   477: astore_1
    //   478: goto -299 -> 179
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	481	0	this	d
    //   0	481	1	paramo1	o
    //   0	481	2	paramo2	o
    //   38	128	3	i	int
    //   40	65	4	bool	boolean
    //   35	435	5	localObject1	Object
    //   53	400	6	localObject2	Object
    //   117	152	7	localObject3	Object
    //   464	1	7	localException1	Exception
    //   474	1	7	localException2	Exception
    //   131	32	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   126	133	172	java/lang/Exception
    //   140	148	172	java/lang/Exception
    //   160	169	172	java/lang/Exception
    //   236	241	172	java/lang/Exception
    //   248	253	172	java/lang/Exception
    //   258	263	280	java/io/IOException
    //   268	273	302	java/io/IOException
    //   209	214	324	java/io/IOException
    //   218	222	346	java/io/IOException
    //   107	113	368	finally
    //   378	382	399	java/io/IOException
    //   387	392	421	java/io/IOException
    //   113	119	450	finally
    //   126	133	460	finally
    //   140	148	460	finally
    //   160	169	460	finally
    //   185	204	460	finally
    //   236	241	460	finally
    //   248	253	460	finally
    //   107	113	464	java/lang/Exception
    //   113	119	474	java/lang/Exception
  }
  
  public final String aj(String paramString1, String paramString2)
  {
    AppMethodBeat.i(131975);
    e locale = aqv();
    if (locale == null)
    {
      AppMethodBeat.o(131975);
      return null;
    }
    if (locale.gMh.containsKey(paramString1))
    {
      paramString1 = (String)((HashMap)locale.gMh.get(paramString1)).get(paramString2);
      AppMethodBeat.o(131975);
      return paramString1;
    }
    AppMethodBeat.o(131975);
    return null;
  }
  
  public final List<String> aqA()
  {
    AppMethodBeat.i(131983);
    Object localObject1 = null;
    Object localObject3 = aj("IBeacon", "Content");
    Object localObject2;
    if (!Util.isNullOrNil((String)localObject3))
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
        Log.e("MicroMsg.ConfigListDecoder", "[oneliang] json parse exception: " + localJSONException.getMessage());
        localObject2 = localArrayList;
      }
    }
    return localObject2;
  }
  
  public final int aqB()
  {
    AppMethodBeat.i(196984);
    int i = Util.getInt(aj("MailApp", "ShowMailAppRecommend"), 0);
    AppMethodBeat.o(196984);
    return i;
  }
  
  public final String aqC()
  {
    AppMethodBeat.i(131984);
    String str = aj("MailApp", "MailAppRedirectUrAndroid");
    AppMethodBeat.o(131984);
    return str;
  }
  
  public final e aqv()
  {
    AppMethodBeat.i(131976);
    if (this.gMe.get(1) == null) {
      load(1);
    }
    e locale = (e)this.gMe.get(1);
    AppMethodBeat.o(131976);
    return locale;
  }
  
  public final boolean aqx()
  {
    boolean bool = true;
    AppMethodBeat.i(131979);
    if (Util.getInt(aj("ShowConfig", "hidePoiOversea"), 1) == 1) {}
    for (;;)
    {
      Log.d("MicroMsg.ConfigListDecoder", "isHidePoiOversea : ".concat(String.valueOf(bool)));
      AppMethodBeat.o(131979);
      return bool;
      bool = false;
    }
  }
  
  public final String aqy()
  {
    AppMethodBeat.i(131981);
    String str = aj("FreeWiFiConfig", "CheckURL");
    Log.d("MicroMsg.ConfigListDecoder", "get check url for free wifi : %s", new Object[] { str });
    AppMethodBeat.o(131981);
    return str;
  }
  
  public final boolean aqz()
  {
    boolean bool = true;
    AppMethodBeat.i(131982);
    if (Util.getInt(aj("ShowConfig", "showRecvTmpMsgBtn"), 0) == 1) {}
    for (;;)
    {
      Log.d("MicroMsg.ConfigListDecoder", "isShowRecvTmpMsgBtn : ".concat(String.valueOf(bool)));
      AppMethodBeat.o(131982);
      return bool;
      bool = false;
    }
  }
  
  public final String getMailAppEnterUlAndroid()
  {
    AppMethodBeat.i(131985);
    String str = aj("MailApp", "MailAppEnterMailAppUrlAndroid");
    AppMethodBeat.o(131985);
    return str;
  }
  
  public final void init()
  {
    AppMethodBeat.i(131973);
    int i = 0;
    while (i < e.gMg.length)
    {
      load(e.gMg[i]);
      i += 1;
    }
    AppMethodBeat.o(131973);
  }
  
  public final void y(int paramInt, String paramString)
  {
    AppMethodBeat.i(131974);
    e locale = new e(paramInt);
    locale.gMi = XmlParser.parseXml(paramString, "ConfigList", null);
    if (locale.gMi.containsKey(".ConfigList.$version")) {
      locale.version = Util.getInt((String)locale.gMi.get(".ConfigList.$version"), 0);
    }
    int i = 0;
    for (;;)
    {
      Object localObject1 = new StringBuilder(".ConfigList.Config");
      String str;
      int j;
      label187:
      Object localObject2;
      label216:
      Object localObject3;
      label256:
      StringBuilder localStringBuilder;
      if (i == 0)
      {
        paramString = "";
        localObject1 = paramString;
        if (locale.gMi.get((String)localObject1 + ".$name") == null) {
          break;
        }
        str = (String)locale.gMi.get((String)localObject1 + ".$name");
        if (str.equalsIgnoreCase("JDWebViewMenu")) {
          break label534;
        }
        j = 0;
        localObject2 = new StringBuilder().append((String)localObject1).append(".Item");
        if (j != 0) {
          break label507;
        }
        paramString = "";
        localObject2 = paramString;
        localObject3 = new StringBuilder().append((String)localObject1).append(".Item");
        if (j != 0) {
          break label516;
        }
        paramString = "";
        localObject3 = paramString + ".$key";
        localStringBuilder = new StringBuilder().append((String)localObject1).append(".Item");
        if (j != 0) {
          break label525;
        }
      }
      label516:
      label525:
      for (paramString = "";; paramString = Integer.valueOf(j))
      {
        paramString = paramString + ".$lang";
        if (!locale.gMi.containsKey(localObject2)) {
          break label534;
        }
        localObject3 = (String)locale.gMi.get(localObject3);
        localObject2 = (String)locale.gMi.get(localObject2);
        paramString = (String)locale.gMi.get(paramString);
        Log.d("MicroMsg.ConfigListInfo", "itemKey " + (String)localObject3 + " itemValue " + (String)localObject2 + " itemLang " + paramString);
        if ((paramString == null) || (e.Ek(paramString)))
        {
          if (!locale.gMh.containsKey(str)) {
            locale.gMh.put(str, new HashMap());
          }
          ((HashMap)locale.gMh.get(str)).put(localObject3, localObject2);
        }
        j += 1;
        break label187;
        paramString = Integer.valueOf(i);
        break;
        label507:
        paramString = Integer.valueOf(j);
        break label216;
        paramString = Integer.valueOf(j);
        break label256;
      }
      label534:
      i += 1;
    }
    this.gMe.put(paramInt, locale);
    AppMethodBeat.o(131974);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.n.d
 * JD-Core Version:    0.7.0.1
 */