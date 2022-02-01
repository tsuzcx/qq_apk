package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.u;
import com.tencent.mm.ai.v;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.biz.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.s;
import java.util.LinkedList;

final class h$4
  implements Runnable
{
  h$4(h paramh, s params, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void run()
  {
    long l1 = 0L;
    AppMethodBeat.i(5933);
    long l3 = l1;
    long l2;
    if (this.mLB.eJL())
    {
      l2 = l1;
      l3 = l1;
    }
    for (;;)
    {
      try
      {
        Object localObject = ((a)g.ab(a.class)).a(this.mLB.field_msgId, this.mLB.field_content);
        if (localObject == null) {
          break label259;
        }
        l2 = l1;
        l3 = l1;
        if (bt.gL(((u)localObject).gKs)) {
          break label259;
        }
        l2 = l1;
        l3 = l1;
        localObject = (v)((u)localObject).gKs.get(this.iko);
        l2 = l1;
        l3 = l1;
        if (bt.isNullOrNil(((v)localObject).url)) {
          break label259;
        }
        l2 = l1;
        l3 = l1;
        localObject = Uri.parse(((v)localObject).url);
        l2 = l1;
        l3 = l1;
        l1 = bt.getLong(((Uri)localObject).getQueryParameter("mid"), 0L);
        l2 = l1;
        l3 = l1;
        i = bt.getInt(((Uri)localObject).getQueryParameter("idx"), 0);
      }
      catch (UnsupportedOperationException localUnsupportedOperationException)
      {
        ad.w("MicroMsg.BizTimeLineReport", "reportBizTimelineOp exp %s", new Object[] { localUnsupportedOperationException.getMessage() });
        i = 0;
        l1 = l2;
        continue;
      }
      catch (Exception localException)
      {
        ad.w("MicroMsg.BizTimeLineReport", "reportBizTimelineOp exp %s", new Object[] { localException.getMessage() });
      }
      this.mXJ.a(this.mLB.field_talker, l1, i, this.mXN, this.mXO);
      AppMethodBeat.o(5933);
      return;
      int i = 0;
      l1 = l3;
      continue;
      label259:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.h.4
 * JD-Core Version:    0.7.0.1
 */