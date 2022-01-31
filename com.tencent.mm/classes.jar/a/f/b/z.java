package a.f.b;

import a.f.a.d;
import a.f.a.e;
import a.f.a.g;
import a.f.a.i;
import a.f.a.k;
import a.f.a.l;
import a.f.a.m;
import a.f.a.n;
import a.f.a.o;
import a.f.a.p;
import a.f.a.q;
import a.f.a.r;
import a.f.a.s;
import a.f.a.t;
import a.f.a.u;
import a.f.a.v;
import a.f.a.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Set;

public class z
{
  public static Iterable di(Object paramObject)
  {
    AppMethodBeat.i(142958);
    if (((paramObject instanceof a.f.b.a.a)) && (!(paramObject instanceof a.f.b.a.c))) {
      r(paramObject, "kotlin.collections.MutableIterable");
    }
    paramObject = dj(paramObject);
    AppMethodBeat.o(142958);
    return paramObject;
  }
  
  private static Iterable dj(Object paramObject)
  {
    AppMethodBeat.i(142959);
    try
    {
      paramObject = (Iterable)paramObject;
      AppMethodBeat.o(142959);
      return paramObject;
    }
    catch (ClassCastException paramObject)
    {
      paramObject = (ClassCastException)o(paramObject);
      AppMethodBeat.o(142959);
      throw paramObject;
    }
  }
  
  public static Collection dk(Object paramObject)
  {
    AppMethodBeat.i(55901);
    if (((paramObject instanceof a.f.b.a.a)) && (!(paramObject instanceof a.f.b.a.b))) {
      r(paramObject, "kotlin.collections.MutableCollection");
    }
    paramObject = dl(paramObject);
    AppMethodBeat.o(55901);
    return paramObject;
  }
  
  private static Collection dl(Object paramObject)
  {
    AppMethodBeat.i(55902);
    try
    {
      paramObject = (Collection)paramObject;
      AppMethodBeat.o(55902);
      return paramObject;
    }
    catch (ClassCastException paramObject)
    {
      paramObject = (ClassCastException)o(paramObject);
      AppMethodBeat.o(55902);
      throw paramObject;
    }
  }
  
  public static Set dm(Object paramObject)
  {
    AppMethodBeat.i(55903);
    if (((paramObject instanceof a.f.b.a.a)) && (!(paramObject instanceof a.f.b.a.f))) {
      r(paramObject, "kotlin.collections.MutableSet");
    }
    paramObject = dn(paramObject);
    AppMethodBeat.o(55903);
    return paramObject;
  }
  
  private static Set dn(Object paramObject)
  {
    AppMethodBeat.i(55904);
    try
    {
      paramObject = (Set)paramObject;
      AppMethodBeat.o(55904);
      return paramObject;
    }
    catch (ClassCastException paramObject)
    {
      paramObject = (ClassCastException)o(paramObject);
      AppMethodBeat.o(55904);
      throw paramObject;
    }
  }
  
  public static Object jdMethod_do(Object paramObject)
  {
    AppMethodBeat.i(55905);
    if (paramObject != null)
    {
      if (!(paramObject instanceof a.c)) {
        break label355;
      }
      if (!(paramObject instanceof h)) {
        break label57;
      }
      i = ((h)paramObject).eaY();
      if (i != 2) {
        break label355;
      }
    }
    label57:
    label355:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        r(paramObject, "kotlin.jvm.functions.Function2");
      }
      AppMethodBeat.o(55905);
      return paramObject;
      if ((paramObject instanceof a.f.a.a))
      {
        i = 0;
        break;
      }
      if ((paramObject instanceof a.f.a.b))
      {
        i = 1;
        break;
      }
      if ((paramObject instanceof m))
      {
        i = 2;
        break;
      }
      if ((paramObject instanceof q))
      {
        i = 3;
        break;
      }
      if ((paramObject instanceof r))
      {
        i = 4;
        break;
      }
      if ((paramObject instanceof s))
      {
        i = 5;
        break;
      }
      if ((paramObject instanceof t))
      {
        i = 6;
        break;
      }
      if ((paramObject instanceof u))
      {
        i = 7;
        break;
      }
      if ((paramObject instanceof v))
      {
        i = 8;
        break;
      }
      if ((paramObject instanceof w))
      {
        i = 9;
        break;
      }
      if ((paramObject instanceof a.f.a.c))
      {
        i = 10;
        break;
      }
      if ((paramObject instanceof d))
      {
        i = 11;
        break;
      }
      if ((paramObject instanceof e))
      {
        i = 12;
        break;
      }
      if ((paramObject instanceof a.f.a.f))
      {
        i = 13;
        break;
      }
      if ((paramObject instanceof g))
      {
        i = 14;
        break;
      }
      if ((paramObject instanceof a.f.a.h))
      {
        i = 15;
        break;
      }
      if ((paramObject instanceof i))
      {
        i = 16;
        break;
      }
      if ((paramObject instanceof a.f.a.j))
      {
        i = 17;
        break;
      }
      if ((paramObject instanceof k))
      {
        i = 18;
        break;
      }
      if ((paramObject instanceof l))
      {
        i = 19;
        break;
      }
      if ((paramObject instanceof n))
      {
        i = 20;
        break;
      }
      if ((paramObject instanceof o))
      {
        i = 21;
        break;
      }
      if ((paramObject instanceof p))
      {
        i = 22;
        break;
      }
      i = -1;
      break;
    }
  }
  
  private static <T extends Throwable> T o(T paramT)
  {
    AppMethodBeat.i(55899);
    paramT = j.b(paramT, z.class.getName());
    AppMethodBeat.o(55899);
    return paramT;
  }
  
  private static void r(Object paramObject, String paramString)
  {
    AppMethodBeat.i(55900);
    if (paramObject == null) {}
    for (paramObject = "null";; paramObject = paramObject.getClass().getName())
    {
      paramObject = (ClassCastException)o(new ClassCastException(paramObject + " cannot be cast to " + paramString));
      AppMethodBeat.o(55900);
      throw paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     a.f.b.z
 * JD-Core Version:    0.7.0.1
 */