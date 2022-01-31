package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.p;
import android.support.v4.widget.b;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;

public class AppCompatTextView
  extends TextView
  implements p, b
{
  private final f Zo = new f(this);
  private final m Zp;
  
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
    super(au.V(paramContext), paramAttributeSet, paramInt);
    this.Zo.b(paramAttributeSet, paramInt);
    this.Zp = m.d(this);
    this.Zp.b(paramAttributeSet, paramInt);
    this.Zp.gm();
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (this.Zo != null) {
      this.Zo.gf();
    }
    if (this.Zp != null) {
      this.Zp.gm();
    }
  }
  
  public int getAutoSizeMaxTextSize()
  {
    if (IY) {
      return super.getAutoSizeMaxTextSize();
    }
    if (this.Zp != null) {
      return Math.round(this.Zp.aaA.aaN);
    }
    return -1;
  }
  
  public int getAutoSizeMinTextSize()
  {
    if (IY) {
      return super.getAutoSizeMinTextSize();
    }
    if (this.Zp != null) {
      return Math.round(this.Zp.aaA.aaM);
    }
    return -1;
  }
  
  public int getAutoSizeStepGranularity()
  {
    if (IY) {
      return super.getAutoSizeStepGranularity();
    }
    if (this.Zp != null) {
      return Math.round(this.Zp.aaA.aaL);
    }
    return -1;
  }
  
  public int[] getAutoSizeTextAvailableSizes()
  {
    if (IY) {
      return super.getAutoSizeTextAvailableSizes();
    }
    if (this.Zp != null) {
      return this.Zp.aaA.aaO;
    }
    return new int[0];
  }
  
  public int getAutoSizeTextType()
  {
    if (IY)
    {
      if (super.getAutoSizeTextType() == 1) {
        return 1;
      }
      return 0;
    }
    if (this.Zp != null) {
      return this.Zp.aaA.aaJ;
    }
    return 0;
  }
  
  public ColorStateList getSupportBackgroundTintList()
  {
    if (this.Zo != null) {
      return this.Zo.getSupportBackgroundTintList();
    }
    return null;
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    if (this.Zo != null) {
      return this.Zo.getSupportBackgroundTintMode();
    }
    return null;
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    return i.a(super.onCreateInputConnection(paramEditorInfo), paramEditorInfo, this);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.Zp != null) {
      this.Zp.gn();
    }
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    if ((this.Zp != null) && (!IY) && (this.Zp.aaA.gr())) {
      this.Zp.aaA.gq();
    }
  }
  
  public void setAutoSizeTextTypeUniformWithConfiguration(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (IY) {
      super.setAutoSizeTextTypeUniformWithConfiguration(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    while (this.Zp == null) {
      return;
    }
    this.Zp.setAutoSizeTextTypeUniformWithConfiguration(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setAutoSizeTextTypeUniformWithPresetSizes(int[] paramArrayOfInt, int paramInt)
  {
    if (IY) {
      super.setAutoSizeTextTypeUniformWithPresetSizes(paramArrayOfInt, paramInt);
    }
    while (this.Zp == null) {
      return;
    }
    this.Zp.setAutoSizeTextTypeUniformWithPresetSizes(paramArrayOfInt, paramInt);
  }
  
  public void setAutoSizeTextTypeWithDefaults(int paramInt)
  {
    if (IY) {
      super.setAutoSizeTextTypeWithDefaults(paramInt);
    }
    while (this.Zp == null) {
      return;
    }
    this.Zp.setAutoSizeTextTypeWithDefaults(paramInt);
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
    if (this.Zo != null) {
      this.Zo.ge();
    }
  }
  
  public void setBackgroundResource(int paramInt)
  {
    super.setBackgroundResource(paramInt);
    if (this.Zo != null) {
      this.Zo.bp(paramInt);
    }
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    if (this.Zo != null) {
      this.Zo.setSupportBackgroundTintList(paramColorStateList);
    }
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    if (this.Zo != null) {
      this.Zo.setSupportBackgroundTintMode(paramMode);
    }
  }
  
  public void setTextAppearance(Context paramContext, int paramInt)
  {
    super.setTextAppearance(paramContext, paramInt);
    if (this.Zp != null) {
      this.Zp.p(paramContext, paramInt);
    }
  }
  
  public void setTextSize(int paramInt, float paramFloat)
  {
    if (IY) {
      super.setTextSize(paramInt, paramFloat);
    }
    while (this.Zp == null) {
      return;
    }
    this.Zp.setTextSize(paramInt, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.AppCompatTextView
 * JD-Core Version:    0.7.0.1
 */