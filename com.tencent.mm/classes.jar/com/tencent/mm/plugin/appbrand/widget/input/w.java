package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.graphics.Rect;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.appbrand.jsapi.h.c;
import com.tencent.mm.plugin.appbrand.n.a;
import com.tencent.mm.plugin.appbrand.widget.input.e.e;
import com.tencent.mm.plugin.appbrand.widget.input.e.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.tools.g.a;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/widget/input/AppBrandSecureInputComponent;", "Lcom/tencent/mm/plugin/appbrand/widget/input/AppBrandInputComponent;", "Lcom/tencent/mm/plugin/appbrand/widget/input/AppBrandSecureInputWidget;", "inputType", "", "pageView", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "inputParams", "Lcom/tencent/mm/plugin/appbrand/widget/input/params/InsertParams;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;Lcom/tencent/mm/plugin/appbrand/widget/input/params/InsertParams;)V", "forceLightMode", "", "inputWidget", "keyboardPanel", "Lcom/tencent/mm/plugin/appbrand/widget/input/AppBrandSecureKeyboardPanel;", "myTag", "performingHideKeyboard", "performingShowKeyboard", "sessionId", "style", "Lcom/tencent/mm/plugin/appbrand/widget/input/params/UpdateParams;", "adjustPositionOnFocused", "clearInputWidgetFocus", "", "currentValue", "Landroid/text/Editable;", "dispatchKeyboardComplete", "isInputDone", "doHideKeyboard", "doShowKeyboard", "findKeyboardPanel", "getInput", "getInputPanel", "Landroid/view/View;", "P", "Lcom/tencent/mm/plugin/appbrand/widget/input/IBaseInputPanel;", "getInputPanelMarginBottom", "", "getPosition", "Landroid/graphics/Rect;", "hideKeyboard", "isFocused", "onFocusChanged", "hasFocus", "showKeyboard", "selectionStart", "selectionEnd", "updateStyle", "params", "updateValue", "value", "luggage-wxa-app-input-ext_release"})
public final class w
  extends c<x>
{
  private final String bqj;
  private boolean nnk;
  private com.tencent.mm.plugin.appbrand.widget.input.e.h rtY;
  private boolean rtZ;
  private boolean rua;
  private x rwl;
  private z rwm;
  private final String sessionId;
  
  public w(String paramString, com.tencent.mm.plugin.appbrand.page.ad paramad, e parame)
  {
    super(paramString, paramad, parame.rtN);
    AppMethodBeat.i(213763);
    this.bqj = ("MicroMsg.AppBrand.AppBrandSecureInputComponent#" + this.rtN);
    parame = parame.rAh;
    if (parame != null)
    {
      parame = String.format("AppBrandSecureInput#%s#%s", Arrays.copyOf(new Object[] { Integer.valueOf(paramad.getComponentId()), parame }, 2));
      kotlin.g.b.p.j(parame, "java.lang.String.format(this, *args)");
      this.sessionId = parame;
      parame = paramad.getContext();
      kotlin.g.b.p.j(parame, "pageView.context");
      this.rwl = new x(parame);
      Log.d(this.bqj, "<init>, inputType: " + paramString + ", inputId: " + this.rtN + ", sessionId: " + this.sessionId);
      paramad.a((h.c)new h.c()
      {
        public final void onDestroy()
        {
          AppMethodBeat.i(213859);
          Log.i(w.a(this.rwn), "onDestroy");
          com.tencent.mm.model.ad.beh().Ro(w.c(this.rwn));
          AppMethodBeat.o(213859);
        }
      });
      paramString = this.rwl;
      if (paramString != null) {
        paramString.setListener((x.a)new x.a()
        {
          public final void coR()
          {
            AppMethodBeat.i(213984);
            w.d(this.rwn);
            AppMethodBeat.o(213984);
          }
        });
      }
      paramad = this.sessionId;
      paramString = localObject;
      if (paramad != null)
      {
        paramad = com.tencent.mm.model.ad.beh().Rn(paramad);
        paramString = localObject;
        if (paramad != null) {
          paramString = paramad.getString("SecureInputValue", null);
        }
      }
      paramad = (CharSequence)paramString;
      if ((paramad != null) && (paramad.length() != 0)) {
        break label305;
      }
    }
    label305:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label311;
      }
      paramad = this.rwl;
      if (paramad == null) {
        break label311;
      }
      paramad.setText((CharSequence)paramString);
      AppMethodBeat.o(213763);
      return;
      parame = null;
      break;
    }
    label311:
    AppMethodBeat.o(213763);
  }
  
  private final z coQ()
  {
    AppMethodBeat.i(213759);
    if (this.rwm == null)
    {
      localObject = this.rwl;
      if (localObject == null) {
        break label43;
      }
    }
    label43:
    for (Object localObject = ((x)localObject).getInputPanel();; localObject = null)
    {
      this.rwm = ((z)localObject);
      localObject = this.rwm;
      AppMethodBeat.o(213759);
      return localObject;
    }
  }
  
  private boolean isFocused()
  {
    AppMethodBeat.i(213726);
    Log.d(this.bqj, "isFocused");
    if (this.rwl == null)
    {
      Log.d(this.bqj, "isFocused, inputWidget is null");
      AppMethodBeat.o(213726);
      return false;
    }
    Object localObject = this.rwl;
    if ((localObject != null) && (true == ((x)localObject).isFocused()))
    {
      Log.d(this.bqj, "isFocused, inputWidget focused");
      AppMethodBeat.o(213726);
      return true;
    }
    localObject = coQ();
    if (localObject == null)
    {
      Log.d(this.bqj, "isFocused, keyboardPanel is null");
      AppMethodBeat.o(213726);
      return false;
    }
    if (!((z)localObject).isShown())
    {
      Log.d(this.bqj, "isFocused, keyboardPanel is not shown");
      AppMethodBeat.o(213726);
      return false;
    }
    boolean bool = kotlin.g.b.p.h(((z)localObject).getAttachedInputWidget(), this.rwl);
    AppMethodBeat.o(213726);
    return bool;
  }
  
  private final void kq(boolean paramBoolean)
  {
    AppMethodBeat.i(213761);
    if (!paramBoolean)
    {
      a(cod());
      AppMethodBeat.o(213761);
      return;
    }
    com.tencent.mm.plugin.appbrand.page.ad localad = (com.tencent.mm.plugin.appbrand.page.ad)this.rtP.get();
    localObject = this.rtY;
    try
    {
      localObject = y.a(this.rwl, localad, (com.tencent.mm.plugin.appbrand.widget.input.e.h)localObject);
      localad = null;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        String str = localIllegalStateException.getMessage();
        Log.i(this.bqj, "dispatchKeyboardComplete, encryptErrorMsg: ".concat(String.valueOf(str)));
        localObject = null;
      }
    }
    a(cod(), (String)localObject, localad);
    AppMethodBeat.o(213761);
  }
  
  private final void kt(boolean paramBoolean)
  {
    AppMethodBeat.i(213757);
    Log.d(this.bqj, "doHideKeyboard, isInputDone: ".concat(String.valueOf(paramBoolean)));
    boolean bool = isFocused();
    if ((this.rtZ) || (!bool))
    {
      Log.i(this.bqj, "doHideKeyboard, performingHideKeyboard: " + this.rtZ + ", isFocused: " + bool);
      AppMethodBeat.o(213757);
      return;
    }
    this.rtZ = true;
    kq(paramBoolean);
    Object localObject = this.rwl;
    if (localObject != null) {}
    for (localObject = ((x)localObject).getRealText$luggage_wxa_app_input_ext_release();; localObject = null)
    {
      if (localObject != null)
      {
        String str = this.sessionId;
        if (str != null) {
          com.tencent.mm.model.ad.beh().I(str, true).aO("SecureInputValue", (String)localObject);
        }
      }
      col();
      remove();
      this.rtZ = false;
      this.rwl = null;
      AppMethodBeat.o(213757);
      return;
    }
  }
  
  public final boolean anC(String paramString)
  {
    AppMethodBeat.i(213740);
    Log.d(this.bqj, "updateValue, value: ".concat(String.valueOf(paramString)));
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      localObject = this.rwl;
      if (localObject != null) {
        ((x)localObject).setText((CharSequence)paramString);
      }
      AppMethodBeat.o(213740);
      return true;
    }
    AppMethodBeat.o(213740);
    return false;
  }
  
  protected final com.tencent.mm.plugin.appbrand.widget.input.e.h b(final com.tencent.mm.plugin.appbrand.widget.input.e.h paramh)
  {
    x localx = null;
    AppMethodBeat.i(213734);
    kotlin.g.b.p.k(paramh, "params");
    Log.d(this.bqj, "updateStyle");
    if (this.rtY == null) {
      this.rtY = paramh;
    }
    while (this.rwl == null)
    {
      AppMethodBeat.o(213734);
      return null;
      localh = this.rtY;
      if (localh != null)
      {
        localh.a((f)paramh);
        au localau = au.ryC;
        au.a(localh, paramh);
      }
    }
    b.a((EditText)this.rwl, this.rtY);
    com.tencent.mm.plugin.appbrand.widget.input.e.h localh = this.rtY;
    paramh = localx;
    if (localh != null) {
      paramh = localh.rAS;
    }
    if (paramh != null)
    {
      localx = this.rwl;
      if (localx != null) {
        localx.setLength$luggage_wxa_app_input_ext_release(paramh.intValue());
      }
    }
    com.tencent.e.h.ZvG.bc((Runnable)new b(this, paramh));
    paramh = this.rtY;
    AppMethodBeat.o(213734);
    return paramh;
  }
  
  protected final Rect coa()
  {
    AppMethodBeat.i(213755);
    Object localObject = this.rtY;
    if (localObject == null)
    {
      AppMethodBeat.o(213755);
      return null;
    }
    Integer localInteger = ((com.tencent.mm.plugin.appbrand.widget.input.e.h)localObject).rAm;
    kotlin.g.b.p.j(localInteger, "styleSnapshot.inputLeft");
    int i = localInteger.intValue();
    localInteger = ((com.tencent.mm.plugin.appbrand.widget.input.e.h)localObject).rAl;
    kotlin.g.b.p.j(localInteger, "styleSnapshot.inputTop");
    int j = localInteger.intValue();
    int k = ((com.tencent.mm.plugin.appbrand.widget.input.e.h)localObject).rAm.intValue();
    localInteger = ((com.tencent.mm.plugin.appbrand.widget.input.e.h)localObject).rAj;
    kotlin.g.b.p.j(localInteger, "styleSnapshot.inputWidth");
    int m = localInteger.intValue();
    int n = ((com.tencent.mm.plugin.appbrand.widget.input.e.h)localObject).rAl.intValue();
    localObject = ((com.tencent.mm.plugin.appbrand.widget.input.e.h)localObject).rAk;
    kotlin.g.b.p.j(localObject, "styleSnapshot.inputHeight");
    localObject = new Rect(i, j, k + m, ((Integer)localObject).intValue() + n);
    AppMethodBeat.o(213755);
    return localObject;
  }
  
  public final Editable cod()
  {
    AppMethodBeat.i(213746);
    Editable localEditable = super.cod();
    Log.d(this.bqj, "currentValue, curVal: ".concat(String.valueOf(localEditable)));
    AppMethodBeat.o(213746);
    return localEditable;
  }
  
  public final boolean coj()
  {
    AppMethodBeat.i(213737);
    Boolean localBoolean = Boolean.TRUE;
    Object localObject = this.rtY;
    if (localObject != null) {}
    for (localObject = ((com.tencent.mm.plugin.appbrand.widget.input.e.h)localObject).rAG;; localObject = null)
    {
      boolean bool = kotlin.g.b.p.h(localBoolean, localObject);
      Log.d(this.bqj, "adjustPositionOnFocused, adjustPos: ".concat(String.valueOf(bool)));
      AppMethodBeat.o(213737);
      return bool;
    }
  }
  
  public final int cok()
  {
    AppMethodBeat.i(213750);
    Object localObject = this.rtY;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.appbrand.widget.input.e.h)localObject).rAD;
      if (localObject == null) {}
    }
    for (int i = ((Integer)localObject).intValue();; i = 0)
    {
      Log.d(this.bqj, "getInputPanelMarginBottom, marginBottom: ".concat(String.valueOf(i)));
      AppMethodBeat.o(213750);
      return i;
    }
  }
  
  public final boolean col()
  {
    AppMethodBeat.i(213718);
    Log.d(this.bqj, "hideKeyboard");
    Object localObject = coQ();
    if (localObject == null)
    {
      Log.i(this.bqj, "hideKeyboardInternal, keyboardPanel is null");
      AppMethodBeat.o(213718);
      return false;
    }
    if (isFocused())
    {
      Log.d(((z)localObject).bqj, "hide");
      ((z)localObject).setVisibility(8);
      ((z)localObject).coO();
      Log.d(this.bqj, "clearInputWidgetFocus, inputWidget: " + this.rwl);
      localObject = this.rwl;
      if (localObject != null)
      {
        ((x)localObject).setFocusable(false);
        ((x)localObject).setFocusableInTouchMode(false);
        ((x)localObject).setEnabled(false);
      }
      cof();
      cog();
      AppMethodBeat.o(213718);
      return true;
    }
    AppMethodBeat.o(213718);
    return false;
  }
  
  public final <P extends View,  extends ag> View getInputPanel()
  {
    AppMethodBeat.i(213713);
    Object localObject = coQ();
    Log.d(this.bqj, "getInputPanel, keyboardPanel: ".concat(String.valueOf(localObject)));
    localObject = (View)localObject;
    AppMethodBeat.o(213713);
    return localObject;
  }
  
  protected final boolean kn(boolean paramBoolean)
  {
    AppMethodBeat.i(213721);
    Log.d(this.bqj, "onFocusChanged, hasFocus: ".concat(String.valueOf(paramBoolean)));
    if (!paramBoolean) {
      kt(false);
    }
    for (;;)
    {
      AppMethodBeat.o(213721);
      return true;
      paramBoolean = isFocused();
      if ((this.rua) || (paramBoolean))
      {
        Log.i(this.bqj, "doShowKeyboard, performingShowKeyboard: " + this.rua + ", isFocused: " + paramBoolean);
      }
      else
      {
        this.rua = true;
        r(-2, -2, this.nnk);
        this.rua = false;
      }
    }
  }
  
  public final boolean r(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject3 = null;
    AppMethodBeat.i(213717);
    Log.d(this.bqj, "showKeyboard, selectionStart: " + paramInt1 + ", selectionEnd: " + paramInt2 + ", forceLightMode: " + paramBoolean);
    if (this.rwl == null)
    {
      Log.i(this.bqj, "showKeyboard, inputWidget is null");
      AppMethodBeat.o(213717);
      return false;
    }
    Object localObject1 = (com.tencent.mm.plugin.appbrand.page.ad)this.rtP.get();
    if (localObject1 != null) {}
    for (localObject1 = ((com.tencent.mm.plugin.appbrand.page.ad)localObject1).getContentView(); localObject1 == null; localObject1 = null)
    {
      Log.w(this.bqj, "showKeyboard, pageContentView is null");
      AppMethodBeat.o(213717);
      return false;
    }
    Object localObject2 = z.rwB;
    localObject2 = this.rtY;
    boolean bool;
    label190:
    Object localObject4;
    if (localObject2 != null)
    {
      localObject2 = ((com.tencent.mm.plugin.appbrand.widget.input.e.h)localObject2).rAQ;
      if (localObject2 != null)
      {
        bool = ((Boolean)localObject2).booleanValue();
        localObject2 = (com.tencent.mm.plugin.appbrand.page.ad)this.rtP.get();
        if (localObject2 == null) {
          break label260;
        }
        localObject2 = ((com.tencent.mm.plugin.appbrand.page.ad)localObject2).cef();
        kotlin.g.b.p.k(localObject1, "view");
        localObject4 = z.a.dv((View)localObject1);
        if (localObject4 == null) {
          break label266;
        }
        z.a((z)localObject4, bool, (a)localObject2);
        localObject1 = localObject4;
      }
    }
    for (;;)
    {
      this.rwm = ((z)localObject1);
      if (this.rwm != null) {
        break label338;
      }
      Log.w(this.bqj, "showKeyboard, keyboardPanel is null");
      AppMethodBeat.o(213717);
      return false;
      bool = false;
      break;
      label260:
      localObject2 = null;
      break label190;
      label266:
      localObject4 = n.dp((View)localObject1);
      if (localObject4 == null)
      {
        Log.w("MicroMsg.AppBrand.AppBrandSecureKeyboardPanel", "settleKeyboardPanel, rootFrameLayout is null");
        localObject1 = localObject3;
      }
      else
      {
        localObject1 = ((View)localObject1).getContext();
        kotlin.g.b.p.j(localObject1, "view.context");
        localObject1 = new z((Context)localObject1, bool, (a)localObject2);
        ((n)localObject4).m((View)localObject1, false);
      }
    }
    label338:
    this.rua = true;
    coe();
    this.nnk = paramBoolean;
    if (paramBoolean)
    {
      localObject1 = this.rwm;
      if (localObject1 != null)
      {
        Log.d(((z)localObject1).bqj, "forceLightMode");
        ((z)localObject1).rwx.bAy();
      }
    }
    localObject1 = this.rwm;
    if (localObject1 != null)
    {
      localObject2 = (EditText)this.rwl;
      Log.d(((z)localObject1).bqj, "show");
      if (localObject2 != null) {
        break label483;
      }
      Log.i(((z)localObject1).bqj, "show, inputWidget is null");
    }
    for (;;)
    {
      localObject1 = this.rwm;
      if (localObject1 != null) {
        ((z)localObject1).setOnDoneListener((z.b)new a(this));
      }
      fh(paramInt1, paramInt2);
      coh();
      this.rua = false;
      AppMethodBeat.o(213717);
      return true;
      label483:
      if ((kotlin.g.b.p.h(localObject2, ((z)localObject1).rwy) ^ true)) {
        ((z)localObject1).coO();
      }
      ((z)localObject1).setInputWidget((EditText)localObject2);
      ((z)localObject1).setVisibility(0);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/widget/input/AppBrandSecureInputComponent$showKeyboard$1", "Lcom/tencent/mm/plugin/appbrand/widget/input/AppBrandSecureKeyboardPanel$OnDoneListener;", "onDone", "", "luggage-wxa-app-input-ext_release"})
  public static final class a
    implements z.b
  {
    public final void onDone()
    {
      AppMethodBeat.i(214343);
      Log.d(w.a(this.rwn), "onDone#OnDoneListener");
      this.rwn.kn(false);
      AppMethodBeat.o(214343);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(w paramw, Integer paramInteger) {}
    
    public final void run()
    {
      AppMethodBeat.i(214794);
      x localx = w.b(this.rwn);
      if (localx == null)
      {
        AppMethodBeat.o(214794);
        return;
      }
      Integer localInteger = paramh;
      if (localInteger != null)
      {
        int i = localInteger.intValue();
        Log.i(w.a(this.rwn), "updateStyle, maxLength: ".concat(String.valueOf(i)));
        p.a((EditText)localx).axx(i).Hh(false).b(g.a.XSt).a(null);
        AppMethodBeat.o(214794);
        return;
      }
      AppMethodBeat.o(214794);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.w
 * JD-Core Version:    0.7.0.1
 */