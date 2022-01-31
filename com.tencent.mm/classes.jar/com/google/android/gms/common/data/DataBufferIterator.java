package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DataBufferIterator<T>
  implements Iterator<T>
{
  protected final DataBuffer<T> mDataBuffer;
  protected int mPosition;
  
  public DataBufferIterator(DataBuffer<T> paramDataBuffer)
  {
    AppMethodBeat.i(61035);
    this.mDataBuffer = ((DataBuffer)Preconditions.checkNotNull(paramDataBuffer));
    this.mPosition = -1;
    AppMethodBeat.o(61035);
  }
  
  public boolean hasNext()
  {
    AppMethodBeat.i(61036);
    if (this.mPosition < this.mDataBuffer.getCount() - 1)
    {
      AppMethodBeat.o(61036);
      return true;
    }
    AppMethodBeat.o(61036);
    return false;
  }
  
  public T next()
  {
    AppMethodBeat.i(61037);
    if (!hasNext())
    {
      i = this.mPosition;
      localObject = new NoSuchElementException(46 + "Cannot advance the iterator beyond " + i);
      AppMethodBeat.o(61037);
      throw ((Throwable)localObject);
    }
    Object localObject = this.mDataBuffer;
    int i = this.mPosition + 1;
    this.mPosition = i;
    localObject = ((DataBuffer)localObject).get(i);
    AppMethodBeat.o(61037);
    return localObject;
  }
  
  public void remove()
  {
    AppMethodBeat.i(61038);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    AppMethodBeat.o(61038);
    throw localUnsupportedOperationException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.common.data.DataBufferIterator
 * JD-Core Version:    0.7.0.1
 */