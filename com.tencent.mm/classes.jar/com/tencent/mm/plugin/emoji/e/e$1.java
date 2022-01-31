package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class e$1
  implements Runnable
{
  e$1(e parame, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(52859);
    this.lfL.Kr(this.val$filePath);
    if (this.lfL.lfJ) {
      g.RL().Ru().set(ac.a.yya, Long.valueOf(System.currentTimeMillis()));
    }
    AppMethodBeat.o(52859);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.e.1
 * JD-Core Version:    0.7.0.1
 */