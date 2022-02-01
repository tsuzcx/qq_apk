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
  private final e akc = new e(this);
  private final l akd;
  private Future<c> alv;
  
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
    super(aw.ae(paramContext), paramAttributeSet, paramInt);
    this.akc.a(paramAttributeSet, paramInt);
    this.akd = new l(this);
    this.akd.a(paramAttributeSet, paramInt);
    this.akd.jo();
  }
  
  private void jq()
  {
    if (this.alv != null) {}
    try
    {
      Future localFuture = this.alv;
      this.alv = null;
      q.a(this, (c)localFuture.get());
      return;
    }
    catch (InterruptedException localInterruptedException) {}catch (ExecutionException localExecutionException) {}
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (this.akc != null) {
      this.akc.jg();
    }
    if (this.akd != null) {
      this.akd.jo();
    }
  }
  
  public int getAutoSizeMaxTextSize()
  {
    if (SC) {
      return super.getAutoSizeMaxTextSize();
    }
    if (this.akd != null) {
      return Math.round(this.akd.alq.alC);
    }
    return -1;
  }
  
  public int getAutoSizeMinTextSize()
  {
    if (SC) {
      return super.getAutoSizeMinTextSize();
    }
    if (this.akd != null) {
      return Math.round(this.akd.alq.alB);
    }
    return -1;
  }
  
  public int getAutoSizeStepGranularity()
  {
    if (SC) {
      return super.getAutoSizeStepGranularity();
    }
    if (this.akd != null) {
      return Math.round(this.akd.alq.alA);
    }
    return -1;
  }
  
  public int[] getAutoSizeTextAvailableSizes()
  {
    if (SC) {
      return super.getAutoSizeTextAvailableSizes();
    }
    if (this.akd != null) {
      return this.akd.alq.alD;
    }
    return new int[0];
  }
  
  public int getAutoSizeTextType()
  {
    if (SC)
    {
      if (super.getAutoSizeTextType() == 1) {
        return 1;
      }
      return 0;
    }
    if (this.akd != null) {
      return this.akd.alq.aly;
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
    if (this.akc != null) {
      return this.akc.getSupportBackgroundTintList();
    }
    return null;
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    if (this.akc != null) {
      return this.akc.getSupportBackgroundTintMode();
    }
    return null;
  }
  
  public CharSequence getText()
  {
    jq();
    return super.getText();
  }
  
  public c.a getTextMetricsParamsCompat()
  {
    return q.e(this);
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    return h.a(super.onCreateInputConnection(paramEditorInfo), paramEditorInfo, this);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.akd != null) {
      this.akd.jp();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    jq();
    super.onMeasure(paramInt1, paramInt2);
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    if ((this.akd != null) && (!SC) && (this.akd.alq.jv())) {
      this.akd.alq.jt();
    }
  }
  
  public void setAutoSizeTextTypeUniformWithConfiguration(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (SC) {
      super.setAutoSizeTextTypeUniformWithConfiguration(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    while (this.akd == null) {
      return;
    }
    this.akd.setAutoSizeTextTypeUniformWithConfiguration(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setAutoSizeTextTypeUniformWithPresetSizes(int[] paramArrayOfInt, int paramInt)
  {
    if (SC) {
      super.setAutoSizeTextTypeUniformWithPresetSizes(paramArrayOfInt, paramInt);
    }
    while (this.akd == null) {
      return;
    }
    this.akd.setAutoSizeTextTypeUniformWithPresetSizes(paramArrayOfInt, paramInt);
  }
  
  public void setAutoSizeTextTypeWithDefaults(int paramInt)
  {
    if (SC) {
      super.setAutoSizeTextTypeWithDefaults(paramInt);
    }
    while (this.akd == null) {
      return;
    }
    this.akd.setAutoSizeTextTypeWithDefaults(paramInt);
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
    if (this.akc != null) {
      this.akc.jf();
    }
  }
  
  public void setBackgroundResource(int paramInt)
  {
    super.setBackgroundResource(paramInt);
    if (this.akc != null) {
      this.akc.bH(paramInt);
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
    if (this.akc != null) {
      this.akc.setSupportBackgroundTintList(paramColorStateList);
    }
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    if (this.akc != null) {
      this.akc.setSupportBackgroundTintMode(paramMode);
    }
  }
  
  public void setTextAppearance(Context paramContext, int paramInt)
  {
    super.setTextAppearance(paramContext, paramInt);
    if (this.akd != null) {
      this.akd.u(paramContext, paramInt);
    }
  }
  
  public void setTextFuture(Future<c> paramFuture)
  {
    this.alv = paramFuture;
    requestLayout();
  }
  
  public void setTextMetricsParamsCompat(c.a parama)
  {
    TextDirectionHeuristic localTextDirectionHeuristic;
    int i;
    if (Build.VERSION.SDK_INT >= 18)
    {
      localTextDirectionHeuristic = parama.Om;
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
      float f = parama.Ol.getTextScaleX();
      getPaint().set(parama.Ol);
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
    getPaint().set(parama.Ol);
    setBreakStrategy(parama.On);
    setHyphenationFrequency(parama.Oo);
  }
  
  public void setTextSize(int paramInt, float paramFloat)
  {
    if (SC) {
      super.setTextSize(paramInt, paramFloat);
    }
    while (this.akd == null) {
      return;
    }
    this.akd.setTextSize(paramInt, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.AppCompatTextView
 * JD-Core Version:    0.7.0.1
 */