package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.widget.ImageView;

public final class j
{
  static final b KS = new a();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      KS = new c();
      return;
    }
  }
  
  public static void a(ImageView paramImageView, ColorStateList paramColorStateList)
  {
    KS.a(paramImageView, paramColorStateList);
  }
  
  public static void a(ImageView paramImageView, PorterDuff.Mode paramMode)
  {
    KS.a(paramImageView, paramMode);
  }
  
  public static ColorStateList b(ImageView paramImageView)
  {
    return KS.b(paramImageView);
  }
  
  public static PorterDuff.Mode c(ImageView paramImageView)
  {
    return KS.c(paramImageView);
  }
  
  static class a
    implements j.b
  {
    public void a(ImageView paramImageView, ColorStateList paramColorStateList)
    {
      if ((paramImageView instanceof q)) {
        ((q)paramImageView).setSupportImageTintList(paramColorStateList);
      }
    }
    
    public void a(ImageView paramImageView, PorterDuff.Mode paramMode)
    {
      if ((paramImageView instanceof q)) {
        ((q)paramImageView).setSupportImageTintMode(paramMode);
      }
    }
    
    public ColorStateList b(ImageView paramImageView)
    {
      if ((paramImageView instanceof q)) {
        return ((q)paramImageView).getSupportImageTintList();
      }
      return null;
    }
    
    public PorterDuff.Mode c(ImageView paramImageView)
    {
      if ((paramImageView instanceof q)) {
        return ((q)paramImageView).getSupportImageTintMode();
      }
      return null;
    }
  }
  
  static abstract interface b
  {
    public abstract void a(ImageView paramImageView, ColorStateList paramColorStateList);
    
    public abstract void a(ImageView paramImageView, PorterDuff.Mode paramMode);
    
    public abstract ColorStateList b(ImageView paramImageView);
    
    public abstract PorterDuff.Mode c(ImageView paramImageView);
  }
  
  static final class c
    extends j.a
  {
    public final void a(ImageView paramImageView, ColorStateList paramColorStateList)
    {
      paramImageView.setImageTintList(paramColorStateList);
      if (Build.VERSION.SDK_INT == 21)
      {
        paramColorStateList = paramImageView.getDrawable();
        if ((paramImageView.getImageTintList() == null) || (paramImageView.getImageTintMode() == null)) {
          break label64;
        }
      }
      label64:
      for (int i = 1;; i = 0)
      {
        if ((paramColorStateList != null) && (i != 0))
        {
          if (paramColorStateList.isStateful()) {
            paramColorStateList.setState(paramImageView.getDrawableState());
          }
          paramImageView.setImageDrawable(paramColorStateList);
        }
        return;
      }
    }
    
    public final void a(ImageView paramImageView, PorterDuff.Mode paramMode)
    {
      paramImageView.setImageTintMode(paramMode);
      if (Build.VERSION.SDK_INT == 21)
      {
        paramMode = paramImageView.getDrawable();
        if ((paramImageView.getImageTintList() == null) || (paramImageView.getImageTintMode() == null)) {
          break label64;
        }
      }
      label64:
      for (int i = 1;; i = 0)
      {
        if ((paramMode != null) && (i != 0))
        {
          if (paramMode.isStateful()) {
            paramMode.setState(paramImageView.getDrawableState());
          }
          paramImageView.setImageDrawable(paramMode);
        }
        return;
      }
    }
    
    public final ColorStateList b(ImageView paramImageView)
    {
      return paramImageView.getImageTintList();
    }
    
    public final PorterDuff.Mode c(ImageView paramImageView)
    {
      return paramImageView.getImageTintMode();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.widget.j
 * JD-Core Version:    0.7.0.1
 */