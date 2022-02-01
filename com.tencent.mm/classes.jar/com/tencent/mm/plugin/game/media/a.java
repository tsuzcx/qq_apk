package com.tencent.mm.plugin.game.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.c;
import com.tencent.mm.b.p;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.game.autogen.b.e;
import com.tencent.mm.plugin.game.autogen.b.f;
import com.tencent.mm.plugin.game.autogen.b.g;
import com.tencent.mm.plugin.game.autogen.b.h;
import com.tencent.mm.plugin.game.autogen.b.m;
import com.tencent.mm.plugin.game.commlib.e.c;
import com.tencent.mm.plugin.game.commlib.e.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
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
  private static final String CDR;
  private static final String CDS;
  private static a CEf;
  private final HashMap<String, b> CDT;
  private h CDU;
  private LinkedList<e> CDV;
  LinkedList<e> CDW;
  LinkedList<e> CDX;
  private boolean CDY;
  private String CDZ;
  private long CEa;
  private int CEb;
  private boolean CEc;
  private d CEd;
  private int CEe;
  private int jlf;
  private Object lock;
  
  static
  {
    AppMethodBeat.i(40942);
    CDR = c.b(c.a.Czy) + "haowan/";
    CDS = CDR + "haowan_gallery_cache";
    AppMethodBeat.o(40942);
  }
  
  public a()
  {
    AppMethodBeat.i(40913);
    this.lock = new Object();
    this.CDT = new HashMap();
    this.CDV = new LinkedList();
    this.CDW = new LinkedList();
    this.CDX = new LinkedList();
    this.CDY = false;
    this.CEd = null;
    this.CEe = 0;
    this.CDZ = MultiProcessMMKV.getMMKV(aco("game_haowan_mmkv_key")).getString("game_remote_ticket", null);
    this.CEa = MultiProcessMMKV.getMMKV(aco("game_haowan_mmkv_key")).getLong("game_local_ticket", 0L);
    exf();
    AppMethodBeat.o(40913);
  }
  
  public static void Tw(int paramInt)
  {
    AppMethodBeat.i(40925);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV(aco("game_haowan_mmkv_key"));
    localMultiProcessMMKV.putInt("game_last_choose_gallery", paramInt);
    localMultiProcessMMKV.apply();
    AppMethodBeat.o(40925);
  }
  
  private static String Tx(int paramInt)
  {
    AppMethodBeat.i(40932);
    String str = new p(paramInt).toString();
    AppMethodBeat.o(40932);
    return str;
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(40912);
    if (CEf == null)
    {
      parama.d(null, false);
      AppMethodBeat.o(40912);
      return;
    }
    CEf.b(new a()
    {
      public final void d(LinkedList<e> paramAnonymousLinkedList, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(40907);
        if (this.CEg != null) {
          this.CEg.d(a.exp().CDX, paramAnonymousBoolean);
        }
        AppMethodBeat.o(40907);
      }
    });
    AppMethodBeat.o(40912);
  }
  
  public static void a(a parama)
  {
    CEf = parama;
  }
  
  private static String aco(String paramString)
  {
    AppMethodBeat.i(40931);
    int i = com.tencent.mm.kernel.b.aGP();
    if (i == 0)
    {
      AppMethodBeat.o(40931);
      return paramString;
    }
    paramString = paramString + "_" + Tx(i);
    AppMethodBeat.o(40931);
    return paramString;
  }
  
  private static void exf()
  {
    AppMethodBeat.i(40915);
    q localq = new q(CDR);
    if ((!localq.ifE()) || (!localq.isDirectory())) {
      localq.ifL();
    }
    AppMethodBeat.o(40915);
  }
  
  private int exh()
  {
    AppMethodBeat.i(40919);
    if (this.CEa == 0L)
    {
      AppMethodBeat.o(40919);
      return 0;
    }
    int i = j.exw().b(exi(), System.currentTimeMillis(), this.CEa + 1L);
    AppMethodBeat.o(40919);
    return i;
  }
  
  private LinkedList<String> exi()
  {
    AppMethodBeat.i(40920);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.CDT.values().iterator();
    while (localIterator.hasNext()) {
      localLinkedList.add(((b)localIterator.next()).albumName);
    }
    AppMethodBeat.o(40920);
    return localLinkedList;
  }
  
  public static int exk()
  {
    AppMethodBeat.i(40926);
    int i = MultiProcessMMKV.getMMKV(aco("game_haowan_mmkv_key")).getInt("game_last_choose_gallery", 0);
    AppMethodBeat.o(40926);
    return i;
  }
  
  public static void exl()
  {
    AppMethodBeat.i(40927);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV(aco("game_haowan_mmkv_key"));
    localMultiProcessMMKV.putBoolean("game_tab_gallery_first_enter", false);
    localMultiProcessMMKV.apply();
    AppMethodBeat.o(40927);
  }
  
  public static boolean exm()
  {
    AppMethodBeat.i(40928);
    boolean bool = MultiProcessMMKV.getMMKV(aco("game_haowan_mmkv_key")).getBoolean("game_tab_gallery_first_enter", true);
    AppMethodBeat.o(40928);
    return bool;
  }
  
  public static void exn()
  {
    AppMethodBeat.i(40929);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV(aco("game_haowan_mmkv_key"));
    localMultiProcessMMKV.putBoolean("game_publish_gallery_first_enter", false);
    localMultiProcessMMKV.apply();
    AppMethodBeat.o(40929);
  }
  
  public static boolean exo()
  {
    AppMethodBeat.i(40930);
    boolean bool = MultiProcessMMKV.getMMKV(aco("game_haowan_mmkv_key")).getBoolean("game_publish_gallery_first_enter", true);
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
    if (this.CDY)
    {
      Log.i("MicroMsg.GameHaowanDataCenter", "gettingDataFromNet, return");
      AppMethodBeat.o(40921);
      return;
    }
    Log.d("MicroMsg.GameHaowanDataCenter", "getDataFromNet");
    this.CDY = true;
    final g localg = new g();
    if (this.CDU != null) {}
    for (long l = this.CDU.Crk;; l = 0L)
    {
      localg.offset = l;
      if (localg.offset == 0L) {
        localg.CqU = this.CDZ;
      }
      parama = new WeakReference(parama);
      d.a locala = new d.a();
      locala.uri = "/cgi-bin/mmgame-bin/getuservideolist";
      locala.funcId = 3549;
      locala.lBU = localg;
      locala.lBV = new h();
      IPCRunCgi.a(locala.bgN(), new IPCRunCgi.a()
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
            paramAnonymousString = (e)a.b(a.this).getLast();
            if (paramAnonymousString == null) {
              break label456;
            }
            l1 = paramAnonymousString.createTime - 1L;
            if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
              break label470;
            }
            a.a(a.this, (h)d.c.b(paramAnonymousd.lBS));
            Log.d("MicroMsg.GameHaowanDataCenter", "new_count = %d", new Object[] { Integer.valueOf(a.d(a.this).tnQ) });
            paramAnonymousString = a.a(a.d(a.this));
            if (localg.offset == 0L)
            {
              a.a(a.this, a.d(a.this).tnQ + a.e(a.this));
              a.b(a.this, a.d(a.this).rMO + a.f(a.this));
              a.aJF(a.d(a.this).CqU);
              a.NO(System.currentTimeMillis());
            }
            if ((!a.d(a.this).has_next) || (Util.isNullOrNil(a.d(a.this).Crl))) {
              break label464;
            }
            l2 = ((m)a.d(a.this).Crl.getLast()).Crz * 1000L;
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
    Object localObject2 = this.CDV.iterator();
    do
    {
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
    } while (!((e)((Iterator)localObject2).next()).Crc);
    for (int i = this.CDV.indexOf(Integer.valueOf(-1));; i = -1)
    {
      if (i > 0) {
        this.CDV.remove(i);
      }
      ((f)localObject1).Crj = this.CDV;
      exf();
      label117:
      for (;;)
      {
        try
        {
          localObject2 = ((f)localObject1).toByteArray();
          localObject1 = u.Te(CDS);
          Log.e("MicroMsg.GameHaowanDataCenter", "cacheData: " + localIOException1.getMessage());
        }
        catch (IOException localIOException1)
        {
          try
          {
            ((OutputStream)localObject1).write((byte[])localObject2);
            safeClose((Closeable)localObject1);
            CEf = null;
            AppMethodBeat.o(40916);
            return;
          }
          catch (IOException localIOException2)
          {
            break label117;
          }
          localIOException1 = localIOException1;
          localObject1 = null;
        }
      }
    }
  }
  
  public final LinkedList<e> exg()
  {
    AppMethodBeat.i(40917);
    try
    {
      localObject2 = new q(CDS);
      localObject1 = u.Tf(CDS);
      try
      {
        Object localObject3 = new byte[(int)((q)localObject2).length()];
        ((InputStream)localObject1).read((byte[])localObject3);
        localObject2 = new f();
        ((f)localObject2).parseFrom((byte[])localObject3);
        safeClose((Closeable)localObject1);
        this.CDV = ((f)localObject2).Crj;
        if (Util.isNullOrNil(this.CDV)) {
          break label174;
        }
        localObject3 = this.CDV.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          e locale = (e)((Iterator)localObject3).next();
          if ((!locale.Crb) && (!locale.Crc)) {
            this.CDW.add(locale);
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
    localObject2 = ((f)localObject2).Crj;
    AppMethodBeat.o(40917);
    return localObject2;
  }
  
  public final String exj()
  {
    AppMethodBeat.i(40922);
    Object localObject1 = new IPCString();
    final int i = exh();
    ??? = new com.tencent.mm.plugin.game.autogen.b.a();
    ((com.tencent.mm.plugin.game.autogen.b.a)???).CqU = this.CDZ;
    d.a locala = new d.a();
    locala.uri = "/cgi-bin/mmgame-bin/checkuserifhasnewvideo";
    locala.funcId = 3911;
    locala.lBU = ((com.tencent.mm.cd.a)???);
    locala.lBV = new com.tencent.mm.plugin.game.autogen.b.b();
    IPCRunCgi.a(locala.bgN(), new IPCRunCgi.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String arg3, d paramAnonymousd)
      {
        AppMethodBeat.i(40909);
        Log.i("MicroMsg.GameHaowanDataCenter", "checkNewVideo errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          ??? = (com.tencent.mm.plugin.game.autogen.b.b)d.c.b(paramAnonymousd.lBS);
          paramAnonymousd = Util.nullAsNil(???.desc);
          if (!paramAnonymousd.contains("[count]")) {
            break label131;
          }
          paramAnonymousInt1 = i;
          paramAnonymousInt1 = ???.tnQ + paramAnonymousInt1;
          if (paramAnonymousInt1 > 0) {
            this.CEk.value = paramAnonymousd.replace("[count]", String.valueOf(paramAnonymousInt1));
          }
        }
        synchronized (a.j(a.this))
        {
          a.j(a.this).notifyAll();
          AppMethodBeat.o(40909);
          return;
          label131:
          this.CEk.value = paramAnonymousd;
        }
      }
    });
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
    return (this.CDU != null) && (this.CDU.has_next);
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
      localb.mOZ = localJSONObject.optString("defaultTitle");
      this.CDT.put(localb.albumName, localb);
      i += 1;
    }
    AppMethodBeat.o(40914);
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
    String mOZ;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.a
 * JD-Core Version:    0.7.0.1
 */