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
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;

public abstract class CardDetailBaseUI
  extends MMActivity
{
  private TextView mPa;
  private ImageView nZa;
  private View nZg;
  private TextView pYW;
  private ImageView pYX;
  private View pYY;
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.nZg = aa.jQ(getContext()).inflate(2131493356, null);
    this.nZg.setBackgroundColor(getResources().getColor(2131099891));
    this.mPa = ((TextView)this.nZg.findViewById(2131309202));
    this.pYW = ((TextView)this.nZg.findViewById(2131308718));
    this.nZa = ((ImageView)this.nZg.findViewById(2131297047));
    this.pYX = ((ImageView)this.nZg.findViewById(2131304616));
    this.pYY = this.nZg.findViewById(2131299682);
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
    for (int i = getResources().getDimensionPixelSize(2131165255);; i = getResources().getDimensionPixelSize(2131165256))
    {
      localObject = new LinearLayout.LayoutParams(-1, i);
      localLinearLayout.addView(this.nZg, (ViewGroup.LayoutParams)localObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardDetailBaseUI
 * JD-Core Version:    0.7.0.1
 */