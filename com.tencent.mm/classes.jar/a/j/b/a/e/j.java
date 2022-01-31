package a.j.b.a.e;

import a.f.b.i;
import a.f.b.k;
import a.j.b.a.c.b.az;
import a.j.b.a.c.d.a.e.g;
import a.j.b.a.c.f.a;
import a.j.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/reflect/jvm/internal/structure/ReflectJavaClass;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaElement;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaAnnotationOwner;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaModifierListOwner;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaClass;", "klass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "constructors", "", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaConstructor;", "getConstructors", "()Ljava/util/List;", "element", "getElement", "()Ljava/lang/Class;", "fields", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaField;", "getFields", "fqName", "Lkotlin/reflect/jvm/internal/impl/name/FqName;", "getFqName", "()Lorg/jetbrains/kotlin/name/FqName;", "innerClassNames", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "getInnerClassNames", "isAnnotationType", "", "()Z", "isEnum", "isInterface", "lightClassOriginKind", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/LightClassOriginKind;", "getLightClassOriginKind", "()Lorg/jetbrains/kotlin/load/java/structure/LightClassOriginKind;", "methods", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaMethod;", "getMethods", "modifiers", "", "getModifiers", "()I", "name", "getName", "()Lorg/jetbrains/kotlin/name/Name;", "outerClass", "getOuterClass", "()Lkotlin/reflect/jvm/internal/structure/ReflectJavaClass;", "supertypes", "", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaClassifierType;", "getSupertypes", "()Ljava/util/Collection;", "typeParameters", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaTypeParameter;", "getTypeParameters", "equals", "other", "", "findInnerClass", "hashCode", "isEnumValuesOrValueOf", "method", "Ljava/lang/reflect/Method;", "toString", "", "descriptors.runtime"})
public final class j
  extends n
  implements g, f, t
{
  public final Class<?> BRg;
  
  public j(Class<?> paramClass)
  {
    AppMethodBeat.i(123074);
    this.BRg = paramClass;
    AppMethodBeat.o(123074);
  }
  
  public final az ecE()
  {
    AppMethodBeat.i(123080);
    az localaz = t.a.d(this);
    AppMethodBeat.o(123080);
    return localaz;
  }
  
  public final a.j.b.a.c.f.f edF()
  {
    AppMethodBeat.i(123066);
    a.j.b.a.c.f.f localf = a.j.b.a.c.f.f.ayT(this.BRg.getSimpleName());
    a.f.b.j.p(localf, "Name.identifier(klass.simpleName)");
    AppMethodBeat.o(123066);
    return localf;
  }
  
  public final List<x> edr()
  {
    AppMethodBeat.i(123067);
    Object localObject = this.BRg.getTypeParameters();
    a.f.b.j.p(localObject, "klass.typeParameters");
    Collection localCollection = (Collection)new ArrayList(localObject.length);
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      localCollection.add(new x(localObject[i]));
      i += 1;
    }
    localObject = (List)localCollection;
    AppMethodBeat.o(123067);
    return localObject;
  }
  
  public final Collection<a.j.b.a.c.d.a.e.j> eeO()
  {
    AppMethodBeat.i(123062);
    if (a.f.b.j.e(this.BRg, Object.class))
    {
      localObject1 = (Collection)a.a.v.BMx;
      AppMethodBeat.o(123062);
      return localObject1;
    }
    a.f.b.x localx = new a.f.b.x(2);
    Object localObject2 = this.BRg.getGenericSuperclass();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = (Type)Object.class;
    }
    localx.add(localObject1);
    localObject1 = this.BRg.getGenericInterfaces();
    a.f.b.j.p(localObject1, "klass.genericInterfaces");
    localx.dh(localObject1);
    localObject2 = (Iterable)a.a.j.listOf((Type[])localx.toArray(new Type[localx.ceo.size()]));
    localObject1 = (Collection)new ArrayList(a.a.j.d((Iterable)localObject2));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(new l((Type)((Iterator)localObject2).next()));
    }
    localObject1 = (Collection)localObject1;
    AppMethodBeat.o(123062);
    return localObject1;
  }
  
  public final a.j.b.a.c.f.b eee()
  {
    AppMethodBeat.i(123060);
    a.j.b.a.c.f.b localb = b.aU(this.BRg).emc();
    a.f.b.j.p(localb, "klass.classId.asSingleFqName()");
    AppMethodBeat.o(123060);
    return localb;
  }
  
  public final boolean egg()
  {
    AppMethodBeat.i(156781);
    boolean bool = this.BRg.isAnnotation();
    AppMethodBeat.o(156781);
    return bool;
  }
  
  public final boolean egw()
  {
    AppMethodBeat.i(123077);
    boolean bool = t.a.a(this);
    AppMethodBeat.o(123077);
    return bool;
  }
  
  public final boolean egx()
  {
    AppMethodBeat.i(123079);
    boolean bool = t.a.c(this);
    AppMethodBeat.o(123079);
    return bool;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(123071);
    if (((paramObject instanceof j)) && (a.f.b.j.e(this.BRg, ((j)paramObject).BRg)))
    {
      AppMethodBeat.o(123071);
      return true;
    }
    AppMethodBeat.o(123071);
    return false;
  }
  
  public final int getModifiers()
  {
    AppMethodBeat.i(123058);
    int i = this.BRg.getModifiers();
    AppMethodBeat.o(123058);
    return i;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(123072);
    int i = this.BRg.hashCode();
    AppMethodBeat.o(123072);
    return i;
  }
  
  public final boolean isEnum()
  {
    AppMethodBeat.i(123070);
    boolean bool = this.BRg.isEnum();
    AppMethodBeat.o(123070);
    return bool;
  }
  
  public final boolean isInterface()
  {
    AppMethodBeat.i(123068);
    boolean bool = this.BRg.isInterface();
    AppMethodBeat.o(123068);
    return bool;
  }
  
  public final boolean isStatic()
  {
    AppMethodBeat.i(123078);
    boolean bool = t.a.b(this);
    AppMethodBeat.o(123078);
    return bool;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(123073);
    String str = getClass().getName() + ": " + this.BRg;
    AppMethodBeat.o(123073);
    return str;
  }
  
  @a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "constructor", "Ljava/lang/reflect/Constructor;", "kotlin.jvm.PlatformType", "invoke"})
  static final class a
    extends k
    implements a.f.a.b<Constructor<?>, Boolean>
  {
    public static final a CFL;
    
    static
    {
      AppMethodBeat.i(123041);
      CFL = new a();
      AppMethodBeat.o(123041);
    }
    
    a()
    {
      super();
    }
  }
  
  @a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaConstructor;", "p1", "Ljava/lang/reflect/Constructor;", "Lkotlin/ParameterName;", "name", "member", "invoke"})
  static final class b
    extends i
    implements a.f.a.b<Constructor<?>, m>
  {
    public static final b CFM;
    
    static
    {
      AppMethodBeat.i(123044);
      CFM = new b();
      AppMethodBeat.o(123044);
    }
    
    b()
    {
      super();
    }
    
    public final String dyz()
    {
      return "<init>(Ljava/lang/reflect/Constructor;)V";
    }
    
    public final d ebe()
    {
      AppMethodBeat.i(123043);
      a.j.b localb = a.f.b.v.aG(m.class);
      AppMethodBeat.o(123043);
      return localb;
    }
    
    public final String getName()
    {
      return "<init>";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.j.b.a.e.j
 * JD-Core Version:    0.7.0.1
 */