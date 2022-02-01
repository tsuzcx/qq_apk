package com.tencent.mm.plugin.finder.preload.worker;

import android.arch.lifecycle.ViewModelProvider;
import android.os.SystemClock;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.g.a;
import com.tencent.mm.i.g.b;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.w;
import com.tencent.mm.plugin.finder.preload.c.a;
import com.tencent.mm.plugin.finder.preload.c.b;
import com.tencent.mm.plugin.finder.preload.model.a.b;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.m;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderVideoRecycler;
import com.tencent.mm.plugin.i.a.d.a;
import com.tencent.mm.plugin.thumbplayer.PluginThumbPlayer;
import com.tencent.mm.plugin.thumbplayer.b.a.d;
import com.tencent.mm.protocal.protobuf.bqs;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import d.a.j;
import d.g.b.k;
import d.n.n;
import d.o;
import d.y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.ReentrantLock;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;", "Lcom/tencent/mm/plugin/finder/preload/worker/IPreloadWorker;", "model", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "sceneTag", "", "(Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;Ljava/lang/String;)V", "TAG", "focusedMediaId", "isOpenMultiBitRateDownload", "", "isRelease", "isStop", "loadingMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "Lkotlin/collections/HashMap;", "mainLock", "Ljava/util/concurrent/locks/ReentrantLock;", "preLoadCallbacks", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mm/plugin/finder/preload/IVideoPreloadCallback;", "getPreLoadCallbacks", "()Ljava/util/concurrent/ConcurrentLinkedQueue;", "waitingList", "Ljava/util/LinkedList;", "buildPreloadList", "centerFeed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "dataList", "", "Lkotlin/Pair;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "cancel", "mediaId", "isIgnorePlaying", "cancelWaitingTask", "createPreloadCDNTask", "detail", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel$Detail;", "enqueue", "", "task", "getPreLoadingCount", "isFocusedMedia", "media", "mergePreload", "preloadList", "needToMerge", "new", "old", "onActivityStart", "", "onActivityStop", "onClearAll", "onMediaFocus", "isFocused", "onRelease", "pollWaiting", "preload", "source", "printMergeList", "", "rawList", "removeWaitingList", "resetRunningTask", "showErrToast", "stage", "ret", "syncLock", "T", "handle", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Companion", "VideoPreloadTaskCallback", "VideoTaskCallTask", "plugin-finder_release"})
public final class b
{
  public static final a rwh;
  public final String TAG;
  private final LinkedList<com.tencent.mm.plugin.finder.preload.c> fYB;
  public boolean gRc;
  public boolean isStop;
  private final ReentrantLock rwa;
  private final HashMap<String, com.tencent.mm.plugin.finder.preload.c> rwb;
  private String rwc;
  private final boolean rwd;
  public final ConcurrentLinkedQueue<com.tencent.mm.plugin.finder.preload.b> rwe;
  private final com.tencent.mm.plugin.finder.preload.model.a rwf;
  private final String rwg;
  
  static
  {
    AppMethodBeat.i(202676);
    rwh = new a((byte)0);
    AppMethodBeat.o(202676);
  }
  
  public b(com.tencent.mm.plugin.finder.preload.model.a parama, String paramString)
  {
    AppMethodBeat.i(202674);
    this.rwf = parama;
    this.rwg = paramString;
    this.rwa = new ReentrantLock();
    this.rwb = new HashMap();
    this.fYB = new LinkedList();
    this.rwc = "";
    parama = com.tencent.mm.plugin.finder.storage.b.rCU;
    this.rwd = com.tencent.mm.plugin.finder.storage.b.cAk();
    this.rwe = new ConcurrentLinkedQueue();
    this.TAG = ("Finder.VideoPreloadWorker_" + this.rwg);
    this.rwe.add(new b.1(this));
    AppMethodBeat.o(202674);
  }
  
