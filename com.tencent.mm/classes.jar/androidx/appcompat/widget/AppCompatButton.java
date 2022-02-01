package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode.Callback;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import androidx.appcompat.a.a;
import androidx.core.g.u;
import androidx.core.widget.b;
import androidx.core.widget.i;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppCompatButton
  extends Button
  implements u, b
{
  private final d mBackgroundTintHelper;
  private final k mTextHelper;
  
  public AppCompatButton(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AppCompatButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.a.buttonStyle);
  }
  
  public AppCompatButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(z.L(paramContext), paramAttributeSet, paramInt);
    AppMethodBeat.i(240682);
    this.mBackgroundTintHelper = new d(this);
    this.mBackgroundTintHelper.a(paramAttributeSet, paramInt);
    this.mTextHelper = new k(this);
    this.mTextHelper.a(paramAttributeSet, paramInt);
    this.mTextHelper.du();
    AppMethodBeat.o(240682);
  }
  
  protected void drawableStateChanged()
  {
    AppMethodBeat.i(240691);
    super.drawableStateChanged();
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.dm();
    }
    if (this.mTextHelper != null) {
      this.mTextHelper.du();
    }
    AppMethodBeat.o(240691);
  }
  
  public int getAutoSizeMaxTextSize()
  {
    AppMethodBeat.i(240708);
    int i;
    if (PX)
    {
      i = super.getAutoSizeMaxTextSize();
      AppMethodBeat.o(240708);
      return i;
    }
    if (this.mTextHelper != null)
    {
      i = Math.round(this.mTextHelper.rB.rN);
      AppMethodBeat.o(240708);
      return i;
    }
    AppMethodBeat.o(240708);
    return -1;
  }
  
  public int getAutoSizeMinTextSize()
  {
    AppMethodBeat.i(240707);
    int i;
    if (PX)
    {
      i = super.getAutoSizeMinTextSize();
      AppMethodBeat.o(240707);
      return i;
    }
    if (this.mTextHelper != null)
    {
      i = Math.round(this.mTextHelper.rB.rM);
      AppMethodBeat.o(240707);
      return i;
    }
    AppMethodBeat.o(240707);
    return -1;
  }
  
  public int getAutoSizeStepGranularity()
  {
    AppMethodBeat.i(240706);
    int i;
    if (PX)
    {
      i = super.getAutoSizeStepGranularity();
      AppMethodBeat.o(240706);
      return i;
    }
    if (this.mTextHelper != null)
    {
      i = Math.round(this.mTextHelper.rB.rL);
      AppMethodBeat.o(240706);
      return i;
    }
    AppMethodBeat.o(240706);
    return -1;
  }
  
  public int[] getAutoSizeTextAvailableSizes()
  {
    AppMethodBeat.i(240710);
    int[] arrayOfInt;
    if (PX)
    {
      arrayOfInt = super.getAutoSizeTextAvailableSizes();
      AppMethodBeat.o(240710);
      return arrayOfInt;
    }
    if (this.mTextHelper != null)
    {
      arrayOfInt = this.mTextHelper.rB.rO;
      AppMethodBeat.o(240710);
      return arrayOfInt;
    }
    AppMethodBeat.o(240710);
    return new int[0];
  }
  
  public int getAutoSizeTextType()
  {
    AppMethodBeat.i(240704);
    if (PX)
    {
      if (super.getAutoSizeTextType() == 1)
      {
        AppMethodBeat.o(240704);
        return 1;
      }
      AppMethodBeat.o(240704);
      return 0;
    }
    if (this.mTextHelper != null)
    {
      int i = this.mTextHelper.rB.rJ;
      AppMethodBeat.o(240704);
      return i;
    }
    AppMethodBeat.o(240704);
    return 0;
  }
  
  public ColorStateList getSupportBackgroundTintList()
  {
    AppMethodBeat.i(240687);
    if (this.mBackgroundTintHelper != null)
    {
      ColorStateList localColorStateList = this.mBackgroundTintHelper.getSupportBackgroundTintList();
      AppMethodBeat.o(240687);
      return localColorStateList;
    }
    AppMethodBeat.o(240687);
    return null;
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    AppMethodBeat.i(240690);
    if (this.mBackgroundTintHelper != null)
    {
      PorterDuff.Mode localMode = this.mBackgroundTintHelper.getSupportBackgroundTintMode();
      AppMethodBeat.o(240690);
      return localMode;
    }
    AppMethodBeat.o(240690);
    return null;
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(240693);
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(Button.class.getName());
    AppMethodBeat.o(240693);
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    AppMethodBeat.i(240694);
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName(Button.class.getName());
    AppMethodBeat.o(240694);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(240695);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.mTextHelper != null) {
      this.mTextHelper.dv();
    }
    AppMethodBeat.o(240695);
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(240699);
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    if ((this.mTextHelper != null) && (!PX) && (this.mTextHelper.rB.dB())) {
      this.mTextHelper.rB.dz();
    }
    AppMethodBeat.o(240699);
  }
  
  public void setAutoSizeTextTypeUniformWithConfiguration(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(240702);
    if (PX)
    {
      super.setAutoSizeTextTypeUniformWithConfiguration(paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(240702);
      return;
    }
    if (this.mTextHelper != null) {
      this.mTextHelper.setAutoSizeTextTypeUniformWithConfiguration(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(240702);
  }
  
  public void setAutoSizeTextTypeUniformWithPresetSizes(int[] paramArrayOfInt, int paramInt)
  {
    AppMethodBeat.i(240703);
    if (PX)
    {
      super.setAutoSizeTextTypeUniformWithPresetSizes(paramArrayOfInt, paramInt);
      AppMethodBeat.o(240703);
      return;
    }
    if (this.mTextHelper != null) {
      this.mTextHelper.setAutoSizeTextTypeUniformWithPresetSizes(paramArrayOfInt, paramInt);
    }
    AppMethodBeat.o(240703);
  }
  
  public void setAutoSizeTextTypeWithDefaults(int paramInt)
  {
    AppMethodBeat.i(240701);
    if (PX)
    {
      super.setAutoSizeTextTypeWithDefaults(paramInt);
      AppMethodBeat.o(240701);
      return;
    }
    if (this.mTextHelper != null) {
      this.mTextHelper.setAutoSizeTextTypeWithDefaults(paramInt);
    }
    AppMethodBeat.o(240701);
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(240685);
    super.setBackgroundDrawable(paramDrawable);
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.dl();
    }
    AppMethodBeat.o(240685);
  }
  
  public void setBackgroundResource(int paramInt)
  {
    AppMethodBeat.i(240684);
    super.setBackgroundResource(paramInt);
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.ar(paramInt);
    }
    AppMethodBeat.o(240684);
  }
  
  public void setCustomSelectionActionModeCallback(ActionMode.Callback paramCallback)
  {
    AppMethodBeat.i(240712);
    super.setCustomSelectionActionModeCallback(i.a(this, paramCallback));
    AppMethodBeat.o(240712);
  }
  
  public void setSupportAllCaps(boolean paramBoolean)
  {
    AppMethodBeat.i(240711);
    if (this.mTextHelper != null) {
      this.mTextHelper.setAllCaps(paramBoolean);
    }
    AppMethodBeat.o(240711);
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(240686);
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.setSupportBackgroundTintList(paramColorStateList);
    }
    AppMethodBeat.o(240686);
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(240689);
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.setSupportBackgroundTintMode(paramMode);
    }
    AppMethodBeat.o(240689);
  }
  
  public void setTextAppearance(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(240692);
    super.setTextAppearance(paramContext, paramInt);
    if (this.mTextHelper != null) {
      this.mTextHelper.s(paramContext, paramInt);
    }
    AppMethodBeat.o(240692);
  }
  
  public void setTextSize(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(240696);
    if (PX)
    {
      super.setTextSize(paramInt, paramFloat);
      AppMethodBeat.o(240696);
      return;
    }
    if (this.mTextHelper != null) {
      this.mTextHelper.setTextSize(paramInt, paramFloat);
    }
    AppMethodBeat.o(240696);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.widget.AppCompatButton
 * JD-Core Version:    0.7.0.1
 */