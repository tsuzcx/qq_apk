package com.tencent.mm.modelsearch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;

public final class a
{
  private static final a oRQ;
  public long status;
  
  static
  {
    AppMethodBeat.i(116858);
    oRQ = new a();
    AppMethodBeat.o(116858);
  }
  
  public a()
  {
    AppMethodBeat.i(116857);
    if (h.baz())
    {
      this.status = z.bAR();
      AppMethodBeat.o(116857);
      return;
    }
    new WebSearchRecordHistorySwitch.1(this, f.hfK).alive();
    AppMethodBeat.o(116857);
  }
  
  public static a bLM()
  {
    return oRQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelsearch.a
 * JD-Core Version:    0.7.0.1
 */