package c.t.m.sapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class p
{
  public static int a = 20000;
  
  public static byte[] a(String paramString)
  {
    AppMethodBeat.i(186136);
    Object localObject;
    try
    {
      localObject = new URL(paramString).openConnection();
      ((URLConnection)localObject).connect();
      paramString = new ByteArrayOutputStream();
      byte[] arrayOfByte = new byte[1024];
      for (;;)
      {
        int i = ((URLConnection)localObject).getInputStream().read(arrayOfByte);
        if (i == -1) {
          break;
        }
        paramString.write(arrayOfByte, 0, i);
      }
      localObject = paramString.toByteArray();
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(186136);
      return null;
    }
    paramString.close();
    AppMethodBeat.o(186136);
    return localObject;
  }
  
  /* Error */
  public static byte[] a(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc 66
    //   2: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 19	java/net/URL
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 23	java/net/URL:<init>	(Ljava/lang/String;)V
    //   13: invokevirtual 27	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   16: checkcast 68	java/net/HttpURLConnection
    //   19: astore_3
    //   20: aload_3
    //   21: astore_0
    //   22: aload_3
    //   23: getstatic 70	c/t/m/sapp/c/p:a	I
    //   26: invokevirtual 73	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   29: aload_3
    //   30: astore_0
    //   31: aload_3
    //   32: getstatic 70	c/t/m/sapp/c/p:a	I
    //   35: invokevirtual 76	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   38: aload_3
    //   39: astore_0
    //   40: aload_3
    //   41: iconst_1
    //   42: invokevirtual 80	java/net/HttpURLConnection:setDoInput	(Z)V
    //   45: aload_3
    //   46: astore_0
    //   47: aload_3
    //   48: iconst_1
    //   49: invokevirtual 83	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   52: aload_3
    //   53: astore_0
    //   54: aload_3
    //   55: ldc 85
    //   57: invokevirtual 88	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   60: aload_3
    //   61: astore_0
    //   62: aload_3
    //   63: iconst_0
    //   64: invokevirtual 91	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   67: aload_3
    //   68: astore_0
    //   69: aload_3
    //   70: ldc 93
    //   72: ldc 95
    //   74: invokevirtual 99	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   77: aload_3
    //   78: astore_0
    //   79: aload_3
    //   80: ldc 101
    //   82: aload_1
    //   83: arraylength
    //   84: invokestatic 107	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   87: invokevirtual 99	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   90: aload_3
    //   91: astore_0
    //   92: aload_3
    //   93: invokevirtual 111	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   96: aload_1
    //   97: invokevirtual 116	java/io/OutputStream:write	([B)V
    //   100: aload_3
    //   101: astore_0
    //   102: aload_3
    //   103: invokevirtual 120	java/net/HttpURLConnection:getResponseCode	()I
    //   106: sipush 200
    //   109: if_icmpne +107 -> 216
    //   112: aload_3
    //   113: astore_0
    //   114: aload_3
    //   115: invokevirtual 121	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   118: astore_1
    //   119: aload_3
    //   120: astore_0
    //   121: new 35	java/io/ByteArrayOutputStream
    //   124: dup
    //   125: invokespecial 37	java/io/ByteArrayOutputStream:<init>	()V
    //   128: astore 4
    //   130: aload_3
    //   131: astore_0
    //   132: sipush 128
    //   135: newarray byte
    //   137: astore 5
    //   139: aload_3
    //   140: astore_0
    //   141: aload_1
    //   142: aload 5
    //   144: invokevirtual 47	java/io/InputStream:read	([B)I
    //   147: istore_2
    //   148: iload_2
    //   149: iconst_m1
    //   150: if_icmpeq +43 -> 193
    //   153: aload_3
    //   154: astore_0
    //   155: aload 4
    //   157: aload 5
    //   159: iconst_0
    //   160: iload_2
    //   161: invokevirtual 51	java/io/ByteArrayOutputStream:write	([BII)V
    //   164: goto -25 -> 139
    //   167: astore_0
    //   168: aload_3
    //   169: astore_1
    //   170: aload_1
    //   171: astore_0
    //   172: sipush 20000
    //   175: putstatic 70	c/t/m/sapp/c/p:a	I
    //   178: aload_1
    //   179: ifnull +7 -> 186
    //   182: aload_1
    //   183: invokevirtual 124	java/net/HttpURLConnection:disconnect	()V
    //   186: ldc 66
    //   188: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   191: aconst_null
    //   192: areturn
    //   193: aload_3
    //   194: astore_0
    //   195: aload 4
    //   197: invokevirtual 58	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   200: astore_1
    //   201: aload_3
    //   202: ifnull +7 -> 209
    //   205: aload_3
    //   206: invokevirtual 124	java/net/HttpURLConnection:disconnect	()V
    //   209: ldc 66
    //   211: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   214: aload_1
    //   215: areturn
    //   216: aload_3
    //   217: ifnull +7 -> 224
    //   220: aload_3
    //   221: invokevirtual 124	java/net/HttpURLConnection:disconnect	()V
    //   224: sipush 20000
    //   227: putstatic 70	c/t/m/sapp/c/p:a	I
    //   230: ldc 66
    //   232: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   235: aconst_null
    //   236: areturn
    //   237: astore_0
    //   238: aconst_null
    //   239: astore_1
    //   240: aload_1
    //   241: ifnull +7 -> 248
    //   244: aload_1
    //   245: invokevirtual 124	java/net/HttpURLConnection:disconnect	()V
    //   248: ldc 66
    //   250: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   253: aload_0
    //   254: athrow
    //   255: astore_0
    //   256: aconst_null
    //   257: astore_1
    //   258: goto -88 -> 170
    //   261: astore_1
    //   262: aload_0
    //   263: astore_3
    //   264: aload_1
    //   265: astore_0
    //   266: aload_3
    //   267: astore_1
    //   268: goto -28 -> 240
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	271	0	paramString	String
    //   0	271	1	paramArrayOfByte	byte[]
    //   147	14	2	i	int
    //   19	248	3	localObject	Object
    //   128	68	4	localByteArrayOutputStream	ByteArrayOutputStream
    //   137	21	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   22	29	167	java/io/IOException
    //   31	38	167	java/io/IOException
    //   40	45	167	java/io/IOException
    //   47	52	167	java/io/IOException
    //   54	60	167	java/io/IOException
    //   62	67	167	java/io/IOException
    //   69	77	167	java/io/IOException
    //   79	90	167	java/io/IOException
    //   92	100	167	java/io/IOException
    //   102	112	167	java/io/IOException
    //   114	119	167	java/io/IOException
    //   121	130	167	java/io/IOException
    //   132	139	167	java/io/IOException
    //   141	148	167	java/io/IOException
    //   155	164	167	java/io/IOException
    //   195	201	167	java/io/IOException
    //   5	20	237	finally
    //   5	20	255	java/io/IOException
    //   22	29	261	finally
    //   31	38	261	finally
    //   40	45	261	finally
    //   47	52	261	finally
    //   54	60	261	finally
    //   62	67	261	finally
    //   69	77	261	finally
    //   79	90	261	finally
    //   92	100	261	finally
    //   102	112	261	finally
    //   114	119	261	finally
    //   121	130	261	finally
    //   132	139	261	finally
    //   141	148	261	finally
    //   155	164	261	finally
    //   172	178	261	finally
    //   195	201	261	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     c.t.m.sapp.c.p
 * JD-Core Version:    0.7.0.1
 */