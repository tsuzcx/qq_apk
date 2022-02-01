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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;

public final class a
{
  private static a Ipr;
  private static final SparseIntArray Ips;
  private static boolean Ipt;
  private static boolean Ipu;
  private static float density;
  private static float scale;
  
  static
  {
    AppMethodBeat.i(125178);
    Ipr = null;
    density = -1.0F;
    Ips = new SparseIntArray();
    scale = 0.0F;
    Ipt = false;
    Ipu = true;
    AppMethodBeat.o(125178);
  }
  
  public static int aA(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(125155);
    paramInt = Math.round(paramInt / getDensity(paramContext));
    AppMethodBeat.o(125155);
    return paramInt;
  }
  
  private static boolean al(float paramFloat1, float paramFloat2)
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
  
  public static int ax(Context paramContext, int paramInt)
  {
    float f1 = 1.4F;
    AppMethodBeat.i(125149);
    float f2 = ef(paramContext);
    if (f2 > 1.4F) {}
    for (;;)
    {
      paramInt = (int)(f1 * ay(paramContext, paramInt));
      AppMethodBeat.o(125149);
      return paramInt;
      f1 = f2;
    }
  }
  
  public static int ay(Context arg0, int paramInt)
  {
    AppMethodBeat.i(125150);
    if (??? == null)
    {
      ae.e("MicroMsg.ResourceHelper", "get dimension pixel size, resId %d, but context is null", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(125150);
      return 0;
    }
    int i;
    synchronized (Ips)
    {
      int j = Ips.get(paramInt, 0);
      i = j;
      if (j <= 0)
      {
        if (Ipr != null) {
          break label109;
        }
        i = ???.getResources().getDimensionPixelSize(paramInt);
      }
    }
    synchronized (Ips)
    {
      Ips.put(paramInt, i);
      AppMethodBeat.o(125150);
      return i;
      ??? = finally;
      AppMethodBeat.o(125150);
      throw ???;
      label109:
      i = Ipr.flu();
    }
  }
  
  public static String az(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(125151);
    if (Ipr == null)
    {
      if (paramContext == null)
      {
        ae.e("MicroMsg.ResourceHelper", "get string, resId %d, but context is null", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(125151);
        return "";
      }
      paramContext = paramContext.getResources().getString(paramInt);
      AppMethodBeat.o(125151);
      return paramContext;
    }
    paramContext = Ipr.flv();
    AppMethodBeat.o(125151);
    return paramContext;
  }
  
  public static float ef(Context paramContext)
  {
    AppMethodBeat.i(125164);
    if (scale == 0.0F) {
      if (paramContext != null) {
        break label89;
      }
    }
    label89:
    for (scale = 1.0F;; scale = paramContext.getSharedPreferences(ak.fow(), 0).getFloat("text_size_scale_key", 1.0F))
    {
      if (!Ipt)
      {
        Ipu = paramContext.getSharedPreferences(ak.fow(), 0).getBoolean("screenResolution_isModifyDensity", true);
        Ipt = true;
      }
      if ((Ipu) && ((scale == 1.1F) || (scale == 0.8F))) {
        scale = 1.0F;
      }
      float f = scale;
      AppMethodBeat.o(125164);
      return f;
    }
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
      localContext = ak.getContext();
    }
    float f = localContext.getResources().getDisplayMetrics().density;
    density = f;
    AppMethodBeat.o(125152);
    return f;
  }
  
  public static int h(Context paramContext, float paramFloat)
  {
    AppMethodBeat.i(125153);
    int i = Math.round(getDensity(paramContext) * paramFloat);
    AppMethodBeat.o(125153);
    return i;
  }
  
  public static void i(Context paramContext, float paramFloat)
  {
    AppMethodBeat.i(125171);
    paramContext = paramContext.getSharedPreferences(ak.fow(), 0).edit();
    paramContext.putFloat("text_size_scale_key", paramFloat);
    paramContext.commit();
    scale = paramFloat;
    AppMethodBeat.o(125171);
  }
  
  public static float id(Context paramContext)
  {
    AppMethodBeat.i(125156);
    if (im(paramContext))
    {
      AppMethodBeat.o(125156);
      return 0.8F;
    }
    AppMethodBeat.o(125156);
    return 0.875F;
  }
  
  public static float ie(Context paramContext)
  {
    AppMethodBeat.i(125157);
    if (im(paramContext))
    {
      AppMethodBeat.o(125157);
      return 1.0F;
    }
    AppMethodBeat.o(125157);
    return 1.0F;
  }
  
  public static float jdMethod_if(Context paramContext)
  {
    AppMethodBeat.i(125158);
    if (im(paramContext))
    {
      AppMethodBeat.o(125158);
      return 1.1F;
    }
    AppMethodBeat.o(125158);
    return 1.11F;
  }
  
  public static float ig(Context paramContext)
  {
    AppMethodBeat.i(125159);
    if (im(paramContext))
    {
      AppMethodBeat.o(125159);
      return 1.12F;
    }
    AppMethodBeat.o(125159);
    return 1.25F;
  }
  
  public static float ih(Context paramContext)
  {
    AppMethodBeat.i(125160);
    if (im(paramContext))
    {
      AppMethodBeat.o(125160);
      return 1.125F;
    }
    AppMethodBeat.o(125160);
    return 1.375F;
  }
  
  public static float ii(Context paramContext)
  {
    AppMethodBeat.i(125161);
    if (im(paramContext))
    {
      AppMethodBeat.o(125161);
      return 1.4F;
    }
    AppMethodBeat.o(125161);
    return 1.625F;
  }
  
  public static float ij(Context paramContext)
  {
    AppMethodBeat.i(125162);
    if (im(paramContext))
    {
      AppMethodBeat.o(125162);
      return 1.55F;
    }
    AppMethodBeat.o(125162);
    return 1.875F;
  }
  
  public static float ik(Context paramContext)
  {
    AppMethodBeat.i(125163);
    if (im(paramContext))
    {
      AppMethodBeat.o(125163);
      return 1.65F;
    }
    AppMethodBeat.o(125163);
    return 2.025F;
  }
  
  public static float il(Context paramContext)
  {
    float f = 1.0F;
    AppMethodBeat.i(125165);
    if (paramContext == null) {}
    for (;;)
    {
      AppMethodBeat.o(125165);
      return f;
      f = paramContext.getSharedPreferences(ak.fow(), 0).getFloat("text_size_scale_key", 1.0F);
    }
  }
  
  public static boolean im(Context paramContext)
  {
    AppMethodBeat.i(125166);
    if ((paramContext != null) && (!Ipt))
    {
      Ipu = paramContext.getSharedPreferences(ak.fow(), 0).getBoolean("screenResolution_isModifyDensity", true);
      Ipt = true;
    }
    boolean bool = Ipu;
    AppMethodBeat.o(125166);
    return bool;
  }
  
  public static int in(Context paramContext)
  {
    AppMethodBeat.i(125167);
    float f = il(paramContext);
    if (f == id(paramContext))
    {
      AppMethodBeat.o(125167);
      return 1;
    }
    if (f == ie(paramContext))
    {
      AppMethodBeat.o(125167);
      return 2;
    }
    if (f == jdMethod_if(paramContext))
    {
      AppMethodBeat.o(125167);
      return 3;
    }
    if (f == ig(paramContext))
    {
      AppMethodBeat.o(125167);
      return 4;
    }
    if (f == ih(paramContext))
    {
      AppMethodBeat.o(125167);
      return 5;
    }
    if (f == ii(paramContext))
    {
      AppMethodBeat.o(125167);
      return 6;
    }
    if (f == ij(paramContext))
    {
      AppMethodBeat.o(125167);
      return 7;
    }
    if (f == ik(paramContext))
    {
      AppMethodBeat.o(125167);
      return 8;
    }
    AppMethodBeat.o(125167);
    return 2;
  }
  
  public static int io(Context paramContext)
  {
    AppMethodBeat.i(125168);
    float f = il(paramContext);
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
    if ((f == 1.625F) || (al(f, 1.3F)))
    {
      AppMethodBeat.o(125168);
      return 5;
    }
    if ((f == 1.875F) || (al(f, 1.38F)))
    {
      AppMethodBeat.o(125168);
      return 6;
    }
    if ((f == 2.025F) || (al(f, 1.565F)))
    {
      AppMethodBeat.o(125168);
      return 7;
    }
    AppMethodBeat.o(125168);
    return 1;
  }
  
  public static float ip(Context paramContext)
  {
    AppMethodBeat.i(125169);
    float f = 1.0F;
    if (is(paramContext)) {
      if (!im(paramContext)) {
        break label34;
      }
    }
    label34:
    for (f = 1.2F;; f = 1.1F)
    {
      AppMethodBeat.o(125169);
      return f;
    }
  }
  
  public static float iq(Context paramContext)
  {
    AppMethodBeat.i(125170);
    float f2 = 1.0F;
    float f1 = f2;
    if (!im(paramContext))
    {
      f1 = f2;
      if (is(paramContext)) {
        f1 = 1.1F;
      }
    }
    AppMethodBeat.o(125170);
    return f1;
  }
  
  public static boolean ir(Context paramContext)
  {
    AppMethodBeat.i(125172);
    float f = ef(paramContext);
    scale = f;
    if (Float.compare(f, jdMethod_if(paramContext)) > 0)
    {
      AppMethodBeat.o(125172);
      return true;
    }
    AppMethodBeat.o(125172);
    return false;
  }
  
  public static boolean is(Context paramContext)
  {
    AppMethodBeat.i(125173);
    float f = ef(paramContext);
    scale = f;
    if (Float.compare(f, ig(paramContext)) > 0)
    {
      AppMethodBeat.o(125173);
      return true;
    }
    AppMethodBeat.o(125173);
    return false;
  }
  
  public static boolean it(Context paramContext)
  {
    AppMethodBeat.i(125174);
    float f = ef(paramContext);
    scale = f;
    if (f == id(paramContext))
    {
      AppMethodBeat.o(125174);
      return true;
    }
    AppMethodBeat.o(125174);
    return false;
  }
  
  public static int iu(Context paramContext)
  {
    AppMethodBeat.i(125175);
    if (Ipr == null)
    {
      if (paramContext == null)
      {
        ae.e("MicroMsg.ResourceHelper", "get widthPixels but context is null");
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
  
  public static int iv(Context paramContext)
  {
    AppMethodBeat.i(125176);
    if (Ipr == null)
    {
      if (paramContext == null)
      {
        ae.e("MicroMsg.ResourceHelper", "get heightPixels but context is null");
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
  
  public static Drawable l(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(125148);
    if (Ipr == null)
    {
      if (paramContext == null)
      {
        ae.e("MicroMsg.ResourceHelper", "get drawable, resId %d, but context is null", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(125148);
        return null;
      }
      paramContext = paramContext.getResources().getDrawable(paramInt);
      AppMethodBeat.o(125148);
      return paramContext;
    }
    paramContext = Ipr.flt();
    AppMethodBeat.o(125148);
    return paramContext;
  }
  
  public static ColorStateList m(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(125147);
    if (Ipr == null)
    {
      if (paramContext == null)
      {
        ae.e("MicroMsg.ResourceHelper", "get color state list, resId %d, but context is null", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(125147);
        return null;
      }
      paramContext = paramContext.getResources().getColorStateList(paramInt);
      AppMethodBeat.o(125147);
      return paramContext;
    }
    paramContext = Ipr.fls();
    AppMethodBeat.o(125147);
    return paramContext;
  }
  
  public static int n(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(125146);
    if (Ipr == null)
    {
      if (paramContext == null)
      {
        ae.e("MicroMsg.ResourceHelper", "get color, resId %d, but context is null", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(125146);
        return 0;
      }
      paramInt = paramContext.getResources().getColor(paramInt);
      AppMethodBeat.o(125146);
      return paramInt;
    }
    paramInt = Ipr.flr();
    AppMethodBeat.o(125146);
    return paramInt;
  }
  
  public static abstract interface a
  {
    public abstract int flr();
    
    public abstract ColorStateList fls();
    
    public abstract Drawable flt();
    
    public abstract int flu();
    
    public abstract String flv();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cb.a
 * JD-Core Version:    0.7.0.1
 */