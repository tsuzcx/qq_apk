package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.view.p;
import android.support.v4.widget.q;
import android.support.v7.a.a.a;
import android.util.AttributeSet;
import android.widget.ImageButton;

public class AppCompatImageButton
  extends ImageButton
  implements p, q
{
  private final f Zo = new f(this);
  private final j iw;
  
  public AppCompatImageButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.a.imageButtonStyle);
  }
  
  public AppCompatImageButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(au.V(paramContext), paramAttributeSet, paramInt);
    this.Zo.b(paramAttributeSet, paramInt);
    this.iw = new j(this);
    this.iw.b(paramAttributeSet, paramInt);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (this.Zo != null) {
      this.Zo.gf();
    }
    if (this.iw != null) {
      this.iw.gj();
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
  
  public ColorStateList getSupportImageTintList()
  {
    if (this.iw != null) {
      return this.iw.getSupportImageTintList();
    }
    return null;
  }
  
  public PorterDuff.Mode getSupportImageTintMode()
  {
    if (this.iw != null) {
      return this.iw.getSupportImageTintMode();
    }
    return null;
  }
  
  public boolean hasOverlappingRendering()
  {
    return (this.iw.hasOverlappingRendering()) && (super.hasOverlappingRendering());
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
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    super.setImageBitmap(paramBitmap);
    if (this.iw != null) {
      this.iw.gj();
    }
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    if (this.iw != null) {
      this.iw.gj();
    }
  }
  
  public void setImageResource(int paramInt)
  {
    this.iw.setImageResource(paramInt);
  }
  
  public void setImageURI(Uri paramUri)
  {
    super.setImageURI(paramUri);
    if (this.iw != null) {
      this.iw.gj();
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
  
  public void setSupportImageTintList(ColorStateList paramColorStateList)
  {
    if (this.iw != null) {
      this.iw.setSupportImageTintList(paramColorStateList);
    }
  }
  
  public void setSupportImageTintMode(PorterDuff.Mode paramMode)
  {
    if (this.iw != null) {
      this.iw.setSupportImageTintMode(paramMode);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.AppCompatImageButton
 * JD-Core Version:    0.7.0.1
 */