package com.tencent.mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.e;
import com.tencent.mm.al.g;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.m.a;
import com.tencent.mm.m.a.a;
import com.tencent.mm.model.bn;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.protocal.protobuf.bzs;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;

public final class o
  implements h, com.tencent.mm.plugin.messenger.foundation.a.o
{
  public final String Q(bv parambv)
  {
    AppMethodBeat.i(22376);
    if (g.vz(parambv.field_talker))
    {
      parambv = e.We();
      AppMethodBeat.o(22376);
      return parambv;
    }
    parambv = bn.aCy();
    AppMethodBeat.o(22376);
    return parambv;
  }
  
  public final void a(bzs parambzs, bv parambv)
  {
    AppMethodBeat.i(22375);
    if (g.vz(parambv.field_talker))
    {
      parambzs.FNL = parambv.eNd;
      if (bu.isNullOrNil(parambzs.FNL))
      {
        parambzs.FNL = a.a.ZP().o(parambv);
        AppMethodBeat.o(22375);
      }
    }
    else
    {
      parambzs.FNL = parambv.eNd;
    }
    AppMethodBeat.o(22375);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.o
 * JD-Core Version:    0.7.0.1
 */