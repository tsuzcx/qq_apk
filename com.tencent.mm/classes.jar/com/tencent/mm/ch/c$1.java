package com.tencent.mm.ch;

import android.os.Process;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.y;

final class c$1
  implements Runnable
{
  c$1(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4) {}
  
  public final void run()
  {
    if (c.access$000())
    {
      y.w("MicroMsg.MemoryDumpOperation", "Hprof is mUploading");
      return;
    }
    if (this.uFT) {}
    for (String str = b.W(true, false);; str = null)
    {
      Process.setThreadPriority(10);
      boolean bool = aq.isWifi(ae.getContext());
      if ((this.uFU) && (!bool))
      {
        y.w("MicroMsg.MemoryDumpOperation", "Hprof no wifi");
        return;
      }
      if ((this.uFV) && (str != null)) {}
      for (;;)
      {
        c.bo(true);
        c.mG(str);
        c.bo(false);
        return;
        if (this.uFW) {
          str = b.uFQ;
        } else {
          str = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ch.c.1
 * JD-Core Version:    0.7.0.1
 */