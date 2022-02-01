package com.tencent.mm.emoji.sync;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.loader.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.b.k;
import d.y;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/sync/EmojiSyncManager;", "", "customType", "", "(I)V", "callbackQueue", "Ljava/util/LinkedList;", "Lcom/tencent/mm/emoji/sync/SyncCallback;", "connectivityReceiver", "Landroid/content/BroadcastReceiver;", "getCustomType", "()I", "downloadCallback", "com/tencent/mm/emoji/sync/EmojiSyncManager$downloadCallback$1", "Lcom/tencent/mm/emoji/sync/EmojiSyncManager$downloadCallback$1;", "downloadList", "", "", "kotlin.jvm.PlatformType", "", "downloadQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/emoji/sync/EmojiDownLoadTask;", "<set-?>", "remainSize", "getRemainSize", "startNonWifi", "", "Lcom/tencent/mm/emoji/sync/EmojiSyncManager$SyncState;", "syncState", "getSyncState", "()Lcom/tencent/mm/emoji/sync/EmojiSyncManager$SyncState;", "totalSize", "getTotalSize", "addDownloadTask", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "checkAutoStart", "checkBroken", "checkSync", "checkSyncEmoji", "start", "withBroken", "destroy", "init", "markBroken", "md5", "registerCallback", "callback", "force", "startInternal", "stop", "unregisterCallback", "Companion", "ConnectivityReceiver", "SyncState", "plugin-emojisdk_release"})
public final class EmojiSyncManager
{
  private static long fVO;
  private static EmojiSyncManager fVP;
  private static EmojiSyncManager fVQ;
  public static final a fVR;
  private BroadcastReceiver aKI;
  public int bSY;
  private final com.tencent.mm.loader.g.d<c> fVH;
  private final LinkedList<f> fVI;
  public b fVJ;
  public final List<String> fVK;
  private boolean fVL;
  private final d fVM;
  final int fVN;
  
  static
  {
    AppMethodBeat.i(105761);
    fVR = new a((byte)0);
    AppMethodBeat.o(105761);
  }
  
