package com.tencent.mm.plugin.card.ui.view;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.card.a.a;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.b.f;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.ui.a.g;
import com.tencent.mm.plugin.card.ui.n;
import com.tencent.mm.protocal.c.ax;
import com.tencent.mm.protocal.c.mg;
import com.tencent.mm.protocal.c.zi;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;

public final class b
  extends i
{
  private MMActivity hxN;
  private com.tencent.mm.plugin.card.base.b ikk;
  private View ixI;
  private TextView ixJ;
  private g ixK;
  
  public final void aCU()
  {
    this.ixI.setVisibility(8);
  }
  
  public final void destroy()
  {
    super.destroy();
    this.hxN = null;
    this.ixK = null;
  }
  
  public final void initView()
  {
    this.hxN = this.iya.aBH();
    this.ixK = this.iya.aBJ();
  }
  
  public final void update()
  {
    if (this.ixI == null)
    {
      this.ixI = ((ViewStub)findViewById(a.d.card_accept_layout_stub)).inflate();
      this.ixI.findViewById(a.d.card_accept_btn).setOnClickListener(this.iya.aBI());
    }
    this.ikk = this.iya.aBE();
    this.ixK = this.iya.aBJ();
    boolean bool1 = this.ixK.aCt();
    boolean bool2 = this.ixK.aCu();
    Object localObject2;
    Object localObject1;
    int i;
    Object localObject3;
    Object localObject4;
    if (bool1)
    {
      this.ixI.setVisibility(0);
      y.i("MicroMsg.CardAcceptView", "updateAcceptView() acceptViewVisible:" + bool1 + " acceptViewEnabled:" + bool2);
      localObject2 = (Button)this.ixI.findViewById(a.d.card_accept_btn);
      localObject1 = this.ixI.findViewById(a.d.card_accept_layout);
      ((View)localObject1).setBackgroundDrawable(null);
      ((View)localObject1).setOnClickListener(null);
      i = this.hxN.getResources().getDimensionPixelSize(a.b.card_member_widget_bg_round_radius);
      if (!bool2) {
        break label1115;
      }
      if (!TextUtils.isEmpty(this.ikk.azx().sIz)) {
        ((Button)localObject2).setText(this.ikk.azx().sIz);
      }
      if (!this.ikk.azf()) {
        break label842;
      }
      ((Button)localObject2).setTextColor(l.yR(this.ikk.azx().color));
      localObject3 = l.b(this.hxN, l.yR(this.ikk.azx().color), i);
      localObject4 = l.cx(l.yR(this.ikk.azx().color), i);
      localObject1 = new StateListDrawable();
      ((StateListDrawable)localObject1).addState(new int[] { 16842919 }, (Drawable)localObject4);
      ((StateListDrawable)localObject1).addState(new int[0], (Drawable)localObject3);
      i = this.hxN.getResources().getColor(a.a.white);
      int j = l.yR(this.ikk.azx().color);
      localObject3 = new int[] { 16842919, 16842910 };
      localObject4 = new int[0];
      ((Button)localObject2).setBackgroundDrawable((Drawable)localObject1);
      ((Button)localObject2).setTextColor(new ColorStateList(new int[][] { localObject3, localObject4 }, new int[] { i, j }));
      localObject1 = (LinearLayout.LayoutParams)this.ixI.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject1).topMargin = this.hxN.getResources().getDimensionPixelSize(a.b.card_card_accept_layout_top_margin_for_member_acceptable);
      this.ixI.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.ixI.findViewById(a.d.divider_line).setVisibility(8);
      localObject1 = this.iya.aBM();
      localObject2 = (CheckBox)this.ixI.findViewById(a.d.card_follow_cbx);
      if ((((f)localObject1).azW() == null) || (!((f)localObject1).azW().ilB)) {
        break label824;
      }
      y.i("MicroMsg.CardAcceptView", "updateFollowBox() show followbox");
      ((CheckBox)localObject2).setVisibility(0);
      localObject3 = this.ikk.azx().sIK;
      if ((localObject3 == null) || (TextUtils.isEmpty(((zi)localObject3).text))) {
        break label808;
      }
      ((CheckBox)localObject2).setText(((zi)localObject3).text);
      ((CheckBox)localObject2).setChecked(((f)localObject1).azW().ilC);
      ((CheckBox)localObject2).setOnClickListener(new b.1(this, (f)localObject1));
      label616:
      if ((!this.ikk.azg()) && (!this.ikk.aze()))
      {
        if ((this.ikk.azx().sIL == null) || (bk.bl(this.ikk.azx().sIL.text))) {
          break label1454;
        }
        if (this.ixJ == null) {
          this.ixJ = ((TextView)this.ixI.findViewById(a.d.card_accept_guidance_tv));
        }
        this.ixJ.setText(this.ikk.azx().sIL.text);
        if (!bk.bl(this.ikk.azx().sIL.url))
        {
          this.ixJ.setOnClickListener(this.iya.aBI());
          this.ixJ.setTextColor(l.yR(this.ikk.azx().color));
        }
        this.ixJ.setVisibility(0);
      }
    }
    label808:
    label824:
    label842:
    label1115:
    while (this.ixJ == null)
    {
      return;
      y.i("MicroMsg.CardAcceptView", "updateAcceptView(), mAcceptCardView is Gone");
      this.ixI.setVisibility(8);
      return;
      ((CheckBox)localObject2).setText(((f)localObject1).azW().title);
      break;
      y.i("MicroMsg.CardAcceptView", "updateFollowBox() not show followbox");
      ((CheckBox)localObject2).setVisibility(8);
      break label616;
      if ((this.ikk.azg()) || (this.ikk.aze()) || (this.ikk.azh()))
      {
        localObject1 = l.cx(l.yR(this.ikk.azx().color), i);
        localObject3 = l.cx(l.bq(this.ikk.azx().color, 175), i);
        localObject4 = new StateListDrawable();
        ((StateListDrawable)localObject4).addState(new int[] { 16842919 }, (Drawable)localObject3);
        ((StateListDrawable)localObject4).addState(new int[0], (Drawable)localObject1);
        ((Button)localObject2).setBackgroundDrawable((Drawable)localObject4);
        ((Button)localObject2).setTextColor(this.hxN.getResources().getColor(a.a.white_text_color_selector));
        localObject1 = (LinearLayout.LayoutParams)((Button)localObject2).getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).width = -1;
        ((Button)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        break label616;
      }
      localObject1 = l.cx(l.yR(this.ikk.azx().color), i);
      localObject3 = l.cx(l.bq(this.ikk.azx().color, 175), i);
      localObject4 = new StateListDrawable();
      ((StateListDrawable)localObject4).addState(new int[] { 16842919 }, (Drawable)localObject3);
      ((StateListDrawable)localObject4).addState(new int[0], (Drawable)localObject1);
      ((Button)localObject2).setBackgroundDrawable((Drawable)localObject4);
      ((Button)localObject2).setTextColor(this.hxN.getResources().getColor(a.a.white_text_color_selector));
      break label616;
      this.ixI.setEnabled(false);
      ((View)localObject1).setEnabled(false);
      ((Button)localObject2).setEnabled(false);
      if (this.ikk.azf()) {}
      for (localObject1 = this.ikk.azx().sIz;; localObject1 = this.ixK.aCm())
      {
        ((Button)localObject2).setText((CharSequence)localObject1);
        if (!this.ikk.azf()) {
          break label1303;
        }
        ((Button)localObject2).setTextColor(l.bq(this.ikk.azx().color, 125));
        ((Button)localObject2).setBackgroundDrawable(l.b(this.hxN, l.bq(this.ikk.azx().color, 125), i));
        localObject1 = (LinearLayout.LayoutParams)this.ixI.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).topMargin = this.hxN.getResources().getDimensionPixelSize(a.b.card_card_accept_layout_top_margin_for_member_unacceptable);
        this.ixI.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.ixI.findViewById(a.d.divider_line).setVisibility(8);
        break;
      }
      if ((this.ikk.azg()) || (this.ikk.aze()) || (this.ikk.azh()))
      {
        ((Button)localObject2).setTextColor(this.hxN.getResources().getColor(a.a.grey_background_text_color));
        ((Button)localObject2).setBackgroundDrawable(l.z(this.hxN, this.hxN.getResources().getColor(a.a.card_accept_btn_disable_bg_color)));
        localObject1 = (LinearLayout.LayoutParams)((Button)localObject2).getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).width = -1;
        ((Button)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        break label616;
      }
      ((Button)localObject2).setTextColor(this.hxN.getResources().getColor(a.a.grey_background_text_color));
      ((Button)localObject2).setBackgroundDrawable(l.z(this.hxN, this.hxN.getResources().getColor(a.a.card_accept_btn_disable_bg_color)));
      break label616;
    }
    label1303:
    label1454:
    this.ixJ.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.b
 * JD-Core Version:    0.7.0.1
 */