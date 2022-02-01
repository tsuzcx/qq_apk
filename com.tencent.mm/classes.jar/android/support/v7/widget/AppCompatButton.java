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
  private final e akc = new e(this);
  private final l akd;
  
  public AppCompatButton(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AppCompatButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130968732);
  }
  
  public AppCompatButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(aw.ae(paramContext), paramAttributeSet, paramInt);
    this.akc.a(paramAttributeSet, paramInt);
    this.akd = new l(this);
    this.akd.a(paramAttributeSet, paramInt);
    this.akd.jo();
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
    if (this.akd != null) {
      this.akd.jp();
    }
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
  
  public void setSupportAllCaps(boolean paramBoolean)
  {
    if (this.akd != null) {
      this.akd.setAllCaps(paramBoolean);
    }
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
 * Qualified Name:     android.support.v7.widget.AppCompatButton
 * JD-Core Version:    0.7.0.1
 */