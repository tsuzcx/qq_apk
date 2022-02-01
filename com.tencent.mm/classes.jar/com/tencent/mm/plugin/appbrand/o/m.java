package com.tencent.mm.plugin.appbrand.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.net.ssl.SSLContext;
import org.json.JSONObject;

public final class m
{
  public static int FAILED = -1;
  public static int SUCCESS = 0;
  private boolean kXC;
  private c kjg;
  protected final ArrayList<String> lVA;
  public final ArrayList<com.tencent.mm.plugin.appbrand.o.a.b> lVC;
  private int lVx;
  private String lVy;
  private SSLContext lVz;
  public final ConcurrentLinkedQueue<com.tencent.mm.plugin.appbrand.o.a.b> lWA;
  private final Map<String, ConcurrentLinkedQueue<b.a>> lWz;
  private final String luC;
  
  public m(c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(144431);
    this.lVy = (com.tencent.mm.loader.j.b.arX() + "appbrand/");
    this.kXC = false;
    this.lVA = new ArrayList();
    this.lVC = new ArrayList();
    this.lWA = new ConcurrentLinkedQueue();
    this.kjg = paramc;
    paramc = (a)paramc.ar(a.class);
    this.lVx = paramc.cmO;
    this.luC = paramc.lVu;
    this.lVz = j.a(paramc);
    this.lWz = new Hashtable(10);
    this.kXC = paramBoolean;
    AppMethodBeat.o(144431);
  }
  
  public final void a(JSONObject paramJSONObject, int paramInt1, Map<String, String> arg3, ArrayList<String> arg4, int paramInt2, final b.a parama, final String paramString1, String paramString2)
  {
    AppMethodBeat.i(144432);
    String str2 = paramJSONObject.optString("url");
    ad.i("MicroMsg.AppBrandPreloadNetworkDownload", "predownload taskId:%s url:%s", new Object[] { paramString1, str2 });
    String str1 = this.lVy + ai.ee(str2) + "temp";
    str2 = j.SS(str2);
    for (;;)
    {
      ConcurrentLinkedQueue localConcurrentLinkedQueue;
      synchronized (this.lWz)
      {
        if (this.lWz.get(str2) == null)
        {
          localConcurrentLinkedQueue = new ConcurrentLinkedQueue();
          localConcurrentLinkedQueue.offer(parama);
          this.lWz.put(str2, localConcurrentLinkedQueue);
          ??? = paramJSONObject.optString("filePath");
          boolean bool1 = paramJSONObject.optBoolean("enableHttp2", false);
          boolean bool2 = paramJSONObject.optBoolean("enableQuic", false);
          boolean bool3 = paramJSONObject.optBoolean("enableCache", false);
          boolean bool4 = paramJSONObject.optBoolean("enableProfile", true);
          paramJSONObject = new com.tencent.mm.plugin.appbrand.o.a.b(this.kjg, str2, str1, (String)???, this.luC, this.kXC, bool1, bool2, bool3, bool4, new com.tencent.mm.plugin.appbrand.o.a.a()
          {
            public final void C(JSONObject paramAnonymousJSONObject)
            {
              AppMethodBeat.i(144426);
              parama.C(paramAnonymousJSONObject);
              AppMethodBeat.o(144426);
            }
            
            public final void I(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3)
            {
              AppMethodBeat.i(144428);
              ad.e("MicroMsg.AppBrandPreloadNetworkDownload", "download error! filename %s, url %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
              paramAnonymousString1 = ((ConcurrentLinkedQueue)m.a(m.this).get(paramAnonymousString2)).iterator();
              while (paramAnonymousString1.hasNext()) {
                ((b.a)paramAnonymousString1.next()).ae(m.FAILED, paramAnonymousString3);
              }
              m.a(m.this, paramString1);
              AppMethodBeat.o(144428);
            }
            
            public final void SH(String paramAnonymousString)
            {
              AppMethodBeat.i(144430);
              m.this.lVA.remove(paramAnonymousString);
              AppMethodBeat.o(144430);
            }
            
            public final void a(String paramAnonymousString, int paramAnonymousInt, long paramAnonymousLong1, long paramAnonymousLong2)
            {
              AppMethodBeat.i(144427);
              paramAnonymousString = ((ConcurrentLinkedQueue)m.a(m.this).get(paramAnonymousString)).iterator();
              while (paramAnonymousString.hasNext()) {
                ((b.a)paramAnonymousString.next()).g(paramAnonymousInt, paramAnonymousLong1, paramAnonymousLong2);
              }
              AppMethodBeat.o(144427);
            }
            
            public final void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt, long paramAnonymousLong, Map paramAnonymousMap)
            {
              AppMethodBeat.i(175395);
              m.a(m.this, paramString1);
              Iterator localIterator = ((ConcurrentLinkedQueue)m.a(m.this).get(paramAnonymousString3)).iterator();
              while (localIterator.hasNext()) {
                ((b.a)localIterator.next()).a(m.SUCCESS, paramAnonymousString2, paramAnonymousString1, paramAnonymousInt, paramAnonymousLong, paramAnonymousMap);
              }
              ad.i("MicroMsg.AppBrandPreloadNetworkDownload", "download success! filename %s, url %s", new Object[] { paramAnonymousString1, paramAnonymousString3 });
              AppMethodBeat.o(175395);
            }
            
            public final void ef(String paramAnonymousString1, String paramAnonymousString2)
            {
              AppMethodBeat.i(144429);
              ad.i("MicroMsg.AppBrandPreloadNetworkDownload", "download start! filename %s, url %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
              AppMethodBeat.o(144429);
            }
          });
          paramJSONObject.lWV = ???;
          paramJSONObject.timeout = paramInt1;
          paramJSONObject.isRunning = true;
          paramJSONObject.lWb = ???;
          paramJSONObject.lWW = paramInt2;
          paramJSONObject.lVz = this.lVz;
          paramJSONObject.iFB = paramString1;
          paramJSONObject.lWg = paramString2;
        }
      }
      synchronized (this.lVC)
      {
        if (this.lVC.size() >= this.lVx) {
          synchronized (this.lWA)
          {
            this.lWA.add(paramJSONObject);
            AppMethodBeat.o(144432);
            return;
            localConcurrentLinkedQueue = (ConcurrentLinkedQueue)this.lWz.get(str2);
            localConcurrentLinkedQueue.offer(parama);
            ad.w("MicroMsg.AppBrandPreloadNetworkDownload", "predownload the same task is working url:%s,size:%d", new Object[] { str2, Integer.valueOf(localConcurrentLinkedQueue.size()) });
            continue;
            paramJSONObject = finally;
            AppMethodBeat.o(144432);
            throw paramJSONObject;
          }
        }
      }
    }
    this.lVC.add(paramJSONObject);
    com.tencent.mm.sdk.g.b.c(paramJSONObject, "appbrand_predownload_thread");
    AppMethodBeat.o(144432);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o.m
 * JD-Core Version:    0.7.0.1
 */