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
import d.g.b.k;
import d.y;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/sync/EmojiSyncManager;", "", "customType", "", "(I)V", "callbackQueue", "Ljava/util/LinkedList;", "Lcom/tencent/mm/emoji/sync/SyncCallback;", "connectivityReceiver", "Landroid/content/BroadcastReceiver;", "getCustomType", "()I", "downloadCallback", "com/tencent/mm/emoji/sync/EmojiSyncManager$downloadCallback$1", "Lcom/tencent/mm/emoji/sync/EmojiSyncManager$downloadCallback$1;", "downloadList", "", "", "kotlin.jvm.PlatformType", "", "downloadQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/emoji/sync/EmojiDownLoadTask;", "<set-?>", "remainSize", "getRemainSize", "startNonWifi", "", "Lcom/tencent/mm/emoji/sync/EmojiSyncManager$SyncState;", "syncState", "getSyncState", "()Lcom/tencent/mm/emoji/sync/EmojiSyncManager$SyncState;", "totalSize", "getTotalSize", "addDownloadTask", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "checkAutoStart", "checkBroken", "checkSync", "checkSyncEmoji", "start", "withBroken", "destroy", "init", "markBroken", "md5", "registerCallback", "callback", "force", "startInternal", "stop", "unregisterCallback", "Companion", "ConnectivityReceiver", "SyncState", "plugin-emojisdk_release"})
public final class EmojiSyncManager
{
  private static long fRT;
  private static EmojiSyncManager fRU;
  private static EmojiSyncManager fRV;
  public static final a fRW;
  private BroadcastReceiver aJS;
  public int bVq;
  private final com.tencent.mm.loader.g.d<c> fRM;
  private final LinkedList<f> fRN;
  public b fRO;
  public final List<String> fRP;
  private boolean fRQ;
  private final d fRR;
  final int fRS;
  
  static
  {
    AppMethodBeat.i(105761);
    fRW = new a((byte)0);
    AppMethodBeat.o(105761);
  }
  
