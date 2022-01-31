package com.tencent.mm.plugin.mmsight.model;

import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.modelvideo.w;
import com.tencent.mm.plugin.mmsight.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.avn;
import com.tencent.mm.sdk.platformtools.y;

public final class m
  implements w
{
  public final void nK(String paramString)
  {
    final s locals = o.Sr().nQ(paramString);
    if (locals == null) {}
    avn localavn;
    label278:
    label283:
    do
    {
      return;
      o.Sr();
      final String str = t.nS(paramString);
      localavn = locals.eHR;
      VideoTransPara localVideoTransPara = com.tencent.mm.modelcontrol.d.Nl().Nm();
      if (localavn != null)
      {
        y.i("MicroMsg.MMSightVideoMsgSendCallback", "beforeVideoSend count %d filename %s filePath %s", new Object[] { Integer.valueOf(localavn.trb), paramString, str });
        if (localavn.trb > 1)
        {
          u.nX(paramString);
          return;
        }
      }
      boolean bool2 = l.a(str, localVideoTransPara, localavn, new d()
      {
        public final boolean bhA()
        {
          y.i("MicroMsg.MMSightVideoMsgSendCallback", "iUpdateVideoFile1 %s", new Object[] { str });
          int i = t.nU(str);
          locals.ebK = i;
          locals.bcw = 32;
          o.Sr().c(locals);
          return true;
        }
      });
      if (localavn != null)
      {
        y.i("MicroMsg.MMSightVideoMsgSendCallback", "filename: %s need ret: %s", new Object[] { paramString, Boolean.valueOf(bool2) });
        if (bool2) {
          break label278;
        }
      }
      for (boolean bool1 = true;; bool1 = false)
      {
        localavn.tre = bool1;
        locals.eHR = localavn;
        locals.bcw = 536870912;
        o.Sr().c(locals);
        if (!bool2) {
          break;
        }
        if (localavn != null)
        {
          localavn.trb += 1;
          locals.eHR = localavn;
        }
        locals.bcw = 536870912;
        o.Sr().c(locals);
        c.tR(locals.eHI);
        if (l.b(str, localVideoTransPara, localavn, new d()
        {
          public final boolean bhA()
          {
            c.tS(locals.eHI);
            y.i("MicroMsg.MMSightVideoMsgSendCallback", "iUpdateVideoFile2 %s", new Object[] { str });
            int i = t.nU(str);
            locals.ebK = i;
            locals.bcw = 32;
            o.Sr().c(locals);
            return true;
          }
        }) >= 0) {
          break label283;
        }
        y.i("MicroMsg.MMSightRecorderIDKeyStat", "mark720CapturePostCompressFailed");
        h.nFQ.a(440L, 45L, 1L, false);
        u.nX(paramString);
        return;
      }
    } while (localavn == null);
    localavn.tre = true;
    locals.eHR = localavn;
    locals.bcw = 536870912;
    o.Sr().c(locals);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.m
 * JD-Core Version:    0.7.0.1
 */