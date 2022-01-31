package a.j.b.a.a;

import a.f.a;
import a.f.b.j;
import a.f.b.k;
import a.l;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"equals", "", "T", "", "other", "invoke"})
final class b$a
  extends k
  implements a.f.a.b<Object, Boolean>
{
  b$a(Class paramClass, List paramList, Map paramMap)
  {
    super(1);
  }
  
  public final boolean dt(Object paramObject)
  {
    Object localObject2 = null;
    AppMethodBeat.i(118960);
    if (!(paramObject instanceof Annotation)) {}
    for (Object localObject1 = null;; localObject1 = paramObject)
    {
      Object localObject3 = (Annotation)localObject1;
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject3 = a.a((Annotation)localObject3);
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = a.a((a.j.b)localObject3);
        }
      }
      if (j.e(localObject1, this.BQG))
      {
        localObject1 = (Iterable)this.BQH;
        boolean bool;
        if ((!(localObject1 instanceof Collection)) || (!((Collection)localObject1).isEmpty()))
        {
          localObject1 = ((Iterable)localObject1).iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (Method)((Iterator)localObject1).next();
            localObject3 = this.BQI.get(((Method)localObject2).getName());
            localObject2 = ((Method)localObject2).invoke(paramObject, new Object[0]);
            if ((localObject3 instanceof boolean[]))
            {
              localObject3 = (boolean[])localObject3;
              if (localObject2 == null)
              {
                paramObject = new v("null cannot be cast to non-null type kotlin.BooleanArray");
                AppMethodBeat.o(118960);
                throw paramObject;
              }
              bool = Arrays.equals((boolean[])localObject3, (boolean[])localObject2);
              label206:
              if (bool) {
                break label640;
              }
            }
          }
        }
        for (int i = 0;; i = 1)
        {
          if (i == 0) {
            break label647;
          }
          AppMethodBeat.o(118960);
          return true;
          if ((localObject3 instanceof char[]))
          {
            localObject3 = (char[])localObject3;
            if (localObject2 == null)
            {
              paramObject = new v("null cannot be cast to non-null type kotlin.CharArray");
              AppMethodBeat.o(118960);
              throw paramObject;
            }
            bool = Arrays.equals((char[])localObject3, (char[])localObject2);
            break label206;
          }
          if ((localObject3 instanceof byte[]))
          {
            localObject3 = (byte[])localObject3;
            if (localObject2 == null)
            {
              paramObject = new v("null cannot be cast to non-null type kotlin.ByteArray");
              AppMethodBeat.o(118960);
              throw paramObject;
            }
            bool = Arrays.equals((byte[])localObject3, (byte[])localObject2);
            break label206;
          }
          if ((localObject3 instanceof short[]))
          {
            localObject3 = (short[])localObject3;
            if (localObject2 == null)
            {
              paramObject = new v("null cannot be cast to non-null type kotlin.ShortArray");
              AppMethodBeat.o(118960);
              throw paramObject;
            }
            bool = Arrays.equals((short[])localObject3, (short[])localObject2);
            break label206;
          }
          if ((localObject3 instanceof int[]))
          {
            localObject3 = (int[])localObject3;
            if (localObject2 == null)
            {
              paramObject = new v("null cannot be cast to non-null type kotlin.IntArray");
              AppMethodBeat.o(118960);
              throw paramObject;
            }
            bool = Arrays.equals((int[])localObject3, (int[])localObject2);
            break label206;
          }
          if ((localObject3 instanceof float[]))
          {
            localObject3 = (float[])localObject3;
            if (localObject2 == null)
            {
              paramObject = new v("null cannot be cast to non-null type kotlin.FloatArray");
              AppMethodBeat.o(118960);
              throw paramObject;
            }
            bool = Arrays.equals((float[])localObject3, (float[])localObject2);
            break label206;
          }
          if ((localObject3 instanceof long[]))
          {
            localObject3 = (long[])localObject3;
            if (localObject2 == null)
            {
              paramObject = new v("null cannot be cast to non-null type kotlin.LongArray");
              AppMethodBeat.o(118960);
              throw paramObject;
            }
            bool = Arrays.equals((long[])localObject3, (long[])localObject2);
            break label206;
          }
          if ((localObject3 instanceof double[]))
          {
            localObject3 = (double[])localObject3;
            if (localObject2 == null)
            {
              paramObject = new v("null cannot be cast to non-null type kotlin.DoubleArray");
              AppMethodBeat.o(118960);
              throw paramObject;
            }
            bool = Arrays.equals((double[])localObject3, (double[])localObject2);
            break label206;
          }
          if ((localObject3 instanceof Object[]))
          {
            localObject3 = (Object[])localObject3;
            if (localObject2 == null)
            {
              paramObject = new v("null cannot be cast to non-null type kotlin.Array<*>");
              AppMethodBeat.o(118960);
              throw paramObject;
            }
            bool = Arrays.equals((Object[])localObject3, (Object[])localObject2);
            break label206;
          }
          bool = j.e(localObject3, localObject2);
          break label206;
          label640:
          break;
        }
      }
      label647:
      AppMethodBeat.o(118960);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     a.j.b.a.a.b.a
 * JD-Core Version:    0.7.0.1
 */