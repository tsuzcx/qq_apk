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
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.appbrand.s.m;
import com.tencent.mm.ui.statusbar.c;
import com.tencent.mm.ui.statusbar.c.a;

@SuppressLint({"ViewConstructor"})
public final class l
  extends LinearLayout
  implements c.a
{
  public final com.tencent.luggage.sdk.d.b bEZ;
  private final a[] iPu;
  private final SparseArray<b> iPw;
  private final SparseArray<b> iPx;
  private int iPy;
  
  public l(Context paramContext, com.tencent.luggage.sdk.d.b paramb)
  {
    super(paramContext);
    AppMethodBeat.i(102341);
    this.bEZ = paramb;
    this.iPw = new SparseArray();
    this.iPx = new SparseArray();
    this.iPu = new a[4];
    setClickable(false);
    int i = getContext().getResources().getDisplayMetrics().widthPixels;
    int j = a.fromDPToPix(getContext(), 10);
    int k = a.fromDPToPix(getContext(), 4);
    paramContext = new FrameLayout.LayoutParams(i * 3 / 5, -2);
    paramContext.gravity = 53;
    setLayoutParams(paramContext);
    aMs();
    setPadding(j, j, j, j);
    setOrientation(1);
    paramContext = new GradientDrawable();
    paramContext.setCornerRadius(k);
    paramContext.setColor(-652403418);
    setBackground(paramContext);
    paramContext = new LinearLayout.LayoutParams(-1, -2);
    paramb = new LinearLayout.LayoutParams(-1, 2);
    TextView localTextView = new TextView(getContext());
    View localView = new View(getContext());
    localTextView.setTextColor(-1);
    localTextView.setLayoutParams(paramContext);
    localTextView.setTextSize(1, 14.0F);
    localTextView.setText(getContext().getString(2131296775));
    addView(localTextView);
    paramb.setMargins(0, a.fromDPToPix(getContext(), 10), 0, 0);
    localView.setLayoutParams(paramb);
    localView.setBackgroundColor(1728053247);
    addView(localView);
    aMt();
    c.aH((Activity)getContext()).a(this);
    AppMethodBeat.o(102341);
  }
  
  private void aMs()
  {
    AppMethodBeat.i(102342);
    if ((getLayoutParams() != null) && ((getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
    {
      ((ViewGroup.MarginLayoutParams)getLayoutParams()).topMargin = (com.tencent.mm.plugin.appbrand.widget.b.di(getContext()) + this.iPy);
      requestLayout();
    }
    AppMethodBeat.o(102342);
  }
  
  private void aMt()
  {
    AppMethodBeat.i(102343);
    int i = 0;
    while (i < 4)
    {
      a locala = new a(getContext());
      locala.setText(getContext().getString(com.tencent.mm.plugin.appbrand.performance.d.iAU[i]));
      this.iPu[i] = locala;
      addView(locala);
      i += 1;
    }
    AppMethodBeat.o(102343);
  }
  
  public final void ae(int paramInt, String paramString)
  {
    AppMethodBeat.i(102344);
    m.runOnUiThread(new l.2(this, paramInt, paramString));
    AppMethodBeat.o(102344);
  }
  
  public final void cU(String paramString1, String paramString2)
  {
    AppMethodBeat.i(102345);
    m.runOnUiThread(new l.3(this, paramString1, paramString2));
    AppMethodBeat.o(102345);
  }
  
  public final void pB(int paramInt)
  {
    AppMethodBeat.i(102346);
    this.iPy = paramInt;
    aMs();
    AppMethodBeat.o(102346);
  }
  
  @SuppressLint({"AppCompatCustomView"})
  final class a
    extends TextView
  {
    public a(Context paramContext)
    {
      super();
      AppMethodBeat.i(102336);
      this$1 = new LinearLayout.LayoutParams(-1, -2);
      int i = a.fromDPToPix(getContext(), 5);
      l.this.setMargins(0, i, 0, i);
      setLayoutParams(l.this);
      setTextSize(1, 12.0F);
      setTextColor(-7171438);
      AppMethodBeat.o(102336);
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
      AppMethodBeat.i(102337);
      setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
      setTextSize(1, 12.0F);
      setTextColor(-419430401);
      AppMethodBeat.o(102337);
    }
    
    private void update()
    {
      AppMethodBeat.i(102338);
      setText(String.format("%s: %s", new Object[] { this.mTitle, this.mValue }));
      AppMethodBeat.o(102338);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.l
 * JD-Core Version:    0.7.0.1
 */