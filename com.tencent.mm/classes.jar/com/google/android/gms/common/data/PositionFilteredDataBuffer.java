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
    AppMethodBeat.i(11654);
    this.zzoe = new HashSet();
    this.zzob = new ArrayList();
    zzcl();
    AppMethodBeat.o(11654);
  }
  
  private final void zzcl()
  {
    AppMethodBeat.i(11660);
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
    AppMethodBeat.o(11660);
  }
  
  public final void clearFilters()
  {
    AppMethodBeat.i(11659);
    this.zzoe.clear();
    zzcl();
    AppMethodBeat.o(11659);
  }
  
  public final int computeRealPosition(int paramInt)
  {
    AppMethodBeat.i(11656);
    if ((paramInt < 0) || (paramInt >= getCount()))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException(53 + "Position " + paramInt + " is out of bounds for this buffer");
      AppMethodBeat.o(11656);
      throw localIllegalArgumentException;
    }
    paramInt = ((Integer)this.zzob.get(paramInt)).intValue();
    AppMethodBeat.o(11656);
    return paramInt;
  }
  
  public final void filterOut(int paramInt)
  {
    AppMethodBeat.i(11657);
    if ((paramInt >= 0) && (paramInt <= this.mDataBuffer.getCount()))
    {
      this.zzoe.add(Integer.valueOf(paramInt));
      zzcl();
    }
    AppMethodBeat.o(11657);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(11655);
    int i = this.mDataBuffer.getCount();
    int j = this.zzoe.size();
    AppMethodBeat.o(11655);
    return i - j;
  }
  
  public final void unfilter(int paramInt)
  {
    AppMethodBeat.i(11658);
    this.zzoe.remove(Integer.valueOf(paramInt));
    zzcl();
    AppMethodBeat.o(11658);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.data.PositionFilteredDataBuffer
 * JD-Core Version:    0.7.0.1
 */