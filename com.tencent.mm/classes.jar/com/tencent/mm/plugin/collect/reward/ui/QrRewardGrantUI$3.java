package com.tencent.mm.plugin.collect.reward.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class QrRewardGrantUI$3
  implements View.OnClickListener
{
  QrRewardGrantUI$3(QrRewardGrantUI paramQrRewardGrantUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(41065);
    boolean bool = QrRewardGrantUI.c(this.kPo).isChecked();
    paramView = QrRewardGrantUI.c(this.kPo);
    if (!bool) {}
    for (bool = true;; bool = false)
    {
      paramView.setChecked(bool);
      AppMethodBeat.o(41065);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardGrantUI.3
 * JD-Core Version:    0.7.0.1
 */