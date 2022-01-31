package com.tencent.mm.network;

import com.tencent.mars.comm.WakerLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bj;

final class t$b
  extends j.a
  implements l
{
  private t dYA;
  private WakerLock ged;
  
  public t$b(t paramt, WakerLock paramWakerLock)
  {
    this.dYA = paramt;
    this.ged = paramWakerLock;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, r paramr, byte[] paramArrayOfByte) {}
  
  public final void a(r paramr, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(58569);
    this.ged.lock(1000L, "MMAutoAuth.IOnGetCert.onAutoAuth");
    new t.b.1(this, paramr, paramInt1, paramInt2).b(this.dYA.handler);
    AppMethodBeat.o(58569);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.network.t.b
 * JD-Core Version:    0.7.0.1
 */