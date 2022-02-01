package com.tencent.mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.memory.a.c;

public final class e
{
  private static e mdm = null;
  public f<String, Long> mdn;
  public String mdo;
  
  private e()
  {
    AppMethodBeat.i(151076);
    this.mdn = new c(10);
    AppMethodBeat.o(151076);
  }
  
  public static e bpu()
  {
    AppMethodBeat.i(151075);
    if (mdm == null) {
      mdm = new e();
    }
    e locale = mdm;
    AppMethodBeat.o(151075);
    return locale;
  }
  
  public final void F(String paramString, long paramLong)
  {
    AppMethodBeat.i(151077);
    if (this.mdn != null)
    {
      this.mdo = paramString;
      this.mdn.put(paramString, Long.valueOf(paramLong));
    }
    AppMethodBeat.o(151077);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelstat.e
 * JD-Core Version:    0.7.0.1
 */