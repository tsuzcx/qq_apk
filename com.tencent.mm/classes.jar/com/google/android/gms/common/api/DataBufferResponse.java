package com.google.android.gms.common.api;

import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataBuffer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

@KeepForSdk
public class DataBufferResponse<T, R extends AbstractDataBuffer<T>,  extends Result>
  extends Response<R>
  implements DataBuffer<T>
{
  @KeepForSdk
  public DataBufferResponse() {}
  
  @KeepForSdk
  public DataBufferResponse(R paramR)
  {
    super(paramR);
  }
  
  public void close()
  {
    AppMethodBeat.i(10990);
    ((AbstractDataBuffer)getResult()).close();
    AppMethodBeat.o(10990);
  }
  
  public T get(int paramInt)
  {
    AppMethodBeat.i(10988);
    Object localObject = ((AbstractDataBuffer)getResult()).get(paramInt);
    AppMethodBeat.o(10988);
    return localObject;
  }
  
  public int getCount()
  {
    AppMethodBeat.i(10987);
    int i = ((AbstractDataBuffer)getResult()).getCount();
    AppMethodBeat.o(10987);
    return i;
  }
  
  public Bundle getMetadata()
  {
    AppMethodBeat.i(10989);
    Bundle localBundle = ((AbstractDataBuffer)getResult()).getMetadata();
    AppMethodBeat.o(10989);
    return localBundle;
  }
  
  public boolean isClosed()
  {
    AppMethodBeat.i(10991);
    boolean bool = ((AbstractDataBuffer)getResult()).isClosed();
    AppMethodBeat.o(10991);
    return bool;
  }
  
  public Iterator<T> iterator()
  {
    AppMethodBeat.i(10992);
    Iterator localIterator = ((AbstractDataBuffer)getResult()).iterator();
    AppMethodBeat.o(10992);
    return localIterator;
  }
  
  public void release()
  {
    AppMethodBeat.i(10994);
    ((AbstractDataBuffer)getResult()).release();
    AppMethodBeat.o(10994);
  }
  
  public Iterator<T> singleRefIterator()
  {
    AppMethodBeat.i(10993);
    Iterator localIterator = ((AbstractDataBuffer)getResult()).singleRefIterator();
    AppMethodBeat.o(10993);
    return localIterator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.common.api.DataBufferResponse
 * JD-Core Version:    0.7.0.1
 */