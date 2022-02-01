package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.content.ContextWrapper;
import android.support.v4.view.t;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class v
  extends LinearLayout
  implements ac
{
  private static final int VIEW_ID = 2131296761;
  EditText mEditText;
  private boolean nfc;
  private a nfd;
  private AppBrandNumberKeyboardView nfe;
  
  private v(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(136479);
    this.nfc = false;
    super.setId(VIEW_ID);
    setOrientation(1);
    setBackgroundColor(-1);
    paramContext = new ViewGroup.LayoutParams(-1, com.tencent.mm.cc.a.fromDPToPix(getContext(), 30));
    Object localObject = LayoutInflater.from(getContext()).inflate(2131493095, null);
    ((View)localObject).setOnClickListener(new v.1(this));
    addView((View)localObject, paramContext);
    paramContext = new ViewGroup.LayoutParams(-1, com.tencent.mm.cc.a.fromDPToPix(getContext(), 240));
    localObject = new AppBrandNumberKeyboardView(getContext());
    this.nfe = ((AppBrandNumberKeyboardView)localObject);
    addView((View)localObject, paramContext);
    AppMethodBeat.o(136479);
  }
  
  public static v di(View paramView)
  {
    AppMethodBeat.i(136477);
    paramView = (v)paramView.getRootView().findViewById(VIEW_ID);
    AppMethodBeat.o(136477);
    return paramView;
  }
  
  public static v dj(View paramView)
  {
    AppMethodBeat.i(136478);
    Object localObject2 = di(paramView);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = n.dd(paramView);
      if (localObject2 == null)
      {
        AppMethodBeat.o(136478);
        return null;
      }
      localObject1 = new v(paramView.getContext());
      ((n)localObject2).n((View)localObject1, false);
    }
    AppMethodBeat.o(136478);
    return localObject1;
  }
  
  private void onDone()
  {
    AppMethodBeat.i(136481);
    if ((!this.nfc) && (this.nfd != null))
    {
      this.nfc = true;
      this.nfd.onDone();
      this.nfc = false;
    }
    AppMethodBeat.o(136481);
  }
  
  public final boolean bEw()
  {
    AppMethodBeat.i(136480);
    boolean bool = t.ay(this);
    AppMethodBeat.o(136480);
    return bool;
  }
  
  final void bEx()
  {
    AppMethodBeat.i(136486);
    if (this.mEditText != null)
    {
      this.mEditText.clearFocus();
      this.mEditText = null;
      this.nfd = null;
      this.nfc = false;
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
    int i = com.tencent.mm.cc.a.fromDPToPix(getContext(), 270);
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
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(136487);
    if (isShown()) {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(getPanelHeight(), 1073741824);
    }
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(136487);
  }
  
  public final void setId(int paramInt) {}
  
  public final <_Input extends EditText,  extends com.tencent.mm.plugin.appbrand.widget.input.numberpad.a> void setInputEditText(_Input param_Input)
  {
    AppMethodBeat.i(136484);
    this.mEditText = param_Input;
    AppBrandNumberKeyboardView localAppBrandNumberKeyboardView = this.nfe;
    com.tencent.mm.plugin.appbrand.widget.input.numberpad.a locala = (com.tencent.mm.plugin.appbrand.widget.input.numberpad.a)param_Input;
    if (localAppBrandNumberKeyboardView.nfj != locala)
    {
      if (locala == null)
      {
        localAppBrandNumberKeyboardView.nfi = null;
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
      localAppBrandNumberKeyboardView.nfi = locala.bEv();
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
    this.nfd = parama;
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
    this.nfe.setXMode(paramInt);
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