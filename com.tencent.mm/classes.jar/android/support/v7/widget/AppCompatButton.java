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
  private final e ahe = new e(this);
  private final l ahf;
  
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
    super(aw.ab(paramContext), paramAttributeSet, paramInt);
    this.ahe.a(paramAttributeSet, paramInt);
    this.ahf = new l(this);
    this.ahf.a(paramAttributeSet, paramInt);
    this.ahf.iH();
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
    if (this.ahf != null) {
      this.ahf.iI();
    }
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
  
  public void setSupportAllCaps(boolean paramBoolean)
  {
    if (this.ahf != null) {
      this.ahf.setAllCaps(paramBoolean);
    }
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
 * Qualified Name:     android.support.v7.widget.AppCompatButton
 * JD-Core Version:    0.7.0.1
 */