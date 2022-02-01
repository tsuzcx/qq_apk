package com.tencent.mm.plugin.mmsight.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.modelvideo.w;
import com.tencent.mm.plugin.mmsight.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.bxm;
import com.tencent.mm.sdk.platformtools.ad;

public final class n
  implements w
{
  public final void GV(String paramString)
  {
    AppMethodBeat.i(89443);
    final s locals = o.aMJ().Hb(paramString);
    if (locals == null)
    {
      AppMethodBeat.o(89443);
      return;
    }
    o.aMJ();
    final String str = t.Hh(paramString);
    bxm localbxm = locals.iuo;
    VideoTransPara localVideoTransPara = d.aGQ().aGR();
    if (localbxm != null)
    {
      ad.i("MicroMsg.MMSightVideoMsgSendCallback", "beforeVideoSend count %d filename %s filePath %s", new Object[] { Integer.valueOf(localbxm.sJZ), paramString, str });
      if (localbxm.sJZ > 1)
      {
        u.Hp(paramString);
        AppMethodBeat.o(89443);
        return;
      }
    }
    boolean bool2 = m.a(str, localVideoTransPara, localbxm, new e()
    {
      public final boolean dlg()
      {
        AppMethodBeat.i(89441);
        ad.i("MicroMsg.MMSightVideoMsgSendCallback", "iUpdateVideoFile1 %s", new Object[] { str });
        int i = t.Hj(str);
        locals.hMP = i;
        locals.dDp = 32;
        o.aMJ().c(locals);
        AppMethodBeat.o(89441);
        return true;
      }
    });
    if (localbxm != null)
    {
      ad.i("MicroMsg.MMSightVideoMsgSendCallback", "filename: %s need ret: %s", new Object[] { paramString, Boolean.valueOf(bool2) });
      if (bool2) {
        break label298;
      }
    }
    label298:
    for (boolean bool1 = true;; bool1 = false)
    {
      localbxm.GRD = bool1;
      locals.iuo = localbxm;
      locals.dDp = 536870912;
      o.aMJ().c(locals);
      if (!bool2) {
        break label337;
      }
      if (localbxm != null)
      {
        localbxm.sJZ += 1;
        locals.iuo = localbxm;
      }
      locals.dDp = 536870912;
      o.aMJ().c(locals);
      c.Kd(locals.iuf);
      if (m.b(str, localVideoTransPara, localbxm, new e()
      {
        public final boolean dlg()
        {
          AppMethodBeat.i(89442);
          c.Ke(locals.iuf);
          ad.i("MicroMsg.MMSightVideoMsgSendCallback", "iUpdateVideoFile2 %s", new Object[] { str });
          int i = t.Hj(str);
          locals.hMP = i;
          locals.dDp = 32;
          o.aMJ().c(locals);
          AppMethodBeat.o(89442);
          return true;
        }
      }) >= 0) {
        break;
      }
      ad.i("MicroMsg.MMSightRecorderIDKeyStat", "mark720CapturePostCompressFailed");
      g.yhR.idkeyStat(440L, 45L, 1L, false);
      u.Hp(paramString);
      AppMethodBeat.o(89443);
      return;
    }
    if (localbxm != null)
    {
      localbxm.GRD = true;
      locals.iuo = localbxm;
      locals.dDp = 536870912;
      o.aMJ().c(locals);
    }
    label337:
    AppMethodBeat.o(89443);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.n
 * JD-Core Version:    0.7.0.1
 */