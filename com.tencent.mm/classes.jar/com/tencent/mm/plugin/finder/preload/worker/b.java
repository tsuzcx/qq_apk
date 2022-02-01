package com.tencent.mm.plugin.finder.preload.worker;

import android.arch.lifecycle.ViewModelProvider;
import android.os.SystemClock;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.g.a;
import com.tencent.mm.i.g.b;
import com.tencent.mm.i.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.plugin.finder.model.y;
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
import com.tencent.mm.protocal.protobuf.bvf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.a.j;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.n.n;
import d.o;
import d.z;
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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;", "Lcom/tencent/mm/plugin/finder/preload/worker/IPreloadWorker;", "model", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "sceneTag", "", "(Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;Ljava/lang/String;)V", "TAG", "focusedMediaId", "isOpenMultiBitRate", "", "isRelease", "isStop", "Ljava/util/concurrent/atomic/AtomicBoolean;", "loadingMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "Lkotlin/collections/HashMap;", "mainLock", "Ljava/util/concurrent/locks/ReentrantLock;", "preLoadCallbacks", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mm/plugin/finder/preload/IVideoPreloadCallback;", "getPreLoadCallbacks", "()Ljava/util/concurrent/ConcurrentLinkedQueue;", "waitingList", "Ljava/util/LinkedList;", "buildPreloadList", "centerFeed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "dataList", "", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "cancel", "mediaId", "isIgnorePlaying", "cancelWaitingTask", "createPreloadCDNTask", "detail", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel$Detail;", "enqueue", "", "task", "getPreLoadingCount", "isFocusedMedia", "media", "mergePreload", "preloadList", "needToMerge", "new", "old", "onClearAll", "", "onMediaFocus", "isFocused", "onPreloadStart", "onPreloadStop", "onRelease", "pollWaiting", "preload", "source", "printMergeList", "", "rawList", "removeWaitingList", "resetRunningTask", "showErrToast", "stage", "ret", "syncLock", "T", "tag", "handle", "Lkotlin/Function0;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Companion", "VideoPreloadTaskCallback", "VideoTaskCallTask", "plugin-finder_release"})
public final class b
{
  public static final a slI;
  public final String TAG;
  public AtomicBoolean deX;
  private final LinkedList<com.tencent.mm.plugin.finder.preload.c> grX;
  public boolean hju;
  private final ReentrantLock slB;
  private final HashMap<String, com.tencent.mm.plugin.finder.preload.c> slC;
  private String slD;
  private final boolean slE;
  public final ConcurrentLinkedQueue<com.tencent.mm.plugin.finder.preload.b> slF;
  private final com.tencent.mm.plugin.finder.preload.model.a slG;
  private String slH;
  
  static
  {
    AppMethodBeat.i(203098);
    slI = new a((byte)0);
    AppMethodBeat.o(203098);
  }
  
