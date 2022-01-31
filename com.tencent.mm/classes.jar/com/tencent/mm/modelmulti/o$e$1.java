package com.tencent.mm.modelmulti;

import com.tencent.mm.ah.f;
import com.tencent.mm.h.a.ln;
import com.tencent.mm.h.a.qt;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.azg;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;

final class o$e$1
  implements o.b
{
  o$e$1(o.e parame, azg paramazg, int paramInt) {}
  
  public final boolean iU(int paramInt)
  {
    g.DQ();
    g.DP().Dz().o(8196, Long.valueOf(this.eua.sFD));
    boolean bool;
    if ((this.eua.sFD & this.euc.selector) != 0)
    {
      bool = true;
      y.i("MicroMsg.SyncService", "%s onFinishCmd ContinueFlag:%s canCont:%s SNSSYNCKEY:%s", new Object[] { this.euc, Integer.valueOf(this.eua.sFD), Boolean.valueOf(bool), Integer.valueOf(this.eua.sFD & 0x100) });
      Object localObject;
      if ((!bool) && ((this.eua.sFD & 0x100) != 0))
      {
        localObject = new qt();
        a.udP.m((b)localObject);
      }
      if ((!bool) && ((this.eua.sFD & 0x200000) != 0))
      {
        localObject = new ln();
        a.udP.m((b)localObject);
      }
      if (bool)
      {
        if ((paramInt != 0) || (!this.euc.etY)) {
          break label257;
        }
        y.w("MicroMsg.SyncService", "%s onFinishCmd is continue Sync , but no Cmd , I will not continue again.", new Object[] { this.euc });
      }
    }
    for (;;)
    {
      this.euc.etX.onSceneEnd(0, 0, "", this.euc);
      o.a(this.euc.etN, this.euc);
      WXHardCoderJNI.stopPerformace(WXHardCoderJNI.hcReceiveMsgEnable, this.eub);
      return true;
      bool = false;
      break;
      label257:
      o.a(this.euc.etN, this.euc.scene, this.euc.selector);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelmulti.o.e.1
 * JD-Core Version:    0.7.0.1
 */