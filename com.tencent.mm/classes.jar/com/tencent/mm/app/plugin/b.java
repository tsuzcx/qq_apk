package com.tencent.mm.app.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.lu;
import com.tencent.mm.g.a.lu.b;
import com.tencent.mm.sdk.event.EventCenter;

public final class b
{
  public static boolean Xm()
  {
    AppMethodBeat.i(19662);
    lu locallu = new lu();
    locallu.dRh.dJY = 7;
    EventCenter.instance.publish(locallu);
    boolean bool = locallu.dRi.dFE;
    AppMethodBeat.o(19662);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.plugin.b
 * JD-Core Version:    0.7.0.1
 */