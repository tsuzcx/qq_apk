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
        Object localObject3 = x.a(x.b(this.b, t.q, "default"));
        if (((List)localObject3).isEmpty())
        {
          AppMethodBeat.o(180808);
          localObject1 = null;
          return localObject1;
        }
        x.f = x.a((List)localObject3);
        Object localObject1 = x.b(this.b, x.a);
        str = x.b(this.b, x.b);
        localStringBuilder = new StringBuilder();
        i = s.a(this.b).a;
        localObject3 = ((List)localObject3).iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break label279;
        }
        localObject4 = (p)((Iterator)localObject3).next();
        if ((localObject4 != null) && (!x.a(((p)localObject4).a)))
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
      if ((x.a(((p)localObject4).a)) && (((p)localObject4).a == i))
      {
        localObject4 = x.c + File.separator + t.F[i] + File.separator + ((p)localObject4).c;
        x.g = x.b(this.b, (String)localObject4);
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
        g.a(this.b).a("CPL", "suc:" + x.f);
        g.a(this.b).a("CPL", "conuseT:" + (System.currentTimeMillis() - l));
        AppMethodBeat.o(180808);
      }
      catch (Throwable localThrowable1)
      {
        break label377;
      }
      g.a(this.b).a("CPL", "fail:" + x.f + ",exc:" + str.toString());
      AppMethodBeat.o(180808);
    }
  }
  
  public final DexClassLoader a()
  {
    AppMethodBeat.i(180807);
    try
    {
      DexClassLoader localDexClassLoader = b();
      x.e(this.b);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.map.tools.internal.j
 * JD-Core Version:    0.7.0.1
 */