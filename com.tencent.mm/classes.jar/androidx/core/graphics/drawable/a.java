package androidx.core.graphics.drawable;

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
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;

public final class a
{
  private static Method KI;
  private static boolean KJ;
  private static Method KK;
  private static boolean KL;
  
  public static void a(Drawable paramDrawable, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(250807);
    if (Build.VERSION.SDK_INT >= 21) {
      paramDrawable.setHotspot(paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(250807);
  }
  
  public static void a(Drawable paramDrawable, int paramInt)
  {
    AppMethodBeat.i(250809);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramDrawable.setTint(paramInt);
      AppMethodBeat.o(250809);
      return;
    }
    if ((paramDrawable instanceof e)) {
      ((e)paramDrawable).setTint(paramInt);
    }
    AppMethodBeat.o(250809);
  }
  
  public static void a(Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(250808);
    if (Build.VERSION.SDK_INT >= 21) {
      paramDrawable.setHotspotBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(250808);
  }
  
  public static void a(Drawable paramDrawable, ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(250811);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramDrawable.setTintList(paramColorStateList);
      AppMethodBeat.o(250811);
      return;
    }
    if ((paramDrawable instanceof e)) {
      ((e)paramDrawable).setTintList(paramColorStateList);
    }
    AppMethodBeat.o(250811);
  }
  
  public static void a(Drawable paramDrawable, Resources.Theme paramTheme)
  {
    AppMethodBeat.i(250814);
    if (Build.VERSION.SDK_INT >= 21) {
      paramDrawable.applyTheme(paramTheme);
    }
    AppMethodBeat.o(250814);
  }
  
  public static void a(Drawable paramDrawable, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    AppMethodBeat.i(250819);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramDrawable.inflate(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
      AppMethodBeat.o(250819);
      return;
    }
    paramDrawable.inflate(paramResources, paramXmlPullParser, paramAttributeSet);
    AppMethodBeat.o(250819);
  }
  
  public static void a(Drawable paramDrawable, PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(250812);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramDrawable.setTintMode(paramMode);
      AppMethodBeat.o(250812);
      return;
    }
    if ((paramDrawable instanceof e)) {
      ((e)paramDrawable).setTintMode(paramMode);
    }
    AppMethodBeat.o(250812);
  }
  
  public static void b(Drawable paramDrawable, boolean paramBoolean)
  {
    AppMethodBeat.i(250805);
    if (Build.VERSION.SDK_INT >= 19) {
      paramDrawable.setAutoMirrored(paramBoolean);
    }
    AppMethodBeat.o(250805);
  }
  
  public static boolean b(Drawable paramDrawable, int paramInt)
  {
    AppMethodBeat.i(250824);
    if (Build.VERSION.SDK_INT >= 23)
    {
      boolean bool = paramDrawable.setLayoutDirection(paramInt);
      AppMethodBeat.o(250824);
      return bool;
    }
    if ((Build.VERSION.SDK_INT < 17) || (!KJ)) {}
    try
    {
      Method localMethod = Drawable.class.getDeclaredMethod("setLayoutDirection", new Class[] { Integer.TYPE });
      KI = localMethod;
      localMethod.setAccessible(true);
      label67:
      KJ = true;
      if (KI != null) {
        try
        {
          KI.invoke(paramDrawable, new Object[] { Integer.valueOf(paramInt) });
          AppMethodBeat.o(250824);
          return true;
        }
        catch (Exception paramDrawable)
        {
          KI = null;
        }
      }
      AppMethodBeat.o(250824);
      return false;
      AppMethodBeat.o(250824);
      return false;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label67;
    }
  }
  
  public static boolean l(Drawable paramDrawable)
  {
    AppMethodBeat.i(250806);
    if (Build.VERSION.SDK_INT >= 19)
    {
      boolean bool = paramDrawable.isAutoMirrored();
      AppMethodBeat.o(250806);
      return bool;
    }
    AppMethodBeat.o(250806);
    return false;
  }
  
