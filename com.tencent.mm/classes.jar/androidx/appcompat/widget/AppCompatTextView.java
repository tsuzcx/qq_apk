package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.ActionMode.Callback;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.core.e.c;
import androidx.core.e.c.a;
import androidx.core.g.u;
import androidx.core.widget.b;
import androidx.core.widget.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class AppCompatTextView
  extends TextView
  implements u, b
{
  private final d mBackgroundTintHelper;
  private final k mTextHelper;
  private Future<c> rG;
  
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
    super(z.L(paramContext), paramAttributeSet, paramInt);
    AppMethodBeat.i(241089);
    this.mBackgroundTintHelper = new d(this);
    this.mBackgroundTintHelper.a(paramAttributeSet, paramInt);
    this.mTextHelper = new k(this);
    this.mTextHelper.a(paramAttributeSet, paramInt);
    this.mTextHelper.du();
    AppMethodBeat.o(241089);
  }
  
  private void dw()
  {
    AppMethodBeat.i(241128);
    if (this.rG != null) {}
    try
    {
      Future localFuture = this.rG;
      this.rG = null;
      i.a(this, (c)localFuture.get());
      AppMethodBeat.o(241128);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      AppMethodBeat.o(241128);
      return;
    }
    catch (ExecutionException localExecutionException)
    {
      label42:
      break label42;
    }
  }
  
  protected void drawableStateChanged()
  {
    AppMethodBeat.i(241100);
    super.drawableStateChanged();
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.dm();
    }
    if (this.mTextHelper != null) {
      this.mTextHelper.du();
    }
    AppMethodBeat.o(241100);
  }
  
  public int getAutoSizeMaxTextSize()
  {
    AppMethodBeat.i(241111);
    int i;
    if (PX)
    {
      i = super.getAutoSizeMaxTextSize();
      AppMethodBeat.o(241111);
      return i;
    }
    if (this.mTextHelper != null)
    {
      i = Math.round(this.mTextHelper.rB.rN);
      AppMethodBeat.o(241111);
      return i;
    }
    AppMethodBeat.o(241111);
    return -1;
  }
  
  public int getAutoSizeMinTextSize()
  {
    AppMethodBeat.i(241110);
    int i;
    if (PX)
    {
      i = super.getAutoSizeMinTextSize();
      AppMethodBeat.o(241110);
      return i;
    }
    if (this.mTextHelper != null)
    {
      i = Math.round(this.mTextHelper.rB.rM);
      AppMethodBeat.o(241110);
      return i;
    }
    AppMethodBeat.o(241110);
    return -1;
  }
  
  public int getAutoSizeStepGranularity()
  {
    AppMethodBeat.i(241109);
    int i;
    if (PX)
    {
      i = super.getAutoSizeStepGranularity();
      AppMethodBeat.o(241109);
      return i;
    }
    if (this.mTextHelper != null)
    {
      i = Math.round(this.mTextHelper.rB.rL);
      AppMethodBeat.o(241109);
      return i;
    }
    AppMethodBeat.o(241109);
    return -1;
  }
  
  public int[] getAutoSizeTextAvailableSizes()
  {
    AppMethodBeat.i(241113);
    int[] arrayOfInt;
    if (PX)
    {
      arrayOfInt = super.getAutoSizeTextAvailableSizes();
      AppMethodBeat.o(241113);
      return arrayOfInt;
    }
    if (this.mTextHelper != null)
    {
      arrayOfInt = this.mTextHelper.rB.rO;
      AppMethodBeat.o(241113);
      return arrayOfInt;
    }
    AppMethodBeat.o(241113);
    return new int[0];
  }
  
  public int getAutoSizeTextType()
  {
    AppMethodBeat.i(241107);
    if (PX)
    {
      if (super.getAutoSizeTextType() == 1)
      {
        AppMethodBeat.o(241107);
        return 1;
      }
      AppMethodBeat.o(241107);
      return 0;
    }
    if (this.mTextHelper != null)
    {
      int i = this.mTextHelper.rB.rJ;
      AppMethodBeat.o(241107);
      return i;
    }
    AppMethodBeat.o(241107);
    return 0;
  }
  
  public int getFirstBaselineToTopHeight()
  {
    AppMethodBeat.i(241118);
    int i = getPaddingTop();
    int j = getPaint().getFontMetricsInt().top;
    AppMethodBeat.o(241118);
    return i - j;
  }
  
  public int getLastBaselineToBottomHeight()
  {
    AppMethodBeat.i(241120);
    int i = getPaddingBottom();
    int j = getPaint().getFontMetricsInt().bottom;
    AppMethodBeat.o(241120);
    return i + j;
  }
  
  public ColorStateList getSupportBackgroundTintList()
  {
    AppMethodBeat.i(241094);
    if (this.mBackgroundTintHelper != null)
    {
      ColorStateList localColorStateList = this.mBackgroundTintHelper.getSupportBackgroundTintList();
      AppMethodBeat.o(241094);
      return localColorStateList;
    }
    AppMethodBeat.o(241094);
    return null;
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    AppMethodBeat.i(241098);
    if (this.mBackgroundTintHelper != null)
    {
      PorterDuff.Mode localMode = this.mBackgroundTintHelper.getSupportBackgroundTintMode();
      AppMethodBeat.o(241098);
      return localMode;
    }
    AppMethodBeat.o(241098);
    return null;
  }
  
  public CharSequence getText()
  {
    AppMethodBeat.i(241130);
    dw();
    CharSequence localCharSequence = super.getText();
    AppMethodBeat.o(241130);
    return localCharSequence;
  }
  
  public c.a getTextMetricsParamsCompat()
  {
    AppMethodBeat.i(241124);
    c.a locala = i.d(this);
    AppMethodBeat.o(241124);
    return locala;
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    AppMethodBeat.i(241115);
    paramEditorInfo = g.a(super.onCreateInputConnection(paramEditorInfo), paramEditorInfo, this);
    AppMethodBeat.o(241115);
    return paramEditorInfo;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(241101);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.mTextHelper != null) {
      this.mTextHelper.dv();
    }
    AppMethodBeat.o(241101);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(241133);
    dw();
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(241133);
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(241103);
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    if ((this.mTextHelper != null) && (!PX) && (this.mTextHelper.rB.dB())) {
      this.mTextHelper.rB.dz();
    }
    AppMethodBeat.o(241103);
  }
  
  public void setAutoSizeTextTypeUniformWithConfiguration(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(241105);
    if (PX)
    {
      super.setAutoSizeTextTypeUniformWithConfiguration(paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(241105);
      return;
    }
    if (this.mTextHelper != null) {
      this.mTextHelper.setAutoSizeTextTypeUniformWithConfiguration(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(241105);
  }
  
  public void setAutoSizeTextTypeUniformWithPresetSizes(int[] paramArrayOfInt, int paramInt)
  {
    AppMethodBeat.i(241106);
    if (PX)
    {
      super.setAutoSizeTextTypeUniformWithPresetSizes(paramArrayOfInt, paramInt);
      AppMethodBeat.o(241106);
      return;
    }
    if (this.mTextHelper != null) {
      this.mTextHelper.setAutoSizeTextTypeUniformWithPresetSizes(paramArrayOfInt, paramInt);
    }
    AppMethodBeat.o(241106);
  }
  
  public void setAutoSizeTextTypeWithDefaults(int paramInt)
  {
    AppMethodBeat.i(241104);
    if (PX)
    {
      super.setAutoSizeTextTypeWithDefaults(paramInt);
      AppMethodBeat.o(241104);
      return;
    }
    if (this.mTextHelper != null) {
      this.mTextHelper.setAutoSizeTextTypeWithDefaults(paramInt);
    }
    AppMethodBeat.o(241104);
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(241091);
    super.setBackgroundDrawable(paramDrawable);
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.dl();
    }
    AppMethodBeat.o(241091);
  }
  
  public void setBackgroundResource(int paramInt)
  {
    AppMethodBeat.i(241090);
    super.setBackgroundResource(paramInt);
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.ar(paramInt);
    }
    AppMethodBeat.o(241090);
  }
  
  public void setCustomSelectionActionModeCallback(ActionMode.Callback paramCallback)
  {
    AppMethodBeat.i(241123);
    super.setCustomSelectionActionModeCallback(i.a(this, paramCallback));
    AppMethodBeat.o(241123);
  }
  
  public void setFirstBaselineToTopHeight(int paramInt)
  {
    AppMethodBeat.i(241116);
    if (Build.VERSION.SDK_INT >= 28)
    {
      super.setFirstBaselineToTopHeight(paramInt);
      AppMethodBeat.o(241116);
      return;
    }
    i.b(this, paramInt);
    AppMethodBeat.o(241116);
  }
  
  public void setLastBaselineToBottomHeight(int paramInt)
  {
    AppMethodBeat.i(241117);
    if (Build.VERSION.SDK_INT >= 28)
    {
      super.setLastBaselineToBottomHeight(paramInt);
      AppMethodBeat.o(241117);
      return;
    }
    i.c(this, paramInt);
    AppMethodBeat.o(241117);
  }
  
  public void setLineHeight(int paramInt)
  {
    AppMethodBeat.i(241121);
    i.d(this, paramInt);
    AppMethodBeat.o(241121);
  }
  
  public void setPrecomputedText(c paramc)
  {
    AppMethodBeat.i(241126);
    i.a(this, paramc);
    AppMethodBeat.o(241126);
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(241093);
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.setSupportBackgroundTintList(paramColorStateList);
    }
    AppMethodBeat.o(241093);
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(241096);
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.setSupportBackgroundTintMode(paramMode);
    }
    AppMethodBeat.o(241096);
  }
  
  public void setTextAppearance(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(241099);
    super.setTextAppearance(paramContext, paramInt);
    if (this.mTextHelper != null) {
      this.mTextHelper.s(paramContext, paramInt);
    }
    AppMethodBeat.o(241099);
  }
  
  public void setTextFuture(Future<c> paramFuture)
  {
    AppMethodBeat.i(241132);
    this.rG = paramFuture;
    requestLayout();
    AppMethodBeat.o(241132);
  }
  
  public void setTextMetricsParamsCompat(c.a parama)
  {
    AppMethodBeat.i(241125);
    TextDirectionHeuristic localTextDirectionHeuristic;
    int i;
    if (Build.VERSION.SDK_INT >= 18)
    {
      localTextDirectionHeuristic = parama.Mg;
      if ((localTextDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL) || (localTextDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR)) {
        break label175;
      }
      if (localTextDirectionHeuristic != TextDirectionHeuristics.ANYRTL_LTR) {
        break label108;
      }
      i = 2;
    }
    label175:
    for (;;)
    {
      setTextDirection(i);
      if (Build.VERSION.SDK_INT >= 23) {
        break;
      }
      float f = parama.Mf.getTextScaleX();
      getPaint().set(parama.Mf);
      if (f == getTextScaleX()) {
        setTextScaleX(f / 2.0F + 1.0F);
      }
      setTextScaleX(f);
      AppMethodBeat.o(241125);
      return;
      label108:
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
    getPaint().set(parama.Mf);
    setBreakStrategy(parama.Mh);
    setHyphenationFrequency(parama.Mi);
    AppMethodBeat.o(241125);
  }
  
  public void setTextSize(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(241102);
    if (PX)
    {
      super.setTextSize(paramInt, paramFloat);
      AppMethodBeat.o(241102);
      return;
    }
    if (this.mTextHelper != null) {
      this.mTextHelper.setTextSize(paramInt, paramFloat);
    }
    AppMethodBeat.o(241102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.widget.AppCompatTextView
 * JD-Core Version:    0.7.0.1
 */