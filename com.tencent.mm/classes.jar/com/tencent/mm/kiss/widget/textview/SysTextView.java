package com.tencent.mm.kiss.widget.textview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Point;
import android.text.Layout;
import android.text.Selection;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStructure;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.reflect.Field;

public class SysTextView
  extends TextView
  implements a
{
  private static boolean eMg = false;
  private static Field eMh = null;
  private g eLS;
  
  public SysTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(105777);
    this.eLS = new g(this, new com.tencent.mm.kiss.widget.textview.a.a());
    init();
    AppMethodBeat.o(105777);
  }
  
  public SysTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(105778);
    this.eLS = new g(this, new com.tencent.mm.kiss.widget.textview.a.a());
    init();
    AppMethodBeat.o(105778);
  }
  
  private void SO()
  {
    AppMethodBeat.i(105780);
    if (eMg)
    {
      AppMethodBeat.o(105780);
      return;
    }
    try
    {
      if (eMh == null)
      {
        Field localField = TextView.class.getDeclaredField("mSingleLine");
        eMh = localField;
        localField.setAccessible(true);
      }
      if (eMh.getBoolean(this)) {
        this.eLS.eLU.maxLines = 1;
      }
      AppMethodBeat.o(105780);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.SysPLTextView", "initSingleLine error: %s", new Object[] { localException.getMessage() });
      eMg = true;
      AppMethodBeat.o(105780);
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(105779);
    super.setText(" ", TextView.BufferType.SPANNABLE);
    this.eLS.eLU = new com.tencent.mm.kiss.widget.textview.a.a();
    this.eLS.eLU.textColor = super.getTextColors().getDefaultColor();
    this.eLS.eLU.eLG = super.getEllipsize();
    this.eLS.eLU.gravity = super.getGravity();
    this.eLS.eLU.textSize = super.getTextSize();
    SO();
    AppMethodBeat.o(105779);
  }
  
  public void dispatchProvideStructure(ViewStructure paramViewStructure) {}
  
  public int getBaseline()
  {
    AppMethodBeat.i(105813);
    try
    {
      int i = super.getBaseline();
      AppMethodBeat.o(105813);
      return i;
    }
    catch (Throwable localThrowable)
    {
      ab.printErrStackTrace("MicroMsg.SysPLTextView", localThrowable, "", new Object[0]);
      AppMethodBeat.o(105813);
    }
    return -1;
  }
  
  public com.tencent.mm.kiss.widget.textview.a.a getConfig()
  {
    if (this.eLS == null) {
      return null;
    }
    return this.eLS.eLU;
  }
  
  public int getHorizontalDrawOffset()
  {
    if (this.eLS == null) {
      return 0;
    }
    return this.eLS.eLX;
  }
  
  protected f getLayoutWrapper()
  {
    AppMethodBeat.i(105781);
    if (this.eLS == null)
    {
      AppMethodBeat.o(105781);
      return null;
    }
    f localf = this.eLS.getLayoutWrapper();
    AppMethodBeat.o(105781);
    return localf;
  }
  
  public int getLineCount()
  {
    AppMethodBeat.i(105799);
    if (this.eLS == null)
    {
      AppMethodBeat.o(105799);
      return 0;
    }
    int i = this.eLS.getLineCount();
    AppMethodBeat.o(105799);
    return i;
  }
  
  public int getLineHeight()
  {
    AppMethodBeat.i(105800);
    if (this.eLS == null)
    {
      AppMethodBeat.o(105800);
      return 0;
    }
    int i = this.eLS.getLineHeight();
    AppMethodBeat.o(105800);
    return i;
  }
  
  public int getSelectionEnd()
  {
    AppMethodBeat.i(105802);
    if (getText() == null)
    {
      AppMethodBeat.o(105802);
      return -1;
    }
    int i = Selection.getSelectionEnd(getText());
    AppMethodBeat.o(105802);
    return i;
  }
  
  public int getSelectionStart()
  {
    AppMethodBeat.i(105801);
    if (getText() == null)
    {
      AppMethodBeat.o(105801);
      return -1;
    }
    int i = Selection.getSelectionStart(getText());
    AppMethodBeat.o(105801);
    return i;
  }
  
  public CharSequence getText()
  {
    AppMethodBeat.i(105795);
    if (this.eLS == null)
    {
      AppMethodBeat.o(105795);
      return null;
    }
    CharSequence localCharSequence = this.eLS.getText();
    AppMethodBeat.o(105795);
    return localCharSequence;
  }
  
  public int getTextColor()
  {
    AppMethodBeat.i(105797);
    int i = this.eLS.getTextColor();
    AppMethodBeat.o(105797);
    return i;
  }
  
  public float getTextSize()
  {
    AppMethodBeat.i(105796);
    if (this.eLS == null)
    {
      AppMethodBeat.o(105796);
      return 0.0F;
    }
    float f = this.eLS.getTextSize();
    AppMethodBeat.o(105796);
    return f;
  }
  
  public Layout getTvLayout()
  {
    AppMethodBeat.i(105798);
    Layout localLayout = this.eLS.getTvLayout();
    AppMethodBeat.o(105798);
    return localLayout;
  }
  
  public int getVerticalDrawOffset()
  {
    if (this.eLS == null) {
      return 0;
    }
    return this.eLS.eLY;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(105808);
    super.onAttachedToWindow();
    AppMethodBeat.o(105808);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(105809);
    super.onDetachedFromWindow();
    AppMethodBeat.o(105809);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(105806);
    try
    {
      g localg = this.eLS;
      if (localg == null)
      {
        AppMethodBeat.o(105806);
        return;
      }
      this.eLS.onDraw(paramCanvas);
      AppMethodBeat.o(105806);
      return;
    }
    catch (Throwable paramCanvas)
    {
      ab.printErrStackTrace("MicroMsg.SysPLTextView", paramCanvas, "", new Object[0]);
      AppMethodBeat.o(105806);
    }
  }
  
  public void onFinishTemporaryDetach()
  {
    AppMethodBeat.i(105811);
    super.onFinishTemporaryDetach();
    AppMethodBeat.o(105811);
  }
  
  public void onHoverChanged(boolean paramBoolean) {}
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(105807);
    try
    {
      Point localPoint = this.eLS.cj(paramInt1, paramInt2);
      if (localPoint != null)
      {
        setMeasuredDimension(localPoint.x, localPoint.y);
        AppMethodBeat.o(105807);
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      try
      {
        super.onMeasure(paramInt1, paramInt2);
        AppMethodBeat.o(105807);
        return;
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.SysPLTextView", localException, "onMeasure error: %s", new Object[] { localException.getMessage() });
        AppMethodBeat.o(105807);
      }
      localThrowable = localThrowable;
      ab.printErrStackTrace("MicroMsg.SysPLTextView", localThrowable, "", new Object[0]);
      AppMethodBeat.o(105807);
      return;
    }
  }
  
  public boolean onPreDraw()
  {
    return true;
  }
  
  public void onProvideStructure(ViewStructure paramViewStructure)
  {
    AppMethodBeat.i(105812);
    try
    {
      super.onProvideStructure(paramViewStructure);
      AppMethodBeat.o(105812);
      return;
    }
    catch (Exception paramViewStructure)
    {
      ab.printErrStackTrace("MicroMsg.SysPLTextView", paramViewStructure, "onProvideStructure error: %s", new Object[] { paramViewStructure.getMessage() });
      AppMethodBeat.o(105812);
    }
  }
  
  public void onStartTemporaryDetach()
  {
    AppMethodBeat.i(105810);
    super.onStartTemporaryDetach();
    AppMethodBeat.o(105810);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(105804);
    if (getTvLayout() == null)
    {
      AppMethodBeat.o(105804);
      return false;
    }
    boolean bool1 = this.eLS.t(paramMotionEvent);
    boolean bool2 = super.onTouchEvent(paramMotionEvent);
    if (bool1)
    {
      AppMethodBeat.o(105804);
      return true;
    }
    AppMethodBeat.o(105804);
    return bool2;
  }
  
  public boolean performClick()
  {
    AppMethodBeat.i(105805);
    if (this.eLS == null)
    {
      AppMethodBeat.o(105805);
      return false;
    }
    if (!this.eLS.performClick())
    {
      AppMethodBeat.o(105805);
      return false;
    }
    boolean bool = super.performClick();
    AppMethodBeat.o(105805);
    return bool;
  }
  
  public void setClickable(boolean paramBoolean)
  {
    AppMethodBeat.i(105803);
    super.setClickable(paramBoolean);
    if (this.eLS == null)
    {
      AppMethodBeat.o(105803);
      return;
    }
    this.eLS.eMa = paramBoolean;
    AppMethodBeat.o(105803);
  }
  
  public void setGravity(int paramInt)
  {
    AppMethodBeat.i(105790);
    if (this.eLS == null)
    {
      AppMethodBeat.o(105790);
      return;
    }
    this.eLS.setGravity(paramInt);
    AppMethodBeat.o(105790);
  }
  
  public void setHandleClickableSpan(boolean paramBoolean)
  {
    this.eLS.eMb = paramBoolean;
  }
  
  public void setLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(105793);
    if (this.eLS != null) {
      this.eLS.SN();
    }
    super.setLayoutParams(paramLayoutParams);
    AppMethodBeat.o(105793);
  }
  
  public void setLines(int paramInt)
  {
    AppMethodBeat.i(105783);
    if (this.eLS == null)
    {
      AppMethodBeat.o(105783);
      return;
    }
    this.eLS.setLines(paramInt);
    AppMethodBeat.o(105783);
  }
  
  public void setMaxLines(int paramInt)
  {
    AppMethodBeat.i(105791);
    if (this.eLS == null)
    {
      AppMethodBeat.o(105791);
      return;
    }
    this.eLS.setMaxLines(paramInt);
    AppMethodBeat.o(105791);
  }
  
  public void setMinLines(int paramInt)
  {
    AppMethodBeat.i(105792);
    if (this.eLS == null)
    {
      AppMethodBeat.o(105792);
      return;
    }
    this.eLS.setMinLines(paramInt);
    AppMethodBeat.o(105792);
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(105794);
    if (this.eLS != null) {
      this.eLS.SN();
    }
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(105794);
  }
  
  public void setSingleLine(boolean paramBoolean)
  {
    AppMethodBeat.i(105782);
    if (this.eLS == null)
    {
      AppMethodBeat.o(105782);
      return;
    }
    this.eLS.setSingleLine(paramBoolean);
    AppMethodBeat.o(105782);
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    AppMethodBeat.i(105784);
    setText$609c24db(paramCharSequence);
    AppMethodBeat.o(105784);
  }
  
  public final void setText$609c24db(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(105785);
    if (this.eLS == null)
    {
      super.setText("");
      AppMethodBeat.o(105785);
      return;
    }
    this.eLS.setText(paramCharSequence, false);
    AppMethodBeat.o(105785);
  }
  
  public void setTextColor(int paramInt)
  {
    AppMethodBeat.i(105789);
    if (this.eLS == null)
    {
      AppMethodBeat.o(105789);
      return;
    }
    this.eLS.setTextColor(paramInt);
    AppMethodBeat.o(105789);
  }
  
  public void setTextLayout(f paramf)
  {
    AppMethodBeat.i(105788);
    if (this.eLS == null)
    {
      AppMethodBeat.o(105788);
      return;
    }
    this.eLS.setTextLayout(paramf);
    AppMethodBeat.o(105788);
  }
  
  public void setTextSize(float paramFloat)
  {
    AppMethodBeat.i(105786);
    setTextSize(0, paramFloat);
    AppMethodBeat.o(105786);
  }
  
  public void setTextSize(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(105787);
    if (this.eLS == null)
    {
      AppMethodBeat.o(105787);
      return;
    }
    this.eLS.setTextSize(paramInt, paramFloat);
    AppMethodBeat.o(105787);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.kiss.widget.textview.SysTextView
 * JD-Core Version:    0.7.0.1
 */