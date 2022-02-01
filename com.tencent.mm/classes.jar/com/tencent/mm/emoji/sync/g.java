package com.tencent.mm.emoji.sync;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/sync/EmojiSyncLoader;", "Lcom/tencent/mm/emoji/sync/IEmojiSyncLoader;", "data", "Lcom/tencent/mm/emoji/sync/EmojiSyncLoader$IDataProvider;", "config", "Lcom/tencent/mm/emoji/sync/EmojiSyncLoader$IConfigProvider;", "(Lcom/tencent/mm/emoji/sync/EmojiSyncLoader$IDataProvider;Lcom/tencent/mm/emoji/sync/EmojiSyncLoader$IConfigProvider;)V", "TAG", "", "callbackQueue", "Ljava/util/LinkedList;", "Lcom/tencent/mm/emoji/sync/EmojiSyncLoader$LoadCallback;", "downloadCallback", "com/tencent/mm/emoji/sync/EmojiSyncLoader$downloadCallback$1", "Lcom/tencent/mm/emoji/sync/EmojiSyncLoader$downloadCallback$1;", "downloadList", "", "kotlin.jvm.PlatformType", "", "downloadQueue", "Lcom/tencent/mm/emoji/sync/EmojiSyncQueue;", "isLoadEnd", "", "isLoading", "startNonWifi", "syncCount", "", "targetSyncCount", "totalCount", "waitNotifyCount", "waitingIndex", "checkStart", "checkSyncEmoji", "", "start", "destroy", "getSyncCount", "getTargetSyncCount", "getWaitingIndex", "hasMore", "init", "loadMore", "matchDisplayIndex", "index", "registerCallback", "callback", "startInternal", "stop", "unregisterCallback", "CaptureEmojiDataProvider", "Companion", "ConfigProvider", "CustomEmojiDataProvider", "IConfigProvider", "IDataProvider", "LoadCallback", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  implements j
{
  public static final b mmX;
  private static j mnk;
  private static j mnl;
  private static final i mnm;
  private static final i mnn;
  private String TAG;
  private boolean isLoading;
  private int lNX;
  private final g.h mmY;
  private final g mmZ;
  private int mna;
  private int mnb;
  private int mnd;
  private boolean mne;
  private final List<String> mnf;
  private final LinkedList<i> mng;
  private final i mnh;
  private int mni;
  private final k mnj;
  
  static
  {
    AppMethodBeat.i(242635);
    mmX = new b((byte)0);
    mnm = (i)new g.d();
    mnn = (i)new g.c();
    AppMethodBeat.o(242635);
  }
  
  private g(g.h paramh, g paramg)
  {
    AppMethodBeat.i(242578);
    this.mmY = paramh;
    this.mmZ = paramg;
    this.TAG = "MicroMsg.EmojiSyncLoader";
    this.mnb = -1;
    this.mnf = Collections.synchronizedList((List)new LinkedList());
    this.mng = new LinkedList();
    this.mnh = new i();
    this.mnj = new k(this);
    AppMethodBeat.o(242578);
  }
  
  private final boolean aWm()
  {
    if (this.mne) {
      this.isLoading = false;
    }
    while (this.isLoading) {
      return false;
    }
    return true;
  }
  
  public static final j aWn()
  {
    AppMethodBeat.i(242587);
    j localj = b.aWn();
    AppMethodBeat.o(242587);
    return localj;
  }
  
  public static final j aWo()
  {
    AppMethodBeat.i(242591);
    j localj = b.aWo();
    AppMethodBeat.o(242591);
    return localj;
  }
  
  private final void startInternal()
  {
    AppMethodBeat.i(242586);
    Object localObject1 = this.mmY.aWt();
    this.lNX = ((List)localObject1).size();
    this.mnd = Math.min(this.mnd, ((List)localObject1).size());
    if (this.mna > this.mnd) {
      this.mna = this.mnd;
    }
    if (this.mnd > this.mna) {
      this.isLoading = true;
    }
    if ((!this.isLoading) && (this.mnd == this.lNX)) {
      this.mne = true;
    }
    this.mnb = this.mna;
    Log.i(this.TAG, "startInternal: " + this.mna + ", " + this.mnd + ", " + this.lNX + ", " + this.mnb + ", " + this.isLoading + ", " + this.mne);
    i locali = this.mnh;
    Object localObject2 = (Iterable)((List)localObject1).subList(this.mna, this.mnd);
    localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
    int i = 0;
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      if (i < 0) {
        p.kkW();
      }
      localObject3 = (EmojiInfo)localObject3;
      this.mnf.add(((EmojiInfo)localObject3).getMd5());
      ((Collection)localObject1).add(new i.a((EmojiInfo)localObject3, i + this.mna));
      i += 1;
    }
    locali.bA((List)localObject1);
    AppMethodBeat.o(242586);
  }
  
  public final void a(final i parami)
  {
    AppMethodBeat.i(242646);
    s.u(parami, "callback");
    d.uiThread((a)new l(this, parami));
    AppMethodBeat.o(242646);
  }
  
  public final void aWi()
  {
    AppMethodBeat.i(242651);
    Log.i(this.TAG, "loadMore: " + this.isLoading + ", " + this.mne);
    if (aWm())
    {
      this.mnd = this.mmZ.rP(this.mnd);
      startInternal();
    }
    AppMethodBeat.o(242651);
  }
  
  public final int aWj()
  {
    if (this.mne) {
      return 2147483647;
    }
    return this.mnb;
  }
  
  public final int aWk()
  {
    if (this.mne) {
      return 2147483647;
    }
    return this.mnd;
  }
  
  public final boolean aWl()
  {
    return !this.mne;
  }
  
  public final void b(final i parami)
  {
    AppMethodBeat.i(242647);
    s.u(parami, "callback");
    d.uiThread((a)new m(this, parami));
    AppMethodBeat.o(242647);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(242642);
    Object localObject = this.mnh;
    ((i)localObject).mnE.clear();
    localObject = ((Map)((i)localObject).mnF).entrySet().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((Iterator)localObject).next();
    }
    this.mnh.mnG = null;
    AppMethodBeat.o(242642);
  }
  
  public final void fo(final boolean paramBoolean)
  {
    AppMethodBeat.i(242655);
    if (!MMApplicationContext.isMainProcess())
    {
      AppMethodBeat.o(242655);
      return;
    }
    d.d("EmojiSyncLoader_checkSyncEmoji", (a)new j(this, paramBoolean));
    AppMethodBeat.o(242655);
  }
  
  public final void init()
  {
    AppMethodBeat.i(242639);
    this.mnh.mnG = ((i.b)this.mnj);
    this.mnd = this.mmZ.aWu();
    fo(false);
    AppMethodBeat.o(242639);
  }
  
  public final void start()
  {
    AppMethodBeat.i(242648);
    Log.i(this.TAG, "start: ");
    if (aWm()) {
      startInternal();
    }
    AppMethodBeat.o(242648);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/sync/EmojiSyncLoader$Companion;", "", "()V", "captureLoader", "Lcom/tencent/mm/emoji/sync/IEmojiSyncLoader;", "captureRemoteCallback", "Lcom/tencent/mm/emoji/sync/EmojiSyncLoader$LoadCallback;", "customLoader", "customRemoteCallback", "getCaptureLoader", "getCustomLoader", "getRemoteData", "Lcom/tencent/mm/emoji/sync/EmojiSyncLoaderIPC$EmojiSyncData;", "type", "", "updateRemoteData", "", "data", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    public static j aWn()
    {
      AppMethodBeat.i(242621);
      Object localObject = g.aWq();
      if (localObject != null)
      {
        AppMethodBeat.o(242621);
        return localObject;
      }
      if (MMApplicationContext.isMainProcess())
      {
        localObject = new g((g.h)new g.f(), (g.g)new g.e(), (byte)0);
        g.a((g)localObject, s.X(g.h((g)localObject), "_custom"));
        localb = g.mmX;
        g.a((j)localObject);
        ((g)localObject).a(g.aWr());
        localObject = (j)localObject;
        AppMethodBeat.o(242621);
        return localObject;
      }
      localObject = new EmojiSyncLoaderIPC(0);
      b localb = g.mmX;
      g.a((j)localObject);
      localObject = (j)localObject;
      AppMethodBeat.o(242621);
      return localObject;
    }
    
    public static j aWo()
    {
      AppMethodBeat.i(242622);
      Object localObject = g.aWp();
      if (localObject != null)
      {
        AppMethodBeat.o(242622);
        return localObject;
      }
      if (MMApplicationContext.isMainProcess())
      {
        localObject = new g((g.h)new g.a(), (g.g)new g.e(), (byte)0);
        g.a((g)localObject, s.X(g.h((g)localObject), "_capture"));
        localb = g.mmX;
        g.b((j)localObject);
        ((g)localObject).a(g.aWs());
        localObject = (j)localObject;
        AppMethodBeat.o(242622);
        return localObject;
      }
      localObject = new EmojiSyncLoaderIPC(1);
      b localb = g.mmX;
      g.b((j)localObject);
      localObject = (j)localObject;
      AppMethodBeat.o(242622);
      return localObject;
    }
    
    public static EmojiSyncLoaderIPC.EmojiSyncData rO(int paramInt)
    {
      AppMethodBeat.i(242618);
      EmojiSyncLoaderIPC.EmojiSyncData localEmojiSyncData = new EmojiSyncLoaderIPC.EmojiSyncData();
      localEmojiSyncData.mjd = paramInt;
      Object localObject;
      if (paramInt == 1)
      {
        localObject = g.aWp();
        if ((localObject instanceof g)) {
          localObject = (g)localObject;
        }
      }
      for (;;)
      {
        if (localObject != null)
        {
          localEmojiSyncData.mna = g.d((g)localObject);
          localEmojiSyncData.mnd = g.f((g)localObject);
          localEmojiSyncData.mnb = g.j((g)localObject);
          localEmojiSyncData.mne = g.i((g)localObject);
        }
        AppMethodBeat.o(242618);
        return localEmojiSyncData;
        localObject = null;
        continue;
        localObject = g.aWq();
        if ((localObject instanceof g)) {
          localObject = (g)localObject;
        } else {
          localObject = null;
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/sync/EmojiSyncLoader$IConfigProvider;", "", "getSyncMinCount", "", "getSyncNotifyCount", "nextSyncCount", "current", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  static abstract interface g
  {
    public abstract int aWu();
    
    public abstract int aWv();
    
    public abstract int rP(int paramInt);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/sync/EmojiSyncLoader$LoadCallback;", "", "onLoadMore", "", "increase", "", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface i
  {
    public abstract void aVL();
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements a<ah>
  {
    j(g paramg, boolean paramBoolean)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/emoji/sync/EmojiSyncLoader$downloadCallback$1", "Lcom/tencent/mm/emoji/sync/EmojiSyncQueue$SyncQueueCallback;", "onState", "", "state", "", "emojiData", "Lcom/tencent/mm/emoji/sync/EmojiSyncQueue$EmojiSyncData;", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class k
    implements i.b
  {
    k(g paramg) {}
    
    public final void a(int paramInt, i.a parama)
    {
      AppMethodBeat.i(242607);
      s.u(parama, "emojiData");
      Object localObject = parama.mgK;
      Log.i(g.h(this.mno), "onLoaderFin: " + ((EmojiInfo)localObject).getMd5() + ' ' + paramInt + ", " + parama.index);
      g.k(this.mno).remove(((EmojiInfo)localObject).getMd5());
      if (g.k(this.mno).size() <= 0) {
        g.l(this.mno);
      }
      localObject = this.mno;
      g.e((g)localObject, g.m((g)localObject) + 1);
      paramInt = parama.index;
      if ((g.f(this.mno, paramInt)) || (!g.c(this.mno)))
      {
        if (g.j(this.mno) < paramInt + 1) {
          g.d(this.mno, paramInt + 1);
        }
        g.d(this.mno);
        parama = this.mno;
        g.b(parama, g.d(parama) + g.m(this.mno));
        if ((g.d(this.mno) == g.f(this.mno)) && (g.f(this.mno) == g.g(this.mno))) {
          g.a(this.mno, true);
        }
        if (!g.c(this.mno)) {
          g.d(this.mno, g.f(this.mno));
        }
        localObject = (Iterable)g.a(this.mno);
        parama = this.mno;
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          g.i locali = (g.i)((Iterator)localObject).next();
          g.d(parama);
          locali.aVL();
        }
        g.e(this.mno, 0);
      }
      AppMethodBeat.o(242607);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends u
    implements a<ah>
  {
    l(g paramg, g.i parami)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends u
    implements a<ah>
  {
    m(g paramg, g.i parami)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.emoji.sync.g
 * JD-Core Version:    0.7.0.1
 */