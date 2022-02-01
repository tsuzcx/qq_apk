package com.tencent.mm.plugin.finder.preload.worker;

import android.os.SystemClock;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.g.b;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.loader.aa;
import com.tencent.mm.plugin.finder.loader.t;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.model.av;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.preload.c.a;
import com.tencent.mm.plugin.finder.preload.c.b;
import com.tencent.mm.plugin.finder.preload.d.a;
import com.tencent.mm.plugin.finder.preload.d.b;
import com.tencent.mm.plugin.finder.preload.model.a.b;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.findersdk.a.j.a;
import com.tencent.mm.plugin.thumbplayer.PluginThumbPlayer;
import com.tencent.mm.plugin.thumbplayer.b.a.d;
import com.tencent.mm.protocal.protobuf.csg;
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
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;", "Lcom/tencent/mm/plugin/finder/preload/worker/IPreloadWorker;", "model", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "sceneTag", "", "(Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;Ljava/lang/String;)V", "TAG", "focusedMediaId", "isOpenMultiBitRate", "", "isRelease", "isStop", "Ljava/util/concurrent/atomic/AtomicBoolean;", "loadingMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "Lkotlin/collections/HashMap;", "mainLock", "Ljava/util/concurrent/locks/ReentrantLock;", "preLoadCallbacks", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mm/plugin/finder/preload/IVideoPreloadCallback;", "getPreLoadCallbacks", "()Ljava/util/concurrent/ConcurrentLinkedQueue;", "waitingList", "Ljava/util/LinkedList;", "buildPreloadList", "commentScene", "", "centerFeed", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "dataList", "", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "cancel", "mediaId", "isIgnorePlaying", "cancelWaitingTask", "createPreloadCDNTask", "detail", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel$Detail;", "enqueue", "task", "getPreLoadingCount", "isFocusedMedia", "media", "mergePreload", "preloadList", "needToMerge", "new", "old", "onClearAll", "", "onMediaFocus", "isFocused", "onPreloadStart", "onPreloadStop", "onRelease", "pollWaiting", "preload", "source", "printMergeList", "", "rawList", "removeWaitingList", "resetRunningTask", "showErrToast", "stage", "ret", "syncLock", "T", "tag", "handle", "Lkotlin/Function0;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Companion", "VideoPreloadTaskCallback", "VideoTaskCallTask", "plugin-finder_release"})
public final class b
{
  public static final a zMf;
  private final String TAG;
  public AtomicBoolean fpV;
  private final LinkedList<com.tencent.mm.plugin.finder.preload.d> jTl;
  public boolean kTS;
  private final ReentrantLock zLY;
  private final HashMap<String, com.tencent.mm.plugin.finder.preload.d> zLZ;
  private String zMa;
  private final boolean zMb;
  public final ConcurrentLinkedQueue<com.tencent.mm.plugin.finder.preload.b> zMc;
  private final com.tencent.mm.plugin.finder.preload.model.a zMd;
  private String zMe;
  
  static
  {
    AppMethodBeat.i(282921);
    zMf = new a((byte)0);
    AppMethodBeat.o(282921);
  }
  
