package com.tencent.mm.plugin.finder.preload;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.event.base.d;
import com.tencent.mm.plugin.finder.event.base.h;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.w;
import com.tencent.mm.plugin.finder.preload.worker.b.h;
import com.tencent.mm.plugin.finder.preload.worker.b.k;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import d.a.j;
import d.g.b.k;
import d.l;
import d.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "imagePreloadWorker", "Lcom/tencent/mm/plugin/finder/preload/worker/ImagePreloadWorker;", "videoPreloadWorker", "Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;", "onMediaFocus", "", "mediaId", "", "isFocused", "", "onOnlineDownloading", "isFinish", "onStart", "onStop", "registerCallback", "callback", "Lcom/tencent/mm/plugin/finder/preload/IVideoPreloadCallback;", "setup", "dataList", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "unregisterCallback", "Companion", "MoovReadyInfo", "Observer", "plugin-finder_release"})
public final class MediaPreloadCore
  extends UIComponent
{
  private static boolean rvn;
  public static final a rvo;
  public final com.tencent.mm.plugin.finder.preload.worker.b rvl;
  private final com.tencent.mm.plugin.finder.preload.worker.a rvm;
  
  static
  {
    AppMethodBeat.i(202611);
    rvo = new a((byte)0);
    e locale = g.agR();
    k.g(locale, "MMKernel.storage()");
    rvn = locale.agA().getBoolean(ah.a.GVx, false);
    AppMethodBeat.o(202611);
  }
  
  public MediaPreloadCore(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(202610);
    paramMMActivity = com.tencent.mm.plugin.finder.storage.b.rCU;
    if (com.tencent.mm.plugin.finder.storage.b.czb()) {}
    for (paramMMActivity = new com.tencent.mm.plugin.finder.preload.worker.b(((PluginFinder)g.ad(PluginFinder.class)).getMediaPreloadModel());; paramMMActivity = null)
    {
      this.rvl = paramMMActivity;
      paramMMActivity = com.tencent.mm.plugin.finder.storage.b.rCU;
      paramMMActivity = localObject;
      if (com.tencent.mm.plugin.finder.storage.b.czc()) {
        paramMMActivity = new com.tencent.mm.plugin.finder.preload.worker.a();
      }
      this.rvm = paramMMActivity;
      AppMethodBeat.o(202610);
      return;
    }
  }
  
  public static void adH(String paramString)
  {
    AppMethodBeat.i(202608);
    k.h(paramString, "mediaId");
    AppMethodBeat.o(202608);
  }
  
  public final void a(DataBuffer<BaseFinderFeed> paramDataBuffer, c paramc)
  {
    AppMethodBeat.i(202604);
    k.h(paramDataBuffer, "dataList");
    Object localObject = new StringBuilder("[CREATE] isPreloadMediaEnable=");
    com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.rCU;
    localObject = ((StringBuilder)localObject).append(com.tencent.mm.plugin.finder.storage.b.czb()).append(" isPreloadImageEnable=");
    localb = com.tencent.mm.plugin.finder.storage.b.rCU;
    ac.i("Finder.MediaPreloadCore", com.tencent.mm.plugin.finder.storage.b.czc() + ' ' + "isShowPreloadView=" + rvn);
    localObject = com.tencent.mm.plugin.finder.storage.b.rCU;
    if (!com.tencent.mm.plugin.finder.storage.b.czb())
    {
      localObject = com.tencent.mm.plugin.finder.storage.b.rCU;
      if (!com.tencent.mm.plugin.finder.storage.b.czc()) {}
    }
    else if (paramc != null)
    {
      paramc.a((d)new c(paramDataBuffer));
      AppMethodBeat.o(202604);
      return;
    }
    AppMethodBeat.o(202604);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(202609);
    k.h(paramb, "callback");
    Object localObject = this.rvl;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.preload.worker.b)localObject).rwe;
      if (localObject != null)
      {
        ((ConcurrentLinkedQueue)localObject).add(paramb);
        AppMethodBeat.o(202609);
        return;
      }
    }
    AppMethodBeat.o(202609);
  }
  
  public final void aY(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(202607);
    k.h(paramString, "mediaId");
    if (this.rvm != null) {
      com.tencent.mm.plugin.finder.preload.worker.a.adL(paramString);
    }
    com.tencent.mm.plugin.finder.preload.worker.b localb = this.rvl;
    if (localb != null)
    {
      localb.aY(paramString, paramBoolean);
      AppMethodBeat.o(202607);
      return;
    }
    AppMethodBeat.o(202607);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(202605);
    super.onStart();
    com.tencent.mm.plugin.finder.preload.worker.b localb = this.rvl;
    if (localb != null)
    {
      localb.isStop = false;
      localb.cwL();
      AppMethodBeat.o(202605);
      return;
    }
    AppMethodBeat.o(202605);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(202606);
    super.onStop();
    com.tencent.mm.plugin.finder.preload.worker.b localb = this.rvl;
    if (localb != null)
    {
      localb.x((d.g.a.a)new b.k(localb));
      localb.isStop = true;
      AppMethodBeat.o(202606);
      return;
    }
    AppMethodBeat.o(202606);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore$Companion;", "", "()V", "TAG", "", "isShowPreloadView", "", "()Z", "setShowPreloadView", "(Z)V", "checkMoovReady", "Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore$MoovReadyInfo;", "cache", "Lcom/tencent/mm/plugin/finder/model/FinderMediaCache;", "plugin-finder_release"})
  public static final class a
  {
    public static MediaPreloadCore.b a(w paramw)
    {
      AppMethodBeat.i(202594);
      k.h(paramw, "cache");
      String str = paramw.field_filePath;
      CdnLogic.C2CDownloadRequest localC2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
      long[] arrayOfLong = new long[2];
      localC2CDownloadRequest.fileKey = paramw.field_mediaId;
      localC2CDownloadRequest.fileType = 8;
      localC2CDownloadRequest.url = paramw.getUrl();
      localC2CDownloadRequest.setSavePath(str);
      localC2CDownloadRequest.videoflagPolicy = 0;
      localC2CDownloadRequest.requestVideoFlag = paramw.field_fileFormat;
      localC2CDownloadRequest.requestVideoFormat = paramw.field_reqFormat;
      boolean bool = CdnLogic.queryVideoMoovInfo(localC2CDownloadRequest, arrayOfLong);
      ac.i("Finder.MediaPreloadCore", "[checkMoovReady] moovReady=" + bool + " cache=" + paramw);
      paramw = new MediaPreloadCore.b(bool, arrayOfLong[0], arrayOfLong[1]);
      AppMethodBeat.o(202594);
      return paramw;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore$MoovReadyInfo;", "", "isMoovReady", "", "offset", "", "length", "(ZJJ)V", "()Z", "getLength", "()J", "getOffset", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "plugin-finder_release"})
  public static final class b
  {
    public final long length;
    public final long offset;
    public final boolean rvp;
    
    public b(boolean paramBoolean, long paramLong1, long paramLong2)
    {
      this.rvp = paramBoolean;
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
          if ((this.rvp != paramObject.rvp) || (this.offset != paramObject.offset) || (this.length != paramObject.length)) {}
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
      AppMethodBeat.i(202595);
      String str = "MoovReadyInfo(isMoovReady=" + this.rvp + ", offset=" + this.offset + ", length=" + this.length + ")";
      AppMethodBeat.o(202595);
      return str;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore$Observer;", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "dataList", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "(Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;)V", "asyncHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "dispatchPreload", "", "centerFeed", "eventType", "", "isAsync", "", "isCareEvent", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onEventHappen", "ev", "onRelease", "plugin-finder_release"})
  public final class c
    extends d
  {
    private final DataBuffer<BaseFinderFeed> dataList;
    private final ao hFu;
    
    public c()
    {
      AppMethodBeat.i(202602);
      this.dataList = localObject;
      this.hFu = new ao("FinderMediaPreloadCore");
      AppMethodBeat.o(202602);
    }
    
    public final void a(com.tencent.mm.plugin.finder.event.base.b paramb)
    {
      AppMethodBeat.i(202598);
      k.h(paramb, "ev");
      if ((paramb instanceof h))
      {
        final BaseFinderFeed localBaseFinderFeed1 = ((h)paramb).rde;
        final int j = ((h)paramb).type;
        if (localBaseFinderFeed1 != null)
        {
          int k = this.dataList.getTotalSize();
          paramb = new ArrayList(k);
          int i = 0;
          while (i < k)
          {
            BaseFinderFeed localBaseFinderFeed2 = (BaseFinderFeed)this.dataList.get(i);
            paramb.add(new o(localBaseFinderFeed2, j.r((Collection)localBaseFinderFeed2.feedObject.getMediaList())));
            i += 1;
          }
          paramb = (List)paramb;
          this.hFu.post((Runnable)new a(paramb, this, localBaseFinderFeed1, j));
        }
      }
      AppMethodBeat.o(202598);
    }
    
    public final boolean a(c paramc, com.tencent.mm.plugin.finder.event.base.b paramb)
    {
      AppMethodBeat.i(202597);
      k.h(paramc, "dispatcher");
      k.h(paramb, "event");
      if ((paramb instanceof h))
      {
        AppMethodBeat.o(202597);
        return true;
      }
      boolean bool = super.a(paramc, paramb);
      AppMethodBeat.o(202597);
      return bool;
    }
    
    public final boolean csW()
    {
      return false;
    }
    
    public final void onRelease()
    {
      AppMethodBeat.i(202599);
      super.onRelease();
      MediaPreloadCore.a(MediaPreloadCore.this);
      com.tencent.mm.plugin.finder.preload.worker.b localb = MediaPreloadCore.b(MediaPreloadCore.this);
      if (localb != null)
      {
        localb.gRc = true;
        LinkedList localLinkedList = new LinkedList();
        localb.x((d.g.a.a)new b.h(localb, localLinkedList));
        ac.i(localb.TAG, "[onClearAll] ".concat(String.valueOf(localLinkedList)));
        AppMethodBeat.o(202599);
        return;
      }
      AppMethodBeat.o(202599);
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/preload/MediaPreloadCore$Observer$dispatchPreload$1$1"})
    static final class a
      implements Runnable
    {
      a(List paramList, MediaPreloadCore.c paramc, BaseFinderFeed paramBaseFinderFeed, int paramInt) {}
      
      public final void run()
      {
        AppMethodBeat.i(202596);
        com.tencent.mm.plugin.finder.preload.worker.b localb = MediaPreloadCore.b(jdField_this.rvq);
        if (localb != null) {
          localb.a(localBaseFinderFeed1, this.gmd, j);
        }
        if (MediaPreloadCore.a(jdField_this.rvq) != null) {
          com.tencent.mm.plugin.finder.preload.worker.a.a(localBaseFinderFeed1, this.gmd);
        }
        AppMethodBeat.o(202596);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.MediaPreloadCore
 * JD-Core Version:    0.7.0.1
 */