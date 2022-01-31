package com.tencent.mm.ci;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;

final class c$1
  implements Runnable
{
  c$1(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4) {}
  
  public final void run()
  {
    AppMethodBeat.i(76899);
    if (c.access$000())
    {
      ab.w("MicroMsg.MemoryDumpOperation", "Hprof is mUploading");
      AppMethodBeat.o(76899);
      return;
    }
    if (this.ySL) {}
    for (String str = b.ah(true, false);; str = null)
    {
      Process.setThreadPriority(10);
      boolean bool = at.isWifi(ah.getContext());
      if ((this.ySM) && (!bool))
      {
        ab.w("MicroMsg.MemoryDumpOperation", "Hprof no wifi");
        AppMethodBeat.o(76899);
        return;
      }
      if ((this.ySN) && (str != null)) {}
      for (;;)
      {
        c.access$002(true);
        c.tQ(str);
        c.access$002(false);
        AppMethodBeat.o(76899);
        return;
        if (this.ySO) {
          str = b.ySI;
        } else {
          str = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ci.c.1
 * JD-Core Version:    0.7.0.1
 */