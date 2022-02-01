package com.tencent.mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.a.e;
import com.tencent.mm.am.f;
import com.tencent.mm.g.c.du;
import com.tencent.mm.l.a;
import com.tencent.mm.l.a.a;
import com.tencent.mm.model.bk;
import com.tencent.mm.plugin.messenger.foundation.a.g;
import com.tencent.mm.protocal.protobuf.bps;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;

public final class n
  implements g, com.tencent.mm.plugin.messenger.foundation.a.n
{
  public final String N(bl parambl)
  {
    AppMethodBeat.i(22376);
    if (f.pc(parambl.field_talker))
    {
      parambl = e.SM();
      AppMethodBeat.o(22376);
      return parambl;
    }
    parambl = bk.asn();
    AppMethodBeat.o(22376);
    return parambl;
  }
  
  public final void a(bps parambps, bl parambl)
  {
    AppMethodBeat.i(22375);
    if (f.pc(parambl.field_talker))
    {
      parambps.CxC = parambl.esh;
      if (bt.isNullOrNil(parambps.CxC))
      {
        parambps.CxC = a.a.Wh().o(parambl);
        AppMethodBeat.o(22375);
      }
    }
    else
    {
      parambps.CxC = parambl.esh;
    }
    AppMethodBeat.o(22375);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.n
 * JD-Core Version:    0.7.0.1
 */