package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.r;
import android.support.v7.c.a.a;
import android.util.AttributeSet;
import android.widget.RadioButton;

public class AppCompatRadioButton
  extends RadioButton
  implements r
{
  private final l aaa;
  private final f aag = new f(this);
  
  public AppCompatRadioButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130772230);
  }
  
  public AppCompatRadioButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(aw.Z(paramContext), paramAttributeSet, paramInt);
    this.aag.a(paramAttributeSet, paramInt);
    this.aaa = new l(this);
    this.aaa.a(paramAttributeSet, paramInt);
  }
  
  public int getCompoundPaddingLeft()
  {
    int j = super.getCompoundPaddingLeft();
    int i = j;
    if (this.aag != null) {
      i = this.aag.bp(j);
    }
    return i;
  }
  
  public ColorStateList getSupportButtonTintList()
  {
    if (this.aag != null) {
      return this.aag.aai;
    }
    return null;
  }
  
  public PorterDuff.Mode getSupportButtonTintMode()
  {
    if (this.aag != null) {
      return this.aag.aaj;
    }
    return null;
  }
  
  public void setButtonDrawable(int paramInt)
  {
    setButtonDrawable(a.k(getContext(), paramInt));
  }
  
  public void setButtonDrawable(Drawable paramDrawable)
  {
    super.setButtonDrawable(paramDrawable);
    if (this.aag != null) {
      this.aag.he();
    }
  }
  
  public void setSupportButtonTintList(ColorStateList paramColorStateList)
  {
    if (this.aag != null) {
      this.aag.setSupportButtonTintList(paramColorStateList);
    }
  }
  
  public void setSupportButtonTintMode(PorterDuff.Mode paramMode)
  {
    if (this.aag != null) {
      this.aag.setSupportButtonTintMode(paramMode);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.AppCompatRadioButton
 * JD-Core Version:    0.7.0.1
 */