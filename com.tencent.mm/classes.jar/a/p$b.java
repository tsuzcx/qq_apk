package a;

import a.f.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/Result$Failure;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "exception", "", "(Ljava/lang/Throwable;)V", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlin-stdlib"})
public final class p$b
  implements Serializable
{
  public final Throwable BLY;
  
  public p$b(Throwable paramThrowable)
  {
    AppMethodBeat.i(56420);
    this.BLY = paramThrowable;
    AppMethodBeat.o(56420);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(56417);
    if (((paramObject instanceof b)) && (j.e(this.BLY, ((b)paramObject).BLY)))
    {
      AppMethodBeat.o(56417);
      return true;
    }
    AppMethodBeat.o(56417);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(56418);
    int i = this.BLY.hashCode();
    AppMethodBeat.o(56418);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(56419);
    String str = "Failure(" + this.BLY + ')';
    AppMethodBeat.o(56419);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     a.p.b
 * JD-Core Version:    0.7.0.1
 */