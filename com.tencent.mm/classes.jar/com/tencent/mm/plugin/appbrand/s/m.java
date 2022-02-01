package com.tencent.mm.plugin.appbrand.s;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.s.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
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
  public f lqg;
  public String mGo;
  private boolean mgB;
  public int nhP;
  private String nhQ;
  public SSLContext nhR;
  protected final ArrayList<String> nhS;
  public final ArrayList<com.tencent.mm.plugin.appbrand.s.a.b> nhU;
  private final Map<String, ConcurrentLinkedQueue<b.a>> niQ;
  public final Map<String, a> niR;
  public final ConcurrentLinkedQueue<com.tencent.mm.plugin.appbrand.s.a.b> niS;
  
  public m(f paramf, boolean paramBoolean)
  {
    AppMethodBeat.i(144431);
    this.nhQ = (com.tencent.mm.loader.j.b.aKM() + "appbrand/");
    this.mgB = false;
    this.nhS = new ArrayList();
    this.nhU = new ArrayList();
    this.niS = new ConcurrentLinkedQueue();
    this.lqg = paramf;
    this.nhP = 2147483647;
    this.niQ = new Hashtable(10);
    this.niR = new HashMap();
    this.mgB = paramBoolean;
    AppMethodBeat.o(144431);
  }
  
  public final void a(JSONObject paramJSONObject, int paramInt1, Map<String, String> arg3, ArrayList<String> arg4, int paramInt2, final b.a parama, final String paramString1, String paramString2)
  {
    AppMethodBeat.i(144432);
    String str = paramJSONObject.optString("url");
    Log.i("MicroMsg.AppBrandPreloadNetworkDownload", "predownload taskId:%s url:%s", new Object[] { paramString1, str });
    synchronized (this.niR)
    {
      ??? = (a)this.niR.get(str);
      if (??? != null)
      {
        Log.i("MicroMsg.AppBrandPreloadNetworkDownload", "already downloaded return cached file:%s url:%s", new Object[] { ((a)???).filePath, str });
        parama.a(SUCCESS, ((a)???).mimeType, ((a)???).filePath, ((a)???).statusCode, ((a)???).niU, null);
        this.niR.remove(str);
        AppMethodBeat.o(144432);
        return;
      }
      ??? = this.nhQ + MD5Util.getMD5String(str) + "temp";
      str = j.adg(str);
      synchronized (this.niQ)
      {
        if (this.niQ.get(str) == null)
        {
          ConcurrentLinkedQueue localConcurrentLinkedQueue = new ConcurrentLinkedQueue();
          localConcurrentLinkedQueue.offer(parama);
          this.niQ.put(str, localConcurrentLinkedQueue);
          ??? = paramJSONObject.optString("filePath");
          boolean bool1 = paramJSONObject.optBoolean("enableHttp2", false);
          boolean bool2 = paramJSONObject.optBoolean("enableQuic", false);
          boolean bool3 = paramJSONObject.optBoolean("enableCache", false);
          boolean bool4 = paramJSONObject.optBoolean("enableProfile", true);
          paramJSONObject = new com.tencent.mm.plugin.appbrand.s.a.b(this.lqg, str, (String)???, (String)???, this.mGo, this.mgB, bool1, bool2, bool3, bool4, new a()
          {
            public final void J(JSONObject paramAnonymousJSONObject)
            {
              AppMethodBeat.i(207104);
              parama.J(paramAnonymousJSONObject);
              AppMethodBeat.o(207104);
            }
            
            public final void K(String arg1, String paramAnonymousString2, String paramAnonymousString3)
            {
              AppMethodBeat.i(207106);
              Log.e("MicroMsg.AppBrandPreloadNetworkDownload", "download error! filename %s, url %s", new Object[] { ???, paramAnonymousString2 });
              ArrayList localArrayList = new ArrayList();
              synchronized (m.b(m.this))
              {
                localArrayList.addAll((Collection)m.b(m.this).get(paramAnonymousString2));
                m.b(m.this).remove(paramAnonymousString2);
                ??? = localArrayList.iterator();
                if (???.hasNext()) {
                  ((b.a)???.next()).ah(m.FAILED, paramAnonymousString3);
                }
              }
              m.a(m.this, paramString1);
              AppMethodBeat.o(207106);
            }
            
            public final void a(String paramAnonymousString, int paramAnonymousInt, long paramAnonymousLong1, long paramAnonymousLong2)
            {
              AppMethodBeat.i(207105);
              paramAnonymousString = ((ConcurrentLinkedQueue)m.b(m.this).get(paramAnonymousString)).iterator();
              while (paramAnonymousString.hasNext()) {
                ((b.a)paramAnonymousString.next()).h(paramAnonymousInt, paramAnonymousLong1, paramAnonymousLong2);
              }
              AppMethodBeat.o(207105);
            }
            
            public final void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt, long paramAnonymousLong, Map paramAnonymousMap)
            {
              AppMethodBeat.i(207103);
              m.a(m.this, paramString1);
              ArrayList localArrayList = new ArrayList();
              synchronized (m.b(m.this))
              {
                localArrayList.addAll((Collection)m.b(m.this).get(paramAnonymousString3));
                m.b(m.this).remove(paramAnonymousString3);
                ??? = localArrayList.iterator();
                if (((Iterator)???).hasNext()) {
                  ((b.a)((Iterator)???).next()).a(m.SUCCESS, paramAnonymousString2, paramAnonymousString1, paramAnonymousInt, paramAnonymousLong, paramAnonymousMap);
                }
              }
              Log.i("MicroMsg.AppBrandPreloadNetworkDownload", "download success! filename %s, url %s", new Object[] { paramAnonymousString1, paramAnonymousString3 });
              AppMethodBeat.o(207103);
            }
            
            public final void acU(String paramAnonymousString)
            {
              AppMethodBeat.i(207108);
              m.this.nhS.remove(paramAnonymousString);
              AppMethodBeat.o(207108);
            }
            
            public final void ey(String paramAnonymousString1, String paramAnonymousString2)
            {
              AppMethodBeat.i(207107);
              Log.i("MicroMsg.AppBrandPreloadNetworkDownload", "download start! filename %s, url %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
              AppMethodBeat.o(207107);
            }
          });
          paramJSONObject.njn = ???;
          paramJSONObject.timeout = paramInt1;
          paramJSONObject.isRunning = true;
          paramJSONObject.nis = ???;
          paramJSONObject.njo = paramInt2;
          paramJSONObject.nhR = this.nhR;
          paramJSONObject.jEY = paramString1;
          paramJSONObject.nix = paramString2;
        }
      }
    }
    synchronized (this.nhU)
    {
      if (this.nhU.size() >= this.nhP) {
        synchronized (this.niS)
        {
          this.niS.add(paramJSONObject);
          AppMethodBeat.o(144432);
          return;
          paramJSONObject = finally;
          AppMethodBeat.o(144432);
          throw paramJSONObject;
          paramJSONObject = (ConcurrentLinkedQueue)this.niQ.get(str);
          paramJSONObject.offer(parama);
          Log.i("MicroMsg.AppBrandPreloadNetworkDownload", "predownload the same task is working url:%s,size:%d", new Object[] { str, Integer.valueOf(paramJSONObject.size()) });
          AppMethodBeat.o(144432);
          return;
          paramJSONObject = finally;
          AppMethodBeat.o(144432);
          throw paramJSONObject;
        }
      }
    }
    this.nhU.add(paramJSONObject);
    ThreadPool.post(paramJSONObject, "appbrand_predownload_thread");
    AppMethodBeat.o(144432);
  }
  
  public final Boolean adi(String paramString)
  {
    AppMethodBeat.i(207109);
    synchronized (this.niR)
    {
      boolean bool = this.niR.containsKey(paramString);
      AppMethodBeat.o(207109);
      return Boolean.valueOf(bool);
    }
  }
  
  static final class a
  {
    String filePath;
    String mimeType;
    long niU;
    int statusCode;
    String url;
    
    public a(String paramString1, String paramString2, String paramString3, int paramInt, long paramLong)
    {
      this.filePath = paramString1;
      this.mimeType = paramString2;
      this.url = paramString3;
      this.statusCode = paramInt;
      this.niU = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.s.m
 * JD-Core Version:    0.7.0.1
 */