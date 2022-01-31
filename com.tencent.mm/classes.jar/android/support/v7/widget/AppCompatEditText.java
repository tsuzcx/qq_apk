package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.p;
import android.support.v7.a.a.a;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;

public class AppCompatEditText
  extends EditText
  implements p
{
  private final f Zo = new f(this);
  private final m Zp;
  
  public AppCompatEditText(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AppCompatEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.a.editTextStyle);
  }
  
  public AppCompatEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.AppCompatEditText
 * JD-Core Version:    0.7.0.1
 */