package com.tencent.mm.plugin.appbrand.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
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
import com.tencent.luggage.m.a.a;
import com.tencent.luggage.m.a.g;
import com.tencent.luggage.sdk.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.appbrand.af.o;
import com.tencent.mm.plugin.appbrand.widget.b;
import com.tencent.mm.ui.statusbar.c;
import com.tencent.mm.ui.statusbar.c.a;

public final class aa
  extends LinearLayout
  implements c.a
{
  public final d etN;
  private int mStatusBarHeight;
  private final a[] ufx;
  private final SparseArray<b> ufy;
  private final SparseArray<b> ufz;
  
  public aa(Context paramContext, d paramd)
  {
    super(paramContext);
    AppMethodBeat.i(147701);
    this.etN = paramd;
    this.ufy = new SparseArray();
    this.ufz = new SparseArray();
    this.ufx = new a[4];
    setClickable(false);
    int i = getContext().getResources().getDisplayMetrics().widthPixels;
    int j = a.fromDPToPix(getContext(), 10);
    int k = a.fromDPToPix(getContext(), 4);
    paramContext = new FrameLayout.LayoutParams(i * 3 / 5, -2);
    paramContext.gravity = 53;
    setLayoutParams(paramContext);
    cLD();
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
    cLE();
    c.ch((Activity)getContext()).a(this);
    AppMethodBeat.o(147701);
  }
  
  private void cLD()
  {
    AppMethodBeat.i(147702);
    if ((getLayoutParams() != null) && ((getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
    {
      ((ViewGroup.MarginLayoutParams)getLayoutParams()).topMargin = (b.fs(getContext()) + this.mStatusBarHeight);
      requestLayout();
    }
    AppMethodBeat.o(147702);
  }
  
  private void cLE()
  {
    AppMethodBeat.i(147703);
    int i = 0;
    while (i < 4)
    {
      a locala = new a(getContext());
      locala.setText(getContext().getString(com.tencent.mm.plugin.appbrand.performance.d.tDN[i]));
      this.ufx[i] = locala;
      addView(locala);
      i += 1;
    }
    AppMethodBeat.o(147703);
  }
  
  public final void aK(final int paramInt, final String paramString)
  {
    AppMethodBeat.i(147704);
    o.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(147692);
        aa.a(aa.this, paramInt, paramString);
        AppMethodBeat.o(147692);
      }
    });
    AppMethodBeat.o(147704);
  }
  
  public final void fq(final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(147705);
    o.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(147693);
        aa.a(aa.this, paramString1, paramString2);
        AppMethodBeat.o(147693);
      }
    });
    AppMethodBeat.o(147705);
  }
  
  public final void onStatusBarHeightChange(int paramInt)
  {
    AppMethodBeat.i(147706);
    this.mStatusBarHeight = paramInt;
    cLD();
    AppMethodBeat.o(147706);
  }
  
  final class a
    extends TextView
  {
    public a(Context paramContext)
    {
      super();
      AppMethodBeat.i(147694);
      this$1 = new LinearLayout.LayoutParams(-1, -2);
      int i = a.fromDPToPix(getContext(), 5);
      aa.this.setMargins(0, i, 0, i);
      setLayoutParams(aa.this);
      setTextSize(1, 12.0F);
      setTextColor(getContext().getResources().getColor(a.a.desc_text_color));
      AppMethodBeat.o(147694);
    }
  }
  
  final class b
    extends TextView
  {
    private String lWc;
    private String mTitle;
    
    public b(Context paramContext)
    {
      super();
      AppMethodBeat.i(147696);
      setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
      setTextSize(1, 12.0F);
      setTextColor(getContext().getResources().getColor(a.a.BW_100_Alpha_0_9));
      AppMethodBeat.o(147696);
    }
    
    private void update()
    {
      AppMethodBeat.i(147697);
      setText(String.format("%s: %s", new Object[] { this.mTitle, this.lWc }));
      AppMethodBeat.o(147697);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.aa
 * JD-Core Version:    0.7.0.1
 */