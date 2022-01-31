package a.j.b.a.a;

import a.f;
import a.f.a.a;
import a.f.b.j;
import a.f.b.t;
import a.j.b.a.x;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller;", "M", "Ljava/lang/reflect/Member;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "caller", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "isDefault", "", "(Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;Lkotlin/reflect/jvm/internal/calls/CallerImpl;Z)V", "data", "Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller$BoxUnboxData;", "getData", "()Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller$BoxUnboxData;", "data$delegate", "Lkotlin/Lazy;", "member", "getMember", "()Ljava/lang/reflect/Member;", "parameterTypes", "", "Ljava/lang/reflect/Type;", "getParameterTypes", "()Ljava/util/List;", "returnType", "getReturnType", "()Ljava/lang/reflect/Type;", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "getBoxMethod", "Ljava/lang/reflect/Method;", "Ljava/lang/Class;", "getUnboxMethod", "toInlineClass", "Lkotlin/reflect/jvm/internal/impl/types/KotlinType;", "BoxUnboxData", "kotlin-reflect-api"})
public final class g<M extends Member>
  implements d<M>
{
  private final f BQV;
  private final a.j.b.a.c.b.b BQW;
  final e<M> BQX;
  private final boolean isDefault;
  
  static
  {
    AppMethodBeat.i(119006);
    eOJ = new a.j.k[] { (a.j.k)a.f.b.v.a(new t(a.f.b.v.aG(g.class), "data", "getData()Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller$BoxUnboxData;")) };
    AppMethodBeat.o(119006);
  }
  
  public g(a.j.b.a.c.b.b paramb, e<? extends M> parame, boolean paramBoolean)
  {
    AppMethodBeat.i(119010);
    this.BQW = paramb;
    this.BQX = parame;
    this.isDefault = paramBoolean;
    this.BQV = a.g.a(a.k.BLU, (a)new g.b(this));
    AppMethodBeat.o(119010);
  }
  
  private final Method aL(Class<?> paramClass)
  {
    AppMethodBeat.i(119008);
    try
    {
      Method localMethod = paramClass.getDeclaredMethod("box-impl", new Class[] { aM(paramClass).getReturnType() });
      j.p(localMethod, "getDeclaredMethod(\"box\" …UnboxMethod().returnType)");
      AppMethodBeat.o(119008);
      return localMethod;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      paramClass = (Throwable)new x("No box method found in inline class: " + paramClass + " (calling " + this.BQW + ')');
      AppMethodBeat.o(119008);
      throw paramClass;
    }
  }
  
  private final Method aM(Class<?> paramClass)
  {
    AppMethodBeat.i(119009);
    try
    {
      Method localMethod = paramClass.getDeclaredMethod("unbox-impl", new Class[0]);
      j.p(localMethod, "getDeclaredMethod(\"unbox…FOR_INLINE_CLASS_MEMBERS)");
      AppMethodBeat.o(119009);
      return localMethod;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      paramClass = (Throwable)new x("No unbox method found in inline class: " + paramClass + " (calling " + this.BQW + ')');
      AppMethodBeat.o(119009);
      throw paramClass;
    }
  }
  
  public final Object X(Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(119007);
    j.q(paramArrayOfObject, "args");
    Object localObject2 = (g.a)this.BQV.getValue();
    Object localObject1 = ((g.a)localObject2).BQY;
    Method[] arrayOfMethod = ((g.a)localObject2).BQZ;
    Method localMethod1 = ((g.a)localObject2).BRa;
    Object[] arrayOfObject = Arrays.copyOf(paramArrayOfObject, paramArrayOfObject.length);
    j.p(arrayOfObject, "java.util.Arrays.copyOf(this, size)");
    if (arrayOfObject == null)
    {
      paramArrayOfObject = new a.v("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
      AppMethodBeat.o(119007);
      throw paramArrayOfObject;
    }
    int i = ((a.i.b)localObject1).BNv;
    int j = ((a.i.b)localObject1).BNw;
    if (i <= j) {
      for (;;)
      {
        Method localMethod2 = arrayOfMethod[i];
        localObject2 = paramArrayOfObject[i];
        localObject1 = localObject2;
        if (localMethod2 != null)
        {
          localObject1 = localObject2;
          if (localObject2 != null) {
            localObject1 = localMethod2.invoke(localObject2, new Object[0]);
          }
        }
        arrayOfObject[i] = localObject1;
        if (i == j) {
          break;
        }
        i += 1;
      }
    }
    localObject1 = this.BQX.X(arrayOfObject);
    if (localMethod1 != null)
    {
      localObject2 = localMethod1.invoke(null, new Object[] { localObject1 });
      paramArrayOfObject = (Object[])localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      paramArrayOfObject = (Object[])localObject1;
    }
    AppMethodBeat.o(119007);
    return paramArrayOfObject;
  }
  
  public final M ebV()
  {
    return this.BQX.BQP;
  }
  
  public final Type ebW()
  {
    return this.BQX.BQQ;
  }
  
  public final List<Type> ebX()
  {
    return this.BQX.BQv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.j.b.a.a.g
 * JD-Core Version:    0.7.0.1
 */