package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.ui.statusbar.c.a;

public final class j
  extends LinearLayout
  implements c.a
{
  private int heA;
  private final j.a[] hex;
  private final SparseArray<j.b> hey;
  private final SparseArray<j.b> hez;
  public final String mAppId;
  
  public j(Context paramContext, String paramString)
  {
    super(paramContext);
    this.mAppId = paramString;
    this.hey = new SparseArray();
    this.hez = new SparseArray();
    this.hex = new j.a[4];
    setClickable(false);
    int i = getContext().getResources().getDisplayMetrics().widthPixels;
    int j = com.tencent.mm.cb.a.fromDPToPix(getContext(), 10);
    int k = com.tencent.mm.cb.a.fromDPToPix(getContext(), 4);
    paramContext = new FrameLayout.LayoutParams(i * 3 / 5, -2);
    paramContext.gravity = 53;
    setLayoutParams(paramContext);
    apg();
    setPadding(j, j, j, j);
    setOrientation(1);
    paramContext = new GradientDrawable();
    paramContext.setCornerRadius(k);
    paramContext.setColor(-652403418);
    setBackground(paramContext);
    paramContext = new LinearLayout.LayoutParams(-1, -2);
    paramString = new LinearLayout.LayoutParams(-1, 2);
    TextView localTextView = new TextView(getContext());
    View localView = new View(getContext());
    localTextView.setTextColor(-1);
    localTextView.setLayoutParams(paramContext);
    localTextView.setTextSize(1, 14.0F);
    localTextView.setText(getContext().getString(y.j.app_brand_performance_title));
    addView(localTextView);
    paramString.setMargins(0, com.tencent.mm.cb.a.fromDPToPix(getContext(), 10), 0, 0);
    localView.setLayoutParams(paramString);
    localView.setBackgroundColor(1728053247);
    addView(localView);
    aph();
    com.tencent.mm.ui.statusbar.c.af((Activity)getContext()).a(this);
  }
  
  private void apg()
  {
    if ((getLayoutParams() != null) && ((getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
    {
      ((ViewGroup.MarginLayoutParams)getLayoutParams()).topMargin = (com.tencent.mm.plugin.appbrand.widget.a.cD(getContext()) + this.heA);
      requestLayout();
    }
  }
  
  private void aph()
  {
    int i = 0;
    while (i < 4)
    {
      j.a locala = new j.a(this, getContext());
      locala.setText(getContext().getString(com.tencent.mm.plugin.appbrand.performance.b.gWp[i]));
      this.hex[i] = locala;
      addView(locala);
      i += 1;
    }
  }
  
  public final void P(final int paramInt, final String paramString)
  {
    com.tencent.mm.plugin.appbrand.v.c.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        j.a(j.this, paramInt, paramString);
      }
    });
  }
  
  public final void cf(String paramString1, String paramString2)
  {
    com.tencent.mm.plugin.appbrand.v.c.runOnUiThread(new j.2(this, paramString1, paramString2));
  }
  
  public final void ml(int paramInt)
  {
    this.heA = paramInt;
    apg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.j
 * JD-Core Version:    0.7.0.1
 */