package com.tencent.mm.plugin.emoji.e;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.dd;
import com.tencent.mm.g.a.dd.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;

final class b$11
  extends c<dd>
{
  b$11(b paramb)
  {
    AppMethodBeat.i(161078);
    this.__eventId = dd.class.getName().hashCode();
    AppMethodBeat.o(161078);
  }
  
  private static boolean a(dd paramdd)
  {
    AppMethodBeat.i(108408);
    if ((paramdd != null) && ((paramdd instanceof dd)))
    {
      boolean bool = paramdd.dcG.enable;
      g.agR().agA().set(ah.a.GEl, Boolean.valueOf(bool));
      k.ccq().oZH = bool;
      if (bool) {
        break label95;
      }
      h.wUl.f(12953, new Object[] { Integer.valueOf(2), "" });
      Toast.makeText(ai.getContext(), 2131758240, 0).show();
    }
    for (;;)
    {
      AppMethodBeat.o(108408);
      return false;
      label95:
      Toast.makeText(ai.getContext(), 2131758242, 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.b.11
 * JD-Core Version:    0.7.0.1
 */