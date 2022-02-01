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
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Field;

public class SysTextView
  extends TextView
  implements a
{
  private static boolean mHl = false;
  private static Field mHm = null;
  private g mGX;
  
  public SysTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(141096);
    this.mGX = new g(this, new com.tencent.mm.kiss.widget.textview.a.a());
    init();
    AppMethodBeat.o(141096);
  }
  
  public SysTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(141097);
    this.mGX = new g(this, new com.tencent.mm.kiss.widget.textview.a.a());
    init();
    AppMethodBeat.o(141097);
  }
  
  private void bbP()
  {
    AppMethodBeat.i(141099);
    if (mHl)
    {
      AppMethodBeat.o(141099);
      return;
    }
    try
    {
      if (mHm == null)
      {
        Field localField = TextView.class.getDeclaredField("mSingleLine");
        mHm = localField;
        localField.setAccessible(true);
      }
      if (mHm.getBoolean(this)) {
        this.mGX.mGZ.maxLines = 1;
      }
      AppMethodBeat.o(141099);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.SysPLTextView", "initSingleLine error: %s", new Object[] { localException.getMessage() });
      mHl = true;
      AppMethodBeat.o(141099);
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(141098);
    super.setText(" ", TextView.BufferType.SPANNABLE);
    this.mGX.mGZ = new com.tencent.mm.kiss.widget.textview.a.a();
    this.mGX.mGZ.textColor = super.getTextColors().getDefaultColor();
    this.mGX.mGZ.bbe = super.getEllipsize();
    this.mGX.mGZ.fl = super.getGravity();
    this.mGX.mGZ.textSize = super.getTextSize();
    bbP();
    AppMethodBeat.o(141098);
  }
  
  public final void N(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(141104);
    if (this.mGX == null)
    {
      super.setText("");
      AppMethodBeat.o(141104);
      return;
    }
    this.mGX.a(paramCharSequence, false);
    AppMethodBeat.o(141104);
  }
  
  public void dispatchProvideStructure(ViewStructure paramViewStructure) {}
  
  public int getBaseline()
  {
    AppMethodBeat.i(141132);
    try
    {
      int i = super.getBaseline();
      AppMethodBeat.o(141132);
      return i;
    }
    finally
    {
      Log.printErrStackTrace("MicroMsg.SysPLTextView", localThrowable, "", new Object[0]);
      AppMethodBeat.o(141132);
    }
    return -1;
  }
  
  public com.tencent.mm.kiss.widget.textview.a.a getConfig()
  {
    if (this.mGX == null) {
      return null;
    }
    return this.mGX.mGZ;
  }
  
  public int getHorizontalDrawOffset()
  {
    if (this.mGX == null) {
      return 0;
    }
    return this.mGX.mHc;
  }
  
  protected f getLayoutWrapper()
  {
    AppMethodBeat.i(141100);
    if (this.mGX == null)
    {
      AppMethodBeat.o(141100);
      return null;
    }
    f localf = this.mGX.getLayoutWrapper();
    AppMethodBeat.o(141100);
    return localf;
  }
  
  public int getLineCount()
  {
    AppMethodBeat.i(141118);
    if (this.mGX == null)
    {
      AppMethodBeat.o(141118);
      return 0;
    }
    int i = this.mGX.getLineCount();
    AppMethodBeat.o(141118);
    return i;
  }
  
  public int getLineHeight()
  {
    AppMethodBeat.i(141119);
    if (this.mGX == null)
    {
      AppMethodBeat.o(141119);
      return 0;
    }
    int i = this.mGX.getLineHeight();
    AppMethodBeat.o(141119);
    return i;
  }
  
  public int getSelectionEnd()
  {
    AppMethodBeat.i(141121);
    if (getText() == null)
    {
      AppMethodBeat.o(141121);
      return -1;
    }
    int i = Selection.getSelectionEnd(getText());
    AppMethodBeat.o(141121);
    return i;
  }
  
  public int getSelectionStart()
  {
    AppMethodBeat.i(141120);
    if (getText() == null)
    {
      AppMethodBeat.o(141120);
      return -1;
    }
    int i = Selection.getSelectionStart(getText());
    AppMethodBeat.o(141120);
    return i;
  }
  
  public CharSequence getText()
  {
    AppMethodBeat.i(141114);
    if (this.mGX == null)
    {
      AppMethodBeat.o(141114);
      return null;
    }
    CharSequence localCharSequence = this.mGX.getText();
    AppMethodBeat.o(141114);
    return localCharSequence;
  }
  
  public int getTextColor()
  {
    AppMethodBeat.i(141116);
    int i = this.mGX.getTextColor();
    AppMethodBeat.o(141116);
    return i;
  }
  
  public float getTextSize()
  {
    AppMethodBeat.i(141115);
    if (this.mGX == null)
    {
      AppMethodBeat.o(141115);
      return 0.0F;
    }
    float f = this.mGX.getTextSize();
    AppMethodBeat.o(141115);
    return f;
  }
  
  public Layout getTvLayout()
  {
    AppMethodBeat.i(141117);
    Layout localLayout = this.mGX.getTvLayout();
    AppMethodBeat.o(141117);
    return localLayout;
  }
  
  public int getVerticalDrawOffset()
  {
    if (this.mGX == null) {
      return 0;
    }
    return this.mGX.mHd;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(141127);
    super.onAttachedToWindow();
    AppMethodBeat.o(141127);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(141128);
    super.onDetachedFromWindow();
    AppMethodBeat.o(141128);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(141125);
    try
    {
      g localg = this.mGX;
      if (localg == null)
      {
        AppMethodBeat.o(141125);
        return;
      }
      this.mGX.onDraw(paramCanvas);
      AppMethodBeat.o(141125);
      return;
    }
    finally
    {
      Log.printErrStackTrace("MicroMsg.SysPLTextView", paramCanvas, "", new Object[0]);
      AppMethodBeat.o(141125);
    }
  }
  
  public void onFinishTemporaryDetach()
  {
    AppMethodBeat.i(141130);
    super.onFinishTemporaryDetach();
    AppMethodBeat.o(141130);
  }
  
  public void onHoverChanged(boolean paramBoolean) {}
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(141126);
    try
    {
      Point localPoint = this.mGX.ed(paramInt1, paramInt2);
      if (localPoint != null)
      {
        setMeasuredDimension(localPoint.x, localPoint.y);
        AppMethodBeat.o(141126);
        return;
      }
      return;
    }
    finally
    {
      try
      {
        super.onMeasure(paramInt1, paramInt2);
        AppMethodBeat.o(141126);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.SysPLTextView", localException, "onMeasure error: %s", new Object[] { localException.getMessage() });
        AppMethodBeat.o(141126);
      }
      localThrowable = finally;
      Log.printErrStackTrace("MicroMsg.SysPLTextView", localThrowable, "", new Object[0]);
      AppMethodBeat.o(141126);
      return;
    }
  }
  
  public boolean onPreDraw()
  {
    return true;
  }
  
  public void onProvideStructure(ViewStructure paramViewStructure)
  {
    AppMethodBeat.i(141131);
    try
    {
      super.onProvideStructure(paramViewStructure);
      AppMethodBeat.o(141131);
      return;
    }
    catch (Exception paramViewStructure)
    {
      Log.printErrStackTrace("MicroMsg.SysPLTextView", paramViewStructure, "onProvideStructure error: %s", new Object[] { paramViewStructure.getMessage() });
      AppMethodBeat.o(141131);
    }
  }
  
  public void onStartTemporaryDetach()
  {
    AppMethodBeat.i(141129);
    super.onStartTemporaryDetach();
    AppMethodBeat.o(141129);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(141123);
    if (getTvLayout() == null)
    {
      AppMethodBeat.o(141123);
      return false;
    }
    boolean bool1 = this.mGX.w(paramMotionEvent);
    boolean bool2 = super.onTouchEvent(paramMotionEvent);
    if (bool1)
    {
      AppMethodBeat.o(141123);
      return true;
    }
    AppMethodBeat.o(141123);
    return bool2;
  }
  
  public boolean performClick()
  {
    AppMethodBeat.i(141124);
    if (this.mGX == null)
    {
      AppMethodBeat.o(141124);
      return false;
    }
    if (!this.mGX.performClick())
    {
      AppMethodBeat.o(141124);
      return false;
    }
    boolean bool = super.performClick();
    AppMethodBeat.o(141124);
    return bool;
  }
  
  public void setClickable(boolean paramBoolean)
  {
    AppMethodBeat.i(141122);
    super.setClickable(paramBoolean);
    if (this.mGX == null)
    {
      AppMethodBeat.o(141122);
      return;
    }
    this.mGX.mHf = paramBoolean;
    AppMethodBeat.o(141122);
  }
  
  public void setGravity(int paramInt)
  {
    AppMethodBeat.i(141109);
    if (this.mGX == null)
    {
      AppMethodBeat.o(141109);
      return;
    }
    this.mGX.setGravity(paramInt);
    AppMethodBeat.o(141109);
  }
  
  public void setHandleClickableSpan(boolean paramBoolean)
  {
    this.mGX.mHg = paramBoolean;
  }
  
  public void setLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(141112);
    if (this.mGX != null) {
      this.mGX.bbO();
    }
    super.setLayoutParams(paramLayoutParams);
    AppMethodBeat.o(141112);
  }
  
  public void setLines(int paramInt)
  {
    AppMethodBeat.i(141102);
    if (this.mGX == null)
    {
      AppMethodBeat.o(141102);
      return;
    }
    this.mGX.setLines(paramInt);
    AppMethodBeat.o(141102);
  }
  
  public void setMaxLines(int paramInt)
  {
    AppMethodBeat.i(141110);
    if (this.mGX == null)
    {
      AppMethodBeat.o(141110);
      return;
    }
    this.mGX.setMaxLines(paramInt);
    AppMethodBeat.o(141110);
  }
  
  public void setMinLines(int paramInt)
  {
    AppMethodBeat.i(141111);
    if (this.mGX == null)
    {
      AppMethodBeat.o(141111);
      return;
    }
    this.mGX.setMinLines(paramInt);
    AppMethodBeat.o(141111);
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(141113);
    if (this.mGX != null) {
      this.mGX.bbO();
    }
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(141113);
  }
  
  public void setSingleLine(boolean paramBoolean)
  {
    AppMethodBeat.i(141101);
    if (this.mGX == null)
    {
      AppMethodBeat.o(141101);
      return;
    }
    this.mGX.setSingleLine(paramBoolean);
    AppMethodBeat.o(141101);
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    AppMethodBeat.i(141103);
    N(paramCharSequence);
    AppMethodBeat.o(141103);
  }
  
  public void setTextColor(int paramInt)
  {
    AppMethodBeat.i(141108);
    if (this.mGX == null)
    {
      AppMethodBeat.o(141108);
      return;
    }
    this.mGX.setTextColor(paramInt);
    AppMethodBeat.o(141108);
  }
  
  public void setTextLayout(f paramf)
  {
    AppMethodBeat.i(141107);
    if (this.mGX == null)
    {
      AppMethodBeat.o(141107);
      return;
    }
    this.mGX.setTextLayout(paramf);
    AppMethodBeat.o(141107);
  }
  
  public void setTextSize(float paramFloat)
  {
    AppMethodBeat.i(141105);
    setTextSize(0, paramFloat);
    AppMethodBeat.o(141105);
  }
  
  public void setTextSize(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(141106);
    if (this.mGX == null)
    {
      AppMethodBeat.o(141106);
      return;
    }
    this.mGX.setTextSize(paramInt, paramFloat);
    AppMethodBeat.o(141106);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.kiss.widget.textview.SysTextView
 * JD-Core Version:    0.7.0.1
 */