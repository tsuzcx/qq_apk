package com.tencent.mm.plugin.appbrand.widget.input;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.support.v4.e.a;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.widget.input.autofill.e;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

@SuppressLint({"AppCompatCustomView"})
public abstract class y
  extends EditText
  implements com.tencent.mm.plugin.appbrand.widget.base.c, ab
{
  private volatile int osn = -1;
  InputConnection otU;
  private final a ouA = new a((byte)0);
  private final PasswordTransformationMethod ouB = new m();
  private final z ouC = new z(this);
  private boolean ouD;
  private int ouE = 0;
  private boolean ouF = false;
  private final int[] ouG = new int[2];
  private boolean ouH = false;
  private ab.b ouI;
  char ouJ = '\000';
  boolean ouv = false;
  private final com.tencent.mm.plugin.appbrand.widget.input.autofill.b ouw;
  private final Map<ab.a, Object> oux = new a();
  private final Map<View.OnFocusChangeListener, Object> ouy = new a();
  private final Map<ab.c, Object> ouz = new a();
  
  public y(Context paramContext)
  {
    super(paramContext);
    setBackgroundDrawable(null);
    setIncludeFontPadding(false);
    Aj(3);
    setSingleLine(true);
    setTextCursorDrawable(2131231075);
    setTextIsSelectable(true);
    setFocusable(true);
    setFocusableInTouchMode(true);
    if (Build.VERSION.SDK_INT >= 16) {
      setLineSpacing(0.0F, 1.0F);
    }
    setTypeface(Typeface.SANS_SERIF);
    super.addTextChangedListener(this.ouA);
    super.setPadding(0, 0, 0, 0);
    super.setEditableFactory(new Editable.Factory()
    {
      public final Editable newEditable(CharSequence paramAnonymousCharSequence)
      {
        AppMethodBeat.i(136555);
        paramAnonymousCharSequence = super.newEditable(paramAnonymousCharSequence);
        paramAnonymousCharSequence = y.this.c(paramAnonymousCharSequence);
        AppMethodBeat.o(136555);
        return paramAnonymousCharSequence;
      }
    });
    if (cby()) {}
    for (this.ouw = new com.tencent.mm.plugin.appbrand.widget.input.autofill.b(this);; this.ouw = null)
    {
      this.ouD = true;
      return;
    }
  }
  
  private void Aj(int paramInt)
  {
    setGravity(getGravity() & 0xFF7FFFFC & 0xFF7FFFFA | paramInt);
    paramInt = getGravity();
    Object localObject = getHint();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      Spannable localSpannable = aj.H((CharSequence)localObject);
      switch (paramInt & 0x7)
      {
      default: 
        localObject = Layout.Alignment.ALIGN_NORMAL;
        localSpannable.setSpan(new AlignmentSpan.Standard((Layout.Alignment)localObject), 0, getHint().length(), 18);
        super.setHint(localSpannable);
        if (Build.VERSION.SDK_INT >= 17) {
          switch (3.bDD[localObject.ordinal()])
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
  
  private void F(CharSequence paramCharSequence)
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
  
  public final int Ak(int paramInt)
  {
    int i = getPaddingTop() + (int)(paramInt * (getLineHeight() + getLineSpacingExtra()));
    Log.d("MicroMsg.AppBrand.WebEditText", "calculateLinePosition, lineNumber %d, returnHeight %d, layout %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), getLayout() });
    return i;
  }
  
  public final void G(ac paramac)
  {
    Object localObject;
    if (this.ouw != null)
    {
      localObject = this.ouw.owb;
      ((com.tencent.mm.plugin.appbrand.widget.input.autofill.c)localObject).owm = paramac;
      paramac = k.C(paramac);
      localObject = ((com.tencent.mm.plugin.appbrand.widget.input.autofill.c)localObject).owl;
      if (localObject != null) {
        break label35;
      }
    }
    label35:
    while (paramac.osQ.containsKey(localObject)) {
      return;
    }
    paramac.osQ.put(localObject, paramac);
  }
  
  public final void G(CharSequence paramCharSequence)
  {
    cbU();
    F(paramCharSequence);
    cbV();
  }
  
  public final void H(ac paramac)
  {
    if (this.ouw != null)
    {
      com.tencent.mm.plugin.appbrand.widget.input.autofill.c localc = this.ouw.owb;
      k.C(paramac).a(localc.owl);
    }
  }
  
  public void Q(float paramFloat1, float paramFloat2)
  {
    throw new IllegalStateException("Should implement performClick(float, float) in this class!");
  }
  
  public final void a(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    if (paramOnFocusChangeListener != null) {
      this.ouy.put(paramOnFocusChangeListener, this);
    }
  }
  
  public final void a(ab.a parama)
  {
    this.oux.put(parama, this);
  }
  
  public final void a(ab.c paramc)
  {
    this.ouz.put(paramc, this);
  }
  
  protected final boolean a(int paramInt, Rect paramRect)
  {
    return super.requestFocus(paramInt, paramRect);
  }
  
  public void addTextChangedListener(TextWatcher paramTextWatcher)
  {
    a locala = this.ouA;
    if (paramTextWatcher != null) {
      locala.ouM.put(paramTextWatcher, locala);
    }
  }
  
  public final void b(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    if (paramOnFocusChangeListener != null) {
      this.ouy.remove(paramOnFocusChangeListener);
    }
  }
  
  Editable c(Editable paramEditable)
  {
    return this.ouC.c(paramEditable);
  }
  
  public boolean caj()
  {
    return false;
  }
  
  public boolean cbB()
  {
    return this.ouF;
  }
  
  public final int cbP()
  {
    return Ak(getLineCount()) + getPaddingBottom();
  }
  
  public final void cbQ()
  {
    Aj(3);
  }
  
  public final void cbR()
  {
    Aj(5);
  }
  
  public final void cbS()
  {
    Aj(1);
  }
  
  final void cbT()
  {
    cbU();
    setText(getEditableText());
    cbV();
  }
  
  final void cbU()
  {
    this.ouE += 1;
  }
  
  final void cbV()
  {
    this.ouE = Math.max(0, this.ouE - 1);
  }
  
  protected final void cbW()
  {
    super.clearFocus();
  }
  
  public boolean cby()
  {
    return true;
  }
  
  protected abstract void cbz();
  
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
    this.oux.clear();
    this.ouz.clear();
    this.ouy.clear();
    this.ouA.ouM.clear();
    if (this.ouw != null)
    {
      com.tencent.mm.plugin.appbrand.widget.input.autofill.b localb = this.ouw;
      com.tencent.mm.plugin.appbrand.widget.input.autofill.c localc = localb.owb;
      k.C(localc.owm).a(localc.owl);
      localb.owe = null;
      localb.ovZ.dismiss();
    }
    super.setOnFocusChangeListener(null);
  }
  
  public com.tencent.mm.plugin.appbrand.widget.input.autofill.b getAutoFillController()
  {
    return this.ouw;
  }
  
  public int getAutofillType()
  {
    return 0;
  }
  
  public int getInputId()
  {
    return this.osn;
  }
  
  public char getLastKeyPressed()
  {
    return this.ouJ;
  }
  
  public final View getView()
  {
    return this;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (!this.oux.isEmpty())
    {
      paramConfiguration = (ab.a[])this.oux.keySet().toArray(new ab.a[this.oux.size()]);
      int j = paramConfiguration.length;
      int i = 0;
      while (i < j)
      {
        paramConfiguration[i].iE();
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
    this.otU = new InputConnectionWrapper(localInputConnection, localInputConnection)
    {
      public final boolean commitText(CharSequence paramAnonymousCharSequence, int paramAnonymousInt)
      {
        AppMethodBeat.i(136557);
        if (!TextUtils.isEmpty(paramAnonymousCharSequence)) {
          y.this.ouJ = paramAnonymousCharSequence.charAt(paramAnonymousCharSequence.length() - 1);
        }
        boolean bool = super.commitText(paramAnonymousCharSequence, paramAnonymousInt);
        AppMethodBeat.o(136557);
        return bool;
      }
      
      public final boolean deleteSurroundingText(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(136558);
        y.this.ouJ = '\b';
        boolean bool = super.deleteSurroundingText(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(136558);
        return bool;
      }
      
      public final boolean finishComposingText()
      {
        AppMethodBeat.i(136559);
        if ((localInputConnection instanceof BaseInputConnection)) {}
        for (Object localObject = ((BaseInputConnection)localInputConnection).getEditable();; localObject = y.this.getEditableText())
        {
          boolean bool1 = aj.I((CharSequence)localObject);
          boolean bool2 = super.finishComposingText();
          if ((bool2) && (y.b(y.this) == this) && (bool1))
          {
            localObject = y.c(y.this);
            ((z)localObject).kAn.removeCallbacks(((z)localObject).ouU);
            if (((z)localObject).ouS) {
              ((z)localObject).ouU.run();
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
          y.this.ouJ = paramAnonymousCharSequence.charAt(paramAnonymousCharSequence.length() - 1);
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
    return this.otU;
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
      cbz();
    }
    if (!this.ouy.isEmpty())
    {
      paramRect = (View.OnFocusChangeListener[])this.ouy.keySet().toArray(new View.OnFocusChangeListener[this.ouy.size()]);
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
      this.ouJ = '\b';
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    if ((bool) && (paramInt == 66)) {
      this.ouJ = '\n';
    }
    this.ouH = bool;
    return bool;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((!this.ouH) && (this.ouI != null) && (this.ouI.Aa(paramInt))) {
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
    if (!this.ouz.isEmpty())
    {
      Object[] arrayOfObject = this.ouz.keySet().toArray();
      paramInt2 = arrayOfObject.length;
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        ab.c localc = (ab.c)arrayOfObject[paramInt1];
        getMeasuredWidth();
        getMeasuredHeight();
        localc.cbA();
        paramInt1 += 1;
      }
    }
  }
  
  public void removeTextChangedListener(TextWatcher paramTextWatcher)
  {
    a locala = this.ouA;
    if (paramTextWatcher != null) {
      locala.ouM.remove(paramTextWatcher);
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
    this.ouF = paramBoolean;
  }
  
  public void setInputId(int paramInt)
  {
    this.osn = paramInt;
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
    this.ouC.ouT = paramb;
  }
  
  @Deprecated
  public void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    if (this.ouy == null)
    {
      super.setOnFocusChangeListener(paramOnFocusChangeListener);
      return;
    }
    a(paramOnFocusChangeListener);
  }
  
  public void setOnKeyUpPostImeListener(ab.b paramb)
  {
    this.ouI = paramb;
  }
  
  public void setPasswordMode(boolean paramBoolean)
  {
    cbU();
    this.ouv = paramBoolean;
    if (paramBoolean) {}
    for (PasswordTransformationMethod localPasswordTransformationMethod = this.ouB;; localPasswordTransformationMethod = null)
    {
      setTransformationMethod(localPasswordTransformationMethod);
      cbV();
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
      new com.tencent.mm.compatible.loader.c(this, "mCursorDrawableRes", TextView.class.getName()).set(Integer.valueOf(paramInt));
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
  
  final class a
    implements TextWatcher
  {
    final Map<TextWatcher, Object> ouM;
    
    private a()
    {
      AppMethodBeat.i(136562);
      this.ouM = new a();
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
        AppMethodBeat.o(136563);
        return;
      }
      catch (Throwable paramCharSequence)
      {
        AppMethodBeat.o(136563);
      }
    }
    
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(136566);
      f.cbc();
      Object localObject;
      final int i;
      final int j;
      if (f.cbd())
      {
        localObject = new PBool();
        PInt localPInt = new PInt();
        final String str = y.a(paramEditable, (PBool)localObject, localPInt);
        i = localPInt.value;
        if ((((PBool)localObject).value) && (!Util.isNullOrNil(str)))
        {
          j = Selection.getSelectionEnd(paramEditable);
          final boolean bool = y.d(y.this);
          y.this.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(136561);
              if (bool) {
                y.this.G(str);
              }
              for (;;)
              {
                try
                {
                  y.this.setSelection(Math.min(j + i, str.length()));
                  AppMethodBeat.o(136561);
                  return;
                }
                catch (Exception localException)
                {
                  Log.e("MicroMsg.AppBrand.WebEditText", "replace softBank to unicode, setSelection ", new Object[] { localException });
                  AppMethodBeat.o(136561);
                }
                y.this.setText(str);
              }
            }
          });
          AppMethodBeat.o(136566);
          return;
        }
      }
      if (!y.d(y.this))
      {
        y.e(y.this);
        if (!this.ouM.isEmpty())
        {
          localObject = (TextWatcher[])this.ouM.keySet().toArray(new TextWatcher[this.ouM.size()]);
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
      if ((!y.d(y.this)) && (!this.ouM.isEmpty()))
      {
        TextWatcher[] arrayOfTextWatcher = (TextWatcher[])this.ouM.keySet().toArray(new TextWatcher[this.ouM.size()]);
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
      if (!y.d(y.this))
      {
        a(paramCharSequence, paramInt1, paramInt3, StyleSpan.class);
        a(paramCharSequence, paramInt1, paramInt3, RelativeSizeSpan.class);
        a(paramCharSequence, paramInt1, paramInt3, AlignmentSpan.class);
        if (!this.ouM.isEmpty())
        {
          TextWatcher[] arrayOfTextWatcher = (TextWatcher[])this.ouM.keySet().toArray(new TextWatcher[this.ouM.size()]);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.y
 * JD-Core Version:    0.7.0.1
 */