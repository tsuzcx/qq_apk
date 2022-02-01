package com.tencent.mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.e;
import com.tencent.mm.al.f;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.l.a;
import com.tencent.mm.l.a.a;
import com.tencent.mm.model.bk;
import com.tencent.mm.plugin.messenger.foundation.a.g;
import com.tencent.mm.protocal.protobuf.buj;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;

public final class n
  implements g, com.tencent.mm.plugin.messenger.foundation.a.n
{
  public final String N(bo parambo)
  {
    AppMethodBeat.i(22376);
    if (f.so(parambo.field_talker))
    {
      parambo = e.TG();
      AppMethodBeat.o(22376);
      return parambo;
    }
    parambo = bk.aze();
    AppMethodBeat.o(22376);
    return parambo;
  }
  
  public final void a(buj parambuj, bo parambo)
  {
    AppMethodBeat.i(22375);
    if (f.so(parambo.field_talker))
    {
      parambuj.DPY = parambo.eul;
      if (bs.isNullOrNil(parambuj.DPY))
      {
        parambuj.DPY = a.a.Xf().o(parambo);
        AppMethodBeat.o(22375);
      }
    }
    else
    {
      parambuj.DPY = parambo.eul;
    }
    AppMethodBeat.o(22375);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.n
 * JD-Core Version:    0.7.0.1
 */