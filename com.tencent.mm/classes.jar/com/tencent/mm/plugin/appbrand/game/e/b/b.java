package com.tencent.mm.plugin.appbrand.game.e.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.AppBrandMixExportLogicService.AppBrandOnStartReportCanvasDataEvent;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c;
import com.tencent.mm.plugin.appbrand.jsapi.r;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

public final class b
  extends r
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "onStartReportCanvasData";
  public static MMToClientEvent.c nSv;
  
  public static void b(final v paramv, String paramString)
  {
    AppMethodBeat.i(180198);
    Log.i("MicroMsg.OnStartReportCanvasDataEvent", "startListeningOperationEvent, appId:%s", new Object[] { paramString });
    if (nSv == null) {
      nSv = new MMToClientEvent.c()
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
              new b().a(paramv, b.a.onR, 0);
            }
          }
          AppMethodBeat.o(45161);
        }
      };
    }
    MMToClientEvent.a(paramString, nSv);
    AppMethodBeat.o(180198);
  }
  
  public final void a(v paramv, a parama, int paramInt)
  {
    AppMethodBeat.i(180197);
    Log.i("MicroMsg.OnStartReportCanvasDataEvent", "hy: trigger event %d", new Object[] { Integer.valueOf(a.a(parama)) });
    i(paramv);
    paramv = new HashMap(1);
    paramv.put("event", Integer.valueOf(a.a(parama)));
    paramv.put("viewId", Integer.valueOf(paramInt));
    D(paramv).bPO();
    AppMethodBeat.o(180197);
  }
  
  public static enum a
  {
    private final int value;
    
    static
    {
      AppMethodBeat.i(45164);
      onR = new a("BeforeIdentifyQRCode", 0, 11);
      onS = new a("BeforeJumpToProfile", 1, 12);
      onT = new a("BeforeBack", 2, 15);
      onU = new a("AfterWebViewLoad", 3, 18);
      onV = new a[] { onR, onS, onT, onU };
      AppMethodBeat.o(45164);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.e.b.b
 * JD-Core Version:    0.7.0.1
 */