  private final int a(com.tencent.mm.plugin.finder.preload.c paramc)
  {
    AppMethodBeat.i(202670);
    this.rwa.lock();
    Object localObject3;
    Object localObject4;
    for (;;)
    {
      try
      {
        if (this.gRc)
        {
          ac.i(this.TAG, "[enqueue] VideoPreloadWorker has release. " + paramc + " just return.");
          return -1;
        }
        if (a(paramc.rcZ.rtl))
        {
          ac.i(this.TAG, "[enqueue] is focused task " + paramc + " just return.");
          return -1;
        }
        localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.rFo;
        localObject2 = com.tencent.mm.plugin.finder.storage.logic.c.aei(paramc.rvw);
        localObject3 = ((Iterable)this.rwe).iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject4 = (com.tencent.mm.plugin.finder.preload.b)((Iterator)localObject3).next();
        String str1 = ((w)localObject2).field_mediaId;
        k.g(str1, "cache.field_mediaId");
        i = ((w)localObject2).cwI();
        String str2 = paramc.cwK();
        if (paramc.field_requestVideoFormat == 1)
        {
          localObject1 = "H264";
          ((com.tencent.mm.plugin.finder.preload.b)localObject4).a(str1, i, str2, (String)localObject1, paramc);
        }
        else
        {
          localObject1 = "H265";
        }
      }
      finally
      {
        this.rwa.unlock();
        AppMethodBeat.o(202670);
      }
    }
    if ((((w)localObject2).cwI() >= paramc.frB) && (((w)localObject2).field_cacheSize >= paramc.preloadMinSize))
    {
      ac.i(this.TAG, "[enqueue] " + paramc + " has finish preload! just return.");
      localObject1 = ((Iterable)this.rwe).iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject3 = (com.tencent.mm.plugin.finder.preload.b)((Iterator)localObject1).next();
        localObject4 = paramc.rvw;
        if (((w)localObject2).cwI() >= 100) {}
        for (boolean bool = true;; bool = false)
        {
          ((com.tencent.mm.plugin.finder.preload.b)localObject3).a((String)localObject4, bool, ((w)localObject2).cwI(), paramc);
          break;
        }
      }
      this.rwa.unlock();
      AppMethodBeat.o(202670);
      return 1;
    }
    int i = this.rwb.size();
    if ((this.rwf.rvI <= i) || (this.isStop))
    {
      this.fYB.add(paramc);
      paramc.a(c.b.rvB);
      ac.i(this.TAG, "[enqueue] " + paramc + " wait to preLoad, just return. isStop=" + this.isStop + " preLoadingCount=" + i + " waitingSize=" + this.fYB.size());
      this.rwa.unlock();
      AppMethodBeat.o(202670);
      return 1;
    }
    paramc.a(c.b.rvz);
    Object localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.rFo;
    com.tencent.mm.plugin.finder.storage.logic.c.a(paramc.rvw, paramc.rvx, paramc.rcZ.getUrl(), paramc.rcZ.getPath(), paramc.field_requestVideoFormat, paramc.cwK(), ((w)localObject2).field_cacheSize, ((w)localObject2).field_totalSize, 1);
    ((Map)this.rwb).put(paramc.rvw, paramc);
    localObject1 = new com.tencent.mm.plugin.finder.loader.f(paramc.rcZ.rtl, m.rDR);
    Object localObject2 = com.tencent.mm.plugin.finder.loader.h.rtK;
    com.tencent.mm.plugin.finder.loader.h.cwn().bG(localObject1).anW();
    localObject1 = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.thumbplayer.a.a.class);
    k.g(localObject1, "MMKernel.plugin(IPluginThumbPlayer::class.java)");
    if (((com.tencent.mm.plugin.thumbplayer.a.a)localObject1).isOpenTPPlayer())
    {
      localObject1 = ((PluginThumbPlayer)com.tencent.mm.kernel.g.ad(PluginThumbPlayer.class)).getCdnTaskController();
      localObject2 = (com.tencent.mm.i.h)paramc;
      localObject3 = (com.tencent.mm.plugin.thumbplayer.b.d)new b.f(this, paramc);
      k.h(localObject2, "task");
      if (bs.isNullOrNil(((com.tencent.mm.i.h)localObject2).field_mediaId)) {
        ac.e(((com.tencent.mm.plugin.thumbplayer.b.a)localObject1).TAG, "add download task, but task mediaId is null.");
      }
    }
    for (;;)
    {
      ac.i(this.TAG, "[enqueue] begin to preloadVideo... ".concat(String.valueOf(paramc)));
      this.rwa.unlock();
      AppMethodBeat.o(202670);
      return 1;
      ac.i(((com.tencent.mm.plugin.thumbplayer.b.a)localObject1).TAG, "startPreloadDownloadTask: " + ((com.tencent.mm.i.h)localObject2).field_mediaId + " current run tasks " + ((com.tencent.mm.plugin.thumbplayer.b.a)localObject1).zYj.keySet());
      if (((com.tencent.mm.i.h)localObject2).field_fileId == null) {
        ((com.tencent.mm.i.h)localObject2).field_fileId = "";
      }
      if (((com.tencent.mm.i.h)localObject2).field_aesKey == null) {
        ((com.tencent.mm.i.h)localObject2).field_aesKey = "";
      }
      ((com.tencent.mm.i.h)localObject2).dBE = false;
      com.tencent.mm.ac.c.c("MicroMsg.Cdn.ThreadName", (d.g.a.a)new a.d((com.tencent.mm.plugin.thumbplayer.b.a)localObject1, (com.tencent.mm.i.h)localObject2, (com.tencent.mm.plugin.thumbplayer.b.d)localObject3));
      continue;
      com.tencent.mm.an.f.aDD().d((com.tencent.mm.i.g)paramc);
    }
  }
  
  private final com.tencent.mm.plugin.finder.preload.c a(a.b paramb)
  {
    boolean bool = true;
    AppMethodBeat.i(202671);
    int i;
    com.tencent.mm.plugin.finder.preload.c localc;
    label272:
    String str;
    StringBuilder localStringBuilder;
    if (k.g(paramb.rvP, "h265"))
    {
      i = 2;
      localc = new com.tencent.mm.plugin.finder.preload.c(paramb.rvQ);
      localc.field_mediaId = paramb.rvQ.abW();
      localc.url = (paramb.rvQ.getUrl() + paramb.rvQ.cwl());
      localc.field_fullpath = paramb.rvQ.getPath();
      localc.snsCipherKey = paramb.rvQ.cwk();
      localc.frq = 2;
      localc.frw = 2;
      localc.frr = 8;
      localc.frB = paramb.frB;
      localc.field_preloadRatio = paramb.frB;
      localc.concurrentCount = d.a.sjk;
      localc.connectionCount = 1;
      localc.frb = ((g.a)new b.c(this, localc.frB, paramb.preloadMinSize, this.rwb, this.rwe, paramb.rvQ));
      localc.frs = ((g.b)new b(localc.frB, SystemClock.uptimeMillis(), this.rwb, this.rwe));
      localc.field_fileType = com.tencent.mm.i.a.fqy;
      localc.preloadMinSize = paramb.preloadMinSize;
      localc.frD = 0;
      if (!this.rwd) {
        break label384;
      }
      localc.field_requestVideoFormat = 0;
      localc.adI(paramb.drn);
      str = this.TAG;
      localStringBuilder = new StringBuilder("[createPreloadCDNTask] isOpenMultiBitRateDownload=").append(this.rwd).append(" mediaId=").append(paramb.rvQ.abW()).append(" decodeKey=").append(paramb.rvQ.rtl.decodeKey).append(" token=");
      if (((CharSequence)paramb.rvQ.cwl()).length() <= 0) {
        break label393;
      }
    }
    for (;;)
    {
      ac.i(str, bool);
      AppMethodBeat.o(202671);
      return localc;
      i = 1;
      break;
      label384:
      localc.field_requestVideoFormat = i;
      break label272;
      label393:
      bool = false;
    }
  }
  
  private final boolean a(bqs parambqs)
  {
    AppMethodBeat.i(202668);
    String str = this.rwc;
    parambqs = parambqs.mediaId;
    k.g(parambqs, "media.mediaId");
    boolean bool = n.nc(str, parambqs);
    AppMethodBeat.o(202668);
    return bool;
  }
  
  private final com.tencent.mm.plugin.finder.preload.c aZ(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(202665);
    paramString = (com.tencent.mm.plugin.finder.preload.c)x((d.g.a.a)new b.d(this, paramString, paramBoolean));
    AppMethodBeat.o(202665);
    return paramString;
  }
  
  private final LinkedList<com.tencent.mm.plugin.finder.preload.c> ad(final LinkedList<com.tencent.mm.plugin.finder.preload.c> paramLinkedList)
  {
    AppMethodBeat.i(202672);
    paramLinkedList = (LinkedList)x((d.g.a.a)new g(this, paramLinkedList));
    AppMethodBeat.o(202672);
    return paramLinkedList;
  }
  
  private final LinkedList<com.tencent.mm.plugin.finder.preload.c> adM(String paramString)
  {
    AppMethodBeat.i(202666);
    paramString = (LinkedList)x((d.g.a.a)new b.e(this, paramString));
    AppMethodBeat.o(202666);
    return paramString;
  }
  
  private final LinkedList<com.tencent.mm.plugin.finder.preload.c> b(BaseFinderFeed paramBaseFinderFeed, List<o<BaseFinderFeed, List<bqs>>> paramList)
  {
    AppMethodBeat.i(202669);
    LinkedList localLinkedList = new LinkedList();
    Object localObject = paramList.iterator();
    int i = 0;
    int j;
    label68:
    label76:
    int i1;
    int i2;
    if (((Iterator)localObject).hasNext()) {
      if (((BaseFinderFeed)((o)((Iterator)localObject).next()).first).feedObject.getExpectId() == paramBaseFinderFeed.lx())
      {
        j = 1;
        if (j == 0) {
          break label327;
        }
        j = i;
        if (j < 0) {
          break label393;
        }
        i1 = Math.max(j - this.rwf.rvF, 0);
        i2 = Math.min(this.rwf.rvG + j + 1, paramList.size());
        paramBaseFinderFeed = (Iterable)paramList.subList(i1, i2);
        i = 0;
        paramBaseFinderFeed = paramBaseFinderFeed.iterator();
      }
    }
    for (;;)
    {
      if (!paramBaseFinderFeed.hasNext()) {
        break label393;
      }
      paramList = paramBaseFinderFeed.next();
      int k = i + 1;
      if (i < 0) {
        j.fOc();
      }
      paramList = (bqs)j.iP((List)((o)paramList).second);
      if (paramList != null)
      {
        if ((paramList.mediaType == 4) && (!a(paramList)))
        {
          int m;
          if (i < j - i1)
          {
            m = i + (i1 - j);
            label226:
            paramList = (Iterable)this.rwf.a(paramList, true);
            i = 0;
            paramList = paramList.iterator();
          }
          for (;;)
          {
            if (!paramList.hasNext()) {
              break label381;
            }
            localObject = paramList.next();
            int n = i + 1;
            if (i < 0) {
              j.fOc();
            }
            localObject = (a.b)localObject;
            if (i == 0)
            {
              localObject = a((a.b)localObject);
              ((com.tencent.mm.plugin.finder.preload.c)localObject).weight = (m + 1000);
              localLinkedList.add(localObject);
              i = n;
              continue;
              j = 0;
              break label68;
              label327:
              i += 1;
              break;
              j = -1;
              break label76;
              m = i2 - i1 - i;
              break label226;
            }
            localObject = a((a.b)localObject);
            ((com.tencent.mm.plugin.finder.preload.c)localObject).weight = m;
            localLinkedList.add(localObject);
            i = n;
          }
        }
        label381:
        i = k;
      }
      else
      {
        i = k;
      }
    }
    label393:
    j.sort((List)localLinkedList);
    AppMethodBeat.o(202669);
    return localLinkedList;
  }
  
  public final void a(BaseFinderFeed paramBaseFinderFeed, List<o<BaseFinderFeed, List<bqs>>> paramList, int paramInt)
  {
    AppMethodBeat.i(202662);
    k.h(paramBaseFinderFeed, "centerFeed");
    k.h(paramList, "dataList");
    ac.i(this.TAG, "[preload] prevCount=" + this.rwf.rvF + " nextCount=" + this.rwf.rvG + " maxConcurrentCount=" + this.rwf.rvI + ' ' + "list=" + paramList.size() + " center=" + paramBaseFinderFeed.cwr() + " source=" + paramInt);
    paramBaseFinderFeed = ((Iterable)ad(b(paramBaseFinderFeed, paramList))).iterator();
    while (paramBaseFinderFeed.hasNext()) {
      a((com.tencent.mm.plugin.finder.preload.c)paramBaseFinderFeed.next());
    }
    AppMethodBeat.o(202662);
  }
  
  public final void aY(final String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(202663);
    k.h(paramString, "mediaId");
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("[onMediaFocus] mediaId=");
    c.a locala = com.tencent.mm.plugin.finder.preload.c.rvy;
    ac.i(str, c.a.adJ(paramString) + " isFocused=" + paramBoolean);
    if (paramBoolean)
    {
      x((d.g.a.a)new i(this, paramString));
      aZ(paramString, true);
      cwL();
      AppMethodBeat.o(202663);
      return;
    }
    this.rwc = "";
    AppMethodBeat.o(202663);
  }
  
  public final void cwL()
  {
    AppMethodBeat.i(202664);
    x((d.g.a.a)new j(this));
    AppMethodBeat.o(202664);
  }
  
  public final <T> T x(d.g.a.a<? extends T> parama)
  {
    AppMethodBeat.i(202673);
    this.rwa.lock();
    try
    {
      parama = parama.invoke();
      return parama;
    }
    finally
    {
      this.rwa.unlock();
      AppMethodBeat.o(202673);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker$Companion;", "", "()V", "ENQUEUE_FAILURE", "", "ENQUEUE_REJECT", "ENQUEUE_SUCCESSFULLY", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker$VideoPreloadTaskCallback;", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskPreloadCallback;", "expect", "", "startTick", "", "loadingMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "Lkotlin/collections/HashMap;", "preLoadCallbacks", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mm/plugin/finder/preload/IVideoPreloadCallback;", "(Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;IJLjava/util/HashMap;Ljava/util/concurrent/ConcurrentLinkedQueue;)V", "onPreloadCompleted", "", "mediaId", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "plugin-finder_release"})
  public final class b
    implements g.b
  {
    private final long fQT;
    final HashMap<String, com.tencent.mm.plugin.finder.preload.c> rwb;
    private final ConcurrentLinkedQueue<com.tencent.mm.plugin.finder.preload.b> rwe;
    private final int rwj;
    
    public b(long paramLong, HashMap<String, com.tencent.mm.plugin.finder.preload.c> paramHashMap, ConcurrentLinkedQueue<com.tencent.mm.plugin.finder.preload.b> paramConcurrentLinkedQueue)
    {
      AppMethodBeat.i(202645);
      this.rwj = paramLong;
      this.fQT = ???;
      this.rwb = paramConcurrentLinkedQueue;
      this.rwe = localObject;
      AppMethodBeat.o(202645);
    }
    
    public final void b(final String paramString, com.tencent.mm.i.d paramd)
    {
      AppMethodBeat.i(202644);
      k.h(paramString, "mediaId");
      if ((paramd != null) && (paramd.field_retCode == -21112))
      {
        paramd = ((Iterable)this.rwe).iterator();
        while (paramd.hasNext()) {
          ((com.tencent.mm.plugin.finder.preload.b)paramd.next()).adG(paramString);
        }
        AppMethodBeat.o(202644);
        return;
      }
      if (paramd == null)
      {
        ac.e(b.b(b.this), "[onPreloadCompleted] sceneResult == null");
        AppMethodBeat.o(202644);
        return;
      }
      Object localObject = new long[3];
      CdnLogic.queryDownloadedSize(paramString, (long[])localObject);
      long l1 = localObject[0];
      long l2 = paramd.field_fileLength;
      if (l1 != paramd.field_recvedBytes) {
        ac.w(b.b(b.this), "[onPreloadCompleted] queryReceived=" + l1 + " recvedBytes=" + paramd.field_recvedBytes + ' ' + paramString);
      }
      com.tencent.mm.plugin.finder.preload.c localc = (com.tencent.mm.plugin.finder.preload.c)b.a(b.this, (d.g.a.a)new a(this, paramString));
      com.tencent.mm.an.f.aDD().BR(paramString);
      if ((l1 > 0L) && (l2 > 0L) && (localc != null))
      {
        localObject = com.tencent.mm.plugin.finder.storage.logic.c.rFo;
        localObject = paramd.field_videoFlag;
        if (localObject != null) {
          break label624;
        }
        localObject = localc.cwK();
      }
      label387:
      label451:
      label457:
      label624:
      for (;;)
      {
        com.tencent.mm.plugin.finder.storage.logic.c.gf(paramString, (String)localObject);
        localObject = com.tencent.mm.plugin.finder.storage.logic.c.rFo;
        int i;
        if (l2 <= l1)
        {
          i = 3;
          com.tencent.mm.plugin.finder.storage.logic.c.a(paramString, l1, l2, i);
          ac.i(b.b(b.this), "[onPreloadCompleted] successfully! mediaId=" + paramString + " startTick=" + this.fQT + " receivedBytes=" + l1 + " fileLength=" + l2 + " expect=" + this.rwj + "% fileFormat=" + paramd.field_videoFlag + " videoFormat=" + paramd.field_videoFormat);
          paramd = ((Iterable)this.rwe).iterator();
          if (!paramd.hasNext()) {
            break label457;
          }
          localObject = (com.tencent.mm.plugin.finder.preload.b)paramd.next();
          if (l2 != l1) {
            break label451;
          }
        }
        for (boolean bool = true;; bool = false)
        {
          ((com.tencent.mm.plugin.finder.preload.b)localObject).a(paramString, bool, d.h.a.cj(100.0F * (float)l1 / (float)l2), localc);
          break label387;
          i = 2;
          break;
        }
        paramd = com.tencent.mm.ui.component.a.IrY;
        ((FinderVideoRecycler)com.tencent.mm.ui.component.a.bg(PluginFinder.class).get(FinderVideoRecycler.class)).aCm(paramString);
        AppMethodBeat.o(202644);
        return;
        ac.e(b.b(b.this), "[onPreloadCompleted] ERROR! mediaId=" + paramString + " startTick=" + this.fQT + " recvedBytes=" + l1 + " fileLength=" + l2 + " fileFormat=" + paramd.field_videoFlag + " videoFormat=" + paramd.field_videoFormat);
        if (localc != null)
        {
          paramd = ((Iterable)this.rwe).iterator();
          while (paramd.hasNext()) {
            ((com.tencent.mm.plugin.finder.preload.b)paramd.next()).a(paramString, "onPreloadCompleted error", localc);
          }
        }
        AppMethodBeat.o(202644);
        return;
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<com.tencent.mm.plugin.finder.preload.c>
    {
      a(b.b paramb, String paramString)
      {
        super();
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "invoke"})
  static final class c$a
    extends d.g.b.l
    implements d.g.a.a<com.tencent.mm.plugin.finder.preload.c>
  {
    c$a(b.c paramc, String paramString)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "invoke"})
  static final class c$b
    extends d.g.b.l
    implements d.g.a.a<com.tencent.mm.plugin.finder.preload.c>
  {
    c$b(b.c paramc, String paramString)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.a<LinkedList<com.tencent.mm.plugin.finder.preload.c>>
  {
    g(b paramb, LinkedList paramLinkedList)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  public static final class h
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public h(b paramb, LinkedList paramLinkedList)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class i
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    i(b paramb, String paramString)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class j
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    j(b paramb)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  public static final class k
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public k(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.worker.b
 * JD-Core Version:    0.7.0.1
 */