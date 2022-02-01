package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.sdk.platformtools.Log;

final class w$1
  implements Runnable
{
  w$1(w paramw, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(20641);
    k.b localb = k.b.OQ(this.maw);
    if ((localb != null) && (localb.type == 6))
    {
      int i = m.X(w.a(this.may), localb.title);
      Log.i("MicroMsg.NetSceneRevokeMsg", "pause msg:%s send, result:%s", new Object[] { Long.valueOf(w.a(this.may)), Integer.valueOf(i) });
    }
    AppMethodBeat.o(20641);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelsimple.w.1
 * JD-Core Version:    0.7.0.1
 */