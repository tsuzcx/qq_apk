package a.f.b;

import a.j.b;
import a.j.d;
import a.j.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class w
{
  public a.j.e a(i parami)
  {
    return parami;
  }
  
  public a.j.h a(m paramm)
  {
    return paramm;
  }
  
  public l a(q paramq)
  {
    return paramq;
  }
  
  public a.j.m a(s params)
  {
    return params;
  }
  
  public String a(h paramh)
  {
    AppMethodBeat.i(55891);
    paramh = paramh.getClass().getGenericInterfaces()[0].toString();
    if (paramh.startsWith("kotlin.jvm.functions."))
    {
      paramh = paramh.substring(21);
      AppMethodBeat.o(55891);
      return paramh;
    }
    AppMethodBeat.o(55891);
    return paramh;
  }
  
  public String a(k paramk)
  {
    AppMethodBeat.i(55890);
    paramk = a(paramk);
    AppMethodBeat.o(55890);
    return paramk;
  }
  
  public b aG(Class paramClass)
  {
    AppMethodBeat.i(55889);
    paramClass = new e(paramClass);
    AppMethodBeat.o(55889);
    return paramClass;
  }
  
  public d i(Class paramClass, String paramString)
  {
    AppMethodBeat.i(55888);
    paramClass = new o(paramClass, paramString);
    AppMethodBeat.o(55888);
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     a.f.b.w
 * JD-Core Version:    0.7.0.1
 */