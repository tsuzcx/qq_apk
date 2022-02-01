package com.tencent.mm.plugin.appbrand.game.e.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.AppBrandMixExportLogicService.AppBrandOnStartReportCanvasDataEvent;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

public final class b
  extends com.tencent.mm.plugin.appbrand.jsapi.s
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "onStartReportCanvasData";
  public static MMToClientEvent.c kYj;
  
  public static void b(final com.tencent.mm.plugin.appbrand.s params, String paramString)
  {
    AppMethodBeat.i(180198);
    Log.i("MicroMsg.OnStartReportCanvasDataEvent", "startListeningOperationEvent, appId:%s", new Object[] { paramString });
    if (kYj == null) {
      kYj = new MMToClientEvent.c()
      {
        public final void cq(Object paramAnonymousObject)
        {
          AppMethodBeat.i(45161);
          if ((paramAnonymousObject instanceof AppBrandMixExportLogicService.AppBrandOnStartReportCanvasDataEvent))
          {
            paramAnonymousObject = (AppBrandMixExportLogicService.AppBrandOnStartReportCanvasDataEvent)paramAnonymousObject;
            if (this.val$appId.equals(paramAnonymousObject.appId))
            {
              MMToClientEvent.b(this.val$appId, this);
              new b().a(params, b.a.lsU, 0);
            }
          }
          AppMethodBeat.o(45161);
        }
      };
    }
    MMToClientEvent.a(paramString, kYj);
    AppMethodBeat.o(180198);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.s params, a parama, int paramInt)
  {
    AppMethodBeat.i(180197);
    Log.i("MicroMsg.OnStartReportCanvasDataEvent", "hy: trigger event %d", new Object[] { Integer.valueOf(a.a(parama)) });
    g(params);
    params = new HashMap(1);
    params.put("event", Integer.valueOf(a.a(parama)));
    params.put("viewId", Integer.valueOf(paramInt));
    K(params).bEo();
    AppMethodBeat.o(180197);
  }
  
  public static enum a
  {
    private final int value;
    
    static
    {
      AppMethodBeat.i(45164);
      lsU = new a("BeforeIdentifyQRCode", 0, 11);
      lsV = new a("BeforeJumpToProfile", 1, 12);
      lsW = new a("BeforeBack", 2, 15);
      lsX = new a("AfterWebViewLoad", 3, 18);
      lsY = new a[] { lsU, lsV, lsW, lsX };
      AppMethodBeat.o(45164);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.e.b.b
 * JD-Core Version:    0.7.0.1
 */