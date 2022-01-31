package com.tencent.mm.plugin.extqlauncher;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

final class b$1
  implements n.b
{
  b$1(b paramb) {}
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(20473);
    ab.d("MicroMsg.SubCoreExtQLauncher", "onNotifyChange");
    if (this.mgf.mfW)
    {
      AppMethodBeat.o(20473);
      return;
    }
    aw.aaz();
    if (paramn != c.YF())
    {
      AppMethodBeat.o(20473);
      return;
    }
    if ((paramn == null) || (paramObject == null))
    {
      ab.e("MicroMsg.SubCoreExtQLauncher", "onConversationChange, wrong args");
      AppMethodBeat.o(20473);
      return;
    }
    if ((ah.getContext() == null) || (!aw.RG()))
    {
      ab.w("MicroMsg.SubCoreExtQLauncher", "wrong account status");
      AppMethodBeat.o(20473);
      return;
    }
    this.mgf.btU();
    AppMethodBeat.o(20473);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.extqlauncher.b.1
 * JD-Core Version:    0.7.0.1
 */