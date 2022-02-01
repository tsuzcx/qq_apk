package com.tencent.mm.plugin.appbrand.game.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.game.e.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.protocal.protobuf.glo;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

final class b$1
  implements Runnable
{
  b$1(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(45167);
    a locala = new a();
    Object localObject = ((AppBrandRuntime)this.rrI.ekH.get()).ari();
    String str = this.rrI.rrF.ache;
    Log.i("MicroMsg.OnCanvasReportEventSampleConfigReceivedEvent", "hy: sending config; %s", new Object[] { str });
    locala.h((f)localObject);
    localObject = new HashMap(1);
    ((Map)localObject).put("keyEventSampleConfig", str);
    locala.K((Map)localObject).cpV();
    AppMethodBeat.o(45167);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.f.b.1
 * JD-Core Version:    0.7.0.1
 */