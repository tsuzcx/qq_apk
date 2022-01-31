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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

public class StaticTextView
  extends View
  implements a
{
  protected g eLS;
  
  public StaticTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(105716);
    this.eLS = new g(this, SM());
    this.eLS.init();
    AppMethodBeat.o(105716);
  }
  
  public StaticTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(105717);
    this.eLS = new g(this, SM());
    this.eLS.init();
    AppMethodBeat.o(105717);
  }
  
  protected com.tencent.mm.kiss.widget.textview.a.a SM()
  {
    AppMethodBeat.i(105718);
    com.tencent.mm.kiss.widget.textview.a.a locala = new com.tencent.mm.kiss.widget.textview.a.a();
    AppMethodBeat.o(105718);
    return locala;
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
  
  public f getLayoutWrapper()
  {
    AppMethodBeat.i(105737);
    if (this.eLS == null)
    {
      AppMethodBeat.o(105737);
      return null;
    }
    f localf = this.eLS.getLayoutWrapper();
    AppMethodBeat.o(105737);
    return localf;
  }
  
  public int getLineCount()
  {
    AppMethodBeat.i(105738);
    int i = this.eLS.getLineCount();
    AppMethodBeat.o(105738);
    return i;
  }
  
  public int getLineHeight()
  {
    AppMethodBeat.i(105739);
    int i = this.eLS.getLineHeight();
    AppMethodBeat.o(105739);
    return i;
  }
  
  public int getMaxLines()
  {
    AppMethodBeat.i(105725);
    int i = this.eLS.getMaxLines();
    AppMethodBeat.o(105725);
    return i;
  }
  
  public int getOrientation()
  {
    AppMethodBeat.i(105751);
    int i = getResources().getConfiguration().orientation;
    ab.i("MicroMsg.StaticTextView", "test test getOrientation ".concat(String.valueOf(i)));
    AppMethodBeat.o(105751);
    return i;
  }
  
  public int getSelectionEnd()
  {
    AppMethodBeat.i(105741);
    int i = this.eLS.getSelectionEnd();
    AppMethodBeat.o(105741);
    return i;
  }
  
  public int getSelectionStart()
  {
    AppMethodBeat.i(105740);
    int i = this.eLS.getSelectionStart();
    AppMethodBeat.o(105740);
    return i;
  }
  
  public CharSequence getText()
  {
    AppMethodBeat.i(105733);
    CharSequence localCharSequence = this.eLS.getText();
    AppMethodBeat.o(105733);
    return localCharSequence;
  }
  
  public int getTextColor()
  {
    AppMethodBeat.i(105735);
    int i = this.eLS.getTextColor();
    AppMethodBeat.o(105735);
    return i;
  }
  
  public float getTextSize()
  {
    AppMethodBeat.i(105734);
    float f = this.eLS.getTextSize();
    AppMethodBeat.o(105734);
    return f;
  }
  
  public Layout getTvLayout()
  {
    AppMethodBeat.i(105736);
    Layout localLayout = this.eLS.getTvLayout();
    AppMethodBeat.o(105736);
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
    AppMethodBeat.i(105747);
    super.onAttachedToWindow();
    AppMethodBeat.o(105747);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(105752);
    super.onConfigurationChanged(paramConfiguration);
    AppMethodBeat.o(105752);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(105748);
    super.onDetachedFromWindow();
    AppMethodBeat.o(105748);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(105745);
    super.onDraw(paramCanvas);
    if (this.eLS != null) {
      this.eLS.onDraw(paramCanvas);
    }
    AppMethodBeat.o(105745);
  }
  
  public void onFinishTemporaryDetach()
  {
    AppMethodBeat.i(105750);
    super.onFinishTemporaryDetach();
    AppMethodBeat.o(105750);
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(105755);
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    if (paramAccessibilityEvent.getEventType() == 8192)
    {
      paramAccessibilityEvent.setFromIndex(Selection.getSelectionStart(getText()));
      paramAccessibilityEvent.setToIndex(Selection.getSelectionEnd(getText()));
      if (!bo.aa(getText())) {
        paramAccessibilityEvent.setItemCount(getText().length());
      }
    }
    AppMethodBeat.o(105755);
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    AppMethodBeat.i(105754);
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    if (!bo.aa(getText()))
    {
      paramAccessibilityNodeInfo.addAction(256);
      paramAccessibilityNodeInfo.addAction(512);
      paramAccessibilityNodeInfo.setMovementGranularities(31);
      if (d.fv(18)) {
        paramAccessibilityNodeInfo.addAction(131072);
      }
    }
    if ((isFocused()) && (d.fv(18)))
    {
      paramAccessibilityNodeInfo.addAction(16384);
      paramAccessibilityNodeInfo.addAction(32768);
      paramAccessibilityNodeInfo.addAction(65536);
    }
    if ((d.fv(19)) && (this.eLS.getMaxLines() > 1)) {
      paramAccessibilityNodeInfo.setMultiLine(true);
    }
    AppMethodBeat.o(105754);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(105746);
    if (this.eLS == null)
    {
      super.onMeasure(paramInt1, paramInt2);
      AppMethodBeat.o(105746);
      return;
    }
    Point localPoint = this.eLS.cj(paramInt1, paramInt2);
    if (localPoint != null)
    {
      setMeasuredDimension(localPoint.x, localPoint.y);
      AppMethodBeat.o(105746);
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(105746);
  }
  
  public void onPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(105753);
    super.onPopulateAccessibilityEvent(paramAccessibilityEvent);
    if (!bo.aa(getText())) {
      paramAccessibilityEvent.getText().add(getText());
    }
    AppMethodBeat.o(105753);
  }
  
  public void onStartTemporaryDetach()
  {
    AppMethodBeat.i(105749);
    super.onStartTemporaryDetach();
    AppMethodBeat.o(105749);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(105743);
    if (getTvLayout() == null)
    {
      AppMethodBeat.o(105743);
      return false;
    }
    boolean bool1 = this.eLS.t(paramMotionEvent);
    boolean bool2 = super.onTouchEvent(paramMotionEvent);
    if (bool1)
    {
      AppMethodBeat.o(105743);
      return true;
    }
    AppMethodBeat.o(105743);
    return bool2;
  }
  
  public boolean performClick()
  {
    AppMethodBeat.i(105744);
    if (this.eLS == null)
    {
      AppMethodBeat.o(105744);
      return false;
    }
    if (!this.eLS.performClick())
    {
      AppMethodBeat.o(105744);
      return false;
    }
    boolean bool = super.performClick();
    AppMethodBeat.o(105744);
    return bool;
  }
  
  public void setClickable(boolean paramBoolean)
  {
    AppMethodBeat.i(105742);
    super.setClickable(paramBoolean);
    if (this.eLS != null) {
      this.eLS.eMa = paramBoolean;
    }
    AppMethodBeat.o(105742);
  }
  
  protected void setConfig(com.tencent.mm.kiss.widget.textview.a.a parama)
  {
    this.eLS.eLU = parama;
  }
  
  public void setGravity(int paramInt)
  {
    AppMethodBeat.i(105723);
    this.eLS.setGravity(paramInt);
    AppMethodBeat.o(105723);
  }
  
  public void setHandleClickableSpan(boolean paramBoolean)
  {
    this.eLS.eMb = paramBoolean;
  }
  
  public void setLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(105731);
    if (this.eLS != null) {
      this.eLS.SN();
    }
    super.setLayoutParams(paramLayoutParams);
    AppMethodBeat.o(105731);
  }
  
  public void setLines(int paramInt)
  {
    AppMethodBeat.i(105727);
    this.eLS.setLines(paramInt);
    AppMethodBeat.o(105727);
  }
  
  public void setMaxLines(int paramInt)
  {
    AppMethodBeat.i(105724);
    this.eLS.setMaxLines(paramInt);
    AppMethodBeat.o(105724);
  }
  
  public void setMinLines(int paramInt)
  {
    AppMethodBeat.i(105726);
    this.eLS.setMinLines(paramInt);
    AppMethodBeat.o(105726);
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(105732);
    if (this.eLS != null) {
      this.eLS.SN();
    }
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(105732);
  }
  
  public void setSingleLine(boolean paramBoolean)
  {
    AppMethodBeat.i(105728);
    this.eLS.setSingleLine(paramBoolean);
    AppMethodBeat.o(105728);
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(105730);
    setText(paramCharSequence, true);
    AppMethodBeat.o(105730);
  }
  
  public final void setText(CharSequence paramCharSequence, boolean paramBoolean)
  {
    AppMethodBeat.i(105729);
    this.eLS.setText(paramCharSequence, paramBoolean);
    setContentDescription(paramCharSequence);
    AppMethodBeat.o(105729);
  }
  
  public void setTextColor(int paramInt)
  {
    AppMethodBeat.i(105722);
    this.eLS.setTextColor(paramInt);
    AppMethodBeat.o(105722);
  }
  
  public void setTextLayout(f paramf)
  {
    AppMethodBeat.i(105721);
    this.eLS.setTextLayout(paramf);
    AppMethodBeat.o(105721);
  }
  
  public void setTextSize(float paramFloat)
  {
    AppMethodBeat.i(105719);
    this.eLS.setTextSize(0, paramFloat);
    AppMethodBeat.o(105719);
  }
  
  public final void setTextSize$255e752(float paramFloat)
  {
    AppMethodBeat.i(105720);
    this.eLS.setTextSize(1, paramFloat);
    AppMethodBeat.o(105720);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.kiss.widget.textview.StaticTextView
 * JD-Core Version:    0.7.0.1
 */