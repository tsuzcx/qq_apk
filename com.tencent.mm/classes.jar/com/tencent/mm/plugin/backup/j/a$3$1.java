package com.tencent.mm.plugin.backup.j;

import com.tencent.mm.h.a.jv;
import com.tencent.mm.h.a.jv.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.x.b;
import com.tencent.mm.plugin.x.f;
import com.tencent.mm.sdk.platformtools.y;

final class a$3$1
  implements Runnable
{
  a$3$1(a.3 param3, jv paramjv) {}
  
  public final void run()
  {
    Object localObject = this.hRy;
    y.i("MicroMsg.BackupCore", "receive msgSynchronizeStartEvent run userCloseMsgSync[%b]", new Object[] { Boolean.valueOf(((jv)localObject).bSl.bSo) });
    if (((jv)localObject).bSl.bSo)
    {
      h.nFQ.a(466L, 13L, 1L, false);
      return;
    }
    byte[] arrayOfByte = ((jv)localObject).bSl.bSm;
    if (arrayOfByte == null)
    {
      y.e("MicroMsg.BackupCore", "msgsynchronize loginconfirmok key is null!");
      h.nFQ.a(466L, 14L, 1L, false);
      return;
    }
    int i = ((jv)localObject).bSl.bSn;
    localObject = f.hD(true);
    String str = b.msB;
    ((f)localObject).bSn = i;
    ((f)localObject).e(str, "", arrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.j.a.3.1
 * JD-Core Version:    0.7.0.1
 */