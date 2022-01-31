package com.google.android.gms.common.data;

import java.util.NoSuchElementException;

public class zzg<T>
  extends zzb<T>
{
  private T zzaEe;
  
  public zzg(DataBuffer<T> paramDataBuffer)
  {
    super(paramDataBuffer);
  }
  
  public T next()
  {
    if (!hasNext())
    {
      int i = this.zzaDJ;
      throw new NoSuchElementException(46 + "Cannot advance the iterator beyond " + i);
    }
    this.zzaDJ += 1;
    if (this.zzaDJ == 0)
    {
      this.zzaEe = this.zzaDI.get(0);
      if (!(this.zzaEe instanceof zzc))
      {
        String str = String.valueOf(this.zzaEe.getClass());
        throw new IllegalStateException(String.valueOf(str).length() + 44 + "DataBuffer reference of type " + str + " is not movable");
      }
    }
    else
    {
      ((zzc)this.zzaEe).zzcG(this.zzaDJ);
    }
    return this.zzaEe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.common.data.zzg
 * JD-Core Version:    0.7.0.1
 */