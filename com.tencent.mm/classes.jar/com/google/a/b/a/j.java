package com.google.a.b.a;

import com.google.a.c.a;
import com.google.a.f;
import com.google.a.s;
import com.google.a.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public final class j
  extends s<Time>
{
  public static final t bOB;
  private final DateFormat bOZ;
  
  static
  {
    AppMethodBeat.i(108017);
    bOB = new t()
    {
      public final <T> s<T> a(f paramAnonymousf, a<T> paramAnonymousa)
      {
        AppMethodBeat.i(107997);
        if (paramAnonymousa.bQy == Time.class)
        {
          paramAnonymousf = new j();
          AppMethodBeat.o(107997);
          return paramAnonymousf;
        }
        AppMethodBeat.o(107997);
        return null;
      }
    };
    AppMethodBeat.o(108017);
  }
  
  public j()
  {
    AppMethodBeat.i(108014);
    this.bOZ = new SimpleDateFormat("hh:mm:ss a");
    AppMethodBeat.o(108014);
  }
  
  /* Error */
  private void a(com.google.a.d.a parama, Time paramTime)
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
    //   15: invokevirtual 49	com/google/a/d/a:ca	(Ljava/lang/String;)Lcom/google/a/d/a;
    //   18: pop
    //   19: ldc 43
    //   21: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: aload_0
    //   28: getfield 40	com/google/a/b/a/j:bOZ	Ljava/text/DateFormat;
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
    //   0	44	1	parama	com.google.a.d.a
    //   0	44	2	paramTime	Time
    // Exception table:
    //   from	to	target	type
    //   2	7	39	finally
    //   13	24	39	finally
    //   27	36	39	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.a.b.a.j
 * JD-Core Version:    0.7.0.1
 */