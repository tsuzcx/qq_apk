package com.tencent.mm.co;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h<T>
{
  private c<T> RwV;
  private volatile T mInstance;
  private byte[] mLock;
  
  public h(c<T> paramc)
  {
    AppMethodBeat.i(133554);
    this.mLock = new byte[0];
    this.RwV = paramc;
    AppMethodBeat.o(133554);
  }
  
  public final T get()
  {
    AppMethodBeat.i(133555);
    if (this.mInstance == null) {}
    synchronized (this.mLock)
    {
      if (this.mInstance == null) {
        this.mInstance = this.RwV.get();
      }
      ??? = this.mInstance;
      AppMethodBeat.o(133555);
      return ???;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.co.h
 * JD-Core Version:    0.7.0.1
 */