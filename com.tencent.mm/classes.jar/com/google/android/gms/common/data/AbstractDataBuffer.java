package com.google.android.gms.common.data;

import android.os.Bundle;
import java.util.Iterator;

public abstract class AbstractDataBuffer<T>
  implements DataBuffer<T>
{
  protected final DataHolder mDataHolder;
  
  protected AbstractDataBuffer(DataHolder paramDataHolder)
  {
    this.mDataHolder = paramDataHolder;
  }
  
  @Deprecated
  public final void close()
  {
    release();
  }
  
  public abstract T get(int paramInt);
  
  public int getCount()
  {
    if (this.mDataHolder == null) {
      return 0;
    }
    return this.mDataHolder.getCount();
  }
  
  public Bundle getMetadata()
  {
    return this.mDataHolder.getMetadata();
  }
  
  @Deprecated
  public boolean isClosed()
  {
    return (this.mDataHolder == null) || (this.mDataHolder.isClosed());
  }
  
  public Iterator<T> iterator()
  {
    return new DataBufferIterator(this);
  }
  
  public void release()
  {
    if (this.mDataHolder != null) {
      this.mDataHolder.close();
    }
  }
  
  public Iterator<T> singleRefIterator()
  {
    return new SingleRefDataBufferIterator(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.data.AbstractDataBuffer
 * JD-Core Version:    0.7.0.1
 */