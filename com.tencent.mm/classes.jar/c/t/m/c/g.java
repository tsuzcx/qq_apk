package c.t.m.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.List;

public class g
{
  private static g a = null;
  private Context b;
  
  private g(Context paramContext)
  {
    this.b = paramContext;
  }
  
  public static g a(Context paramContext)
  {
    AppMethodBeat.i(136358);
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new g(paramContext);
      }
      paramContext = a;
      AppMethodBeat.o(136358);
      return paramContext;
    }
    finally
    {
      AppMethodBeat.o(136358);
    }
  }
  
  public int a()
  {
    AppMethodBeat.i(136359);
    Object localObject = q.b(this.b, "__bad_dex_info__", "preference_default");
    List localList = q.b((String)localObject);
    if ((((String)localObject).equals("preference_default")) || (localList.isEmpty()))
    {
      AppMethodBeat.o(136359);
      return 0;
    }
    e.a(this.b).a("DGB", "badDex:".concat(String.valueOf(localObject)));
    localObject = q.b(q.b(this.b, "__SP_Tencent_Loc_COMP_INFO__", ""));
    ((List)localObject).isEmpty();
    if ((((List)localObject).isEmpty()) || (l.a((List)localObject, localList)))
    {
      localObject = q.b(q.b(this.b, "TencentLocationComp" + File.separator + "comp_list"));
      ((List)localObject).isEmpty();
      if (l.a((List)localObject, localList))
      {
        if (q.b(this.b, "__loc_sdk_run_duration__", Long.valueOf(0L)).longValue() < 300000L)
        {
          e.a(this.b).a("DGB", "brun<5min");
          new Thread(new j(this.b, localList, true)).start();
          AppMethodBeat.o(136359);
          return 1;
        }
        e.a(this.b).a("DGB", "brun>5min");
        new Thread(new j(this.b, localList, true)).start();
        AppMethodBeat.o(136359);
        return 4;
      }
      e.a(this.b).a("DGB", "brun<5min");
      l.c(this.b);
      AppMethodBeat.o(136359);
      return 2;
    }
    e.a(this.b).a("DGB", "local is ok");
    AppMethodBeat.o(136359);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     c.t.m.c.g
 * JD-Core Version:    0.7.0.1
 */