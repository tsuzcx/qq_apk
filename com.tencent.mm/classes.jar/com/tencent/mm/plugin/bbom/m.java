package com.tencent.mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.a.e;
import com.tencent.mm.aj.f;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.l.a;
import com.tencent.mm.l.a.a;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.messenger.foundation.a.g;
import com.tencent.mm.protocal.protobuf.bdc;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;

public final class m
  implements g, com.tencent.mm.plugin.messenger.foundation.a.m
{
  public final String B(bi parambi)
  {
    AppMethodBeat.i(18270);
    if (f.lg(parambi.field_talker))
    {
      parambi = e.aaQ();
      AppMethodBeat.o(18270);
      return parambi;
    }
    parambi = bh.aaR();
    AppMethodBeat.o(18270);
    return parambi;
  }
  
  public final void a(bdc parambdc, bi parambi)
  {
    AppMethodBeat.i(18269);
    if (f.lg(parambi.field_talker))
    {
      parambdc.woU = parambi.dns;
      if (bo.isNullOrNil(parambdc.woU))
      {
        parambdc.woU = a.a.Ky().h(parambi);
        AppMethodBeat.o(18269);
      }
    }
    else
    {
      parambdc.woU = parambi.dns;
    }
    AppMethodBeat.o(18269);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.m
 * JD-Core Version:    0.7.0.1
 */