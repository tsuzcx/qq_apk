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
    AppMethodBeat.i(60498);
    ((AbstractDataBuffer)getResult()).close();
    AppMethodBeat.o(60498);
  }
  
  public T get(int paramInt)
  {
    AppMethodBeat.i(60496);
    Object localObject = ((AbstractDataBuffer)getResult()).get(paramInt);
    AppMethodBeat.o(60496);
    return localObject;
  }
  
  public int getCount()
  {
    AppMethodBeat.i(60495);
    int i = ((AbstractDataBuffer)getResult()).getCount();
    AppMethodBeat.o(60495);
    return i;
  }
  
  public Bundle getMetadata()
  {
    AppMethodBeat.i(60497);
    Bundle localBundle = ((AbstractDataBuffer)getResult()).getMetadata();
    AppMethodBeat.o(60497);
    return localBundle;
  }
  
  public boolean isClosed()
  {
    AppMethodBeat.i(60499);
    boolean bool = ((AbstractDataBuffer)getResult()).isClosed();
    AppMethodBeat.o(60499);
    return bool;
  }
  
  public Iterator<T> iterator()
  {
    AppMethodBeat.i(60500);
    Iterator localIterator = ((AbstractDataBuffer)getResult()).iterator();
    AppMethodBeat.o(60500);
    return localIterator;
  }
  
  public void release()
  {
    AppMethodBeat.i(60502);
    ((AbstractDataBuffer)getResult()).release();
    AppMethodBeat.o(60502);
  }
  
  public Iterator<T> singleRefIterator()
  {
    AppMethodBeat.i(60501);
    Iterator localIterator = ((AbstractDataBuffer)getResult()).singleRefIterator();
    AppMethodBeat.o(60501);
    return localIterator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.common.api.DataBufferResponse
 * JD-Core Version:    0.7.0.1
 */