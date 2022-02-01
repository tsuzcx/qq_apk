package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.content.ContextWrapper;
import android.support.v4.view.u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class v
  extends LinearLayout
  implements ac
{
  private static final int VIEW_ID = 2131296842;
  static com.tencent.mm.plugin.appbrand.n.a otP = null;
  static boolean otQ = false;
  EditText mEditText;
  View otK;
  private boolean otL;
  private a otM;
  AppBrandNumberKeyboardView otN;
  View otO;
  
  private v(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(136479);
    this.otL = false;
    Log.d("MicroMsg.AppBrandNumberKeyboardPanel", "init");
    super.setId(VIEW_ID);
    setOrientation(1);
    setBackgroundColor(-1);
    if (otQ)
    {
      this.otO = otP;
      if (this.otO != null)
      {
        paramContext = (ViewGroup)this.otO.getParent();
        if (paramContext != null)
        {
          Log.i("MicroMsg.AppBrandNumberKeyboardPanel", "toolbar is already exsited in a layout,the class of the parent is %s  the id is : %d", new Object[] { paramContext.getClass().toString(), Integer.valueOf(paramContext.getId()) });
          paramContext.removeView(this.otO);
        }
      }
      addView(this.otO);
    }
    paramContext = new ViewGroup.LayoutParams(-1, com.tencent.mm.cb.a.fromDPToPix(getContext(), 30));
    this.otK = LayoutInflater.from(getContext()).inflate(2131493137, null);
    this.otK.setOnClickListener(new v.1(this));
    addView(this.otK, paramContext);
    paramContext = new ViewGroup.LayoutParams(-1, com.tencent.mm.cb.a.fromDPToPix(getContext(), 240));
    AppBrandNumberKeyboardView localAppBrandNumberKeyboardView = new AppBrandNumberKeyboardView(getContext());
    this.otN = localAppBrandNumberKeyboardView;
    addView(localAppBrandNumberKeyboardView, paramContext);
    AppMethodBeat.o(136479);
  }
  
  public static v a(View paramView, com.tencent.mm.plugin.appbrand.n.a parama)
  {
    AppMethodBeat.i(230582);
    if (otP != parama)
    {
      Log.d("MicroMsg.AppBrandNumberKeyboardPanel", "mComponentView != componentView so we set mComponentView = componentView;");
      otP = parama;
    }
    Object localObject = da(paramView);
    parama = (com.tencent.mm.plugin.appbrand.n.a)localObject;
    if (localObject == null)
    {
      localObject = n.cW(paramView);
      if (localObject == null)
      {
        AppMethodBeat.o(230582);
        return null;
      }
      parama = new v(paramView.getContext());
      ((n)localObject).n(parama, false);
    }
    AppMethodBeat.o(230582);
    return parama;
  }
  
  public static v da(View paramView)
  {
    AppMethodBeat.i(136477);
    paramView = (v)paramView.getRootView().findViewById(VIEW_ID);
    AppMethodBeat.o(136477);
    return paramView;
  }
  
  public static void db(View paramView)
  {
    AppMethodBeat.i(230583);
    if (paramView != null)
    {
      ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
      if (localViewGroup != null) {
        localViewGroup.removeView(paramView);
      }
    }
    AppMethodBeat.o(230583);
  }
  
  private void onDone()
  {
    AppMethodBeat.i(136481);
    if ((!this.otL) && (this.otM != null))
    {
      this.otL = true;
      this.otM.onDone();
      this.otL = false;
    }
    AppMethodBeat.o(136481);
  }
  
  public final boolean cbD()
  {
    AppMethodBeat.i(136480);
    boolean bool = u.az(this);
    AppMethodBeat.o(136480);
    return bool;
  }
  
  final void cbE()
  {
    AppMethodBeat.i(136486);
    if (this.mEditText != null)
    {
      this.mEditText.clearFocus();
      this.mEditText = null;
      this.otM = null;
      this.otL = false;
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
    int i = com.tencent.mm.cb.a.fromDPToPix(getContext(), 270);
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
    otQ = paramBoolean;
  }
  
  public final void setId(int paramInt) {}
  
  public final <_Input extends EditText,  extends com.tencent.mm.plugin.appbrand.widget.input.numberpad.a> void setInputEditText(_Input param_Input)
  {
    AppMethodBeat.i(136484);
    this.mEditText = param_Input;
    AppBrandNumberKeyboardView localAppBrandNumberKeyboardView = this.otN;
    com.tencent.mm.plugin.appbrand.widget.input.numberpad.a locala = (com.tencent.mm.plugin.appbrand.widget.input.numberpad.a)param_Input;
    if (localAppBrandNumberKeyboardView.otV != locala)
    {
      if (locala == null)
      {
        localAppBrandNumberKeyboardView.otU = null;
        AppMethodBeat.o(136484);
        return;
      }
      if ((locala instanceof View))
      {
        param_Input = ((View)locala).getContext();
        if (param_Input == null) {
          break label172;
        }
        if (!(param_Input instanceof ad)) {
          break label147;
        }
      }
    }
    label147:
    label172:
    for (param_Input = (ad)param_Input;; param_Input = null)
    {
      if (param_Input != null) {
        param_Input.hideVKB();
      }
      if ((locala instanceof EditText))
      {
        aj.a.setNoSystemInputOnEditText((EditText)locala);
        aj.a.c((EditText)locala);
      }
      if ((locala instanceof View)) {
        ((View)locala).requestFocus();
      }
      localAppBrandNumberKeyboardView.otU = locala.cbC();
      AppMethodBeat.o(136484);
      return;
      if ((param_Input instanceof ContextWrapper))
      {
        Context localContext = ((ContextWrapper)param_Input).getBaseContext();
        if (localContext != param_Input)
        {
          param_Input = localContext;
          break;
        }
      }
    }
  }
  
  public final void setOnDoneListener(a parama)
  {
    this.otM = parama;
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
    this.otN.setXMode(paramInt);
    AppMethodBeat.o(136485);
  }
  
  public static abstract interface a
  {
    public abstract void onDone();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.v
 * JD-Core Version:    0.7.0.1
 */