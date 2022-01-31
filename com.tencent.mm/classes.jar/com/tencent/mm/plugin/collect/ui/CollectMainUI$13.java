package com.tencent.mm.plugin.collect.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.a.d;
import java.util.List;

final class CollectMainUI$13
  implements View.OnClickListener
{
  CollectMainUI$13(CollectMainUI paramCollectMainUI, List paramList) {}
  
  public final void onClick(View paramView)
  {
    paramView = new d(this.iLP.mController.uMN, 1, false);
    paramView.phH = new CollectMainUI.13.1(this);
    paramView.phI = new CollectMainUI.13.2(this);
    paramView.cfU();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectMainUI.13
 * JD-Core Version:    0.7.0.1
 */