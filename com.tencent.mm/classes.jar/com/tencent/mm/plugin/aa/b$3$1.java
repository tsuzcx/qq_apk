package com.tencent.mm.plugin.aa;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.aa.a.i;
import com.tencent.mm.plugin.aa.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.vending.g.d.a;

final class b$3$1
  implements d.a
{
  b$3$1(b.3 param3, j paramj) {}
  
  public final void aX(Object paramObject)
  {
    AppMethodBeat.i(40577);
    if ((paramObject instanceof String)) {
      Toast.makeText(ah.getContext(), paramObject.toString(), 0).show();
    }
    for (;;)
    {
      this.gmZ.aoS().aoR();
      AppMethodBeat.o(40577);
      return;
      ab.e("MicroMsg.SubCoreAA", "close aa failed: %s", new Object[] { paramObject });
      Toast.makeText(ah.getContext(), 2131298418, 1).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.b.3.1
 * JD-Core Version:    0.7.0.1
 */