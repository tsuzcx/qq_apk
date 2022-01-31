package com.tencent.mm.plugin.api.recordView;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.h;

final class f$4
  implements Runnable
{
  f$4(f paramf, MMSightRecordView.h paramh) {}
  
  public final void run()
  {
    AppMethodBeat.i(76341);
    this.gOo.gNX = false;
    if (this.gOp != null) {
      this.gOp.ef(false);
    }
    AppMethodBeat.o(76341);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.api.recordView.f.4
 * JD-Core Version:    0.7.0.1
 */