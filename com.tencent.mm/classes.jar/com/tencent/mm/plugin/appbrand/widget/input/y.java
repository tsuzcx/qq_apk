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
import com.tencent.mm.plugin.appbrand.widget.input.autofill.e;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

@SuppressLint({"AppCompatCustomView"})
public abstract class y
  extends EditText
  implements com.tencent.mm.plugin.appbrand.widget.base.c, ab
{
  private volatile int niF = -1;
  boolean nkO = false;
  private final com.tencent.mm.plugin.appbrand.widget.input.autofill.b nkP;
  private final Map<ab.a, Object> nkQ = new a();
  private final Map<View.OnFocusChangeListener, Object> nkR = new a();
  private final Map<ab.c, Object> nkS = new a();
  private final a nkT = new a((byte)0);
  private final PasswordTransformationMethod nkU = new m();
  private final z nkV = new z(this);
  private boolean nkW;
  private int nkX = 0;
  private boolean nkY = false;
  private final int[] nkZ = new int[2];
  InputConnection nkq;
  private boolean nla = false;
  private ab.b nlb;
  char nlc = '\000';
  
  public y(Context paramContext)
  {
    super(paramContext);
    setBackgroundDrawable(null);
    setIncludeFontPadding(false);
    wB(3);
    setSingleLine(true);
    setTextCursorDrawable(2131231042);
    setTextIsSelectable(true);
    setFocusable(true);
    setFocusableInTouchMode(true);
    if (Build.VERSION.SDK_INT >= 16) {
      setLineSpacing(0.0F, 1.0F);
    }
    setTypeface(Typeface.SANS_SERIF);
    super.addTextChangedListener(this.nkT);
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
    if (bFj()) {}
    for (this.nkP = new com.tencent.mm.plugin.appbrand.widget.input.autofill.b(this);; this.nkP = null)
    {
      this.nkW = true;
      return;
    }
  }
  
  private void B(CharSequence paramCharSequence)
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
  
  private void wB(int paramInt)
  {
    setGravity(getGravity() & 0xFF7FFFFC & 0xFF7FFFFA | paramInt);
    paramInt = getGravity();
    Object localObject = getHint();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      Spannable localSpannable = aj.D((CharSequence)localObject);
      switch (paramInt & 0x7)
      {
      default: 
        localObject = Layout.Alignment.ALIGN_NORMAL;
        localSpannable.setSpan(new AlignmentSpan.Standard((Layout.Alignment)localObject), 0, getHint().length(), 18);
        super.setHint(localSpannable);
        if (Build.VERSION.SDK_INT >= 17) {
          switch (y.3.bDB[localObject.ordinal()])
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
  
  public final void B(com.tencent.mm.plugin.appbrand.page.z paramz)
  {
    Object localObject;
    if (this.nkP != null)
    {
      localObject = this.nkP.nmu;
      ((com.tencent.mm.plugin.appbrand.widget.input.autofill.c)localObject).nmF = paramz;
      paramz = k.x(paramz);
      localObject = ((com.tencent.mm.plugin.appbrand.widget.input.autofill.c)localObject).nmE;
      if (localObject != null) {
        break label35;
      }
    }
    label35:
    while (paramz.nje.containsKey(localObject)) {
      return;
    }
    paramz.nje.put(localObject, paramz);
  }
  
  public final void C(com.tencent.mm.plugin.appbrand.page.z paramz)
  {
    if (this.nkP != null)
    {
      com.tencent.mm.plugin.appbrand.widget.input.autofill.c localc = this.nkP.nmu;
      k.x(paramz).a(localc.nmE);
    }
  }
  
  public final void C(CharSequence paramCharSequence)
  {
    bFE();
    B(paramCharSequence);
    bFF();
  }
  
  public void M(float paramFloat1, float paramFloat2)
  {
    throw new IllegalStateException("Should implement performClick(float, float) in this class!");
  }
  
  public final void a(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    if (paramOnFocusChangeListener != null) {
      this.nkR.put(paramOnFocusChangeListener, this);
    }
  }
  
  public final void a(ab.a parama)
  {
    this.nkQ.put(parama, this);
  }
  
  public final void a(ab.c paramc)
  {
    this.nkS.put(paramc, this);
  }
  
  protected final boolean a(int paramInt, Rect paramRect)
  {
    return super.requestFocus(paramInt, paramRect);
  }
  
  public void addTextChangedListener(TextWatcher paramTextWatcher)
  {
    a locala = this.nkT;
    if (paramTextWatcher != null) {
      locala.nlf.put(paramTextWatcher, locala);
    }
  }
  
  public final void b(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    if (paramOnFocusChangeListener != null) {
      this.nkR.remove(paramOnFocusChangeListener);
    }
  }
  
  public boolean bDj()
  {
    return false;
  }
  
  public final void bFA()
  {
    wB(3);
  }
  
  public final void bFB()
  {
    wB(5);
  }
  
  public final void bFC()
  {
    wB(1);
  }
  
  final void bFD()
  {
    bFE();
    setText(getEditableText());
    bFF();
  }
  
  final void bFE()
  {
    this.nkX += 1;
  }
  
  final void bFF()
  {
    this.nkX = Math.max(0, this.nkX - 1);
  }
  
  protected final void bFG()
  {
    super.clearFocus();
  }
  
  public boolean bFj()
  {
    return true;
  }
  
  protected abstract void bFk();
  
  public boolean bFm()
  {
    return this.nkY;
  }
  
  public final int bFz()
  {
    return wC(getLineCount()) + getPaddingBottom();
  }
  
  Editable c(Editable paramEditable)
  {
    return this.nkV.c(paramEditable);
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
    this.nkQ.clear();
    this.nkS.clear();
    this.nkR.clear();
    this.nkT.nlf.clear();
    if (this.nkP != null)
    {
      com.tencent.mm.plugin.appbrand.widget.input.autofill.b localb = this.nkP;
      com.tencent.mm.plugin.appbrand.widget.input.autofill.c localc = localb.nmu;
      k.x(localc.nmF).a(localc.nmE);
      localb.nmx = null;
      localb.nms.dismiss();
    }
    super.setOnFocusChangeListener(null);
  }
  
  public com.tencent.mm.plugin.appbrand.widget.input.autofill.b getAutoFillController()
  {
    return this.nkP;
  }
  
  public int getAutofillType()
  {
    return 0;
  }
  
  public int getInputId()
  {
    return this.niF;
  }
  
  public char getLastKeyPressed()
  {
    return this.nlc;
  }
  
  public final View getView()
  {
    return this;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (!this.nkQ.isEmpty())
    {
      paramConfiguration = (ab.a[])this.nkQ.keySet().toArray(new ab.a[this.nkQ.size()]);
      int j = paramConfiguration.length;
      int i = 0;
      while (i < j)
      {
        paramConfiguration[i].iv();
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
    this.nkq = new InputConnectionWrapper(localInputConnection, localInputConnection)
    {
      public final boolean commitText(CharSequence paramAnonymousCharSequence, int paramAnonymousInt)
      {
        AppMethodBeat.i(136557);
        if (!TextUtils.isEmpty(paramAnonymousCharSequence)) {
          y.this.nlc = paramAnonymousCharSequence.charAt(paramAnonymousCharSequence.length() - 1);
        }
        boolean bool = super.commitText(paramAnonymousCharSequence, paramAnonymousInt);
        AppMethodBeat.o(136557);
        return bool;
      }
      
      public final boolean deleteSurroundingText(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(136558);
        y.this.nlc = '\b';
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
          boolean bool1 = aj.E((CharSequence)localObject);
          boolean bool2 = super.finishComposingText();
          if ((bool2) && (y.b(y.this) == this) && (bool1))
          {
            localObject = y.c(y.this);
            ((z)localObject).jzz.removeCallbacks(((z)localObject).nln);
            if (((z)localObject).nll) {
              ((z)localObject).nln.run();
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
          y.this.nlc = paramAnonymousCharSequence.charAt(paramAnonymousCharSequence.length() - 1);
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
    return this.nkq;
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
      bFk();
    }
    if (!this.nkR.isEmpty())
    {
      paramRect = (View.OnFocusChangeListener[])this.nkR.keySet().toArray(new View.OnFocusChangeListener[this.nkR.size()]);
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
      this.nlc = '\b';
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    if ((bool) && (paramInt == 66)) {
      this.nlc = '\n';
    }
    this.nla = bool;
    return bool;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((!this.nla) && (this.nlb != null) && (this.nlb.ws(paramInt))) {
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ae.v("MicroMsg.AppBrand.WebEditText", "[scrollUp] input onLayout");
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    ae.v("MicroMsg.AppBrand.WebEditText", "[scrollUp] input onMeasure");
    super.onMeasure(paramInt1, paramInt2);
    if (!this.nkS.isEmpty())
    {
      Object[] arrayOfObject = this.nkS.keySet().toArray();
      paramInt2 = arrayOfObject.length;
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        ab.c localc = (ab.c)arrayOfObject[paramInt1];
        getMeasuredWidth();
        getMeasuredHeight();
        localc.bFl();
        paramInt1 += 1;
      }
    }
  }
  
  public void removeTextChangedListener(TextWatcher paramTextWatcher)
  {
    a locala = this.nkT;
    if (paramTextWatcher != null) {
      locala.nlf.remove(paramTextWatcher);
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
      ae.e("MicroMsg.AppBrand.WebEditText", "requestFocus e=%s", new Object[] { localRuntimeException });
      try
      {
        bool = super.requestFocus(paramInt, paramRect);
        return bool;
      }
      catch (RuntimeException paramRect)
      {
        ae.e("MicroMsg.AppBrand.WebEditText", "requestFocus try again e=%s", new Object[] { paramRect });
      }
    }
    return false;
  }
  
  public void setFixed(boolean paramBoolean)
  {
    this.nkY = paramBoolean;
  }
  
  public void setInputId(int paramInt)
  {
    this.niF = paramInt;
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
    this.nkV.nlm = paramb;
  }
  
  @Deprecated
  public void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    if (this.nkR == null)
    {
      super.setOnFocusChangeListener(paramOnFocusChangeListener);
      return;
    }
    a(paramOnFocusChangeListener);
  }
  
  public void setOnKeyUpPostImeListener(ab.b paramb)
  {
    this.nlb = paramb;
  }
  
  public void setPasswordMode(boolean paramBoolean)
  {
    bFE();
    this.nkO = paramBoolean;
    if (paramBoolean) {}
    for (PasswordTransformationMethod localPasswordTransformationMethod = this.nkU;; localPasswordTransformationMethod = null)
    {
      setTransformationMethod(localPasswordTransformationMethod);
      bFF();
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
      ae.d("MicroMsg.AppBrand.WebEditText", "setTextCursorDrawable, exp = %s", new Object[] { bu.o(localException) });
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
  
  public final int wC(int paramInt)
  {
    int i = getPaddingTop() + (int)(paramInt * (getLineHeight() + getLineSpacingExtra()));
    ae.d("MicroMsg.AppBrand.WebEditText", "calculateLinePosition, lineNumber %d, returnHeight %d, layout %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), getLayout() });
    return i;
  }
  
  final class a
    implements TextWatcher
  {
    final Map<TextWatcher, Object> nlf;
    
    private a()
    {
      AppMethodBeat.i(136562);
      this.nlf = new a();
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
      f.bEO();
      Object localObject;
      final int i;
      final int j;
      if (f.bEP())
      {
        localObject = new PBool();
        PInt localPInt = new PInt();
        final String str = y.a(paramEditable, (PBool)localObject, localPInt);
        i = localPInt.value;
        if ((((PBool)localObject).value) && (!bu.isNullOrNil(str)))
        {
          j = Selection.getSelectionEnd(paramEditable);
          final boolean bool = y.d(y.this);
          y.this.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(136561);
              if (bool) {
                y.this.C(str);
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
                  ae.e("MicroMsg.AppBrand.WebEditText", "replace softBank to unicode, setSelection ", new Object[] { localException });
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
        if (!this.nlf.isEmpty())
        {
          localObject = (TextWatcher[])this.nlf.keySet().toArray(new TextWatcher[this.nlf.size()]);
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
      if ((!y.d(y.this)) && (!this.nlf.isEmpty()))
      {
        TextWatcher[] arrayOfTextWatcher = (TextWatcher[])this.nlf.keySet().toArray(new TextWatcher[this.nlf.size()]);
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
        if (!this.nlf.isEmpty())
        {
          TextWatcher[] arrayOfTextWatcher = (TextWatcher[])this.nlf.keySet().toArray(new TextWatcher[this.nlf.size()]);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.y
 * JD-Core Version:    0.7.0.1
 */