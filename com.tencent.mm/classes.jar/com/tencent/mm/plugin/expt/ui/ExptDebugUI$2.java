package com.tencent.mm.plugin.expt.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.bk;

final class ExptDebugUI$2
  implements View.OnClickListener
{
  ExptDebugUI$2(ExptDebugUI paramExptDebugUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = ExptDebugUI.a(this.jJl).getText().toString().trim();
    ExptDebugUI.a(this.jJl, bk.getInt(paramView, 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.ui.ExptDebugUI.2
 * JD-Core Version:    0.7.0.1
 */