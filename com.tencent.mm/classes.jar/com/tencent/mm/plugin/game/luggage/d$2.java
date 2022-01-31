package com.tencent.mm.plugin.game.luggage;

import android.text.TextUtils;
import com.tencent.luggage.d.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.HashMap;
import java.util.LinkedList;

final class d$2
  implements Runnable
{
  d$2(Class paramClass, String paramString, d.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(135832);
    k localk = new k(ah.getContext(), this.njx);
    d.bFm().put(this.val$url, localk);
    d.bFn().remove(this.val$url);
    if (!TextUtils.isEmpty(this.val$url))
    {
      ab.i("MicroMsg.PreloadGameWebCoreHelp", "loadUrl: %s", new Object[] { this.val$url });
      localk.loadUrl(this.val$url);
    }
    if (this.njw != null) {
      this.njw.tU();
    }
    AppMethodBeat.o(135832);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d.2
 * JD-Core Version:    0.7.0.1
 */