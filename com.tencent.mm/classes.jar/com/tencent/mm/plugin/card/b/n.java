package com.tencent.mm.plugin.card.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.ju;
import com.tencent.mm.g.a.ju.a;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.card.model.af;
import com.tencent.mm.plugin.card.model.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.storage.bv;

public final class n
  extends c<ju>
  implements f
{
  private long dnX;
  
  public n()
  {
    AppMethodBeat.i(161193);
    this.dnX = 0L;
    this.__eventId = ju.class.getName().hashCode();
    AppMethodBeat.o(161193);
  }
  
  private boolean a(ju paramju)
  {
    AppMethodBeat.i(112711);
    String str;
    if ((paramju instanceof ju))
    {
      Object localObject = paramju.dxM.dxN;
      this.dnX = paramju.dxM.dnX;
      str = paramju.dxM.dxO;
      paramju = com.tencent.mm.plugin.card.d.g.ZT((String)localObject);
      localObject = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().ys(this.dnX);
      ((bv)localObject).setStatus(1);
      ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().a(this.dnX, (bv)localObject);
      if (paramju != null) {
        break label165;
      }
      paramju = com.tencent.mm.plugin.card.d.g.ZT(((ei)localObject).field_content);
    }
    label165:
    for (;;)
    {
      if (paramju != null)
      {
        com.tencent.mm.kernel.g.ajQ().gDv.a(1045, this);
        paramju = new af(paramju.dJb, str, 17);
        com.tencent.mm.kernel.g.ajQ().gDv.a(paramju, 0);
      }
      AppMethodBeat.o(112711);
      return true;
      AppMethodBeat.o(112711);
      return false;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(112710);
    if ((paramn instanceof af))
    {
      paramString = ((af)paramn).dJc;
      paramn = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().ys(this.dnX);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label163;
      }
      paramn.setStatus(2);
    }
    for (;;)
    {
      k.b localb = k.b.zb(paramn.field_content);
      d locald = com.tencent.mm.plugin.card.d.g.ZT(paramn.field_content);
      locald.dJc = paramString;
      localb.hDO = com.tencent.mm.plugin.card.d.g.a(locald);
      localb.dxN = k.b.a(localb, null, null);
      paramn.setContent(k.b.a(localb, null, null));
      ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().a(this.dnX, paramn);
      com.tencent.mm.kernel.g.ajQ().gDv.b(1045, this);
      AppMethodBeat.o(112710);
      return;
      label163:
      paramn.setStatus(5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.n
 * JD-Core Version:    0.7.0.1
 */