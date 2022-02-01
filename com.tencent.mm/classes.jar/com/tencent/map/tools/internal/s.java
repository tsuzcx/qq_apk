package com.tencent.map.tools.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class s
{
  private static final String a;
  
  static
  {
    AppMethodBeat.i(180852);
    a = s.class.getSimpleName();
    AppMethodBeat.o(180852);
  }
  
  public static byte[] a(String paramString)
  {
    AppMethodBeat.i(180851);
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
      AppMethodBeat.o(180851);
      return null;
    }
    paramString.close();
    AppMethodBeat.o(180851);
    return localObject;
  }
  
  /* Error */
  public static byte[] a(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc 76
    //   2: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 36	java/net/URL
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 39	java/net/URL:<init>	(Ljava/lang/String;)V
    //   13: invokevirtual 43	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   16: checkcast 78	java/net/HttpURLConnection
    //   19: astore_3
    //   20: aload_3
    //   21: astore_0
    //   22: aload_3
    //   23: getstatic 84	com/tencent/map/tools/internal/z:b	I
    //   26: invokevirtual 87	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   29: aload_3
    //   30: astore_0
    //   31: aload_3
    //   32: getstatic 84	com/tencent/map/tools/internal/z:b	I
    //   35: invokevirtual 90	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   38: aload_3
    //   39: astore_0
    //   40: aload_3
    //   41: iconst_1
    //   42: invokevirtual 94	java/net/HttpURLConnection:setDoInput	(Z)V
    //   45: aload_3
    //   46: astore_0
    //   47: aload_3
    //   48: iconst_1
    //   49: invokevirtual 97	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   52: aload_3
    //   53: astore_0
    //   54: aload_3
    //   55: ldc 99
    //   57: invokevirtual 102	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   60: aload_3
    //   61: astore_0
    //   62: aload_3
    //   63: iconst_0
    //   64: invokevirtual 105	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   67: aload_3
    //   68: astore_0
    //   69: aload_3
    //   70: ldc 107
    //   72: ldc 109
    //   74: invokevirtual 113	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   77: aload_3
    //   78: astore_0
    //   79: aload_3
    //   80: ldc 115
    //   82: aload_1
    //   83: arraylength
    //   84: invokestatic 121	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   87: invokevirtual 113	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   90: aload_3
    //   91: astore_0
    //   92: aload_3
    //   93: invokevirtual 125	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   96: aload_1
    //   97: invokevirtual 130	java/io/OutputStream:write	([B)V
    //   100: aload_3
    //   101: astore_0
    //   102: aload_3
    //   103: invokevirtual 134	java/net/HttpURLConnection:getResponseCode	()I
    //   106: sipush 200
    //   109: if_icmpne +107 -> 216
    //   112: aload_3
    //   113: astore_0
    //   114: aload_3
    //   115: invokevirtual 135	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   118: astore_1
    //   119: aload_3
    //   120: astore_0
    //   121: new 50	java/io/ByteArrayOutputStream
    //   124: dup
    //   125: invokespecial 51	java/io/ByteArrayOutputStream:<init>	()V
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
    //   144: invokevirtual 61	java/io/InputStream:read	([B)I
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
    //   161: invokevirtual 65	java/io/ByteArrayOutputStream:write	([BII)V
    //   164: goto -25 -> 139
    //   167: astore_0
    //   168: aload_3
    //   169: astore_1
    //   170: aload_1
    //   171: astore_0
    //   172: sipush 20000
    //   175: putstatic 84	com/tencent/map/tools/internal/z:b	I
    //   178: aload_1
    //   179: ifnull +7 -> 186
    //   182: aload_1
    //   183: invokevirtual 138	java/net/HttpURLConnection:disconnect	()V
    //   186: ldc 76
    //   188: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   191: aconst_null
    //   192: areturn
    //   193: aload_3
    //   194: astore_0
    //   195: aload 4
    //   197: invokevirtual 69	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   200: astore_1
    //   201: aload_3
    //   202: ifnull +7 -> 209
    //   205: aload_3
    //   206: invokevirtual 138	java/net/HttpURLConnection:disconnect	()V
    //   209: ldc 76
    //   211: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   214: aload_1
    //   215: areturn
    //   216: aload_3
    //   217: ifnull +7 -> 224
    //   220: aload_3
    //   221: invokevirtual 138	java/net/HttpURLConnection:disconnect	()V
    //   224: sipush 20000
    //   227: putstatic 84	com/tencent/map/tools/internal/z:b	I
    //   230: ldc 76
    //   232: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   235: aconst_null
    //   236: areturn
    //   237: astore_0
    //   238: aconst_null
    //   239: astore_1
    //   240: aload_1
    //   241: ifnull +7 -> 248
    //   244: aload_1
    //   245: invokevirtual 138	java/net/HttpURLConnection:disconnect	()V
    //   248: ldc 76
    //   250: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   253: aload_0
    //   254: athrow
    //   255: astore_1
    //   256: aload_0
    //   257: astore_3
    //   258: aload_1
    //   259: astore_0
    //   260: aload_3
    //   261: astore_1
    //   262: goto -22 -> 240
    //   265: astore_0
    //   266: aconst_null
    //   267: astore_1
    //   268: goto -98 -> 170
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	271	0	paramString	String
    //   0	271	1	paramArrayOfByte	byte[]
    //   147	14	2	i	int
    //   19	242	3	localObject	Object
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
    //   22	29	255	finally
    //   31	38	255	finally
    //   40	45	255	finally
    //   47	52	255	finally
    //   54	60	255	finally
    //   62	67	255	finally
    //   69	77	255	finally
    //   79	90	255	finally
    //   92	100	255	finally
    //   102	112	255	finally
    //   114	119	255	finally
    //   121	130	255	finally
    //   132	139	255	finally
    //   141	148	255	finally
    //   155	164	255	finally
    //   172	178	255	finally
    //   195	201	255	finally
    //   5	20	265	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.map.tools.internal.s
 * JD-Core Version:    0.7.0.1
 */