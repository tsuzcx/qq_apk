package com.tencent.mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.a.e;
import com.tencent.mm.an.g;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.j.a;
import com.tencent.mm.j.a.a;
import com.tencent.mm.model.bt;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.protocal.protobuf.don;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;

public final class o
  implements j, q
{
  public final void a(don paramdon, cc paramcc)
  {
    AppMethodBeat.i(22375);
    if (g.Dn(paramcc.field_talker))
    {
      paramdon.YFJ = paramcc.jUr;
      if (Util.isNullOrNil(paramdon.YFJ))
      {
        paramdon.YFJ = a.a.aOb().o(paramcc);
        AppMethodBeat.o(22375);
      }
    }
    else
    {
      paramdon.YFJ = paramcc.jUr;
    }
    AppMethodBeat.o(22375);
  }
  
  public final String ak(cc paramcc)
  {
    AppMethodBeat.i(22376);
    if (g.Dn(paramcc.field_talker))
    {
      paramcc = e.bCQ();
      AppMethodBeat.o(22376);
      return paramcc;
    }
    paramcc = bt.ab(paramcc);
    AppMethodBeat.o(22376);
    return paramcc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.o
 * JD-Core Version:    0.7.0.1
 */