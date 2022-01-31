package c.t.m.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import dalvik.system.DexClassLoader;
import java.util.ArrayList;
import java.util.List;

public class f
{
  private static DexClassLoader a;
  private static Context b;
  private static f c;
  
  private f(Context paramContext)
  {
    AppMethodBeat.i(136354);
    b = paramContext;
    n.a(paramContext).a();
    e.a(paramContext).b();
    AppMethodBeat.o(136354);
  }
  
  public static f a(Context paramContext)
  {
    AppMethodBeat.i(136355);
    if (c == null) {}
    try
    {
      if (c == null) {
        c = new f(paramContext);
      }
      paramContext = c;
      AppMethodBeat.o(136355);
      return paramContext;
    }
    finally
    {
      AppMethodBeat.o(136355);
    }
  }
  
  public DexClassLoader a()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(136356);
        DexClassLoader localDexClassLoader;
        if (a != null)
        {
          localDexClassLoader = a;
          AppMethodBeat.o(136356);
          return localDexClassLoader;
        }
        if (b == null)
        {
          localDexClassLoader = null;
          AppMethodBeat.o(136356);
          continue;
        }
        q.c = System.currentTimeMillis();
      }
      finally {}
      d.a(b).a("load");
      new ArrayList();
      if (i.a(b).a())
      {
        System.currentTimeMillis();
        g.a(b).a();
        localObject2 = q.b(q.b(b, "__SP_Tencent_Loc_COMP_INFO__", ""));
        System.currentTimeMillis();
        a = b.a(b, (List)localObject2).a();
      }
      d.a(b).b("load");
      if (a != null) {
        e.a(b).d();
      }
      b();
      Object localObject2 = a;
      AppMethodBeat.o(136356);
    }
  }
  
  public void b()
  {
    AppMethodBeat.i(136357);
    try
    {
      List localList = q.b(q.b(b, "__SP_Tencent_Loc_COMP_INFO__", ""));
      new Thread(new j(b, localList, false)).start();
      AppMethodBeat.o(136357);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(136357);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     c.t.m.c.f
 * JD-Core Version:    0.7.0.1
 */