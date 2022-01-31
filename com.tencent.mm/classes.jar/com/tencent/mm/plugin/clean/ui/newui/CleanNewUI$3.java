package com.tencent.mm.plugin.clean.ui.newui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class CleanNewUI$3
  implements View.OnClickListener
{
  CleanNewUI$3(CleanNewUI paramCleanNewUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(18913);
    ab.i("MicroMsg.CleanNewUI", "clean wechat cache");
    AppMethodBeat.o(18913);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.newui.CleanNewUI.3
 * JD-Core Version:    0.7.0.1
 */