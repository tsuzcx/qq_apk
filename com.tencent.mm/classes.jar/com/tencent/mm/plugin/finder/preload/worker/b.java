package com.tencent.mm.plugin.finder.preload.worker;

import android.arch.lifecycle.ViewModelProvider;
import android.os.SystemClock;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.g.a;
import com.tencent.mm.i.g.b;
import com.tencent.mm.i.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.loader.i;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.am;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore.a;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore.b;
import com.tencent.mm.plugin.finder.preload.c.a;
import com.tencent.mm.plugin.finder.preload.c.b;
import com.tencent.mm.plugin.finder.preload.model.a.b;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.r;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderVideoRecycler;
import com.tencent.mm.plugin.i.a.d.a;
import com.tencent.mm.plugin.thumbplayer.PluginThumbPlayer;
import com.tencent.mm.plugin.thumbplayer.b.a.d;
import com.tencent.mm.protocal.protobuf.bvz;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import d.a.j;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.n.n;
import java.io.ByteArrayOutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;", "Lcom/tencent/mm/plugin/finder/preload/worker/IPreloadWorker;", "model", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "sceneTag", "", "(Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;Ljava/lang/String;)V", "TAG", "focusedMediaId", "isOpenMultiBitRate", "", "isRelease", "isStop", "Ljava/util/concurrent/atomic/AtomicBoolean;", "loadingMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "Lkotlin/collections/HashMap;", "mainLock", "Ljava/util/concurrent/locks/ReentrantLock;", "preLoadCallbacks", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mm/plugin/finder/preload/IVideoPreloadCallback;", "getPreLoadCallbacks", "()Ljava/util/concurrent/ConcurrentLinkedQueue;", "waitingList", "Ljava/util/LinkedList;", "buildPreloadList", "centerFeed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "dataList", "", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "cancel", "mediaId", "isIgnorePlaying", "cancelWaitingTask", "createPreloadCDNTask", "detail", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel$Detail;", "enqueue", "", "task", "getPreLoadingCount", "isFocusedMedia", "media", "mergePreload", "preloadList", "needToMerge", "new", "old", "onClearAll", "", "onMediaFocus", "isFocused", "onPreloadStart", "onPreloadStop", "onRelease", "pollWaiting", "preload", "source", "printMergeList", "", "rawList", "removeWaitingList", "resetRunningTask", "showErrToast", "stage", "ret", "syncLock", "T", "tag", "handle", "Lkotlin/Function0;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Companion", "VideoPreloadTaskCallback", "VideoTaskCallTask", "plugin-finder_release"})
public final class b
{
  public static final a svz;
  public final String TAG;
  public AtomicBoolean dfZ;
  private final LinkedList<com.tencent.mm.plugin.finder.preload.c> guy;
  public boolean hmi;
  private final ReentrantLock svs;
  private final HashMap<String, com.tencent.mm.plugin.finder.preload.c> svt;
  private String svu;
  private final boolean svv;
  public final ConcurrentLinkedQueue<com.tencent.mm.plugin.finder.preload.b> svw;
  private final com.tencent.mm.plugin.finder.preload.model.a svx;
  private String svy;
  
  static
  {
    AppMethodBeat.i(203639);
    svz = new a((byte)0);
    AppMethodBeat.o(203639);
  }
  
