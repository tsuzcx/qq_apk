package com.tencent.mm.emoji.sync;

import a.f.b.j;
import a.f.b.k;
import a.l;
import a.y;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.g.a.h;
import com.tencent.mm.loader.g.f;
import com.tencent.mm.pluginsdk.a.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/emoji/sync/EmojiSyncManager;", "", "customType", "", "(I)V", "callbackQueue", "Ljava/util/LinkedList;", "Lcom/tencent/mm/emoji/sync/SyncCallback;", "connectivityReceiver", "Landroid/content/BroadcastReceiver;", "getCustomType", "()I", "downloadCallback", "com/tencent/mm/emoji/sync/EmojiSyncManager$downloadCallback$1", "Lcom/tencent/mm/emoji/sync/EmojiSyncManager$downloadCallback$1;", "downloadList", "", "", "kotlin.jvm.PlatformType", "", "downloadQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/emoji/sync/EmojiDownLoadTask;", "<set-?>", "remainSize", "getRemainSize", "setRemainSize", "startNonWifi", "", "Lcom/tencent/mm/emoji/sync/EmojiSyncManager$SyncState;", "syncState", "getSyncState", "()Lcom/tencent/mm/emoji/sync/EmojiSyncManager$SyncState;", "setSyncState", "(Lcom/tencent/mm/emoji/sync/EmojiSyncManager$SyncState;)V", "totalSize", "getTotalSize", "setTotalSize", "addDownloadTask", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "checkAutoStart", "checkBroken", "checkSync", "checkSyncEmoji", "start", "withBroken", "destroy", "init", "markBroken", "md5", "registerCallback", "callback", "force", "startInternal", "stop", "unregisterCallback", "Companion", "ConnectivityReceiver", "SyncState", "plugin-emojisdk_release"})
public final class EmojiSyncManager
{
  private static EmojiSyncManager exF;
  private static EmojiSyncManager exG;
  public static final EmojiSyncManager.a exH;
  public final List<String> exA;
  public int exB;
  private boolean exC;
  private final d exD;
  final int exE;
  private BroadcastReceiver exw;
  private final com.tencent.mm.loader.g.d<a> exx;
  private final LinkedList<c> exy;
  public EmojiSyncManager.b exz;
  
  static
  {
    AppMethodBeat.i(63284);
    exH = new EmojiSyncManager.a((byte)0);
    AppMethodBeat.o(63284);
  }
  
  public EmojiSyncManager(int paramInt)
  {
    AppMethodBeat.i(63283);
    this.exE = paramInt;
    this.exx = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.g((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a(2147483647), new h(1, (byte)0), 1, "EmojiSync"));
    this.exy = new LinkedList();
    this.exz = EmojiSyncManager.b.exI;
    this.exA = Collections.synchronizedList((List)new LinkedList());
    this.exD = new d(this);
    AppMethodBeat.o(63283);
  }
  
  private final boolean Pd()
  {
    AppMethodBeat.i(63282);
    if ((this.exC) || (at.isWifi(ah.getContext())))
    {
      AppMethodBeat.o(63282);
      return true;
    }
    AppMethodBeat.o(63282);
    return false;
  }
  
  private void j(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(63279);
    j.q(paramEmojiInfo, "emojiInfo");
    ab.i(b.Ot(), this.exE + " addDownloadTask: " + paramEmojiInfo.Al());
    this.exx.b((com.tencent.mm.loader.g.c)new a(paramEmojiInfo));
    AppMethodBeat.o(63279);
  }
  
  private final void startInternal()
  {
    AppMethodBeat.i(63281);
    ab.i(b.Ot(), this.exE + " startInternal: " + this.exC + ' ' + at.isWifi(ah.getContext()) + ' ' + "size is " + this.exA.size());
    ??? = this.exA;
    j.p(???, "downloadList");
    synchronized ((Iterable)???)
    {
      Iterator localIterator = ((Iterable)???).iterator();
      while (localIterator.hasNext())
      {
        Object localObject3 = (String)localIterator.next();
        com.tencent.mm.kernel.b.a locala = com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class);
        j.p(locala, "plugin(IPluginEmoji::class.java)");
        localObject3 = ((com.tencent.mm.plugin.emoji.b.d)locala).getProvider().Ku((String)localObject3);
        if (localObject3 != null) {
          j((EmojiInfo)localObject3);
        }
      }
    }
    y localy = y.BMg;
    this.exz = EmojiSyncManager.b.exJ;
    com.tencent.mm.ab.b.b((a.f.a.a)new f(this));
    AppMethodBeat.o(63281);
  }
  
  public final void cp(final boolean paramBoolean)
  {
    AppMethodBeat.i(63280);
    ab.i(b.Ot(), this.exE + " checkSyncEmoji: true " + paramBoolean);
    com.tencent.mm.ab.b.a("EmojiSyncManager_checkBrokenEmoji", (a.f.a.a)new c(this, paramBoolean));
    AppMethodBeat.o(63280);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(63276);
    ab.i(b.Ot(), "destroy customType: " + this.exE);
    this.exx.b((f)this.exD);
    this.exx.clean();
    if (this.exw != null)
    {
      ah.getContext().unregisterReceiver(this.exw);
      this.exw = null;
    }
    AppMethodBeat.o(63276);
  }
  
  public final void init()
  {
    AppMethodBeat.i(63275);
    ab.i(b.Ot(), "init customType: " + this.exE);
    this.exx.a((f)this.exD);
    this.exw = ((BroadcastReceiver)new EmojiSyncManager.ConnectivityReceiver());
    ah.getContext().registerReceiver(this.exw, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    AppMethodBeat.o(63275);
  }
  
  public final void start(boolean paramBoolean)
  {
    AppMethodBeat.i(63277);
    this.exC = paramBoolean;
    if (this.exz != EmojiSyncManager.b.exJ)
    {
      List localList = this.exA;
      j.p(localList, "downloadList");
      if (((Collection)localList).isEmpty()) {
        break label69;
      }
    }
    label69:
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (Pd())) {
        startInternal();
      }
      AppMethodBeat.o(63277);
      return;
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(63278);
    ab.i(b.Ot(), this.exE + " stop: " + at.isWifi(ah.getContext()));
    this.exC = false;
    this.exx.clean();
    if (!this.exA.isEmpty())
    {
      this.exz = EmojiSyncManager.b.exK;
      com.tencent.mm.ab.b.b((a.f.a.a)new EmojiSyncManager.g(this));
    }
    AppMethodBeat.o(63278);
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "invoke"})
  static final class c
    extends k
    implements a.f.a.a<y>
  {
    c(EmojiSyncManager paramEmojiSyncManager, boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/emoji/sync/EmojiSyncManager$downloadCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/emoji/sync/EmojiDownLoadTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-emojisdk_release"})
  public static final class d
    implements f<a>
  {}
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "invoke"})
  public static final class e
    extends k
    implements a.f.a.a<y>
  {
    public e(EmojiSyncManager paramEmojiSyncManager, c paramc)
    {
      super();
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "invoke"})
  static final class f
    extends k
    implements a.f.a.a<y>
  {
    f(EmojiSyncManager paramEmojiSyncManager)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emoji.sync.EmojiSyncManager
 * JD-Core Version:    0.7.0.1
 */