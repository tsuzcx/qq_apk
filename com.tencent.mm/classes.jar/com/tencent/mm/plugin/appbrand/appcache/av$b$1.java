package com.tencent.mm.plugin.appbrand.appcache;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

final class av$b$1
  implements Runnable
{
  av$b$1(av.b paramb, String paramString1, int paramInt, String paramString2) {}
  
  public final void run()
  {
    AppMethodBeat.i(129432);
    h.bt(this.val$appId, this.gWI);
    Toast.makeText(ah.getContext(), ah.getContext().getString(2131296785, new Object[] { bo.bf(this.gWJ, this.val$appId) }), 1).show();
    AppMethodBeat.o(129432);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.av.b.1
 * JD-Core Version:    0.7.0.1
 */