  public static int m(Drawable paramDrawable)
  {
    AppMethodBeat.i(250813);
    if (Build.VERSION.SDK_INT >= 19)
    {
      int i = paramDrawable.getAlpha();
      AppMethodBeat.o(250813);
      return i;
    }
    AppMethodBeat.o(250813);
    return 0;
  }
  
  public static boolean n(Drawable paramDrawable)
  {
    AppMethodBeat.i(250815);
    if (Build.VERSION.SDK_INT >= 21)
    {
      boolean bool = paramDrawable.canApplyTheme();
      AppMethodBeat.o(250815);
      return bool;
    }
    AppMethodBeat.o(250815);
    return false;
  }
  
  public static void o(Drawable paramDrawable)
  {
    AppMethodBeat.i(250817);
    while ((Build.VERSION.SDK_INT < 23) && (Build.VERSION.SDK_INT >= 21))
    {
      paramDrawable.clearColorFilter();
      if ((paramDrawable instanceof InsetDrawable))
      {
        paramDrawable = ((InsetDrawable)paramDrawable).getDrawable();
      }
      else if ((paramDrawable instanceof f))
      {
        paramDrawable = ((f)paramDrawable).gD();
      }
      else
      {
        if (!(paramDrawable instanceof DrawableContainer)) {
          break label128;
        }
        paramDrawable = (DrawableContainer.DrawableContainerState)((DrawableContainer)paramDrawable).getConstantState();
        if (paramDrawable != null)
        {
          int i = 0;
          int j = paramDrawable.getChildCount();
          while (i < j)
          {
            Drawable localDrawable = paramDrawable.getChild(i);
            if (localDrawable != null) {
              o(localDrawable);
            }
            i += 1;
          }
        }
        AppMethodBeat.o(250817);
        return;
      }
    }
    paramDrawable.clearColorFilter();
    label128:
    AppMethodBeat.o(250817);
  }
  
  public static Drawable p(Drawable paramDrawable)
  {
    AppMethodBeat.i(250821);
    if (Build.VERSION.SDK_INT >= 23)
    {
      AppMethodBeat.o(250821);
      return paramDrawable;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (!(paramDrawable instanceof e))
      {
        paramDrawable = new h(paramDrawable);
        AppMethodBeat.o(250821);
        return paramDrawable;
      }
      AppMethodBeat.o(250821);
      return paramDrawable;
    }
    if (!(paramDrawable instanceof e))
    {
      paramDrawable = new g(paramDrawable);
      AppMethodBeat.o(250821);
      return paramDrawable;
    }
    AppMethodBeat.o(250821);
    return paramDrawable;
  }
  
  public static <T extends Drawable> T q(Drawable paramDrawable)
  {
    AppMethodBeat.i(250822);
    if ((paramDrawable instanceof f))
    {
      paramDrawable = ((f)paramDrawable).gD();
      AppMethodBeat.o(250822);
      return paramDrawable;
    }
    AppMethodBeat.o(250822);
    return paramDrawable;
  }
  
  public static int r(Drawable paramDrawable)
  {
    AppMethodBeat.i(250826);
    int i;
    if (Build.VERSION.SDK_INT >= 23)
    {
      i = paramDrawable.getLayoutDirection();
      AppMethodBeat.o(250826);
      return i;
    }
    if ((Build.VERSION.SDK_INT < 17) || (!KL)) {}
    try
    {
      Method localMethod = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
      KK = localMethod;
      localMethod.setAccessible(true);
      label60:
      KL = true;
      if (KK != null) {
        try
        {
          i = ((Integer)KK.invoke(paramDrawable, new Object[0])).intValue();
          AppMethodBeat.o(250826);
          return i;
        }
        catch (Exception paramDrawable)
        {
          KK = null;
        }
      }
      AppMethodBeat.o(250826);
      return 0;
      AppMethodBeat.o(250826);
      return 0;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label60;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.core.graphics.drawable.a
 * JD-Core Version:    0.7.0.1
 */