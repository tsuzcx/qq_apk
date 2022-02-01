package com.google.android.gms.common.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Iterator;

public final class DataBufferObserverSet
  implements DataBufferObserver, DataBufferObserver.Observable
{
  private HashSet<DataBufferObserver> zzni;
  
  public DataBufferObserverSet()
  {
    AppMethodBeat.i(11531);
    this.zzni = new HashSet();
    AppMethodBeat.o(11531);
  }
  
  public final void addObserver(DataBufferObserver paramDataBufferObserver)
  {
    AppMethodBeat.i(11534);
    this.zzni.add(paramDataBufferObserver);
    AppMethodBeat.o(11534);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(11533);
    this.zzni.clear();
    AppMethodBeat.o(11533);
  }
  
  public final boolean hasObservers()
  {
    AppMethodBeat.i(11532);
    if (!this.zzni.isEmpty())
    {
      AppMethodBeat.o(11532);
      return true;
    }
    AppMethodBeat.o(11532);
    return false;
  }
  
  public final void onDataChanged()
  {
    AppMethodBeat.i(11536);
    Iterator localIterator = this.zzni.iterator();
    while (localIterator.hasNext()) {
      ((DataBufferObserver)localIterator.next()).onDataChanged();
    }
    AppMethodBeat.o(11536);
  }
  
  public final void onDataRangeChanged(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(11537);
    Iterator localIterator = this.zzni.iterator();
    while (localIterator.hasNext()) {
      ((DataBufferObserver)localIterator.next()).onDataRangeChanged(paramInt1, paramInt2);
    }
    AppMethodBeat.o(11537);
  }
  
  public final void onDataRangeInserted(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(11538);
    Iterator localIterator = this.zzni.iterator();
    while (localIterator.hasNext()) {
      ((DataBufferObserver)localIterator.next()).onDataRangeInserted(paramInt1, paramInt2);
    }
    AppMethodBeat.o(11538);
  }
  
  public final void onDataRangeMoved(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(11540);
    Iterator localIterator = this.zzni.iterator();
    while (localIterator.hasNext()) {
      ((DataBufferObserver)localIterator.next()).onDataRangeMoved(paramInt1, paramInt2, paramInt3);
    }
    AppMethodBeat.o(11540);
  }
  
  public final void onDataRangeRemoved(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(11539);
    Iterator localIterator = this.zzni.iterator();
    while (localIterator.hasNext()) {
      ((DataBufferObserver)localIterator.next()).onDataRangeRemoved(paramInt1, paramInt2);
    }
    AppMethodBeat.o(11539);
  }
  
  public final void removeObserver(DataBufferObserver paramDataBufferObserver)
  {
    AppMethodBeat.i(11535);
    this.zzni.remove(paramDataBufferObserver);
    AppMethodBeat.o(11535);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.common.data.DataBufferObserverSet
 * JD-Core Version:    0.7.0.1
 */