package com.google.c.b.a;

import com.google.c.d.b;
import com.google.c.e;
import com.google.c.p;
import com.google.c.r;
import com.google.c.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public final class j
  extends r<java.sql.Date>
{
  public static final s dFZ;
  private final DateFormat dGB;
  
  static
  {
    AppMethodBeat.i(108057);
    dFZ = new s()
    {
      public final <T> r<T> a(e paramAnonymouse, com.google.c.c.a<T> paramAnonymousa)
      {
        AppMethodBeat.i(108012);
        if (paramAnonymousa.dIb == java.sql.Date.class)
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
    this.dGB = new SimpleDateFormat("MMM d, yyyy");
    AppMethodBeat.o(108054);
  }
  
  /* Error */
  private void a(com.google.c.d.c paramc, java.sql.Date paramDate)
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
    //   15: invokevirtual 49	com/google/c/d/c:dN	(Ljava/lang/String;)Lcom/google/c/d/c;
    //   18: pop
    //   19: ldc 43
    //   21: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: aload_0
    //   28: getfield 40	com/google/c/b/a/j:dGB	Ljava/text/DateFormat;
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
    //   0	44	1	paramc	com.google.c.d.c
    //   0	44	2	paramDate	java.sql.Date
    // Exception table:
    //   from	to	target	type
    //   2	7	39	finally
    //   13	24	39	finally
    //   27	36	39	finally
  }
  
  private java.sql.Date d(com.google.c.d.a parama)
  {
    try
    {
      AppMethodBeat.i(208891);
      if (parama.Zh() != b.dIv) {
        break label32;
      }
      parama.Zl();
      parama = null;
      AppMethodBeat.o(208891);
    }
    finally
    {
      try
      {
        label32:
        parama = new java.sql.Date(this.dGB.parse(parama.Zj()).getTime());
        AppMethodBeat.o(208891);
      }
      catch (ParseException parama)
      {
        parama = new p(parama);
        AppMethodBeat.o(208891);
        throw parama;
      }
      parama = finally;
    }
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.c.b.a.j
 * JD-Core Version:    0.7.0.1
 */