package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum p$a
{
  public final int cof;
  
  static
  {
    AppMethodBeat.i(90891);
    ovH = new a("ReasonInterrupted", 0, 0);
    ovI = new a("ReasonManual", 1, 1);
    ovJ = new a("ReasonDevice", 2, 2);
    ovK = new a("ReasonInCommingCall", 3, 3);
    ovL = new a("ReasonSessionUpdateFailed", 4, 4);
    ovM = new a("ReasonWeappEnterBackground", 5, 5);
    ovN = new a("ReasonWeappStopFromPassiveFloatBall", 6, 6);
    ovO = new a("ReasonUnknown", 7, 100);
    ovP = new a[] { ovH, ovI, ovJ, ovK, ovL, ovM, ovN, ovO };
    AppMethodBeat.o(90891);
  }
  
  private p$a(int paramInt)
  {
    this.cof = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.p.a
 * JD-Core Version:    0.7.0.1
 */