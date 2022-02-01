package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.k;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.i;
import com.tenpay.miniapp.MiniAppSecureEditText;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.d;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/input/AppBrandSecureInputWidget;", "Lcom/tencent/mm/plugin/appbrand/widget/input/AppBrandInputWidgetSingleLineBase;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "cachedCertPem", "", "cachedSafePasswordCertPath", "listener", "Lcom/tencent/mm/plugin/appbrand/widget/input/AppBrandSecureInputWidget$IListener;", "getListener", "()Lcom/tencent/mm/plugin/appbrand/widget/input/AppBrandSecureInputWidget$IListener;", "setListener", "(Lcom/tencent/mm/plugin/appbrand/widget/input/AppBrandSecureInputWidget$IListener;)V", "myTag", "getMyTag$luggage_wxa_app_input_ext_release", "()Ljava/lang/String;", "secureInputWidgetLogic", "Lcom/tenpay/miniapp/MiniAppSecureEditText;", "getSecureInputWidgetLogic$luggage_wxa_app_input_ext_release", "()Lcom/tenpay/miniapp/MiniAppSecureEditText;", "appendText", "", "text", "", "deleteLast", "dispatchKeyEvent", "", "event", "Landroid/view/KeyEvent;", "ensureInputConnection", "getInputPanel", "Lcom/tencent/mm/plugin/appbrand/widget/input/AppBrandSecureKeyboardPanel;", "getRealText", "getRealText$luggage_wxa_app_input_ext_release", "onAttachedToPage", "page", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "onCreateContextMenu", "menu", "Landroid/view/ContextMenu;", "onCreateInputConnection", "Landroid/view/inputmethod/InputConnection;", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "onDetachedFromPage", "onSelectionChanged", "selStart", "", "selEnd", "onSelectionChangedDisable", "onSelectionChangedSync", "onTextContextMenuItem", "id", "readCertPem", "env", "safePasswordCertPath", "readCertPem$luggage_wxa_app_input_ext_release", "realSetSelection", "index", "start", "stop", "saveLastKeyPressed", "code", "", "setInputId", "setLength", "length", "setLength$luggage_wxa_app_input_ext_release", "setLogicSelection", "setText", "type", "Landroid/widget/TextView$BufferType;", "supportsAutoFill", "isKeyCodeLetterOrDigit", "IListener", "luggage-wxa-app-input-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class x
  extends r
{
  private a uHv;
  private final MiniAppSecureEditText uHw;
  private String uHx;
  private String uHy;
  
  public x(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(324520);
    this.uHw = new MiniAppSecureEditText(paramContext);
    setImeOptions(1);
    new av((TextView)this);
    this.uHw.setText((CharSequence)getText());
    gb(getSelectionStart(), getSelectionEnd());
    this.uHw.setOnPasswdInputListener(new x..ExternalSyntheticLambda0(this));
    this.uHw.addTextChangedListener((TextWatcher)new i()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(324482);
        super.afterTextChanged(paramAnonymousEditable);
        AppMethodBeat.o(324482);
      }
    });
    AppMethodBeat.o(324520);
  }
  
  private static final void a(x paramx)
  {
    AppMethodBeat.i(324527);
    s.u(paramx, "this$0");
    Log.d(paramx.getMyTag$luggage_wxa_app_input_ext_release(), "onDone#secureInputWidgetLogic");
    paramx = paramx.getListener();
    if (paramx != null) {
      paramx.cRt();
    }
    AppMethodBeat.o(324527);
  }
  
  private static final void a(x paramx, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(324529);
    s.u(paramx, "this$0");
    paramx.gb(paramInt1, paramInt2);
    AppMethodBeat.o(324529);
  }
  
  private final void gb(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(324523);
    if ((paramInt1 >= 0) && (paramInt2 >= 0) && (paramInt1 <= paramInt2)) {
      try
      {
        this.uHw.setSelection(paramInt1, paramInt2);
        AppMethodBeat.o(324523);
        return;
      }
      catch (Exception localException) {}
    }
    AppMethodBeat.o(324523);
  }
  
  public final void H(ad paramad)
  {
    AppMethodBeat.i(324593);
    Log.d(getMyTag$luggage_wxa_app_input_ext_release(), "onAttachedToPage");
    AppMethodBeat.o(324593);
  }
  
  public final void I(ad paramad)
  {
    AppMethodBeat.i(324596);
    Log.d(getMyTag$luggage_wxa_app_input_ext_release(), "onDetachedFromPage");
    AppMethodBeat.o(324596);
  }
  
  public final void R(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(324579);
    Log.e(getMyTag$luggage_wxa_app_input_ext_release(), s.X("appendText, text: ", paramCharSequence));
    AppMethodBeat.o(324579);
  }
  
  public final String b(ad paramad, String paramString)
  {
    AppMethodBeat.i(324604);
    s.u(paramad, "env");
    s.u(paramString, "safePasswordCertPath");
    if (s.p(paramString, this.uHx))
    {
      paramad = this.uHy;
      if (paramad == null)
      {
        Log.e(((x)this).getMyTag$luggage_wxa_app_input_ext_release(), "readCertPem, cachedCertPem is null");
        paramad = new IllegalStateException("certPath is illegal");
        AppMethodBeat.o(324604);
        throw paramad;
      }
      AppMethodBeat.o(324604);
      return paramad;
    }
    k localk = new k();
    paramad = paramad.getFileSystem();
    if (paramad == null) {}
    for (paramad = null; paramad == null; paramad = paramad.b(paramString, localk))
    {
      Log.e(getMyTag$luggage_wxa_app_input_ext_release(), "readCertPem, opResult is null");
      paramad = new IllegalStateException("env error");
      AppMethodBeat.o(324604);
      throw paramad;
    }
    if (com.tencent.mm.plugin.appbrand.appstorage.r.qML != paramad)
    {
      Log.e(getMyTag$luggage_wxa_app_input_ext_release(), s.X("getEncryptedData, opResult: ", paramad));
      paramad = new IllegalStateException("certPath is illegal");
      AppMethodBeat.o(324604);
      throw paramad;
    }
    paramad = localk.value;
    s.s(paramad, "byteBufRef.value");
    paramad = new String(at.F((ByteBuffer)paramad), d.UTF_8);
    this.uHy = paramad;
    this.uHx = paramString;
    AppMethodBeat.o(324604);
    return paramad;
  }
  
  public final boolean cRk()
  {
    AppMethodBeat.i(324589);
    Log.d(getMyTag$luggage_wxa_app_input_ext_release(), "supportsAutoFill");
    AppMethodBeat.o(324589);
    return false;
  }
  
  protected final void cRl()
  {
    AppMethodBeat.i(324582);
    if (androidx.core.g.z.ay((View)this))
    {
      z localz = getInputPanel();
      if (localz != null) {
        localz.setInputWidget((EditText)this);
      }
    }
    AppMethodBeat.o(324582);
  }
  
  public final void cRu()
  {
    AppMethodBeat.i(324574);
    Log.d(getMyTag$luggage_wxa_app_input_ext_release(), "deleteLast");
    dispatchKeyEvent(new KeyEvent(0, 67));
    dispatchKeyEvent(new KeyEvent(1, 67));
    AppMethodBeat.o(324574);
  }
  
  public final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    int j = 0;
    AppMethodBeat.i(324557);
    s.u(paramKeyEvent, "event");
    int i = paramKeyEvent.getKeyCode();
    if (7 <= i) {
      if (i <= 16)
      {
        i = 1;
        if (i == 0)
        {
          i = paramKeyEvent.getKeyCode();
          if (29 > i) {
            break label196;
          }
          if (i > 54) {
            break label191;
          }
          i = 1;
          label57:
          if (i == 0) {}
        }
        else
        {
          j = 1;
        }
        if (j == 0) {
          break label201;
        }
      }
    }
    label191:
    label196:
    label201:
    for (KeyEvent localKeyEvent = new KeyEvent(paramKeyEvent.getAction(), 155);; localKeyEvent = paramKeyEvent)
    {
      Log.d(getMyTag$luggage_wxa_app_input_ext_release(), "dispatchKeyEvent, event: " + paramKeyEvent + ", dispatchedKeyEvent: " + localKeyEvent);
      boolean bool1 = super.dispatchKeyEvent(localKeyEvent);
      boolean bool2 = this.uHw.dispatchKeyEvent(paramKeyEvent);
      Log.d(getMyTag$luggage_wxa_app_input_ext_release(), "dispatchKeyEvent, handled: " + bool1 + ", handled2: " + bool2);
      AppMethodBeat.o(324557);
      return bool1;
      i = 0;
      break;
      i = 0;
      break;
      i = 0;
      break label57;
      i = 0;
      break label57;
    }
  }
  
  public final z getInputPanel()
  {
    AppMethodBeat.i(324586);
    Object localObject = z.uHA;
    localObject = z.a.ej((View)this);
    Log.d(getMyTag$luggage_wxa_app_input_ext_release(), s.X("getInputPanel, keyboardPanel: ", localObject));
    AppMethodBeat.o(324586);
    return localObject;
  }
  
  public final a getListener()
  {
    return this.uHv;
  }
  
  public final String getMyTag$luggage_wxa_app_input_ext_release()
  {
    AppMethodBeat.i(324539);
    String str = s.X("MicroMsg.AppBrand.AppBrandSecureInputWidget#", Integer.valueOf(getInputId()));
    AppMethodBeat.o(324539);
    return str;
  }
  
  public final String getRealText$luggage_wxa_app_input_ext_release()
  {
    AppMethodBeat.i(324601);
    Object localObject = this.uHw.getText();
    if (localObject == null)
    {
      AppMethodBeat.o(324601);
      return null;
    }
    localObject = localObject.toString();
    AppMethodBeat.o(324601);
    return localObject;
  }
  
  public final MiniAppSecureEditText getSecureInputWidgetLogic$luggage_wxa_app_input_ext_release()
  {
    return this.uHw;
  }
  
  protected final void onCreateContextMenu(ContextMenu paramContextMenu)
  {
    AppMethodBeat.i(324571);
    if (paramContextMenu != null) {
      paramContextMenu.clearHeader();
    }
    AppMethodBeat.o(324571);
  }
  
  public final InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    AppMethodBeat.i(324551);
    Log.d(getMyTag$luggage_wxa_app_input_ext_release(), "onCreateInputConnection");
    AppMethodBeat.o(324551);
    return null;
  }
  
  protected final void onSelectionChanged(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(324567);
    Log.i(getMyTag$luggage_wxa_app_input_ext_release(), "onSelectionChanged, selStart: " + paramInt1 + ", selEnd: " + paramInt2);
    Editable localEditable = getText();
    if (localEditable == null) {}
    for (int i = 0;; i = localEditable.length())
    {
      Log.i(getMyTag$luggage_wxa_app_input_ext_release(), s.X("onSelectionChangedDisable, sel: ", Integer.valueOf(i)));
      if ((paramInt1 == i) && (paramInt2 == i)) {
        break;
      }
      setSelection(i, i);
      AppMethodBeat.o(324567);
      return;
    }
    super.onSelectionChanged(paramInt1, paramInt2);
    post(new x..ExternalSyntheticLambda1(this, paramInt1, paramInt2));
    AppMethodBeat.o(324567);
  }
  
  public final boolean onTextContextMenuItem(int paramInt)
  {
    return true;
  }
  
  public final void setInputId(int paramInt)
  {
    AppMethodBeat.i(324591);
    Log.d(getMyTag$luggage_wxa_app_input_ext_release(), s.X("setInputId, id: ", Integer.valueOf(paramInt)));
    super.setInputId(paramInt);
    AppMethodBeat.o(324591);
  }
  
  public final void setLength$luggage_wxa_app_input_ext_release(int paramInt)
  {
    AppMethodBeat.i(324598);
    Log.d(getMyTag$luggage_wxa_app_input_ext_release(), s.X("setLength, length: ", Integer.valueOf(paramInt)));
    this.uHw.setInputLength(paramInt, paramInt);
    AppMethodBeat.o(324598);
  }
  
  public final void setListener(a parama)
  {
    this.uHv = parama;
  }
  
  public final void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    AppMethodBeat.i(324564);
    Object localObject;
    if (paramCharSequence != null)
    {
      localObject = new StringBuilder();
      int j = paramCharSequence.length();
      int i = 0;
      if (i < j)
      {
        char c2 = paramCharSequence.charAt(i);
        if (Character.isLetterOrDigit(c2)) {}
        for (char c1 = '*';; c1 = c2)
        {
          Log.d(getMyTag$luggage_wxa_app_input_ext_release(), "setText, i: " + i + ", char: " + c2 + ", shownChar: " + c1);
          ((StringBuilder)localObject).append(c1);
          i += 1;
          break;
        }
      }
      localObject = ((StringBuilder)localObject).toString();
      s.s(localObject, "StringBuilder().apply(builderAction).toString()");
    }
    for (;;)
    {
      Log.i("MicroMsg.AppBrand.AppBrandSecureInputWidget", "setText, text: " + paramCharSequence + ", shownText: " + localObject + ", type: " + paramBufferType);
      super.setText((CharSequence)localObject, paramBufferType);
      try
      {
        this.uHw.setText(paramCharSequence, paramBufferType);
        AppMethodBeat.o(324564);
        return;
      }
      catch (NullPointerException paramCharSequence)
      {
        AppMethodBeat.o(324564);
      }
      localObject = (String)paramCharSequence;
    }
  }
  
  public final void y(char paramChar)
  {
    AppMethodBeat.i(324578);
    if (Character.isLetterOrDigit(paramChar)) {}
    for (char c = '*';; c = paramChar)
    {
      Log.d(getMyTag$luggage_wxa_app_input_ext_release(), "saveLastKeyPressed, code: " + paramChar + ", savedCode: " + c);
      super.y(c);
      AppMethodBeat.o(324578);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/input/AppBrandSecureInputWidget$IListener;", "", "onInputDone", "", "luggage-wxa-app-input-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void cRt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.x
 * JD-Core Version:    0.7.0.1
 */