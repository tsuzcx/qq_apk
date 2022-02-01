package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.Handler;
import androidx.core.content.a.c.a;
import androidx.core.content.a.c.b;
import androidx.core.content.a.c.d;
import androidx.core.content.a.f.c;
import androidx.core.d.a;
import androidx.core.d.d;
import androidx.core.d.e.b;
import androidx.core.d.e.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
{
  private static final androidx.b.e<String, Typeface> bqA;
  private static final k bqz;
  
  static
  {
    AppMethodBeat.i(196154);
    if (Build.VERSION.SDK_INT >= 29) {
      bqz = new j();
    }
    for (;;)
    {
      bqA = new androidx.b.e(16);
      AppMethodBeat.o(196154);
      return;
      if (Build.VERSION.SDK_INT >= 28) {
        bqz = new i();
      } else if (Build.VERSION.SDK_INT >= 26) {
        bqz = new h();
      } else if ((Build.VERSION.SDK_INT >= 24) && (g.DI())) {
        bqz = new g();
      } else if (Build.VERSION.SDK_INT >= 21) {
        bqz = new f();
      } else {
        bqz = new k();
      }
    }
  }
  
  public static Typeface a(Context paramContext, Resources paramResources, int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(196138);
    paramContext = bqz.a(paramContext, paramResources, paramInt1, paramString, paramInt2);
    if (paramContext != null)
    {
      paramResources = b(paramResources, paramInt1, paramInt2);
      bqA.put(paramResources, paramContext);
    }
    AppMethodBeat.o(196138);
    return paramContext;
  }
  
  public static Typeface a(Context paramContext, c.a parama, Resources paramResources, int paramInt1, int paramInt2, f.c paramc, Handler paramHandler, boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(196125);
    int j;
    if ((parama instanceof c.d))
    {
      c.d locald = (c.d)parama;
      parama = locald.bqn;
      if ((parama == null) || (parama.isEmpty())) {
        parama = null;
      }
      while (parama != null)
      {
        if (paramc != null) {
          paramc.a(parama, paramHandler);
        }
        AppMethodBeat.o(196125);
        return parama;
        Typeface localTypeface1 = Typeface.create(parama, 0);
        Typeface localTypeface2 = Typeface.create(Typeface.DEFAULT, 0);
        if (localTypeface1 != null)
        {
          parama = localTypeface1;
          if (!localTypeface1.equals(localTypeface2)) {}
        }
        else
        {
          parama = null;
        }
      }
      if (paramBoolean) {
        if (locald.bqm == 0)
        {
          if (!paramBoolean) {
            break label223;
          }
          j = locald.mTimeoutMs;
          label128:
          parama = f.c.c(paramHandler);
          paramc = new a(paramc);
          paramHandler = locald.bql;
          parama = new a(paramc, parama);
          if (i == 0) {
            break label229;
          }
          paramContext = d.a(paramContext, paramHandler, parama, paramInt2, j);
        }
      }
    }
    for (;;)
    {
      if (paramContext != null) {
        bqA.put(b(paramResources, paramInt1, paramInt2), paramContext);
      }
      AppMethodBeat.o(196125);
      return paramContext;
      i = 0;
      break;
      if (paramc == null) {
        break;
      }
      i = 0;
      break;
      label223:
      j = -1;
      break label128;
      label229:
      paramContext = d.a(paramContext, paramHandler, paramInt2, parama);
      continue;
      parama = bqz.a(paramContext, (c.b)parama, paramResources, paramInt2);
      paramContext = parama;
      if (paramc != null) {
        if (parama != null)
        {
          paramc.a(parama, paramHandler);
          paramContext = parama;
        }
        else
        {
          paramc.a(-3, paramHandler);
          paramContext = parama;
        }
      }
    }
  }
  
  public static Typeface a(Context paramContext, e.b[] paramArrayOfb, int paramInt)
  {
    AppMethodBeat.i(196146);
    paramContext = bqz.a(paramContext, paramArrayOfb, paramInt);
    AppMethodBeat.o(196146);
    return paramContext;
  }
  
  public static Typeface a(Resources paramResources, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(196096);
    paramResources = (Typeface)bqA.get(b(paramResources, paramInt1, paramInt2));
    AppMethodBeat.o(196096);
    return paramResources;
  }
  
  private static String b(Resources paramResources, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(196108);
    paramResources = paramResources.getResourcePackageName(paramInt1) + "-" + paramInt1 + "-" + paramInt2;
    AppMethodBeat.o(196108);
    return paramResources;
  }
  
  public static final class a
    extends e.c
  {
    private f.c bqB;
    
    public a(f.c paramc)
    {
      this.bqB = paramc;
    }
    
    public final void d(Typeface paramTypeface)
    {
      AppMethodBeat.i(196029);
      if (this.bqB != null) {
        this.bqB.b(paramTypeface);
      }
      AppMethodBeat.o(196029);
    }
    
    public final void ei(int paramInt)
    {
      AppMethodBeat.i(196035);
      if (this.bqB != null) {
        this.bqB.as(paramInt);
      }
      AppMethodBeat.o(196035);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.core.graphics.e
 * JD-Core Version:    0.7.0.1
 */