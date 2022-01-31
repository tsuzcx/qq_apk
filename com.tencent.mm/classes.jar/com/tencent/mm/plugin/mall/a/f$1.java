package com.tencent.mm.plugin.mall.a;

import com.tencent.mm.ah.e.a;
import com.tencent.mm.model.bx.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

final class f$1
  implements bx.a
{
  f$1(f paramf) {}
  
  public final void a(e.a parama)
  {
    parama = aa.a(parama.dBs.svH);
    y.d("MicroMsg.SubCoreMall", "WalletNotifyConfXml:" + parama);
    f.a(this.lYv).post(new f.1.1(this, parama));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.f.1
 * JD-Core Version:    0.7.0.1
 */