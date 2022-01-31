package com.tencent.mm.plugin.card.sharecard.ui;

import com.tencent.mars.smc.IDKey;
import com.tencent.mm.plugin.card.base.a;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.report.service.h;
import java.util.ArrayList;

public final class d
  implements a
{
  private c iqf;
  
  public d(c paramc)
  {
    this.iqf = paramc;
  }
  
  public final void HL()
  {
    if (this.iqf != null) {
      this.iqf.a(null, null);
    }
  }
  
  public final void onCreate()
  {
    if (this.iqf != null) {
      am.aAs().c(this.iqf);
    }
  }
  
  public final void onDestroy()
  {
    if (this.iqf != null)
    {
      am.aAs().d(this.iqf);
      Object localObject = this.iqf;
      ((c)localObject).iqd.release();
      ((c)localObject).iqd = null;
      ((c)localObject).bcS();
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
      h.nFQ.b((ArrayList)localObject, true);
      this.iqf = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.d
 * JD-Core Version:    0.7.0.1
 */