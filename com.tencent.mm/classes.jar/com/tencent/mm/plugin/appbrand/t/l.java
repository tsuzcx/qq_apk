package com.tencent.mm.plugin.appbrand.t;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.t.a.a;
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

public final class l
{
  public static int FAILED = -1;
  public static int SUCCESS = 0;
  public f rot;
  public String sKB;
  private boolean sjY;
  public int tnk;
  private String tnl;
  public SSLContext tnm;
  protected final ArrayList<String> tnn;
  public final ArrayList<com.tencent.mm.plugin.appbrand.t.a.b> tnp;
  private final Map<String, ConcurrentLinkedQueue<b.a>> tor;
  public final Map<String, a> tos;
  public final ConcurrentLinkedQueue<com.tencent.mm.plugin.appbrand.t.a.b> tot;
  
  public l(f paramf)
  {
    AppMethodBeat.i(319164);
    this.tnl = (com.tencent.mm.loader.i.b.bmC() + "appbrand/");
    this.sjY = false;
    this.tnn = new ArrayList();
    this.tnp = new ArrayList();
    this.tot = new ConcurrentLinkedQueue();
    this.rot = paramf;
    this.tnk = 2147483647;
    this.tor = new Hashtable(10);
    this.tos = new HashMap();
    this.sjY = true;
    AppMethodBeat.o(319164);
  }
  
