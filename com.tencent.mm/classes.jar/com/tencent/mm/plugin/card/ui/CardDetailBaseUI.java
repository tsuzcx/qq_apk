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
import com.tencent.mm.ui.y;

public abstract class CardDetailBaseUI
  extends MMActivity
{
  private TextView kEu;
  private ImageView lEt;
  private View lEz;
  private TextView nym;
  private ImageView nyn;
  private View nyo;
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.lEz = y.js(getContext()).inflate(2131493268, null);
    this.lEz.setBackgroundColor(getResources().getColor(2131099873));
    this.kEu = ((TextView)this.lEz.findViewById(2131305908));
    this.nym = ((TextView)this.lEz.findViewById(2131305509));
    this.lEt = ((ImageView)this.lEz.findViewById(2131296940));
    this.nyn = ((ImageView)this.lEz.findViewById(2131302241));
    this.nyo = this.lEz.findViewById(2131299154);
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
    for (int i = getResources().getDimensionPixelSize(2131165251);; i = getResources().getDimensionPixelSize(2131165252))
    {
      localObject = new LinearLayout.LayoutParams(-1, i);
      localLinearLayout.addView(this.lEz, (ViewGroup.LayoutParams)localObject);
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