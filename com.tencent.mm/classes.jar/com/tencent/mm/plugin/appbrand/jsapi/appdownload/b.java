package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.b.c;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c;
import com.tencent.mm.plugin.appbrand.ipc.f;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.y;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

public class b
  extends s
{
  public static final int CTRL_INDEX = 662;
  public static final String NAME = "onDownloadAppStateChangeForNative";
  public static HashMap<String, b> rCp;
  private static Set<String> rCq;
  private MMToClientEvent.c rCo;
  
  static
  {
    AppMethodBeat.i(45740);
    rCp = new HashMap();
    rCq = new HashSet();
    AppMethodBeat.o(45740);
  }
  
  public b(final y paramy)
  {
    AppMethodBeat.i(45736);
    this.rCo = new MMToClientEvent.c()
    {
      public final void dL(Object paramAnonymousObject)
      {
        AppMethodBeat.i(45732);
        if ((paramAnonymousObject instanceof AppbrandDownloadState))
        {
          paramAnonymousObject = (AppbrandDownloadState)paramAnonymousObject;
          if (paramy != null) {
            b.this.h(paramy).ZQ(paramAnonymousObject.cqc().toString()).cpV();
          }
        }
        AppMethodBeat.o(45732);
      }
    };
    MMToClientEvent.a(paramy.getAppId(), this.rCo);
    paramy.getRuntime().qsB.a(new c.a()
    {
      public final void onRunningStateChanged(String paramAnonymousString, com.tencent.mm.plugin.appbrand.b.b paramAnonymousb)
      {
        AppMethodBeat.i(45733);
        if (paramAnonymousb == com.tencent.mm.plugin.appbrand.b.b.qKz)
        {
          MMToClientEvent.b(paramy.getAppId(), b.a(b.this));
          b.m(paramy);
        }
        AppMethodBeat.o(45733);
      }
    });
    AppMethodBeat.o(45736);
  }
  
  public static void a(AppbrandDownloadState paramAppbrandDownloadState)
  {
    AppMethodBeat.i(45737);
    Iterator localIterator = rCq.iterator();
    while (localIterator.hasNext()) {
      f.b((String)localIterator.next(), paramAppbrandDownloadState);
    }
    AppMethodBeat.o(45737);
  }
  
  public static void a(y paramy, b paramb)
  {
    AppMethodBeat.i(45738);
    rCp.put(paramy.getAppId(), paramb);
    j.a(MainProcessIPCService.PROCESS_NAME, new IPCString(paramy.getAppId()), a.class, null);
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