  public b(com.tencent.mm.plugin.finder.preload.model.a parama, String paramString)
  {
    AppMethodBeat.i(203637);
    this.svx = parama;
    this.svy = paramString;
    this.svs = new ReentrantLock();
    this.svt = new HashMap();
    this.guy = new LinkedList();
    this.svu = "";
    parama = com.tencent.mm.plugin.finder.storage.b.sHP;
    this.svv = com.tencent.mm.plugin.finder.storage.b.cIB();
    this.svw = new ConcurrentLinkedQueue();
    this.TAG = ("Finder.VideoPreloadWorker_" + this.svy);
    this.svw.add(new com.tencent.mm.plugin.finder.preload.b()
    {
      public final void a(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, String paramAnonymousString3, com.tencent.mm.plugin.finder.preload.c paramAnonymousc)
      {
        AppMethodBeat.i(203600);
        p.h(paramAnonymousString1, "mediaId");
        p.h(paramAnonymousString2, "fileFormat");
        p.h(paramAnonymousString3, "codingFormat");
        p.h(paramAnonymousc, "task");
        AppMethodBeat.o(203600);
      }
      
      public final void a(String paramAnonymousString1, String paramAnonymousString2, com.tencent.mm.plugin.finder.preload.c paramAnonymousc)
      {
        AppMethodBeat.i(203603);
        p.h(paramAnonymousString1, "mediaId");
        p.h(paramAnonymousString2, "msg");
        p.h(paramAnonymousc, "task");
        b.g(this.svA);
        AppMethodBeat.o(203603);
      }
      
      public final void a(String paramAnonymousString, boolean paramAnonymousBoolean, int paramAnonymousInt, com.tencent.mm.plugin.finder.preload.c paramAnonymousc)
      {
        AppMethodBeat.i(203602);
        p.h(paramAnonymousString, "mediaId");
        p.h(paramAnonymousc, "task");
        if (b.e(this.svA).sub)
        {
          Object localObject = com.tencent.mm.plugin.finder.storage.logic.c.sLt;
          localObject = com.tencent.mm.plugin.finder.storage.logic.c.ajA(paramAnonymousString);
          MediaPreloadCore.a locala = MediaPreloadCore.stL;
          if ((!MediaPreloadCore.a.a((com.tencent.mm.plugin.finder.model.z)localObject).stM) && (!paramAnonymousBoolean))
          {
            ae.w(b.a(this.svA), "Moov failure! try to download all! ".concat(String.valueOf(localObject)));
            b.a(this.svA, paramAnonymousString, false);
            paramAnonymousc.fLN = 100;
            paramAnonymousc.field_preloadRatio = 100;
            b.a(this.svA, paramAnonymousc);
            AppMethodBeat.o(203602);
            return;
          }
        }
        b.g(this.svA);
        AppMethodBeat.o(203602);
      }
      
      public final void aiw(String paramAnonymousString)
      {
        AppMethodBeat.i(203604);
        p.h(paramAnonymousString, "mediaId");
        ae.e(b.a(this.svA), "[onFormatChange] mediaId=".concat(String.valueOf(paramAnonymousString)));
        b.a(this.svA, paramAnonymousString, false);
        com.tencent.mm.plugin.finder.storage.logic.c localc = com.tencent.mm.plugin.finder.storage.logic.c.sLt;
        com.tencent.mm.vfs.o.deleteFile(com.tencent.mm.plugin.finder.storage.logic.c.ajA(paramAnonymousString).getFilePath());
        localc = com.tencent.mm.plugin.finder.storage.logic.c.sLt;
        com.tencent.mm.plugin.finder.storage.logic.c.dy(paramAnonymousString, -2);
        AppMethodBeat.o(203604);
      }
      
      public final void dp(String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(203601);
        p.h(paramAnonymousString, "mediaId");
        AppMethodBeat.o(203601);
      }
    });
    this.dfZ = new AtomicBoolean(false);
    AppMethodBeat.o(203637);
  }
  
