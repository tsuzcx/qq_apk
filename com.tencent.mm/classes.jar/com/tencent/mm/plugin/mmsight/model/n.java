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
import com.tencent.mm.protocal.protobuf.byg;
import com.tencent.mm.sdk.platformtools.ae;

public final class n
  implements w
{
  public final void Hx(String paramString)
  {
    AppMethodBeat.i(89443);
    final s locals = o.aNh().HD(paramString);
    if (locals == null)
    {
      AppMethodBeat.o(89443);
      return;
    }
    o.aNh();
    final String str = t.HJ(paramString);
    byg localbyg = locals.ixi;
    VideoTransPara localVideoTransPara = d.aHh().aHi();
    if (localbyg != null)
    {
      ae.i("MicroMsg.MMSightVideoMsgSendCallback", "beforeVideoSend count %d filename %s filePath %s", new Object[] { Integer.valueOf(localbyg.sVm), paramString, str });
      if (localbyg.sVm > 1)
      {
        u.HR(paramString);
        AppMethodBeat.o(89443);
        return;
      }
    }
    boolean bool2 = m.a(str, localVideoTransPara, localbyg, new e()
    {
      public final boolean dog()
      {
        AppMethodBeat.i(89441);
        ae.i("MicroMsg.MMSightVideoMsgSendCallback", "iUpdateVideoFile1 %s", new Object[] { str });
        int i = t.HL(str);
        locals.hPI = i;
        locals.dEu = 32;
        o.aNh().c(locals);
        AppMethodBeat.o(89441);
        return true;
      }
    });
    if (localbyg != null)
    {
      ae.i("MicroMsg.MMSightVideoMsgSendCallback", "filename: %s need ret: %s", new Object[] { paramString, Boolean.valueOf(bool2) });
      if (bool2) {
        break label298;
      }
    }
    label298:
    for (boolean bool1 = true;; bool1 = false)
    {
      localbyg.Hle = bool1;
      locals.ixi = localbyg;
      locals.dEu = 536870912;
      o.aNh().c(locals);
      if (!bool2) {
        break label337;
      }
      if (localbyg != null)
      {
        localbyg.sVm += 1;
        locals.ixi = localbyg;
      }
      locals.dEu = 536870912;
      o.aNh().c(locals);
      c.KD(locals.iwZ);
      if (m.b(str, localVideoTransPara, localbyg, new e()
      {
        public final boolean dog()
        {
          AppMethodBeat.i(89442);
          c.KE(locals.iwZ);
          ae.i("MicroMsg.MMSightVideoMsgSendCallback", "iUpdateVideoFile2 %s", new Object[] { str });
          int i = t.HL(str);
          locals.hPI = i;
          locals.dEu = 32;
          o.aNh().c(locals);
          AppMethodBeat.o(89442);
          return true;
        }
      }) >= 0) {
        break;
      }
      ae.i("MicroMsg.MMSightRecorderIDKeyStat", "mark720CapturePostCompressFailed");
      g.yxI.idkeyStat(440L, 45L, 1L, false);
      u.HR(paramString);
      AppMethodBeat.o(89443);
      return;
    }
    if (localbyg != null)
    {
      localbyg.Hle = true;
      locals.ixi = localbyg;
      locals.dEu = 536870912;
      o.aNh().c(locals);
    }
    label337:
    AppMethodBeat.o(89443);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.n
 * JD-Core Version:    0.7.0.1
 */