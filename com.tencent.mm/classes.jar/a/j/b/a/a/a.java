package a.j.b.a.a;

import a.a.ad;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "", "jClass", "Ljava/lang/Class;", "parameterNames", "", "", "callMode", "Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$CallMode;", "origin", "Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$Origin;", "methods", "Ljava/lang/reflect/Method;", "(Ljava/lang/Class;Ljava/util/List;Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$CallMode;Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$Origin;Ljava/util/List;)V", "defaultValues", "", "erasedParameterTypes", "member", "getMember", "()Ljava/lang/Void;", "parameterTypes", "Ljava/lang/reflect/Type;", "getParameterTypes", "()Ljava/util/List;", "returnType", "getReturnType", "()Ljava/lang/reflect/Type;", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "CallMode", "Origin", "kotlin-reflect-api"})
public final class a
  implements d
{
  private final List<Method> BNR;
  private final Class<?> BNl;
  private final List<Type> BQv;
  private final List<Class<?>> BQw;
  private final List<Object> BQx;
  private final List<String> BQy;
  private final a.a BQz;
  
  public a(Class<?> paramClass, List<String> paramList, a.a parama, a.b paramb, List<Method> paramList1)
  {
    AppMethodBeat.i(118957);
    this.BNl = paramClass;
    this.BQy = paramList;
    this.BQz = parama;
    this.BNR = paramList1;
    paramList = (Iterable)this.BNR;
    paramClass = (Collection)new ArrayList(a.a.j.d(paramList));
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      paramClass.add(((Method)paramList.next()).getGenericReturnType());
    }
    this.BQv = ((List)paramClass);
    paramClass = (Iterable)this.BNR;
    parama = (Collection)new ArrayList(a.a.j.d(paramClass));
    paramList1 = paramClass.iterator();
    if (paramList1.hasNext())
    {
      paramClass = ((Method)paramList1.next()).getReturnType();
      a.f.b.j.p(paramClass, "it");
      paramList = a.j.b.a.e.b.aT(paramClass);
      if (paramList != null) {
        break label370;
      }
    }
    for (;;)
    {
      parama.add(paramClass);
      break;
      this.BQw = ((List)parama);
      paramList = (Iterable)this.BNR;
      paramClass = (Collection)new ArrayList(a.a.j.d(paramList));
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        paramClass.add(((Method)paramList.next()).getDefaultValue());
      }
      this.BQx = ((List)paramClass);
      if ((this.BQz == a.a.BQB) && (paramb == a.b.BQD))
      {
        if (!((Collection)a.a.j.c((Iterable)this.BQy, "value")).isEmpty()) {}
        for (int i = 1; i != 0; i = 0)
        {
          paramClass = (Throwable)new UnsupportedOperationException("Positional call of a Java annotation constructor is allowed only if there are no parameters or one parameter named \"value\". This restriction exists because Java annotations (in contrast to Kotlin)do not impose any order on their arguments. Use KCallable#callBy instead.");
          AppMethodBeat.o(118957);
          throw paramClass;
        }
      }
      AppMethodBeat.o(118957);
      return;
      label370:
      paramClass = paramList;
    }
  }
  
  public final Object X(Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(118956);
    a.f.b.j.q(paramArrayOfObject, "args");
    a.f.b.j.q(paramArrayOfObject, "args");
    d.a.a(this, paramArrayOfObject);
    Collection localCollection = (Collection)new ArrayList(paramArrayOfObject.length);
    int k = paramArrayOfObject.length;
    int j = 0;
    int i = 0;
    while (j < k)
    {
      Object localObject = paramArrayOfObject[j];
      if ((localObject == null) && (this.BQz == a.a.BQA)) {}
      for (localObject = this.BQx.get(i); localObject == null; localObject = b.e(localObject, (Class)this.BQw.get(i)))
      {
        b.a(i, (String)this.BQy.get(i), (Class)this.BQw.get(i));
        AppMethodBeat.o(118956);
        throw null;
      }
      localCollection.add(localObject);
      j += 1;
      i += 1;
    }
    paramArrayOfObject = (List)localCollection;
    paramArrayOfObject = b.a(this.BNl, ad.w((Iterable)a.a.j.a((Iterable)this.BQy, (Iterable)paramArrayOfObject)), this.BNR);
    AppMethodBeat.o(118956);
    return paramArrayOfObject;
  }
  
  public final Type ebW()
  {
    return (Type)this.BNl;
  }
  
  public final List<Type> ebX()
  {
    return this.BQv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.j.b.a.a.a
 * JD-Core Version:    0.7.0.1
 */