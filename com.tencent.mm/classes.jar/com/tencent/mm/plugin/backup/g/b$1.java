package com.tencent.mm.plugin.backup.g;

import com.tencent.mm.sdk.platformtools.y;

final class b$1
  implements Runnable
{
  b$1(boolean paramBoolean, int paramInt1, byte[] paramArrayOfByte, int paramInt2) {}
  
  public final void run()
  {
    if (b.auW() != null)
    {
      b.auW().a(this.hFS, this.bns, this.hFT, this.hFQ);
      return;
    }
    y.w("MicroMsg.BackupBaseScene", "callbackToNotify, onNotify is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.b.1
 * JD-Core Version:    0.7.0.1
 */