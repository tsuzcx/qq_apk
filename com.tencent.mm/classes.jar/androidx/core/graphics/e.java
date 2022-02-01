package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.Handler;
import androidx.core.content.a.c.a;
import androidx.core.content.a.c.b;
import androidx.core.content.a.c.d;
import androidx.core.content.a.f.a;
import androidx.core.d.b;
import androidx.core.d.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SuppressLint({"NewApi"})
public final class e
{
  private static final k Ks;
  private static final androidx.b.e<String, Typeface> Kt;
  
  static
  {
    AppMethodBeat.i(250703);
    if (Build.VERSION.SDK_INT >= 29) {
      Ks = new j();
    }
    for (;;)
    {
      Kt = new androidx.b.e(16);
      AppMethodBeat.o(250703);
      return;
      if (Build.VERSION.SDK_INT >= 28) {
        Ks = new i();
      } else if (Build.VERSION.SDK_INT >= 26) {
        Ks = new h();
      } else if ((Build.VERSION.SDK_INT >= 24) && (g.gx())) {
        Ks = new g();
      } else if (Build.VERSION.SDK_INT >= 21) {
        Ks = new f();
      } else {
        Ks = new k();
      }
    }
  }
  
  public static Typeface a(Context paramContext, Resources paramResources, int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(250699);
    paramContext = Ks.a(paramContext, paramResources, paramInt1, paramString, paramInt2);
    if (paramContext != null)
    {
      paramResources = b(paramResources, paramInt1, paramInt2);
      Kt.put(paramResources, paramContext);
    }
    AppMethodBeat.o(250699);
    return paramContext;
  }
  
  public static Typeface a(Context paramContext, c.a parama, Resources paramResources, int paramInt1, int paramInt2, f.a parama1, Handler paramHandler, boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(250697);
    int i;
    if ((parama instanceof c.d))
    {
      parama = (c.d)parama;
      if (paramBoolean) {
        if (parama.Ki == 0)
        {
          if (!paramBoolean) {
            break label105;
          }
          i = parama.Kh;
          label43:
          paramContext = b.a(paramContext, parama.Kg, parama1, paramHandler, bool, i, paramInt2);
        }
      }
    }
    for (;;)
    {
      if (paramContext != null) {
        Kt.put(b(paramResources, paramInt1, paramInt2), paramContext);
      }
      AppMethodBeat.o(250697);
      return paramContext;
      bool = false;
      break;
      if (parama1 == null) {
        break;
      }
      bool = false;
      break;
      label105:
      i = -1;
      break label43;
      parama = Ks.a(paramContext, (c.b)parama, paramResources, paramInt2);
      paramContext = parama;
      if (parama1 != null) {
        if (parama != null)
        {
          parama1.a(parama, paramHandler);
          paramContext = parama;
        }
        else
        {
          parama1.a(-3, paramHandler);
          paramContext = parama;
        }
      }
    }
  }
  
  public static Typeface a(Context paramContext, b.b[] paramArrayOfb, int paramInt)
  {
    AppMethodBeat.i(250701);
    paramContext = Ks.a(paramContext, paramArrayOfb, paramInt);
    AppMethodBeat.o(250701);
    return paramContext;
  }
  
  public static Typeface a(Resources paramResources, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(250694);
    paramResources = (Typeface)Kt.get(b(paramResources, paramInt1, paramInt2));
    AppMethodBeat.o(250694);
    return paramResources;
  }
  
  private static String b(Resources paramResources, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(250695);
    paramResources = paramResources.getResourcePackageName(paramInt1) + "-" + paramInt1 + "-" + paramInt2;
    AppMethodBeat.o(250695);
    return paramResources;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     androidx.core.graphics.e
 * JD-Core Version:    0.7.0.1
 */