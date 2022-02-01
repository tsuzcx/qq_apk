package com.google.a.c;

import com.google.a.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Type;

public final class a<T>
{
  final int aFZ;
  public final Type bET;
  public final Class<? super T> bGk;
  
  protected a()
  {
    AppMethodBeat.i(107871);
    Object localObject = getClass().getGenericSuperclass();
    if ((localObject instanceof Class))
    {
      localObject = new RuntimeException("Missing type parameter.");
      AppMethodBeat.o(107871);
      throw ((Throwable)localObject);
    }
    this.bET = b.b(((java.lang.reflect.ParameterizedType)localObject).getActualTypeArguments()[0]);
    this.bGk = b.c(this.bET);
    this.aFZ = this.bET.hashCode();
    AppMethodBeat.o(107871);
  }
  
  private a(Type paramType)
  {
    AppMethodBeat.i(107872);
    this.bET = b.b((Type)com.google.a.b.a.checkNotNull(paramType));
    this.bGk = b.c(this.bET);
    this.aFZ = this.bET.hashCode();
    AppMethodBeat.o(107872);
  }
  
  public static <T> a<T> J(Class<T> paramClass)
  {
    AppMethodBeat.i(107876);
    paramClass = new a(paramClass);
    AppMethodBeat.o(107876);
    return paramClass;
  }
  
  public static a<?> h(Type paramType)
  {
    AppMethodBeat.i(107875);
    paramType = new a(paramType);
    AppMethodBeat.o(107875);
    return paramType;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(107873);
    if (((paramObject instanceof a)) && (b.a(this.bET, ((a)paramObject).bET)))
    {
      AppMethodBeat.o(107873);
      return true;
    }
    AppMethodBeat.o(107873);
    return false;
  }
  
  public final int hashCode()
  {
    return this.aFZ;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(107874);
    String str = b.d(this.bET);
    AppMethodBeat.o(107874);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.a.c.a
 * JD-Core Version:    0.7.0.1
 */