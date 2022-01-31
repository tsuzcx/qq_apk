package a.f.b;

import a.f.a;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/jvm/internal/ClassReference;", "Lkotlin/reflect/KClass;", "", "Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "jClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "constructors", "", "Lkotlin/reflect/KFunction;", "getConstructors", "()Ljava/util/Collection;", "isAbstract", "", "isAbstract$annotations", "()V", "()Z", "isCompanion", "isCompanion$annotations", "isData", "isData$annotations", "isFinal", "isFinal$annotations", "isInner", "isInner$annotations", "isOpen", "isOpen$annotations", "isSealed", "isSealed$annotations", "getJClass", "()Ljava/lang/Class;", "members", "Lkotlin/reflect/KCallable;", "getMembers", "nestedClasses", "getNestedClasses", "objectInstance", "getObjectInstance", "()Ljava/lang/Object;", "qualifiedName", "", "getQualifiedName", "()Ljava/lang/String;", "sealedSubclasses", "sealedSubclasses$annotations", "getSealedSubclasses", "simpleName", "getSimpleName", "supertypes", "Lkotlin/reflect/KType;", "supertypes$annotations", "getSupertypes", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "typeParameters$annotations", "getTypeParameters", "visibility", "Lkotlin/reflect/KVisibility;", "visibility$annotations", "getVisibility", "()Lkotlin/reflect/KVisibility;", "equals", "other", "error", "", "hashCode", "", "isInstance", "value", "toString", "kotlin-stdlib"})
public final class e
  implements d, a.j.b<Object>
{
  private final Class<?> BNl;
  
  public e(Class<?> paramClass)
  {
    AppMethodBeat.i(56231);
    this.BNl = paramClass;
    AppMethodBeat.o(56231);
  }
  
  public final Class<?> ebg()
  {
    return this.BNl;
  }
  
  public final String ebh()
  {
    AppMethodBeat.i(56227);
    Throwable localThrowable = (Throwable)new a.f.b();
    AppMethodBeat.o(56227);
    throw localThrowable;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(56228);
    if (((paramObject instanceof e)) && (j.e(a.c(this), a.c((a.j.b)paramObject))))
    {
      AppMethodBeat.o(56228);
      return true;
    }
    AppMethodBeat.o(56228);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(56229);
    int i = a.c(this).hashCode();
    AppMethodBeat.o(56229);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(56230);
    String str = this.BNl.toString() + " (Kotlin reflection is not available)";
    AppMethodBeat.o(56230);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     a.f.b.e
 * JD-Core Version:    0.7.0.1
 */