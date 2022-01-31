package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.bs;
import com.tencent.mm.h.a.bs.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.c.d;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.y;

public final class b
  extends c<bs>
  implements f
{
  private bs kkW;
  private boolean kkX = false;
  
  public b()
  {
    this.udX = bs.class.getName().hashCode();
  }
  
  private boolean a(bs parambs)
  {
    if (!g.DK()) {
      y.e("MicroMsg.CloseFingerPrintEventListener", "CloseFingerPrintEvent account is not ready");
    }
    do
    {
      return false;
      this.kkX = false;
    } while (!(parambs instanceof bs));
    this.kkW = parambs;
    y.i("MicroMsg.CloseFingerPrintEventListener", "handle CloseFingerPrintEvent");
    g.DQ();
    g.DO().dJT.a(385, this);
    parambs = new d();
    g.DQ();
    g.DO().dJT.a(parambs, 0);
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramm instanceof d))
    {
      paramm = new bs.a();
      y.i("MicroMsg.CloseFingerPrintEventListener", "NetSceneTenpayCloseTouchPay doscene return errcode " + paramInt2 + " errmsg" + paramString);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label134;
      }
      y.i("MicroMsg.CloseFingerPrintEventListener", "NetSceneTenpayCloseTouchPay doscene is success");
    }
    for (paramm.retCode = 0;; paramm.retCode = paramInt2)
    {
      g.DQ();
      g.DO().dJT.b(385, this);
      this.kkW.bHT = paramm;
      this.kkX = true;
      if (this.kkW.bFJ != null) {
        this.kkW.bFJ.run();
      }
      if (this.kkX) {
        this.kkW = null;
      }
      return;
      label134:
      y.i("MicroMsg.CloseFingerPrintEventListener", "NetSceneTenpayCloseTouchPay doscene is fail");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.b
 * JD-Core Version:    0.7.0.1
 */