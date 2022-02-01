package com.tencent.mm.plugin.card.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.je;
import com.tencent.mm.g.a.je.a;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.card.model.af;
import com.tencent.mm.plugin.card.model.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.storage.bl;

public final class n
  extends c<je>
  implements com.tencent.mm.al.g
{
  private long ded;
  
  public n()
  {
    AppMethodBeat.i(161193);
    this.ded = 0L;
    this.__eventId = je.class.getName().hashCode();
    AppMethodBeat.o(161193);
  }
  
  private boolean a(je paramje)
  {
    AppMethodBeat.i(112711);
    String str;
    if ((paramje instanceof je))
    {
      Object localObject = paramje.dnm.dnn;
      this.ded = paramje.dnm.ded;
      str = paramje.dnm.dno;
      paramje = com.tencent.mm.plugin.card.d.g.Rh((String)localObject);
      localObject = ((k)com.tencent.mm.kernel.g.ab(k.class)).cOI().rm(this.ded);
      ((bl)localObject).setStatus(1);
      ((k)com.tencent.mm.kernel.g.ab(k.class)).cOI().a(this.ded, (bl)localObject);
      if (paramje != null) {
        break label165;
      }
      paramje = com.tencent.mm.plugin.card.d.g.Rh(((du)localObject).field_content);
    }
    label165:
    for (;;)
    {
      if (paramje != null)
      {
        com.tencent.mm.kernel.g.afA().gcy.a(1045, this);
        paramje = new af(paramje.dyc, str, 17);
        com.tencent.mm.kernel.g.afA().gcy.a(paramje, 0);
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
      paramString = ((af)paramn).dyd;
      paramn = ((k)com.tencent.mm.kernel.g.ab(k.class)).cOI().rm(this.ded);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label163;
      }
      paramn.setStatus(2);
    }
    for (;;)
    {
      k.b localb = k.b.rx(paramn.field_content);
      d locald = com.tencent.mm.plugin.card.d.g.Rh(paramn.field_content);
      locald.dyd = paramString;
      localb.gIq = com.tencent.mm.plugin.card.d.g.a(locald);
      localb.dnn = k.b.a(localb, null, null);
      paramn.setContent(k.b.a(localb, null, null));
      ((k)com.tencent.mm.kernel.g.ab(k.class)).cOI().a(this.ded, paramn);
      com.tencent.mm.kernel.g.afA().gcy.b(1045, this);
      AppMethodBeat.o(112710);
      return;
      label163:
      paramn.setStatus(5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.n
 * JD-Core Version:    0.7.0.1
 */