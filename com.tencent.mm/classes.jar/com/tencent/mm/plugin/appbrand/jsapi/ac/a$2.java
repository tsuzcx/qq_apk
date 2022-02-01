package com.tencent.mm.plugin.appbrand.jsapi.ac;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;

final class a$2
  implements Runnable
{
  a$2(a parama, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(186861);
    Toast.makeText(aj.getContext(), this.lwW, 0).show();
    AppMethodBeat.o(186861);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ac.a.2
 * JD-Core Version:    0.7.0.1
 */