package com.tencent.mm.plugin.freewifi.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.freewifi.a.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.c;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.a;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.b;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.d;
import com.tencent.mm.protocal.protobuf.hj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;

public final class g
  extends e
  implements a
{
  private com.tencent.mm.plugin.freewifi.a rip;
  private int riq = 5;
  
  public g(FreeWifiFrontPageUI paramFreeWifiFrontPageUI)
  {
    super(paramFreeWifiFrontPageUI);
  }
  
  /* Error */
  static String aaE(String paramString)
  {
    // Byte code:
    //   0: sipush 24890
    //   3: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 62	java/net/URL
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 65	java/net/URL:<init>	(Ljava/lang/String;)V
    //   14: invokevirtual 69	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   17: checkcast 71	java/net/HttpURLConnection
    //   20: astore_0
    //   21: aload_0
    //   22: ifnull +85 -> 107
    //   25: aload_0
    //   26: sipush 30000
    //   29: invokevirtual 74	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   32: aload_0
    //   33: iconst_0
    //   34: invokevirtual 78	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   37: aload_0
    //   38: invokevirtual 82	java/net/HttpURLConnection:getResponseCode	()I
    //   41: istore_1
    //   42: aload_0
    //   43: ldc 84
    //   45: invokevirtual 87	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   48: astore_2
    //   49: ldc 89
    //   51: ldc 91
    //   53: iconst_2
    //   54: anewarray 93	java/lang/Object
    //   57: dup
    //   58: iconst_0
    //   59: iload_1
    //   60: invokestatic 99	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   63: aastore
    //   64: dup
    //   65: iconst_1
    //   66: aload_2
    //   67: aastore
    //   68: invokestatic 104	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   71: aload_0
    //   72: ifnull +14 -> 86
    //   75: aload_0
    //   76: invokevirtual 108	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   79: invokevirtual 114	java/io/InputStream:close	()V
    //   82: aload_0
    //   83: invokevirtual 117	java/net/HttpURLConnection:disconnect	()V
    //   86: sipush 24890
    //   89: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   92: aload_2
    //   93: areturn
    //   94: astore_3
    //   95: ldc 89
    //   97: aload_3
    //   98: invokevirtual 121	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   101: invokestatic 125	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   104: goto -22 -> 82
    //   107: aload_0
    //   108: ifnull +14 -> 122
    //   111: aload_0
    //   112: invokevirtual 108	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   115: invokevirtual 114	java/io/InputStream:close	()V
    //   118: aload_0
    //   119: invokevirtual 117	java/net/HttpURLConnection:disconnect	()V
    //   122: sipush 24890
    //   125: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: aconst_null
    //   129: areturn
    //   130: astore_2
    //   131: ldc 89
    //   133: aload_2
    //   134: invokevirtual 121	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   137: invokestatic 125	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   140: goto -22 -> 118
    //   143: astore_2
    //   144: aconst_null
    //   145: astore_0
    //   146: ldc 89
    //   148: ldc 127
    //   150: iconst_1
    //   151: anewarray 93	java/lang/Object
    //   154: dup
    //   155: iconst_0
    //   156: aload_2
    //   157: invokevirtual 121	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   160: aastore
    //   161: invokestatic 129	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   164: aload_0
    //   165: ifnull -43 -> 122
    //   168: aload_0
    //   169: invokevirtual 108	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   172: invokevirtual 114	java/io/InputStream:close	()V
    //   175: aload_0
    //   176: invokevirtual 117	java/net/HttpURLConnection:disconnect	()V
    //   179: goto -57 -> 122
    //   182: astore_2
    //   183: ldc 89
    //   185: aload_2
    //   186: invokevirtual 121	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   189: invokestatic 125	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   192: goto -17 -> 175
    //   195: astore_2
    //   196: aconst_null
    //   197: astore_0
    //   198: aload_0
    //   199: ifnull +14 -> 213
    //   202: aload_0
    //   203: invokevirtual 108	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   206: invokevirtual 114	java/io/InputStream:close	()V
    //   209: aload_0
    //   210: invokevirtual 117	java/net/HttpURLConnection:disconnect	()V
    //   213: sipush 24890
    //   216: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   219: aload_2
    //   220: athrow
    //   221: astore_3
    //   222: ldc 89
    //   224: aload_3
    //   225: invokevirtual 121	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   228: invokestatic 125	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   231: goto -22 -> 209
    //   234: astore_2
    //   235: goto -37 -> 198
    //   238: astore_2
    //   239: goto -41 -> 198
    //   242: astore_2
    //   243: goto -97 -> 146
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	246	0	paramString	String
    //   41	19	1	i	int
    //   48	45	2	str	String
    //   130	4	2	localException1	java.lang.Exception
    //   143	14	2	localException2	java.lang.Exception
    //   182	4	2	localException3	java.lang.Exception
    //   195	25	2	localObject1	Object
    //   234	1	2	localObject2	Object
    //   238	1	2	localObject3	Object
    //   242	1	2	localException4	java.lang.Exception
    //   94	4	3	localException5	java.lang.Exception
    //   221	4	3	localException6	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   75	82	94	java/lang/Exception
    //   111	118	130	java/lang/Exception
    //   6	21	143	java/lang/Exception
    //   168	175	182	java/lang/Exception
    //   6	21	195	finally
    //   202	209	221	java/lang/Exception
    //   25	71	234	finally
    //   146	164	238	finally
    //   25	71	242	java/lang/Exception
  }
  
  private void cwv()
  {
    AppMethodBeat.i(24888);
    this.rij.a(FreeWifiFrontPageUI.d.rkB, FreeWifiFrontPageUI.a.rkx);
    AppMethodBeat.o(24888);
  }
  
  static String gh(String paramString1, String paramString2)
  {
    AppMethodBeat.i(24889);
    if (bt.isNullOrNil(paramString1))
    {
      ad.e("MicroMsg.FreeWifi.ProtocolOne", "null or nil header");
      AppMethodBeat.o(24889);
      return null;
    }
    paramString1 = paramString1.split("\\?");
    if (paramString2.length() > 0) {
      paramString1 = paramString1[1].split("&");
    }
    for (;;)
    {
      if ((paramString1 != null) && (paramString1.length > 0))
      {
        int j = paramString1.length;
        int i = 0;
        while (i < j)
        {
          Object localObject = paramString1[i];
          if (localObject.startsWith(paramString2))
          {
            paramString1 = localObject.substring(paramString2.length());
            AppMethodBeat.o(24889);
            return paramString1;
          }
          i += 1;
        }
      }
      AppMethodBeat.o(24889);
      return null;
    }
  }
  
  public final void connect()
  {
    AppMethodBeat.i(24887);
    j.cwb().cvK().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24882);
        g.a(g.this);
        AppMethodBeat.o(24882);
      }
    });
    AppMethodBeat.o(24887);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.g
 * JD-Core Version:    0.7.0.1
 */