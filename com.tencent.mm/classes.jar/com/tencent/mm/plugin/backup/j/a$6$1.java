package com.tencent.mm.plugin.backup.j;

import com.tencent.mm.plugin.x.f;
import com.tencent.mm.sdk.platformtools.y;

final class a$6$1
  implements Runnable
{
  a$6$1(a.6 param6, String paramString1, String paramString2, byte[] paramArrayOfByte) {}
  
  public final void run()
  {
    y.i("MicroMsg.BackupCore.MsgSynchronize", "start MsgSynchronizeServer");
    f.hD(false).e(this.BI, this.ggg, this.hRA);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.j.a.6.1
 * JD-Core Version:    0.7.0.1
 */