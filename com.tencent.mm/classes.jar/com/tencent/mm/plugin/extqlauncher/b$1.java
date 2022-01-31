package com.tencent.mm.plugin.extqlauncher;

import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

final class b$1
  implements m.b
{
  b$1(b paramb) {}
  
  public final void a(int paramInt, m paramm, Object paramObject)
  {
    y.d("MicroMsg.SubCoreExtQLauncher", "onNotifyChange");
    if (this.jMb.jLS) {}
    do
    {
      return;
      au.Hx();
    } while (paramm != c.FB());
    if ((paramm == null) || (paramObject == null))
    {
      y.e("MicroMsg.SubCoreExtQLauncher", "onConversationChange, wrong args");
      return;
    }
    if ((ae.getContext() == null) || (!au.DK()))
    {
      y.w("MicroMsg.SubCoreExtQLauncher", "wrong account status");
      return;
    }
    this.jMb.aNR();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.extqlauncher.b.1
 * JD-Core Version:    0.7.0.1
 */