package com.tencent.mm.plugin.card.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.jt;
import com.tencent.mm.g.a.jt.a;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.card.model.af;
import com.tencent.mm.plugin.card.model.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.storage.bu;

public final class n
  extends c<jt>
  implements f
{
  private long dmV;
  
  public n()
  {
    AppMethodBeat.i(161193);
    this.dmV = 0L;
    this.__eventId = jt.class.getName().hashCode();
    AppMethodBeat.o(161193);
  }
  
  private boolean a(jt paramjt)
  {
    AppMethodBeat.i(112711);
    String str;
    if ((paramjt instanceof jt))
    {
      Object localObject = paramjt.dwH.dwI;
      this.dmV = paramjt.dwH.dmV;
      str = paramjt.dwH.dwJ;
      paramjt = com.tencent.mm.plugin.card.d.g.Zc((String)localObject);
      localObject = ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().xY(this.dmV);
      ((bu)localObject).setStatus(1);
      ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().a(this.dmV, (bu)localObject);
      if (paramjt != null) {
        break label165;
      }
      paramjt = com.tencent.mm.plugin.card.d.g.Zc(((ei)localObject).field_content);
    }
    label165:
    for (;;)
    {
      if (paramjt != null)
      {
        com.tencent.mm.kernel.g.ajB().gAO.a(1045, this);
        paramjt = new af(paramjt.dHX, str, 17);
        com.tencent.mm.kernel.g.ajB().gAO.a(paramjt, 0);
      }
      AppMethodBeat.o(112711);
      return true;
      AppMethodBeat.o(112711);
      return false;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(112710);
    if ((paramn instanceof af))
    {
      paramString = ((af)paramn).dHY;
      paramn = ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().xY(this.dmV);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label163;
      }
      paramn.setStatus(2);
    }
    for (;;)
    {
      k.b localb = k.b.yr(paramn.field_content);
      d locald = com.tencent.mm.plugin.card.d.g.Zc(paramn.field_content);
      locald.dHY = paramString;
      localb.hBa = com.tencent.mm.plugin.card.d.g.a(locald);
      localb.dwI = k.b.a(localb, null, null);
      paramn.setContent(k.b.a(localb, null, null));
      ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().a(this.dmV, paramn);
      com.tencent.mm.kernel.g.ajB().gAO.b(1045, this);
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