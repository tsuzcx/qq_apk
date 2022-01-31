package a.j.b.a.c.i.b;

import a.j.b.a.c.b.y;
import a.j.b.a.c.l.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class g
{
  public static final g CwD;
  
  static
  {
    AppMethodBeat.i(122083);
    CwD = new g();
    AppMethodBeat.o(122083);
  }
  
  private final b a(List<?> paramList, a.j.b.a.c.a.h paramh)
  {
    AppMethodBeat.i(122082);
    Object localObject1 = (Iterable)a.a.j.m((Iterable)paramList);
    paramList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      localObject2 = ((g)this).dL(localObject2);
      if (localObject2 != null) {
        paramList.add(localObject2);
      }
    }
    paramList = new b((List)paramList, (a.f.a.b)new g.b(paramh));
    AppMethodBeat.o(122082);
    return paramList;
  }
  
  public static b a(List<? extends f<?>> paramList, w paramw)
  {
    AppMethodBeat.i(122080);
    a.f.b.j.q(paramList, "value");
    a.f.b.j.q(paramw, "type");
    paramList = new b(paramList, (a.f.a.b)new a(paramw));
    AppMethodBeat.o(122080);
    return paramList;
  }
  
  public final f<?> dL(Object paramObject)
  {
    AppMethodBeat.i(122081);
    if ((paramObject instanceof Byte))
    {
      paramObject = (f)new d(((Number)paramObject).byteValue());
      AppMethodBeat.o(122081);
      return paramObject;
    }
    if ((paramObject instanceof Short))
    {
      paramObject = (f)new r(((Number)paramObject).shortValue());
      AppMethodBeat.o(122081);
      return paramObject;
    }
    if ((paramObject instanceof Integer))
    {
      paramObject = (f)new l(((Number)paramObject).intValue());
      AppMethodBeat.o(122081);
      return paramObject;
    }
    if ((paramObject instanceof Long))
    {
      paramObject = (f)new p(((Number)paramObject).longValue());
      AppMethodBeat.o(122081);
      return paramObject;
    }
    if ((paramObject instanceof Character))
    {
      paramObject = (f)new e(((Character)paramObject).charValue());
      AppMethodBeat.o(122081);
      return paramObject;
    }
    if ((paramObject instanceof Float))
    {
      paramObject = (f)new k(((Number)paramObject).floatValue());
      AppMethodBeat.o(122081);
      return paramObject;
    }
    if ((paramObject instanceof Double))
    {
      paramObject = (f)new h(((Number)paramObject).doubleValue());
      AppMethodBeat.o(122081);
      return paramObject;
    }
    if ((paramObject instanceof Boolean))
    {
      paramObject = (f)new c(((Boolean)paramObject).booleanValue());
      AppMethodBeat.o(122081);
      return paramObject;
    }
    if ((paramObject instanceof String))
    {
      paramObject = (f)new s((String)paramObject);
      AppMethodBeat.o(122081);
      return paramObject;
    }
    if ((paramObject instanceof byte[]))
    {
      paramObject = (f)a(a.a.e.cy((byte[])paramObject), a.j.b.a.c.a.h.BTG);
      AppMethodBeat.o(122081);
      return paramObject;
    }
    if ((paramObject instanceof short[]))
    {
      paramObject = (f)a(a.a.e.b((short[])paramObject), a.j.b.a.c.a.h.BTH);
      AppMethodBeat.o(122081);
      return paramObject;
    }
    if ((paramObject instanceof int[]))
    {
      paramObject = (f)a(a.a.e.N((int[])paramObject), a.j.b.a.c.a.h.BTI);
      AppMethodBeat.o(122081);
      return paramObject;
    }
    if ((paramObject instanceof long[]))
    {
      paramObject = (f)a(a.a.e.g((long[])paramObject), a.j.b.a.c.a.h.BTK);
      AppMethodBeat.o(122081);
      return paramObject;
    }
    if ((paramObject instanceof char[]))
    {
      paramObject = (f)a(a.a.e.c((char[])paramObject), a.j.b.a.c.a.h.BTF);
      AppMethodBeat.o(122081);
      return paramObject;
    }
    if ((paramObject instanceof float[]))
    {
      paramObject = (f)a(a.a.e.l((float[])paramObject), a.j.b.a.c.a.h.BTJ);
      AppMethodBeat.o(122081);
      return paramObject;
    }
    if ((paramObject instanceof double[]))
    {
      paramObject = (f)a(a.a.e.e((double[])paramObject), a.j.b.a.c.a.h.BTL);
      AppMethodBeat.o(122081);
      return paramObject;
    }
    if ((paramObject instanceof boolean[]))
    {
      paramObject = (f)a(a.a.e.b((boolean[])paramObject), a.j.b.a.c.a.h.BTE);
      AppMethodBeat.o(122081);
      return paramObject;
    }
    if (paramObject == null)
    {
      paramObject = (f)new q();
      AppMethodBeat.o(122081);
      return paramObject;
    }
    AppMethodBeat.o(122081);
    return null;
  }
  
  static final class a
    extends a.f.b.k
    implements a.f.a.b<y, w>
  {
    a(w paramw)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.j.b.a.c.i.b.g
 * JD-Core Version:    0.7.0.1
 */