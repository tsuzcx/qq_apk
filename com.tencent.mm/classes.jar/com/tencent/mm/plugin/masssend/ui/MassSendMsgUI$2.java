package com.tencent.mm.plugin.masssend.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.plugin.mmsight.model.l;
import com.tencent.mm.protocal.protobuf.bby;
import com.tencent.mm.sdk.platformtools.al;

final class MassSendMsgUI$2
  implements Runnable
{
  MassSendMsgUI$2(MassSendMsgUI paramMassSendMsgUI, String paramString, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(153541);
    VideoTransPara localVideoTransPara = d.afW().afX();
    bby localbby = new bby();
    localbby.xra = true;
    if (l.a(this.mED, localVideoTransPara, localbby, new MassSendMsgUI.2.1(this))) {
      l.b(this.mED, localVideoTransPara, localbby, new MassSendMsgUI.2.2(this));
    }
    al.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(153540);
        MassSendMsgUI.a(MassSendMsgUI.2.this.oCj, MassSendMsgUI.2.this.mED, MassSendMsgUI.2.this.hXH);
        AppMethodBeat.o(153540);
      }
    });
    AppMethodBeat.o(153541);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.MassSendMsgUI.2
 * JD-Core Version:    0.7.0.1
 */