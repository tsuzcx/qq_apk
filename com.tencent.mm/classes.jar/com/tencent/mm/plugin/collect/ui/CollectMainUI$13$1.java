package com.tencent.mm.plugin.collect.ui;

import com.tencent.mm.plugin.collect.a.a;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.awl;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import java.util.List;

final class CollectMainUI$13$1
  implements n.c
{
  CollectMainUI$13$1(CollectMainUI.13 param13) {}
  
  public final void a(l paraml)
  {
    a.aEp();
    if (a.aEr()) {
      paraml.add(0, 1, 0, a.i.collect_main_close_ring_tone);
    }
    while (this.iLU.fng != null)
    {
      int i = 0;
      while (i < this.iLU.fng.size())
      {
        awl localawl = (awl)this.iLU.fng.get(i);
        if (!bk.bl(localawl.bQZ)) {
          paraml.add(0, i + 1 + 1, 0, localawl.bQZ);
        }
        i += 1;
      }
      paraml.add(0, 1, 0, a.i.collect_main_open_ring_tone);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectMainUI.13.1
 * JD-Core Version:    0.7.0.1
 */