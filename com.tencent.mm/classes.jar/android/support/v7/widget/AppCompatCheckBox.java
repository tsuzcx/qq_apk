package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.r;
import android.support.v7.c.a.a;
import android.util.AttributeSet;
import android.widget.CheckBox;

public class AppCompatCheckBox
  extends CheckBox
  implements r
{
  private final f aif = new f(this);
  
  public AppCompatCheckBox(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130968744);
  }
  
  public AppCompatCheckBox(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(aw.ac(paramContext), paramAttributeSet, paramInt);
    this.aif.a(paramAttributeSet, paramInt);
  }
  
  public int getCompoundPaddingLeft()
  {
    int j = super.getCompoundPaddingLeft();
    int i = j;
    if (this.aif != null) {
      i = this.aif.bH(j);
    }
    return i;
  }
  
  public ColorStateList getSupportButtonTintList()
  {
    if (this.aif != null) {
      return this.aif.aih;
    }
    return null;
  }
  
  public PorterDuff.Mode getSupportButtonTintMode()
  {
    if (this.aif != null) {
      return this.aif.aii;
    }
    return null;
  }
  
  public void setButtonDrawable(int paramInt)
  {
    setButtonDrawable(a.l(getContext(), paramInt));
  }
  
  public void setButtonDrawable(Drawable paramDrawable)
  {
    super.setButtonDrawable(paramDrawable);
    if (this.aif != null) {
      this.aif.iJ();
    }
  }
  
  public void setSupportButtonTintList(ColorStateList paramColorStateList)
  {
    if (this.aif != null) {
      this.aif.setSupportButtonTintList(paramColorStateList);
    }
  }
  
  public void setSupportButtonTintMode(PorterDuff.Mode paramMode)
  {
    if (this.aif != null) {
      this.aif.setSupportButtonTintMode(paramMode);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.AppCompatCheckBox
 * JD-Core Version:    0.7.0.1
 */