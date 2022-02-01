package com.tencent.mm.plugin.masssend.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.m;
import com.tencent.mm.protocal.protobuf.cly;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

final class MassSendMsgUI$2
  implements Runnable
{
  MassSendMsgUI$2(MassSendMsgUI paramMassSendMsgUI, String paramString, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(26448);
    VideoTransPara localVideoTransPara = com.tencent.mm.modelcontrol.e.baZ().bba();
    cly localcly = new cly();
    localcly.Mrn = true;
    if (m.a(this.tnl, localVideoTransPara, localcly, new com.tencent.mm.plugin.mmsight.model.e()
    {
      public final boolean ehT()
      {
        return false;
      }
    })) {
      m.b(this.tnl, localVideoTransPara, localcly, new com.tencent.mm.plugin.mmsight.model.e()
      {
        public final boolean ehT()
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
        MassSendMsgUI.a(MassSendMsgUI.2.this.zoo, MassSendMsgUI.2.this.tnl, MassSendMsgUI.2.this.moi);
        AppMethodBeat.o(26447);
      }
    });
    AppMethodBeat.o(26448);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.MassSendMsgUI.2
 * JD-Core Version:    0.7.0.1
 */