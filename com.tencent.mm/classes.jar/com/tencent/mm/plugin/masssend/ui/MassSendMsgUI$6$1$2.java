package com.tencent.mm.plugin.masssend.ui;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.p;

final class MassSendMsgUI$6$1$2
  implements Runnable
{
  MassSendMsgUI$6$1$2(MassSendMsgUI.6.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(153544);
    Toast.makeText(this.oCo.oCn.oCj, this.oCo.oCn.oCj.getString(2131304514), 0).show();
    if (MassSendMsgUI.d(this.oCo.oCn.oCj) != null)
    {
      MassSendMsgUI.d(this.oCo.oCn.oCj).dismiss();
      MassSendMsgUI.e(this.oCo.oCn.oCj);
    }
    AppMethodBeat.o(153544);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.MassSendMsgUI.6.1.2
 * JD-Core Version:    0.7.0.1
 */