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
import androidx.core.g.x;
import androidx.core.widget.b;
import androidx.core.widget.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppCompatButton
  extends Button
  implements x, b
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
    AppMethodBeat.i(200242);
    this.mBackgroundTintHelper = new d(this);
    this.mBackgroundTintHelper.a(paramAttributeSet, paramInt);
    this.mTextHelper = new k(this);
    this.mTextHelper.a(paramAttributeSet, paramInt);
    this.mTextHelper.et();
    AppMethodBeat.o(200242);
  }
  
  protected void drawableStateChanged()
  {
    AppMethodBeat.i(200307);
    super.drawableStateChanged();
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.el();
    }
    if (this.mTextHelper != null) {
      this.mTextHelper.et();
    }
    AppMethodBeat.o(200307);
  }
  
  public int getAutoSizeMaxTextSize()
  {
    AppMethodBeat.i(200443);
    int i;
    if (bwp)
    {
      i = super.getAutoSizeMaxTextSize();
      AppMethodBeat.o(200443);
      return i;
    }
    if (this.mTextHelper != null)
    {
      i = Math.round(this.mTextHelper.sA.sM);
      AppMethodBeat.o(200443);
      return i;
    }
    AppMethodBeat.o(200443);
    return -1;
  }
  
  public int getAutoSizeMinTextSize()
  {
    AppMethodBeat.i(200435);
    int i;
    if (bwp)
    {
      i = super.getAutoSizeMinTextSize();
      AppMethodBeat.o(200435);
      return i;
    }
    if (this.mTextHelper != null)
    {
      i = Math.round(this.mTextHelper.sA.sL);
      AppMethodBeat.o(200435);
      return i;
    }
    AppMethodBeat.o(200435);
    return -1;
  }
  
  public int getAutoSizeStepGranularity()
  {
    AppMethodBeat.i(200422);
    int i;
    if (bwp)
    {
      i = super.getAutoSizeStepGranularity();
      AppMethodBeat.o(200422);
      return i;
    }
    if (this.mTextHelper != null)
    {
      i = Math.round(this.mTextHelper.sA.sK);
      AppMethodBeat.o(200422);
      return i;
    }
    AppMethodBeat.o(200422);
    return -1;
  }
  
  public int[] getAutoSizeTextAvailableSizes()
  {
    AppMethodBeat.i(200456);
    int[] arrayOfInt;
    if (bwp)
    {
      arrayOfInt = super.getAutoSizeTextAvailableSizes();
      AppMethodBeat.o(200456);
      return arrayOfInt;
    }
    if (this.mTextHelper != null)
    {
      arrayOfInt = this.mTextHelper.sA.sN;
      AppMethodBeat.o(200456);
      return arrayOfInt;
    }
    AppMethodBeat.o(200456);
    return new int[0];
  }
  
  public int getAutoSizeTextType()
  {
    AppMethodBeat.i(200411);
    if (bwp)
    {
      if (super.getAutoSizeTextType() == 1)
      {
        AppMethodBeat.o(200411);
        return 1;
      }
      AppMethodBeat.o(200411);
      return 0;
    }
    if (this.mTextHelper != null)
    {
      int i = this.mTextHelper.sA.sI;
      AppMethodBeat.o(200411);
      return i;
    }
    AppMethodBeat.o(200411);
    return 0;
  }
  
  public ColorStateList getSupportBackgroundTintList()
  {
    AppMethodBeat.i(200288);
    if (this.mBackgroundTintHelper != null)
    {
      ColorStateList localColorStateList = this.mBackgroundTintHelper.getSupportBackgroundTintList();
      AppMethodBeat.o(200288);
      return localColorStateList;
    }
    AppMethodBeat.o(200288);
    return null;
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    AppMethodBeat.i(200300);
    if (this.mBackgroundTintHelper != null)
    {
      PorterDuff.Mode localMode = this.mBackgroundTintHelper.getSupportBackgroundTintMode();
      AppMethodBeat.o(200300);
      return localMode;
    }
    AppMethodBeat.o(200300);
    return null;
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(200318);
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(Button.class.getName());
    AppMethodBeat.o(200318);
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    AppMethodBeat.i(200326);
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName(Button.class.getName());
    AppMethodBeat.o(200326);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(200338);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.mTextHelper != null) {
      this.mTextHelper.eu();
    }
    AppMethodBeat.o(200338);
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(200360);
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    if ((this.mTextHelper != null) && (!bwp) && (this.mTextHelper.sA.eA())) {
      this.mTextHelper.sA.ey();
    }
    AppMethodBeat.o(200360);
  }
  
  public void setAutoSizeTextTypeUniformWithConfiguration(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(200385);
    if (bwp)
    {
      super.setAutoSizeTextTypeUniformWithConfiguration(paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(200385);
      return;
    }
    if (this.mTextHelper != null) {
      this.mTextHelper.setAutoSizeTextTypeUniformWithConfiguration(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(200385);
  }
  
  public void setAutoSizeTextTypeUniformWithPresetSizes(int[] paramArrayOfInt, int paramInt)
  {
    AppMethodBeat.i(200398);
    if (bwp)
    {
      super.setAutoSizeTextTypeUniformWithPresetSizes(paramArrayOfInt, paramInt);
      AppMethodBeat.o(200398);
      return;
    }
    if (this.mTextHelper != null) {
      this.mTextHelper.setAutoSizeTextTypeUniformWithPresetSizes(paramArrayOfInt, paramInt);
    }
    AppMethodBeat.o(200398);
  }
  
  public void setAutoSizeTextTypeWithDefaults(int paramInt)
  {
    AppMethodBeat.i(200375);
    if (bwp)
    {
      super.setAutoSizeTextTypeWithDefaults(paramInt);
      AppMethodBeat.o(200375);
      return;
    }
    if (this.mTextHelper != null) {
      this.mTextHelper.setAutoSizeTextTypeWithDefaults(paramInt);
    }
    AppMethodBeat.o(200375);
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(200266);
    super.setBackgroundDrawable(paramDrawable);
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.ek();
    }
    AppMethodBeat.o(200266);
  }
  
  public void setBackgroundResource(int paramInt)
  {
    AppMethodBeat.i(200255);
    super.setBackgroundResource(paramInt);
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.ap(paramInt);
    }
    AppMethodBeat.o(200255);
  }
  
  public void setCustomSelectionActionModeCallback(ActionMode.Callback paramCallback)
  {
    AppMethodBeat.i(200484);
    super.setCustomSelectionActionModeCallback(j.a(this, paramCallback));
    AppMethodBeat.o(200484);
  }
  
  public void setSupportAllCaps(boolean paramBoolean)
  {
    AppMethodBeat.i(200467);
    if (this.mTextHelper != null) {
      this.mTextHelper.setAllCaps(paramBoolean);
    }
    AppMethodBeat.o(200467);
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(200276);
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.setSupportBackgroundTintList(paramColorStateList);
    }
    AppMethodBeat.o(200276);
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(200296);
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.setSupportBackgroundTintMode(paramMode);
    }
    AppMethodBeat.o(200296);
  }
  
  public void setTextAppearance(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(200311);
    super.setTextAppearance(paramContext, paramInt);
    if (this.mTextHelper != null) {
      this.mTextHelper.s(paramContext, paramInt);
    }
    AppMethodBeat.o(200311);
  }
  
  public void setTextSize(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(200348);
    if (bwp)
    {
      super.setTextSize(paramInt, paramFloat);
      AppMethodBeat.o(200348);
      return;
    }
    if (this.mTextHelper != null) {
      this.mTextHelper.setTextSize(paramInt, paramFloat);
    }
    AppMethodBeat.o(200348);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.widget.AppCompatButton
 * JD-Core Version:    0.7.0.1
 */