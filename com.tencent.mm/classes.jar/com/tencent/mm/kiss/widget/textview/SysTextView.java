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
import com.tencent.mm.sdk.platformtools.ac;
import java.lang.reflect.Field;

public class SysTextView
  extends TextView
  implements a
{
  private static boolean glR = false;
  private static Field glS = null;
  private g glD;
  
  public SysTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(141096);
    this.glD = new g(this, new com.tencent.mm.kiss.widget.textview.a.a());
    init();
    AppMethodBeat.o(141096);
  }
  
  public SysTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(141097);
    this.glD = new g(this, new com.tencent.mm.kiss.widget.textview.a.a());
    init();
    AppMethodBeat.o(141097);
  }
  
  private void ahY()
  {
    AppMethodBeat.i(141099);
    if (glR)
    {
      AppMethodBeat.o(141099);
      return;
    }
    try
    {
      if (glS == null)
      {
        Field localField = TextView.class.getDeclaredField("mSingleLine");
        glS = localField;
        localField.setAccessible(true);
      }
      if (glS.getBoolean(this)) {
        this.glD.glF.maxLines = 1;
      }
      AppMethodBeat.o(141099);
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.SysPLTextView", "initSingleLine error: %s", new Object[] { localException.getMessage() });
      glR = true;
      AppMethodBeat.o(141099);
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(141098);
    super.setText(" ", TextView.BufferType.SPANNABLE);
    this.glD.glF = new com.tencent.mm.kiss.widget.textview.a.a();
    this.glD.glF.textColor = super.getTextColors().getDefaultColor();
    this.glD.glF.gls = super.getEllipsize();
    this.glD.glF.gravity = super.getGravity();
    this.glD.glF.textSize = super.getTextSize();
    ahY();
    AppMethodBeat.o(141098);
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
    catch (Throwable localThrowable)
    {
      ac.printErrStackTrace("MicroMsg.SysPLTextView", localThrowable, "", new Object[0]);
      AppMethodBeat.o(141132);
    }
    return -1;
  }
  
  public com.tencent.mm.kiss.widget.textview.a.a getConfig()
  {
    if (this.glD == null) {
      return null;
    }
    return this.glD.glF;
  }
  
  public int getHorizontalDrawOffset()
  {
    if (this.glD == null) {
      return 0;
    }
    return this.glD.glI;
  }
  
  protected f getLayoutWrapper()
  {
    AppMethodBeat.i(141100);
    if (this.glD == null)
    {
      AppMethodBeat.o(141100);
      return null;
    }
    f localf = this.glD.getLayoutWrapper();
    AppMethodBeat.o(141100);
    return localf;
  }
  
  public int getLineCount()
  {
    AppMethodBeat.i(141118);
    if (this.glD == null)
    {
      AppMethodBeat.o(141118);
      return 0;
    }
    int i = this.glD.getLineCount();
    AppMethodBeat.o(141118);
    return i;
  }
  
  public int getLineHeight()
  {
    AppMethodBeat.i(141119);
    if (this.glD == null)
    {
      AppMethodBeat.o(141119);
      return 0;
    }
    int i = this.glD.getLineHeight();
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
    if (this.glD == null)
    {
      AppMethodBeat.o(141114);
      return null;
    }
    CharSequence localCharSequence = this.glD.getText();
    AppMethodBeat.o(141114);
    return localCharSequence;
  }
  
  public int getTextColor()
  {
    AppMethodBeat.i(141116);
    int i = this.glD.getTextColor();
    AppMethodBeat.o(141116);
    return i;
  }
  
  public float getTextSize()
  {
    AppMethodBeat.i(141115);
    if (this.glD == null)
    {
      AppMethodBeat.o(141115);
      return 0.0F;
    }
    float f = this.glD.getTextSize();
    AppMethodBeat.o(141115);
    return f;
  }
  
  public Layout getTvLayout()
  {
    AppMethodBeat.i(141117);
    Layout localLayout = this.glD.getTvLayout();
    AppMethodBeat.o(141117);
    return localLayout;
  }
  
  public int getVerticalDrawOffset()
  {
    if (this.glD == null) {
      return 0;
    }
    return this.glD.glJ;
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
      g localg = this.glD;
      if (localg == null)
      {
        AppMethodBeat.o(141125);
        return;
      }
      this.glD.onDraw(paramCanvas);
      AppMethodBeat.o(141125);
      return;
    }
    catch (Throwable paramCanvas)
    {
      ac.printErrStackTrace("MicroMsg.SysPLTextView", paramCanvas, "", new Object[0]);
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
      Point localPoint = this.glD.cN(paramInt1, paramInt2);
      if (localPoint != null)
      {
        setMeasuredDimension(localPoint.x, localPoint.y);
        AppMethodBeat.o(141126);
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      try
      {
        super.onMeasure(paramInt1, paramInt2);
        AppMethodBeat.o(141126);
        return;
      }
      catch (Exception localException)
      {
        ac.printErrStackTrace("MicroMsg.SysPLTextView", localException, "onMeasure error: %s", new Object[] { localException.getMessage() });
        AppMethodBeat.o(141126);
      }
      localThrowable = localThrowable;
      ac.printErrStackTrace("MicroMsg.SysPLTextView", localThrowable, "", new Object[0]);
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
      ac.printErrStackTrace("MicroMsg.SysPLTextView", paramViewStructure, "onProvideStructure error: %s", new Object[] { paramViewStructure.getMessage() });
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
    boolean bool1 = this.glD.s(paramMotionEvent);
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
    if (this.glD == null)
    {
      AppMethodBeat.o(141124);
      return false;
    }
    if (!this.glD.performClick())
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
    if (this.glD == null)
    {
      AppMethodBeat.o(141122);
      return;
    }
    this.glD.glL = paramBoolean;
    AppMethodBeat.o(141122);
  }
  
  public void setGravity(int paramInt)
  {
    AppMethodBeat.i(141109);
    if (this.glD == null)
    {
      AppMethodBeat.o(141109);
      return;
    }
    this.glD.setGravity(paramInt);
    AppMethodBeat.o(141109);
  }
  
  public void setHandleClickableSpan(boolean paramBoolean)
  {
    this.glD.glM = paramBoolean;
  }
  
  public void setLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(141112);
    if (this.glD != null) {
      this.glD.ahX();
    }
    super.setLayoutParams(paramLayoutParams);
    AppMethodBeat.o(141112);
  }
  
  public void setLines(int paramInt)
  {
    AppMethodBeat.i(141102);
    if (this.glD == null)
    {
      AppMethodBeat.o(141102);
      return;
    }
    this.glD.setLines(paramInt);
    AppMethodBeat.o(141102);
  }
  
  public void setMaxLines(int paramInt)
  {
    AppMethodBeat.i(141110);
    if (this.glD == null)
    {
      AppMethodBeat.o(141110);
      return;
    }
    this.glD.setMaxLines(paramInt);
    AppMethodBeat.o(141110);
  }
  
  public void setMinLines(int paramInt)
  {
    AppMethodBeat.i(141111);
    if (this.glD == null)
    {
      AppMethodBeat.o(141111);
      return;
    }
    this.glD.setMinLines(paramInt);
    AppMethodBeat.o(141111);
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(141113);
    if (this.glD != null) {
      this.glD.ahX();
    }
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(141113);
  }
  
  public void setSingleLine(boolean paramBoolean)
  {
    AppMethodBeat.i(141101);
    if (this.glD == null)
    {
      AppMethodBeat.o(141101);
      return;
    }
    this.glD.setSingleLine(paramBoolean);
    AppMethodBeat.o(141101);
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    AppMethodBeat.i(141103);
    setText$609c24db(paramCharSequence);
    AppMethodBeat.o(141103);
  }
  
  public final void setText$609c24db(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(141104);
    if (this.glD == null)
    {
      super.setText("");
      AppMethodBeat.o(141104);
      return;
    }
    this.glD.setText(paramCharSequence, false);
    AppMethodBeat.o(141104);
  }
  
  public void setTextColor(int paramInt)
  {
    AppMethodBeat.i(141108);
    if (this.glD == null)
    {
      AppMethodBeat.o(141108);
      return;
    }
    this.glD.setTextColor(paramInt);
    AppMethodBeat.o(141108);
  }
  
  public void setTextLayout(f paramf)
  {
    AppMethodBeat.i(141107);
    if (this.glD == null)
    {
      AppMethodBeat.o(141107);
      return;
    }
    this.glD.setTextLayout(paramf);
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
    if (this.glD == null)
    {
      AppMethodBeat.o(141106);
      return;
    }
    this.glD.setTextSize(paramInt, paramFloat);
    AppMethodBeat.o(141106);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.kiss.widget.textview.SysTextView
 * JD-Core Version:    0.7.0.1
 */