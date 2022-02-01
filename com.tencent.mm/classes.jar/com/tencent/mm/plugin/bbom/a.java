package com.tencent.mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.eq;
import com.tencent.mm.autogen.a.er;
import com.tencent.mm.autogen.a.la;
import com.tencent.mm.autogen.a.qt;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bt;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.modelmulti.u;
import com.tencent.mm.modelmulti.v;
import com.tencent.mm.modelsimple.h;
import com.tencent.mm.plugin.auth.a.b;
import com.tencent.mm.pluginsdk.model.app.as;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.protocal.j.h;
import com.tencent.mm.protocal.j.i;
import com.tencent.mm.protocal.protobuf.ba;
import com.tencent.mm.protocal.protobuf.dug;
import com.tencent.mm.protocal.protobuf.frg;
import com.tencent.mm.protocal.x.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public final class a
  implements b
{
  public final void onAuthResponse(j.h paramh, j.i parami, boolean paramBoolean)
  {
    AppMethodBeat.i(22330);
    if ((parami.YxP.abQP & 0x2) != 0)
    {
      paramh = parami.YxP.abQR;
      if (!paramBoolean)
      {
        bh.bCz();
        c.clearPluginData(paramh.YBX);
      }
      parami = com.tencent.mm.modelavatar.d.Lz(z.bAM());
      bg.okT.JD(parami);
      if (paramh.YBU != 0)
      {
        bh.bCz();
        c.bzJ().gd(paramh.YBU + "@qqim", 3);
      }
      com.tencent.mm.modelavatar.d.n(paramh.YBU, 3);
      if (!paramBoolean) {
        break label155;
      }
      paramh = new la();
      paramh.hMJ.hMK = false;
      paramh.publish();
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.l.kK(2, 8);
      AppMethodBeat.o(22330);
      return;
      Log.w("MicroMsg.BigBallAuthHandle", "summerauth updateProfile acctsect not set!");
      break;
      label155:
      bh.baH().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(22328);
          bt.JU("ver" + com.tencent.mm.protocal.d.Yxh);
          as.gxp().addAll(com.tencent.mm.plugin.openapi.a.gxn().iIx());
          if (EventCenter.instance == null)
          {
            Log.e("MicroMsg.BigBallAuthHandle", "EventPool is null.");
            AppMethodBeat.o(22328);
            return;
          }
          Object localObject = new la();
          ((la)localObject).hMJ.hMK = true;
          ((la)localObject).publish();
          new eq().publish();
          localObject = new er();
          ((er)localObject).hEH.hEG = true;
          ((er)localObject).publish();
          new qt().publish();
          h.hl(true);
          u.bKY().wG(3);
          Log.i("MicroMsg.BigBallAuthHandle", "summerbadcr triggerSync bgfg after manual auth");
          AppMethodBeat.o(22328);
        }
        
        public final String toString()
        {
          AppMethodBeat.i(22329);
          String str = super.toString() + "|onGYNetEnd2";
          AppMethodBeat.o(22329);
          return str;
        }
      });
    }
  }
  
  public final void onRegResponse(x.b paramb, String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    AppMethodBeat.i(22331);
    paramString1 = com.tencent.mm.modelavatar.d.Lz(z.bAM());
    bg.okT.JD(paramString1);
    com.tencent.mm.modelavatar.d.n(paramInt1, 3);
    bh.bCz();
    c.bzJ().gd(paramb.YyC.abaa, 2);
    if (paramInt1 != 0)
    {
      bh.bCz();
      c.bzJ().gd(paramInt1 + "@qqim", 3);
    }
    AppMethodBeat.o(22331);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.a
 * JD-Core Version:    0.7.0.1
 */