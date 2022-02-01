package com.tencent.mm.plugin.appbrand.jsapi.ad;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class a$2
  implements Runnable
{
  a$2(a parama, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(220553);
    Toast.makeText(ak.getContext(), this.lBu, 0).show();
    AppMethodBeat.o(220553);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ad.a.2
 * JD-Core Version:    0.7.0.1
 */