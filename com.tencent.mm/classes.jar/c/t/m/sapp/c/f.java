package c.t.m.sapp.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import dalvik.system.DexClassLoader;
import java.util.List;

public class f
{
  public static DexClassLoader a;
  public static Context b;
  public static f c;
  
  public f(Context paramContext)
  {
    AppMethodBeat.i(186146);
    b = paramContext;
    n.a(paramContext).a();
    AppMethodBeat.o(186146);
  }
  
  public static f a(Context paramContext)
  {
    AppMethodBeat.i(186279);
    if (c == null) {}
    try
    {
      if (c == null) {
        c = new f(paramContext);
      }
      paramContext = c;
      AppMethodBeat.o(186279);
      return paramContext;
    }
    finally
    {
      AppMethodBeat.o(186279);
    }
  }
  
  public DexClassLoader a()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(186284);
        Object localObject = a;
        if (localObject != null)
        {
          AppMethodBeat.o(186284);
          return localObject;
        }
        localObject = b;
        if (localObject == null)
        {
          localObject = null;
          AppMethodBeat.o(186284);
          continue;
        }
        d.a(localContext).b("load_sapp");
      }
      finally {}
      r.e = System.currentTimeMillis();
      DexClassLoader localDexClassLoader = h.a(b).b();
      a = localDexClassLoader;
      if (localDexClassLoader != null) {
        e.a(b).a();
      }
      b();
      d.a(b).c("load_sapp");
      localDexClassLoader = a;
      AppMethodBeat.o(186284);
    }
  }
  
  public void b()
  {
    AppMethodBeat.i(186288);
    try
    {
      Object localObject1 = b;
      localObject1 = r.e(r.b((Context)localObject1, "__SP_Tencent_Loc_COMP_INFO__sapp_", ""));
      new Thread(new i(b, (List)localObject1, false)).start();
      return;
    }
    finally
    {
      AppMethodBeat.o(186288);
    }
  }
  
  public void c()
  {
    c = null;
    a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     c.t.m.sapp.c.f
 * JD-Core Version:    0.7.0.1
 */