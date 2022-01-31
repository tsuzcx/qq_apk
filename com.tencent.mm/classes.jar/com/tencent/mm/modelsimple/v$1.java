package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;

final class v$1
  implements Runnable
{
  v$1(v paramv, bi parambi) {}
  
  public final void run()
  {
    AppMethodBeat.i(16597);
    ab.i("MicroMsg.NetSceneRevokeMsg", "delete invoke message! msg:%s", new Object[] { Long.valueOf(this.fkQ.field_msgId) });
    this.fkQ.setType(10002);
    v.a(v.a(this.fPY), "", this.fkQ, "");
    aw.aaz();
    c.YC().a(this.fkQ.field_msgId, this.fkQ);
    AppMethodBeat.o(16597);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelsimple.v.1
 * JD-Core Version:    0.7.0.1
 */