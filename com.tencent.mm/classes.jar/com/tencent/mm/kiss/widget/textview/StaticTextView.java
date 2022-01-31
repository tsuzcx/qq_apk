package com.tencent.mm.kiss.widget.textview;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Point;
import android.text.Layout;
import android.text.Selection;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

public class StaticTextView
  extends View
  implements a
{
  protected g dOk = new g(this, EH());
  
  public StaticTextView(Context paramContext)
  {
    super(paramContext);
    this.dOk.init();
  }
  
  public StaticTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.dOk.init();
  }
  
  public StaticTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.dOk.init();
  }
  
  public com.tencent.mm.kiss.widget.textview.a.a EH()
  {
    return new com.tencent.mm.kiss.widget.textview.a.a();
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
  
  public f getLayoutWrapper()
  {
    if (this.dOk == null) {
      return null;
    }
    return this.dOk.getLayoutWrapper();
  }
  
  public int getLineCount()
  {
    return this.dOk.getLineCount();
  }
  
  public int getLineHeight()
  {
    return this.dOk.getLineHeight();
  }
  
  public int getMaxLines()
  {
    return this.dOk.getMaxLines();
  }
  
  public int getOrientation()
  {
    int i = getResources().getConfiguration().orientation;
    y.i("MicroMsg.StaticTextView", "test test getOrientation " + i);
    return i;
  }
  
  public int getSelectionEnd()
  {
    return this.dOk.getSelectionEnd();
  }
  
  public int getSelectionStart()
  {
    return this.dOk.getSelectionStart();
  }
  
  public CharSequence getText()
  {
    return this.dOk.getText();
  }
  
  public int getTextColor()
  {
    return this.dOk.getTextColor();
  }
  
  public float getTextSize()
  {
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
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.dOk != null) {
      this.dOk.onDraw(paramCanvas);
    }
  }
  
  public void onFinishTemporaryDetach()
  {
    super.onFinishTemporaryDetach();
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    if (paramAccessibilityEvent.getEventType() == 8192)
    {
      paramAccessibilityEvent.setFromIndex(Selection.getSelectionStart(getText()));
      paramAccessibilityEvent.setToIndex(Selection.getSelectionEnd(getText()));
      if (!bk.L(getText())) {
        paramAccessibilityEvent.setItemCount(getText().length());
      }
    }
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    if (!bk.L(getText()))
    {
      paramAccessibilityNodeInfo.addAction(256);
      paramAccessibilityNodeInfo.addAction(512);
      paramAccessibilityNodeInfo.setMovementGranularities(31);
      if (d.gF(18)) {
        paramAccessibilityNodeInfo.addAction(131072);
      }
    }
    if ((isFocused()) && (d.gF(18)))
    {
      paramAccessibilityNodeInfo.addAction(16384);
      paramAccessibilityNodeInfo.addAction(32768);
      paramAccessibilityNodeInfo.addAction(65536);
    }
    if ((d.gF(19)) && (this.dOk.getMaxLines() > 1)) {
      paramAccessibilityNodeInfo.setMultiLine(true);
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.dOk == null)
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    Point localPoint = this.dOk.bf(paramInt1, paramInt2);
    if (localPoint != null)
    {
      setMeasuredDimension(localPoint.x, localPoint.y);
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void onPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onPopulateAccessibilityEvent(paramAccessibilityEvent);
    if (!bk.L(getText())) {
      paramAccessibilityEvent.getText().add(getText());
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
    if (this.dOk != null) {
      this.dOk.dOs = paramBoolean;
    }
  }
  
  public void setConfig(com.tencent.mm.kiss.widget.textview.a.a parama)
  {
    this.dOk.dOm = parama;
  }
  
  public void setGravity(int paramInt)
  {
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
    this.dOk.setLines(paramInt);
  }
  
  public void setMaxLines(int paramInt)
  {
    this.dOk.setMaxLines(paramInt);
  }
  
  public void setMinLines(int paramInt)
  {
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
    this.dOk.setSingleLine(paramBoolean);
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    setText(paramCharSequence, true);
  }
  
  public final void setText(CharSequence paramCharSequence, boolean paramBoolean)
  {
    this.dOk.setText(paramCharSequence, paramBoolean);
    setContentDescription(paramCharSequence);
  }
  
  public void setTextColor(int paramInt)
  {
    this.dOk.setTextColor(paramInt);
  }
  
  public void setTextLayout(f paramf)
  {
    this.dOk.setTextLayout(paramf);
  }
  
  public void setTextSize(float paramFloat)
  {
    this.dOk.setTextSize(0, paramFloat);
  }
  
  public final void setTextSize$255e752(float paramFloat)
  {
    this.dOk.setTextSize(1, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kiss.widget.textview.StaticTextView
 * JD-Core Version:    0.7.0.1
 */