package com.tencent.mm.plugin.card.ui;

import com.tencent.mm.plugin.card.base.a;
import com.tencent.mm.plugin.card.model.am;

public final class d
  implements a
{
  private c irL;
  
  public d(c paramc)
  {
    this.irL = paramc;
  }
  
  public final void HL()
  {
    if (this.irL != null) {
      this.irL.a(null, null);
    }
  }
  
  public final void onCreate()
  {
    if (this.irL != null) {
      am.aAs().c(this.irL);
    }
  }
  
  public final void onDestroy()
  {
    if (this.irL != null)
    {
      am.aAs().d(this.irL);
      this.irL.release();
      this.irL = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.d
 * JD-Core Version:    0.7.0.1
 */