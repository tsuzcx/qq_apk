package com.tencent.mm.plugin.backup.c;

import com.tencent.mm.plugin.backup.g.l;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import junit.framework.Assert;

final class c$b$3
  implements Runnable
{
  c$b$3(c.b paramb) {}
  
  public final void run()
  {
    boolean bool = true;
    Assert.assertTrue(toString() + ", check running. ", this.hGz.fSF);
    y.i(this.hGz.TAG, "requestBigFileList svrIdCnt:%d timeDiff:%d caller:%s", new Object[] { Integer.valueOf(this.hGz.hGu.size()), Long.valueOf(bk.co(this.hGz.hGv)), ak.cri() });
    if (!this.hGz.hGu.isEmpty()) {}
    for (;;)
    {
      Assert.assertTrue("BigFileMap should not Empty", bool);
      c.b.3.1 local1 = new c.b.3.1(this);
      new l(this.hGz.talker, this.hGz.hGu, local1).auT();
      return;
      bool = false;
    }
  }
  
  public final String toString()
  {
    return this.hGz.TAG + ".reqBigFile";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.c.c.b.3
 * JD-Core Version:    0.7.0.1
 */