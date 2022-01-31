package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.support.v4.view.q;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.luggage.l.a.a.c;
import com.tencent.luggage.l.a.a.d;

public final class u
  extends LinearLayout
  implements ab
{
  private static final int gdr = a.d.app_brand_keyboard_number;
  private boolean huF = false;
  private u.a huG;
  private AppBrandNumberKeyboardView huH;
  EditText ln;
  
  private u(Context paramContext)
  {
    super(paramContext);
    super.setId(gdr);
    setOrientation(1);
    setBackgroundColor(-1);
    paramContext = new ViewGroup.LayoutParams(-1, com.tencent.mm.cb.a.fromDPToPix(getContext(), 30));
    Object localObject = new RelativeLayout(getContext());
    ((RelativeLayout)localObject).setOnClickListener(new u.1(this));
    ((RelativeLayout)localObject).setBackgroundResource(a.c.tenpay_push_down_bg);
    ImageView localImageView = new ImageView(getContext());
    localImageView.setImageResource(a.c.tenpay_push_down);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13);
    ((RelativeLayout)localObject).addView(localImageView, localLayoutParams);
    addView((View)localObject, paramContext);
    paramContext = new ViewGroup.LayoutParams(-1, com.tencent.mm.cb.a.fromDPToPix(getContext(), 240));
    localObject = new AppBrandNumberKeyboardView(getContext());
    this.huH = ((AppBrandNumberKeyboardView)localObject);
    addView((View)localObject, paramContext);
  }
  
  public static u cl(View paramView)
  {
    return (u)paramView.getRootView().findViewById(gdr);
  }
  
  public static u cm(View paramView)
  {
    u localu = cl(paramView);
    Object localObject = localu;
    if (localu == null)
    {
      localObject = m.ch(paramView);
      if (localObject == null) {
        localObject = null;
      }
    }
    else
    {
      return localObject;
    }
    paramView = new u(paramView.getContext());
    ((m)localObject).i(paramView, false);
    return paramView;
  }
  
  private void onDone()
  {
    if ((!this.huF) && (this.huG != null))
    {
      this.huF = true;
      this.huG.onDone();
      this.huF = false;
    }
  }
  
  public final boolean arZ()
  {
    return q.al(this);
  }
  
  final void asa()
  {
    if (this.ln != null)
    {
      this.ln.clearFocus();
      this.ln = null;
      this.huG = null;
      this.huF = false;
    }
  }
  
  public final EditText getAttachedEditText()
  {
    return this.ln;
  }
  
  public final int getPanelHeight()
  {
    return com.tencent.mm.cb.a.fromDPToPix(getContext(), 270);
  }
  
  protected final void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    removeAllViews();
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    if (isShown()) {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(getPanelHeight(), 1073741824);
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public final void setId(int paramInt) {}
  
  public final <_Input extends EditText,  extends com.tencent.mm.plugin.appbrand.widget.input.numberpad.a> void setInputEditText(_Input param_Input)
  {
    this.ln = param_Input;
    AppBrandNumberKeyboardView localAppBrandNumberKeyboardView = this.huH;
    param_Input = (com.tencent.mm.plugin.appbrand.widget.input.numberpad.a)param_Input;
    if (localAppBrandNumberKeyboardView.huM != param_Input)
    {
      if (param_Input == null) {
        localAppBrandNumberKeyboardView.huL = null;
      }
    }
    else {
      return;
    }
    if ((param_Input instanceof View)) {
      ((View)param_Input).requestFocus();
    }
    if ((param_Input instanceof EditText))
    {
      ai.a.setNoSystemInputOnEditText((EditText)param_Input);
      ai.a.c((EditText)param_Input);
    }
    localAppBrandNumberKeyboardView.huL = param_Input.arY();
  }
  
  public final void setOnDoneListener(u.a parama)
  {
    this.huG = parama;
  }
  
  public final void setVisibility(int paramInt)
  {
    if ((getVisibility() == paramInt) && ((getVisibility() == 0) || (getVisibility() == 8))) {
      return;
    }
    if (paramInt != 0)
    {
      super.setVisibility(8);
      onDone();
      return;
    }
    super.setVisibility(paramInt);
  }
  
  public final void setXMode(int paramInt)
  {
    this.huH.setXMode(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.u
 * JD-Core Version:    0.7.0.1
 */