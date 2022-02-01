package com.tencent.mm.media.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
final class a$y
  implements Runnable
{
  a$y(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(93495);
    Log.i(this.ids.TAG, "mixMusic onDecodeEnd delay check, isPostEncodeEnd:" + this.ids.idp);
    if (!this.ids.idp)
    {
      a locala = this.ids;
      long l = Util.currentTicks();
      locala.a(new byte[0], l, true);
    }
    AppMethodBeat.o(93495);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.media.a.a.y
 * JD-Core Version:    0.7.0.1
 */