  public b(com.tencent.mm.plugin.finder.preload.model.a parama, String paramString)
  {
    AppMethodBeat.i(282919);
    this.zMd = parama;
    this.zMe = paramString;
    this.zLY = new ReentrantLock();
    this.zLZ = new HashMap();
    this.jTl = new LinkedList();
    this.zMa = "";
    parama = com.tencent.mm.plugin.finder.storage.d.AjH;
    this.zMb = com.tencent.mm.plugin.finder.storage.d.dTw();
    this.zMc = new ConcurrentLinkedQueue();
    this.TAG = ("Finder.VideoPreloadWorker_" + this.zMe);
    this.zMc.add(new com.tencent.mm.plugin.finder.preload.b()
    {
      public final void a(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, String paramAnonymousString3, com.tencent.mm.plugin.finder.preload.d paramAnonymousd)
      {
        AppMethodBeat.i(281494);
        p.k(paramAnonymousString1, "mediaId");
        p.k(paramAnonymousString2, "fileFormat");
        p.k(paramAnonymousString3, "codingFormat");
        p.k(paramAnonymousd, "task");
        AppMethodBeat.o(281494);
      }
      
      public final void a(String paramAnonymousString1, String paramAnonymousString2, com.tencent.mm.plugin.finder.preload.d paramAnonymousd)
      {
        AppMethodBeat.i(281497);
        p.k(paramAnonymousString1, "mediaId");
        p.k(paramAnonymousString2, "msg");
        p.k(paramAnonymousd, "task");
        b.g(this.zMg);
        AppMethodBeat.o(281497);
      }
      
      public final void a(String paramAnonymousString, boolean paramAnonymousBoolean, int paramAnonymousInt, com.tencent.mm.plugin.finder.preload.d paramAnonymousd)
      {
        AppMethodBeat.i(281496);
        p.k(paramAnonymousString, "mediaId");
        p.k(paramAnonymousd, "task");
        Object localObject = com.tencent.mm.plugin.finder.storage.logic.d.AnN;
        localObject = com.tencent.mm.plugin.finder.storage.logic.d.aEU(paramAnonymousString);
        if (b.e(this.zMg).zKB)
        {
          c.a locala = com.tencent.mm.plugin.finder.preload.c.zKl;
          if ((!c.a.a((av)localObject).zKm) && (!paramAnonymousBoolean))
          {
            Log.w(b.a(this.zMg), "Moov failure! try to download all! ".concat(String.valueOf(localObject)));
            b.a(this.zMg, paramAnonymousString, false);
            paramAnonymousd.iVi = 100;
            paramAnonymousd.field_preloadRatio = 100;
            b.a(this.zMg, paramAnonymousd);
            AppMethodBeat.o(281496);
            return;
          }
        }
        if ((!((av)localObject).field_moovReady) && (paramAnonymousBoolean))
        {
          localObject = com.tencent.mm.plugin.finder.storage.logic.d.AnN;
          com.tencent.mm.plugin.finder.storage.logic.d.hl(paramAnonymousString, paramAnonymousd.dMH());
        }
        b.g(this.zMg);
        AppMethodBeat.o(281496);
      }
      
      public final void aDB(String paramAnonymousString)
      {
        AppMethodBeat.i(281498);
        p.k(paramAnonymousString, "mediaId");
        Log.e(b.a(this.zMg), "[onFormatChange] mediaId=".concat(String.valueOf(paramAnonymousString)));
        b.a(this.zMg, paramAnonymousString, false);
        com.tencent.mm.plugin.finder.storage.logic.d locald = com.tencent.mm.plugin.finder.storage.logic.d.AnN;
        com.tencent.mm.vfs.u.deleteFile(com.tencent.mm.plugin.finder.storage.logic.d.aEU(paramAnonymousString).getFilePath());
        locald = com.tencent.mm.plugin.finder.storage.logic.d.AnN;
        com.tencent.mm.plugin.finder.storage.logic.d.ee(paramAnonymousString, -2);
        AppMethodBeat.o(281498);
      }
      
      public final void aDC(String paramAnonymousString)
      {
        AppMethodBeat.i(281499);
        p.k(paramAnonymousString, "mediaId");
        Log.e(b.a(this.zMg), "[onReject] mediaId=".concat(String.valueOf(paramAnonymousString)));
        AppMethodBeat.o(281499);
      }
      
      public final void dT(String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(281495);
        p.k(paramAnonymousString, "mediaId");
        AppMethodBeat.o(281495);
      }
    });
    this.fpV = new AtomicBoolean(false);
    AppMethodBeat.o(282919);
  }
  
