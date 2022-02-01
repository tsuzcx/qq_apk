package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.luggage.wxa.b.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.o.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/input/AppBrandSecureKeyboardPanel;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/plugin/appbrand/widget/input/IBaseInputPanel;", "context", "Landroid/content/Context;", "enableKeyboardAccessory", "", "keyboardAccessoryContainer", "Lcom/tencent/mm/plugin/appbrand/keyboardCoverView/AppBrandKeyBoardComponentView;", "(Landroid/content/Context;ZLcom/tencent/mm/plugin/appbrand/keyboardCoverView/AppBrandKeyBoardComponentView;)V", "hashCode", "", "inputWidget", "Landroid/widget/EditText;", "keyboardView", "Lcom/tencent/mm/plugin/appbrand/widget/input/AppBrandSecureKeyboard;", "myKeyboardAccessoryContainer", "Landroid/view/View;", "myTag", "", "onDoneListener", "Lcom/tencent/mm/plugin/appbrand/widget/input/AppBrandSecureKeyboardPanel$OnDoneListener;", "performingOnDone", "forceLightMode", "", "getAttachedInputWidget", "hide", "isRealHeightSettled", "onDetachedFromWindow", "performOnDone", "resetFocusStatus", "setId", "id", "setInputWidget", "setOnDoneListener", "setVisibility", "visibility", "show", "toString", "updateKeyboardAccessory", "Companion", "OnDoneListener", "luggage-wxa-app-input-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class z
  extends LinearLayout
  implements ag
{
  private static final int ehD;
  public static final a uHA;
  private final int cHb;
  final String djQ;
  private View uHB;
  final AppBrandSecureKeyboard uHC;
  EditText uHD;
  private b uHE;
  private boolean uHF;
  
  static
  {
    AppMethodBeat.i(324509);
    uHA = new a((byte)0);
    ehD = a.e.app_brand_keyboard_security;
    AppMethodBeat.o(324509);
  }
  
  public z(Context paramContext, boolean paramBoolean, a parama)
  {
    super(paramContext);
    AppMethodBeat.i(324506);
    this.cHb = hashCode();
    this.djQ = s.X("MicroMsg.AppBrand.AppBrandSecureKeyboardPanel#", Integer.valueOf(this.cHb));
    this.uHC = new AppBrandSecureKeyboard(paramContext);
    Log.d(this.djQ, "init");
    super.setId(ehD);
    setOrientation(1);
    setBackgroundColor(-1);
    if ((paramBoolean) && (parama != null))
    {
      paramContext = parama.getParent();
      if (!(paramContext instanceof ViewGroup)) {
        break label161;
      }
    }
    label161:
    for (paramContext = (ViewGroup)paramContext;; paramContext = null)
    {
      if (paramContext != null) {
        paramContext.removeView((View)parama);
      }
      addView((View)parama);
      this.uHB = ((View)parama);
      addView((View)this.uHC, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
      AppMethodBeat.o(324506);
      return;
    }
  }
  
  public final boolean cRp()
  {
    AppMethodBeat.i(324525);
    boolean bool = androidx.core.g.z.au((View)this);
    Log.d(this.djQ, s.X("isRealHeightSettled, settled: ", Boolean.valueOf(bool)));
    AppMethodBeat.o(324525);
    return bool;
  }
  
  final void cRq()
  {
    AppMethodBeat.i(324517);
    Log.d(this.djQ, "resetFocusStatus");
    EditText localEditText = this.uHD;
    if (localEditText != null)
    {
      localEditText.clearFocus();
      this.uHD = null;
      this.uHE = null;
      this.uHF = false;
    }
    AppMethodBeat.o(324517);
  }
  
  public final EditText getAttachedInputWidget()
  {
    AppMethodBeat.i(324511);
    Log.d(this.djQ, s.X("getAttachedInputWidget, inputWidget: ", this.uHD));
    EditText localEditText = this.uHD;
    AppMethodBeat.o(324511);
    return localEditText;
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(324531);
    Log.d(this.djQ, "onDetachedFromWindow");
    super.onDetachedFromWindow();
    removeAllViews();
    AppMethodBeat.o(324531);
  }
  
  public final void setId(int paramInt) {}
  
  public final void setInputWidget(EditText paramEditText)
  {
    AppMethodBeat.i(324510);
    Log.d(this.djQ, s.X("setInputWidget, inputWidget: ", paramEditText));
    this.uHD = paramEditText;
    this.uHC.setInputEditText(paramEditText);
    an.a.setNoSystemInputOnEditText(paramEditText);
    an.a.c(paramEditText);
    if (paramEditText != null) {
      paramEditText.requestFocus();
    }
    AppMethodBeat.o(324510);
  }
  
  public final void setOnDoneListener(b paramb)
  {
    AppMethodBeat.i(324519);
    Log.d(this.djQ, s.X("setOnDoneListener, onDoneListener: ", paramb));
    this.uHE = paramb;
    AppMethodBeat.o(324519);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(324522);
    int i = getVisibility();
    Log.d(this.djQ, "setVisibility, visibility: " + paramInt + ", curVisibility: " + i);
    if ((paramInt == i) && ((i == 0) || (8 == i)))
    {
      Log.i(this.djQ, "setVisibility, same visibility");
      AppMethodBeat.o(324522);
      return;
    }
    if (paramInt != 0)
    {
      super.setVisibility(8);
      Log.d(this.djQ, "performOnDone");
      if (this.uHF)
      {
        Log.i(this.djQ, "performOnDone, performingOnDone");
        AppMethodBeat.o(324522);
        return;
      }
      this.uHF = true;
      b localb = this.uHE;
      if (localb != null) {
        localb.onDone();
      }
      this.uHF = false;
      AppMethodBeat.o(324522);
      return;
    }
    super.setVisibility(paramInt);
    AppMethodBeat.o(324522);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(324515);
    String str = s.X("AppBrandSecureKeyboardPanel#", Integer.valueOf(this.cHb));
    AppMethodBeat.o(324515);
    return str;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/input/AppBrandSecureKeyboardPanel$Companion;", "", "()V", "TAG", "", "VIEW_ID", "", "findKeyboardPanel", "Lcom/tencent/mm/plugin/appbrand/widget/input/AppBrandSecureKeyboardPanel;", "view", "Landroid/view/View;", "settleKeyboardPanel", "enableKeyboardAccessory", "", "keyboardAccessoryContainer", "Lcom/tencent/mm/plugin/appbrand/keyboardCoverView/AppBrandKeyBoardComponentView;", "luggage-wxa-app-input-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static z ej(View paramView)
    {
      AppMethodBeat.i(324419);
      s.u(paramView, "view");
      paramView = (z)paramView.getRootView().findViewById(z.cRv());
      AppMethodBeat.o(324419);
      return paramView;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/input/AppBrandSecureKeyboardPanel$OnDoneListener;", "", "onDone", "", "luggage-wxa-app-input-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void onDone();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.z
 * JD-Core Version:    0.7.0.1
 */