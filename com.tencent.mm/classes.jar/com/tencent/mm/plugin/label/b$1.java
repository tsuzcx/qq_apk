package com.tencent.mm.plugin.label;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;

final class b$1
  implements f
{
  b$1(b paramb) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.e("MicroMsg.Label.ContactLabelManagerImpl", "onSceneEnd");
    switch (paramm.getType())
    {
    case 636: 
    case 637: 
    default: 
      return;
    case 635: 
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        b.g(this.lAI.username, this.lAI.lAF);
        return;
      }
      this.lAI.bdw();
      y.e("MicroMsg.Label.ContactLabelManagerImpl", "add contact lable faild");
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((this.lAI.lAG == null) || (this.lAI.lAG.isEmpty())) {
        break label257;
      }
    }
    label257:
    for (paramInt1 = this.lAI.lAG.size();; paramInt1 = 0)
    {
      if ((this.lAI.lAF != null) && (!this.lAI.lAF.isEmpty())) {}
      for (paramInt2 = this.lAI.lAF.size() - paramInt1;; paramInt2 = 0)
      {
        if ((paramInt1 > 0) || (paramInt2 > 0))
        {
          y.d("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveContact]addLabelNum:%d,updateLabelNum:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
          h.nFQ.f(11220, new Object[] { q.Gj(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(0), Integer.valueOf(0) });
        }
        this.lAI.bdw();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.label.b.1
 * JD-Core Version:    0.7.0.1
 */