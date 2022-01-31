package com.tencent.mm.ai;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bd;

final class k$1
  implements m.b
{
  k$1(k paramk) {}
  
  public final void a(int paramInt, m paramm, Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof String))) {
      y.i("MicroMsg.ReportLocation", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramm, paramObject });
    }
    while ((!this.egx.userName.equals((String)paramObject)) || (this.egx.egr != 1)) {
      return;
    }
    y.i("MicroMsg.ReportLocation", "contactStgUpdate, %s", new Object[] { this.egx.userName });
    this.egx.lj(this.egx.userName);
    ((j)g.r(j.class)).Fw().b(this.egx.egw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ai.k.1
 * JD-Core Version:    0.7.0.1
 */