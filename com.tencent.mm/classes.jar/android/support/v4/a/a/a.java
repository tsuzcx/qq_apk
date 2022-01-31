package android.support.v4.a.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.graphics.drawable.InsetDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;

public final class a
{
  private static Method Ai;
  private static boolean Aj;
  private static Method Ak;
  private static boolean Al;
  
  public static void a(Drawable paramDrawable, float paramFloat1, float paramFloat2)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramDrawable.setHotspot(paramFloat1, paramFloat2);
    }
  }
  
  public static void a(Drawable paramDrawable, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramDrawable.setTint(paramInt);
    }
    while (!(paramDrawable instanceof e)) {
      return;
    }
    ((e)paramDrawable).setTint(paramInt);
  }
  
  public static void a(Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramDrawable.setHotspotBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public static void a(Drawable paramDrawable, ColorStateList paramColorStateList)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramDrawable.setTintList(paramColorStateList);
    }
    while (!(paramDrawable instanceof e)) {
      return;
    }
    ((e)paramDrawable).setTintList(paramColorStateList);
  }
  
  public static void a(Drawable paramDrawable, Resources.Theme paramTheme)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramDrawable.applyTheme(paramTheme);
    }
  }
  
  public static void a(Drawable paramDrawable, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramDrawable.inflate(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
      return;
    }
    paramDrawable.inflate(paramResources, paramXmlPullParser, paramAttributeSet);
  }
  
  public static void a(Drawable paramDrawable, PorterDuff.Mode paramMode)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramDrawable.setTintMode(paramMode);
    }
    while (!(paramDrawable instanceof e)) {
      return;
    }
    ((e)paramDrawable).setTintMode(paramMode);
  }
  
  public static void a(Drawable paramDrawable, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      paramDrawable.setAutoMirrored(paramBoolean);
    }
  }
  
  public static boolean b(Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return paramDrawable.isAutoMirrored();
    }
    return false;
  }
  
  public static boolean b(Drawable paramDrawable, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramDrawable.setLayoutDirection(paramInt);
    }
    if ((Build.VERSION.SDK_INT < 17) || (!Aj)) {}
    try
    {
      Method localMethod = Drawable.class.getDeclaredMethod("setLayoutDirection", new Class[] { Integer.TYPE });
      Ai = localMethod;
      localMethod.setAccessible(true);
      label55:
      Aj = true;
      if (Ai != null) {
        try
        {
          Ai.invoke(paramDrawable, new Object[] { Integer.valueOf(paramInt) });
          return true;
        }
        catch (Exception paramDrawable)
        {
          Ai = null;
        }
      }
      return false;
      return false;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label55;
    }
  }
  
  public static int c(Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return paramDrawable.getAlpha();
    }
    return 0;
  }
  
  public static boolean d(Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramDrawable.canApplyTheme();
    }
    return false;
  }
  
  public static void e(Drawable paramDrawable)
  {
    int i;
    int j;
    while ((Build.VERSION.SDK_INT < 23) && (Build.VERSION.SDK_INT >= 21))
    {
      paramDrawable.clearColorFilter();
      if ((paramDrawable instanceof InsetDrawable))
      {
        paramDrawable = ((InsetDrawable)paramDrawable).getDrawable();
      }
      else if ((paramDrawable instanceof f))
      {
        paramDrawable = ((f)paramDrawable).cr();
      }
      else
      {
        if (!(paramDrawable instanceof DrawableContainer)) {
          return;
        }
        paramDrawable = (DrawableContainer.DrawableContainerState)((DrawableContainer)paramDrawable).getConstantState();
        if (paramDrawable == null) {
          return;
        }
        i = 0;
        j = paramDrawable.getChildCount();
      }
    }
    while (i < j)
    {
      Drawable localDrawable = paramDrawable.getChild(i);
      if (localDrawable != null) {
        e(localDrawable);
      }
      i += 1;
      continue;
      paramDrawable.clearColorFilter();
    }
  }
  
  public static Drawable f(Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT >= 23) {}
    do
    {
      do
      {
        do
        {
          return paramDrawable;
          if (Build.VERSION.SDK_INT < 21) {
            break;
          }
        } while ((paramDrawable instanceof e));
        return new i(paramDrawable);
        if (Build.VERSION.SDK_INT < 19) {
          break;
        }
      } while ((paramDrawable instanceof e));
      return new h(paramDrawable);
    } while ((paramDrawable instanceof e));
    return new g(paramDrawable);
  }
  
  public static int g(Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramDrawable.getLayoutDirection();
    }
    if ((Build.VERSION.SDK_INT < 17) || (!Al)) {}
    try
    {
      Method localMethod = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
      Ak = localMethod;
      localMethod.setAccessible(true);
      label48:
      Al = true;
      if (Ak != null) {
        try
        {
          int i = ((Integer)Ak.invoke(paramDrawable, new Object[0])).intValue();
          return i;
        }
        catch (Exception paramDrawable)
        {
          Ak = null;
        }
      }
      return 0;
      return 0;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label48;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.a.a.a
 * JD-Core Version:    0.7.0.1
 */