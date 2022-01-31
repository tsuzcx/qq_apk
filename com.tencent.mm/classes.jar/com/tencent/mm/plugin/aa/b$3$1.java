package com.tencent.mm.plugin.aa;

import android.widget.Toast;
import com.tencent.mm.plugin.aa.a.i;
import com.tencent.mm.plugin.aa.a.j;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vending.g.d.a;

final class b$3$1
  implements d.a
{
  b$3$1(b.3 param3, j paramj) {}
  
  public final void aE(Object paramObject)
  {
    if ((paramObject instanceof String)) {
      Toast.makeText(ae.getContext(), paramObject.toString(), 0).show();
    }
    for (;;)
    {
      this.eVc.Vu().Vt();
      return;
      y.e("MicroMsg.SubCoreAA", "close aa failed: %s", new Object[] { paramObject });
      Toast.makeText(ae.getContext(), a.i.close_paylist_failed, 1).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.b.3.1
 * JD-Core Version:    0.7.0.1
 */