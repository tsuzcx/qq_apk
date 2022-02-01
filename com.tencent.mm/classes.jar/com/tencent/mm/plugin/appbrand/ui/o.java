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
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.appbrand.aa.l;
import com.tencent.mm.plugin.appbrand.widget.b;
import com.tencent.mm.ui.statusbar.c.a;

@SuppressLint({"ViewConstructor"})
public final class o
  extends LinearLayout
  implements c.a
{
  public final com.tencent.luggage.sdk.d.c chU;
  private final a[] lDh;
  private final SparseArray<b> lDi;
  private final SparseArray<b> lDj;
  private int lDk;
  
  public o(Context paramContext, com.tencent.luggage.sdk.d.c paramc)
  {
    super(paramContext);
    AppMethodBeat.i(147701);
    this.chU = paramc;
    this.lDi = new SparseArray();
    this.lDj = new SparseArray();
    this.lDh = new a[4];
    setClickable(false);
    int i = getContext().getResources().getDisplayMetrics().widthPixels;
    int j = a.fromDPToPix(getContext(), 10);
    int k = a.fromDPToPix(getContext(), 4);
    paramContext = new FrameLayout.LayoutParams(i * 3 / 5, -2);
    paramContext.gravity = 53;
    setLayoutParams(paramContext);
    boD();
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
    boE();
    com.tencent.mm.ui.statusbar.c.bj((Activity)getContext()).a(this);
    AppMethodBeat.o(147701);
  }
  
  private void boD()
  {
    AppMethodBeat.i(147702);
    if ((getLayoutParams() != null) && ((getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
    {
      ((ViewGroup.MarginLayoutParams)getLayoutParams()).topMargin = (b.dL(getContext()) + this.lDk);
      requestLayout();
    }
    AppMethodBeat.o(147702);
  }
  
  private void boE()
  {
    AppMethodBeat.i(147703);
    int i = 0;
    while (i < 4)
    {
      a locala = new a(getContext());
      locala.setText(getContext().getString(com.tencent.mm.plugin.appbrand.performance.d.lhN[i]));
      this.lDh[i] = locala;
      addView(locala);
      i += 1;
    }
    AppMethodBeat.o(147703);
  }
  
  public final void ar(final int paramInt, final String paramString)
  {
    AppMethodBeat.i(147704);
    l.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(147692);
        o.a(o.this, paramInt, paramString);
        AppMethodBeat.o(147692);
      }
    });
    AppMethodBeat.o(147704);
  }
  
  public final void dV(final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(147705);
    l.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(147693);
        o.a(o.this, paramString1, paramString2);
        AppMethodBeat.o(147693);
      }
    });
    AppMethodBeat.o(147705);
  }
  
  public final void sG(int paramInt)
  {
    AppMethodBeat.i(147706);
    this.lDk = paramInt;
    boD();
    AppMethodBeat.o(147706);
  }
  
  @SuppressLint({"AppCompatCustomView"})
  final class a
    extends TextView
  {
    public a(Context paramContext)
    {
      super();
      AppMethodBeat.i(147694);
      this$1 = new LinearLayout.LayoutParams(-1, -2);
      int i = a.fromDPToPix(getContext(), 5);
      o.this.setMargins(0, i, 0, i);
      setLayoutParams(o.this);
      setTextSize(1, 12.0F);
      setTextColor(getContext().getResources().getColor(2131100212));
      AppMethodBeat.o(147694);
    }
  }
  
  @SuppressLint({"AppCompatCustomView"})
  final class b
    extends TextView
  {
    private String mTitle;
    private String mValue;
    
    public b(Context paramContext)
    {
      super();
      AppMethodBeat.i(147696);
      setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
      setTextSize(1, 12.0F);
      setTextColor(getContext().getResources().getColor(2131099674));
      AppMethodBeat.o(147696);
    }
    
    private void update()
    {
      AppMethodBeat.i(147697);
      setText(String.format("%s: %s", new Object[] { this.mTitle, this.mValue }));
      AppMethodBeat.o(147697);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.o
 * JD-Core Version:    0.7.0.1
 */