package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageButton;

public class AppCompatImageButton
  extends ImageButton
  implements android.support.v4.view.s, android.support.v4.widget.s
{
  private final e ajP = new e(this);
  private final i aks;
  
  public AppCompatImageButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130969084);
  }
  
  public AppCompatImageButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(aw.ad(paramContext), paramAttributeSet, paramInt);
    this.ajP.a(paramAttributeSet, paramInt);
    this.aks = new i(this);
    this.aks.a(paramAttributeSet, paramInt);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (this.ajP != null) {
      this.ajP.iX();
    }
    if (this.aks != null) {
      this.aks.jc();
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
  
  public ColorStateList getSupportImageTintList()
  {
    if (this.aks != null) {
      return this.aks.getSupportImageTintList();
    }
    return null;
  }
  
  public PorterDuff.Mode getSupportImageTintMode()
  {
    if (this.aks != null) {
      return this.aks.getSupportImageTintMode();
    }
    return null;
  }
  
  public boolean hasOverlappingRendering()
  {
    return (this.aks.hasOverlappingRendering()) && (super.hasOverlappingRendering());
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
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    super.setImageBitmap(paramBitmap);
    if (this.aks != null) {
      this.aks.jc();
    }
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    if (this.aks != null) {
      this.aks.jc();
    }
  }
  
  public void setImageResource(int paramInt)
  {
    this.aks.setImageResource(paramInt);
  }
  
  public void setImageURI(Uri paramUri)
  {
    super.setImageURI(paramUri);
    if (this.aks != null) {
      this.aks.jc();
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
  
  public void setSupportImageTintList(ColorStateList paramColorStateList)
  {
    if (this.aks != null) {
      this.aks.setSupportImageTintList(paramColorStateList);
    }
  }
  
  public void setSupportImageTintMode(PorterDuff.Mode paramMode)
  {
    if (this.aks != null) {
      this.aks.setSupportImageTintMode(paramMode);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.AppCompatImageButton
 * JD-Core Version:    0.7.0.1
 */