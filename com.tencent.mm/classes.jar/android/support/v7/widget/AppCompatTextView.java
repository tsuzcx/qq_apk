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
  private final e ahe = new e(this);
  private final l ahf;
  private Future<c> aix;
  
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
    super(aw.ab(paramContext), paramAttributeSet, paramInt);
    this.ahe.a(paramAttributeSet, paramInt);
    this.ahf = new l(this);
    this.ahf.a(paramAttributeSet, paramInt);
    this.ahf.iH();
  }
  
  private void iJ()
  {
    if (this.aix != null) {}
    try
    {
      Future localFuture = this.aix;
      this.aix = null;
      q.a(this, (c)localFuture.get());
      return;
    }
    catch (InterruptedException localInterruptedException) {}catch (ExecutionException localExecutionException) {}
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (this.ahe != null) {
      this.ahe.iz();
    }
    if (this.ahf != null) {
      this.ahf.iH();
    }
  }
  
  public int getAutoSizeMaxTextSize()
  {
    if (PF) {
      return super.getAutoSizeMaxTextSize();
    }
    if (this.ahf != null) {
      return Math.round(this.ahf.ais.aiE);
    }
    return -1;
  }
  
  public int getAutoSizeMinTextSize()
  {
    if (PF) {
      return super.getAutoSizeMinTextSize();
    }
    if (this.ahf != null) {
      return Math.round(this.ahf.ais.aiD);
    }
    return -1;
  }
  
  public int getAutoSizeStepGranularity()
  {
    if (PF) {
      return super.getAutoSizeStepGranularity();
    }
    if (this.ahf != null) {
      return Math.round(this.ahf.ais.aiC);
    }
    return -1;
  }
  
  public int[] getAutoSizeTextAvailableSizes()
  {
    if (PF) {
      return super.getAutoSizeTextAvailableSizes();
    }
    if (this.ahf != null) {
      return this.ahf.ais.aiF;
    }
    return new int[0];
  }
  
  public int getAutoSizeTextType()
  {
    if (PF)
    {
      if (super.getAutoSizeTextType() == 1) {
        return 1;
      }
      return 0;
    }
    if (this.ahf != null) {
      return this.ahf.ais.aiA;
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
    if (this.ahe != null) {
      return this.ahe.getSupportBackgroundTintList();
    }
    return null;
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    if (this.ahe != null) {
      return this.ahe.getSupportBackgroundTintMode();
    }
    return null;
  }
  
  public CharSequence getText()
  {
    iJ();
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
    if (this.ahf != null) {
      this.ahf.iI();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    iJ();
    super.onMeasure(paramInt1, paramInt2);
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    if ((this.ahf != null) && (!PF) && (this.ahf.ais.iO())) {
      this.ahf.ais.iM();
    }
  }
  
  public void setAutoSizeTextTypeUniformWithConfiguration(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (PF) {
      super.setAutoSizeTextTypeUniformWithConfiguration(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    while (this.ahf == null) {
      return;
    }
    this.ahf.setAutoSizeTextTypeUniformWithConfiguration(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setAutoSizeTextTypeUniformWithPresetSizes(int[] paramArrayOfInt, int paramInt)
  {
    if (PF) {
      super.setAutoSizeTextTypeUniformWithPresetSizes(paramArrayOfInt, paramInt);
    }
    while (this.ahf == null) {
      return;
    }
    this.ahf.setAutoSizeTextTypeUniformWithPresetSizes(paramArrayOfInt, paramInt);
  }
  
  public void setAutoSizeTextTypeWithDefaults(int paramInt)
  {
    if (PF) {
      super.setAutoSizeTextTypeWithDefaults(paramInt);
    }
    while (this.ahf == null) {
      return;
    }
    this.ahf.setAutoSizeTextTypeWithDefaults(paramInt);
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
    if (this.ahe != null) {
      this.ahe.iy();
    }
  }
  
  public void setBackgroundResource(int paramInt)
  {
    super.setBackgroundResource(paramInt);
    if (this.ahe != null) {
      this.ahe.bG(paramInt);
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
    if (this.ahe != null) {
      this.ahe.setSupportBackgroundTintList(paramColorStateList);
    }
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    if (this.ahe != null) {
      this.ahe.setSupportBackgroundTintMode(paramMode);
    }
  }
  
  public void setTextAppearance(Context paramContext, int paramInt)
  {
    super.setTextAppearance(paramContext, paramInt);
    if (this.ahf != null) {
      this.ahf.u(paramContext, paramInt);
    }
  }
  
  public void setTextFuture(Future<c> paramFuture)
  {
    this.aix = paramFuture;
    requestLayout();
  }
  
  public void setTextMetricsParamsCompat(c.a parama)
  {
    TextDirectionHeuristic localTextDirectionHeuristic;
    int i;
    if (Build.VERSION.SDK_INT >= 18)
    {
      localTextDirectionHeuristic = parama.Ln;
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
      float f = parama.Lm.getTextScaleX();
      getPaint().set(parama.Lm);
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
    getPaint().set(parama.Lm);
    setBreakStrategy(parama.Lo);
    setHyphenationFrequency(parama.Lp);
  }
  
  public void setTextSize(int paramInt, float paramFloat)
  {
    if (PF) {
      super.setTextSize(paramInt, paramFloat);
    }
    while (this.ahf == null) {
      return;
    }
    this.ahf.setTextSize(paramInt, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.AppCompatTextView
 * JD-Core Version:    0.7.0.1
 */