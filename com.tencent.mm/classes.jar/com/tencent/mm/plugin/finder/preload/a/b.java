package com.tencent.mm.plugin.finder.preload.a;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.g;
import com.tencent.mm.i.g.a;
import com.tencent.mm.i.g.b;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.r;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore.a;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore.b;
import com.tencent.mm.plugin.finder.preload.c.a;
import com.tencent.mm.plugin.finder.preload.c.b;
import com.tencent.mm.plugin.finder.preload.model.a.b;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.i.a.l.a;
import com.tencent.mm.protocal.protobuf.bmd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.i;
import d.a.j;
import d.g.b.k;
import d.n.n;
import d.o;
import d.y;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.ReentrantLock;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;", "Lcom/tencent/mm/plugin/finder/preload/worker/IPreloadWorker;", "model", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "(Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;)V", "TAG", "", "focusedMediaId", "isOpenMultiBitRateDownload", "", "isRelease", "isStop", "loadingMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "Lkotlin/collections/HashMap;", "mainLock", "Ljava/util/concurrent/locks/ReentrantLock;", "preLoadCallbacks", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mm/plugin/finder/preload/IVideoPreloadCallback;", "getPreLoadCallbacks", "()Ljava/util/concurrent/ConcurrentLinkedQueue;", "waitingList", "Ljava/util/LinkedList;", "buildPreloadList", "centerFeed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "dataList", "", "Lkotlin/Pair;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "cancel", "mediaId", "isIgnorePlaying", "cancelWaitingTask", "createPreloadCDNTask", "detail", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel$Detail;", "enqueue", "", "task", "getPreLoadingCount", "isFocusedMedia", "media", "mergePreload", "preloadList", "needToMerge", "new", "old", "onActivityStart", "", "onActivityStop", "onClearAll", "onMediaFocus", "isFocused", "onRelease", "pollWaiting", "preload", "source", "printMergeList", "", "rawList", "removeWaitingList", "resetRunningTask", "showErrToast", "stage", "ret", "syncLock", "T", "handle", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Companion", "VideoPreloadTaskCallback", "VideoTaskCallTask", "plugin-finder_release"})
public final class b
{
  public static final a KUl;
  private final HashMap<String, com.tencent.mm.plugin.finder.preload.c> KUg;
  private String KUh;
  private final boolean KUi;
  public final ConcurrentLinkedQueue<com.tencent.mm.plugin.finder.preload.b> KUj;
  public final com.tencent.mm.plugin.finder.preload.model.a KUk;
  public final String TAG;
  private final LinkedList<com.tencent.mm.plugin.finder.preload.c> fUG;
  public boolean gqu;
  public boolean isStop;
  private final ReentrantLock qEi;
  
  static
  {
    AppMethodBeat.i(198743);
    KUl = new a((byte)0);
    AppMethodBeat.o(198743);
  }
  
