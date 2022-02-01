package com.tencent.mm.be;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;

public final class a
{
  private static final a jij;
  public long jii;
  
  static
  {
    AppMethodBeat.i(116858);
    jij = new a();
    AppMethodBeat.o(116858);
  }
  
  public a()
  {
    AppMethodBeat.i(116857);
    if (g.aAc())
    {
      this.jii = z.aUd();
      AppMethodBeat.o(116857);
      return;
    }
    EventCenter.instance.add(new IListener() {});
    AppMethodBeat.o(116857);
  }
  
  public static a beA()
  {
    return jij;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.be.a
 * JD-Core Version:    0.7.0.1
 */