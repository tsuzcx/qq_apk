package com.tencent.mm.network;

import com.tencent.mars.comm.WakerLock;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.h;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class t$a
  extends j.a
  implements l
{
  private t dhp;
  private WakerLock eOp;
  private int eOq = 0;
  
  public t$a(t paramt, WakerLock paramWakerLock)
  {
    this.dhp = paramt;
    this.eOp = paramWakerLock;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, r paramr, byte[] paramArrayOfByte)
  {
    if (paramr.getType() == 701)
    {
      y.d("MicroMsg.AutoAuth", "summerauth IOnAutoAuth onGYNetEnd manual auth");
      if ((paramr.Ld().Lh() != 0) || (paramInt2 != 0)) {
        break label210;
      }
      if (paramr.Le() != 2) {
        break label190;
      }
      f.nEG.a(148L, 28L, 1L, false);
      this.eOq += 1;
      if (this.eOq <= 1) {
        break label177;
      }
      y.w("MicroMsg.AutoAuth", "summerauth manualLoginDecodeFailedTry beyond 1 no more try!");
      this.dhp.f(paramInt2, paramInt3, "auth_decode_failed_" + bk.aM(paramString, ""));
    }
    while ((paramr.Ld().Lh() != 0) || (paramInt2 != 0)) {
      if (-102 == paramInt3)
      {
        this.dhp.eNP = paramInt1;
        paramr.a(this.dhp.eNL, this.dhp.eNN, 0, 0);
        return;
        label177:
        paramr.a(this, 0, 0);
        continue;
        label190:
        this.eOq = 0;
        paramr.a(this, paramInt2, paramInt3, paramString);
        continue;
        label210:
        paramArrayOfByte = f.nEG;
        if (-102 == paramInt3) {}
        for (long l = 30L;; l = 29L)
        {
          paramArrayOfByte.a(148L, l, 1L, false);
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
          this.dhp.f(paramInt2, paramInt3, "autoauth_errmsg_" + bk.aM(paramString, ""));
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
  }
  
  public final void a(r paramr, int paramInt1, int paramInt2, String paramString)
  {
    this.eOp.lock(1000L, "MMAutoAuth.IOnAutoAuth.onAutoAuth");
    new t.a.1(this, paramr, paramInt1, paramInt2, paramString).b(this.dhp.handler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.network.t.a
 * JD-Core Version:    0.7.0.1
 */