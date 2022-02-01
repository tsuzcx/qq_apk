package com.tencent.mm.plugin.mmsight.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.aa;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.w;
import com.tencent.mm.modelvideo.x;
import com.tencent.mm.modelvideo.y;
import com.tencent.mm.plugin.mmsight.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.cuv;
import com.tencent.mm.sdk.platformtools.Log;

public final class m
  implements aa
{
  public final void XH(String paramString)
  {
    AppMethodBeat.i(89443);
    final w localw = s.bqB().XN(paramString);
    if (localw == null)
    {
      AppMethodBeat.o(89443);
      return;
    }
    s.bqB();
    final String str = x.XT(paramString);
    cuv localcuv = localw.mia;
    VideoTransPara localVideoTransPara = com.tencent.mm.modelcontrol.e.bkp().bkq();
    if (localcuv != null)
    {
      Log.i("MicroMsg.MMSightVideoMsgSendCallback", "beforeVideoSend count %d filename %s filePath %s", new Object[] { Integer.valueOf(localcuv.ABK), paramString, str });
      if (localcuv.ABK > 1)
      {
        y.Yb(paramString);
        AppMethodBeat.o(89443);
        return;
      }
    }
    boolean bool2 = l.a(str, localVideoTransPara, localcuv, new e()
    {
      public final boolean eRA()
      {
        AppMethodBeat.i(89441);
        Log.i("MicroMsg.MMSightVideoMsgSendCallback", "iUpdateVideoFile1 %s", new Object[] { str });
        int i = x.XV(str);
        localw.lAW = i;
        localw.cUP = 32;
        s.bqB().c(localw);
        AppMethodBeat.o(89441);
        return true;
      }
    });
    if (localcuv != null)
    {
      Log.i("MicroMsg.MMSightVideoMsgSendCallback", "filename: %s need ret: %s", new Object[] { paramString, Boolean.valueOf(bool2) });
      if (bool2) {
        break label298;
      }
    }
    label298:
    for (boolean bool1 = true;; bool1 = false)
    {
      localcuv.TCD = bool1;
      localw.mia = localcuv;
      localw.cUP = 536870912;
      s.bqB().c(localw);
      if (!bool2) {
        break label337;
      }
      if (localcuv != null)
      {
        localcuv.ABK += 1;
        localw.mia = localcuv;
      }
      localw.cUP = 536870912;
      s.bqB().c(localw);
      c.WS(localw.mhR);
      if (l.b(str, localVideoTransPara, localcuv, new e()
      {
        public final boolean eRA()
        {
          AppMethodBeat.i(89442);
          c.WT(localw.mhR);
          Log.i("MicroMsg.MMSightVideoMsgSendCallback", "iUpdateVideoFile2 %s", new Object[] { str });
          int i = x.XV(str);
          localw.lAW = i;
          localw.cUP = 32;
          s.bqB().c(localw);
          AppMethodBeat.o(89442);
          return true;
        }
      }) >= 0) {
        break;
      }
      Log.i("MicroMsg.MMSightRecorderIDKeyStat", "mark720CapturePostCompressFailed");
      h.IzE.idkeyStat(440L, 45L, 1L, false);
      y.Yb(paramString);
      AppMethodBeat.o(89443);
      return;
    }
    if (localcuv != null)
    {
      localcuv.TCD = true;
      localw.mia = localcuv;
      localw.cUP = 536870912;
      s.bqB().c(localw);
    }
    label337:
    AppMethodBeat.o(89443);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.m
 * JD-Core Version:    0.7.0.1
 */