package com.tencent.mm.plugin.masssend.ui;

import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.plugin.mmsight.model.l;
import com.tencent.mm.protocal.c.avn;
import com.tencent.mm.sdk.platformtools.ai;

final class MassSendMsgUI$15
  implements Runnable
{
  MassSendMsgUI$15(MassSendMsgUI paramMassSendMsgUI, String paramString, int paramInt) {}
  
  public final void run()
  {
    VideoTransPara localVideoTransPara = d.Nl().Nm();
    avn localavn = new avn();
    localavn.tra = true;
    if (l.a(this.kjY, localVideoTransPara, localavn, new MassSendMsgUI.15.1(this))) {
      l.b(this.kjY, localVideoTransPara, localavn, new MassSendMsgUI.15.2(this));
    }
    ai.d(new MassSendMsgUI.15.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.MassSendMsgUI.15
 * JD-Core Version:    0.7.0.1
 */