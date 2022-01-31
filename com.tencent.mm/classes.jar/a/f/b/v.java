package a.f.b;

import a.j.b;
import a.j.d;
import a.j.e;
import a.j.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class v
{
  private static final w BNr;
  private static final b[] BNs;
  
  static
  {
    AppMethodBeat.i(55882);
    try
    {
      w localw1 = (w)Class.forName("a.j.b.a.aa").newInstance();
      if (localw1 != null)
      {
        BNr = localw1;
        BNs = new b[0];
        AppMethodBeat.o(55882);
        return;
      }
    }
    catch (ClassCastException localClassCastException)
    {
      for (;;)
      {
        Object localObject1 = null;
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        Object localObject2 = null;
      }
    }
    catch (InstantiationException localInstantiationException)
    {
      for (;;)
      {
        Object localObject3 = null;
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        w localw2 = null;
        continue;
        localw2 = new w();
      }
    }
  }
  
  public static e a(i parami)
  {
    AppMethodBeat.i(55878);
    parami = BNr.a(parami);
    AppMethodBeat.o(55878);
    return parami;
  }
  
  public static a.j.h a(m paramm)
  {
    AppMethodBeat.i(55881);
    paramm = BNr.a(paramm);
    AppMethodBeat.o(55881);
    return paramm;
  }
  
  public static l a(q paramq)
  {
    AppMethodBeat.i(55879);
    paramq = BNr.a(paramq);
    AppMethodBeat.o(55879);
    return paramq;
  }
  
  public static a.j.m a(s params)
  {
    AppMethodBeat.i(55880);
    params = BNr.a(params);
    AppMethodBeat.o(55880);
    return params;
  }
  
  public static String a(h paramh)
  {
    AppMethodBeat.i(55877);
    paramh = BNr.a(paramh);
    AppMethodBeat.o(55877);
    return paramh;
  }
  
  public static String a(k paramk)
  {
    AppMethodBeat.i(55876);
    paramk = BNr.a(paramk);
    AppMethodBeat.o(55876);
    return paramk;
  }
  
  public static b aG(Class paramClass)
  {
    AppMethodBeat.i(55875);
    paramClass = BNr.aG(paramClass);
    AppMethodBeat.o(55875);
    return paramClass;
  }
  
  public static d i(Class paramClass, String paramString)
  {
    AppMethodBeat.i(55874);
    paramClass = BNr.i(paramClass, paramString);
    AppMethodBeat.o(55874);
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     a.f.b.v
 * JD-Core Version:    0.7.0.1
 */