package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.Editable;
import android.text.Editable.Factory;
import android.text.Layout.Alignment;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.text.style.AlignmentSpan;
import android.text.style.AlignmentSpan.Standard;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import androidx.b.a;
import com.tencent.luggage.wxa.b.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.input.autofill.e;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public abstract class ac
  extends EditText
  implements com.tencent.mm.plugin.appbrand.widget.base.c, af
{
  private final Map<af.a, Object> mConfigChangedListeners = new a();
  private volatile int uFB = -1;
  private InputConnection uHp;
  boolean uIb = false;
  private final com.tencent.mm.plugin.appbrand.widget.input.autofill.b uIc;
  private final Map<View.OnFocusChangeListener, Object> uId = new a();
  private final Map<af.c, Object> uIe = new a();
  private final a uIf = new a((byte)0);
  private final PasswordTransformationMethod uIg = new m();
  private final ad uIh = new ad(this);
  private boolean uIi;
  private int uIj = 0;
  private boolean uIk = false;
  private final int[] uIl = new int[2];
  private boolean uIm = false;
  private af.b uIn;
  private char uIo = '\000';
  
  public ac(Context paramContext)
  {
    super(paramContext);
    setBackgroundDrawable(null);
    setIncludeFontPadding(false);
    Et(3);
    setSingleLine(true);
    setTextCursorDrawable(a.d.app_brand_web_edit_text_cursor);
    setTextIsSelectable(true);
    setFocusable(true);
    setFocusableInTouchMode(true);
    if (Build.VERSION.SDK_INT >= 16) {
      setLineSpacing(0.0F, 1.0F);
    }
    setTypeface(Typeface.SANS_SERIF);
    super.addTextChangedListener(this.uIf);
    super.setPadding(0, 0, 0, 0);
    super.setEditableFactory(new Editable.Factory()
    {
      public final Editable newEditable(CharSequence paramAnonymousCharSequence)
      {
        AppMethodBeat.i(136555);
        paramAnonymousCharSequence = super.newEditable(paramAnonymousCharSequence);
        paramAnonymousCharSequence = ac.this.c(paramAnonymousCharSequence);
        AppMethodBeat.o(136555);
        return paramAnonymousCharSequence;
      }
    });
    if (cRk()) {}
    for (this.uIc = new com.tencent.mm.plugin.appbrand.widget.input.autofill.b(this);; this.uIc = null)
    {
      this.uIi = true;
      return;
    }
  }
  
  private void Et(int paramInt)
  {
    setGravity(getGravity() & 0xFF7FFFFC & 0xFF7FFFFA | paramInt);
    paramInt = getGravity();
    Object localObject = getHint();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      Spannable localSpannable = an.U((CharSequence)localObject);
      switch (paramInt & 0x7)
      {
      default: 
        localObject = Layout.Alignment.ALIGN_NORMAL;
        localSpannable.setSpan(new AlignmentSpan.Standard((Layout.Alignment)localObject), 0, getHint().length(), 18);
        super.setHint(localSpannable);
        if (Build.VERSION.SDK_INT >= 17) {
          switch (ac.3.dgZ[localObject.ordinal()])
          {
          default: 
            paramInt = 5;
          }
        }
        break;
      }
    }
    for (;;)
    {
      super.setTextAlignment(paramInt);
      return;
      localObject = Layout.Alignment.ALIGN_OPPOSITE;
      break;
      localObject = Layout.Alignment.ALIGN_CENTER;
      break;
      paramInt = 4;
      continue;
      paramInt = 6;
    }
  }
  
  private void S(CharSequence paramCharSequence)
  {
    Editable localEditable = getEditableText();
    if (localEditable == null)
    {
      setText(paramCharSequence, TextView.BufferType.EDITABLE);
      return;
    }
    clearComposingText();
    if (TextUtils.isEmpty(paramCharSequence))
    {
      localEditable.clear();
      return;
    }
    localEditable.replace(0, localEditable.length(), paramCharSequence);
  }
  
  public final int Eu(int paramInt)
  {
    int i = getPaddingTop() + (int)(paramInt * (getLineHeight() + getLineSpacingExtra()));
    Log.d("MicroMsg.AppBrand.WebEditText", "calculateLinePosition, lineNumber %d, returnHeight %d, layout %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), getLayout() });
    return i;
  }
  
  public void H(com.tencent.mm.plugin.appbrand.page.ad paramad)
  {
    Object localObject;
    if (this.uIc != null)
    {
      localObject = this.uIc.uJY;
      ((com.tencent.mm.plugin.appbrand.widget.input.autofill.c)localObject).uKj = paramad;
      paramad = k.D(paramad);
      localObject = ((com.tencent.mm.plugin.appbrand.widget.input.autofill.c)localObject).uKi;
      if (localObject != null) {
        break label35;
      }
    }
    label35:
    while (paramad.uGe.containsKey(localObject)) {
      return;
    }
    paramad.uGe.put(localObject, paramad);
  }
  
  public void I(com.tencent.mm.plugin.appbrand.page.ad paramad)
  {
    if (this.uIc != null)
    {
      com.tencent.mm.plugin.appbrand.widget.input.autofill.c localc = this.uIc.uJY;
      k.D(paramad).a(localc.uKi);
    }
  }
  
  public void R(CharSequence paramCharSequence)
  {
    if (f.cQP())
    {
      if (getEditableText() != null) {
        break label35;
      }
      setText(paramCharSequence, TextView.BufferType.EDITABLE);
    }
    for (;;)
    {
      setSelection(getEditableText().length());
      return;
      label35:
      getEditableText().append(paramCharSequence);
    }
  }
  
  public final void T(CharSequence paramCharSequence)
  {
    cRI();
    S(paramCharSequence);
    cRJ();
  }
  
  public final void a(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    if (paramOnFocusChangeListener != null) {
      this.uId.put(paramOnFocusChangeListener, this);
    }
  }
  
  public final void a(af.a parama)
  {
    this.mConfigChangedListeners.put(parama, this);
  }
  
  public final void a(af.c paramc)
  {
    this.uIe.put(paramc, this);
  }
  
  protected final boolean a(int paramInt, Rect paramRect)
  {
    return super.requestFocus(paramInt, paramRect);
  }
  
  public void addTextChangedListener(TextWatcher paramTextWatcher)
  {
    a locala = this.uIf;
    if (paramTextWatcher != null) {
      locala.uIs.put(paramTextWatcher, locala);
    }
  }
  
  public void ay(float paramFloat1, float paramFloat2)
  {
    throw new IllegalStateException("Should implement performClick(float, float) in this class!");
  }
  
  public final void b(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    if (paramOnFocusChangeListener != null) {
      this.uId.remove(paramOnFocusChangeListener);
    }
  }
  
  Editable c(Editable paramEditable)
  {
    return this.uIh.c(paramEditable);
  }
  
  public boolean cPf()
  {
    return false;
  }
  
  public final int cRD()
  {
    return Eu(getLineCount()) + getPaddingBottom();
  }
  
  public final void cRE()
  {
    Et(3);
  }
  
  public final void cRF()
  {
    Et(5);
  }
  
  public final void cRG()
  {
    Et(1);
  }
  
  final void cRH()
  {
    cRI();
    setText(getEditableText());
    cRJ();
  }
  
  final void cRI()
  {
    this.uIj += 1;
  }
  
  final void cRJ()
  {
    this.uIj = Math.max(0, this.uIj - 1);
  }
  
  protected final void cRK()
  {
    super.clearFocus();
  }
  
  public boolean cRk()
  {
    return true;
  }
  
  protected abstract void cRl();
  
  public boolean cRn()
  {
    return this.uIk;
  }
  
  public void cRu()
  {
    if (this.uHp != null)
    {
      if (!Util.isNullOrNil(getEditableText())) {
        this.uHp.deleteSurroundingText(getEditableText().length(), getEditableText().length() - 1);
      }
      return;
    }
    dispatchKeyEvent(new KeyEvent(0, 67));
    dispatchKeyEvent(new KeyEvent(1, 67));
  }
  
  public void clearFocus()
  {
    if ((getParent() instanceof ViewGroup))
    {
      ((ViewGroup)getParent()).setFocusableInTouchMode(true);
      ((ViewGroup)getParent()).setDescendantFocusability(131072);
    }
    super.clearFocus();
  }
  
  public final void destroy()
  {
    this.mConfigChangedListeners.clear();
    this.uIe.clear();
    this.uId.clear();
    this.uIf.uIs.clear();
    if (this.uIc != null)
    {
      com.tencent.mm.plugin.appbrand.widget.input.autofill.b localb = this.uIc;
      com.tencent.mm.plugin.appbrand.widget.input.autofill.c localc = localb.uJY;
      k.D(localc.uKj).a(localc.uKi);
      localb.uKb = null;
      localb.uJW.dismiss();
    }
    super.setOnFocusChangeListener(null);
  }
  
  public com.tencent.mm.plugin.appbrand.widget.input.autofill.b getAutoFillController()
  {
    return this.uIc;
  }
  
  public int getAutofillType()
  {
    return 0;
  }
  
  public int getInputId()
  {
    return this.uFB;
  }
  
  public char getLastKeyPressed()
  {
    return this.uIo;
  }
  
  public final View getView()
  {
    return this;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (!this.mConfigChangedListeners.isEmpty())
    {
      paramConfiguration = (af.a[])this.mConfigChangedListeners.keySet().toArray(new af.a[this.mConfigChangedListeners.size()]);
      int j = paramConfiguration.length;
      int i = 0;
      while (i < j)
      {
        paramConfiguration[i].dG();
        i += 1;
      }
    }
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    final InputConnection localInputConnection = super.onCreateInputConnection(paramEditorInfo);
    if (localInputConnection == null) {
      return null;
    }
    this.uHp = new InputConnectionWrapper(localInputConnection, localInputConnection)
    {
      public final boolean commitText(CharSequence paramAnonymousCharSequence, int paramAnonymousInt)
      {
        AppMethodBeat.i(136557);
        if (!TextUtils.isEmpty(paramAnonymousCharSequence)) {
          ac.this.y(paramAnonymousCharSequence.charAt(paramAnonymousCharSequence.length() - 1));
        }
        boolean bool = super.commitText(paramAnonymousCharSequence, paramAnonymousInt);
        AppMethodBeat.o(136557);
        return bool;
      }
      
      public final boolean deleteSurroundingText(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(136558);
        ac.this.y('\b');
        boolean bool = super.deleteSurroundingText(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(136558);
        return bool;
      }
      
      public final boolean finishComposingText()
      {
        AppMethodBeat.i(136559);
        if ((localInputConnection instanceof BaseInputConnection)) {}
        for (Object localObject = ((BaseInputConnection)localInputConnection).getEditable();; localObject = ac.this.getEditableText())
        {
          boolean bool1 = an.V((CharSequence)localObject);
          boolean bool2 = super.finishComposingText();
          if ((bool2) && (ac.b(ac.this) == this) && (bool1))
          {
            localObject = ac.c(ac.this);
            ((ad)localObject).qse.removeCallbacks(((ad)localObject).uIA);
            if (((ad)localObject).uIy) {
              ((ad)localObject).uIA.run();
            }
          }
          AppMethodBeat.o(136559);
          return bool2;
        }
      }
      
      public final boolean setComposingText(CharSequence paramAnonymousCharSequence, int paramAnonymousInt)
      {
        AppMethodBeat.i(136556);
        if (!TextUtils.isEmpty(paramAnonymousCharSequence)) {
          ac.this.y(paramAnonymousCharSequence.charAt(paramAnonymousCharSequence.length() - 1));
        }
        boolean bool = super.setComposingText(paramAnonymousCharSequence, paramAnonymousInt);
        AppMethodBeat.o(136556);
        return bool;
      }
    };
    paramEditorInfo.imeOptions |= 0x10000000;
    if (getImeOptions() != 0) {
      paramEditorInfo.imeOptions &= 0xBFFFFFFF;
    }
    return this.uHp;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    if (!paramBoolean) {
      clearComposingText();
    }
    if (paramBoolean) {
      cRl();
    }
    if (!this.uId.isEmpty())
    {
      paramRect = (View.OnFocusChangeListener[])this.uId.keySet().toArray(new View.OnFocusChangeListener[this.uId.size()]);
      int i = paramRect.length;
      paramInt = 0;
      while (paramInt < i)
      {
        paramRect[paramInt].onFocusChange(this, paramBoolean);
        paramInt += 1;
      }
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 67) {
      y('\b');
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    if ((bool) && (paramInt == 66)) {
      y('\n');
    }
    this.uIm = bool;
    return bool;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((!this.uIm) && (this.uIn != null) && (this.uIn.Ek(paramInt))) {
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Log.v("MicroMsg.AppBrand.WebEditText", "[scrollUp] input onLayout");
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    Log.v("MicroMsg.AppBrand.WebEditText", "[scrollUp] input onMeasure");
    super.onMeasure(paramInt1, paramInt2);
    if (!this.uIe.isEmpty())
    {
      Object[] arrayOfObject = this.uIe.keySet().toArray();
      paramInt2 = arrayOfObject.length;
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        af.c localc = (af.c)arrayOfObject[paramInt1];
        getMeasuredWidth();
        getMeasuredHeight();
        localc.cRm();
        paramInt1 += 1;
      }
    }
  }
  
  public void removeTextChangedListener(TextWatcher paramTextWatcher)
  {
    a locala = this.uIf;
    if (paramTextWatcher != null) {
      locala.uIs.remove(paramTextWatcher);
    }
  }
  
  public boolean requestFocus(int paramInt, Rect paramRect)
  {
    if ((130 == paramInt) && (paramRect == null) && ((getParent() instanceof ViewGroup)))
    {
      ((ViewGroup)getParent()).setDescendantFocusability(262144);
      ((ViewGroup)getParent()).setFocusableInTouchMode(false);
    }
    try
    {
      bool = super.requestFocus(paramInt, paramRect);
      return bool;
    }
    catch (RuntimeException localRuntimeException)
    {
      boolean bool;
      Log.e("MicroMsg.AppBrand.WebEditText", "requestFocus e=%s", new Object[] { localRuntimeException });
      try
      {
        bool = super.requestFocus(paramInt, paramRect);
        return bool;
      }
      catch (RuntimeException paramRect)
      {
        Log.e("MicroMsg.AppBrand.WebEditText", "requestFocus try again e=%s", new Object[] { paramRect });
      }
    }
    return false;
  }
  
  public void setFixed(boolean paramBoolean)
  {
    this.uIk = paramBoolean;
  }
  
  public void setInputId(int paramInt)
  {
    this.uFB = paramInt;
  }
  
  public void setInputType(int paramInt)
  {
    if (getInputType() == paramInt) {
      return;
    }
    super.setInputType(paramInt);
  }
  
  public void setMaxHeight(int paramInt)
  {
    if (getMaxHeight() == paramInt) {
      return;
    }
    super.setMaxHeight(paramInt);
  }
  
  public void setMinHeight(int paramInt)
  {
    if (getMinHeight() == paramInt) {
      return;
    }
    super.setMinHeight(paramInt);
  }
  
  public void setOnComposingDismissedListener(com.tencent.mm.plugin.appbrand.widget.input.c.b paramb)
  {
    this.uIh.uIz = paramb;
  }
  
  @Deprecated
  public void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    if (this.uId == null)
    {
      super.setOnFocusChangeListener(paramOnFocusChangeListener);
      return;
    }
    a(paramOnFocusChangeListener);
  }
  
  public void setOnKeyUpPostImeListener(af.b paramb)
  {
    this.uIn = paramb;
  }
  
  public void setPasswordMode(boolean paramBoolean)
  {
    cRI();
    this.uIb = paramBoolean;
    if (paramBoolean) {}
    for (PasswordTransformationMethod localPasswordTransformationMethod = this.uIg;; localPasswordTransformationMethod = null)
    {
      setTransformationMethod(localPasswordTransformationMethod);
      cRJ();
      return;
    }
  }
  
  public void setSelection(int paramInt)
  {
    if (getEditableText() == null) {
      return;
    }
    super.setSelection(Math.min(paramInt, getEditableText().length()));
  }
  
  public void setSelection(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt1 < 0) {
      i = 0;
    }
    if (i >= getEditableText().length()) {}
    for (paramInt1 = getEditableText().length();; paramInt1 = i)
    {
      i = paramInt2;
      if (paramInt2 < paramInt1) {
        i = paramInt1;
      }
      paramInt2 = i;
      if (i >= getEditableText().length()) {
        paramInt2 = getEditableText().length();
      }
      super.setSelection(paramInt1, paramInt2);
      return;
    }
  }
  
  public void setSingleLine(boolean paramBoolean) {}
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    super.setText(paramCharSequence, paramBufferType);
  }
  
  public final void setTextCursorDrawable(int paramInt)
  {
    try
    {
      new com.tencent.mm.compatible.loader.b(this, "mCursorDrawableRes", TextView.class.getName()).set(Integer.valueOf(paramInt));
      return;
    }
    catch (Exception localException)
    {
      Log.d("MicroMsg.AppBrand.WebEditText", "setTextCursorDrawable, exp = %s", new Object[] { Util.stackTraceToString(localException) });
    }
  }
  
  public final void setTextSize(float paramFloat)
  {
    setTextSize(0, paramFloat);
  }
  
  public void setTextSize(int paramInt, float paramFloat)
  {
    super.setTextSize(paramInt, paramFloat);
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    super.setTypeface(paramTypeface);
  }
  
  public void setTypeface(Typeface paramTypeface, int paramInt)
  {
    super.setTypeface(paramTypeface, paramInt);
  }
  
  public String toString()
  {
    return String.format(Locale.US, "[%s|%s]", new Object[] { getClass().getSimpleName(), Integer.valueOf(getInputId()) });
  }
  
  public void y(char paramChar)
  {
    this.uIo = paramChar;
  }
  
  final class a
    implements TextWatcher
  {
    final Map<TextWatcher, Object> uIs;
    
    private a()
    {
      AppMethodBeat.i(136562);
      this.uIs = new a();
      AppMethodBeat.o(136562);
    }
    
    private static <T> void a(CharSequence paramCharSequence, int paramInt1, int paramInt2, Class<T> paramClass)
    {
      AppMethodBeat.i(136563);
      try
      {
        if ((paramCharSequence instanceof SpannableStringBuilder))
        {
          paramCharSequence = (SpannableStringBuilder)paramCharSequence;
          paramClass = paramCharSequence.getSpans(paramInt1, paramInt1 + paramInt2, paramClass);
          if ((paramClass != null) && (paramClass.length > 0))
          {
            paramInt2 = paramClass.length;
            paramInt1 = 0;
            while (paramInt1 < paramInt2)
            {
              paramCharSequence.removeSpan(paramClass[paramInt1]);
              paramInt1 += 1;
            }
          }
        }
        return;
      }
      finally
      {
        AppMethodBeat.o(136563);
      }
    }
    
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(136566);
      Object localObject;
      final int i;
      final int j;
      if ((f.cQP()) && (f.cQQ()))
      {
        localObject = new PBool();
        PInt localPInt = new PInt();
        final String str = ac.a(paramEditable, (PBool)localObject, localPInt);
        i = localPInt.value;
        if ((((PBool)localObject).value) && (!Util.isNullOrNil(str)))
        {
          j = Selection.getSelectionEnd(paramEditable);
          final boolean bool = ac.d(ac.this);
          ac.this.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(136561);
              if (bool) {
                ac.this.T(str);
              }
              for (;;)
              {
                try
                {
                  ac.this.setSelection(Math.min(j + i, str.length()));
                  AppMethodBeat.o(136561);
                  return;
                }
                catch (Exception localException)
                {
                  Log.e("MicroMsg.AppBrand.WebEditText", "replace softBank to unicode, setSelection ", new Object[] { localException });
                  AppMethodBeat.o(136561);
                }
                ac.this.setText(str);
              }
            }
          });
          AppMethodBeat.o(136566);
          return;
        }
      }
      if (!ac.d(ac.this))
      {
        ac.e(ac.this);
        if (!this.uIs.isEmpty())
        {
          localObject = (TextWatcher[])this.uIs.keySet().toArray(new TextWatcher[this.uIs.size()]);
          j = localObject.length;
          i = 0;
          while (i < j)
          {
            localObject[i].afterTextChanged(paramEditable);
            i += 1;
          }
        }
      }
      AppMethodBeat.o(136566);
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(136564);
      if ((!ac.d(ac.this)) && (!this.uIs.isEmpty()))
      {
        TextWatcher[] arrayOfTextWatcher = (TextWatcher[])this.uIs.keySet().toArray(new TextWatcher[this.uIs.size()]);
        int j = arrayOfTextWatcher.length;
        int i = 0;
        while (i < j)
        {
          arrayOfTextWatcher[i].beforeTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
          i += 1;
        }
      }
      AppMethodBeat.o(136564);
    }
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(136565);
      if (!ac.d(ac.this))
      {
        a(paramCharSequence, paramInt1, paramInt3, StyleSpan.class);
        a(paramCharSequence, paramInt1, paramInt3, RelativeSizeSpan.class);
        a(paramCharSequence, paramInt1, paramInt3, AlignmentSpan.class);
        if (!this.uIs.isEmpty())
        {
          TextWatcher[] arrayOfTextWatcher = (TextWatcher[])this.uIs.keySet().toArray(new TextWatcher[this.uIs.size()]);
          int j = arrayOfTextWatcher.length;
          int i = 0;
          while (i < j)
          {
            arrayOfTextWatcher[i].onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
            i += 1;
          }
        }
      }
      AppMethodBeat.o(136565);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.ac
 * JD-Core Version:    0.7.0.1
 */