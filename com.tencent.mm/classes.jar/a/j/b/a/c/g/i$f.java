package a.j.b.a.c.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

public final class i$f<ContainingType extends q, Type>
{
  final Type CcG;
  final ContainingType CrG;
  final q CrH;
  final i.e CrI;
  final Class CrJ;
  final Method CrK;
  
  i$f(ContainingType paramContainingType, Type paramType, q paramq, i.e parame, Class paramClass)
  {
    AppMethodBeat.i(121525);
    if (paramContainingType == null)
    {
      paramContainingType = new IllegalArgumentException("Null containingTypeDefaultInstance");
      AppMethodBeat.o(121525);
      throw paramContainingType;
    }
    if ((parame.CrD == z.a.CsP) && (paramq == null))
    {
      paramContainingType = new IllegalArgumentException("Null messageDefaultInstance");
      AppMethodBeat.o(121525);
      throw paramContainingType;
    }
    this.CrG = paramContainingType;
    this.CcG = paramType;
    this.CrH = paramq;
    this.CrI = parame;
    this.CrJ = paramClass;
    if (j.a.class.isAssignableFrom(paramClass))
    {
      this.CrK = i.e(paramClass, "valueOf", new Class[] { Integer.TYPE });
      AppMethodBeat.o(121525);
      return;
    }
    this.CrK = null;
    AppMethodBeat.o(121525);
  }
  
  final Object dH(Object paramObject)
  {
    AppMethodBeat.i(121526);
    if (this.CrI.CrD.CsX == z.b.Cth)
    {
      paramObject = i.d(this.CrK, new Object[] { (Integer)paramObject });
      AppMethodBeat.o(121526);
      return paramObject;
    }
    AppMethodBeat.o(121526);
    return paramObject;
  }
  
  final Object dI(Object paramObject)
  {
    AppMethodBeat.i(121527);
    if (this.CrI.CrD.CsX == z.b.Cth)
    {
      int i = ((j.a)paramObject).ehC();
      AppMethodBeat.o(121527);
      return Integer.valueOf(i);
    }
    AppMethodBeat.o(121527);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     a.j.b.a.c.g.i.f
 * JD-Core Version:    0.7.0.1
 */