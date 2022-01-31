package a.j.b.a.e;

import a.a.e;
import a.j.b.a.c.b.az;
import a.j.b.a.c.d.a.e.p;
import a.j.b.a.c.f.h;
import a.l;
import a.v;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/reflect/jvm/internal/structure/ReflectJavaMember;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaElement;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaAnnotationOwner;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaModifierListOwner;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaMember;", "()V", "containingClass", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaClass;", "getContainingClass", "()Lkotlin/reflect/jvm/internal/structure/ReflectJavaClass;", "element", "Ljava/lang/reflect/AnnotatedElement;", "getElement", "()Ljava/lang/reflect/AnnotatedElement;", "member", "Ljava/lang/reflect/Member;", "getMember", "()Ljava/lang/reflect/Member;", "modifiers", "", "getModifiers", "()I", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "getName", "()Lorg/jetbrains/kotlin/name/Name;", "equals", "", "other", "", "getValueParameters", "", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaValueParameter;", "parameterTypes", "", "Ljava/lang/reflect/Type;", "parameterAnnotations", "", "isVararg", "([Ljava/lang/reflect/Type;[[Ljava/lang/annotation/Annotation;Z)Ljava/util/List;", "hashCode", "toString", "", "descriptors.runtime"})
public abstract class r
  extends n
  implements p, f, t
{
  protected final List<a.j.b.a.c.d.a.e.y> a(Type[] paramArrayOfType, Annotation[][] paramArrayOfAnnotation, boolean paramBoolean)
  {
    a.f.b.j.q(paramArrayOfType, "parameterTypes");
    a.f.b.j.q(paramArrayOfAnnotation, "parameterAnnotations");
    ArrayList localArrayList = new ArrayList(paramArrayOfType.length);
    Object localObject = a.CFz;
    List localList = a.b(ebV());
    if (localList != null) {}
    int j;
    w localw;
    for (int i = localList.size() - paramArrayOfType.length;; i = 0)
    {
      int k = paramArrayOfType.length;
      j = 0;
      if (j >= k) {
        break label251;
      }
      localObject = w.CFZ;
      localw = w.a.k(paramArrayOfType[j]);
      if (localList == null) {
        break label239;
      }
      localObject = (String)a.a.j.w(localList, j + i);
      if (localObject != null) {
        break;
      }
      throw ((Throwable)new IllegalStateException(("No parameter with index " + j + '+' + i + " (name=" + edF() + " type=" + localw + ") in " + localList + "@ReflectJavaMember").toString()));
    }
    label191:
    if ((paramBoolean) && (j == e.Q(paramArrayOfType))) {}
    for (boolean bool = true;; bool = false)
    {
      localArrayList.add(new y(localw, paramArrayOfAnnotation[j], (String)localObject, bool));
      j += 1;
      break;
      label239:
      localObject = null;
      break label191;
    }
    label251:
    return (List)localArrayList;
  }
  
  public abstract Member ebV();
  
  public final az ecE()
  {
    return t.a.d(this);
  }
  
  public final a.j.b.a.c.f.f edF()
  {
    Object localObject = ebV().getName();
    if (localObject != null) {
      return a.j.b.a.c.f.f.ayT((String)localObject);
    }
    localObject = h.CqQ;
    a.f.b.j.p(localObject, "SpecialNames.NO_NAME_PROVIDED");
    return localObject;
  }
  
  public final boolean egw()
  {
    return t.a.a(this);
  }
  
  public final boolean egx()
  {
    return t.a.c(this);
  }
  
  public final AnnotatedElement epf()
  {
    Member localMember = ebV();
    if (localMember == null) {
      throw new v("null cannot be cast to non-null type java.lang.reflect.AnnotatedElement");
    }
    return (AnnotatedElement)localMember;
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof r)) && (a.f.b.j.e(ebV(), ((r)paramObject).ebV()));
  }
  
  public final int getModifiers()
  {
    return ebV().getModifiers();
  }
  
  public int hashCode()
  {
    return ebV().hashCode();
  }
  
  public final boolean isStatic()
  {
    return t.a.b(this);
  }
  
  public String toString()
  {
    return getClass().getName() + ": " + ebV();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.j.b.a.e.r
 * JD-Core Version:    0.7.0.1
 */