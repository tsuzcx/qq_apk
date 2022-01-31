package com.google.android.gms.common.data;

import android.os.Bundle;
import java.util.Iterator;

public abstract class AbstractDataBuffer<T>
  implements DataBuffer<T>
{
  public final DataHolder zzaBi;
  
  protected AbstractDataBuffer(DataHolder paramDataHolder)
  {
    this.zzaBi = paramDataHolder;
  }
  
  @Deprecated
  public final void close()
  {
    release();
  }
  
  public abstract T get(int paramInt);
  
  public int getCount()
  {
    if (this.zzaBi == null) {
      return 0;
    }
    return this.zzaBi.getCount();
  }
  
  @Deprecated
  public boolean isClosed()
  {
    return (this.zzaBi == null) || (this.zzaBi.isClosed());
  }
  
  public Iterator<T> iterator()
  {
    return new zzb(this);
  }
  
  public void release()
  {
    if (this.zzaBi != null) {
      this.zzaBi.close();
    }
  }
  
  public Iterator<T> singleRefIterator()
  {
    return new zzg(this);
  }
  
  public Bundle zzxf()
  {
    return this.zzaBi.zzxf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.data.AbstractDataBuffer
 * JD-Core Version:    0.7.0.1
 */