  public EmojiSyncManager(int paramInt)
  {
    AppMethodBeat.i(105760);
    this.fRS = paramInt;
    this.fRM = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a(2147483647), new com.tencent.mm.loader.g.a.g(1, (byte)0), 1, "EmojiSync"));
    this.fRN = new LinkedList();
    this.fRO = b.fRY;
    this.fRP = Collections.synchronizedList((List)new LinkedList());
    this.fRR = new d(this);
    AppMethodBeat.o(105760);
  }
  
  private final boolean acs()
  {
    AppMethodBeat.i(105759);
    if ((this.fRQ) || (ay.isWifi(aj.getContext())) || (a.acw()))
    {
      AppMethodBeat.o(105759);
      return true;
    }
    AppMethodBeat.o(105759);
    return false;
  }
  
  public static final boolean acw()
  {
    AppMethodBeat.i(177055);
    boolean bool = a.acw();
    AppMethodBeat.o(177055);
    return bool;
  }
  
  public static final void ls(long paramLong)
  {
    AppMethodBeat.i(177054);
    a.ls(paramLong);
    AppMethodBeat.o(177054);
  }
  
  private void n(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105756);
    k.h(paramEmojiInfo, "emojiInfo");
    ad.i(e.abb(), this.fRS + " addDownloadTask: " + paramEmojiInfo.JS());
    this.fRM.b((com.tencent.mm.loader.g.c)new c(paramEmojiInfo));
    AppMethodBeat.o(105756);
  }
  
  private final void startInternal()
  {
    AppMethodBeat.i(105758);
    ad.i(e.abb(), this.fRS + " startInternal: " + this.fRQ + ' ' + ay.isWifi(aj.getContext()) + ' ' + "size is " + this.fRP.size());
    ??? = b.fLw;
    b.clear();
    ??? = this.fRP;
    k.g(???, "downloadList");
    synchronized ((Iterable)???)
    {
      Iterator localIterator = ((Iterable)???).iterator();
      while (localIterator.hasNext())
      {
        Object localObject3 = (String)localIterator.next();
        com.tencent.mm.kernel.b.a locala = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class);
        k.g(locala, "plugin(IPluginEmoji::class.java)");
        localObject3 = ((com.tencent.mm.plugin.emoji.b.d)locala).getProvider().TA((String)localObject3);
        if (localObject3 != null) {
          n((EmojiInfo)localObject3);
        }
      }
    }
    y localy = y.JfV;
    this.fRO = b.fRZ;
    com.tencent.mm.ad.c.g((d.g.a.a)new f(this));
    AppMethodBeat.o(105758);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(105753);
    ad.i(e.abb(), "destroy customType: " + this.fRS);
    this.fRM.b((com.tencent.mm.loader.g.f)this.fRR);
    this.fRM.clean();
    if (this.aJS != null)
    {
      aj.getContext().unregisterReceiver(this.aJS);
      this.aJS = null;
    }
    AppMethodBeat.o(105753);
  }
  
  public final void dr(final boolean paramBoolean)
  {
    AppMethodBeat.i(105757);
    ad.i(e.abb(), this.fRS + " checkSyncEmoji: true " + paramBoolean);
    com.tencent.mm.ad.c.b("EmojiSyncManager_checkBrokenEmoji", (d.g.a.a)new c(this, paramBoolean));
    AppMethodBeat.o(105757);
  }
  
  public final void init()
  {
    AppMethodBeat.i(105752);
    ad.i(e.abb(), "init customType: " + this.fRS);
    this.fRM.a((com.tencent.mm.loader.g.f)this.fRR);
    this.aJS = ((BroadcastReceiver)new ConnectivityReceiver());
    aj.getContext().registerReceiver(this.aJS, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    AppMethodBeat.o(105752);
  }
  
  public final void start(boolean paramBoolean)
  {
    AppMethodBeat.i(105754);
    this.fRQ = paramBoolean;
    if (this.fRO != b.fRZ)
    {
      List localList = this.fRP;
      k.g(localList, "downloadList");
      if (((Collection)localList).isEmpty()) {
        break label69;
      }
    }
    label69:
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (acs())) {
        startInternal();
      }
      AppMethodBeat.o(105754);
      return;
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(105755);
    ad.i(e.abb(), this.fRS + " stop: " + ay.isWifi(aj.getContext()));
    this.fRQ = false;
    this.fRM.clean();
    if (!this.fRP.isEmpty())
    {
      this.fRO = b.fSa;
      com.tencent.mm.ad.c.g((d.g.a.a)new g(this));
    }
    AppMethodBeat.o(105755);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/sync/EmojiSyncManager$ConnectivityReceiver;", "Landroid/content/BroadcastReceiver;", "(Lcom/tencent/mm/emoji/sync/EmojiSyncManager;)V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "plugin-emojisdk_release"})
  public final class ConnectivityReceiver
    extends BroadcastReceiver
  {
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(105738);
      k.h(paramContext, "context");
      k.h(paramIntent, "intent");
      if (!ay.isConnected(paramContext))
      {
        this.fRX.stop();
        AppMethodBeat.o(105738);
        return;
      }
      if (ay.isWifi(paramContext))
      {
        this.fRX.start(false);
        AppMethodBeat.o(105738);
        return;
      }
      if (!EmojiSyncManager.a(this.fRX)) {
        this.fRX.stop();
      }
      AppMethodBeat.o(105738);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/sync/EmojiSyncManager$Companion;", "", "()V", "MaxNoWifiCount", "", "captureSyncMgr", "Lcom/tencent/mm/emoji/sync/EmojiSyncManager;", "customSyncMgr", "noWifiCount", "addNoWifiSize", "", "size", "checkNoWifiSize", "", "getCaptureSyncMgr", "getCustomSyncMgr", "plugin-emojisdk_release"})
  public static final class a
  {
    public static boolean acw()
    {
      AppMethodBeat.i(177053);
      ad.i(e.abb(), "checkNoWifiSize " + EmojiSyncManager.act() / 1048576L + "MB");
      if (EmojiSyncManager.act() < 52428800L)
      {
        AppMethodBeat.o(177053);
        return true;
      }
      AppMethodBeat.o(177053);
      return false;
    }
    
    public static EmojiSyncManager acx()
    {
      AppMethodBeat.i(105736);
      EmojiSyncManager localEmojiSyncManager2 = EmojiSyncManager.acu();
      EmojiSyncManager localEmojiSyncManager1 = localEmojiSyncManager2;
      if (localEmojiSyncManager2 == null)
      {
        localEmojiSyncManager1 = new EmojiSyncManager(0);
        EmojiSyncManager.h(localEmojiSyncManager1);
      }
      AppMethodBeat.o(105736);
      return localEmojiSyncManager1;
    }
    
    public static EmojiSyncManager acy()
    {
      AppMethodBeat.i(105737);
      EmojiSyncManager localEmojiSyncManager2 = EmojiSyncManager.acv();
      EmojiSyncManager localEmojiSyncManager1 = localEmojiSyncManager2;
      if (localEmojiSyncManager2 == null)
      {
        localEmojiSyncManager1 = new EmojiSyncManager(1);
        EmojiSyncManager.i(localEmojiSyncManager1);
      }
      AppMethodBeat.o(105737);
      return localEmojiSyncManager1;
    }
    
    public static void ls(long paramLong)
    {
      AppMethodBeat.i(177052);
      ad.i(e.abb(), "addNoWifiSize " + paramLong + ", " + EmojiSyncManager.act());
      if (!ay.isWifi(aj.getContext())) {
        EmojiSyncManager.lr(EmojiSyncManager.act() + paramLong);
      }
      AppMethodBeat.o(177052);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/sync/EmojiSyncManager$SyncState;", "", "(Ljava/lang/String;I)V", "Init", "Syncing", "Wait", "WaitOffline", "End", "plugin-emojisdk_release"})
  public static enum b
  {
    static
    {
      AppMethodBeat.i(105739);
      b localb1 = new b("Init", 0);
      fRY = localb1;
      b localb2 = new b("Syncing", 1);
      fRZ = localb2;
      b localb3 = new b("Wait", 2);
      fSa = localb3;
      b localb4 = new b("WaitOffline", 3);
      fSb = localb4;
      b localb5 = new b("End", 4);
      fSc = localb5;
      fSd = new b[] { localb1, localb2, localb3, localb4, localb5 };
      AppMethodBeat.o(105739);
    }
    
    private b() {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    c(EmojiSyncManager paramEmojiSyncManager, boolean paramBoolean)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/emoji/sync/EmojiSyncManager$downloadCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/emoji/sync/EmojiDownLoadTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-emojisdk_release"})
  public static final class d
    implements com.tencent.mm.loader.g.f<c>
  {
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      a(EmojiSyncManager.d paramd)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class b
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      b(EmojiSyncManager.d paramd)
      {
        super();
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  public static final class e
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public e(EmojiSyncManager paramEmojiSyncManager, f paramf)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    f(EmojiSyncManager paramEmojiSyncManager)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    g(EmojiSyncManager paramEmojiSyncManager)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  public static final class h
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public h(EmojiSyncManager paramEmojiSyncManager, f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.sync.EmojiSyncManager
 * JD-Core Version:    0.7.0.1
 */