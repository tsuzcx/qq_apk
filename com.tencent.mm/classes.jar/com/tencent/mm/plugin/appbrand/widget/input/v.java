package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.core.g.w;
import com.tencent.luggage.wxa.b.a.e;
import com.tencent.luggage.wxa.b.a.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class v
  extends LinearLayout
  implements ag
{
  private static final int cpM = a.e.app_brand_keyboard_number;
  EditText mEditText;
  View rvY;
  private boolean rvZ;
  private a rwa;
  AppBrandNumberKeyboardView rwb;
  View rwc;
  com.tencent.mm.plugin.appbrand.n.a rwd;
  boolean rwe;
  
  private v(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(136479);
    this.rvZ = false;
    this.rwd = null;
    this.rwe = false;
    Log.d("MicroMsg.AppBrandNumberKeyboardPanel", "init");
    super.setId(cpM);
    setOrientation(1);
    setBackgroundColor(-1);
    if (this.rwe)
    {
      this.rwc = this.rwd;
      if (this.rwc != null)
      {
        paramContext = (ViewGroup)this.rwc.getParent();
        if (paramContext != null)
        {
          Log.i("MicroMsg.AppBrandNumberKeyboardPanel", "toolbar is already exsited in a layout,the class of the parent is %s  the id is : %d", new Object[] { paramContext.getClass().toString(), Integer.valueOf(paramContext.getId()) });
          paramContext.removeView(this.rwc);
        }
      }
      addView(this.rwc);
    }
    paramContext = new ViewGroup.LayoutParams(-1, com.tencent.mm.ci.a.fromDPToPix(getContext(), 30));
    this.rvY = LayoutInflater.from(getContext()).inflate(a.f.appbrand_keyboard_push_down_layout, null);
    this.rvY.setOnClickListener(new v.1(this));
    addView(this.rvY, paramContext);
    paramContext = new ViewGroup.LayoutParams(-1, com.tencent.mm.ci.a.fromDPToPix(getContext(), 240));
    AppBrandNumberKeyboardView localAppBrandNumberKeyboardView = new AppBrandNumberKeyboardView(getContext());
    this.rwb = localAppBrandNumberKeyboardView;
    addView(localAppBrandNumberKeyboardView, paramContext);
    AppMethodBeat.o(136479);
  }
  
  public static v a(View paramView, com.tencent.mm.plugin.appbrand.n.a parama)
  {
    AppMethodBeat.i(214225);
    Object localObject2 = dt(paramView);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = n.dp(paramView);
      if (localObject2 == null)
      {
        AppMethodBeat.o(214225);
        return null;
      }
      localObject1 = new v(paramView.getContext());
      ((n)localObject2).m((View)localObject1, false);
    }
    if (((v)localObject1).rwd != parama)
    {
      Log.d("MicroMsg.AppBrandNumberKeyboardPanel", "mComponentView != componentView so we set mComponentView = componentView;");
      ((v)localObject1).rwd = parama;
    }
    AppMethodBeat.o(214225);
    return localObject1;
  }
  
  public static v dt(View paramView)
  {
    AppMethodBeat.i(136477);
    paramView = (v)paramView.getRootView().findViewById(cpM);
    AppMethodBeat.o(136477);
    return paramView;
  }
  
  public static void du(View paramView)
  {
    AppMethodBeat.i(214231);
    if (paramView != null)
    {
      ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
      if (localViewGroup != null) {
        localViewGroup.removeView(paramView);
      }
    }
    AppMethodBeat.o(214231);
  }
  
  private void onDone()
  {
    AppMethodBeat.i(136481);
    if ((!this.rvZ) && (this.rwa != null))
    {
      this.rvZ = true;
      this.rwa.onDone();
      this.rvZ = false;
    }
    AppMethodBeat.o(136481);
  }
  
  public final boolean coN()
  {
    AppMethodBeat.i(136480);
    boolean bool = w.ah(this);
    AppMethodBeat.o(136480);
    return bool;
  }
  
  final void coO()
  {
    AppMethodBeat.i(136486);
    if (this.mEditText != null)
    {
      this.mEditText.clearFocus();
      this.mEditText = null;
      this.rwa = null;
      this.rvZ = false;
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
    int i = com.tencent.mm.ci.a.fromDPToPix(getContext(), 270);
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
    this.rwe = paramBoolean;
  }
  
  public final void setId(int paramInt) {}
  
  public final <_Input extends EditText,  extends com.tencent.mm.plugin.appbrand.widget.input.numberpad.a> void setInputEditText(_Input param_Input)
  {
    AppMethodBeat.i(136484);
    this.mEditText = param_Input;
    AppBrandNumberKeyboardView localAppBrandNumberKeyboardView = this.rwb;
    param_Input = (com.tencent.mm.plugin.appbrand.widget.input.numberpad.a)param_Input;
    if (localAppBrandNumberKeyboardView.rwj != param_Input)
    {
      if (param_Input == null)
      {
        localAppBrandNumberKeyboardView.rwi = null;
        AppMethodBeat.o(136484);
        return;
      }
      if ((param_Input instanceof View))
      {
        ah localah = ah.a.eC(((View)param_Input).getContext());
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
      localAppBrandNumberKeyboardView.rwi = param_Input.coM();
    }
    AppMethodBeat.o(136484);
  }
  
  public final void setOnDoneListener(a parama)
  {
    this.rwa = parama;
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
    this.rwb.setXMode(paramInt);
    AppMethodBeat.o(136485);
  }
  
  public static abstract interface a
  {
    public abstract void onDone();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.v
 * JD-Core Version:    0.7.0.1
 */