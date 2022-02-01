package androidx.paging;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/PagingConfig;", "", "pageSize", "", "prefetchDistance", "enablePlaceholders", "", "initialLoadSize", "maxSize", "jumpThreshold", "(IIZIII)V", "Companion", "paging-common"}, k=1, mv={1, 4, 2})
public final class au
{
  public static final au.a bQj;
  public final int bMq;
  public final int bPL;
  public final boolean bPM;
  public final int bQi;
  public final int maxSize;
  public final int pageSize;
  
  static
  {
    AppMethodBeat.i(196664);
    bQj = new au.a((byte)0);
    AppMethodBeat.o(196664);
  }
  
  private au(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(196656);
    this.pageSize = paramInt1;
    this.bPL = paramInt2;
    this.bPM = paramBoolean;
    this.bMq = paramInt3;
    this.maxSize = paramInt4;
    this.bQi = paramInt5;
    Throwable localThrowable;
    if ((!this.bPM) && (this.bPL == 0))
    {
      localThrowable = (Throwable)new IllegalArgumentException("Placeholders and prefetch are the only ways to trigger loading of more data in PagingData, so either placeholders must be enabled, or prefetch distance must be > 0.");
      AppMethodBeat.o(196656);
      throw localThrowable;
    }
    if ((this.maxSize != 2147483647) && (this.maxSize < this.pageSize + this.bPL * 2))
    {
      localThrowable = (Throwable)new IllegalArgumentException("Maximum size must be at least pageSize + 2*prefetchDist, pageSize=" + this.pageSize + ", prefetchDist=" + this.bPL + ", maxSize=" + this.maxSize);
      AppMethodBeat.o(196656);
      throw localThrowable;
    }
    if ((this.bQi == -2147483648) || (this.bQi > 0)) {}
    for (paramInt1 = 1; paramInt1 == 0; paramInt1 = 0)
    {
      localThrowable = (Throwable)new IllegalArgumentException("jumpThreshold must be positive to enable jumps or COUNT_UNDEFINED to disable jumping.".toString());
      AppMethodBeat.o(196656);
      throw localThrowable;
    }
    AppMethodBeat.o(196656);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.paging.au
 * JD-Core Version:    0.7.0.1
 */