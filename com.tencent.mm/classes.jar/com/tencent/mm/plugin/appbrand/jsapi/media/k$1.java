package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;

final class k$1
  implements Runnable
{
  k$1(k paramk, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(114370);
    Toast.makeText(ah.getContext(), ah.getContext().getString(2131304522, new Object[] { this.hSl }), 1).show();
    AppMethodBeat.o(114370);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.k.1
 * JD-Core Version:    0.7.0.1
 */