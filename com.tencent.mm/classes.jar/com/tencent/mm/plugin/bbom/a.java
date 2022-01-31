package com.tencent.mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.b;
import com.tencent.mm.g.a.hj;
import com.tencent.mm.g.a.tg;
import com.tencent.mm.model.av;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.protocal.j.h;
import com.tencent.mm.protocal.j.i;
import com.tencent.mm.protocal.protobuf.ar;
import com.tencent.mm.protocal.protobuf.bgg;
import com.tencent.mm.protocal.protobuf.cmm;
import com.tencent.mm.protocal.v.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

public final class a
  implements com.tencent.mm.plugin.auth.a.a
{
  public final void a(j.h paramh, j.i parami, boolean paramBoolean)
  {
    AppMethodBeat.i(18229);
    if ((parami.wil.xWl & 0x2) != 0)
    {
      paramh = parami.wil.xWn;
      if (!paramBoolean)
      {
        aw.aaz();
        c.clearPluginData(paramh.wmt);
      }
      parami = b.qS(r.Zn());
      av.flM.po(parami);
      if (paramh.wmq != 0)
      {
        aw.aaz();
        c.YI().cO(paramh.wmq + "@qqim", 3);
      }
      b.d(paramh.wmq, 3);
    }
    for (;;)
    {
      o.run(1);
      if (!paramBoolean) {
        break;
      }
      paramh = new hj();
      paramh.cwv.cww = false;
      com.tencent.mm.sdk.b.a.ymk.l(paramh);
      paramh = new tg();
      paramh.cJH.cJI = true;
      com.tencent.mm.sdk.b.a.ymk.l(paramh);
      AppMethodBeat.o(18229);
      return;
      ab.w("MicroMsg.BigBallAuthHandle", "summerauth updateProfile acctsect not set!");
    }
    aw.RO().ac(new a.1(this));
    AppMethodBeat.o(18229);
  }
  
  public final void a(v.b paramb, String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    AppMethodBeat.i(18230);
    paramString1 = b.qS(r.Zn());
    av.flM.po(paramString1);
    b.d(paramInt1, 3);
    aw.aaz();
    c.YI().cO(paramb.wiP.xvq, 2);
    if (paramInt1 != 0)
    {
      aw.aaz();
      c.YI().cO(paramInt1 + "@qqim", 3);
    }
    AppMethodBeat.o(18230);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.a
 * JD-Core Version:    0.7.0.1
 */