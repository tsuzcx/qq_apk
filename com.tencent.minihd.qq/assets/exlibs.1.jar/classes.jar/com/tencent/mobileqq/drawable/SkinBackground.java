package com.tencent.mobileqq.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.theme.SkinnableBitmapDrawable;

public class SkinBackground
{
  public static Drawable a(Resources paramResources, int paramInt)
  {
    Object localObject = Shader.TileMode.REPEAT;
    Drawable localDrawable = paramResources.getDrawable(paramInt);
    Bitmap localBitmap;
    int i;
    if ((localDrawable instanceof BitmapDrawable))
    {
      localBitmap = ((BitmapDrawable)localDrawable).getBitmap();
      localObject = ((BitmapDrawable)localDrawable).getTileModeX();
      i = ((BitmapDrawable)localDrawable).getGravity();
    }
    for (;;)
    {
      if ((localBitmap == null) || (localObject == Shader.TileMode.REPEAT) || (i != 48))
      {
        return paramResources.getDrawable(paramInt);
        if ((localDrawable instanceof SkinnableBitmapDrawable))
        {
          localBitmap = ((SkinnableBitmapDrawable)localDrawable).getBitmap();
          localObject = ((SkinnableBitmapDrawable)localDrawable).getTileModeX();
          i = ((SkinnableBitmapDrawable)localDrawable).getGravity();
        }
      }
      else
      {
        localObject = new SkinBackground();
        localObject.getClass();
        paramResources = new SkinBackground.SkinBackgroudDrawable((SkinBackground)localObject, paramResources, localBitmap);
        paramResources.setGravity(i);
        return paramResources;
      }
      i = 119;
      localBitmap = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.drawable.SkinBackground
 * JD-Core Version:    0.7.0.1
 */