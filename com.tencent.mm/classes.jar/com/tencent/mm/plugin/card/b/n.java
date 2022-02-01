package com.tencent.mm.plugin.card.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.jl;
import com.tencent.mm.g.a.jl.a;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.card.model.af;
import com.tencent.mm.plugin.card.model.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.storage.bo;

public final class n
  extends c<jl>
  implements com.tencent.mm.ak.g
{
  private long dbz;
  
  public n()
  {
    AppMethodBeat.i(161193);
    this.dbz = 0L;
    this.__eventId = jl.class.getName().hashCode();
    AppMethodBeat.o(161193);
  }
  
  private boolean a(jl paramjl)
  {
    AppMethodBeat.i(112711);
    String str;
    if ((paramjl instanceof jl))
    {
      Object localObject = paramjl.dkU.dkV;
      this.dbz = paramjl.dkU.dbz;
      str = paramjl.dkU.dkW;
      paramjl = com.tencent.mm.plugin.card.d.g.Vt((String)localObject);
      localObject = ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().vP(this.dbz);
      ((bo)localObject).setStatus(1);
      ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().a(this.dbz, (bo)localObject);
      if (paramjl != null) {
        break label165;
      }
      paramjl = com.tencent.mm.plugin.card.d.g.Vt(((dy)localObject).field_content);
    }
    label165:
    for (;;)
    {
      if (paramjl != null)
      {
        com.tencent.mm.kernel.g.agQ().ghe.a(1045, this);
        paramjl = new af(paramjl.dvO, str, 17);
        com.tencent.mm.kernel.g.agQ().ghe.a(paramjl, 0);
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
      paramString = ((af)paramn).dvP;
      paramn = ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().vP(this.dbz);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label163;
      }
      paramn.setStatus(2);
    }
    for (;;)
    {
      k.b localb = k.b.vA(paramn.field_content);
      d locald = com.tencent.mm.plugin.card.d.g.Vt(paramn.field_content);
      locald.dvP = paramString;
      localb.hiR = com.tencent.mm.plugin.card.d.g.a(locald);
      localb.dkV = k.b.a(localb, null, null);
      paramn.setContent(k.b.a(localb, null, null));
      ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().a(this.dbz, paramn);
      com.tencent.mm.kernel.g.agQ().ghe.b(1045, this);
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