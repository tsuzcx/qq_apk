package com.tencent.mm.plugin.emoji.ui.v2;

import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.protocal.c.afi;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.p;

final class a$8
  implements Runnable
{
  a$8(a parama, afi paramafi) {}
  
  public final void run()
  {
    int j = 0;
    int i;
    if (this.jgh != null)
    {
      if (this.jgh != null) {
        break label85;
      }
      i = 0;
      if (this.jgh != null) {
        break label96;
      }
    }
    for (;;)
    {
      y.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "jacks save EmoijStoreUI Cache: list:%d, size: %d, type: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.jgg.aIE()) });
      i.getEmojiStorageMgr().uBe.a(this.jgg.aIE(), this.jgh);
      return;
      label85:
      i = this.jgh.tcZ;
      break;
      label96:
      if (this.jgh.swr != null) {
        j = this.jgh.swr.btq();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.a.8
 * JD-Core Version:    0.7.0.1
 */