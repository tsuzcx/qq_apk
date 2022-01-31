package android.support.v4.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.support.v4.content.a.a.a;
import android.support.v4.content.a.a.b;
import android.support.v4.content.a.a.d;
import android.support.v4.content.a.b.a;
import android.support.v4.d.b;
import android.support.v4.d.b.b;

public final class d
{
  private static final a zX;
  private static final android.support.v4.f.g<String, Typeface> zY;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 26) {
      zX = new g();
    }
    for (;;)
    {
      zY = new android.support.v4.f.g(16);
      return;
      if ((Build.VERSION.SDK_INT >= 24) && (f.cl())) {
        zX = new f();
      } else if (Build.VERSION.SDK_INT >= 21) {
        zX = new e();
      } else {
        zX = new h();
      }
    }
  }
  
  public static Typeface a(Context paramContext, Resources paramResources, int paramInt1, String paramString, int paramInt2)
  {
    paramContext = zX.a(paramContext, paramResources, paramInt1, paramString, paramInt2);
    if (paramContext != null)
    {
      paramResources = b(paramResources, paramInt1, paramInt2);
      zY.put(paramResources, paramContext);
    }
    return paramContext;
  }
  
  public static Typeface a(Context paramContext, a.a parama, Resources paramResources, int paramInt1, int paramInt2, b.a parama1)
  {
    boolean bool;
    if ((parama instanceof a.d))
    {
      parama = (a.d)parama;
      if (parama.zN == 0)
      {
        bool = true;
        int i = parama.zM;
        paramContext = b.a(paramContext, parama.zL, parama1, bool, i, paramInt2);
      }
    }
    for (;;)
    {
      if (paramContext != null) {
        zY.put(b(paramResources, paramInt1, paramInt2), paramContext);
      }
      return paramContext;
      bool = false;
      break;
      parama = zX.a(paramContext, (a.b)parama, paramResources, paramInt2);
      paramContext = parama;
      if (parama1 != null) {
        if (parama != null)
        {
          parama1.a(parama, null);
          paramContext = parama;
        }
        else
        {
          parama1.a(-3, null);
          paramContext = parama;
        }
      }
    }
  }
  
  public static Typeface a(Context paramContext, b.b[] paramArrayOfb, int paramInt)
  {
    return zX.a(paramContext, paramArrayOfb, paramInt);
  }
  
  public static Typeface a(Resources paramResources, int paramInt1, int paramInt2)
  {
    return (Typeface)zY.get(b(paramResources, paramInt1, paramInt2));
  }
  
  private static String b(Resources paramResources, int paramInt1, int paramInt2)
  {
    return paramResources.getResourcePackageName(paramInt1) + "-" + paramInt1 + "-" + paramInt2;
  }
  
  static abstract interface a
  {
    public abstract Typeface a(Context paramContext, Resources paramResources, int paramInt1, String paramString, int paramInt2);
    
    public abstract Typeface a(Context paramContext, a.b paramb, Resources paramResources, int paramInt);
    
    public abstract Typeface a(Context paramContext, b.b[] paramArrayOfb, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.a.d
 * JD-Core Version:    0.7.0.1
 */