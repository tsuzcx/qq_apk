package com.tencent.mm.plugin.collect.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet_core.ui.m;

final class CollectMainUI$18
  implements View.OnClickListener
{
  CollectMainUI$18(CollectMainUI paramCollectMainUI, m paramm1, m paramm2) {}
  
  public final void onClick(View paramView)
  {
    if (CollectMainUI.g(this.iLP).getText().toString().equals(CollectMainUI.i(this.iLP)))
    {
      this.iLW.onClick(paramView);
      return;
    }
    this.iLX.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectMainUI.18
 * JD-Core Version:    0.7.0.1
 */