package com.tencent.mm.cb;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.SparseIntArray;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

public final class a
{
  private static float density;
  private static float scale = 0.0F;
  private static a uaP = null;
  private static SparseIntArray uaQ;
  
  static
  {
    density = -1.0F;
    uaQ = new SparseIntArray();
  }
  
  public static int aa(Context paramContext, int paramInt)
  {
    float f1 = 1.625F;
    float f2 = scale;
    if (f2 > 1.625F) {}
    for (;;)
    {
      if (uaP == null)
      {
        if (paramContext == null)
        {
          y.e("MicroMsg.ResourceHelper", "get dimension pixel size, resId %d, but context is null", new Object[] { Integer.valueOf(paramInt) });
          return 0;
        }
        j = uaQ.get(paramInt, 0);
        i = j;
        if (j == 0)
        {
          i = paramContext.getResources().getDimensionPixelSize(paramInt);
          uaQ.put(paramInt, i);
        }
        return (int)(f1 * i);
      }
      int j = uaQ.get(paramInt, 0);
      int i = j;
      if (j == 0)
      {
        i = uaP.cpt();
        uaQ.put(paramInt, i);
      }
      return (int)(f1 * i);
      f1 = f2;
    }
  }
  
  public static int ab(Context paramContext, int paramInt)
  {
    int i = 0;
    if (uaP == null) {
      if (paramContext == null) {
        y.e("MicroMsg.ResourceHelper", "get dimension pixel size, resId %d, but context is null", new Object[] { Integer.valueOf(paramInt) });
      }
    }
    int j;
    do
    {
      do
      {
        return i;
        j = uaQ.get(paramInt, 0);
        i = j;
      } while (j != 0);
      i = paramContext.getResources().getDimensionPixelSize(paramInt);
      uaQ.put(paramInt, i);
      return i;
      j = uaQ.get(paramInt, 0);
      i = j;
    } while (j != 0);
    i = uaP.cpt();
    uaQ.put(paramInt, i);
    return i;
  }
  
  public static String ac(Context paramContext, int paramInt)
  {
    if (uaP == null)
    {
      if (paramContext == null)
      {
        y.e("MicroMsg.ResourceHelper", "get string, resId %d, but context is null", new Object[] { Integer.valueOf(paramInt) });
        return "";
      }
      return paramContext.getResources().getString(paramInt);
    }
    return uaP.cpu();
  }
  
  public static int ad(Context paramContext, int paramInt)
  {
    return Math.round(paramInt / getDensity(paramContext));
  }
  
  public static float cJ(Context paramContext)
  {
    if (scale == 0.0F) {
      if (paramContext != null) {
        break label20;
      }
    }
    label20:
    for (scale = 1.0F;; scale = paramContext.getSharedPreferences(ae.cqR(), 0).getFloat("text_size_scale_key", 1.0F)) {
      return scale;
    }
  }
  
  public static int fe(Context paramContext)
  {
    int j = 2;
    float f = cJ(paramContext);
    int i;
    if (f == 0.875F) {
      i = 1;
    }
    do
    {
      do
      {
        return i;
        i = j;
      } while (f == 1.0F);
      if (f == 1.125F) {
        return 3;
      }
      if (f == 1.25F) {
        return 4;
      }
      if (f == 1.375F) {
        return 5;
      }
      if (f == 1.625F) {
        return 6;
      }
      if (f == 1.875F) {
        return 7;
      }
      i = j;
    } while (f != 2.025F);
    return 8;
  }
  
  public static float ff(Context paramContext)
  {
    float f = 1.0F;
    if (fh(paramContext)) {
      f = 1.3F;
    }
    return f;
  }
  
  public static float fg(Context paramContext)
  {
    float f = 1.0F;
    if (fh(paramContext)) {
      f = 1.2F;
    }
    return f;
  }
  
  public static boolean fh(Context paramContext)
  {
    float f = cJ(paramContext);
    scale = f;
    return Float.compare(f, 1.125F) > 0;
  }
  
  public static boolean fi(Context paramContext)
  {
    float f = cJ(paramContext);
    scale = f;
    return f == 0.875F;
  }
  
  public static int fj(Context paramContext)
  {
    if (uaP == null)
    {
      if (paramContext == null) {
        y.e("MicroMsg.ResourceHelper", "get widthPixels but context is null");
      }
    }
    else {
      return 0;
    }
    return paramContext.getResources().getDisplayMetrics().widthPixels;
  }
  
  public static int fk(Context paramContext)
  {
    if (uaP == null)
    {
      if (paramContext == null) {
        y.e("MicroMsg.ResourceHelper", "get heightPixels but context is null");
      }
    }
    else {
      return 0;
    }
    return paramContext.getResources().getDisplayMetrics().heightPixels;
  }
  
  public static int fromDPToPix(Context paramContext, int paramInt)
  {
    return Math.round(getDensity(paramContext) * paramInt);
  }
  
  public static Drawable g(Context paramContext, int paramInt)
  {
    if (uaP == null)
    {
      if (paramContext == null)
      {
        y.e("MicroMsg.ResourceHelper", "get drawable, resId %d, but context is null", new Object[] { Integer.valueOf(paramInt) });
        return null;
      }
      return paramContext.getResources().getDrawable(paramInt);
    }
    return uaP.cps();
  }
  
  public static void g(Context paramContext, float paramFloat)
  {
    paramContext = paramContext.getSharedPreferences(ae.cqR(), 0).edit();
    paramContext.putFloat("text_size_scale_key", paramFloat);
    paramContext.commit();
    scale = paramFloat;
  }
  
  public static float getDensity(Context paramContext)
  {
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = ae.getContext();
    }
    if (density < 0.0F) {
      density = localContext.getResources().getDisplayMetrics().density;
    }
    return density;
  }
  
  public static ColorStateList h(Context paramContext, int paramInt)
  {
    if (uaP == null)
    {
      if (paramContext == null)
      {
        y.e("MicroMsg.ResourceHelper", "get color state list, resId %d, but context is null", new Object[] { Integer.valueOf(paramInt) });
        return null;
      }
      return paramContext.getResources().getColorStateList(paramInt);
    }
    return uaP.cpr();
  }
  
  public static int i(Context paramContext, int paramInt)
  {
    if (uaP == null)
    {
      if (paramContext == null)
      {
        y.e("MicroMsg.ResourceHelper", "get color, resId %d, but context is null", new Object[] { Integer.valueOf(paramInt) });
        return 0;
      }
      return paramContext.getResources().getColor(paramInt);
    }
    return uaP.cpq();
  }
  
  public static abstract interface a
  {
    public abstract int cpq();
    
    public abstract ColorStateList cpr();
    
    public abstract Drawable cps();
    
    public abstract int cpt();
    
    public abstract String cpu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cb.a
 * JD-Core Version:    0.7.0.1
 */