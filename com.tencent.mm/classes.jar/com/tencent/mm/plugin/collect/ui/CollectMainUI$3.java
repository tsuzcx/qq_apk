package com.tencent.mm.plugin.collect.ui;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.cb.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class CollectMainUI$3
  implements Runnable
{
  CollectMainUI$3(CollectMainUI paramCollectMainUI) {}
  
  public final void run()
  {
    int i = a.fromDPToPix(this.iLP.mController.uMN, 37);
    ViewGroup.LayoutParams localLayoutParams = CollectMainUI.k(this.iLP).getLayoutParams();
    if (localLayoutParams != null)
    {
      localLayoutParams.height = i;
      CollectMainUI.k(this.iLP).setLayoutParams(localLayoutParams);
      CollectMainUI.k(this.iLP).requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectMainUI.3
 * JD-Core Version:    0.7.0.1
 */