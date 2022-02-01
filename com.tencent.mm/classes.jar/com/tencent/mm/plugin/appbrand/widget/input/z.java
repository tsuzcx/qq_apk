package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import androidx.core.g.w;
import com.tencent.luggage.wxa.b.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.n.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/widget/input/AppBrandSecureKeyboardPanel;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/plugin/appbrand/widget/input/IBaseInputPanel;", "context", "Landroid/content/Context;", "enableKeyboardAccessory", "", "keyboardAccessoryContainer", "Lcom/tencent/mm/plugin/appbrand/keyboardCoverView/AppBrandKeyBoardComponentView;", "(Landroid/content/Context;ZLcom/tencent/mm/plugin/appbrand/keyboardCoverView/AppBrandKeyBoardComponentView;)V", "hashCode", "", "inputWidget", "Landroid/widget/EditText;", "keyboardView", "Lcom/tencent/mm/plugin/appbrand/widget/input/AppBrandSecureKeyboard;", "myKeyboardAccessoryContainer", "Landroid/view/View;", "myTag", "", "onDoneListener", "Lcom/tencent/mm/plugin/appbrand/widget/input/AppBrandSecureKeyboardPanel$OnDoneListener;", "performingOnDone", "forceLightMode", "", "getAttachedInputWidget", "hide", "isRealHeightSettled", "onDetachedFromWindow", "performOnDone", "resetFocusStatus", "setId", "id", "setInputWidget", "setOnDoneListener", "setVisibility", "visibility", "show", "toString", "updateKeyboardAccessory", "Companion", "OnDoneListener", "luggage-wxa-app-input-ext_release"})
public final class z
  extends LinearLayout
  implements ag
{
  private static final int cpM;
  public static final a rwB;
  private final int aNf;
  final String bqj;
  private boolean rwA;
  private View rww;
  final AppBrandSecureKeyboard rwx;
  EditText rwy;
  private b rwz;
  
  static
  {
    AppMethodBeat.i(214263);
    rwB = new a((byte)0);
    cpM = a.e.app_brand_keyboard_security;
    AppMethodBeat.o(214263);
  }
  
  public z(Context paramContext, boolean paramBoolean, a parama)
  {
    super(paramContext);
    AppMethodBeat.i(214261);
    this.aNf = hashCode();
    this.bqj = ("MicroMsg.AppBrand.AppBrandSecureKeyboardPanel#" + this.aNf);
    this.rwx = new AppBrandSecureKeyboard(paramContext);
    Log.d(this.bqj, "init");
    super.setId(cpM);
    setOrientation(1);
    setBackgroundColor(-1);
    if ((paramBoolean) && (parama != null))
    {
      ViewParent localViewParent = parama.getParent();
      paramContext = localViewParent;
      if (!(localViewParent instanceof ViewGroup)) {
        paramContext = null;
      }
      paramContext = (ViewGroup)paramContext;
      if (paramContext != null) {
        paramContext.removeView((View)parama);
      }
      addView((View)parama);
      this.rww = ((View)parama);
    }
    addView((View)this.rwx, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
    AppMethodBeat.o(214261);
  }
  
  public final boolean coN()
  {
    AppMethodBeat.i(214259);
    boolean bool = w.ah((View)this);
    Log.d(this.bqj, "isRealHeightSettled, settled: ".concat(String.valueOf(bool)));
    AppMethodBeat.o(214259);
    return bool;
  }
  
  final void coO()
  {
    AppMethodBeat.i(214255);
    Log.d(this.bqj, "resetFocusStatus");
    EditText localEditText = this.rwy;
    if (localEditText != null)
    {
      localEditText.clearFocus();
      this.rwy = null;
      this.rwz = null;
      this.rwA = false;
      AppMethodBeat.o(214255);
      return;
    }
    AppMethodBeat.o(214255);
  }
  
  public final EditText getAttachedInputWidget()
  {
    AppMethodBeat.i(214253);
    Log.d(this.bqj, "getAttachedInputWidget, inputWidget: " + this.rwy);
    EditText localEditText = this.rwy;
    AppMethodBeat.o(214253);
    return localEditText;
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(214260);
    Log.d(this.bqj, "onDetachedFromWindow");
    super.onDetachedFromWindow();
    removeAllViews();
    AppMethodBeat.o(214260);
  }
  
  public final void setId(int paramInt) {}
  
  public final void setInputWidget(EditText paramEditText)
  {
    AppMethodBeat.i(214251);
    Log.d(this.bqj, "setInputWidget, inputWidget: ".concat(String.valueOf(paramEditText)));
    this.rwy = paramEditText;
    this.rwx.setInputEditText(paramEditText);
    an.a.setNoSystemInputOnEditText(paramEditText);
    an.a.c(paramEditText);
    if (paramEditText != null)
    {
      paramEditText.requestFocus();
      AppMethodBeat.o(214251);
      return;
    }
    AppMethodBeat.o(214251);
  }
  
  public final void setOnDoneListener(b paramb)
  {
    AppMethodBeat.i(214256);
    Log.d(this.bqj, "setOnDoneListener, onDoneListener: ".concat(String.valueOf(paramb)));
    this.rwz = paramb;
    AppMethodBeat.o(214256);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(214257);
    int i = getVisibility();
    Log.d(this.bqj, "setVisibility, visibility: " + paramInt + ", curVisibility: " + i);
    if ((paramInt == i) && ((i == 0) || (8 == i)))
    {
      Log.i(this.bqj, "setVisibility, same visibility");
      AppMethodBeat.o(214257);
      return;
    }
    if (paramInt != 0)
    {
      super.setVisibility(8);
      Log.d(this.bqj, "performOnDone");
      if (this.rwA)
      {
        Log.i(this.bqj, "performOnDone, performingOnDone");
        AppMethodBeat.o(214257);
        return;
      }
      this.rwA = true;
      b localb = this.rwz;
      if (localb != null) {
        localb.onDone();
      }
      this.rwA = false;
      AppMethodBeat.o(214257);
      return;
    }
    super.setVisibility(paramInt);
    AppMethodBeat.o(214257);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(214254);
    String str = "AppBrandSecureKeyboardPanel#" + this.aNf;
    AppMethodBeat.o(214254);
    return str;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/widget/input/AppBrandSecureKeyboardPanel$Companion;", "", "()V", "TAG", "", "VIEW_ID", "", "findKeyboardPanel", "Lcom/tencent/mm/plugin/appbrand/widget/input/AppBrandSecureKeyboardPanel;", "view", "Landroid/view/View;", "settleKeyboardPanel", "enableKeyboardAccessory", "", "keyboardAccessoryContainer", "Lcom/tencent/mm/plugin/appbrand/keyboardCoverView/AppBrandKeyBoardComponentView;", "luggage-wxa-app-input-ext_release"})
  public static final class a
  {
    public static z dv(View paramView)
    {
      AppMethodBeat.i(214689);
      p.k(paramView, "view");
      paramView = (z)paramView.getRootView().findViewById(z.coT());
      AppMethodBeat.o(214689);
      return paramView;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/widget/input/AppBrandSecureKeyboardPanel$OnDoneListener;", "", "onDone", "", "luggage-wxa-app-input-ext_release"})
  public static abstract interface b
  {
    public abstract void onDone();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.z
 * JD-Core Version:    0.7.0.1
 */