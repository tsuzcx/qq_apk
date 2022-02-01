package com.tencent.mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.a.e;
import com.tencent.mm.am.g;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.m.a;
import com.tencent.mm.m.a.a;
import com.tencent.mm.model.bl;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.protocal.protobuf.byy;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;

public final class o
  implements h, com.tencent.mm.plugin.messenger.foundation.a.o
{
  public final String Q(bu parambu)
  {
    AppMethodBeat.i(22376);
    if (g.vd(parambu.field_talker))
    {
      parambu = e.VW();
      AppMethodBeat.o(22376);
      return parambu;
    }
    parambu = bl.aCi();
    AppMethodBeat.o(22376);
    return parambu;
  }
  
  public final void a(byy parambyy, bu parambu)
  {
    AppMethodBeat.i(22375);
    if (g.vd(parambu.field_talker))
    {
      parambyy.Fvn = parambu.eLs;
      if (bt.isNullOrNil(parambyy.Fvn))
      {
        parambyy.Fvn = a.a.ZG().o(parambu);
        AppMethodBeat.o(22375);
      }
    }
    else
    {
      parambyy.Fvn = parambu.eLs;
    }
    AppMethodBeat.o(22375);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.o
 * JD-Core Version:    0.7.0.1
 */