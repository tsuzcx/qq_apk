package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class kt
{
  private static final String a = "PoolUtil";
  private static final int b = 20;
  private static final k<Object> c;
  
  static
  {
    AppMethodBeat.i(222416);
    c = new k()
    {
      public final void a(Object paramAnonymousObject) {}
    };
    AppMethodBeat.o(222416);
  }
  
  private static <T> g<List<T>> a()
  {
    AppMethodBeat.i(222374);
    g localg = a(new j.b(20), new e()new k
    {
      private static List<T> b()
      {
        AppMethodBeat.i(221572);
        ArrayList localArrayList = new ArrayList();
        AppMethodBeat.o(221572);
        return localArrayList;
      }
    }, new k()
    {
      private static void a(List<T> paramAnonymousList)
      {
        AppMethodBeat.i(221595);
        paramAnonymousList.clear();
        AppMethodBeat.o(221595);
      }
    });
    AppMethodBeat.o(222374);
    return localg;
  }
  
  public static <T extends kt.h> g<T> a(int paramInt, e<T> parame)
  {
    AppMethodBeat.i(222356);
    parame = a(new j.b(paramInt), parame);
    AppMethodBeat.o(222356);
    return parame;
  }
  
  private static <T extends kt.h> g<T> a(int paramInt, e<T> parame, k<T> paramk)
  {
    AppMethodBeat.i(222364);
    parame = a(new j.b(paramInt), parame, paramk);
    AppMethodBeat.o(222364);
    return parame;
  }
  
  public static g<kt.i<Bitmap>> a(a parama)
  {
    AppMethodBeat.i(222336);
    parama = a(10, new b(parama)
    {
      private kt.i<Bitmap> b()
      {
        AppMethodBeat.i(221580);
        kt.i locali = new kt.i(Bitmap.createBitmap(this.a.a, this.a.b, this.a.c));
        AppMethodBeat.o(221580);
        return locali;
      }
    });
    AppMethodBeat.o(222336);
    return parama;
  }
  
  private static <T extends kt.h> g<T> a(g<T> paramg, e<T> parame)
  {
    AppMethodBeat.i(222393);
    paramg = a(paramg, parame, c);
    AppMethodBeat.o(222393);
    return paramg;
  }
  
  private static <T> g<T> a(g<T> paramg, e<T> parame, k<T> paramk)
  {
    AppMethodBeat.i(222403);
    paramg = new f(paramg, parame, paramk);
    AppMethodBeat.o(222403);
    return paramg;
  }
  
  private static <T> g<List<T>> b()
  {
    AppMethodBeat.i(222384);
    g localg = a(new j.b(20), new e()new k
    {
      private static List<T> b()
      {
        AppMethodBeat.i(221572);
        ArrayList localArrayList = new ArrayList();
        AppMethodBeat.o(221572);
        return localArrayList;
      }
    }, new k()
    {
      private static void a(List<T> paramAnonymousList)
      {
        AppMethodBeat.i(221595);
        paramAnonymousList.clear();
        AppMethodBeat.o(221595);
      }
    });
    AppMethodBeat.o(222384);
    return localg;
  }
  
  private static <T extends kt.h> g<T> b(int paramInt, e<T> parame)
  {
    AppMethodBeat.i(222345);
    parame = a(new j.a(paramInt), parame);
    AppMethodBeat.o(222345);
    return parame;
  }
  
  private static <T> k<T> c()
  {
    return c;
  }
  
  public static final class a
  {
    public int a = 256;
    public int b = 256;
    public Bitmap.Config c;
    
    public a(Bitmap.Config paramConfig)
    {
      this.c = paramConfig;
    }
    
    private void a(a parama)
    {
      if (parama != null)
      {
        this.a = parama.a;
        this.b = parama.b;
        this.c = parama.c;
      }
    }
  }
  
  static abstract class b<T>
    implements kt.e<T>
  {
    kt.a a;
    
    b(kt.a parama)
    {
      this.a = parama;
    }
  }
  
  public static abstract interface e<T>
  {
    public abstract T a();
  }
  
  static final class f<T>
    implements kt.g<T>
  {
    private final kt.e<T> a;
    private final kt.k<T> b;
    private final kt.g<T> c;
    
    f(kt.g<T> paramg, kt.e<T> parame, kt.k<T> paramk)
    {
      this.c = paramg;
      this.a = parame;
      this.b = paramk;
    }
    
    public final T a()
    {
      AppMethodBeat.i(225952);
      Object localObject2 = this.c.a();
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = this.a.a();
        kh.a("PoolUtil", "Created new ".concat(String.valueOf(localObject1)));
      }
      if ((localObject1 instanceof kt.h)) {
        ((kt.h)localObject1).a().a(false);
      }
      AppMethodBeat.o(225952);
      return localObject1;
    }
    
    public final boolean a(T paramT)
    {
      AppMethodBeat.i(225964);
      if ((paramT instanceof kt.h)) {
        ((kt.h)paramT).a().a(true);
      }
      this.b.a(paramT);
      boolean bool = this.c.a(paramT);
      AppMethodBeat.o(225964);
      return bool;
    }
  }
  
  public static abstract interface g<T>
  {
    public abstract T a();
    
    public abstract boolean a(T paramT);
  }
  
  public static class j$a<T>
    implements kt.g<T>
  {
    private final Object[] a;
    private int b;
    
    public j$a(int paramInt)
    {
      AppMethodBeat.i(221506);
      if (paramInt <= 0)
      {
        IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("The max pool size must be > 0");
        AppMethodBeat.o(221506);
        throw localIllegalArgumentException;
      }
      this.a = new Object[paramInt];
      AppMethodBeat.o(221506);
    }
    
    private boolean b(T paramT)
    {
      boolean bool2 = false;
      int i = 0;
      for (;;)
      {
        boolean bool1 = bool2;
        if (i < this.b)
        {
          if (this.a[i] == paramT) {
            bool1 = true;
          }
        }
        else {
          return bool1;
        }
        i += 1;
      }
    }
    
    public T a()
    {
      if (this.b > 0)
      {
        int i = this.b - 1;
        Object localObject = this.a[i];
        this.a[i] = null;
        this.b -= 1;
        return localObject;
      }
      return null;
    }
    
    public boolean a(T paramT)
    {
      AppMethodBeat.i(221545);
      int i = 0;
      if (i < this.b) {
        if (this.a[i] != paramT) {}
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label60;
        }
        paramT = new IllegalStateException("Already in the pool!");
        AppMethodBeat.o(221545);
        throw paramT;
        i += 1;
        break;
      }
      label60:
      if (this.b < this.a.length)
      {
        this.a[this.b] = paramT;
        this.b += 1;
        AppMethodBeat.o(221545);
        return true;
      }
      AppMethodBeat.o(221545);
      return false;
    }
  }
  
  public static final class j$b<T>
    extends kt.j.a<T>
  {
    private final Object a;
    
    public j$b(int paramInt)
    {
      super();
      AppMethodBeat.i(221517);
      this.a = new Object();
      AppMethodBeat.o(221517);
    }
    
    public final T a()
    {
      AppMethodBeat.i(221524);
      synchronized (this.a)
      {
        Object localObject2 = super.a();
        AppMethodBeat.o(221524);
        return localObject2;
      }
    }
    
    public final boolean a(T paramT)
    {
      AppMethodBeat.i(221531);
      synchronized (this.a)
      {
        boolean bool = super.a(paramT);
        AppMethodBeat.o(221531);
        return bool;
      }
    }
  }
  
  public static abstract interface k<T>
  {
    public abstract void a(T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mapsdk.internal.kt
 * JD-Core Version:    0.7.0.1
 */