package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum o$a
{
  public final int bKp;
  
  static
  {
    AppMethodBeat.i(135548);
    kMd = new a("ReasonInterrupted", 0, 0);
    kMe = new a("ReasonManual", 1, 1);
    kMf = new a("ReasonDevice", 2, 2);
    kMg = new a("ReasonInCommingCall", 3, 3);
    kMh = new a("ReasonSessionUpdateFailed", 4, 4);
    kMi = new a("ReasonWeappEnterBackground", 5, 5);
    kMj = new a("ReasonUnknown", 6, 100);
    kMk = new a[] { kMd, kMe, kMf, kMg, kMh, kMi, kMj };
    AppMethodBeat.o(135548);
  }
  
  private o$a(int paramInt)
  {
    this.bKp = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.o.a
 * JD-Core Version:    0.7.0.1
 */