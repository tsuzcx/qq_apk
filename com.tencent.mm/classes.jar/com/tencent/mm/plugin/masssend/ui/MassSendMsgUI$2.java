package com.tencent.mm.plugin.masssend.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.plugin.mmsight.model.e;
import com.tencent.mm.plugin.mmsight.model.m;
import com.tencent.mm.protocal.protobuf.boj;
import com.tencent.mm.sdk.platformtools.aq;

final class MassSendMsgUI$2
  implements Runnable
{
  MassSendMsgUI$2(MassSendMsgUI paramMassSendMsgUI, String paramString, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(26448);
    VideoTransPara localVideoTransPara = d.awT().awU();
    boj localboj = new boj();
    localboj.DLK = true;
    if (m.a(this.qmz, localVideoTransPara, localboj, new e()
    {
      public final boolean cOe()
      {
        return false;
      }
    })) {
      m.b(this.qmz, localVideoTransPara, localboj, new e()
      {
        public final boolean cOe()
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
        MassSendMsgUI.a(MassSendMsgUI.2.this.twM, MassSendMsgUI.2.this.qmz, MassSendMsgUI.2.this.khF);
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