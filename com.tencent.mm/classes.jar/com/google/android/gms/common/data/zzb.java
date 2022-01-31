package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.zzac;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class zzb<T>
  implements Iterator<T>
{
  protected final DataBuffer<T> zzaDI;
  protected int zzaDJ;
  
  public zzb(DataBuffer<T> paramDataBuffer)
  {
    this.zzaDI = ((DataBuffer)zzac.zzw(paramDataBuffer));
    this.zzaDJ = -1;
  }
  
  public boolean hasNext()
  {
    return this.zzaDJ < this.zzaDI.getCount() - 1;
  }
  
  public T next()
  {
    if (!hasNext())
    {
      i = this.zzaDJ;
      throw new NoSuchElementException(46 + "Cannot advance the iterator beyond " + i);
    }
    DataBuffer localDataBuffer = this.zzaDI;
    int i = this.zzaDJ + 1;
    this.zzaDJ = i;
    return localDataBuffer.get(i);
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.common.data.zzb
 * JD-Core Version:    0.7.0.1
 */