package a.j.b.a;

import a.j.b.a.a.d;
import a.j.b.a.c.b.b;
import a.l;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/reflect/jvm/internal/KCallableImpl;", "R", "Lkotlin/reflect/KCallable;", "()V", "_annotations", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "", "", "kotlin.jvm.PlatformType", "_parameters", "Ljava/util/ArrayList;", "Lkotlin/reflect/KParameter;", "_returnType", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "_typeParameters", "Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "annotations", "getAnnotations", "()Ljava/util/List;", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "getDefaultCaller", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;", "isAbstract", "", "()Z", "isAnnotationConstructor", "isBound", "isFinal", "isOpen", "parameters", "getParameters", "returnType", "Lkotlin/reflect/KType;", "getReturnType", "()Lkotlin/reflect/KType;", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "visibility", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", "call", "args", "", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "callAnnotationConstructor", "", "(Ljava/util/Map;)Ljava/lang/Object;", "callBy", "callDefaultMethod", "continuationArgument", "Lkotlin/coroutines/Continuation;", "callDefaultMethod$kotlin_reflect_api", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "defaultPrimitiveValue", "type", "Ljava/lang/reflect/Type;", "extractContinuationArgument", "kotlin-reflect-api"})
public abstract class e<R>
  implements a.j.a<R>
{
  private final z.a<List<Annotation>> BOg;
  private final z.a<ArrayList<a.j.j>> BOh;
  private final z.a<u> BOi;
  private final z.a<List<w>> BOj;
  
  public e()
  {
    z.a locala = z.a(null, (a.f.a.a)new e.a(this));
    a.f.b.j.p(locala, "ReflectProperties.lazySo…or.computeAnnotations() }");
    this.BOg = locala;
    locala = z.a(null, (a.f.a.a)new e.b(this));
    a.f.b.j.p(locala, "ReflectProperties.lazySo…ze()\n        result\n    }");
    this.BOh = locala;
    locala = z.a(null, (a.f.a.a)new e.c(this));
    a.f.b.j.p(locala, "ReflectProperties.lazySo…eturnType\n        }\n    }");
    this.BOi = locala;
    locala = z.a(null, (a.f.a.a)new e.d(this));
    a.f.b.j.p(locala, "ReflectProperties.lazySo…KTypeParameterImpl)\n    }");
    this.BOj = locala;
  }
  
  public final R X(Object... paramVarArgs)
  {
    a.f.b.j.q(paramVarArgs, "args");
    try
    {
      paramVarArgs = ebt().X(paramVarArgs);
      return paramVarArgs;
    }
    catch (IllegalAccessException paramVarArgs)
    {
      throw ((Throwable)new a.j.a.a(paramVarArgs));
    }
  }
  
  public abstract b ebs();
  
  public abstract d<?> ebt();
  
  public abstract i ebu();
  
  protected final boolean ebv()
  {
    return (a.f.b.j.e(getName(), "<init>")) && (ebu().ebg().isAnnotation());
  }
  
  public final List<a.j.j> getParameters()
  {
    Object localObject = this.BOh.invoke();
    a.f.b.j.p(localObject, "_parameters()");
    return (List)localObject;
  }
  
  public abstract boolean isBound();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.j.b.a.e
 * JD-Core Version:    0.7.0.1
 */