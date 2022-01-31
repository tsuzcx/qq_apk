package com.tencent.mm.plugin.mmsight.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.modelvideo.w;
import com.tencent.mm.plugin.mmsight.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bby;
import com.tencent.mm.sdk.platformtools.ab;

public final class m
  implements w
{
  public final void uX(String paramString)
  {
    AppMethodBeat.i(76542);
    final s locals = o.alE().vd(paramString);
    if (locals == null)
    {
      AppMethodBeat.o(76542);
      return;
    }
    o.alE();
    final String str = t.vf(paramString);
    bby localbby = locals.fXH;
    VideoTransPara localVideoTransPara = com.tencent.mm.modelcontrol.d.afW().afX();
    if (localbby != null)
    {
      ab.i("MicroMsg.MMSightVideoMsgSendCallback", "beforeVideoSend count %d filename %s filePath %s", new Object[] { Integer.valueOf(localbby.xrb), paramString, str });
      if (localbby.xrb > 1)
      {
        u.vk(paramString);
        AppMethodBeat.o(76542);
        return;
      }
    }
    boolean bool2 = l.a(str, localVideoTransPara, localbby, new d()
    {
      public final boolean bPn()
      {
        AppMethodBeat.i(76540);
        ab.i("MicroMsg.MMSightVideoMsgSendCallback", "iUpdateVideoFile1 %s", new Object[] { str });
        int i = t.vh(str);
        locals.fsd = i;
        locals.bsY = 32;
        o.alE().c(locals);
        AppMethodBeat.o(76540);
        return true;
      }
    });
    if (localbby != null)
    {
      ab.i("MicroMsg.MMSightVideoMsgSendCallback", "filename: %s need ret: %s", new Object[] { paramString, Boolean.valueOf(bool2) });
      if (bool2) {
        break label298;
      }
    }
    label298:
    for (boolean bool1 = true;; bool1 = false)
    {
      localbby.xre = bool1;
      locals.fXH = localbby;
      locals.bsY = 536870912;
      o.alE().c(locals);
      if (!bool2) {
        break label337;
      }
      if (localbby != null)
      {
        localbby.xrb += 1;
        locals.fXH = localbby;
      }
      locals.bsY = 536870912;
      o.alE().c(locals);
      c.zk(locals.fXy);
      if (l.b(str, localVideoTransPara, localbby, new d()
      {
        public final boolean bPn()
        {
          AppMethodBeat.i(76541);
          c.zl(locals.fXy);
          ab.i("MicroMsg.MMSightVideoMsgSendCallback", "iUpdateVideoFile2 %s", new Object[] { str });
          int i = t.vh(str);
          locals.fsd = i;
          locals.bsY = 32;
          o.alE().c(locals);
          AppMethodBeat.o(76541);
          return true;
        }
      }) >= 0) {
        break;
      }
      ab.i("MicroMsg.MMSightRecorderIDKeyStat", "mark720CapturePostCompressFailed");
      h.qsU.idkeyStat(440L, 45L, 1L, false);
      u.vk(paramString);
      AppMethodBeat.o(76542);
      return;
    }
    if (localbby != null)
    {
      localbby.xre = true;
      locals.fXH = localbby;
      locals.bsY = 536870912;
      o.alE().c(locals);
    }
    label337:
    AppMethodBeat.o(76542);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.m
 * JD-Core Version:    0.7.0.1
 */