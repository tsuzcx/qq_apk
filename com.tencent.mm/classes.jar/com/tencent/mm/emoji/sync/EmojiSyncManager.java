package com.tencent.mm.emoji.sync;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.loader.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/sync/EmojiSyncManager;", "", "customType", "", "(I)V", "callbackQueue", "Ljava/util/LinkedList;", "Lcom/tencent/mm/emoji/sync/SyncCallback;", "connectivityReceiver", "Landroid/content/BroadcastReceiver;", "getCustomType", "()I", "downloadCallback", "com/tencent/mm/emoji/sync/EmojiSyncManager$downloadCallback$1", "Lcom/tencent/mm/emoji/sync/EmojiSyncManager$downloadCallback$1;", "downloadList", "", "", "kotlin.jvm.PlatformType", "", "downloadQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/emoji/sync/EmojiDownLoadTask;", "<set-?>", "remainSize", "getRemainSize", "startNonWifi", "", "Lcom/tencent/mm/emoji/sync/EmojiSyncManager$SyncState;", "syncState", "getSyncState", "()Lcom/tencent/mm/emoji/sync/EmojiSyncManager$SyncState;", "totalSize", "getTotalSize", "addDownloadTask", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "checkAutoStart", "checkBroken", "checkSync", "checkSyncEmoji", "start", "withBroken", "destroy", "init", "markBroken", "md5", "registerCallback", "callback", "force", "startInternal", "stop", "unregisterCallback", "Companion", "ConnectivityReceiver", "SyncState", "plugin-emojisdk_release"})
public final class EmojiSyncManager
{
  private static long grM;
  private static EmojiSyncManager grN;
  private static EmojiSyncManager grO;
  public static final a grP;
  private BroadcastReceiver aMz;
  public int cdl;
  private final com.tencent.mm.loader.g.d<c> grF;
  private final LinkedList<f> grG;
  public b grH;
  public final List<String> grI;
  private boolean grJ;
  private final d grK;
  final int grL;
  
  static
  {
    AppMethodBeat.i(105761);
    grP = new a((byte)0);
    AppMethodBeat.o(105761);
  }
  
