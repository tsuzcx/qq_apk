package com.tencent.mm.plugin.collect.reward.ui;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMEditText;

final class QrRewardMainUI$10
  implements TextView.OnEditorActionListener
{
  QrRewardMainUI$10(QrRewardMainUI paramQrRewardMainUI) {}
  
  public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(41093);
    ab.i("MicroMsg.QrRewardMainUI", "action: %s", new Object[] { Integer.valueOf(paramInt) });
    QrRewardMainUI.a(this.kPN, QrRewardMainUI.a(this.kPN).getText().toString());
    QrRewardMainUI.b(this.kPN);
    if (bo.isNullOrNil(QrRewardMainUI.c(this.kPN))) {
      QrRewardMainUI.a(this.kPN, true);
    }
    this.kPN.hideVKB();
    AppMethodBeat.o(41093);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI.10
 * JD-Core Version:    0.7.0.1
 */