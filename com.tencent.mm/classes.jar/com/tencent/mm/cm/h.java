package com.tencent.mm.cm;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h<T>
{
  private c<T> AZy;
  private byte[] eFQ;
  private volatile T mInstance;
  
  public h(c<T> paramc)
  {
    AppMethodBeat.i(59239);
    this.eFQ = new byte[0];
    this.AZy = paramc;
    AppMethodBeat.o(59239);
  }
  
  public final T get()
  {
    AppMethodBeat.i(59240);
    if (this.mInstance == null) {}
    synchronized (this.eFQ)
    {
      if (this.mInstance == null) {
        this.mInstance = this.AZy.get();
      }
      ??? = this.mInstance;
      AppMethodBeat.o(59240);
      return ???;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.cm.h
 * JD-Core Version:    0.7.0.1
 */