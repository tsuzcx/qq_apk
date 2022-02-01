package com.tencent.mm.plugin.appbrand.g.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public final class d
{
  ServerSocket cAY;
  String ip;
  int port = -1;
  c.a riW;
  boolean running = false;
  
  public final void start()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(158976);
        if (this.running)
        {
          AppMethodBeat.o(158976);
          return;
        }
        this.running = true;
      }
      finally
      {
        try
        {
          this.ip = g.cnl();
          this.cAY = new ServerSocket(0, 32, InetAddress.getByName(this.ip));
          this.port = this.cAY.getLocalPort();
          new Thread(new b()).start();
          AppMethodBeat.o(158976);
        }
        catch (IOException localIOException)
        {
          AppMethodBeat.o(158976);
        }
        localObject = finally;
      }
    }
  }
  
  public final void stop()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(158977);
        if (!this.running)
        {
          AppMethodBeat.o(158977);
          return;
        }
        this.running = false;
        if (this.cAY != null)
        {
          boolean bool = this.cAY.isClosed();
          if (!bool) {}
        }
      }
      finally
      {
        try
        {
          this.cAY.close();
          AppMethodBeat.o(158977);
        }
        catch (IOException localIOException) {}
        localObject = finally;
      }
      AppMethodBeat.o(158977);
    }
  }
  
  final class a
    implements Callable<Void>
  {
    private Socket cBb;
    
    a(Socket paramSocket)
    {
      this.cBb = paramSocket;
    }
    
    private void a(com.tencent.mm.plugin.appbrand.g.c.b.d paramd, BufferedWriter paramBufferedWriter)
    {
      AppMethodBeat.i(158972);
      c.a locala = d.this.riW;
      if ((locala == null) || (locala.b(paramd)))
      {
        paramBufferedWriter.write("HTTP/1.1 200 OK\r\nContent-Length: 0\r\n\r\n");
        AppMethodBeat.o(158972);
        return;
      }
      paramBufferedWriter.write("HTTP/1.1 500 Internal Server Error\r\nContent-Length: 0\r\n\r\n");
      AppMethodBeat.o(158972);
    }
    
    /* Error */
    private Void cni()
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_2
      //   2: ldc 60
      //   4: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   7: aload_0
      //   8: getfield 23	com/tencent/mm/plugin/appbrand/g/c/d$a:cBb	Ljava/net/Socket;
      //   11: invokevirtual 66	java/net/Socket:getInputStream	()Ljava/io/InputStream;
      //   14: astore 5
      //   16: invokestatic 72	com/tencent/mm/plugin/appbrand/g/c/j:cnp	()Lcom/tencent/mm/plugin/appbrand/g/c/j;
      //   19: astore 7
      //   21: new 74	com/tencent/mm/plugin/appbrand/g/c/b/d
      //   24: dup
      //   25: invokespecial 75	com/tencent/mm/plugin/appbrand/g/c/b/d:<init>	()V
      //   28: astore 6
      //   30: ldc 77
      //   32: astore 4
      //   34: new 79	java/io/BufferedReader
      //   37: dup
      //   38: new 81	java/io/InputStreamReader
      //   41: dup
      //   42: aload 5
      //   44: invokespecial 84	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
      //   47: invokespecial 87	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
      //   50: astore 8
      //   52: new 89	java/lang/StringBuilder
      //   55: dup
      //   56: invokespecial 90	java/lang/StringBuilder:<init>	()V
      //   59: astore 9
      //   61: aload 8
      //   63: invokevirtual 94	java/io/BufferedReader:readLine	()Ljava/lang/String;
      //   66: astore 10
      //   68: aload 4
      //   70: astore_3
      //   71: aload 10
      //   73: ifnull +393 -> 466
      //   76: aload 10
      //   78: invokevirtual 100	java/lang/String:length	()I
      //   81: ifne +242 -> 323
      //   84: aload 9
      //   86: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   89: astore 4
      //   91: aload 4
      //   93: astore_3
      //   94: aload 4
      //   96: invokevirtual 100	java/lang/String:length	()I
      //   99: ifle +367 -> 466
      //   102: aload 6
      //   104: aload 4
      //   106: invokestatic 107	com/tencent/mm/plugin/appbrand/g/c/j:YO	(Ljava/lang/String;)Lcom/tencent/mm/plugin/appbrand/g/c/b/b;
      //   109: putfield 111	com/tencent/mm/plugin/appbrand/g/c/b/d:rjF	Lcom/tencent/mm/plugin/appbrand/g/c/b/b;
      //   112: aload 6
      //   114: getfield 111	com/tencent/mm/plugin/appbrand/g/c/b/d:rjF	Lcom/tencent/mm/plugin/appbrand/g/c/b/b;
      //   117: ldc 113
      //   119: invokevirtual 119	com/tencent/mm/plugin/appbrand/g/c/b/b:get	(Ljava/lang/String;)Ljava/lang/String;
      //   122: astore 9
      //   124: aload 4
      //   126: astore_3
      //   127: aload 9
      //   129: invokestatic 125	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   132: ifne +334 -> 466
      //   135: aload 9
      //   137: invokestatic 131	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
      //   140: invokevirtual 134	java/lang/Integer:intValue	()I
      //   143: istore_1
      //   144: aload 4
      //   146: astore_3
      //   147: iload_1
      //   148: ifle +311 -> 459
      //   151: iload_1
      //   152: newarray char
      //   154: astore 4
      //   156: new 96	java/lang/String
      //   159: dup
      //   160: aload 4
      //   162: iconst_0
      //   163: aload 8
      //   165: aload 4
      //   167: invokevirtual 138	java/io/BufferedReader:read	([C)I
      //   170: invokespecial 141	java/lang/String:<init>	([CII)V
      //   173: astore 4
      //   175: aload_3
      //   176: invokevirtual 100	java/lang/String:length	()I
      //   179: ifle +12 -> 191
      //   182: aload 6
      //   184: aload_3
      //   185: invokestatic 107	com/tencent/mm/plugin/appbrand/g/c/j:YO	(Ljava/lang/String;)Lcom/tencent/mm/plugin/appbrand/g/c/b/b;
      //   188: putfield 111	com/tencent/mm/plugin/appbrand/g/c/b/d:rjF	Lcom/tencent/mm/plugin/appbrand/g/c/b/b;
      //   191: aload 4
      //   193: invokevirtual 100	java/lang/String:length	()I
      //   196: ifle +15 -> 211
      //   199: aload 6
      //   201: aload 7
      //   203: aload 4
      //   205: invokevirtual 145	com/tencent/mm/plugin/appbrand/g/c/j:YP	(Ljava/lang/String;)Ljava/util/HashMap;
      //   208: putfield 149	com/tencent/mm/plugin/appbrand/g/c/b/d:rjG	Ljava/util/Map;
      //   211: new 46	java/io/BufferedWriter
      //   214: dup
      //   215: new 151	java/io/OutputStreamWriter
      //   218: dup
      //   219: aload_0
      //   220: getfield 23	com/tencent/mm/plugin/appbrand/g/c/d$a:cBb	Ljava/net/Socket;
      //   223: invokevirtual 155	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
      //   226: invokespecial 158	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
      //   229: invokespecial 161	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
      //   232: astore_3
      //   233: aload 6
      //   235: getfield 111	com/tencent/mm/plugin/appbrand/g/c/b/d:rjF	Lcom/tencent/mm/plugin/appbrand/g/c/b/b;
      //   238: ldc 163
      //   240: invokevirtual 119	com/tencent/mm/plugin/appbrand/g/c/b/b:get	(Ljava/lang/String;)Ljava/lang/String;
      //   243: astore 4
      //   245: aload 4
      //   247: invokevirtual 166	java/lang/String:hashCode	()I
      //   250: lookupswitch	default:+221->471, 50084583:+114->364, 1171555962:+129->379
      //   277: ldc 168
      //   279: invokevirtual 50	java/io/BufferedWriter:write	(Ljava/lang/String;)V
      //   282: aload_3
      //   283: invokevirtual 171	java/io/BufferedWriter:flush	()V
      //   286: aload_3
      //   287: invokevirtual 174	java/io/BufferedWriter:close	()V
      //   290: aload 5
      //   292: invokevirtual 177	java/io/InputStream:close	()V
      //   295: aload_0
      //   296: getfield 23	com/tencent/mm/plugin/appbrand/g/c/d$a:cBb	Ljava/net/Socket;
      //   299: invokevirtual 178	java/net/Socket:close	()V
      //   302: aload_0
      //   303: getfield 23	com/tencent/mm/plugin/appbrand/g/c/d$a:cBb	Ljava/net/Socket;
      //   306: ifnull +10 -> 316
      //   309: aload_0
      //   310: getfield 23	com/tencent/mm/plugin/appbrand/g/c/d$a:cBb	Ljava/net/Socket;
      //   313: invokevirtual 178	java/net/Socket:close	()V
      //   316: ldc 60
      //   318: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   321: aconst_null
      //   322: areturn
      //   323: aload 9
      //   325: aload 10
      //   327: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   330: pop
      //   331: aload 9
      //   333: ldc 184
      //   335: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   338: pop
      //   339: goto -278 -> 61
      //   342: astore_3
      //   343: aload_0
      //   344: getfield 23	com/tencent/mm/plugin/appbrand/g/c/d$a:cBb	Ljava/net/Socket;
      //   347: ifnull -31 -> 316
      //   350: aload_0
      //   351: getfield 23	com/tencent/mm/plugin/appbrand/g/c/d$a:cBb	Ljava/net/Socket;
      //   354: invokevirtual 178	java/net/Socket:close	()V
      //   357: goto -41 -> 316
      //   360: astore_3
      //   361: goto -45 -> 316
      //   364: aload 4
      //   366: ldc 186
      //   368: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   371: ifeq +100 -> 471
      //   374: iload_2
      //   375: istore_1
      //   376: goto +97 -> 473
      //   379: aload 4
      //   381: ldc 192
      //   383: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   386: ifeq +85 -> 471
      //   389: iconst_1
      //   390: istore_1
      //   391: goto +82 -> 473
      //   394: aload 6
      //   396: ldc 194
      //   398: putfield 198	com/tencent/mm/plugin/appbrand/g/c/b/d:rjE	Ljava/lang/String;
      //   401: aload_0
      //   402: aload 6
      //   404: aload_3
      //   405: invokespecial 200	com/tencent/mm/plugin/appbrand/g/c/d$a:a	(Lcom/tencent/mm/plugin/appbrand/g/c/b/d;Ljava/io/BufferedWriter;)V
      //   408: goto -126 -> 282
      //   411: astore_3
      //   412: aload_0
      //   413: getfield 23	com/tencent/mm/plugin/appbrand/g/c/d$a:cBb	Ljava/net/Socket;
      //   416: ifnull +10 -> 426
      //   419: aload_0
      //   420: getfield 23	com/tencent/mm/plugin/appbrand/g/c/d$a:cBb	Ljava/net/Socket;
      //   423: invokevirtual 178	java/net/Socket:close	()V
      //   426: ldc 60
      //   428: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   431: aload_3
      //   432: athrow
      //   433: aload 6
      //   435: ldc 202
      //   437: putfield 198	com/tencent/mm/plugin/appbrand/g/c/b/d:rjE	Ljava/lang/String;
      //   440: aload_0
      //   441: aload 6
      //   443: aload_3
      //   444: invokespecial 200	com/tencent/mm/plugin/appbrand/g/c/d$a:a	(Lcom/tencent/mm/plugin/appbrand/g/c/b/d;Ljava/io/BufferedWriter;)V
      //   447: goto -165 -> 282
      //   450: astore 4
      //   452: goto -26 -> 426
      //   455: astore_3
      //   456: goto -140 -> 316
      //   459: ldc 77
      //   461: astore 4
      //   463: goto -288 -> 175
      //   466: iconst_0
      //   467: istore_1
      //   468: goto -321 -> 147
      //   471: iconst_m1
      //   472: istore_1
      //   473: iload_1
      //   474: tableswitch	default:+22 -> 496, 0:+-80->394, 1:+-41->433
      //   497: impdep2
      //   498: fload_2
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	499	0	this	a
      //   143	331	1	i	int
      //   1	374	2	j	int
      //   70	217	3	localObject1	Object
      //   342	1	3	localIOException1	IOException
      //   360	45	3	localIOException2	IOException
      //   411	33	3	localBufferedWriter	BufferedWriter
      //   455	1	3	localIOException3	IOException
      //   32	348	4	localObject2	Object
      //   450	1	4	localIOException4	IOException
      //   461	1	4	str1	String
      //   14	277	5	localInputStream	java.io.InputStream
      //   28	414	6	locald	com.tencent.mm.plugin.appbrand.g.c.b.d
      //   19	183	7	localj	j
      //   50	114	8	localBufferedReader	java.io.BufferedReader
      //   59	273	9	localObject3	Object
      //   66	260	10	str2	String
      // Exception table:
      //   from	to	target	type
      //   7	30	342	java/io/IOException
      //   34	61	342	java/io/IOException
      //   61	68	342	java/io/IOException
      //   76	91	342	java/io/IOException
      //   94	124	342	java/io/IOException
      //   127	144	342	java/io/IOException
      //   151	175	342	java/io/IOException
      //   175	191	342	java/io/IOException
      //   191	211	342	java/io/IOException
      //   211	276	342	java/io/IOException
      //   276	282	342	java/io/IOException
      //   282	302	342	java/io/IOException
      //   323	339	342	java/io/IOException
      //   364	374	342	java/io/IOException
      //   379	389	342	java/io/IOException
      //   394	408	342	java/io/IOException
      //   433	447	342	java/io/IOException
      //   350	357	360	java/io/IOException
      //   7	30	411	finally
      //   34	61	411	finally
      //   61	68	411	finally
      //   76	91	411	finally
      //   94	124	411	finally
      //   127	144	411	finally
      //   151	175	411	finally
      //   175	191	411	finally
      //   191	211	411	finally
      //   211	276	411	finally
      //   276	282	411	finally
      //   282	302	411	finally
      //   323	339	411	finally
      //   364	374	411	finally
      //   379	389	411	finally
      //   394	408	411	finally
      //   433	447	411	finally
      //   419	426	450	java/io/IOException
      //   309	316	455	java/io/IOException
    }
  }
  
  final class b
    implements Runnable
  {
    b() {}
    
    public final void run()
    {
      AppMethodBeat.i(158974);
      ScheduledExecutorService localScheduledExecutorService = Executors.newScheduledThreadPool(4);
      while (d.this.running) {
        try
        {
          Socket localSocket = d.this.cAY.accept();
          localScheduledExecutorService.submit(new d.a(d.this, localSocket));
        }
        catch (IOException localIOException) {}
      }
      AppMethodBeat.o(158974);
    }
  }
  
  static final class c
  {
    private static d rje;
    
    static
    {
      AppMethodBeat.i(158975);
      rje = new d((byte)0);
      AppMethodBeat.o(158975);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g.c.d
 * JD-Core Version:    0.7.0.1
 */