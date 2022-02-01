package com.tencent.mm.plugin.appbrand.game.e.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.AppBrandMixExportLogicService.AppBrandOnStartReportCanvasDataEvent;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

public final class b
  extends s
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "onStartReportCanvasData";
  public static MMToClientEvent.c qSg;
  
  public static void b(final y paramy, String paramString)
  {
    AppMethodBeat.i(180198);
    Log.i("MicroMsg.OnStartReportCanvasDataEvent", "startListeningOperationEvent, appId:%s", new Object[] { paramString });
    if (qSg == null) {
      qSg = new MMToClientEvent.c()
      {
        public final void dL(Object paramAnonymousObject)
        {
          AppMethodBeat.i(45161);
          if ((paramAnonymousObject instanceof AppBrandMixExportLogicService.AppBrandOnStartReportCanvasDataEvent))
          {
            paramAnonymousObject = (AppBrandMixExportLogicService.AppBrandOnStartReportCanvasDataEvent)paramAnonymousObject;
            if (b.this.equals(paramAnonymousObject.appId))
            {
              MMToClientEvent.b(b.this, this);
              new b().a(paramy, b.a.rrA, 0);
            }
          }
          AppMethodBeat.o(45161);
        }
      };
    }
    MMToClientEvent.a(paramString, qSg);
    AppMethodBeat.o(180198);
  }
  
  public final void a(y paramy, a parama, int paramInt)
  {
    AppMethodBeat.i(180197);
    Log.i("MicroMsg.OnStartReportCanvasDataEvent", "hy: trigger event %d", new Object[] { Integer.valueOf(a.a(parama)) });
    h(paramy);
    paramy = new HashMap(1);
    paramy.put("event", Integer.valueOf(a.a(parama)));
    paramy.put("viewId", Integer.valueOf(paramInt));
    K(paramy).cpV();
    AppMethodBeat.o(180197);
  }
  
  public static enum a
  {
    private final int value;
    
    static
    {
      AppMethodBeat.i(45164);
      rrA = new a("BeforeIdentifyQRCode", 0, 11);
      rrB = new a("BeforeJumpToProfile", 1, 12);
      rrC = new a("BeforeBack", 2, 15);
      rrD = new a("AfterWebViewLoad", 3, 18);
      rrE = new a[] { rrA, rrB, rrC, rrD };
      AppMethodBeat.o(45164);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.e.b.b
 * JD-Core Version:    0.7.0.1
 */