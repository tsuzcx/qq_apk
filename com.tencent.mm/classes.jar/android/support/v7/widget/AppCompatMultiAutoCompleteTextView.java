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
  private static final int[] afE = { 16843126 };
  private final e ajP;
  private final l ajQ;
  
  public AppCompatMultiAutoCompleteTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130968660);
  }
  
  public AppCompatMultiAutoCompleteTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(aw.ac(paramContext), paramAttributeSet, paramInt);
    paramContext = az.a(getContext(), paramAttributeSet, afE, paramInt, 0);
    if (paramContext.hasValue(0)) {
      setDropDownBackgroundDrawable(paramContext.getDrawable(0));
    }
    paramContext.ayA.recycle();
    this.ajP = new e(this);
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
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    return h.a(super.onCreateInputConnection(paramEditorInfo), paramEditorInfo, this);
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
  
  public void setDropDownBackgroundResource(int paramInt)
  {
    setDropDownBackgroundDrawable(a.l(getContext(), paramInt));
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.AppCompatMultiAutoCompleteTextView
 * JD-Core Version:    0.7.0.1
 */