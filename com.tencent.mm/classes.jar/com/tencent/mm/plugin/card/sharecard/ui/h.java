package com.tencent.mm.plugin.card.sharecard.ui;

import com.tencent.mm.plugin.card.base.a;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.base.c;
import java.util.List;

public final class h
  implements a
{
  private g iqp;
  
  public h(g paramg)
  {
    this.iqp = paramg;
  }
  
  public final void HL()
  {
    if (this.iqp != null) {
      this.iqp.notifyDataSetChanged();
    }
  }
  
  public final b oK(int paramInt)
  {
    if (this.iqp != null) {
      return this.iqp.oK(paramInt);
    }
    return null;
  }
  
  public final void onCreate()
  {
    this.iqp.notifyDataSetChanged();
  }
  
  public final void onDestroy()
  {
    if (this.iqp != null)
    {
      g localg = this.iqp;
      localg.iqd.release();
      localg.iqd = null;
      localg.iqo.clear();
      localg.mContext = null;
      this.iqp = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.h
 * JD-Core Version:    0.7.0.1
 */