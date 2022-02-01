package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.widget.ImageView;

public final class l
{
  public static ColorStateList a(ImageView paramImageView)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramImageView.getImageTintList();
    }
    if ((paramImageView instanceof s)) {
      return ((s)paramImageView).getSupportImageTintList();
    }
    return null;
  }
  
  public static void a(ImageView paramImageView, ColorStateList paramColorStateList)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramImageView.setImageTintList(paramColorStateList);
      if (Build.VERSION.SDK_INT == 21)
      {
        paramColorStateList = paramImageView.getDrawable();
        if ((paramImageView.getImageTintList() == null) || (paramImageView.getImageTintMode() == null)) {
          break label72;
        }
        i = 1;
        if ((paramColorStateList != null) && (i != 0))
        {
          if (paramColorStateList.isStateful()) {
            paramColorStateList.setState(paramImageView.getDrawableState());
          }
          paramImageView.setImageDrawable(paramColorStateList);
        }
      }
    }
    label72:
    while (!(paramImageView instanceof s)) {
      for (;;)
      {
        return;
        int i = 0;
      }
    }
    ((s)paramImageView).setSupportImageTintList(paramColorStateList);
  }
  
  public static void a(ImageView paramImageView, PorterDuff.Mode paramMode)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramImageView.setImageTintMode(paramMode);
      if (Build.VERSION.SDK_INT == 21)
      {
        paramMode = paramImageView.getDrawable();
        if ((paramImageView.getImageTintList() == null) || (paramImageView.getImageTintMode() == null)) {
          break label72;
        }
        i = 1;
        if ((paramMode != null) && (i != 0))
        {
          if (paramMode.isStateful()) {
            paramMode.setState(paramImageView.getDrawableState());
          }
          paramImageView.setImageDrawable(paramMode);
        }
      }
    }
    label72:
    while (!(paramImageView instanceof s)) {
      for (;;)
      {
        return;
        int i = 0;
      }
    }
    ((s)paramImageView).setSupportImageTintMode(paramMode);
  }
  
  public static PorterDuff.Mode b(ImageView paramImageView)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramImageView.getImageTintMode();
    }
    if ((paramImageView instanceof s)) {
      return ((s)paramImageView).getSupportImageTintMode();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.widget.l
 * JD-Core Version:    0.7.0.1
 */