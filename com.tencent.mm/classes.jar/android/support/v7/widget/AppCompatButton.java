package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.s;
import android.support.v4.widget.b;
import android.support.v4.widget.q;
import android.util.AttributeSet;
import android.view.ActionMode.Callback;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;

public class AppCompatButton
  extends Button
  implements s, b
{
  private final e ahY = new e(this);
  private final l ahZ;
  
  public AppCompatButton(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AppCompatButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130968719);
  }
  
  public AppCompatButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(aw.ac(paramContext), paramAttributeSet, paramInt);
    this.ahY.a(paramAttributeSet, paramInt);
    this.ahZ = new l(this);
    this.ahZ.a(paramAttributeSet, paramInt);
    this.ahZ.iP();
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
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(Button.class.getName());
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName(Button.class.getName());
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.ahZ != null) {
      this.ahZ.iQ();
    }
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
  
  public void setSupportAllCaps(boolean paramBoolean)
  {
    if (this.ahZ != null) {
      this.ahZ.setAllCaps(paramBoolean);
    }
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
 * Qualified Name:     android.support.v7.widget.AppCompatButton
 * JD-Core Version:    0.7.0.1
 */