  private final int a(final com.tencent.mm.plugin.finder.preload.c paramc)
  {
    AppMethodBeat.i(203632);
    this.svs.lock();
    Object localObject3;
    Object localObject4;
    for (;;)
    {
      try
      {
        if (this.hmi)
        {
          ae.i(this.TAG, "[enqueue] VideoPreloadWorker has release. " + paramc + " just return.");
          return -1;
        }
        if (a(paramc.rYW.srx))
        {
          ae.i(this.TAG, "[enqueue] is focused task " + paramc + " just return.");
          return -1;
        }
        localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.sLt;
        localObject2 = com.tencent.mm.plugin.finder.storage.logic.c.ajA(paramc.stU);
        localObject3 = ((Iterable)this.svw).iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject4 = (com.tencent.mm.plugin.finder.preload.b)((Iterator)localObject3).next();
        String str1 = ((com.tencent.mm.plugin.finder.model.z)localObject2).field_mediaId;
        p.g(str1, "cache.field_mediaId");
        i = ((com.tencent.mm.plugin.finder.model.z)localObject2).cEL();
        String str2 = paramc.cEP();
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
        this.svs.unlock();
        AppMethodBeat.o(203632);
      }
    }
    boolean bool;
    if (((com.tencent.mm.plugin.finder.model.z)localObject2).cEJ())
    {
      ae.i(this.TAG, "[enqueue] " + paramc + " has complete file(" + ((com.tencent.mm.plugin.finder.model.z)localObject2).cEL() + "%)! just return.");
      localObject1 = ((Iterable)this.svw).iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject3 = (com.tencent.mm.plugin.finder.preload.b)((Iterator)localObject1).next();
        localObject4 = paramc.stU;
        if (((com.tencent.mm.plugin.finder.model.z)localObject2).cEL() >= 100) {}
        for (bool = true;; bool = false)
        {
          ((com.tencent.mm.plugin.finder.preload.b)localObject3).a((String)localObject4, bool, ((com.tencent.mm.plugin.finder.model.z)localObject2).cEL(), paramc);
          break;
        }
      }
      this.svs.unlock();
      AppMethodBeat.o(203632);
      return 1;
    }
    if ((((com.tencent.mm.plugin.finder.model.z)localObject2).cEL() >= paramc.fLN) && (((com.tencent.mm.plugin.finder.model.z)localObject2).field_cacheSize >= paramc.preloadMinSize))
    {
      ae.i(this.TAG, "[enqueue] " + paramc + " has finish preload(" + ((com.tencent.mm.plugin.finder.model.z)localObject2).cEL() + "%)! just return.");
      localObject1 = ((Iterable)this.svw).iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject3 = (com.tencent.mm.plugin.finder.preload.b)((Iterator)localObject1).next();
        localObject4 = paramc.stU;
        if (((com.tencent.mm.plugin.finder.model.z)localObject2).cEL() >= 100) {}
        for (bool = true;; bool = false)
        {
          ((com.tencent.mm.plugin.finder.preload.b)localObject3).a((String)localObject4, bool, ((com.tencent.mm.plugin.finder.model.z)localObject2).cEL(), paramc);
          break;
        }
      }
      this.svs.unlock();
      AppMethodBeat.o(203632);
      return 1;
    }
    int i = this.svt.size();
    if ((this.svx.sug <= i) || (this.dfZ.get()))
    {
      j.c((List)this.guy, (d.g.a.b)new g(paramc));
      this.guy.add(paramc);
      paramc.a(c.b.stZ);
      ae.i(this.TAG, "[enqueue] " + paramc + " wait to preLoad, just return. isStop=" + this.dfZ + " preLoadingCount=" + i + " waitingSize=" + this.guy.size());
      this.svs.unlock();
      AppMethodBeat.o(203632);
      return 1;
    }
    paramc.a(c.b.stX);
    Object localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.sLt;
    com.tencent.mm.plugin.finder.storage.logic.c.a(paramc.stU, paramc.stV, paramc.rYW.getUrl(), paramc.field_requestVideoFormat, paramc.cEP(), ((com.tencent.mm.plugin.finder.model.z)localObject2).field_cacheSize, ((com.tencent.mm.plugin.finder.model.z)localObject2).field_totalSize, 1, paramc.rYW.srx.videoDuration, paramc.rYW.srx.url_token, paramc.rYW.srx.decodeKey);
    ((Map)this.svt).put(paramc.stU, paramc);
    localObject1 = new com.tencent.mm.plugin.finder.loader.g(paramc.rYW.srx, r.sJv);
    Object localObject2 = i.srW;
    i.cEn().bI(localObject1).aqX();
    localObject1 = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.thumbplayer.a.a.class);
    p.g(localObject1, "MMKernel.plugin(IPluginThumbPlayer::class.java)");
    if (((com.tencent.mm.plugin.thumbplayer.a.a)localObject1).isOpenTPPlayer())
    {
      localObject1 = ((PluginThumbPlayer)com.tencent.mm.kernel.g.ad(PluginThumbPlayer.class)).getCdnTaskController();
      localObject2 = (h)paramc;
      localObject3 = (com.tencent.mm.plugin.thumbplayer.b.d)new f(this, paramc);
      p.h(localObject2, "task");
      if (bu.isNullOrNil(((h)localObject2).field_mediaId)) {
        ae.e(((com.tencent.mm.plugin.thumbplayer.b.a)localObject1).TAG, "add download task, but task mediaId is null.");
      }
    }
    for (;;)
    {
      ae.i(this.TAG, "[enqueue] begin to preloadVideo... ".concat(String.valueOf(paramc)));
      this.svs.unlock();
      AppMethodBeat.o(203632);
      return 1;
      ae.i(((com.tencent.mm.plugin.thumbplayer.b.a)localObject1).TAG, "startPreloadDownloadTask: " + ((h)localObject2).field_mediaId + " current run tasks " + ((com.tencent.mm.plugin.thumbplayer.b.a)localObject1).BHn.size());
      if (((h)localObject2).field_fileId == null) {
        ((h)localObject2).field_fileId = "";
      }
      if (((h)localObject2).field_aesKey == null) {
        ((h)localObject2).field_aesKey = "";
      }
      ((h)localObject2).dPh = false;
      com.tencent.mm.ac.c.c("MicroMsg.Cdn.ThreadName", (d.g.a.a)new a.d((com.tencent.mm.plugin.thumbplayer.b.a)localObject1, (h)localObject2, (com.tencent.mm.plugin.thumbplayer.b.d)localObject3));
      continue;
      com.tencent.mm.an.f.aGZ().d((com.tencent.mm.i.g)paramc);
    }
  }
  
  private final com.tencent.mm.plugin.finder.preload.c a(a.b paramb)
  {
    AppMethodBeat.i(203633);
    int i;
    com.tencent.mm.plugin.finder.preload.c localc;
    if (p.i(paramb.suu, "h265"))
    {
      i = 2;
      localc = new com.tencent.mm.plugin.finder.preload.c(paramb.suv);
      localc.fLl = "task_VideoPreloadWorker";
      localc.field_mediaId = paramb.suv.aeM();
      localc.url = (paramb.suv.getUrl() + paramb.suv.cEl());
      localc.field_fullpath = paramb.suv.getPath();
      localc.snsCipherKey = paramb.suv.cEk();
      localc.fLC = 2;
      localc.fLI = 2;
      localc.fLD = 8;
      localc.fLN = paramb.fLN;
      localc.field_preloadRatio = paramb.fLN;
      localc.concurrentCount = d.a.tqF;
      localc.connectionCount = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getMediaPreloadModel().suh;
      localc.fLm = ((g.a)new c(localc.fLN, paramb.preloadMinSize, this.svt, this.svw, paramb.suv));
      localc.fLE = ((g.b)new b(localc.fLN, SystemClock.uptimeMillis(), this.svt, this.svw));
      localc.field_fileType = com.tencent.mm.i.a.fKJ;
      localc.preloadMinSize = paramb.preloadMinSize;
      localc.fLP = 0;
      if (!this.svv) {
        break label283;
      }
      localc.field_requestVideoFormat = 0;
      localc.aiB(paramb.dEk);
    }
    for (;;)
    {
      AppMethodBeat.o(203633);
      return localc;
      i = 1;
      break;
      label283:
      localc.field_requestVideoFormat = i;
    }
  }
  
  private final boolean a(bvz parambvz)
  {
    AppMethodBeat.i(203630);
    String str2 = this.svu;
    String str1 = parambvz.mediaId;
    parambvz = str1;
    if (str1 == null) {
      parambvz = "";
    }
    boolean bool = n.nG(str2, parambvz);
    AppMethodBeat.o(203630);
    return bool;
  }
  
  private final LinkedList<com.tencent.mm.plugin.finder.preload.c> ae(final LinkedList<com.tencent.mm.plugin.finder.preload.c> paramLinkedList)
  {
    AppMethodBeat.i(203634);
    final List localList = j.s((Collection)paramLinkedList);
    final LinkedList localLinkedList1 = new LinkedList();
    final LinkedList localLinkedList2 = aiG(null);
    i("mergePreload", (d.g.a.a)new h(this, paramLinkedList, localLinkedList1, localList, localLinkedList2));
    d((List)paramLinkedList, localList, (List)localLinkedList2);
    AppMethodBeat.o(203634);
    return paramLinkedList;
  }
  
  private final LinkedList<com.tencent.mm.plugin.finder.preload.c> aiG(final String paramString)
  {
    AppMethodBeat.i(203629);
    paramString = (LinkedList)i("cancelWaitingTask", (d.g.a.a)new e(this, paramString));
    AppMethodBeat.o(203629);
    return paramString;
  }
  
  private final LinkedList<com.tencent.mm.plugin.finder.preload.c> b(BaseFinderFeed paramBaseFinderFeed, List<d.o<am, List<bvz>>> paramList)
  {
    AppMethodBeat.i(203631);
    LinkedList localLinkedList = new LinkedList();
    Object localObject = paramList.iterator();
    int i = 0;
    int j;
    label83:
    label91:
    int i1;
    int i2;
    if (((Iterator)localObject).hasNext())
    {
      am localam = (am)((d.o)((Iterator)localObject).next()).first;
      if (((localam instanceof BaseFinderFeed)) && (((BaseFinderFeed)localam).feedObject.getExpectId() == paramBaseFinderFeed.lP()))
      {
        j = 1;
        if (j == 0) {
          break label342;
        }
        j = i;
        if (j < 0) {
          break label408;
        }
        i1 = Math.max(j - this.svx.suc, 0);
        i2 = Math.min(this.svx.sud + j + 1, paramList.size());
        paramBaseFinderFeed = (Iterable)paramList.subList(i1, i2);
        i = 0;
        paramBaseFinderFeed = paramBaseFinderFeed.iterator();
      }
    }
    for (;;)
    {
      if (!paramBaseFinderFeed.hasNext()) {
        break label408;
      }
      paramList = paramBaseFinderFeed.next();
      int k = i + 1;
      if (i < 0) {
        j.gkd();
      }
      paramList = (bvz)j.jm((List)((d.o)paramList).second);
      if (paramList != null)
      {
        if ((paramList.mediaType == 4) && (!a(paramList)))
        {
          int m;
          if (i < j - i1)
          {
            m = i + (i1 - j);
            label241:
            paramList = (Iterable)this.svx.a(paramList, true);
            i = 0;
            paramList = paramList.iterator();
          }
          for (;;)
          {
            if (!paramList.hasNext()) {
              break label396;
            }
            localObject = paramList.next();
            int n = i + 1;
            if (i < 0) {
              j.gkd();
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
              break label83;
              label342:
              i += 1;
              break;
              j = -1;
              break label91;
              m = i2 - i1 - i;
              break label241;
            }
            localObject = a((a.b)localObject);
            ((com.tencent.mm.plugin.finder.preload.c)localObject).weight = m;
            localLinkedList.add(localObject);
            i = n;
          }
        }
        label396:
        i = k;
      }
      else
      {
        i = k;
      }
    }
    label408:
    j.sort((List)localLinkedList);
    AppMethodBeat.o(203631);
    return localLinkedList;
  }
  
  private final com.tencent.mm.plugin.finder.preload.c bf(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(203628);
    paramString = (com.tencent.mm.plugin.finder.preload.c)i("cancel", (d.g.a.a)new d(this, paramString, paramBoolean));
    AppMethodBeat.o(203628);
    return paramString;
  }
  
  private final void d(List<com.tencent.mm.plugin.finder.preload.c> paramList1, List<com.tencent.mm.plugin.finder.preload.c> paramList2, List<com.tencent.mm.plugin.finder.preload.c> paramList3)
  {
    AppMethodBeat.i(203636);
    if (paramList1.isEmpty())
    {
      ae.i(this.TAG, "[mergePreload] preloadList is empty!");
      AppMethodBeat.o(203636);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("[mergePreload] -> \n");
    paramList3 = ((Iterable)paramList3).iterator();
    while (paramList3.hasNext())
    {
      com.tencent.mm.plugin.finder.preload.c localc = (com.tencent.mm.plugin.finder.preload.c)paramList3.next();
      localStringBuilder.append("(-) ").append(localc).append("\n");
    }
    paramList2 = ((Iterable)paramList2).iterator();
    while (paramList2.hasNext())
    {
      paramList3 = (com.tencent.mm.plugin.finder.preload.c)paramList2.next();
      if (paramList1.contains(paramList3)) {
        localStringBuilder.append("(+) ").append(paramList3).append("\n");
      } else {
        localStringBuilder.append("(~) ").append(paramList3).append("\n");
      }
    }
    ae.i(this.TAG, localStringBuilder.toString());
    AppMethodBeat.o(203636);
  }
  
  public final void a(BaseFinderFeed paramBaseFinderFeed, List<d.o<am, List<bvz>>> paramList, int paramInt)
  {
    AppMethodBeat.i(203625);
    p.h(paramBaseFinderFeed, "centerFeed");
    p.h(paramList, "dataList");
    ae.i(this.TAG, "[preload] prevCount=" + this.svx.suc + " nextCount=" + this.svx.sud + " maxPreloadTaskCount=" + this.svx.sug + ' ' + "list=" + paramList.size() + " center=" + paramBaseFinderFeed.cEt() + " source=" + paramInt);
    paramBaseFinderFeed = ((Iterable)ae(b(paramBaseFinderFeed, paramList))).iterator();
    while (paramBaseFinderFeed.hasNext()) {
      a((com.tencent.mm.plugin.finder.preload.c)paramBaseFinderFeed.next());
    }
    AppMethodBeat.o(203625);
  }
  
  public final void be(final String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(203626);
    p.h(paramString, "mediaId");
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("[onMediaFocus] mediaId=");
    c.a locala = com.tencent.mm.plugin.finder.preload.c.stW;
    ae.i(str, c.a.aiC(paramString) + " isFocused=" + paramBoolean);
    if (paramBoolean)
    {
      i("onMediaFocus", (d.g.a.a)new j(this, paramString));
      bf(paramString, true);
      cEV();
      AppMethodBeat.o(203626);
      return;
    }
    this.svu = "";
    AppMethodBeat.o(203626);
  }
  
  public final void cEV()
  {
    AppMethodBeat.i(203627);
    i("pollWaiting", (d.g.a.a)new k(this));
    AppMethodBeat.o(203627);
  }
  
  public final <T> T i(String paramString, d.g.a.a<? extends T> parama)
  {
    AppMethodBeat.i(203635);
    long l = SystemClock.uptimeMillis();
    this.svs.lock();
    try
    {
      parama = parama.invoke();
      return parama;
    }
    finally
    {
      this.svs.unlock();
      l = SystemClock.uptimeMillis() - l;
      if (l > 100L) {
        ae.w(this.TAG, "[syncLock] tag=" + paramString + " so slow! cost=" + l + "ms");
      }
      AppMethodBeat.o(203635);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker$Companion;", "", "()V", "ENQUEUE_FAILURE", "", "ENQUEUE_REJECT", "ENQUEUE_SUCCESSFULLY", "plugin-finder_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker$VideoPreloadTaskCallback;", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskPreloadCallback;", "expect", "", "startTick", "", "loadingMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "Lkotlin/collections/HashMap;", "preLoadCallbacks", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mm/plugin/finder/preload/IVideoPreloadCallback;", "(Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;IJLjava/util/HashMap;Ljava/util/concurrent/ConcurrentLinkedQueue;)V", "onPreloadCompleted", "", "mediaId", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "plugin-finder_release"})
  public final class b
    implements g.b
  {
    private final long gmN;
    private final int svB;
    final HashMap<String, com.tencent.mm.plugin.finder.preload.c> svt;
    private final ConcurrentLinkedQueue<com.tencent.mm.plugin.finder.preload.b> svw;
    
    public b(long paramLong, HashMap<String, com.tencent.mm.plugin.finder.preload.c> paramHashMap, ConcurrentLinkedQueue<com.tencent.mm.plugin.finder.preload.b> paramConcurrentLinkedQueue)
    {
      AppMethodBeat.i(203607);
      this.svB = paramLong;
      this.gmN = ???;
      this.svt = paramConcurrentLinkedQueue;
      this.svw = localObject;
      AppMethodBeat.o(203607);
    }
    
    public final void b(final String paramString, com.tencent.mm.i.d paramd)
    {
      AppMethodBeat.i(203606);
      p.h(paramString, "mediaId");
      if ((paramd != null) && (paramd.field_retCode == -21112))
      {
        paramd = ((Iterable)this.svw).iterator();
        while (paramd.hasNext()) {
          ((com.tencent.mm.plugin.finder.preload.b)paramd.next()).aiw(paramString);
        }
        AppMethodBeat.o(203606);
        return;
      }
      if (paramd == null)
      {
        ae.e(b.a(b.this), "[onPreloadCompleted] sceneResult == null");
        AppMethodBeat.o(203606);
        return;
      }
      Object localObject = new long[3];
      CdnLogic.queryDownloadedSize(paramString, (long[])localObject);
      long l1 = Math.max(localObject[0], paramd.field_recvedBytes);
      long l2 = paramd.field_fileLength;
      com.tencent.mm.plugin.finder.preload.c localc = (com.tencent.mm.plugin.finder.preload.c)b.a(b.this, "onPreloadCompleted", (d.g.a.a)new a(this, paramString));
      com.tencent.mm.an.f.aGZ().Fs(paramString);
      if ((l1 > 0L) && (l2 > 0L) && (localc != null))
      {
        localObject = com.tencent.mm.plugin.finder.storage.logic.c.sLt;
        int i;
        if (l2 <= l1)
        {
          i = 3;
          com.tencent.mm.plugin.finder.model.z localz = com.tencent.mm.plugin.finder.storage.logic.c.a(paramString, l1, l2, i);
          String str = paramd.field_videoFlag;
          localObject = str;
          if (str == null) {
            localObject = localc.cEP();
          }
          localz.field_fileFormat = ((String)localObject);
          localObject = com.tencent.mm.plugin.finder.storage.logic.c.sLt;
          com.tencent.mm.plugin.finder.storage.logic.c.ajz(paramString);
          ae.i(b.a(b.this), "[onPreloadCompleted] successfully! mediaId=" + paramString + " startTick=" + this.gmN + " receivedBytes=" + l1 + " fileLength=" + l2 + " expect=" + this.svB + "% result=" + (int)(100.0F * (float)l1 / (float)l2) + "% fileFormat=" + paramd.field_videoFlag + " videoFormat=" + paramd.field_videoFormat);
          paramd = ((Iterable)this.svw).iterator();
          label367:
          if (!paramd.hasNext()) {
            break label437;
          }
          localObject = (com.tencent.mm.plugin.finder.preload.b)paramd.next();
          if (l2 != l1) {
            break label431;
          }
        }
        label431:
        for (boolean bool = true;; bool = false)
        {
          ((com.tencent.mm.plugin.finder.preload.b)localObject).a(paramString, bool, d.h.a.cm(100.0F * (float)l1 / (float)l2), localc);
          break label367;
          i = 2;
          break;
        }
        label437:
        paramd = com.tencent.mm.ui.component.a.KEX;
        ((FinderVideoRecycler)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderVideoRecycler.class)).akm(paramString);
        AppMethodBeat.o(203606);
        return;
      }
      ae.e(b.a(b.this), "[onPreloadCompleted] ERROR! mediaId=" + paramString + " startTick=" + this.gmN + " recvedBytes=" + l1 + " fileLength=" + l2 + " fileFormat=" + paramd.field_videoFlag + " videoFormat=" + paramd.field_videoFormat);
      if (localc != null)
      {
        paramd = ((Iterable)this.svw).iterator();
        while (paramd.hasNext()) {
          ((com.tencent.mm.plugin.finder.preload.b)paramd.next()).a(paramString, "onPreloadCompleted error", localc);
        }
      }
      AppMethodBeat.o(203606);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "invoke"})
    static final class a
      extends q
      implements d.g.a.a<com.tencent.mm.plugin.finder.preload.c>
    {
      a(b.b paramb, String paramString)
      {
        super();
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker$VideoTaskCallTask;", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "expect", "", "preloadMinSize", "", "loadingMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "Lkotlin/collections/HashMap;", "preLoadCallbacks", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mm/plugin/finder/preload/IVideoPreloadCallback;", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "(Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;IJLjava/util/HashMap;Ljava/util/concurrent/ConcurrentLinkedQueue;Lcom/tencent/mm/plugin/finder/loader/FinderVideo;)V", "getExpect", "()I", "getPreloadMinSize", "()J", "callback", "mediaId", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-finder_release"})
  final class c
    implements g.a
  {
    private final long preloadMinSize;
    private final m rYW;
    private final int svB;
    final HashMap<String, com.tencent.mm.plugin.finder.preload.c> svt;
    private final ConcurrentLinkedQueue<com.tencent.mm.plugin.finder.preload.b> svw;
    
    public c(long paramLong, HashMap<String, com.tencent.mm.plugin.finder.preload.c> paramHashMap, ConcurrentLinkedQueue<com.tencent.mm.plugin.finder.preload.b> paramConcurrentLinkedQueue, m paramm)
    {
      AppMethodBeat.i(203612);
      this.svB = paramLong;
      this.preloadMinSize = ???;
      this.svt = paramConcurrentLinkedQueue;
      this.svw = paramm;
      this.rYW = localObject;
      AppMethodBeat.o(203612);
    }
    
    public final int a(final String paramString, int paramInt, com.tencent.mm.i.c paramc, com.tencent.mm.i.d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(203611);
      p.h(paramString, "mediaId");
      if ((paramd != null) && (paramd.field_retCode == -21112))
      {
        b.a(b.this, "callback#1", (d.g.a.a)new a(this, paramString));
        paramc = ((Iterable)this.svw).iterator();
        while (paramc.hasNext()) {
          ((com.tencent.mm.plugin.finder.preload.b)paramc.next()).aiw(paramString);
        }
        AppMethodBeat.o(203611);
        return -1;
      }
      if ((paramc != null) && (paramc.field_toltalLength > 0L))
      {
        long l1 = paramc.field_finishedLength;
        long l2 = paramc.field_toltalLength;
        if (((int)((float)l1 / (float)l2 * 100.0F) >= this.svB) && (l1 < l2) && (this.preloadMinSize <= l1)) {
          paramInt = 2;
        }
        for (;;)
        {
          paramc = com.tencent.mm.plugin.finder.storage.logic.c.sLt;
          com.tencent.mm.plugin.finder.model.z localz = com.tencent.mm.plugin.finder.storage.logic.c.a(paramString, l1, l2, paramInt);
          if (paramd != null)
          {
            paramd = paramd.field_videoFlag;
            paramc = paramd;
            if (paramd != null) {}
          }
          else
          {
            paramc = ((c)this).rYW.sry.detail;
          }
          localz.field_fileFormat = paramc;
          paramc = com.tencent.mm.plugin.finder.storage.logic.c.sLt;
          com.tencent.mm.plugin.finder.storage.logic.c.ajz(paramString);
          paramc = ((Iterable)this.svw).iterator();
          while (paramc.hasNext()) {
            ((com.tencent.mm.plugin.finder.preload.b)paramc.next()).dp(paramString, d.h.a.cm((float)l1 * 100.0F / (float)l2));
          }
          if (l1 >= l2) {
            paramInt = 3;
          } else {
            paramInt = 1;
          }
        }
      }
      if (paramInt != 0)
      {
        ae.e(b.a(b.this), "[VideoTaskCallTask] error! startRet=" + paramInt + " mediaId=" + paramString);
        if (-21006 != paramInt)
        {
          paramc = (com.tencent.mm.plugin.finder.preload.c)b.a(b.this, "callback#2", (d.g.a.a)new b(this, paramString));
          paramd = com.tencent.mm.plugin.finder.storage.logic.c.sLt;
          com.tencent.mm.plugin.finder.storage.logic.c.dy(paramString, -1);
          if (paramc != null)
          {
            paramd = ((Iterable)this.svw).iterator();
            while (paramd.hasNext()) {
              ((com.tencent.mm.plugin.finder.preload.b)paramd.next()).a(paramString, "UPDATE ERROR", paramc);
            }
          }
        }
      }
      AppMethodBeat.o(203611);
      return 0;
    }
    
    public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
    {
      AppMethodBeat.i(203610);
      p.h(paramString, "mediaId");
      AppMethodBeat.o(203610);
    }
    
    public final byte[] f(String paramString, byte[] paramArrayOfByte)
    {
      return new byte[0];
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "invoke"})
    static final class a
      extends q
      implements d.g.a.a<com.tencent.mm.plugin.finder.preload.c>
    {
      a(b.c paramc, String paramString)
      {
        super();
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "invoke"})
    static final class b
      extends q
      implements d.g.a.a<com.tencent.mm.plugin.finder.preload.c>
    {
      b(b.c paramc, String paramString)
      {
        super();
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "invoke"})
  static final class d
    extends q
    implements d.g.a.a<com.tencent.mm.plugin.finder.preload.c>
  {
    d(b paramb, String paramString, boolean paramBoolean)
    {
      super();
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker$cancel$1$1$1", "Lcom/tencent/mm/plugin/thumbplayer/cdn/StopPreloadDownloadCallback;", "onStop", "", "ret", "", "plugin-finder_release"})
    public static final class a
      implements com.tencent.mm.plugin.thumbplayer.b.f
    {
      a(b.d paramd) {}
      
      public final void Fb(int paramInt)
      {
        AppMethodBeat.i(203613);
        ae.i(b.a(this.svF.svA), "preload task on Stop " + this.svF.pGG + ' ' + paramInt);
        b.dq("stopPreload", paramInt);
        AppMethodBeat.o(203613);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "invoke"})
  static final class e
    extends q
    implements d.g.a.a<LinkedList<com.tencent.mm.plugin.finder.preload.c>>
  {
    e(b paramb, String paramString)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker$enqueue$5", "Lcom/tencent/mm/plugin/thumbplayer/cdn/StartPreloadDownloadCallback;", "onStart", "", "ret", "", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "plugin-finder_release"})
  public static final class f
    implements com.tencent.mm.plugin.thumbplayer.b.d
  {
    f(com.tencent.mm.plugin.finder.preload.c paramc) {}
    
    public final void Fc(int paramInt)
    {
      AppMethodBeat.i(224304);
      ae.i(b.a(this.svA), "preload task on Start " + paramc.field_mediaId + ' ' + paramInt);
      b.dq("startPreload", paramInt);
      AppMethodBeat.o(224304);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "invoke"})
  static final class g
    extends q
    implements d.g.a.b<com.tencent.mm.plugin.finder.preload.c, Boolean>
  {
    g(com.tencent.mm.plugin.finder.preload.c paramc)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements d.g.a.a<d.z>
  {
    h(b paramb, LinkedList paramLinkedList1, LinkedList paramLinkedList2, List paramList, LinkedList paramLinkedList3)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  public static final class i
    extends q
    implements d.g.a.a<d.z>
  {
    public i(b paramb, LinkedList paramLinkedList)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class j
    extends q
    implements d.g.a.a<d.z>
  {
    j(b paramb, String paramString)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class k
    extends q
    implements d.g.a.a<d.z>
  {
    k(b paramb)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  public static final class l
    extends q
    implements d.g.a.a<Boolean>
  {
    public l(b paramb)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class m
    extends q
    implements d.g.a.a<d.z>
  {
    m(String paramString, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.worker.b
 * JD-Core Version:    0.7.0.1
 */