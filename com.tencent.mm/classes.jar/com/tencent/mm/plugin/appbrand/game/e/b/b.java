package com.tencent.mm.plugin.appbrand.game.e.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.AppBrandMixExportLogicService.AppBrandOnStartReportCanvasDataEvent;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.Map;

public final class b
  extends p
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "onStartReportCanvasData";
  public static MMToClientEvent.c iXK;
  
  public static void b(final q paramq, String paramString)
  {
    AppMethodBeat.i(180198);
    ad.i("MicroMsg.OnStartReportCanvasDataEvent", "startListeningOperationEvent, appId:%s", new Object[] { paramString });
    if (iXK == null) {
      iXK = new MMToClientEvent.c()
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
              new b().a(paramq, b.a.jrp, 0);
            }
          }
          AppMethodBeat.o(45161);
        }
      };
    }
    MMToClientEvent.a(paramString, iXK);
    AppMethodBeat.o(180198);
  }
  
  public final void a(q paramq, a parama, int paramInt)
  {
    AppMethodBeat.i(180197);
    ad.i("MicroMsg.OnStartReportCanvasDataEvent", "hy: trigger event %d", new Object[] { Integer.valueOf(a.a(parama)) });
    g(paramq);
    paramq = new HashMap(1);
    paramq.put("event", Integer.valueOf(a.a(parama)));
    paramq.put("viewId", Integer.valueOf(paramInt));
    B(paramq).aXQ();
    AppMethodBeat.o(180197);
  }
  
  public static enum a
  {
    private final int value;
    
    static
    {
      AppMethodBeat.i(45164);
      jrp = new a("BeforeIdentifyQRCode", 0, 11);
      jrq = new a("BeforeJumpToProfile", 1, 12);
      jrr = new a("BeforeBack", 2, 15);
      jrs = new a("AfterWebViewLoad", 3, 18);
      jrt = new a[] { jrp, jrq, jrr, jrs };
      AppMethodBeat.o(45164);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.e.b.b
 * JD-Core Version:    0.7.0.1
 */