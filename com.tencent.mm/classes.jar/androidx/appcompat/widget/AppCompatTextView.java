package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.ActionMode.Callback;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.core.e.c;
import androidx.core.e.c.a;
import androidx.core.g.x;
import androidx.core.widget.b;
import androidx.core.widget.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class AppCompatTextView
  extends TextView
  implements x, b
{
  private final d mBackgroundTintHelper;
  private final k mTextHelper;
  private Future<c> sF;
  
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
    AppMethodBeat.i(199397);
    this.mBackgroundTintHelper = new d(this);
    this.mBackgroundTintHelper.a(paramAttributeSet, paramInt);
    this.mTextHelper = new k(this);
    this.mTextHelper.a(paramAttributeSet, paramInt);
    this.mTextHelper.et();
    AppMethodBeat.o(199397);
  }
  
  private void ev()
  {
    AppMethodBeat.i(199407);
    if (this.sF != null) {}
    try
    {
      Future localFuture = this.sF;
      this.sF = null;
      j.a(this, (c)localFuture.get());
      AppMethodBeat.o(199407);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      AppMethodBeat.o(199407);
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
    AppMethodBeat.i(199476);
    super.drawableStateChanged();
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.el();
    }
    if (this.mTextHelper != null) {
      this.mTextHelper.et();
    }
    AppMethodBeat.o(199476);
  }
  
  public int getAutoSizeMaxTextSize()
  {
    AppMethodBeat.i(199583);
    int i;
    if (bwp)
    {
      i = super.getAutoSizeMaxTextSize();
      AppMethodBeat.o(199583);
      return i;
    }
    if (this.mTextHelper != null)
    {
      i = Math.round(this.mTextHelper.sA.sM);
      AppMethodBeat.o(199583);
      return i;
    }
    AppMethodBeat.o(199583);
    return -1;
  }
  
  public int getAutoSizeMinTextSize()
  {
    AppMethodBeat.i(199572);
    int i;
    if (bwp)
    {
      i = super.getAutoSizeMinTextSize();
      AppMethodBeat.o(199572);
      return i;
    }
    if (this.mTextHelper != null)
    {
      i = Math.round(this.mTextHelper.sA.sL);
      AppMethodBeat.o(199572);
      return i;
    }
    AppMethodBeat.o(199572);
    return -1;
  }
  
  public int getAutoSizeStepGranularity()
  {
    AppMethodBeat.i(199563);
    int i;
    if (bwp)
    {
      i = super.getAutoSizeStepGranularity();
      AppMethodBeat.o(199563);
      return i;
    }
    if (this.mTextHelper != null)
    {
      i = Math.round(this.mTextHelper.sA.sK);
      AppMethodBeat.o(199563);
      return i;
    }
    AppMethodBeat.o(199563);
    return -1;
  }
  
  public int[] getAutoSizeTextAvailableSizes()
  {
    AppMethodBeat.i(199591);
    int[] arrayOfInt;
    if (bwp)
    {
      arrayOfInt = super.getAutoSizeTextAvailableSizes();
      AppMethodBeat.o(199591);
      return arrayOfInt;
    }
    if (this.mTextHelper != null)
    {
      arrayOfInt = this.mTextHelper.sA.sN;
      AppMethodBeat.o(199591);
      return arrayOfInt;
    }
    AppMethodBeat.o(199591);
    return new int[0];
  }
  
  public int getAutoSizeTextType()
  {
    AppMethodBeat.i(199552);
    if (bwp)
    {
      if (super.getAutoSizeTextType() == 1)
      {
        AppMethodBeat.o(199552);
        return 1;
      }
      AppMethodBeat.o(199552);
      return 0;
    }
    if (this.mTextHelper != null)
    {
      int i = this.mTextHelper.sA.sI;
      AppMethodBeat.o(199552);
      return i;
    }
    AppMethodBeat.o(199552);
    return 0;
  }
  
  public int getFirstBaselineToTopHeight()
  {
    AppMethodBeat.i(199632);
    int i = j.d(this);
    AppMethodBeat.o(199632);
    return i;
  }
  
  public int getLastBaselineToBottomHeight()
  {
    AppMethodBeat.i(199642);
    int i = j.e(this);
    AppMethodBeat.o(199642);
    return i;
  }
  
  public ColorStateList getSupportBackgroundTintList()
  {
    AppMethodBeat.i(199437);
    if (this.mBackgroundTintHelper != null)
    {
      ColorStateList localColorStateList = this.mBackgroundTintHelper.getSupportBackgroundTintList();
      AppMethodBeat.o(199437);
      return localColorStateList;
    }
    AppMethodBeat.o(199437);
    return null;
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    AppMethodBeat.i(199456);
    if (this.mBackgroundTintHelper != null)
    {
      PorterDuff.Mode localMode = this.mBackgroundTintHelper.getSupportBackgroundTintMode();
      AppMethodBeat.o(199456);
      return localMode;
    }
    AppMethodBeat.o(199456);
    return null;
  }
  
  public CharSequence getText()
  {
    AppMethodBeat.i(199696);
    ev();
    CharSequence localCharSequence = super.getText();
    AppMethodBeat.o(199696);
    return localCharSequence;
  }
  
  public c.a getTextMetricsParamsCompat()
  {
    AppMethodBeat.i(199668);
    c.a locala = j.f(this);
    AppMethodBeat.o(199668);
    return locala;
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    AppMethodBeat.i(199604);
    paramEditorInfo = g.a(super.onCreateInputConnection(paramEditorInfo), paramEditorInfo, this);
    AppMethodBeat.o(199604);
    return paramEditorInfo;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(199487);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.mTextHelper != null) {
      this.mTextHelper.eu();
    }
    AppMethodBeat.o(199487);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(199712);
    ev();
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(199712);
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(199510);
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    if ((this.mTextHelper != null) && (!bwp) && (this.mTextHelper.sA.eA())) {
      this.mTextHelper.sA.ey();
    }
    AppMethodBeat.o(199510);
  }
  
  public void setAutoSizeTextTypeUniformWithConfiguration(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(199533);
    if (bwp)
    {
      super.setAutoSizeTextTypeUniformWithConfiguration(paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(199533);
      return;
    }
    if (this.mTextHelper != null) {
      this.mTextHelper.setAutoSizeTextTypeUniformWithConfiguration(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(199533);
  }
  
  public void setAutoSizeTextTypeUniformWithPresetSizes(int[] paramArrayOfInt, int paramInt)
  {
    AppMethodBeat.i(199542);
    if (bwp)
    {
      super.setAutoSizeTextTypeUniformWithPresetSizes(paramArrayOfInt, paramInt);
      AppMethodBeat.o(199542);
      return;
    }
    if (this.mTextHelper != null) {
      this.mTextHelper.setAutoSizeTextTypeUniformWithPresetSizes(paramArrayOfInt, paramInt);
    }
    AppMethodBeat.o(199542);
  }
  
  public void setAutoSizeTextTypeWithDefaults(int paramInt)
  {
    AppMethodBeat.i(199522);
    if (bwp)
    {
      super.setAutoSizeTextTypeWithDefaults(paramInt);
      AppMethodBeat.o(199522);
      return;
    }
    if (this.mTextHelper != null) {
      this.mTextHelper.setAutoSizeTextTypeWithDefaults(paramInt);
    }
    AppMethodBeat.o(199522);
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(199421);
    super.setBackgroundDrawable(paramDrawable);
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.ek();
    }
    AppMethodBeat.o(199421);
  }
  
  public void setBackgroundResource(int paramInt)
  {
    AppMethodBeat.i(199414);
    super.setBackgroundResource(paramInt);
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.ap(paramInt);
    }
    AppMethodBeat.o(199414);
  }
  
  public void setCustomSelectionActionModeCallback(ActionMode.Callback paramCallback)
  {
    AppMethodBeat.i(199662);
    super.setCustomSelectionActionModeCallback(j.a(this, paramCallback));
    AppMethodBeat.o(199662);
  }
  
  public void setFirstBaselineToTopHeight(int paramInt)
  {
    AppMethodBeat.i(199615);
    if (Build.VERSION.SDK_INT >= 28)
    {
      super.setFirstBaselineToTopHeight(paramInt);
      AppMethodBeat.o(199615);
      return;
    }
    j.c(this, paramInt);
    AppMethodBeat.o(199615);
  }
  
  public void setLastBaselineToBottomHeight(int paramInt)
  {
    AppMethodBeat.i(199625);
    if (Build.VERSION.SDK_INT >= 28)
    {
      super.setLastBaselineToBottomHeight(paramInt);
      AppMethodBeat.o(199625);
      return;
    }
    j.d(this, paramInt);
    AppMethodBeat.o(199625);
  }
  
  public void setLineHeight(int paramInt)
  {
    AppMethodBeat.i(199651);
    j.e(this, paramInt);
    AppMethodBeat.o(199651);
  }
  
  public void setPrecomputedText(c paramc)
  {
    AppMethodBeat.i(199685);
    j.a(this, paramc);
    AppMethodBeat.o(199685);
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(199429);
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.setSupportBackgroundTintList(paramColorStateList);
    }
    AppMethodBeat.o(199429);
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(199447);
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.setSupportBackgroundTintMode(paramMode);
    }
    AppMethodBeat.o(199447);
  }
  
  public void setTextAppearance(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(199466);
    super.setTextAppearance(paramContext, paramInt);
    if (this.mTextHelper != null) {
      this.mTextHelper.s(paramContext, paramInt);
    }
    AppMethodBeat.o(199466);
  }
  
  public void setTextFuture(Future<c> paramFuture)
  {
    AppMethodBeat.i(199706);
    this.sF = paramFuture;
    requestLayout();
    AppMethodBeat.o(199706);
  }
  
  public void setTextMetricsParamsCompat(c.a parama)
  {
    AppMethodBeat.i(199678);
    j.a(this, parama);
    AppMethodBeat.o(199678);
  }
  
  public void setTextSize(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(199497);
    if (bwp)
    {
      super.setTextSize(paramInt, paramFloat);
      AppMethodBeat.o(199497);
      return;
    }
    if (this.mTextHelper != null) {
      this.mTextHelper.setTextSize(paramInt, paramFloat);
    }
    AppMethodBeat.o(199497);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.widget.AppCompatTextView
 * JD-Core Version:    0.7.0.1
 */