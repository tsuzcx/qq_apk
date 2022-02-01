package com.tencent.mm.plugin.card.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.la;
import com.tencent.mm.f.a.la.a;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.card.d.g;
import com.tencent.mm.plugin.card.model.af;
import com.tencent.mm.plugin.card.model.d;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.storage.ca;

public final class n
  extends IListener<la>
  implements com.tencent.mm.an.i
{
  private long fxU;
  
  public n()
  {
    AppMethodBeat.i(161193);
    this.fxU = 0L;
    this.__eventId = la.class.getName().hashCode();
    AppMethodBeat.o(161193);
  }
  
  private boolean a(la paramla)
  {
    AppMethodBeat.i(112711);
    String str;
    if ((paramla instanceof la))
    {
      Object localObject = paramla.fIH.fII;
      this.fxU = paramla.fIH.fxU;
      str = paramla.fIH.fIJ;
      paramla = g.arM((String)localObject);
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().Oq(this.fxU);
      ((ca)localObject).setStatus(1);
      ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().a(this.fxU, (ca)localObject);
      if (paramla != null) {
        break label165;
      }
      paramla = g.arM(((et)localObject).field_content);
    }
    label165:
    for (;;)
    {
      if (paramla != null)
      {
        h.aHF().kcd.a(1045, this);
        paramla = new af(paramla.fUL, str, 17);
        h.aHF().kcd.a(paramla, 0);
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
      paramString = ((af)paramq).fUM;
      paramq = ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().Oq(this.fxU);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label163;
      }
      paramq.setStatus(2);
    }
    for (;;)
    {
      k.b localb = k.b.OQ(paramq.field_content);
      d locald = g.arM(paramq.field_content);
      locald.fUM = paramString;
      localb.lnj = g.a(locald);
      localb.fII = k.b.a(localb, null, null);
      paramq.setContent(k.b.a(localb, null, null));
      ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().a(this.fxU, paramq);
      h.aHF().kcd.b(1045, this);
      AppMethodBeat.o(112710);
      return;
      label163:
      paramq.setStatus(5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.n
 * JD-Core Version:    0.7.0.1
 */