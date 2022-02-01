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
import androidx.core.g.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.sdk.platformtools.Log;
import com.tenpay.miniapp.MiniAppSecureEditText;
import com.tenpay.miniapp.MiniAppSecureEditText.OnPasswdInputListener;
import java.nio.ByteBuffer;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.d;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/widget/input/AppBrandSecureInputWidget;", "Lcom/tencent/mm/plugin/appbrand/widget/input/AppBrandInputWidgetSingleLineBase;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "cachedCertPem", "", "cachedSafePasswordCertPath", "listener", "Lcom/tencent/mm/plugin/appbrand/widget/input/AppBrandSecureInputWidget$IListener;", "getListener", "()Lcom/tencent/mm/plugin/appbrand/widget/input/AppBrandSecureInputWidget$IListener;", "setListener", "(Lcom/tencent/mm/plugin/appbrand/widget/input/AppBrandSecureInputWidget$IListener;)V", "myTag", "getMyTag$luggage_wxa_app_input_ext_release", "()Ljava/lang/String;", "secureInputWidgetLogic", "Lcom/tenpay/miniapp/MiniAppSecureEditText;", "getSecureInputWidgetLogic$luggage_wxa_app_input_ext_release", "()Lcom/tenpay/miniapp/MiniAppSecureEditText;", "appendText", "", "text", "", "deleteLast", "dispatchKeyEvent", "", "event", "Landroid/view/KeyEvent;", "ensureInputConnection", "getInputPanel", "Lcom/tencent/mm/plugin/appbrand/widget/input/AppBrandSecureKeyboardPanel;", "getRealText", "getRealText$luggage_wxa_app_input_ext_release", "onAttachedToPage", "page", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "onCreateContextMenu", "menu", "Landroid/view/ContextMenu;", "onCreateInputConnection", "Landroid/view/inputmethod/InputConnection;", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "onDetachedFromPage", "onSelectionChanged", "selStart", "", "selEnd", "onSelectionChangedDisable", "onSelectionChangedSync", "onTextContextMenuItem", "id", "readCertPem", "env", "safePasswordCertPath", "readCertPem$luggage_wxa_app_input_ext_release", "realSetSelection", "index", "start", "stop", "saveLastKeyPressed", "code", "", "setInputId", "setLength", "length", "setLength$luggage_wxa_app_input_ext_release", "setLogicSelection", "setText", "type", "Landroid/widget/TextView$BufferType;", "supportsAutoFill", "isKeyCodeLetterOrDigit", "IListener", "luggage-wxa-app-input-ext_release"})
public final class x
  extends r
{
  private a rwp;
  private final MiniAppSecureEditText rwq;
  private String rwr;
  private String rws;
  
  public x(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(213963);
    this.rwq = new MiniAppSecureEditText(paramContext);
    setImeOptions(1);
    new av((TextView)this);
    this.rwq.setText((CharSequence)getText());
    fi(getSelectionStart(), getSelectionEnd());
    this.rwq.setOnPasswdInputListener((MiniAppSecureEditText.OnPasswdInputListener)new MiniAppSecureEditText.OnPasswdInputListener()
    {
      public final void onDone()
      {
        AppMethodBeat.i(215000);
        Log.d(this.rwt.getMyTag$luggage_wxa_app_input_ext_release(), "onDone#secureInputWidgetLogic");
        x.a locala = this.rwt.getListener();
        if (locala != null)
        {
          locala.coR();
          AppMethodBeat.o(215000);
          return;
        }
        AppMethodBeat.o(215000);
      }
    });
    this.rwq.addTextChangedListener((TextWatcher)new x.2(this));
    AppMethodBeat.o(213963);
  }
  
  private final void fi(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(213962);
    if ((paramInt1 >= 0) && (paramInt2 >= 0) && (paramInt1 <= paramInt2)) {
      try
      {
        this.rwq.setSelection(paramInt1, paramInt2);
        AppMethodBeat.o(213962);
        return;
      }
      catch (Exception localException) {}
    }
    AppMethodBeat.o(213962);
  }
  
  public final void F(char paramChar)
  {
    AppMethodBeat.i(213943);
    if (Character.isLetterOrDigit(paramChar)) {}
    for (char c = '*';; c = paramChar)
    {
      Log.d(getMyTag$luggage_wxa_app_input_ext_release(), "saveLastKeyPressed, code: " + paramChar + ", savedCode: " + c);
      super.F(c);
      AppMethodBeat.o(213943);
      return;
    }
  }
  
  public final void G(ad paramad)
  {
    AppMethodBeat.i(213956);
    Log.d(getMyTag$luggage_wxa_app_input_ext_release(), "onAttachedToPage");
    AppMethodBeat.o(213956);
  }
  
  public final void H(ad paramad)
  {
    AppMethodBeat.i(213957);
    Log.d(getMyTag$luggage_wxa_app_input_ext_release(), "onDetachedFromPage");
    AppMethodBeat.o(213957);
  }
  
  public final void N(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(213944);
    Log.e(getMyTag$luggage_wxa_app_input_ext_release(), "appendText, text: " + paramCharSequence);
    AppMethodBeat.o(213944);
  }
  
  public final String a(ad paramad, String paramString)
  {
    AppMethodBeat.i(213961);
    p.k(paramad, "env");
    p.k(paramString, "safePasswordCertPath");
    if (p.h(paramString, this.rwr))
    {
      paramad = this.rws;
      if (paramad == null)
      {
        Log.e(((x)this).getMyTag$luggage_wxa_app_input_ext_release(), "readCertPem, cachedCertPem is null");
        paramad = (Throwable)new IllegalStateException("certPath is illegal");
        AppMethodBeat.o(213961);
        throw paramad;
      }
      AppMethodBeat.o(213961);
      return paramad;
    }
    Object localObject = new i();
    paramad = paramad.getFileSystem();
    if (paramad != null) {}
    for (paramad = paramad.b(paramString, (i)localObject); paramad == null; paramad = null)
    {
      Log.e(getMyTag$luggage_wxa_app_input_ext_release(), "readCertPem, opResult is null");
      paramad = (Throwable)new IllegalStateException("env error");
      AppMethodBeat.o(213961);
      throw paramad;
    }
    if (m.nMR != paramad)
    {
      Log.e(getMyTag$luggage_wxa_app_input_ext_release(), "getEncryptedData, opResult: ".concat(String.valueOf(paramad)));
      paramad = (Throwable)new IllegalStateException("certPath is illegal");
      AppMethodBeat.o(213961);
      throw paramad;
    }
    paramad = ((i)localObject).value;
    p.j(paramad, "byteBufRef.value");
    paramad = (ByteBuffer)paramad;
    p.k(paramad, "$this$toArray");
    localObject = new byte[paramad.remaining()];
    paramad.get((byte[])localObject);
    paramad = new String((byte[])localObject, d.UTF_8);
    this.rws = paramad;
    this.rwr = paramString;
    AppMethodBeat.o(213961);
    return paramad;
  }
  
  public final boolean coI()
  {
    AppMethodBeat.i(213951);
    Log.d(getMyTag$luggage_wxa_app_input_ext_release(), "supportsAutoFill");
    AppMethodBeat.o(213951);
    return false;
  }
  
  protected final void coJ()
  {
    AppMethodBeat.i(213947);
    if (w.al((View)this))
    {
      z localz = getInputPanel();
      if (localz != null)
      {
        localz.setInputWidget((EditText)this);
        AppMethodBeat.o(213947);
        return;
      }
    }
    AppMethodBeat.o(213947);
  }
  
  public final void coS()
  {
    AppMethodBeat.i(213942);
    Log.d(getMyTag$luggage_wxa_app_input_ext_release(), "deleteLast");
    dispatchKeyEvent(new KeyEvent(0, 67));
    dispatchKeyEvent(new KeyEvent(1, 67));
    AppMethodBeat.o(213942);
  }
  
  public final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(213936);
    p.k(paramKeyEvent, "event");
    int i = paramKeyEvent.getKeyCode();
    if ((7 > i) || (16 < i))
    {
      i = paramKeyEvent.getKeyCode();
      if (29 > i)
      {
        i = 0;
        label43:
        if (i == 0) {
          break label169;
        }
      }
    }
    label169:
    for (KeyEvent localKeyEvent = new KeyEvent(paramKeyEvent.getAction(), 155);; localKeyEvent = paramKeyEvent)
    {
      Log.d(getMyTag$luggage_wxa_app_input_ext_release(), "dispatchKeyEvent, event: " + paramKeyEvent + ", dispatchedKeyEvent: " + localKeyEvent);
      boolean bool1 = super.dispatchKeyEvent(localKeyEvent);
      boolean bool2 = this.rwq.dispatchKeyEvent(paramKeyEvent);
      Log.d(getMyTag$luggage_wxa_app_input_ext_release(), "dispatchKeyEvent, handled: " + bool1 + ", handled2: " + bool2);
      AppMethodBeat.o(213936);
      return bool1;
      if (54 < i) {
        break;
      }
      i = 1;
      break label43;
    }
  }
  
  public final z getInputPanel()
  {
    AppMethodBeat.i(213949);
    Object localObject = z.rwB;
    localObject = z.a.dv((View)this);
    Log.d(getMyTag$luggage_wxa_app_input_ext_release(), "getInputPanel, keyboardPanel: ".concat(String.valueOf(localObject)));
    AppMethodBeat.o(213949);
    return localObject;
  }
  
  public final a getListener()
  {
    return this.rwp;
  }
  
  public final String getMyTag$luggage_wxa_app_input_ext_release()
  {
    AppMethodBeat.i(213933);
    String str = "MicroMsg.AppBrand.AppBrandSecureInputWidget#" + getInputId();
    AppMethodBeat.o(213933);
    return str;
  }
  
  public final String getRealText$luggage_wxa_app_input_ext_release()
  {
    AppMethodBeat.i(213959);
    Object localObject = this.rwq.getText();
    if (localObject != null)
    {
      localObject = localObject.toString();
      AppMethodBeat.o(213959);
      return localObject;
    }
    AppMethodBeat.o(213959);
    return null;
  }
  
  public final MiniAppSecureEditText getSecureInputWidgetLogic$luggage_wxa_app_input_ext_release()
  {
    return this.rwq;
  }
  
  protected final void onCreateContextMenu(ContextMenu paramContextMenu)
  {
    AppMethodBeat.i(213941);
    if (paramContextMenu != null)
    {
      paramContextMenu.clearHeader();
      AppMethodBeat.o(213941);
      return;
    }
    AppMethodBeat.o(213941);
  }
  
  public final InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    AppMethodBeat.i(213934);
    Log.d(getMyTag$luggage_wxa_app_input_ext_release(), "onCreateInputConnection");
    AppMethodBeat.o(213934);
    return null;
  }
  
  protected final void onSelectionChanged(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(213938);
    Log.i(getMyTag$luggage_wxa_app_input_ext_release(), "onSelectionChanged, selStart: " + paramInt1 + ", selEnd: " + paramInt2);
    Editable localEditable = getText();
    if (localEditable != null) {}
    for (int i = localEditable.length();; i = 0)
    {
      Log.i(getMyTag$luggage_wxa_app_input_ext_release(), "onSelectionChangedDisable, sel: ".concat(String.valueOf(i)));
      if ((paramInt1 == i) && (paramInt2 == i)) {
        break;
      }
      setSelection(i, i);
      AppMethodBeat.o(213938);
      return;
    }
    super.onSelectionChanged(paramInt1, paramInt2);
    post((Runnable)new x.b(this, paramInt1, paramInt2));
    AppMethodBeat.o(213938);
  }
  
  public final boolean onTextContextMenuItem(int paramInt)
  {
    return true;
  }
  
  public final void setInputId(int paramInt)
  {
    AppMethodBeat.i(213954);
    Log.d(getMyTag$luggage_wxa_app_input_ext_release(), "setInputId, id: ".concat(String.valueOf(paramInt)));
    super.setInputId(paramInt);
    AppMethodBeat.o(213954);
  }
  
  public final void setLength$luggage_wxa_app_input_ext_release(int paramInt)
  {
    AppMethodBeat.i(213958);
    Log.d(getMyTag$luggage_wxa_app_input_ext_release(), "setLength, length: ".concat(String.valueOf(paramInt)));
    this.rwq.setInputLength(paramInt, paramInt);
    AppMethodBeat.o(213958);
  }
  
  public final void setListener(a parama)
  {
    this.rwp = parama;
  }
  
  public final void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    AppMethodBeat.i(213937);
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
      p.j(localObject, "StringBuilder().apply(builderAction).toString()");
    }
    for (;;)
    {
      Log.i("MicroMsg.AppBrand.AppBrandSecureInputWidget", "setText, text: " + paramCharSequence + ", shownText: " + (String)localObject + ", type: " + paramBufferType);
      super.setText((CharSequence)localObject, paramBufferType);
      try
      {
        this.rwq.setText(paramCharSequence, paramBufferType);
        AppMethodBeat.o(213937);
        return;
      }
      catch (NullPointerException paramCharSequence)
      {
        AppMethodBeat.o(213937);
      }
      localObject = (String)paramCharSequence;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/widget/input/AppBrandSecureInputWidget$IListener;", "", "onInputDone", "", "luggage-wxa-app-input-ext_release"})
  public static abstract interface a
  {
    public abstract void coR();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.x
 * JD-Core Version:    0.7.0.1
 */