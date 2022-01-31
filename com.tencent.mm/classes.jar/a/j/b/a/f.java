package a.j.b.a;

import a.f.b.j;
import a.j.b.a.d.a;
import a.j.b.a.d.b;
import a.j.b.a.d.e;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"K_CLASS_CACHE", "Lkotlin/reflect/jvm/internal/pcollections/HashPMap;", "", "kotlin.jvm.PlatformType", "", "clearKClassCache", "", "getOrCreateKotlinClass", "Lkotlin/reflect/jvm/internal/KClassImpl;", "T", "jClass", "Ljava/lang/Class;", "kotlin-reflect-api"})
public final class f
{
  private static b<String, Object> BOq;
  
  static
  {
    AppMethodBeat.i(118693);
    b localb = b.epd();
    j.p(localb, "HashPMap.empty<String, Any>()");
    BOq = localb;
    AppMethodBeat.o(118693);
  }
  
  public static final <T> g<T> aH(Class<T> paramClass)
  {
    Object localObject2 = null;
    AppMethodBeat.i(118692);
    j.q(paramClass, "jClass");
    String str = paramClass.getName();
    Object localObject1 = BOq.Wd(str.hashCode());
    Object localObject3;
    if ((localObject1 != null) && (((a)localObject1).size > 0))
    {
      localObject3 = (e)((a)localObject1).first;
      if (!((e)localObject3).ypR.equals(str)) {}
    }
    for (localObject1 = ((e)localObject3).value;; localObject1 = null)
    {
      if (!(localObject1 instanceof WeakReference)) {
        break label133;
      }
      localObject3 = (g)((WeakReference)localObject1).get();
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = ((g)localObject3).BNl;
      }
      if (!j.e(localObject1, paramClass)) {
        break label280;
      }
      AppMethodBeat.o(118692);
      return localObject3;
      localObject1 = ((a)localObject1).CFp;
      break;
    }
    label133:
    if (localObject1 != null)
    {
      localObject3 = (WeakReference[])localObject1;
      int j = localObject3.length;
      int i = 0;
      while (i < j)
      {
        g localg = (g)localObject3[i].get();
        if (localg != null) {}
        for (localObject2 = localg.BNl; j.e(localObject2, paramClass); localObject2 = null)
        {
          AppMethodBeat.o(118692);
          return localg;
        }
        i += 1;
      }
      i = ((Object[])localObject1).length;
      localObject2 = new WeakReference[i + 1];
      System.arraycopy(localObject1, 0, localObject2, 0, i);
      paramClass = new g(paramClass);
      localObject2[i] = new WeakReference(paramClass);
      localObject1 = BOq.H(str, localObject2);
      j.p(localObject1, "K_CLASS_CACHE.plus(name, newArray)");
      BOq = (b)localObject1;
      AppMethodBeat.o(118692);
      return paramClass;
    }
    label280:
    paramClass = new g(paramClass);
    localObject1 = BOq.H(str, new WeakReference(paramClass));
    j.p(localObject1, "K_CLASS_CACHE.plus(name, WeakReference(newKClass))");
    BOq = (b)localObject1;
    AppMethodBeat.o(118692);
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.j.b.a.f
 * JD-Core Version:    0.7.0.1
 */