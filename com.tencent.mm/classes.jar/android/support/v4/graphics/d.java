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
  private static final i JL;
  private static final android.support.v4.e.h<String, Typeface> JM;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 28) {
      JL = new h();
    }
    for (;;)
    {
      JM = new android.support.v4.e.h(16);
      return;
      if (Build.VERSION.SDK_INT >= 26) {
        JL = new g();
      } else if ((Build.VERSION.SDK_INT >= 24) && (f.ev())) {
        JL = new f();
      } else if (Build.VERSION.SDK_INT >= 21) {
        JL = new e();
      } else {
        JL = new i();
      }
    }
  }
  
  public static Typeface a(Context paramContext, Resources paramResources, int paramInt1, String paramString, int paramInt2)
  {
    paramContext = JL.a(paramContext, paramResources, paramInt1, paramString, paramInt2);
    if (paramContext != null)
    {
      paramResources = b(paramResources, paramInt1, paramInt2);
      JM.put(paramResources, paramContext);
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
        if (parama.JC == 0)
        {
          if (!paramBoolean) {
            break label94;
          }
          i = parama.mTimeoutMs;
          label38:
          paramContext = b.a(paramContext, parama.JB, parama1, null, bool, i, paramInt2);
        }
      }
    }
    for (;;)
    {
      if (paramContext != null) {
        JM.put(b(paramResources, paramInt1, paramInt2), paramContext);
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
      parama = JL.a(paramContext, (c.b)parama, paramResources, paramInt2);
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
    return JL.a(paramContext, paramArrayOfb, paramInt);
  }
  
  public static Typeface a(Resources paramResources, int paramInt1, int paramInt2)
  {
    return (Typeface)JM.get(b(paramResources, paramInt1, paramInt2));
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