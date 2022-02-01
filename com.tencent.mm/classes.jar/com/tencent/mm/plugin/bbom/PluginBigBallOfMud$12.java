package com.tencent.mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.a.e;
import com.tencent.mm.ao.g;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.m.a;
import com.tencent.mm.model.bs;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.storage.ca;

final class PluginBigBallOfMud$12
  implements a
{
  PluginBigBallOfMud$12(PluginBigBallOfMud paramPluginBigBallOfMud) {}
  
  public final boolean KI(String paramString)
  {
    AppMethodBeat.i(22398);
    boolean bool = g.KI(paramString);
    AppMethodBeat.o(22398);
    return bool;
  }
  
  public final String ac(String paramString, int paramInt)
  {
    AppMethodBeat.i(22396);
    if (g.KI(paramString))
    {
      paramString = e.Vg(((n)h.ae(n.class)).eSe().Oq(paramInt).hxy);
      AppMethodBeat.o(22396);
      return paramString;
    }
    paramString = bs.beZ();
    AppMethodBeat.o(22396);
    return paramString;
  }
  
  public final void n(ca paramca)
  {
    AppMethodBeat.i(22395);
    if (g.KI(paramca.field_talker))
    {
      paramca.Ip(e.apc());
      AppMethodBeat.o(22395);
      return;
    }
    paramca.Ip(bs.beZ());
    AppMethodBeat.o(22395);
  }
  
  public final String o(ca paramca)
  {
    AppMethodBeat.i(22397);
    if (g.KI(paramca.field_talker))
    {
      paramca = e.Vg(paramca.hxy);
      AppMethodBeat.o(22397);
      return paramca;
    }
    paramca = bs.beZ();
    AppMethodBeat.o(22397);
    return paramca;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.PluginBigBallOfMud.12
 * JD-Core Version:    0.7.0.1
 */