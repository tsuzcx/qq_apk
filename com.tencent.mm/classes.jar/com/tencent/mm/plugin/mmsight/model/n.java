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
import com.tencent.mm.protocal.protobuf.cly;
import com.tencent.mm.sdk.platformtools.Log;

public final class n
  implements w
{
  public final void Qk(String paramString)
  {
    AppMethodBeat.i(89443);
    final s locals = o.bhj().Qq(paramString);
    if (locals == null)
    {
      AppMethodBeat.o(89443);
      return;
    }
    o.bhj();
    final String str = t.Qw(paramString);
    cly localcly = locals.jsx;
    VideoTransPara localVideoTransPara = com.tencent.mm.modelcontrol.e.baZ().bba();
    if (localcly != null)
    {
      Log.i("MicroMsg.MMSightVideoMsgSendCallback", "beforeVideoSend count %d filename %s filePath %s", new Object[] { Integer.valueOf(localcly.vUh), paramString, str });
      if (localcly.vUh > 1)
      {
        u.QE(paramString);
        AppMethodBeat.o(89443);
        return;
      }
    }
    boolean bool2 = m.a(str, localVideoTransPara, localcly, new e()
    {
      public final boolean ehT()
      {
        AppMethodBeat.i(89441);
        Log.i("MicroMsg.MMSightVideoMsgSendCallback", "iUpdateVideoFile1 %s", new Object[] { str });
        int i = t.Qy(str);
        locals.iKP = i;
        locals.cSx = 32;
        o.bhj().c(locals);
        AppMethodBeat.o(89441);
        return true;
      }
    });
    if (localcly != null)
    {
      Log.i("MicroMsg.MMSightVideoMsgSendCallback", "filename: %s need ret: %s", new Object[] { paramString, Boolean.valueOf(bool2) });
      if (bool2) {
        break label298;
      }
    }
    label298:
    for (boolean bool1 = true;; bool1 = false)
    {
      localcly.Mrq = bool1;
      locals.jsx = localcly;
      locals.cSx = 536870912;
      o.bhj().c(locals);
      if (!bool2) {
        break label337;
      }
      if (localcly != null)
      {
        localcly.vUh += 1;
        locals.jsx = localcly;
      }
      locals.cSx = 536870912;
      o.bhj().c(locals);
      c.QE(locals.jso);
      if (m.b(str, localVideoTransPara, localcly, new e()
      {
        public final boolean ehT()
        {
          AppMethodBeat.i(89442);
          c.QF(locals.jso);
          Log.i("MicroMsg.MMSightVideoMsgSendCallback", "iUpdateVideoFile2 %s", new Object[] { str });
          int i = t.Qy(str);
          locals.iKP = i;
          locals.cSx = 32;
          o.bhj().c(locals);
          AppMethodBeat.o(89442);
          return true;
        }
      }) >= 0) {
        break;
      }
      Log.i("MicroMsg.MMSightRecorderIDKeyStat", "mark720CapturePostCompressFailed");
      h.CyF.idkeyStat(440L, 45L, 1L, false);
      u.QE(paramString);
      AppMethodBeat.o(89443);
      return;
    }
    if (localcly != null)
    {
      localcly.Mrq = true;
      locals.jsx = localcly;
      locals.cSx = 536870912;
      o.bhj().c(locals);
    }
    label337:
    AppMethodBeat.o(89443);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.n
 * JD-Core Version:    0.7.0.1
 */