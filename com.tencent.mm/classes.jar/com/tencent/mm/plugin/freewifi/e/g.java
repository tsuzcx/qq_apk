package com.tencent.mm.plugin.freewifi.e;

import com.tencent.mm.plugin.freewifi.model.c;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.a;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.b;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.d;
import com.tencent.mm.protocal.c.fd;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class g
  extends e
  implements a
{
  private int kpA = 5;
  private com.tencent.mm.plugin.freewifi.a kpz;
  
  public g(FreeWifiFrontPageUI paramFreeWifiFrontPageUI)
  {
    super(paramFreeWifiFrontPageUI);
  }
  
  /* Error */
  static String Dy(String paramString)
  {
    // Byte code:
    //   0: new 25	java/net/URL
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 28	java/net/URL:<init>	(Ljava/lang/String;)V
    //   8: invokevirtual 32	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   11: checkcast 34	java/net/HttpURLConnection
    //   14: astore_0
    //   15: aload_0
    //   16: ifnull +59 -> 75
    //   19: aload_0
    //   20: sipush 30000
    //   23: invokevirtual 38	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   26: aload_0
    //   27: iconst_0
    //   28: invokevirtual 42	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   31: aload_0
    //   32: invokevirtual 46	java/net/HttpURLConnection:getResponseCode	()I
    //   35: istore_1
    //   36: aload_0
    //   37: ldc 48
    //   39: invokevirtual 51	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   42: astore_2
    //   43: ldc 53
    //   45: ldc 55
    //   47: iconst_2
    //   48: anewarray 57	java/lang/Object
    //   51: dup
    //   52: iconst_0
    //   53: iload_1
    //   54: invokestatic 63	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   57: aastore
    //   58: dup
    //   59: iconst_1
    //   60: aload_2
    //   61: aastore
    //   62: invokestatic 69	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   65: aload_0
    //   66: ifnull +7 -> 73
    //   69: aload_0
    //   70: invokevirtual 73	java/net/HttpURLConnection:disconnect	()V
    //   73: aload_2
    //   74: areturn
    //   75: aload_0
    //   76: ifnull +7 -> 83
    //   79: aload_0
    //   80: invokevirtual 73	java/net/HttpURLConnection:disconnect	()V
    //   83: aconst_null
    //   84: areturn
    //   85: astore_2
    //   86: aconst_null
    //   87: astore_0
    //   88: ldc 53
    //   90: ldc 75
    //   92: iconst_1
    //   93: anewarray 57	java/lang/Object
    //   96: dup
    //   97: iconst_0
    //   98: aload_2
    //   99: invokevirtual 79	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   102: aastore
    //   103: invokestatic 82	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   106: aload_0
    //   107: ifnull -24 -> 83
    //   110: aload_0
    //   111: invokevirtual 73	java/net/HttpURLConnection:disconnect	()V
    //   114: goto -31 -> 83
    //   117: astore_2
    //   118: aconst_null
    //   119: astore_0
    //   120: aload_0
    //   121: ifnull +7 -> 128
    //   124: aload_0
    //   125: invokevirtual 73	java/net/HttpURLConnection:disconnect	()V
    //   128: aload_2
    //   129: athrow
    //   130: astore_2
    //   131: goto -11 -> 120
    //   134: astore_2
    //   135: goto -15 -> 120
    //   138: astore_2
    //   139: goto -51 -> 88
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	paramString	String
    //   35	19	1	i	int
    //   42	32	2	str	String
    //   85	14	2	localException1	java.lang.Exception
    //   117	12	2	localObject1	Object
    //   130	1	2	localObject2	Object
    //   134	1	2	localObject3	Object
    //   138	1	2	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   0	15	85	java/lang/Exception
    //   0	15	117	finally
    //   19	65	130	finally
    //   88	106	134	finally
    //   19	65	138	java/lang/Exception
  }
  
  private void aUH()
  {
    this.kps.a(FreeWifiFrontPageUI.d.krV, FreeWifiFrontPageUI.a.krR);
  }
  
  static String di(String paramString1, String paramString2)
  {
    if (bk.bl(paramString1)) {
      y.e("MicroMsg.FreeWifi.ProtocolOne", "null or nil header");
    }
    label90:
    for (;;)
    {
      return null;
      paramString1 = paramString1.split("\\?");
      if (paramString2.length() > 0) {
        paramString1 = paramString1[1].split("&");
      }
      for (;;)
      {
        if ((paramString1 == null) || (paramString1.length <= 0)) {
          break label90;
        }
        int j = paramString1.length;
        int i = 0;
        while (i < j)
        {
          Object localObject = paramString1[i];
          if (localObject.startsWith(paramString2)) {
            return localObject.substring(paramString2.length());
          }
          i += 1;
        }
        break;
      }
    }
  }
  
  public final void connect()
  {
    j.aUl().aTT().post(new g.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.g
 * JD-Core Version:    0.7.0.1
 */