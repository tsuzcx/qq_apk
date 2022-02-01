package com.tencent.luggage.game.d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.z.a;
import com.tencent.mm.sdk.platformtools.Log;

final class e$1
  implements z.a
{
  e$1(e parame) {}
  
  public final void eW(String paramString)
  {
    AppMethodBeat.i(130601);
    Log.e("MicroMsg.WAGameJsContextInterfaceLU", "Interface port loadJsFiles fail");
    AppMethodBeat.o(130601);
  }
  
  public final void onSuccess(String paramString)
  {
    AppMethodBeat.i(130600);
    Log.i("MicroMsg.WAGameJsContextInterfaceLU", "Interface port loadJsFiles success");
    AppMethodBeat.o(130600);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.game.d.a.a.e.1
 * JD-Core Version:    0.7.0.1
 */