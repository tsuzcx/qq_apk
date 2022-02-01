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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.List;

public class StaticTextView
  extends View
  implements a
{
  protected g gHU;
  
  public StaticTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(141034);
    this.gHU = new g(this, akW());
    this.gHU.init();
    AppMethodBeat.o(141034);
  }
  
  public StaticTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(141035);
    this.gHU = new g(this, akW());
    this.gHU.init();
    AppMethodBeat.o(141035);
  }
  
  protected com.tencent.mm.kiss.widget.textview.a.a akW()
  {
    AppMethodBeat.i(141036);
    com.tencent.mm.kiss.widget.textview.a.a locala = new com.tencent.mm.kiss.widget.textview.a.a();
    AppMethodBeat.o(141036);
    return locala;
  }
  
  public com.tencent.mm.kiss.widget.textview.a.a getConfig()
  {
    if (this.gHU == null) {
      return null;
    }
    return this.gHU.gHW;
  }
  
  public int getHorizontalDrawOffset()
  {
    if (this.gHU == null) {
      return 0;
    }
    return this.gHU.gHZ;
  }
  
  public f getLayoutWrapper()
  {
    AppMethodBeat.i(141055);
    if (this.gHU == null)
    {
      AppMethodBeat.o(141055);
      return null;
    }
    f localf = this.gHU.getLayoutWrapper();
    AppMethodBeat.o(141055);
    return localf;
  }
  
  public int getLineCount()
  {
    AppMethodBeat.i(141056);
    int i = this.gHU.getLineCount();
    AppMethodBeat.o(141056);
    return i;
  }
  
  public int getLineHeight()
  {
    AppMethodBeat.i(141057);
    int i = this.gHU.getLineHeight();
    AppMethodBeat.o(141057);
    return i;
  }
  
  public int getMaxLines()
  {
    AppMethodBeat.i(141043);
    int i = this.gHU.getMaxLines();
    AppMethodBeat.o(141043);
    return i;
  }
  
  public int getOrientation()
  {
    AppMethodBeat.i(141069);
    int i = getResources().getConfiguration().orientation;
    ae.i("MicroMsg.StaticTextView", "test test getOrientation ".concat(String.valueOf(i)));
    AppMethodBeat.o(141069);
    return i;
  }
  
  public int getSelectionEnd()
  {
    AppMethodBeat.i(141059);
    int i = this.gHU.getSelectionEnd();
    AppMethodBeat.o(141059);
    return i;
  }
  
  public int getSelectionStart()
  {
    AppMethodBeat.i(141058);
    int i = this.gHU.getSelectionStart();
    AppMethodBeat.o(141058);
    return i;
  }
  
  public CharSequence getText()
  {
    AppMethodBeat.i(141051);
    CharSequence localCharSequence = this.gHU.getText();
    AppMethodBeat.o(141051);
    return localCharSequence;
  }
  
  public int getTextColor()
  {
    AppMethodBeat.i(141053);
    int i = this.gHU.getTextColor();
    AppMethodBeat.o(141053);
    return i;
  }
  
  public float getTextSize()
  {
    AppMethodBeat.i(141052);
    float f = this.gHU.getTextSize();
    AppMethodBeat.o(141052);
    return f;
  }
  
  public Layout getTvLayout()
  {
    AppMethodBeat.i(141054);
    Layout localLayout = this.gHU.getTvLayout();
    AppMethodBeat.o(141054);
    return localLayout;
  }
  
  public int getVerticalDrawOffset()
  {
    if (this.gHU == null) {
      return 0;
    }
    return this.gHU.gIa;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(141065);
    super.onAttachedToWindow();
    AppMethodBeat.o(141065);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(141070);
    super.onConfigurationChanged(paramConfiguration);
    AppMethodBeat.o(141070);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(141066);
    super.onDetachedFromWindow();
    AppMethodBeat.o(141066);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(141063);
    super.onDraw(paramCanvas);
    if (this.gHU != null) {
      this.gHU.onDraw(paramCanvas);
    }
    AppMethodBeat.o(141063);
  }
  
  public void onFinishTemporaryDetach()
  {
    AppMethodBeat.i(141068);
    super.onFinishTemporaryDetach();
    AppMethodBeat.o(141068);
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(141073);
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    if (paramAccessibilityEvent.getEventType() == 8192)
    {
      paramAccessibilityEvent.setFromIndex(Selection.getSelectionStart(getText()));
      paramAccessibilityEvent.setToIndex(Selection.getSelectionEnd(getText()));
      if (!bu.ah(getText())) {
        paramAccessibilityEvent.setItemCount(getText().length());
      }
    }
    AppMethodBeat.o(141073);
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    AppMethodBeat.i(141072);
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    if (!bu.ah(getText()))
    {
      paramAccessibilityNodeInfo.addAction(256);
      paramAccessibilityNodeInfo.addAction(512);
      paramAccessibilityNodeInfo.setMovementGranularities(31);
      if (d.lA(18)) {
        paramAccessibilityNodeInfo.addAction(131072);
      }
    }
    if ((isFocused()) && (d.lA(18)))
    {
      paramAccessibilityNodeInfo.addAction(16384);
      paramAccessibilityNodeInfo.addAction(32768);
      paramAccessibilityNodeInfo.addAction(65536);
    }
    if ((d.lA(19)) && (this.gHU.getMaxLines() > 1)) {
      paramAccessibilityNodeInfo.setMultiLine(true);
    }
    AppMethodBeat.o(141072);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(141064);
    if (this.gHU == null)
    {
      super.onMeasure(paramInt1, paramInt2);
      AppMethodBeat.o(141064);
      return;
    }
    Point localPoint = this.gHU.cP(paramInt1, paramInt2);
    if (localPoint != null)
    {
      setMeasuredDimension(localPoint.x, localPoint.y);
      AppMethodBeat.o(141064);
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(141064);
  }
  
  public void onPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(141071);
    super.onPopulateAccessibilityEvent(paramAccessibilityEvent);
    if (!bu.ah(getText())) {
      paramAccessibilityEvent.getText().add(getText());
    }
    AppMethodBeat.o(141071);
  }
  
  public void onStartTemporaryDetach()
  {
    AppMethodBeat.i(141067);
    super.onStartTemporaryDetach();
    AppMethodBeat.o(141067);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(141061);
    if (getTvLayout() == null)
    {
      AppMethodBeat.o(141061);
      return false;
    }
    boolean bool1 = this.gHU.s(paramMotionEvent);
    boolean bool2 = super.onTouchEvent(paramMotionEvent);
    if (bool1)
    {
      AppMethodBeat.o(141061);
      return true;
    }
    AppMethodBeat.o(141061);
    return bool2;
  }
  
  public boolean performClick()
  {
    AppMethodBeat.i(141062);
    if (this.gHU == null)
    {
      AppMethodBeat.o(141062);
      return false;
    }
    if (!this.gHU.performClick())
    {
      AppMethodBeat.o(141062);
      return false;
    }
    boolean bool = super.performClick();
    AppMethodBeat.o(141062);
    return bool;
  }
  
  public void setClickable(boolean paramBoolean)
  {
    AppMethodBeat.i(141060);
    super.setClickable(paramBoolean);
    if (this.gHU != null) {
      this.gHU.gIc = paramBoolean;
    }
    AppMethodBeat.o(141060);
  }
  
  protected void setConfig(com.tencent.mm.kiss.widget.textview.a.a parama)
  {
    this.gHU.gHW = parama;
  }
  
  public void setGravity(int paramInt)
  {
    AppMethodBeat.i(141041);
    this.gHU.setGravity(paramInt);
    AppMethodBeat.o(141041);
  }
  
  public void setHandleClickableSpan(boolean paramBoolean)
  {
    this.gHU.gId = paramBoolean;
  }
  
  public void setLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(141049);
    if (this.gHU != null) {
      this.gHU.akX();
    }
    super.setLayoutParams(paramLayoutParams);
    AppMethodBeat.o(141049);
  }
  
  public void setLines(int paramInt)
  {
    AppMethodBeat.i(141045);
    this.gHU.setLines(paramInt);
    AppMethodBeat.o(141045);
  }
  
  public void setMaxLines(int paramInt)
  {
    AppMethodBeat.i(141042);
    this.gHU.setMaxLines(paramInt);
    AppMethodBeat.o(141042);
  }
  
  public void setMinLines(int paramInt)
  {
    AppMethodBeat.i(141044);
    this.gHU.setMinLines(paramInt);
    AppMethodBeat.o(141044);
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(141050);
    if (this.gHU != null) {
      this.gHU.akX();
    }
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(141050);
  }
  
  public void setSingleLine(boolean paramBoolean)
  {
    AppMethodBeat.i(141046);
    this.gHU.setSingleLine(paramBoolean);
    AppMethodBeat.o(141046);
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(141048);
    setText(paramCharSequence, true);
    AppMethodBeat.o(141048);
  }
  
  public final void setText(CharSequence paramCharSequence, boolean paramBoolean)
  {
    AppMethodBeat.i(141047);
    this.gHU.setText(paramCharSequence, paramBoolean);
    setContentDescription(paramCharSequence);
    AppMethodBeat.o(141047);
  }
  
  public void setTextColor(int paramInt)
  {
    AppMethodBeat.i(141040);
    this.gHU.setTextColor(paramInt);
    AppMethodBeat.o(141040);
  }
  
  public void setTextLayout(f paramf)
  {
    AppMethodBeat.i(141039);
    this.gHU.setTextLayout(paramf);
    AppMethodBeat.o(141039);
  }
  
  public void setTextSize(float paramFloat)
  {
    AppMethodBeat.i(141037);
    this.gHU.setTextSize(0, paramFloat);
    AppMethodBeat.o(141037);
  }
  
  public final void setTextSize$255e752(float paramFloat)
  {
    AppMethodBeat.i(141038);
    this.gHU.setTextSize(1, paramFloat);
    AppMethodBeat.o(141038);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.kiss.widget.textview.StaticTextView
 * JD-Core Version:    0.7.0.1
 */