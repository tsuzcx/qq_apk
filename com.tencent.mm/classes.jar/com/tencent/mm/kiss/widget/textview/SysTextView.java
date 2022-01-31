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
import com.tencent.mm.sdk.platformtools.y;
import java.lang.reflect.Field;

public class SysTextView
  extends TextView
  implements a
{
  private static boolean dOy = false;
  private static Field dOz = null;
  private g dOk = new g(this, new com.tencent.mm.kiss.widget.textview.a.a());
  
  public SysTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public SysTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    super.setText(" ", TextView.BufferType.SPANNABLE);
    this.dOk.dOm = new com.tencent.mm.kiss.widget.textview.a.a();
    this.dOk.dOm.textColor = super.getTextColors().getDefaultColor();
    this.dOk.dOm.dNY = super.getEllipsize();
    this.dOk.dOm.gravity = super.getGravity();
    this.dOk.dOm.dOB = super.getTextSize();
    if (!dOy) {}
    try
    {
      if (dOz == null)
      {
        Field localField = TextView.class.getDeclaredField("mSingleLine");
        dOz = localField;
        localField.setAccessible(true);
      }
      if (dOz.getBoolean(this)) {
        this.dOk.dOm.maxLines = 1;
      }
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.SysPLTextView", "initSingleLine error: %s", new Object[] { localException.getMessage() });
      dOy = true;
    }
  }
  
  public void dispatchProvideStructure(ViewStructure paramViewStructure) {}
  
  public int getBaseline()
  {
    try
    {
      int i = super.getBaseline();
      return i;
    }
    catch (Throwable localThrowable)
    {
      y.printErrStackTrace("MicroMsg.SysPLTextView", localThrowable, "", new Object[0]);
    }
    return -1;
  }
  
  public com.tencent.mm.kiss.widget.textview.a.a getConfig()
  {
    if (this.dOk == null) {
      return null;
    }
    return this.dOk.dOm;
  }
  
  public int getHorizontalDrawOffset()
  {
    if (this.dOk == null) {
      return 0;
    }
    return this.dOk.dOp;
  }
  
  protected f getLayoutWrapper()
  {
    if (this.dOk == null) {
      return null;
    }
    return this.dOk.getLayoutWrapper();
  }
  
  public int getLineCount()
  {
    if (this.dOk == null) {
      return 0;
    }
    return this.dOk.getLineCount();
  }
  
  public int getLineHeight()
  {
    if (this.dOk == null) {
      return 0;
    }
    return this.dOk.getLineHeight();
  }
  
  public int getSelectionEnd()
  {
    if (getText() == null) {
      return -1;
    }
    return Selection.getSelectionEnd(getText());
  }
  
  public int getSelectionStart()
  {
    if (getText() == null) {
      return -1;
    }
    return Selection.getSelectionStart(getText());
  }
  
  public CharSequence getText()
  {
    if (this.dOk == null) {
      return null;
    }
    return this.dOk.getText();
  }
  
  public int getTextColor()
  {
    return this.dOk.getTextColor();
  }
  
  public float getTextSize()
  {
    if (this.dOk == null) {
      return 0.0F;
    }
    return this.dOk.getTextSize();
  }
  
  public Layout getTvLayout()
  {
    return this.dOk.getTvLayout();
  }
  
  public int getVerticalDrawOffset()
  {
    if (this.dOk == null) {
      return 0;
    }
    return this.dOk.dOq;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    try
    {
      if (this.dOk == null) {
        return;
      }
      this.dOk.onDraw(paramCanvas);
      return;
    }
    catch (Throwable paramCanvas)
    {
      y.printErrStackTrace("MicroMsg.SysPLTextView", paramCanvas, "", new Object[0]);
    }
  }
  
  public void onFinishTemporaryDetach()
  {
    super.onFinishTemporaryDetach();
  }
  
  public void onHoverChanged(boolean paramBoolean) {}
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    try
    {
      Point localPoint = this.dOk.bf(paramInt1, paramInt2);
      if (localPoint != null)
      {
        setMeasuredDimension(localPoint.x, localPoint.y);
        return;
      }
      try
      {
        super.onMeasure(paramInt1, paramInt2);
        return;
      }
      catch (Exception localException)
      {
        y.printErrStackTrace("MicroMsg.SysPLTextView", localException, "onMeasure error: %s", new Object[] { localException.getMessage() });
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      y.printErrStackTrace("MicroMsg.SysPLTextView", localThrowable, "", new Object[0]);
    }
  }
  
  public boolean onPreDraw()
  {
    return true;
  }
  
  public void onProvideStructure(ViewStructure paramViewStructure)
  {
    try
    {
      super.onProvideStructure(paramViewStructure);
      return;
    }
    catch (Exception paramViewStructure)
    {
      y.printErrStackTrace("MicroMsg.SysPLTextView", paramViewStructure, "onProvideStructure error: %s", new Object[] { paramViewStructure.getMessage() });
    }
  }
  
  public void onStartTemporaryDetach()
  {
    super.onStartTemporaryDetach();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1;
    if (getTvLayout() == null) {
      bool1 = false;
    }
    boolean bool2;
    do
    {
      return bool1;
      bool2 = this.dOk.r(paramMotionEvent);
      bool1 = super.onTouchEvent(paramMotionEvent);
    } while (!bool2);
    return true;
  }
  
  public boolean performClick()
  {
    if (this.dOk == null) {}
    while (!this.dOk.performClick()) {
      return false;
    }
    return super.performClick();
  }
  
  public void setClickable(boolean paramBoolean)
  {
    super.setClickable(paramBoolean);
    if (this.dOk == null) {
      return;
    }
    this.dOk.dOs = paramBoolean;
  }
  
  public void setGravity(int paramInt)
  {
    if (this.dOk == null) {
      return;
    }
    this.dOk.setGravity(paramInt);
  }
  
  public void setHandleClickableSpan(boolean paramBoolean)
  {
    this.dOk.dOt = paramBoolean;
  }
  
  public void setLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if (this.dOk != null) {
      this.dOk.EI();
    }
    super.setLayoutParams(paramLayoutParams);
  }
  
  public void setLines(int paramInt)
  {
    if (this.dOk == null) {
      return;
    }
    this.dOk.setLines(paramInt);
  }
  
  public void setMaxLines(int paramInt)
  {
    if (this.dOk == null) {
      return;
    }
    this.dOk.setMaxLines(paramInt);
  }
  
  public void setMinLines(int paramInt)
  {
    if (this.dOk == null) {
      return;
    }
    this.dOk.setMinLines(paramInt);
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.dOk != null) {
      this.dOk.EI();
    }
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setSingleLine(boolean paramBoolean)
  {
    if (this.dOk == null) {
      return;
    }
    this.dOk.setSingleLine(paramBoolean);
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    setText$609c24db(paramCharSequence);
  }
  
  public final void setText$609c24db(CharSequence paramCharSequence)
  {
    if (this.dOk == null)
    {
      super.setText("");
      return;
    }
    this.dOk.setText(paramCharSequence, false);
  }
  
  public void setTextColor(int paramInt)
  {
    if (this.dOk == null) {
      return;
    }
    this.dOk.setTextColor(paramInt);
  }
  
  public void setTextLayout(f paramf)
  {
    if (this.dOk == null) {
      return;
    }
    this.dOk.setTextLayout(paramf);
  }
  
  public void setTextSize(float paramFloat)
  {
    setTextSize(0, paramFloat);
  }
  
  public void setTextSize(int paramInt, float paramFloat)
  {
    if (this.dOk == null) {
      return;
    }
    this.dOk.setTextSize(paramInt, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kiss.widget.textview.SysTextView
 * JD-Core Version:    0.7.0.1
 */