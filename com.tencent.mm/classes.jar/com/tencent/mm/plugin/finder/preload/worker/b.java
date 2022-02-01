package com.tencent.mm.plugin.finder.preload.worker;

import android.arch.lifecycle.ViewModelProvider;
import android.os.SystemClock;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.g.a;
import com.tencent.mm.i.g.b;
import com.tencent.mm.i.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.loader.k;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.plugin.finder.model.at;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore.a;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore.b;
import com.tencent.mm.plugin.finder.preload.c.a;
import com.tencent.mm.plugin.finder.preload.c.b;
import com.tencent.mm.plugin.finder.preload.model.a.b;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderVideoRecycler;
import com.tencent.mm.plugin.i.a.k.a;
import com.tencent.mm.plugin.thumbplayer.PluginThumbPlayer;
import com.tencent.mm.plugin.thumbplayer.b.a.d;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
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
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.o;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;", "Lcom/tencent/mm/plugin/finder/preload/worker/IPreloadWorker;", "model", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "sceneTag", "", "(Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;Ljava/lang/String;)V", "TAG", "focusedMediaId", "isOpenMultiBitRate", "", "isRelease", "isStop", "Ljava/util/concurrent/atomic/AtomicBoolean;", "loadingMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "Lkotlin/collections/HashMap;", "mainLock", "Ljava/util/concurrent/locks/ReentrantLock;", "preLoadCallbacks", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mm/plugin/finder/preload/IVideoPreloadCallback;", "getPreLoadCallbacks", "()Ljava/util/concurrent/ConcurrentLinkedQueue;", "waitingList", "Ljava/util/LinkedList;", "buildPreloadList", "centerFeed", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "dataList", "", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "cancel", "mediaId", "isIgnorePlaying", "cancelWaitingTask", "createPreloadCDNTask", "detail", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel$Detail;", "enqueue", "", "task", "getPreLoadingCount", "isFocusedMedia", "media", "mergePreload", "preloadList", "needToMerge", "new", "old", "onClearAll", "", "onMediaFocus", "isFocused", "onPreloadStart", "onPreloadStop", "onRelease", "pollWaiting", "preload", "source", "printMergeList", "", "rawList", "removeWaitingList", "resetRunningTask", "showErrToast", "stage", "ret", "syncLock", "T", "tag", "handle", "Lkotlin/Function0;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Companion", "VideoPreloadTaskCallback", "VideoTaskCallTask", "plugin-finder_release"})
public final class b
{
  public static final a uVO;
  public final String TAG;
  public AtomicBoolean dxj;
  private final LinkedList<com.tencent.mm.plugin.finder.preload.c> hhn;
  public boolean ife;
  private final ReentrantLock uVH;
  private final HashMap<String, com.tencent.mm.plugin.finder.preload.c> uVI;
  private String uVJ;
  private final boolean uVK;
  public final ConcurrentLinkedQueue<com.tencent.mm.plugin.finder.preload.b> uVL;
  private final com.tencent.mm.plugin.finder.preload.model.a uVM;
  private String uVN;
  
  static
  {
    AppMethodBeat.i(249653);
    uVO = new a((byte)0);
    AppMethodBeat.o(249653);
  }
  
