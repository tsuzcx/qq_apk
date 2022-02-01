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
import com.tencent.mm.protocal.protobuf.bsz;
import com.tencent.mm.sdk.platformtools.ac;

public final class n
  implements w
{
  public final void DO(String paramString)
  {
    AppMethodBeat.i(89443);
    final s locals = o.aJy().DT(paramString);
    if (locals == null)
    {
      AppMethodBeat.o(89443);
      return;
    }
    o.aJy();
    final String str = t.DV(paramString);
    bsz localbsz = locals.iaS;
    VideoTransPara localVideoTransPara = d.aDL().aDM();
    if (localbsz != null)
    {
      ac.i("MicroMsg.MMSightVideoMsgSendCallback", "beforeVideoSend count %d filename %s filePath %s", new Object[] { Integer.valueOf(localbsz.rNU), paramString, str });
      if (localbsz.rNU > 1)
      {
        u.Ea(paramString);
        AppMethodBeat.o(89443);
        return;
      }
    }
    boolean bool2 = m.a(str, localVideoTransPara, localbsz, new e()
    {
      public final boolean dbM()
      {
        AppMethodBeat.i(89441);
        ac.i("MicroMsg.MMSightVideoMsgSendCallback", "iUpdateVideoFile1 %s", new Object[] { str });
        int i = t.DX(str);
        locals.hux = i;
        locals.drx = 32;
        o.aJy().c(locals);
        AppMethodBeat.o(89441);
        return true;
      }
    });
    if (localbsz != null)
    {
      ac.i("MicroMsg.MMSightVideoMsgSendCallback", "filename: %s need ret: %s", new Object[] { paramString, Boolean.valueOf(bool2) });
      if (bool2) {
        break label298;
      }
    }
    label298:
    for (boolean bool1 = true;; bool1 = false)
    {
      localbsz.Fic = bool1;
      locals.iaS = localbsz;
      locals.drx = 536870912;
      o.aJy().c(locals);
      if (!bool2) {
        break label337;
      }
      if (localbsz != null)
      {
        localbsz.rNU += 1;
        locals.iaS = localbsz;
      }
      locals.drx = 536870912;
      o.aJy().c(locals);
      c.IG(locals.iaJ);
      if (m.b(str, localVideoTransPara, localbsz, new e()
      {
        public final boolean dbM()
        {
          AppMethodBeat.i(89442);
          c.IH(locals.iaJ);
          ac.i("MicroMsg.MMSightVideoMsgSendCallback", "iUpdateVideoFile2 %s", new Object[] { str });
          int i = t.DX(str);
          locals.hux = i;
          locals.drx = 32;
          o.aJy().c(locals);
          AppMethodBeat.o(89442);
          return true;
        }
      }) >= 0) {
        break;
      }
      ac.i("MicroMsg.MMSightRecorderIDKeyStat", "mark720CapturePostCompressFailed");
      h.wUl.idkeyStat(440L, 45L, 1L, false);
      u.Ea(paramString);
      AppMethodBeat.o(89443);
      return;
    }
    if (localbsz != null)
    {
      localbsz.Fic = true;
      locals.iaS = localbsz;
      locals.drx = 536870912;
      o.aJy().c(locals);
    }
    label337:
    AppMethodBeat.o(89443);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.n
 * JD-Core Version:    0.7.0.1
 */