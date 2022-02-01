package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.core.g.z;
import com.tencent.luggage.wxa.b.a.e;
import com.tencent.luggage.wxa.b.a.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class v
  extends LinearLayout
  implements ag
{
  private static final int ehD = a.e.app_brand_keyboard_number;
  EditText mEditText;
  View uHf;
  private boolean uHg;
  private a uHh;
  AppBrandNumberKeyboardView uHi;
  View uHj;
  com.tencent.mm.plugin.appbrand.o.a uHk;
  boolean uHl;
  
  private v(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(136479);
    this.uHg = false;
    this.uHk = null;
    this.uHl = false;
    Log.d("MicroMsg.AppBrandNumberKeyboardPanel", "init");
    super.setId(ehD);
    setOrientation(1);
    setBackgroundColor(-1);
    if (this.uHl)
    {
      this.uHj = this.uHk;
      if (this.uHj != null)
      {
        paramContext = (ViewGroup)this.uHj.getParent();
        if (paramContext != null)
        {
          Log.i("MicroMsg.AppBrandNumberKeyboardPanel", "toolbar is already exsited in a layout,the class of the parent is %s  the id is : %d", new Object[] { paramContext.getClass().toString(), Integer.valueOf(paramContext.getId()) });
          paramContext.removeView(this.uHj);
        }
      }
      addView(this.uHj);
    }
    paramContext = new ViewGroup.LayoutParams(-1, com.tencent.mm.cd.a.fromDPToPix(getContext(), 30));
    this.uHf = LayoutInflater.from(getContext()).inflate(a.f.appbrand_keyboard_push_down_layout, null);
    this.uHf.setOnClickListener(new v.1(this));
    addView(this.uHf, paramContext);
    paramContext = new ViewGroup.LayoutParams(-1, com.tencent.mm.cd.a.fromDPToPix(getContext(), 240));
    AppBrandNumberKeyboardView localAppBrandNumberKeyboardView = new AppBrandNumberKeyboardView(getContext());
    this.uHi = localAppBrandNumberKeyboardView;
    addView(localAppBrandNumberKeyboardView, paramContext);
    AppMethodBeat.o(136479);
  }
  
  public static v a(View paramView, com.tencent.mm.plugin.appbrand.o.a parama)
  {
    AppMethodBeat.i(324518);
    Object localObject2 = eh(paramView);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = n.ed(paramView);
      if (localObject2 == null)
      {
        AppMethodBeat.o(324518);
        return null;
      }
      localObject1 = new v(paramView.getContext());
      ((n)localObject2).n((View)localObject1, false);
    }
    if (((v)localObject1).uHk != parama)
    {
      Log.d("MicroMsg.AppBrandNumberKeyboardPanel", "mComponentView != componentView so we set mComponentView = componentView;");
      ((v)localObject1).uHk = parama;
    }
    AppMethodBeat.o(324518);
    return localObject1;
  }
  
  public static v eh(View paramView)
  {
    AppMethodBeat.i(136477);
    paramView = (v)paramView.getRootView().findViewById(ehD);
    AppMethodBeat.o(136477);
    return paramView;
  }
  
  public static void ei(View paramView)
  {
    AppMethodBeat.i(324530);
    if (paramView != null)
    {
      ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
      if (localViewGroup != null) {
        localViewGroup.removeView(paramView);
      }
    }
    AppMethodBeat.o(324530);
  }
  
  private void onDone()
  {
    AppMethodBeat.i(136481);
    if ((!this.uHg) && (this.uHh != null))
    {
      this.uHg = true;
      this.uHh.onDone();
      this.uHg = false;
    }
    AppMethodBeat.o(136481);
  }
  
  public final boolean cRp()
  {
    AppMethodBeat.i(136480);
    boolean bool = z.au(this);
    AppMethodBeat.o(136480);
    return bool;
  }
  
  final void cRq()
  {
    AppMethodBeat.i(136486);
    if (this.mEditText != null)
    {
      this.mEditText.clearFocus();
      this.mEditText = null;
      this.uHh = null;
      this.uHg = false;
    }
    AppMethodBeat.o(136486);
  }
  
  public final EditText getAttachedEditText()
  {
    return this.mEditText;
  }
  
  public final int getPanelHeight()
  {
    AppMethodBeat.i(136483);
    int i = com.tencent.mm.cd.a.fromDPToPix(getContext(), 270);
    AppMethodBeat.o(136483);
    return i;
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(136488);
    super.onDetachedFromWindow();
    removeAllViews();
    AppMethodBeat.o(136488);
  }
  
  public final void setComponentView(boolean paramBoolean)
  {
    this.uHl = paramBoolean;
  }
  
  public final void setId(int paramInt) {}
  
  public final <_Input extends EditText,  extends com.tencent.mm.plugin.appbrand.widget.input.numberpad.a> void setInputEditText(_Input param_Input)
  {
    AppMethodBeat.i(136484);
    this.mEditText = param_Input;
    AppBrandNumberKeyboardView localAppBrandNumberKeyboardView = this.uHi;
    param_Input = (com.tencent.mm.plugin.appbrand.widget.input.numberpad.a)param_Input;
    if (localAppBrandNumberKeyboardView.uHq != param_Input)
    {
      if (param_Input == null)
      {
        localAppBrandNumberKeyboardView.uHp = null;
        AppMethodBeat.o(136484);
        return;
      }
      if ((param_Input instanceof View))
      {
        ah localah = ah.a.fy(((View)param_Input).getContext());
        if (localah != null) {
          localah.hideVKB();
        }
      }
      if ((param_Input instanceof EditText))
      {
        an.a.setNoSystemInputOnEditText((EditText)param_Input);
        an.a.c((EditText)param_Input);
      }
      if ((param_Input instanceof View)) {
        ((View)param_Input).requestFocus();
      }
      localAppBrandNumberKeyboardView.uHp = param_Input.cRo();
    }
    AppMethodBeat.o(136484);
  }
  
  public final void setOnDoneListener(a parama)
  {
    this.uHh = parama;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(136482);
    if ((getVisibility() == paramInt) && ((getVisibility() == 0) || (getVisibility() == 8)))
    {
      AppMethodBeat.o(136482);
      return;
    }
    if (paramInt != 0)
    {
      super.setVisibility(8);
      onDone();
      AppMethodBeat.o(136482);
      return;
    }
    super.setVisibility(paramInt);
    AppMethodBeat.o(136482);
  }
  
  public final void setXMode(int paramInt)
  {
    AppMethodBeat.i(136485);
    this.uHi.setXMode(paramInt);
    AppMethodBeat.o(136485);
  }
  
  public static abstract interface a
  {
    public abstract void onDone();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.v
 * JD-Core Version:    0.7.0.1
 */