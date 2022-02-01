package com.tencent.mm.n;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
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
  public static final String jwu;
  public SparseArray<e> jwt;
  
  static
  {
    AppMethodBeat.i(131986);
    jwu = ar.Vgb + "configlist/";
    AppMethodBeat.o(131986);
  }
  
  public d()
  {
    AppMethodBeat.i(131970);
    this.jwt = new SparseArray();
    AppMethodBeat.o(131970);
  }
  
  public static int awQ()
  {
    AppMethodBeat.i(131978);
    String str = ((a)h.ae(a.class)).axc().getValue("VoiceVOIPSwitch");
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
  
  public static String qZ(int paramInt)
  {
    AppMethodBeat.i(131971);
    String str = jwu + "config_" + paramInt + ".xml";
    AppMethodBeat.o(131971);
    return str;
  }
  
  private void ra(int paramInt)
  {
    AppMethodBeat.i(131977);
    InputStream localInputStream = null;
    BufferedReader localBufferedReader = null;
    InputStreamReader localInputStreamReader = null;
    Object localObject2 = localInputStreamReader;
    Object localObject1 = localBufferedReader;
    try
    {
      Object localObject4 = new q(qZ(paramInt));
      localObject2 = localInputStreamReader;
      localObject1 = localBufferedReader;
      if (((q)localObject4).ifE())
      {
        localObject2 = localInputStreamReader;
        localObject1 = localBufferedReader;
        localInputStream = u.al((q)localObject4);
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
        z(paramInt, ((StringBuffer)localObject4).toString());
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
  
  /* Error */
  public final boolean a(q paramq1, q paramq2)
  {
    // Byte code:
    //   0: ldc 182
    //   2: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokevirtual 140	com/tencent/mm/vfs/q:ifE	()Z
    //   9: ifeq +431 -> 440
    //   12: aload_1
    //   13: invokevirtual 185	com/tencent/mm/vfs/q:isDirectory	()Z
    //   16: ifeq +88 -> 104
    //   19: aload_2
    //   20: invokevirtual 140	com/tencent/mm/vfs/q:ifE	()Z
    //   23: ifne +8 -> 31
    //   26: aload_2
    //   27: invokevirtual 188	com/tencent/mm/vfs/q:ifK	()Z
    //   30: pop
    //   31: aload_1
    //   32: invokevirtual 192	com/tencent/mm/vfs/q:ifJ	()[Lcom/tencent/mm/vfs/q;
    //   35: astore 5
    //   37: iconst_0
    //   38: istore_3
    //   39: iconst_0
    //   40: istore 4
    //   42: iload_3
    //   43: aload 5
    //   45: arraylength
    //   46: if_icmpge +50 -> 96
    //   49: aload 5
    //   51: iload_3
    //   52: aaload
    //   53: astore 6
    //   55: aload_0
    //   56: aload 6
    //   58: new 131	com/tencent/mm/vfs/q
    //   61: dup
    //   62: aload_2
    //   63: invokevirtual 195	com/tencent/mm/vfs/q:getPath	()Ljava/lang/String;
    //   66: aload 6
    //   68: invokevirtual 198	com/tencent/mm/vfs/q:getName	()Ljava/lang/String;
    //   71: invokespecial 200	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   74: invokevirtual 202	com/tencent/mm/n/d:a	(Lcom/tencent/mm/vfs/q;Lcom/tencent/mm/vfs/q;)Z
    //   77: istore 4
    //   79: iload 4
    //   81: ifeq +8 -> 89
    //   84: aload_1
    //   85: invokevirtual 205	com/tencent/mm/vfs/q:cFq	()Z
    //   88: pop
    //   89: iload_3
    //   90: iconst_1
    //   91: iadd
    //   92: istore_3
    //   93: goto -51 -> 42
    //   96: ldc 182
    //   98: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   101: iload 4
    //   103: ireturn
    //   104: aload_1
    //   105: invokestatic 146	com/tencent/mm/vfs/u:al	(Lcom/tencent/mm/vfs/q;)Ljava/io/InputStream;
    //   108: astore 5
    //   110: aload_2
    //   111: invokestatic 209	com/tencent/mm/vfs/u:an	(Lcom/tencent/mm/vfs/q;)Ljava/io/OutputStream;
    //   114: astore 7
    //   116: aload 7
    //   118: astore 6
    //   120: aload 5
    //   122: astore_2
    //   123: sipush 1024
    //   126: newarray byte
    //   128: astore 8
    //   130: aload 7
    //   132: astore 6
    //   134: aload 5
    //   136: astore_2
    //   137: aload 5
    //   139: aload 8
    //   141: invokevirtual 213	java/io/InputStream:read	([B)I
    //   144: istore_3
    //   145: iload_3
    //   146: iconst_m1
    //   147: if_icmpeq +79 -> 226
    //   150: aload 7
    //   152: astore 6
    //   154: aload 5
    //   156: astore_2
    //   157: aload 7
    //   159: aload 8
    //   161: iconst_0
    //   162: iload_3
    //   163: invokevirtual 219	java/io/OutputStream:write	([BII)V
    //   166: goto -36 -> 130
    //   169: astore_2
    //   170: aload 7
    //   172: astore_1
    //   173: aload_2
    //   174: astore 7
    //   176: aload_1
    //   177: astore 6
    //   179: aload 5
    //   181: astore_2
    //   182: ldc 78
    //   184: ldc 108
    //   186: iconst_1
    //   187: anewarray 4	java/lang/Object
    //   190: dup
    //   191: iconst_0
    //   192: aload 7
    //   194: invokestatic 112	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   197: aastore
    //   198: invokestatic 116	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   201: aload 5
    //   203: ifnull +8 -> 211
    //   206: aload 5
    //   208: invokevirtual 172	java/io/InputStream:close	()V
    //   211: aload_1
    //   212: ifnull +7 -> 219
    //   215: aload_1
    //   216: invokevirtual 220	java/io/OutputStream:close	()V
    //   219: ldc 182
    //   221: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   224: iconst_0
    //   225: ireturn
    //   226: aload 7
    //   228: astore 6
    //   230: aload 5
    //   232: astore_2
    //   233: aload 7
    //   235: invokevirtual 223	java/io/OutputStream:flush	()V
    //   238: aload 7
    //   240: astore 6
    //   242: aload 5
    //   244: astore_2
    //   245: aload_1
    //   246: invokevirtual 205	com/tencent/mm/vfs/q:cFq	()Z
    //   249: pop
    //   250: aload 5
    //   252: ifnull +8 -> 260
    //   255: aload 5
    //   257: invokevirtual 172	java/io/InputStream:close	()V
    //   260: aload 7
    //   262: ifnull +8 -> 270
    //   265: aload 7
    //   267: invokevirtual 220	java/io/OutputStream:close	()V
    //   270: ldc 182
    //   272: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   275: iconst_1
    //   276: ireturn
    //   277: astore_1
    //   278: ldc 78
    //   280: ldc 108
    //   282: iconst_1
    //   283: anewarray 4	java/lang/Object
    //   286: dup
    //   287: iconst_0
    //   288: aload_1
    //   289: invokestatic 112	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   292: aastore
    //   293: invokestatic 116	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   296: goto -36 -> 260
    //   299: astore_1
    //   300: ldc 78
    //   302: ldc 108
    //   304: iconst_1
    //   305: anewarray 4	java/lang/Object
    //   308: dup
    //   309: iconst_0
    //   310: aload_1
    //   311: invokestatic 112	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   314: aastore
    //   315: invokestatic 116	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   318: goto -48 -> 270
    //   321: astore_2
    //   322: ldc 78
    //   324: ldc 108
    //   326: iconst_1
    //   327: anewarray 4	java/lang/Object
    //   330: dup
    //   331: iconst_0
    //   332: aload_2
    //   333: invokestatic 112	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   336: aastore
    //   337: invokestatic 116	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   340: goto -129 -> 211
    //   343: astore_1
    //   344: ldc 78
    //   346: ldc 108
    //   348: iconst_1
    //   349: anewarray 4	java/lang/Object
    //   352: dup
    //   353: iconst_0
    //   354: aload_1
    //   355: invokestatic 112	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   358: aastore
    //   359: invokestatic 116	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   362: goto -143 -> 219
    //   365: astore_1
    //   366: aconst_null
    //   367: astore 6
    //   369: aconst_null
    //   370: astore_2
    //   371: aload_2
    //   372: ifnull +7 -> 379
    //   375: aload_2
    //   376: invokevirtual 172	java/io/InputStream:close	()V
    //   379: aload 6
    //   381: ifnull +8 -> 389
    //   384: aload 6
    //   386: invokevirtual 220	java/io/OutputStream:close	()V
    //   389: ldc 182
    //   391: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   394: aload_1
    //   395: athrow
    //   396: astore_2
    //   397: ldc 78
    //   399: ldc 108
    //   401: iconst_1
    //   402: anewarray 4	java/lang/Object
    //   405: dup
    //   406: iconst_0
    //   407: aload_2
    //   408: invokestatic 112	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   411: aastore
    //   412: invokestatic 116	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   415: goto -36 -> 379
    //   418: astore_2
    //   419: ldc 78
    //   421: ldc 108
    //   423: iconst_1
    //   424: anewarray 4	java/lang/Object
    //   427: dup
    //   428: iconst_0
    //   429: aload_2
    //   430: invokestatic 112	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   433: aastore
    //   434: invokestatic 116	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   437: goto -48 -> 389
    //   440: ldc 182
    //   442: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   445: iconst_0
    //   446: ireturn
    //   447: astore_1
    //   448: aconst_null
    //   449: astore 6
    //   451: aload 5
    //   453: astore_2
    //   454: goto -83 -> 371
    //   457: astore_1
    //   458: goto -87 -> 371
    //   461: astore 7
    //   463: aconst_null
    //   464: astore_1
    //   465: aconst_null
    //   466: astore 5
    //   468: goto -292 -> 176
    //   471: astore 7
    //   473: aconst_null
    //   474: astore_1
    //   475: goto -299 -> 176
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	478	0	this	d
    //   0	478	1	paramq1	q
    //   0	478	2	paramq2	q
    //   38	125	3	i	int
    //   40	62	4	bool	boolean
    //   35	432	5	localObject1	Object
    //   53	397	6	localObject2	Object
    //   114	152	7	localObject3	Object
    //   461	1	7	localException1	Exception
    //   471	1	7	localException2	Exception
    //   128	32	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   123	130	169	java/lang/Exception
    //   137	145	169	java/lang/Exception
    //   157	166	169	java/lang/Exception
    //   233	238	169	java/lang/Exception
    //   245	250	169	java/lang/Exception
    //   255	260	277	java/io/IOException
    //   265	270	299	java/io/IOException
    //   206	211	321	java/io/IOException
    //   215	219	343	java/io/IOException
    //   104	110	365	finally
    //   375	379	396	java/io/IOException
    //   384	389	418	java/io/IOException
    //   110	116	447	finally
    //   123	130	457	finally
    //   137	145	457	finally
    //   157	166	457	finally
    //   182	201	457	finally
    //   233	238	457	finally
    //   245	250	457	finally
    //   104	110	461	java/lang/Exception
    //   110	116	471	java/lang/Exception
  }
  
  public final String ao(String paramString1, String paramString2)
  {
    AppMethodBeat.i(131975);
    e locale = awP();
    if (locale == null)
    {
      AppMethodBeat.o(131975);
      return null;
    }
    if (locale.jww.containsKey(paramString1))
    {
      paramString1 = (String)((HashMap)locale.jww.get(paramString1)).get(paramString2);
      AppMethodBeat.o(131975);
      return paramString1;
    }
    AppMethodBeat.o(131975);
    return null;
  }
  
  public final e awP()
  {
    AppMethodBeat.i(131976);
    if (this.jwt.get(1) == null) {
      ra(1);
    }
    e locale = (e)this.jwt.get(1);
    AppMethodBeat.o(131976);
    return locale;
  }
  
  public final boolean awR()
  {
    boolean bool = true;
    AppMethodBeat.i(131979);
    if (Util.getInt(ao("ShowConfig", "hidePoiOversea"), 1) == 1) {}
    for (;;)
    {
      Log.d("MicroMsg.ConfigListDecoder", "isHidePoiOversea : ".concat(String.valueOf(bool)));
      AppMethodBeat.o(131979);
      return bool;
      bool = false;
    }
  }
  
  public final boolean awS()
  {
    boolean bool = true;
    AppMethodBeat.i(131982);
    if (Util.getInt(ao("ShowConfig", "showRecvTmpMsgBtn"), 0) == 1) {}
    for (;;)
    {
      Log.d("MicroMsg.ConfigListDecoder", "isShowRecvTmpMsgBtn : ".concat(String.valueOf(bool)));
      AppMethodBeat.o(131982);
      return bool;
      bool = false;
    }
  }
  
  public final List<String> awT()
  {
    AppMethodBeat.i(131983);
    Object localObject1 = null;
    Object localObject3 = ao("IBeacon", "Content");
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
  
  public final int awU()
  {
    AppMethodBeat.i(202416);
    int i = Util.getInt(ao("MailApp", "ShowMailAppRecommend"), 0);
    AppMethodBeat.o(202416);
    return i;
  }
  
  public final String awV()
  {
    AppMethodBeat.i(131984);
    String str = ao("MailApp", "MailAppRedirectUrAndroid");
    AppMethodBeat.o(131984);
    return str;
  }
  
  public final String getMailAppEnterUlAndroid()
  {
    AppMethodBeat.i(131985);
    String str = ao("MailApp", "MailAppEnterMailAppUrlAndroid");
    AppMethodBeat.o(131985);
    return str;
  }
  
  public final void init()
  {
    AppMethodBeat.i(131973);
    int i = 0;
    while (i < e.jwv.length)
    {
      ra(e.jwv[i]);
      i += 1;
    }
    AppMethodBeat.o(131973);
  }
  
  public final void z(int paramInt, String paramString)
  {
    AppMethodBeat.i(131974);
    e locale = new e(paramInt);
    locale.jwx = XmlParser.parseXml(paramString, "ConfigList", null);
    if (locale.jwx.containsKey(".ConfigList.$version")) {
      locale.version = Util.getInt((String)locale.jwx.get(".ConfigList.$version"), 0);
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
        if (locale.jwx.get((String)localObject1 + ".$name") == null) {
          break;
        }
        str = (String)locale.jwx.get((String)localObject1 + ".$name");
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
        if (!locale.jwx.containsKey(localObject2)) {
          break label534;
        }
        localObject3 = (String)locale.jwx.get(localObject3);
        localObject2 = (String)locale.jwx.get(localObject2);
        paramString = (String)locale.jwx.get(paramString);
        Log.d("MicroMsg.ConfigListInfo", "itemKey " + (String)localObject3 + " itemValue " + (String)localObject2 + " itemLang " + paramString);
        if ((paramString == null) || (e.Ld(paramString)))
        {
          if (!locale.jww.containsKey(str)) {
            locale.jww.put(str, new HashMap());
          }
          ((HashMap)locale.jww.get(str)).put(localObject3, localObject2);
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
    this.jwt.put(paramInt, locale);
    AppMethodBeat.o(131974);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.n.d
 * JD-Core Version:    0.7.0.1
 */