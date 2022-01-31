package com.tencent.mm.plugin.card.ui.view;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.ui.n;
import com.tencent.mm.protocal.c.lv;
import com.tencent.mm.protocal.c.mg;
import com.tencent.mm.protocal.c.ra;
import com.tencent.mm.ui.MMActivity;

public final class u
  extends i
{
  private View iyv;
  
  public final void aCU()
  {
    if (this.iyv != null) {
      this.iyv.setVisibility(8);
    }
  }
  
  public final void initView() {}
  
  public final void update()
  {
    if (this.iyv == null) {
      this.iyv = ((ViewStub)findViewById(a.d.card_operate_field_layout_stub)).inflate();
    }
    b localb = this.iya.aBE();
    MMActivity localMMActivity = this.iya.aBH();
    Object localObject = localb.azy().sHF;
    TextView localTextView1;
    TextView localTextView2;
    LinearLayout localLinearLayout;
    LinearLayout.LayoutParams localLayoutParams1;
    LinearLayout.LayoutParams localLayoutParams2;
    if (this.iyv != null)
    {
      localTextView1 = (TextView)this.iyv.findViewById(a.d.card_operate_field_title_tv);
      localTextView1.setText(((ra)localObject).title);
      localTextView1.setTextColor(l.yR(localb.azx().color));
      localTextView2 = (TextView)this.iyv.findViewById(a.d.card_operate_field_aux_title_tv);
      localLinearLayout = (LinearLayout)this.iyv.findViewById(a.d.card_widget_operate_field_layout);
      localLayoutParams1 = (LinearLayout.LayoutParams)localLinearLayout.getLayoutParams();
      if (!localb.azf()) {
        break label418;
      }
      localLayoutParams2 = (LinearLayout.LayoutParams)localTextView1.getLayoutParams();
      if (TextUtils.isEmpty(((ra)localObject).ilr)) {
        break label393;
      }
      localTextView2.setText(((ra)localObject).ilr);
      localTextView2.setVisibility(0);
      localLayoutParams1.height = localMMActivity.getResources().getDimensionPixelOffset(a.b.card_member_operate_field_layout_height_with_aux_title);
      localLayoutParams2.bottomMargin = localMMActivity.getResources().getDimensionPixelSize(a.b.BasicPaddingSize);
      localObject = (LinearLayout.LayoutParams)localTextView2.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).topMargin = localMMActivity.getResources().getDimensionPixelSize(a.b.BasicPaddingSize);
      localTextView2.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localTextView2.invalidate();
    }
    for (;;)
    {
      localLayoutParams2.height = localMMActivity.getResources().getDimensionPixelSize(a.b.card_member_operate_field_title_height);
      localTextView1.setLayoutParams(localLayoutParams2);
      localTextView1.invalidate();
      int i = localMMActivity.getResources().getDimensionPixelSize(a.b.card_member_widget_bg_round_radius);
      localTextView1.setBackgroundDrawable(l.f(localMMActivity, localb.azx().color, i));
      localTextView1.setTextColor(l.ac(localMMActivity, localb.azx().color));
      localLinearLayout.setBackgroundDrawable(null);
      localTextView1.setOnClickListener(this.iya.aBI());
      localLinearLayout.setLayoutParams(localLayoutParams1);
      localLinearLayout.invalidate();
      this.iyv.invalidate();
      if (localb.azf()) {
        localLinearLayout.getLayoutParams();
      }
      return;
      label393:
      localTextView2.setVisibility(8);
      localLayoutParams1.height = localMMActivity.getResources().getDimensionPixelOffset(a.b.card_member_operate_field_layout_height_with_no_aux_title);
    }
    label418:
    if (!TextUtils.isEmpty(((ra)localObject).ilr))
    {
      localTextView2.setText(((ra)localObject).ilr);
      localTextView2.setVisibility(0);
    }
    for (localLayoutParams1.height = localMMActivity.getResources().getDimensionPixelOffset(a.b.card_operate_field_layout_height_with_aux_title);; localLayoutParams1.height = localMMActivity.getResources().getDimensionPixelOffset(a.b.card_operate_field_layout_height_with_no_aux_title))
    {
      localLinearLayout.setOnClickListener(this.iya.aBI());
      break;
      localTextView2.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.u
 * JD-Core Version:    0.7.0.1
 */