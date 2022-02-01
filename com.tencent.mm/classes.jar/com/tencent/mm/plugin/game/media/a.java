package com.tencent.mm.plugin.game.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.b.p;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.game.autogen.b.e;
import com.tencent.mm.plugin.game.autogen.b.f;
import com.tencent.mm.plugin.game.autogen.b.g;
import com.tencent.mm.plugin.game.autogen.b.h;
import com.tencent.mm.plugin.game.autogen.b.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
{
  private static final String IxV;
  private static final String IxW;
  private static a Iyj;
  private final HashMap<String, b> IxX;
  private h IxY;
  private LinkedList<e> IxZ;
  LinkedList<e> Iya;
  LinkedList<e> Iyb;
  private boolean Iyc;
  private String Iyd;
  private long Iye;
  private int Iyf;
  private boolean Iyg;
  private c Iyh;
  private int Iyi;
  private int lNX;
  private Object lock;
  
  static
  {
    AppMethodBeat.i(40942);
    IxV = com.tencent.mm.plugin.game.commlib.e.c.b(com.tencent.mm.plugin.game.commlib.e.c.a.Ito) + "haowan/";
    IxW = IxV + "haowan_gallery_cache";
    AppMethodBeat.o(40942);
  }
  
  public a()
  {
    AppMethodBeat.i(40913);
    this.lock = new Object();
    this.IxX = new HashMap();
    this.IxZ = new LinkedList();
    this.Iya = new LinkedList();
    this.Iyb = new LinkedList();
    this.Iyc = false;
    this.Iyh = null;
    this.Iyi = 0;
    this.Iyd = MultiProcessMMKV.getMMKV(UO("game_haowan_mmkv_key")).getString("game_remote_ticket", null);
    this.Iye = MultiProcessMMKV.getMMKV(UO("game_haowan_mmkv_key")).getLong("game_local_ticket", 0L);
    fFc();
    AppMethodBeat.o(40913);
  }
  
  private static String UO(String paramString)
  {
    AppMethodBeat.i(40931);
    int i = com.tencent.mm.kernel.b.aZP();
    if (i == 0)
    {
      AppMethodBeat.o(40931);
      return paramString;
    }
    paramString = paramString + "_" + Xr(i);
    AppMethodBeat.o(40931);
    return paramString;
  }
  
  public static void Xq(int paramInt)
  {
    AppMethodBeat.i(40925);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV(UO("game_haowan_mmkv_key"));
    localMultiProcessMMKV.putInt("game_last_choose_gallery", paramInt);
    localMultiProcessMMKV.apply();
    AppMethodBeat.o(40925);
  }
  
  private static String Xr(int paramInt)
  {
    AppMethodBeat.i(40932);
    String str = new p(paramInt).toString();
    AppMethodBeat.o(40932);
    return str;
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(40912);
    if (Iyj == null)
    {
      parama.d(null, false);
      AppMethodBeat.o(40912);
      return;
    }
    Iyj.b(new a()
    {
      public final void d(LinkedList<e> paramAnonymousLinkedList, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(40907);
        if (a.this != null) {
          a.this.d(a.fFm().Iyb, paramAnonymousBoolean);
        }
        AppMethodBeat.o(40907);
      }
    });
    AppMethodBeat.o(40912);
  }
  
  public static void a(a parama)
  {
    Iyj = parama;
  }
  
  private static void fFc()
  {
    AppMethodBeat.i(40915);
    u localu = new u(IxV);
    if ((!localu.jKS()) || (!localu.isDirectory())) {
      localu.jKY();
    }
    AppMethodBeat.o(40915);
  }
  
  private int fFe()
  {
    AppMethodBeat.i(40919);
    if (this.Iye == 0L)
    {
      AppMethodBeat.o(40919);
      return 0;
    }
    int i = j.fFs().b(fFf(), System.currentTimeMillis(), this.Iye + 1L);
    AppMethodBeat.o(40919);
    return i;
  }
  
  private LinkedList<String> fFf()
  {
    AppMethodBeat.i(40920);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.IxX.values().iterator();
    while (localIterator.hasNext()) {
      localLinkedList.add(((b)localIterator.next()).albumName);
    }
    AppMethodBeat.o(40920);
    return localLinkedList;
  }
  
  public static int fFh()
  {
    AppMethodBeat.i(40926);
    int i = MultiProcessMMKV.getMMKV(UO("game_haowan_mmkv_key")).getInt("game_last_choose_gallery", 0);
    AppMethodBeat.o(40926);
    return i;
  }
  
  public static void fFi()
  {
    AppMethodBeat.i(40927);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV(UO("game_haowan_mmkv_key"));
    localMultiProcessMMKV.putBoolean("game_tab_gallery_first_enter", false);
    localMultiProcessMMKV.apply();
    AppMethodBeat.o(40927);
  }
  
  public static boolean fFj()
  {
    AppMethodBeat.i(40928);
    boolean bool = MultiProcessMMKV.getMMKV(UO("game_haowan_mmkv_key")).getBoolean("game_tab_gallery_first_enter", true);
    AppMethodBeat.o(40928);
    return bool;
  }
  
  public static void fFk()
  {
    AppMethodBeat.i(40929);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV(UO("game_haowan_mmkv_key"));
    localMultiProcessMMKV.putBoolean("game_publish_gallery_first_enter", false);
    localMultiProcessMMKV.apply();
    AppMethodBeat.o(40929);
  }
  
  public static boolean fFl()
  {
    AppMethodBeat.i(40930);
    boolean bool = MultiProcessMMKV.getMMKV(UO("game_haowan_mmkv_key")).getBoolean("game_publish_gallery_first_enter", true);
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
  
  public final void B(JSONArray paramJSONArray)
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
      localb.pLF = localJSONObject.optString("defaultTitle");
      this.IxX.put(localb.albumName, localb);
      i += 1;
    }
    AppMethodBeat.o(40914);
  }
  
  public final void b(final a parama)
  {
    AppMethodBeat.i(40921);
    if (this.Iyc)
    {
      Log.i("MicroMsg.GameHaowanDataCenter", "gettingDataFromNet, return");
      AppMethodBeat.o(40921);
      return;
    }
    Log.d("MicroMsg.GameHaowanDataCenter", "getDataFromNet");
    this.Iyc = true;
    final g localg = new g();
    if (this.IxY != null) {}
    for (long l = this.IxY.Idr;; l = 0L)
    {
      localg.offset = l;
      if (localg.offset == 0L) {
        localg.Idc = this.Iyd;
      }
      parama = new WeakReference(parama);
      com.tencent.mm.am.c.a locala = new com.tencent.mm.am.c.a();
      locala.uri = "/cgi-bin/mmgame-bin/getuservideolist";
      locala.funcId = 3549;
      locala.otE = localg;
      locala.otF = new h();
      IPCRunCgi.a(locala.bEF(), new IPCRunCgi.a()
      {
        public final void callback(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.c paramAnonymousc)
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
            paramAnonymousString = (e)a.b(a.this).getLast();
            if (paramAnonymousString == null) {
              break label456;
            }
            l1 = paramAnonymousString.createTime - 1L;
            if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
              break label470;
            }
            a.a(a.this, (h)c.c.b(paramAnonymousc.otC));
            Log.d("MicroMsg.GameHaowanDataCenter", "new_count = %d", new Object[] { Integer.valueOf(a.d(a.this).wsr) });
            paramAnonymousString = a.a(a.d(a.this));
            if (localg.offset == 0L)
            {
              a.a(a.this, a.d(a.this).wsr + a.e(a.this));
              a.b(a.this, a.d(a.this).uYc + a.f(a.this));
              a.aGt(a.d(a.this).Idc);
              a.rF(System.currentTimeMillis());
            }
            if ((!a.d(a.this).has_next) || (Util.isNullOrNil(a.d(a.this).Ids))) {
              break label464;
            }
            l2 = ((m)a.d(a.this).Ids.getLast()).IdF * 1000L;
            label303:
            paramAnonymousc = a.a(a.this, l1, l2);
            LinkedList localLinkedList = new LinkedList();
            localLinkedList.addAll(paramAnonymousString);
            localLinkedList.addAll(paramAnonymousc);
            a.a(a.this, localLinkedList);
            a.b(a.this, localLinkedList);
            a.c(a.this).addAll(localLinkedList);
            a.c(a.this, localLinkedList);
            a.g(a.this);
            if ((parama != null) && (parama.get() != null)) {
              ((a.a)parama.get()).d(a.h(a.this), a.d(a.this).has_next);
            }
          }
          for (;;)
          {
            a.i(a.this);
            AppMethodBeat.o(40908);
            return;
            paramAnonymousString = null;
            break;
            label456:
            l1 = System.currentTimeMillis();
            break label101;
            label464:
            l2 = 0L;
            break label303;
            label470:
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
            if ((parama != null) && (parama.get() != null)) {
              ((a.a)parama.get()).d(a.h(a.this), false);
            }
          }
        }
      });
      AppMethodBeat.o(40921);
      return;
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(40916);
    Object localObject1 = new f();
    Object localObject2 = this.IxZ.iterator();
    do
    {
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
    } while (!((e)((Iterator)localObject2).next()).Idk);
    for (int i = this.IxZ.indexOf(Integer.valueOf(-1));; i = -1)
    {
      if (i > 0) {
        this.IxZ.remove(i);
      }
      ((f)localObject1).Idq = this.IxZ;
      fFc();
      label118:
      for (;;)
      {
        try
        {
          localObject2 = ((f)localObject1).toByteArray();
          localObject1 = y.ev(IxW, false);
          Log.e("MicroMsg.GameHaowanDataCenter", "cacheData: " + localIOException1.getMessage());
        }
        catch (IOException localIOException1)
        {
          try
          {
            ((OutputStream)localObject1).write((byte[])localObject2);
            safeClose((Closeable)localObject1);
            Iyj = null;
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
  
  public final LinkedList<e> fFd()
  {
    AppMethodBeat.i(40917);
    try
    {
      localObject2 = new u(IxW);
      localObject1 = y.Lh(IxW);
      try
      {
        Object localObject3 = new byte[(int)((u)localObject2).length()];
        ((InputStream)localObject1).read((byte[])localObject3);
        localObject2 = new f();
        ((f)localObject2).parseFrom((byte[])localObject3);
        safeClose((Closeable)localObject1);
        this.IxZ = ((f)localObject2).Idq;
        if (Util.isNullOrNil(this.IxZ)) {
          break label174;
        }
        localObject3 = this.IxZ.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          e locale = (e)((Iterator)localObject3).next();
          if ((!locale.Idj) && (!locale.Idk)) {
            this.Iya.add(locale);
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
    localObject2 = ((f)localObject2).Idq;
    AppMethodBeat.o(40917);
    return localObject2;
  }
  
  public final String fFg()
  {
    AppMethodBeat.i(40922);
    Object localObject1 = new IPCString();
    int i = fFe();
    ??? = new com.tencent.mm.plugin.game.autogen.b.a();
    ((com.tencent.mm.plugin.game.autogen.b.a)???).Idc = this.Iyd;
    com.tencent.mm.am.c.a locala = new com.tencent.mm.am.c.a();
    locala.uri = "/cgi-bin/mmgame-bin/checkuserifhasnewvideo";
    locala.funcId = 3911;
    locala.otE = ((com.tencent.mm.bx.a)???);
    locala.otF = new com.tencent.mm.plugin.game.autogen.b.b();
    IPCRunCgi.a(locala.bEF(), new a.3(this, i, (IPCString)localObject1));
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
  
  public final boolean hasNext()
  {
    return (this.IxY != null) && (this.IxY.has_next);
  }
  
  public static abstract interface a
  {
    public abstract void d(LinkedList<e> paramLinkedList, boolean paramBoolean);
  }
  
  static final class b
  {
    String albumName;
    String appId;
    String appName;
    String pLF;
  }
  
  public static final class c
  {
    public String type;
    
    public c(String paramString)
    {
      this.type = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.a
 * JD-Core Version:    0.7.0.1
 */