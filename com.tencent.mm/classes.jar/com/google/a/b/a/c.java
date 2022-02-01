package com.google.a.b.a;

import com.google.a.b.e;
import com.google.a.b.i;
import com.google.a.c.a;
import com.google.a.f;
import com.google.a.s;
import com.google.a.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public final class c
  extends s<Date>
{
  public static final t bOB;
  private final List<DateFormat> bML;
  
  static
  {
    AppMethodBeat.i(108006);
    bOB = new t()
    {
      public final <T> s<T> a(f paramAnonymousf, a<T> paramAnonymousa)
      {
        AppMethodBeat.i(108025);
        if (paramAnonymousa.bQy == Date.class)
        {
          paramAnonymousf = new c();
          AppMethodBeat.o(108025);
          return paramAnonymousf;
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
    this.bML = new ArrayList();
    this.bML.add(DateFormat.getDateTimeInstance(2, 2, Locale.US));
    if (!Locale.getDefault().equals(Locale.US)) {
      this.bML.add(DateFormat.getDateTimeInstance(2, 2));
    }
    if (e.yK()) {
      this.bML.add(i.bw(2, 2));
    }
    AppMethodBeat.o(108003);
  }
  
  /* Error */
  private void a(com.google.a.d.a parama, Date paramDate)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 79
    //   4: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_2
    //   8: ifnonnull +16 -> 24
    //   11: aload_1
    //   12: invokevirtual 85	com/google/a/d/a:yS	()Lcom/google/a/d/a;
    //   15: pop
    //   16: ldc 79
    //   18: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_1
    //   25: aload_0
    //   26: getfield 37	com/google/a/b/a/c:bML	Ljava/util/List;
    //   29: iconst_0
    //   30: invokeinterface 89 2 0
    //   35: checkcast 45	java/text/DateFormat
    //   38: aload_2
    //   39: invokevirtual 93	java/text/DateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   42: invokevirtual 97	com/google/a/d/a:ca	(Ljava/lang/String;)Lcom/google/a/d/a;
    //   45: pop
    //   46: ldc 79
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
    //   0	59	1	parama	com.google.a.d.a
    //   0	59	2	paramDate	Date
    // Exception table:
    //   from	to	target	type
    //   2	7	54	finally
    //   11	21	54	finally
    //   24	51	54	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.a.b.a.c
 * JD-Core Version:    0.7.0.1
 */