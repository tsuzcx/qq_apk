package com.google.android.gms.common.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ShuffleFilteredDataBuffer<T>
  extends FilteredDataBuffer<T>
{
  private final List<Integer> zzoh;
  private final int zzoi;
  
  public ShuffleFilteredDataBuffer(DataBuffer<T> paramDataBuffer, int paramInt)
  {
    super(paramDataBuffer);
    AppMethodBeat.i(11661);
    this.zzoi = paramInt;
    int i = this.zzoi;
    int j = this.mDataBuffer.getCount();
    if (i > j)
    {
      paramDataBuffer = new IllegalArgumentException("numIndexes must be smaller or equal to max");
      AppMethodBeat.o(11661);
      throw paramDataBuffer;
    }
    paramDataBuffer = new ArrayList(j);
    paramInt = 0;
    while (paramInt < j)
    {
      paramDataBuffer.add(Integer.valueOf(paramInt));
      paramInt += 1;
    }
    Collections.shuffle(paramDataBuffer);
    this.zzoh = paramDataBuffer.subList(0, i);
    AppMethodBeat.o(11661);
  }
  
  public final int computeRealPosition(int paramInt)
  {
    AppMethodBeat.i(11663);
    if ((paramInt < 0) || (paramInt >= getCount()))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException(53 + "Position " + paramInt + " is out of bounds for this buffer");
      AppMethodBeat.o(11663);
      throw localIllegalArgumentException;
    }
    paramInt = ((Integer)this.zzoh.get(paramInt)).intValue();
    AppMethodBeat.o(11663);
    return paramInt;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(11662);
    int i = Math.min(this.zzoi, this.mDataBuffer.getCount());
    AppMethodBeat.o(11662);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.data.ShuffleFilteredDataBuffer
 * JD-Core Version:    0.7.0.1
 */