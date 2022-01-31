package com.tencent.mm.plugin.emoji.e;

import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class c$1
  implements Runnable
{
  c$1(c paramc, String paramString) {}
  
  public final void run()
  {
    this.iWD.Aq(this.val$filePath);
    if (this.iWD.iWB) {
      g.DP().Dz().c(ac.a.uoh, Long.valueOf(System.currentTimeMillis()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.c.1
 * JD-Core Version:    0.7.0.1
 */