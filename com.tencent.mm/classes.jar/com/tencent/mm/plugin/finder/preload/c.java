package com.tencent.mm.plugin.finder.preload;

import androidx.appcompat.app.AppCompatActivity;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.h;
import com.tencent.mm.plugin.finder.feed.an;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.av;
import com.tencent.mm.plugin.finder.model.bs;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.preload.worker.b.l;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.FeedData.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.protocal.protobuf.csg;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "commentScene", "", "imagePreloadWorker", "Lcom/tencent/mm/plugin/finder/preload/worker/ImagePreloadWorker;", "isWaitingPreload", "", "lastCenterFeed", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "preloadModel", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "getPreloadModel", "()Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "preloadModel$delegate", "Lkotlin/Lazy;", "videoPreloadWorker", "Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;", "isEnableWaitPreload", "onMediaFocusDownload", "", "mediaId", "", "isFocused", "onMediaFocusForTP", "onOnlineCachePlaying", "cacheTime", "timeDuration", "onPreloadStart", "source", "onPreloadStop", "onStart", "onStop", "registerCallback", "callback", "Lcom/tencent/mm/plugin/finder/preload/IVideoPreloadCallback;", "setup", "dataList", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "startPreloadForTP", "stopPreloadForTP", "unregisterCallback", "Companion", "MoovReadyInfo", "Observer", "plugin-finder_release"})
public final class c
  extends UIComponent
{
  private static boolean zKk;
  public static final a zKl;
  private int xkX;
  private final f zKf;
  public final com.tencent.mm.plugin.finder.preload.worker.b zKg;
  private final com.tencent.mm.plugin.finder.preload.worker.a zKh;
  public boolean zKi;
  private FeedData zKj;
  
  static
  {
    AppMethodBeat.i(277021);
    zKl = new a((byte)0);
    com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.AjH;
    zKk = ((Boolean)com.tencent.mm.plugin.finder.storage.d.dTK().aSr()).booleanValue();
    AppMethodBeat.o(277021);
  }
  
  public c(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(277020);
    this.zKf = g.ar((kotlin.g.a.a)d.zKr);
    paramAppCompatActivity = com.tencent.mm.plugin.finder.storage.d.AjH;
    if (com.tencent.mm.plugin.finder.storage.d.dSU()) {}
    for (paramAppCompatActivity = new com.tencent.mm.plugin.finder.preload.worker.b(getPreloadModel());; paramAppCompatActivity = null)
    {
      this.zKg = paramAppCompatActivity;
      paramAppCompatActivity = com.tencent.mm.plugin.finder.storage.d.AjH;
      paramAppCompatActivity = localObject;
      if (com.tencent.mm.plugin.finder.storage.d.dSV()) {
        paramAppCompatActivity = new com.tencent.mm.plugin.finder.preload.worker.a();
      }
      this.zKh = paramAppCompatActivity;
      AppMethodBeat.o(277020);
      return;
    }
  }
  
  private final void aDE(String paramString)
  {
    AppMethodBeat.i(277012);
    Log.i("Finder.MediaPreloadCore", "[onPreloadStop] source=".concat(String.valueOf(paramString)));
    paramString = this.zKg;
    if (paramString != null)
    {
      if (paramString.fpV.compareAndSet(false, true)) {
        paramString.l("resetRunningTask", (kotlin.g.a.a)new b.l(paramString));
      }
      AppMethodBeat.o(277012);
      return;
    }
    AppMethodBeat.o(277012);
  }
  
  public final void a(DataBuffer<bu> paramDataBuffer, int paramInt, com.tencent.mm.plugin.finder.event.base.c paramc)
  {
    AppMethodBeat.i(277010);
    p.k(paramDataBuffer, "dataList");
    Object localObject = new StringBuilder("[CREATE] commentScene=").append(paramInt).append(" isPreloadMediaEnable=");
    com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.AjH;
    localObject = ((StringBuilder)localObject).append(com.tencent.mm.plugin.finder.storage.d.dSU()).append(" isPreloadImageEnable=");
    locald = com.tencent.mm.plugin.finder.storage.d.AjH;
    Log.i("Finder.MediaPreloadCore", com.tencent.mm.plugin.finder.storage.d.dSV() + ' ' + "isShowPreloadView=" + zKk);
    this.xkX = paramInt;
    localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
    if (!com.tencent.mm.plugin.finder.storage.d.dSU())
    {
      localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (!com.tencent.mm.plugin.finder.storage.d.dSV()) {}
    }
    else if (paramc != null)
    {
      paramc.a((com.tencent.mm.plugin.finder.event.base.d)new c(paramDataBuffer));
      AppMethodBeat.o(277010);
      return;
    }
    AppMethodBeat.o(277010);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(277019);
    p.k(paramb, "callback");
    Object localObject = this.zKg;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.preload.worker.b)localObject).zMc;
      if (localObject != null)
      {
        ((ConcurrentLinkedQueue)localObject).add(paramb);
        AppMethodBeat.o(277019);
        return;
      }
    }
    AppMethodBeat.o(277019);
  }
  
  public final void aDD(String paramString)
  {
    AppMethodBeat.i(277011);
    Log.i("Finder.MediaPreloadCore", "[onPreloadStart] source=".concat(String.valueOf(paramString)));
    paramString = this.zKg;
    if (paramString != null)
    {
      if (paramString.fpV.compareAndSet(true, false)) {
        paramString.dMQ();
      }
      AppMethodBeat.o(277011);
      return;
    }
    AppMethodBeat.o(277011);
  }
  
  public final void aDF(String paramString)
  {
    AppMethodBeat.i(277017);
    p.k(paramString, "mediaId");
    Log.i("Finder.MediaPreloadCore", "[stopPreloadForTP] mediaId=".concat(String.valueOf(paramString)));
    if (!this.zKi)
    {
      aDE("onMediaFocusForTP#".concat(String.valueOf(paramString)));
      this.zKi = true;
    }
    AppMethodBeat.o(277017);
  }
  
  public final void bq(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(277015);
    p.k(paramString, "mediaId");
    Log.i("Finder.MediaPreloadCore", "[onMediaFocusDownload] mediaId=" + paramString + " isFocused=" + paramBoolean);
    if (dMF())
    {
      if (!paramBoolean) {
        break label113;
      }
      aDE("onMediaFocusDownload#".concat(String.valueOf(paramString)));
    }
    for (boolean bool = true;; bool = false)
    {
      this.zKi = bool;
      if (this.zKh != null) {
        com.tencent.mm.plugin.finder.preload.worker.a.aDK(paramString);
      }
      com.tencent.mm.plugin.finder.preload.worker.b localb = this.zKg;
      if (localb == null) {
        break;
      }
      localb.bs(paramString, paramBoolean);
      AppMethodBeat.o(277015);
      return;
      label113:
      aDD("onMediaFocusDownload#".concat(String.valueOf(paramString)));
    }
    AppMethodBeat.o(277015);
  }
  
  public final void br(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(277016);
    p.k(paramString, "mediaId");
    Log.i("Finder.MediaPreloadCore", "[onMediaFocusForTP] mediaId=" + paramString + " isFocused=" + paramBoolean);
    if (this.zKh != null) {
      com.tencent.mm.plugin.finder.preload.worker.a.aDK(paramString);
    }
    com.tencent.mm.plugin.finder.preload.worker.b localb = this.zKg;
    if (localb != null)
    {
      localb.bs(paramString, paramBoolean);
      AppMethodBeat.o(277016);
      return;
    }
    AppMethodBeat.o(277016);
  }
  
  public final boolean dMF()
  {
    AppMethodBeat.i(277018);
    if ((getPreloadModel().zKK >= 0) && (getPreloadModel().zKJ >= 0))
    {
      AppMethodBeat.o(277018);
      return true;
    }
    AppMethodBeat.o(277018);
    return false;
  }
  
  public final com.tencent.mm.plugin.finder.preload.model.a getPreloadModel()
  {
    AppMethodBeat.i(277009);
    com.tencent.mm.plugin.finder.preload.model.a locala = (com.tencent.mm.plugin.finder.preload.model.a)this.zKf.getValue();
    AppMethodBeat.o(277009);
    return locala;
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(277013);
    super.onStart();
    if (!this.zKi) {
      aDD("Activity#onStart");
    }
    AppMethodBeat.o(277013);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(277014);
    super.onStop();
    if (!this.zKi) {
      aDE("Activity#onStrop");
    }
    AppMethodBeat.o(277014);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore$Companion;", "", "()V", "SOURCE_DATA_INSERTED", "", "SOURCE_IDLE", "SOURCE_LOAD_MORE", "SOURCE_REFRESH", "SOURCE_TAB_CHANGE", "TAG", "", "isShowPreloadView", "", "()Z", "setShowPreloadView", "(Z)V", "checkMoovReady", "Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore$MoovReadyInfo;", "cache", "Lcom/tencent/mm/plugin/finder/model/FinderMediaCache;", "plugin-finder_release"})
  public static final class a
  {
    public static c.b a(av paramav)
    {
      AppMethodBeat.i(278789);
      p.k(paramav, "cache");
      String str3 = paramav.getFilePath();
      CdnLogic.C2CDownloadRequest localC2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
      long[] arrayOfLong = new long[2];
      localC2CDownloadRequest.fileKey = paramav.field_mediaId;
      localC2CDownloadRequest.fileType = 8;
      StringBuilder localStringBuilder = new StringBuilder();
      String str2 = paramav.field_url;
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      localC2CDownloadRequest.url = (str1 + paramav.field_urlToken);
      localC2CDownloadRequest.snsCipherKey = paramav.field_decodeKey;
      localC2CDownloadRequest.setSavePath(str3);
      localC2CDownloadRequest.videoflagPolicy = 0;
      localC2CDownloadRequest.requestVideoFlag = paramav.field_fileFormat;
      localC2CDownloadRequest.requestVideoFormat = paramav.field_reqFormat;
      paramav = new c.b(CdnLogic.queryVideoMoovInfo(localC2CDownloadRequest, arrayOfLong), arrayOfLong[0], arrayOfLong[1]);
      AppMethodBeat.o(278789);
      return paramav;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore$MoovReadyInfo;", "", "isMoovReady", "", "offset", "", "length", "(ZJJ)V", "()Z", "getLength", "()J", "getOffset", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "plugin-finder_release"})
  public static final class b
  {
    private final long aFL;
    private final long offset;
    public final boolean zKm;
    
    public b(boolean paramBoolean, long paramLong1, long paramLong2)
    {
      this.zKm = paramBoolean;
      this.offset = paramLong1;
      this.aFL = paramLong2;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((this.zKm != paramObject.zKm) || (this.offset != paramObject.offset) || (this.aFL != paramObject.aFL)) {}
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
      AppMethodBeat.i(256947);
      String str = "MoovReadyInfo(isMoovReady=" + this.zKm + ", offset=" + this.offset + ", length=" + this.aFL + ")";
      AppMethodBeat.o(256947);
      return str;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore$Observer;", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "dataList", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "(Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;)V", "asyncHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "dispatchPreload", "", "centerFeed", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "eventType", "", "findMediaList", "", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "feed", "isAsync", "", "isCareEvent", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onEventHappen", "ev", "onRelease", "plugin-finder_release"})
  public final class c
    extends com.tencent.mm.plugin.finder.event.base.d
  {
    private final DataBuffer<bu> dataList;
    private final MMHandler lMk;
    
    public c()
    {
      AppMethodBeat.i(272073);
      this.dataList = localObject;
      this.lMk = new MMHandler("FinderMediaPreloadCore");
      AppMethodBeat.o(272073);
    }
    
    public final void a(com.tencent.mm.plugin.finder.event.base.b paramb)
    {
      AppMethodBeat.i(272071);
      p.k(paramb, "ev");
      if ((paramb instanceof h))
      {
        final FeedData localFeedData2 = ((h)paramb).xro;
        final int j = ((h)paramb).type;
        if (localFeedData2 != null)
        {
          long l = localFeedData2.getId();
          paramb = c.c(c.this);
          int i;
          FeedData localFeedData1;
          label79:
          ArrayList localArrayList;
          label106:
          bu localbu;
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
            localbu = (bu)this.dataList.get(i);
            if (!(localbu instanceof bs)) {
              break label185;
            }
            paramb = (List)((bs)localbu).dKV();
          }
          for (;;)
          {
            localArrayList.add(new o(localbu, j.t((Collection)paramb)));
            i += 1;
            break label106;
            i = 0;
            break;
            label179:
            localFeedData1 = null;
            break label79;
            label185:
            if ((localbu instanceof BaseFinderFeed))
            {
              paramb = new LinkedList();
              boolean bool = aj.a(aj.AGc, 0, c.d(c.this), 1);
              ((BaseFinderFeed)localbu).feedObject.setReplaceLongVideoToNormal(bool);
              Object localObject = FeedData.Companion;
              localObject = (csg)j.lp((List)FeedData.a.t((BaseFinderFeed)localbu).getMediaList());
              if (localObject != null) {
                paramb.add(localObject);
              }
              if (!bool)
              {
                localObject = (csg)j.lp((List)((BaseFinderFeed)localbu).feedObject.getLongVideoMediaList());
                if (localObject != null) {
                  paramb.add(localObject);
                }
              }
              paramb = (List)paramb;
            }
            else if ((localbu instanceof an))
            {
              paramb = (BaseFinderFeed)j.lp((List)((an)localbu).rvFeedList);
              if (paramb != null)
              {
                paramb = paramb.feedObject;
                if (paramb != null)
                {
                  paramb = paramb.getMediaList();
                  if (paramb != null)
                  {
                    paramb = j.t((Collection)paramb);
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
          this.lMk.post((Runnable)new a(paramb, this, localFeedData2, j));
          c.a(c.this, localFeedData1);
          AppMethodBeat.o(272071);
          return;
        }
      }
      label448:
      AppMethodBeat.o(272071);
    }
    
    public final boolean a(com.tencent.mm.plugin.finder.event.base.c paramc, com.tencent.mm.plugin.finder.event.base.b paramb)
    {
      AppMethodBeat.i(272070);
      p.k(paramc, "dispatcher");
      p.k(paramb, "event");
      if (((paramb instanceof h)) && ((((h)paramb).type == 6) || (((h)paramb).type == 7) || (((h)paramb).type == 0)))
      {
        AppMethodBeat.o(272070);
        return true;
      }
      AppMethodBeat.o(272070);
      return false;
    }
    
    public final boolean dpw()
    {
      return false;
    }
    
    public final void onRelease()
    {
      AppMethodBeat.i(272072);
      super.onRelease();
      c.a(c.this);
      com.tencent.mm.plugin.finder.preload.worker.b localb = c.b(c.this);
      if (localb != null)
      {
        localb.kTS = true;
        localb.dMP();
        AppMethodBeat.o(272072);
        return;
      }
      AppMethodBeat.o(272072);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/preload/MediaPreloadCore$Observer$dispatchPreload$2$1"})
    static final class a
      implements Runnable
    {
      a(List paramList, c.c paramc, FeedData paramFeedData, int paramInt) {}
      
      public final void run()
      {
        AppMethodBeat.i(291959);
        com.tencent.mm.plugin.finder.preload.worker.b localb = c.b(jdField_this.zKn);
        if (localb != null) {
          localb.a(c.d(jdField_this.zKn), localFeedData2, this.khi, j);
        }
        if (c.a(jdField_this.zKn) != null)
        {
          c.d(jdField_this.zKn);
          com.tencent.mm.plugin.finder.preload.worker.a.a(localFeedData2, this.khi);
        }
        AppMethodBeat.o(291959);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.preload.model.a>
  {
    public static final d zKr;
    
    static
    {
      AppMethodBeat.i(256438);
      zKr = new d();
      AppMethodBeat.o(256438);
    }
    
    d()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/preload/IVideoPreloadCallback;", "kotlin.jvm.PlatformType", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.c
 * JD-Core Version:    0.7.0.1
 */