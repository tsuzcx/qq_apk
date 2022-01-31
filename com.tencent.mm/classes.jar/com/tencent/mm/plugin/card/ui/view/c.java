package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.ui.n;
import com.tencent.mm.protocal.c.mg;
import com.tencent.mm.protocal.c.tw;

public final class c
  extends i
{
  private View ixN;
  private TextView ixO;
  
  public final void aCU()
  {
    if (this.ixN != null) {
      this.ixN.setVisibility(8);
    }
  }
  
  public final void initView() {}
  
  public final void update()
  {
    if (this.ixN == null)
    {
      this.ixN = ((ViewStub)findViewById(a.d.card_ad_title_layout_stub)).inflate();
      this.ixO = ((TextView)this.ixN.findViewById(a.d.card_ad_title_tv));
    }
    this.ixN.setVisibility(0);
    this.ixN.setOnClickListener(this.iya.aBI());
    b localb = this.iya.aBE();
    if (!TextUtils.isEmpty(localb.azx().sII.sQJ))
    {
      this.ixO.setText(localb.azx().sII.sQJ);
      return;
    }
    this.ixO.setText(getString(a.g.card_membership_right_see_default_wording));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.c
 * JD-Core Version:    0.7.0.1
 */