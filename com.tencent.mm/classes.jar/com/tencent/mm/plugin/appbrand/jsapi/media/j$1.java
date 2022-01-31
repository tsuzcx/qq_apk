package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.f.b;
import com.tencent.mm.sdk.platformtools.ah;

final class j$1
  implements Runnable
{
  j$1(j paramj) {}
  
  public final void run()
  {
    AppMethodBeat.i(114366);
    Toast.makeText(ah.getContext(), ah.getContext().getString(2131298889, new Object[] { b.dpF() }), 1).show();
    AppMethodBeat.o(114366);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.j.1
 * JD-Core Version:    0.7.0.1
 */