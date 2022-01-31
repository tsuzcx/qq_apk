package com.tencent.mm.plugin.luckymoney.model;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.vv;
import com.tencent.mm.g.a.vv.a;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;

final class av$1
  extends c<vv>
{
  av$1(av paramav)
  {
    AppMethodBeat.i(42425);
    this.__eventId = vv.class.getName().hashCode();
    AppMethodBeat.o(42425);
  }
  
  private boolean a(vv paramvv)
  {
    AppMethodBeat.i(42426);
    if ((paramvv instanceof vv)) {
      switch (paramvv.cNa.action)
      {
      }
    }
    label268:
    for (;;)
    {
      AppMethodBeat.o(42426);
      return false;
      av localav = this.opX;
      long l = paramvv.cNa.cpg;
      if (!localav.opS)
      {
        localav.opS = true;
        bi localbi = ((j)g.E(j.class)).bPQ().kB(l);
        paramvv = localbi.field_content;
        if (paramvv != null) {}
        for (paramvv = j.b.ab(paramvv, localbi.field_reserved);; paramvv = null)
        {
          if (paramvv == null) {
            break label268;
          }
          paramvv = bo.nullAsNil(paramvv.fih);
          Uri localUri = Uri.parse(paramvv);
          String str = localUri.getQueryParameter("sendid");
          int i = bo.getInt(localUri.getQueryParameter("channelid"), 1);
          if (localav.opT != null)
          {
            g.RM();
            g.RK().eHt.a(localav.opT);
            localav.opT = null;
          }
          g.RM();
          g.RK().eHt.a(1581, localav);
          localav.opT = new aq(i, str, paramvv, 3, "v1.0");
          localav.opT.talker = localbi.field_talker;
          localav.opT.cpO = l;
          g.RM();
          g.RK().eHt.a(localav.opT, 0);
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.av.1
 * JD-Core Version:    0.7.0.1
 */