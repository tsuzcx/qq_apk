package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.graphics.Rect;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.appbrand.o.a;
import com.tencent.mm.plugin.appbrand.widget.input.e.e;
import com.tencent.mm.plugin.appbrand.widget.input.e.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.tools.g.a;
import com.tencent.threadpool.i;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/input/AppBrandSecureInputComponent;", "Lcom/tencent/mm/plugin/appbrand/widget/input/AppBrandInputComponent;", "Lcom/tencent/mm/plugin/appbrand/widget/input/AppBrandSecureInputWidget;", "inputType", "", "pageView", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "inputParams", "Lcom/tencent/mm/plugin/appbrand/widget/input/params/InsertParams;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;Lcom/tencent/mm/plugin/appbrand/widget/input/params/InsertParams;)V", "forceLightMode", "", "inputWidget", "keyboardPanel", "Lcom/tencent/mm/plugin/appbrand/widget/input/AppBrandSecureKeyboardPanel;", "myTag", "performingHideKeyboard", "performingShowKeyboard", "sessionId", "style", "Lcom/tencent/mm/plugin/appbrand/widget/input/params/UpdateParams;", "adjustPositionOnFocused", "clearInputWidgetFocus", "", "currentValue", "Landroid/text/Editable;", "dispatchKeyboardComplete", "isInputDone", "doHideKeyboard", "doShowKeyboard", "findKeyboardPanel", "getInput", "getInputPanel", "Landroid/view/View;", "P", "Lcom/tencent/mm/plugin/appbrand/widget/input/IBaseInputPanel;", "getInputPanelMarginBottom", "", "getPosition", "Landroid/graphics/Rect;", "hideKeyboard", "isFocused", "onFocusChanged", "hasFocus", "showKeyboard", "selectionStart", "selectionEnd", "updateStyle", "params", "updateValue", "value", "luggage-wxa-app-input-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class w
  extends c<x>
{
  private final String djQ;
  private boolean qkq;
  private final String sessionId;
  private com.tencent.mm.plugin.appbrand.widget.input.e.h uFd;
  private boolean uFe;
  private boolean uFf;
  private x uHs;
  private z uHt;
  
  public w(String paramString, com.tencent.mm.plugin.appbrand.page.ad paramad, e parame)
  {
    super(paramString, paramad, parame.uES);
    AppMethodBeat.i(324524);
    this.djQ = s.X("MicroMsg.AppBrand.AppBrandSecureInputComponent#", Integer.valueOf(this.uES));
    parame = parame.uLy;
    if (parame == null)
    {
      parame = null;
      this.sessionId = parame;
      parame = paramad.getContext();
      s.s(parame, "pageView.context");
      this.uHs = new x(parame);
      Log.d(this.djQ, "<init>, inputType: " + paramString + ", inputId: " + this.uES + ", sessionId: " + this.sessionId);
      paramad.a(new w..ExternalSyntheticLambda0(this));
      paramString = this.uHs;
      if (paramString != null) {
        paramString.setListener((x.a)new x.a()
        {
          public final void cRt()
          {
            AppMethodBeat.i(324627);
            w.c(this.uHu);
            AppMethodBeat.o(324627);
          }
        });
      }
      paramString = this.sessionId;
      if (paramString != null) {
        break label272;
      }
      paramString = localObject;
      label186:
      paramad = (CharSequence)paramString;
      if ((paramad != null) && (paramad.length() != 0)) {
        break label298;
      }
    }
    label272:
    label298:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        paramad = this.uHs;
        if (paramad != null) {
          paramad.setText((CharSequence)paramString);
        }
      }
      AppMethodBeat.o(324524);
      return;
      parame = String.format("AppBrandSecureInput#%s#%s", Arrays.copyOf(new Object[] { Integer.valueOf(paramad.getComponentId()), parame }, 2));
      s.s(parame, "java.lang.String.format(this, *args)");
      break;
      paramad = com.tencent.mm.model.ad.bCb().Jm(paramString);
      paramString = localObject;
      if (paramad == null) {
        break label186;
      }
      paramString = paramad.getString("SecureInputValue", null);
      break label186;
    }
  }
  
  private static final void a(w paramw)
  {
    AppMethodBeat.i(324545);
    s.u(paramw, "this$0");
    Log.i(paramw.djQ, "onDestroy");
    com.tencent.mm.model.ad.bCb().Jn(paramw.sessionId);
    AppMethodBeat.o(324545);
  }
  
  private static final void a(w paramw, Integer paramInteger)
  {
    AppMethodBeat.i(324549);
    s.u(paramw, "this$0");
    x localx = paramw.uHs;
    if (localx == null)
    {
      AppMethodBeat.o(324549);
      return;
    }
    if (paramInteger == null)
    {
      AppMethodBeat.o(324549);
      return;
    }
    int i = paramInteger.intValue();
    Log.i(paramw.djQ, s.X("updateStyle, maxLength: ", Integer.valueOf(i)));
    p.a((EditText)localx).aEg(i).Nc(false).b(g.a.afIH).a(null);
    AppMethodBeat.o(324549);
  }
  
  private final z cRs()
  {
    AppMethodBeat.i(324537);
    if (this.uHt == null)
    {
      localObject = this.uHs;
      if (localObject != null) {
        break label42;
      }
    }
    label42:
    for (Object localObject = null;; localObject = ((x)localObject).getInputPanel())
    {
      this.uHt = ((z)localObject);
      localObject = this.uHt;
      AppMethodBeat.o(324537);
      return localObject;
    }
  }
  
  private boolean isFocused()
  {
    AppMethodBeat.i(324528);
    Log.d(this.djQ, "isFocused");
    if (this.uHs == null)
    {
      Log.d(this.djQ, "isFocused, inputWidget is null");
      AppMethodBeat.o(324528);
      return false;
    }
    Object localObject = this.uHs;
    if ((localObject != null) && (true == ((x)localObject).isFocused())) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.d(this.djQ, "isFocused, inputWidget focused");
      AppMethodBeat.o(324528);
      return true;
    }
    localObject = cRs();
    if (localObject == null)
    {
      Log.d(this.djQ, "isFocused, keyboardPanel is null");
      AppMethodBeat.o(324528);
      return false;
    }
    if (!((z)localObject).isShown())
    {
      Log.d(this.djQ, "isFocused, keyboardPanel is not shown");
      AppMethodBeat.o(324528);
      return false;
    }
    boolean bool = s.p(((z)localObject).getAttachedInputWidget(), this.uHs);
    AppMethodBeat.o(324528);
    return bool;
  }
  
  private final void lC(boolean paramBoolean)
  {
    AppMethodBeat.i(324541);
    if (!paramBoolean)
    {
      a(cQF());
      AppMethodBeat.o(324541);
      return;
    }
    com.tencent.mm.plugin.appbrand.page.ad localad = (com.tencent.mm.plugin.appbrand.page.ad)this.uEU.get();
    localObject = this.uFd;
    try
    {
      localObject = y.a(this.uHs, localad, (com.tencent.mm.plugin.appbrand.widget.input.e.h)localObject);
      localad = null;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        String str = localIllegalStateException.getMessage();
        Log.i(this.djQ, s.X("dispatchKeyboardComplete, encryptErrorMsg: ", str));
        localObject = null;
      }
    }
    a(cQF(), (String)localObject, localad);
    AppMethodBeat.o(324541);
  }
  
  private final void lF(boolean paramBoolean)
  {
    AppMethodBeat.i(324534);
    Log.d(this.djQ, s.X("doHideKeyboard, isInputDone: ", Boolean.valueOf(paramBoolean)));
    boolean bool = isFocused();
    if ((this.uFe) || (!bool))
    {
      Log.i(this.djQ, "doHideKeyboard, performingHideKeyboard: " + this.uFe + ", isFocused: " + bool);
      AppMethodBeat.o(324534);
      return;
    }
    this.uFe = true;
    lC(paramBoolean);
    Object localObject = this.uHs;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((x)localObject).getRealText$luggage_wxa_app_input_ext_release())
    {
      if (localObject != null)
      {
        String str = this.sessionId;
        if (str != null) {
          com.tencent.mm.model.ad.bCb().M(str, true).aY("SecureInputValue", (String)localObject);
        }
      }
      cQN();
      remove();
      this.uFe = false;
      this.uHs = null;
      AppMethodBeat.o(324534);
      return;
    }
  }
  
  public final boolean agZ(String paramString)
  {
    AppMethodBeat.i(324588);
    Log.d(this.djQ, s.X("updateValue, value: ", paramString));
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      localObject = this.uHs;
      if (localObject != null) {
        ((x)localObject).setText((CharSequence)paramString);
      }
      AppMethodBeat.o(324588);
      return true;
    }
    AppMethodBeat.o(324588);
    return false;
  }
  
  protected final com.tencent.mm.plugin.appbrand.widget.input.e.h b(com.tencent.mm.plugin.appbrand.widget.input.e.h paramh)
  {
    x localx = null;
    AppMethodBeat.i(324580);
    s.u(paramh, "params");
    Log.d(this.djQ, "updateStyle");
    if (this.uFd == null) {
      this.uFd = paramh;
    }
    while (this.uHs == null)
    {
      AppMethodBeat.o(324580);
      return null;
      com.tencent.mm.plugin.appbrand.widget.input.e.h localh = this.uFd;
      if (localh != null)
      {
        localh.a((f)paramh);
        au localau = au.uJG;
        au.a(localh, paramh);
      }
    }
    b.a((EditText)this.uHs, this.uFd);
    paramh = this.uFd;
    if (paramh == null) {}
    for (paramh = localx;; paramh = paramh.uMi)
    {
      if (paramh != null)
      {
        localx = this.uHs;
        if (localx != null) {
          localx.setLength$luggage_wxa_app_input_ext_release(paramh.intValue());
        }
      }
      com.tencent.threadpool.h.ahAA.bk(new w..ExternalSyntheticLambda1(this, paramh));
      paramh = this.uFd;
      AppMethodBeat.o(324580);
      return paramh;
    }
  }
  
  protected final Rect cQC()
  {
    AppMethodBeat.i(324594);
    Object localObject = this.uFd;
    if (localObject == null)
    {
      AppMethodBeat.o(324594);
      return null;
    }
    Integer localInteger = ((com.tencent.mm.plugin.appbrand.widget.input.e.h)localObject).uLC;
    s.s(localInteger, "styleSnapshot.inputLeft");
    int i = ((Number)localInteger).intValue();
    localInteger = ((com.tencent.mm.plugin.appbrand.widget.input.e.h)localObject).uLB;
    s.s(localInteger, "styleSnapshot.inputTop");
    int j = ((Number)localInteger).intValue();
    int k = ((com.tencent.mm.plugin.appbrand.widget.input.e.h)localObject).uLC.intValue();
    localInteger = ((com.tencent.mm.plugin.appbrand.widget.input.e.h)localObject).uLz;
    s.s(localInteger, "styleSnapshot.inputWidth");
    int m = ((Number)localInteger).intValue();
    int n = ((com.tencent.mm.plugin.appbrand.widget.input.e.h)localObject).uLB.intValue();
    localObject = ((com.tencent.mm.plugin.appbrand.widget.input.e.h)localObject).uLA;
    s.s(localObject, "styleSnapshot.inputHeight");
    localObject = new Rect(i, j, k + m, ((Number)localObject).intValue() + n);
    AppMethodBeat.o(324594);
    return localObject;
  }
  
  public final Editable cQF()
  {
    AppMethodBeat.i(324590);
    Editable localEditable = super.cQF();
    Log.d(this.djQ, s.X("currentValue, curVal: ", localEditable));
    AppMethodBeat.o(324590);
    return localEditable;
  }
  
  public final boolean cQL()
  {
    AppMethodBeat.i(324584);
    com.tencent.mm.plugin.appbrand.widget.input.e.h localh = this.uFd;
    if (localh == null) {}
    for (boolean bool = false;; bool = s.p(Boolean.TRUE, localh.uLW))
    {
      Log.d(this.djQ, s.X("adjustPositionOnFocused, adjustPos: ", Boolean.valueOf(bool)));
      AppMethodBeat.o(324584);
      return bool;
    }
  }
  
  public final int cQM()
  {
    int i = 0;
    AppMethodBeat.i(324592);
    Object localObject = this.uFd;
    if (localObject == null) {}
    for (;;)
    {
      Log.d(this.djQ, s.X("getInputPanelMarginBottom, marginBottom: ", Integer.valueOf(i)));
      AppMethodBeat.o(324592);
      return i;
      localObject = ((com.tencent.mm.plugin.appbrand.widget.input.e.h)localObject).uLT;
      if (localObject != null) {
        i = ((Integer)localObject).intValue();
      }
    }
  }
  
  public final boolean cQN()
  {
    AppMethodBeat.i(324573);
    Log.d(this.djQ, "hideKeyboard");
    Object localObject = cRs();
    if (localObject == null)
    {
      Log.i(this.djQ, "hideKeyboardInternal, keyboardPanel is null");
      AppMethodBeat.o(324573);
      return false;
    }
    if (isFocused())
    {
      Log.d(((z)localObject).djQ, "hide");
      ((z)localObject).setVisibility(8);
      ((z)localObject).cRq();
      Log.d(this.djQ, s.X("clearInputWidgetFocus, inputWidget: ", this.uHs));
      localObject = this.uHs;
      if (localObject != null)
      {
        ((x)localObject).setFocusable(false);
        ((x)localObject).setFocusableInTouchMode(false);
        ((x)localObject).setEnabled(false);
      }
      cQS();
      cQT();
      AppMethodBeat.o(324573);
      return true;
    }
    AppMethodBeat.o(324573);
    return false;
  }
  
  public final <P extends View,  extends ag> View getInputPanel()
  {
    AppMethodBeat.i(324565);
    Object localObject = cRs();
    Log.d(this.djQ, s.X("getInputPanel, keyboardPanel: ", localObject));
    localObject = (View)localObject;
    AppMethodBeat.o(324565);
    return localObject;
  }
  
  protected final boolean lz(boolean paramBoolean)
  {
    AppMethodBeat.i(324577);
    Log.d(this.djQ, s.X("onFocusChanged, hasFocus: ", Boolean.valueOf(paramBoolean)));
    if (!paramBoolean) {
      lF(false);
    }
    for (;;)
    {
      AppMethodBeat.o(324577);
      return true;
      paramBoolean = isFocused();
      if ((this.uFf) || (paramBoolean))
      {
        Log.i(this.djQ, "doShowKeyboard, performingShowKeyboard: " + this.uFf + ", isFocused: " + paramBoolean);
      }
      else
      {
        this.uFf = true;
        r(-2, -2, this.qkq);
        this.uFf = false;
      }
    }
  }
  
  public final boolean r(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject3 = null;
    AppMethodBeat.i(324570);
    Log.d(this.djQ, "showKeyboard, selectionStart: " + paramInt1 + ", selectionEnd: " + paramInt2 + ", forceLightMode: " + paramBoolean);
    if (this.uHs == null)
    {
      Log.i(this.djQ, "showKeyboard, inputWidget is null");
      AppMethodBeat.o(324570);
      return false;
    }
    Object localObject1 = (com.tencent.mm.plugin.appbrand.page.ad)this.uEU.get();
    if (localObject1 == null) {}
    for (localObject1 = null; localObject1 == null; localObject1 = ((com.tencent.mm.plugin.appbrand.page.ad)localObject1).getContentView())
    {
      Log.w(this.djQ, "showKeyboard, pageContentView is null");
      AppMethodBeat.o(324570);
      return false;
    }
    Object localObject2 = z.uHA;
    localObject2 = this.uFd;
    boolean bool;
    label170:
    Object localObject4;
    if (localObject2 == null)
    {
      bool = false;
      localObject2 = (com.tencent.mm.plugin.appbrand.page.ad)this.uEU.get();
      if (localObject2 != null) {
        break label262;
      }
      localObject2 = null;
      s.u(localObject1, "view");
      localObject4 = z.a.ej((View)localObject1);
      if (localObject4 == null) {
        break label272;
      }
      z.a((z)localObject4, bool, (a)localObject2);
      localObject1 = localObject4;
    }
    for (;;)
    {
      this.uHt = ((z)localObject1);
      if (this.uHt != null) {
        break label344;
      }
      Log.w(this.djQ, "showKeyboard, keyboardPanel is null");
      AppMethodBeat.o(324570);
      return false;
      localObject2 = ((com.tencent.mm.plugin.appbrand.widget.input.e.h)localObject2).uMg;
      if (localObject2 == null)
      {
        bool = false;
        break;
      }
      bool = ((Boolean)localObject2).booleanValue();
      break;
      label262:
      localObject2 = ((com.tencent.mm.plugin.appbrand.page.ad)localObject2).cEK();
      break label170;
      label272:
      localObject4 = n.ed((View)localObject1);
      if (localObject4 == null)
      {
        Log.w("MicroMsg.AppBrand.AppBrandSecureKeyboardPanel", "settleKeyboardPanel, rootFrameLayout is null");
        localObject1 = localObject3;
      }
      else
      {
        localObject1 = ((View)localObject1).getContext();
        s.s(localObject1, "view.context");
        localObject1 = new z((Context)localObject1, bool, (a)localObject2);
        ((n)localObject4).n((View)localObject1, false);
      }
    }
    label344:
    this.uFf = true;
    cQJ();
    this.qkq = paramBoolean;
    if (paramBoolean)
    {
      localObject1 = this.uHt;
      if (localObject1 != null)
      {
        Log.d(((z)localObject1).djQ, "forceLightMode");
        ((z)localObject1).uHC.bZo();
      }
    }
    localObject1 = this.uHt;
    if (localObject1 != null)
    {
      localObject2 = (EditText)this.uHs;
      Log.d(((z)localObject1).djQ, "show");
      if (localObject2 != null) {
        break label489;
      }
      Log.i(((z)localObject1).djQ, "show, inputWidget is null");
    }
    for (;;)
    {
      localObject1 = this.uHt;
      if (localObject1 != null) {
        ((z)localObject1).setOnDoneListener((z.b)new a(this));
      }
      fZ(paramInt1, paramInt2);
      cQU();
      this.uFf = false;
      AppMethodBeat.o(324570);
      return true;
      label489:
      if (!s.p(localObject2, ((z)localObject1).uHD)) {
        ((z)localObject1).cRq();
      }
      ((z)localObject1).setInputWidget((EditText)localObject2);
      ((z)localObject1).setVisibility(0);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/widget/input/AppBrandSecureInputComponent$showKeyboard$1", "Lcom/tencent/mm/plugin/appbrand/widget/input/AppBrandSecureKeyboardPanel$OnDoneListener;", "onDone", "", "luggage-wxa-app-input-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements z.b
  {
    a(w paramw) {}
    
    public final void onDone()
    {
      AppMethodBeat.i(324600);
      Log.d(w.b(this.uHu), "onDone#OnDoneListener");
      this.uHu.lz(false);
      AppMethodBeat.o(324600);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.w
 * JD-Core Version:    0.7.0.1
 */