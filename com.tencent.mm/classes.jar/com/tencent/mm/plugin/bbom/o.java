package com.tencent.mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.a.e;
import com.tencent.mm.ao.g;
import com.tencent.mm.f.c.et;
import com.tencent.mm.m.a;
import com.tencent.mm.m.a.a;
import com.tencent.mm.model.bs;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.protocal.protobuf.cxi;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;

public final class o
  implements j, q
{
  public final void a(cxi paramcxi, ca paramca)
  {
    AppMethodBeat.i(22375);
    if (g.KI(paramca.field_talker))
    {
      paramcxi.RII = paramca.hxy;
      if (Util.isNullOrNil(paramcxi.RII))
      {
        paramcxi.RII = a.a.atD().o(paramca);
        AppMethodBeat.o(22375);
      }
    }
    else
    {
      paramcxi.RII = paramca.hxy;
    }
    AppMethodBeat.o(22375);
  }
  
  public final String af(ca paramca)
  {
    AppMethodBeat.i(22376);
    if (g.KI(paramca.field_talker))
    {
      paramca = e.apc();
      AppMethodBeat.o(22376);
      return paramca;
    }
    paramca = bs.beZ();
    AppMethodBeat.o(22376);
    return paramca;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.o
 * JD-Core Version:    0.7.0.1
 */