package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.s;
import android.support.v7.c.a.a;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.MultiAutoCompleteTextView;

public class AppCompatMultiAutoCompleteTextView
  extends MultiAutoCompleteTextView
  implements s
{
  private static final int[] adN = { 16843126 };
  private final e ahY;
  private final l ahZ;
  
  public AppCompatMultiAutoCompleteTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130968660);
  }
  
  public AppCompatMultiAutoCompleteTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(aw.ac(paramContext), paramAttributeSet, paramInt);
    paramContext = az.a(getContext(), paramAttributeSet, adN, paramInt, 0);
    if (paramContext.hasValue(0)) {
      setDropDownBackgroundDrawable(paramContext.getDrawable(0));
    }
    paramContext.awJ.recycle();
    this.ahY = new e(this);
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
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    return h.a(super.onCreateInputConnection(paramEditorInfo), paramEditorInfo, this);
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
  
  public void setDropDownBackgroundResource(int paramInt)
  {
    setDropDownBackgroundDrawable(a.l(getContext(), paramInt));
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.AppCompatMultiAutoCompleteTextView
 * JD-Core Version:    0.7.0.1
 */