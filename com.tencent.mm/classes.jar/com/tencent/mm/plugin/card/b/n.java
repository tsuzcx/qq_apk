package com.tencent.mm.plugin.card.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.ij;
import com.tencent.mm.g.a.ij.a;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.card.model.af;
import com.tencent.mm.plugin.card.model.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.storage.bi;

public final class n
  extends c<ij>
  implements f
{
  private long cpg;
  
  public n()
  {
    AppMethodBeat.i(87766);
    this.cpg = 0L;
    this.__eventId = ij.class.getName().hashCode();
    AppMethodBeat.o(87766);
  }
  
  private boolean a(ij paramij)
  {
    AppMethodBeat.i(87768);
    String str;
    if ((paramij instanceof ij))
    {
      Object localObject = paramij.cxJ.cxK;
      this.cpg = paramij.cxJ.cpg;
      str = paramij.cxJ.cxL;
      paramij = com.tencent.mm.plugin.card.d.g.Iw((String)localObject);
      localObject = ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().kB(this.cpg);
      ((bi)localObject).setStatus(1);
      ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().a(this.cpg, (bi)localObject);
      if (paramij != null) {
        break label165;
      }
      paramij = com.tencent.mm.plugin.card.d.g.Iw(((dd)localObject).field_content);
    }
    label165:
    for (;;)
    {
      if (paramij != null)
      {
        com.tencent.mm.kernel.g.RK().eHt.a(652, this);
        paramij = new af(paramij.cHn, str, 17);
        com.tencent.mm.kernel.g.RK().eHt.a(paramij, 0);
      }
      AppMethodBeat.o(87768);
      return true;
      AppMethodBeat.o(87768);
      return false;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(87767);
    if ((paramm instanceof af))
    {
      paramString = ((af)paramm).cHo;
      paramm = ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().kB(this.cpg);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label163;
      }
      paramm.setStatus(2);
    }
    for (;;)
    {
      j.b localb = j.b.mY(paramm.field_content);
      d locald = com.tencent.mm.plugin.card.d.g.Iw(paramm.field_content);
      locald.cHo = paramString;
      localb.fhJ = com.tencent.mm.plugin.card.d.g.a(locald);
      localb.cxK = j.b.a(localb, null, null);
      paramm.setContent(j.b.a(localb, null, null));
      ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().a(this.cpg, paramm);
      com.tencent.mm.kernel.g.RK().eHt.b(652, this);
      AppMethodBeat.o(87767);
      return;
      label163:
      paramm.setStatus(5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.n
 * JD-Core Version:    0.7.0.1
 */