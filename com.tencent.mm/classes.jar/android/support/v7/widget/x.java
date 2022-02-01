package android.support.v7.widget;

import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build.VERSION;
import android.support.v4.graphics.drawable.a;
import android.support.v4.graphics.drawable.f;
import android.support.v7.d.a.c;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class x
{
  public static final Rect amD = new Rect();
  private static Class<?> amE;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 18) {}
    try
    {
      amE = Class.forName("android.graphics.Insets");
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException) {}
  }
  
  public static PorterDuff.Mode a(int paramInt, PorterDuff.Mode paramMode)
  {
    switch (paramInt)
    {
    case 4: 
    case 6: 
    case 7: 
    case 8: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    default: 
      return paramMode;
    case 3: 
      return PorterDuff.Mode.SRC_OVER;
    case 5: 
      return PorterDuff.Mode.SRC_IN;
    case 9: 
      return PorterDuff.Mode.SRC_ATOP;
    case 14: 
      return PorterDuff.Mode.MULTIPLY;
    case 15: 
      return PorterDuff.Mode.SCREEN;
    }
    return PorterDuff.Mode.ADD;
  }
  
  public static Rect r(Drawable paramDrawable)
  {
    if (amE != null) {}
    for (;;)
    {
      Object localObject;
      Rect localRect;
      int j;
      String str;
      int i;
      try
      {
        paramDrawable = a.j(paramDrawable);
        localObject = paramDrawable.getClass().getMethod("getOpticalInsets", new Class[0]).invoke(paramDrawable, new Object[0]);
        if (localObject == null) {
          break label207;
        }
        localRect = new Rect();
        Field[] arrayOfField = amE.getFields();
        int k = arrayOfField.length;
        j = 0;
        paramDrawable = localRect;
        if (j >= k) {
          break label211;
        }
        paramDrawable = arrayOfField[j];
        str = paramDrawable.getName();
        i = -1;
        switch (str.hashCode())
        {
        case 3317767: 
          if (!str.equals("left")) {
            break label255;
          }
          i = 0;
        }
      }
      catch (Exception paramDrawable) {}
      if (str.equals("top"))
      {
        i = 1;
        break label255;
        if (str.equals("right"))
        {
          i = 2;
          break label255;
          if (str.equals("bottom"))
          {
            i = 3;
            break label255;
            localRect.left = paramDrawable.getInt(localObject);
            break label288;
            label207:
            paramDrawable = amD;
            label211:
            return paramDrawable;
            localRect.top = paramDrawable.getInt(localObject);
            break label288;
            localRect.right = paramDrawable.getInt(localObject);
            break label288;
            localRect.bottom = paramDrawable.getInt(localObject);
            break label288;
          }
        }
      }
      label255:
      switch (i)
      {
      }
      label288:
      j += 1;
    }
  }
  
  static void s(Drawable paramDrawable)
  {
    int[] arrayOfInt;
    if ((Build.VERSION.SDK_INT == 21) && ("android.graphics.drawable.VectorDrawable".equals(paramDrawable.getClass().getName())))
    {
      arrayOfInt = paramDrawable.getState();
      if ((arrayOfInt != null) && (arrayOfInt.length != 0)) {
        break label52;
      }
      paramDrawable.setState(av.jT);
    }
    for (;;)
    {
      paramDrawable.setState(arrayOfInt);
      return;
      label52:
      paramDrawable.setState(av.EMPTY_STATE_SET);
    }
  }
  
  public static boolean t(Drawable paramDrawable)
  {
    for (;;)
    {
      if ((Build.VERSION.SDK_INT < 15) && ((paramDrawable instanceof InsetDrawable))) {
        return false;
      }
      if ((Build.VERSION.SDK_INT < 15) && ((paramDrawable instanceof GradientDrawable))) {
        return false;
      }
      if ((Build.VERSION.SDK_INT < 17) && ((paramDrawable instanceof LayerDrawable))) {
        return false;
      }
      if ((paramDrawable instanceof DrawableContainer))
      {
        paramDrawable = paramDrawable.getConstantState();
        if (!(paramDrawable instanceof DrawableContainer.DrawableContainerState)) {
          break;
        }
        paramDrawable = ((DrawableContainer.DrawableContainerState)paramDrawable).getChildren();
        int j = paramDrawable.length;
        int i = 0;
        while (i < j)
        {
          if (!t(paramDrawable[i])) {
            return false;
          }
          i += 1;
        }
      }
      if ((paramDrawable instanceof f))
      {
        paramDrawable = ((f)paramDrawable).eB();
      }
      else if ((paramDrawable instanceof c))
      {
        paramDrawable = ((c)paramDrawable).mDrawable;
      }
      else
      {
        if (!(paramDrawable instanceof ScaleDrawable)) {
          break;
        }
        paramDrawable = ((ScaleDrawable)paramDrawable).getDrawable();
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.x
 * JD-Core Version:    0.7.0.1
 */