  public b(com.tencent.mm.plugin.finder.preload.model.a parama)
  {
    AppMethodBeat.i(198742);
    this.KUk = parama;
    this.qEi = new ReentrantLock();
    this.KUg = new HashMap();
    this.fUG = new LinkedList();
    this.KUh = "";
    parama = com.tencent.mm.plugin.finder.storage.b.qJA;
    this.KUi = com.tencent.mm.plugin.finder.storage.b.fUN();
    this.KUj = new ConcurrentLinkedQueue();
    this.TAG = "Finder.VideoPreloadWorker";
    this.KUj.add(new com.tencent.mm.plugin.finder.preload.b()
    {
      public final void a(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, String paramAnonymousString3, com.tencent.mm.plugin.finder.preload.c paramAnonymousc)
      {
        AppMethodBeat.i(198710);
        k.h(paramAnonymousString1, "mediaId");
        k.h(paramAnonymousString2, "fileFormat");
        k.h(paramAnonymousString3, "codingFormat");
        k.h(paramAnonymousc, "task");
        AppMethodBeat.o(198710);
      }
      
      public final void a(String paramAnonymousString1, String paramAnonymousString2, com.tencent.mm.plugin.finder.preload.c paramAnonymousc)
      {
        AppMethodBeat.i(198713);
        k.h(paramAnonymousString1, "mediaId");
        k.h(paramAnonymousString2, "msg");
        k.h(paramAnonymousc, "task");
        b.h(this.KUm);
        AppMethodBeat.o(198713);
      }
      
      public final void a(String paramAnonymousString, boolean paramAnonymousBoolean, int paramAnonymousInt, com.tencent.mm.plugin.finder.preload.c paramAnonymousc)
      {
        AppMethodBeat.i(198712);
        k.h(paramAnonymousString, "mediaId");
        k.h(paramAnonymousc, "task");
        if (b.f(this.KUm).KTP)
        {
          Object localObject = com.tencent.mm.plugin.finder.storage.logic.c.KXF;
          localObject = com.tencent.mm.plugin.finder.storage.logic.c.aVA(paramAnonymousString);
          MediaPreloadCore.a locala = MediaPreloadCore.KTA;
          if ((!MediaPreloadCore.a.a((r)localObject).qEp) && (!paramAnonymousBoolean))
          {
            ad.w(b.b(this.KUm), "Moov failure! try to download all! ".concat(String.valueOf(localObject)));
            b.a(this.KUm, paramAnonymousString, false);
            paramAnonymousc.foh = 100;
            paramAnonymousc.field_preloadRatio = 100;
            b.a(this.KUm, paramAnonymousc);
            AppMethodBeat.o(198712);
            return;
          }
        }
        b.h(this.KUm);
        AppMethodBeat.o(198712);
      }
      
      public final void aVn(String paramAnonymousString)
      {
        AppMethodBeat.i(198714);
        k.h(paramAnonymousString, "mediaId");
        ad.e(b.b(this.KUm), "[onFormatChange] mediaId=".concat(String.valueOf(paramAnonymousString)));
        b.a(this.KUm, paramAnonymousString, false);
        com.tencent.mm.plugin.finder.storage.logic.c localc = com.tencent.mm.plugin.finder.storage.logic.c.KXF;
        i.deleteFile(com.tencent.mm.plugin.finder.storage.logic.c.aVA(paramAnonymousString).getFilePath());
        localc = com.tencent.mm.plugin.finder.storage.logic.c.KXF;
        com.tencent.mm.plugin.finder.storage.logic.c.f(paramAnonymousString, 0L, 0L, -2);
        AppMethodBeat.o(198714);
      }
      
      public final void cU(String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(198711);
        k.h(paramAnonymousString, "mediaId");
        AppMethodBeat.o(198711);
      }
    });
    AppMethodBeat.o(198742);
  }
  
  private final com.tencent.mm.plugin.finder.preload.c a(a.b paramb)
  {
    boolean bool = true;
    AppMethodBeat.i(198740);
    int i;
    com.tencent.mm.plugin.finder.preload.c localc;
    label270:
    String str;
    StringBuilder localStringBuilder;
    if (k.g(paramb.KTW, "h265"))
    {
      i = 2;
      localc = new com.tencent.mm.plugin.finder.preload.c(paramb.qUh);
      localc.field_mediaId = paramb.qUh.aaX();
      localc.url = (paramb.qUh.getUrl() + paramb.qUh.fTN());
      localc.field_fullpath = paramb.qUh.getPath();
      localc.snsCipherKey = paramb.qUh.cmS();
      localc.fnW = 2;
      localc.foc = 2;
      localc.fnX = 8;
      localc.foh = paramb.foh;
      localc.field_preloadRatio = paramb.foh;
      localc.concurrentCount = l.a.tDs;
      localc.connectionCount = 1;
      localc.fnH = ((g.a)new c(localc.foh, paramb.preloadMinSize, this.KUg, this.KUj, paramb.qUh));
      localc.fnY = ((g.b)new b(localc.foh, SystemClock.uptimeMillis(), this.KUg, this.KUj));
      localc.field_fileType = com.tencent.mm.i.a.fne;
      localc.preloadMinSize = paramb.preloadMinSize;
      localc.qpa = 0;
      if (!this.KUi) {
        break label381;
      }
      localc.field_requestVideoFormat = 0;
      localc.aVp(paramb.DkS);
      str = this.TAG;
      localStringBuilder = new StringBuilder("[createPreloadCDNTask] isOpenMultiBitRateDownload=").append(this.KUi).append(" mediaId=").append(paramb.qUh.aaX()).append(" decodeKey=").append(paramb.qUh.qCj.decodeKey).append(" token=");
      if (((CharSequence)paramb.qUh.fTN()).length() <= 0) {
        break label390;
      }
    }
    for (;;)
    {
      ad.i(str, bool);
      AppMethodBeat.o(198740);
      return localc;
      i = 1;
      break;
      label381:
      localc.field_requestVideoFormat = i;
      break label270;
      label390:
      bool = false;
    }
  }
  
