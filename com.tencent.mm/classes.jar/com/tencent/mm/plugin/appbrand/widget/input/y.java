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
import android.text.Spannable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.text.style.AlignmentSpan.Standard;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.widget.input.autofill.e;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

@SuppressLint({"AppCompatCustomView"})
public abstract class y
  extends EditText
  implements com.tencent.mm.plugin.appbrand.widget.base.c, ab
{
  private volatile int jlk = -1;
  InputConnection jmV;
  private final PasswordTransformationMethod jnA = new m();
  private final z jnB = new z(this);
  private boolean jnC;
  private int jnD = 0;
  private boolean jnE = false;
  private final int[] jnF = new int[2];
  private boolean jnG = false;
  private ab.b jnH;
  char jnI = '\000';
  boolean jnu = false;
  private final com.tencent.mm.plugin.appbrand.widget.input.autofill.b jnv;
  private final Map<ab.a, Object> jnw = new a();
  private final Map<View.OnFocusChangeListener, Object> jnx = new a();
  private final Map<ab.c, Object> jny = new a();
  private final y.a jnz = new y.a(this, (byte)0);
  
  public y(Context paramContext)
  {
    super(paramContext);
    setBackgroundDrawable(null);
    setIncludeFontPadding(false);
    qy(3);
    setSingleLine(true);
    setTextCursorDrawable(2130837789);
    setTextIsSelectable(true);
    setFocusable(true);
    setFocusableInTouchMode(true);
    if (Build.VERSION.SDK_INT >= 16) {
      setLineSpacing(0.0F, 1.0F);
    }
    setTypeface(Typeface.SANS_SERIF);
    super.addTextChangedListener(this.jnz);
    super.setPadding(0, 0, 0, 0);
    super.setEditableFactory(new Editable.Factory()
    {
      public final Editable newEditable(CharSequence paramAnonymousCharSequence)
      {
        AppMethodBeat.i(123816);
        paramAnonymousCharSequence = super.newEditable(paramAnonymousCharSequence);
        paramAnonymousCharSequence = y.this.c(paramAnonymousCharSequence);
        AppMethodBeat.o(123816);
        return paramAnonymousCharSequence;
      }
    });
    if (aQY()) {}
    for (this.jnv = new com.tencent.mm.plugin.appbrand.widget.input.autofill.b(this);; this.jnv = null)
    {
      this.jnC = true;
      return;
    }
  }
  
  private void qy(int paramInt)
  {
    setGravity(getGravity() & 0xFF7FFFFC & 0xFF7FFFFA | paramInt);
    paramInt = getGravity();
    Object localObject = getHint();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      Spannable localSpannable = aj.A((CharSequence)localObject);
      switch (paramInt & 0x7)
      {
      default: 
        localObject = Layout.Alignment.ALIGN_NORMAL;
        localSpannable.setSpan(new AlignmentSpan.Standard((Layout.Alignment)localObject), 0, getHint().length(), 18);
        super.setHint(localSpannable);
        if (Build.VERSION.SDK_INT >= 17) {
          switch (y.3.aXj[localObject.ordinal()])
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
  
  private void y(CharSequence paramCharSequence)
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
  
  public void R(float paramFloat1, float paramFloat2)
  {
    throw new IllegalStateException("Should implement performClick(float, float) in this class!");
  }
  
  public final void a(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    if (paramOnFocusChangeListener != null) {
      this.jnx.put(paramOnFocusChangeListener, this);
    }
  }
  
  public final void a(ab.a parama)
  {
    this.jnw.put(parama, this);
  }
  
  public final void a(ab.c paramc)
  {
    this.jny.put(paramc, this);
  }
  
  protected final boolean a(int paramInt, Rect paramRect)
  {
    return super.requestFocus(paramInt, paramRect);
  }
  
  public boolean aOP()
  {
    return false;
  }
  
  public boolean aQY()
  {
    return true;
  }
  
  protected abstract void aQZ();
  
  public boolean aRb()
  {
    return this.jnE;
  }
  
  public final int aRp()
  {
    return qz(getLineCount()) + getPaddingBottom();
  }
  
  public final void aRq()
  {
    qy(3);
  }
  
  public final void aRr()
  {
    qy(5);
  }
  
  public final void aRs()
  {
    qy(1);
  }
  
  final void aRt()
  {
    aRu();
    setText(getEditableText());
    aRv();
  }
  
  final void aRu()
  {
    this.jnD += 1;
  }
  
  final void aRv()
  {
    this.jnD = Math.max(0, this.jnD - 1);
  }
  
  protected final void aRw()
  {
    super.clearFocus();
  }
  
  public void addTextChangedListener(TextWatcher paramTextWatcher)
  {
    y.a locala = this.jnz;
    if (paramTextWatcher != null) {
      locala.jnL.put(paramTextWatcher, locala);
    }
  }
  
  public final void b(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    if (paramOnFocusChangeListener != null) {
      this.jnx.remove(paramOnFocusChangeListener);
    }
  }
  
  Editable c(Editable paramEditable)
  {
    return this.jnB.c(paramEditable);
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
    this.jnw.clear();
    this.jny.clear();
    this.jnx.clear();
    this.jnz.jnL.clear();
    if (this.jnv != null)
    {
      com.tencent.mm.plugin.appbrand.widget.input.autofill.b localb = this.jnv;
      com.tencent.mm.plugin.appbrand.widget.input.autofill.c localc = localb.joX;
      k.p(localc.jpi).a(localc.jph);
      localb.jpa = null;
      localb.joV.dismiss();
    }
    super.setOnFocusChangeListener(null);
  }
  
  public com.tencent.mm.plugin.appbrand.widget.input.autofill.b getAutoFillController()
  {
    return this.jnv;
  }
  
  public int getAutofillType()
  {
    return 0;
  }
  
  public int getInputId()
  {
    return this.jlk;
  }
  
  public char getLastKeyPressed()
  {
    return this.jnI;
  }
  
  public final View getView()
  {
    return this;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (!this.jnw.isEmpty())
    {
      paramConfiguration = (ab.a[])this.jnw.keySet().toArray(new ab.a[this.jnw.size()]);
      int j = paramConfiguration.length;
      int i = 0;
      while (i < j)
      {
        paramConfiguration[i].gA();
        i += 1;
      }
    }
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    InputConnection localInputConnection = super.onCreateInputConnection(paramEditorInfo);
    if (localInputConnection == null) {
      return null;
    }
    this.jmV = new y.2(this, localInputConnection, localInputConnection);
    paramEditorInfo.imeOptions |= 0x10000000;
    return this.jmV;
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
      aQZ();
    }
    if (!this.jnx.isEmpty())
    {
      paramRect = (View.OnFocusChangeListener[])this.jnx.keySet().toArray(new View.OnFocusChangeListener[this.jnx.size()]);
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
      this.jnI = '\b';
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    if ((bool) && (paramInt == 66)) {
      this.jnI = '\n';
    }
    this.jnG = bool;
    return bool;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((!this.jnG) && (this.jnH != null) && (this.jnH.qp(paramInt))) {
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    com.tencent.mm.sdk.platformtools.ab.v("MicroMsg.AppBrand.WebEditText", "[scrollUp] input onLayout");
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    com.tencent.mm.sdk.platformtools.ab.v("MicroMsg.AppBrand.WebEditText", "[scrollUp] input onMeasure");
    super.onMeasure(paramInt1, paramInt2);
    if (!this.jny.isEmpty())
    {
      Object[] arrayOfObject = this.jny.keySet().toArray();
      paramInt2 = arrayOfObject.length;
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        ab.c localc = (ab.c)arrayOfObject[paramInt1];
        getMeasuredWidth();
        getMeasuredHeight();
        localc.aRa();
        paramInt1 += 1;
      }
    }
  }
  
  public final int qz(int paramInt)
  {
    int i = getPaddingTop() + (int)(paramInt * (getLineHeight() + getLineSpacingExtra()));
    com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.AppBrand.WebEditText", "calculateLinePosition, lineNumber %d, returnHeight %d, layout %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), getLayout() });
    return i;
  }
  
  public void removeTextChangedListener(TextWatcher paramTextWatcher)
  {
    y.a locala = this.jnz;
    if (paramTextWatcher != null) {
      locala.jnL.remove(paramTextWatcher);
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
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.AppBrand.WebEditText", "requestFocus e=%s", new Object[] { localRuntimeException });
      try
      {
        bool = super.requestFocus(paramInt, paramRect);
        return bool;
      }
      catch (RuntimeException paramRect)
      {
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.AppBrand.WebEditText", "requestFocus try again e=%s", new Object[] { paramRect });
      }
    }
    return false;
  }
  
  public void setFixed(boolean paramBoolean)
  {
    this.jnE = paramBoolean;
  }
  
  public void setInputId(int paramInt)
  {
    this.jlk = paramInt;
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
    this.jnB.jnS = paramb;
  }
  
  @Deprecated
  public void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    a(paramOnFocusChangeListener);
  }
  
  public void setOnKeyUpPostImeListener(ab.b paramb)
  {
    this.jnH = paramb;
  }
  
  public void setPasswordMode(boolean paramBoolean)
  {
    aRu();
    this.jnu = paramBoolean;
    if (paramBoolean) {}
    for (PasswordTransformationMethod localPasswordTransformationMethod = this.jnA;; localPasswordTransformationMethod = null)
    {
      setTransformationMethod(localPasswordTransformationMethod);
      aRv();
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
      com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.AppBrand.WebEditText", "setTextCursorDrawable, exp = %s", new Object[] { bo.l(localException) });
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
  
  public final void t(v paramv)
  {
    Object localObject;
    if (this.jnv != null)
    {
      localObject = this.jnv.joX;
      ((com.tencent.mm.plugin.appbrand.widget.input.autofill.c)localObject).jpi = paramv;
      paramv = k.p(paramv);
      localObject = ((com.tencent.mm.plugin.appbrand.widget.input.autofill.c)localObject).jph;
      if (localObject != null) {
        break label35;
      }
    }
    label35:
    while (paramv.jlI.containsKey(localObject)) {
      return;
    }
    paramv.jlI.put(localObject, paramv);
  }
  
  public String toString()
  {
    return String.format(Locale.US, "[%s|%s]", new Object[] { getClass().getSimpleName(), Integer.valueOf(getInputId()) });
  }
  
  public final void u(v paramv)
  {
    if (this.jnv != null)
    {
      com.tencent.mm.plugin.appbrand.widget.input.autofill.c localc = this.jnv.joX;
      k.p(paramv).a(localc.jph);
    }
  }
  
  public final void z(CharSequence paramCharSequence)
  {
    aRu();
    y(paramCharSequence);
    aRv();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.y
 * JD-Core Version:    0.7.0.1
 */