package com.tencent.mm.plugin.appbrand.q;

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
  private final Map<String, ConcurrentLinkedQueue<b.a>> iON;
  private c joJ;
  private int kUA;
  private String kUB;
  private SSLContext kUC;
  protected final ArrayList<String> kUD;
  public final ArrayList<com.tencent.mm.plugin.appbrand.q.a.b> kUF;
  public final ConcurrentLinkedQueue<com.tencent.mm.plugin.appbrand.q.a.b> kVC;
  private boolean kaI;
  private final String kwo;
  
  public m(c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(144431);
    this.kUB = (com.tencent.mm.loader.j.b.aij() + "appbrand/");
    this.kaI = false;
    this.kUD = new ArrayList();
    this.kUF = new ArrayList();
    this.kVC = new ConcurrentLinkedQueue();
    this.joJ = paramc;
    paramc = (a)paramc.ar(a.class);
    this.kUA = paramc.cfA;
    this.kwo = paramc.kUx;
    this.kUC = j.a(paramc);
    this.iON = new Hashtable(10);
    this.kaI = paramBoolean;
    AppMethodBeat.o(144431);
  }
  
  public final void a(JSONObject paramJSONObject, int paramInt1, Map<String, String> arg3, ArrayList<String> arg4, int paramInt2, final b.a parama, final String paramString1, String paramString2)
  {
    AppMethodBeat.i(144432);
    String str2 = paramJSONObject.optString("url");
    ad.i("MicroMsg.AppBrandPreloadNetworkDownload", "predownload taskId:%s url:%s", new Object[] { paramString1, str2 });
    String str1 = this.kUB + ai.du(str2) + "temp";
    str2 = j.Lh(str2);
    for (;;)
    {
      ConcurrentLinkedQueue localConcurrentLinkedQueue;
      synchronized (this.iON)
      {
        if (this.iON.get(str2) == null)
        {
          localConcurrentLinkedQueue = new ConcurrentLinkedQueue();
          localConcurrentLinkedQueue.offer(parama);
          this.iON.put(str2, localConcurrentLinkedQueue);
          ??? = paramJSONObject.optString("filePath");
          boolean bool1 = paramJSONObject.optBoolean("enableHttp2", false);
          boolean bool2 = paramJSONObject.optBoolean("enableQuic", false);
          boolean bool3 = paramJSONObject.optBoolean("enableCache", false);
          boolean bool4 = paramJSONObject.optBoolean("enableProfile", true);
          paramJSONObject = new com.tencent.mm.plugin.appbrand.q.a.b(this.joJ, str2, str1, (String)???, this.kwo, this.kaI, bool1, bool2, bool3, bool4, new com.tencent.mm.plugin.appbrand.q.a.a()
          {
            public final void C(JSONObject paramAnonymousJSONObject)
            {
              AppMethodBeat.i(144426);
              parama.C(paramAnonymousJSONObject);
              AppMethodBeat.o(144426);
            }
            
            public final void J(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3)
            {
              AppMethodBeat.i(144428);
              ad.e("MicroMsg.AppBrandPreloadNetworkDownload", "download error! filename %s, url %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
              paramAnonymousString1 = ((ConcurrentLinkedQueue)m.a(m.this).get(paramAnonymousString2)).iterator();
              while (paramAnonymousString1.hasNext()) {
                ((b.a)paramAnonymousString1.next()).ab(m.FAILED, paramAnonymousString3);
              }
              m.a(m.this, paramString1);
              AppMethodBeat.o(144428);
            }
            
            public final void KX(String paramAnonymousString)
            {
              AppMethodBeat.i(144430);
              m.this.kUD.remove(paramAnonymousString);
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
            
            public final void dJ(String paramAnonymousString1, String paramAnonymousString2)
            {
              AppMethodBeat.i(144429);
              ad.i("MicroMsg.AppBrandPreloadNetworkDownload", "download start! filename %s, url %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
              AppMethodBeat.o(144429);
            }
          });
          paramJSONObject.kVX = ???;
          paramJSONObject.timeout = paramInt1;
          paramJSONObject.isRunning = true;
          paramJSONObject.kVe = ???;
          paramJSONObject.kVY = paramInt2;
          paramJSONObject.kUC = this.kUC;
          paramJSONObject.hLO = paramString1;
          paramJSONObject.kVj = paramString2;
        }
      }
      synchronized (this.kUF)
      {
        if (this.kUF.size() >= this.kUA) {
          synchronized (this.kVC)
          {
            this.kVC.add(paramJSONObject);
            AppMethodBeat.o(144432);
            return;
            localConcurrentLinkedQueue = (ConcurrentLinkedQueue)this.iON.get(str2);
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
    this.kUF.add(paramJSONObject);
    com.tencent.mm.sdk.g.b.c(paramJSONObject, "appbrand_predownload_thread");
    AppMethodBeat.o(144432);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q.m
 * JD-Core Version:    0.7.0.1
 */