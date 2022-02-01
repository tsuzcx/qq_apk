package com.tencent.mm.plugin.finder.preload.worker;

import android.os.SystemClock;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.az;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.preload.f.a;
import com.tencent.mm.plugin.finder.preload.f.b;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.findersdk.a.k.a;
import com.tencent.mm.plugin.thumbplayer.PluginThumbPlayer;
import com.tencent.mm.plugin.thumbplayer.b.a.d;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.n;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;", "Lcom/tencent/mm/plugin/finder/preload/worker/IPreloadWorker;", "model", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "sceneTag", "", "(Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;Ljava/lang/String;)V", "TAG", "focusedMediaId", "isOpenMultiBitRate", "", "isRelease", "isStop", "Ljava/util/concurrent/atomic/AtomicBoolean;", "loadingMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "Lkotlin/collections/HashMap;", "mainLock", "Ljava/util/concurrent/locks/ReentrantLock;", "preLoadCallbacks", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mm/plugin/finder/preload/IVideoPreloadCallback;", "getPreLoadCallbacks", "()Ljava/util/concurrent/ConcurrentLinkedQueue;", "waitingList", "Ljava/util/LinkedList;", "buildPreloadList", "commentScene", "", "centerFeed", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "dataList", "", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "source", "cancel", "", "mediaId", "isIgnorePlaying", "cancelWaitingTask", "createPreloadCDNTask", "detail", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel$Detail;", "feedId", "", "enqueue", "task", "getPreLoadingCount", "isFocusedMedia", "media", "mergePreload", "preloadList", "needToMerge", "new", "old", "onClearAll", "onMediaFocus", "isFocused", "onPreloadStart", "onPreloadStop", "onRelease", "pollWaiting", "preload", "printMergeList", "", "rawList", "removeWaitingList", "recordPreloadInfo", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "resetRunningTask", "showErrToast", "stage", "ret", "syncLock", "T", "tag", "handle", "Lkotlin/Function0;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Companion", "VideoPreloadTaskCallback", "VideoTaskCallTask", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public class b
{
  public static final b.a EWV;
  private final com.tencent.mm.plugin.finder.preload.model.b EWW;
  private String EWX;
  private final ReentrantLock EWY;
  private final HashMap<String, com.tencent.mm.plugin.finder.preload.g> EWZ;
  private String EXa;
  private final boolean EXb;
  public final ConcurrentLinkedQueue<com.tencent.mm.plugin.finder.preload.e> EXc;
  private final String TAG;
  public AtomicBoolean hue;
  private final LinkedList<com.tencent.mm.plugin.finder.preload.g> mtD;
  public boolean nzB;
  
  static
  {
    AppMethodBeat.i(346467);
    EWV = new b.a((byte)0);
    AppMethodBeat.o(346467);
  }
  
  public b(com.tencent.mm.plugin.finder.preload.model.b paramb, String paramString)
  {
    AppMethodBeat.i(346303);
    this.EWW = paramb;
    this.EWX = paramString;
    this.EWY = new ReentrantLock();
    this.EWZ = new HashMap();
    this.mtD = new LinkedList();
    this.EXa = "";
    paramb = com.tencent.mm.plugin.finder.storage.d.FAy;
    this.EXb = com.tencent.mm.plugin.finder.storage.d.eRL();
    this.EXc = new ConcurrentLinkedQueue();
    this.TAG = s.X("Finder.VideoPreloadWorker_", this.EWX);
    this.EXc.add(new com.tencent.mm.plugin.finder.preload.e()
    {
      public final void B(String paramAnonymousString, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(346297);
        s.u(paramAnonymousString, "mediaId");
        AppMethodBeat.o(346297);
      }
      
      public final void a(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, String paramAnonymousString3, com.tencent.mm.plugin.finder.preload.g paramAnonymousg)
      {
        AppMethodBeat.i(346292);
        s.u(paramAnonymousString1, "mediaId");
        s.u(paramAnonymousString2, "fileFormat");
        s.u(paramAnonymousString3, "codingFormat");
        s.u(paramAnonymousg, "task");
        AppMethodBeat.o(346292);
      }
      
      public final void a(String paramAnonymousString, com.tencent.mm.plugin.finder.preload.g paramAnonymousg)
      {
        AppMethodBeat.i(346322);
        s.u(paramAnonymousString, "mediaId");
        s.u(paramAnonymousg, "task");
        Log.e(b.e(this.EXd), s.X("[onReject] mediaId=", paramAnonymousString));
        AppMethodBeat.o(346322);
      }
      
      public final void a(String paramAnonymousString1, String paramAnonymousString2, com.tencent.mm.plugin.finder.preload.g paramAnonymousg)
      {
        AppMethodBeat.i(346304);
        s.u(paramAnonymousString1, "mediaId");
        s.u(paramAnonymousString2, "msg");
        s.u(paramAnonymousg, "task");
        b.g(this.EXd);
        AppMethodBeat.o(346304);
      }
      
      public final void a(String paramAnonymousString, boolean paramAnonymousBoolean, int paramAnonymousInt, com.tencent.mm.plugin.finder.preload.g paramAnonymousg, long paramAnonymousLong)
      {
        AppMethodBeat.i(346300);
        s.u(paramAnonymousString, "mediaId");
        s.u(paramAnonymousg, "task");
        Object localObject = com.tencent.mm.plugin.finder.storage.logic.e.FNF;
        localObject = com.tencent.mm.plugin.finder.storage.logic.e.aAN(paramAnonymousString);
        if (b.c(this.EXd).EVi)
        {
          f.a locala = com.tencent.mm.plugin.finder.preload.f.EUC;
          if ((!f.a.a((az)localObject).EUK) && (!paramAnonymousBoolean))
          {
            Log.w(b.e(this.EXd), s.X("Moov failure! try to download all! ", localObject));
            b.a(this.EXd, paramAnonymousString, false);
            paramAnonymousg.lxn = 100;
            paramAnonymousg.field_preloadRatio = 100;
            b.a(this.EXd, paramAnonymousg);
            AppMethodBeat.o(346300);
            return;
          }
        }
        if ((!((az)localObject).field_moovReady) && (paramAnonymousBoolean))
        {
          localObject = com.tencent.mm.plugin.finder.storage.logic.e.FNF;
          com.tencent.mm.plugin.finder.storage.logic.e.ig(paramAnonymousString, paramAnonymousg.eHJ());
        }
        b.g(this.EXd);
        AppMethodBeat.o(346300);
      }
      
      public final void azf(String paramAnonymousString)
      {
        AppMethodBeat.i(346313);
        s.u(paramAnonymousString, "mediaId");
        Log.e(b.e(this.EXd), s.X("[onFormatChange] mediaId=", paramAnonymousString));
        b.a(this.EXd, paramAnonymousString, false);
        com.tencent.mm.plugin.finder.storage.logic.e locale = com.tencent.mm.plugin.finder.storage.logic.e.FNF;
        y.deleteFile(com.tencent.mm.plugin.finder.storage.logic.e.aAN(paramAnonymousString).getFilePath());
        locale = com.tencent.mm.plugin.finder.storage.logic.e.FNF;
        com.tencent.mm.plugin.finder.storage.logic.e.eP(paramAnonymousString, -2);
        AppMethodBeat.o(346313);
      }
    });
    this.hue = new AtomicBoolean(false);
    AppMethodBeat.o(346303);
  }
  
  private final int a(final com.tencent.mm.plugin.finder.preload.g paramg)
  {
    AppMethodBeat.i(346365);
    this.EWY.lock();
    Object localObject4;
    try
    {
      if (!this.nzB) {
        break label152;
      }
      Log.i(this.TAG, "[enqueue] VideoPreloadWorker has release. " + paramg + " just return.");
      localObject3 = ((Iterable)this.EXc).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (com.tencent.mm.plugin.finder.preload.e)((Iterator)localObject3).next();
        localObject2 = paramg.EyX.ExE.mediaId;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        ((com.tencent.mm.plugin.finder.preload.e)localObject4).a((String)localObject1, paramg);
      }
      this.EWY.unlock();
    }
    finally
    {
      this.EWY.unlock();
      AppMethodBeat.o(346365);
    }
    AppMethodBeat.o(346365);
    return -1;
    label152:
    if (b(paramg.EyX.ExE))
    {
      Log.i(this.TAG, "[enqueue] is focused task " + paramg + " just return.");
      localObject3 = ((Iterable)this.EXc).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (com.tencent.mm.plugin.finder.preload.e)((Iterator)localObject3).next();
        localObject2 = paramg.EyX.ExE.mediaId;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        ((com.tencent.mm.plugin.finder.preload.e)localObject4).a((String)localObject1, paramg);
      }
      this.EWY.unlock();
      AppMethodBeat.o(346365);
      return -1;
    }
    Object localObject1 = com.tencent.mm.plugin.finder.storage.logic.e.FNF;
    Object localObject2 = com.tencent.mm.plugin.finder.storage.logic.e.aAN(paramg.EUR);
    Object localObject3 = ((Iterable)this.EXc).iterator();
    String str1;
    int i;
    String str2;
    if (((Iterator)localObject3).hasNext())
    {
      localObject4 = (com.tencent.mm.plugin.finder.preload.e)((Iterator)localObject3).next();
      str1 = ((az)localObject2).field_mediaId;
      s.s(str1, "cache.field_mediaId");
      i = ((az)localObject2).eDy();
      str2 = paramg.eHJ();
      if (paramg.field_requestVideoFormat != 1) {
        break label1229;
      }
    }
    label1229:
    for (localObject1 = "H264";; localObject1 = "H265")
    {
      ((com.tencent.mm.plugin.finder.preload.e)localObject4).a(str1, i, str2, (String)localObject1, paramg);
      break;
      boolean bool;
      if (((az)localObject2).eDw())
      {
        Log.i(this.TAG, "[enqueue] " + paramg + " has complete file(" + ((az)localObject2).eDy() + "%)! just return.");
        localObject1 = ((Iterable)this.EXc).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localObject3 = (com.tencent.mm.plugin.finder.preload.e)((Iterator)localObject1).next();
          localObject4 = paramg.EUR;
          if (((az)localObject2).eDy() >= 100) {}
          for (bool = true;; bool = false)
          {
            ((com.tencent.mm.plugin.finder.preload.e)localObject3).a((String)localObject4, bool, ((az)localObject2).eDy(), paramg, ((az)localObject2).field_totalSize);
            break;
          }
        }
        this.EWY.unlock();
        AppMethodBeat.o(346365);
        return 1;
      }
      if ((((az)localObject2).eDy() >= paramg.lxn) && (((az)localObject2).field_cacheSize >= paramg.preloadMinSize))
      {
        Log.i(this.TAG, "[enqueue] " + paramg + " has finish preload(" + ((az)localObject2).eDy() + "%)! just return.");
        localObject1 = ((Iterable)this.EXc).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localObject3 = (com.tencent.mm.plugin.finder.preload.e)((Iterator)localObject1).next();
          localObject4 = paramg.EUR;
          if (((az)localObject2).eDy() >= 100) {}
          for (bool = true;; bool = false)
          {
            ((com.tencent.mm.plugin.finder.preload.e)localObject3).a((String)localObject4, bool, ((az)localObject2).eDy(), paramg, ((az)localObject2).field_cacheSize);
            break;
          }
        }
        this.EWY.unlock();
        AppMethodBeat.o(346365);
        return 1;
      }
      i = this.EWZ.size();
      if ((this.EWW.EVn <= i) || (this.hue.get()))
      {
        kotlin.a.p.e((List)this.mtD, (kotlin.g.a.b)new f(paramg));
        this.mtD.add(paramg);
        paramg.a(com.tencent.mm.plugin.finder.preload.g.b.EUV);
        Log.i(this.TAG, "[enqueue] " + paramg + " wait to preLoad, just return. isStop=" + this.hue + " preLoadingCount=" + i + " waitingSize=" + this.mtD.size());
        this.EWY.unlock();
        AppMethodBeat.o(346365);
        return 1;
      }
      paramg.a(com.tencent.mm.plugin.finder.preload.g.b.EUT);
      localObject1 = com.tencent.mm.plugin.finder.storage.logic.e.FNF;
      com.tencent.mm.plugin.finder.storage.logic.e.a(paramg.EUR, paramg.EUS, paramg.EyX.getUrl(), paramg.field_requestVideoFormat, paramg.eHJ(), ((az)localObject2).field_cacheSize, ((az)localObject2).field_totalSize, 1, paramg.EyX.ExE.videoDuration, paramg.EyX.ExE.url_token, paramg.EyX.ExE.decodeKey);
      ((Map)this.EWZ).put(paramg.EUR, paramg);
      localObject1 = new com.tencent.mm.plugin.finder.loader.k(paramg.EyX.ExE, com.tencent.mm.plugin.finder.storage.v.FKZ);
      localObject2 = com.tencent.mm.plugin.finder.loader.p.ExI;
      localObject2 = com.tencent.mm.plugin.finder.loader.p.eCl();
      localObject3 = com.tencent.mm.plugin.finder.loader.p.ExI;
      ((com.tencent.mm.loader.d)localObject2).a(localObject1, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExJ)).blg();
      if (((com.tencent.mm.plugin.thumbplayer.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.thumbplayer.a.a.class)).isOpenTPPlayer())
      {
        localObject1 = ((PluginThumbPlayer)com.tencent.mm.kernel.h.az(PluginThumbPlayer.class)).getCdnTaskController();
        localObject2 = (com.tencent.mm.g.h)paramg;
        localObject3 = (com.tencent.mm.plugin.thumbplayer.b.d)new g(this, paramg);
        s.u(localObject2, "task");
        if (Util.isNullOrNil(((com.tencent.mm.g.h)localObject2).field_mediaId)) {
          Log.e(((com.tencent.mm.plugin.thumbplayer.b.a)localObject1).TAG, "add download task, but task mediaId is null.");
        }
      }
      for (;;)
      {
        Log.i(this.TAG, s.X("[enqueue] begin to preloadVideo... ", paramg));
        this.EWY.unlock();
        AppMethodBeat.o(346365);
        return 1;
        Log.i(((com.tencent.mm.plugin.thumbplayer.b.a)localObject1).TAG, "startPreloadDownloadTask: " + ((com.tencent.mm.g.h)localObject2).field_mediaId + " current run tasks " + ((com.tencent.mm.plugin.thumbplayer.b.a)localObject1).TBR.size());
        if (((com.tencent.mm.g.h)localObject2).field_fileId == null) {
          ((com.tencent.mm.g.h)localObject2).field_fileId = "";
        }
        if (((com.tencent.mm.g.h)localObject2).field_aesKey == null) {
          ((com.tencent.mm.g.h)localObject2).field_aesKey = "";
        }
        ((com.tencent.mm.g.h)localObject2).ihD = false;
        com.tencent.mm.ae.d.e("MicroMsg.Cdn.ThreadName", (kotlin.g.a.a)new a.d((com.tencent.mm.plugin.thumbplayer.b.a)localObject1, (com.tencent.mm.g.h)localObject2, (com.tencent.mm.plugin.thumbplayer.b.d)localObject3));
        continue;
        com.tencent.mm.modelcdntran.k.bHW().f((com.tencent.mm.g.g)paramg);
      }
    }
  }
  
  private final com.tencent.mm.plugin.finder.preload.g a(com.tencent.mm.plugin.finder.preload.model.b.b paramb, long paramLong)
  {
    AppMethodBeat.i(346374);
    int i;
    com.tencent.mm.plugin.finder.preload.g localg;
    boolean bool;
    if (s.p(paramb.EVK, "h265"))
    {
      i = 2;
      localg = new com.tencent.mm.plugin.finder.preload.g(paramb.EEv);
      localg.feedId = paramLong;
      localg.taskName = "task_VideoPreloadWorker";
      localg.field_mediaId = paramb.EEv.aUt();
      localg.url = s.X(paramb.EEv.getUrl(), paramb.EEv.eCf());
      localg.field_fullpath = paramb.EEv.getPath();
      localg.snsCipherKey = paramb.EEv.eCe();
      if (paramb.EEv.ExE.hot_flag != 1) {
        break label386;
      }
      bool = true;
      label124:
      localg.isHotSnsVideo = bool;
      localg.lxb = 2;
      localg.lxi = 2;
      localg.lxc = 8;
      localg.lxn = paramb.lxn;
      localg.field_preloadRatio = paramb.lxn;
      localg.concurrentCount = k.a.Hcc;
      localg.connectionCount = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getMediaPreloadModel().EVo;
      localg.lwL = ((com.tencent.mm.g.g.a)new c(localg.lxn, paramb.preloadMinSize, this.EWZ, this.EXc, paramb.EEv));
      localg.lxd = ((com.tencent.mm.g.g.b)new b(localg.lxn, SystemClock.uptimeMillis(), this.EWZ, this.EXc));
      localg.field_fileType = com.tencent.mm.g.a.lwi;
      localg.preloadMinSize = paramb.preloadMinSize;
      localg.lxp = 0;
      if (!this.EXb) {
        break label392;
      }
      localg.field_requestVideoFormat = 0;
      localg.azj(paramb.hVy);
    }
    for (;;)
    {
      Log.i(this.TAG, "[createPreloadCDNTask] isHot=" + localg.isHotSnsVideo + " mediaId=" + paramb.EEv.aUt() + " feedId:" + com.tencent.mm.ae.d.hF(localg.feedId));
      AppMethodBeat.o(346374);
      return localg;
      i = 1;
      break;
      label386:
      bool = false;
      break label124;
      label392:
      localg.field_requestVideoFormat = i;
    }
  }
  
  private final LinkedList<com.tencent.mm.plugin.finder.preload.g> azp(final String paramString)
  {
    AppMethodBeat.i(346318);
    paramString = (LinkedList)s("cancelWaitingTask", (kotlin.g.a.a)new e(this, paramString));
    AppMethodBeat.o(346318);
    return paramString;
  }
  
  private final LinkedList<com.tencent.mm.plugin.finder.preload.g> b(int paramInt1, FeedData paramFeedData, List<r<cc, List<dji>>> paramList, int paramInt2)
  {
    AppMethodBeat.i(346337);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramList.iterator();
    int i = 0;
    int j;
    label68:
    label77:
    label98:
    label114:
    int i1;
    int i2;
    if (localIterator.hasNext()) {
      if (((cc)((r)localIterator.next()).bsC).bZA() == paramFeedData.getId())
      {
        j = 1;
        if (j == 0) {
          break label297;
        }
        j = i;
        if (j < 0) {
          break label669;
        }
        if (!paramFeedData.isLongVideo()) {
          break label312;
        }
        i = this.EWW.EVv;
        if (!paramFeedData.isLongVideo()) {
          break label324;
        }
        k = this.EWW.EVw;
        i1 = Math.max(j - i, 0);
        i2 = Math.min(j + k + 1, paramList.size());
        paramFeedData = (Iterable)paramList.subList(i1, i2);
        paramList = (Collection)new ArrayList();
        localIterator = paramFeedData.iterator();
      }
    }
    label176:
    Object localObject1;
    Object localObject2;
    label297:
    label312:
    label324:
    label341:
    label345:
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label347;
      }
      localObject1 = localIterator.next();
      localObject2 = (r)localObject1;
      paramFeedData = ((r)localObject2).bsC;
      if ((paramFeedData instanceof BaseFinderFeed))
      {
        paramFeedData = (BaseFinderFeed)paramFeedData;
        label220:
        if ((paramFeedData == null) || (((BaseFinderFeed)((r)localObject2).bsC).feedObject.isUrlValid())) {
          break label341;
        }
        Log.w(this.TAG, s.X("buildPreloadList feed url is not valid, feedId:", com.tencent.mm.ae.d.hF(((BaseFinderFeed)((r)localObject2).bsC).feedObject.field_id)));
      }
      for (i = 0;; i = 1)
      {
        if (i == 0) {
          break label345;
        }
        paramList.add(localObject1);
        break label176;
        j = 0;
        break label68;
        i += 1;
        break;
        j = -1;
        break label77;
        i = this.EWW.EVj;
        break label98;
        k = this.EWW.EVk;
        break label114;
        paramFeedData = null;
        break label220;
      }
    }
    label347:
    paramFeedData = ((Iterable)paramList).iterator();
    int k = 0;
    while (paramFeedData.hasNext())
    {
      paramList = paramFeedData.next();
      if (k < 0) {
        kotlin.a.p.kkW();
      }
      paramList = (r)paramList;
      localIterator = ((Iterable)paramList.bsD).iterator();
      label658:
      while (localIterator.hasNext())
      {
        localObject2 = (dji)localIterator.next();
        if ((((dji)localObject2).mediaType == 4) && (!b((dji)localObject2)))
        {
          int m;
          if (k < j - i1)
          {
            m = i1 - j + k;
            localObject1 = (cc)paramList.bsC;
            localObject2 = (Iterable)this.EWW.a(paramInt1, ((cc)localObject1).bZA(), (dji)localObject2, paramInt2);
            i = 0;
            localObject2 = ((Iterable)localObject2).iterator();
          }
          for (;;)
          {
            if (!((Iterator)localObject2).hasNext()) {
              break label658;
            }
            Object localObject3 = ((Iterator)localObject2).next();
            int n = i + 1;
            if (i < 0) {
              kotlin.a.p.kkW();
            }
            localObject3 = (com.tencent.mm.plugin.finder.preload.model.b.b)localObject3;
            if (i == 0)
            {
              localObject3 = a((com.tencent.mm.plugin.finder.preload.model.b.b)localObject3, ((cc)localObject1).bZA());
              ((com.tencent.mm.plugin.finder.preload.g)localObject3).weight = (m + 1000);
              localah = ah.aiuX;
              localLinkedList.add(localObject3);
              i = n;
              continue;
              m = i2 - i1 - k;
              break;
            }
            localObject3 = a((com.tencent.mm.plugin.finder.preload.model.b.b)localObject3, ((cc)localObject1).bZA());
            ((com.tencent.mm.plugin.finder.preload.g)localObject3).weight = m;
            ah localah = ah.aiuX;
            localLinkedList.add(localObject3);
            i = n;
          }
        }
      }
      k += 1;
    }
    label669:
    kotlin.a.p.N((List)localLinkedList);
    AppMethodBeat.o(346337);
    return localLinkedList;
  }
  
  private final boolean b(dji paramdji)
  {
    AppMethodBeat.i(346325);
    String str2 = this.EXa;
    String str1 = paramdji.mediaId;
    paramdji = str1;
    if (str1 == null) {
      paramdji = "";
    }
    boolean bool = n.rs(str2, paramdji);
    AppMethodBeat.o(346325);
    return bool;
  }
  
  private final void d(List<com.tencent.mm.plugin.finder.preload.g> paramList1, List<com.tencent.mm.plugin.finder.preload.g> paramList2, List<com.tencent.mm.plugin.finder.preload.g> paramList3)
  {
    AppMethodBeat.i(346383);
    if (paramList1.isEmpty())
    {
      Log.i(this.TAG, "[mergePreload] preloadList is empty!");
      AppMethodBeat.o(346383);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("[mergePreload] -> \n");
    paramList3 = ((Iterable)paramList3).iterator();
    while (paramList3.hasNext())
    {
      com.tencent.mm.plugin.finder.preload.g localg = (com.tencent.mm.plugin.finder.preload.g)paramList3.next();
      localStringBuilder.append("(-) ").append(localg).append("\n");
    }
    paramList2 = ((Iterable)paramList2).iterator();
    while (paramList2.hasNext())
    {
      paramList3 = (com.tencent.mm.plugin.finder.preload.g)paramList2.next();
      if (paramList1.contains(paramList3)) {
        localStringBuilder.append("(+) ").append(paramList3).append("\n");
      } else {
        localStringBuilder.append("(~) ").append(paramList3).append("\n");
      }
    }
    Log.i(this.TAG, localStringBuilder.toString());
    AppMethodBeat.o(346383);
  }
  
  public final void a(int paramInt1, FeedData paramFeedData, List<r<cc, List<dji>>> paramList, int paramInt2)
  {
    AppMethodBeat.i(346474);
    s.u(paramFeedData, "centerFeed");
    s.u(paramList, "dataList");
    Log.i(this.TAG, "[preload] commentScene=" + paramInt1 + " prevCount=" + this.EWW.EVj + " nextCount=" + this.EWW.EVk + " maxPreloadTaskCount=" + this.EWW.EVn + " list=" + paramList.size() + " center=" + paramFeedData.getId() + " source=" + paramInt2 + " isLongVideo=" + paramFeedData.isLongVideo() + " megaVideoPrevCnt=" + this.EWW.EVv + " megaVideoNextCnt=" + this.EWW.EVw);
    paramFeedData = ((Iterable)aR(b(paramInt1, paramFeedData, paramList, paramInt2))).iterator();
    while (paramFeedData.hasNext()) {
      a((com.tencent.mm.plugin.finder.preload.g)paramFeedData.next());
    }
    AppMethodBeat.o(346474);
  }
  
  public LinkedList<com.tencent.mm.plugin.finder.preload.g> aR(LinkedList<com.tencent.mm.plugin.finder.preload.g> paramLinkedList)
  {
    AppMethodBeat.i(346502);
    s.u(paramLinkedList, "preloadList");
    List localList = kotlin.a.p.J((Collection)paramLinkedList);
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = azp(null);
    s("mergePreload", (kotlin.g.a.a)new b.h(paramLinkedList, this, localList, localLinkedList1, localLinkedList2));
    d((List)paramLinkedList, localList, (List)localLinkedList2);
    AppMethodBeat.o(346502);
    return paramLinkedList;
  }
  
  public final void bJ(final String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(346480);
    s.u(paramString, "mediaId");
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("[onMediaFocus] mediaId=");
    com.tencent.mm.plugin.finder.preload.g.a locala = com.tencent.mm.plugin.finder.preload.g.EUP;
    Log.i(str, com.tencent.mm.plugin.finder.preload.g.a.azk(paramString) + " isFocused=" + paramBoolean);
    if (paramBoolean)
    {
      s("onMediaFocus", (kotlin.g.a.a)new j(this, paramString));
      bK(paramString, true);
      eHV();
      AppMethodBeat.o(346480);
      return;
    }
    this.EXa = "";
    AppMethodBeat.o(346480);
  }
  
  public final com.tencent.mm.plugin.finder.preload.g bK(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(346495);
    paramString = (com.tencent.mm.plugin.finder.preload.g)s("cancel", (kotlin.g.a.a)new d(this, paramString, paramBoolean));
    AppMethodBeat.o(346495);
    return paramString;
  }
  
  public final void eHU()
  {
    AppMethodBeat.i(346484);
    LinkedList localLinkedList = new LinkedList();
    s("onClearAll", (kotlin.g.a.a)new i(localLinkedList, this));
    Log.i(this.TAG, s.X("[onClearAll] ", localLinkedList));
    AppMethodBeat.o(346484);
  }
  
  public final void eHV()
  {
    AppMethodBeat.i(346490);
    s("pollWaiting", (kotlin.g.a.a)new k(this));
    AppMethodBeat.o(346490);
  }
  
  public final <T> T s(String paramString, kotlin.g.a.a<? extends T> parama)
  {
    AppMethodBeat.i(346507);
    long l = SystemClock.uptimeMillis();
    this.EWY.lock();
    try
    {
      parama = parama.invoke();
      return parama;
    }
    finally
    {
      this.EWY.unlock();
      l = SystemClock.uptimeMillis() - l;
      if (l > 100L) {
        Log.w(this.TAG, "[syncLock] tag=" + paramString + " so slow! cost=" + l + "ms");
      }
      AppMethodBeat.o(346507);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker$VideoPreloadTaskCallback;", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskPreloadCallback;", "expect", "", "startTick", "", "loadingMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "Lkotlin/collections/HashMap;", "preLoadCallbacks", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mm/plugin/finder/preload/IVideoPreloadCallback;", "(Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;IJLjava/util/HashMap;Ljava/util/concurrent/ConcurrentLinkedQueue;)V", "onPreloadCompleted", "", "mediaId", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    implements com.tencent.mm.g.g.b
  {
    final HashMap<String, com.tencent.mm.plugin.finder.preload.g> EWZ;
    private final ConcurrentLinkedQueue<com.tencent.mm.plugin.finder.preload.e> EXc;
    private final int EXe;
    private final long moe;
    
    public b(long paramLong, HashMap<String, com.tencent.mm.plugin.finder.preload.g> paramHashMap, ConcurrentLinkedQueue<com.tencent.mm.plugin.finder.preload.e> paramConcurrentLinkedQueue)
    {
      AppMethodBeat.i(346277);
      this.EXe = paramLong;
      this.moe = ???;
      this.EWZ = paramConcurrentLinkedQueue;
      this.EXc = localObject;
      AppMethodBeat.o(346277);
    }
    
    public final void b(final String paramString, com.tencent.mm.g.d paramd)
    {
      AppMethodBeat.i(346296);
      s.u(paramString, "mediaId");
      int i;
      if ((paramd != null) && (paramd.field_retCode == -21112)) {
        i = 1;
      }
      while (i != 0)
      {
        paramd = ((Iterable)this.EXc).iterator();
        for (;;)
        {
          if (paramd.hasNext())
          {
            ((com.tencent.mm.plugin.finder.preload.e)paramd.next()).azf(paramString);
            continue;
            i = 0;
            break;
          }
        }
        AppMethodBeat.o(346296);
        return;
      }
      if (paramd == null)
      {
        Log.e(b.e(b.this), "[onPreloadCompleted] sceneResult == null");
        paramd = (com.tencent.mm.plugin.finder.preload.g)b.a(b.this, "onPreloadCompleted", (kotlin.g.a.a)new a(this, paramString));
        if (paramd != null)
        {
          localObject1 = ((Iterable)this.EXc).iterator();
          while (((Iterator)localObject1).hasNext()) {
            ((com.tencent.mm.plugin.finder.preload.e)((Iterator)localObject1).next()).a(paramString, "onPreloadCompleted sceneResult null error", paramd);
          }
        }
        AppMethodBeat.o(346296);
        return;
      }
      Object localObject1 = new long[3];
      CdnLogic.queryDownloadedSize(paramString, (long[])localObject1);
      long l1 = Math.max(localObject1[0], paramd.field_recvedBytes);
      long l2 = paramd.field_fileLength;
      com.tencent.mm.plugin.finder.preload.g localg = (com.tencent.mm.plugin.finder.preload.g)b.a(b.this, "onPreloadCompleted", (kotlin.g.a.a)new b.b.b(this, paramString));
      com.tencent.mm.modelcdntran.k.bHW().Nz(paramString);
      if ((l1 > 0L) && (l2 > 0L) && (localg != null))
      {
        localObject1 = com.tencent.mm.plugin.finder.storage.logic.e.FNF;
        Object localObject2;
        if (l2 <= l1)
        {
          i = 3;
          az localaz = com.tencent.mm.plugin.finder.storage.logic.e.a(paramString, l1, l2, i);
          if (localaz.field_reqFormat != paramd.field_videoFormat) {
            localaz.field_reqFormat = paramd.field_videoFormat;
          }
          localObject2 = paramd.field_videoFlag;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = localg.eHJ();
          }
          localaz.field_fileFormat = ((String)localObject1);
          localObject1 = com.tencent.mm.plugin.finder.storage.logic.e.FNF;
          com.tencent.mm.plugin.finder.storage.logic.e.aAM(paramString);
          Log.i(b.e(b.this), "[onPreloadCompleted] successfully! mediaId=" + paramString + " startTick=" + this.moe + " receivedBytes=" + l1 + " fileLength=" + l2 + " expect=" + this.EXe + "% result=" + (int)(100.0F * (float)l1 / (float)l2) + "% fileFormat=" + paramd.field_videoFlag + " videoFormat=" + paramd.field_videoFormat);
          localObject1 = ((Iterable)this.EXc).iterator();
          label475:
          if (!((Iterator)localObject1).hasNext()) {
            break label549;
          }
          localObject2 = (com.tencent.mm.plugin.finder.preload.e)((Iterator)localObject1).next();
          if (l2 != l1) {
            break label543;
          }
        }
        label543:
        for (boolean bool = true;; bool = false)
        {
          ((com.tencent.mm.plugin.finder.preload.e)localObject2).a(paramString, bool, kotlin.h.a.eH(100.0F * (float)l1 / (float)l2), localg, l1);
          break label475;
          i = 2;
          break;
        }
        label549:
        b.a(localg, paramd);
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new c(paramString));
        AppMethodBeat.o(346296);
        return;
      }
      Log.e(b.e(b.this), "[onPreloadCompleted] ERROR! mediaId=" + paramString + " startTick=" + this.moe + " recvedBytes=" + l1 + " fileLength=" + l2 + " fileFormat=" + paramd.field_videoFlag + " videoFormat=" + paramd.field_videoFormat);
      if (localg != null)
      {
        paramd = ((Iterable)this.EXc).iterator();
        while (paramd.hasNext()) {
          ((com.tencent.mm.plugin.finder.preload.e)paramd.next()).a(paramString, "onPreloadCompleted error", localg);
        }
      }
      AppMethodBeat.o(346296);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<com.tencent.mm.plugin.finder.preload.g>
    {
      a(b.b paramb, String paramString)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class c
      extends u
      implements kotlin.g.a.a<ah>
    {
      c(String paramString)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker$VideoTaskCallTask;", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "expect", "", "preloadMinSize", "", "loadingMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "Lkotlin/collections/HashMap;", "preLoadCallbacks", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mm/plugin/finder/preload/IVideoPreloadCallback;", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "(Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;IJLjava/util/HashMap;Ljava/util/concurrent/ConcurrentLinkedQueue;Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;)V", "getExpect", "()I", "getPreloadMinSize", "()J", "callback", "mediaId", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  final class c
    implements com.tencent.mm.g.g.a
  {
    final HashMap<String, com.tencent.mm.plugin.finder.preload.g> EWZ;
    private final ConcurrentLinkedQueue<com.tencent.mm.plugin.finder.preload.e> EXc;
    private final int EXe;
    private final com.tencent.mm.plugin.finder.loader.v EyX;
    private final long preloadMinSize;
    
    public c(long paramLong, HashMap<String, com.tencent.mm.plugin.finder.preload.g> paramHashMap, ConcurrentLinkedQueue<com.tencent.mm.plugin.finder.preload.e> paramConcurrentLinkedQueue, com.tencent.mm.plugin.finder.loader.v paramv)
    {
      AppMethodBeat.i(346294);
      this.EXe = paramLong;
      this.preloadMinSize = ???;
      this.EWZ = paramConcurrentLinkedQueue;
      this.EXc = paramv;
      this.EyX = localObject;
      AppMethodBeat.o(346294);
    }
    
    public final int a(final String paramString, int paramInt, c paramc, com.tencent.mm.g.d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(346327);
      s.u(paramString, "mediaId");
      int i;
      if ((paramd != null) && (paramd.field_retCode == -21112)) {
        i = 1;
      }
      while (i != 0)
      {
        b.a(b.this, "callback#1", (kotlin.g.a.a)new a(this, paramString));
        paramc = ((Iterable)this.EXc).iterator();
        for (;;)
        {
          if (paramc.hasNext())
          {
            ((com.tencent.mm.plugin.finder.preload.e)paramc.next()).azf(paramString);
            continue;
            i = 0;
            break;
          }
        }
        AppMethodBeat.o(346327);
        return -1;
      }
      if ((paramc != null) && (paramc.field_toltalLength > 0L))
      {
        long l1 = paramc.field_finishedLength;
        long l2 = paramc.field_toltalLength;
        az localaz;
        if (((int)((float)l1 / (float)l2 * 100.0F) >= this.EXe) && (l1 < l2) && (this.preloadMinSize <= l1))
        {
          paramInt = 2;
          paramc = com.tencent.mm.plugin.finder.storage.logic.e.FNF;
          localaz = com.tencent.mm.plugin.finder.storage.logic.e.a(paramString, l1, l2, paramInt);
          if (paramd != null) {
            break label305;
          }
        }
        label305:
        for (paramc = null;; paramc = paramd.field_videoFlag)
        {
          paramd = paramc;
          if (paramc == null) {
            paramd = ((c)this).EyX.ExF.detail;
          }
          localaz.field_fileFormat = paramd;
          paramc = com.tencent.mm.plugin.finder.storage.logic.e.FNF;
          com.tencent.mm.plugin.finder.storage.logic.e.aAM(paramString);
          paramc = ((Iterable)this.EXc).iterator();
          while (paramc.hasNext()) {
            ((com.tencent.mm.plugin.finder.preload.e)paramc.next()).B(paramString, kotlin.h.a.eH(100.0F * (float)l1 / (float)l2), l1);
          }
          if (l1 >= l2)
          {
            paramInt = 3;
            break;
          }
          paramInt = 1;
          break;
        }
      }
      if (paramInt != 0)
      {
        Log.e(b.e(b.this), "[VideoTaskCallTask] error! startRet=" + paramInt + " mediaId=" + paramString);
        if (-21006 != paramInt)
        {
          paramc = (com.tencent.mm.plugin.finder.preload.g)b.a(b.this, "callback#2", (kotlin.g.a.a)new b.c.b(this, paramString));
          paramd = com.tencent.mm.plugin.finder.storage.logic.e.FNF;
          com.tencent.mm.plugin.finder.storage.logic.e.eP(paramString, -1);
          if (paramc != null)
          {
            paramd = ((Iterable)this.EXc).iterator();
            while (paramd.hasNext()) {
              ((com.tencent.mm.plugin.finder.preload.e)paramd.next()).a(paramString, "UPDATE ERROR", paramc);
            }
          }
        }
      }
      AppMethodBeat.o(346327);
      return 0;
    }
    
    public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
    {
      AppMethodBeat.i(346298);
      s.u(paramString, "mediaId");
      AppMethodBeat.o(346298);
    }
    
    public final byte[] h(String paramString, byte[] paramArrayOfByte)
    {
      return new byte[0];
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<com.tencent.mm.plugin.finder.preload.g>
    {
      a(b.c paramc, String paramString)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.preload.g>
  {
    d(b paramb, String paramString, boolean paramBoolean)
    {
      super();
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker$cancel$1$1$1", "Lcom/tencent/mm/plugin/thumbplayer/cdn/StopPreloadDownloadCallback;", "onStop", "", "ret", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements com.tencent.mm.plugin.thumbplayer.b.f
    {
      a(b paramb, String paramString) {}
      
      public final void Ru(int paramInt)
      {
        AppMethodBeat.i(346289);
        Log.i(b.e(this.EXd), "preload task on Stop " + this.mrQ + ' ' + paramInt);
        AppMethodBeat.o(346289);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<LinkedList<com.tencent.mm.plugin.finder.preload.g>>
  {
    e(b paramb, String paramString)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.b<com.tencent.mm.plugin.finder.preload.g, Boolean>
  {
    f(com.tencent.mm.plugin.finder.preload.g paramg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker$enqueue$7", "Lcom/tencent/mm/plugin/thumbplayer/cdn/StartPreloadDownloadCallback;", "onStart", "", "ret", "", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements com.tencent.mm.plugin.thumbplayer.b.d
  {
    g(b paramb, com.tencent.mm.plugin.finder.preload.g paramg) {}
    
    public final void Rv(int paramInt)
    {
      AppMethodBeat.i(346272);
      Log.i(b.e(this.EXd), "preload task on Start " + paramg.field_mediaId + ' ' + paramInt);
      if ((paramInt < 0) && ((com.tencent.mm.plugin.finder.preload.g)b.a(this.EXd, "onPreloadCompleted", (kotlin.g.a.a)new a(this.EXd, paramg)) != null))
      {
        Object localObject = this.EXd;
        com.tencent.mm.plugin.finder.preload.g localg = paramg;
        localObject = ((Iterable)((b)localObject).EXc).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((com.tencent.mm.plugin.finder.preload.e)((Iterator)localObject).next()).a(localg.EUR, "onPreloadCompleted start ret=" + paramInt + " error", localg);
        }
      }
      AppMethodBeat.o(346272);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<com.tencent.mm.plugin.finder.preload.g>
    {
      a(b paramb, com.tencent.mm.plugin.finder.preload.g paramg)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<ah>
  {
    i(LinkedList<com.tencent.mm.plugin.finder.preload.g> paramLinkedList, b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<ah>
  {
    j(b paramb, String paramString)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends u
    implements kotlin.g.a.a<ah>
  {
    k(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class l
    extends u
    implements kotlin.g.a.a<Boolean>
  {
    public l(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.worker.b
 * JD-Core Version:    0.7.0.1
 */