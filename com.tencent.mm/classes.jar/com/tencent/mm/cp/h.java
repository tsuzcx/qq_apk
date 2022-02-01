package com.tencent.mm.cp;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h<T>
{
  private c<T> agWH;
  private volatile T mInstance;
  private byte[] mLock;
  
  public h(c<T> paramc)
  {
    AppMethodBeat.i(133554);
    this.mLock = new byte[0];
    this.agWH = paramc;
    AppMethodBeat.o(133554);
  }
  
  public final T get()
  {
    AppMethodBeat.i(133555);
    if (this.mInstance == null) {}
    synchronized (this.mLock)
    {
      if (this.mInstance == null) {
        this.mInstance = this.agWH.get();
      }
      ??? = this.mInstance;
      AppMethodBeat.o(133555);
      return ???;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.cp.h
 * JD-Core Version:    0.7.0.1
 */