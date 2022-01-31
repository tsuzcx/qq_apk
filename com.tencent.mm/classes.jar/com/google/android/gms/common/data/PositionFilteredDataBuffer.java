package com.google.android.gms.common.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashSet;

public final class PositionFilteredDataBuffer<T>
  extends FilteredDataBuffer<T>
{
  private final ArrayList<Integer> zzob;
  private final HashSet<Integer> zzoe;
  
  public PositionFilteredDataBuffer(AbstractDataBuffer<T> paramAbstractDataBuffer)
  {
    super(paramAbstractDataBuffer);
    AppMethodBeat.i(61162);
    this.zzoe = new HashSet();
    this.zzob = new ArrayList();
    zzcl();
    AppMethodBeat.o(61162);
  }
  
  private final void zzcl()
  {
    AppMethodBeat.i(61168);
    this.zzob.clear();
    int i = 0;
    int j = this.mDataBuffer.getCount();
    while (i < j)
    {
      if (!this.zzoe.contains(Integer.valueOf(i))) {
        this.zzob.add(Integer.valueOf(i));
      }
      i += 1;
    }
    AppMethodBeat.o(61168);
  }
  
  public final void clearFilters()
  {
    AppMethodBeat.i(61167);
    this.zzoe.clear();
    zzcl();
    AppMethodBeat.o(61167);
  }
  
  public final int computeRealPosition(int paramInt)
  {
    AppMethodBeat.i(61164);
    if ((paramInt < 0) || (paramInt >= getCount()))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException(53 + "Position " + paramInt + " is out of bounds for this buffer");
      AppMethodBeat.o(61164);
      throw localIllegalArgumentException;
    }
    paramInt = ((Integer)this.zzob.get(paramInt)).intValue();
    AppMethodBeat.o(61164);
    return paramInt;
  }
  
  public final void filterOut(int paramInt)
  {
    AppMethodBeat.i(61165);
    if ((paramInt >= 0) && (paramInt <= this.mDataBuffer.getCount()))
    {
      this.zzoe.add(Integer.valueOf(paramInt));
      zzcl();
    }
    AppMethodBeat.o(61165);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(61163);
    int i = this.mDataBuffer.getCount();
    int j = this.zzoe.size();
    AppMethodBeat.o(61163);
    return i - j;
  }
  
  public final void unfilter(int paramInt)
  {
    AppMethodBeat.i(61166);
    this.zzoe.remove(Integer.valueOf(paramInt));
    zzcl();
    AppMethodBeat.o(61166);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.data.PositionFilteredDataBuffer
 * JD-Core Version:    0.7.0.1
 */