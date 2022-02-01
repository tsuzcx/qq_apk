package com.tencent.mm.plugin.finder.preload;

import android.support.v7.app.AppCompatActivity;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.d;
import com.tencent.mm.plugin.finder.event.base.h;
import com.tencent.mm.plugin.finder.feed.ag;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.at;
import com.tencent.mm.plugin.finder.model.bm;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.preload.worker.b.i;
import com.tencent.mm.plugin.finder.preload.worker.b.l;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.FeedData.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.component.UIComponent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.a.j;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.o;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "imagePreloadWorker", "Lcom/tencent/mm/plugin/finder/preload/worker/ImagePreloadWorker;", "isWaitingPreload", "", "lastCenterFeed", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "preloadModel", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "getPreloadModel", "()Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "preloadModel$delegate", "Lkotlin/Lazy;", "tabType", "", "videoPreloadWorker", "Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;", "isEnableWaitPreload", "onMediaFocusDownload", "", "mediaId", "", "isFocused", "onMediaFocusForTP", "onOnlineCachePlaying", "cacheTime", "timeDuration", "onPreloadStart", "source", "onPreloadStop", "onStart", "onStop", "registerCallback", "callback", "Lcom/tencent/mm/plugin/finder/preload/IVideoPreloadCallback;", "setup", "dataList", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "startPreloadForTP", "stopPreloadForTP", "unregisterCallback", "Companion", "MoovReadyInfo", "Observer", "plugin-finder_release"})
public final class MediaPreloadCore
  extends UIComponent
{
  private static boolean uTU;
  public static final a uTV;
  private int dLS;
  private final f uTP;
  public final com.tencent.mm.plugin.finder.preload.worker.b uTQ;
  private final com.tencent.mm.plugin.finder.preload.worker.a uTR;
  public boolean uTS;
  private FeedData uTT;
  
  static
  {
    AppMethodBeat.i(249525);
    uTV = new a((byte)0);
    com.tencent.mm.plugin.finder.storage.c localc = com.tencent.mm.plugin.finder.storage.c.vCb;
    uTU = ((Boolean)com.tencent.mm.plugin.finder.storage.c.dsv().value()).booleanValue();
    AppMethodBeat.o(249525);
  }
  
  public MediaPreloadCore(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(249524);
    this.uTP = g.ah((kotlin.g.a.a)d.uUb);
    paramAppCompatActivity = com.tencent.mm.plugin.finder.storage.c.vCb;
    if (com.tencent.mm.plugin.finder.storage.c.drD()) {}
    for (paramAppCompatActivity = new com.tencent.mm.plugin.finder.preload.worker.b(getPreloadModel());; paramAppCompatActivity = null)
    {
      this.uTQ = paramAppCompatActivity;
      paramAppCompatActivity = com.tencent.mm.plugin.finder.storage.c.vCb;
      paramAppCompatActivity = localObject;
      if (com.tencent.mm.plugin.finder.storage.c.drE()) {
        paramAppCompatActivity = new com.tencent.mm.plugin.finder.preload.worker.a();
      }
      this.uTR = paramAppCompatActivity;
      this.dLS = -2147483648;
      AppMethodBeat.o(249524);
      return;
    }
  }
  
  private final void auo(String paramString)
  {
    AppMethodBeat.i(249516);
    Log.i("Finder.MediaPreloadCore", "[onPreloadStop] source=".concat(String.valueOf(paramString)));
    paramString = this.uTQ;
    if (paramString != null)
    {
      if (paramString.dxj.compareAndSet(false, true)) {
        paramString.l("resetRunningTask", (kotlin.g.a.a)new b.l(paramString));
      }
      AppMethodBeat.o(249516);
      return;
    }
    AppMethodBeat.o(249516);
  }
  
  public final void a(DataBuffer<bo> paramDataBuffer, int paramInt, com.tencent.mm.plugin.finder.event.base.c paramc)
  {
    AppMethodBeat.i(249514);
    p.h(paramDataBuffer, "dataList");
    Object localObject = new StringBuilder("[CREATE] tabType=").append(paramInt).append(" isPreloadMediaEnable=");
    com.tencent.mm.plugin.finder.storage.c localc = com.tencent.mm.plugin.finder.storage.c.vCb;
    localObject = ((StringBuilder)localObject).append(com.tencent.mm.plugin.finder.storage.c.drD()).append(" isPreloadImageEnable=");
    localc = com.tencent.mm.plugin.finder.storage.c.vCb;
    Log.i("Finder.MediaPreloadCore", com.tencent.mm.plugin.finder.storage.c.drE() + ' ' + "isShowPreloadView=" + uTU);
    this.dLS = paramInt;
    localObject = com.tencent.mm.plugin.finder.storage.c.vCb;
    if (!com.tencent.mm.plugin.finder.storage.c.drD())
    {
      localObject = com.tencent.mm.plugin.finder.storage.c.vCb;
      if (!com.tencent.mm.plugin.finder.storage.c.drE()) {}
    }
    else if (paramc != null)
    {
      paramc.a((d)new c(paramDataBuffer));
      AppMethodBeat.o(249514);
      return;
    }
    AppMethodBeat.o(249514);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(249523);
    p.h(paramb, "callback");
    Object localObject = this.uTQ;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.preload.worker.b)localObject).uVL;
      if (localObject != null)
      {
        ((ConcurrentLinkedQueue)localObject).add(paramb);
        AppMethodBeat.o(249523);
        return;
      }
    }
    AppMethodBeat.o(249523);
  }
  
  public final void aun(String paramString)
  {
    AppMethodBeat.i(249515);
    Log.i("Finder.MediaPreloadCore", "[onPreloadStart] source=".concat(String.valueOf(paramString)));
    paramString = this.uTQ;
    if (paramString != null)
    {
      if (paramString.dxj.compareAndSet(true, false)) {
        paramString.dlM();
      }
      AppMethodBeat.o(249515);
      return;
    }
    AppMethodBeat.o(249515);
  }
  
  public final void aup(String paramString)
  {
    AppMethodBeat.i(249521);
    p.h(paramString, "mediaId");
    Log.i("Finder.MediaPreloadCore", "[stopPreloadForTP] mediaId=".concat(String.valueOf(paramString)));
    if (!this.uTS)
    {
      auo("onMediaFocusForTP#".concat(String.valueOf(paramString)));
      this.uTS = true;
    }
    AppMethodBeat.o(249521);
  }
  
  public final void bl(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(249519);
    p.h(paramString, "mediaId");
    Log.i("Finder.MediaPreloadCore", "[onMediaFocusDownload] mediaId=" + paramString + " isFocused=" + paramBoolean);
    if (dlE())
    {
      if (!paramBoolean) {
        break label113;
      }
      auo("onMediaFocusDownload#".concat(String.valueOf(paramString)));
    }
    for (boolean bool = true;; bool = false)
    {
      this.uTS = bool;
      if (this.uTR != null) {
        com.tencent.mm.plugin.finder.preload.worker.a.auu(paramString);
      }
      com.tencent.mm.plugin.finder.preload.worker.b localb = this.uTQ;
      if (localb == null) {
        break;
      }
      localb.bn(paramString, paramBoolean);
      AppMethodBeat.o(249519);
      return;
      label113:
      aun("onMediaFocusDownload#".concat(String.valueOf(paramString)));
    }
    AppMethodBeat.o(249519);
  }
  
  public final void bm(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(249520);
    p.h(paramString, "mediaId");
    Log.i("Finder.MediaPreloadCore", "[onMediaFocusForTP] mediaId=" + paramString + " isFocused=" + paramBoolean);
    if (this.uTR != null) {
      com.tencent.mm.plugin.finder.preload.worker.a.auu(paramString);
    }
    com.tencent.mm.plugin.finder.preload.worker.b localb = this.uTQ;
    if (localb != null)
    {
      localb.bn(paramString, paramBoolean);
      AppMethodBeat.o(249520);
      return;
    }
    AppMethodBeat.o(249520);
  }
  
  public final boolean dlE()
  {
    AppMethodBeat.i(249522);
    if ((getPreloadModel().uUu >= 0) && (getPreloadModel().uUt >= 0))
    {
      AppMethodBeat.o(249522);
      return true;
    }
    AppMethodBeat.o(249522);
    return false;
  }
  
  public final com.tencent.mm.plugin.finder.preload.model.a getPreloadModel()
  {
    AppMethodBeat.i(249513);
    com.tencent.mm.plugin.finder.preload.model.a locala = (com.tencent.mm.plugin.finder.preload.model.a)this.uTP.getValue();
    AppMethodBeat.o(249513);
    return locala;
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(249517);
    super.onStart();
    if (!this.uTS) {
      aun("Activity#onStart");
    }
    AppMethodBeat.o(249517);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(249518);
    super.onStop();
    if (!this.uTS) {
      auo("Activity#onStrop");
    }
    AppMethodBeat.o(249518);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore$Companion;", "", "()V", "SOURCE_DATA_INSERTED", "", "SOURCE_IDLE", "SOURCE_LOAD_MORE", "SOURCE_REFRESH", "SOURCE_TAB_CHANGE", "TAG", "", "isShowPreloadView", "", "()Z", "setShowPreloadView", "(Z)V", "checkMoovReady", "Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore$MoovReadyInfo;", "cache", "Lcom/tencent/mm/plugin/finder/model/FinderMediaCache;", "plugin-finder_release"})
  public static final class a
  {
    public static MediaPreloadCore.b a(at paramat)
    {
      AppMethodBeat.i(249503);
      p.h(paramat, "cache");
      String str3 = paramat.getFilePath();
      CdnLogic.C2CDownloadRequest localC2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
      long[] arrayOfLong = new long[2];
      localC2CDownloadRequest.fileKey = paramat.field_mediaId;
      localC2CDownloadRequest.fileType = 8;
      StringBuilder localStringBuilder = new StringBuilder();
      String str2 = paramat.field_url;
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      localC2CDownloadRequest.url = (str1 + paramat.field_urlToken);
      localC2CDownloadRequest.snsCipherKey = paramat.field_decodeKey;
      localC2CDownloadRequest.setSavePath(str3);
      localC2CDownloadRequest.videoflagPolicy = 0;
      localC2CDownloadRequest.requestVideoFlag = paramat.field_fileFormat;
      localC2CDownloadRequest.requestVideoFormat = paramat.field_reqFormat;
      paramat = new MediaPreloadCore.b(CdnLogic.queryVideoMoovInfo(localC2CDownloadRequest, arrayOfLong), arrayOfLong[0], arrayOfLong[1]);
      AppMethodBeat.o(249503);
      return paramat;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore$MoovReadyInfo;", "", "isMoovReady", "", "offset", "", "length", "(ZJJ)V", "()Z", "getLength", "()J", "getOffset", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "plugin-finder_release"})
  public static final class b
  {
    private final long length;
    private final long offset;
    public final boolean uTW;
    
    public b(boolean paramBoolean, long paramLong1, long paramLong2)
    {
      this.uTW = paramBoolean;
      this.offset = paramLong1;
      this.length = paramLong2;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((this.uTW != paramObject.uTW) || (this.offset != paramObject.offset) || (this.length != paramObject.length)) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(249504);
      String str = "MoovReadyInfo(isMoovReady=" + this.uTW + ", offset=" + this.offset + ", length=" + this.length + ")";
      AppMethodBeat.o(249504);
      return str;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore$Observer;", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "dataList", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "(Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;)V", "asyncHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "dispatchPreload", "", "centerFeed", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "eventType", "", "findMediaList", "", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "feed", "isAsync", "", "isCareEvent", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onEventHappen", "ev", "onRelease", "plugin-finder_release"})
  public final class c
    extends d
  {
    private final DataBuffer<bo> dataList;
    private final MMHandler iVP;
    
    public c()
    {
      AppMethodBeat.i(249509);
      this.dataList = localObject;
      this.iVP = new MMHandler("FinderMediaPreloadCore");
      AppMethodBeat.o(249509);
    }
    
    public final void a(com.tencent.mm.plugin.finder.event.base.b paramb)
    {
      AppMethodBeat.i(249507);
      p.h(paramb, "ev");
      if ((paramb instanceof h))
      {
        final FeedData localFeedData2 = ((h)paramb).tIF;
        final int j = ((h)paramb).type;
        if (localFeedData2 != null)
        {
          long l = localFeedData2.getId();
          paramb = MediaPreloadCore.c(MediaPreloadCore.this);
          int i;
          FeedData localFeedData1;
          label79:
          ArrayList localArrayList;
          label106:
          bo localbo;
          if ((paramb == null) || (l != paramb.getId()))
          {
            i = 1;
            if (i == 0) {
              break label179;
            }
            localFeedData1 = localFeedData2;
            if (localFeedData1 == null) {
              break label448;
            }
            int k = this.dataList.getTotalSize();
            localArrayList = new ArrayList(k);
            i = 0;
            if (i >= k) {
              break label404;
            }
            localbo = (bo)this.dataList.get(i);
            if (!(localbo instanceof bm)) {
              break label185;
            }
            paramb = (List)((bm)localbo).dkV();
          }
          for (;;)
          {
            localArrayList.add(new o(localbo, j.v((Collection)paramb)));
            i += 1;
            break label106;
            i = 0;
            break;
            label179:
            localFeedData1 = null;
            break label79;
            label185:
            if ((localbo instanceof BaseFinderFeed))
            {
              paramb = new LinkedList();
              boolean bool = y.a(y.vXH, MediaPreloadCore.d(MediaPreloadCore.this), 0, 2);
              ((BaseFinderFeed)localbo).feedObject.setReplaceLongVideoToNormal(bool);
              Object localObject = FeedData.Companion;
              localObject = (cjl)j.kt((List)FeedData.a.s((BaseFinderFeed)localbo).getMediaList());
              if (localObject != null) {
                paramb.add(localObject);
              }
              if (!bool)
              {
                localObject = (cjl)j.kt((List)((BaseFinderFeed)localbo).feedObject.getLongVideoMediaList());
                if (localObject != null) {
                  paramb.add(localObject);
                }
              }
              paramb = (List)paramb;
            }
            else if ((localbo instanceof ag))
            {
              paramb = (BaseFinderFeed)j.kt((List)((ag)localbo).rvFeedList);
              if (paramb != null)
              {
                paramb = paramb.feedObject;
                if (paramb != null)
                {
                  paramb = paramb.getMediaList();
                  if (paramb != null)
                  {
                    paramb = j.v((Collection)paramb);
                    continue;
                  }
                }
              }
              paramb = (List)new LinkedList();
            }
            else
            {
              paramb = (List)new LinkedList();
            }
          }
          label404:
          paramb = (List)localArrayList;
          this.iVP.post((Runnable)new a(paramb, this, localFeedData2, j));
          MediaPreloadCore.a(MediaPreloadCore.this, localFeedData1);
          AppMethodBeat.o(249507);
          return;
        }
      }
      label448:
      AppMethodBeat.o(249507);
    }
    
    public final boolean a(com.tencent.mm.plugin.finder.event.base.c paramc, com.tencent.mm.plugin.finder.event.base.b paramb)
    {
      AppMethodBeat.i(249506);
      p.h(paramc, "dispatcher");
      p.h(paramb, "event");
      if (((paramb instanceof h)) && ((((h)paramb).type == 6) || (((h)paramb).type == 7) || (((h)paramb).type == 0)))
      {
        AppMethodBeat.o(249506);
        return true;
      }
      AppMethodBeat.o(249506);
      return false;
    }
    
    public final boolean cZD()
    {
      return false;
    }
    
    public final void onRelease()
    {
      AppMethodBeat.i(249508);
      super.onRelease();
      MediaPreloadCore.a(MediaPreloadCore.this);
      com.tencent.mm.plugin.finder.preload.worker.b localb = MediaPreloadCore.b(MediaPreloadCore.this);
      if (localb != null)
      {
        localb.ife = true;
        LinkedList localLinkedList = new LinkedList();
        localb.l("onClearAll", (kotlin.g.a.a)new b.i(localb, localLinkedList));
        Log.i(localb.TAG, "[onClearAll] ".concat(String.valueOf(localLinkedList)));
        AppMethodBeat.o(249508);
        return;
      }
      AppMethodBeat.o(249508);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/preload/MediaPreloadCore$Observer$dispatchPreload$2$1"})
    static final class a
      implements Runnable
    {
      a(List paramList, MediaPreloadCore.c paramc, FeedData paramFeedData, int paramInt) {}
      
      public final void run()
      {
        AppMethodBeat.i(249505);
        com.tencent.mm.plugin.finder.preload.worker.b localb = MediaPreloadCore.b(jdField_this.uTX);
        if (localb != null) {
          localb.a(localFeedData2, this.hvj, j);
        }
        if (MediaPreloadCore.a(jdField_this.uTX) != null) {
          com.tencent.mm.plugin.finder.preload.worker.a.a(localFeedData2, this.hvj);
        }
        AppMethodBeat.o(249505);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.preload.model.a>
  {
    public static final d uUb;
    
    static
    {
      AppMethodBeat.i(249511);
      uUb = new d();
      AppMethodBeat.o(249511);
    }
    
    d()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/preload/IVideoPreloadCallback;", "kotlin.jvm.PlatformType", "invoke"})
  public static final class e
    extends q
    implements kotlin.g.a.b<b, Boolean>
  {
    public e(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.MediaPreloadCore
 * JD-Core Version:    0.7.0.1
 */