package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;

final class w$1
  implements Runnable
{
  w$1(w paramw, ca paramca) {}
  
  public final void run()
  {
    AppMethodBeat.i(20641);
    Log.i("MicroMsg.NetSceneRevokeMsg", "delete invoke message! msg:%s", new Object[] { Long.valueOf(this.iBP.field_msgId) });
    this.iBP.setType(10002);
    w.a(w.a(this.jkx), "", this.iBP, "");
    bg.aVF();
    c.aSQ().a(this.iBP.field_msgId, this.iBP);
    AppMethodBeat.o(20641);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelsimple.w.1
 * JD-Core Version:    0.7.0.1
 */