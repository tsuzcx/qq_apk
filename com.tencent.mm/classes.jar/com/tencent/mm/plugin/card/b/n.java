package com.tencent.mm.plugin.card.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.kj;
import com.tencent.mm.g.a.kj.a;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.card.model.af;
import com.tencent.mm.plugin.card.model.d;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.storage.ca;

public final class n
  extends IListener<kj>
  implements com.tencent.mm.ak.i
{
  private long dFm;
  
  public n()
  {
    AppMethodBeat.i(161193);
    this.dFm = 0L;
    this.__eventId = kj.class.getName().hashCode();
    AppMethodBeat.o(161193);
  }
  
  private boolean a(kj paramkj)
  {
    AppMethodBeat.i(112711);
    String str;
    if ((paramkj instanceof kj))
    {
      Object localObject = paramkj.dPt.dPu;
      this.dFm = paramkj.dPt.dFm;
      str = paramkj.dPt.dPv;
      paramkj = com.tencent.mm.plugin.card.d.g.ajZ((String)localObject);
      localObject = ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(this.dFm);
      ((ca)localObject).setStatus(1);
      ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().a(this.dFm, (ca)localObject);
      if (paramkj != null) {
        break label165;
      }
      paramkj = com.tencent.mm.plugin.card.d.g.ajZ(((eo)localObject).field_content);
    }
    label165:
    for (;;)
    {
      if (paramkj != null)
      {
        com.tencent.mm.kernel.g.aAg().hqi.a(1045, this);
        paramkj = new af(paramkj.eaO, str, 17);
        com.tencent.mm.kernel.g.aAg().hqi.a(paramkj, 0);
      }
      AppMethodBeat.o(112711);
      return true;
      AppMethodBeat.o(112711);
      return false;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(112710);
    if ((paramq instanceof af))
    {
      paramString = ((af)paramq).eaP;
      paramq = ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(this.dFm);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label163;
      }
      paramq.setStatus(2);
    }
    for (;;)
    {
      k.b localb = k.b.HD(paramq.field_content);
      d locald = com.tencent.mm.plugin.card.d.g.ajZ(paramq.field_content);
      locald.eaP = paramString;
      localb.ixT = com.tencent.mm.plugin.card.d.g.a(locald);
      localb.dPu = k.b.a(localb, null, null);
      paramq.setContent(k.b.a(localb, null, null));
      ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().a(this.dFm, paramq);
      com.tencent.mm.kernel.g.aAg().hqi.b(1045, this);
      AppMethodBeat.o(112710);
      return;
      label163:
      paramq.setStatus(5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.n
 * JD-Core Version:    0.7.0.1
 */