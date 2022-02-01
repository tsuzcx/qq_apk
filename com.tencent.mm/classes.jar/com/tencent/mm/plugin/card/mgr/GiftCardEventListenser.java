package com.tencent.mm.plugin.card.mgr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.me;
import com.tencent.mm.autogen.a.me.a;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.c;
import com.tencent.mm.message.k.b;
import com.tencent.mm.plugin.card.c.g;
import com.tencent.mm.plugin.card.model.af;
import com.tencent.mm.plugin.card.model.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.storage.cc;

public class GiftCardEventListenser
  extends IListener<me>
  implements com.tencent.mm.am.h
{
  private long hCz;
  
  public GiftCardEventListenser()
  {
    super(f.hfK);
    AppMethodBeat.i(161193);
    this.hCz = 0L;
    this.__eventId = me.class.getName().hashCode();
    AppMethodBeat.o(161193);
  }
  
  private boolean a(me paramme)
  {
    AppMethodBeat.i(112711);
    String str;
    if ((paramme instanceof me))
    {
      Object localObject = paramme.hOi.hOj;
      this.hCz = paramme.hOi.hCz;
      str = paramme.hOi.hOk;
      paramme = g.alq((String)localObject);
      localObject = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(this.hCz);
      ((cc)localObject).setStatus(1);
      ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().a(this.hCz, (cc)localObject);
      if (paramme != null) {
        break label165;
      }
      paramme = g.alq(((fi)localObject).field_content);
    }
    label165:
    for (;;)
    {
      if (paramme != null)
      {
        com.tencent.mm.kernel.h.baD().mCm.a(1045, this);
        paramme = new af(paramme.iaI, str, 17);
        com.tencent.mm.kernel.h.baD().mCm.a(paramme, 0);
      }
      AppMethodBeat.o(112711);
      return true;
      AppMethodBeat.o(112711);
      return false;
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(112710);
    if ((paramp instanceof af))
    {
      paramString = ((af)paramp).iaJ;
      paramp = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(this.hCz);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label163;
      }
      paramp.setStatus(2);
    }
    for (;;)
    {
      k.b localb = k.b.Hf(paramp.field_content);
      d locald = g.alq(paramp.field_content);
      locald.iaJ = paramString;
      localb.nSn = g.a(locald);
      localb.hOj = k.b.a(localb, null, null);
      paramp.setContent(k.b.a(localb, null, null));
      ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().a(this.hCz, paramp);
      com.tencent.mm.kernel.h.baD().mCm.b(1045, this);
      AppMethodBeat.o(112710);
      return;
      label163:
      paramp.setStatus(5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.mgr.GiftCardEventListenser
 * JD-Core Version:    0.7.0.1
 */