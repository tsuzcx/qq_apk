package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.d.b.a;
import android.support.v4.view.s;
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
  implements s, android.support.v4.widget.b
{
  private final e ZZ = new e(this);
  private final l aaa;
  private Future<android.support.v4.d.b> abr;
  
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
    super(aw.Z(paramContext), paramAttributeSet, paramInt);
    this.ZZ.a(paramAttributeSet, paramInt);
    this.aaa = new l(this);
    this.aaa.a(paramAttributeSet, paramInt);
    this.aaa.hk();
  }
  
  private void hm()
  {
    if (this.abr != null) {}
    try
    {
      Future localFuture = this.abr;
      this.abr = null;
      q.a(this, (android.support.v4.d.b)localFuture.get());
      return;
    }
    catch (InterruptedException localInterruptedException) {}catch (ExecutionException localExecutionException) {}
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (this.ZZ != null) {
      this.ZZ.hc();
    }
    if (this.aaa != null) {
      this.aaa.hk();
    }
  }
  
  public int getAutoSizeMaxTextSize()
  {
    if (IG) {
      return super.getAutoSizeMaxTextSize();
    }
    if (this.aaa != null) {
      return Math.round(this.aaa.abm.aby);
    }
    return -1;
  }
  
  public int getAutoSizeMinTextSize()
  {
    if (IG) {
      return super.getAutoSizeMinTextSize();
    }
    if (this.aaa != null) {
      return Math.round(this.aaa.abm.abx);
    }
    return -1;
  }
  
  public int getAutoSizeStepGranularity()
  {
    if (IG) {
      return super.getAutoSizeStepGranularity();
    }
    if (this.aaa != null) {
      return Math.round(this.aaa.abm.abw);
    }
    return -1;
  }
  
  public int[] getAutoSizeTextAvailableSizes()
  {
    if (IG) {
      return super.getAutoSizeTextAvailableSizes();
    }
    if (this.aaa != null) {
      return this.aaa.abm.abz;
    }
    return new int[0];
  }
  
  public int getAutoSizeTextType()
  {
    if (IG)
    {
      if (super.getAutoSizeTextType() == 1) {
        return 1;
      }
      return 0;
    }
    if (this.aaa != null) {
      return this.aaa.abm.abu;
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
    if (this.ZZ != null) {
      return this.ZZ.getSupportBackgroundTintList();
    }
    return null;
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    if (this.ZZ != null) {
      return this.ZZ.getSupportBackgroundTintMode();
    }
    return null;
  }
  
  public CharSequence getText()
  {
    hm();
    return super.getText();
  }
  
  public b.a getTextMetricsParamsCompat()
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
    if (this.aaa != null) {
      this.aaa.hl();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    hm();
    super.onMeasure(paramInt1, paramInt2);
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    if ((this.aaa != null) && (!IG) && (this.aaa.abm.hr())) {
      this.aaa.abm.hp();
    }
  }
  
  public void setAutoSizeTextTypeUniformWithConfiguration(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (IG) {
      super.setAutoSizeTextTypeUniformWithConfiguration(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    while (this.aaa == null) {
      return;
    }
    this.aaa.setAutoSizeTextTypeUniformWithConfiguration(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setAutoSizeTextTypeUniformWithPresetSizes(int[] paramArrayOfInt, int paramInt)
  {
    if (IG) {
      super.setAutoSizeTextTypeUniformWithPresetSizes(paramArrayOfInt, paramInt);
    }
    while (this.aaa == null) {
      return;
    }
    this.aaa.setAutoSizeTextTypeUniformWithPresetSizes(paramArrayOfInt, paramInt);
  }
  
  public void setAutoSizeTextTypeWithDefaults(int paramInt)
  {
    if (IG) {
      super.setAutoSizeTextTypeWithDefaults(paramInt);
    }
    while (this.aaa == null) {
      return;
    }
    this.aaa.setAutoSizeTextTypeWithDefaults(paramInt);
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
    if (this.ZZ != null) {
      this.ZZ.hb();
    }
  }
  
  public void setBackgroundResource(int paramInt)
  {
    super.setBackgroundResource(paramInt);
    if (this.ZZ != null) {
      this.ZZ.bo(paramInt);
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
    q.c(this, paramInt);
  }
  
  public void setLastBaselineToBottomHeight(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 28)
    {
      super.setLastBaselineToBottomHeight(paramInt);
      return;
    }
    q.d(this, paramInt);
  }
  
  public void setLineHeight(int paramInt)
  {
    q.e(this, paramInt);
  }
  
  public void setPrecomputedText(android.support.v4.d.b paramb)
  {
    q.a(this, paramb);
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    if (this.ZZ != null) {
      this.ZZ.setSupportBackgroundTintList(paramColorStateList);
    }
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    if (this.ZZ != null) {
      this.ZZ.setSupportBackgroundTintMode(paramMode);
    }
  }
  
  public void setTextAppearance(Context paramContext, int paramInt)
  {
    super.setTextAppearance(paramContext, paramInt);
    if (this.aaa != null) {
      this.aaa.t(paramContext, paramInt);
    }
  }
  
  public void setTextFuture(Future<android.support.v4.d.b> paramFuture)
  {
    this.abr = paramFuture;
    requestLayout();
  }
  
  public void setTextMetricsParamsCompat(b.a parama)
  {
    TextDirectionHeuristic localTextDirectionHeuristic;
    int i;
    if (Build.VERSION.SDK_INT >= 18)
    {
      localTextDirectionHeuristic = parama.Eo;
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
      float f = parama.mPaint.getTextScaleX();
      getPaint().set(parama.mPaint);
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
    getPaint().set(parama.mPaint);
    setBreakStrategy(parama.Ep);
    setHyphenationFrequency(parama.Eq);
  }
  
  public void setTextSize(int paramInt, float paramFloat)
  {
    if (IG) {
      super.setTextSize(paramInt, paramFloat);
    }
    while (this.aaa == null) {
      return;
    }
    this.aaa.setTextSize(paramInt, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.AppCompatTextView
 * JD-Core Version:    0.7.0.1
 */