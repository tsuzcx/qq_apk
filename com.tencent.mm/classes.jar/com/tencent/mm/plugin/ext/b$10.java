package com.tencent.mm.plugin.ext;

import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.y;

final class b$10
  implements m.b
{
  b$10(b paramb) {}
  
  public final void a(int paramInt, m paramm, Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof String))) {
      y.d("MicroMsg.SubCoreExt", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramm, paramObject });
    }
    do
    {
      return;
      if (!au.DK())
      {
        y.i("MicroMsg.SubCoreExt", "onNotifyChange acc not ready");
        return;
      }
      au.Hx();
    } while (paramm != c.Fw());
    b.d(this.jJF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.b.10
 * JD-Core Version:    0.7.0.1
 */