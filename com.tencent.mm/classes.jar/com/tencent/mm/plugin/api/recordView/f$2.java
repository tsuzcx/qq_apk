package com.tencent.mm.plugin.api.recordView;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.c;

final class f$2
  implements Runnable
{
  f$2(f paramf) {}
  
  public final void run()
  {
    AppMethodBeat.i(138312);
    if (this.gOo.gOi != null) {
      this.gOo.gOi.aCM();
    }
    AppMethodBeat.o(138312);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.api.recordView.f.2
 * JD-Core Version:    0.7.0.1
 */