  private final boolean a(bmd parambmd)
  {
    AppMethodBeat.i(198737);
    String str = this.KUh;
    parambmd = parambmd.mediaId;
    k.g(parambmd, "media.mediaId");
    boolean bool = n.mB(str, parambmd);
    AppMethodBeat.o(198737);
    return bool;
  }
  
  private final LinkedList<com.tencent.mm.plugin.finder.preload.c> aVt(final String paramString)
  {
    AppMethodBeat.i(198735);
    paramString = (LinkedList)S((d.g.a.a)new e(this, paramString));
    AppMethodBeat.o(198735);
    return paramString;
  }
  
  private final com.tencent.mm.plugin.finder.preload.c cX(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(198734);
    paramString = (com.tencent.mm.plugin.finder.preload.c)S((d.g.a.a)new d(this, paramString, paramBoolean));
    AppMethodBeat.o(198734);
    return paramString;
  }
  
  public final <T> T S(d.g.a.a<? extends T> parama)
  {
    AppMethodBeat.i(198741);
    this.qEi.lock();
    try
    {
      parama = parama.invoke();
      return parama;
    }
    finally
    {
      this.qEi.unlock();
      AppMethodBeat.o(198741);
    }
  }
  
  public final int a(com.tencent.mm.plugin.finder.preload.c paramc)
  {
    AppMethodBeat.i(198739);
    this.qEi.lock();
    Object localObject3;
    Object localObject4;
    for (;;)
    {
      try
      {
        if (this.gqu)
        {
          ad.i(this.TAG, "[enqueue] VideoPreloadWorker has release. " + paramc + " just return.");
          return -1;
        }
        if (a(paramc.qCU.qCj))
        {
          ad.i(this.TAG, "[enqueue] is focused task " + paramc + " just return.");
          return -1;
        }
        localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.KXF;
        localObject2 = com.tencent.mm.plugin.finder.storage.logic.c.aVA(paramc.KTH);
        localObject3 = ((Iterable)this.KUj).iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject4 = (com.tencent.mm.plugin.finder.preload.b)((Iterator)localObject3).next();
        String str1 = ((r)localObject2).field_mediaId;
        k.g(str1, "cache.field_mediaId");
        i = ((r)localObject2).cno();
        String str2 = paramc.fTQ();
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
        this.qEi.unlock();
        AppMethodBeat.o(198739);
      }
    }
    if ((((r)localObject2).cno() >= paramc.foh) && (((r)localObject2).field_cacheSize >= paramc.preloadMinSize))
    {
      ad.i(this.TAG, "[enqueue] " + paramc + " has finish preload! just return.");
      localObject1 = ((Iterable)this.KUj).iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject3 = (com.tencent.mm.plugin.finder.preload.b)((Iterator)localObject1).next();
        localObject4 = paramc.KTH;
        if (((r)localObject2).cno() >= 100) {}
        for (boolean bool = true;; bool = false)
        {
          ((com.tencent.mm.plugin.finder.preload.b)localObject3).a((String)localObject4, bool, ((r)localObject2).cno(), paramc);
          break;
        }
      }
      this.qEi.unlock();
      AppMethodBeat.o(198739);
      return 1;
    }
    int i = this.KUg.size();
    if ((this.KUk.KTR <= i) || (this.isStop))
    {
      this.fUG.add(paramc);
      paramc.a(c.b.KTM);
      ad.i(this.TAG, "[enqueue] " + paramc + " wait to preLoad, just return. isStop=" + this.isStop + " preLoadingCount=" + i + " waitingSize=" + this.fUG.size());
      this.qEi.unlock();
      AppMethodBeat.o(198739);
      return 1;
    }
    paramc.a(c.b.KTK);
    Object localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.KXF;
    com.tencent.mm.plugin.finder.storage.logic.c.a(paramc.KTH, paramc.KTI, paramc.qCU.getUrl(), paramc.qCU.getPath(), paramc.field_requestVideoFormat, paramc.fTQ(), ((r)localObject2).field_cacheSize, ((r)localObject2).field_totalSize, 1);
    ((Map)this.KUg).put(paramc.KTH, paramc);
    localObject1 = new com.tencent.mm.plugin.finder.loader.f(paramc.qCU.qCj, com.tencent.mm.plugin.finder.storage.h.qJZ);
    Object localObject2 = com.tencent.mm.plugin.finder.loader.h.qCF;
    com.tencent.mm.plugin.finder.loader.h.cmU().bI(localObject1).agR();
    com.tencent.mm.ao.f.awL().h((g)paramc);
    ad.i(this.TAG, "[enqueue] begin to preloadVideo... ".concat(String.valueOf(paramc)));
    this.qEi.unlock();
    AppMethodBeat.o(198739);
    return 1;
  }
  
  public final LinkedList<com.tencent.mm.plugin.finder.preload.c> b(BaseFinderFeed paramBaseFinderFeed, List<o<BaseFinderFeed, List<bmd>>> paramList)
  {
    AppMethodBeat.i(198738);
    LinkedList localLinkedList = new LinkedList();
    Object localObject = paramList.iterator();
    int i = 0;
    int j;
    label68:
    label76:
    int i1;
    int i2;
    if (((Iterator)localObject).hasNext()) {
      if (((BaseFinderFeed)((o)((Iterator)localObject).next()).first).feedObject.getExpectId() == paramBaseFinderFeed.bMs())
      {
        j = 1;
        if (j == 0) {
          break label327;
        }
        j = i;
        if (j < 0) {
          break label393;
        }
        i1 = Math.max(j - this.KUk.Dmf, 0);
        i2 = Math.min(this.KUk.wAk + j + 1, paramList.size());
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
        j.fvx();
      }
      paramList = (bmd)j.iz((List)((o)paramList).second);
      if (paramList != null)
      {
        if ((paramList.mediaType == 4) && (!a(paramList)))
        {
          int m;
          if (i < j - i1)
          {
            m = i + (i1 - j);
            label226:
            paramList = (Iterable)this.KUk.a(paramList, true);
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
              j.fvx();
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
    AppMethodBeat.o(198738);
    return localLinkedList;
  }
  
  public final void cW(final String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(198732);
    k.h(paramString, "mediaId");
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("[onMediaFocus] mediaId=");
    c.a locala = com.tencent.mm.plugin.finder.preload.c.KTJ;
    ad.i(str, c.a.aVq(paramString) + " isFocused=" + paramBoolean);
    if (paramBoolean)
    {
      S((d.g.a.a)new h(this, paramString));
      cX(paramString, true);
      fTR();
      AppMethodBeat.o(198732);
      return;
    }
    this.KUh = "";
    AppMethodBeat.o(198732);
  }
  
  public final void fTR()
  {
    AppMethodBeat.i(198733);
    S((d.g.a.a)new i(this));
    AppMethodBeat.o(198733);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker$Companion;", "", "()V", "ENQUEUE_FAILURE", "", "ENQUEUE_REJECT", "ENQUEUE_SUCCESSFULLY", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker$VideoPreloadTaskCallback;", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskPreloadCallback;", "expect", "", "startTick", "", "loadingMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "Lkotlin/collections/HashMap;", "preLoadCallbacks", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mm/plugin/finder/preload/IVideoPreloadCallback;", "(Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;IJLjava/util/HashMap;Ljava/util/concurrent/ConcurrentLinkedQueue;)V", "onPreloadCompleted", "", "mediaId", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "plugin-finder_release"})
  public final class b
    implements g.b
  {
    final HashMap<String, com.tencent.mm.plugin.finder.preload.c> KUg;
    private final ConcurrentLinkedQueue<com.tencent.mm.plugin.finder.preload.b> KUj;
    private final int KUn;
    private final long fNi;
    
    public b(long paramLong, HashMap<String, com.tencent.mm.plugin.finder.preload.c> paramHashMap, ConcurrentLinkedQueue<com.tencent.mm.plugin.finder.preload.b> paramConcurrentLinkedQueue)
    {
      AppMethodBeat.i(198718);
      this.KUn = paramLong;
      this.fNi = ???;
      this.KUg = paramConcurrentLinkedQueue;
      this.KUj = localObject;
      AppMethodBeat.o(198718);
    }
    
    public final void a(final String paramString, com.tencent.mm.i.d paramd)
    {
      Object localObject1 = null;
      String str1 = null;
      AppMethodBeat.i(198717);
      k.h(paramString, "mediaId");
      if ((paramd != null) && (paramd.field_retCode == -21112))
      {
        paramd = ((Iterable)this.KUj).iterator();
        while (paramd.hasNext()) {
          ((com.tencent.mm.plugin.finder.preload.b)paramd.next()).aVn(paramString);
        }
        AppMethodBeat.o(198717);
        return;
      }
      long l1;
      long l2;
      label97:
      long l3;
      Object localObject2;
      if (paramd != null)
      {
        l1 = paramd.field_recvedBytes;
        if (paramd == null) {
          break label430;
        }
        l2 = paramd.field_fileLength;
        l3 = l1;
        if (l1 == 0L) {
          l3 = l2;
        }
        if ((l3 <= 0L) || (l2 <= 0L)) {
          break label459;
        }
        com.tencent.mm.ao.f.awL().xL(paramString);
        localObject2 = (com.tencent.mm.plugin.finder.preload.c)b.a(b.this, (d.g.a.a)new b(this, paramString));
        if (localObject2 == null) {
          break label599;
        }
        localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.KXF;
        if (paramd != null)
        {
          localObject1 = paramd.field_videoFlag;
          if (localObject1 != null) {
            break label610;
          }
        }
        localObject1 = ((com.tencent.mm.plugin.finder.preload.c)localObject2).fTQ();
      }
      label211:
      label599:
      label605:
      label610:
      for (;;)
      {
        com.tencent.mm.plugin.finder.storage.logic.c.ki(paramString, (String)localObject1);
        localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.KXF;
        int i;
        if (l2 <= l3)
        {
          i = 3;
          if (com.tencent.mm.plugin.finder.storage.logic.c.f(paramString, l3, l2, i))
          {
            String str2 = b.b(b.this);
            StringBuilder localStringBuilder = new StringBuilder("[onPreloadCompleted] successfully! mediaId=").append(paramString).append(" startTick=").append(this.fNi).append(" receivedBytes=").append(l3).append(" fileLength=").append(l2).append(" expect=").append(this.KUn).append("% fileFormat=");
            if (paramd == null) {
              break label441;
            }
            localObject1 = paramd.field_videoFlag;
            localStringBuilder = localStringBuilder.append((String)localObject1).append(" videoFormat=");
            localObject1 = str1;
            if (paramd != null) {
              localObject1 = Integer.valueOf(paramd.field_videoFormat);
            }
            ad.i(str2, localObject1);
          }
          paramd = ((Iterable)this.KUj).iterator();
          label365:
          if (!paramd.hasNext()) {
            break label453;
          }
          localObject1 = (com.tencent.mm.plugin.finder.preload.b)paramd.next();
          if (l2 != l3) {
            break label447;
          }
        }
        for (boolean bool = true;; bool = false)
        {
          ((com.tencent.mm.plugin.finder.preload.b)localObject1).a(paramString, bool, d.h.a.bU(100.0F * (float)l3 / (float)l2), (com.tencent.mm.plugin.finder.preload.c)localObject2);
          break label365;
          l1 = 0L;
          break;
          l2 = 0L;
          break label97;
          i = 2;
          break label211;
          localObject1 = null;
          break label306;
        }
        AppMethodBeat.o(198717);
        return;
        if (((Boolean)b.a(b.this, (d.g.a.a)new a(this, paramString))).booleanValue())
        {
          str1 = b.b(b.this);
          localObject2 = new StringBuilder("onPreloadCompleted ERROR! mediaId=").append(paramString).append(" startTick=").append(this.fNi).append(" recvedBytes=").append(l3).append(" fileLength=").append(l2).append(" fileFormat=");
          if (paramd == null) {
            break label605;
          }
        }
        for (paramString = paramd.field_videoFlag;; paramString = null)
        {
          localObject2 = ((StringBuilder)localObject2).append(paramString).append(" videoFormat=");
          paramString = (String)localObject1;
          if (paramd != null) {
            paramString = Integer.valueOf(paramd.field_videoFormat);
          }
          ad.e(str1, paramString);
          AppMethodBeat.o(198717);
          return;
        }
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<Boolean>
    {
      a(b.b paramb, String paramString)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "invoke"})
    static final class b
      extends d.g.b.l
      implements d.g.a.a<com.tencent.mm.plugin.finder.preload.c>
    {
      b(b.b paramb, String paramString)
      {
        super();
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker$VideoTaskCallTask;", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "expect", "", "preloadMinSize", "", "loadingMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "Lkotlin/collections/HashMap;", "preLoadCallbacks", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mm/plugin/finder/preload/IVideoPreloadCallback;", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "(Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;IJLjava/util/HashMap;Ljava/util/concurrent/ConcurrentLinkedQueue;Lcom/tencent/mm/plugin/finder/loader/FinderVideo;)V", "getExpect", "()I", "getPreloadMinSize", "()J", "callback", "mediaId", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-finder_release"})
  final class c
    implements g.a
  {
    final HashMap<String, com.tencent.mm.plugin.finder.preload.c> KUg;
    private final ConcurrentLinkedQueue<com.tencent.mm.plugin.finder.preload.b> KUj;
    private final int KUn;
    private final long preloadMinSize;
    private final com.tencent.mm.plugin.finder.loader.l qCU;
    
    public c(long paramLong, HashMap<String, com.tencent.mm.plugin.finder.preload.c> paramHashMap, ConcurrentLinkedQueue<com.tencent.mm.plugin.finder.preload.b> paramConcurrentLinkedQueue, com.tencent.mm.plugin.finder.loader.l paraml)
    {
      AppMethodBeat.i(198723);
      this.KUn = paramLong;
      this.preloadMinSize = ???;
      this.KUg = paramConcurrentLinkedQueue;
      this.KUj = paraml;
      this.qCU = localObject;
      AppMethodBeat.o(198723);
    }
    
    public final int a(final String paramString, int paramInt, com.tencent.mm.i.c paramc, com.tencent.mm.i.d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(198722);
      k.h(paramString, "mediaId");
      if ((paramd != null) && (paramd.field_retCode == -21112))
      {
        b.a(b.this, (d.g.a.a)new a(this, paramString));
        paramc = ((Iterable)this.KUj).iterator();
        while (paramc.hasNext()) {
          ((com.tencent.mm.plugin.finder.preload.b)paramc.next()).aVn(paramString);
        }
        AppMethodBeat.o(198722);
        return -1;
      }
      long l1;
      long l2;
      if ((paramc != null) && (paramc.field_toltalLength > 0L))
      {
        l1 = paramc.field_finishedLength;
        l2 = paramc.field_toltalLength;
        if (((int)((float)l1 / (float)l2 * 100.0F) >= this.KUn) && (l1 < l2) && (this.preloadMinSize <= l1))
        {
          paramInt = 2;
          paramc = com.tencent.mm.plugin.finder.storage.logic.c.KXF;
          if (paramd != null)
          {
            paramc = paramd.field_videoFlag;
            if (paramc != null) {
              break label419;
            }
          }
          paramc = ((c)this).qCU.qCk.detail;
        }
      }
      label419:
      for (;;)
      {
        com.tencent.mm.plugin.finder.storage.logic.c.ki(paramString, paramc);
        paramc = com.tencent.mm.plugin.finder.storage.logic.c.KXF;
        com.tencent.mm.plugin.finder.storage.logic.c.f(paramString, l1, l2, paramInt);
        paramc = ((Iterable)this.KUj).iterator();
        for (;;)
        {
          if (paramc.hasNext())
          {
            ((com.tencent.mm.plugin.finder.preload.b)paramc.next()).cU(paramString, d.h.a.bU((float)l1 * 100.0F / (float)l2));
            continue;
            if (l1 >= l2)
            {
              paramInt = 3;
              break;
            }
            paramInt = 1;
            break;
            if (paramInt != 0)
            {
              ad.e(b.b(b.this), "[VideoTaskCallTask] error! startRet=" + paramInt + " mediaId=" + paramString);
              if (-21006 != paramInt)
              {
                paramc = (com.tencent.mm.plugin.finder.preload.c)b.a(b.this, (d.g.a.a)new b(this, paramString));
                paramd = com.tencent.mm.plugin.finder.storage.logic.c.KXF;
                com.tencent.mm.plugin.finder.storage.logic.c.f(paramString, 0L, 0L, -1);
                if (paramc != null)
                {
                  paramd = ((Iterable)this.KUj).iterator();
                  while (paramd.hasNext()) {
                    ((com.tencent.mm.plugin.finder.preload.b)paramd.next()).a(paramString, "UPDATE ERROR", paramc);
                  }
                }
              }
            }
          }
        }
        AppMethodBeat.o(198722);
        return 0;
      }
    }
    
    public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
    {
      AppMethodBeat.i(198721);
      k.h(paramString, "mediaId");
      AppMethodBeat.o(198721);
    }
    
    public final byte[] f(String paramString, byte[] paramArrayOfByte)
    {
      return new byte[0];
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<com.tencent.mm.plugin.finder.preload.c>
    {
      a(b.c paramc, String paramString)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "invoke"})
    static final class b
      extends d.g.b.l
      implements d.g.a.a<com.tencent.mm.plugin.finder.preload.c>
    {
      b(b.c paramc, String paramString)
      {
        super();
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<com.tencent.mm.plugin.finder.preload.c>
  {
    d(b paramb, String paramString, boolean paramBoolean)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.a<LinkedList<com.tencent.mm.plugin.finder.preload.c>>
  {
    e(b paramb, String paramString)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "invoke"})
  public static final class f
    extends d.g.b.l
    implements d.g.a.a<LinkedList<com.tencent.mm.plugin.finder.preload.c>>
  {
    public f(b paramb, LinkedList paramLinkedList)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  public static final class g
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public g(b paramb, LinkedList paramLinkedList)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class h
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    h(b paramb, String paramString)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class i
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    i(b paramb)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  public static final class j
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public j(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.a.b
 * JD-Core Version:    0.7.0.1
 */