package com.tencent.mm.plugin.card.b;

import com.tencent.mm.ae.g.a;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.if;
import com.tencent.mm.h.a.if.a;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.card.model.af;
import com.tencent.mm.plugin.card.model.d;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.storage.bi;

public final class n
  extends c<if>
  implements f
{
  private long bHR = 0L;
  
  public n()
  {
    this.udX = if.class.getName().hashCode();
  }
  
  private boolean a(if paramif)
  {
    String str;
    if ((paramif instanceof if))
    {
      Object localObject = paramif.bQq.bQr;
      this.bHR = paramif.bQq.bHR;
      str = paramif.bQq.bQs;
      paramif = com.tencent.mm.plugin.card.d.g.yM((String)localObject);
      localObject = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().fd(this.bHR);
      ((bi)localObject).setStatus(1);
      ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().a(this.bHR, (bi)localObject);
      if (paramif != null) {
        break label150;
      }
      paramif = com.tencent.mm.plugin.card.d.g.yM(((cs)localObject).field_content);
    }
    label150:
    for (;;)
    {
      if (paramif != null)
      {
        com.tencent.mm.kernel.g.DO().dJT.a(652, this);
        paramif = new af(paramif.bZc, str, 17);
        com.tencent.mm.kernel.g.DO().dJT.a(paramif, 0);
      }
      return true;
      return false;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramm instanceof af))
    {
      paramString = ((af)paramm).bZd;
      paramm = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().fd(this.bHR);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label153;
      }
      paramm.setStatus(2);
    }
    for (;;)
    {
      g.a locala = g.a.gp(paramm.field_content);
      d locald = com.tencent.mm.plugin.card.d.g.yM(paramm.field_content);
      locald.bZd = paramString;
      locala.dRK = com.tencent.mm.plugin.card.d.g.a(locald);
      locala.bQr = g.a.a(locala, null, null);
      paramm.setContent(g.a.a(locala, null, null));
      ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().a(this.bHR, paramm);
      com.tencent.mm.kernel.g.DO().dJT.b(652, this);
      return;
      label153:
      paramm.setStatus(5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.n
 * JD-Core Version:    0.7.0.1
 */