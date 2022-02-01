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
  private final e ajP = new e(this);
  private final l ajQ;
  private Future<c> ali;
  
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
    this.ajP.a(paramAttributeSet, paramInt);
    this.ajQ = new l(this);
    this.ajQ.a(paramAttributeSet, paramInt);
    this.ajQ.jf();
  }
  
  private void jh()
  {
    if (this.ali != null) {}
    try
    {
      Future localFuture = this.ali;
      this.ali = null;
      q.a(this, (c)localFuture.get());
      return;
    }
    catch (InterruptedException localInterruptedException) {}catch (ExecutionException localExecutionException) {}
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (this.ajP != null) {
      this.ajP.iX();
    }
    if (this.ajQ != null) {
      this.ajQ.jf();
    }
  }
  
  public int getAutoSizeMaxTextSize()
  {
    if (Sp) {
      return super.getAutoSizeMaxTextSize();
    }
    if (this.ajQ != null) {
      return Math.round(this.ajQ.ald.alp);
    }
    return -1;
  }
  
  public int getAutoSizeMinTextSize()
  {
    if (Sp) {
      return super.getAutoSizeMinTextSize();
    }
    if (this.ajQ != null) {
      return Math.round(this.ajQ.ald.alo);
    }
    return -1;
  }
  
  public int getAutoSizeStepGranularity()
  {
    if (Sp) {
      return super.getAutoSizeStepGranularity();
    }
    if (this.ajQ != null) {
      return Math.round(this.ajQ.ald.aln);
    }
    return -1;
  }
  
  public int[] getAutoSizeTextAvailableSizes()
  {
    if (Sp) {
      return super.getAutoSizeTextAvailableSizes();
    }
    if (this.ajQ != null) {
      return this.ajQ.ald.alq;
    }
    return new int[0];
  }
  
  public int getAutoSizeTextType()
  {
    if (Sp)
    {
      if (super.getAutoSizeTextType() == 1) {
        return 1;
      }
      return 0;
    }
    if (this.ajQ != null) {
      return this.ajQ.ald.all;
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
    if (this.ajP != null) {
      return this.ajP.getSupportBackgroundTintList();
    }
    return null;
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    if (this.ajP != null) {
      return this.ajP.getSupportBackgroundTintMode();
    }
    return null;
  }
  
  public CharSequence getText()
  {
    jh();
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
    if (this.ajQ != null) {
      this.ajQ.jg();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    jh();
    super.onMeasure(paramInt1, paramInt2);
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    if ((this.ajQ != null) && (!Sp) && (this.ajQ.ald.jm())) {
      this.ajQ.ald.jk();
    }
  }
  
  public void setAutoSizeTextTypeUniformWithConfiguration(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (Sp) {
      super.setAutoSizeTextTypeUniformWithConfiguration(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    while (this.ajQ == null) {
      return;
    }
    this.ajQ.setAutoSizeTextTypeUniformWithConfiguration(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setAutoSizeTextTypeUniformWithPresetSizes(int[] paramArrayOfInt, int paramInt)
  {
    if (Sp) {
      super.setAutoSizeTextTypeUniformWithPresetSizes(paramArrayOfInt, paramInt);
    }
    while (this.ajQ == null) {
      return;
    }
    this.ajQ.setAutoSizeTextTypeUniformWithPresetSizes(paramArrayOfInt, paramInt);
  }
  
  public void setAutoSizeTextTypeWithDefaults(int paramInt)
  {
    if (Sp) {
      super.setAutoSizeTextTypeWithDefaults(paramInt);
    }
    while (this.ajQ == null) {
      return;
    }
    this.ajQ.setAutoSizeTextTypeWithDefaults(paramInt);
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
    if (this.ajP != null) {
      this.ajP.iW();
    }
  }
  
  public void setBackgroundResource(int paramInt)
  {
    super.setBackgroundResource(paramInt);
    if (this.ajP != null) {
      this.ajP.bG(paramInt);
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
    if (this.ajP != null) {
      this.ajP.setSupportBackgroundTintList(paramColorStateList);
    }
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    if (this.ajP != null) {
      this.ajP.setSupportBackgroundTintMode(paramMode);
    }
  }
  
  public void setTextAppearance(Context paramContext, int paramInt)
  {
    super.setTextAppearance(paramContext, paramInt);
    if (this.ajQ != null) {
      this.ajQ.u(paramContext, paramInt);
    }
  }
  
  public void setTextFuture(Future<c> paramFuture)
  {
    this.ali = paramFuture;
    requestLayout();
  }
  
  public void setTextMetricsParamsCompat(c.a parama)
  {
    TextDirectionHeuristic localTextDirectionHeuristic;
    int i;
    if (Build.VERSION.SDK_INT >= 18)
    {
      localTextDirectionHeuristic = parama.Oa;
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
      float f = parama.NZ.getTextScaleX();
      getPaint().set(parama.NZ);
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
    getPaint().set(parama.NZ);
    setBreakStrategy(parama.Ob);
    setHyphenationFrequency(parama.Oc);
  }
  
  public void setTextSize(int paramInt, float paramFloat)
  {
    if (Sp) {
      super.setTextSize(paramInt, paramFloat);
    }
    while (this.ajQ == null) {
      return;
    }
    this.ajQ.setTextSize(paramInt, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.AppCompatTextView
 * JD-Core Version:    0.7.0.1
 */