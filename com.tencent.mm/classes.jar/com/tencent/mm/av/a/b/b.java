package com.tencent.mm.av.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.c.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.io.IOException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLHandshakeException;

public final class b
  implements c
{
  public final com.tencent.mm.av.a.d.b Gj(String paramString)
  {
    AppMethodBeat.i(130412);
    ae.d("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data from url:%s", new Object[] { paramString });
    try
    {
      paramString = a.Gk(paramString);
      AppMethodBeat.o(130412);
      return paramString;
    }
    catch (InterruptedException paramString)
    {
      ae.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[] { bu.o(paramString) });
      paramString = new com.tencent.mm.av.a.d.b(null, null);
      AppMethodBeat.o(130412);
      return paramString;
    }
    catch (UnknownHostException paramString)
    {
      for (;;)
      {
        ae.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[] { bu.o(paramString) });
      }
    }
    catch (SSLHandshakeException paramString)
    {
      for (;;)
      {
        ae.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[] { bu.o(paramString) });
      }
    }
    catch (SocketException paramString)
    {
      for (;;)
      {
        ae.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[] { bu.o(paramString) });
      }
    }
    catch (SocketTimeoutException paramString)
    {
      for (;;)
      {
        ae.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[] { bu.o(paramString) });
      }
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        ae.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[] { bu.o(paramString) });
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ae.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", new Object[] { bu.o(paramString) });
      }
    }
  }
  
  static final class a
  {
    /* Error */
    public static com.tencent.mm.av.a.d.b Gk(String paramString)
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
      //   44: invokestatic 45	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
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
      //   72: invokestatic 67	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;)V
      //   75: ldc 12
      //   77: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   80: aconst_null
      //   81: areturn
      //   82: astore_1
      //   83: ldc 38
      //   85: aload_1
      //   86: invokevirtual 74	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   89: invokestatic 77	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   92: goto -28 -> 64
      //   95: aload_0
      //   96: invokevirtual 53	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
      //   99: astore_1
      //   100: aload_0
      //   101: invokevirtual 80	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
      //   104: astore_2
      //   105: aload_1
      //   106: invokestatic 86	com/tencent/mm/av/a/b/e:s	(Ljava/io/InputStream;)[B
      //   109: astore_3
      //   110: aload_0
      //   111: invokevirtual 53	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
      //   114: invokevirtual 59	java/io/InputStream:close	()V
      //   117: aload_0
      //   118: invokevirtual 62	java/net/HttpURLConnection:disconnect	()V
      //   121: new 88	com/tencent/mm/av/a/d/b
      //   124: dup
      //   125: aload_3
      //   126: aload_2
      //   127: invokespecial 91	com/tencent/mm/av/a/d/b:<init>	([BLjava/lang/String;)V
      //   130: astore_0
      //   131: aload_1
      //   132: ifnull +7 -> 139
      //   135: aload_1
      //   136: invokevirtual 59	java/io/InputStream:close	()V
      //   139: ldc 12
      //   141: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   144: aload_0
      //   145: areturn
      //   146: astore 4
      //   148: ldc 38
      //   150: aload 4
      //   152: invokevirtual 74	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   155: invokestatic 77	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   158: goto -41 -> 117
      //   161: astore_0
      //   162: aload_1
      //   163: ifnull +7 -> 170
      //   166: aload_1
      //   167: invokevirtual 59	java/io/InputStream:close	()V
      //   170: ldc 12
      //   172: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   175: aload_0
      //   176: athrow
      //   177: astore_1
      //   178: goto -39 -> 139
      //   181: astore_1
      //   182: goto -12 -> 170
      //   185: astore_0
      //   186: aload_2
      //   187: astore_1
      //   188: goto -26 -> 162
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	191	0	paramString	String
      //   82	4	1	localException1	Exception
      //   99	68	1	localInputStream	java.io.InputStream
      //   177	1	1	localException2	Exception
      //   181	1	1	localException3	Exception
      //   187	1	1	str1	String
      //   1	186	2	str2	String
      //   109	17	3	arrayOfByte	byte[]
      //   146	5	4	localException4	Exception
      // Exception table:
      //   from	to	target	type
      //   57	64	82	java/lang/Exception
      //   110	117	146	java/lang/Exception
      //   100	110	161	finally
      //   110	117	161	finally
      //   117	131	161	finally
      //   148	158	161	finally
      //   135	139	177	java/lang/Exception
      //   166	170	181	java/lang/Exception
      //   95	100	185	finally
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.av.a.b.b
 * JD-Core Version:    0.7.0.1
 */