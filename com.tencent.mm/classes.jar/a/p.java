package a;

import a.f.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/Result;", "T", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "value", "", "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "isFailure", "", "isFailure-impl", "(Ljava/lang/Object;)Z", "isSuccess", "isSuccess-impl", "value$annotations", "()V", "equals", "other", "exceptionOrNull", "", "exceptionOrNull-impl", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "getOrNull", "getOrNull-impl", "hashCode", "", "toString", "", "toString-impl", "(Ljava/lang/Object;)Ljava/lang/String;", "Companion", "Failure", "kotlin-stdlib"})
public final class p<T>
  implements Serializable
{
  public static final a BLX;
  private final Object value;
  
  static
  {
    AppMethodBeat.i(56250);
    BLX = new a((byte)0);
    AppMethodBeat.o(56250);
  }
  
  public static final boolean dc(Object paramObject)
  {
    return !(paramObject instanceof p.b);
  }
  
  public static final Throwable dd(Object paramObject)
  {
    if ((paramObject instanceof p.b)) {
      return ((p.b)paramObject).BLY;
    }
    return null;
  }
  
  public static Object de(Object paramObject)
  {
    return paramObject;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(56252);
    Object localObject = this.value;
    if (((paramObject instanceof p)) && (j.e(localObject, ((p)paramObject).value)))
    {
      AppMethodBeat.o(56252);
      return true;
    }
    AppMethodBeat.o(56252);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(56251);
    Object localObject = this.value;
    if (localObject != null)
    {
      int i = localObject.hashCode();
      AppMethodBeat.o(56251);
      return i;
    }
    AppMethodBeat.o(56251);
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(56249);
    Object localObject = this.value;
    if ((localObject instanceof p.b))
    {
      localObject = localObject.toString();
      AppMethodBeat.o(56249);
      return localObject;
    }
    localObject = "Success(" + localObject + ')';
    AppMethodBeat.o(56249);
    return localObject;
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/Result$Companion;", "", "()V", "failure", "Lkotlin/Result;", "T", "exception", "", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "success", "value", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.p
 * JD-Core Version:    0.7.0.1
 */