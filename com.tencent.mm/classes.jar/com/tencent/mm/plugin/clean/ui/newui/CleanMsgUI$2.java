package com.tencent.mm.plugin.clean.ui.newui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.clean.c.d;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;

final class CleanMsgUI$2
  implements View.OnClickListener
{
  CleanMsgUI$2(CleanMsgUI paramCleanMsgUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(18889);
    h.d(this.kJo, this.kJo.getString(2131298391, new Object[] { bo.nV(d.bgT()) }), "", this.kJo.getString(2131297018), this.kJo.getString(2131296888), new CleanMsgUI.2.1(this), null);
    AppMethodBeat.o(18889);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.newui.CleanMsgUI.2
 * JD-Core Version:    0.7.0.1
 */