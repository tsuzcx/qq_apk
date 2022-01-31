package com.tencent.mm.plugin.appbrand.widget.picker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.appbrand.jsapi.n.b;

public class d
  extends RelativeLayout
{
  private static final int jsB;
  d.b jsA;
  private final int jsu;
  private final int jsv;
  private b jsw;
  private FrameLayout jsx;
  private d.a jsy;
  private boolean jsz;
  
  static
  {
    AppMethodBeat.i(126740);
    jsB = Color.parseColor("#F9F9F9");
    AppMethodBeat.o(126740);
  }
  
  public d(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(126730);
    this.jsu = a.fromDPToPix(paramContext, 48);
    this.jsv = a.fromDPToPix(paramContext, 240);
    setClickable(true);
    setLongClickable(true);
    paramContext = new RelativeLayout.LayoutParams(-1, this.jsv);
    paramContext.addRule(12);
    Object localObject = new FrameLayout(getContext());
    ((FrameLayout)localObject).setId(2131820572);
    ((FrameLayout)localObject).setOnClickListener(new d.4(this));
    ((FrameLayout)localObject).setBackgroundColor(jsB);
    this.jsx = ((FrameLayout)localObject);
    addView((View)localObject, paramContext);
    paramContext = new RelativeLayout.LayoutParams(-1, this.jsu);
    paramContext.addRule(2, 2131820572);
    localObject = new RelativeLayout(getContext());
    View localView = dA(2131301359, 2131690139);
    localView.setOnClickListener(new d.1(this));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -1);
    localLayoutParams.addRule(11);
    ((RelativeLayout)localObject).addView(localView, localLayoutParams);
    localView = dA(2131301358, 2131689819);
    localView.setOnClickListener(new d.2(this));
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -1);
    localLayoutParams.addRule(9);
    ((RelativeLayout)localObject).addView(localView, localLayoutParams);
    ((RelativeLayout)localObject).setOnClickListener(new d.3(this));
    ((RelativeLayout)localObject).setBackgroundColor(jsB);
    addView((View)localObject, paramContext);
    AppMethodBeat.o(126730);
  }
  
  private void aRS()
  {
    this.jsy = null;
    this.jsA = null;
  }
  
  private void c(boolean paramBoolean, Object paramObject)
  {
    AppMethodBeat.i(126729);
    if ((!this.jsz) && (this.jsy != null))
    {
      this.jsz = true;
      this.jsy.b(paramBoolean, paramObject);
      this.jsz = false;
    }
    AppMethodBeat.o(126729);
  }
  
  private View dA(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126737);
    TextView localTextView = new TextView(new ContextThemeWrapper(getContext(), 2131493044));
    localTextView.setTextColor(getResources().getColor(paramInt2));
    localTextView.setText(paramInt1);
    localTextView.setGravity(17);
    AppMethodBeat.o(126737);
    return localTextView;
  }
  
  @SuppressLint({"WrongCall"})
  protected final void dz(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126735);
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(126735);
  }
  
  protected final int getPanelContentHeight()
  {
    return this.jsu + this.jsv;
  }
  
  public b getPicker()
  {
    return this.jsw;
  }
  
  public void hide()
  {
    AppMethodBeat.i(126733);
    super.setVisibility(8);
    c(false, null);
    if (this.jsw != null) {
      this.jsw.aEs();
    }
    AppMethodBeat.o(126733);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(126738);
    super.onDetachedFromWindow();
    aRS();
    removeAllViews();
    AppMethodBeat.o(126738);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126736);
    if (!isShown())
    {
      super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(0, -2147483648));
      AppMethodBeat.o(126736);
      return;
    }
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.jsu + this.jsv, 1073741824));
    AppMethodBeat.o(126736);
  }
  
  public void setOnResultListener(d.a parama)
  {
    this.jsy = parama;
  }
  
  public void setOnValueUpdateListener(d.b paramb)
  {
    this.jsA = paramb;
  }
  
  protected void setPickerImpl(b paramb)
  {
    AppMethodBeat.i(126731);
    if (this.jsw != null) {
      this.jsw.aEt();
    }
    this.jsw = paramb;
    if (this.jsw != null) {
      this.jsw.b(this);
    }
    if ((this.jsx == null) || (this.jsw == null) || (this.jsw.getView() == null))
    {
      AppMethodBeat.o(126731);
      return;
    }
    this.jsx.removeAllViews();
    aRS();
    paramb = new FrameLayout.LayoutParams(-1, -2);
    paramb.gravity = 17;
    this.jsx.addView(this.jsw.getView(), paramb);
    AppMethodBeat.o(126731);
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(126734);
    if (paramInt != 0)
    {
      hide();
      AppMethodBeat.o(126734);
      return;
    }
    super.setVisibility(paramInt);
    AppMethodBeat.o(126734);
  }
  
  public void show()
  {
    AppMethodBeat.i(126732);
    if (this.jsw == null)
    {
      setVisibility(8);
      AppMethodBeat.o(126732);
      return;
    }
    setVisibility(0);
    if (this.jsw != null) {
      this.jsw.a(this);
    }
    AppMethodBeat.o(126732);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.d
 * JD-Core Version:    0.7.0.1
 */