package com.tencent.mm.plugin.masssend.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.l;
import com.tencent.mm.protocal.protobuf.dmb;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

final class MassSendMsgUI$2
  implements Runnable
{
  MassSendMsgUI$2(MassSendMsgUI paramMassSendMsgUI, String paramString, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(26448);
    VideoTransPara localVideoTransPara = com.tencent.mm.modelcontrol.e.bIg().bIh();
    dmb localdmb = new dmb();
    localdmb.aaSg = true;
    if (l.a(this.Aqm, localVideoTransPara, localdmb, new com.tencent.mm.plugin.mmsight.model.e()
    {
      public final boolean gaj()
      {
        return false;
      }
    })) {
      l.b(this.Aqm, localVideoTransPara, localdmb, new com.tencent.mm.plugin.mmsight.model.e()
      {
        public final boolean gaj()
        {
          return false;
        }
      });
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(26447);
        MassSendMsgUI.a(MassSendMsgUI.2.this.KOj, MassSendMsgUI.2.this.Aqm, MassSendMsgUI.2.this.srg);
        AppMethodBeat.o(26447);
      }
    });
    AppMethodBeat.o(26448);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.MassSendMsgUI.2
 * JD-Core Version:    0.7.0.1
 */