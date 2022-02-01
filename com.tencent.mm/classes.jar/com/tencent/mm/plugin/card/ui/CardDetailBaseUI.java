package com.tencent.mm.plugin.card.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.a.a;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ad;

public abstract class CardDetailBaseUI
  extends MMActivity
{
  private TextView pPT;
  private ImageView raL;
  private View raR;
  private TextView tuS;
  private ImageView tuT;
  private View tuU;
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.raR = ad.kS(getContext()).inflate(a.e.thX, null);
    this.raR.setBackgroundColor(getResources().getColor(a.a.action_bar_color));
    this.pPT = ((TextView)this.raR.findViewById(a.d.title_area));
    this.tuS = ((TextView)this.raR.findViewById(a.d.sub_title_area));
    this.raL = ((ImageView)this.raR.findViewById(a.d.arrow_area_btn));
    this.tuT = ((ImageView)this.raR.findViewById(a.d.menu_icon));
    this.tuU = this.raR.findViewById(a.d.divider);
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
        break label263;
      }
    }
    label263:
    for (int i = getResources().getDimensionPixelSize(a.b.DefaultActionbarHeightLand);; i = getResources().getDimensionPixelSize(a.b.DefaultActionbarHeightPort))
    {
      localObject = new LinearLayout.LayoutParams(-1, i);
      localLinearLayout.addView(this.raR, (ViewGroup.LayoutParams)localObject);
      localLinearLayout.addView(paramBundle);
      ((ViewGroup)getContentView()).addView(localLinearLayout);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardDetailBaseUI
 * JD-Core Version:    0.7.0.1
 */