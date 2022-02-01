package com.tencent.mm.emoji.sync;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.loader.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/sync/EmojiSyncManager;", "", "customType", "", "(I)V", "callbackQueue", "Ljava/util/LinkedList;", "Lcom/tencent/mm/emoji/sync/SyncCallback;", "connectivityReceiver", "Landroid/content/BroadcastReceiver;", "getCustomType", "()I", "downloadCallback", "com/tencent/mm/emoji/sync/EmojiSyncManager$downloadCallback$1", "Lcom/tencent/mm/emoji/sync/EmojiSyncManager$downloadCallback$1;", "downloadList", "", "", "kotlin.jvm.PlatformType", "", "downloadQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/emoji/sync/EmojiDownLoadTask;", "<set-?>", "remainSize", "getRemainSize", "startNonWifi", "", "Lcom/tencent/mm/emoji/sync/EmojiSyncManager$SyncState;", "syncState", "getSyncState", "()Lcom/tencent/mm/emoji/sync/EmojiSyncManager$SyncState;", "totalSize", "getTotalSize", "addDownloadTask", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "checkAutoStart", "checkBroken", "checkSync", "checkSyncEmoji", "start", "withBroken", "destroy", "init", "markBroken", "md5", "registerCallback", "callback", "force", "startInternal", "stop", "unregisterCallback", "Companion", "ConnectivityReceiver", "SyncState", "plugin-emojisdk_release"})
public final class EmojiSyncManager
{
  private static long hcX;
  private static EmojiSyncManager hcY;
  private static EmojiSyncManager hcZ;
  public static final a hda;
  private BroadcastReceiver aMq;
  public int cnR;
  private final com.tencent.mm.loader.g.d<c> hcQ;
  private final LinkedList<f> hcR;
  public b hcS;
  public final List<String> hcT;
  private boolean hcU;
  private final d hcV;
  final int hcW;
  
  static
  {
    AppMethodBeat.i(105761);
    hda = new a((byte)0);
    AppMethodBeat.o(105761);
  }
  