  public b(com.tencent.mm.plugin.finder.preload.model.a parama, String paramString)
  {
    AppMethodBeat.i(203096);
    this.slG = parama;
    this.slH = paramString;
    this.slB = new ReentrantLock();
    this.slC = new HashMap();
    this.grX = new LinkedList();
    this.slD = "";
    parama = com.tencent.mm.plugin.finder.storage.b.sxa;
    this.slE = com.tencent.mm.plugin.finder.storage.b.cGE();
    this.slF = new ConcurrentLinkedQueue();
    this.TAG = ("Finder.VideoPreloadWorker_" + this.slH);
    this.slF.add(new com.tencent.mm.plugin.finder.preload.b()
    {
      public final void a(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, String paramAnonymousString3, com.tencent.mm.plugin.finder.preload.c paramAnonymousc)
      {
        AppMethodBeat.i(203059);
        p.h(paramAnonymousString1, "mediaId");
        p.h(paramAnonymousString2, "fileFormat");
        p.h(paramAnonymousString3, "codingFormat");
        p.h(paramAnonymousc, "task");
        AppMethodBeat.o(203059);
      }
      
      public final void a(String paramAnonymousString1, String paramAnonymousString2, com.tencent.mm.plugin.finder.preload.c paramAnonymousc)
      {
        AppMethodBeat.i(203062);
        p.h(paramAnonymousString1, "mediaId");
        p.h(paramAnonymousString2, "msg");
        p.h(paramAnonymousc, "task");
        b.g(this.slJ);
        AppMethodBeat.o(203062);
      }
      
      public final void a(String paramAnonymousString, boolean paramAnonymousBoolean, int paramAnonymousInt, com.tencent.mm.plugin.finder.preload.c paramAnonymousc)
      {
        AppMethodBeat.i(203061);
        p.h(paramAnonymousString, "mediaId");
        p.h(paramAnonymousc, "task");
        if (b.e(this.slJ).sle)
        {
          Object localObject = com.tencent.mm.plugin.finder.storage.logic.c.sAv;
          localObject = com.tencent.mm.plugin.finder.storage.logic.c.aiD(paramAnonymousString);
          MediaPreloadCore.a locala = MediaPreloadCore.skO;
          if ((!MediaPreloadCore.a.a((y)localObject).skP) && (!paramAnonymousBoolean))
          {
            ad.w(b.a(this.slJ), "Moov failure! try to download all! ".concat(String.valueOf(localObject)));
            b.a(this.slJ, paramAnonymousString, false);
            paramAnonymousc.fJK = 100;
            paramAnonymousc.field_preloadRatio = 100;
            b.a(this.slJ, paramAnonymousc);
            AppMethodBeat.o(203061);
            return;
          }
        }
        b.g(this.slJ);
        AppMethodBeat.o(203061);
      }
      
      public final void ahz(String paramAnonymousString)
      {
        AppMethodBeat.i(203063);
        p.h(paramAnonymousString, "mediaId");
        ad.e(b.a(this.slJ), "[onFormatChange] mediaId=".concat(String.valueOf(paramAnonymousString)));
        b.a(this.slJ, paramAnonymousString, false);
        com.tencent.mm.plugin.finder.storage.logic.c localc = com.tencent.mm.plugin.finder.storage.logic.c.sAv;
        com.tencent.mm.vfs.i.deleteFile(com.tencent.mm.plugin.finder.storage.logic.c.aiD(paramAnonymousString).getFilePath());
        localc = com.tencent.mm.plugin.finder.storage.logic.c.sAv;
        com.tencent.mm.plugin.finder.storage.logic.c.dt(paramAnonymousString, -2);
        AppMethodBeat.o(203063);
      }
      
      public final void dk(String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(203060);
        p.h(paramAnonymousString, "mediaId");
        AppMethodBeat.o(203060);
      }
    });
    this.deX = new AtomicBoolean(false);
    AppMethodBeat.o(203096);
  }
  
