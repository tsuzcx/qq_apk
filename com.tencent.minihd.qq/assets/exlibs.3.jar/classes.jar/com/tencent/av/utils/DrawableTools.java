package com.tencent.av.utils;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;

public class DrawableTools
{
  public static Drawable a(Resources paramResources, int paramInt)
  {
    return a(paramResources, paramInt, 2131427851, 2130838740, 2131427852);
  }
  
  static Drawable a(Resources paramResources, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Drawable localDrawable = paramResources.getDrawable(paramInt1);
    TintStateDrawable localTintStateDrawable = TintStateDrawable.a(paramResources, paramInt1, paramInt2);
    localTintStateDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    localDrawable = paramResources.getDrawable(paramInt3);
    paramResources = TintStateDrawable.a(paramResources, paramInt3, paramInt4);
    paramResources.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    paramResources = new LayerDrawable(new Drawable[] { paramResources, localTintStateDrawable });
    paramResources.setLayerInset(0, 0, 0, 0, 0);
    paramResources.setLayerInset(1, 0, 0, 0, 0);
    paramResources.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    return paramResources;
  }
  
  public static Drawable b(Resources paramResources, int paramInt)
  {
    Drawable localDrawable = paramResources.getDrawable(paramInt);
    paramResources = TintStateDrawable.a(paramResources, paramInt, 2131427851);
    paramResources.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    return paramResources;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.av.utils.DrawableTools
 * JD-Core Version:    0.7.0.1
 */