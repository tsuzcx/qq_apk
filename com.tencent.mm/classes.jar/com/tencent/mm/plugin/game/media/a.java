package com.tencent.mm.plugin.game.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.b.p;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.i.c;
import com.tencent.mm.plugin.game.b.b.f;
import com.tencent.mm.plugin.game.b.b.g;
import com.tencent.mm.plugin.game.b.b.h;
import com.tencent.mm.plugin.game.b.b.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
{
  private static long pFU;
  private static a uhK;
  private static final String uhw;
  private static final String uhx;
  private int fVS;
  private Object lock;
  private LinkedList<com.tencent.mm.plugin.game.b.b.e> uhA;
  LinkedList<com.tencent.mm.plugin.game.b.b.e> uhB;
  LinkedList<com.tencent.mm.plugin.game.b.b.e> uhC;
  private boolean uhD;
  private String uhE;
  private long uhF;
  private int uhG;
  private boolean uhH;
  private d uhI;
  private int uhJ;
  private final HashMap<String, b> uhy;
  private h uhz;
  
  static
  {
    AppMethodBeat.i(40942);
    uhw = com.tencent.mm.plugin.game.commlib.util.b.b(com.tencent.mm.plugin.game.commlib.util.b.a.udW) + "haowan/";
    uhx = uhw + "haowan_gallery_cache";
    pFU = 0L;
    AppMethodBeat.o(40942);
  }
  
  public a()
  {
    AppMethodBeat.i(40913);
    this.lock = new Object();
    this.uhy = new HashMap();
    this.uhA = new LinkedList();
    this.uhB = new LinkedList();
    this.uhC = new LinkedList();
    this.uhD = false;
    this.uhI = null;
    this.uhJ = 0;
    this.uhE = ay.aRW(Lv("game_haowan_mmkv_key")).getString("game_remote_ticket", null);
    this.uhF = ay.aRW(Lv("game_haowan_mmkv_key")).getLong("game_local_ticket", 0L);
    daq();
    AppMethodBeat.o(40913);
  }
  
  public static void Ia(int paramInt)
  {
    AppMethodBeat.i(40925);
    ay localay = ay.aRW(Lv("game_haowan_mmkv_key"));
    localay.putInt("game_last_choose_gallery", paramInt);
    localay.apply();
    AppMethodBeat.o(40925);
  }
  
  private static String Ib(int paramInt)
  {
    AppMethodBeat.i(40932);
    String str = new p(paramInt).toString();
    AppMethodBeat.o(40932);
    return str;
  }
  
  private static String Lv(String paramString)
  {
    AppMethodBeat.i(40931);
    int i = com.tencent.mm.kernel.a.ajc();
    if (i == 0)
    {
      AppMethodBeat.o(40931);
      return paramString;
    }
    paramString = paramString + "_" + Ib(i);
    AppMethodBeat.o(40931);
    return paramString;
  }
  
  public static void a(int paramInt, c paramc)
  {
    AppMethodBeat.i(40924);
    com.tencent.mm.plugin.gallery.model.e.cXr().setQueryType(paramInt);
    com.tencent.mm.plugin.gallery.model.e.cXr().kXg = 15;
    com.tencent.mm.plugin.gallery.model.e.cXr().a(new i.c()
    {
      public final void b(LinkedList<GalleryItem.MediaItem> paramAnonymousLinkedList, long paramAnonymousLong, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(40911);
        if ((a.daB() == paramAnonymousLong) && (this.uhQ != null)) {
          this.uhQ.au(paramAnonymousLinkedList);
        }
        AppMethodBeat.o(40911);
      }
    });
    pFU = System.currentTimeMillis();
    com.tencent.mm.plugin.gallery.model.e.cXr().ax("", pFU);
    AppMethodBeat.o(40924);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(40912);
    if (uhK == null)
    {
      parama.b(null, false);
      AppMethodBeat.o(40912);
      return;
    }
    uhK.b(new a()
    {
      public final void b(LinkedList<com.tencent.mm.plugin.game.b.b.e> paramAnonymousLinkedList, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(40907);
        if (this.uhL != null) {
          this.uhL.b(a.daA().uhC, paramAnonymousBoolean);
        }
        AppMethodBeat.o(40907);
      }
    });
    AppMethodBeat.o(40912);
  }
  
  public static void a(a parama)
  {
    uhK = parama;
  }
  
  private static void daq()
  {
    AppMethodBeat.i(40915);
    k localk = new k(uhw);
    if ((!localk.exists()) || (!localk.isDirectory())) {
      localk.mkdirs();
    }
    AppMethodBeat.o(40915);
  }
  
  private int das()
  {
    AppMethodBeat.i(40919);
    if (this.uhF == 0L)
    {
      AppMethodBeat.o(40919);
      return 0;
    }
    int i = j.daH().b(dat(), System.currentTimeMillis(), this.uhF + 1L);
    AppMethodBeat.o(40919);
    return i;
  }
  
  private LinkedList<String> dat()
  {
    AppMethodBeat.i(40920);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.uhy.values().iterator();
    while (localIterator.hasNext()) {
      localLinkedList.add(((b)localIterator.next()).tRB);
    }
    AppMethodBeat.o(40920);
    return localLinkedList;
  }
  
  public static int dav()
  {
    AppMethodBeat.i(40926);
    int i = ay.aRW(Lv("game_haowan_mmkv_key")).getInt("game_last_choose_gallery", 0);
    AppMethodBeat.o(40926);
    return i;
  }
  
  public static void daw()
  {
    AppMethodBeat.i(40927);
    ay localay = ay.aRW(Lv("game_haowan_mmkv_key"));
    localay.putBoolean("game_tab_gallery_first_enter", false);
    localay.apply();
    AppMethodBeat.o(40927);
  }
  
  public static boolean dax()
  {
    AppMethodBeat.i(40928);
    boolean bool = ay.aRW(Lv("game_haowan_mmkv_key")).getBoolean("game_tab_gallery_first_enter", true);
    AppMethodBeat.o(40928);
    return bool;
  }
  
  public static void day()
  {
    AppMethodBeat.i(40929);
    ay localay = ay.aRW(Lv("game_haowan_mmkv_key"));
    localay.putBoolean("game_publish_gallery_first_enter", false);
    localay.apply();
    AppMethodBeat.o(40929);
  }
  
  public static boolean daz()
  {
    AppMethodBeat.i(40930);
    boolean bool = ay.aRW(Lv("game_haowan_mmkv_key")).getBoolean("game_publish_gallery_first_enter", true);
    AppMethodBeat.o(40930);
    return bool;
  }
  
  private static void safeClose(Closeable paramCloseable)
  {
    AppMethodBeat.i(40918);
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      AppMethodBeat.o(40918);
      return;
    }
    catch (IOException paramCloseable)
    {
      AppMethodBeat.o(40918);
    }
  }
  
  public final void b(final a parama)
  {
    AppMethodBeat.i(40921);
    if (this.uhD)
    {
      ae.i("MicroMsg.GameHaowanDataCenter", "gettingDataFromNet, return");
      AppMethodBeat.o(40921);
      return;
    }
    ae.d("MicroMsg.GameHaowanDataCenter", "getDataFromNet");
    this.uhD = true;
    final g localg = new g();
    if (this.uhz != null) {}
    for (long l = this.uhz.ude;; l = 0L)
    {
      localg.offset = l;
      if (localg.offset == 0L) {
        localg.ucP = this.uhE;
      }
      com.tencent.mm.ak.b.a locala = new com.tencent.mm.ak.b.a();
      locala.uri = "/cgi-bin/mmgame-bin/getuservideolist";
      locala.funcId = 3549;
      locala.hQF = localg;
      locala.hQG = new h();
      IPCRunCgi.a(locala.aDS(), new IPCRunCgi.a()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb)
        {
          AppMethodBeat.i(40908);
          ae.i("MicroMsg.GameHaowanDataCenter", "errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          if (localg.offset == 0L)
          {
            a.b(a.this).clear();
            a.c(a.this).clear();
          }
          long l1;
          label101:
          long l2;
          if (!bu.ht(a.b(a.this)))
          {
            paramAnonymousString = (com.tencent.mm.plugin.game.b.b.e)a.b(a.this).getLast();
            if (paramAnonymousString == null) {
              break label440;
            }
            l1 = paramAnonymousString.createTime - 1L;
            if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
              break label454;
            }
            a.a(a.this, (h)paramAnonymousb.hQE.hQJ);
            ae.d("MicroMsg.GameHaowanDataCenter", "new_count = %d", new Object[] { Integer.valueOf(a.d(a.this).oEh) });
            paramAnonymousString = a.a(a.d(a.this));
            if (localg.offset == 0L)
            {
              a.a(a.this, a.d(a.this).oEh + a.e(a.this));
              a.b(a.this, a.d(a.this).nAa + a.f(a.this));
              a.amF(a.d(a.this).ucP);
              a.xY(System.currentTimeMillis());
            }
            if ((!a.d(a.this).pqC) || (bu.ht(a.d(a.this).udf))) {
              break label448;
            }
            l2 = ((m)a.d(a.this).udf.getLast()).udu * 1000L;
            label303:
            paramAnonymousb = a.a(a.this, l1, l2);
            LinkedList localLinkedList = new LinkedList();
            localLinkedList.addAll(paramAnonymousString);
            localLinkedList.addAll(paramAnonymousb);
            a.a(a.this, localLinkedList);
            a.b(a.this, localLinkedList);
            a.c(a.this).addAll(localLinkedList);
            a.c(a.this, localLinkedList);
            a.g(a.this);
            if (parama != null) {
              parama.b(a.h(a.this), a.d(a.this).pqC);
            }
          }
          for (;;)
          {
            a.i(a.this);
            AppMethodBeat.o(40908);
            return;
            paramAnonymousString = null;
            break;
            label440:
            l1 = System.currentTimeMillis();
            break label101;
            label448:
            l2 = 0L;
            break label303;
            label454:
            if (localg.offset == 0L)
            {
              a.a(a.this, a.e(a.this));
              a.b(a.this, a.f(a.this));
            }
            paramAnonymousString = a.a(a.this, l1, 0L);
            a.b(a.this, paramAnonymousString);
            a.c(a.this).addAll(paramAnonymousString);
            a.c(a.this, paramAnonymousString);
            a.g(a.this);
            if (parama != null) {
              parama.b(a.h(a.this), false);
            }
          }
        }
      });
      AppMethodBeat.o(40921);
      return;
    }
  }
  
  public final LinkedList<com.tencent.mm.plugin.game.b.b.e> dar()
  {
    AppMethodBeat.i(40917);
    try
    {
      localObject2 = new k(uhx);
      localObject1 = com.tencent.mm.vfs.o.openRead(uhx);
      try
      {
        Object localObject3 = new byte[(int)((k)localObject2).length()];
        ((InputStream)localObject1).read((byte[])localObject3);
        localObject2 = new f();
        ((f)localObject2).parseFrom((byte[])localObject3);
        safeClose((Closeable)localObject1);
        this.uhA = ((f)localObject2).udd;
        if (bu.ht(this.uhA)) {
          break label174;
        }
        localObject3 = this.uhA.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          com.tencent.mm.plugin.game.b.b.e locale = (com.tencent.mm.plugin.game.b.b.e)((Iterator)localObject3).next();
          if ((!locale.ucV) && (!locale.ucW)) {
            this.uhB.add(locale);
          }
        }
        ae.e("MicroMsg.GameHaowanDataCenter", "parseGlobalConfig: " + ((Exception)localObject1).getMessage());
      }
      catch (Exception localException2)
      {
        localObject2 = localObject1;
        localObject1 = localException2;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        Object localObject1;
        Object localObject2 = null;
      }
    }
    safeClose((Closeable)localObject2);
    AppMethodBeat.o(40917);
    return null;
    label174:
    localObject2 = ((f)localObject2).udd;
    AppMethodBeat.o(40917);
    return localObject2;
  }
  
  public final String dau()
  {
    AppMethodBeat.i(40922);
    Object localObject1 = new IPCString();
    int i = das();
    ??? = new com.tencent.mm.plugin.game.b.b.a();
    ((com.tencent.mm.plugin.game.b.b.a)???).ucP = this.uhE;
    com.tencent.mm.ak.b.a locala = new com.tencent.mm.ak.b.a();
    locala.uri = "/cgi-bin/mmgame-bin/checkuserifhasnewvideo";
    locala.funcId = 3911;
    locala.hQF = ((com.tencent.mm.bw.a)???);
    locala.hQG = new com.tencent.mm.plugin.game.b.b.b();
    IPCRunCgi.a(locala.aDS(), new a.3(this, i, (IPCString)localObject1));
    synchronized (this.lock)
    {
      try
      {
        this.lock.wait();
        localObject1 = ((IPCString)localObject1).value;
        AppMethodBeat.o(40922);
        return localObject1;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.GameHaowanDataCenter", localInterruptedException, "", new Object[0]);
        }
      }
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(40916);
    Object localObject1 = new f();
    Object localObject2 = this.uhA.iterator();
    do
    {
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
    } while (!((com.tencent.mm.plugin.game.b.b.e)((Iterator)localObject2).next()).ucW);
    for (int i = this.uhA.indexOf(Integer.valueOf(-1));; i = -1)
    {
      if (i > 0) {
        this.uhA.remove(i);
      }
      ((f)localObject1).udd = this.uhA;
      daq();
      label118:
      for (;;)
      {
        try
        {
          localObject2 = ((f)localObject1).toByteArray();
          localObject1 = com.tencent.mm.vfs.o.db(uhx, false);
          ae.e("MicroMsg.GameHaowanDataCenter", "cacheData: " + localIOException1.getMessage());
        }
        catch (IOException localIOException1)
        {
          try
          {
            ((OutputStream)localObject1).write((byte[])localObject2);
            safeClose((Closeable)localObject1);
            uhK = null;
            AppMethodBeat.o(40916);
            return;
          }
          catch (IOException localIOException2)
          {
            break label118;
          }
          localIOException1 = localIOException1;
          localObject1 = null;
        }
      }
    }
  }
  
  public final boolean hasNext()
  {
    return (this.uhz != null) && (this.uhz.pqC);
  }
  
  public final void x(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(40914);
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0))
    {
      AppMethodBeat.o(40914);
      return;
    }
    int i = 0;
    while (i < paramJSONArray.length())
    {
      JSONObject localJSONObject = paramJSONArray.optJSONObject(0);
      b localb = new b((byte)0);
      localb.appId = localJSONObject.optString("appId");
      localb.appName = localJSONObject.optString("gameName");
      localb.tRB = localJSONObject.optString("albumName");
      localb.iZX = localJSONObject.optString("defaultTitle");
      this.uhy.put(localb.tRB, localb);
      i += 1;
    }
    AppMethodBeat.o(40914);
  }
  
  public static abstract interface a
  {
    public abstract void b(LinkedList<com.tencent.mm.plugin.game.b.b.e> paramLinkedList, boolean paramBoolean);
  }
  
  static final class b
  {
    String appId;
    String appName;
    String iZX;
    String tRB;
  }
  
  static abstract interface c
  {
    public abstract void au(LinkedList<GalleryItem.MediaItem> paramLinkedList);
  }
  
  public static final class d
  {
    public String type;
    
    public d(String paramString)
    {
      this.type = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.a
 * JD-Core Version:    0.7.0.1
 */