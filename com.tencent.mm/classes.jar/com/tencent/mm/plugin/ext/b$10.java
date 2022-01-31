package com.tencent.mm.plugin.ext;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;

final class b$10
  implements n.b
{
  b$10(b paramb) {}
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(20269);
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      ab.d("MicroMsg.SubCoreExt", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
      AppMethodBeat.o(20269);
      return;
    }
    if (!aw.RG())
    {
      ab.i("MicroMsg.SubCoreExt", "onNotifyChange acc not ready");
      AppMethodBeat.o(20269);
      return;
    }
    aw.aaz();
    if (paramn == c.YA()) {
      b.d(this.mdJ);
    }
    AppMethodBeat.o(20269);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.b.10
 * JD-Core Version:    0.7.0.1
 */