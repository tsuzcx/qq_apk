package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.d.c;
import android.support.v4.d.c.a;
import android.support.v4.view.s;
import android.support.v4.widget.b;
import android.support.v4.widget.q;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.ActionMode.Callback;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class AppCompatTextView
  extends TextView
  implements s, b
{
  private final e ahY = new e(this);
  private final l ahZ;
  private Future<c> ajr;
  
  public AppCompatTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AppCompatTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842884);
  }
  
  public AppCompatTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(aw.ac(paramContext), paramAttributeSet, paramInt);
    this.ahY.a(paramAttributeSet, paramInt);
    this.ahZ = new l(this);
    this.ahZ.a(paramAttributeSet, paramInt);
    this.ahZ.iP();
  }
  
  private void iR()
  {
    if (this.ajr != null) {}
    try
    {
      Future localFuture = this.ajr;
      this.ajr = null;
      q.a(this, (c)localFuture.get());
      return;
    }
    catch (InterruptedException localInterruptedException) {}catch (ExecutionException localExecutionException) {}
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (this.ahY != null) {
      this.ahY.iH();
    }
    if (this.ahZ != null) {
      this.ahZ.iP();
    }
  }
  
  public int getAutoSizeMaxTextSize()
  {
    if (QA) {
      return super.getAutoSizeMaxTextSize();
    }
    if (this.ahZ != null) {
      return Math.round(this.ahZ.ajm.ajy);
    }
    return -1;
  }
  
  public int getAutoSizeMinTextSize()
  {
    if (QA) {
      return super.getAutoSizeMinTextSize();
    }
    if (this.ahZ != null) {
      return Math.round(this.ahZ.ajm.ajx);
    }
    return -1;
  }
  
  public int getAutoSizeStepGranularity()
  {
    if (QA) {
      return super.getAutoSizeStepGranularity();
    }
    if (this.ahZ != null) {
      return Math.round(this.ahZ.ajm.ajw);
    }
    return -1;
  }
  
  public int[] getAutoSizeTextAvailableSizes()
  {
    if (QA) {
      return super.getAutoSizeTextAvailableSizes();
    }
    if (this.ahZ != null) {
      return this.ahZ.ajm.ajz;
    }
    return new int[0];
  }
  
  public int getAutoSizeTextType()
  {
    if (QA)
    {
      if (super.getAutoSizeTextType() == 1) {
        return 1;
      }
      return 0;
    }
    if (this.ahZ != null) {
      return this.ahZ.ajm.aju;
    }
    return 0;
  }
  
  public int getFirstBaselineToTopHeight()
  {
    return getPaddingTop() - getPaint().getFontMetricsInt().top;
  }
  
  public int getLastBaselineToBottomHeight()
  {
    return getPaddingBottom() + getPaint().getFontMetricsInt().bottom;
  }
  
  public ColorStateList getSupportBackgroundTintList()
  {
    if (this.ahY != null) {
      return this.ahY.getSupportBackgroundTintList();
    }
    return null;
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    if (this.ahY != null) {
      return this.ahY.getSupportBackgroundTintMode();
    }
    return null;
  }
  
  public CharSequence getText()
  {
    iR();
    return super.getText();
  }
  
  public c.a getTextMetricsParamsCompat()
  {
    return q.d(this);
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    return h.a(super.onCreateInputConnection(paramEditorInfo), paramEditorInfo, this);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.ahZ != null) {
      this.ahZ.iQ();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    iR();
    super.onMeasure(paramInt1, paramInt2);
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    if ((this.ahZ != null) && (!QA) && (this.ahZ.ajm.iW())) {
      this.ahZ.ajm.iU();
    }
  }
  
  public void setAutoSizeTextTypeUniformWithConfiguration(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (QA) {
      super.setAutoSizeTextTypeUniformWithConfiguration(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    while (this.ahZ == null) {
      return;
    }
    this.ahZ.setAutoSizeTextTypeUniformWithConfiguration(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setAutoSizeTextTypeUniformWithPresetSizes(int[] paramArrayOfInt, int paramInt)
  {
    if (QA) {
      super.setAutoSizeTextTypeUniformWithPresetSizes(paramArrayOfInt, paramInt);
    }
    while (this.ahZ == null) {
      return;
    }
    this.ahZ.setAutoSizeTextTypeUniformWithPresetSizes(paramArrayOfInt, paramInt);
  }
  
  public void setAutoSizeTextTypeWithDefaults(int paramInt)
  {
    if (QA) {
      super.setAutoSizeTextTypeWithDefaults(paramInt);
    }
    while (this.ahZ == null) {
      return;
    }
    this.ahZ.setAutoSizeTextTypeWithDefaults(paramInt);
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
    if (this.ahY != null) {
      this.ahY.iG();
    }
  }
  
  public void setBackgroundResource(int paramInt)
  {
    super.setBackgroundResource(paramInt);
    if (this.ahY != null) {
      this.ahY.bG(paramInt);
    }
  }
  
  public void setCustomSelectionActionModeCallback(ActionMode.Callback paramCallback)
  {
    super.setCustomSelectionActionModeCallback(q.a(this, paramCallback));
  }
  
  public void setFirstBaselineToTopHeight(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 28)
    {
      super.setFirstBaselineToTopHeight(paramInt);
      return;
    }
    q.e(this, paramInt);
  }
  
  public void setLastBaselineToBottomHeight(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 28)
    {
      super.setLastBaselineToBottomHeight(paramInt);
      return;
    }
    q.f(this, paramInt);
  }
  
  public void setLineHeight(int paramInt)
  {
    q.g(this, paramInt);
  }
  
  public void setPrecomputedText(c paramc)
  {
    q.a(this, paramc);
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    if (this.ahY != null) {
      this.ahY.setSupportBackgroundTintList(paramColorStateList);
    }
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    if (this.ahY != null) {
      this.ahY.setSupportBackgroundTintMode(paramMode);
    }
  }
  
  public void setTextAppearance(Context paramContext, int paramInt)
  {
    super.setTextAppearance(paramContext, paramInt);
    if (this.ahZ != null) {
      this.ahZ.u(paramContext, paramInt);
    }
  }
  
  public void setTextFuture(Future<c> paramFuture)
  {
    this.ajr = paramFuture;
    requestLayout();
  }
  
  public void setTextMetricsParamsCompat(c.a parama)
  {
    TextDirectionHeuristic localTextDirectionHeuristic;
    int i;
    if (Build.VERSION.SDK_INT >= 18)
    {
      localTextDirectionHeuristic = parama.Mi;
      if ((localTextDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL) || (localTextDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR)) {
        break label163;
      }
      if (localTextDirectionHeuristic != TextDirectionHeuristics.ANYRTL_LTR) {
        break label96;
      }
      i = 2;
    }
    label163:
    for (;;)
    {
      setTextDirection(i);
      if (Build.VERSION.SDK_INT >= 23) {
        break;
      }
      float f = parama.Mh.getTextScaleX();
      getPaint().set(parama.Mh);
      if (f == getTextScaleX()) {
        setTextScaleX(f / 2.0F + 1.0F);
      }
      setTextScaleX(f);
      return;
      label96:
      if (localTextDirectionHeuristic == TextDirectionHeuristics.LTR) {
        i = 3;
      } else if (localTextDirectionHeuristic == TextDirectionHeuristics.RTL) {
        i = 4;
      } else if (localTextDirectionHeuristic == TextDirectionHeuristics.LOCALE) {
        i = 5;
      } else if (localTextDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
        i = 6;
      } else if (localTextDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL) {
        i = 7;
      } else {
        i = 1;
      }
    }
    getPaint().set(parama.Mh);
    setBreakStrategy(parama.Mj);
    setHyphenationFrequency(parama.Mk);
  }
  
  public void setTextSize(int paramInt, float paramFloat)
  {
    if (QA) {
      super.setTextSize(paramInt, paramFloat);
    }
    while (this.ahZ == null) {
      return;
    }
    this.ahZ.setTextSize(paramInt, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.AppCompatTextView
 * JD-Core Version:    0.7.0.1
 */