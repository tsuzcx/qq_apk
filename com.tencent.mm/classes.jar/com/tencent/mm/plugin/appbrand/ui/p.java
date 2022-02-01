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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.plugin.appbrand.widget.b;
import com.tencent.mm.plugin.appbrand.z.m;
import com.tencent.mm.ui.statusbar.c.a;

@SuppressLint({"ViewConstructor"})
public final class p
  extends LinearLayout
  implements c.a
{
  public final com.tencent.luggage.sdk.d.c cpg;
  private final p.a[] mFC;
  private final SparseArray<p.b> mFD;
  private final SparseArray<p.b> mFE;
  private int mFF;
  
  public p(Context paramContext, com.tencent.luggage.sdk.d.c paramc)
  {
    super(paramContext);
    AppMethodBeat.i(147701);
    this.cpg = paramc;
    this.mFD = new SparseArray();
    this.mFE = new SparseArray();
    this.mFC = new p.a[4];
    setClickable(false);
    int i = getContext().getResources().getDisplayMetrics().widthPixels;
    int j = a.fromDPToPix(getContext(), 10);
    int k = a.fromDPToPix(getContext(), 4);
    paramContext = new FrameLayout.LayoutParams(i * 3 / 5, -2);
    paramContext.gravity = 53;
    setLayoutParams(paramContext);
    bzE();
    setPadding(j, j, j, j);
    setOrientation(1);
    paramContext = new GradientDrawable();
    paramContext.setCornerRadius(k);
    paramContext.setColor(-652403418);
    setBackground(paramContext);
    paramContext = new LinearLayout.LayoutParams(-1, -2);
    paramc = new LinearLayout.LayoutParams(-1, 2);
    TextView localTextView = new TextView(getContext());
    View localView = new View(getContext());
    localTextView.setTextColor(-1);
    localTextView.setLayoutParams(paramContext);
    localTextView.setTextSize(1, 14.0F);
    localTextView.setText(getContext().getString(2131755562));
    addView(localTextView);
    paramc.setMargins(0, a.fromDPToPix(getContext(), 10), 0, 0);
    localView.setLayoutParams(paramc);
    localView.setBackgroundColor(1728053247);
    addView(localView);
    bzF();
    com.tencent.mm.ui.statusbar.c.bm((Activity)getContext()).a(this);
    AppMethodBeat.o(147701);
  }
  
  private void bzE()
  {
    AppMethodBeat.i(147702);
    if ((getLayoutParams() != null) && ((getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
    {
      ((ViewGroup.MarginLayoutParams)getLayoutParams()).topMargin = (b.dT(getContext()) + this.mFF);
      requestLayout();
    }
    AppMethodBeat.o(147702);
  }
  
  private void bzF()
  {
    AppMethodBeat.i(147703);
    int i = 0;
    while (i < 4)
    {
      p.a locala = new p.a(this, getContext());
      locala.setText(getContext().getString(com.tencent.mm.plugin.appbrand.performance.d.mhr[i]));
      this.mFC[i] = locala;
      addView(locala);
      i += 1;
    }
    AppMethodBeat.o(147703);
  }
  
  public final void au(final int paramInt, final String paramString)
  {
    AppMethodBeat.i(147704);
    m.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(147692);
        p.a(p.this, paramInt, paramString);
        AppMethodBeat.o(147692);
      }
    });
    AppMethodBeat.o(147704);
  }
  
  public final void eq(final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(147705);
    m.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(147693);
        p.a(p.this, paramString1, paramString2);
        AppMethodBeat.o(147693);
      }
    });
    AppMethodBeat.o(147705);
  }
  
  public final void ua(int paramInt)
  {
    AppMethodBeat.i(147706);
    this.mFF = paramInt;
    bzE();
    AppMethodBeat.o(147706);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.p
 * JD-Core Version:    0.7.0.1
 */