package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.c;
import com.tencent.mm.plugin.appbrand.a.c.a;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c;
import com.tencent.mm.plugin.appbrand.ipc.e;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.r;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

public class b
  extends p
{
  public static final int CTRL_INDEX = 662;
  public static final String NAME = "onDownloadAppStateChangeForNative";
  public static HashMap<String, b> kyC;
  private static Set<String> kyD;
  private MMToClientEvent.c kyB;
  
  static
  {
    AppMethodBeat.i(45740);
    kyC = new HashMap();
    kyD = new HashSet();
    AppMethodBeat.o(45740);
  }
  
  public b(final r paramr)
  {
    AppMethodBeat.i(45736);
    this.kyB = new MMToClientEvent.c()
    {
      public final void ch(Object paramAnonymousObject)
      {
        AppMethodBeat.i(45732);
        if ((paramAnonymousObject instanceof AppbrandDownloadState))
        {
          paramAnonymousObject = (AppbrandDownloadState)paramAnonymousObject;
          if (paramr != null) {
            b.this.g(paramr).PP(paramAnonymousObject.bji().toString()).bja();
          }
        }
        AppMethodBeat.o(45732);
      }
    };
    MMToClientEvent.a(paramr.getAppId(), this.kyB);
    paramr.getRuntime().jzQ.a(new c.a()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.plugin.appbrand.a.b paramAnonymousb)
      {
        AppMethodBeat.i(45733);
        if (paramAnonymousb == com.tencent.mm.plugin.appbrand.a.b.jOd)
        {
          MMToClientEvent.b(paramr.getAppId(), b.a(b.this));
          b.k(paramr);
        }
        AppMethodBeat.o(45733);
      }
    });
    AppMethodBeat.o(45736);
  }
  
  public static void a(AppbrandDownloadState paramAppbrandDownloadState)
  {
    AppMethodBeat.i(45737);
    Iterator localIterator = kyD.iterator();
    while (localIterator.hasNext()) {
      e.b((String)localIterator.next(), paramAppbrandDownloadState);
    }
    AppMethodBeat.o(45737);
  }
  
  public static void a(r paramr, b paramb)
  {
    AppMethodBeat.i(45738);
    kyC.put(paramr.getAppId(), paramb);
    h.a("com.tencent.mm", new IPCString(paramr.getAppId()), b.a.class, null);
    AppMethodBeat.o(45738);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.b
 * JD-Core Version:    0.7.0.1
 */