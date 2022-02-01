package com.tencent.mm.plugin.backup.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ab;
import com.tencent.mm.g.a.ad;
import com.tencent.mm.sdk.event.IListener;

public final class b
{
  private static b oVl;
  IListener oVi;
  IListener oVj;
  IListener oVk;
  
  public static b chF()
  {
    AppMethodBeat.i(22162);
    if (oVl == null) {
      oVl = new b();
    }
    b localb = oVl;
    AppMethodBeat.o(22162);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.j.b
 * JD-Core Version:    0.7.0.1
 */