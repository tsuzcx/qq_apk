package com.google.a.b.a;

import com.google.a.d.b;
import com.google.a.e;
import com.google.a.p;
import com.google.a.r;
import com.google.a.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public final class j
  extends r<java.sql.Date>
{
  public static final s bMt;
  private final DateFormat bMW;
  
  static
  {
    AppMethodBeat.i(108057);
    bMt = new s()
    {
      public final <T> r<T> a(e paramAnonymouse, com.google.a.c.a<T> paramAnonymousa)
      {
        AppMethodBeat.i(108012);
        if (paramAnonymousa.bOw == java.sql.Date.class)
        {
          paramAnonymouse = new j();
          AppMethodBeat.o(108012);
          return paramAnonymouse;
        }
        AppMethodBeat.o(108012);
        return null;
      }
    };
    AppMethodBeat.o(108057);
  }
  
  public j()
  {
    AppMethodBeat.i(108054);
    this.bMW = new SimpleDateFormat("MMM d, yyyy");
    AppMethodBeat.o(108054);
  }
  
  /* Error */
  private void a(com.google.a.d.c paramc, java.sql.Date paramDate)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 43
    //   4: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_2
    //   8: ifnonnull +19 -> 27
    //   11: aconst_null
    //   12: astore_2
    //   13: aload_1
    //   14: aload_2
    //   15: invokevirtual 49	com/google/a/d/c:cn	(Ljava/lang/String;)Lcom/google/a/d/c;
    //   18: pop
    //   19: ldc 43
    //   21: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: aload_0
    //   28: getfield 40	com/google/a/b/a/j:bMW	Ljava/text/DateFormat;
    //   31: aload_2
    //   32: invokevirtual 55	java/text/DateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   35: astore_2
    //   36: goto -23 -> 13
    //   39: astore_1
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_1
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	j
    //   0	44	1	paramc	com.google.a.d.c
    //   0	44	2	paramDate	java.sql.Date
    // Exception table:
    //   from	to	target	type
    //   2	7	39	finally
    //   13	24	39	finally
    //   27	36	39	finally
  }
  
  private java.sql.Date d(com.google.a.d.a parama)
  {
    try
    {
      AppMethodBeat.i(223300);
      if (parama.zw() != b.bOQ) {
        break label32;
      }
      parama.zA();
      parama = null;
      AppMethodBeat.o(223300);
    }
    finally
    {
      try
      {
        label32:
        parama = new java.sql.Date(this.bMW.parse(parama.zy()).getTime());
        AppMethodBeat.o(223300);
      }
      catch (ParseException parama)
      {
        parama = new p(parama);
        AppMethodBeat.o(223300);
        throw parama;
      }
      parama = finally;
    }
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.a.b.a.j
 * JD-Core Version:    0.7.0.1
 */