  public final void a(JSONObject paramJSONObject, int paramInt1, Map<String, String> arg3, ArrayList<String> arg4, int paramInt2, final b.a parama, final String paramString1, String paramString2)
  {
    AppMethodBeat.i(144432);
    String str = paramJSONObject.optString("url");
    Log.i("MicroMsg.AppBrandPreloadNetworkDownload", "predownload taskId:%s url:%s", new Object[] { paramString1, str });
    synchronized (this.tos)
    {
      ??? = (a)this.tos.get(str);
      if (??? != null)
      {
        Log.i("MicroMsg.AppBrandPreloadNetworkDownload", "already downloaded return cached file:%s url:%s", new Object[] { ((a)???).filePath, str });
        parama.a(SUCCESS, ((a)???).mimeType, ((a)???).filePath, ((a)???).statusCode, ((a)???).tov, null);
        this.tos.remove(str);
        AppMethodBeat.o(144432);
        return;
      }
      ??? = this.tnl + MD5Util.getMD5String(str) + "temp";
      str = i.aeg(str);
      synchronized (this.tor)
      {
        if (this.tor.get(str) == null)
        {
          ConcurrentLinkedQueue localConcurrentLinkedQueue = new ConcurrentLinkedQueue();
          localConcurrentLinkedQueue.offer(parama);
          this.tor.put(str, localConcurrentLinkedQueue);
          ??? = paramJSONObject.optString("filePath");
          boolean bool1 = paramJSONObject.optBoolean("enableHttp2", false);
          boolean bool2 = paramJSONObject.optBoolean("enableQuic", false);
          boolean bool3 = paramJSONObject.optBoolean("enableCache", false);
          boolean bool4 = paramJSONObject.optBoolean("enableProfile", true);
          paramJSONObject = new com.tencent.mm.plugin.appbrand.t.a.b(this.rot, str, (String)???, (String)???, this.sKB, this.sjY, bool1, bool2, bool3, bool4, new a()
          {
            public final void O(String arg1, String paramAnonymousString2, String paramAnonymousString3)
            {
              AppMethodBeat.i(319148);
              Log.e("MicroMsg.AppBrandPreloadNetworkDownload", "download error! filename %s, url %s", new Object[] { ???, paramAnonymousString2 });
              ArrayList localArrayList = new ArrayList();
              synchronized (l.b(l.this))
              {
                localArrayList.addAll((Collection)l.b(l.this).get(paramAnonymousString2));
                l.b(l.this).remove(paramAnonymousString2);
                ??? = localArrayList.iterator();
                if (???.hasNext()) {
                  ((b.a)???.next()).at(l.FAILED, paramAnonymousString3);
                }
              }
            }
            
            public final void X(JSONObject paramAnonymousJSONObject)
            {
              AppMethodBeat.i(319142);
              parama.X(paramAnonymousJSONObject);
              AppMethodBeat.o(319142);
            }
            
            public final void a(String paramAnonymousString, int paramAnonymousInt, long paramAnonymousLong1, long paramAnonymousLong2)
            {
              AppMethodBeat.i(319146);
              paramAnonymousString = ((ConcurrentLinkedQueue)l.b(l.this).get(paramAnonymousString)).iterator();
              while (paramAnonymousString.hasNext()) {
                ((b.a)paramAnonymousString.next()).j(paramAnonymousInt, paramAnonymousLong1, paramAnonymousLong2);
              }
              AppMethodBeat.o(319146);
            }
            
            /* Error */
            public final void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt, long paramAnonymousLong, Map paramAnonymousMap)
            {
              // Byte code:
              //   0: ldc 116
              //   2: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
              //   5: aload_0
              //   6: getfield 21	com/tencent/mm/plugin/appbrand/t/l$2:tou	Lcom/tencent/mm/plugin/appbrand/t/l;
              //   9: aload_0
              //   10: getfield 23	com/tencent/mm/plugin/appbrand/t/l$2:ruW	Ljava/lang/String;
              //   13: invokestatic 100	com/tencent/mm/plugin/appbrand/t/l:a	(Lcom/tencent/mm/plugin/appbrand/t/l;Ljava/lang/String;)V
              //   16: new 50	java/util/ArrayList
              //   19: dup
              //   20: invokespecial 51	java/util/ArrayList:<init>	()V
              //   23: astore 9
              //   25: aload_0
              //   26: getfield 21	com/tencent/mm/plugin/appbrand/t/l$2:tou	Lcom/tencent/mm/plugin/appbrand/t/l;
              //   29: invokestatic 55	com/tencent/mm/plugin/appbrand/t/l:b	(Lcom/tencent/mm/plugin/appbrand/t/l;)Ljava/util/Map;
              //   32: astore 8
              //   34: aload 8
              //   36: monitorenter
              //   37: aload 9
              //   39: aload_0
              //   40: getfield 21	com/tencent/mm/plugin/appbrand/t/l$2:tou	Lcom/tencent/mm/plugin/appbrand/t/l;
              //   43: invokestatic 55	com/tencent/mm/plugin/appbrand/t/l:b	(Lcom/tencent/mm/plugin/appbrand/t/l;)Ljava/util/Map;
              //   46: aload_3
              //   47: invokeinterface 61 2 0
              //   52: checkcast 63	java/util/Collection
              //   55: invokevirtual 67	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
              //   58: pop
              //   59: aload_0
              //   60: getfield 21	com/tencent/mm/plugin/appbrand/t/l$2:tou	Lcom/tencent/mm/plugin/appbrand/t/l;
              //   63: invokestatic 55	com/tencent/mm/plugin/appbrand/t/l:b	(Lcom/tencent/mm/plugin/appbrand/t/l;)Ljava/util/Map;
              //   66: aload_3
              //   67: invokeinterface 70 2 0
              //   72: pop
              //   73: aload 8
              //   75: monitorexit
              //   76: aload 9
              //   78: invokevirtual 74	java/util/ArrayList:iterator	()Ljava/util/Iterator;
              //   81: astore 8
              //   83: aload 8
              //   85: invokeinterface 80 1 0
              //   90: ifeq +43 -> 133
              //   93: aload 8
              //   95: invokeinterface 84 1 0
              //   100: checkcast 86	com/tencent/mm/plugin/appbrand/t/b$a
              //   103: getstatic 119	com/tencent/mm/plugin/appbrand/t/l:SUCCESS	I
              //   106: aload_2
              //   107: aload_1
              //   108: iload 4
              //   110: lload 5
              //   112: aload 7
              //   114: invokeinterface 122 8 0
              //   119: goto -36 -> 83
              //   122: astore_1
              //   123: aload 8
              //   125: monitorexit
              //   126: ldc 116
              //   128: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
              //   131: aload_1
              //   132: athrow
              //   133: ldc 40
              //   135: ldc 124
              //   137: iconst_2
              //   138: anewarray 4	java/lang/Object
              //   141: dup
              //   142: iconst_0
              //   143: aload_1
              //   144: aastore
              //   145: dup
              //   146: iconst_1
              //   147: aload_3
              //   148: aastore
              //   149: invokestatic 126	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
              //   152: ldc 116
              //   154: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
              //   157: return
              // Local variable table:
              //   start	length	slot	name	signature
              //   0	158	0	this	2
              //   0	158	1	paramAnonymousString1	String
              //   0	158	2	paramAnonymousString2	String
              //   0	158	3	paramAnonymousString3	String
              //   0	158	4	paramAnonymousInt	int
              //   0	158	5	paramAnonymousLong	long
              //   0	158	7	paramAnonymousMap	Map
              //   23	54	9	localArrayList	ArrayList
              // Exception table:
              //   from	to	target	type
              //   37	76	122	finally
            }
            
            public final void adV(String paramAnonymousString)
            {
              AppMethodBeat.i(319154);
              l.this.tnn.remove(paramAnonymousString);
              AppMethodBeat.o(319154);
            }
            
            public final void fd(String paramAnonymousString1, String paramAnonymousString2)
            {
              AppMethodBeat.i(319152);
              Log.i("MicroMsg.AppBrandPreloadNetworkDownload", "download start! filename %s, url %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
              AppMethodBeat.o(319152);
            }
          });
          paramJSONObject.toO = ???;
          paramJSONObject.timeout = paramInt1;
          paramJSONObject.Uz = true;
          paramJSONObject.tnQ = ???;
          paramJSONObject.toP = paramInt2;
          paramJSONObject.tnm = this.tnm;
          paramJSONObject.ppa = paramString1;
          paramJSONObject.tnV = paramString2;
        }
      }
    }
    synchronized (this.tnp)
    {
      if (this.tnp.size() >= this.tnk) {
        synchronized (this.tot)
        {
          this.tot.add(paramJSONObject);
          AppMethodBeat.o(144432);
          return;
          paramJSONObject = finally;
          AppMethodBeat.o(144432);
          throw paramJSONObject;
          paramJSONObject = (ConcurrentLinkedQueue)this.tor.get(str);
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
    this.tnp.add(paramJSONObject);
    ThreadPool.post(paramJSONObject, "appbrand_predownload_thread");
    AppMethodBeat.o(144432);
  }
  
  public final Boolean aei(String paramString)
  {
    AppMethodBeat.i(319180);
    synchronized (this.tos)
    {
      boolean bool = this.tos.containsKey(paramString);
      AppMethodBeat.o(319180);
      return Boolean.valueOf(bool);
    }
  }
  
  static final class a
  {
    String filePath;
    String mimeType;
    int statusCode;
    long tov;
    String url;
    
    public a(String paramString1, String paramString2, String paramString3, int paramInt, long paramLong)
    {
      this.filePath = paramString1;
      this.mimeType = paramString2;
      this.url = paramString3;
      this.statusCode = paramInt;
      this.tov = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.t.l
 * JD-Core Version:    0.7.0.1
 */