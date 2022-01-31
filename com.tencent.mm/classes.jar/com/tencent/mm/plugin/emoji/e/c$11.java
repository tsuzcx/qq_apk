package com.tencent.mm.plugin.emoji.e;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cw;
import com.tencent.mm.g.a.cw.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class c$11
  extends com.tencent.mm.sdk.b.c<cw>
{
  c$11(c paramc)
  {
    AppMethodBeat.i(52846);
    this.__eventId = cw.class.getName().hashCode();
    AppMethodBeat.o(52846);
  }
  
  private static boolean a(cw paramcw)
  {
    AppMethodBeat.i(139668);
    if ((paramcw != null) && ((paramcw instanceof cw)))
    {
      boolean bool = paramcw.cqo.enable;
      g.RL().Ru().set(ac.a.yyd, Boolean.valueOf(bool));
      i.blt().lgB = bool;
      if (bool) {
        break label95;
      }
      h.qsU.e(12953, new Object[] { Integer.valueOf(2), "" });
      Toast.makeText(ah.getContext(), 2131299124, 0).show();
    }
    for (;;)
    {
      AppMethodBeat.o(139668);
      return false;
      label95:
      Toast.makeText(ah.getContext(), 2131299126, 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.c.11
 * JD-Core Version:    0.7.0.1
 */