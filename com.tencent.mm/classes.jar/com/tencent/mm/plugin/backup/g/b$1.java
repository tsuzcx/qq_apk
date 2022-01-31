package com.tencent.mm.plugin.backup.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class b$1
  implements Runnable
{
  b$1(boolean paramBoolean, int paramInt1, byte[] paramArrayOfByte, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(17638);
    if (b.aUy() != null)
    {
      b.aUy().a(this.jzp, this.bHS, this.ePW, this.jzn);
      AppMethodBeat.o(17638);
      return;
    }
    ab.w("MicroMsg.BackupBaseScene", "callbackToNotify, onNotify is null");
    AppMethodBeat.o(17638);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.b.1
 * JD-Core Version:    0.7.0.1
 */