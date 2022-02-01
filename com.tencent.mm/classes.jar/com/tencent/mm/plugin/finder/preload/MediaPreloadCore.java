package com.tencent.mm.plugin.finder.preload;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.event.base.d;
import com.tencent.mm.plugin.finder.event.base.h;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.plugin.finder.model.y;
import com.tencent.mm.plugin.finder.preload.worker.b.i;
import com.tencent.mm.plugin.finder.preload.worker.b.l;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import d.a.j;
import d.f;
import d.g;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "imagePreloadWorker", "Lcom/tencent/mm/plugin/finder/preload/worker/ImagePreloadWorker;", "isWaitingPreload", "", "lastCenterFeed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "preloadModel", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "getPreloadModel", "()Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "preloadModel$delegate", "Lkotlin/Lazy;", "videoPreloadWorker", "Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;", "isEnableWaitPreload", "onMediaFocusDownload", "", "mediaId", "", "isFocused", "onMediaFocusForTP", "onOnlineCachePlaying", "cacheTime", "", "timeDuration", "onPreloadStart", "source", "onPreloadStop", "onStart", "onStop", "registerCallback", "callback", "Lcom/tencent/mm/plugin/finder/preload/IVideoPreloadCallback;", "setup", "dataList", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "startPreloadForTP", "stopPreloadForTP", "unregisterCallback", "Companion", "MoovReadyInfo", "Observer", "plugin-finder_release"})
public final class MediaPreloadCore
  extends UIComponent
{
  private static boolean skN;
  public static final a skO;
  private final f skI;
  public final com.tencent.mm.plugin.finder.preload.worker.b skJ;
  private final com.tencent.mm.plugin.finder.preload.worker.a skK;
  public boolean skL;
  private BaseFinderFeed skM;
  
  static
  {
    AppMethodBeat.i(203032);
    skO = new a((byte)0);
    com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sxa;
    skN = ((Boolean)com.tencent.mm.plugin.finder.storage.b.cGQ().value()).booleanValue();
    AppMethodBeat.o(203032);
  }
  
  public MediaPreloadCore(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(203031);
    this.skI = g.O((d.g.a.a)d.skU);
    paramMMActivity = com.tencent.mm.plugin.finder.storage.b.sxa;
    if (com.tencent.mm.plugin.finder.storage.b.cFW()) {}
    for (paramMMActivity = new com.tencent.mm.plugin.finder.preload.worker.b(getPreloadModel());; paramMMActivity = null)
    {
      this.skJ = paramMMActivity;
      paramMMActivity = com.tencent.mm.plugin.finder.storage.b.sxa;
      paramMMActivity = localObject;
      if (com.tencent.mm.plugin.finder.storage.b.cFX()) {
        paramMMActivity = new com.tencent.mm.plugin.finder.preload.worker.a();
      }
      this.skK = paramMMActivity;
      AppMethodBeat.o(203031);
      return;
    }
  }
  
  private final void ahB(String paramString)
  {
    AppMethodBeat.i(203022);
    ad.i("Finder.MediaPreloadCore", "[onPreloadStop] source=".concat(String.valueOf(paramString)));
    paramString = this.skJ;
    if (paramString != null)
    {
      if (paramString.deX.compareAndSet(false, true)) {
        paramString.i("resetRunningTask", (d.g.a.a)new b.l(paramString));
      }
      AppMethodBeat.o(203022);
      return;
    }
    AppMethodBeat.o(203022);
  }
  
  public final void a(DataBuffer<al> paramDataBuffer, c paramc)
  {
    AppMethodBeat.i(203020);
    p.h(paramDataBuffer, "dataList");
    Object localObject = new StringBuilder("[CREATE] isPreloadMediaEnable=");
    com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sxa;
    localObject = ((StringBuilder)localObject).append(com.tencent.mm.plugin.finder.storage.b.cFW()).append(" isPreloadImageEnable=");
    localb = com.tencent.mm.plugin.finder.storage.b.sxa;
    ad.i("Finder.MediaPreloadCore", com.tencent.mm.plugin.finder.storage.b.cFX() + ' ' + "isShowPreloadView=" + skN);
    localObject = com.tencent.mm.plugin.finder.storage.b.sxa;
    if (!com.tencent.mm.plugin.finder.storage.b.cFW())
    {
      localObject = com.tencent.mm.plugin.finder.storage.b.sxa;
      if (!com.tencent.mm.plugin.finder.storage.b.cFX()) {}
    }
    else if (paramc != null)
    {
      paramc.a((d)new c(paramDataBuffer));
      AppMethodBeat.o(203020);
      return;
    }
    AppMethodBeat.o(203020);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(203030);
    p.h(paramb, "callback");
    Object localObject = this.skJ;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.preload.worker.b)localObject).slF;
      if (localObject != null)
      {
        ((ConcurrentLinkedQueue)localObject).add(paramb);
        AppMethodBeat.o(203030);
        return;
      }
    }
    AppMethodBeat.o(203030);
  }
  
  public final void ahA(String paramString)
  {
    AppMethodBeat.i(203021);
    ad.i("Finder.MediaPreloadCore", "[onPreloadStart] source=".concat(String.valueOf(paramString)));
    paramString = this.skJ;
    if (paramString != null)
    {
      if (paramString.deX.compareAndSet(true, false)) {
        paramString.cDd();
      }
      AppMethodBeat.o(203021);
      return;
    }
    AppMethodBeat.o(203021);
  }
  
  public final void ahC(String paramString)
  {
    AppMethodBeat.i(203027);
    p.h(paramString, "mediaId");
    ad.i("Finder.MediaPreloadCore", "[stopPreloadForTP] mediaId=".concat(String.valueOf(paramString)));
    if (!this.skL)
    {
      ahB("onMediaFocusForTP#".concat(String.valueOf(paramString)));
      this.skL = true;
    }
    AppMethodBeat.o(203027);
  }
  
  public final void ahD(String paramString)
  {
    AppMethodBeat.i(203028);
    p.h(paramString, "mediaId");
    ad.i("Finder.MediaPreloadCore", "[startPreloadForTP] mediaId=".concat(String.valueOf(paramString)));
    if (this.skL)
    {
      ahA("startPreloadForTP#".concat(String.valueOf(paramString)));
      this.skL = false;
    }
    AppMethodBeat.o(203028);
  }
  
  public final void ba(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(203025);
    p.h(paramString, "mediaId");
    ad.i("Finder.MediaPreloadCore", "[onMediaFocusDownload] mediaId=" + paramString + " isFocused=" + paramBoolean);
    if (cDa())
    {
      if (!paramBoolean) {
        break label113;
      }
      ahB("onMediaFocusDownload#".concat(String.valueOf(paramString)));
    }
    for (boolean bool = true;; bool = false)
    {
      this.skL = bool;
      if (this.skK != null) {
        com.tencent.mm.plugin.finder.preload.worker.a.ahH(paramString);
      }
      com.tencent.mm.plugin.finder.preload.worker.b localb = this.skJ;
      if (localb == null) {
        break;
      }
      localb.bc(paramString, paramBoolean);
      AppMethodBeat.o(203025);
      return;
      label113:
      ahA("onMediaFocusDownload#".concat(String.valueOf(paramString)));
    }
    AppMethodBeat.o(203025);
  }
  
  public final void bb(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(203026);
    p.h(paramString, "mediaId");
    ad.i("Finder.MediaPreloadCore", "[onMediaFocusForTP] mediaId=" + paramString + " isFocused=" + paramBoolean);
    if (this.skK != null) {
      com.tencent.mm.plugin.finder.preload.worker.a.ahH(paramString);
    }
    com.tencent.mm.plugin.finder.preload.worker.b localb = this.skJ;
    if (localb != null)
    {
      localb.bc(paramString, paramBoolean);
      AppMethodBeat.o(203026);
      return;
    }
    AppMethodBeat.o(203026);
  }
  
  public final boolean cDa()
  {
    AppMethodBeat.i(203029);
    if ((getPreloadModel().sln >= 0) && (getPreloadModel().slm >= 0))
    {
      AppMethodBeat.o(203029);
      return true;
    }
    AppMethodBeat.o(203029);
    return false;
  }
  
  public final com.tencent.mm.plugin.finder.preload.model.a getPreloadModel()
  {
    AppMethodBeat.i(203019);
    com.tencent.mm.plugin.finder.preload.model.a locala = (com.tencent.mm.plugin.finder.preload.model.a)this.skI.getValue();
    AppMethodBeat.o(203019);
    return locala;
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(203023);
    super.onStart();
    if (!this.skL) {
      ahA("Activity#onStart");
    }
    AppMethodBeat.o(203023);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(203024);
    super.onStop();
    if (!this.skL) {
      ahB("Activity#onStrop");
    }
    AppMethodBeat.o(203024);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore$Companion;", "", "()V", "SOURCE_DATA_INSERTED", "", "SOURCE_IDLE", "SOURCE_LOAD_MORE", "SOURCE_REFRESH", "SOURCE_TAB_CHANGE", "TAG", "", "isShowPreloadView", "", "()Z", "setShowPreloadView", "(Z)V", "checkMoovReady", "Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore$MoovReadyInfo;", "cache", "Lcom/tencent/mm/plugin/finder/model/FinderMediaCache;", "plugin-finder_release"})
  public static final class a
  {
    public static MediaPreloadCore.b a(y paramy)
    {
      AppMethodBeat.i(203009);
      p.h(paramy, "cache");
      String str3 = paramy.field_filePath;
      CdnLogic.C2CDownloadRequest localC2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
      long[] arrayOfLong = new long[2];
      localC2CDownloadRequest.fileKey = paramy.field_mediaId;
      localC2CDownloadRequest.fileType = 8;
      StringBuilder localStringBuilder = new StringBuilder();
      String str2 = paramy.field_url;
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      localC2CDownloadRequest.url = (str1 + paramy.field_urlToken);
      localC2CDownloadRequest.snsCipherKey = paramy.field_decodeKey;
      localC2CDownloadRequest.setSavePath(str3);
      localC2CDownloadRequest.videoflagPolicy = 0;
      localC2CDownloadRequest.requestVideoFlag = paramy.field_fileFormat;
      localC2CDownloadRequest.requestVideoFormat = paramy.field_reqFormat;
      paramy = new MediaPreloadCore.b(CdnLogic.queryVideoMoovInfo(localC2CDownloadRequest, arrayOfLong), arrayOfLong[0], arrayOfLong[1]);
      AppMethodBeat.o(203009);
      return paramy;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore$MoovReadyInfo;", "", "isMoovReady", "", "offset", "", "length", "(ZJJ)V", "()Z", "getLength", "()J", "getOffset", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "plugin-finder_release"})
  public static final class b
  {
    private final long length;
    private final long offset;
    public final boolean skP;
    
    public b(boolean paramBoolean, long paramLong1, long paramLong2)
    {
      this.skP = paramBoolean;
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
          if ((this.skP != paramObject.skP) || (this.offset != paramObject.offset) || (this.length != paramObject.length)) {}
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
      AppMethodBeat.i(203010);
      String str = "MoovReadyInfo(isMoovReady=" + this.skP + ", offset=" + this.offset + ", length=" + this.length + ")";
      AppMethodBeat.o(203010);
      return str;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore$Observer;", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "dataList", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "(Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;)V", "asyncHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "dispatchPreload", "", "centerFeed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "eventType", "", "isAsync", "", "isCareEvent", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onEventHappen", "ev", "onRelease", "plugin-finder_release"})
  public final class c
    extends d
  {
    private final DataBuffer<al> dataList;
    private final ap hXZ;
    
    public c()
    {
      AppMethodBeat.i(203015);
      this.dataList = localObject;
      this.hXZ = new ap("FinderMediaPreloadCore");
      AppMethodBeat.o(203015);
    }
    
    public final void a(com.tencent.mm.plugin.finder.event.base.b paramb)
    {
      AppMethodBeat.i(203013);
      p.h(paramb, "ev");
      if ((paramb instanceof h))
      {
        final BaseFinderFeed localBaseFinderFeed = ((h)paramb).rRn;
        final int j = ((h)paramb).type;
        if (localBaseFinderFeed != null)
        {
          long l = localBaseFinderFeed.lP();
          paramb = MediaPreloadCore.c(MediaPreloadCore.this);
          int i;
          label78:
          ArrayList localArrayList;
          label104:
          al localal;
          if ((paramb == null) || (l != paramb.lP()))
          {
            i = 1;
            if (i == 0) {
              break label179;
            }
            paramb = localBaseFinderFeed;
            if (paramb == null) {
              break label244;
            }
            int k = this.dataList.getTotalSize();
            localArrayList = new ArrayList(k);
            i = 0;
            if (i >= k) {
              break label199;
            }
            localal = (al)this.dataList.get(i);
            if (!(localal instanceof BaseFinderFeed)) {
              break label184;
            }
          }
          label179:
          label184:
          for (List localList = j.s((Collection)((BaseFinderFeed)localal).feedObject.getMediaList());; localList = (List)new ArrayList())
          {
            localArrayList.add(new o(localal, localList));
            i += 1;
            break label104;
            i = 0;
            break;
            paramb = null;
            break label78;
          }
          label199:
          localList = (List)localArrayList;
          this.hXZ.post((Runnable)new a(localList, this, localBaseFinderFeed, j));
          MediaPreloadCore.a(MediaPreloadCore.this, paramb);
          AppMethodBeat.o(203013);
          return;
        }
      }
      label244:
      AppMethodBeat.o(203013);
    }
    
    public final boolean a(c paramc, com.tencent.mm.plugin.finder.event.base.b paramb)
    {
      AppMethodBeat.i(203012);
      p.h(paramc, "dispatcher");
      p.h(paramb, "event");
      if (((paramb instanceof h)) && ((((h)paramb).type == 6) || (((h)paramb).type == 7) || (((h)paramb).type == 0)))
      {
        AppMethodBeat.o(203012);
        return true;
      }
      AppMethodBeat.o(203012);
      return false;
    }
    
    public final boolean cyW()
    {
      return false;
    }
    
    public final void onRelease()
    {
      AppMethodBeat.i(203014);
      super.onRelease();
      MediaPreloadCore.a(MediaPreloadCore.this);
      com.tencent.mm.plugin.finder.preload.worker.b localb = MediaPreloadCore.b(MediaPreloadCore.this);
      if (localb != null)
      {
        localb.hju = true;
        LinkedList localLinkedList = new LinkedList();
        localb.i("onClearAll", (d.g.a.a)new b.i(localb, localLinkedList));
        ad.i(localb.TAG, "[onClearAll] ".concat(String.valueOf(localLinkedList)));
        AppMethodBeat.o(203014);
        return;
      }
      AppMethodBeat.o(203014);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/preload/MediaPreloadCore$Observer$dispatchPreload$2$1"})
    static final class a
      implements Runnable
    {
      a(List paramList, MediaPreloadCore.c paramc, BaseFinderFeed paramBaseFinderFeed, int paramInt) {}
      
      public final void run()
      {
        AppMethodBeat.i(203011);
        com.tencent.mm.plugin.finder.preload.worker.b localb = MediaPreloadCore.b(jdField_this.skQ);
        if (localb != null) {
          localb.a(localBaseFinderFeed, this.gFM, j);
        }
        if (MediaPreloadCore.a(jdField_this.skQ) != null) {
          com.tencent.mm.plugin.finder.preload.worker.a.a(localBaseFinderFeed, this.gFM);
        }
        AppMethodBeat.o(203011);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "invoke"})
  static final class d
    extends q
    implements d.g.a.a<com.tencent.mm.plugin.finder.preload.model.a>
  {
    public static final d skU;
    
    static
    {
      AppMethodBeat.i(203017);
      skU = new d();
      AppMethodBeat.o(203017);
    }
    
    d()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/preload/IVideoPreloadCallback;", "kotlin.jvm.PlatformType", "invoke"})
  public static final class e
    extends q
    implements d.g.a.b<b, Boolean>
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