package com.tencent.mm.m;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ac;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
{
  public static final String etL;
  public SparseArray<d> etK;
  
  static
  {
    AppMethodBeat.i(57865);
    etL = ac.eQv + "configlist/";
    AppMethodBeat.o(57865);
  }
  
  public c()
  {
    AppMethodBeat.i(57849);
    this.etK = new SparseArray();
    AppMethodBeat.o(57849);
  }
  
  public static int Nb()
  {
    AppMethodBeat.i(57857);
    String str = ((a)g.E(a.class)).Nq().getValue("VoiceVOIPSwitch");
    ab.d("MicroMsg.ConfigListDecoder", "voip is ".concat(String.valueOf(str)));
    try
    {
      i = bo.getInt(str, 0);
      ab.d("MicroMsg.ConfigListDecoder", "showVoiceVoipEntrance is ".concat(String.valueOf(i)));
      AppMethodBeat.o(57857);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.ConfigListDecoder", "exception:%s", new Object[] { bo.l(localException) });
        int i = 0;
      }
    }
  }
  
  public static String iV(int paramInt)
  {
    AppMethodBeat.i(57850);
    String str = etL + "config_" + paramInt + ".xml";
    AppMethodBeat.o(57850);
    return str;
  }
  
  /* Error */
  private void load(int paramInt)
  {
    // Byte code:
    //   0: ldc 129
    //   2: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 131	java/io/File
    //   8: dup
    //   9: iload_1
    //   10: invokestatic 133	com/tencent/mm/m/c:iV	(I)Ljava/lang/String;
    //   13: invokespecial 136	java/io/File:<init>	(Ljava/lang/String;)V
    //   16: astore_2
    //   17: aload_2
    //   18: invokevirtual 140	java/io/File:exists	()Z
    //   21: ifeq +261 -> 282
    //   24: new 142	java/io/FileInputStream
    //   27: dup
    //   28: aload_2
    //   29: invokespecial 145	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   32: astore_3
    //   33: aload_3
    //   34: astore_2
    //   35: new 147	java/io/InputStreamReader
    //   38: dup
    //   39: aload_3
    //   40: ldc 149
    //   42: invokespecial 152	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   45: astore 4
    //   47: aload_3
    //   48: astore_2
    //   49: new 154	java/io/BufferedReader
    //   52: dup
    //   53: aload 4
    //   55: invokespecial 157	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   58: astore 5
    //   60: aload_3
    //   61: astore_2
    //   62: new 159	java/lang/StringBuffer
    //   65: dup
    //   66: invokespecial 160	java/lang/StringBuffer:<init>	()V
    //   69: astore 6
    //   71: aload_3
    //   72: astore_2
    //   73: aload 5
    //   75: invokevirtual 163	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   78: astore 7
    //   80: aload 7
    //   82: ifnull +53 -> 135
    //   85: aload_3
    //   86: astore_2
    //   87: aload 6
    //   89: aload 7
    //   91: invokevirtual 166	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   94: pop
    //   95: goto -24 -> 71
    //   98: astore 4
    //   100: aload_3
    //   101: astore_2
    //   102: ldc 78
    //   104: ldc 108
    //   106: iconst_1
    //   107: anewarray 4	java/lang/Object
    //   110: dup
    //   111: iconst_0
    //   112: aload 4
    //   114: invokestatic 112	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   117: aastore
    //   118: invokestatic 116	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   121: aload_3
    //   122: ifnull +143 -> 265
    //   125: aload_3
    //   126: invokevirtual 171	java/io/InputStream:close	()V
    //   129: ldc 129
    //   131: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   134: return
    //   135: aload_3
    //   136: astore_2
    //   137: aload_0
    //   138: iload_1
    //   139: aload 6
    //   141: invokevirtual 172	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   144: invokevirtual 176	com/tencent/mm/m/c:r	(ILjava/lang/String;)V
    //   147: aload_3
    //   148: astore_2
    //   149: aload 4
    //   151: invokevirtual 177	java/io/InputStreamReader:close	()V
    //   154: aload_3
    //   155: astore_2
    //   156: aload 5
    //   158: invokevirtual 178	java/io/BufferedReader:close	()V
    //   161: aload_3
    //   162: ifnull +103 -> 265
    //   165: aload_3
    //   166: invokevirtual 171	java/io/InputStream:close	()V
    //   169: ldc 129
    //   171: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   174: return
    //   175: astore_2
    //   176: ldc 78
    //   178: ldc 108
    //   180: iconst_1
    //   181: anewarray 4	java/lang/Object
    //   184: dup
    //   185: iconst_0
    //   186: aload_2
    //   187: invokestatic 112	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   190: aastore
    //   191: invokestatic 116	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   194: ldc 129
    //   196: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   199: return
    //   200: astore_2
    //   201: ldc 78
    //   203: ldc 108
    //   205: iconst_1
    //   206: anewarray 4	java/lang/Object
    //   209: dup
    //   210: iconst_0
    //   211: aload_2
    //   212: invokestatic 112	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   215: aastore
    //   216: invokestatic 116	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   219: ldc 129
    //   221: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   224: return
    //   225: astore_3
    //   226: aconst_null
    //   227: astore_2
    //   228: aload_2
    //   229: ifnull +7 -> 236
    //   232: aload_2
    //   233: invokevirtual 171	java/io/InputStream:close	()V
    //   236: ldc 129
    //   238: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   241: aload_3
    //   242: athrow
    //   243: astore_2
    //   244: ldc 78
    //   246: ldc 108
    //   248: iconst_1
    //   249: anewarray 4	java/lang/Object
    //   252: dup
    //   253: iconst_0
    //   254: aload_2
    //   255: invokestatic 112	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   258: aastore
    //   259: invokestatic 116	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   262: goto -26 -> 236
    //   265: ldc 129
    //   267: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   270: return
    //   271: astore_3
    //   272: goto -44 -> 228
    //   275: astore 4
    //   277: aconst_null
    //   278: astore_3
    //   279: goto -179 -> 100
    //   282: aconst_null
    //   283: astore_3
    //   284: goto -123 -> 161
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	287	0	this	c
    //   0	287	1	paramInt	int
    //   16	140	2	localObject1	Object
    //   175	12	2	localIOException1	java.io.IOException
    //   200	12	2	localIOException2	java.io.IOException
    //   227	6	2	localObject2	Object
    //   243	12	2	localIOException3	java.io.IOException
    //   32	134	3	localFileInputStream	java.io.FileInputStream
    //   225	17	3	localObject3	Object
    //   271	1	3	localObject4	Object
    //   278	6	3	localObject5	Object
    //   45	9	4	localInputStreamReader	java.io.InputStreamReader
    //   98	52	4	localException1	Exception
    //   275	1	4	localException2	Exception
    //   58	99	5	localBufferedReader	java.io.BufferedReader
    //   69	71	6	localStringBuffer	java.lang.StringBuffer
    //   78	12	7	str	String
    // Exception table:
    //   from	to	target	type
    //   35	47	98	java/lang/Exception
    //   49	60	98	java/lang/Exception
    //   62	71	98	java/lang/Exception
    //   73	80	98	java/lang/Exception
    //   87	95	98	java/lang/Exception
    //   137	147	98	java/lang/Exception
    //   149	154	98	java/lang/Exception
    //   156	161	98	java/lang/Exception
    //   165	169	175	java/io/IOException
    //   125	129	200	java/io/IOException
    //   5	33	225	finally
    //   232	236	243	java/io/IOException
    //   35	47	271	finally
    //   49	60	271	finally
    //   62	71	271	finally
    //   73	80	271	finally
    //   87	95	271	finally
    //   102	121	271	finally
    //   137	147	271	finally
    //   149	154	271	finally
    //   156	161	271	finally
    //   5	33	275	java/lang/Exception
  }
  
  public final d Na()
  {
    AppMethodBeat.i(57855);
    if (this.etK.get(1) == null) {
      load(1);
    }
    d locald = (d)this.etK.get(1);
    AppMethodBeat.o(57855);
    return locald;
  }
  
  public final boolean Nc()
  {
    boolean bool = true;
    AppMethodBeat.i(57858);
    if (bo.getInt(R("ShowConfig", "hidePoiOversea"), 1) == 1) {}
    for (;;)
    {
      ab.d("MicroMsg.ConfigListDecoder", "isHidePoiOversea : ".concat(String.valueOf(bool)));
      AppMethodBeat.o(57858);
      return bool;
      bool = false;
    }
  }
  
  public final boolean Nd()
  {
    boolean bool = true;
    AppMethodBeat.i(57859);
    if (bo.getInt(R("WebViewConfig", "disableWePkg"), 0) == 1) {}
    for (;;)
    {
      ab.d("MicroMsg.ConfigListDecoder", "disableWePkg : ".concat(String.valueOf(bool)));
      AppMethodBeat.o(57859);
      return bool;
      bool = false;
    }
  }
  
  public final String Ne()
  {
    AppMethodBeat.i(57860);
    String str = R("FreeWiFiConfig", "CheckURL");
    ab.d("MicroMsg.ConfigListDecoder", "get check url for free wifi : %s", new Object[] { str });
    AppMethodBeat.o(57860);
    return str;
  }
  
  public final boolean Nf()
  {
    boolean bool = true;
    AppMethodBeat.i(57861);
    if (bo.getInt(R("ShowConfig", "showRecvTmpMsgBtn"), 0) == 1) {}
    for (;;)
    {
      ab.d("MicroMsg.ConfigListDecoder", "isShowRecvTmpMsgBtn : ".concat(String.valueOf(bool)));
      AppMethodBeat.o(57861);
      return bool;
      bool = false;
    }
  }
  
  public final List<String> Ng()
  {
    AppMethodBeat.i(57862);
    Object localObject1 = null;
    Object localObject3 = R("IBeacon", "Content");
    Object localObject2;
    if (!bo.isNullOrNil((String)localObject3))
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
        AppMethodBeat.o(57862);
      }
      catch (JSONException localJSONException)
      {
        ab.e("MicroMsg.ConfigListDecoder", "[oneliang] json parse exception: " + localJSONException.getMessage());
        localObject2 = localArrayList;
      }
    }
    return localObject2;
  }
  
  public final String Nh()
  {
    AppMethodBeat.i(57863);
    String str = R("MailApp", "MailAppRedirectUrAndroid");
    AppMethodBeat.o(57863);
    return str;
  }
  
  public final String R(String paramString1, String paramString2)
  {
    AppMethodBeat.i(57854);
    d locald = Na();
    if (locald == null)
    {
      AppMethodBeat.o(57854);
      return null;
    }
    if (locald.etN.containsKey(paramString1))
    {
      paramString1 = (String)((HashMap)locald.etN.get(paramString1)).get(paramString2);
      AppMethodBeat.o(57854);
      return paramString1;
    }
    AppMethodBeat.o(57854);
    return null;
  }
  
  /* Error */
  public final boolean d(java.io.File paramFile1, java.io.File paramFile2)
  {
    // Byte code:
    //   0: ldc_w 308
    //   3: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokevirtual 140	java/io/File:exists	()Z
    //   10: ifeq +433 -> 443
    //   13: aload_1
    //   14: invokevirtual 311	java/io/File:isDirectory	()Z
    //   17: ifeq +89 -> 106
    //   20: aload_2
    //   21: invokevirtual 140	java/io/File:exists	()Z
    //   24: ifne +8 -> 32
    //   27: aload_2
    //   28: invokevirtual 314	java/io/File:mkdir	()Z
    //   31: pop
    //   32: aload_1
    //   33: invokevirtual 318	java/io/File:listFiles	()[Ljava/io/File;
    //   36: astore 5
    //   38: iconst_0
    //   39: istore_3
    //   40: iconst_0
    //   41: istore 4
    //   43: iload_3
    //   44: aload 5
    //   46: arraylength
    //   47: if_icmpge +50 -> 97
    //   50: aload 5
    //   52: iload_3
    //   53: aaload
    //   54: astore 6
    //   56: aload_0
    //   57: aload 6
    //   59: new 131	java/io/File
    //   62: dup
    //   63: aload_2
    //   64: invokevirtual 321	java/io/File:getPath	()Ljava/lang/String;
    //   67: aload 6
    //   69: invokevirtual 324	java/io/File:getName	()Ljava/lang/String;
    //   72: invokespecial 326	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   75: invokevirtual 328	com/tencent/mm/m/c:d	(Ljava/io/File;Ljava/io/File;)Z
    //   78: istore 4
    //   80: iload 4
    //   82: ifeq +8 -> 90
    //   85: aload_1
    //   86: invokevirtual 331	java/io/File:delete	()Z
    //   89: pop
    //   90: iload_3
    //   91: iconst_1
    //   92: iadd
    //   93: istore_3
    //   94: goto -51 -> 43
    //   97: ldc_w 308
    //   100: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   103: iload 4
    //   105: ireturn
    //   106: new 142	java/io/FileInputStream
    //   109: dup
    //   110: aload_1
    //   111: invokespecial 145	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   114: astore 5
    //   116: new 333	java/io/FileOutputStream
    //   119: dup
    //   120: aload_2
    //   121: invokespecial 334	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   124: astore 7
    //   126: aload 7
    //   128: astore 6
    //   130: aload 5
    //   132: astore_2
    //   133: sipush 1024
    //   136: newarray byte
    //   138: astore 8
    //   140: aload 7
    //   142: astore 6
    //   144: aload 5
    //   146: astore_2
    //   147: aload 5
    //   149: aload 8
    //   151: invokevirtual 338	java/io/InputStream:read	([B)I
    //   154: istore_3
    //   155: iload_3
    //   156: iconst_m1
    //   157: if_icmpeq +80 -> 237
    //   160: aload 7
    //   162: astore 6
    //   164: aload 5
    //   166: astore_2
    //   167: aload 7
    //   169: aload 8
    //   171: iconst_0
    //   172: iload_3
    //   173: invokevirtual 344	java/io/OutputStream:write	([BII)V
    //   176: goto -36 -> 140
    //   179: astore_2
    //   180: aload 7
    //   182: astore_1
    //   183: aload_2
    //   184: astore 7
    //   186: aload_1
    //   187: astore 6
    //   189: aload 5
    //   191: astore_2
    //   192: ldc 78
    //   194: ldc 108
    //   196: iconst_1
    //   197: anewarray 4	java/lang/Object
    //   200: dup
    //   201: iconst_0
    //   202: aload 7
    //   204: invokestatic 112	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   207: aastore
    //   208: invokestatic 116	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   211: aload 5
    //   213: ifnull +8 -> 221
    //   216: aload 5
    //   218: invokevirtual 171	java/io/InputStream:close	()V
    //   221: aload_1
    //   222: ifnull +7 -> 229
    //   225: aload_1
    //   226: invokevirtual 345	java/io/OutputStream:close	()V
    //   229: ldc_w 308
    //   232: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   235: iconst_0
    //   236: ireturn
    //   237: aload 7
    //   239: astore 6
    //   241: aload 5
    //   243: astore_2
    //   244: aload 7
    //   246: invokevirtual 348	java/io/OutputStream:flush	()V
    //   249: aload 7
    //   251: astore 6
    //   253: aload 5
    //   255: astore_2
    //   256: aload_1
    //   257: invokevirtual 331	java/io/File:delete	()Z
    //   260: pop
    //   261: aload 5
    //   263: invokevirtual 171	java/io/InputStream:close	()V
    //   266: aload 7
    //   268: invokevirtual 345	java/io/OutputStream:close	()V
    //   271: ldc_w 308
    //   274: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   277: iconst_1
    //   278: ireturn
    //   279: astore_1
    //   280: ldc 78
    //   282: ldc 108
    //   284: iconst_1
    //   285: anewarray 4	java/lang/Object
    //   288: dup
    //   289: iconst_0
    //   290: aload_1
    //   291: invokestatic 112	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   294: aastore
    //   295: invokestatic 116	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   298: goto -32 -> 266
    //   301: astore_1
    //   302: ldc 78
    //   304: ldc 108
    //   306: iconst_1
    //   307: anewarray 4	java/lang/Object
    //   310: dup
    //   311: iconst_0
    //   312: aload_1
    //   313: invokestatic 112	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   316: aastore
    //   317: invokestatic 116	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   320: goto -49 -> 271
    //   323: astore_2
    //   324: ldc 78
    //   326: ldc 108
    //   328: iconst_1
    //   329: anewarray 4	java/lang/Object
    //   332: dup
    //   333: iconst_0
    //   334: aload_2
    //   335: invokestatic 112	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   338: aastore
    //   339: invokestatic 116	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   342: goto -121 -> 221
    //   345: astore_1
    //   346: ldc 78
    //   348: ldc 108
    //   350: iconst_1
    //   351: anewarray 4	java/lang/Object
    //   354: dup
    //   355: iconst_0
    //   356: aload_1
    //   357: invokestatic 112	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   360: aastore
    //   361: invokestatic 116	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   364: goto -135 -> 229
    //   367: astore_1
    //   368: aconst_null
    //   369: astore 6
    //   371: aconst_null
    //   372: astore_2
    //   373: aload_2
    //   374: ifnull +7 -> 381
    //   377: aload_2
    //   378: invokevirtual 171	java/io/InputStream:close	()V
    //   381: aload 6
    //   383: ifnull +8 -> 391
    //   386: aload 6
    //   388: invokevirtual 345	java/io/OutputStream:close	()V
    //   391: ldc_w 308
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
    //   411: invokestatic 112	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   414: aastore
    //   415: invokestatic 116	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   418: goto -37 -> 381
    //   421: astore_2
    //   422: ldc 78
    //   424: ldc 108
    //   426: iconst_1
    //   427: anewarray 4	java/lang/Object
    //   430: dup
    //   431: iconst_0
    //   432: aload_2
    //   433: invokestatic 112	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   436: aastore
    //   437: invokestatic 116	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   440: goto -49 -> 391
    //   443: ldc_w 308
    //   446: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   449: iconst_0
    //   450: ireturn
    //   451: astore_1
    //   452: aconst_null
    //   453: astore 6
    //   455: aload 5
    //   457: astore_2
    //   458: goto -85 -> 373
    //   461: astore_1
    //   462: goto -89 -> 373
    //   465: astore 7
    //   467: aconst_null
    //   468: astore_1
    //   469: aconst_null
    //   470: astore 5
    //   472: goto -286 -> 186
    //   475: astore 7
    //   477: aconst_null
    //   478: astore_1
    //   479: goto -293 -> 186
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	482	0	this	c
    //   0	482	1	paramFile1	java.io.File
    //   0	482	2	paramFile2	java.io.File
    //   39	134	3	i	int
    //   41	63	4	bool	boolean
    //   36	435	5	localObject1	Object
    //   54	400	6	localObject2	Object
    //   124	143	7	localObject3	Object
    //   465	1	7	localException1	Exception
    //   475	1	7	localException2	Exception
    //   138	32	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   133	140	179	java/lang/Exception
    //   147	155	179	java/lang/Exception
    //   167	176	179	java/lang/Exception
    //   244	249	179	java/lang/Exception
    //   256	261	179	java/lang/Exception
    //   261	266	279	java/io/IOException
    //   266	271	301	java/io/IOException
    //   216	221	323	java/io/IOException
    //   225	229	345	java/io/IOException
    //   106	116	367	finally
    //   377	381	399	java/io/IOException
    //   386	391	421	java/io/IOException
    //   116	126	451	finally
    //   133	140	461	finally
    //   147	155	461	finally
    //   167	176	461	finally
    //   192	211	461	finally
    //   244	249	461	finally
    //   256	261	461	finally
    //   106	116	465	java/lang/Exception
    //   116	126	475	java/lang/Exception
  }
  
  public final String getMailAppEnterUlAndroid()
  {
    AppMethodBeat.i(57864);
    String str = R("MailApp", "MailAppEnterMailAppUrlAndroid");
    AppMethodBeat.o(57864);
    return str;
  }
  
  public final void init()
  {
    AppMethodBeat.i(57852);
    int i = 0;
    while (i < d.etM.length)
    {
      load(d.etM[i]);
      i += 1;
    }
    AppMethodBeat.o(57852);
  }
  
  public final void r(int paramInt, String paramString)
  {
    AppMethodBeat.i(57853);
    d locald = new d(paramInt);
    locald.etO = br.F(paramString, "ConfigList");
    if (locald.etO.containsKey(".ConfigList.$version")) {
      locald.version = Integer.valueOf((String)locald.etO.get(".ConfigList.$version")).intValue();
    }
    int i = 0;
    for (;;)
    {
      Object localObject1 = new StringBuilder(".ConfigList.Config");
      String str;
      int j;
      label188:
      Object localObject2;
      label217:
      Object localObject3;
      label257:
      StringBuilder localStringBuilder;
      if (i == 0)
      {
        paramString = "";
        localObject1 = paramString;
        if (locald.etO.get((String)localObject1 + ".$name") == null) {
          break;
        }
        str = (String)locald.etO.get((String)localObject1 + ".$name");
        if (str.equalsIgnoreCase("JDWebViewMenu")) {
          break label535;
        }
        j = 0;
        localObject2 = new StringBuilder().append((String)localObject1).append(".Item");
        if (j != 0) {
          break label508;
        }
        paramString = "";
        localObject2 = paramString;
        localObject3 = new StringBuilder().append((String)localObject1).append(".Item");
        if (j != 0) {
          break label517;
        }
        paramString = "";
        localObject3 = paramString + ".$key";
        localStringBuilder = new StringBuilder().append((String)localObject1).append(".Item");
        if (j != 0) {
          break label526;
        }
      }
      label517:
      label526:
      for (paramString = "";; paramString = Integer.valueOf(j))
      {
        paramString = paramString + ".$lang";
        if (!locald.etO.containsKey(localObject2)) {
          break label535;
        }
        localObject3 = (String)locald.etO.get(localObject3);
        localObject2 = (String)locald.etO.get(localObject2);
        paramString = (String)locald.etO.get(paramString);
        ab.d("MicroMsg.ConfigListInfo", "itemKey " + (String)localObject3 + " itemValue " + (String)localObject2 + " itemLang " + paramString);
        if ((paramString == null) || (d.lu(paramString)))
        {
          if (!locald.etN.containsKey(str)) {
            locald.etN.put(str, new HashMap());
          }
          ((HashMap)locald.etN.get(str)).put(localObject3, localObject2);
        }
        j += 1;
        break label188;
        paramString = Integer.valueOf(i);
        break;
        label508:
        paramString = Integer.valueOf(j);
        break label217;
        paramString = Integer.valueOf(j);
        break label257;
      }
      label535:
      i += 1;
    }
    this.etK.put(paramInt, locald);
    AppMethodBeat.o(57853);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.m.c
 * JD-Core Version:    0.7.0.1
 */