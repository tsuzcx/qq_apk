package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.support.v4.view.t;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class v
  extends LinearLayout
  implements ac
{
  private static final int VIEW_ID = 2131820560;
  private boolean jmP;
  private v.a jmQ;
  private AppBrandNumberKeyboardView jmR;
  EditText mEditText;
  
  private v(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(123744);
    this.jmP = false;
    super.setId(VIEW_ID);
    setOrientation(1);
    setBackgroundColor(-1);
    paramContext = new ViewGroup.LayoutParams(-1, com.tencent.mm.cb.a.fromDPToPix(getContext(), 30));
    Object localObject = new RelativeLayout(getContext());
    ((RelativeLayout)localObject).setOnClickListener(new v.1(this));
    ((RelativeLayout)localObject).setBackgroundResource(2130840569);
    ImageView localImageView = new ImageView(getContext());
    localImageView.setImageResource(2130840568);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13);
    ((RelativeLayout)localObject).addView(localImageView, localLayoutParams);
    addView((View)localObject, paramContext);
    paramContext = new ViewGroup.LayoutParams(-1, com.tencent.mm.cb.a.fromDPToPix(getContext(), 240));
    localObject = new AppBrandNumberKeyboardView(getContext());
    this.jmR = ((AppBrandNumberKeyboardView)localObject);
    addView((View)localObject, paramContext);
    AppMethodBeat.o(123744);
  }
  
  public static v cO(View paramView)
  {
    AppMethodBeat.i(123742);
    paramView = (v)paramView.getRootView().findViewById(VIEW_ID);
    AppMethodBeat.o(123742);
    return paramView;
  }
  
  public static v cP(View paramView)
  {
    AppMethodBeat.i(123743);
    Object localObject2 = cO(paramView);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = n.cJ(paramView);
      if (localObject2 == null)
      {
        AppMethodBeat.o(123743);
        return null;
      }
      localObject1 = new v(paramView.getContext());
      ((n)localObject2).n((View)localObject1, false);
    }
    AppMethodBeat.o(123743);
    return localObject1;
  }
  
  private void onDone()
  {
    AppMethodBeat.i(123746);
    if ((!this.jmP) && (this.jmQ != null))
    {
      this.jmP = true;
      this.jmQ.onDone();
      this.jmP = false;
    }
    AppMethodBeat.o(123746);
  }
  
  public final boolean aRd()
  {
    AppMethodBeat.i(123745);
    boolean bool = t.as(this);
    AppMethodBeat.o(123745);
    return bool;
  }
  
  final void aRe()
  {
    AppMethodBeat.i(123751);
    if (this.mEditText != null)
    {
      this.mEditText.clearFocus();
      this.mEditText = null;
      this.jmQ = null;
      this.jmP = false;
    }
    AppMethodBeat.o(123751);
  }
  
  public final EditText getAttachedEditText()
  {
    return this.mEditText;
  }
  
  public final int getPanelHeight()
  {
    AppMethodBeat.i(123748);
    int i = com.tencent.mm.cb.a.fromDPToPix(getContext(), 270);
    AppMethodBeat.o(123748);
    return i;
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(123753);
    super.onDetachedFromWindow();
    removeAllViews();
    AppMethodBeat.o(123753);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(123752);
    if (isShown()) {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(getPanelHeight(), 1073741824);
    }
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(123752);
  }
  
  public final void setId(int paramInt) {}
  
  public final <_Input extends EditText,  extends com.tencent.mm.plugin.appbrand.widget.input.numberpad.a> void setInputEditText(_Input param_Input)
  {
    AppMethodBeat.i(123749);
    this.mEditText = param_Input;
    AppBrandNumberKeyboardView localAppBrandNumberKeyboardView = this.jmR;
    param_Input = (com.tencent.mm.plugin.appbrand.widget.input.numberpad.a)param_Input;
    if (localAppBrandNumberKeyboardView.jmW != param_Input)
    {
      if (param_Input == null)
      {
        localAppBrandNumberKeyboardView.jmV = null;
        AppMethodBeat.o(123749);
        return;
      }
      if ((param_Input instanceof View)) {
        ((View)param_Input).requestFocus();
      }
      if ((param_Input instanceof EditText))
      {
        aj.a.setNoSystemInputOnEditText((EditText)param_Input);
        aj.a.c((EditText)param_Input);
      }
      localAppBrandNumberKeyboardView.jmV = param_Input.aRc();
    }
    AppMethodBeat.o(123749);
  }
  
  public final void setOnDoneListener(v.a parama)
  {
    this.jmQ = parama;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(123747);
    if ((getVisibility() == paramInt) && ((getVisibility() == 0) || (getVisibility() == 8)))
    {
      AppMethodBeat.o(123747);
      return;
    }
    if (paramInt != 0)
    {
      super.setVisibility(8);
      onDone();
      AppMethodBeat.o(123747);
      return;
    }
    super.setVisibility(paramInt);
    AppMethodBeat.o(123747);
  }
  
  public final void setXMode(int paramInt)
  {
    AppMethodBeat.i(123750);
    this.jmR.setXMode(paramInt);
    AppMethodBeat.o(123750);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.v
 * JD-Core Version:    0.7.0.1
 */