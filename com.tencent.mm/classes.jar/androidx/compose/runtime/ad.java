package androidx.compose.runtime;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/IntStack;", "", "()V", "size", "", "getSize", "()I", "slots", "", "tos", "clear", "", "isEmpty", "", "isNotEmpty", "peek", "index", "peekOr", "default", "pop", "push", "value", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ad
{
  private int[] aoc;
  int aod;
  
  public ad()
  {
    AppMethodBeat.i(201866);
    this.aoc = new int[10];
    AppMethodBeat.o(201866);
  }
  
  public final void bF(int paramInt)
  {
    AppMethodBeat.i(201876);
    if (this.aod >= this.aoc.length)
    {
      arrayOfInt = Arrays.copyOf(this.aoc, this.aoc.length * 2);
      s.s(arrayOfInt, "java.util.Arrays.copyOf(this, newSize)");
      this.aoc = arrayOfInt;
    }
    int[] arrayOfInt = this.aoc;
    int i = this.aod;
    this.aod = (i + 1);
    arrayOfInt[i] = paramInt;
    AppMethodBeat.o(201876);
  }
  
  public final int pv()
  {
    int[] arrayOfInt = this.aoc;
    this.aod -= 1;
    return arrayOfInt[this.aod];
  }
  
  public final int pw()
  {
    AppMethodBeat.i(201889);
    if (this.aod > 0)
    {
      int i = px();
      AppMethodBeat.o(201889);
      return i;
    }
    AppMethodBeat.o(201889);
    return -1;
  }
  
  public final int px()
  {
    return this.aoc[(this.aod - 1)];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.ad
 * JD-Core Version:    0.7.0.1
 */