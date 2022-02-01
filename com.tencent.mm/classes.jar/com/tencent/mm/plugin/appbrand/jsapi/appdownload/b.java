package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.c;
import com.tencent.mm.plugin.appbrand.a.c.a;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c;
import com.tencent.mm.plugin.appbrand.ipc.e;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

public class b
  extends com.tencent.mm.plugin.appbrand.jsapi.s
{
  public static final int CTRL_INDEX = 662;
  public static final String NAME = "onDownloadAppStateChangeForNative";
  public static HashMap<String, b> lCV;
  private static Set<String> lCW;
  private MMToClientEvent.c lCU;
  
  static
  {
    AppMethodBeat.i(45740);
    lCV = new HashMap();
    lCW = new HashSet();
    AppMethodBeat.o(45740);
  }
  
  public b(final com.tencent.mm.plugin.appbrand.s params)
  {
    AppMethodBeat.i(45736);
    this.lCU = new MMToClientEvent.c()
    {
      public final void cq(Object paramAnonymousObject)
      {
        AppMethodBeat.i(45732);
        if ((paramAnonymousObject instanceof AppbrandDownloadState))
        {
          paramAnonymousObject = (AppbrandDownloadState)paramAnonymousObject;
          if (params != null) {
            b.this.g(params).Zg(paramAnonymousObject.bEw().toString()).bEo();
          }
        }
        AppMethodBeat.o(45732);
      }
    };
    MMToClientEvent.a(params.getAppId(), this.lCU);
    params.getRuntime().kAH.a(new c.a()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.plugin.appbrand.a.b paramAnonymousb)
      {
        AppMethodBeat.i(45733);
        if (paramAnonymousb == com.tencent.mm.plugin.appbrand.a.b.kQK)
        {
          MMToClientEvent.b(params.getAppId(), b.a(b.this));
          b.m(params);
        }
        AppMethodBeat.o(45733);
      }
    });
    AppMethodBeat.o(45736);
  }
  
  public static void a(AppbrandDownloadState paramAppbrandDownloadState)
  {
    AppMethodBeat.i(45737);
    Iterator localIterator = lCW.iterator();
    while (localIterator.hasNext()) {
      e.b((String)localIterator.next(), paramAppbrandDownloadState);
    }
    AppMethodBeat.o(45737);
  }
  
  public static void a(com.tencent.mm.plugin.appbrand.s params, b paramb)
  {
    AppMethodBeat.i(45738);
    lCV.put(params.getAppId(), paramb);
    h.a(MainProcessIPCService.dkO, new IPCString(params.getAppId()), b.a.class, null);
    AppMethodBeat.o(45738);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.b
 * JD-Core Version:    0.7.0.1
 */