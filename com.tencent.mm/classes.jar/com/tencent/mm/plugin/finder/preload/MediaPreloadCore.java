package com.tencent.mm.plugin.finder.preload;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.event.base.d;
import com.tencent.mm.plugin.finder.event.base.f;
import com.tencent.mm.plugin.finder.event.base.i;
import com.tencent.mm.plugin.finder.event.base.m;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.r;
import com.tencent.mm.plugin.finder.preload.a.b.f;
import com.tencent.mm.plugin.finder.preload.a.b.g;
import com.tencent.mm.plugin.finder.preload.a.b.j;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import d.a.j;
import d.g.b.k;
import d.o;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "imagePreloadWorker", "Lcom/tencent/mm/plugin/finder/preload/worker/ImagePreloadWorker;", "videoPreloadWorker", "Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;", "onMediaFocus", "", "mediaId", "", "isFocused", "", "onOnlineDownloading", "onStart", "onStop", "registerCallback", "callback", "Lcom/tencent/mm/plugin/finder/preload/IVideoPreloadCallback;", "setup", "dataList", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "unregisterCallback", "Companion", "MoovReadyInfo", "Observer", "plugin-finder_release"})
public final class MediaPreloadCore
  extends UIComponent
{
  public static final a KTA;
  private static boolean KTz;
  public final com.tencent.mm.plugin.finder.preload.a.b KTx;
  private final com.tencent.mm.plugin.finder.preload.a.a KTy;
  
  static
  {
    AppMethodBeat.i(198684);
    KTA = new a((byte)0);
    e locale = g.afB();
    k.g(locale, "MMKernel.storage()");
    KTz = locale.afk().getBoolean(ae.a.Fxh, false);
    AppMethodBeat.o(198684);
  }
  
  public MediaPreloadCore(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(198683);
    paramMMActivity = com.tencent.mm.plugin.finder.storage.b.qJA;
    if (com.tencent.mm.plugin.finder.storage.b.fUc()) {}
    for (paramMMActivity = new com.tencent.mm.plugin.finder.preload.a.b(((PluginFinder)g.ad(PluginFinder.class)).getMediaPreloadModel());; paramMMActivity = null)
    {
      this.KTx = paramMMActivity;
      paramMMActivity = com.tencent.mm.plugin.finder.storage.b.qJA;
      paramMMActivity = localObject;
      if (com.tencent.mm.plugin.finder.storage.b.fUd()) {
        paramMMActivity = new com.tencent.mm.plugin.finder.preload.a.a();
      }
      this.KTy = paramMMActivity;
      AppMethodBeat.o(198683);
      return;
    }
  }
  
  public static void aVo(String paramString)
  {
    AppMethodBeat.i(198681);
    k.h(paramString, "mediaId");
    AppMethodBeat.o(198681);
  }
  
  public final void a(DataBuffer<BaseFinderFeed> paramDataBuffer, d paramd)
  {
    AppMethodBeat.i(198677);
    k.h(paramDataBuffer, "dataList");
    Object localObject = new StringBuilder("[CREATE] isPreloadMediaEnable=");
    com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.qJA;
    localObject = ((StringBuilder)localObject).append(com.tencent.mm.plugin.finder.storage.b.fUc()).append(" isPreloadImageEnable=");
    localb = com.tencent.mm.plugin.finder.storage.b.qJA;
    ad.i("Finder.MediaPreloadCore", com.tencent.mm.plugin.finder.storage.b.fUd() + ' ' + "isShowPreloadView=" + KTz);
    localObject = com.tencent.mm.plugin.finder.storage.b.qJA;
    if (!com.tencent.mm.plugin.finder.storage.b.fUc())
    {
      localObject = com.tencent.mm.plugin.finder.storage.b.qJA;
      if (!com.tencent.mm.plugin.finder.storage.b.fUd()) {}
    }
    else if (paramd != null)
    {
      paramd.a((f)new c(paramDataBuffer));
      AppMethodBeat.o(198677);
      return;
    }
    AppMethodBeat.o(198677);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(198682);
    k.h(paramb, "callback");
    Object localObject = this.KTx;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.preload.a.b)localObject).KUj;
      if (localObject != null)
      {
        ((ConcurrentLinkedQueue)localObject).add(paramb);
        AppMethodBeat.o(198682);
        return;
      }
    }
    AppMethodBeat.o(198682);
  }
  
  public final void cW(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(198680);
    k.h(paramString, "mediaId");
    if (this.KTy != null) {
      com.tencent.mm.plugin.finder.preload.a.a.aVs(paramString);
    }
    com.tencent.mm.plugin.finder.preload.a.b localb = this.KTx;
    if (localb != null)
    {
      localb.cW(paramString, paramBoolean);
      AppMethodBeat.o(198680);
      return;
    }
    AppMethodBeat.o(198680);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(198678);
    super.onStart();
    com.tencent.mm.plugin.finder.preload.a.b localb = this.KTx;
    if (localb != null)
    {
      localb.isStop = false;
      localb.fTR();
      AppMethodBeat.o(198678);
      return;
    }
    AppMethodBeat.o(198678);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(198679);
    super.onStop();
    com.tencent.mm.plugin.finder.preload.a.b localb = this.KTx;
    if (localb != null)
    {
      localb.S((d.g.a.a)new b.j(localb));
      localb.isStop = true;
      AppMethodBeat.o(198679);
      return;
    }
    AppMethodBeat.o(198679);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore$Companion;", "", "()V", "SOURCE_DATA_INSERTED", "", "SOURCE_IDLE", "SOURCE_LOAD_MORE", "SOURCE_REFRESH", "SOURCE_TAB_CHANGE", "TAG", "", "isShowPreloadView", "", "()Z", "setShowPreloadView", "(Z)V", "checkMoovReady", "Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore$MoovReadyInfo;", "cache", "Lcom/tencent/mm/plugin/finder/model/FinderMediaCache;", "plugin-finder_release"})
  public static final class a
  {
    public static MediaPreloadCore.b a(r paramr)
    {
      AppMethodBeat.i(198667);
      k.h(paramr, "cache");
      String str = paramr.field_filePath;
      CdnLogic.C2CDownloadRequest localC2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
      long[] arrayOfLong = new long[2];
      localC2CDownloadRequest.fileKey = paramr.field_mediaId;
      localC2CDownloadRequest.fileType = 8;
      localC2CDownloadRequest.url = paramr.getUrl();
      localC2CDownloadRequest.setSavePath(str);
      localC2CDownloadRequest.requestVideoFormat = paramr.field_reqFormat;
      boolean bool = CdnLogic.queryVideoMoovInfo(localC2CDownloadRequest, arrayOfLong);
      ad.i("Finder.MediaPreloadCore", "[checkMoovReady] moovReady=" + bool + " cache=" + paramr);
      paramr = new MediaPreloadCore.b(bool, arrayOfLong[0], arrayOfLong[1]);
      AppMethodBeat.o(198667);
      return paramr;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore$MoovReadyInfo;", "", "isMoovReady", "", "offset", "", "length", "(ZJJ)V", "()Z", "getLength", "()J", "getOffset", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "plugin-finder_release"})
  public static final class b
  {
    public final long length;
    public final long offset;
    public final boolean qEp;
    
    public b(boolean paramBoolean, long paramLong1, long paramLong2)
    {
      this.qEp = paramBoolean;
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
          if ((this.qEp != paramObject.qEp) || (this.offset != paramObject.offset) || (this.length != paramObject.length)) {}
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
      AppMethodBeat.i(198668);
      String str = "MoovReadyInfo(isMoovReady=" + this.qEp + ", offset=" + this.offset + ", length=" + this.length + ")";
      AppMethodBeat.o(198668);
      return str;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore$Observer;", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "dataList", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "(Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;)V", "asyncHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "lastCenterFeedId", "", "dispatchPreload", "", "centerFeed", "source", "", "isAsync", "", "isCareEvent", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "isNeedToDispatch", "onEventHappen", "ev", "onRelease", "plugin-finder_release"})
  public final class c
    extends f
  {
    private final DataBuffer<BaseFinderFeed> dataList;
    private final ap heR;
    private long qGl;
    
    public c()
    {
      AppMethodBeat.i(198675);
      this.dataList = localObject;
      this.heR = new ap("FinderMediaPreloadCore");
      AppMethodBeat.o(198675);
    }
    
    private final boolean a(BaseFinderFeed paramBaseFinderFeed, int paramInt)
    {
      AppMethodBeat.i(198673);
      if (paramBaseFinderFeed != null)
      {
        paramBaseFinderFeed = paramBaseFinderFeed.feedObject;
        if (paramBaseFinderFeed == null) {}
      }
      for (paramBaseFinderFeed = Long.valueOf(paramBaseFinderFeed.getExpectId()); (paramInt == 4) || (paramInt == 5); paramBaseFinderFeed = null)
      {
        AppMethodBeat.o(198673);
        return true;
      }
      long l = this.qGl;
      if (paramBaseFinderFeed == null) {
        if (paramBaseFinderFeed == null) {
          break label94;
        }
      }
      label94:
      for (l = paramBaseFinderFeed.longValue();; l = 0L)
      {
        this.qGl = l;
        AppMethodBeat.o(198673);
        return true;
        if (paramBaseFinderFeed.longValue() != l) {
          break;
        }
        AppMethodBeat.o(198673);
        return false;
      }
    }
    
    private final void b(final BaseFinderFeed paramBaseFinderFeed, final int paramInt)
    {
      AppMethodBeat.i(198674);
      if (!a(paramBaseFinderFeed, paramInt))
      {
        AppMethodBeat.o(198674);
        return;
      }
      if (paramBaseFinderFeed != null)
      {
        int j = this.dataList.getTotalSize();
        Object localObject = new ArrayList(j);
        int i = 0;
        while (i < j)
        {
          BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)this.dataList.get(i);
          ((ArrayList)localObject).add(new o(localBaseFinderFeed, j.q((Collection)localBaseFinderFeed.feedObject.getMediaList())));
          i += 1;
        }
        localObject = (List)localObject;
        this.heR.post((Runnable)new a((List)localObject, this, paramBaseFinderFeed, paramInt));
      }
      AppMethodBeat.o(198674);
    }
    
    public final void a(com.tencent.mm.plugin.finder.event.base.c paramc)
    {
      AppMethodBeat.i(198671);
      k.h(paramc, "ev");
      if ((paramc instanceof m))
      {
        b(((m)paramc).qsl, 5);
        AppMethodBeat.o(198671);
        return;
      }
      if ((paramc instanceof i))
      {
        b(((i)paramc).qsl, 1);
        AppMethodBeat.o(198671);
        return;
      }
      if ((paramc instanceof com.tencent.mm.plugin.finder.event.base.a)) {
        switch (((com.tencent.mm.plugin.finder.event.base.a)paramc).type)
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(198671);
        return;
        b(((com.tencent.mm.plugin.finder.event.base.a)paramc).qsl, 3);
        AppMethodBeat.o(198671);
        return;
        b(((com.tencent.mm.plugin.finder.event.base.a)paramc).qsl, 2);
        AppMethodBeat.o(198671);
        return;
        b(((com.tencent.mm.plugin.finder.event.base.a)paramc).qsl, 4);
      }
    }
    
    public final boolean a(d paramd, com.tencent.mm.plugin.finder.event.base.c paramc)
    {
      AppMethodBeat.i(198670);
      k.h(paramd, "dispatcher");
      k.h(paramc, "event");
      if ((paramc instanceof i))
      {
        if (((i)paramc).type == 0)
        {
          AppMethodBeat.o(198670);
          return true;
        }
        AppMethodBeat.o(198670);
        return false;
      }
      if ((paramc instanceof m))
      {
        AppMethodBeat.o(198670);
        return true;
      }
      if ((paramc instanceof com.tencent.mm.plugin.finder.event.base.a))
      {
        if ((((com.tencent.mm.plugin.finder.event.base.a)paramc).type == 4) || (((com.tencent.mm.plugin.finder.event.base.a)paramc).type == 3) || (((com.tencent.mm.plugin.finder.event.base.a)paramc).type == 5))
        {
          AppMethodBeat.o(198670);
          return true;
        }
        AppMethodBeat.o(198670);
        return false;
      }
      boolean bool = super.a(paramd, paramc);
      AppMethodBeat.o(198670);
      return bool;
    }
    
    public final boolean clc()
    {
      return false;
    }
    
    public final void onRelease()
    {
      AppMethodBeat.i(198672);
      super.onRelease();
      MediaPreloadCore.a(MediaPreloadCore.this);
      com.tencent.mm.plugin.finder.preload.a.b localb = MediaPreloadCore.b(MediaPreloadCore.this);
      if (localb != null)
      {
        localb.gqu = true;
        LinkedList localLinkedList = new LinkedList();
        localb.S((d.g.a.a)new b.g(localb, localLinkedList));
        ad.i(localb.TAG, "[onClearAll] ".concat(String.valueOf(localLinkedList)));
        AppMethodBeat.o(198672);
        return;
      }
      AppMethodBeat.o(198672);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/preload/MediaPreloadCore$Observer$dispatchPreload$1$1"})
    static final class a
      implements Runnable
    {
      a(List paramList, MediaPreloadCore.c paramc, BaseFinderFeed paramBaseFinderFeed, int paramInt) {}
      
      public final void run()
      {
        AppMethodBeat.i(198669);
        Object localObject1 = MediaPreloadCore.b(jdField_this.KTB);
        if (localObject1 != null)
        {
          Object localObject2 = paramBaseFinderFeed;
          List localList = this.$list;
          int i = paramInt;
          k.h(localObject2, "centerFeed");
          k.h(localList, "dataList");
          String str1 = ((com.tencent.mm.plugin.finder.preload.a.b)localObject1).TAG;
          StringBuilder localStringBuilder = new StringBuilder("[preload] prevCount=").append(((com.tencent.mm.plugin.finder.preload.a.b)localObject1).KUk.Dmf).append(" prevCount=").append(((com.tencent.mm.plugin.finder.preload.a.b)localObject1).KUk.wAk).append(" maxConcurrentCount=").append(((com.tencent.mm.plugin.finder.preload.a.b)localObject1).KUk.KTR).append(' ').append("list=").append(localList.size()).append(" center=");
          String str2 = String.valueOf(((BaseFinderFeed)localObject2).bMs());
          int j = Math.min(str2.length(), 8);
          if (str2 == null)
          {
            localObject1 = new v("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(198669);
            throw ((Throwable)localObject1);
          }
          str2 = str2.substring(0, j);
          k.g(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
          ad.i(str1, str2 + " source=" + i);
          localObject2 = ((Iterable)((com.tencent.mm.plugin.finder.preload.a.b)localObject1).S((d.g.a.a)new b.f((com.tencent.mm.plugin.finder.preload.a.b)localObject1, ((com.tencent.mm.plugin.finder.preload.a.b)localObject1).b((BaseFinderFeed)localObject2, localList)))).iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((com.tencent.mm.plugin.finder.preload.a.b)localObject1).a((c)((Iterator)localObject2).next());
          }
        }
        if (MediaPreloadCore.a(jdField_this.KTB) != null) {
          com.tencent.mm.plugin.finder.preload.a.a.a(paramBaseFinderFeed, this.$list);
        }
        AppMethodBeat.o(198669);
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/preload/IVideoPreloadCallback;", "kotlin.jvm.PlatformType", "invoke"})
  public static final class d
    extends d.g.b.l
    implements d.g.a.b<b, Boolean>
  {
    public d(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.MediaPreloadCore
 * JD-Core Version:    0.7.0.1
 */