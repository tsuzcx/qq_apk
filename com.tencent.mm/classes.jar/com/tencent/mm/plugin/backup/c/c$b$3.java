package com.tencent.mm.plugin.backup.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.g.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import junit.framework.Assert;

final class c$b$3
  implements Runnable
{
  c$b$3(c.b paramb) {}
  
  public final void run()
  {
    boolean bool = true;
    AppMethodBeat.i(17183);
    Assert.assertTrue(toString() + ", check running. ", this.jzV.hmf);
    ab.i(this.jzV.TAG, "requestBigFileList svrIdCnt:%d timeDiff:%d caller:%s", new Object[] { Integer.valueOf(this.jzV.jzQ.size()), Long.valueOf(bo.hl(this.jzV.jzR)), an.dtg() });
    if (!this.jzV.jzQ.isEmpty()) {}
    for (;;)
    {
      Assert.assertTrue("BigFileMap should not Empty", bool);
      c.b.3.1 local1 = new c.b.3.1(this);
      new l(this.jzV.talker, this.jzV.jzQ, local1).aUv();
      AppMethodBeat.o(17183);
      return;
      bool = false;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(17182);
    String str = this.jzV.TAG + ".reqBigFile";
    AppMethodBeat.o(17182);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.c.c.b.3
 * JD-Core Version:    0.7.0.1
 */