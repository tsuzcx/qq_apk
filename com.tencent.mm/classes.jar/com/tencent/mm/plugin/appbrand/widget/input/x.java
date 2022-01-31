package com.tencent.mm.plugin.appbrand.widget.input;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.support.v4.f.a;
import android.text.Editable;
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
import com.tencent.luggage.l.a.a.c;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.widget.input.autofill.e;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

@SuppressLint({"AppCompatCustomView"})
public abstract class x
  extends EditText
  implements com.tencent.mm.plugin.appbrand.widget.base.c, aa
{
  InputConnection huL;
  boolean hvj = false;
  private final com.tencent.mm.plugin.appbrand.widget.input.autofill.b hvk;
  private final Map<aa.a, Object> hvl = new a();
  private final Map<View.OnFocusChangeListener, Object> hvm = new a();
  private final Map<aa.c, Object> hvn = new a();
  private final x.a hvo = new x.a(this, (byte)0);
  private final PasswordTransformationMethod hvp = new l();
  private final y hvq = new y(this);
  private boolean hvr;
  private int hvs = 0;
  private boolean hvt = false;
  private final int[] hvu = new int[2];
  private boolean hvv = false;
  private aa.b hvw;
  char hvx = '\000';
  private volatile int mInputId = -1;
  
  public x(Context paramContext)
  {
    super(paramContext);
    setBackgroundDrawable(null);
    setIncludeFontPadding(false);
    mU(3);
    setSingleLine(true);
    setTextCursorDrawable(a.c.app_brand_web_edit_text_cursor);
    setTextIsSelectable(true);
    setFocusable(true);
    setFocusableInTouchMode(true);
    if (Build.VERSION.SDK_INT >= 16) {
      setLineSpacing(0.0F, 1.0F);
    }
    setTypeface(Typeface.SANS_SERIF);
    super.addTextChangedListener(this.hvo);
    super.setPadding(0, 0, 0, 0);
    super.setEditableFactory(new x.1(this));
    if (arU()) {}
    for (this.hvk = new com.tencent.mm.plugin.appbrand.widget.input.autofill.b(this);; this.hvk = null)
    {
      this.hvr = true;
      return;
    }
  }
  
  private void mU(int paramInt)
  {
    setGravity(getGravity() & 0xFF7FFFFC & 0xFF7FFFFA | paramInt);
    paramInt = getGravity();
    Object localObject = getHint();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      Spannable localSpannable = ai.r((CharSequence)localObject);
      switch (paramInt & 0x7)
      {
      default: 
        localObject = Layout.Alignment.ALIGN_NORMAL;
        localSpannable.setSpan(new AlignmentSpan.Standard((Layout.Alignment)localObject), 0, getHint().length(), 18);
        super.setHint(localSpannable);
        if (Build.VERSION.SDK_INT >= 17) {
          switch (x.3.aPP[localObject.ordinal()])
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
  
  public final void A(q paramq)
  {
    if (this.hvk != null)
    {
      com.tencent.mm.plugin.appbrand.widget.input.autofill.c localc = this.hvk.hwN;
      j.u(paramq).a(localc.hwX);
    }
  }
  
  public void K(float paramFloat1, float paramFloat2)
  {
    throw new IllegalStateException("Should implement performClick(float, float) in this class!");
  }
  
  public final void a(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    if (paramOnFocusChangeListener != null) {
      this.hvm.put(paramOnFocusChangeListener, this);
    }
  }
  
  public final void a(aa.a parama)
  {
    this.hvl.put(parama, this);
  }
  
  public final void a(aa.c paramc)
  {
    this.hvn.put(paramc, this);
  }
  
  protected final boolean a(int paramInt, Rect paramRect)
  {
    return super.requestFocus(paramInt, paramRect);
  }
  
  public void addTextChangedListener(TextWatcher paramTextWatcher)
  {
    x.a locala = this.hvo;
    if (paramTextWatcher != null) {
      locala.hvz.put(paramTextWatcher, locala);
    }
  }
  
  public boolean arU()
  {
    return true;
  }
  
  protected abstract void arV();
  
  public boolean arX()
  {
    return this.hvt;
  }
  
  public boolean arc()
  {
    return false;
  }
  
  public final int ask()
  {
    return mV(getLineCount()) + getPaddingBottom();
  }
  
  public final void asl()
  {
    mU(3);
  }
  
  public final void asm()
  {
    mU(5);
  }
  
  public final void asn()
  {
    mU(1);
  }
  
  final void aso()
  {
    this.hvs += 1;
  }
  
  final void asp()
  {
    this.hvs = Math.max(0, this.hvs - 1);
  }
  
  protected final void asq()
  {
    super.clearFocus();
  }
  
  public final void b(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    if (paramOnFocusChangeListener != null) {
      this.hvm.remove(paramOnFocusChangeListener);
    }
  }
  
  Editable c(Editable paramEditable)
  {
    return this.hvq.c(paramEditable);
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
    this.hvl.clear();
    this.hvn.clear();
    this.hvm.clear();
    this.hvo.hvz.clear();
    if (this.hvk != null)
    {
      com.tencent.mm.plugin.appbrand.widget.input.autofill.b localb = this.hvk;
      com.tencent.mm.plugin.appbrand.widget.input.autofill.c localc = localb.hwN;
      j.u(localc.hwY).a(localc.hwX);
      localb.hwQ = null;
      localb.hwL.dismiss();
    }
    super.setOnFocusChangeListener(null);
  }
  
  public com.tencent.mm.plugin.appbrand.widget.input.autofill.b getAutoFillController()
  {
    return this.hvk;
  }
  
  public int getInputId()
  {
    return this.mInputId;
  }
  
  public char getLastKeyPressed()
  {
    return this.hvx;
  }
  
  public final View getView()
  {
    return this;
  }
  
  public final int mV(int paramInt)
  {
    int i = getPaddingTop() + (int)(paramInt * (getLineHeight() + getLineSpacingExtra()));
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.AppBrand.WebEditText", "calculateLinePosition, lineNumber %d, returnHeight %d, layout %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), getLayout() });
    return i;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (!this.hvl.isEmpty())
    {
      paramConfiguration = (aa.a[])this.hvl.keySet().toArray(new aa.a[this.hvl.size()]);
      int j = paramConfiguration.length;
      int i = 0;
      while (i < j)
      {
        paramConfiguration[i].asr();
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
    this.huL = new x.2(this, localInputConnection);
    paramEditorInfo.imeOptions |= 0x10000000;
    return this.huL;
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
      arV();
    }
    if (!this.hvm.isEmpty())
    {
      paramRect = (View.OnFocusChangeListener[])this.hvm.keySet().toArray(new View.OnFocusChangeListener[this.hvm.size()]);
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
      this.hvx = '\b';
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    if ((bool) && (paramInt == 66)) {
      this.hvx = '\n';
    }
    this.hvv = bool;
    return bool;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((!this.hvv) && (this.hvw != null) && (this.hvw.mK(paramInt))) {
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    com.tencent.mm.sdk.platformtools.y.v("MicroMsg.AppBrand.WebEditText", "[scrollUp] input onLayout");
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    com.tencent.mm.sdk.platformtools.y.v("MicroMsg.AppBrand.WebEditText", "[scrollUp] input onMeasure");
    super.onMeasure(paramInt1, paramInt2);
    if (!this.hvn.isEmpty())
    {
      Object[] arrayOfObject = this.hvn.keySet().toArray();
      paramInt2 = arrayOfObject.length;
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        aa.c localc = (aa.c)arrayOfObject[paramInt1];
        getMeasuredWidth();
        getMeasuredHeight();
        localc.arW();
        paramInt1 += 1;
      }
    }
  }
  
  public final void q(CharSequence paramCharSequence)
  {
    aso();
    Editable localEditable = getEditableText();
    if (localEditable == null) {
      setText(paramCharSequence, TextView.BufferType.EDITABLE);
    }
    for (;;)
    {
      asp();
      return;
      clearComposingText();
      if (TextUtils.isEmpty(paramCharSequence)) {
        localEditable.clear();
      } else {
        localEditable.replace(0, localEditable.length(), paramCharSequence);
      }
    }
  }
  
  public void removeTextChangedListener(TextWatcher paramTextWatcher)
  {
    x.a locala = this.hvo;
    if (paramTextWatcher != null) {
      locala.hvz.remove(paramTextWatcher);
    }
  }
  
  public boolean requestFocus(int paramInt, Rect paramRect)
  {
    if ((130 == paramInt) && (paramRect == null) && ((getParent() instanceof ViewGroup)))
    {
      ((ViewGroup)getParent()).setDescendantFocusability(262144);
      ((ViewGroup)getParent()).setFocusableInTouchMode(false);
    }
    return super.requestFocus(paramInt, paramRect);
  }
  
  public void setFixed(boolean paramBoolean)
  {
    this.hvt = paramBoolean;
  }
  
  public void setInputId(int paramInt)
  {
    this.mInputId = paramInt;
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
    this.hvq.hvF = paramb;
  }
  
  @Deprecated
  public void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    super.setOnFocusChangeListener(paramOnFocusChangeListener);
  }
  
  public void setOnKeyUpPostImeListener(aa.b paramb)
  {
    this.hvw = paramb;
  }
  
  public void setPasswordMode(boolean paramBoolean)
  {
    aso();
    this.hvj = paramBoolean;
    if (paramBoolean) {}
    for (PasswordTransformationMethod localPasswordTransformationMethod = this.hvp;; localPasswordTransformationMethod = null)
    {
      setTransformationMethod(localPasswordTransformationMethod);
      asp();
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
    super.setSelection(paramInt1, paramInt2);
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
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.AppBrand.WebEditText", "setTextCursorDrawable, exp = %s", new Object[] { bk.j(localException) });
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
  
  public final void z(q paramq)
  {
    Object localObject;
    if (this.hvk != null)
    {
      localObject = this.hvk.hwN;
      ((com.tencent.mm.plugin.appbrand.widget.input.autofill.c)localObject).hwY = paramq;
      paramq = j.u(paramq);
      localObject = ((com.tencent.mm.plugin.appbrand.widget.input.autofill.c)localObject).hwX;
      if (localObject != null) {
        break label35;
      }
    }
    label35:
    while (paramq.htB.containsKey(localObject)) {
      return;
    }
    paramq.htB.put(localObject, paramq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.x
 * JD-Core Version:    0.7.0.1
 */