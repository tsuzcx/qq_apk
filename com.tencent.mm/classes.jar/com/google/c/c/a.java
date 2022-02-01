package com.google.c.c;

import com.google.c.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Type;

public final class a<T>
{
  final int cHb;
  public final Type dGJ;
  public final Class<? super T> dIb;
  
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
    this.dGJ = b.b(((java.lang.reflect.ParameterizedType)localObject).getActualTypeArguments()[0]);
    this.dIb = b.c(this.dGJ);
    this.cHb = this.dGJ.hashCode();
    AppMethodBeat.o(107871);
  }
  
  private a(Type paramType)
  {
    AppMethodBeat.i(107872);
    this.dGJ = b.b((Type)com.google.c.b.a.checkNotNull(paramType));
    this.dIb = b.c(this.dGJ);
    this.cHb = this.dGJ.hashCode();
    AppMethodBeat.o(107872);
  }
  
  public static <T> a<T> I(Class<T> paramClass)
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
    if (((paramObject instanceof a)) && (b.a(this.dGJ, ((a)paramObject).dGJ)))
    {
      AppMethodBeat.o(107873);
      return true;
    }
    AppMethodBeat.o(107873);
    return false;
  }
  
  public final int hashCode()
  {
    return this.cHb;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(107874);
    String str = b.d(this.dGJ);
    AppMethodBeat.o(107874);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.c.c.a
 * JD-Core Version:    0.7.0.1
 */