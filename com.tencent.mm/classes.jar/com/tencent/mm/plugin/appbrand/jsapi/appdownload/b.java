package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.appbrand.b.c;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c;
import com.tencent.mm.plugin.appbrand.ipc.d;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.r;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class b
  extends p
{
  public static final int CTRL_INDEX = 662;
  public static final String NAME = "onDownloadAppStateChangeForNative";
  public static HashMap<String, b> hAR;
  private static Set<String> hAS;
  private MMToClientEvent.c hAQ;
  
  static
  {
    AppMethodBeat.i(143278);
    hAR = new HashMap();
    hAS = new HashSet();
    AppMethodBeat.o(143278);
  }
  
  public b(r paramr)
  {
    AppMethodBeat.i(143274);
    this.hAQ = new b.1(this, paramr);
    MMToClientEvent.a(paramr.getAppId(), this.hAQ);
    paramr.getRuntime().gPL.a(new b.2(this, paramr));
    AppMethodBeat.o(143274);
  }
  
  public static void a(AppbrandDownloadState paramAppbrandDownloadState)
  {
    AppMethodBeat.i(143275);
    Iterator localIterator = hAS.iterator();
    while (localIterator.hasNext()) {
      d.a((String)localIterator.next(), paramAppbrandDownloadState);
    }
    AppMethodBeat.o(143275);
  }
  
  public static void a(r paramr, b paramb)
  {
    AppMethodBeat.i(143276);
    hAR.put(paramr.getAppId(), paramb);
    f.a("com.tencent.mm", new IPCString(paramr.getAppId()), b.a.class, null);
    AppMethodBeat.o(143276);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.b
 * JD-Core Version:    0.7.0.1
 */