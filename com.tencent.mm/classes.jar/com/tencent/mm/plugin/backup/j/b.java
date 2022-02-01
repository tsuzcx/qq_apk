package com.tencent.mm.plugin.backup.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.ac;
import com.tencent.mm.f.a.ae;
import com.tencent.mm.sdk.event.IListener;

public final class b
{
  private static b rXk;
  IListener rXh;
  IListener rXi;
  IListener rXj;
  
  public static b cuQ()
  {
    AppMethodBeat.i(22162);
    if (rXk == null) {
      rXk = new b();
    }
    b localb = rXk;
    AppMethodBeat.o(22162);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.j.b
 * JD-Core Version:    0.7.0.1
 */