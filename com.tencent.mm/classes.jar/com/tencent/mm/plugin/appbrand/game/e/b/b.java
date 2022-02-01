package com.tencent.mm.plugin.appbrand.game.e.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.AppBrandMixExportLogicService.AppBrandOnStartReportCanvasDataEvent;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashMap;
import java.util.Map;

public final class b
  extends p
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "onStartReportCanvasData";
  public static MMToClientEvent.c jVn;
  
  public static void b(final r paramr, String paramString)
  {
    AppMethodBeat.i(180198);
    ae.i("MicroMsg.OnStartReportCanvasDataEvent", "startListeningOperationEvent, appId:%s", new Object[] { paramString });
    if (jVn == null) {
      jVn = new MMToClientEvent.c()
      {
        public final void ch(Object paramAnonymousObject)
        {
          AppMethodBeat.i(45161);
          if ((paramAnonymousObject instanceof AppBrandMixExportLogicService.AppBrandOnStartReportCanvasDataEvent))
          {
            paramAnonymousObject = (AppBrandMixExportLogicService.AppBrandOnStartReportCanvasDataEvent)paramAnonymousObject;
            if (this.val$appId.equals(paramAnonymousObject.appId))
            {
              MMToClientEvent.b(this.val$appId, this);
              new b().a(paramr, b.a.kpl, 0);
            }
          }
          AppMethodBeat.o(45161);
        }
      };
    }
    MMToClientEvent.a(paramString, jVn);
    AppMethodBeat.o(180198);
  }
  
  public final void a(r paramr, a parama, int paramInt)
  {
    AppMethodBeat.i(180197);
    ae.i("MicroMsg.OnStartReportCanvasDataEvent", "hy: trigger event %d", new Object[] { Integer.valueOf(a.a(parama)) });
    g(paramr);
    paramr = new HashMap(1);
    paramr.put("event", Integer.valueOf(a.a(parama)));
    paramr.put("viewId", Integer.valueOf(paramInt));
    H(paramr).bja();
    AppMethodBeat.o(180197);
  }
  
  public static enum a
  {
    private final int value;
    
    static
    {
      AppMethodBeat.i(45164);
      kpl = new a("BeforeIdentifyQRCode", 0, 11);
      kpm = new a("BeforeJumpToProfile", 1, 12);
      kpn = new a("BeforeBack", 2, 15);
      kpo = new a("AfterWebViewLoad", 3, 18);
      kpp = new a[] { kpl, kpm, kpn, kpo };
      AppMethodBeat.o(45164);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.e.b.b
 * JD-Core Version:    0.7.0.1
 */