package com.tencent.mm.plugin.location.ui;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMHorList;

final class h$2
  implements Runnable
{
  h$2(h paramh, int paramInt) {}
  
  public final void run()
  {
    y.d("MicroMsg.ShareHeaderAvatarViewMgr", "scrollToTalker pos=%d", new Object[] { Integer.valueOf(this.lFR) });
    this.lFQ.lFM.Gq(this.lFR);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.h.2
 * JD-Core Version:    0.7.0.1
 */