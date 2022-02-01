package com.tencent.mm.app.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.ml;
import com.tencent.mm.f.a.ml.b;
import com.tencent.mm.sdk.event.EventCenter;

public final class c
{
  public static boolean abO()
  {
    AppMethodBeat.i(19662);
    ml localml = new ml();
    localml.fKx.fCN = 7;
    EventCenter.instance.publish(localml);
    boolean bool = localml.fKy.fyl;
    AppMethodBeat.o(19662);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.app.plugin.c
 * JD-Core Version:    0.7.0.1
 */