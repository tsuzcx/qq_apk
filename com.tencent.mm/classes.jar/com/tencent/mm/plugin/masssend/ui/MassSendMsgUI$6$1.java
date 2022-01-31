package com.tencent.mm.plugin.masssend.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.al;

final class MassSendMsgUI$6$1
  implements Runnable
{
  MassSendMsgUI$6$1(MassSendMsgUI.6 param6, String paramString1, String paramString2, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(153545);
    if (MassSendMsgUI.a(this.oCn.oCj, this.cbL, this.oCm))
    {
      al.d(new MassSendMsgUI.6.1.1(this));
      AppMethodBeat.o(153545);
      return;
    }
    al.d(new MassSendMsgUI.6.1.2(this));
    AppMethodBeat.o(153545);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.MassSendMsgUI.6.1
 * JD-Core Version:    0.7.0.1
 */