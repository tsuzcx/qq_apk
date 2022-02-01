package com.tencent.mm.plugin.appbrand.p;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
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
  private c jOV;
  private final Map<String, ConcurrentLinkedQueue<b.a>> joW;
  private boolean kBv;
  private final String kXC;
  private int lwk;
  private String lwl;
  private SSLContext lwm;
  protected final ArrayList<String> lwn;
  public final ArrayList<com.tencent.mm.plugin.appbrand.p.a.b> lwp;
  public final ConcurrentLinkedQueue<com.tencent.mm.plugin.appbrand.p.a.b> lxm;
  
  public m(c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(144431);
    this.lwl = (com.tencent.mm.loader.j.b.apj() + "appbrand/");
    this.kBv = false;
    this.lwn = new ArrayList();
    this.lwp = new ArrayList();
    this.lxm = new ConcurrentLinkedQueue();
    this.jOV = paramc;
    paramc = (a)paramc.ar(a.class);
    this.lwk = paramc.ccx;
    this.kXC = paramc.lwh;
    this.lwm = j.a(paramc);
    this.joW = new Hashtable(10);
    this.kBv = paramBoolean;
    AppMethodBeat.o(144431);
  }
  
  public final void a(JSONObject paramJSONObject, int paramInt1, Map<String, String> arg3, ArrayList<String> arg4, int paramInt2, final b.a parama, final String paramString1, String paramString2)
  {
    AppMethodBeat.i(144432);
    String str2 = paramJSONObject.optString("url");
    ac.i("MicroMsg.AppBrandPreloadNetworkDownload", "predownload taskId:%s url:%s", new Object[] { paramString1, str2 });
    String str1 = this.lwl + ah.dg(str2) + "temp";
    str2 = j.Pp(str2);
    for (;;)
    {
      ConcurrentLinkedQueue localConcurrentLinkedQueue;
      synchronized (this.joW)
      {
        if (this.joW.get(str2) == null)
        {
          localConcurrentLinkedQueue = new ConcurrentLinkedQueue();
          localConcurrentLinkedQueue.offer(parama);
          this.joW.put(str2, localConcurrentLinkedQueue);
          ??? = paramJSONObject.optString("filePath");
          boolean bool1 = paramJSONObject.optBoolean("enableHttp2", false);
          boolean bool2 = paramJSONObject.optBoolean("enableQuic", false);
          boolean bool3 = paramJSONObject.optBoolean("enableCache", false);
          boolean bool4 = paramJSONObject.optBoolean("enableProfile", true);
          paramJSONObject = new com.tencent.mm.plugin.appbrand.p.a.b(this.jOV, str2, str1, (String)???, this.kXC, this.kBv, bool1, bool2, bool3, bool4, new com.tencent.mm.plugin.appbrand.p.a.a()
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
              ac.e("MicroMsg.AppBrandPreloadNetworkDownload", "download error! filename %s, url %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
              paramAnonymousString1 = ((ConcurrentLinkedQueue)m.a(m.this).get(paramAnonymousString2)).iterator();
              while (paramAnonymousString1.hasNext()) {
                ((b.a)paramAnonymousString1.next()).ac(m.FAILED, paramAnonymousString3);
              }
              m.a(m.this, paramString1);
              AppMethodBeat.o(144428);
            }
            
            public final void Pf(String paramAnonymousString)
            {
              AppMethodBeat.i(144430);
              m.this.lwn.remove(paramAnonymousString);
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
              ac.i("MicroMsg.AppBrandPreloadNetworkDownload", "download success! filename %s, url %s", new Object[] { paramAnonymousString1, paramAnonymousString3 });
              AppMethodBeat.o(175395);
            }
            
            public final void dV(String paramAnonymousString1, String paramAnonymousString2)
            {
              AppMethodBeat.i(144429);
              ac.i("MicroMsg.AppBrandPreloadNetworkDownload", "download start! filename %s, url %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
              AppMethodBeat.o(144429);
            }
          });
          paramJSONObject.lxH = ???;
          paramJSONObject.timeout = paramInt1;
          paramJSONObject.isRunning = true;
          paramJSONObject.lwO = ???;
          paramJSONObject.lxI = paramInt2;
          paramJSONObject.lwm = this.lwm;
          paramJSONObject.imk = paramString1;
          paramJSONObject.lwT = paramString2;
        }
      }
      synchronized (this.lwp)
      {
        if (this.lwp.size() >= this.lwk) {
          synchronized (this.lxm)
          {
            this.lxm.add(paramJSONObject);
            AppMethodBeat.o(144432);
            return;
            localConcurrentLinkedQueue = (ConcurrentLinkedQueue)this.joW.get(str2);
            localConcurrentLinkedQueue.offer(parama);
            ac.w("MicroMsg.AppBrandPreloadNetworkDownload", "predownload the same task is working url:%s,size:%d", new Object[] { str2, Integer.valueOf(localConcurrentLinkedQueue.size()) });
            continue;
            paramJSONObject = finally;
            AppMethodBeat.o(144432);
            throw paramJSONObject;
          }
        }
      }
    }
    this.lwp.add(paramJSONObject);
    com.tencent.mm.sdk.g.b.c(paramJSONObject, "appbrand_predownload_thread");
    AppMethodBeat.o(144432);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.p.m
 * JD-Core Version:    0.7.0.1
 */