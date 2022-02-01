package com.tencent.mm.plugin.appbrand.ui;

import android.annotation.SuppressLint;
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
import com.tencent.luggage.l.a.g;
import com.tencent.luggage.sdk.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.widget.b;
import com.tencent.mm.ui.statusbar.c;
import com.tencent.mm.ui.statusbar.c.a;

@SuppressLint({"ViewConstructor"})
public final class u
  extends LinearLayout
  implements c.a
{
  public final d cBh;
  private int mStatusBarHeight;
  private final u.a[] qZw;
  private final SparseArray<u.b> qZx;
  private final SparseArray<u.b> qZy;
  
  public u(Context paramContext, d paramd)
  {
    super(paramContext);
    AppMethodBeat.i(147701);
    this.cBh = paramd;
    this.qZx = new SparseArray();
    this.qZy = new SparseArray();
    this.qZw = new u.a[4];
    setClickable(false);
    int i = getContext().getResources().getDisplayMetrics().widthPixels;
    int j = a.fromDPToPix(getContext(), 10);
    int k = a.fromDPToPix(getContext(), 4);
    paramContext = new FrameLayout.LayoutParams(i * 3 / 5, -2);
    paramContext.gravity = 53;
    setLayoutParams(paramContext);
    cko();
    setPadding(j, j, j, j);
    setOrientation(1);
    paramContext = new GradientDrawable();
    paramContext.setCornerRadius(k);
    paramContext.setColor(-652403418);
    setBackground(paramContext);
    paramContext = new LinearLayout.LayoutParams(-1, -2);
    paramd = new LinearLayout.LayoutParams(-1, 2);
    TextView localTextView = new TextView(getContext());
    View localView = new View(getContext());
    localTextView.setTextColor(-1);
    localTextView.setLayoutParams(paramContext);
    localTextView.setTextSize(1, 14.0F);
    localTextView.setText(getContext().getString(a.g.app_brand_performance_title));
    addView(localTextView);
    paramd.setMargins(0, a.fromDPToPix(getContext(), 10), 0, 0);
    localView.setLayoutParams(paramd);
    localView.setBackgroundColor(1728053247);
    addView(localView);
    ckp();
    c.bA((Activity)getContext()).a(this);
    AppMethodBeat.o(147701);
  }
  
  private void cko()
  {
    AppMethodBeat.i(147702);
    if ((getLayoutParams() != null) && ((getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
    {
      ((ViewGroup.MarginLayoutParams)getLayoutParams()).topMargin = (b.ew(getContext()) + this.mStatusBarHeight);
      requestLayout();
    }
    AppMethodBeat.o(147702);
  }
  
  private void ckp()
  {
    AppMethodBeat.i(147703);
    int i = 0;
    while (i < 4)
    {
      u.a locala = new u.a(this, getContext());
      locala.setText(getContext().getString(com.tencent.mm.plugin.appbrand.performance.d.qyS[i]));
      this.qZw[i] = locala;
      addView(locala);
      i += 1;
    }
    AppMethodBeat.o(147703);
  }
  
  public final void BF(int paramInt)
  {
    AppMethodBeat.i(147706);
    this.mStatusBarHeight = paramInt;
    cko();
    AppMethodBeat.o(147706);
  }
  
  public final void ay(final int paramInt, final String paramString)
  {
    AppMethodBeat.i(147704);
    m.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(147692);
        u.a(u.this, paramInt, paramString);
        AppMethodBeat.o(147692);
      }
    });
    AppMethodBeat.o(147704);
  }
  
  public final void eZ(final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(147705);
    m.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(147693);
        u.a(u.this, paramString1, paramString2);
        AppMethodBeat.o(147693);
      }
    });
    AppMethodBeat.o(147705);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.u
 * JD-Core Version:    0.7.0.1
 */