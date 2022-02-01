package com.tencent.mm.plugin.game.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.b.p;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.i.c;
import com.tencent.mm.plugin.gallery.model.o;
import com.tencent.mm.plugin.game.b.b.f;
import com.tencent.mm.plugin.game.b.b.g;
import com.tencent.mm.plugin.game.b.b.h;
import com.tencent.mm.plugin.game.b.b.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
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
  private static long oVG;
  private static final String sYH;
  private static final String sYI;
  private static a sYV;
  private int fAw;
  private Object lock;
  private final HashMap<String, b> sYJ;
  private h sYK;
  private LinkedList<com.tencent.mm.plugin.game.b.b.e> sYL;
  LinkedList<com.tencent.mm.plugin.game.b.b.e> sYM;
  LinkedList<com.tencent.mm.plugin.game.b.b.e> sYN;
  private boolean sYO;
  private String sYP;
  private long sYQ;
  private int sYR;
  private boolean sYS;
  private d sYT;
  private int sYU;
  
  static
  {
    AppMethodBeat.i(40942);
    sYH = com.tencent.mm.plugin.game.commlib.e.b.a(com.tencent.mm.plugin.game.commlib.e.b.a.sWx) + "haowan/";
    sYI = sYH + "haowan_gallery_cache";
    oVG = 0L;
    AppMethodBeat.o(40942);
  }
  
  public a()
  {
    AppMethodBeat.i(40913);
    this.lock = new Object();
    this.sYJ = new HashMap();
    this.sYL = new LinkedList();
    this.sYM = new LinkedList();
    this.sYN = new LinkedList();
    this.sYO = false;
    this.sYT = null;
    this.sYU = 0;
    this.sYP = aw.aKT(SR("game_haowan_mmkv_key")).getString("game_remote_ticket", null);
    this.sYQ = aw.aKT(SR("game_haowan_mmkv_key")).getLong("game_local_ticket", 0L);
    cPb();
    AppMethodBeat.o(40913);
  }
  
  public static void Gj(int paramInt)
  {
    AppMethodBeat.i(40925);
    aw localaw = aw.aKT(SR("game_haowan_mmkv_key"));
    localaw.putInt("game_last_choose_gallery", paramInt);
    localaw.apply();
    AppMethodBeat.o(40925);
  }
  
  private static String Gk(int paramInt)
  {
    AppMethodBeat.i(40932);
    String str = new p(paramInt).toString();
    AppMethodBeat.o(40932);
    return str;
  }
  
  private static String SR(String paramString)
  {
    AppMethodBeat.i(40931);
    int i = com.tencent.mm.kernel.a.agb();
    if (i == 0)
    {
      AppMethodBeat.o(40931);
      return paramString;
    }
    paramString = paramString + "_" + Gk(i);
    AppMethodBeat.o(40931);
    return paramString;
  }
  
  public static void a(int paramInt, c paramc)
  {
    AppMethodBeat.i(40924);
    com.tencent.mm.plugin.gallery.model.e.cMt().setQueryType(paramInt);
    com.tencent.mm.plugin.gallery.model.e.cMt().kxr = 15;
    com.tencent.mm.plugin.gallery.model.e.cMt().a(new i.c()
    {
      public final void b(LinkedList<GalleryItem.MediaItem> paramAnonymousLinkedList, long paramAnonymousLong, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(40911);
        if ((a.cPm() == paramAnonymousLong) && (this.sZb != null)) {
          this.sZb.as(paramAnonymousLinkedList);
        }
        AppMethodBeat.o(40911);
      }
    });
    oVG = System.currentTimeMillis();
    com.tencent.mm.plugin.gallery.model.e.cMt().au("", oVG);
    AppMethodBeat.o(40924);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(40912);
    if (sYV == null)
    {
      parama.b(null, false);
      AppMethodBeat.o(40912);
      return;
    }
    sYV.b(new a()
    {
      public final void b(LinkedList<com.tencent.mm.plugin.game.b.b.e> paramAnonymousLinkedList, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(40907);
        if (this.sYW != null) {
          this.sYW.b(a.cPl().sYN, paramAnonymousBoolean);
        }
        AppMethodBeat.o(40907);
      }
    });
    AppMethodBeat.o(40912);
  }
  
  public static void a(a parama)
  {
    sYV = parama;
  }
  
  private static void cPb()
  {
    AppMethodBeat.i(40915);
    com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(sYH);
    if ((!locale.exists()) || (!locale.isDirectory())) {
      locale.mkdirs();
    }
    AppMethodBeat.o(40915);
  }
  
  private int cPd()
  {
    AppMethodBeat.i(40919);
    if (this.sYQ == 0L)
    {
      AppMethodBeat.o(40919);
      return 0;
    }
    int i = j.cPs().b(cPe(), System.currentTimeMillis(), this.sYQ + 1L);
    AppMethodBeat.o(40919);
    return i;
  }
  
  private LinkedList<String> cPe()
  {
    AppMethodBeat.i(40920);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.sYJ.values().iterator();
    while (localIterator.hasNext()) {
      localLinkedList.add(((b)localIterator.next()).sJZ);
    }
    AppMethodBeat.o(40920);
    return localLinkedList;
  }
  
  public static int cPg()
  {
    AppMethodBeat.i(40926);
    int i = aw.aKT(SR("game_haowan_mmkv_key")).getInt("game_last_choose_gallery", 0);
    AppMethodBeat.o(40926);
    return i;
  }
  
  public static void cPh()
  {
    AppMethodBeat.i(40927);
    aw localaw = aw.aKT(SR("game_haowan_mmkv_key"));
    localaw.putBoolean("game_tab_gallery_first_enter", false);
    localaw.apply();
    AppMethodBeat.o(40927);
  }
  
  public static boolean cPi()
  {
    AppMethodBeat.i(40928);
    boolean bool = aw.aKT(SR("game_haowan_mmkv_key")).getBoolean("game_tab_gallery_first_enter", true);
    AppMethodBeat.o(40928);
    return bool;
  }
  
  public static void cPj()
  {
    AppMethodBeat.i(40929);
    aw localaw = aw.aKT(SR("game_haowan_mmkv_key"));
    localaw.putBoolean("game_publish_gallery_first_enter", false);
    localaw.apply();
    AppMethodBeat.o(40929);
  }
  
  public static boolean cPk()
  {
    AppMethodBeat.i(40930);
    boolean bool = aw.aKT(SR("game_haowan_mmkv_key")).getBoolean("game_publish_gallery_first_enter", true);
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
    if (this.sYO)
    {
      ac.i("MicroMsg.GameHaowanDataCenter", "gettingDataFromNet, return");
      AppMethodBeat.o(40921);
      return;
    }
    ac.d("MicroMsg.GameHaowanDataCenter", "getDataFromNet");
    this.sYO = true;
    final g localg = new g();
    if (this.sYK != null) {}
    for (long l = this.sYK.sVI;; l = 0L)
    {
      localg.offset = l;
      if (localg.offset == 0L) {
        localg.sVt = this.sYP;
      }
      com.tencent.mm.ak.b.a locala = new com.tencent.mm.ak.b.a();
      locala.uri = "/cgi-bin/mmgame-bin/getuservideolist";
      locala.funcId = 3549;
      locala.hvt = localg;
      locala.hvu = new h();
      IPCRunCgi.a(locala.aAz(), new IPCRunCgi.a()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb)
        {
          AppMethodBeat.i(40908);
          ac.i("MicroMsg.GameHaowanDataCenter", "errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          if (localg.offset == 0L)
          {
            a.b(a.this).clear();
            a.c(a.this).clear();
          }
          long l1;
          label101:
          long l2;
          if (!bs.gY(a.b(a.this)))
          {
            paramAnonymousString = (com.tencent.mm.plugin.game.b.b.e)a.b(a.this).getLast();
            if (paramAnonymousString == null) {
              break label440;
            }
            l1 = paramAnonymousString.createTime - 1L;
            if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
              break label454;
            }
            a.a(a.this, (h)paramAnonymousb.hvs.hvw);
            ac.d("MicroMsg.GameHaowanDataCenter", "new_count = %d", new Object[] { Integer.valueOf(a.d(a.this).nUk) });
            paramAnonymousString = a.a(a.d(a.this));
            if (localg.offset == 0L)
            {
              a.a(a.this, a.d(a.this).nUk + a.e(a.this));
              a.b(a.this, a.d(a.this).mUh + a.f(a.this));
              a.ahd(a.d(a.this).sVt);
              a.vx(System.currentTimeMillis());
            }
            if ((!a.d(a.this).oGt) || (bs.gY(a.d(a.this).sVJ))) {
              break label448;
            }
            l2 = ((m)a.d(a.this).sVJ.getLast()).sVY * 1000L;
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
              parama.b(a.h(a.this), a.d(a.this).oGt);
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
  
  public final LinkedList<com.tencent.mm.plugin.game.b.b.e> cPc()
  {
    AppMethodBeat.i(40917);
    try
    {
      localObject2 = new com.tencent.mm.vfs.e(sYI);
      localObject1 = i.openRead(sYI);
      try
      {
        Object localObject3 = new byte[(int)((com.tencent.mm.vfs.e)localObject2).length()];
        ((InputStream)localObject1).read((byte[])localObject3);
        localObject2 = new f();
        ((f)localObject2).parseFrom((byte[])localObject3);
        safeClose((Closeable)localObject1);
        this.sYL = ((f)localObject2).sVH;
        if (bs.gY(this.sYL)) {
          break label174;
        }
        localObject3 = this.sYL.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          com.tencent.mm.plugin.game.b.b.e locale = (com.tencent.mm.plugin.game.b.b.e)((Iterator)localObject3).next();
          if ((!locale.sVz) && (!locale.sVA)) {
            this.sYM.add(locale);
          }
        }
        ac.e("MicroMsg.GameHaowanDataCenter", "parseGlobalConfig: " + ((Exception)localObject1).getMessage());
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
    localObject2 = ((f)localObject2).sVH;
    AppMethodBeat.o(40917);
    return localObject2;
  }
  
  public final String cPf()
  {
    AppMethodBeat.i(40922);
    Object localObject1 = new IPCString();
    final int i = cPd();
    ??? = new com.tencent.mm.plugin.game.b.b.a();
    ((com.tencent.mm.plugin.game.b.b.a)???).sVt = this.sYP;
    com.tencent.mm.ak.b.a locala = new com.tencent.mm.ak.b.a();
    locala.uri = "/cgi-bin/mmgame-bin/checkuserifhasnewvideo";
    locala.funcId = 3911;
    locala.hvt = ((com.tencent.mm.bw.a)???);
    locala.hvu = new com.tencent.mm.plugin.game.b.b.b();
    IPCRunCgi.a(locala.aAz(), new IPCRunCgi.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String arg3, com.tencent.mm.ak.b paramAnonymousb)
      {
        AppMethodBeat.i(40909);
        ac.i("MicroMsg.GameHaowanDataCenter", "checkNewVideo errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          ??? = (com.tencent.mm.plugin.game.b.b.b)paramAnonymousb.hvs.hvw;
          paramAnonymousb = bs.nullAsNil(???.desc);
          if (!paramAnonymousb.contains("[count]")) {
            break label131;
          }
          paramAnonymousInt1 = i;
          paramAnonymousInt1 = ???.nUk + paramAnonymousInt1;
          if (paramAnonymousInt1 > 0) {
            this.sZa.value = paramAnonymousb.replace("[count]", String.valueOf(paramAnonymousInt1));
          }
        }
        synchronized (a.j(a.this))
        {
          a.j(a.this).notifyAll();
          AppMethodBeat.o(40909);
          return;
          label131:
          this.sZa.value = paramAnonymousb;
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
          ac.printErrStackTrace("MicroMsg.GameHaowanDataCenter", localInterruptedException, "", new Object[0]);
        }
      }
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(40916);
    Object localObject1 = new f();
    Object localObject2 = this.sYL.iterator();
    do
    {
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
    } while (!((com.tencent.mm.plugin.game.b.b.e)((Iterator)localObject2).next()).sVA);
    for (int i = this.sYL.indexOf(Integer.valueOf(-1));; i = -1)
    {
      if (i > 0) {
        this.sYL.remove(i);
      }
      ((f)localObject1).sVH = this.sYL;
      cPb();
      label118:
      for (;;)
      {
        try
        {
          localObject2 = ((f)localObject1).toByteArray();
          localObject1 = i.cS(sYI, false);
          ac.e("MicroMsg.GameHaowanDataCenter", "cacheData: " + localIOException1.getMessage());
        }
        catch (IOException localIOException1)
        {
          try
          {
            ((OutputStream)localObject1).write((byte[])localObject2);
            safeClose((Closeable)localObject1);
            sYV = null;
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
    return (this.sYK != null) && (this.sYK.oGt);
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
      localb.sJZ = localJSONObject.optString("albumName");
      localb.iDU = localJSONObject.optString("defaultTitle");
      this.sYJ.put(localb.sJZ, localb);
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
    String iDU;
    String sJZ;
  }
  
  static abstract interface c
  {
    public abstract void as(LinkedList<GalleryItem.MediaItem> paramLinkedList);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.a
 * JD-Core Version:    0.7.0.1
 */