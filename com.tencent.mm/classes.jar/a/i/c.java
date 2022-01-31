package a.i;

import a.a.ab;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.NoSuchElementException;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/ranges/IntProgressionIterator;", "Lkotlin/collections/IntIterator;", "first", "", "last", "step", "(III)V", "finalElement", "hasNext", "", "next", "getStep", "()I", "nextInt", "kotlin-stdlib"})
public final class c
  extends ab
{
  private int BNA;
  private final int BNy;
  private boolean BNz;
  private final int hAu;
  
  public c(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(55994);
    this.hAu = paramInt3;
    this.BNy = paramInt2;
    if (this.hAu > 0) {
      if (paramInt1 <= paramInt2)
      {
        this.BNz = bool;
        if (!this.BNz) {
          break label75;
        }
      }
    }
    for (;;)
    {
      this.BNA = paramInt1;
      AppMethodBeat.o(55994);
      return;
      bool = false;
      break;
      if (paramInt1 >= paramInt2) {
        break;
      }
      bool = false;
      break;
      label75:
      paramInt1 = this.BNy;
    }
  }
  
  public final boolean hasNext()
  {
    return this.BNz;
  }
  
  public final int nextInt()
  {
    AppMethodBeat.i(55993);
    int i = this.BNA;
    if (i == this.BNy)
    {
      if (!this.BNz)
      {
        Throwable localThrowable = (Throwable)new NoSuchElementException();
        AppMethodBeat.o(55993);
        throw localThrowable;
      }
      this.BNz = false;
    }
    for (;;)
    {
      AppMethodBeat.o(55993);
      return i;
      this.BNA += this.hAu;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.i.c
 * JD-Core Version:    0.7.0.1
 */