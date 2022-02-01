package com.tencent.map.tools.internal;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class j
{
  private String a;
  private Context b;
  
  public j(Context paramContext)
  {
    AppMethodBeat.i(180806);
    this.a = j.class.getSimpleName();
    this.b = paramContext;
    AppMethodBeat.o(180806);
  }
  
  private DexClassLoader b()
  {
    for (;;)
    {
      String str;
      StringBuilder localStringBuilder;
      int i;
      Object localObject4;
      try
      {
        AppMethodBeat.i(180808);
        Object localObject3 = y.a(y.b(this.b, u.q, "default"));
        if (((List)localObject3).isEmpty())
        {
          AppMethodBeat.o(180808);
          localObject1 = null;
          return localObject1;
        }
        y.f = y.a((List)localObject3);
        Object localObject1 = y.b(this.b, y.a);
        str = y.b(this.b, y.b);
        localStringBuilder = new StringBuilder();
        i = t.a(this.b).a;
        localObject3 = ((List)localObject3).iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break label279;
        }
        localObject4 = (p)((Iterator)localObject3).next();
        if ((localObject4 != null) && (!y.a(((p)localObject4).a)))
        {
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append(File.separator);
          localStringBuilder.append(((p)localObject4).c);
          localStringBuilder.append(File.pathSeparator);
          continue;
        }
        if (localObject4 == null) {
          continue;
        }
      }
      finally {}
      if ((y.a(((p)localObject4).a)) && (((p)localObject4).a == i))
      {
        localObject4 = y.c + File.separator + u.F[i] + File.separator + ((p)localObject4).c;
        y.g = y.b(this.b, (String)localObject4);
      }
      try
      {
        label279:
        l = System.currentTimeMillis();
        localDexClassLoader = new DexClassLoader(localStringBuilder.toString(), str, null, getClass().getClassLoader());
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          long l;
          label377:
          DexClassLoader localDexClassLoader = null;
        }
      }
      try
      {
        g.a(this.b).a("CPL", "suc:" + y.f);
        g.a(this.b).a("CPL", "conuseT:" + (System.currentTimeMillis() - l));
        AppMethodBeat.o(180808);
      }
      catch (Throwable localThrowable1)
      {
        break label377;
      }
      g.a(this.b).a("CPL", "fail:" + y.f + ",exc:" + str.toString());
      AppMethodBeat.o(180808);
    }
  }
  
  public final DexClassLoader a()
  {
    AppMethodBeat.i(180807);
    try
    {
      DexClassLoader localDexClassLoader = b();
      y.e(this.b);
      AppMethodBeat.o(180807);
      return localDexClassLoader;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        g.a().a("CPL", "fail:" + localThrowable.toString());
        Object localObject = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.map.tools.internal.j
 * JD-Core Version:    0.7.0.1
 */