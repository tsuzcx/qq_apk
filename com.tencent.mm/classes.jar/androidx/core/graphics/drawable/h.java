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
  private static Method brm;
  
  h(Drawable paramDrawable)
  {
    super(paramDrawable);
    AppMethodBeat.i(196161);
    DQ();
    AppMethodBeat.o(196161);
  }
  
  h(i parami, Resources paramResources)
  {
    super(parami, paramResources);
    AppMethodBeat.i(196170);
    DQ();
    AppMethodBeat.o(196170);
  }
  
  private static void DQ()
  {
    AppMethodBeat.i(196179);
    if (brm == null) {
      try
      {
        brm = Drawable.class.getDeclaredMethod("isProjected", new Class[0]);
        AppMethodBeat.o(196179);
        return;
      }
      catch (Exception localException) {}
    }
    AppMethodBeat.o(196179);
  }
  
  protected final boolean DP()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (Build.VERSION.SDK_INT == 21)
    {
      Drawable localDrawable = this.kD;
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
    AppMethodBeat.i(196210);
    Rect localRect = this.kD.getDirtyBounds();
    AppMethodBeat.o(196210);
    return localRect;
  }
  
  public final void getOutline(Outline paramOutline)
  {
    AppMethodBeat.i(196203);
    this.kD.getOutline(paramOutline);
    AppMethodBeat.o(196203);
  }
  
  public final boolean isProjected()
  {
    AppMethodBeat.i(196262);
    if ((this.kD != null) && (brm != null)) {
      try
      {
        boolean bool = ((Boolean)brm.invoke(this.kD, new Object[0])).booleanValue();
        AppMethodBeat.o(196262);
        return bool;
      }
      catch (Exception localException) {}
    }
    AppMethodBeat.o(196262);
    return false;
  }
  
  public final void setHotspot(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(196185);
    this.kD.setHotspot(paramFloat1, paramFloat2);
    AppMethodBeat.o(196185);
  }
  
  public final void setHotspotBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(196199);
    this.kD.setHotspotBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(196199);
  }
  
  public final boolean setState(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(196245);
    if (super.setState(paramArrayOfInt))
    {
      invalidateSelf();
      AppMethodBeat.o(196245);
      return true;
    }
    AppMethodBeat.o(196245);
    return false;
  }
  
  public final void setTint(int paramInt)
  {
    AppMethodBeat.i(196224);
    if (DP())
    {
      super.setTint(paramInt);
      AppMethodBeat.o(196224);
      return;
    }
    this.kD.setTint(paramInt);
    AppMethodBeat.o(196224);
  }
  
  public final void setTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(196219);
    if (DP())
    {
      super.setTintList(paramColorStateList);
      AppMethodBeat.o(196219);
      return;
    }
    this.kD.setTintList(paramColorStateList);
    AppMethodBeat.o(196219);
  }
  
  public final void setTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(196234);
    if (DP())
    {
      super.setTintMode(paramMode);
      AppMethodBeat.o(196234);
      return;
    }
    this.kD.setTintMode(paramMode);
    AppMethodBeat.o(196234);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.core.graphics.drawable.h
 * JD-Core Version:    0.7.0.1
 */