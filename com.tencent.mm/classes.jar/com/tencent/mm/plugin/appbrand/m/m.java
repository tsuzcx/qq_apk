package com.tencent.mm.plugin.appbrand.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.m.a.b;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.net.ssl.SSLContext;
import org.json.JSONObject;

public final class m
{
  public static int FAILED = -1;
  public static int SUCCESS = 0;
  private final Map<String, ConcurrentLinkedQueue<b.a>> gXb;
  private c hrA;
  private final String igf;
  protected final ArrayList<String> isA;
  private final ArrayList<b> isC;
  private int isx;
  private String isy;
  private SSLContext isz;
  private final ConcurrentLinkedQueue<b> itn;
  
  public m(c paramc)
  {
    AppMethodBeat.i(108249);
    this.isy = (e.esq + "appbrand/");
    this.isA = new ArrayList();
    this.isC = new ArrayList();
    this.itn = new ConcurrentLinkedQueue();
    this.hrA = paramc;
    paramc = (a)paramc.U(a.class);
    this.isx = paramc.bDs;
    this.igf = paramc.isv;
    this.isz = j.a(paramc);
    this.gXb = new Hashtable(10);
    AppMethodBeat.o(108249);
  }
  
  public final void a(JSONObject paramJSONObject, int paramInt1, Map<String, String> arg3, ArrayList<String> arg4, int paramInt2, b.a parama, String paramString1, String paramString2)
  {
    AppMethodBeat.i(108250);
    ??? = paramJSONObject.optString("url");
    paramJSONObject = this.isy + ag.cE((String)???) + "temp";
    String str = j.DY((String)???);
    for (;;)
    {
      ConcurrentLinkedQueue localConcurrentLinkedQueue;
      synchronized (this.gXb)
      {
        if (this.gXb.get(str) == null)
        {
          localConcurrentLinkedQueue = new ConcurrentLinkedQueue();
          localConcurrentLinkedQueue.offer(parama);
          this.gXb.put(str, localConcurrentLinkedQueue);
          paramJSONObject = new b(this.hrA, str, paramJSONObject, this.igf, new m.1(this, paramString1, parama));
          paramJSONObject.itJ = ???;
          paramJSONObject.eBM = paramInt1;
          paramJSONObject.isRunning = true;
          paramJSONObject.isU = ???;
          paramJSONObject.itK = paramInt2;
          paramJSONObject.isz = this.isz;
          paramJSONObject.hwp = paramString1;
          paramJSONObject.isY = paramString2;
        }
      }
      synchronized (this.isC)
      {
        if (this.isC.size() >= this.isx) {
          synchronized (this.itn)
          {
            this.itn.add(paramJSONObject);
            AppMethodBeat.o(108250);
            return;
            localConcurrentLinkedQueue = (ConcurrentLinkedQueue)this.gXb.get(str);
            localConcurrentLinkedQueue.offer(parama);
            ab.w("MicroMsg.AppBrandPreloadNetworkDownload", "predownload the same task is working url:%s,size:%d", new Object[] { str, Integer.valueOf(localConcurrentLinkedQueue.size()) });
            continue;
            paramJSONObject = finally;
            AppMethodBeat.o(108250);
            throw paramJSONObject;
          }
        }
      }
    }
    this.isC.add(paramJSONObject);
    d.post(paramJSONObject, "appbrand_predownload_thread");
    AppMethodBeat.o(108250);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.m.m
 * JD-Core Version:    0.7.0.1
 */