package com.tencent.mm.plugin.emoji.e;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.dh;
import com.tencent.mm.g.a.dh.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;

final class b$11
  extends c<dh>
{
  b$11(b paramb)
  {
    AppMethodBeat.i(161078);
    this.__eventId = dh.class.getName().hashCode();
    AppMethodBeat.o(161078);
  }
  
  private static boolean a(dh paramdh)
  {
    AppMethodBeat.i(108408);
    if ((paramdh != null) && ((paramdh instanceof dh)))
    {
      boolean bool = paramdh.dph.enable;
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.ILa, Boolean.valueOf(bool));
      k.cik().pJV = bool;
      if (bool) {
        break label95;
      }
      com.tencent.mm.plugin.report.service.g.yxI.f(12953, new Object[] { Integer.valueOf(2), "" });
      Toast.makeText(ak.getContext(), 2131758240, 0).show();
    }
    for (;;)
    {
      AppMethodBeat.o(108408);
      return false;
      label95:
      Toast.makeText(ak.getContext(), 2131758242, 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.b.11
 * JD-Core Version:    0.7.0.1
 */