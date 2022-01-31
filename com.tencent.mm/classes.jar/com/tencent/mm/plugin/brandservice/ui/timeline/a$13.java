package com.tencent.mm.plugin.brandservice.ui.timeline;

import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.q;
import java.util.HashMap;

final class a$13
  implements j
{
  a$13(a parama) {}
  
  public final void a(q paramq, int paramInt)
  {
    Object localObject = a.d(this.ifl);
    if (paramq != null)
    {
      localObject = (g.a)((g)localObject).igI.get(paramq.field_msgId + "_" + paramInt);
      if (localObject != null)
      {
        ((g.a)localObject).sDM = 1;
        y.d("MicroMsg.BizTimeLineReport", "onClick %d", new Object[] { Integer.valueOf(paramInt) });
      }
    }
    a.l(this.ifl).d(paramq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.13
 * JD-Core Version:    0.7.0.1
 */