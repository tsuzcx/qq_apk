package com.tencent.mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.e;
import com.tencent.mm.al.g;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.m.a;
import com.tencent.mm.m.a.a;
import com.tencent.mm.model.br;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.protocal.protobuf.cot;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;

public final class o
  implements h, com.tencent.mm.plugin.messenger.foundation.a.o
{
  public final String Z(ca paramca)
  {
    AppMethodBeat.i(22376);
    if (g.DQ(paramca.field_talker))
    {
      paramca = e.ajw();
      AppMethodBeat.o(22376);
      return paramca;
    }
    paramca = br.aVW();
    AppMethodBeat.o(22376);
    return paramca;
  }
  
  public final void a(cot paramcot, ca paramca)
  {
    AppMethodBeat.i(22375);
    if (g.DQ(paramca.field_talker))
    {
      paramcot.KHq = paramca.fqK;
      if (Util.isNullOrNil(paramcot.KHq))
      {
        paramcot.KHq = a.a.anC().o(paramca);
        AppMethodBeat.o(22375);
      }
    }
    else
    {
      paramcot.KHq = paramca.fqK;
    }
    AppMethodBeat.o(22375);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.o
 * JD-Core Version:    0.7.0.1
 */