  public EmojiSyncManager(int paramInt)
  {
    AppMethodBeat.i(105760);
    this.hcW = paramInt;
    this.hcQ = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a(2147483647), new com.tencent.mm.loader.g.a.g(1, (byte)0), 1, "EmojiSync"));
    this.hcR = new LinkedList();
    this.hcS = b.hdc;
    this.hcT = Collections.synchronizedList((List)new LinkedList());
    this.hcV = new d(this);
    AppMethodBeat.o(105760);
  }
  
  private final boolean awi()
  {
    AppMethodBeat.i(105759);
    if ((this.hcU) || (NetStatusUtil.isWifi(MMApplicationContext.getContext())) || (a.awm()))
    {
      AppMethodBeat.o(105759);
      return true;
    }
    AppMethodBeat.o(105759);
    return false;
  }
  
  public static final boolean awm()
  {
    AppMethodBeat.i(177055);
    boolean bool = a.awm();
    AppMethodBeat.o(177055);
    return bool;
  }
  
  private void n(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105756);
    p.h(paramEmojiInfo, "emojiInfo");
    Log.i(e.auD(), this.hcW + " addDownloadTask: " + paramEmojiInfo.getMd5());
    this.hcQ.c((com.tencent.mm.loader.g.c)new c(paramEmojiInfo));
    AppMethodBeat.o(105756);
  }
  
  private final void startInternal()
  {
    AppMethodBeat.i(105758);
    Log.i(e.auD(), this.hcW + " startInternal: " + this.hcU + ' ' + NetStatusUtil.isWifi(MMApplicationContext.getContext()) + ' ' + "size is " + this.hcT.size());
    ??? = b.gVU;
    b.clear();
    ??? = this.hcT;
    p.g(???, "downloadList");
    synchronized ((Iterable)???)
    {
      Iterator localIterator = ((Iterable)???).iterator();
      while (localIterator.hasNext())
      {
        Object localObject3 = (String)localIterator.next();
        com.tencent.mm.kernel.b.a locala = com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class);
        p.g(locala, "plugin(IPluginEmoji::class.java)");
        localObject3 = ((com.tencent.mm.plugin.emoji.b.d)locala).getProvider().amm((String)localObject3);
        if (localObject3 != null) {
          n((EmojiInfo)localObject3);
        }
      }
    }
    x localx = x.SXb;
    this.hcS = b.hdd;
    com.tencent.mm.ac.d.h((kotlin.g.a.a)new f(this));
    AppMethodBeat.o(105758);
  }
  
  public static final void zl(long paramLong)
  {
    AppMethodBeat.i(177054);
    a.zl(paramLong);
    AppMethodBeat.o(177054);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(105753);
    Log.i(e.auD(), "destroy customType: " + this.hcW);
    this.hcQ.b((com.tencent.mm.loader.g.f)this.hcV);
    this.hcQ.clean();
    if (this.aMq != null)
    {
      MMApplicationContext.getContext().unregisterReceiver(this.aMq);
      this.aMq = null;
    }
    AppMethodBeat.o(105753);
  }
  
  public final void eg(final boolean paramBoolean)
  {
    AppMethodBeat.i(105757);
    if (!MMApplicationContext.isMainProcess())
    {
      AppMethodBeat.o(105757);
      return;
    }
    Log.i(e.auD(), this.hcW + " checkSyncEmoji: true " + paramBoolean);
    com.tencent.mm.ac.d.b("EmojiSyncManager_checkBrokenEmoji", (kotlin.g.a.a)new c(this, paramBoolean));
    AppMethodBeat.o(105757);
  }
  
  public final void init()
  {
    AppMethodBeat.i(105752);
    Log.i(e.auD(), "init customType: " + this.hcW);
    this.hcQ.a((com.tencent.mm.loader.g.f)this.hcV);
    this.aMq = ((BroadcastReceiver)new ConnectivityReceiver());
    MMApplicationContext.getContext().registerReceiver(this.aMq, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    AppMethodBeat.o(105752);
  }
  
  public final void start(boolean paramBoolean)
  {
    AppMethodBeat.i(105754);
    if (!MMApplicationContext.isMainProcess())
    {
      AppMethodBeat.o(105754);
      return;
    }
    this.hcU = paramBoolean;
    if (this.hcS != b.hdd)
    {
      List localList = this.hcT;
      p.g(localList, "downloadList");
      if (((Collection)localList).isEmpty()) {
        break label82;
      }
    }
    label82:
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (awi())) {
        startInternal();
      }
      AppMethodBeat.o(105754);
      return;
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(105755);
    Log.i(e.auD(), this.hcW + " stop: " + NetStatusUtil.isWifi(MMApplicationContext.getContext()));
    this.hcU = false;
    this.hcQ.clean();
    if (!this.hcT.isEmpty())
    {
      this.hcS = b.hde;
      com.tencent.mm.ac.d.h((kotlin.g.a.a)new g(this));
    }
    AppMethodBeat.o(105755);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/sync/EmojiSyncManager$ConnectivityReceiver;", "Landroid/content/BroadcastReceiver;", "(Lcom/tencent/mm/emoji/sync/EmojiSyncManager;)V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "plugin-emojisdk_release"})
  public final class ConnectivityReceiver
    extends BroadcastReceiver
  {
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(105738);
      p.h(paramContext, "context");
      p.h(paramIntent, "intent");
      if (!NetStatusUtil.isConnected(paramContext))
      {
        this.hdb.stop();
        AppMethodBeat.o(105738);
        return;
      }
      if (NetStatusUtil.isWifi(paramContext))
      {
        this.hdb.start(false);
        AppMethodBeat.o(105738);
        return;
      }
      if (!EmojiSyncManager.a(this.hdb)) {
        this.hdb.stop();
      }
      AppMethodBeat.o(105738);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/sync/EmojiSyncManager$Companion;", "", "()V", "MaxNoWifiCount", "", "captureSyncMgr", "Lcom/tencent/mm/emoji/sync/EmojiSyncManager;", "customSyncMgr", "noWifiCount", "addNoWifiSize", "", "size", "checkNoWifiSize", "", "getCaptureSyncMgr", "getCustomSyncMgr", "plugin-emojisdk_release"})
  public static final class a
  {
    public static boolean awm()
    {
      AppMethodBeat.i(177053);
      Log.i(e.auD(), "checkNoWifiSize " + EmojiSyncManager.awj() / 1048576L + "MB");
      if (EmojiSyncManager.awj() < 52428800L)
      {
        AppMethodBeat.o(177053);
        return true;
      }
      AppMethodBeat.o(177053);
      return false;
    }
    
    public static EmojiSyncManager awn()
    {
      AppMethodBeat.i(105736);
      EmojiSyncManager localEmojiSyncManager2 = EmojiSyncManager.awk();
      EmojiSyncManager localEmojiSyncManager1 = localEmojiSyncManager2;
      if (localEmojiSyncManager2 == null)
      {
        localEmojiSyncManager1 = new EmojiSyncManager(0);
        EmojiSyncManager.h(localEmojiSyncManager1);
      }
      AppMethodBeat.o(105736);
      return localEmojiSyncManager1;
    }
    
    public static EmojiSyncManager awo()
    {
      AppMethodBeat.i(105737);
      EmojiSyncManager localEmojiSyncManager2 = EmojiSyncManager.awl();
      EmojiSyncManager localEmojiSyncManager1 = localEmojiSyncManager2;
      if (localEmojiSyncManager2 == null)
      {
        localEmojiSyncManager1 = new EmojiSyncManager(1);
        EmojiSyncManager.i(localEmojiSyncManager1);
      }
      AppMethodBeat.o(105737);
      return localEmojiSyncManager1;
    }
    
    public static void zl(long paramLong)
    {
      AppMethodBeat.i(177052);
      Log.i(e.auD(), "addNoWifiSize " + paramLong + ", " + EmojiSyncManager.awj());
      if (!NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
        EmojiSyncManager.zk(EmojiSyncManager.awj() + paramLong);
      }
      AppMethodBeat.o(177052);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/sync/EmojiSyncManager$SyncState;", "", "(Ljava/lang/String;I)V", "Init", "Syncing", "Wait", "WaitOffline", "End", "plugin-emojisdk_release"})
  public static enum b
  {
    static
    {
      AppMethodBeat.i(105739);
      b localb1 = new b("Init", 0);
      hdc = localb1;
      b localb2 = new b("Syncing", 1);
      hdd = localb2;
      b localb3 = new b("Wait", 2);
      hde = localb3;
      b localb4 = new b("WaitOffline", 3);
      hdf = localb4;
      b localb5 = new b("End", 4);
      hdg = localb5;
      hdh = new b[] { localb1, localb2, localb3, localb4, localb5 };
      AppMethodBeat.o(105739);
    }
    
    private b() {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    c(EmojiSyncManager paramEmojiSyncManager, boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/emoji/sync/EmojiSyncManager$downloadCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/emoji/sync/EmojiDownLoadTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-emojisdk_release"})
  public static final class d
    implements com.tencent.mm.loader.g.f<c>
  {
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(EmojiSyncManager.d paramd)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class b
      extends q
      implements kotlin.g.a.a<x>
    {
      b(EmojiSyncManager.d paramd)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  public static final class e
    extends q
    implements kotlin.g.a.a<x>
  {
    public e(EmojiSyncManager paramEmojiSyncManager, f paramf)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<x>
  {
    f(EmojiSyncManager paramEmojiSyncManager)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<x>
  {
    g(EmojiSyncManager paramEmojiSyncManager)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  public static final class h
    extends q
    implements kotlin.g.a.a<x>
  {
    public h(EmojiSyncManager paramEmojiSyncManager, f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.sync.EmojiSyncManager
 * JD-Core Version:    0.7.0.1
 */