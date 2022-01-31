package com.google.android.gms.common.data;

import java.util.HashSet;
import java.util.Iterator;

public final class DataBufferObserverSet
  implements DataBufferObserver, DataBufferObserver.Observable
{
  private HashSet<DataBufferObserver> zzaDK = new HashSet();
  
  public final void addObserver(DataBufferObserver paramDataBufferObserver)
  {
    this.zzaDK.add(paramDataBufferObserver);
  }
  
  public final void clear()
  {
    this.zzaDK.clear();
  }
  
  public final boolean hasObservers()
  {
    return !this.zzaDK.isEmpty();
  }
  
  public final void onDataChanged()
  {
    Iterator localIterator = this.zzaDK.iterator();
    while (localIterator.hasNext()) {
      ((DataBufferObserver)localIterator.next()).onDataChanged();
    }
  }
  
  public final void onDataRangeChanged(int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.zzaDK.iterator();
    while (localIterator.hasNext()) {
      ((DataBufferObserver)localIterator.next()).onDataRangeChanged(paramInt1, paramInt2);
    }
  }
  
  public final void onDataRangeInserted(int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.zzaDK.iterator();
    while (localIterator.hasNext()) {
      ((DataBufferObserver)localIterator.next()).onDataRangeInserted(paramInt1, paramInt2);
    }
  }
  
  public final void onDataRangeMoved(int paramInt1, int paramInt2, int paramInt3)
  {
    Iterator localIterator = this.zzaDK.iterator();
    while (localIterator.hasNext()) {
      ((DataBufferObserver)localIterator.next()).onDataRangeMoved(paramInt1, paramInt2, paramInt3);
    }
  }
  
  public final void onDataRangeRemoved(int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.zzaDK.iterator();
    while (localIterator.hasNext()) {
      ((DataBufferObserver)localIterator.next()).onDataRangeRemoved(paramInt1, paramInt2);
    }
  }
  
  public final void removeObserver(DataBufferObserver paramDataBufferObserver)
  {
    this.zzaDK.remove(paramDataBufferObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.common.data.DataBufferObserverSet
 * JD-Core Version:    0.7.0.1
 */