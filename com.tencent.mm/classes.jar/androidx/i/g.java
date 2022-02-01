package androidx.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

final class g<T>
{
  private static final g adM;
  private static final g adN;
  public final List<T> adO;
  public final int adP;
  public final int adQ;
  public final int adR;
  
  static
  {
    AppMethodBeat.i(219499);
    adM = new g(Collections.emptyList());
    adN = new g(Collections.emptyList());
    AppMethodBeat.o(219499);
  }
  
  private g(List<T> paramList)
  {
    this.adO = paramList;
    this.adP = 0;
    this.adQ = 0;
    this.adR = 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(219497);
    String str = "Result " + this.adP + ", " + this.adO + ", " + this.adQ + ", offset " + this.adR;
    AppMethodBeat.o(219497);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.i.g
 * JD-Core Version:    0.7.0.1
 */