  public EmojiSyncManager(int paramInt)
  {
    AppMethodBeat.i(105760);
    this.grL = paramInt;
    this.grF = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a(2147483647), new com.tencent.mm.loader.g.a.g(1, (byte)0), 1, "EmojiSync"));
    this.grG = new LinkedList();
    this.grH = b.grR;
    this.grI = Collections.synchronizedList((List)new LinkedList());
    this.grK = new d(this);
    AppMethodBeat.o(105760);
  }
  
  private final boolean ags()
  {
    AppMethodBeat.i(105759);
    if ((this.grJ) || (az.isWifi(ak.getContext())) || (a.agw()))
    {
      AppMethodBeat.o(105759);
      return true;
    }
    AppMethodBeat.o(105759);
    return false;
  }
  
  public static final boolean agw()
  {
    AppMethodBeat.i(177055);
    boolean bool = a.agw();
    AppMethodBeat.o(177055);
    return bool;
  }
  
  private void n(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105756);
    p.h(paramEmojiInfo, "emojiInfo");
    ae.i(e.aeP(), this.grL + " addDownloadTask: " + paramEmojiInfo.Lj());
    this.grF.b((com.tencent.mm.loader.g.c)new c(paramEmojiInfo));
    AppMethodBeat.o(105756);
  }
  
  public static final void ri(long paramLong)
  {
    AppMethodBeat.i(177054);
    a.ri(paramLong);
    AppMethodBeat.o(177054);
  }
  
  private final void startInternal()
  {
    AppMethodBeat.i(105758);
    ae.i(e.aeP(), this.grL + " startInternal: " + this.grJ + ' ' + az.isWifi(ak.getContext()) + ' ' + "size is " + this.grI.size());
    ??? = b.gla;
    b.clear();
    ??? = this.grI;
    p.g(???, "downloadList");
    synchronized ((Iterable)???)
    {
      Iterator localIterator = ((Iterable)???).iterator();
      while (localIterator.hasNext())
      {
        Object localObject3 = (String)localIterator.next();
        com.tencent.mm.kernel.b.a locala = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class);
        p.g(locala, "plugin(IPluginEmoji::class.java)");
        localObject3 = ((com.tencent.mm.plugin.emoji.b.d)locala).getProvider().acj((String)localObject3);
        if (localObject3 != null) {
          n((EmojiInfo)localObject3);
        }
      }
    }
    z localz = z.Nhr;
    this.grH = b.grS;
    com.tencent.mm.ac.c.h((d.g.a.a)new f(this));
    AppMethodBeat.o(105758);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(105753);
    ae.i(e.aeP(), "destroy customType: " + this.grL);
    this.grF.b((com.tencent.mm.loader.g.f)this.grK);
    this.grF.clean();
    if (this.aMz != null)
    {
      ak.getContext().unregisterReceiver(this.aMz);
      this.aMz = null;
    }
    AppMethodBeat.o(105753);
  }
  
  public final void dt(final boolean paramBoolean)
  {
    AppMethodBeat.i(105757);
    if (!ak.coh())
    {
      AppMethodBeat.o(105757);
      return;
    }
    ae.i(e.aeP(), this.grL + " checkSyncEmoji: true " + paramBoolean);
    com.tencent.mm.ac.c.b("EmojiSyncManager_checkBrokenEmoji", (d.g.a.a)new c(this, paramBoolean));
    AppMethodBeat.o(105757);
  }
  
  public final void init()
  {
    AppMethodBeat.i(105752);
    ae.i(e.aeP(), "init customType: " + this.grL);
    this.grF.a((com.tencent.mm.loader.g.f)this.grK);
    this.aMz = ((BroadcastReceiver)new ConnectivityReceiver());
    ak.getContext().registerReceiver(this.aMz, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    AppMethodBeat.o(105752);
  }
  
  public final void start(boolean paramBoolean)
  {
    AppMethodBeat.i(105754);
    if (!ak.coh())
    {
      AppMethodBeat.o(105754);
      return;
    }
    this.grJ = paramBoolean;
    if (this.grH != b.grS)
    {
      List localList = this.grI;
      p.g(localList, "downloadList");
      if (((Collection)localList).isEmpty()) {
        break label82;
      }
    }
    label82:
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (ags())) {
        startInternal();
      }
      AppMethodBeat.o(105754);
      return;
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(105755);
    ae.i(e.aeP(), this.grL + " stop: " + az.isWifi(ak.getContext()));
    this.grJ = false;
    this.grF.clean();
    if (!this.grI.isEmpty())
    {
      this.grH = b.grT;
      com.tencent.mm.ac.c.h((d.g.a.a)new g(this));
    }
    AppMethodBeat.o(105755);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/sync/EmojiSyncManager$ConnectivityReceiver;", "Landroid/content/BroadcastReceiver;", "(Lcom/tencent/mm/emoji/sync/EmojiSyncManager;)V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "plugin-emojisdk_release"})
  public final class ConnectivityReceiver
    extends BroadcastReceiver
  {
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(105738);
      p.h(paramContext, "context");
      p.h(paramIntent, "intent");
      if (!az.isConnected(paramContext))
      {
        this.grQ.stop();
        AppMethodBeat.o(105738);
        return;
      }
      if (az.isWifi(paramContext))
      {
        this.grQ.start(false);
        AppMethodBeat.o(105738);
        return;
      }
      if (!EmojiSyncManager.a(this.grQ)) {
        this.grQ.stop();
      }
      AppMethodBeat.o(105738);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/sync/EmojiSyncManager$Companion;", "", "()V", "MaxNoWifiCount", "", "captureSyncMgr", "Lcom/tencent/mm/emoji/sync/EmojiSyncManager;", "customSyncMgr", "noWifiCount", "addNoWifiSize", "", "size", "checkNoWifiSize", "", "getCaptureSyncMgr", "getCustomSyncMgr", "plugin-emojisdk_release"})
  public static final class a
  {
    public static boolean agw()
    {
      AppMethodBeat.i(177053);
      ae.i(e.aeP(), "checkNoWifiSize " + EmojiSyncManager.agt() / 1048576L + "MB");
      if (EmojiSyncManager.agt() < 52428800L)
      {
        AppMethodBeat.o(177053);
        return true;
      }
      AppMethodBeat.o(177053);
      return false;
    }
    
    public static EmojiSyncManager agx()
    {
      AppMethodBeat.i(105736);
      EmojiSyncManager localEmojiSyncManager2 = EmojiSyncManager.agu();
      EmojiSyncManager localEmojiSyncManager1 = localEmojiSyncManager2;
      if (localEmojiSyncManager2 == null)
      {
        localEmojiSyncManager1 = new EmojiSyncManager(0);
        EmojiSyncManager.h(localEmojiSyncManager1);
      }
      AppMethodBeat.o(105736);
      return localEmojiSyncManager1;
    }
    
    public static EmojiSyncManager agy()
    {
      AppMethodBeat.i(105737);
      EmojiSyncManager localEmojiSyncManager2 = EmojiSyncManager.agv();
      EmojiSyncManager localEmojiSyncManager1 = localEmojiSyncManager2;
      if (localEmojiSyncManager2 == null)
      {
        localEmojiSyncManager1 = new EmojiSyncManager(1);
        EmojiSyncManager.i(localEmojiSyncManager1);
      }
      AppMethodBeat.o(105737);
      return localEmojiSyncManager1;
    }
    
    public static void ri(long paramLong)
    {
      AppMethodBeat.i(177052);
      ae.i(e.aeP(), "addNoWifiSize " + paramLong + ", " + EmojiSyncManager.agt());
      if (!az.isWifi(ak.getContext())) {
        EmojiSyncManager.rh(EmojiSyncManager.agt() + paramLong);
      }
      AppMethodBeat.o(177052);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/sync/EmojiSyncManager$SyncState;", "", "(Ljava/lang/String;I)V", "Init", "Syncing", "Wait", "WaitOffline", "End", "plugin-emojisdk_release"})
  public static enum b
  {
    static
    {
      AppMethodBeat.i(105739);
      b localb1 = new b("Init", 0);
      grR = localb1;
      b localb2 = new b("Syncing", 1);
      grS = localb2;
      b localb3 = new b("Wait", 2);
      grT = localb3;
      b localb4 = new b("WaitOffline", 3);
      grU = localb4;
      b localb5 = new b("End", 4);
      grV = localb5;
      grW = new b[] { localb1, localb2, localb3, localb4, localb5 };
      AppMethodBeat.o(105739);
    }
    
    private b() {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<z>
  {
    c(EmojiSyncManager paramEmojiSyncManager, boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/emoji/sync/EmojiSyncManager$downloadCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/emoji/sync/EmojiDownLoadTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-emojisdk_release"})
  public static final class d
    implements com.tencent.mm.loader.g.f<c>
  {
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements d.g.a.a<z>
    {
      a(EmojiSyncManager.d paramd)
      {
        super();
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  public static final class e
    extends q
    implements d.g.a.a<z>
  {
    public e(EmojiSyncManager paramEmojiSyncManager, f paramf)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements d.g.a.a<z>
  {
    f(EmojiSyncManager paramEmojiSyncManager)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements d.g.a.a<z>
  {
    g(EmojiSyncManager paramEmojiSyncManager)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.sync.EmojiSyncManager
 * JD-Core Version:    0.7.0.1
 */