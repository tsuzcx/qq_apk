package com.tencent.mm.plugin.card.ui;

import android.app.Activity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.statusbar.a;
import com.tencent.mm.ui.w;

public abstract class CardDetailBaseUI
  extends MMActivity
{
  private TextView iJG;
  private View iQc;
  private ImageView ksT;
  private TextView ksU;
  ImageView ksV;
  private View ksW;
  
  public final void Q(int paramInt, boolean paramBoolean)
  {
    this.iQc.setBackgroundColor(paramInt);
    if (paramBoolean)
    {
      this.iJG.setTextColor(getResources().getColor(2131689763));
      this.ksU.setTextColor(getResources().getColor(2131689763));
      this.ksT.setImageResource(2131230737);
      this.ksV.setImageResource(2130838153);
      this.ksW.setBackgroundColor(getResources().getColor(2131689647));
    }
    for (;;)
    {
      a.d(getContentView(), paramInt, paramBoolean);
      return;
      this.iJG.setTextColor(getResources().getColor(2131690709));
      this.ksU.setTextColor(getResources().getColor(2131690709));
      this.ksT.setImageResource(2131230737);
      this.ksV.setImageResource(2130839668);
      this.ksW.setBackgroundColor(getResources().getColor(2131690161));
    }
  }
  
  public final void fY(boolean paramBoolean)
  {
    ImageView localImageView = this.ksV;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      return;
    }
  }
  
  public boolean noActionBar()
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.iQc = w.hM(getContext()).inflate(2130968926, null);
    this.iQc.setBackgroundColor(getResources().getColor(2131689641));
    this.iJG = ((TextView)this.iQc.findViewById(2131820981));
    this.ksU = ((TextView)this.iQc.findViewById(2131820982));
    this.ksT = ((ImageView)this.iQc.findViewById(2131820980));
    this.ksV = ((ImageView)this.iQc.findViewById(2131822061));
    this.ksW = this.iQc.findViewById(2131821148);
    LinearLayout localLinearLayout;
    Object localObject;
    if ((getContentView() != null) && (((ViewGroup)getContentView()).getChildCount() > 0))
    {
      paramBundle = ((ViewGroup)getContentView()).getChildAt(0);
      ((ViewGroup)getContentView()).removeView(paramBundle);
      localLinearLayout = new LinearLayout(this);
      localLinearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      localLinearLayout.setOrientation(1);
      localObject = getResources().getDisplayMetrics();
      if (((DisplayMetrics)localObject).widthPixels <= ((DisplayMetrics)localObject).heightPixels) {
        break label255;
      }
    }
    label255:
    for (int i = getResources().getDimensionPixelSize(2131427558);; i = getResources().getDimensionPixelSize(2131427559))
    {
      localObject = new LinearLayout.LayoutParams(-1, i);
      localLinearLayout.addView(this.iQc, (ViewGroup.LayoutParams)localObject);
      localLinearLayout.addView(paramBundle);
      ((ViewGroup)getContentView()).addView(localLinearLayout);
      return;
    }
  }
  
  public void onCreateBeforeSetContentView()
  {
    super.onCreateBeforeSetContentView();
    supportRequestWindowFeature(10);
    supportRequestWindowFeature(1);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void setBackBtn(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.ksT.setOnClickListener(new CardDetailBaseUI.1(this, paramOnMenuItemClickListener));
  }
  
  public void setMMSubTitle(String paramString)
  {
    this.ksU.setText(paramString);
  }
  
  public void setMMTitle(String paramString)
  {
    this.iJG.setText(paramString);
  }
  
  public void setMMTitleColor(int paramInt)
  {
    this.iJG.setTextColor(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardDetailBaseUI
 * JD-Core Version:    0.7.0.1
 */