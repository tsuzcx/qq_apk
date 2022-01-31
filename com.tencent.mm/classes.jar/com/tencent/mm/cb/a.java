package com.tencent.mm.cb;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class a
{
  private static float density;
  private static float scale;
  private static a yiJ;
  private static SparseIntArray yiK;
  private static boolean yiL;
  private static boolean yiM;
  
  static
  {
    AppMethodBeat.i(115145);
    yiJ = null;
    density = -1.0F;
    yiK = new SparseIntArray();
    scale = 0.0F;
    yiL = false;
    yiM = true;
    AppMethodBeat.o(115145);
  }
  
  private static boolean am(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(155586);
    if (Math.abs(paramFloat1 - paramFloat2) <= 1.E-005D)
    {
      AppMethodBeat.o(155586);
      return true;
    }
    AppMethodBeat.o(155586);
    return false;
  }
  
  public static int ao(Context paramContext, int paramInt)
  {
    float f1 = 1.4F;
    AppMethodBeat.i(115129);
    float f2 = dr(paramContext);
    if (f2 > 1.4F) {}
    for (;;)
    {
      paramInt = (int)(f1 * ap(paramContext, paramInt));
      AppMethodBeat.o(115129);
      return paramInt;
      f1 = f2;
    }
  }
  
  public static int ap(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(115130);
    if (paramContext == null)
    {
      ab.e("MicroMsg.ResourceHelper", "get dimension pixel size, resId %d, but context is null", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(115130);
      return 0;
    }
    for (;;)
    {
      try
      {
        int j = yiK.get(paramInt, 0);
        i = j;
        if (j <= 0)
        {
          if (yiJ != null) {
            continue;
          }
          i = paramContext.getResources().getDimensionPixelSize(paramInt);
          yiK.put(paramInt, i);
        }
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        int i = paramContext.getResources().getDimensionPixelSize(paramInt);
        yiK.put(paramInt, i);
        continue;
      }
      AppMethodBeat.o(115130);
      return i;
      i = yiJ.dqQ();
    }
  }
  
  public static String aq(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(115131);
    if (yiJ == null)
    {
      if (paramContext == null)
      {
        ab.e("MicroMsg.ResourceHelper", "get string, resId %d, but context is null", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(115131);
        return "";
      }
      paramContext = paramContext.getResources().getString(paramInt);
      AppMethodBeat.o(115131);
      return paramContext;
    }
    paramContext = yiJ.dqR();
    AppMethodBeat.o(115131);
    return paramContext;
  }
  
  public static int ar(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(115134);
    paramInt = Math.round(paramInt / getDensity(paramContext));
    AppMethodBeat.o(115134);
    return paramInt;
  }
  
  public static float dr(Context paramContext)
  {
    AppMethodBeat.i(115135);
    if (scale == 0.0F) {
      if (paramContext != null) {
        break label89;
      }
    }
    label89:
    for (scale = 1.0F;; scale = paramContext.getSharedPreferences(ah.dsP(), 0).getFloat("text_size_scale_key", 1.0F))
    {
      if (!yiL)
      {
        yiM = paramContext.getSharedPreferences(ah.dsP(), 0).getBoolean("screenResolution_isModifyDensity", true);
        yiL = true;
      }
      if ((yiM) && ((scale == 1.1F) || (scale == 0.8F))) {
        scale = 1.0F;
      }
      float f = scale;
      AppMethodBeat.o(115135);
      return f;
    }
  }
  
  public static int fromDPToPix(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(115133);
    paramInt = Math.round(getDensity(paramContext) * paramInt);
    AppMethodBeat.o(115133);
    return paramInt;
  }
  
  public static float getDensity(Context paramContext)
  {
    AppMethodBeat.i(115132);
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = ah.getContext();
    }
    float f = localContext.getResources().getDisplayMetrics().density;
    density = f;
    AppMethodBeat.o(115132);
    return f;
  }
  
  public static float gf(Context paramContext)
  {
    AppMethodBeat.i(155666);
    if (go(paramContext))
    {
      AppMethodBeat.o(155666);
      return 0.8F;
    }
    AppMethodBeat.o(155666);
    return 0.875F;
  }
  
  public static float gg(Context paramContext)
  {
    AppMethodBeat.i(155667);
    if (go(paramContext))
    {
      AppMethodBeat.o(155667);
      return 1.0F;
    }
    AppMethodBeat.o(155667);
    return 1.0F;
  }
  
  public static float gh(Context paramContext)
  {
    AppMethodBeat.i(155668);
    if (go(paramContext))
    {
      AppMethodBeat.o(155668);
      return 1.1F;
    }
    AppMethodBeat.o(155668);
    return 1.11F;
  }
  
  public static float gi(Context paramContext)
  {
    AppMethodBeat.i(155669);
    if (go(paramContext))
    {
      AppMethodBeat.o(155669);
      return 1.12F;
    }
    AppMethodBeat.o(155669);
    return 1.25F;
  }
  
  public static float gj(Context paramContext)
  {
    AppMethodBeat.i(155670);
    if (go(paramContext))
    {
      AppMethodBeat.o(155670);
      return 1.125F;
    }
    AppMethodBeat.o(155670);
    return 1.375F;
  }
  
  public static float gk(Context paramContext)
  {
    AppMethodBeat.i(155671);
    if (go(paramContext))
    {
      AppMethodBeat.o(155671);
      return 1.4F;
    }
    AppMethodBeat.o(155671);
    return 1.625F;
  }
  
  public static float gl(Context paramContext)
  {
    AppMethodBeat.i(155672);
    if (go(paramContext))
    {
      AppMethodBeat.o(155672);
      return 1.55F;
    }
    AppMethodBeat.o(155672);
    return 1.875F;
  }
  
  public static float gm(Context paramContext)
  {
    AppMethodBeat.i(155673);
    if (go(paramContext))
    {
      AppMethodBeat.o(155673);
      return 1.65F;
    }
    AppMethodBeat.o(155673);
    return 2.025F;
  }
  
  public static float gn(Context paramContext)
  {
    float f = 1.0F;
    AppMethodBeat.i(141777);
    if (paramContext == null) {}
    for (;;)
    {
      AppMethodBeat.o(141777);
      return f;
      f = paramContext.getSharedPreferences(ah.dsP(), 0).getFloat("text_size_scale_key", 1.0F);
    }
  }
  
  public static boolean go(Context paramContext)
  {
    AppMethodBeat.i(155674);
    if ((paramContext != null) && (!yiL))
    {
      yiM = paramContext.getSharedPreferences(ah.dsP(), 0).getBoolean("screenResolution_isModifyDensity", true);
      yiL = true;
    }
    boolean bool = yiM;
    AppMethodBeat.o(155674);
    return bool;
  }
  
  public static int gp(Context paramContext)
  {
    AppMethodBeat.i(115136);
    float f = gn(paramContext);
    if (f == gf(paramContext))
    {
      AppMethodBeat.o(115136);
      return 1;
    }
    if (f == gg(paramContext))
    {
      AppMethodBeat.o(115136);
      return 2;
    }
    if (f == gh(paramContext))
    {
      AppMethodBeat.o(115136);
      return 3;
    }
    if (f == gi(paramContext))
    {
      AppMethodBeat.o(115136);
      return 4;
    }
    if (f == gj(paramContext))
    {
      AppMethodBeat.o(115136);
      return 5;
    }
    if (f == gk(paramContext))
    {
      AppMethodBeat.o(115136);
      return 6;
    }
    if (f == gl(paramContext))
    {
      AppMethodBeat.o(115136);
      return 7;
    }
    if (f == gm(paramContext))
    {
      AppMethodBeat.o(115136);
      return 8;
    }
    AppMethodBeat.o(115136);
    return 2;
  }
  
  public static int gq(Context paramContext)
  {
    AppMethodBeat.i(141778);
    float f = gn(paramContext);
    if (f == 0.875F)
    {
      AppMethodBeat.o(141778);
      return 0;
    }
    if (f == 1.0F)
    {
      AppMethodBeat.o(141778);
      return 1;
    }
    if (f == 1.11F)
    {
      AppMethodBeat.o(141778);
      return 2;
    }
    if (f == 1.25F)
    {
      AppMethodBeat.o(141778);
      return 3;
    }
    if (f == 1.375F)
    {
      AppMethodBeat.o(141778);
      return 4;
    }
    if ((f == 1.625F) || (am(f, 1.3F)))
    {
      AppMethodBeat.o(141778);
      return 5;
    }
    if ((f == 1.875F) || (am(f, 1.38F)))
    {
      AppMethodBeat.o(141778);
      return 6;
    }
    if ((f == 2.025F) || (am(f, 1.565F)))
    {
      AppMethodBeat.o(141778);
      return 7;
    }
    AppMethodBeat.o(141778);
    return 1;
  }
  
  public static float gr(Context paramContext)
  {
    AppMethodBeat.i(115137);
    float f = 1.0F;
    if (gu(paramContext)) {
      if (!go(paramContext)) {
        break label31;
      }
    }
    label31:
    for (f = 1.2F;; f = 1.1F)
    {
      AppMethodBeat.o(115137);
      return f;
    }
  }
  
  public static float gs(Context paramContext)
  {
    AppMethodBeat.i(115138);
    float f2 = 1.0F;
    float f1 = f2;
    if (!go(paramContext))
    {
      f1 = f2;
      if (gu(paramContext)) {
        f1 = 1.1F;
      }
    }
    AppMethodBeat.o(115138);
    return f1;
  }
  
  public static boolean gt(Context paramContext)
  {
    AppMethodBeat.i(115140);
    float f = dr(paramContext);
    scale = f;
    if (Float.compare(f, gh(paramContext)) > 0)
    {
      AppMethodBeat.o(115140);
      return true;
    }
    AppMethodBeat.o(115140);
    return false;
  }
  
  public static boolean gu(Context paramContext)
  {
    AppMethodBeat.i(115141);
    float f = dr(paramContext);
    scale = f;
    if (Float.compare(f, gi(paramContext)) > 0)
    {
      AppMethodBeat.o(115141);
      return true;
    }
    AppMethodBeat.o(115141);
    return false;
  }
  
  public static boolean gv(Context paramContext)
  {
    AppMethodBeat.i(115142);
    float f = dr(paramContext);
    scale = f;
    if (f == gf(paramContext))
    {
      AppMethodBeat.o(115142);
      return true;
    }
    AppMethodBeat.o(115142);
    return false;
  }
  
  public static int gw(Context paramContext)
  {
    AppMethodBeat.i(115143);
    if (yiJ == null)
    {
      if (paramContext == null)
      {
        ab.e("MicroMsg.ResourceHelper", "get widthPixels but context is null");
        AppMethodBeat.o(115143);
        return 0;
      }
      int i = paramContext.getResources().getDisplayMetrics().widthPixels;
      AppMethodBeat.o(115143);
      return i;
    }
    AppMethodBeat.o(115143);
    return 0;
  }
  
  public static int gx(Context paramContext)
  {
    AppMethodBeat.i(115144);
    if (yiJ == null)
    {
      if (paramContext == null)
      {
        ab.e("MicroMsg.ResourceHelper", "get heightPixels but context is null");
        AppMethodBeat.o(115144);
        return 0;
      }
      int i = paramContext.getResources().getDisplayMetrics().heightPixels;
      AppMethodBeat.o(115144);
      return i;
    }
    AppMethodBeat.o(115144);
    return 0;
  }
  
  public static void h(Context paramContext, float paramFloat)
  {
    AppMethodBeat.i(115139);
    paramContext = paramContext.getSharedPreferences(ah.dsP(), 0).edit();
    paramContext.putFloat("text_size_scale_key", paramFloat);
    paramContext.commit();
    scale = paramFloat;
    AppMethodBeat.o(115139);
  }
  
  public static Drawable k(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(115128);
    if (yiJ == null)
    {
      if (paramContext == null)
      {
        ab.e("MicroMsg.ResourceHelper", "get drawable, resId %d, but context is null", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(115128);
        return null;
      }
      paramContext = paramContext.getResources().getDrawable(paramInt);
      AppMethodBeat.o(115128);
      return paramContext;
    }
    paramContext = yiJ.dqP();
    AppMethodBeat.o(115128);
    return paramContext;
  }
  
  public static ColorStateList l(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(115127);
    if (yiJ == null)
    {
      if (paramContext == null)
      {
        ab.e("MicroMsg.ResourceHelper", "get color state list, resId %d, but context is null", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(115127);
        return null;
      }
      paramContext = paramContext.getResources().getColorStateList(paramInt);
      AppMethodBeat.o(115127);
      return paramContext;
    }
    paramContext = yiJ.dqO();
    AppMethodBeat.o(115127);
    return paramContext;
  }
  
  public static int m(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(115126);
    if (yiJ == null)
    {
      if (paramContext == null)
      {
        ab.e("MicroMsg.ResourceHelper", "get color, resId %d, but context is null", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(115126);
        return 0;
      }
      paramInt = paramContext.getResources().getColor(paramInt);
      AppMethodBeat.o(115126);
      return paramInt;
    }
    paramInt = yiJ.dqN();
    AppMethodBeat.o(115126);
    return paramInt;
  }
  
  public static abstract interface a
  {
    public abstract int dqN();
    
    public abstract ColorStateList dqO();
    
    public abstract Drawable dqP();
    
    public abstract int dqQ();
    
    public abstract String dqR();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cb.a
 * JD-Core Version:    0.7.0.1
 */