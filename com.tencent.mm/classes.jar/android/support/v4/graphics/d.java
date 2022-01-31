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
  private static final i AA;
  private static final android.support.v4.e.g<String, Typeface> AB;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 28) {
      AA = new h();
    }
    for (;;)
    {
      AB = new android.support.v4.e.g(16);
      return;
      if (Build.VERSION.SDK_INT >= 26) {
        AA = new g();
      } else if ((Build.VERSION.SDK_INT >= 24) && (f.cO())) {
        AA = new f();
      } else if (Build.VERSION.SDK_INT >= 21) {
        AA = new e();
      } else {
        AA = new i();
      }
    }
  }
  
  public static Typeface a(Context paramContext, Resources paramResources, int paramInt1, String paramString, int paramInt2)
  {
    paramContext = AA.a(paramContext, paramResources, paramInt1, paramString, paramInt2);
    if (paramContext != null)
    {
      paramResources = b(paramResources, paramInt1, paramInt2);
      AB.put(paramResources, paramContext);
    }
    return paramContext;
  }
  
  public static Typeface a(Context paramContext, c.a parama, Resources paramResources, int paramInt1, int paramInt2, f.a parama1)
  {
    boolean bool;
    if ((parama instanceof c.d))
    {
      parama = (c.d)parama;
      if (parama.Ap == 0)
      {
        bool = true;
        int i = parama.Ao;
        paramContext = b.a(paramContext, parama.An, parama1, bool, i, paramInt2);
      }
    }
    for (;;)
    {
      if (paramContext != null) {
        AB.put(b(paramResources, paramInt1, paramInt2), paramContext);
      }
      return paramContext;
      bool = false;
      break;
      parama = AA.a(paramContext, (c.b)parama, paramResources, paramInt2);
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
    return AA.a(paramContext, paramArrayOfb, paramInt);
  }
  
  public static Typeface a(Resources paramResources, int paramInt1, int paramInt2)
  {
    return (Typeface)AB.get(b(paramResources, paramInt1, paramInt2));
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