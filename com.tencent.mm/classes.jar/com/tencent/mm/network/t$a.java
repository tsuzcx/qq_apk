package com.tencent.mm.network;

import com.tencent.mars.comm.WakerLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.bo;

final class t$a
  extends j.a
  implements l
{
  private t dYA;
  private WakerLock ged;
  private int gee = 0;
  
  public t$a(t paramt, WakerLock paramWakerLock)
  {
    this.dYA = paramt;
    this.ged = paramWakerLock;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, r paramr, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(58567);
    if ((paramr.getType() == 252) || (paramr.getType() == 701))
    {
      ab.d("MicroMsg.MMAutoAuth", "summerauth IOnAutoAuth onGYNetEnd manual auth");
      if ((paramr.adP().getRetCode() != 0) || (paramInt2 != 0)) {
        break label233;
      }
      if (paramr.adQ() != 2) {
        break label213;
      }
      e.qrI.idkeyStat(148L, 28L, 1L, false);
      this.gee += 1;
      if (this.gee <= 1) {
        break label200;
      }
      ab.w("MicroMsg.MMAutoAuth", "summerauth manualLoginDecodeFailedTry beyond 1 no more try!");
      this.dYA.j(paramInt2, paramInt3, "auth_decode_failed_" + bo.bf(paramString, ""));
    }
    while ((paramr.adP().getRetCode() != 0) || (paramInt2 != 0)) {
      if (-102 == paramInt3)
      {
        this.dYA.gdD = paramInt1;
        paramr.a(this.dYA.gdz, this.dYA.gdB, 0, 0);
        AppMethodBeat.o(58567);
        return;
        label200:
        paramr.a(this, 0, 0);
        continue;
        label213:
        this.gee = 0;
        paramr.a(this, paramInt2, paramInt3, paramString);
        continue;
        label233:
        paramArrayOfByte = e.qrI;
        if (-102 == paramInt3) {}
        for (long l = 30L;; l = 29L)
        {
          paramArrayOfByte.idkeyStat(148L, l, 1L, false);
          break;
        }
      }
      else
      {
        if (-301 == paramInt3) {
          paramr.a(this, paramInt2, paramInt3, paramString);
        }
        for (;;)
        {
          this.dYA.j(paramInt2, paramInt3, "autoauth_errmsg_" + bo.bf(paramString, ""));
          AppMethodBeat.o(58567);
          return;
          if (-105 == paramInt3) {
            paramr.a(this, paramInt2, paramInt3, paramString);
          } else if (-17 == paramInt3) {
            paramr.a(this, paramInt2, paramInt3, paramString);
          }
        }
      }
    }
    paramr.a(this, paramInt2, paramInt3, paramString);
    AppMethodBeat.o(58567);
  }
  
  public final void a(r paramr, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(58566);
    this.ged.lock(1000L, "MMAutoAuth.IOnAutoAuth.onAutoAuth");
    new t.a.1(this, paramr, paramInt1, paramInt2, paramString).b(this.dYA.handler);
    AppMethodBeat.o(58566);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.network.t.a
 * JD-Core Version:    0.7.0.1
 */