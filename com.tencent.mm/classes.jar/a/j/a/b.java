package a.j.a;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/reflect/full/IllegalPropertyDelegateAccessException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "cause", "Ljava/lang/IllegalAccessException;", "(Ljava/lang/IllegalAccessException;)V", "kotlin-reflect-api"})
public final class b
  extends Exception
{
  public b(IllegalAccessException paramIllegalAccessException)
  {
    super("Cannot obtain the delegate of a non-accessible property. Use \"isAccessible = true\" to make the property accessible", (Throwable)paramIllegalAccessException);
    AppMethodBeat.i(118653);
    AppMethodBeat.o(118653);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.j.a.b
 * JD-Core Version:    0.7.0.1
 */