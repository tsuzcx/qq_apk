package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.u;
import com.tencent.mm.aj.v;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.biz.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.z;
import java.util.LinkedList;

final class f$4
  implements Runnable
{
  f$4(f paramf, z paramz, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void run()
  {
    long l1 = 0L;
    AppMethodBeat.i(5933);
    long l3 = l1;
    long l2;
    if (this.sgW.hwA())
    {
      l2 = l1;
      l3 = l1;
    }
    for (;;)
    {
      try
      {
        Object localObject = ((a)h.ae(a.class)).b(this.sgW.field_msgId, this.sgW.field_content);
        if (localObject == null) {
          break label259;
        }
        l2 = l1;
        l3 = l1;
        if (Util.isNullOrNil(((u)localObject).lpz)) {
          break label259;
        }
        l2 = l1;
        l3 = l1;
        localObject = (v)((u)localObject).lpz.get(this.mWa);
        l2 = l1;
        l3 = l1;
        if (Util.isNullOrNil(((v)localObject).url)) {
          break label259;
        }
        l2 = l1;
        l3 = l1;
        localObject = Uri.parse(((v)localObject).url);
        l2 = l1;
        l3 = l1;
        l1 = Util.getLong(((Uri)localObject).getQueryParameter("mid"), 0L);
        l2 = l1;
        l3 = l1;
        i = Util.getInt(((Uri)localObject).getQueryParameter("idx"), 0);
      }
      catch (UnsupportedOperationException localUnsupportedOperationException)
      {
        Log.w("MicroMsg.BizTimeLineReport", "reportBizTimelineOp exp %s", new Object[] { localUnsupportedOperationException.getMessage() });
        i = 0;
        l1 = l2;
        continue;
      }
      catch (Exception localException)
      {
        Log.w("MicroMsg.BizTimeLineReport", "reportBizTimelineOp exp %s", new Object[] { localException.getMessage() });
      }
      this.sBG.a(this.sgW.field_talker, l1, i, this.sBL, this.sBM);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.f.4
 * JD-Core Version:    0.7.0.1
 */