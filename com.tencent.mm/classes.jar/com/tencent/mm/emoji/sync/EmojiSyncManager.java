package com.tencent.mm.emoji.sync;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.loader.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/sync/EmojiSyncManager;", "", "customType", "", "(I)V", "callbackQueue", "Ljava/util/LinkedList;", "Lcom/tencent/mm/emoji/sync/SyncCallback;", "connectivityReceiver", "Landroid/content/BroadcastReceiver;", "getCustomType", "()I", "downloadCallback", "com/tencent/mm/emoji/sync/EmojiSyncManager$downloadCallback$1", "Lcom/tencent/mm/emoji/sync/EmojiSyncManager$downloadCallback$1;", "downloadList", "", "", "kotlin.jvm.PlatformType", "", "downloadQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/emoji/sync/EmojiDownLoadTask;", "<set-?>", "remainSize", "getRemainSize", "startNonWifi", "", "Lcom/tencent/mm/emoji/sync/EmojiSyncManager$SyncState;", "syncState", "getSyncState", "()Lcom/tencent/mm/emoji/sync/EmojiSyncManager$SyncState;", "totalSize", "getTotalSize", "addDownloadTask", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "checkAutoStart", "checkBroken", "checkSync", "checkSyncEmoji", "start", "withBroken", "destroy", "init", "markBroken", "md5", "registerCallback", "callback", "force", "startInternal", "stop", "unregisterCallback", "Companion", "ConnectivityReceiver", "SyncState", "plugin-emojisdk_release"})
public final class EmojiSyncManager
{
  private static long gpr;
  private static EmojiSyncManager gps;
  private static EmojiSyncManager gpt;
  public static final a gpu;
  private BroadcastReceiver aMz;
  public int cdl;
  private final com.tencent.mm.loader.g.d<c> gpk;
  private final LinkedList<f> gpl;
  public b gpm;
  public final List<String> gpn;
  private boolean gpo;
  private final d gpp;
  final int gpq;
  
  static
  {
    AppMethodBeat.i(105761);
    gpu = new a((byte)0);
    AppMethodBeat.o(105761);
  }
  
