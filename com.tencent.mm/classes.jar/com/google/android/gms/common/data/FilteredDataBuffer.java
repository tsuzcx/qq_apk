package com.google.android.gms.common.data;

import android.os.Bundle;
import com.google.android.gms.common.internal.Asserts;
import java.util.Iterator;

public abstract class FilteredDataBuffer<T>
  implements DataBuffer<T>
{
  protected final DataBuffer<T> mDataBuffer;
  
  public FilteredDataBuffer(DataBuffer<T> paramDataBuffer)
  {
    Asserts.checkNotNull(paramDataBuffer);
    if (!(paramDataBuffer instanceof FilteredDataBuffer)) {}
    for (boolean bool = true;; bool = false)
    {
      Asserts.checkState(bool, "Not possible to have nested FilteredDataBuffers.");
      this.mDataBuffer = paramDataBuffer;
      return;
    }
  }
  
  public void close()
  {
    release();
  }
  
  protected abstract int computeRealPosition(int paramInt);
  
  public T get(int paramInt)
  {
    return this.mDataBuffer.get(computeRealPosition(paramInt));
  }
  
  public Bundle getMetadata()
  {
    return this.mDataBuffer.getMetadata();
  }
  
  @Deprecated
  public boolean isClosed()
  {
    return this.mDataBuffer.isClosed();
  }
  
  public Iterator<T> iterator()
  {
    return new DataBufferIterator(this);
  }
  
  public void release()
  {
    this.mDataBuffer.release();
  }
  
  public Iterator<T> singleRefIterator()
  {
    return iterator();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.common.data.FilteredDataBuffer
 * JD-Core Version:    0.7.0.1
 */