  private final int a(final com.tencent.mm.plugin.finder.preload.c paramc)
  {
    AppMethodBeat.i(203091);
    this.slB.lock();
    Object localObject3;
    Object localObject4;
    for (;;)
    {
      try
      {
        if (this.hju)
        {
          ad.i(this.TAG, "[enqueue] VideoPreloadWorker has release. " + paramc + " just return.");
          return -1;
        }
        if (a(paramc.rQu.siC))
        {
          ad.i(this.TAG, "[enqueue] is focused task " + paramc + " just return.");
          return -1;
        }
        localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.sAv;
        localObject2 = com.tencent.mm.plugin.finder.storage.logic.c.aiD(paramc.skX);
        localObject3 = ((Iterable)this.slF).iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject4 = (com.tencent.mm.plugin.finder.preload.b)((Iterator)localObject3).next();
        String str1 = ((y)localObject2).field_mediaId;
        p.g(str1, "cache.field_mediaId");
        i = ((y)localObject2).cCY();
        String str2 = paramc.cDc();
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
        this.slB.unlock();
        AppMethodBeat.o(203091);
      }
    }
    if ((((y)localObject2).cCY() >= paramc.fJK) && (((y)localObject2).field_cacheSize >= paramc.preloadMinSize))
    {
      ad.i(this.TAG, "[enqueue] " + paramc + " has finish preload(" + ((y)localObject2).cCY() + "%)! just return.");
      localObject1 = ((Iterable)this.slF).iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject3 = (com.tencent.mm.plugin.finder.preload.b)((Iterator)localObject1).next();
        localObject4 = paramc.skX;
        if (((y)localObject2).cCY() >= 100) {}
        for (boolean bool = true;; bool = false)
        {
          ((com.tencent.mm.plugin.finder.preload.b)localObject3).a((String)localObject4, bool, ((y)localObject2).cCY(), paramc);
          break;
        }
      }
      this.slB.unlock();
      AppMethodBeat.o(203091);
      return 1;
    }
    int i = this.slC.size();
    if ((this.slG.slj <= i) || (this.deX.get()))
    {
      j.b((List)this.grX, (d.g.a.b)new f(paramc));
      this.grX.add(paramc);
      paramc.a(c.b.slc);
      ad.i(this.TAG, "[enqueue] " + paramc + " wait to preLoad, just return. isStop=" + this.deX + " preLoadingCount=" + i + " waitingSize=" + this.grX.size());
      this.slB.unlock();
      AppMethodBeat.o(203091);
      return 1;
    }
    paramc.a(c.b.sla);
    Object localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.sAv;
    com.tencent.mm.plugin.finder.storage.logic.c.a(paramc.skX, paramc.skY, paramc.rQu.getUrl(), paramc.rQu.getPath(), paramc.field_requestVideoFormat, paramc.cDc(), ((y)localObject2).field_cacheSize, ((y)localObject2).field_totalSize, 1, paramc.rQu.siC.videoDuration, paramc.rQu.siC.url_token, paramc.rQu.siC.decodeKey);
    ((Map)this.slC).put(paramc.skX, paramc);
    localObject1 = new com.tencent.mm.plugin.finder.loader.g(paramc.rQu.siC, r.syE);
    Object localObject2 = com.tencent.mm.plugin.finder.loader.i.sja;
    com.tencent.mm.plugin.finder.loader.i.cCB().bI(localObject1).aqI();
    localObject1 = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.thumbplayer.a.a.class);
    p.g(localObject1, "MMKernel.plugin(IPluginThumbPlayer::class.java)");
    if (((com.tencent.mm.plugin.thumbplayer.a.a)localObject1).isOpenTPPlayer())
    {
      localObject1 = ((PluginThumbPlayer)com.tencent.mm.kernel.g.ad(PluginThumbPlayer.class)).getCdnTaskController();
      localObject2 = (h)paramc;
      localObject3 = (com.tencent.mm.plugin.thumbplayer.b.d)new g(this, paramc);
      p.h(localObject2, "task");
      if (bt.isNullOrNil(((h)localObject2).field_mediaId)) {
        ad.e(((com.tencent.mm.plugin.thumbplayer.b.a)localObject1).TAG, "add download task, but task mediaId is null.");
      }
    }
    for (;;)
    {
      ad.i(this.TAG, "[enqueue] begin to preloadVideo... ".concat(String.valueOf(paramc)));
      this.slB.unlock();
      AppMethodBeat.o(203091);
      return 1;
      ad.i(((com.tencent.mm.plugin.thumbplayer.b.a)localObject1).TAG, "startPreloadDownloadTask: " + ((h)localObject2).field_mediaId + " current run tasks " + ((com.tencent.mm.plugin.thumbplayer.b.a)localObject1).BpO.size());
      if (((h)localObject2).field_fileId == null) {
        ((h)localObject2).field_fileId = "";
      }
      if (((h)localObject2).field_aesKey == null) {
        ((h)localObject2).field_aesKey = "";
      }
      ((h)localObject2).dNR = false;
      com.tencent.mm.ad.c.c("MicroMsg.Cdn.ThreadName", (d.g.a.a)new a.d((com.tencent.mm.plugin.thumbplayer.b.a)localObject1, (h)localObject2, (com.tencent.mm.plugin.thumbplayer.b.d)localObject3));
      continue;
      com.tencent.mm.ao.f.aGI().d((com.tencent.mm.i.g)paramc);
    }
  }
  
  private final com.tencent.mm.plugin.finder.preload.c a(a.b paramb)
  {
    AppMethodBeat.i(203092);
    int i;
    com.tencent.mm.plugin.finder.preload.c localc;
    if (p.i(paramb.slv, "h265"))
    {
      i = 2;
      localc = new com.tencent.mm.plugin.finder.preload.c(paramb.slw);
      localc.fJi = "task_VideoPreloadWorker";
      localc.field_mediaId = paramb.slw.aeA();
      localc.url = (paramb.slw.getUrl() + paramb.slw.cCz());
      localc.field_fullpath = paramb.slw.getPath();
      localc.snsCipherKey = paramb.slw.cCy();
      localc.fJz = 2;
      localc.fJF = 2;
      localc.fJA = 8;
      localc.fJK = paramb.fJK;
      localc.field_preloadRatio = paramb.fJK;
      localc.concurrentCount = d.a.tfM;
      localc.connectionCount = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getMediaPreloadModel().slk;
      localc.fJj = ((g.a)new c(localc.fJK, paramb.preloadMinSize, this.slC, this.slF, paramb.slw));
      localc.fJB = ((g.b)new b(localc.fJK, SystemClock.uptimeMillis(), this.slC, this.slF));
      localc.field_fileType = com.tencent.mm.i.a.fIF;
      localc.preloadMinSize = paramb.preloadMinSize;
      localc.fJM = 0;
      if (!this.slE) {
        break label283;
      }
      localc.field_requestVideoFormat = 0;
      localc.ahE(paramb.dDf);
    }
    for (;;)
    {
      AppMethodBeat.o(203092);
      return localc;
      i = 1;
      break;
      label283:
      localc.field_requestVideoFormat = i;
    }
  }
  
  private final boolean a(bvf parambvf)
  {
    AppMethodBeat.i(203089);
    String str = this.slD;
    parambvf = parambvf.mediaId;
    p.g(parambvf, "media.mediaId");
    boolean bool = n.nA(str, parambvf);
    AppMethodBeat.o(203089);
    return bool;
  }
  
  private final LinkedList<com.tencent.mm.plugin.finder.preload.c> ae(final LinkedList<com.tencent.mm.plugin.finder.preload.c> paramLinkedList)
  {
    AppMethodBeat.i(203093);
    final List localList = j.s((Collection)paramLinkedList);
    final LinkedList localLinkedList1 = new LinkedList();
    final LinkedList localLinkedList2 = ahI(null);
    i("mergePreload", (d.g.a.a)new h(this, paramLinkedList, localLinkedList1, localList, localLinkedList2));
    d((List)paramLinkedList, localList, (List)localLinkedList2);
    AppMethodBeat.o(203093);
    return paramLinkedList;
  }
  
  private final LinkedList<com.tencent.mm.plugin.finder.preload.c> ahI(final String paramString)
  {
    AppMethodBeat.i(203088);
    paramString = (LinkedList)i("cancelWaitingTask", (d.g.a.a)new e(this, paramString));
    AppMethodBeat.o(203088);
    return paramString;
  }
  
  private final LinkedList<com.tencent.mm.plugin.finder.preload.c> b(BaseFinderFeed paramBaseFinderFeed, List<o<al, List<bvf>>> paramList)
  {
    AppMethodBeat.i(203090);
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
      al localal = (al)((o)((Iterator)localObject).next()).first;
      if (((localal instanceof BaseFinderFeed)) && (((BaseFinderFeed)localal).feedObject.getExpectId() == paramBaseFinderFeed.lP()))
      {
        j = 1;
        if (j == 0) {
          break label342;
        }
        j = i;
        if (j < 0) {
          break label408;
        }
        i1 = Math.max(j - this.slG.slf, 0);
        i2 = Math.min(this.slG.slg + j + 1, paramList.size());
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
        j.gfB();
      }
      paramList = (bvf)j.jd((List)((o)paramList).second);
      if (paramList != null)
      {
        if ((paramList.mediaType == 4) && (!a(paramList)))
        {
          int m;
          if (i < j - i1)
          {
            m = i + (i1 - j);
            label241:
            paramList = (Iterable)this.slG.a(paramList, true);
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
              j.gfB();
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
    AppMethodBeat.o(203090);
    return localLinkedList;
  }
  
  private final com.tencent.mm.plugin.finder.preload.c bd(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(203087);
    paramString = (com.tencent.mm.plugin.finder.preload.c)i("cancel", (d.g.a.a)new d(this, paramString, paramBoolean));
    AppMethodBeat.o(203087);
    return paramString;
  }
  
  private final void d(List<com.tencent.mm.plugin.finder.preload.c> paramList1, List<com.tencent.mm.plugin.finder.preload.c> paramList2, List<com.tencent.mm.plugin.finder.preload.c> paramList3)
  {
    AppMethodBeat.i(203095);
    if (paramList1.isEmpty())
    {
      ad.i(this.TAG, "[mergePreload] preloadList is empty!");
      AppMethodBeat.o(203095);
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
    ad.i(this.TAG, localStringBuilder.toString());
    AppMethodBeat.o(203095);
  }
  
  public final void a(BaseFinderFeed paramBaseFinderFeed, List<o<al, List<bvf>>> paramList, int paramInt)
  {
    AppMethodBeat.i(203084);
    p.h(paramBaseFinderFeed, "centerFeed");
    p.h(paramList, "dataList");
    ad.i(this.TAG, "[preload] prevCount=" + this.slG.slf + " nextCount=" + this.slG.slg + " maxPreloadTaskCount=" + this.slG.slj + ' ' + "list=" + paramList.size() + " center=" + paramBaseFinderFeed.cCG() + " source=" + paramInt);
    paramBaseFinderFeed = ((Iterable)ae(b(paramBaseFinderFeed, paramList))).iterator();
    while (paramBaseFinderFeed.hasNext()) {
      a((com.tencent.mm.plugin.finder.preload.c)paramBaseFinderFeed.next());
    }
    AppMethodBeat.o(203084);
  }
  
  public final void bc(final String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(203085);
    p.h(paramString, "mediaId");
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("[onMediaFocus] mediaId=");
    c.a locala = com.tencent.mm.plugin.finder.preload.c.skZ;
    ad.i(str, c.a.ahF(paramString) + " isFocused=" + paramBoolean);
    if (paramBoolean)
    {
      i("onMediaFocus", (d.g.a.a)new j(this, paramString));
      bd(paramString, true);
      cDd();
      AppMethodBeat.o(203085);
      return;
    }
    this.slD = "";
    AppMethodBeat.o(203085);
  }
  
  public final void cDd()
  {
    AppMethodBeat.i(203086);
    i("pollWaiting", (d.g.a.a)new k(this));
    AppMethodBeat.o(203086);
  }
  
  public final <T> T i(String paramString, d.g.a.a<? extends T> parama)
  {
    AppMethodBeat.i(203094);
    long l = SystemClock.uptimeMillis();
    this.slB.lock();
    try
    {
      parama = parama.invoke();
      return parama;
    }
    finally
    {
      this.slB.unlock();
      l = SystemClock.uptimeMillis() - l;
      if (l > 100L) {
        ad.w(this.TAG, "[syncLock] tag=" + paramString + " so slow! cost=" + l + "ms");
      }
      AppMethodBeat.o(203094);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker$Companion;", "", "()V", "ENQUEUE_FAILURE", "", "ENQUEUE_REJECT", "ENQUEUE_SUCCESSFULLY", "plugin-finder_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker$VideoPreloadTaskCallback;", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskPreloadCallback;", "expect", "", "startTick", "", "loadingMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "Lkotlin/collections/HashMap;", "preLoadCallbacks", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mm/plugin/finder/preload/IVideoPreloadCallback;", "(Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;IJLjava/util/HashMap;Ljava/util/concurrent/ConcurrentLinkedQueue;)V", "onPreloadCompleted", "", "mediaId", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "plugin-finder_release"})
  public final class b
    implements g.b
  {
    private final long gkt;
    final HashMap<String, com.tencent.mm.plugin.finder.preload.c> slC;
    private final ConcurrentLinkedQueue<com.tencent.mm.plugin.finder.preload.b> slF;
    private final int slK;
    
    public b(long paramLong, HashMap<String, com.tencent.mm.plugin.finder.preload.c> paramHashMap, ConcurrentLinkedQueue<com.tencent.mm.plugin.finder.preload.b> paramConcurrentLinkedQueue)
    {
      AppMethodBeat.i(203066);
      this.slK = paramLong;
      this.gkt = ???;
      this.slC = paramConcurrentLinkedQueue;
      this.slF = localObject;
      AppMethodBeat.o(203066);
    }
    
    public final void b(final String paramString, com.tencent.mm.i.d paramd)
    {
      AppMethodBeat.i(203065);
      p.h(paramString, "mediaId");
      if ((paramd != null) && (paramd.field_retCode == -21112))
      {
        paramd = ((Iterable)this.slF).iterator();
        while (paramd.hasNext()) {
          ((com.tencent.mm.plugin.finder.preload.b)paramd.next()).ahz(paramString);
        }
        AppMethodBeat.o(203065);
        return;
      }
      if (paramd == null)
      {
        ad.e(b.a(b.this), "[onPreloadCompleted] sceneResult == null");
        AppMethodBeat.o(203065);
        return;
      }
      Object localObject = new long[3];
      CdnLogic.queryDownloadedSize(paramString, (long[])localObject);
      long l1 = Math.max(localObject[0], paramd.field_recvedBytes);
      long l2 = paramd.field_fileLength;
      com.tencent.mm.plugin.finder.preload.c localc = (com.tencent.mm.plugin.finder.preload.c)b.a(b.this, "onPreloadCompleted", (d.g.a.a)new a(this, paramString));
      com.tencent.mm.ao.f.aGI().EQ(paramString);
      if ((l1 > 0L) && (l2 > 0L) && (localc != null))
      {
        localObject = com.tencent.mm.plugin.finder.storage.logic.c.sAv;
        int i;
        if (l2 <= l1)
        {
          i = 3;
          y localy = com.tencent.mm.plugin.finder.storage.logic.c.a(paramString, l1, l2, i);
          String str = paramd.field_videoFlag;
          localObject = str;
          if (str == null) {
            localObject = localc.cDc();
          }
          localy.field_fileFormat = ((String)localObject);
          localObject = com.tencent.mm.plugin.finder.storage.logic.c.sAv;
          com.tencent.mm.plugin.finder.storage.logic.c.aiC(paramString);
          ad.i(b.a(b.this), "[onPreloadCompleted] successfully! mediaId=" + paramString + " startTick=" + this.gkt + " receivedBytes=" + l1 + " fileLength=" + l2 + " expect=" + this.slK + "% result=" + (int)(100.0F * (float)l1 / (float)l2) + "% fileFormat=" + paramd.field_videoFlag + " videoFormat=" + paramd.field_videoFormat);
          paramd = ((Iterable)this.slF).iterator();
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
          ((com.tencent.mm.plugin.finder.preload.b)localObject).a(paramString, bool, d.h.a.co(100.0F * (float)l1 / (float)l2), localc);
          break label367;
          i = 2;
          break;
        }
        label437:
        paramd = com.tencent.mm.ui.component.a.KiD;
        ((FinderVideoRecycler)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderVideoRecycler.class)).ajo(paramString);
        AppMethodBeat.o(203065);
        return;
      }
      ad.e(b.a(b.this), "[onPreloadCompleted] ERROR! mediaId=" + paramString + " startTick=" + this.gkt + " recvedBytes=" + l1 + " fileLength=" + l2 + " fileFormat=" + paramd.field_videoFlag + " videoFormat=" + paramd.field_videoFormat);
      if (localc != null)
      {
        paramd = ((Iterable)this.slF).iterator();
        while (paramd.hasNext()) {
          ((com.tencent.mm.plugin.finder.preload.b)paramd.next()).a(paramString, "onPreloadCompleted error", localc);
        }
      }
      AppMethodBeat.o(203065);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "invoke"})
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker$VideoTaskCallTask;", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "expect", "", "preloadMinSize", "", "loadingMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "Lkotlin/collections/HashMap;", "preLoadCallbacks", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mm/plugin/finder/preload/IVideoPreloadCallback;", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "(Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;IJLjava/util/HashMap;Ljava/util/concurrent/ConcurrentLinkedQueue;Lcom/tencent/mm/plugin/finder/loader/FinderVideo;)V", "getExpect", "()I", "getPreloadMinSize", "()J", "callback", "mediaId", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-finder_release"})
  final class c
    implements g.a
  {
    private final long preloadMinSize;
    private final m rQu;
    final HashMap<String, com.tencent.mm.plugin.finder.preload.c> slC;
    private final ConcurrentLinkedQueue<com.tencent.mm.plugin.finder.preload.b> slF;
    private final int slK;
    
    public c(long paramLong, HashMap<String, com.tencent.mm.plugin.finder.preload.c> paramHashMap, ConcurrentLinkedQueue<com.tencent.mm.plugin.finder.preload.b> paramConcurrentLinkedQueue, m paramm)
    {
      AppMethodBeat.i(203071);
      this.slK = paramLong;
      this.preloadMinSize = ???;
      this.slC = paramConcurrentLinkedQueue;
      this.slF = paramm;
      this.rQu = localObject;
      AppMethodBeat.o(203071);
    }
    
    public final int a(final String paramString, int paramInt, com.tencent.mm.i.c paramc, com.tencent.mm.i.d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(203070);
      p.h(paramString, "mediaId");
      if ((paramd != null) && (paramd.field_retCode == -21112))
      {
        b.a(b.this, "callback#1", (d.g.a.a)new a(this, paramString));
        paramc = ((Iterable)this.slF).iterator();
        while (paramc.hasNext()) {
          ((com.tencent.mm.plugin.finder.preload.b)paramc.next()).ahz(paramString);
        }
        AppMethodBeat.o(203070);
        return -1;
      }
      if ((paramc != null) && (paramc.field_toltalLength > 0L))
      {
        long l1 = paramc.field_finishedLength;
        long l2 = paramc.field_toltalLength;
        if (((int)((float)l1 / (float)l2 * 100.0F) >= this.slK) && (l1 < l2) && (this.preloadMinSize <= l1)) {
          paramInt = 2;
        }
        for (;;)
        {
          paramc = com.tencent.mm.plugin.finder.storage.logic.c.sAv;
          y localy = com.tencent.mm.plugin.finder.storage.logic.c.a(paramString, l1, l2, paramInt);
          if (paramd != null)
          {
            paramd = paramd.field_videoFlag;
            paramc = paramd;
            if (paramd != null) {}
          }
          else
          {
            paramc = ((c)this).rQu.siD.detail;
          }
          localy.field_fileFormat = paramc;
          paramc = com.tencent.mm.plugin.finder.storage.logic.c.sAv;
          com.tencent.mm.plugin.finder.storage.logic.c.aiC(paramString);
          paramc = ((Iterable)this.slF).iterator();
          while (paramc.hasNext()) {
            ((com.tencent.mm.plugin.finder.preload.b)paramc.next()).dk(paramString, d.h.a.co((float)l1 * 100.0F / (float)l2));
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
        ad.e(b.a(b.this), "[VideoTaskCallTask] error! startRet=" + paramInt + " mediaId=" + paramString);
        if (-21006 != paramInt)
        {
          paramc = (com.tencent.mm.plugin.finder.preload.c)b.a(b.this, "callback#2", (d.g.a.a)new b(this, paramString));
          paramd = com.tencent.mm.plugin.finder.storage.logic.c.sAv;
          com.tencent.mm.plugin.finder.storage.logic.c.dt(paramString, -1);
          if (paramc != null)
          {
            paramd = ((Iterable)this.slF).iterator();
            while (paramd.hasNext()) {
              ((com.tencent.mm.plugin.finder.preload.b)paramd.next()).a(paramString, "UPDATE ERROR", paramc);
            }
          }
        }
      }
      AppMethodBeat.o(203070);
      return 0;
    }
    
    public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
    {
      AppMethodBeat.i(203069);
      p.h(paramString, "mediaId");
      AppMethodBeat.o(203069);
    }
    
    public final byte[] f(String paramString, byte[] paramArrayOfByte)
    {
      return new byte[0];
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "invoke"})
    static final class a
      extends q
      implements d.g.a.a<com.tencent.mm.plugin.finder.preload.c>
    {
      a(b.c paramc, String paramString)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "invoke"})
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "invoke"})
  static final class d
    extends q
    implements d.g.a.a<com.tencent.mm.plugin.finder.preload.c>
  {
    d(b paramb, String paramString, boolean paramBoolean)
    {
      super();
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker$cancel$1$1$1", "Lcom/tencent/mm/plugin/thumbplayer/cdn/StopPreloadDownloadCallback;", "onStop", "", "ret", "", "plugin-finder_release"})
    public static final class a
      implements com.tencent.mm.plugin.thumbplayer.b.f
    {
      a(b.d paramd) {}
      
      public final void EI(int paramInt)
      {
        AppMethodBeat.i(203072);
        ad.i(b.a(this.slO.slJ), "preload task on Stop " + this.slO.pAc + ' ' + paramInt);
        b.dl("stopPreload", paramInt);
        AppMethodBeat.o(203072);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "invoke"})
  static final class e
    extends q
    implements d.g.a.a<LinkedList<com.tencent.mm.plugin.finder.preload.c>>
  {
    e(b paramb, String paramString)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "invoke"})
  static final class f
    extends q
    implements d.g.a.b<com.tencent.mm.plugin.finder.preload.c, Boolean>
  {
    f(com.tencent.mm.plugin.finder.preload.c paramc)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker$enqueue$4", "Lcom/tencent/mm/plugin/thumbplayer/cdn/StartPreloadDownloadCallback;", "onStart", "", "ret", "", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "plugin-finder_release"})
  public static final class g
    implements com.tencent.mm.plugin.thumbplayer.b.d
  {
    g(com.tencent.mm.plugin.finder.preload.c paramc) {}
    
    public final void EJ(int paramInt)
    {
      AppMethodBeat.i(203077);
      ad.i(b.a(this.slJ), "preload task on Start " + paramc.field_mediaId + ' ' + paramInt);
      b.dl("startPreload", paramInt);
      AppMethodBeat.o(203077);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements d.g.a.a<z>
  {
    h(b paramb, LinkedList paramLinkedList1, LinkedList paramLinkedList2, List paramList, LinkedList paramLinkedList3)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  public static final class i
    extends q
    implements d.g.a.a<z>
  {
    public i(b paramb, LinkedList paramLinkedList)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class j
    extends q
    implements d.g.a.a<z>
  {
    j(b paramb, String paramString)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class k
    extends q
    implements d.g.a.a<z>
  {
    k(b paramb)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  public static final class l
    extends q
    implements d.g.a.a<Boolean>
  {
    public l(b paramb)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class m
    extends q
    implements d.g.a.a<z>
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