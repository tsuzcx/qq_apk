package a.c;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/coroutines/CombinedContext$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "elements", "", "Lkotlin/coroutines/CoroutineContext;", "([Lkotlin/coroutines/CoroutineContext;)V", "getElements", "()[Lkotlin/coroutines/CoroutineContext;", "[Lkotlin/coroutines/CoroutineContext;", "readResolve", "", "Companion", "kotlin-stdlib"})
final class b$a
  implements Serializable
{
  public static final b.a.a BMI;
  private final e[] BMH;
  
  static
  {
    AppMethodBeat.i(56372);
    BMI = new b.a.a((byte)0);
    AppMethodBeat.o(56372);
  }
  
  public b$a(e[] paramArrayOfe)
  {
    AppMethodBeat.i(56371);
    this.BMH = paramArrayOfe;
    AppMethodBeat.o(56371);
  }
  
  private final Object readResolve()
  {
    AppMethodBeat.i(56370);
    e[] arrayOfe = this.BMH;
    Object localObject = f.BMO;
    int j = arrayOfe.length;
    int i = 0;
    while (i < j)
    {
      e locale = arrayOfe[i];
      localObject = ((e)localObject).plus(locale);
      i += 1;
    }
    AppMethodBeat.o(56370);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.c.b.a
 * JD-Core Version:    0.7.0.1
 */