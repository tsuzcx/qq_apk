package com.tencent.mm.plugin.card.ui;

import com.tencent.mm.plugin.card.base.a;
import com.tencent.mm.plugin.card.base.c;
import java.util.List;

public final class h
  implements a
{
  private g ivs;
  
  public h(g paramg)
  {
    this.ivs = paramg;
  }
  
  public final void HL()
  {
    if (this.ivs != null) {
      this.ivs.notifyDataSetChanged();
    }
  }
  
  public final void onCreate()
  {
    this.ivs.notifyDataSetChanged();
  }
  
  public final void onDestroy()
  {
    if (this.ivs != null)
    {
      g localg = this.ivs;
      localg.iqd.release();
      localg.iqd = null;
      localg.iqo.clear();
      localg.mContext = null;
      localg.ivq = null;
      this.ivs = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.h
 * JD-Core Version:    0.7.0.1
 */