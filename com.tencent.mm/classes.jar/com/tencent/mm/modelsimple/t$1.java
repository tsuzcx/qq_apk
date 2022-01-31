package com.tencent.mm.modelsimple;

import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;

final class t$1
  implements Runnable
{
  t$1(t paramt, bi parambi) {}
  
  public final void run()
  {
    y.i("MicroMsg.NetSceneRevokeMsg", "delete invoke message! msg:%s", new Object[] { Long.valueOf(this.dUH.field_msgId) });
    this.dUH.setType(10002);
    t.a(t.a(this.eAi), "", this.dUH, "");
    au.Hx();
    c.Fy().a(this.dUH.field_msgId, this.dUH);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.modelsimple.t.1
 * JD-Core Version:    0.7.0.1
 */