  private final int a(final com.tencent.mm.plugin.finder.preload.d paramd)
  {
    AppMethodBeat.i(282914);
    this.zLY.lock();
    Object localObject4;
    try
    {
      if (!this.kTS) {
        break label151;
      }
      Log.i(this.TAG, "[enqueue] VideoPreloadWorker has release. " + paramd + " just return.");
      localObject3 = ((Iterable)this.zMc).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (com.tencent.mm.plugin.finder.preload.b)((Iterator)localObject3).next();
        localObject2 = paramd.zuY.ztO.mediaId;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        ((com.tencent.mm.plugin.finder.preload.b)localObject4).aDC((String)localObject1);
      }
      this.zLY.unlock();
    }
    finally
    {
      this.zLY.unlock();
      AppMethodBeat.o(282914);
    }
    AppMethodBeat.o(282914);
    return -1;
    label151:
    if (b(paramd.zuY.ztO))
    {
      Log.i(this.TAG, "[enqueue] is focused task " + paramd + " just return.");
      localObject3 = ((Iterable)this.zMc).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (com.tencent.mm.plugin.finder.preload.b)((Iterator)localObject3).next();
        localObject2 = paramd.zuY.ztO.mediaId;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        ((com.tencent.mm.plugin.finder.preload.b)localObject4).aDC((String)localObject1);
      }
      this.zLY.unlock();
      AppMethodBeat.o(282914);
      return -1;
    }
    Object localObject1 = com.tencent.mm.plugin.finder.storage.logic.d.AnN;
    Object localObject2 = com.tencent.mm.plugin.finder.storage.logic.d.aEU(paramd.zKu);
    Object localObject3 = ((Iterable)this.zMc).iterator();
    String str1;
    int i;
    String str2;
    if (((Iterator)localObject3).hasNext())
    {
      localObject4 = (com.tencent.mm.plugin.finder.preload.b)((Iterator)localObject3).next();
      str1 = ((av)localObject2).field_mediaId;
      p.j(str1, "cache.field_mediaId");
      i = ((av)localObject2).dKP();
      str2 = paramd.dMH();
      if (paramd.field_requestVideoFormat != 1) {
        break label1232;
      }
    }
    label1232:
    for (localObject1 = "H264";; localObject1 = "H265")
    {
      ((com.tencent.mm.plugin.finder.preload.b)localObject4).a(str1, i, str2, (String)localObject1, paramd);
      break;
      boolean bool;
      if (((av)localObject2).dKN())
      {
        Log.i(this.TAG, "[enqueue] " + paramd + " has complete file(" + ((av)localObject2).dKP() + "%)! just return.");
        localObject1 = ((Iterable)this.zMc).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localObject3 = (com.tencent.mm.plugin.finder.preload.b)((Iterator)localObject1).next();
          localObject4 = paramd.zKu;
          if (((av)localObject2).dKP() >= 100) {}
          for (bool = true;; bool = false)
          {
            ((com.tencent.mm.plugin.finder.preload.b)localObject3).a((String)localObject4, bool, ((av)localObject2).dKP(), paramd);
            break;
          }
        }
        this.zLY.unlock();
        AppMethodBeat.o(282914);
        return 1;
      }
      if ((((av)localObject2).dKP() >= paramd.iVi) && (((av)localObject2).field_cacheSize >= paramd.preloadMinSize))
      {
        Log.i(this.TAG, "[enqueue] " + paramd + " has finish preload(" + ((av)localObject2).dKP() + "%)! just return.");
        localObject1 = ((Iterable)this.zMc).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localObject3 = (com.tencent.mm.plugin.finder.preload.b)((Iterator)localObject1).next();
          localObject4 = paramd.zKu;
          if (((av)localObject2).dKP() >= 100) {}
          for (bool = true;; bool = false)
          {
            ((com.tencent.mm.plugin.finder.preload.b)localObject3).a((String)localObject4, bool, ((av)localObject2).dKP(), paramd);
            break;
          }
        }
        this.zLY.unlock();
        AppMethodBeat.o(282914);
        return 1;
      }
      i = this.zLZ.size();
      if ((this.zMd.zKG <= i) || (this.fpV.get()))
      {
        j.c((List)this.jTl, (kotlin.g.a.b)new f(paramd));
        this.jTl.add(paramd);
        paramd.a(d.b.zKz);
        Log.i(this.TAG, "[enqueue] " + paramd + " wait to preLoad, just return. isStop=" + this.fpV + " preLoadingCount=" + i + " waitingSize=" + this.jTl.size());
        this.zLY.unlock();
        AppMethodBeat.o(282914);
        return 1;
      }
      paramd.a(d.b.zKx);
      localObject1 = com.tencent.mm.plugin.finder.storage.logic.d.AnN;
      com.tencent.mm.plugin.finder.storage.logic.d.a(paramd.zKu, paramd.zKv, paramd.zuY.getUrl(), paramd.field_requestVideoFormat, paramd.dMH(), ((av)localObject2).field_cacheSize, ((av)localObject2).field_totalSize, 1, paramd.zuY.ztO.videoDuration, paramd.zuY.ztO.url_token, paramd.zuY.ztO.decodeKey);
      ((Map)this.zLZ).put(paramd.zKu, paramd);
      localObject1 = new com.tencent.mm.plugin.finder.loader.o(paramd.zuY.ztO, com.tencent.mm.plugin.finder.storage.u.Alz);
      localObject2 = t.ztT;
      localObject2 = t.dJe();
      localObject3 = t.ztT;
      ((com.tencent.mm.loader.d)localObject2).a(localObject1, t.a(t.a.ztU)).aRr();
      localObject1 = com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.thumbplayer.a.a.class);
      p.j(localObject1, "MMKernel.plugin(IPluginThumbPlayer::class.java)");
      if (((com.tencent.mm.plugin.thumbplayer.a.a)localObject1).isOpenTPPlayer())
      {
        localObject1 = ((PluginThumbPlayer)com.tencent.mm.kernel.h.ag(PluginThumbPlayer.class)).getCdnTaskController();
        localObject2 = (com.tencent.mm.i.h)paramd;
        localObject3 = (com.tencent.mm.plugin.thumbplayer.b.d)new g(this, paramd);
        p.k(localObject2, "task");
        if (Util.isNullOrNil(((com.tencent.mm.i.h)localObject2).field_mediaId)) {
          Log.e(((com.tencent.mm.plugin.thumbplayer.b.a)localObject1).TAG, "add download task, but task mediaId is null.");
        }
      }
      for (;;)
      {
        Log.i(this.TAG, "[enqueue] begin to preloadVideo... ".concat(String.valueOf(paramd)));
        this.zLY.unlock();
        AppMethodBeat.o(282914);
        return 1;
        Log.i(((com.tencent.mm.plugin.thumbplayer.b.a)localObject1).TAG, "startPreloadDownloadTask: " + ((com.tencent.mm.i.h)localObject2).field_mediaId + " current run tasks " + ((com.tencent.mm.plugin.thumbplayer.b.a)localObject1).MPk.size());
        if (((com.tencent.mm.i.h)localObject2).field_fileId == null) {
          ((com.tencent.mm.i.h)localObject2).field_fileId = "";
        }
        if (((com.tencent.mm.i.h)localObject2).field_aesKey == null) {
          ((com.tencent.mm.i.h)localObject2).field_aesKey = "";
        }
        ((com.tencent.mm.i.h)localObject2).gbt = false;
        com.tencent.mm.ae.d.c("MicroMsg.Cdn.ThreadName", (kotlin.g.a.a)new a.d((com.tencent.mm.plugin.thumbplayer.b.a)localObject1, (com.tencent.mm.i.h)localObject2, (com.tencent.mm.plugin.thumbplayer.b.d)localObject3));
        continue;
        com.tencent.mm.aq.f.bkg().d((com.tencent.mm.i.g)paramd);
      }
    }
  }
  
  private final com.tencent.mm.plugin.finder.preload.d a(a.b paramb)
  {
    boolean bool = true;
    AppMethodBeat.i(282915);
    int i;
    com.tencent.mm.plugin.finder.preload.d locald;
    if (p.h(paramb.zKY, "h265"))
    {
      i = 2;
      locald = new com.tencent.mm.plugin.finder.preload.d(paramb.zBB);
      locald.taskName = "task_VideoPreloadWorker";
      locald.field_mediaId = paramb.zBB.aBv();
      locald.url = (paramb.zBB.getUrl() + paramb.zBB.dIZ());
      locald.field_fullpath = paramb.zBB.getPath();
      locald.snsCipherKey = paramb.zBB.dIY();
      if (paramb.zBB.ztO.hot_flag != 1) {
        break label372;
      }
      label129:
      locald.isHotSnsVideo = bool;
      locald.iUW = 2;
      locald.iVd = 2;
      locald.iUX = 8;
      locald.iVi = paramb.iVi;
      locald.field_preloadRatio = paramb.iVi;
      locald.concurrentCount = j.a.Bvh;
      locald.connectionCount = ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getMediaPreloadModel().zKH;
      locald.iUG = ((com.tencent.mm.i.g.a)new c(locald.iVi, paramb.preloadMinSize, this.zLZ, this.zMc, paramb.zBB));
      locald.iUY = ((g.b)new b(locald.iVi, SystemClock.uptimeMillis(), this.zLZ, this.zMc));
      locald.field_fileType = com.tencent.mm.i.a.iUd;
      locald.preloadMinSize = paramb.preloadMinSize;
      locald.iVk = 0;
      if (!this.zMb) {
        break label377;
      }
      locald.field_requestVideoFormat = 0;
      locald.aDG(paramb.fPD);
    }
    for (;;)
    {
      Log.i(this.TAG, "[createPreloadCDNTask] isHot=" + locald.isHotSnsVideo + " mediaId=" + paramb.zBB.aBv());
      AppMethodBeat.o(282915);
      return locald;
      i = 1;
      break;
      label372:
      bool = false;
      break label129;
      label377:
      locald.field_requestVideoFormat = i;
    }
  }
  
  private final LinkedList<com.tencent.mm.plugin.finder.preload.d> a(int paramInt, FeedData paramFeedData, List<kotlin.o<bu, List<csg>>> paramList)
  {
    AppMethodBeat.i(282913);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramList.iterator();
    int i = 0;
    int j;
    label68:
    label77:
    label98:
    int k;
    label114:
    int i1;
    int i2;
    if (localIterator.hasNext()) {
      if (((bu)((kotlin.o)localIterator.next()).Mx).mf() == paramFeedData.getId())
      {
        j = 1;
        if (j == 0) {
          break label399;
        }
        j = i;
        if (j < 0) {
          break label490;
        }
        if (!paramFeedData.isLongVideo()) {
          break label414;
        }
        i = this.zMd.zKO;
        if (!paramFeedData.isLongVideo()) {
          break label426;
        }
        k = this.zMd.zKP;
        i1 = Math.max(j - i, 0);
        i2 = Math.min(j + k + 1, paramList.size());
        paramFeedData = ((Iterable)paramList.subList(i1, i2)).iterator();
        k = 0;
      }
    }
    for (;;)
    {
      if (!paramFeedData.hasNext()) {
        break label490;
      }
      paramList = paramFeedData.next();
      if (k < 0) {
        j.iBO();
      }
      paramList = (kotlin.o)paramList;
      localIterator = ((Iterable)paramList.My).iterator();
      label271:
      label414:
      label426:
      label479:
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label481;
        }
        Object localObject1 = (csg)localIterator.next();
        if ((((csg)localObject1).mediaType == 4) && (!b((csg)localObject1)))
        {
          int m;
          Object localObject2;
          if (k < j - i1)
          {
            m = i1 - j + k;
            localObject2 = (bu)paramList.Mx;
            localObject1 = (Iterable)this.zMd.a(paramInt, ((bu)localObject2).mf(), (csg)localObject1);
            i = 0;
            localObject1 = ((Iterable)localObject1).iterator();
          }
          for (;;)
          {
            if (!((Iterator)localObject1).hasNext()) {
              break label479;
            }
            localObject2 = ((Iterator)localObject1).next();
            int n = i + 1;
            if (i < 0) {
              j.iBO();
            }
            localObject2 = (a.b)localObject2;
            if (i == 0)
            {
              localObject2 = a((a.b)localObject2);
              ((com.tencent.mm.plugin.finder.preload.d)localObject2).weight = (m + 1000);
              localLinkedList.add(localObject2);
              i = n;
              continue;
              j = 0;
              break label68;
              i += 1;
              break;
              j = -1;
              break label77;
              i = this.zMd.zKC;
              break label98;
              k = this.zMd.zKD;
              break label114;
              m = i2 - i1 - k;
              break label271;
            }
            localObject2 = a((a.b)localObject2);
            ((com.tencent.mm.plugin.finder.preload.d)localObject2).weight = m;
            localLinkedList.add(localObject2);
            i = n;
          }
        }
      }
      label399:
      label481:
      k += 1;
    }
    label490:
    j.lm((List)localLinkedList);
    AppMethodBeat.o(282913);
    return localLinkedList;
  }
  
  private final LinkedList<com.tencent.mm.plugin.finder.preload.d> aDL(final String paramString)
  {
    AppMethodBeat.i(282911);
    paramString = (LinkedList)l("cancelWaitingTask", (kotlin.g.a.a)new e(this, paramString));
    AppMethodBeat.o(282911);
    return paramString;
  }
  
  private final LinkedList<com.tencent.mm.plugin.finder.preload.d> aK(final LinkedList<com.tencent.mm.plugin.finder.preload.d> paramLinkedList)
  {
    AppMethodBeat.i(282916);
    final List localList = j.t((Collection)paramLinkedList);
    final LinkedList localLinkedList1 = new LinkedList();
    final LinkedList localLinkedList2 = aDL(null);
    l("mergePreload", (kotlin.g.a.a)new h(this, paramLinkedList, localLinkedList1, localList, localLinkedList2));
    d((List)paramLinkedList, localList, (List)localLinkedList2);
    AppMethodBeat.o(282916);
    return paramLinkedList;
  }
  
  private final boolean b(csg paramcsg)
  {
    AppMethodBeat.i(282912);
    String str2 = this.zMa;
    String str1 = paramcsg.mediaId;
    paramcsg = str1;
    if (str1 == null) {
      paramcsg = "";
    }
    boolean bool = n.pu(str2, paramcsg);
    AppMethodBeat.o(282912);
    return bool;
  }
  
  private final com.tencent.mm.plugin.finder.preload.d bt(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(282910);
    paramString = (com.tencent.mm.plugin.finder.preload.d)l("cancel", (kotlin.g.a.a)new d(this, paramString, paramBoolean));
    AppMethodBeat.o(282910);
    return paramString;
  }
  
  private final void d(List<com.tencent.mm.plugin.finder.preload.d> paramList1, List<com.tencent.mm.plugin.finder.preload.d> paramList2, List<com.tencent.mm.plugin.finder.preload.d> paramList3)
  {
    AppMethodBeat.i(282918);
    if (paramList1.isEmpty())
    {
      Log.i(this.TAG, "[mergePreload] preloadList is empty!");
      AppMethodBeat.o(282918);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("[mergePreload] -> \n");
    paramList3 = ((Iterable)paramList3).iterator();
    while (paramList3.hasNext())
    {
      com.tencent.mm.plugin.finder.preload.d locald = (com.tencent.mm.plugin.finder.preload.d)paramList3.next();
      localStringBuilder.append("(-) ").append(locald).append("\n");
    }
    paramList2 = ((Iterable)paramList2).iterator();
    while (paramList2.hasNext())
    {
      paramList3 = (com.tencent.mm.plugin.finder.preload.d)paramList2.next();
      if (paramList1.contains(paramList3)) {
        localStringBuilder.append("(+) ").append(paramList3).append("\n");
      } else {
        localStringBuilder.append("(~) ").append(paramList3).append("\n");
      }
    }
    Log.i(this.TAG, localStringBuilder.toString());
    AppMethodBeat.o(282918);
  }
  
  public final void a(int paramInt1, FeedData paramFeedData, List<kotlin.o<bu, List<csg>>> paramList, int paramInt2)
  {
    AppMethodBeat.i(282906);
    p.k(paramFeedData, "centerFeed");
    p.k(paramList, "dataList");
    Log.i(this.TAG, "[preload] commentScene=" + paramInt1 + " prevCount=" + this.zMd.zKC + " nextCount=" + this.zMd.zKD + " maxPreloadTaskCount=" + this.zMd.zKG + ' ' + "list=" + paramList.size() + " center=" + paramFeedData.getId() + " source=" + paramInt2 + ' ' + "isLongVideo=" + paramFeedData.isLongVideo() + " megaVideoPrevCnt=" + this.zMd.zKO + " megaVideoNextCnt=" + this.zMd.zKP);
    paramFeedData = ((Iterable)aK(a(paramInt1, paramFeedData, paramList))).iterator();
    while (paramFeedData.hasNext()) {
      a((com.tencent.mm.plugin.finder.preload.d)paramFeedData.next());
    }
    AppMethodBeat.o(282906);
  }
  
  public final void bs(final String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(282907);
    p.k(paramString, "mediaId");
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("[onMediaFocus] mediaId=");
    d.a locala = com.tencent.mm.plugin.finder.preload.d.zKw;
    Log.i(str, d.a.aDH(paramString) + " isFocused=" + paramBoolean);
    if (paramBoolean)
    {
      l("onMediaFocus", (kotlin.g.a.a)new j(this, paramString));
      bt(paramString, true);
      dMQ();
      AppMethodBeat.o(282907);
      return;
    }
    this.zMa = "";
    AppMethodBeat.o(282907);
  }
  
  public final void dMP()
  {
    AppMethodBeat.i(282908);
    final LinkedList localLinkedList = new LinkedList();
    l("onClearAll", (kotlin.g.a.a)new i(this, localLinkedList));
    Log.i(this.TAG, "[onClearAll] ".concat(String.valueOf(localLinkedList)));
    AppMethodBeat.o(282908);
  }
  
  public final void dMQ()
  {
    AppMethodBeat.i(282909);
    l("pollWaiting", (kotlin.g.a.a)new k(this));
    AppMethodBeat.o(282909);
  }
  
  public final <T> T l(String paramString, kotlin.g.a.a<? extends T> parama)
  {
    AppMethodBeat.i(282917);
    long l = SystemClock.uptimeMillis();
    this.zLY.lock();
    try
    {
      parama = parama.invoke();
      return parama;
    }
    finally
    {
      this.zLY.unlock();
      l = SystemClock.uptimeMillis() - l;
      if (l > 100L) {
        Log.w(this.TAG, "[syncLock] tag=" + paramString + " so slow! cost=" + l + "ms");
      }
      AppMethodBeat.o(282917);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker$Companion;", "", "()V", "ENQUEUE_FAILURE", "", "ENQUEUE_REJECT", "ENQUEUE_SUCCESSFULLY", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker$VideoPreloadTaskCallback;", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskPreloadCallback;", "expect", "", "startTick", "", "loadingMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "Lkotlin/collections/HashMap;", "preLoadCallbacks", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mm/plugin/finder/preload/IVideoPreloadCallback;", "(Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;IJLjava/util/HashMap;Ljava/util/concurrent/ConcurrentLinkedQueue;)V", "onPreloadCompleted", "", "mediaId", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "plugin-finder_release"})
  public final class b
    implements g.b
  {
    private final long jID;
    final HashMap<String, com.tencent.mm.plugin.finder.preload.d> zLZ;
    private final ConcurrentLinkedQueue<com.tencent.mm.plugin.finder.preload.b> zMc;
    private final int zMh;
    
    public b(long paramLong, HashMap<String, com.tencent.mm.plugin.finder.preload.d> paramHashMap, ConcurrentLinkedQueue<com.tencent.mm.plugin.finder.preload.b> paramConcurrentLinkedQueue)
    {
      AppMethodBeat.i(285215);
      this.zMh = paramLong;
      this.jID = ???;
      this.zLZ = paramConcurrentLinkedQueue;
      this.zMc = localObject;
      AppMethodBeat.o(285215);
    }
    
    public final void b(final String paramString, com.tencent.mm.i.d paramd)
    {
      AppMethodBeat.i(285214);
      p.k(paramString, "mediaId");
      if ((paramd != null) && (paramd.field_retCode == -21112))
      {
        paramd = ((Iterable)this.zMc).iterator();
        while (paramd.hasNext()) {
          ((com.tencent.mm.plugin.finder.preload.b)paramd.next()).aDB(paramString);
        }
        AppMethodBeat.o(285214);
        return;
      }
      if (paramd == null)
      {
        Log.e(b.a(b.this), "[onPreloadCompleted] sceneResult == null");
        AppMethodBeat.o(285214);
        return;
      }
      Object localObject = new long[3];
      CdnLogic.queryDownloadedSize(paramString, (long[])localObject);
      long l1 = Math.max(localObject[0], paramd.field_recvedBytes);
      long l2 = paramd.field_fileLength;
      com.tencent.mm.plugin.finder.preload.d locald = (com.tencent.mm.plugin.finder.preload.d)b.a(b.this, "onPreloadCompleted", (kotlin.g.a.a)new a(this, paramString));
      com.tencent.mm.aq.f.bkg().Vz(paramString);
      if ((l1 > 0L) && (l2 > 0L) && (locald != null))
      {
        localObject = com.tencent.mm.plugin.finder.storage.logic.d.AnN;
        int i;
        if (l2 <= l1)
        {
          i = 3;
          av localav = com.tencent.mm.plugin.finder.storage.logic.d.a(paramString, l1, l2, i);
          if (localav.field_reqFormat != paramd.field_videoFormat) {
            localav.field_reqFormat = paramd.field_videoFormat;
          }
          String str = paramd.field_videoFlag;
          localObject = str;
          if (str == null) {
            localObject = locald.dMH();
          }
          localav.field_fileFormat = ((String)localObject);
          localObject = com.tencent.mm.plugin.finder.storage.logic.d.AnN;
          com.tencent.mm.plugin.finder.storage.logic.d.aET(paramString);
          Log.i(b.a(b.this), "[onPreloadCompleted] successfully! mediaId=" + paramString + " startTick=" + this.jID + " receivedBytes=" + l1 + " fileLength=" + l2 + " expect=" + this.zMh + "% result=" + (int)(100.0F * (float)l1 / (float)l2) + "% fileFormat=" + paramd.field_videoFlag + " videoFormat=" + paramd.field_videoFormat);
          paramd = ((Iterable)this.zMc).iterator();
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
          ((com.tencent.mm.plugin.finder.preload.b)localObject).a(paramString, bool, kotlin.h.a.dm(100.0F * (float)l1 / (float)l2), locald);
          break label388;
          i = 2;
          break;
        }
        label458:
        paramd = com.tencent.mm.ui.component.g.Xox;
        ((as)com.tencent.mm.ui.component.g.bD(PluginFinder.class).i(as.class)).aGE(paramString);
        AppMethodBeat.o(285214);
        return;
      }
      Log.e(b.a(b.this), "[onPreloadCompleted] ERROR! mediaId=" + paramString + " startTick=" + this.jID + " recvedBytes=" + l1 + " fileLength=" + l2 + " fileFormat=" + paramd.field_videoFlag + " videoFormat=" + paramd.field_videoFormat);
      if (locald != null)
      {
        paramd = ((Iterable)this.zMc).iterator();
        while (paramd.hasNext()) {
          ((com.tencent.mm.plugin.finder.preload.b)paramd.next()).a(paramString, "onPreloadCompleted error", locald);
        }
      }
      AppMethodBeat.o(285214);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<com.tencent.mm.plugin.finder.preload.d>
    {
      a(b.b paramb, String paramString)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker$VideoTaskCallTask;", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "expect", "", "preloadMinSize", "", "loadingMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "Lkotlin/collections/HashMap;", "preLoadCallbacks", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mm/plugin/finder/preload/IVideoPreloadCallback;", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "(Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;IJLjava/util/HashMap;Ljava/util/concurrent/ConcurrentLinkedQueue;Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;)V", "getExpect", "()I", "getPreloadMinSize", "()J", "callback", "mediaId", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-finder_release"})
  final class c
    implements com.tencent.mm.i.g.a
  {
    private final long preloadMinSize;
    final HashMap<String, com.tencent.mm.plugin.finder.preload.d> zLZ;
    private final ConcurrentLinkedQueue<com.tencent.mm.plugin.finder.preload.b> zMc;
    private final int zMh;
    private final aa zuY;
    
    public c(long paramLong, HashMap<String, com.tencent.mm.plugin.finder.preload.d> paramHashMap, ConcurrentLinkedQueue<com.tencent.mm.plugin.finder.preload.b> paramConcurrentLinkedQueue, aa paramaa)
    {
      AppMethodBeat.i(266115);
      this.zMh = paramLong;
      this.preloadMinSize = ???;
      this.zLZ = paramConcurrentLinkedQueue;
      this.zMc = paramaa;
      this.zuY = localObject;
      AppMethodBeat.o(266115);
    }
    
    public final int a(final String paramString, int paramInt, com.tencent.mm.i.c paramc, com.tencent.mm.i.d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(266114);
      p.k(paramString, "mediaId");
      if ((paramd != null) && (paramd.field_retCode == -21112))
      {
        b.a(b.this, "callback#1", (kotlin.g.a.a)new a(this, paramString));
        paramc = ((Iterable)this.zMc).iterator();
        while (paramc.hasNext()) {
          ((com.tencent.mm.plugin.finder.preload.b)paramc.next()).aDB(paramString);
        }
        AppMethodBeat.o(266114);
        return -1;
      }
      if ((paramc != null) && (paramc.field_toltalLength > 0L))
      {
        long l1 = paramc.field_finishedLength;
        long l2 = paramc.field_toltalLength;
        if (((int)((float)l1 / (float)l2 * 100.0F) >= this.zMh) && (l1 < l2) && (this.preloadMinSize <= l1)) {
          paramInt = 2;
        }
        for (;;)
        {
          paramc = com.tencent.mm.plugin.finder.storage.logic.d.AnN;
          av localav = com.tencent.mm.plugin.finder.storage.logic.d.a(paramString, l1, l2, paramInt);
          if (paramd != null)
          {
            paramd = paramd.field_videoFlag;
            paramc = paramd;
            if (paramd != null) {}
          }
          else
          {
            paramc = ((c)this).zuY.ztP.detail;
          }
          localav.field_fileFormat = paramc;
          paramc = com.tencent.mm.plugin.finder.storage.logic.d.AnN;
          com.tencent.mm.plugin.finder.storage.logic.d.aET(paramString);
          paramc = ((Iterable)this.zMc).iterator();
          while (paramc.hasNext()) {
            ((com.tencent.mm.plugin.finder.preload.b)paramc.next()).dT(paramString, kotlin.h.a.dm((float)l1 * 100.0F / (float)l2));
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
          paramc = (com.tencent.mm.plugin.finder.preload.d)b.a(b.this, "callback#2", (kotlin.g.a.a)new b(this, paramString));
          paramd = com.tencent.mm.plugin.finder.storage.logic.d.AnN;
          com.tencent.mm.plugin.finder.storage.logic.d.ee(paramString, -1);
          if (paramc != null)
          {
            paramd = ((Iterable)this.zMc).iterator();
            while (paramd.hasNext()) {
              ((com.tencent.mm.plugin.finder.preload.b)paramd.next()).a(paramString, "UPDATE ERROR", paramc);
            }
          }
        }
      }
      AppMethodBeat.o(266114);
      return 0;
    }
    
    public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
    {
      AppMethodBeat.i(266113);
      p.k(paramString, "mediaId");
      AppMethodBeat.o(266113);
    }
    
    public final byte[] f(String paramString, byte[] paramArrayOfByte)
    {
      return new byte[0];
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<com.tencent.mm.plugin.finder.preload.d>
    {
      a(b.c paramc, String paramString)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "invoke"})
    static final class b
      extends q
      implements kotlin.g.a.a<com.tencent.mm.plugin.finder.preload.d>
    {
      b(b.c paramc, String paramString)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.preload.d>
  {
    d(b paramb, String paramString, boolean paramBoolean)
    {
      super();
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker$cancel$1$1$1", "Lcom/tencent/mm/plugin/thumbplayer/cdn/StopPreloadDownloadCallback;", "onStop", "", "ret", "", "plugin-finder_release"})
    public static final class a
      implements com.tencent.mm.plugin.thumbplayer.b.f
    {
      a(b.d paramd) {}
      
      public final void OS(int paramInt)
      {
        AppMethodBeat.i(268207);
        Log.i(b.a(this.zMl.zMg), "preload task on Stop " + this.zMl.uzc + ' ' + paramInt);
        AppMethodBeat.o(268207);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<LinkedList<com.tencent.mm.plugin.finder.preload.d>>
  {
    e(b paramb, String paramString)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.b<com.tencent.mm.plugin.finder.preload.d, Boolean>
  {
    f(com.tencent.mm.plugin.finder.preload.d paramd)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker$enqueue$7", "Lcom/tencent/mm/plugin/thumbplayer/cdn/StartPreloadDownloadCallback;", "onStart", "", "ret", "", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "plugin-finder_release"})
  public static final class g
    implements com.tencent.mm.plugin.thumbplayer.b.d
  {
    g(com.tencent.mm.plugin.finder.preload.d paramd) {}
    
    public final void OT(int paramInt)
    {
      AppMethodBeat.i(264017);
      Log.i(b.a(this.zMg), "preload task on Start " + paramd.field_mediaId + ' ' + paramInt);
      AppMethodBeat.o(264017);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<x>
  {
    h(b paramb, LinkedList paramLinkedList1, LinkedList paramLinkedList2, List paramList, LinkedList paramLinkedList3)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.a<x>
  {
    i(b paramb, LinkedList paramLinkedList)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.a<x>
  {
    j(b paramb, String paramString)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class k
    extends q
    implements kotlin.g.a.a<x>
  {
    k(b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  public static final class l
    extends q
    implements kotlin.g.a.a<Boolean>
  {
    public l(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.worker.b
 * JD-Core Version:    0.7.0.1
 */