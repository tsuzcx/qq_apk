package com.tencent.mm.plugin.collect.ui;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.tools.j;
import com.tencent.mm.ui.widget.a.d;

final class CollectMainUI$19
  implements View.OnLongClickListener
{
  CollectMainUI$19(CollectMainUI paramCollectMainUI) {}
  
  public final boolean onLongClick(View paramView)
  {
    if (CollectMainUI.b(this.iLP) == 0)
    {
      paramView = new j(this.iLP.mController.uMN);
      paramView.phH = new n.c()
      {
        public final void a(l paramAnonymousl)
        {
          paramAnonymousl.e(0, CollectMainUI.19.this.iLP.getString(a.i.collect_main_save));
        }
      };
      paramView.phI = new CollectMainUI.19.2(this);
      paramView.bJQ();
      return true;
    }
    paramView = new d(this.iLP.mController.uMN, 1, false);
    paramView.phH = new CollectMainUI.19.3(this);
    paramView.phI = new CollectMainUI.19.4(this);
    paramView.cfU();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectMainUI.19
 * JD-Core Version:    0.7.0.1
 */