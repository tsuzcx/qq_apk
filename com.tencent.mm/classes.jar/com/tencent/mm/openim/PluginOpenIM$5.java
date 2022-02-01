package com.tencent.mm.openim;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.rj;
import com.tencent.mm.openim.model.m;

final class PluginOpenIM$5
  implements h
{
  PluginOpenIM$5(PluginOpenIM paramPluginOpenIM) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(151167);
    if ((paramp instanceof m))
    {
      paramString = (m)paramp;
      paramp = new rj();
      paramp.hUu.hUv = paramString.hUv;
      paramp.publish();
    }
    AppMethodBeat.o(151167);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.PluginOpenIM.5
 * JD-Core Version:    0.7.0.1
 */