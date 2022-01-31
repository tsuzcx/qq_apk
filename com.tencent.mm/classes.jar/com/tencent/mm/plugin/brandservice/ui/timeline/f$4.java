package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.biz.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

final class f$4
  implements Runnable
{
  f$4(f paramf, com.tencent.mm.storage.q paramq, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void run()
  {
    long l1 = 0L;
    AppMethodBeat.i(14173);
    long l3 = l1;
    long l2;
    if (this.jMz.dvV())
    {
      l2 = l1;
      l3 = l1;
    }
    for (;;)
    {
      try
      {
        Object localObject = ((a)g.E(a.class)).b(this.jMz.field_msgId, this.jMz.field_content);
        if (localObject == null) {
          break label259;
        }
        l2 = l1;
        l3 = l1;
        if (bo.es(((p)localObject).fjy)) {
          break label259;
        }
        l2 = l1;
        l3 = l1;
        localObject = (com.tencent.mm.af.q)((p)localObject).fjy.get(this.gxr);
        l2 = l1;
        l3 = l1;
        if (bo.isNullOrNil(((com.tencent.mm.af.q)localObject).url)) {
          break label259;
        }
        l2 = l1;
        l3 = l1;
        localObject = Uri.parse(((com.tencent.mm.af.q)localObject).url);
        l2 = l1;
        l3 = l1;
        l1 = bo.getLong(((Uri)localObject).getQueryParameter("mid"), 0L);
        l2 = l1;
        l3 = l1;
        i = bo.getInt(((Uri)localObject).getQueryParameter("idx"), 0);
      }
      catch (UnsupportedOperationException localUnsupportedOperationException)
      {
        ab.w("MicroMsg.BizTimeLineReport", "reportBizTimelineOp exp %s", new Object[] { localUnsupportedOperationException.getMessage() });
        i = 0;
        l1 = l2;
        continue;
      }
      catch (Exception localException)
      {
        ab.w("MicroMsg.BizTimeLineReport", "reportBizTimelineOp exp %s", new Object[] { localException.getMessage() });
      }
      this.jWC.a(this.jMz.field_talker, l1, i, this.jWH, this.jWI);
      AppMethodBeat.o(14173);
      return;
      int i = 0;
      l1 = l3;
      continue;
      label259:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.f.4
 * JD-Core Version:    0.7.0.1
 */