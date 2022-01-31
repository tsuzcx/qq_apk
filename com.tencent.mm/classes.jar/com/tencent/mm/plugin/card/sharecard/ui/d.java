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
  private c krn;
  
  public d(c paramc)
  {
    this.krn = paramc;
  }
  
  public final void aaK()
  {
    AppMethodBeat.i(88148);
    if (this.krn != null) {
      this.krn.a(null, null);
    }
    AppMethodBeat.o(88148);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(88146);
    if (this.krn != null) {
      am.bcd().add(this.krn);
    }
    AppMethodBeat.o(88146);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(88147);
    if (this.krn != null)
    {
      am.bcd().remove(this.krn);
      Object localObject = this.krn;
      ((c)localObject).krl.release();
      ((c)localObject).krl = null;
      ((c)localObject).bKb();
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
      h.qsU.b((ArrayList)localObject, true);
      this.krn = null;
    }
    AppMethodBeat.o(88147);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.d
 * JD-Core Version:    0.7.0.1
 */