package a.j.b.a.c.n;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class j
{
  private static final Object BQk;
  public static volatile boolean CFn;
  
  static
  {
    AppMethodBeat.i(122978);
    BQk = new j.1();
    CFn = false;
    AppMethodBeat.o(122978);
  }
  
  public static <V> Object dR(V paramV)
  {
    Object localObject = paramV;
    if (paramV == null) {
      localObject = BQk;
    }
    return localObject;
  }
  
  public static <V> V dS(Object paramObject)
  {
    AppMethodBeat.i(122976);
    paramObject = dT(paramObject);
    if (paramObject == BQk)
    {
      AppMethodBeat.o(122976);
      return null;
    }
    AppMethodBeat.o(122976);
    return paramObject;
  }
  
  public static <V> V dT(Object paramObject)
  {
    AppMethodBeat.i(122977);
    if ((paramObject instanceof j.a))
    {
      paramObject = ((j.a)paramObject).ytv;
      if ((CFn) && (c.r(paramObject)))
      {
        paramObject = new b(paramObject);
        AppMethodBeat.o(122977);
        throw paramObject;
      }
      a.f.b.j.q(paramObject, "e");
      AppMethodBeat.o(122977);
      throw paramObject;
    }
    AppMethodBeat.o(122977);
    return paramObject;
  }
  
  public static Object s(Throwable paramThrowable)
  {
    AppMethodBeat.i(122975);
    paramThrowable = new j.a(paramThrowable, (byte)0);
    AppMethodBeat.o(122975);
    return paramThrowable;
  }
  
  public static final class b
    extends RuntimeException
  {
    public b(Throwable paramThrowable)
    {
      super(paramThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.j.b.a.c.n.j
 * JD-Core Version:    0.7.0.1
 */