  public EmojiSyncManager(int paramInt)
  {
    AppMethodBeat.i(105760);
    this.gpq = paramInt;
    this.gpk = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a(2147483647), new com.tencent.mm.loader.g.a.g(1, (byte)0), 1, "EmojiSync"));
    this.gpl = new LinkedList();
    this.gpm = b.gpw;
    this.gpn = Collections.synchronizedList((List)new LinkedList());
    this.gpp = new d(this);
    AppMethodBeat.o(105760);
  }
  
  private final boolean age()
  {
    AppMethodBeat.i(105759);
    if ((this.gpo) || (ay.isWifi(aj.getContext())) || (a.agi()))
    {
      AppMethodBeat.o(105759);
      return true;
    }
    AppMethodBeat.o(105759);
    return false;
  }
  
  public static final boolean agi()
  {
    AppMethodBeat.i(177055);
    boolean bool = a.agi();
    AppMethodBeat.o(177055);
    return bool;
  }
  
  private void n(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105756);
    p.h(paramEmojiInfo, "emojiInfo");
    ad.i(e.aeD(), this.gpq + " addDownloadTask: " + paramEmojiInfo.Lb());
    this.gpk.b((com.tencent.mm.loader.g.c)new c(paramEmojiInfo));
    AppMethodBeat.o(105756);
  }
  
  public static final void qV(long paramLong)
  {
    AppMethodBeat.i(177054);
    a.qV(paramLong);
    AppMethodBeat.o(177054);
  }
  
  private final void startInternal()
  {
    AppMethodBeat.i(105758);
    ad.i(e.aeD(), this.gpq + " startInternal: " + this.gpo + ' ' + ay.isWifi(aj.getContext()) + ' ' + "size is " + this.gpn.size());
    ??? = b.giI;
    b.clear();
    ??? = this.gpn;
    p.g(???, "downloadList");
    synchronized ((Iterable)???)
    {
      Iterator localIterator = ((Iterable)???).iterator();
      while (localIterator.hasNext())
      {
        Object localObject3 = (String)localIterator.next();
        com.tencent.mm.kernel.b.a locala = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class);
        p.g(locala, "plugin(IPluginEmoji::class.java)");
        localObject3 = ((com.tencent.mm.plugin.emoji.b.d)locala).getProvider().abs((String)localObject3);
        if (localObject3 != null) {
          n((EmojiInfo)localObject3);
        }
      }
    }
    z localz = z.MKo;
    this.gpm = b.gpx;
    com.tencent.mm.ad.c.g((d.g.a.a)new f(this));
    AppMethodBeat.o(105758);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(105753);
    ad.i(e.aeD(), "destroy customType: " + this.gpq);
    this.gpk.b((com.tencent.mm.loader.g.f)this.gpp);
    this.gpk.clean();
    if (this.aMz != null)
    {
      aj.getContext().unregisterReceiver(this.aMz);
      this.aMz = null;
    }
    AppMethodBeat.o(105753);
  }
  
  public final void dt(final boolean paramBoolean)
  {
    AppMethodBeat.i(105757);
    if (!aj.cmR())
    {
      AppMethodBeat.o(105757);
      return;
    }
    ad.i(e.aeD(), this.gpq + " checkSyncEmoji: true " + paramBoolean);
    com.tencent.mm.ad.c.b("EmojiSyncManager_checkBrokenEmoji", (d.g.a.a)new c(this, paramBoolean));
    AppMethodBeat.o(105757);
  }
  
  public final void init()
  {
    AppMethodBeat.i(105752);
    ad.i(e.aeD(), "init customType: " + this.gpq);
    this.gpk.a((com.tencent.mm.loader.g.f)this.gpp);
    this.aMz = ((BroadcastReceiver)new ConnectivityReceiver());
    aj.getContext().registerReceiver(this.aMz, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    AppMethodBeat.o(105752);
  }
  
  public final void start(boolean paramBoolean)
  {
    AppMethodBeat.i(105754);
    if (!aj.cmR())
    {
      AppMethodBeat.o(105754);
      return;
    }
    this.gpo = paramBoolean;
    if (this.gpm != b.gpx)
    {
      List localList = this.gpn;
      p.g(localList, "downloadList");
      if (((Collection)localList).isEmpty()) {
        break label82;
      }
    }
    label82:
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (age())) {
        startInternal();
      }
      AppMethodBeat.o(105754);
      return;
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(105755);
    ad.i(e.aeD(), this.gpq + " stop: " + ay.isWifi(aj.getContext()));
    this.gpo = false;
    this.gpk.clean();
    if (!this.gpn.isEmpty())
    {
      this.gpm = b.gpy;
      com.tencent.mm.ad.c.g((d.g.a.a)new g(this));
    }
    AppMethodBeat.o(105755);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/sync/EmojiSyncManager$ConnectivityReceiver;", "Landroid/content/BroadcastReceiver;", "(Lcom/tencent/mm/emoji/sync/EmojiSyncManager;)V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "plugin-emojisdk_release"})
  public final class ConnectivityReceiver
    extends BroadcastReceiver
  {
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(105738);
      p.h(paramContext, "context");
      p.h(paramIntent, "intent");
      if (!ay.isConnected(paramContext))
      {
        this.gpv.stop();
        AppMethodBeat.o(105738);
        return;
      }
      if (ay.isWifi(paramContext))
      {
        this.gpv.start(false);
        AppMethodBeat.o(105738);
        return;
      }
      if (!EmojiSyncManager.a(this.gpv)) {
        this.gpv.stop();
      }
      AppMethodBeat.o(105738);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/sync/EmojiSyncManager$Companion;", "", "()V", "MaxNoWifiCount", "", "captureSyncMgr", "Lcom/tencent/mm/emoji/sync/EmojiSyncManager;", "customSyncMgr", "noWifiCount", "addNoWifiSize", "", "size", "checkNoWifiSize", "", "getCaptureSyncMgr", "getCustomSyncMgr", "plugin-emojisdk_release"})
  public static final class a
  {
    public static boolean agi()
    {
      AppMethodBeat.i(177053);
      ad.i(e.aeD(), "checkNoWifiSize " + EmojiSyncManager.agf() / 1048576L + "MB");
      if (EmojiSyncManager.agf() < 52428800L)
      {
        AppMethodBeat.o(177053);
        return true;
      }
      AppMethodBeat.o(177053);
      return false;
    }
    
    public static EmojiSyncManager agj()
    {
      AppMethodBeat.i(105736);
      EmojiSyncManager localEmojiSyncManager2 = EmojiSyncManager.agg();
      EmojiSyncManager localEmojiSyncManager1 = localEmojiSyncManager2;
      if (localEmojiSyncManager2 == null)
      {
        localEmojiSyncManager1 = new EmojiSyncManager(0);
        EmojiSyncManager.h(localEmojiSyncManager1);
      }
      AppMethodBeat.o(105736);
      return localEmojiSyncManager1;
    }
    
    public static EmojiSyncManager agk()
    {
      AppMethodBeat.i(105737);
      EmojiSyncManager localEmojiSyncManager2 = EmojiSyncManager.agh();
      EmojiSyncManager localEmojiSyncManager1 = localEmojiSyncManager2;
      if (localEmojiSyncManager2 == null)
      {
        localEmojiSyncManager1 = new EmojiSyncManager(1);
        EmojiSyncManager.i(localEmojiSyncManager1);
      }
      AppMethodBeat.o(105737);
      return localEmojiSyncManager1;
    }
    
    public static void qV(long paramLong)
    {
      AppMethodBeat.i(177052);
      ad.i(e.aeD(), "addNoWifiSize " + paramLong + ", " + EmojiSyncManager.agf());
      if (!ay.isWifi(aj.getContext())) {
        EmojiSyncManager.qU(EmojiSyncManager.agf() + paramLong);
      }
      AppMethodBeat.o(177052);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/sync/EmojiSyncManager$SyncState;", "", "(Ljava/lang/String;I)V", "Init", "Syncing", "Wait", "WaitOffline", "End", "plugin-emojisdk_release"})
  public static enum b
  {
    static
    {
      AppMethodBeat.i(105739);
      b localb1 = new b("Init", 0);
      gpw = localb1;
      b localb2 = new b("Syncing", 1);
      gpx = localb2;
      b localb3 = new b("Wait", 2);
      gpy = localb3;
      b localb4 = new b("WaitOffline", 3);
      gpz = localb4;
      b localb5 = new b("End", 4);
      gpA = localb5;
      gpB = new b[] { localb1, localb2, localb3, localb4, localb5 };
      AppMethodBeat.o(105739);
    }
    
    private b() {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<z>
  {
    c(EmojiSyncManager paramEmojiSyncManager, boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/emoji/sync/EmojiSyncManager$downloadCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/emoji/sync/EmojiDownLoadTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-emojisdk_release"})
  public static final class d
    implements com.tencent.mm.loader.g.f<c>
  {
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements d.g.a.a<z>
    {
      a(EmojiSyncManager.d paramd)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class b
      extends q
      implements d.g.a.a<z>
    {
      b(EmojiSyncManager.d paramd)
      {
        super();
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  public static final class e
    extends q
    implements d.g.a.a<z>
  {
    public e(EmojiSyncManager paramEmojiSyncManager, f paramf)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements d.g.a.a<z>
  {
    f(EmojiSyncManager paramEmojiSyncManager)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements d.g.a.a<z>
  {
    g(EmojiSyncManager paramEmojiSyncManager)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  public static final class h
    extends q
    implements d.g.a.a<z>
  {
    public h(EmojiSyncManager paramEmojiSyncManager, f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.sync.EmojiSyncManager
 * JD-Core Version:    0.7.0.1
 */