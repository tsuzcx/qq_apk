package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.clean.c.j;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;

final class CleanMsgUI$2
  implements View.OnClickListener
{
  CleanMsgUI$2(CleanMsgUI paramCleanMsgUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(18799);
    h.a(this.kIC, this.kIC.getString(2131298391, new Object[] { bo.nV(j.bhb().kGt) }), "", this.kIC.getString(2131297018), this.kIC.getString(2131296888), new CleanMsgUI.2.1(this), null, 2131690391);
    AppMethodBeat.o(18799);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.CleanMsgUI.2
 * JD-Core Version:    0.7.0.1
 */