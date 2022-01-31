package com.tencent.mm.plugin.bottle.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;

final class a$1
  implements View.OnClickListener
{
  a$1(a parama) {}
  
  public final void onClick(View paramView)
  {
    y.v("MicroMsg.BottleConversationAdapter", "on delView clicked");
    this.hZh.hZg.bdc();
    if (this.hZh.hZf != null) {
      this.hZh.hZf.bg(paramView.getTag());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.ui.a.1
 * JD-Core Version:    0.7.0.1
 */