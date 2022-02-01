package com.tencent.mm.bz;

import android.support.v4.e.l.c;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class a
{
  static void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(194767);
    a.log(5, paramString1, paramString2 + " : " + Log.getStackTraceString(paramThrowable));
    AppMethodBeat.o(194767);
  }
  
  public static class a
  {
    private static final List<a.b> Git;
    
    static
    {
      AppMethodBeat.i(194764);
      Git = new LinkedList();
      AppMethodBeat.o(194764);
    }
    
    /* Error */
    public static void I(java.io.File paramFile)
    {
      // Byte code:
      //   0: ldc 36
      //   2: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: invokevirtual 42	java/io/File:exists	()Z
      //   9: ifne +7 -> 16
      //   12: aload_0
      //   13: invokestatic 47	com/tencent/mm/bz/k$b:L	(Ljava/io/File;)V
      //   16: ldc 2
      //   18: monitorenter
      //   19: new 21	java/util/LinkedList
      //   22: dup
      //   23: getstatic 26	com/tencent/mm/bz/a$a:Git	Ljava/util/List;
      //   26: invokespecial 50	java/util/LinkedList:<init>	(Ljava/util/Collection;)V
      //   29: astore_1
      //   30: getstatic 26	com/tencent/mm/bz/a$a:Git	Ljava/util/List;
      //   33: invokeinterface 55 1 0
      //   38: ldc 2
      //   40: monitorexit
      //   41: new 57	java/io/PrintWriter
      //   44: dup
      //   45: new 59	java/io/OutputStreamWriter
      //   48: dup
      //   49: new 61	java/io/FileOutputStream
      //   52: dup
      //   53: aload_0
      //   54: iconst_1
      //   55: invokespecial 64	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
      //   58: ldc 66
      //   60: invokespecial 69	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/lang/String;)V
      //   63: invokespecial 72	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
      //   66: astore_2
      //   67: aload_2
      //   68: astore_0
      //   69: aload_1
      //   70: invokeinterface 76 1 0
      //   75: astore_3
      //   76: aload_2
      //   77: astore_0
      //   78: aload_3
      //   79: invokeinterface 81 1 0
      //   84: ifeq +200 -> 284
      //   87: aload_2
      //   88: astore_0
      //   89: aload_3
      //   90: invokeinterface 85 1 0
      //   95: checkcast 87	com/tencent/mm/bz/a$b
      //   98: astore 4
      //   100: aload_2
      //   101: astore_0
      //   102: new 89	java/lang/StringBuilder
      //   105: dup
      //   106: invokespecial 90	java/lang/StringBuilder:<init>	()V
      //   109: getstatic 94	com/tencent/mm/bz/a$b:Giv	Ljava/text/SimpleDateFormat;
      //   112: aload 4
      //   114: getfield 98	com/tencent/mm/bz/a$b:time	J
      //   117: invokestatic 104	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   120: invokevirtual 110	java/text/SimpleDateFormat:format	(Ljava/lang/Object;)Ljava/lang/String;
      //   123: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   126: ldc 116
      //   128: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   131: astore 5
      //   133: aload_2
      //   134: astore_0
      //   135: aload 4
      //   137: getfield 119	com/tencent/mm/bz/a$b:priority	I
      //   140: tableswitch	default:+178 -> 318, 4:+132->272, 5:+138->278
      //   165: astore_0
      //   166: aload_2
      //   167: aload 5
      //   169: aload_1
      //   170: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   173: ldc 121
      //   175: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   178: aload 4
      //   180: getfield 125	com/tencent/mm/bz/a$b:tag	Ljava/lang/String;
      //   183: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   186: ldc 127
      //   188: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   191: aload 4
      //   193: getfield 130	com/tencent/mm/bz/a$b:Giw	Ljava/lang/String;
      //   196: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   199: ldc 132
      //   201: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   204: aload 4
      //   206: getfield 135	com/tencent/mm/bz/a$b:bIO	Ljava/lang/String;
      //   209: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   212: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   215: invokevirtual 143	java/io/PrintWriter:println	(Ljava/lang/String;)V
      //   218: goto -142 -> 76
      //   221: astore_0
      //   222: aload_2
      //   223: astore_1
      //   224: aload_0
      //   225: astore_2
      //   226: aload_1
      //   227: astore_0
      //   228: ldc 145
      //   230: ldc 147
      //   232: aload_2
      //   233: invokestatic 151	com/tencent/mm/bz/a:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   236: aload_1
      //   237: invokestatic 155	com/tencent/mm/bz/k$b:closeQuietly	(Ljava/lang/Object;)V
      //   240: ldc 36
      //   242: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   245: return
      //   246: astore_0
      //   247: ldc 145
      //   249: ldc 157
      //   251: aload_0
      //   252: invokestatic 151	com/tencent/mm/bz/a:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   255: ldc 36
      //   257: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   260: return
      //   261: astore_0
      //   262: ldc 2
      //   264: monitorexit
      //   265: ldc 36
      //   267: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   270: aload_0
      //   271: athrow
      //   272: ldc 159
      //   274: astore_1
      //   275: goto -111 -> 164
      //   278: ldc 161
      //   280: astore_1
      //   281: goto -117 -> 164
      //   284: aload_2
      //   285: invokestatic 155	com/tencent/mm/bz/k$b:closeQuietly	(Ljava/lang/Object;)V
      //   288: ldc 36
      //   290: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   293: return
      //   294: astore_1
      //   295: aconst_null
      //   296: astore_0
      //   297: aload_0
      //   298: invokestatic 155	com/tencent/mm/bz/k$b:closeQuietly	(Ljava/lang/Object;)V
      //   301: ldc 36
      //   303: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   306: aload_1
      //   307: athrow
      //   308: astore_1
      //   309: goto -12 -> 297
      //   312: astore_2
      //   313: aconst_null
      //   314: astore_1
      //   315: goto -89 -> 226
      //   318: ldc 163
      //   320: astore_1
      //   321: goto -157 -> 164
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	324	0	paramFile	java.io.File
      //   29	252	1	localObject1	Object
      //   294	13	1	localObject2	Object
      //   308	1	1	localObject3	Object
      //   314	7	1	str	String
      //   66	219	2	localObject4	Object
      //   312	1	2	localIOException	java.io.IOException
      //   75	15	3	localIterator	java.util.Iterator
      //   98	107	4	localb	a.b
      //   131	37	5	localStringBuilder	java.lang.StringBuilder
      // Exception table:
      //   from	to	target	type
      //   69	76	221	java/io/IOException
      //   78	87	221	java/io/IOException
      //   89	100	221	java/io/IOException
      //   102	133	221	java/io/IOException
      //   135	164	221	java/io/IOException
      //   166	218	221	java/io/IOException
      //   12	16	246	java/io/IOException
      //   19	41	261	finally
      //   262	265	261	finally
      //   41	67	294	finally
      //   69	76	308	finally
      //   78	87	308	finally
      //   89	100	308	finally
      //   102	133	308	finally
      //   135	164	308	finally
      //   166	218	308	finally
      //   228	236	308	finally
      //   41	67	312	java/io/IOException
    }
    
    public static void log(int paramInt, String paramString1, String paramString2)
    {
      AppMethodBeat.i(194762);
      a.b localb = a.b.eRN();
      long l = System.currentTimeMillis();
      String str = Thread.currentThread().getName();
      localb.priority = paramInt;
      localb.time = l;
      localb.tag = paramString1;
      localb.Giw = str;
      localb.bIO = paramString2;
      try
      {
        Git.add(localb);
        return;
      }
      finally
      {
        AppMethodBeat.o(194762);
      }
    }
  }
  
  public static final class b
  {
    private static final l.c<b> Giu;
    static final SimpleDateFormat Giv;
    public String Giw;
    public String bIO;
    public int priority;
    public String tag;
    public long time;
    
    static
    {
      AppMethodBeat.i(194766);
      Giu = new l.c(20);
      Giv = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.US);
      AppMethodBeat.o(194766);
    }
    
    public static b eRN()
    {
      AppMethodBeat.i(194765);
      b localb = (b)Giu.acquire();
      if (localb != null)
      {
        AppMethodBeat.o(194765);
        return localb;
      }
      localb = new b();
      AppMethodBeat.o(194765);
      return localb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.bz.a
 * JD-Core Version:    0.7.0.1
 */