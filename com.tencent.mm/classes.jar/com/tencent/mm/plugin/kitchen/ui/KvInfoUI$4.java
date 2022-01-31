package com.tencent.mm.plugin.kitchen.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class KvInfoUI$4
  implements View.OnClickListener
{
  KvInfoUI$4(KvInfoUI paramKvInfoUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(114444);
    paramView = KvInfoUI.a(this.nXL).getText().toString().trim();
    KvInfoUI.a(this.nXL, paramView);
    AppMethodBeat.o(114444);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.kitchen.ui.KvInfoUI.4
 * JD-Core Version:    0.7.0.1
 */