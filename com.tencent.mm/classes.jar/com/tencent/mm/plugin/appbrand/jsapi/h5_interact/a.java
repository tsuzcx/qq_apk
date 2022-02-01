package com.tencent.mm.plugin.appbrand.jsapi.h5_interact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.b.c;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONObject;

public final class a
  extends p
{
  private static final int CTRL_INDEX = 460;
  private static final String NAME = "onH5Data";
  
  public static void x(o paramo)
  {
    AppMethodBeat.i(46352);
    String str = paramo.mAppId;
    MMToClientEvent.c local1 = new MMToClientEvent.c()
    {
      public final void ch(Object paramAnonymousObject)
      {
        AppMethodBeat.i(46350);
        if ((paramAnonymousObject instanceof SendDataToMiniProgramFromH5Event))
        {
          Object localObject1 = (SendDataToMiniProgramFromH5Event)paramAnonymousObject;
          Object localObject2 = ((SendDataToMiniProgramFromH5Event)localObject1).jRv;
          paramAnonymousObject = ((SendDataToMiniProgramFromH5Event)localObject1).data;
          int i = ((SendDataToMiniProgramFromH5Event)localObject1).jRw;
          if (!bt.isNullOrNil((String)localObject2))
          {
            localObject1 = com.tencent.mm.plugin.appbrand.a.CR((String)localObject2);
            if ((localObject1 == null) || (!((AppBrandRuntime)localObject1).mInitialized))
            {
              AppMethodBeat.o(46350);
              return;
            }
            try
            {
              paramAnonymousObject = new JSONObject().put("data", paramAnonymousObject).put("webviewId", String.valueOf(i));
              localObject2 = new a();
              ((a)localObject2).g(((o)localObject1).aNe()).HJ(paramAnonymousObject.toString());
              ((a)localObject2).aXQ();
              AppMethodBeat.o(46350);
              return;
            }
            catch (Exception paramAnonymousObject)
            {
              ad.e("MicroMsg.AppBrand.EventOnH5Data", "dispatch ex = %s", new Object[] { paramAnonymousObject });
            }
          }
        }
        AppMethodBeat.o(46350);
      }
    };
    MMToClientEvent.a(str, local1);
    paramo.iDK.a(new c.a()
    {
      public final void a(String paramAnonymousString, b paramAnonymousb)
      {
        AppMethodBeat.i(46351);
        if (paramAnonymousb == b.iQN) {
          MMToClientEvent.b(paramAnonymousString, this.iXu);
        }
        AppMethodBeat.o(46351);
      }
    });
    AppMethodBeat.o(46352);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.h5_interact.a
 * JD-Core Version:    0.7.0.1
 */