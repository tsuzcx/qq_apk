package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;

final class w$2
  implements Runnable
{
  w$2(w paramw, ca paramca) {}
  
  public final void run()
  {
    AppMethodBeat.i(218608);
    Log.i("MicroMsg.NetSceneRevokeMsg", "delete invoke message! msg:%s", new Object[] { Long.valueOf(this.lru.field_msgId) });
    this.lru.setType(10002);
    w.a(w.b(this.may), "", this.lru, "");
    bh.beI();
    c.bbO().a(this.lru.field_msgId, this.lru);
    AppMethodBeat.o(218608);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelsimple.w.2
 * JD-Core Version:    0.7.0.1
 */