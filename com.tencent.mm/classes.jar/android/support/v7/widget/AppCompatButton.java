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
  private final e ajP = new e(this);
  private final l ajQ;
  
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
    super(aw.ad(paramContext), paramAttributeSet, paramInt);
    this.ajP.a(paramAttributeSet, paramInt);
    this.ajQ = new l(this);
    this.ajQ.a(paramAttributeSet, paramInt);
    this.ajQ.jf();
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
    if (this.ajQ != null) {
      this.ajQ.jg();
    }
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
  
  public void setSupportAllCaps(boolean paramBoolean)
  {
    if (this.ajQ != null) {
      this.ajQ.setAllCaps(paramBoolean);
    }
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
 * Qualified Name:     android.support.v7.widget.AppCompatButton
 * JD-Core Version:    0.7.0.1
 */