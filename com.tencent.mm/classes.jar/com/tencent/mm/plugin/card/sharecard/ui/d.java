package com.tencent.mm.plugin.card.sharecard.ui;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.a;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.report.service.h;
import java.util.ArrayList;

public final class d
  implements a
{
  private c ttn;
  
  public d(c paramc)
  {
    this.ttn = paramc;
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(113080);
    if (this.ttn != null) {
      am.cHs().add(this.ttn);
    }
    AppMethodBeat.o(113080);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(113081);
    if (this.ttn != null)
    {
      am.cHs().remove(this.ttn);
      Object localObject = this.ttn;
      ((c)localObject).ttl.release();
      ((c)localObject).ttl = null;
      ((c)localObject).eKd();
      int i = (int)(((c)localObject).endTime - ((c)localObject).beginTime);
      localObject = new ArrayList();
      IDKey localIDKey1 = new IDKey();
      localIDKey1.SetID(281);
      localIDKey1.SetKey(24);
      localIDKey1.SetValue(1L);
      IDKey localIDKey2 = new IDKey();
      localIDKey2.SetID(281);
      localIDKey2.SetKey(25);
      localIDKey2.SetValue(i);
      ((ArrayList)localObject).add(localIDKey1);
      ((ArrayList)localObject).add(localIDKey2);
      h.IzE.b((ArrayList)localObject, true);
      this.ttn = null;
    }
    AppMethodBeat.o(113081);
  }
  
  public final void onNotify()
  {
    AppMethodBeat.i(113082);
    if (this.ttn != null) {
      this.ttn.onNotifyChange(null, null);
    }
    AppMethodBeat.o(113082);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.d
 * JD-Core Version:    0.7.0.1
 */