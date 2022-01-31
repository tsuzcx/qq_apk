package com.tencent.mm.plugin.brandservice.ui.timeline;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.z;
import com.tencent.mm.cg.h;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.r.a;
import com.tencent.mm.storage.r.b;
import com.tencent.mm.storage.r.c;
import com.tencent.mm.storage.t;
import java.util.List;

final class e$1
  implements r.c
{
  e$1(e parame) {}
  
  public final void a(Object paramObject, r.a parama)
  {
    AppMethodBeat.i(14147);
    if (parama != null)
    {
      if ((parama.ywM != r.b.ywO) || (parama.jWv == null)) {
        break label58;
      }
      e.a(this.jWn).add(0, parama.jWv);
    }
    for (;;)
    {
      this.jWn.notifyDataSetChanged();
      AppMethodBeat.o(14147);
      return;
      label58:
      if (parama.ywM == r.b.ywP)
      {
        parama = this.jWn;
        paramObject = parama.aWH();
        if (paramObject != null)
        {
          parama.iQp.clear();
          parama = parama.iQp;
          t localt = z.afp();
          long l = paramObject.field_createTime;
          parama.addAll(t.n(localt.fnw.query("BizTimeLineSingleMsgInfo", null, "createTime>=?", new String[] { String.valueOf(l) }, null, null, "createTime DESC")));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.e.1
 * JD-Core Version:    0.7.0.1
 */