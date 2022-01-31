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
import com.tencent.luggage.c.c.a.a;
import com.tencent.luggage.c.c.a.c;
import com.tencent.luggage.c.c.a.d;
import com.tencent.luggage.c.c.a.e;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.appbrand.jsapi.m.b;

public class d
  extends RelativeLayout
{
  private static final int hAm = Color.parseColor("#F9F9F9");
  private final int hAf;
  private final int hAg;
  private b hAh;
  private FrameLayout hAi;
  private d.a hAj;
  private boolean hAk;
  d.b hAl;
  
  public d(Context paramContext)
  {
    super(paramContext);
    this.hAf = a.fromDPToPix(paramContext, 48);
    this.hAg = a.fromDPToPix(paramContext, 240);
    setClickable(true);
    setLongClickable(true);
    paramContext = new RelativeLayout.LayoutParams(-1, this.hAg);
    paramContext.addRule(12);
    Object localObject = new FrameLayout(getContext());
    ((FrameLayout)localObject).setId(a.c.app_brand_picker_panel_internal_picker);
    ((FrameLayout)localObject).setOnClickListener(new d.4(this));
    ((FrameLayout)localObject).setBackgroundColor(hAm);
    this.hAi = ((FrameLayout)localObject);
    addView((View)localObject, paramContext);
    paramContext = new RelativeLayout.LayoutParams(-1, this.hAf);
    paramContext.addRule(2, a.c.app_brand_picker_panel_internal_picker);
    localObject = new RelativeLayout(getContext());
    View localView = cm(a.d.luggage_confirm_dialog_ok, a.a.green_text_color);
    localView.setOnClickListener(new d.1(this));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -1);
    localLayoutParams.addRule(11);
    ((RelativeLayout)localObject).addView(localView, localLayoutParams);
    localView = cm(a.d.luggage_confirm_dialog_cancel, a.a.cancel_btn_color);
    localView.setOnClickListener(new d.2(this));
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -1);
    localLayoutParams.addRule(9);
    ((RelativeLayout)localObject).addView(localView, localLayoutParams);
    ((RelativeLayout)localObject).setOnClickListener(new d.3(this));
    ((RelativeLayout)localObject).setBackgroundColor(hAm);
    addView((View)localObject, paramContext);
  }
  
  private void asQ()
  {
    this.hAj = null;
    this.hAl = null;
  }
  
  private View cm(int paramInt1, int paramInt2)
  {
    TextView localTextView = new TextView(new ContextThemeWrapper(getContext(), a.e.AppBrandPickerPanelTextButton));
    localTextView.setTextColor(getResources().getColor(paramInt2));
    localTextView.setText(paramInt1);
    localTextView.setGravity(17);
    return localTextView;
  }
  
  private void e(boolean paramBoolean, Object paramObject)
  {
    if ((!this.hAk) && (this.hAj != null))
    {
      this.hAk = true;
      this.hAj.d(paramBoolean, paramObject);
      this.hAk = false;
    }
  }
  
  @SuppressLint({"WrongCall"})
  protected final void cl(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  protected final int getPanelContentHeight()
  {
    return this.hAf + this.hAg;
  }
  
  public b getPicker()
  {
    return this.hAh;
  }
  
  public void hide()
  {
    super.setVisibility(8);
    e(false, null);
    if (this.hAh != null) {
      this.hAh.ajP();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    asQ();
    removeAllViews();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (!isShown())
    {
      super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(0, -2147483648));
      return;
    }
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.hAf + this.hAg, 1073741824));
  }
  
  public void setOnResultListener(d.a parama)
  {
    this.hAj = parama;
  }
  
  public void setOnValueUpdateListener(d.b paramb)
  {
    this.hAl = paramb;
  }
  
  protected void setPickerImpl(b paramb)
  {
    if (this.hAh != null) {
      this.hAh.ajQ();
    }
    this.hAh = paramb;
    if (this.hAh != null) {
      this.hAh.b(this);
    }
    if ((this.hAi == null) || (this.hAh == null) || (this.hAh.getView() == null)) {
      return;
    }
    this.hAi.removeAllViews();
    asQ();
    paramb = new FrameLayout.LayoutParams(-1, -2);
    paramb.gravity = 17;
    this.hAi.addView(this.hAh.getView(), paramb);
  }
  
  public void setVisibility(int paramInt)
  {
    if (paramInt != 0)
    {
      hide();
      return;
    }
    super.setVisibility(paramInt);
  }
  
  public void show()
  {
    if (this.hAh == null) {
      setVisibility(8);
    }
    do
    {
      return;
      setVisibility(0);
    } while (this.hAh == null);
    this.hAh.a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.d
 * JD-Core Version:    0.7.0.1
 */