package com.tencent.mm.cd;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class a
{
  private static a aclw;
  private static boolean aclx;
  private static boolean acly;
  private static float density;
  private static final SparseIntArray ehY;
  private static float scale;
  
  static
  {
    AppMethodBeat.i(125178);
    aclw = null;
    density = -1.0F;
    ehY = new SparseIntArray();
    scale = 0.0F;
    aclx = false;
    acly = true;
    AppMethodBeat.o(125178);
  }
  
  public static int K(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(125155);
    paramInt = Math.round(paramInt / getDensity(paramContext));
    AppMethodBeat.o(125155);
    return paramInt;
  }
  
  public static boolean bc(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(125177);
    if (Math.abs(paramFloat1 - paramFloat2) <= 1.E-005D)
    {
      AppMethodBeat.o(125177);
      return true;
    }
    AppMethodBeat.o(125177);
    return false;
  }
  
  public static int br(Context paramContext, int paramInt)
  {
    float f1 = 1.4F;
    AppMethodBeat.i(125149);
    float f2 = getScaleSize(paramContext);
    if (f2 > 1.4F) {}
    for (;;)
    {
      paramInt = (int)(f1 * bs(paramContext, paramInt));
      AppMethodBeat.o(125149);
      return paramInt;
      f1 = f2;
    }
  }
  
  public static int bs(Context arg0, int paramInt)
  {
    AppMethodBeat.i(125150);
    if (??? == null)
    {
      Log.e("MicroMsg.ResourceHelper", "get dimension pixel size, resId %d, but context is null", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(125150);
      return 0;
    }
    int i;
    synchronized (ehY)
    {
      int j = ehY.get(paramInt, 0);
      i = j;
      if (j <= 0)
      {
        if (aclw != null) {
          break label109;
        }
        i = ???.getResources().getDimensionPixelSize(paramInt);
      }
    }
    synchronized (ehY)
    {
      ehY.put(paramInt, i);
      AppMethodBeat.o(125150);
      return i;
      ??? = finally;
      AppMethodBeat.o(125150);
      throw ???;
      label109:
      i = aclw.iRl();
    }
  }
  
  public static String bt(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(125151);
    if (aclw == null)
    {
      if (paramContext == null)
      {
        Log.e("MicroMsg.ResourceHelper", "get string, resId %d, but context is null", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(125151);
        return "";
      }
      paramContext = paramContext.getResources().getString(paramInt);
      AppMethodBeat.o(125151);
      return paramContext;
    }
    paramContext = aclw.iRm();
    AppMethodBeat.o(125151);
    return paramContext;
  }
  
  public static int fromDPToPix(Context paramContext, float paramFloat)
  {
    AppMethodBeat.i(125153);
    int i = Math.round(getDensity(paramContext) * paramFloat);
    AppMethodBeat.o(125153);
    return i;
  }
  
  public static int fromDPToPix(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(125154);
    paramInt = Math.round(getDensity(paramContext) * paramInt);
    AppMethodBeat.o(125154);
    return paramInt;
  }
  
  public static float getDensity(Context paramContext)
  {
    AppMethodBeat.i(125152);
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = MMApplicationContext.getContext();
    }
    float f = localContext.getResources().getDisplayMetrics().density;
    density = f;
    AppMethodBeat.o(125152);
    return f;
  }
  
  public static float getScaleSize(Context paramContext)
  {
    AppMethodBeat.i(125164);
    if (scale == 0.0F) {
      if (paramContext != null) {
        break label93;
      }
    }
    label93:
    for (scale = 1.0F;; scale = paramContext.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getFloat("text_size_scale_key", 1.0F))
    {
      if (!aclx)
      {
        acly = paramContext.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getBoolean("screenResolution_isModifyDensity", true);
        aclx = true;
      }
      if ((acly) && ((bc(scale, 1.1F)) || (bc(scale, 0.8F)))) {
        scale = 1.0F;
      }
      float f = scale;
      AppMethodBeat.o(125164);
      return f;
    }
  }
  
  public static void i(Context paramContext, float paramFloat)
  {
    AppMethodBeat.i(125171);
    paramContext = paramContext.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).edit();
    paramContext.putFloat("text_size_scale_key", paramFloat);
    paramContext.commit();
    scale = paramFloat;
    AppMethodBeat.o(125171);
  }
  
  public static void iRh()
  {
    AppMethodBeat.i(231241);
    synchronized (ehY)
    {
      ehY.clear();
      AppMethodBeat.o(231241);
      return;
    }
  }
  
  public static float jO(Context paramContext)
  {
    AppMethodBeat.i(125169);
    float f = 1.0F;
    if (mq(paramContext)) {
      if (!ml(paramContext)) {
        break label31;
      }
    }
    label31:
    for (f = 1.2F;; f = 1.1F)
    {
      AppMethodBeat.o(125169);
      return f;
    }
  }
  
  public static ColorStateList l(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(125147);
    if (aclw == null)
    {
      if (paramContext == null)
      {
        Log.e("MicroMsg.ResourceHelper", "get color state list, resId %d, but context is null", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(125147);
        return null;
      }
      paramContext = paramContext.getResources().getColorStateList(paramInt);
      AppMethodBeat.o(125147);
      return paramContext;
    }
    paramContext = aclw.iRj();
    AppMethodBeat.o(125147);
    return paramContext;
  }
  
  public static Drawable m(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(125148);
    if (aclw == null)
    {
      if (paramContext == null)
      {
        Log.e("MicroMsg.ResourceHelper", "get drawable, resId %d, but context is null", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(125148);
        return null;
      }
      paramContext = paramContext.getResources().getDrawable(paramInt);
      AppMethodBeat.o(125148);
      return paramContext;
    }
    paramContext = aclw.iRk();
    AppMethodBeat.o(125148);
    return paramContext;
  }
  
  public static float mc(Context paramContext)
  {
    AppMethodBeat.i(125156);
    if (ml(paramContext))
    {
      AppMethodBeat.o(125156);
      return 0.8F;
    }
    AppMethodBeat.o(125156);
    return 0.875F;
  }
  
  public static float md(Context paramContext)
  {
    AppMethodBeat.i(125157);
    if (ml(paramContext))
    {
      AppMethodBeat.o(125157);
      return 1.0F;
    }
    AppMethodBeat.o(125157);
    return 1.0F;
  }
  
  public static float me(Context paramContext)
  {
    AppMethodBeat.i(125158);
    if (ml(paramContext))
    {
      AppMethodBeat.o(125158);
      return 1.1F;
    }
    AppMethodBeat.o(125158);
    return 1.11F;
  }
  
  public static float mf(Context paramContext)
  {
    AppMethodBeat.i(125159);
    if (ml(paramContext))
    {
      AppMethodBeat.o(125159);
      return 1.12F;
    }
    AppMethodBeat.o(125159);
    return 1.25F;
  }
  
  public static float mg(Context paramContext)
  {
    AppMethodBeat.i(125160);
    if (ml(paramContext))
    {
      AppMethodBeat.o(125160);
      return 1.125F;
    }
    AppMethodBeat.o(125160);
    return 1.375F;
  }
  
  public static float mh(Context paramContext)
  {
    AppMethodBeat.i(125161);
    if (ml(paramContext))
    {
      AppMethodBeat.o(125161);
      return 1.4F;
    }
    AppMethodBeat.o(125161);
    return 1.625F;
  }
  
  public static float mi(Context paramContext)
  {
    AppMethodBeat.i(125162);
    if (ml(paramContext))
    {
      AppMethodBeat.o(125162);
      return 1.55F;
    }
    AppMethodBeat.o(125162);
    return 1.875F;
  }
  
  public static float mj(Context paramContext)
  {
    AppMethodBeat.i(125163);
    if (ml(paramContext))
    {
      AppMethodBeat.o(125163);
      return 1.65F;
    }
    AppMethodBeat.o(125163);
    return 2.025F;
  }
  
  public static float mk(Context paramContext)
  {
    float f = 1.0F;
    AppMethodBeat.i(125165);
    if (paramContext == null) {}
    for (;;)
    {
      AppMethodBeat.o(125165);
      return f;
      f = paramContext.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getFloat("text_size_scale_key", 1.0F);
    }
  }
  
  public static boolean ml(Context paramContext)
  {
    AppMethodBeat.i(125166);
    if ((paramContext != null) && (!aclx))
    {
      acly = paramContext.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getBoolean("screenResolution_isModifyDensity", true);
      aclx = true;
    }
    boolean bool = acly;
    AppMethodBeat.o(125166);
    return bool;
  }
  
  public static int mm(Context paramContext)
  {
    AppMethodBeat.i(125167);
    float f = mk(paramContext);
    if (f == mc(paramContext))
    {
      AppMethodBeat.o(125167);
      return 1;
    }
    if (f == md(paramContext))
    {
      AppMethodBeat.o(125167);
      return 2;
    }
    if (f == me(paramContext))
    {
      AppMethodBeat.o(125167);
      return 3;
    }
    if (f == mf(paramContext))
    {
      AppMethodBeat.o(125167);
      return 4;
    }
    if (f == mg(paramContext))
    {
      AppMethodBeat.o(125167);
      return 5;
    }
    if (f == mh(paramContext))
    {
      AppMethodBeat.o(125167);
      return 6;
    }
    if (f == mi(paramContext))
    {
      AppMethodBeat.o(125167);
      return 7;
    }
    if (f == mj(paramContext))
    {
      AppMethodBeat.o(125167);
      return 8;
    }
    AppMethodBeat.o(125167);
    return 2;
  }
  
  public static int mn(Context paramContext)
  {
    AppMethodBeat.i(125168);
    float f = mk(paramContext);
    if (f == 0.875F)
    {
      AppMethodBeat.o(125168);
      return 0;
    }
    if (f == 1.0F)
    {
      AppMethodBeat.o(125168);
      return 1;
    }
    if (f == 1.11F)
    {
      AppMethodBeat.o(125168);
      return 2;
    }
    if (f == 1.25F)
    {
      AppMethodBeat.o(125168);
      return 3;
    }
    if (f == 1.375F)
    {
      AppMethodBeat.o(125168);
      return 4;
    }
    if ((f == 1.625F) || (bc(f, 1.3F)))
    {
      AppMethodBeat.o(125168);
      return 5;
    }
    if ((f == 1.875F) || (bc(f, 1.38F)))
    {
      AppMethodBeat.o(125168);
      return 6;
    }
    if ((f == 2.025F) || (bc(f, 1.565F)))
    {
      AppMethodBeat.o(125168);
      return 7;
    }
    AppMethodBeat.o(125168);
    return 1;
  }
  
  public static float mo(Context paramContext)
  {
    AppMethodBeat.i(125170);
    float f2 = 1.0F;
    float f1 = f2;
    if (!ml(paramContext))
    {
      f1 = f2;
      if (mq(paramContext)) {
        f1 = 1.1F;
      }
    }
    AppMethodBeat.o(125170);
    return f1;
  }
  
  public static boolean mp(Context paramContext)
  {
    AppMethodBeat.i(125172);
    float f = getScaleSize(paramContext);
    scale = f;
    if (Float.compare(f, me(paramContext)) > 0)
    {
      AppMethodBeat.o(125172);
      return true;
    }
    AppMethodBeat.o(125172);
    return false;
  }
  
  public static boolean mq(Context paramContext)
  {
    AppMethodBeat.i(125173);
    float f = getScaleSize(paramContext);
    scale = f;
    if (Float.compare(f, mf(paramContext)) > 0)
    {
      AppMethodBeat.o(125173);
      return true;
    }
    AppMethodBeat.o(125173);
    return false;
  }
  
  public static boolean mr(Context paramContext)
  {
    AppMethodBeat.i(125174);
    float f = getScaleSize(paramContext);
    scale = f;
    if (f == mc(paramContext))
    {
      AppMethodBeat.o(125174);
      return true;
    }
    AppMethodBeat.o(125174);
    return false;
  }
  
  public static int ms(Context paramContext)
  {
    AppMethodBeat.i(125175);
    if (aclw == null)
    {
      if (paramContext == null)
      {
        Log.e("MicroMsg.ResourceHelper", "get widthPixels but context is null");
        AppMethodBeat.o(125175);
        return 0;
      }
      int i = paramContext.getResources().getDisplayMetrics().widthPixels;
      AppMethodBeat.o(125175);
      return i;
    }
    AppMethodBeat.o(125175);
    return 0;
  }
  
  public static int mt(Context paramContext)
  {
    AppMethodBeat.i(125176);
    if (aclw == null)
    {
      if (paramContext == null)
      {
        Log.e("MicroMsg.ResourceHelper", "get heightPixels but context is null");
        AppMethodBeat.o(125176);
        return 0;
      }
      int i = paramContext.getResources().getDisplayMetrics().heightPixels;
      AppMethodBeat.o(125176);
      return i;
    }
    AppMethodBeat.o(125176);
    return 0;
  }
  
  public static int w(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(125146);
    if (aclw == null)
    {
      if (paramContext == null)
      {
        Log.e("MicroMsg.ResourceHelper", "get color, resId %d, but context is null", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(125146);
        return 0;
      }
      paramInt = paramContext.getResources().getColor(paramInt);
      AppMethodBeat.o(125146);
      return paramInt;
    }
    paramInt = aclw.iRi();
    AppMethodBeat.o(125146);
    return paramInt;
  }
  
  public static abstract interface a
  {
    public abstract int iRi();
    
    public abstract ColorStateList iRj();
    
    public abstract Drawable iRk();
    
    public abstract int iRl();
    
    public abstract String iRm();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.cd.a
 * JD-Core Version:    0.7.0.1
 */