package com.tencent.mm.plugin.extaccessories;

import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class b$1
  implements Runnable
{
  b$1(b paramb) {}
  
  public final void run()
  {
    if (!au.DK()) {}
    while (bk.bl(this.jLN.dKt)) {
      return;
    }
    long l = System.currentTimeMillis();
    bk.h(this.jLN.dKt + "image/spen/", "spen_", 259200000L);
    y.d("MicroMsg.extaccessories.SubCoreExtAccessories", "deleteOutOfDateFile cost %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.extaccessories.b.1
 * JD-Core Version:    0.7.0.1
 */