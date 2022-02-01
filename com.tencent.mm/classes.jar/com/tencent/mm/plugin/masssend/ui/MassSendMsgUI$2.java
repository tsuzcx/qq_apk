package com.tencent.mm.plugin.masssend.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.plugin.mmsight.model.e;
import com.tencent.mm.plugin.mmsight.model.m;
import com.tencent.mm.protocal.protobuf.bxm;
import com.tencent.mm.sdk.platformtools.aq;

final class MassSendMsgUI$2
  implements Runnable
{
  MassSendMsgUI$2(MassSendMsgUI paramMassSendMsgUI, String paramString, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(26448);
    VideoTransPara localVideoTransPara = d.aGQ().aGR();
    bxm localbxm = new bxm();
    localbxm.GRA = true;
    if (m.a(this.rFp, localVideoTransPara, localbxm, new e()
    {
      public final boolean dlg()
      {
        return false;
      }
    })) {
      m.b(this.rFp, localVideoTransPara, localbxm, new e()
      {
        public final boolean dlg()
        {
          return false;
        }
      });
    }
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(26447);
        MassSendMsgUI.a(MassSendMsgUI.2.this.vIe, MassSendMsgUI.2.this.rFp, MassSendMsgUI.2.this.leQ);
        AppMethodBeat.o(26447);
      }
    });
    AppMethodBeat.o(26448);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.MassSendMsgUI.2
 * JD-Core Version:    0.7.0.1
 */