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
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.boj;
import com.tencent.mm.sdk.platformtools.ad;

public final class n
  implements w
{
  public final void zJ(String paramString)
  {
    AppMethodBeat.i(89443);
    final s locals = o.aCI().zO(paramString);
    if (locals == null)
    {
      AppMethodBeat.o(89443);
      return;
    }
    o.aCI();
    final String str = t.zQ(paramString);
    boj localboj = locals.hAr;
    VideoTransPara localVideoTransPara = d.awT().awU();
    if (localboj != null)
    {
      ad.i("MicroMsg.MMSightVideoMsgSendCallback", "beforeVideoSend count %d filename %s filePath %s", new Object[] { Integer.valueOf(localboj.qRG), paramString, str });
      if (localboj.qRG > 1)
      {
        u.zV(paramString);
        AppMethodBeat.o(89443);
        return;
      }
    }
    boolean bool2 = m.a(str, localVideoTransPara, localboj, new e()
    {
      public final boolean cOe()
      {
        AppMethodBeat.i(89441);
        ad.i("MicroMsg.MMSightVideoMsgSendCallback", "iUpdateVideoFile1 %s", new Object[] { str });
        int i = t.zS(str);
        locals.gTY = i;
        locals.dtM = 32;
        o.aCI().c(locals);
        AppMethodBeat.o(89441);
        return true;
      }
    });
    if (localboj != null)
    {
      ad.i("MicroMsg.MMSightVideoMsgSendCallback", "filename: %s need ret: %s", new Object[] { paramString, Boolean.valueOf(bool2) });
      if (bool2) {
        break label298;
      }
    }
    label298:
    for (boolean bool1 = true;; bool1 = false)
    {
      localboj.DLN = bool1;
      locals.hAr = localboj;
      locals.dtM = 536870912;
      o.aCI().c(locals);
      if (!bool2) {
        break label337;
      }
      if (localboj != null)
      {
        localboj.qRG += 1;
        locals.hAr = localboj;
      }
      locals.dtM = 536870912;
      o.aCI().c(locals);
      c.GK(locals.hAi);
      if (m.b(str, localVideoTransPara, localboj, new e()
      {
        public final boolean cOe()
        {
          AppMethodBeat.i(89442);
          c.GL(locals.hAi);
          ad.i("MicroMsg.MMSightVideoMsgSendCallback", "iUpdateVideoFile2 %s", new Object[] { str });
          int i = t.zS(str);
          locals.gTY = i;
          locals.dtM = 32;
          o.aCI().c(locals);
          AppMethodBeat.o(89442);
          return true;
        }
      }) >= 0) {
        break;
      }
      ad.i("MicroMsg.MMSightRecorderIDKeyStat", "mark720CapturePostCompressFailed");
      h.vKh.idkeyStat(440L, 45L, 1L, false);
      u.zV(paramString);
      AppMethodBeat.o(89443);
      return;
    }
    if (localboj != null)
    {
      localboj.DLN = true;
      locals.hAr = localboj;
      locals.dtM = 536870912;
      o.aCI().c(locals);
    }
    label337:
    AppMethodBeat.o(89443);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.n
 * JD-Core Version:    0.7.0.1
 */