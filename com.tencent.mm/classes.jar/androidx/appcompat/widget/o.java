package androidx.appcompat.widget;

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
import androidx.appcompat.b.a.c;
import androidx.core.graphics.drawable.a;
import androidx.core.graphics.drawable.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class o
{
  public static final Rect se;
  private static Class<?> sf;
  
  static
  {
    AppMethodBeat.i(241244);
    se = new Rect();
    if (Build.VERSION.SDK_INT >= 18) {
      try
      {
        sf = Class.forName("android.graphics.Insets");
        AppMethodBeat.o(241244);
        return;
      }
      catch (ClassNotFoundException localClassNotFoundException) {}
    }
    AppMethodBeat.o(241244);
  }
  
  public static PorterDuff.Mode c(int paramInt, PorterDuff.Mode paramMode)
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
  
  public static Rect g(Drawable paramDrawable)
  {
    AppMethodBeat.i(241241);
    if (sf != null) {}
    for (;;)
    {
      Rect localRect;
      int j;
      Field localField;
      String str;
      int i;
      try
      {
        paramDrawable = a.q(paramDrawable);
        paramDrawable = paramDrawable.getClass().getMethod("getOpticalInsets", new Class[0]).invoke(paramDrawable, new Object[0]);
        if (paramDrawable == null) {
          break label207;
        }
        localRect = new Rect();
        Field[] arrayOfField = sf.getFields();
        int k = arrayOfField.length;
        j = 0;
        if (j >= k) {
          break label260;
        }
        localField = arrayOfField[j];
        str = localField.getName();
        i = -1;
        switch (str.hashCode())
        {
        case 3317767: 
          if (!str.equals("left")) {
            break label268;
          }
          i = 0;
        }
      }
      catch (Exception paramDrawable) {}
      if (str.equals("top"))
      {
        i = 1;
        break label268;
        if (str.equals("right"))
        {
          i = 2;
          break label268;
          if (str.equals("bottom"))
          {
            i = 3;
            break label268;
            localRect.left = localField.getInt(paramDrawable);
            break label300;
            label207:
            paramDrawable = se;
            AppMethodBeat.o(241241);
            return paramDrawable;
            localRect.top = localField.getInt(paramDrawable);
            break label300;
            localRect.right = localField.getInt(paramDrawable);
            break label300;
            localRect.bottom = localField.getInt(paramDrawable);
            break label300;
            label260:
            AppMethodBeat.o(241241);
            return localRect;
          }
        }
      }
      label268:
      switch (i)
      {
      }
      label300:
      j += 1;
    }
  }
  
  static void h(Drawable paramDrawable)
  {
    AppMethodBeat.i(241242);
    int[] arrayOfInt;
    if ((Build.VERSION.SDK_INT == 21) && ("android.graphics.drawable.VectorDrawable".equals(paramDrawable.getClass().getName())))
    {
      arrayOfInt = paramDrawable.getState();
      if ((arrayOfInt != null) && (arrayOfInt.length != 0)) {
        break label62;
      }
      paramDrawable.setState(y.wo);
    }
    for (;;)
    {
      paramDrawable.setState(arrayOfInt);
      AppMethodBeat.o(241242);
      return;
      label62:
      paramDrawable.setState(y.ww);
    }
  }
  
  public static boolean i(Drawable paramDrawable)
  {
    AppMethodBeat.i(241243);
    for (;;)
    {
      if ((Build.VERSION.SDK_INT < 15) && ((paramDrawable instanceof InsetDrawable)))
      {
        AppMethodBeat.o(241243);
        return false;
      }
      if ((Build.VERSION.SDK_INT < 15) && ((paramDrawable instanceof GradientDrawable)))
      {
        AppMethodBeat.o(241243);
        return false;
      }
      if ((Build.VERSION.SDK_INT < 17) && ((paramDrawable instanceof LayerDrawable)))
      {
        AppMethodBeat.o(241243);
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
          if (!i(paramDrawable[i]))
          {
            AppMethodBeat.o(241243);
            return false;
          }
          i += 1;
        }
      }
      if ((paramDrawable instanceof f))
      {
        paramDrawable = ((f)paramDrawable).gD();
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
    AppMethodBeat.o(241243);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.widget.o
 * JD-Core Version:    0.7.0.1
 */