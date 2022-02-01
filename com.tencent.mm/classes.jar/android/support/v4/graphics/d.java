package android.support.v4.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.support.v4.c.b;
import android.support.v4.c.b.b;
import android.support.v4.content.a.c.a;
import android.support.v4.content.a.c.b;
import android.support.v4.content.a.c.d;
import android.support.v4.content.a.f.a;

public final class d
{
  private static final i GV;
  private static final android.support.v4.e.h<String, Typeface> GW;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 28) {
      GV = new h();
    }
    for (;;)
    {
      GW = new android.support.v4.e.h(16);
      return;
      if (Build.VERSION.SDK_INT >= 26) {
        GV = new g();
      } else if ((Build.VERSION.SDK_INT >= 24) && (f.dT())) {
        GV = new f();
      } else if (Build.VERSION.SDK_INT >= 21) {
        GV = new e();
      } else {
        GV = new i();
      }
    }
  }
  
  public static Typeface a(Context paramContext, Resources paramResources, int paramInt1, String paramString, int paramInt2)
  {
    paramContext = GV.a(paramContext, paramResources, paramInt1, paramString, paramInt2);
    if (paramContext != null)
    {
      paramResources = b(paramResources, paramInt1, paramInt2);
      GW.put(paramResources, paramContext);
    }
    return paramContext;
  }
  
  public static Typeface a(Context paramContext, c.a parama, Resources paramResources, int paramInt1, int paramInt2, f.a parama1, boolean paramBoolean)
  {
    boolean bool = true;
    int i;
    if ((parama instanceof c.d))
    {
      parama = (c.d)parama;
      if (paramBoolean) {
        if (parama.GL == 0)
        {
          if (!paramBoolean) {
            break label94;
          }
          i = parama.GK;
          label38:
          paramContext = b.a(paramContext, parama.GJ, parama1, null, bool, i, paramInt2);
        }
      }
    }
    for (;;)
    {
      if (paramContext != null) {
        GW.put(b(paramResources, paramInt1, paramInt2), paramContext);
      }
      return paramContext;
      bool = false;
      break;
      if (parama1 == null) {
        break;
      }
      bool = false;
      break;
      label94:
      i = -1;
      break label38;
      parama = GV.a(paramContext, (c.b)parama, paramResources, paramInt2);
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
    return GV.a(paramContext, paramArrayOfb, paramInt);
  }
  
  public static Typeface a(Resources paramResources, int paramInt1, int paramInt2)
  {
    return (Typeface)GW.get(b(paramResources, paramInt1, paramInt2));
  }
  
  private static String b(Resources paramResources, int paramInt1, int paramInt2)
  {
    return paramResources.getResourcePackageName(paramInt1) + "-" + paramInt1 + "-" + paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.graphics.d
 * JD-Core Version:    0.7.0.1
 */