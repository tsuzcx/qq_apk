package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

final class h
  extends g
{
  private static Method Ld;
  
  h(Drawable paramDrawable)
  {
    super(paramDrawable);
    AppMethodBeat.i(250992);
    gG();
    AppMethodBeat.o(250992);
  }
  
  h(i parami, Resources paramResources)
  {
    super(parami, paramResources);
    AppMethodBeat.i(250994);
    gG();
    AppMethodBeat.o(250994);
  }
  
  private static void gG()
  {
    AppMethodBeat.i(251011);
    if (Ld == null) {
      try
      {
        Ld = Drawable.class.getDeclaredMethod("isProjected", new Class[0]);
        AppMethodBeat.o(251011);
        return;
      }
      catch (Exception localException) {}
    }
    AppMethodBeat.o(251011);
  }
  
  protected final boolean gF()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (Build.VERSION.SDK_INT == 21)
    {
      Drawable localDrawable = this.mDrawable;
      if ((!(localDrawable instanceof GradientDrawable)) && (!(localDrawable instanceof DrawableContainer)) && (!(localDrawable instanceof InsetDrawable)))
      {
        bool1 = bool2;
        if (!(localDrawable instanceof RippleDrawable)) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final Rect getDirtyBounds()
  {
    AppMethodBeat.i(251000);
    Rect localRect = this.mDrawable.getDirtyBounds();
    AppMethodBeat.o(251000);
    return localRect;
  }
  
  public final void getOutline(Outline paramOutline)
  {
    AppMethodBeat.i(250999);
    this.mDrawable.getOutline(paramOutline);
    AppMethodBeat.o(250999);
  }
  
  public final boolean isProjected()
  {
    AppMethodBeat.i(251010);
    if ((this.mDrawable != null) && (Ld != null)) {
      try
      {
        boolean bool = ((Boolean)Ld.invoke(this.mDrawable, new Object[0])).booleanValue();
        AppMethodBeat.o(251010);
        return bool;
      }
      catch (Exception localException) {}
    }
    AppMethodBeat.o(251010);
    return false;
  }
  
  public final void setHotspot(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(250996);
    this.mDrawable.setHotspot(paramFloat1, paramFloat2);
    AppMethodBeat.o(250996);
  }
  
  public final void setHotspotBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(250998);
    this.mDrawable.setHotspotBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(250998);
  }
  
  public final boolean setState(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(251007);
    if (super.setState(paramArrayOfInt))
    {
      invalidateSelf();
      AppMethodBeat.o(251007);
      return true;
    }
    AppMethodBeat.o(251007);
    return false;
  }
  
  public final void setTint(int paramInt)
  {
    AppMethodBeat.i(251004);
    if (gF())
    {
      super.setTint(paramInt);
      AppMethodBeat.o(251004);
      return;
    }
    this.mDrawable.setTint(paramInt);
    AppMethodBeat.o(251004);
  }
  
  public final void setTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(251001);
    if (gF())
    {
      super.setTintList(paramColorStateList);
      AppMethodBeat.o(251001);
      return;
    }
    this.mDrawable.setTintList(paramColorStateList);
    AppMethodBeat.o(251001);
  }
  
  public final void setTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(251006);
    if (gF())
    {
      super.setTintMode(paramMode);
      AppMethodBeat.o(251006);
      return;
    }
    this.mDrawable.setTintMode(paramMode);
    AppMethodBeat.o(251006);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.core.graphics.drawable.h
 * JD-Core Version:    0.7.0.1
 */