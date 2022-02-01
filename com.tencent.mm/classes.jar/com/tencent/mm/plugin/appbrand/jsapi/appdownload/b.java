package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.b.c;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c;
import com.tencent.mm.plugin.appbrand.ipc.e;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.q;
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
  public static HashMap<String, b> jAv;
  private static Set<String> jAw;
  private MMToClientEvent.c jAu;
  
  static
  {
    AppMethodBeat.i(45740);
    jAv = new HashMap();
    jAw = new HashSet();
    AppMethodBeat.o(45740);
  }
  
  public b(final q paramq)
  {
    AppMethodBeat.i(45736);
    this.jAu = new MMToClientEvent.c()
    {
      public final void ch(Object paramAnonymousObject)
      {
        AppMethodBeat.i(45732);
        if ((paramAnonymousObject instanceof AppbrandDownloadState))
        {
          paramAnonymousObject = (AppbrandDownloadState)paramAnonymousObject;
          if (paramq != null) {
            b.this.g(paramq).HJ(paramAnonymousObject.aXY().toString()).aXQ();
          }
        }
        AppMethodBeat.o(45732);
      }
    };
    MMToClientEvent.a(paramq.getAppId(), this.jAu);
    paramq.getRuntime().iDK.a(new c.a()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.plugin.appbrand.b.b paramAnonymousb)
      {
        AppMethodBeat.i(45733);
        if (paramAnonymousb == com.tencent.mm.plugin.appbrand.b.b.iQN)
        {
          MMToClientEvent.b(paramq.getAppId(), b.a(b.this));
          b.k(paramq);
        }
        AppMethodBeat.o(45733);
      }
    });
    AppMethodBeat.o(45736);
  }
  
  public static void a(AppbrandDownloadState paramAppbrandDownloadState)
  {
    AppMethodBeat.i(45737);
    Iterator localIterator = jAw.iterator();
    while (localIterator.hasNext()) {
      e.b((String)localIterator.next(), paramAppbrandDownloadState);
    }
    AppMethodBeat.o(45737);
  }
  
  public static void a(q paramq, b paramb)
  {
    AppMethodBeat.i(45738);
    jAv.put(paramq.getAppId(), paramb);
    h.a("com.tencent.mm", new IPCString(paramq.getAppId()), b.a.class, null);
    AppMethodBeat.o(45738);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.b
 * JD-Core Version:    0.7.0.1
 */