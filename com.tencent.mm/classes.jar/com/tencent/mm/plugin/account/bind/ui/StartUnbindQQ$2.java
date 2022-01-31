package com.tencent.mm.plugin.account.bind.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.c;

final class StartUnbindQQ$2
  implements View.OnClickListener
{
  StartUnbindQQ$2(StartUnbindQQ paramStartUnbindQQ) {}
  
  public final void onClick(View paramView)
  {
    if (StartUnbindQQ.a(this.feJ) == null)
    {
      StartUnbindQQ.a(this.feJ, h.a(this.feJ, this.feJ.getString(a.i.setting_unbinding_confirm), null, new StartUnbindQQ.2.1(this), new StartUnbindQQ.2.2(this)));
      return;
    }
    StartUnbindQQ.a(this.feJ).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.StartUnbindQQ.2
 * JD-Core Version:    0.7.0.1
 */