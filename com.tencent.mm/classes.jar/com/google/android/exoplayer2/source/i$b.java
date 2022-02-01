package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.w;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class i$b
  extends a
{
  private final int cZM;
  private final w cZP;
  private final int cZQ;
  private final int loopCount;
  
  public i$b(w paramw, int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(210339);
    this.cZP = paramw;
    this.cZM = paramw.QX();
    this.cZQ = paramw.QW();
    this.loopCount = paramInt;
    if (paramInt <= 2147483647 / this.cZM) {}
    for (boolean bool = true;; bool = false)
    {
      com.google.android.exoplayer2.i.a.checkState(bool, "LoopingMediaSource contains too many periods");
      AppMethodBeat.o(210339);
      return;
    }
  }
  
  public final int QW()
  {
    return this.cZQ * this.loopCount;
  }
  
  public final int QX()
  {
    return this.cZM * this.loopCount;
  }
  
  protected final w SL()
  {
    return this.cZP;
  }
  
  protected final int bh(Object paramObject)
  {
    AppMethodBeat.i(210345);
    if (!(paramObject instanceof Integer))
    {
      AppMethodBeat.o(210345);
      return -1;
    }
    int i = ((Integer)paramObject).intValue();
    AppMethodBeat.o(210345);
    return i;
  }
  
  protected final int ib(int paramInt)
  {
    return paramInt / this.cZM;
  }
  
  protected final int ic(int paramInt)
  {
    return paramInt / this.cZQ;
  }
  
  protected final int id(int paramInt)
  {
    return this.cZM * paramInt;
  }
  
  protected final int ie(int paramInt)
  {
    return this.cZQ * paramInt;
  }
  
  protected final Object jdMethod_if(int paramInt)
  {
    AppMethodBeat.i(210350);
    AppMethodBeat.o(210350);
    return Integer.valueOf(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.source.i.b
 * JD-Core Version:    0.7.0.1
 */