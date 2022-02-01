package com.tencent.mm.bh;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.ct;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;

public final class a
{
  private static final a lYL;
  public long status;
  
  static
  {
    AppMethodBeat.i(116858);
    lYL = new a();
    AppMethodBeat.o(116858);
  }
  
  public a()
  {
    AppMethodBeat.i(116857);
    if (h.aHB())
    {
      this.status = z.bde();
      AppMethodBeat.o(116857);
      return;
    }
    EventCenter.instance.add(new IListener() {});
    AppMethodBeat.o(116857);
  }
  
  public static a bnZ()
  {
    return lYL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.bh.a
 * JD-Core Version:    0.7.0.1
 */