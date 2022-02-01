package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;

public class AppCompatImageView
  extends ImageView
  implements android.support.v4.view.s, android.support.v4.widget.s
{
  private final i akF;
  private final e akc = new e(this);
  
  public AppCompatImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AppCompatImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AppCompatImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(aw.ae(paramContext), paramAttributeSet, paramInt);
    this.akc.a(paramAttributeSet, paramInt);
    this.akF = new i(this);
    this.akF.a(paramAttributeSet, paramInt);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (this.akc != null) {
      this.akc.jg();
    }
    if (this.akF != null) {
      this.akF.jl();
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
  
  public ColorStateList getSupportImageTintList()
  {
    if (this.akF != null) {
      return this.akF.getSupportImageTintList();
    }
    return null;
  }
  
  public PorterDuff.Mode getSupportImageTintMode()
  {
    if (this.akF != null) {
      return this.akF.getSupportImageTintMode();
    }
    return null;
  }
  
  public boolean hasOverlappingRendering()
  {
    return (this.akF.hasOverlappingRendering()) && (super.hasOverlappingRendering());
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
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    super.setImageBitmap(paramBitmap);
    if (this.akF != null) {
      this.akF.jl();
    }
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    if (this.akF != null) {
      this.akF.jl();
    }
  }
  
  public void setImageResource(int paramInt)
  {
    if (this.akF != null) {
      this.akF.setImageResource(paramInt);
    }
  }
  
  public void setImageURI(Uri paramUri)
  {
    super.setImageURI(paramUri);
    if (this.akF != null) {
      this.akF.jl();
    }
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
  
  public void setSupportImageTintList(ColorStateList paramColorStateList)
  {
    if (this.akF != null) {
      this.akF.setSupportImageTintList(paramColorStateList);
    }
  }
  
  public void setSupportImageTintMode(PorterDuff.Mode paramMode)
  {
    if (this.akF != null) {
      this.akF.setSupportImageTintMode(paramMode);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.AppCompatImageView
 * JD-Core Version:    0.7.0.1
 */