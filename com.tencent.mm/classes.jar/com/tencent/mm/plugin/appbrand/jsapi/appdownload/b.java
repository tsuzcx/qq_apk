package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import com.tencent.mm.plugin.appbrand.b.c;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c;
import com.tencent.mm.plugin.appbrand.ipc.d;
import com.tencent.mm.plugin.appbrand.jsapi.l;
import com.tencent.mm.plugin.appbrand.o;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class b
  extends l
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "onDownloadAppStateChange";
  private static HashMap<String, b> ghM = new HashMap();
  private MMToClientEvent.c ghL;
  
  private b(o paramo)
  {
    this.ghL = new b.1(this, paramo);
    MMToClientEvent.a(paramo.mAppId, this.ghL);
    paramo.getRuntime().fyy.a(new b.2(this, paramo));
  }
  
  public static void a(AppbrandDownloadState paramAppbrandDownloadState)
  {
    Iterator localIterator = ghM.keySet().iterator();
    while (localIterator.hasNext()) {
      d.a((String)localIterator.next(), paramAppbrandDownloadState);
    }
  }
  
  public static void c(o paramo)
  {
    if (ghM.containsKey(paramo.mAppId)) {
      return;
    }
    b localb = new b(paramo);
    ghM.put(paramo.mAppId, localb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.b
 * JD-Core Version:    0.7.0.1
 */