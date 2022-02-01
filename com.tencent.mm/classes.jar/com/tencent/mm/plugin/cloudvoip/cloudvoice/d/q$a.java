package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum q$a
{
  public final int cOr;
  
  static
  {
    AppMethodBeat.i(90891);
    tTw = new a("ReasonInterrupted", 0, 0);
    tTx = new a("ReasonManual", 1, 1);
    tTy = new a("ReasonDevice", 2, 2);
    tTz = new a("ReasonInCommingCall", 3, 3);
    tTA = new a("ReasonSessionUpdateFailed", 4, 4);
    tTB = new a("ReasonWeappEnterBackground", 5, 5);
    tTC = new a("ReasonWeappStopFromPassiveFloatBall", 6, 6);
    tTD = new a("ReasonUnknown", 7, 100);
    tTE = new a[] { tTw, tTx, tTy, tTz, tTA, tTB, tTC, tTD };
    AppMethodBeat.o(90891);
  }
  
  private q$a(int paramInt)
  {
    this.cOr = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.a
 * JD-Core Version:    0.7.0.1
 */