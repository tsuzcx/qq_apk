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
  private static final int[] afR = { 16843126 };
  private final e akc;
  private final l akd;
  
  public AppCompatMultiAutoCompleteTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130968665);
  }
  
  public AppCompatMultiAutoCompleteTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(aw.ae(paramContext), paramAttributeSet, paramInt);
    paramContext = az.a(getContext(), paramAttributeSet, afR, paramInt, 0);
    if (paramContext.hasValue(0)) {
      setDropDownBackgroundDrawable(paramContext.getDrawable(0));
    }
    paramContext.ayy.recycle();
    this.akc = new e(this);
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
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    return h.a(super.onCreateInputConnection(paramEditorInfo), paramEditorInfo, this);
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
  
  public void setDropDownBackgroundResource(int paramInt)
  {
    setDropDownBackgroundDrawable(a.l(getContext(), paramInt));
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.AppCompatMultiAutoCompleteTextView
 * JD-Core Version:    0.7.0.1
 */