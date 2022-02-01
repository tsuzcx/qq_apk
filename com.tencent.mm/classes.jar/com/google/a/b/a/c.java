package com.google.a.b.a;

import com.google.a.c.a;
import com.google.a.r;
import com.google.a.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public final class c
  extends r<Date>
{
  public static final s bMt;
  private final List<DateFormat> bMy;
  
  static
  {
    AppMethodBeat.i(108006);
    bMt = new s()
    {
      public final <T> r<T> a(com.google.a.e paramAnonymouse, a<T> paramAnonymousa)
      {
        AppMethodBeat.i(108025);
        if (paramAnonymousa.bOw == Date.class)
        {
          paramAnonymouse = new c();
          AppMethodBeat.o(108025);
          return paramAnonymouse;
        }
        AppMethodBeat.o(108025);
        return null;
      }
    };
    AppMethodBeat.o(108006);
  }
  
  public c()
  {
    AppMethodBeat.i(108003);
    this.bMy = new ArrayList();
    this.bMy.add(DateFormat.getDateTimeInstance(2, 2, Locale.US));
    if (!Locale.getDefault().equals(Locale.US)) {
      this.bMy.add(DateFormat.getDateTimeInstance(2, 2));
    }
    if (com.google.a.b.e.zp()) {
      this.bMy.add(new SimpleDateFormat("MMM d, yyyy h:mm:ss a", Locale.US));
    }
    AppMethodBeat.o(108003);
  }
  
  /* Error */
  private void a(com.google.a.d.c paramc, Date paramDate)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 90
    //   4: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_2
    //   8: ifnonnull +16 -> 24
    //   11: aload_1
    //   12: invokevirtual 96	com/google/a/d/c:zK	()Lcom/google/a/d/c;
    //   15: pop
    //   16: ldc 90
    //   18: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_1
    //   25: aload_0
    //   26: getfield 37	com/google/a/b/a/c:bMy	Ljava/util/List;
    //   29: iconst_0
    //   30: invokeinterface 100 2 0
    //   35: checkcast 45	java/text/DateFormat
    //   38: aload_2
    //   39: invokevirtual 104	java/text/DateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   42: invokevirtual 108	com/google/a/d/c:cn	(Ljava/lang/String;)Lcom/google/a/d/c;
    //   45: pop
    //   46: ldc 90
    //   48: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   51: goto -30 -> 21
    //   54: astore_1
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_1
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	c
    //   0	59	1	paramc	com.google.a.d.c
    //   0	59	2	paramDate	Date
    // Exception table:
    //   from	to	target	type
    //   2	7	54	finally
    //   11	21	54	finally
    //   24	51	54	finally
  }
  
  /* Error */
  private Date cl(java.lang.String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 113
    //   4: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 37	com/google/a/b/a/c:bMy	Ljava/util/List;
    //   11: invokeinterface 117 1 0
    //   16: astore_3
    //   17: aload_3
    //   18: invokeinterface 122 1 0
    //   23: ifeq +30 -> 53
    //   26: aload_3
    //   27: invokeinterface 126 1 0
    //   32: checkcast 45	java/text/DateFormat
    //   35: astore_2
    //   36: aload_2
    //   37: aload_1
    //   38: invokevirtual 129	java/text/DateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   41: astore_2
    //   42: aload_2
    //   43: astore_1
    //   44: ldc 113
    //   46: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_1
    //   52: areturn
    //   53: aload_1
    //   54: new 131	java/text/ParsePosition
    //   57: dup
    //   58: iconst_0
    //   59: invokespecial 133	java/text/ParsePosition:<init>	(I)V
    //   62: invokestatic 138	com/google/a/b/a/a/a:a	(Ljava/lang/String;Ljava/text/ParsePosition;)Ljava/util/Date;
    //   65: astore_2
    //   66: aload_2
    //   67: astore_1
    //   68: ldc 113
    //   70: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   73: goto -24 -> 49
    //   76: astore_1
    //   77: aload_0
    //   78: monitorexit
    //   79: aload_1
    //   80: athrow
    //   81: astore_2
    //   82: new 140	com/google/a/p
    //   85: dup
    //   86: aload_1
    //   87: aload_2
    //   88: invokespecial 143	com/google/a/p:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   91: astore_1
    //   92: ldc 113
    //   94: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: aload_1
    //   98: athrow
    //   99: astore_2
    //   100: goto -83 -> 17
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	this	c
    //   0	103	1	paramString	java.lang.String
    //   35	32	2	localObject	Object
    //   81	7	2	localParseException1	java.text.ParseException
    //   99	1	2	localParseException2	java.text.ParseException
    //   16	11	3	localIterator	java.util.Iterator
    // Exception table:
    //   from	to	target	type
    //   2	17	76	finally
    //   17	36	76	finally
    //   36	42	76	finally
    //   44	49	76	finally
    //   53	66	76	finally
    //   68	73	76	finally
    //   82	99	76	finally
    //   53	66	81	java/text/ParseException
    //   36	42	99	java/text/ParseException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.a.b.a.c
 * JD-Core Version:    0.7.0.1
 */