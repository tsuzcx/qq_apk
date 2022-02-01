package com.tencent.mm.plugin.mmsight.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.aa;
import com.tencent.mm.modelvideo.ab;
import com.tencent.mm.modelvideo.ad;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.modelvideo.z;
import com.tencent.mm.plugin.mmsight.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.dmb;
import com.tencent.mm.sdk.platformtools.Log;

public final class m
  implements ad
{
  public final void PJ(String paramString)
  {
    AppMethodBeat.i(89443);
    final z localz = v.bOh().PR(paramString);
    if (localz == null)
    {
      AppMethodBeat.o(89443);
      return;
    }
    v.bOh();
    final String str = aa.PX(paramString);
    dmb localdmb = localz.pbl;
    VideoTransPara localVideoTransPara = com.tencent.mm.modelcontrol.e.bIg().bIh();
    if (localdmb != null)
    {
      Log.i("MicroMsg.MMSightVideoMsgSendCallback", "beforeVideoSend count %d filename %s filePath %s", new Object[] { Integer.valueOf(localdmb.Gad), paramString, str });
      if (localdmb.Gad > 1)
      {
        ab.Qf(paramString);
        AppMethodBeat.o(89443);
        return;
      }
    }
    boolean bool2 = l.a(str, localVideoTransPara, localdmb, new e()
    {
      public final boolean gaj()
      {
        AppMethodBeat.i(89441);
        Log.i("MicroMsg.MMSightVideoMsgSendCallback", "iUpdateVideoFile1 %s", new Object[] { str });
        int i = aa.PZ(str);
        localz.osy = i;
        localz.eQp = 32;
        v.bOh().c(localz);
        AppMethodBeat.o(89441);
        return true;
      }
    });
    if (localdmb != null)
    {
      Log.i("MicroMsg.MMSightVideoMsgSendCallback", "filename: %s need ret: %s", new Object[] { paramString, Boolean.valueOf(bool2) });
      if (bool2) {
        break label298;
      }
    }
    label298:
    for (boolean bool1 = true;; bool1 = false)
    {
      localdmb.aaSj = bool1;
      localz.pbl = localdmb;
      localz.eQp = 536870912;
      v.bOh().c(localz);
      if (!bool2) {
        break label337;
      }
      if (localdmb != null)
      {
        localdmb.Gad += 1;
        localz.pbl = localdmb;
      }
      localz.eQp = 536870912;
      v.bOh().c(localz);
      c.aaU(localz.pbc);
      if (l.b(str, localVideoTransPara, localdmb, new e()
      {
        public final boolean gaj()
        {
          AppMethodBeat.i(89442);
          c.aaV(localz.pbc);
          Log.i("MicroMsg.MMSightVideoMsgSendCallback", "iUpdateVideoFile2 %s", new Object[] { str });
          int i = aa.PZ(str);
          localz.osy = i;
          localz.eQp = 32;
          v.bOh().c(localz);
          AppMethodBeat.o(89442);
          return true;
        }
      }) >= 0) {
        break;
      }
      Log.i("MicroMsg.MMSightRecorderIDKeyStat", "mark720CapturePostCompressFailed");
      h.OAn.idkeyStat(440L, 45L, 1L, false);
      ab.Qf(paramString);
      AppMethodBeat.o(89443);
      return;
    }
    if (localdmb != null)
    {
      localdmb.aaSj = true;
      localz.pbl = localdmb;
      localz.eQp = 536870912;
      v.bOh().c(localz);
    }
    label337:
    AppMethodBeat.o(89443);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.m
 * JD-Core Version:    0.7.0.1
 */