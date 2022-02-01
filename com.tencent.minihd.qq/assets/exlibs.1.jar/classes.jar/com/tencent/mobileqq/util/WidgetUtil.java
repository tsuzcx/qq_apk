package com.tencent.mobileqq.util;

import android.graphics.BitmapShader;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.Shape;
import android.view.View;
import android.view.ViewGroup;

public class WidgetUtil
{
  public static Drawable a(Drawable paramDrawable, boolean paramBoolean, Shape paramShape)
  {
    int j = 0;
    Object localObject1;
    int i;
    Object localObject2;
    if ((paramDrawable instanceof LayerDrawable))
    {
      localObject1 = (LayerDrawable)paramDrawable;
      int k = ((LayerDrawable)localObject1).getNumberOfLayers();
      paramDrawable = new Drawable[k];
      i = 0;
      if (i < k)
      {
        int m = ((LayerDrawable)localObject1).getId(i);
        localObject2 = ((LayerDrawable)localObject1).getDrawable(i);
        if ((m == 16908301) || (m == 16908303)) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          paramDrawable[i] = a((Drawable)localObject2, paramBoolean, paramShape);
          i += 1;
          break;
        }
      }
      paramShape = new LayerDrawable(paramDrawable);
      i = j;
      for (;;)
      {
        paramDrawable = paramShape;
        if (i >= k) {
          break;
        }
        paramShape.setId(i, ((LayerDrawable)localObject1).getId(i));
        i += 1;
      }
    }
    if ((paramDrawable instanceof StateListDrawable))
    {
      localObject2 = (StateListDrawable)paramDrawable;
      localObject1 = new StateListDrawable();
      j = ((StateListDrawable)localObject2).getState().length;
      i = 0;
      for (;;)
      {
        paramDrawable = (Drawable)localObject1;
        if (i >= j) {
          break;
        }
        paramDrawable = new int[1];
        paramDrawable[0] = localObject2.getState()[i];
        ((StateListDrawable)localObject2).setState(paramDrawable);
        ((StateListDrawable)localObject1).addState(paramDrawable, a(((StateListDrawable)localObject2).getCurrent(), paramBoolean, paramShape));
        i += 1;
      }
    }
    if ((paramDrawable instanceof BitmapDrawable))
    {
      paramDrawable = ((BitmapDrawable)paramDrawable).getBitmap();
      paramShape = new ShapeDrawable(paramShape);
      paramDrawable = new BitmapShader(paramDrawable, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP);
      paramShape.getPaint().setShader(paramDrawable);
      if (paramBoolean)
      {
        paramDrawable = new ClipDrawable(paramShape, 3, 1);
        return paramDrawable;
      }
      return paramShape;
    }
    return paramDrawable;
  }
  
  public static boolean a(View paramView1, View paramView2)
  {
    if ((paramView1 == null) || (paramView2 == null)) {}
    for (;;)
    {
      return false;
      ViewGroup localViewGroup = (ViewGroup)paramView1.getParent();
      if ((localViewGroup != null) && (paramView2.getParent() == null))
      {
        int i = 0;
        while (i < localViewGroup.getChildCount())
        {
          if (localViewGroup.getChildAt(i) == paramView1)
          {
            localViewGroup.addView(paramView2, i);
            localViewGroup.removeView(paramView1);
            return true;
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.util.WidgetUtil
 * JD-Core Version:    0.7.0.1
 */