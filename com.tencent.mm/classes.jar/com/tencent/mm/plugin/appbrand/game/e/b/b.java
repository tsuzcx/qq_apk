package com.tencent.mm.plugin.appbrand.game.e.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.AppBrandMixExportLogicService.AppBrandOnStartReportCanvasDataEvent;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashMap;
import java.util.Map;

public final class b
  extends p
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "onStartReportCanvasData";
  public static MMToClientEvent.c jya;
  
  public static void b(final q paramq, String paramString)
  {
    AppMethodBeat.i(180198);
    ac.i("MicroMsg.OnStartReportCanvasDataEvent", "startListeningOperationEvent, appId:%s", new Object[] { paramString });
    if (jya == null) {
      jya = new MMToClientEvent.c()
      {
        public final void cf(Object paramAnonymousObject)
        {
          AppMethodBeat.i(45161);
          if ((paramAnonymousObject instanceof AppBrandMixExportLogicService.AppBrandOnStartReportCanvasDataEvent))
          {
            paramAnonymousObject = (AppBrandMixExportLogicService.AppBrandOnStartReportCanvasDataEvent)paramAnonymousObject;
            if (this.val$appId.equals(paramAnonymousObject.appId))
            {
              MMToClientEvent.b(this.val$appId, this);
              new b().a(paramq, b.a.jRH, 0);
            }
          }
          AppMethodBeat.o(45161);
        }
      };
    }
    MMToClientEvent.a(paramString, jya);
    AppMethodBeat.o(180198);
  }
  
  public final void a(q paramq, a parama, int paramInt)
  {
    AppMethodBeat.i(180197);
    ac.i("MicroMsg.OnStartReportCanvasDataEvent", "hy: trigger event %d", new Object[] { Integer.valueOf(a.a(parama)) });
    g(paramq);
    paramq = new HashMap(1);
    paramq.put("event", Integer.valueOf(a.a(parama)));
    paramq.put("viewId", Integer.valueOf(paramInt));
    A(paramq).beN();
    AppMethodBeat.o(180197);
  }
  
  public static enum a
  {
    private final int value;
    
    static
    {
      AppMethodBeat.i(45164);
      jRH = new a("BeforeIdentifyQRCode", 0, 11);
      jRI = new a("BeforeJumpToProfile", 1, 12);
      jRJ = new a("BeforeBack", 2, 15);
      jRK = new a("AfterWebViewLoad", 3, 18);
      jRL = new a[] { jRH, jRI, jRJ, jRK };
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