package a.j.b.a.c.a.b;

import a.a.aj;
import a.f.b.u.d;
import a.j.b.a.c.b.al;
import a.j.b.a.c.b.am;
import a.j.b.a.c.b.ay;
import a.j.b.a.c.b.az;
import a.j.b.a.c.b.b.a;
import a.j.b.a.c.b.e;
import a.j.b.a.c.b.l;
import a.j.b.a.c.b.q;
import a.j.b.a.c.b.t.a;
import a.j.b.a.c.b.y;
import a.j.b.a.c.e.a.c;
import a.j.b.a.c.e.a.o;
import a.j.b.a.c.i.e.h.b;
import a.j.b.a.c.l.ad;
import a.j.b.a.c.l.an;
import a.j.b.a.c.l.ao;
import a.j.b.a.c.l.z;
import a.j.b.a.c.n.b.b;
import a.j.b.a.c.n.b.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class f
  implements a.j.b.a.c.b.b.a, a.j.b.a.c.b.b.c
{
  private static final Set<String> BVE;
  private static final Set<String> BVF;
  private static final Set<String> BVG;
  private static final Set<String> BVH;
  private static final Set<String> BVI;
  private static final Set<String> BVJ;
  public static final f.a BVK;
  private final a.j.b.a.c.l.w BVA;
  private final a.j.b.a.c.k.f BVB;
  private final a.j.b.a.c.k.a<a.j.b.a.c.f.b, e> BVC;
  private final a.j.b.a.c.k.f BVD;
  private final y BVj;
  private final c BVx;
  private final a.f BVy;
  private final a.f BVz;
  
  static
  {
    AppMethodBeat.i(119229);
    eOJ = new a.j.k[] { (a.j.k)a.f.b.v.a(new a.f.b.t(a.f.b.v.aG(f.class), "ownerModuleDescriptor", "getOwnerModuleDescriptor()Lorg/jetbrains/kotlin/descriptors/ModuleDescriptor;")), (a.j.k)a.f.b.v.a(new a.f.b.t(a.f.b.v.aG(f.class), "isAdditionalBuiltInsFeatureSupported", "isAdditionalBuiltInsFeatureSupported()Z")), (a.j.k)a.f.b.v.a(new a.f.b.t(a.f.b.v.aG(f.class), "cloneableType", "getCloneableType()Lorg/jetbrains/kotlin/types/SimpleType;")), (a.j.k)a.f.b.v.a(new a.f.b.t(a.f.b.v.aG(f.class), "notConsideredDeprecation", "getNotConsideredDeprecation()Lorg/jetbrains/kotlin/descriptors/annotations/Annotations;")) };
    BVK = new f.a((byte)0);
    Object localObject1 = a.j.b.a.c.d.b.t.Cjx;
    BVE = aj.b((Set)a.j.b.a.c.d.b.t.p("Collection", new String[] { "toArray()[Ljava/lang/Object;", "toArray([Ljava/lang/Object;)[Ljava/lang/Object;" }), "java/lang/annotation/Annotation.annotationType()Ljava/lang/Class;");
    localObject1 = a.j.b.a.c.d.b.t.Cjx;
    localObject1 = a.j.b.a.c.d.b.t.Cjx;
    Object localObject2 = (Iterable)a.a.j.listOf(new a.j.b.a.c.i.d.c[] { a.j.b.a.c.i.d.c.CwT, a.j.b.a.c.i.d.c.CwU });
    localObject1 = (Collection)new LinkedHashSet();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      a.j.b.a.c.i.d.c localc = (a.j.b.a.c.i.d.c)((Iterator)localObject2).next();
      String str = localc.Cxg.CqE.emh().name;
      a.f.b.j.p(str, "it.wrapperFqName.shortName().asString()");
      a.a.j.a((Collection)localObject1, (Iterable)a.j.b.a.c.d.b.t.o(str, new String[] { localc.name + "Value()" + localc.desc }));
    }
    BVF = aj.a(aj.a(aj.a(aj.a(aj.a((Set)localObject1, (Iterable)a.j.b.a.c.d.b.t.p("List", new String[] { "sort(Ljava/util/Comparator;)V" })), (Iterable)a.j.b.a.c.d.b.t.o("String", new String[] { "codePointAt(I)I", "codePointBefore(I)I", "codePointCount(II)I", "compareToIgnoreCase(Ljava/lang/String;)I", "concat(Ljava/lang/String;)Ljava/lang/String;", "contains(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/StringBuffer;)Z", "endsWith(Ljava/lang/String;)Z", "equalsIgnoreCase(Ljava/lang/String;)Z", "getBytes()[B", "getBytes(II[BI)V", "getBytes(Ljava/lang/String;)[B", "getBytes(Ljava/nio/charset/Charset;)[B", "getChars(II[CI)V", "indexOf(I)I", "indexOf(II)I", "indexOf(Ljava/lang/String;)I", "indexOf(Ljava/lang/String;I)I", "intern()Ljava/lang/String;", "isEmpty()Z", "lastIndexOf(I)I", "lastIndexOf(II)I", "lastIndexOf(Ljava/lang/String;)I", "lastIndexOf(Ljava/lang/String;I)I", "matches(Ljava/lang/String;)Z", "offsetByCodePoints(II)I", "regionMatches(ILjava/lang/String;II)Z", "regionMatches(ZILjava/lang/String;II)Z", "replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(CC)Ljava/lang/String;", "replaceFirst(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;", "split(Ljava/lang/String;I)[Ljava/lang/String;", "split(Ljava/lang/String;)[Ljava/lang/String;", "startsWith(Ljava/lang/String;I)Z", "startsWith(Ljava/lang/String;)Z", "substring(II)Ljava/lang/String;", "substring(I)Ljava/lang/String;", "toCharArray()[C", "toLowerCase()Ljava/lang/String;", "toLowerCase(Ljava/util/Locale;)Ljava/lang/String;", "toUpperCase()Ljava/lang/String;", "toUpperCase(Ljava/util/Locale;)Ljava/lang/String;", "trim()Ljava/lang/String;", "isBlank()Z", "lines()Ljava/util/stream/Stream;", "repeat(I)Ljava/lang/String;" })), (Iterable)a.j.b.a.c.d.b.t.o("Double", new String[] { "isInfinite()Z", "isNaN()Z" })), (Iterable)a.j.b.a.c.d.b.t.o("Float", new String[] { "isInfinite()Z", "isNaN()Z" })), (Iterable)a.j.b.a.c.d.b.t.o("Enum", new String[] { "getDeclaringClass()Ljava/lang/Class;", "finalize()V" }));
    localObject1 = a.j.b.a.c.d.b.t.Cjx;
    BVG = aj.a(aj.a(aj.a(aj.a(aj.a(aj.a((Set)a.j.b.a.c.d.b.t.o("CharSequence", new String[] { "codePoints()Ljava/util/stream/IntStream;", "chars()Ljava/util/stream/IntStream;" }), (Iterable)a.j.b.a.c.d.b.t.p("Iterator", new String[] { "forEachRemaining(Ljava/util/function/Consumer;)V" })), (Iterable)a.j.b.a.c.d.b.t.o("Iterable", new String[] { "forEach(Ljava/util/function/Consumer;)V", "spliterator()Ljava/util/Spliterator;" })), (Iterable)a.j.b.a.c.d.b.t.o("Throwable", new String[] { "setStackTrace([Ljava/lang/StackTraceElement;)V", "fillInStackTrace()Ljava/lang/Throwable;", "getLocalizedMessage()Ljava/lang/String;", "printStackTrace()V", "printStackTrace(Ljava/io/PrintStream;)V", "printStackTrace(Ljava/io/PrintWriter;)V", "getStackTrace()[Ljava/lang/StackTraceElement;", "initCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "getSuppressed()[Ljava/lang/Throwable;", "addSuppressed(Ljava/lang/Throwable;)V" })), (Iterable)a.j.b.a.c.d.b.t.p("Collection", new String[] { "spliterator()Ljava/util/Spliterator;", "parallelStream()Ljava/util/stream/Stream;", "stream()Ljava/util/stream/Stream;", "removeIf(Ljava/util/function/Predicate;)Z" })), (Iterable)a.j.b.a.c.d.b.t.p("List", new String[] { "replaceAll(Ljava/util/function/UnaryOperator;)V" })), (Iterable)a.j.b.a.c.d.b.t.p("Map", new String[] { "getOrDefault(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "forEach(Ljava/util/function/BiConsumer;)V", "replaceAll(Ljava/util/function/BiFunction;)V", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;" }));
    localObject1 = a.j.b.a.c.d.b.t.Cjx;
    BVH = aj.a(aj.a((Set)a.j.b.a.c.d.b.t.p("Collection", new String[] { "removeIf(Ljava/util/function/Predicate;)Z" }), (Iterable)a.j.b.a.c.d.b.t.p("List", new String[] { "replaceAll(Ljava/util/function/UnaryOperator;)V", "sort(Ljava/util/Comparator;)V" })), (Iterable)a.j.b.a.c.d.b.t.p("Map", new String[] { "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove(Ljava/lang/Object;Ljava/lang/Object;)Z", "replaceAll(Ljava/util/function/BiFunction;)V", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z" }));
    localObject1 = a.j.b.a.c.d.b.t.Cjx;
    localObject1 = f.a.edn();
    localObject2 = a.j.b.a.c.d.b.t.ad(new String[] { "D" });
    localObject1 = aj.a((Set)localObject1, (Iterable)a.j.b.a.c.d.b.t.o("Float", (String[])Arrays.copyOf((Object[])localObject2, localObject2.length)));
    localObject2 = a.j.b.a.c.d.b.t.ad(new String[] { "[C", "[CII", "[III", "[BIILjava/lang/String;", "[BIILjava/nio/charset/Charset;", "[BLjava/lang/String;", "[BLjava/nio/charset/Charset;", "[BII", "[B", "Ljava/lang/StringBuffer;", "Ljava/lang/StringBuilder;" });
    BVI = aj.a((Set)localObject1, (Iterable)a.j.b.a.c.d.b.t.o("String", (String[])Arrays.copyOf((Object[])localObject2, localObject2.length)));
    localObject1 = a.j.b.a.c.d.b.t.Cjx;
    localObject1 = a.j.b.a.c.d.b.t.ad(new String[] { "Ljava/lang/String;Ljava/lang/Throwable;ZZ" });
    BVJ = (Set)a.j.b.a.c.d.b.t.o("Throwable", (String[])Arrays.copyOf((Object[])localObject1, localObject1.length));
    AppMethodBeat.o(119229);
  }
  
  public f(y paramy, a.j.b.a.c.k.i parami, a.f.a.a<? extends y> parama, a.f.a.a<Boolean> parama1)
  {
    AppMethodBeat.i(119240);
    this.BVj = paramy;
    this.BVx = c.BVe;
    this.BVy = a.g.j(parama);
    this.BVz = a.g.j(parama1);
    paramy = new f.d(this, this.BVj, new a.j.b.a.c.f.b("java.io"));
    parama = a.a.j.listOf(new z(parami, (a.f.a.a)new f.e(this)));
    paramy = new a.j.b.a.c.b.c.h((l)paramy, a.j.b.a.c.f.f.ayT("Serializable"), a.j.b.a.c.b.w.BWs, a.j.b.a.c.b.f.BWg, (Collection)parama, am.BWF, parami);
    paramy.a((a.j.b.a.c.i.e.h)h.b.CxW, (Set)a.a.x.BMz, null);
    paramy = paramy.edE();
    a.f.b.j.p(paramy, "mockSerializableClass.defaultType");
    this.BVA = ((a.j.b.a.c.l.w)paramy);
    this.BVB = parami.l((a.f.a.a)new f.c(this, parami));
    this.BVC = parami.eoC();
    this.BVD = parami.l((a.f.a.a)new m(this));
    AppMethodBeat.o(119240);
  }
  
  private final y edg()
  {
    AppMethodBeat.i(119230);
    y localy = (y)this.BVy.getValue();
    AppMethodBeat.o(119230);
    return localy;
  }
  
  private final boolean edh()
  {
    AppMethodBeat.i(119231);
    boolean bool = ((Boolean)this.BVz.getValue()).booleanValue();
    AppMethodBeat.o(119231);
    return bool;
  }
  
  private final ad edi()
  {
    AppMethodBeat.i(119232);
    ad localad = (ad)a.j.b.a.c.k.h.a(this.BVB, eOJ[2]);
    AppMethodBeat.o(119232);
    return localad;
  }
  
  private final a.j.b.a.c.b.a.g edj()
  {
    AppMethodBeat.i(119233);
    a.j.b.a.c.b.a.g localg = (a.j.b.a.c.b.a.g)a.j.b.a.c.k.h.a(this.BVD, eOJ[3]);
    AppMethodBeat.o(119233);
    return localg;
  }
  
  private final a.j.b.a.c.d.a.c.a.f n(e parame)
  {
    AppMethodBeat.i(119237);
    if (a.j.b.a.c.a.g.f(parame))
    {
      AppMethodBeat.o(119237);
      return null;
    }
    if (!a.j.b.a.c.a.g.c((l)parame))
    {
      AppMethodBeat.o(119237);
      return null;
    }
    parame = a.j.b.a.c.i.c.a.q((l)parame);
    if (!parame.eme())
    {
      AppMethodBeat.o(119237);
      return null;
    }
    parame = c.c(parame);
    if (parame != null)
    {
      parame = parame.emc();
      if (parame != null) {}
    }
    else
    {
      AppMethodBeat.o(119237);
      return null;
    }
    a.f.b.j.p(parame, "j2kClassMap.mapKotlinToJ…leFqName() ?: return null");
    e locale = q.a(edg(), parame, (a.j.b.a.c.c.a.a)a.j.b.a.c.c.a.c.Cbw);
    parame = locale;
    if (!(locale instanceof a.j.b.a.c.d.a.c.a.f)) {
      parame = null;
    }
    parame = (a.j.b.a.c.d.a.c.a.f)parame;
    AppMethodBeat.o(119237);
    return parame;
  }
  
  public final Collection<al> a(a.j.b.a.c.f.f paramf, e parame)
  {
    AppMethodBeat.i(119235);
    a.f.b.j.q(paramf, "name");
    a.f.b.j.q(parame, "classDescriptor");
    Object localObject1 = a.BUP;
    int i;
    if ((a.f.b.j.e(paramf, a.ecX())) && ((parame instanceof a.j.b.a.c.j.a.a.d)) && (a.j.b.a.c.a.g.c(parame)))
    {
      localObject1 = ((a.j.b.a.c.j.a.a.d)parame).Cys.Clk;
      a.f.b.j.p(localObject1, "classDescriptor.classProto.functionList");
      localObject1 = (Iterable)localObject1;
      if ((!(localObject1 instanceof Collection)) || (!((Collection)localObject1).isEmpty()))
      {
        localObject1 = ((Iterable)localObject1).iterator();
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (a.o)((Iterator)localObject1).next();
          localObject3 = ((a.j.b.a.c.j.a.a.d)parame).CyY.BOc;
          a.f.b.j.p(localObject2, "functionProto");
          localObject2 = a.j.b.a.c.j.a.r.b((a.j.b.a.c.e.a.c)localObject3, ((a.o)localObject2).ClT);
          localObject3 = a.BUP;
        } while (!a.f.b.j.e(localObject2, a.ecX()));
      }
      for (i = 1; i != 0; i = 0)
      {
        paramf = (Collection)a.a.v.BMx;
        AppMethodBeat.o(119235);
        return paramf;
      }
      parame = (a.j.b.a.c.j.a.a.d)parame;
      paramf = ((al)a.a.j.h((Iterable)edi().ecq().b(paramf, (a.j.b.a.c.c.a.a)a.j.b.a.c.c.a.c.Cbw))).edV();
      paramf.g((l)parame);
      paramf.a(ay.BWO);
      paramf.I((a.j.b.a.c.l.w)parame.edE());
      paramf.b(parame.edK());
      paramf = paramf.eeb();
      if (paramf == null) {
        a.f.b.j.ebi();
      }
      paramf = (Collection)a.a.j.listOf((al)paramf);
      AppMethodBeat.o(119235);
      return paramf;
    }
    if (!edh())
    {
      paramf = (Collection)a.a.v.BMx;
      AppMethodBeat.o(119235);
      return paramf;
    }
    Object localObject2 = (a.f.a.b)new f.h(paramf);
    Object localObject3 = n(parame);
    if (localObject3 == null) {
      paramf = (Collection)a.a.v.BMx;
    }
    for (;;)
    {
      paramf = (Iterable)paramf;
      localObject1 = (Collection)new ArrayList();
      localObject2 = paramf.iterator();
      if (!((Iterator)localObject2).hasNext()) {
        break label1618;
      }
      localObject3 = (al)((Iterator)localObject2).next();
      paramf = ((al)localObject3).ecv();
      if (paramf != null) {
        break;
      }
      paramf = new a.v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
      AppMethodBeat.o(119235);
      throw paramf;
      localObject1 = a.j.b.a.c.i.c.a.o((l)localObject3);
      paramf = b.BUQ;
      paramf = b.ecY().ecc();
      a.f.b.j.q(localObject1, "fqName");
      a.f.b.j.q(paramf, "builtIns");
      localObject1 = c.a((a.j.b.a.c.f.b)localObject1, paramf);
      if (localObject1 == null)
      {
        localObject1 = (Collection)a.a.x.BMz;
        label521:
        paramf = (Iterable)localObject1;
        a.f.b.j.q(paramf, "receiver$0");
        if (!(paramf instanceof List)) {
          break label686;
        }
        if (!((List)paramf).isEmpty()) {
          break label662;
        }
        paramf = null;
      }
      for (;;)
      {
        localObject4 = (e)paramf;
        if (localObject4 != null) {
          break label730;
        }
        paramf = (Collection)a.a.v.BMx;
        break;
        localObject4 = (a.j.b.a.c.f.b)c.BVc.get(a.j.b.a.c.i.c.a.q((l)localObject1));
        if (localObject4 == null)
        {
          localObject1 = (Collection)aj.setOf(localObject1);
          break label521;
        }
        a.f.b.j.p(localObject4, "readOnlyToMutable[kotlin…eturn setOf(kotlinAnalog)");
        paramf = Arrays.asList(new e[] { localObject1, paramf.c((a.j.b.a.c.f.b)localObject4) });
        a.f.b.j.p(paramf, "Arrays.asList(kotlinAnal…tlinMutableAnalogFqName))");
        localObject1 = (Collection)paramf;
        break label521;
        label662:
        paramf = ((List)paramf).get(((List)paramf).size() - 1);
        continue;
        label686:
        localObject4 = paramf.iterator();
        if (!((Iterator)localObject4).hasNext()) {
          paramf = null;
        } else {
          do
          {
            paramf = ((Iterator)localObject4).next();
          } while (((Iterator)localObject4).hasNext());
        }
      }
      label730:
      paramf = a.j.b.a.c.n.i.CFl;
      localObject1 = (Iterable)localObject1;
      paramf = (Collection)new ArrayList(a.a.j.d((Iterable)localObject1));
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        paramf.add(a.j.b.a.c.i.c.a.o((l)((Iterator)localObject1).next()));
      }
      localObject1 = (Collection)paramf;
      a.f.b.j.q(localObject1, "set");
      paramf = new a.j.b.a.c.n.i((byte)0);
      paramf.addAll((Collection)localObject1);
      boolean bool2 = c.h(parame);
      localObject1 = ((e)this.BVC.b(a.j.b.a.c.i.c.a.o((l)localObject3), (a.f.a.a)new f.f((a.j.b.a.c.d.a.c.a.f)localObject3, (e)localObject4))).ecy();
      a.f.b.j.p(localObject1, "fakeJavaClassDescriptor.unsubstitutedMemberScope");
      localObject2 = (Iterable)((a.f.a.b)localObject2).S(localObject1);
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      label1198:
      label1270:
      label1273:
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        localObject4 = (al)localObject3;
        boolean bool1;
        if ((((al)localObject4).edy() == b.a.BVX) && (((al)localObject4).ecE().BXa) && (!a.j.b.a.c.a.g.f((l)localObject4)))
        {
          localObject5 = ((al)localObject4).edw();
          a.f.b.j.p(localObject5, "analogueMember.overriddenDescriptors");
          localObject5 = (Iterable)localObject5;
          Object localObject6;
          if ((!(localObject5 instanceof Collection)) || (!((Collection)localObject5).isEmpty()))
          {
            localObject5 = ((Iterable)localObject5).iterator();
            while (((Iterator)localObject5).hasNext())
            {
              localObject6 = (a.j.b.a.c.b.t)((Iterator)localObject5).next();
              a.f.b.j.p(localObject6, "it");
              localObject6 = ((a.j.b.a.c.b.t)localObject6).ecv();
              a.f.b.j.p(localObject6, "it.containingDeclaration");
              if (paramf.contains(a.j.b.a.c.i.c.a.o((l)localObject6))) {
                i = 1;
              }
            }
          }
          for (;;)
          {
            if (i == 0)
            {
              localObject5 = ((al)localObject4).ecv();
              if (localObject5 == null)
              {
                paramf = new a.v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                AppMethodBeat.o(119235);
                throw paramf;
                i = 0;
              }
              else
              {
                localObject5 = (e)localObject5;
                localObject6 = a.j.b.a.c.d.b.r.a((a.j.b.a.c.b.t)localObject4, false, false, 3);
                Set localSet = BVH;
                a.j.b.a.c.d.b.t localt = a.j.b.a.c.d.b.t.Cjx;
                if ((localSet.contains(a.j.b.a.c.d.b.t.a((e)localObject5, (String)localObject6)) ^ bool2))
                {
                  bool1 = true;
                  if (bool1) {
                    break label1270;
                  }
                }
              }
            }
          }
        }
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label1273;
          }
          ((Collection)localObject1).add(localObject3);
          break;
          localObject4 = a.j.b.a.c.n.b.a((Collection)a.a.j.listOf(localObject4), (b.b)f.k.BVW, (a.f.a.b)new f.l(this));
          a.f.b.j.p(localObject4, "DFS.ifAny<CallableMember…lassDescriptor)\n        }");
          bool1 = ((Boolean)localObject4).booleanValue();
          break label1198;
        }
      }
      paramf = (Collection)localObject1;
    }
    paramf = ((al)localObject3).c(h.a((e)paramf, parame).eoP());
    if (paramf == null)
    {
      paramf = new a.v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.SimpleFunctionDescriptor");
      AppMethodBeat.o(119235);
      throw paramf;
    }
    paramf = ((al)paramf).edV();
    paramf.g((l)parame);
    paramf.b(parame.edK());
    paramf.edX();
    Object localObject4 = (a.j.b.a.c.b.t)localObject3;
    localObject3 = ((a.j.b.a.c.b.t)localObject4).ecv();
    if (localObject3 == null)
    {
      paramf = new a.v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
      AppMethodBeat.o(119235);
      throw paramf;
    }
    localObject3 = (e)localObject3;
    localObject4 = a.j.b.a.c.d.b.r.a((a.j.b.a.c.b.t)localObject4, false, false, 3);
    Object localObject5 = new u.d();
    ((u.d)localObject5).BNq = null;
    localObject3 = a.j.b.a.c.n.b.a((Collection)a.a.j.listOf(localObject3), (b.b)new f.i(this), (b.c)new f.j((String)localObject4, (u.d)localObject5));
    a.f.b.j.p(localObject3, "DFS.dfs<ClassDescriptor,…CONSIDERED\n            })");
    localObject3 = (f.b)localObject3;
    switch (g.bLo[localObject3.ordinal()])
    {
    default: 
      label1532:
      paramf = paramf.eeb();
      if (paramf == null) {
        a.f.b.j.ebi();
      }
      paramf = (al)paramf;
    }
    while (paramf != null)
    {
      ((Collection)localObject1).add(paramf);
      break;
      if (a.j.b.a.c.b.x.p(parame))
      {
        paramf = null;
      }
      else
      {
        a.f.b.j.p(paramf.eea(), "setHiddenForResolutionEverywhereBesideSupercalls()");
        break label1532;
        a.f.b.j.p(paramf.a(edj()), "setAdditionalAnnotations(notConsideredDeprecation)");
        break label1532;
        paramf = null;
      }
    }
    label1618:
    paramf = (Collection)localObject1;
    AppMethodBeat.o(119235);
    return paramf;
  }
  
  public final boolean a(e parame, al paramal)
  {
    AppMethodBeat.i(119239);
    a.f.b.j.q(parame, "classDescriptor");
    a.f.b.j.q(paramal, "functionDescriptor");
    Object localObject = n(parame);
    if (localObject == null)
    {
      AppMethodBeat.o(119239);
      return true;
    }
    if (!paramal.ecM().j(a.j.b.a.c.b.b.d.eeI()))
    {
      AppMethodBeat.o(119239);
      return true;
    }
    if (!edh())
    {
      AppMethodBeat.o(119239);
      return false;
    }
    parame = a.j.b.a.c.d.b.r.a((a.j.b.a.c.b.t)paramal, false, false, 3);
    localObject = ((a.j.b.a.c.d.a.c.a.f)localObject).CfK;
    paramal = paramal.edF();
    a.f.b.j.p(paramal, "functionDescriptor.name");
    paramal = (Iterable)((a.j.b.a.c.d.a.c.a.g)localObject).b(paramal, (a.j.b.a.c.c.a.a)a.j.b.a.c.c.a.c.Cbw);
    if ((!(paramal instanceof Collection)) || (!((Collection)paramal).isEmpty()))
    {
      paramal = paramal.iterator();
      while (paramal.hasNext()) {
        if (a.f.b.j.e(a.j.b.a.c.d.b.r.a((a.j.b.a.c.b.t)paramal.next(), false, false, 3), parame))
        {
          AppMethodBeat.o(119239);
          return true;
        }
      }
    }
    AppMethodBeat.o(119239);
    return false;
  }
  
  public final Collection<a.j.b.a.c.l.w> l(e parame)
  {
    AppMethodBeat.i(119234);
    a.f.b.j.q(parame, "classDescriptor");
    parame = a.j.b.a.c.i.c.a.q((l)parame);
    if (f.a.e(parame))
    {
      parame = edi();
      a.f.b.j.p(parame, "cloneableType");
      parame = (Collection)a.a.j.listOf(new a.j.b.a.c.l.w[] { (a.j.b.a.c.l.w)parame, this.BVA });
      AppMethodBeat.o(119234);
      return parame;
    }
    if (f.a.d(parame))
    {
      parame = (Collection)a.a.j.listOf(this.BVA);
      AppMethodBeat.o(119234);
      return parame;
    }
    parame = (Collection)a.a.v.BMx;
    AppMethodBeat.o(119234);
    return parame;
  }
  
  public final Collection<a.j.b.a.c.b.d> o(e parame)
  {
    AppMethodBeat.i(119238);
    a.f.b.j.q(parame, "classDescriptor");
    if ((parame.ecB() != a.j.b.a.c.b.f.BWf) || (!edh()))
    {
      parame = (Collection)a.a.v.BMx;
      AppMethodBeat.o(119238);
      return parame;
    }
    a.j.b.a.c.d.a.c.a.f localf = n(parame);
    if (localf == null)
    {
      parame = (Collection)a.a.v.BMx;
      AppMethodBeat.o(119238);
      return parame;
    }
    Object localObject1 = a.j.b.a.c.i.c.a.o((l)localf);
    Object localObject2 = b.BUQ;
    Object localObject3 = c.a((a.j.b.a.c.f.b)localObject1, b.ecY().ecc());
    if (localObject3 == null)
    {
      parame = (Collection)a.a.v.BMx;
      AppMethodBeat.o(119238);
      return parame;
    }
    localObject2 = h.a((e)localObject3, (e)localf).eoP();
    Object localObject4 = new f.g((a.j.b.a.c.l.au)localObject2);
    localObject1 = (Iterable)localf.efQ();
    Object localObject5 = (Collection)new ArrayList();
    Object localObject6 = ((Iterable)localObject1).iterator();
    Object localObject7;
    label325:
    label498:
    label503:
    label508:
    label511:
    while (((Iterator)localObject6).hasNext())
    {
      localObject7 = ((Iterator)localObject6).next();
      a.j.b.a.c.b.d locald = (a.j.b.a.c.b.d)localObject7;
      a.f.b.j.p(locald, "javaConstructor");
      if (locald.ecE().BXa)
      {
        localObject1 = ((e)localObject3).ecA();
        a.f.b.j.p(localObject1, "defaultKotlinVersion.constructors");
        localObject1 = (Iterable)localObject1;
        if ((!(localObject1 instanceof Collection)) || (!((Collection)localObject1).isEmpty()))
        {
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject8 = (a.j.b.a.c.b.d)((Iterator)localObject1).next();
            a.f.b.j.p(localObject8, "it");
            if (((f.g)localObject4).a((a.j.b.a.c.b.k)localObject8, (a.j.b.a.c.b.k)locald))
            {
              i = 0;
              if (i == 0) {
                break label508;
              }
              localObject1 = (a.j.b.a.c.b.k)locald;
              if (((a.j.b.a.c.b.k)localObject1).edu().size() != 1) {
                break label503;
              }
              localObject1 = ((a.j.b.a.c.b.k)localObject1).edu();
              a.f.b.j.p(localObject1, "valueParameters");
              localObject1 = a.a.j.fU((List)localObject1);
              a.f.b.j.p(localObject1, "valueParameters.single()");
              localObject1 = ((a.j.b.a.c.b.au)localObject1).eer().enU().ecR();
              if (localObject1 == null) {
                break label498;
              }
              localObject1 = a.j.b.a.c.i.c.a.q((l)localObject1);
              if (!a.f.b.j.e(localObject1, a.j.b.a.c.i.c.a.q((l)parame))) {
                break label503;
              }
              i = 1;
              if ((i != 0) || (a.j.b.a.c.a.g.f((l)locald))) {
                break label508;
              }
              localObject1 = BVI;
              localObject8 = a.j.b.a.c.d.b.t.Cjx;
              if (((Set)localObject1).contains(a.j.b.a.c.d.b.t.a((e)localf, a.j.b.a.c.d.b.r.a((a.j.b.a.c.b.t)locald, false, false, 3)))) {
                break label508;
              }
            }
          }
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label511;
        }
        ((Collection)localObject5).add(localObject7);
        break;
        i = 1;
        break label325;
        localObject1 = null;
        break label406;
        i = 0;
        break label422;
      }
    }
    label406:
    label422:
    localObject3 = (Iterable)localObject5;
    localObject1 = (Collection)new ArrayList(a.a.j.d((Iterable)localObject3));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (a.j.b.a.c.b.d)((Iterator)localObject3).next();
      localObject5 = ((a.j.b.a.c.b.d)localObject4).edV();
      ((t.a)localObject5).g((l)parame);
      ((t.a)localObject5).I((a.j.b.a.c.l.w)parame.edE());
      ((t.a)localObject5).edX();
      ((t.a)localObject5).b(((a.j.b.a.c.l.au)localObject2).BZY);
      localObject6 = BVJ;
      localObject7 = a.j.b.a.c.d.b.t.Cjx;
      localObject7 = (e)localf;
      a.f.b.j.p(localObject4, "javaConstructor");
      if (!((Set)localObject6).contains(a.j.b.a.c.d.b.t.a((e)localObject7, a.j.b.a.c.d.b.r.a((a.j.b.a.c.b.t)localObject4, false, false, 3)))) {
        ((t.a)localObject5).a(edj());
      }
      localObject4 = ((t.a)localObject5).eeb();
      if (localObject4 == null)
      {
        parame = new a.v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassConstructorDescriptor");
        AppMethodBeat.o(119238);
        throw parame;
      }
      ((Collection)localObject1).add((a.j.b.a.c.b.d)localObject4);
    }
    parame = (Collection)localObject1;
    AppMethodBeat.o(119238);
    return parame;
  }
  
  static final class m
    extends a.f.b.k
    implements a.f.a.a<a.j.b.a.c.b.a.g>
  {
    m(f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.j.b.a.c.a.b.f
 * JD-Core Version:    0.7.0.1
 */