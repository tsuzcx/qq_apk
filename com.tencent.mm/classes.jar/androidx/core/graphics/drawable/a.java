package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
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
  private static Method bqQ;
  private static boolean bqR;
  private static Method bqS;
  private static boolean bqT;
  
  public static void a(Drawable paramDrawable, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(196209);
    if (Build.VERSION.SDK_INT >= 21) {
      paramDrawable.setHotspot(paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(196209);
  }
  
  public static void a(Drawable paramDrawable, int paramInt)
  {
    AppMethodBeat.i(196223);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramDrawable.setTint(paramInt);
      AppMethodBeat.o(196223);
      return;
    }
    if ((paramDrawable instanceof e)) {
      ((e)paramDrawable).setTint(paramInt);
    }
    AppMethodBeat.o(196223);
  }
  
  public static void a(Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(196216);
    if (Build.VERSION.SDK_INT >= 21) {
      paramDrawable.setHotspotBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(196216);
  }
  
  public static void a(Drawable paramDrawable, ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(196236);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramDrawable.setTintList(paramColorStateList);
      AppMethodBeat.o(196236);
      return;
    }
    if ((paramDrawable instanceof e)) {
      ((e)paramDrawable).setTintList(paramColorStateList);
    }
    AppMethodBeat.o(196236);
  }
  
  public static void a(Drawable paramDrawable, Resources.Theme paramTheme)
  {
    AppMethodBeat.i(196261);
    if (Build.VERSION.SDK_INT >= 21) {
      paramDrawable.applyTheme(paramTheme);
    }
    AppMethodBeat.o(196261);
  }
  
  public static void a(Drawable paramDrawable, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    AppMethodBeat.i(196291);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramDrawable.inflate(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
      AppMethodBeat.o(196291);
      return;
    }
    paramDrawable.inflate(paramResources, paramXmlPullParser, paramAttributeSet);
    AppMethodBeat.o(196291);
  }
  
  public static void a(Drawable paramDrawable, PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(196247);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramDrawable.setTintMode(paramMode);
      AppMethodBeat.o(196247);
      return;
    }
    if ((paramDrawable instanceof e)) {
      ((e)paramDrawable).setTintMode(paramMode);
    }
    AppMethodBeat.o(196247);
  }
  
  public static void b(Drawable paramDrawable, boolean paramBoolean)
  {
    AppMethodBeat.i(196192);
    if (Build.VERSION.SDK_INT >= 19) {
      paramDrawable.setAutoMirrored(paramBoolean);
    }
    AppMethodBeat.o(196192);
  }
  
  public static boolean b(Drawable paramDrawable, int paramInt)
  {
    AppMethodBeat.i(196317);
    if (Build.VERSION.SDK_INT >= 23)
    {
      boolean bool = paramDrawable.setLayoutDirection(paramInt);
      AppMethodBeat.o(196317);
      return bool;
    }
    if ((Build.VERSION.SDK_INT < 17) || (!bqR)) {}
    try
    {
      Method localMethod = Drawable.class.getDeclaredMethod("setLayoutDirection", new Class[] { Integer.TYPE });
      bqQ = localMethod;
      localMethod.setAccessible(true);
      label67:
      bqR = true;
      if (bqQ != null) {
        try
        {
          bqQ.invoke(paramDrawable, new Object[] { Integer.valueOf(paramInt) });
          AppMethodBeat.o(196317);
          return true;
        }
        catch (Exception paramDrawable)
        {
          bqQ = null;
        }
      }
      AppMethodBeat.o(196317);
      return false;
      AppMethodBeat.o(196317);
      return false;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label67;
    }
  }
  
  @Deprecated
  public static void m(Drawable paramDrawable)
  {
    AppMethodBeat.i(196184);
    paramDrawable.jumpToCurrentState();
    AppMethodBeat.o(196184);
  }
  
  public static boolean n(Drawable paramDrawable)
  {
    AppMethodBeat.i(196201);
    if (Build.VERSION.SDK_INT >= 19)
    {
      boolean bool = paramDrawable.isAutoMirrored();
      AppMethodBeat.o(196201);
      return bool;
    }
    AppMethodBeat.o(196201);
    return false;
  }
  
  public static int o(Drawable paramDrawable)
  {
    AppMethodBeat.i(196251);
    if (Build.VERSION.SDK_INT >= 19)
    {
      int i = paramDrawable.getAlpha();
      AppMethodBeat.o(196251);
      return i;
    }
    AppMethodBeat.o(196251);
    return 0;
  }
  
  public static boolean p(Drawable paramDrawable)
  {
    AppMethodBeat.i(196269);
    if (Build.VERSION.SDK_INT >= 21)
    {
      boolean bool = paramDrawable.canApplyTheme();
      AppMethodBeat.o(196269);
      return bool;
    }
    AppMethodBeat.o(196269);
    return false;
  }
  
  public static ColorFilter q(Drawable paramDrawable)
  {
    AppMethodBeat.i(196274);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramDrawable = paramDrawable.getColorFilter();
      AppMethodBeat.o(196274);
      return paramDrawable;
    }
    AppMethodBeat.o(196274);
    return null;
  }
  
  public static void r(Drawable paramDrawable)
  {
    AppMethodBeat.i(196283);
    while ((Build.VERSION.SDK_INT < 23) && (Build.VERSION.SDK_INT >= 21))
    {
      paramDrawable.clearColorFilter();
      if ((paramDrawable instanceof InsetDrawable))
      {
        paramDrawable = ((InsetDrawable)paramDrawable).getDrawable();
      }
      else if ((paramDrawable instanceof f))
      {
        paramDrawable = ((f)paramDrawable).DN();
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
              r(localDrawable);
            }
            i += 1;
          }
        }
        AppMethodBeat.o(196283);
        return;
      }
    }
    paramDrawable.clearColorFilter();
    label128:
    AppMethodBeat.o(196283);
  }
  
  public static Drawable s(Drawable paramDrawable)
  {
    AppMethodBeat.i(196300);
    if (Build.VERSION.SDK_INT >= 23)
    {
      AppMethodBeat.o(196300);
      return paramDrawable;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (!(paramDrawable instanceof e))
      {
        paramDrawable = new h(paramDrawable);
        AppMethodBeat.o(196300);
        return paramDrawable;
      }
      AppMethodBeat.o(196300);
      return paramDrawable;
    }
    if (!(paramDrawable instanceof e))
    {
      paramDrawable = new g(paramDrawable);
      AppMethodBeat.o(196300);
      return paramDrawable;
    }
    AppMethodBeat.o(196300);
    return paramDrawable;
  }
  
  public static <T extends Drawable> T t(Drawable paramDrawable)
  {
    AppMethodBeat.i(196307);
    if ((paramDrawable instanceof f))
    {
      paramDrawable = ((f)paramDrawable).DN();
      AppMethodBeat.o(196307);
      return paramDrawable;
    }
    AppMethodBeat.o(196307);
    return paramDrawable;
  }
  
  public static int u(Drawable paramDrawable)
  {
    AppMethodBeat.i(196328);
    int i;
    if (Build.VERSION.SDK_INT >= 23)
    {
      i = paramDrawable.getLayoutDirection();
      AppMethodBeat.o(196328);
      return i;
    }
    if ((Build.VERSION.SDK_INT < 17) || (!bqT)) {}
    try
    {
      Method localMethod = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
      bqS = localMethod;
      localMethod.setAccessible(true);
      label60:
      bqT = true;
      if (bqS != null) {
        try
        {
          i = ((Integer)bqS.invoke(paramDrawable, new Object[0])).intValue();
          AppMethodBeat.o(196328);
          return i;
        }
        catch (Exception paramDrawable)
        {
          bqS = null;
        }
      }
      AppMethodBeat.o(196328);
      return 0;
      AppMethodBeat.o(196328);
      return 0;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label60;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.core.graphics.drawable.a
 * JD-Core Version:    0.7.0.1
 */