  public b(com.tencent.mm.plugin.finder.preload.model.a parama, String paramString)
  {
    AppMethodBeat.i(249651);
    this.uVM = parama;
    this.uVN = paramString;
    this.uVH = new ReentrantLock();
    this.uVI = new HashMap();
    this.hhn = new LinkedList();
    this.uVJ = "";
    parama = com.tencent.mm.plugin.finder.storage.c.vCb;
    this.uVK = com.tencent.mm.plugin.finder.storage.c.dsh();
    this.uVL = new ConcurrentLinkedQueue();
    this.TAG = ("Finder.VideoPreloadWorker_" + this.uVN);
    this.uVL.add(new com.tencent.mm.plugin.finder.preload.b()
    {
      public final void a(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, String paramAnonymousString3, com.tencent.mm.plugin.finder.preload.c paramAnonymousc)
      {
        AppMethodBeat.i(249614);
        p.h(paramAnonymousString1, "mediaId");
        p.h(paramAnonymousString2, "fileFormat");
        p.h(paramAnonymousString3, "codingFormat");
        p.h(paramAnonymousc, "task");
        AppMethodBeat.o(249614);
      }
      
      public final void a(String paramAnonymousString1, String paramAnonymousString2, com.tencent.mm.plugin.finder.preload.c paramAnonymousc)
      {
        AppMethodBeat.i(249617);
        p.h(paramAnonymousString1, "mediaId");
        p.h(paramAnonymousString2, "msg");
        p.h(paramAnonymousc, "task");
        b.g(this.uVP);
        AppMethodBeat.o(249617);
      }
      
      public final void a(String paramAnonymousString, boolean paramAnonymousBoolean, int paramAnonymousInt, com.tencent.mm.plugin.finder.preload.c paramAnonymousc)
      {
        AppMethodBeat.i(249616);
        p.h(paramAnonymousString, "mediaId");
        p.h(paramAnonymousc, "task");
        Object localObject = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
        localObject = com.tencent.mm.plugin.finder.storage.logic.d.avH(paramAnonymousString);
        if (b.e(this.uVP).uUl)
        {
          MediaPreloadCore.a locala = MediaPreloadCore.uTV;
          if ((!MediaPreloadCore.a.a((at)localObject).uTW) && (!paramAnonymousBoolean))
          {
            Log.w(b.a(this.uVP), "Moov failure! try to download all! ".concat(String.valueOf(localObject)));
            b.a(this.uVP, paramAnonymousString, false);
            paramAnonymousc.gqZ = 100;
            paramAnonymousc.field_preloadRatio = 100;
            b.a(this.uVP, paramAnonymousc);
            AppMethodBeat.o(249616);
            return;
          }
        }
        if ((!((at)localObject).field_moovReady) && (paramAnonymousBoolean))
        {
          localObject = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
          com.tencent.mm.plugin.finder.storage.logic.d.gU(paramAnonymousString, paramAnonymousc.dlG());
        }
        b.g(this.uVP);
        AppMethodBeat.o(249616);
      }
      
      public final void aum(String paramAnonymousString)
      {
        AppMethodBeat.i(249618);
        p.h(paramAnonymousString, "mediaId");
        Log.e(b.a(this.uVP), "[onFormatChange] mediaId=".concat(String.valueOf(paramAnonymousString)));
        b.a(this.uVP, paramAnonymousString, false);
        com.tencent.mm.plugin.finder.storage.logic.d locald = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
        com.tencent.mm.vfs.s.deleteFile(com.tencent.mm.plugin.finder.storage.logic.d.avH(paramAnonymousString).getFilePath());
        locald = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
        com.tencent.mm.plugin.finder.storage.logic.d.dH(paramAnonymousString, -2);
        AppMethodBeat.o(249618);
      }
      
      public final void dx(String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(249615);
        p.h(paramAnonymousString, "mediaId");
        AppMethodBeat.o(249615);
      }
    });
    this.dxj = new AtomicBoolean(false);
    AppMethodBeat.o(249651);
  }
  
