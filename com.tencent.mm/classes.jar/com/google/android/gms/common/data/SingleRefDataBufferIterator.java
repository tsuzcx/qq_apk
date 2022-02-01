package com.google.android.gms.common.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.NoSuchElementException;

public class SingleRefDataBufferIterator<T>
  extends DataBufferIterator<T>
{
  private T zzoj;
  
  public SingleRefDataBufferIterator(DataBuffer<T> paramDataBuffer)
  {
    super(paramDataBuffer);
  }
  
  public T next()
  {
    AppMethodBeat.i(11664);
    if (!hasNext())
    {
      int i = this.mPosition;
      localObject = new NoSuchElementException(46 + "Cannot advance the iterator beyond " + i);
      AppMethodBeat.o(11664);
      throw ((Throwable)localObject);
    }
    this.mPosition += 1;
    if (this.mPosition == 0)
    {
      this.zzoj = this.mDataBuffer.get(0);
      if (!(this.zzoj instanceof DataBufferRef))
      {
        localObject = String.valueOf(this.zzoj.getClass());
        localObject = new IllegalStateException(String.valueOf(localObject).length() + 44 + "DataBuffer reference of type " + (String)localObject + " is not movable");
        AppMethodBeat.o(11664);
        throw ((Throwable)localObject);
      }
    }
    else
    {
      ((DataBufferRef)this.zzoj).setDataRow(this.mPosition);
    }
    Object localObject = this.zzoj;
    AppMethodBeat.o(11664);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.common.data.SingleRefDataBufferIterator
 * JD-Core Version:    0.7.0.1
 */