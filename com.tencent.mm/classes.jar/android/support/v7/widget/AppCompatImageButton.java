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
  private final e ahY = new e(this);
  private final i aiB;
  
  public AppCompatImageButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130969084);
  }
  
  public AppCompatImageButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(aw.ac(paramContext), paramAttributeSet, paramInt);
    this.ahY.a(paramAttributeSet, paramInt);
    this.aiB = new i(this);
    this.aiB.a(paramAttributeSet, paramInt);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (this.ahY != null) {
      this.ahY.iH();
    }
    if (this.aiB != null) {
      this.aiB.iM();
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
  
  public ColorStateList getSupportImageTintList()
  {
    if (this.aiB != null) {
      return this.aiB.getSupportImageTintList();
    }
    return null;
  }
  
  public PorterDuff.Mode getSupportImageTintMode()
  {
    if (this.aiB != null) {
      return this.aiB.getSupportImageTintMode();
    }
    return null;
  }
  
  public boolean hasOverlappingRendering()
  {
    return (this.aiB.hasOverlappingRendering()) && (super.hasOverlappingRendering());
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
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    super.setImageBitmap(paramBitmap);
    if (this.aiB != null) {
      this.aiB.iM();
    }
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    if (this.aiB != null) {
      this.aiB.iM();
    }
  }
  
  public void setImageResource(int paramInt)
  {
    this.aiB.setImageResource(paramInt);
  }
  
  public void setImageURI(Uri paramUri)
  {
    super.setImageURI(paramUri);
    if (this.aiB != null) {
      this.aiB.iM();
    }
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
  
  public void setSupportImageTintList(ColorStateList paramColorStateList)
  {
    if (this.aiB != null) {
      this.aiB.setSupportImageTintList(paramColorStateList);
    }
  }
  
  public void setSupportImageTintMode(PorterDuff.Mode paramMode)
  {
    if (this.aiB != null) {
      this.aiB.setSupportImageTintMode(paramMode);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.AppCompatImageButton
 * JD-Core Version:    0.7.0.1
 */