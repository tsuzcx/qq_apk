package com.tencent.mm.plugin.emoji.e;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.dg;
import com.tencent.mm.g.a.dg.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;

final class b$11
  extends c<dg>
{
  b$11(b paramb)
  {
    AppMethodBeat.i(161078);
    this.__eventId = dg.class.getName().hashCode();
    AppMethodBeat.o(161078);
  }
  
  private static boolean a(dg paramdg)
  {
    AppMethodBeat.i(108408);
    if ((paramdg != null) && ((paramdg instanceof dg)))
    {
      boolean bool = paramdg.doc.enable;
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IqE, Boolean.valueOf(bool));
      k.cgU().pDr = bool;
      if (bool) {
        break label95;
      }
      com.tencent.mm.plugin.report.service.g.yhR.f(12953, new Object[] { Integer.valueOf(2), "" });
      Toast.makeText(aj.getContext(), 2131758240, 0).show();
    }
    for (;;)
    {
      AppMethodBeat.o(108408);
      return false;
      label95:
      Toast.makeText(aj.getContext(), 2131758242, 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.b.11
 * JD-Core Version:    0.7.0.1
 */