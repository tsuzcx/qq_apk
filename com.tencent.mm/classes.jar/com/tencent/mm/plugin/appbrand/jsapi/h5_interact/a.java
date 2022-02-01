package com.tencent.mm.plugin.appbrand.jsapi.h5_interact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.b.c;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class a
  extends s
{
  private static final int CTRL_INDEX = 460;
  private static final String NAME = "onH5Data";
  
  public static void z(w paramw)
  {
    AppMethodBeat.i(46352);
    String str = paramw.mAppId;
    MMToClientEvent.c local1 = new MMToClientEvent.c()
    {
      public final void dL(Object paramAnonymousObject)
      {
        AppMethodBeat.i(46350);
        if ((paramAnonymousObject instanceof SendDataToMiniProgramFromH5Event))
        {
          Object localObject1 = (SendDataToMiniProgramFromH5Event)paramAnonymousObject;
          Object localObject2 = ((SendDataToMiniProgramFromH5Event)localObject1).rZd;
          paramAnonymousObject = ((SendDataToMiniProgramFromH5Event)localObject1).data;
          int i = ((SendDataToMiniProgramFromH5Event)localObject1).rZe;
          if (!Util.isNullOrNil((String)localObject2))
          {
            localObject1 = d.Uc((String)localObject2);
            if ((localObject1 == null) || (!((AppBrandRuntime)localObject1).mInitialized))
            {
              AppMethodBeat.o(46350);
              return;
            }
            try
            {
              paramAnonymousObject = new JSONObject().put("data", paramAnonymousObject).put("webviewId", String.valueOf(i));
              localObject2 = new a();
              ((a)localObject2).h(((w)localObject1).ccO()).ZQ(paramAnonymousObject.toString());
              ((a)localObject2).cpV();
              AppMethodBeat.o(46350);
              return;
            }
            catch (Exception paramAnonymousObject)
            {
              Log.e("MicroMsg.AppBrand.EventOnH5Data", "dispatch ex = %s", new Object[] { paramAnonymousObject });
            }
          }
        }
        AppMethodBeat.o(46350);
      }
    };
    MMToClientEvent.a(str, local1);
    paramw.qsB.a(new c.a()
    {
      public final void onRunningStateChanged(String paramAnonymousString, b paramAnonymousb)
      {
        AppMethodBeat.i(46351);
        if (paramAnonymousb == b.qKz) {
          MMToClientEvent.b(paramAnonymousString, a.this);
        }
        AppMethodBeat.o(46351);
      }
    });
    AppMethodBeat.o(46352);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.h5_interact.a
 * JD-Core Version:    0.7.0.1
 */