  private final int a(final com.tencent.mm.plugin.finder.preload.c paramc)
  {
    AppMethodBeat.i(249646);
    this.uVH.lock();
    Object localObject4;
    for (;;)
    {
      try
      {
        if (this.ife)
        {
          Log.i(this.TAG, "[enqueue] VideoPreloadWorker has release. " + paramc + " just return.");
          return -1;
        }
        if (c(paramc.tHN.uIw))
        {
          Log.i(this.TAG, "[enqueue] is focused task " + paramc + " just return.");
          return -1;
        }
        localObject1 = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
        localObject2 = com.tencent.mm.plugin.finder.storage.logic.d.avH(paramc.uUe);
        localObject3 = ((Iterable)this.uVL).iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject4 = (com.tencent.mm.plugin.finder.preload.b)((Iterator)localObject3).next();
        String str1 = ((at)localObject2).field_mediaId;
        p.g(str1, "cache.field_mediaId");
        i = ((at)localObject2).dkP();
        String str2 = paramc.dlG();
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
        this.uVH.unlock();
        AppMethodBeat.o(249646);
      }
    }
    boolean bool;
    if (((at)localObject2).dkN())
    {
      Log.i(this.TAG, "[enqueue] " + paramc + " has complete file(" + ((at)localObject2).dkP() + "%)! just return.");
      localObject1 = ((Iterable)this.uVL).iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject3 = (com.tencent.mm.plugin.finder.preload.b)((Iterator)localObject1).next();
        localObject4 = paramc.uUe;
        if (((at)localObject2).dkP() >= 100) {}
        for (bool = true;; bool = false)
        {
          ((com.tencent.mm.plugin.finder.preload.b)localObject3).a((String)localObject4, bool, ((at)localObject2).dkP(), paramc);
          break;
        }
      }
      this.uVH.unlock();
      AppMethodBeat.o(249646);
      return 1;
    }
    if ((((at)localObject2).dkP() >= paramc.gqZ) && (((at)localObject2).field_cacheSize >= paramc.preloadMinSize))
    {
      Log.i(this.TAG, "[enqueue] " + paramc + " has finish preload(" + ((at)localObject2).dkP() + "%)! just return.");
      localObject1 = ((Iterable)this.uVL).iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject3 = (com.tencent.mm.plugin.finder.preload.b)((Iterator)localObject1).next();
        localObject4 = paramc.uUe;
        if (((at)localObject2).dkP() >= 100) {}
        for (bool = true;; bool = false)
        {
          ((com.tencent.mm.plugin.finder.preload.b)localObject3).a((String)localObject4, bool, ((at)localObject2).dkP(), paramc);
          break;
        }
      }
      this.uVH.unlock();
      AppMethodBeat.o(249646);
      return 1;
    }
    int i = this.uVI.size();
    if ((this.uVM.uUq <= i) || (this.dxj.get()))
    {
      j.c((List)this.hhn, (kotlin.g.a.b)new f(paramc));
      this.hhn.add(paramc);
      paramc.a(c.b.uUj);
      Log.i(this.TAG, "[enqueue] " + paramc + " wait to preLoad, just return. isStop=" + this.dxj + " preLoadingCount=" + i + " waitingSize=" + this.hhn.size());
      this.uVH.unlock();
      AppMethodBeat.o(249646);
      return 1;
    }
    paramc.a(c.b.uUh);
    Object localObject1 = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
    com.tencent.mm.plugin.finder.storage.logic.d.a(paramc.uUe, paramc.uUf, paramc.tHN.getUrl(), paramc.field_requestVideoFormat, paramc.dlG(), ((at)localObject2).field_cacheSize, ((at)localObject2).field_totalSize, 1, paramc.tHN.uIw.videoDuration, paramc.tHN.uIw.url_token, paramc.tHN.uIw.decodeKey);
    ((Map)this.uVI).put(paramc.uUe, paramc);
    localObject1 = new k(paramc.tHN.uIw, com.tencent.mm.plugin.finder.storage.x.vEo, null, null, 12);
    Object localObject2 = m.uJa;
    localObject2 = m.djY();
    Object localObject3 = m.uJa;
    ((com.tencent.mm.loader.d)localObject2).a(localObject1, m.a(m.a.uJb)).aJw();
    localObject1 = com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.thumbplayer.a.a.class);
    p.g(localObject1, "MMKernel.plugin(IPluginThumbPlayer::class.java)");
    if (((com.tencent.mm.plugin.thumbplayer.a.a)localObject1).isOpenTPPlayer())
    {
      localObject1 = ((PluginThumbPlayer)com.tencent.mm.kernel.g.ah(PluginThumbPlayer.class)).getCdnTaskController();
      localObject2 = (h)paramc;
      localObject3 = (com.tencent.mm.plugin.thumbplayer.b.d)new g(this, paramc);
      p.h(localObject2, "task");
      if (Util.isNullOrNil(((h)localObject2).field_mediaId)) {
        Log.e(((com.tencent.mm.plugin.thumbplayer.b.a)localObject1).TAG, "add download task, but task mediaId is null.");
      }
    }
    for (;;)
    {
      Log.i(this.TAG, "[enqueue] begin to preloadVideo... ".concat(String.valueOf(paramc)));
      this.uVH.unlock();
      AppMethodBeat.o(249646);
      return 1;
      Log.i(((com.tencent.mm.plugin.thumbplayer.b.a)localObject1).TAG, "startPreloadDownloadTask: " + ((h)localObject2).field_mediaId + " current run tasks " + ((com.tencent.mm.plugin.thumbplayer.b.a)localObject1).Ggv.size());
      if (((h)localObject2).field_fileId == null) {
        ((h)localObject2).field_fileId = "";
      }
      if (((h)localObject2).field_aesKey == null) {
        ((h)localObject2).field_aesKey = "";
      }
      ((h)localObject2).ehd = false;
      com.tencent.mm.ac.d.c("MicroMsg.Cdn.ThreadName", (kotlin.g.a.a)new a.d((com.tencent.mm.plugin.thumbplayer.b.a)localObject1, (h)localObject2, (com.tencent.mm.plugin.thumbplayer.b.d)localObject3));
      continue;
      com.tencent.mm.an.f.baQ().d((com.tencent.mm.i.g)paramc);
    }
  }
  
  private final com.tencent.mm.plugin.finder.preload.c a(a.b paramb)
  {
    AppMethodBeat.i(249647);
    int i;
    com.tencent.mm.plugin.finder.preload.c localc;
    if (p.j(paramb.uUI, "h265"))
    {
      i = 2;
      localc = new com.tencent.mm.plugin.finder.preload.c(paramb.uPf);
      localc.taskName = "task_VideoPreloadWorker";
      localc.field_mediaId = paramb.uPf.auA();
      localc.url = (paramb.uPf.getUrl() + paramb.uPf.djW());
      localc.field_fullpath = paramb.uPf.getPath();
      localc.snsCipherKey = paramb.uPf.djV();
      localc.gqO = 2;
      localc.gqU = 2;
      localc.gqP = 8;
      localc.gqZ = paramb.gqZ;
      localc.field_preloadRatio = paramb.gqZ;
      localc.concurrentCount = k.a.wEc;
      localc.connectionCount = ((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).getMediaPreloadModel().uUr;
      localc.gqy = ((g.a)new c(localc.gqZ, paramb.preloadMinSize, this.uVI, this.uVL, paramb.uPf));
      localc.gqQ = ((g.b)new b(localc.gqZ, SystemClock.uptimeMillis(), this.uVI, this.uVL));
      localc.field_fileType = com.tencent.mm.i.a.gpV;
      localc.preloadMinSize = paramb.preloadMinSize;
      localc.grb = 0;
      if (!this.uVK) {
        break label283;
      }
      localc.field_requestVideoFormat = 0;
      localc.auq(paramb.dVY);
    }
    for (;;)
    {
      AppMethodBeat.o(249647);
      return localc;
      i = 1;
      break;
      label283:
      localc.field_requestVideoFormat = i;
    }
  }
  
  private final LinkedList<com.tencent.mm.plugin.finder.preload.c> as(final LinkedList<com.tencent.mm.plugin.finder.preload.c> paramLinkedList)
  {
    AppMethodBeat.i(249648);
    final List localList = j.v((Collection)paramLinkedList);
    final LinkedList localLinkedList1 = new LinkedList();
    final LinkedList localLinkedList2 = auv(null);
    l("mergePreload", (kotlin.g.a.a)new h(this, paramLinkedList, localLinkedList1, localList, localLinkedList2));
    d((List)paramLinkedList, localList, (List)localLinkedList2);
    AppMethodBeat.o(249648);
    return paramLinkedList;
  }
  
  private final LinkedList<com.tencent.mm.plugin.finder.preload.c> auv(final String paramString)
  {
    AppMethodBeat.i(249643);
    paramString = (LinkedList)l("cancelWaitingTask", (kotlin.g.a.a)new e(this, paramString));
    AppMethodBeat.o(249643);
    return paramString;
  }
  
  private final LinkedList<com.tencent.mm.plugin.finder.preload.c> b(FeedData paramFeedData, List<o<bo, List<cjl>>> paramList)
  {
    AppMethodBeat.i(249645);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramList.iterator();
    int i = 0;
    int j;
    label67:
    label75:
    label95:
    int k;
    label111:
    int i1;
    int i2;
    if (localIterator.hasNext()) {
      if (((bo)((o)localIterator.next()).first).lT() == paramFeedData.getId())
      {
        j = 1;
        if (j == 0) {
          break label394;
        }
        j = i;
        if (j < 0) {
          break label481;
        }
        if (!paramFeedData.isLongVideo()) {
          break label407;
        }
        i = this.uVM.uUy;
        if (!paramFeedData.isLongVideo()) {
          break label418;
        }
        k = this.uVM.uUz;
        i1 = Math.max(j - i, 0);
        i2 = Math.min(j + k + 1, paramList.size());
        paramFeedData = ((Iterable)paramList.subList(i1, i2)).iterator();
        k = 0;
      }
    }
    for (;;)
    {
      if (!paramFeedData.hasNext()) {
        break label481;
      }
      paramList = paramFeedData.next();
      if (k < 0) {
        j.hxH();
      }
      paramList = (o)paramList;
      localIterator = ((Iterable)paramList.second).iterator();
      label267:
      label407:
      label418:
      label470:
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label472;
        }
        Object localObject1 = (cjl)localIterator.next();
        if ((((cjl)localObject1).mediaType == 4) && (!c((cjl)localObject1)))
        {
          int m;
          Object localObject2;
          if (k < j - i1)
          {
            m = i1 - j + k;
            localObject2 = (bo)paramList.first;
            com.tencent.mm.plugin.finder.preload.model.a locala = this.uVM;
            ((bo)localObject2).lT();
            localObject1 = (Iterable)locala.a((cjl)localObject1);
            i = 0;
            localObject1 = ((Iterable)localObject1).iterator();
          }
          for (;;)
          {
            if (!((Iterator)localObject1).hasNext()) {
              break label470;
            }
            localObject2 = ((Iterator)localObject1).next();
            int n = i + 1;
            if (i < 0) {
              j.hxH();
            }
            localObject2 = (a.b)localObject2;
            if (i == 0)
            {
              localObject2 = a((a.b)localObject2);
              ((com.tencent.mm.plugin.finder.preload.c)localObject2).weight = (m + 1000);
              localLinkedList.add(localObject2);
              i = n;
              continue;
              j = 0;
              break label67;
              i += 1;
              break;
              j = -1;
              break label75;
              i = this.uVM.uUm;
              break label95;
              k = this.uVM.uUn;
              break label111;
              m = i2 - i1 - k;
              break label267;
            }
            localObject2 = a((a.b)localObject2);
            ((com.tencent.mm.plugin.finder.preload.c)localObject2).weight = m;
            localLinkedList.add(localObject2);
            i = n;
          }
        }
      }
      label394:
      label472:
      k += 1;
    }
    label481:
    j.sort((List)localLinkedList);
    AppMethodBeat.o(249645);
    return localLinkedList;
  }
  
  private final com.tencent.mm.plugin.finder.preload.c bo(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(249642);
    paramString = (com.tencent.mm.plugin.finder.preload.c)l("cancel", (kotlin.g.a.a)new d(this, paramString, paramBoolean));
    AppMethodBeat.o(249642);
    return paramString;
  }
  
  private final boolean c(cjl paramcjl)
  {
    AppMethodBeat.i(249644);
    String str2 = this.uVJ;
    String str1 = paramcjl.mediaId;
    paramcjl = str1;
    if (str1 == null) {
      paramcjl = "";
    }
    boolean bool = n.K(str2, paramcjl, false);
    AppMethodBeat.o(249644);
    return bool;
  }
  
  private final void d(List<com.tencent.mm.plugin.finder.preload.c> paramList1, List<com.tencent.mm.plugin.finder.preload.c> paramList2, List<com.tencent.mm.plugin.finder.preload.c> paramList3)
  {
    AppMethodBeat.i(249650);
    if (paramList1.isEmpty())
    {
      Log.i(this.TAG, "[mergePreload] preloadList is empty!");
      AppMethodBeat.o(249650);
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
    Log.i(this.TAG, localStringBuilder.toString());
    AppMethodBeat.o(249650);
  }
  
  public final void a(FeedData paramFeedData, List<o<bo, List<cjl>>> paramList, int paramInt)
  {
    AppMethodBeat.i(249639);
    p.h(paramFeedData, "centerFeed");
    p.h(paramList, "dataList");
    Log.i(this.TAG, "[preload] prevCount=" + this.uVM.uUm + " nextCount=" + this.uVM.uUn + " maxPreloadTaskCount=" + this.uVM.uUq + ' ' + "list=" + paramList.size() + " center=" + paramFeedData.getId() + " source=" + paramInt + ' ' + "isLongVideo=" + paramFeedData.isLongVideo() + " megaVideoPrevCnt=" + this.uVM.uUy + " megaVideoNextCnt=" + this.uVM.uUz);
    paramFeedData = ((Iterable)as(b(paramFeedData, paramList))).iterator();
    while (paramFeedData.hasNext()) {
      a((com.tencent.mm.plugin.finder.preload.c)paramFeedData.next());
    }
    AppMethodBeat.o(249639);
  }
  
  public final void bn(final String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(249640);
    p.h(paramString, "mediaId");
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("[onMediaFocus] mediaId=");
    c.a locala = com.tencent.mm.plugin.finder.preload.c.uUg;
    Log.i(str, c.a.aur(paramString) + " isFocused=" + paramBoolean);
    if (paramBoolean)
    {
      l("onMediaFocus", (kotlin.g.a.a)new j(this, paramString));
      bo(paramString, true);
      dlM();
      AppMethodBeat.o(249640);
      return;
    }
    this.uVJ = "";
    AppMethodBeat.o(249640);
  }
  
  public final void dlM()
  {
    AppMethodBeat.i(249641);
    l("pollWaiting", (kotlin.g.a.a)new k(this));
    AppMethodBeat.o(249641);
  }
  
  public final <T> T l(String paramString, kotlin.g.a.a<? extends T> parama)
  {
    AppMethodBeat.i(249649);
    long l = SystemClock.uptimeMillis();
    this.uVH.lock();
    try
    {
      parama = parama.invoke();
      return parama;
    }
    finally
    {
      this.uVH.unlock();
      l = SystemClock.uptimeMillis() - l;
      if (l > 100L) {
        Log.w(this.TAG, "[syncLock] tag=" + paramString + " so slow! cost=" + l + "ms");
      }
      AppMethodBeat.o(249649);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker$Companion;", "", "()V", "ENQUEUE_FAILURE", "", "ENQUEUE_REJECT", "ENQUEUE_SUCCESSFULLY", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker$VideoPreloadTaskCallback;", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskPreloadCallback;", "expect", "", "startTick", "", "loadingMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "Lkotlin/collections/HashMap;", "preLoadCallbacks", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mm/plugin/finder/preload/IVideoPreloadCallback;", "(Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;IJLjava/util/HashMap;Ljava/util/concurrent/ConcurrentLinkedQueue;)V", "onPreloadCompleted", "", "mediaId", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "plugin-finder_release"})
  public final class b
    implements g.b
  {
    private final long gXF;
    final HashMap<String, com.tencent.mm.plugin.finder.preload.c> uVI;
    private final ConcurrentLinkedQueue<com.tencent.mm.plugin.finder.preload.b> uVL;
    private final int uVQ;
    
    public b(long paramLong, HashMap<String, com.tencent.mm.plugin.finder.preload.c> paramHashMap, ConcurrentLinkedQueue<com.tencent.mm.plugin.finder.preload.b> paramConcurrentLinkedQueue)
    {
      AppMethodBeat.i(249621);
      this.uVQ = paramLong;
      this.gXF = ???;
      this.uVI = paramConcurrentLinkedQueue;
      this.uVL = localObject;
      AppMethodBeat.o(249621);
    }
    
    public final void b(final String paramString, com.tencent.mm.i.d paramd)
    {
      AppMethodBeat.i(249620);
      p.h(paramString, "mediaId");
      if ((paramd != null) && (paramd.field_retCode == -21112))
      {
        paramd = ((Iterable)this.uVL).iterator();
        while (paramd.hasNext()) {
          ((com.tencent.mm.plugin.finder.preload.b)paramd.next()).aum(paramString);
        }
        AppMethodBeat.o(249620);
        return;
      }
      if (paramd == null)
      {
        Log.e(b.a(b.this), "[onPreloadCompleted] sceneResult == null");
        AppMethodBeat.o(249620);
        return;
      }
      Object localObject = new long[3];
      CdnLogic.queryDownloadedSize(paramString, (long[])localObject);
      long l1 = Math.max(localObject[0], paramd.field_recvedBytes);
      long l2 = paramd.field_fileLength;
      com.tencent.mm.plugin.finder.preload.c localc = (com.tencent.mm.plugin.finder.preload.c)b.a(b.this, "onPreloadCompleted", (kotlin.g.a.a)new a(this, paramString));
      com.tencent.mm.an.f.baQ().Oc(paramString);
      if ((l1 > 0L) && (l2 > 0L) && (localc != null))
      {
        localObject = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
        int i;
        if (l2 <= l1)
        {
          i = 3;
          at localat = com.tencent.mm.plugin.finder.storage.logic.d.a(paramString, l1, l2, i);
          if (localat.field_reqFormat != paramd.field_videoFormat) {
            localat.field_reqFormat = paramd.field_videoFormat;
          }
          String str = paramd.field_videoFlag;
          localObject = str;
          if (str == null) {
            localObject = localc.dlG();
          }
          localat.field_fileFormat = ((String)localObject);
          localObject = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
          com.tencent.mm.plugin.finder.storage.logic.d.avG(paramString);
          Log.i(b.a(b.this), "[onPreloadCompleted] successfully! mediaId=" + paramString + " startTick=" + this.gXF + " receivedBytes=" + l1 + " fileLength=" + l2 + " expect=" + this.uVQ + "% result=" + (int)(100.0F * (float)l1 / (float)l2) + "% fileFormat=" + paramd.field_videoFlag + " videoFormat=" + paramd.field_videoFormat);
          paramd = ((Iterable)this.uVL).iterator();
          label388:
          if (!paramd.hasNext()) {
            break label458;
          }
          localObject = (com.tencent.mm.plugin.finder.preload.b)paramd.next();
          if (l2 != l1) {
            break label452;
          }
        }
        label452:
        for (boolean bool = true;; bool = false)
        {
          ((com.tencent.mm.plugin.finder.preload.b)localObject).a(paramString, bool, kotlin.h.a.cR(100.0F * (float)l1 / (float)l2), localc);
          break label388;
          i = 2;
          break;
        }
        label458:
        paramd = com.tencent.mm.ui.component.a.PRN;
        ((FinderVideoRecycler)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderVideoRecycler.class)).awV(paramString);
        AppMethodBeat.o(249620);
        return;
      }
      Log.e(b.a(b.this), "[onPreloadCompleted] ERROR! mediaId=" + paramString + " startTick=" + this.gXF + " recvedBytes=" + l1 + " fileLength=" + l2 + " fileFormat=" + paramd.field_videoFlag + " videoFormat=" + paramd.field_videoFormat);
      if (localc != null)
      {
        paramd = ((Iterable)this.uVL).iterator();
        while (paramd.hasNext()) {
          ((com.tencent.mm.plugin.finder.preload.b)paramd.next()).a(paramString, "onPreloadCompleted error", localc);
        }
      }
      AppMethodBeat.o(249620);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<com.tencent.mm.plugin.finder.preload.c>
    {
      a(b.b paramb, String paramString)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker$VideoTaskCallTask;", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "expect", "", "preloadMinSize", "", "loadingMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "Lkotlin/collections/HashMap;", "preLoadCallbacks", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mm/plugin/finder/preload/IVideoPreloadCallback;", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "(Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;IJLjava/util/HashMap;Ljava/util/concurrent/ConcurrentLinkedQueue;Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;)V", "getExpect", "()I", "getPreloadMinSize", "()J", "callback", "mediaId", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-finder_release"})
  final class c
    implements g.a
  {
    private final long preloadMinSize;
    private final com.tencent.mm.plugin.finder.loader.s tHN;
    final HashMap<String, com.tencent.mm.plugin.finder.preload.c> uVI;
    private final ConcurrentLinkedQueue<com.tencent.mm.plugin.finder.preload.b> uVL;
    private final int uVQ;
    
    public c(long paramLong, HashMap<String, com.tencent.mm.plugin.finder.preload.c> paramHashMap, ConcurrentLinkedQueue<com.tencent.mm.plugin.finder.preload.b> paramConcurrentLinkedQueue, com.tencent.mm.plugin.finder.loader.s params)
    {
      AppMethodBeat.i(249626);
      this.uVQ = paramLong;
      this.preloadMinSize = ???;
      this.uVI = paramConcurrentLinkedQueue;
      this.uVL = params;
      this.tHN = localObject;
      AppMethodBeat.o(249626);
    }
    
    public final int a(final String paramString, int paramInt, com.tencent.mm.i.c paramc, com.tencent.mm.i.d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(249625);
      p.h(paramString, "mediaId");
      if ((paramd != null) && (paramd.field_retCode == -21112))
      {
        b.a(b.this, "callback#1", (kotlin.g.a.a)new a(this, paramString));
        paramc = ((Iterable)this.uVL).iterator();
        while (paramc.hasNext()) {
          ((com.tencent.mm.plugin.finder.preload.b)paramc.next()).aum(paramString);
        }
        AppMethodBeat.o(249625);
        return -1;
      }
      if ((paramc != null) && (paramc.field_toltalLength > 0L))
      {
        long l1 = paramc.field_finishedLength;
        long l2 = paramc.field_toltalLength;
        if (((int)((float)l1 / (float)l2 * 100.0F) >= this.uVQ) && (l1 < l2) && (this.preloadMinSize <= l1)) {
          paramInt = 2;
        }
        for (;;)
        {
          paramc = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
          at localat = com.tencent.mm.plugin.finder.storage.logic.d.a(paramString, l1, l2, paramInt);
          if (paramd != null)
          {
            paramd = paramd.field_videoFlag;
            paramc = paramd;
            if (paramd != null) {}
          }
          else
          {
            paramc = ((c)this).tHN.uIx.detail;
          }
          localat.field_fileFormat = paramc;
          paramc = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
          com.tencent.mm.plugin.finder.storage.logic.d.avG(paramString);
          paramc = ((Iterable)this.uVL).iterator();
          while (paramc.hasNext()) {
            ((com.tencent.mm.plugin.finder.preload.b)paramc.next()).dx(paramString, kotlin.h.a.cR((float)l1 * 100.0F / (float)l2));
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
        Log.e(b.a(b.this), "[VideoTaskCallTask] error! startRet=" + paramInt + " mediaId=" + paramString);
        if (-21006 != paramInt)
        {
          paramc = (com.tencent.mm.plugin.finder.preload.c)b.a(b.this, "callback#2", (kotlin.g.a.a)new b(this, paramString));
          paramd = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
          com.tencent.mm.plugin.finder.storage.logic.d.dH(paramString, -1);
          if (paramc != null)
          {
            paramd = ((Iterable)this.uVL).iterator();
            while (paramd.hasNext()) {
              ((com.tencent.mm.plugin.finder.preload.b)paramd.next()).a(paramString, "UPDATE ERROR", paramc);
            }
          }
        }
      }
      AppMethodBeat.o(249625);
      return 0;
    }
    
    public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
    {
      AppMethodBeat.i(249624);
      p.h(paramString, "mediaId");
      AppMethodBeat.o(249624);
    }
    
    public final byte[] f(String paramString, byte[] paramArrayOfByte)
    {
      return new byte[0];
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<com.tencent.mm.plugin.finder.preload.c>
    {
      a(b.c paramc, String paramString)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "invoke"})
    static final class b
      extends q
      implements kotlin.g.a.a<com.tencent.mm.plugin.finder.preload.c>
    {
      b(b.c paramc, String paramString)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.preload.c>
  {
    d(b paramb, String paramString, boolean paramBoolean)
    {
      super();
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker$cancel$1$1$1", "Lcom/tencent/mm/plugin/thumbplayer/cdn/StopPreloadDownloadCallback;", "onStop", "", "ret", "", "plugin-finder_release"})
    public static final class a
      implements com.tencent.mm.plugin.thumbplayer.b.f
    {
      a(b.d paramd) {}
      
      public final void JR(int paramInt)
      {
        AppMethodBeat.i(249627);
        Log.i(b.a(this.uVU.uVP), "preload task on Stop " + this.uVU.qWs + ' ' + paramInt);
        b.dy("stopPreload", paramInt);
        AppMethodBeat.o(249627);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<LinkedList<com.tencent.mm.plugin.finder.preload.c>>
  {
    e(b paramb, String paramString)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.b<com.tencent.mm.plugin.finder.preload.c, Boolean>
  {
    f(com.tencent.mm.plugin.finder.preload.c paramc)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker$enqueue$5", "Lcom/tencent/mm/plugin/thumbplayer/cdn/StartPreloadDownloadCallback;", "onStart", "", "ret", "", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "plugin-finder_release"})
  public static final class g
    implements com.tencent.mm.plugin.thumbplayer.b.d
  {
    g(com.tencent.mm.plugin.finder.preload.c paramc) {}
    
    public final void JS(int paramInt)
    {
      AppMethodBeat.i(249632);
      Log.i(b.a(this.uVP), "preload task on Start " + paramc.field_mediaId + ' ' + paramInt);
      b.dy("startPreload", paramInt);
      AppMethodBeat.o(249632);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<kotlin.x>
  {
    h(b paramb, LinkedList paramLinkedList1, LinkedList paramLinkedList2, List paramList, LinkedList paramLinkedList3)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  public static final class i
    extends q
    implements kotlin.g.a.a<kotlin.x>
  {
    public i(b paramb, LinkedList paramLinkedList)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.a<kotlin.x>
  {
    j(b paramb, String paramString)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class k
    extends q
    implements kotlin.g.a.a<kotlin.x>
  {
    k(b paramb)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  public static final class l
    extends q
    implements kotlin.g.a.a<Boolean>
  {
    public l(b paramb)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class m
    extends q
    implements kotlin.g.a.a<kotlin.x>
  {
    m(String paramString, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.worker.b
 * JD-Core Version:    0.7.0.1
 */