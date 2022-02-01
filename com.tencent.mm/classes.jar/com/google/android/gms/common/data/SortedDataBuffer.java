package com.google.android.gms.common.data;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public final class SortedDataBuffer<T>
  implements DataBuffer<T>
{
  private final DataBuffer<T> zzok;
  private final Integer[] zzol;
  
  public SortedDataBuffer(DataBuffer<T> paramDataBuffer, Comparator<T> paramComparator)
  {
    AppMethodBeat.i(11665);
    this.zzok = paramDataBuffer;
    this.zzol = new Integer[paramDataBuffer.getCount()];
    int i = 0;
    while (i < this.zzol.length)
    {
      this.zzol[i] = Integer.valueOf(i);
      i += 1;
    }
    Arrays.sort(this.zzol, new zzb(this, paramComparator));
    AppMethodBeat.o(11665);
  }
  
  public final void close()
  {
    AppMethodBeat.i(11669);
    this.zzok.release();
    AppMethodBeat.o(11669);
  }
  
  public final T get(int paramInt)
  {
    AppMethodBeat.i(11666);
    Object localObject = this.zzok.get(this.zzol[paramInt].intValue());
    AppMethodBeat.o(11666);
    return localObject;
  }
  
  public final int getCount()
  {
    return this.zzol.length;
  }
  
  public final Bundle getMetadata()
  {
    AppMethodBeat.i(11668);
    Bundle localBundle = this.zzok.getMetadata();
    AppMethodBeat.o(11668);
    return localBundle;
  }
  
  public final boolean isClosed()
  {
    AppMethodBeat.i(11670);
    boolean bool = this.zzok.isClosed();
    AppMethodBeat.o(11670);
    return bool;
  }
  
  public final Iterator<T> iterator()
  {
    AppMethodBeat.i(11671);
    DataBufferIterator localDataBufferIterator = new DataBufferIterator(this);
    AppMethodBeat.o(11671);
    return localDataBufferIterator;
  }
  
  public final void release()
  {
    AppMethodBeat.i(11667);
    this.zzok.release();
    AppMethodBeat.o(11667);
  }
  
  public final Iterator<T> singleRefIterator()
  {
    AppMethodBeat.i(11672);
    Iterator localIterator = iterator();
    AppMethodBeat.o(11672);
    return localIterator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.common.data.SortedDataBuffer
 * JD-Core Version:    0.7.0.1
 */