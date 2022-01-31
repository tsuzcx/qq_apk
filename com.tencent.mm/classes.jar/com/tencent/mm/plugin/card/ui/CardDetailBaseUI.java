package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.card.a.a;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.f;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.statusbar.DrawStatusBarActivity;
import com.tencent.mm.ui.y;

public abstract class CardDetailBaseUI
  extends DrawStatusBarActivity
{
  private TextView haW;
  private View heP;
  private ImageView irM;
  private TextView irN;
  ImageView irO;
  private View irP;
  
  public final void J(int paramInt, boolean paramBoolean)
  {
    this.heP.setBackgroundColor(paramInt);
    if (paramBoolean)
    {
      this.haW.setTextColor(getResources().getColor(a.a.black));
      this.irN.setTextColor(getResources().getColor(a.a.black));
      this.irM.setImageResource(a.f.actionbar_icon_dark_back);
      this.irO.setImageResource(a.c.card_mm_title_btn_menu);
      this.irP.setBackgroundColor(getResources().getColor(a.a.actionbar_devider_color));
      return;
    }
    this.haW.setTextColor(getResources().getColor(a.a.white));
    this.irN.setTextColor(getResources().getColor(a.a.white));
    this.irM.setImageResource(a.f.actionbar_icon_dark_back);
    this.irO.setImageResource(a.c.mm_title_btn_menu);
    this.irP.setBackgroundColor(getResources().getColor(a.a.half_alpha_white));
  }
  
  public final void ey(boolean paramBoolean)
  {
    ImageView localImageView = this.irO;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      return;
    }
  }
  
  public final boolean noActionBar()
  {
    return false;
  }
  
  public final void oX(int paramInt)
  {
    this.haW.setTextColor(paramInt);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.heP = y.gt(this.mController.uMN).inflate(a.e.card_detail_action_bar, null);
    this.heP.setBackgroundColor(getResources().getColor(a.a.action_bar_color));
    this.haW = ((TextView)this.heP.findViewById(a.d.title_area));
    this.irN = ((TextView)this.heP.findViewById(a.d.sub_title_area));
    this.irM = ((ImageView)this.heP.findViewById(a.d.arrow_area_btn));
    this.irO = ((ImageView)this.heP.findViewById(a.d.menu_icon));
    this.irP = this.heP.findViewById(a.d.divider);
    LinearLayout localLinearLayout;
    Object localObject;
    if ((this.mController.contentView != null) && (((ViewGroup)this.mController.contentView).getChildCount() > 0))
    {
      paramBundle = ((ViewGroup)this.mController.contentView).getChildAt(0);
      ((ViewGroup)this.mController.contentView).removeView(paramBundle);
      localLinearLayout = new LinearLayout(this);
      localLinearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      localLinearLayout.setOrientation(1);
      localObject = getResources().getDisplayMetrics();
      if (((DisplayMetrics)localObject).widthPixels <= ((DisplayMetrics)localObject).heightPixels) {
        break label281;
      }
    }
    label281:
    for (int i = getResources().getDimensionPixelSize(a.b.DefaultActionbarHeightLand);; i = getResources().getDimensionPixelSize(a.b.DefaultActionbarHeightPort))
    {
      localObject = new LinearLayout.LayoutParams(-1, i);
      localLinearLayout.addView(this.heP, (ViewGroup.LayoutParams)localObject);
      localLinearLayout.addView(paramBundle);
      ((ViewGroup)this.mController.contentView).addView(localLinearLayout);
      return;
    }
  }
  
  protected final void onCreateBeforeSetContentView()
  {
    super.onCreateBeforeSetContentView();
    supportRequestWindowFeature(10);
    supportRequestWindowFeature(1);
  }
  
  public final void setBackBtn(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.irM.setOnClickListener(new CardDetailBaseUI.1(this, paramOnMenuItemClickListener));
  }
  
  public final void setMMSubTitle(String paramString)
  {
    this.irN.setText(paramString);
  }
  
  public final void setMMTitle(String paramString)
  {
    this.haW.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardDetailBaseUI
 * JD-Core Version:    0.7.0.1
 */