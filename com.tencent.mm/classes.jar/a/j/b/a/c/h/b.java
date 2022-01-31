package a.j.b.a.c.h;

import a.a.ai;
import a.f.b.j;
import a.j.b.a.c.b.ar;
import a.j.b.a.c.b.e;
import a.j.b.a.c.b.h;
import a.j.b.a.c.b.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public abstract interface b
{
  public abstract String a(h paramh, c paramc);
  
  public static final class b
    implements b
  {
    public static final b Cts;
    
    static
    {
      AppMethodBeat.i(121702);
      Cts = new b();
      AppMethodBeat.o(121702);
    }
    
    public final String a(h paramh, c paramc)
    {
      AppMethodBeat.i(121701);
      j.q(paramh, "classifier");
      j.q(paramc, "renderer");
      if ((paramh instanceof ar))
      {
        paramh = ((ar)paramh).edF();
        j.p(paramh, "classifier.name");
        paramh = paramc.b(paramh, false);
        AppMethodBeat.o(121701);
        return paramh;
      }
      ArrayList localArrayList = new ArrayList();
      paramh = (l)paramh;
      do
      {
        localArrayList.add(paramh.edF());
        paramc = paramh.ecv();
        paramh = paramc;
      } while ((paramc instanceof e));
      paramh = (List)localArrayList;
      j.q(paramh, "receiver$0");
      paramh = q.gg((List)new ai(paramh));
      AppMethodBeat.o(121701);
      return paramh;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     a.j.b.a.c.h.b
 * JD-Core Version:    0.7.0.1
 */