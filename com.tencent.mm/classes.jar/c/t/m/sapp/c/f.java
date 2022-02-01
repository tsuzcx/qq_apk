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
    AppMethodBeat.i(210714);
    b = paramContext;
    n.a(paramContext).a();
    AppMethodBeat.o(210714);
  }
  
  public static f a(Context paramContext)
  {
    AppMethodBeat.i(210715);
    if (c == null) {}
    try
    {
      if (c == null) {
        c = new f(paramContext);
      }
      paramContext = c;
      AppMethodBeat.o(210715);
      return paramContext;
    }
    finally
    {
      AppMethodBeat.o(210715);
    }
  }
  
  public DexClassLoader a()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(210716);
        Object localObject = a;
        if (localObject != null)
        {
          AppMethodBeat.o(210716);
          return localObject;
        }
        localObject = b;
        if (localObject == null)
        {
          localObject = null;
          AppMethodBeat.o(210716);
          continue;
        }
        d.a(localContext).b("load_sapp");
      }
      finally {}
      q.e = System.currentTimeMillis();
      DexClassLoader localDexClassLoader = h.a(b).b();
      a = localDexClassLoader;
      if (localDexClassLoader != null) {
        e.a(b).a();
      }
      b();
      d.a(b).c("load_sapp");
      localDexClassLoader = a;
      AppMethodBeat.o(210716);
    }
  }
  
  public void b()
  {
    AppMethodBeat.i(210717);
    try
    {
      Object localObject = b;
      localObject = q.e(q.a((Context)localObject, "__SP_Tencent_Loc_COMP_INFO__sapp_", ""));
      new Thread(new i(b, (List)localObject, false)).start();
      AppMethodBeat.o(210717);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(210717);
    }
  }
  
  public void c()
  {
    c = null;
    a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     c.t.m.sapp.c.f
 * JD-Core Version:    0.7.0.1
 */