package com.tencent.mm.plugin.card.ui.view;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.mm.plugin.card.a.a;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.plugin.card.ui.n;
import com.tencent.mm.protocal.c.lv;
import com.tencent.mm.protocal.c.mg;
import com.tencent.mm.ui.MMActivity;

public final class y
  extends i
{
  private MMActivity hxN;
  private b ikk;
  private View iyJ;
  
  public final void aCU()
  {
    if (this.iyJ != null) {
      this.iyJ.setVisibility(8);
    }
  }
  
  public final void initView()
  {
    this.hxN = this.iya.aBH();
  }
  
  public final void update()
  {
    this.ikk = this.iya.aBE();
    if (this.iyJ == null) {
      this.iyJ = ((ViewStub)findViewById(a.d.card_status_layout_stub)).inflate();
    }
    if (this.ikk.azh()) {
      this.iyJ.setBackgroundDrawable(l.z(this.hxN, this.hxN.getResources().getColor(a.a.card_bottom_container_normal_color)));
    }
    TextView localTextView = (TextView)this.iyJ.findViewById(a.d.card_status_tv);
    if (this.ikk.azy() == null)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.CardStatusView", "updateState() mCardInfo.getDataInfo() == null");
      localTextView.setVisibility(8);
      return;
    }
    localTextView.setVisibility(0);
    localTextView.setTextColor(this.hxN.getResources().getColor(a.a.grey_background_text_color));
    if (!TextUtils.isEmpty(this.ikk.azx().sIO))
    {
      localTextView.setText(this.ikk.azx().sIO);
      return;
    }
    m.c(localTextView, this.ikk.azy().status);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.y
 * JD-Core Version:    0.7.0.1
 */