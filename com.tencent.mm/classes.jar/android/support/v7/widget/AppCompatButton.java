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
  private final e ZZ = new e(this);
  private final l aaa;
  
  public AppCompatButton(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AppCompatButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130772225);
  }
  
  public AppCompatButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(aw.Z(paramContext), paramAttributeSet, paramInt);
    this.ZZ.a(paramAttributeSet, paramInt);
    this.aaa = new l(this);
    this.aaa.a(paramAttributeSet, paramInt);
    this.aaa.hk();
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
    if (this.aaa != null) {
      this.aaa.hl();
    }
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
  
  public void setSupportAllCaps(boolean paramBoolean)
  {
    if (this.aaa != null) {
      this.aaa.setAllCaps(paramBoolean);
    }
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
 * Qualified Name:     android.support.v7.widget.AppCompatButton
 * JD-Core Version:    0.7.0.1
 */