package com.tencent.mm.plugin.game.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.b.p;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.gallery.model.o;
import com.tencent.mm.plugin.game.b.b.f;
import com.tencent.mm.plugin.game.b.b.g;
import com.tencent.mm.plugin.game.b.b.h;
import com.tencent.mm.plugin.game.b.b.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
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
  private static long osg;
  private static final String rQR;
  private static final String rQS;
  private static a rRf;
  private int fwP;
  private Object lock;
  private final HashMap<String, b> rQT;
  private h rQU;
  private LinkedList<com.tencent.mm.plugin.game.b.b.e> rQV;
  LinkedList<com.tencent.mm.plugin.game.b.b.e> rQW;
  LinkedList<com.tencent.mm.plugin.game.b.b.e> rQX;
  private boolean rQY;
  private String rQZ;
  private long rRa;
  private int rRb;
  private boolean rRc;
  private d rRd;
  private int rRe;
  
  static
  {
    AppMethodBeat.i(40942);
    rQR = com.tencent.mm.plugin.game.commlib.e.b.a(com.tencent.mm.plugin.game.commlib.e.b.a.rOH) + "haowan/";
    rQS = rQR + "haowan_gallery_cache";
    osg = 0L;
    AppMethodBeat.o(40942);
  }
  
  public a()
  {
    AppMethodBeat.i(40913);
    this.lock = new Object();
    this.rQT = new HashMap();
    this.rQV = new LinkedList();
    this.rQW = new LinkedList();
    this.rQX = new LinkedList();
    this.rQY = false;
    this.rRd = null;
    this.rRe = 0;
    this.rQZ = ax.aFC(OH("game_haowan_mmkv_key")).getString("game_remote_ticket", null);
    this.rRa = ax.aFC(OH("game_haowan_mmkv_key")).getLong("game_local_ticket", 0L);
    cBQ();
    AppMethodBeat.o(40913);
  }
  
  public static void En(int paramInt)
  {
    AppMethodBeat.i(40925);
    ax localax = ax.aFC(OH("game_haowan_mmkv_key"));
    localax.putInt("game_last_choose_gallery", paramInt);
    localax.apply();
    AppMethodBeat.o(40925);
  }
  
  private static String Eo(int paramInt)
  {
    AppMethodBeat.i(40932);
    String str = new p(paramInt).toString();
    AppMethodBeat.o(40932);
    return str;
  }
  
  private static String OH(String paramString)
  {
    AppMethodBeat.i(40931);
    int i = com.tencent.mm.kernel.a.aeL();
    if (i == 0)
    {
      AppMethodBeat.o(40931);
      return paramString;
    }
    paramString = paramString + "_" + Eo(i);
    AppMethodBeat.o(40931);
    return paramString;
  }
  
  public static void a(int paramInt, a.c paramc)
  {
    AppMethodBeat.i(40924);
    com.tencent.mm.plugin.gallery.model.e.czh().setQueryType(paramInt);
    com.tencent.mm.plugin.gallery.model.e.czh().jWF = 15;
    com.tencent.mm.plugin.gallery.model.e.czh().a(new a.5(paramc));
    osg = System.currentTimeMillis();
    com.tencent.mm.plugin.gallery.model.e.czh().as("", osg);
    AppMethodBeat.o(40924);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(40912);
    if (rRf == null)
    {
      parama.b(null, false);
      AppMethodBeat.o(40912);
      return;
    }
    rRf.b(new a()
    {
      public final void b(LinkedList<com.tencent.mm.plugin.game.b.b.e> paramAnonymousLinkedList, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(40907);
        if (this.rRg != null) {
          this.rRg.b(a.cCa().rQX, paramAnonymousBoolean);
        }
        AppMethodBeat.o(40907);
      }
    });
    AppMethodBeat.o(40912);
  }
  
  public static void a(a parama)
  {
    rRf = parama;
  }
  
  private static void cBQ()
  {
    AppMethodBeat.i(40915);
    com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(rQR);
    if ((!locale.exists()) || (!locale.isDirectory())) {
      locale.mkdirs();
    }
    AppMethodBeat.o(40915);
  }
  
  private int cBS()
  {
    AppMethodBeat.i(40919);
    if (this.rRa == 0L)
    {
      AppMethodBeat.o(40919);
      return 0;
    }
    int i = j.cCh().b(cBT(), System.currentTimeMillis(), this.rRa + 1L);
    AppMethodBeat.o(40919);
    return i;
  }
  
  private LinkedList<String> cBT()
  {
    AppMethodBeat.i(40920);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.rQT.values().iterator();
    while (localIterator.hasNext()) {
      localLinkedList.add(((b)localIterator.next()).rBh);
    }
    AppMethodBeat.o(40920);
    return localLinkedList;
  }
  
  public static int cBV()
  {
    AppMethodBeat.i(40926);
    int i = ax.aFC(OH("game_haowan_mmkv_key")).getInt("game_last_choose_gallery", 0);
    AppMethodBeat.o(40926);
    return i;
  }
  
  public static void cBW()
  {
    AppMethodBeat.i(40927);
    ax localax = ax.aFC(OH("game_haowan_mmkv_key"));
    localax.putBoolean("game_tab_gallery_first_enter", false);
    localax.apply();
    AppMethodBeat.o(40927);
  }
  
  public static boolean cBX()
  {
    AppMethodBeat.i(40928);
    boolean bool = ax.aFC(OH("game_haowan_mmkv_key")).getBoolean("game_tab_gallery_first_enter", true);
    AppMethodBeat.o(40928);
    return bool;
  }
  
  public static void cBY()
  {
    AppMethodBeat.i(40929);
    ax localax = ax.aFC(OH("game_haowan_mmkv_key"));
    localax.putBoolean("game_publish_gallery_first_enter", false);
    localax.apply();
    AppMethodBeat.o(40929);
  }
  
  public static boolean cBZ()
  {
    AppMethodBeat.i(40930);
    boolean bool = ax.aFC(OH("game_haowan_mmkv_key")).getBoolean("game_publish_gallery_first_enter", true);
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
    if (this.rQY)
    {
      ad.i("MicroMsg.GameHaowanDataCenter", "gettingDataFromNet, return");
      AppMethodBeat.o(40921);
      return;
    }
    ad.d("MicroMsg.GameHaowanDataCenter", "getDataFromNet");
    this.rQY = true;
    final g localg = new g();
    if (this.rQU != null) {}
    for (long l = this.rQU.rNR;; l = 0L)
    {
      localg.offset = l;
      if (localg.offset == 0L) {
        localg.rNE = this.rQZ;
      }
      com.tencent.mm.al.b.a locala = new com.tencent.mm.al.b.a();
      locala.uri = "/cgi-bin/mmgame-bin/getuservideolist";
      locala.funcId = 3549;
      locala.gUU = localg;
      locala.gUV = new h();
      IPCRunCgi.a(locala.atI(), new IPCRunCgi.a()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb)
        {
          AppMethodBeat.i(40908);
          ad.i("MicroMsg.GameHaowanDataCenter", "errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          if (localg.offset == 0L)
          {
            a.b(a.this).clear();
            a.c(a.this).clear();
          }
          long l1;
          label101:
          long l2;
          if (!bt.gL(a.b(a.this)))
          {
            paramAnonymousString = (com.tencent.mm.plugin.game.b.b.e)a.b(a.this).getLast();
            if (paramAnonymousString == null) {
              break label440;
            }
            l1 = paramAnonymousString.createTime - 1L;
            if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
              break label454;
            }
            a.a(a.this, (h)paramAnonymousb.gUT.gUX);
            ad.d("MicroMsg.GameHaowanDataCenter", "new_count = %d", new Object[] { Integer.valueOf(a.d(a.this).nrk) });
            paramAnonymousString = a.a(a.d(a.this));
            if (localg.offset == 0L)
            {
              a.a(a.this, a.d(a.this).nrk + a.e(a.this));
              a.b(a.this, a.d(a.this).msg + a.f(a.this));
              a.acl(a.d(a.this).rNE);
              a.qU(System.currentTimeMillis());
            }
            if ((!a.d(a.this).ocU) || (bt.gL(a.d(a.this).rNS))) {
              break label448;
            }
            l2 = ((m)a.d(a.this).rNS.getLast()).rOh * 1000L;
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
              parama.b(a.h(a.this), a.d(a.this).ocU);
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
  
  public final LinkedList<com.tencent.mm.plugin.game.b.b.e> cBR()
  {
    AppMethodBeat.i(40917);
    try
    {
      localObject2 = new com.tencent.mm.vfs.e(rQS);
      localObject1 = i.openRead(rQS);
      try
      {
        Object localObject3 = new byte[(int)((com.tencent.mm.vfs.e)localObject2).length()];
        ((InputStream)localObject1).read((byte[])localObject3);
        localObject2 = new f();
        ((f)localObject2).parseFrom((byte[])localObject3);
        safeClose((Closeable)localObject1);
        this.rQV = ((f)localObject2).rNQ;
        if (bt.gL(this.rQV)) {
          break label174;
        }
        localObject3 = this.rQV.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          com.tencent.mm.plugin.game.b.b.e locale = (com.tencent.mm.plugin.game.b.b.e)((Iterator)localObject3).next();
          if ((!locale.rNJ) && (!locale.rNK)) {
            this.rQW.add(locale);
          }
        }
        ad.e("MicroMsg.GameHaowanDataCenter", "parseGlobalConfig: " + ((Exception)localObject1).getMessage());
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
    localObject2 = ((f)localObject2).rNQ;
    AppMethodBeat.o(40917);
    return localObject2;
  }
  
  public final String cBU()
  {
    AppMethodBeat.i(40922);
    Object localObject1 = new IPCString();
    final int i = cBS();
    ??? = new com.tencent.mm.plugin.game.b.b.a();
    ((com.tencent.mm.plugin.game.b.b.a)???).rNE = this.rQZ;
    com.tencent.mm.al.b.a locala = new com.tencent.mm.al.b.a();
    locala.uri = "/cgi-bin/mmgame-bin/checkuserifhasnewvideo";
    locala.funcId = 3911;
    locala.gUU = ((com.tencent.mm.bx.a)???);
    locala.gUV = new com.tencent.mm.plugin.game.b.b.b();
    IPCRunCgi.a(locala.atI(), new IPCRunCgi.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String arg3, com.tencent.mm.al.b paramAnonymousb)
      {
        AppMethodBeat.i(40909);
        ad.i("MicroMsg.GameHaowanDataCenter", "checkNewVideo errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          ??? = (com.tencent.mm.plugin.game.b.b.b)paramAnonymousb.gUT.gUX;
          paramAnonymousb = bt.nullAsNil(???.desc);
          if (!paramAnonymousb.contains("[count]")) {
            break label131;
          }
          paramAnonymousInt1 = i;
          paramAnonymousInt1 = ???.nrk + paramAnonymousInt1;
          if (paramAnonymousInt1 > 0) {
            this.rRk.value = paramAnonymousb.replace("[count]", String.valueOf(paramAnonymousInt1));
          }
        }
        synchronized (a.j(a.this))
        {
          a.j(a.this).notifyAll();
          AppMethodBeat.o(40909);
          return;
          label131:
          this.rRk.value = paramAnonymousb;
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
          ad.printErrStackTrace("MicroMsg.GameHaowanDataCenter", localInterruptedException, "", new Object[0]);
        }
      }
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(40916);
    Object localObject1 = new f();
    Object localObject2 = this.rQV.iterator();
    do
    {
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
    } while (!((com.tencent.mm.plugin.game.b.b.e)((Iterator)localObject2).next()).rNK);
    for (int i = this.rQV.indexOf(Integer.valueOf(-1));; i = -1)
    {
      if (i > 0) {
        this.rQV.remove(i);
      }
      ((f)localObject1).rNQ = this.rQV;
      cBQ();
      label118:
      for (;;)
      {
        try
        {
          localObject2 = ((f)localObject1).toByteArray();
          localObject1 = i.cM(rQS, false);
          ad.e("MicroMsg.GameHaowanDataCenter", "cacheData: " + localIOException1.getMessage());
        }
        catch (IOException localIOException1)
        {
          try
          {
            ((OutputStream)localObject1).write((byte[])localObject2);
            safeClose((Closeable)localObject1);
            rRf = null;
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
    return (this.rQU != null) && (this.rQU.ocU);
  }
  
  public final void v(JSONArray paramJSONArray)
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
      localb.rBh = localJSONObject.optString("albumName");
      localb.idL = localJSONObject.optString("defaultTitle");
      this.rQT.put(localb.rBh, localb);
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
    String idL;
    String rBh;
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