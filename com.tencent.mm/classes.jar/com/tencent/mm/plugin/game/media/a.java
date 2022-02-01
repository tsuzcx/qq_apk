package com.tencent.mm.plugin.game.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.c;
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
import com.tencent.mm.plugin.game.commlib.util.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
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
  private static long qVk;
  private static a xAe;
  private static final String xzQ;
  private static final String xzR;
  private int gAZ;
  private Object lock;
  private int xAa;
  private boolean xAb;
  private d xAc;
  private int xAd;
  private final HashMap<String, b> xzS;
  private h xzT;
  private LinkedList<com.tencent.mm.plugin.game.b.b.e> xzU;
  LinkedList<com.tencent.mm.plugin.game.b.b.e> xzV;
  LinkedList<com.tencent.mm.plugin.game.b.b.e> xzW;
  private boolean xzX;
  private String xzY;
  private long xzZ;
  
  static
  {
    AppMethodBeat.i(40942);
    xzQ = com.tencent.mm.plugin.game.commlib.util.b.b(b.a.xvI) + "haowan/";
    xzR = xzQ + "haowan_gallery_cache";
    qVk = 0L;
    AppMethodBeat.o(40942);
  }
  
  public a()
  {
    AppMethodBeat.i(40913);
    this.lock = new Object();
    this.xzS = new HashMap();
    this.xzU = new LinkedList();
    this.xzV = new LinkedList();
    this.xzW = new LinkedList();
    this.xzX = false;
    this.xAc = null;
    this.xAd = 0;
    this.xzY = MultiProcessMMKV.getMMKV(UE("game_haowan_mmkv_key")).getString("game_remote_ticket", null);
    this.xzZ = MultiProcessMMKV.getMMKV(UE("game_haowan_mmkv_key")).getLong("game_local_ticket", 0L);
    dTY();
    AppMethodBeat.o(40913);
  }
  
  public static void Od(int paramInt)
  {
    AppMethodBeat.i(40925);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV(UE("game_haowan_mmkv_key"));
    localMultiProcessMMKV.putInt("game_last_choose_gallery", paramInt);
    localMultiProcessMMKV.apply();
    AppMethodBeat.o(40925);
  }
  
  private static String Oe(int paramInt)
  {
    AppMethodBeat.i(40932);
    String str = new p(paramInt).toString();
    AppMethodBeat.o(40932);
    return str;
  }
  
  private static String UE(String paramString)
  {
    AppMethodBeat.i(40931);
    int i = com.tencent.mm.kernel.a.azs();
    if (i == 0)
    {
      AppMethodBeat.o(40931);
      return paramString;
    }
    paramString = paramString + "_" + Oe(i);
    AppMethodBeat.o(40931);
    return paramString;
  }
  
  public static void a(int paramInt, a.c paramc)
  {
    AppMethodBeat.i(40924);
    com.tencent.mm.plugin.gallery.model.e.dQK().setQueryType(paramInt);
    com.tencent.mm.plugin.gallery.model.e.dQK().mcq = 15;
    com.tencent.mm.plugin.gallery.model.e.dQK().a(new i.c()
    {
      public final void b(LinkedList<GalleryItem.MediaItem> paramAnonymousLinkedList, long paramAnonymousLong, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(40911);
        if ((a.dUj() == paramAnonymousLong) && (this.xAk != null)) {
          this.xAk.aP(paramAnonymousLinkedList);
        }
        AppMethodBeat.o(40911);
      }
    });
    qVk = System.currentTimeMillis();
    com.tencent.mm.plugin.gallery.model.e.dQK().ax("", qVk);
    AppMethodBeat.o(40924);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(40912);
    if (xAe == null)
    {
      parama.c(null, false);
      AppMethodBeat.o(40912);
      return;
    }
    xAe.b(new a()
    {
      public final void c(LinkedList<com.tencent.mm.plugin.game.b.b.e> paramAnonymousLinkedList, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(40907);
        if (this.xAf != null) {
          this.xAf.c(a.dUi().xzW, paramAnonymousBoolean);
        }
        AppMethodBeat.o(40907);
      }
    });
    AppMethodBeat.o(40912);
  }
  
  public static void a(a parama)
  {
    xAe = parama;
  }
  
  private static void dTY()
  {
    AppMethodBeat.i(40915);
    com.tencent.mm.vfs.o localo = new com.tencent.mm.vfs.o(xzQ);
    if ((!localo.exists()) || (!localo.isDirectory())) {
      localo.mkdirs();
    }
    AppMethodBeat.o(40915);
  }
  
  private int dUa()
  {
    AppMethodBeat.i(40919);
    if (this.xzZ == 0L)
    {
      AppMethodBeat.o(40919);
      return 0;
    }
    int i = j.dUp().b(dUb(), System.currentTimeMillis(), this.xzZ + 1L);
    AppMethodBeat.o(40919);
    return i;
  }
  
  private LinkedList<String> dUb()
  {
    AppMethodBeat.i(40920);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.xzS.values().iterator();
    while (localIterator.hasNext()) {
      localLinkedList.add(((b)localIterator.next()).albumName);
    }
    AppMethodBeat.o(40920);
    return localLinkedList;
  }
  
  public static int dUd()
  {
    AppMethodBeat.i(40926);
    int i = MultiProcessMMKV.getMMKV(UE("game_haowan_mmkv_key")).getInt("game_last_choose_gallery", 0);
    AppMethodBeat.o(40926);
    return i;
  }
  
  public static void dUe()
  {
    AppMethodBeat.i(40927);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV(UE("game_haowan_mmkv_key"));
    localMultiProcessMMKV.putBoolean("game_tab_gallery_first_enter", false);
    localMultiProcessMMKV.apply();
    AppMethodBeat.o(40927);
  }
  
  public static boolean dUf()
  {
    AppMethodBeat.i(40928);
    boolean bool = MultiProcessMMKV.getMMKV(UE("game_haowan_mmkv_key")).getBoolean("game_tab_gallery_first_enter", true);
    AppMethodBeat.o(40928);
    return bool;
  }
  
  public static void dUg()
  {
    AppMethodBeat.i(40929);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV(UE("game_haowan_mmkv_key"));
    localMultiProcessMMKV.putBoolean("game_publish_gallery_first_enter", false);
    localMultiProcessMMKV.apply();
    AppMethodBeat.o(40929);
  }
  
  public static boolean dUh()
  {
    AppMethodBeat.i(40930);
    boolean bool = MultiProcessMMKV.getMMKV(UE("game_haowan_mmkv_key")).getBoolean("game_publish_gallery_first_enter", true);
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
    if (this.xzX)
    {
      Log.i("MicroMsg.GameHaowanDataCenter", "gettingDataFromNet, return");
      AppMethodBeat.o(40921);
      return;
    }
    Log.d("MicroMsg.GameHaowanDataCenter", "getDataFromNet");
    this.xzX = true;
    final g localg = new g();
    if (this.xzT != null) {}
    for (long l = this.xzT.xuR;; l = 0L)
    {
      localg.offset = l;
      if (localg.offset == 0L) {
        localg.xuD = this.xzY;
      }
      d.a locala = new d.a();
      locala.uri = "/cgi-bin/mmgame-bin/getuservideolist";
      locala.funcId = 3549;
      locala.iLN = localg;
      locala.iLO = new h();
      IPCRunCgi.a(locala.aXF(), new IPCRunCgi.a()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, d paramAnonymousd)
        {
          AppMethodBeat.i(40908);
          Log.i("MicroMsg.GameHaowanDataCenter", "errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          if (localg.offset == 0L)
          {
            a.b(a.this).clear();
            a.c(a.this).clear();
          }
          long l1;
          label101:
          long l2;
          if (!Util.isNullOrNil(a.b(a.this)))
          {
            paramAnonymousString = (com.tencent.mm.plugin.game.b.b.e)a.b(a.this).getLast();
            if (paramAnonymousString == null) {
              break label440;
            }
            l1 = paramAnonymousString.createTime - 1L;
            if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
              break label454;
            }
            a.a(a.this, (h)paramAnonymousd.iLL.iLR);
            Log.d("MicroMsg.GameHaowanDataCenter", "new_count = %d", new Object[] { Integer.valueOf(a.d(a.this).pRQ) });
            paramAnonymousString = a.a(a.d(a.this));
            if (localg.offset == 0L)
            {
              a.a(a.this, a.d(a.this).pRQ + a.e(a.this));
              a.b(a.this, a.d(a.this).oKY + a.f(a.this));
              a.azU(a.d(a.this).xuD);
              a.GI(System.currentTimeMillis());
            }
            if ((!a.d(a.this).qGh) || (Util.isNullOrNil(a.d(a.this).xuS))) {
              break label448;
            }
            l2 = ((m)a.d(a.this).xuS.getLast()).xvg * 1000L;
            label303:
            paramAnonymousd = a.a(a.this, l1, l2);
            LinkedList localLinkedList = new LinkedList();
            localLinkedList.addAll(paramAnonymousString);
            localLinkedList.addAll(paramAnonymousd);
            a.a(a.this, localLinkedList);
            a.b(a.this, localLinkedList);
            a.c(a.this).addAll(localLinkedList);
            a.c(a.this, localLinkedList);
            a.g(a.this);
            if (parama != null) {
              parama.c(a.h(a.this), a.d(a.this).qGh);
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
              parama.c(a.h(a.this), false);
            }
          }
        }
      });
      AppMethodBeat.o(40921);
      return;
    }
  }
  
  public final LinkedList<com.tencent.mm.plugin.game.b.b.e> dTZ()
  {
    AppMethodBeat.i(40917);
    try
    {
      localObject2 = new com.tencent.mm.vfs.o(xzR);
      localObject1 = s.openRead(xzR);
      try
      {
        Object localObject3 = new byte[(int)((com.tencent.mm.vfs.o)localObject2).length()];
        ((InputStream)localObject1).read((byte[])localObject3);
        localObject2 = new f();
        ((f)localObject2).parseFrom((byte[])localObject3);
        safeClose((Closeable)localObject1);
        this.xzU = ((f)localObject2).xuQ;
        if (Util.isNullOrNil(this.xzU)) {
          break label174;
        }
        localObject3 = this.xzU.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          com.tencent.mm.plugin.game.b.b.e locale = (com.tencent.mm.plugin.game.b.b.e)((Iterator)localObject3).next();
          if ((!locale.xuJ) && (!locale.xuK)) {
            this.xzV.add(locale);
          }
        }
        Log.e("MicroMsg.GameHaowanDataCenter", "parseGlobalConfig: " + ((Exception)localObject1).getMessage());
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
    localObject2 = ((f)localObject2).xuQ;
    AppMethodBeat.o(40917);
    return localObject2;
  }
  
  public final String dUc()
  {
    AppMethodBeat.i(40922);
    Object localObject1 = new IPCString();
    int i = dUa();
    ??? = new com.tencent.mm.plugin.game.b.b.a();
    ((com.tencent.mm.plugin.game.b.b.a)???).xuD = this.xzY;
    d.a locala = new d.a();
    locala.uri = "/cgi-bin/mmgame-bin/checkuserifhasnewvideo";
    locala.funcId = 3911;
    locala.iLN = ((com.tencent.mm.bw.a)???);
    locala.iLO = new com.tencent.mm.plugin.game.b.b.b();
    IPCRunCgi.a(locala.aXF(), new a.3(this, i, (IPCString)localObject1));
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
          Log.printErrStackTrace("MicroMsg.GameHaowanDataCenter", localInterruptedException, "", new Object[0]);
        }
      }
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(40916);
    Object localObject1 = new f();
    Object localObject2 = this.xzU.iterator();
    do
    {
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
    } while (!((com.tencent.mm.plugin.game.b.b.e)((Iterator)localObject2).next()).xuK);
    for (int i = this.xzU.indexOf(Integer.valueOf(-1));; i = -1)
    {
      if (i > 0) {
        this.xzU.remove(i);
      }
      ((f)localObject1).xuQ = this.xzU;
      dTY();
      label118:
      for (;;)
      {
        try
        {
          localObject2 = ((f)localObject1).toByteArray();
          localObject1 = s.dw(xzR, false);
          Log.e("MicroMsg.GameHaowanDataCenter", "cacheData: " + localIOException1.getMessage());
        }
        catch (IOException localIOException1)
        {
          try
          {
            ((OutputStream)localObject1).write((byte[])localObject2);
            safeClose((Closeable)localObject1);
            xAe = null;
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
    return (this.xzT != null) && (this.xzT.qGh);
  }
  
  public final void y(JSONArray paramJSONArray)
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
      JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
      b localb = new b((byte)0);
      localb.appId = localJSONObject.optString("appId");
      localb.appName = localJSONObject.optString("gameName");
      localb.albumName = localJSONObject.optString("albumName");
      localb.jXM = localJSONObject.optString("defaultTitle");
      this.xzS.put(localb.albumName, localb);
      i += 1;
    }
    AppMethodBeat.o(40914);
  }
  
  public static abstract interface a
  {
    public abstract void c(LinkedList<com.tencent.mm.plugin.game.b.b.e> paramLinkedList, boolean paramBoolean);
  }
  
  static final class b
  {
    String albumName;
    String appId;
    String appName;
    String jXM;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.a
 * JD-Core Version:    0.7.0.1
 */