  public EmojiSyncManager(int paramInt)
  {
    AppMethodBeat.i(105760);
    this.fVN = paramInt;
    this.fVH = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a(2147483647), new com.tencent.mm.loader.g.a.g(1, (byte)0), 1, "EmojiSync"));
    this.fVI = new LinkedList();
    this.fVJ = b.fVT;
    this.fVK = Collections.synchronizedList((List)new LinkedList());
    this.fVM = new d(this);
    AppMethodBeat.o(105760);
  }
  
  public static final boolean adC()
  {
    AppMethodBeat.i(177055);
    boolean bool = a.adC();
    AppMethodBeat.o(177055);
    return bool;
  }
  
  private final boolean ady()
  {
    AppMethodBeat.i(105759);
    if ((this.fVL) || (ax.isWifi(ai.getContext())) || (a.adC()))
    {
      AppMethodBeat.o(105759);
      return true;
    }
    AppMethodBeat.o(105759);
    return false;
  }
  
  private void n(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105756);
    k.h(paramEmojiInfo, "emojiInfo");
    ac.i(e.abZ(), this.fVN + " addDownloadTask: " + paramEmojiInfo.JC());
    this.fVH.b((com.tencent.mm.loader.g.c)new c(paramEmojiInfo));
    AppMethodBeat.o(105756);
  }
  
  public static final void oV(long paramLong)
  {
    AppMethodBeat.i(177054);
    a.oV(paramLong);
    AppMethodBeat.o(177054);
  }
  
  private final void startInternal()
  {
    AppMethodBeat.i(105758);
    ac.i(e.abZ(), this.fVN + " startInternal: " + this.fVL + ' ' + ax.isWifi(ai.getContext()) + ' ' + "size is " + this.fVK.size());
    ??? = b.fPi;
    b.clear();
    ??? = this.fVK;
    k.g(???, "downloadList");
    synchronized ((Iterable)???)
    {
      Iterator localIterator = ((Iterable)???).iterator();
      while (localIterator.hasNext())
      {
        Object localObject3 = (String)localIterator.next();
        com.tencent.mm.kernel.b.a locala = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class);
        k.g(locala, "plugin(IPluginEmoji::class.java)");
        localObject3 = ((com.tencent.mm.plugin.emoji.b.d)locala).getProvider().XM((String)localObject3);
        if (localObject3 != null) {
          n((EmojiInfo)localObject3);
        }
      }
    }
    y localy = y.KTp;
    this.fVJ = b.fVU;
    com.tencent.mm.ac.c.g((d.g.a.a)new f(this));
    AppMethodBeat.o(105758);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(105753);
    ac.i(e.abZ(), "destroy customType: " + this.fVN);
    this.fVH.b((com.tencent.mm.loader.g.f)this.fVM);
    this.fVH.clean();
    if (this.aKI != null)
    {
      ai.getContext().unregisterReceiver(this.aKI);
      this.aKI = null;
    }
    AppMethodBeat.o(105753);
  }
  
  public final void dr(final boolean paramBoolean)
  {
    AppMethodBeat.i(105757);
    if (!ai.cin())
    {
      AppMethodBeat.o(105757);
      return;
    }
    ac.i(e.abZ(), this.fVN + " checkSyncEmoji: true " + paramBoolean);
    com.tencent.mm.ac.c.b("EmojiSyncManager_checkBrokenEmoji", (d.g.a.a)new c(this, paramBoolean));
    AppMethodBeat.o(105757);
  }
  
  public final void init()
  {
    AppMethodBeat.i(105752);
    ac.i(e.abZ(), "init customType: " + this.fVN);
    this.fVH.a((com.tencent.mm.loader.g.f)this.fVM);
    this.aKI = ((BroadcastReceiver)new ConnectivityReceiver());
    ai.getContext().registerReceiver(this.aKI, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    AppMethodBeat.o(105752);
  }
  
  public final void start(boolean paramBoolean)
  {
    AppMethodBeat.i(105754);
    if (!ai.cin())
    {
      AppMethodBeat.o(105754);
      return;
    }
    this.fVL = paramBoolean;
    if (this.fVJ != b.fVU)
    {
      List localList = this.fVK;
      k.g(localList, "downloadList");
      if (((Collection)localList).isEmpty()) {
        break label82;
      }
    }
    label82:
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (ady())) {
        startInternal();
      }
      AppMethodBeat.o(105754);
      return;
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(105755);
    ac.i(e.abZ(), this.fVN + " stop: " + ax.isWifi(ai.getContext()));
    this.fVL = false;
    this.fVH.clean();
    if (!this.fVK.isEmpty())
    {
      this.fVJ = b.fVV;
      com.tencent.mm.ac.c.g((d.g.a.a)new g(this));
    }
    AppMethodBeat.o(105755);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/sync/EmojiSyncManager$ConnectivityReceiver;", "Landroid/content/BroadcastReceiver;", "(Lcom/tencent/mm/emoji/sync/EmojiSyncManager;)V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "plugin-emojisdk_release"})
  public final class ConnectivityReceiver
    extends BroadcastReceiver
  {
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(105738);
      k.h(paramContext, "context");
      k.h(paramIntent, "intent");
      if (!ax.isConnected(paramContext))
      {
        this.fVS.stop();
        AppMethodBeat.o(105738);
        return;
      }
      if (ax.isWifi(paramContext))
      {
        this.fVS.start(false);
        AppMethodBeat.o(105738);
        return;
      }
      if (!EmojiSyncManager.a(this.fVS)) {
        this.fVS.stop();
      }
      AppMethodBeat.o(105738);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/sync/EmojiSyncManager$Companion;", "", "()V", "MaxNoWifiCount", "", "captureSyncMgr", "Lcom/tencent/mm/emoji/sync/EmojiSyncManager;", "customSyncMgr", "noWifiCount", "addNoWifiSize", "", "size", "checkNoWifiSize", "", "getCaptureSyncMgr", "getCustomSyncMgr", "plugin-emojisdk_release"})
  public static final class a
  {
    public static boolean adC()
    {
      AppMethodBeat.i(177053);
      ac.i(e.abZ(), "checkNoWifiSize " + EmojiSyncManager.adz() / 1048576L + "MB");
      if (EmojiSyncManager.adz() < 52428800L)
      {
        AppMethodBeat.o(177053);
        return true;
      }
      AppMethodBeat.o(177053);
      return false;
    }
    
    public static EmojiSyncManager adD()
    {
      AppMethodBeat.i(105736);
      EmojiSyncManager localEmojiSyncManager2 = EmojiSyncManager.adA();
      EmojiSyncManager localEmojiSyncManager1 = localEmojiSyncManager2;
      if (localEmojiSyncManager2 == null)
      {
        localEmojiSyncManager1 = new EmojiSyncManager(0);
        EmojiSyncManager.h(localEmojiSyncManager1);
      }
      AppMethodBeat.o(105736);
      return localEmojiSyncManager1;
    }
    
    public static EmojiSyncManager adE()
    {
      AppMethodBeat.i(105737);
      EmojiSyncManager localEmojiSyncManager2 = EmojiSyncManager.adB();
      EmojiSyncManager localEmojiSyncManager1 = localEmojiSyncManager2;
      if (localEmojiSyncManager2 == null)
      {
        localEmojiSyncManager1 = new EmojiSyncManager(1);
        EmojiSyncManager.i(localEmojiSyncManager1);
      }
      AppMethodBeat.o(105737);
      return localEmojiSyncManager1;
    }
    
    public static void oV(long paramLong)
    {
      AppMethodBeat.i(177052);
      ac.i(e.abZ(), "addNoWifiSize " + paramLong + ", " + EmojiSyncManager.adz());
      if (!ax.isWifi(ai.getContext())) {
        EmojiSyncManager.oU(EmojiSyncManager.adz() + paramLong);
      }
      AppMethodBeat.o(177052);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/sync/EmojiSyncManager$SyncState;", "", "(Ljava/lang/String;I)V", "Init", "Syncing", "Wait", "WaitOffline", "End", "plugin-emojisdk_release"})
  public static enum b
  {
    static
    {
      AppMethodBeat.i(105739);
      b localb1 = new b("Init", 0);
      fVT = localb1;
      b localb2 = new b("Syncing", 1);
      fVU = localb2;
      b localb3 = new b("Wait", 2);
      fVV = localb3;
      b localb4 = new b("WaitOffline", 3);
      fVW = localb4;
      b localb5 = new b("End", 4);
      fVX = localb5;
      fVY = new b[] { localb1, localb2, localb3, localb4, localb5 };
      AppMethodBeat.o(105739);
    }
    
    private b() {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    c(EmojiSyncManager paramEmojiSyncManager, boolean paramBoolean)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/emoji/sync/EmojiSyncManager$downloadCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/emoji/sync/EmojiDownLoadTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-emojisdk_release"})
  public static final class d
    implements com.tencent.mm.loader.g.f<c>
  {
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      a(EmojiSyncManager.d paramd)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
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
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  public static final class e
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public e(EmojiSyncManager paramEmojiSyncManager, f paramf)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    f(EmojiSyncManager paramEmojiSyncManager)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    g(EmojiSyncManager paramEmojiSyncManager)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.sync.EmojiSyncManager
 * JD-Core Version:    0.7.0.1
 */