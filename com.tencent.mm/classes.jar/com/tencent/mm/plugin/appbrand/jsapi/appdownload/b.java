package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.c;
import com.tencent.mm.plugin.appbrand.a.c.a;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c;
import com.tencent.mm.plugin.appbrand.ipc.e;
import com.tencent.mm.plugin.appbrand.jsapi.r;
import com.tencent.mm.plugin.appbrand.v;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

public class b
  extends r
{
  public static final int CTRL_INDEX = 662;
  public static final String NAME = "onDownloadAppStateChangeForNative";
  public static HashMap<String, b> oyx;
  private static Set<String> oyy;
  private MMToClientEvent.c oyw;
  
  static
  {
    AppMethodBeat.i(45740);
    oyx = new HashMap();
    oyy = new HashSet();
    AppMethodBeat.o(45740);
  }
  
  public b(final v paramv)
  {
    AppMethodBeat.i(45736);
    this.oyw = new MMToClientEvent.c()
    {
      public final void cq(Object paramAnonymousObject)
      {
        AppMethodBeat.i(45732);
        if ((paramAnonymousObject instanceof AppbrandDownloadState))
        {
          paramAnonymousObject = (AppbrandDownloadState)paramAnonymousObject;
          if (paramv != null) {
            b.this.i(paramv).agT(paramAnonymousObject.bPW().toString()).bPO();
          }
        }
        AppMethodBeat.o(45732);
      }
    };
    MMToClientEvent.a(paramv.getAppId(), this.oyw);
    paramv.getRuntime().ntR.a(new c.a()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.plugin.appbrand.a.b paramAnonymousb)
      {
        AppMethodBeat.i(45733);
        if (paramAnonymousb == com.tencent.mm.plugin.appbrand.a.b.nKS)
        {
          MMToClientEvent.b(paramv.getAppId(), b.a(b.this));
          b.m(paramv);
        }
        AppMethodBeat.o(45733);
      }
    });
    AppMethodBeat.o(45736);
  }
  
  public static void a(AppbrandDownloadState paramAppbrandDownloadState)
  {
    AppMethodBeat.i(45737);
    Iterator localIterator = oyy.iterator();
    while (localIterator.hasNext()) {
      e.b((String)localIterator.next(), paramAppbrandDownloadState);
    }
    AppMethodBeat.o(45737);
  }
  
  public static void a(v paramv, b paramb)
  {
    AppMethodBeat.i(45738);
    oyx.put(paramv.getAppId(), paramb);
    j.a(MainProcessIPCService.PROCESS_NAME, new IPCString(paramv.getAppId()), a.class, null);
    AppMethodBeat.o(45738);
  }
  
  static class a
    implements d<IPCString, IPCVoid>
  {}
  
  static class b
    implements d<IPCString, IPCVoid>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.b
 * JD-Core Version:    0.7.0.1
 */