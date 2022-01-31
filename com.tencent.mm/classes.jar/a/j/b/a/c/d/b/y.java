package a.j.b.a.c.d.b;

import a.aa;
import a.f.a.q;
import a.j.b.a.c.a.b.c.a;
import a.j.b.a.c.a.g;
import a.j.b.a.c.b.ab;
import a.j.b.a.c.b.ar;
import a.j.b.a.c.b.e;
import a.j.b.a.c.b.l;
import a.j.b.a.c.d.a.f.s;
import a.j.b.a.c.l.an;
import a.j.b.a.c.l.ap;
import a.j.b.a.c.l.av;
import a.j.b.a.c.l.ba;
import a.j.b.a.c.l.p;
import a.l.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class y
{
  private static a.j.b.a.c.l.w a(a.j.b.a.c.l.w paramw, HashSet<a.j.b.a.c.b.h> paramHashSet)
  {
    AppMethodBeat.i(120333);
    a.f.b.j.q(paramw, "kotlinType");
    a.f.b.j.q(paramHashSet, "visitedClassifiers");
    Object localObject = paramw.enU().ecR();
    if (localObject == null)
    {
      paramw = (Throwable)new AssertionError("Type with a declaration expected: ".concat(String.valueOf(paramw)));
      AppMethodBeat.o(120333);
      throw paramw;
    }
    a.f.b.j.p(localObject, "kotlinType.constructor.d…n expected: $kotlinType\")");
    if (!paramHashSet.add(localObject))
    {
      AppMethodBeat.o(120333);
      return null;
    }
    if ((localObject instanceof ar))
    {
      paramHashSet = a(c((ar)localObject), paramHashSet);
      if (paramHashSet != null)
      {
        if ((a.j.b.a.c.l.y.am(paramHashSet)) || (!paramw.egH()))
        {
          AppMethodBeat.o(120333);
          return paramHashSet;
        }
        paramw = a.j.b.a.c.l.c.a.az(paramHashSet);
        AppMethodBeat.o(120333);
        return paramw;
      }
      AppMethodBeat.o(120333);
      return null;
    }
    if (((localObject instanceof e)) && (((e)localObject).ecI()))
    {
      localObject = a.j.b.a.c.i.f.ac(paramw);
      if (localObject == null)
      {
        AppMethodBeat.o(120333);
        return null;
      }
      paramHashSet = a((a.j.b.a.c.l.w)localObject, paramHashSet);
      if (paramHashSet == null)
      {
        AppMethodBeat.o(120333);
        return null;
      }
      if (!paramw.egH())
      {
        AppMethodBeat.o(120333);
        return paramHashSet;
      }
      if (a.j.b.a.c.l.y.am(paramHashSet))
      {
        AppMethodBeat.o(120333);
        return paramw;
      }
      if (g.p(paramHashSet))
      {
        AppMethodBeat.o(120333);
        return paramw;
      }
      paramw = a.j.b.a.c.l.c.a.az(paramHashSet);
      AppMethodBeat.o(120333);
      return paramw;
    }
    AppMethodBeat.o(120333);
    return paramw;
  }
  
  private static final <T> T a(k<T> paramk, T paramT, boolean paramBoolean)
  {
    AppMethodBeat.i(120329);
    if (paramBoolean)
    {
      paramk = paramk.dE(paramT);
      AppMethodBeat.o(120329);
      return paramk;
    }
    AppMethodBeat.o(120329);
    return paramT;
  }
  
  private static <T> T a(a.j.b.a.c.l.w paramw, k<T> paramk, w paramw1, u<? extends T> paramu, h<T> paramh, q<? super a.j.b.a.c.l.w, ? super T, ? super w, a.y> paramq, boolean paramBoolean)
  {
    AppMethodBeat.i(120330);
    Object localObject1 = paramw;
    Object localObject2;
    for (;;)
    {
      a.f.b.j.q(localObject1, "kotlinType");
      a.f.b.j.q(paramk, "factory");
      a.f.b.j.q(paramw1, "mode");
      a.f.b.j.q(paramu, "typeMappingConfiguration");
      a.f.b.j.q(paramq, "writeGenericType");
      if (a.j.b.a.c.a.f.e((a.j.b.a.c.l.w)localObject1))
      {
        localObject1 = (a.j.b.a.c.l.w)a.j.b.a.c.a.k.F((a.j.b.a.c.l.w)localObject1);
      }
      else
      {
        localObject2 = ((a.j.b.a.c.l.w)localObject1).enU().ecR();
        paramw = (a.j.b.a.c.l.w)localObject2;
        if (!(localObject2 instanceof e)) {
          paramw = null;
        }
        paramw = (e)paramw;
        if (paramw == null) {}
        label469:
        label473:
        for (;;)
        {
          paramw = null;
          for (;;)
          {
            if (paramw == null) {
              break label475;
            }
            paramw = a(paramk, paramw, paramw1.CjA);
            paramq.d(localObject1, paramw, paramw1);
            AppMethodBeat.o(120330);
            return paramw;
            if (paramw == a.j.b.a.c.a.k.ect())
            {
              paramw = paramk.ayJ(st(false));
            }
            else if (a.f.b.j.e(paramw, a.j.b.a.c.a.k.ecu()))
            {
              paramw = paramk.ayJ(st(true));
            }
            else
            {
              localObject2 = g.d((l)paramw);
              if (localObject2 != null)
              {
                paramw = a.j.b.a.c.i.d.c.d((a.j.b.a.c.a.h)localObject2);
                a.f.b.j.p(paramw, "JvmPrimitiveType.get(primitiveType)");
                paramw = paramw.desc;
                a.f.b.j.p(paramw, "JvmPrimitiveType.get(primitiveType).desc");
                paramw = paramk.ayI(paramw);
                if ((av.aB((a.j.b.a.c.l.w)localObject1)) || (s.U((a.j.b.a.c.l.w)localObject1))) {}
                for (boolean bool = true;; bool = false)
                {
                  paramw = a(paramk, paramw, bool);
                  break;
                }
              }
              localObject2 = g.e((l)paramw);
              if (localObject2 == null) {
                break;
              }
              paramw = new StringBuilder("[");
              localObject2 = a.j.b.a.c.i.d.c.d((a.j.b.a.c.a.h)localObject2);
              a.f.b.j.p(localObject2, "JvmPrimitiveType.get(arrayElementType)");
              paramw = paramk.ayI(((a.j.b.a.c.i.d.c)localObject2).desc);
            }
          }
          if (g.c((l)paramw))
          {
            localObject2 = a.j.b.a.c.a.b.c.BVe;
            paramw = a.j.b.a.c.a.b.c.c(a.j.b.a.c.i.c.a.q((l)paramw));
            if (paramw != null)
            {
              if (!paramw1.CjF)
              {
                localObject2 = a.j.b.a.c.a.b.c.BVe;
                localObject2 = (Iterable)a.j.b.a.c.a.b.c.eda();
                if (((localObject2 instanceof Collection)) && (((Collection)localObject2).isEmpty())) {
                  break label469;
                }
                localObject2 = ((Iterable)localObject2).iterator();
                do
                {
                  if (!((Iterator)localObject2).hasNext()) {
                    break;
                  }
                } while (!a.f.b.j.e(((c.a)((Iterator)localObject2).next()).BVf, paramw));
              }
              for (int i = 1;; i = 0)
              {
                if (i != 0) {
                  break label473;
                }
                paramw = a.j.b.a.c.i.d.b.h(paramw);
                a.f.b.j.p(paramw, "JvmClassName.byClassId(classId)");
                paramw = paramw.Cjr;
                a.f.b.j.p(paramw, "JvmClassName.byClassId(classId).internalName");
                paramw = paramk.ayJ(paramw);
                break;
              }
            }
          }
        }
        label475:
        paramw = ((a.j.b.a.c.l.w)localObject1).enU();
        if ((paramw instanceof a.j.b.a.c.l.v))
        {
          paramw = ((a.j.b.a.c.l.v)paramw).CBw;
          a.f.b.j.p(paramw, "constructor.supertypes");
          localObject1 = a.j.b.a.c.l.c.a.aN(paramu.k(paramw));
        }
        else
        {
          localObject2 = paramw.ecR();
          if (localObject2 == null)
          {
            paramw = (Throwable)new UnsupportedOperationException("no descriptor for type constructor of ".concat(String.valueOf(localObject1)));
            AppMethodBeat.o(120330);
            throw paramw;
          }
          a.f.b.j.p(localObject2, "constructor.declarationD…structor of $kotlinType\")");
          if (p.L((l)localObject2))
          {
            paramw = paramk.ayJ("error/NonExistentClass");
            if (localObject2 == null)
            {
              paramw = new a.v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
              AppMethodBeat.o(120330);
              throw paramw;
            }
            paramu.a((a.j.b.a.c.l.w)localObject1, (e)localObject2);
            if (paramh != null) {
              paramh.dC(paramw);
            }
            AppMethodBeat.o(120330);
            return paramw;
          }
          if (((localObject2 instanceof e)) && (g.n((a.j.b.a.c.l.w)localObject1)))
          {
            if (((a.j.b.a.c.l.w)localObject1).enR().size() != 1)
            {
              paramw = (Throwable)new UnsupportedOperationException("arrays must have one type argument");
              AppMethodBeat.o(120330);
              throw paramw;
            }
            paramw = (ap)((a.j.b.a.c.l.w)localObject1).enR().get(0);
            localObject2 = paramw.eer();
            a.f.b.j.p(localObject2, "memberProjection.type");
            if (paramw.eoO() == ba.CBY)
            {
              paramw1 = paramk.ayJ("java/lang/Object");
              paramw = paramw1;
              if (paramh != null)
              {
                paramh.egR();
                paramh.dC(paramw1);
                paramw = paramw1;
              }
              paramw = paramk.ayI("[" + paramk.toString(paramw));
              AppMethodBeat.o(120330);
              return paramw;
            }
            if (paramh != null) {
              paramh.egR();
            }
            paramw = paramw.eoO();
            a.f.b.j.p(paramw, "memberProjection.projectionKind");
            a.f.b.j.q(paramw, "effectiveVariance");
            switch (x.bLo[paramw.ordinal()])
            {
            default: 
              localObject1 = paramw1.CjE;
              paramw = (a.j.b.a.c.l.w)localObject1;
              if (localObject1 == null) {
                paramw = paramw1;
              }
              break;
            }
            for (;;)
            {
              paramw = a((a.j.b.a.c.l.w)localObject2, paramk, paramw, paramu, paramh, paramq, paramBoolean);
              break;
              localObject1 = paramw1.CjG;
              paramw = (a.j.b.a.c.l.w)localObject1;
              if (localObject1 == null)
              {
                paramw = paramw1;
                continue;
                localObject1 = paramw1.CjH;
                paramw = (a.j.b.a.c.l.w)localObject1;
                if (localObject1 == null) {
                  paramw = paramw1;
                }
              }
            }
          }
          if (!(localObject2 instanceof e)) {
            break label1200;
          }
          if ((!((e)localObject2).ecI()) || (paramw1.CjB)) {
            break;
          }
          a.f.b.j.q(localObject1, "inlineClassType");
          paramw = a((a.j.b.a.c.l.w)localObject1, new HashSet());
          if (paramw == null) {
            break;
          }
          paramw1 = new w(paramw1.CjA, true, paramw1.CgM, paramw1.CjC, paramw1.CjD, paramw1.CjE, paramw1.CjF, paramw1.CjG, paramw1.CjH);
          localObject1 = paramw;
        }
      }
    }
    if ((paramw1.CgM) && (g.g((e)localObject2)))
    {
      paramw = paramk.egT();
      paramq.d(localObject1, paramw, paramw1);
      AppMethodBeat.o(120330);
      return paramw;
    }
    paramw = ((e)localObject2).edL();
    a.f.b.j.p(paramw, "descriptor.original");
    paramu.t(paramw);
    if (((e)localObject2).ecB() == a.j.b.a.c.b.f.BWi)
    {
      paramw = ((e)localObject2).ecv();
      if (paramw == null)
      {
        paramw = new a.v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        AppMethodBeat.o(120330);
        throw paramw;
      }
    }
    for (paramw = (e)paramw;; paramw = (e)localObject2)
    {
      paramw = paramw.edL();
      a.f.b.j.p(paramw, "enumClassIfEnumEntry.original");
      paramw = paramk.ayJ(a(paramw, paramu, paramBoolean));
      break;
    }
    label1200:
    if ((localObject2 instanceof ar))
    {
      paramw = a(c((ar)localObject2), paramk, paramw1, paramu, null, a.j.b.a.c.n.d.eoU(), paramBoolean);
      if (paramh != null)
      {
        paramk = ((a.j.b.a.c.b.h)localObject2).edF();
        a.f.b.j.p(paramk, "descriptor.getName()");
        a.f.b.j.q(paramk, "name");
        a.f.b.j.q(paramw, "type");
        paramh.dD(paramw);
      }
      AppMethodBeat.o(120330);
      return paramw;
    }
    paramw = (Throwable)new UnsupportedOperationException("Unknown type ".concat(String.valueOf(localObject1)));
    AppMethodBeat.o(120330);
    throw paramw;
  }
  
  public static final String a(e parame, u<?> paramu, boolean paramBoolean)
  {
    AppMethodBeat.i(120334);
    a.f.b.j.q(parame, "klass");
    a.f.b.j.q(paramu, "typeMappingConfiguration");
    if (paramBoolean) {}
    String str;
    for (l locall = i(parame.ecv());; locall = parame.ecv())
    {
      localObject = a.j.b.a.c.f.h.w(parame.edF());
      a.f.b.j.p(localObject, "SpecialNames.safeIdentifier(klass.name)");
      str = ((a.j.b.a.c.f.f)localObject).emk();
      a.f.b.j.p(str, "SpecialNames.safeIdentifier(klass.name).identifier");
      if (!(locall instanceof ab)) {
        break label173;
      }
      paramu = ((ab)locall).eee();
      if (!paramu.CqE.CqJ.isEmpty()) {
        break;
      }
      AppMethodBeat.o(120334);
      return str;
    }
    parame = new StringBuilder();
    paramu = paramu.CqE.CqJ;
    a.f.b.j.p(paramu, "fqName.asString()");
    parame = m.a(paramu, '.', '/') + '/' + str;
    AppMethodBeat.o(120334);
    return parame;
    label173:
    if (!(locall instanceof e)) {}
    for (Object localObject = null;; localObject = locall)
    {
      localObject = (e)localObject;
      if (localObject == null)
      {
        parame = (Throwable)new IllegalArgumentException("Unexpected container: " + locall + " for " + parame);
        AppMethodBeat.o(120334);
        throw parame;
      }
      paramu.u((e)localObject);
      parame = a((e)localObject, paramu, paramBoolean);
      parame = parame + '$' + str;
      AppMethodBeat.o(120334);
      return parame;
    }
  }
  
  private static a.j.b.a.c.l.w c(ar paramar)
  {
    AppMethodBeat.i(120336);
    a.f.b.j.q(paramar, "descriptor");
    List localList = paramar.ebo();
    a.f.b.j.p(localList, "descriptor.upperBounds");
    if (!localList.isEmpty()) {}
    for (int i = 1; (aa.BMh) && (i == 0); i = 0)
    {
      paramar = (Throwable)new AssertionError("Upper bounds should not be empty: ".concat(String.valueOf(paramar)));
      AppMethodBeat.o(120336);
      throw paramar;
    }
    Iterator localIterator = ((Iterable)localList).iterator();
    Object localObject;
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      a.j.b.a.c.b.h localh = ((a.j.b.a.c.l.w)localObject).enU().ecR();
      paramar = localh;
      if (!(localh instanceof e)) {
        paramar = null;
      }
      paramar = (e)paramar;
      if (paramar == null)
      {
        label148:
        i = 0;
        label150:
        if (i == 0) {
          break label220;
        }
      }
    }
    for (paramar = (ar)localObject;; paramar = null)
    {
      localObject = (a.j.b.a.c.l.w)paramar;
      paramar = (ar)localObject;
      if (localObject == null)
      {
        paramar = a.a.j.fQ(localList);
        a.f.b.j.p(paramar, "upperBounds.first()");
        paramar = (a.j.b.a.c.l.w)paramar;
      }
      AppMethodBeat.o(120336);
      return paramar;
      if ((paramar.ecB() == a.j.b.a.c.b.f.BWg) || (paramar.ecB() == a.j.b.a.c.b.f.BWj)) {
        break label148;
      }
      i = 1;
      break label150;
      label220:
      break;
    }
  }
  
  private static final l i(l paraml)
  {
    Object localObject2 = null;
    AppMethodBeat.i(120335);
    if (!(paraml instanceof e)) {}
    for (Object localObject1 = null;; localObject1 = paraml)
    {
      localObject1 = (e)localObject1;
      if (localObject1 != null)
      {
        localObject1 = (l)localObject1;
        if (localObject1 != null) {
          break label71;
        }
        localObject1 = localObject2;
        if (paraml == null) {
          break label71;
        }
        paraml = paraml.ecv();
        break;
      }
      if (!(paraml instanceof ab)) {}
      for (localObject1 = null;; localObject1 = paraml)
      {
        localObject1 = (l)localObject1;
        break;
        label71:
        AppMethodBeat.o(120335);
        return localObject1;
      }
    }
  }
  
  private static final String st(boolean paramBoolean)
  {
    AppMethodBeat.i(120332);
    if (paramBoolean) {}
    for (Object localObject = a.j.b.a.c.i.d.CvL;; localObject = a.j.b.a.c.i.d.CvK)
    {
      localObject = a.j.b.a.c.i.d.b.h(a.j.b.a.c.f.a.n((a.j.b.a.c.f.b)localObject));
      a.f.b.j.p(localObject, "JvmClassName.byClassId(ClassId.topLevel(fqName))");
      localObject = ((a.j.b.a.c.i.d.b)localObject).Cjr;
      a.f.b.j.p(localObject, "JvmClassName.byClassId(C…vel(fqName)).internalName");
      AppMethodBeat.o(120332);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.j.b.a.c.d.b.y
 * JD-Core Version:    0.7.0.1
 */