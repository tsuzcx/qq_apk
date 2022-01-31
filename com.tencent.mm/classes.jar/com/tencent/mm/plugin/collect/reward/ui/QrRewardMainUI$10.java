package com.tencent.mm.plugin.collect.reward.ui;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.sdk.platformtools.y;

final class QrRewardMainUI$10
  implements TextView.OnEditorActionListener
{
  QrRewardMainUI$10(QrRewardMainUI paramQrRewardMainUI) {}
  
  public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    y.i("MicroMsg.QrRewardMainUI", "action: %s", new Object[] { Integer.valueOf(paramInt) });
    this.iJi.XM();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI.10
 * JD-Core Version:    0.7.0.1
 */