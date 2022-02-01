package com.tencent.mm.modelimage.loader.impr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelimage.loader.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLHandshakeException;

public final class b
  implements c
{
  public final com.tencent.mm.modelimage.loader.c.b Os(String paramString)
  {
    AppMethodBeat.i(130412);
    Log.d("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data from url:%s", new Object[] { paramString });
    try
    {
      paramString = a.Ot(paramString);
      AppMethodBeat.o(130412);
      return paramString;
    }
    catch (InterruptedException paramString)
    {
      Log.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[] { Util.stackTraceToString(paramString) });
      paramString = new com.tencent.mm.modelimage.loader.c.b(null, null);
      AppMethodBeat.o(130412);
      return paramString;
    }
    catch (UnknownHostException paramString)
    {
      for (;;)
      {
        Log.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[] { Util.stackTraceToString(paramString) });
      }
    }
    catch (SSLHandshakeException paramString)
    {
      for (;;)
      {
        Log.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[] { Util.stackTraceToString(paramString) });
      }
    }
    catch (SocketException paramString)
    {
      for (;;)
      {
        Log.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[] { Util.stackTraceToString(paramString) });
      }
    }
    catch (SocketTimeoutException paramString)
    {
      for (;;)
      {
        Log.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[] { Util.stackTraceToString(paramString) });
      }
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        Log.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[] { Util.stackTraceToString(paramString) });
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[] { Util.stackTraceToString(paramString) });
      }
    }
  }
  
  static final class a
  {
    /* Error */
    public static com.tencent.mm.modelimage.loader.c.b Ot(String paramString)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_2
      //   2: ldc 12
      //   4: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   7: new 20	java/net/URL
      //   10: dup
      //   11: aload_0
      //   12: invokespecial 24	java/net/URL:<init>	(Ljava/lang/String;)V
      //   15: invokevirtual 28	java/net/URL:openConnection	()Ljava/net/URLConnection;
      //   18: checkcast 30	java/net/HttpURLConnection
      //   21: astore_0
      //   22: aload_0
      //   23: sipush 15000
      //   26: invokevirtual 33	java/net/HttpURLConnection:setConnectTimeout	(I)V
      //   29: aload_0
      //   30: sipush 20000
      //   33: invokevirtual 36	java/net/HttpURLConnection:setReadTimeout	(I)V
      //   36: aload_0
      //   37: ifnonnull +10 -> 47
      //   40: ldc 38
      //   42: ldc 40
      //   44: invokestatic 45	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   47: aload_0
      //   48: invokevirtual 49	java/net/HttpURLConnection:getResponseCode	()I
      //   51: sipush 300
      //   54: if_icmplt +41 -> 95
      //   57: aload_0
      //   58: invokevirtual 53	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
      //   61: invokevirtual 59	java/io/InputStream:close	()V
      //   64: aload_0
      //   65: invokevirtual 62	java/net/HttpURLConnection:disconnect	()V
      //   68: ldc 38
      //   70: ldc 64
      //   72: invokestatic 67	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
      //   75: ldc 12
      //   77: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   80: aconst_null
      //   81: areturn
      //   82: astore_1
      //   83: ldc 38
      //   85: aload_1
      //   86: invokevirtual 74	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   89: invokestatic 77	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   92: goto -28 -> 64
      //   95: aload_0
      //   96: invokevirtual 53	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
      //   99: astore_1
      //   100: aload_0
      //   101: invokevirtual 80	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
      //   104: astore_2
      //   105: aload_1
      //   106: iconst_0
      //   107: invokestatic 86	com/tencent/mm/modelimage/loader/impr/e:b	(Ljava/io/InputStream;Z)[B
      //   110: astore_3
      //   111: aload_0
      //   112: invokevirtual 53	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
      //   115: invokevirtual 59	java/io/InputStream:close	()V
      //   118: aload_0
      //   119: invokevirtual 62	java/net/HttpURLConnection:disconnect	()V
      //   122: new 88	com/tencent/mm/modelimage/loader/c/b
      //   125: dup
      //   126: aload_3
      //   127: aload_2
      //   128: invokespecial 91	com/tencent/mm/modelimage/loader/c/b:<init>	([BLjava/lang/String;)V
      //   131: astore_0
      //   132: aload_1
      //   133: ifnull +7 -> 140
      //   136: aload_1
      //   137: invokevirtual 59	java/io/InputStream:close	()V
      //   140: ldc 12
      //   142: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   145: aload_0
      //   146: areturn
      //   147: astore 4
      //   149: ldc 38
      //   151: aload 4
      //   153: invokevirtual 74	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   156: invokestatic 77	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   159: goto -41 -> 118
      //   162: astore_0
      //   163: aload_1
      //   164: ifnull +7 -> 171
      //   167: aload_1
      //   168: invokevirtual 59	java/io/InputStream:close	()V
      //   171: ldc 12
      //   173: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   176: aload_0
      //   177: athrow
      //   178: astore_1
      //   179: goto -39 -> 140
      //   182: astore_1
      //   183: goto -12 -> 171
      //   186: astore_0
      //   187: aload_2
      //   188: astore_1
      //   189: goto -26 -> 163
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	192	0	paramString	String
      //   82	4	1	localException1	Exception
      //   99	69	1	localInputStream	java.io.InputStream
      //   178	1	1	localException2	Exception
      //   182	1	1	localException3	Exception
      //   188	1	1	str1	String
      //   1	187	2	str2	String
      //   110	17	3	arrayOfByte	byte[]
      //   147	5	4	localException4	Exception
      // Exception table:
      //   from	to	target	type
      //   57	64	82	java/lang/Exception
      //   111	118	147	java/lang/Exception
      //   100	111	162	finally
      //   111	118	162	finally
      //   118	132	162	finally
      //   149	159	162	finally
      //   136	140	178	java/lang/Exception
      //   167	171	182	java/lang/Exception
      //   95	100	186	finally
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelimage.loader.impr.b
 * JD-Core Version:    0.7.0.1
 */