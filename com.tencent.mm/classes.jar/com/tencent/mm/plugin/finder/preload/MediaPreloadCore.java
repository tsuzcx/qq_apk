package com.tencent.mm.plugin.finder.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.event.base.d;
import com.tencent.mm.plugin.finder.event.base.h;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.am;
import com.tencent.mm.plugin.finder.preload.worker.b.i;
import com.tencent.mm.plugin.finder.preload.worker.b.l;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import d.a.j;
import d.f;
import d.g;
import d.g.b.p;
import d.l;
import d.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "imagePreloadWorker", "Lcom/tencent/mm/plugin/finder/preload/worker/ImagePreloadWorker;", "isWaitingPreload", "", "lastCenterFeed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "preloadModel", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "getPreloadModel", "()Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "preloadModel$delegate", "Lkotlin/Lazy;", "videoPreloadWorker", "Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;", "isEnableWaitPreload", "onMediaFocusDownload", "", "mediaId", "", "isFocused", "onMediaFocusForTP", "onOnlineCachePlaying", "cacheTime", "", "timeDuration", "onPreloadStart", "source", "onPreloadStop", "onStart", "onStop", "registerCallback", "callback", "Lcom/tencent/mm/plugin/finder/preload/IVideoPreloadCallback;", "setup", "dataList", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "startPreloadForTP", "stopPreloadForTP", "unregisterCallback", "Companion", "MoovReadyInfo", "Observer", "plugin-finder_release"})
public final class MediaPreloadCore
  extends UIComponent
{
  private static boolean stK;
  public static final MediaPreloadCore.a stL;
  private final f stF;
  public final com.tencent.mm.plugin.finder.preload.worker.b stG;
  private final com.tencent.mm.plugin.finder.preload.worker.a stH;
  public boolean stI;
  private BaseFinderFeed stJ;
  
  static
  {
    AppMethodBeat.i(203517);
    stL = new MediaPreloadCore.a((byte)0);
    com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sHP;
    stK = ((Boolean)com.tencent.mm.plugin.finder.storage.b.cIP().value()).booleanValue();
    AppMethodBeat.o(203517);
  }
  
  public MediaPreloadCore(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(203516);
    this.stF = g.O((d.g.a.a)MediaPreloadCore.d.stR);
    paramMMActivity = com.tencent.mm.plugin.finder.storage.b.sHP;
    if (com.tencent.mm.plugin.finder.storage.b.cHT()) {}
    for (paramMMActivity = new com.tencent.mm.plugin.finder.preload.worker.b(getPreloadModel());; paramMMActivity = null)
    {
      this.stG = paramMMActivity;
      paramMMActivity = com.tencent.mm.plugin.finder.storage.b.sHP;
      paramMMActivity = localObject;
      if (com.tencent.mm.plugin.finder.storage.b.cHU()) {
        paramMMActivity = new com.tencent.mm.plugin.finder.preload.worker.a();
      }
      this.stH = paramMMActivity;
      AppMethodBeat.o(203516);
      return;
    }
  }
  
  private final void aiy(String paramString)
  {
    AppMethodBeat.i(203507);
    ae.i("Finder.MediaPreloadCore", "[onPreloadStop] source=".concat(String.valueOf(paramString)));
    paramString = this.stG;
    if (paramString != null)
    {
      if (paramString.dfZ.compareAndSet(false, true)) {
        paramString.i("resetRunningTask", (d.g.a.a)new b.l(paramString));
      }
      AppMethodBeat.o(203507);
      return;
    }
    AppMethodBeat.o(203507);
  }
  
  public final void a(DataBuffer<am> paramDataBuffer, c paramc)
  {
    AppMethodBeat.i(203505);
    p.h(paramDataBuffer, "dataList");
    Object localObject = new StringBuilder("[CREATE] isPreloadMediaEnable=");
    com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sHP;
    localObject = ((StringBuilder)localObject).append(com.tencent.mm.plugin.finder.storage.b.cHT()).append(" isPreloadImageEnable=");
    localb = com.tencent.mm.plugin.finder.storage.b.sHP;
    ae.i("Finder.MediaPreloadCore", com.tencent.mm.plugin.finder.storage.b.cHU() + ' ' + "isShowPreloadView=" + stK);
    localObject = com.tencent.mm.plugin.finder.storage.b.sHP;
    if (!com.tencent.mm.plugin.finder.storage.b.cHT())
    {
      localObject = com.tencent.mm.plugin.finder.storage.b.sHP;
      if (!com.tencent.mm.plugin.finder.storage.b.cHU()) {}
    }
    else if (paramc != null)
    {
      paramc.a((d)new c(paramDataBuffer));
      AppMethodBeat.o(203505);
      return;
    }
    AppMethodBeat.o(203505);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(203515);
    p.h(paramb, "callback");
    Object localObject = this.stG;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.preload.worker.b)localObject).svw;
      if (localObject != null)
      {
        ((ConcurrentLinkedQueue)localObject).add(paramb);
        AppMethodBeat.o(203515);
        return;
      }
    }
    AppMethodBeat.o(203515);
  }
  
  public final void aiA(String paramString)
  {
    AppMethodBeat.i(203513);
    p.h(paramString, "mediaId");
    ae.i("Finder.MediaPreloadCore", "[startPreloadForTP] mediaId=".concat(String.valueOf(paramString)));
    if (this.stI)
    {
      aix("startPreloadForTP#".concat(String.valueOf(paramString)));
      this.stI = false;
    }
    AppMethodBeat.o(203513);
  }
  
  public final void aix(String paramString)
  {
    AppMethodBeat.i(203506);
    ae.i("Finder.MediaPreloadCore", "[onPreloadStart] source=".concat(String.valueOf(paramString)));
    paramString = this.stG;
    if (paramString != null)
    {
      if (paramString.dfZ.compareAndSet(true, false)) {
        paramString.cEV();
      }
      AppMethodBeat.o(203506);
      return;
    }
    AppMethodBeat.o(203506);
  }
  
  public final void aiz(String paramString)
  {
    AppMethodBeat.i(203512);
    p.h(paramString, "mediaId");
    ae.i("Finder.MediaPreloadCore", "[stopPreloadForTP] mediaId=".concat(String.valueOf(paramString)));
    if (!this.stI)
    {
      aiy("onMediaFocusForTP#".concat(String.valueOf(paramString)));
      this.stI = true;
    }
    AppMethodBeat.o(203512);
  }
  
  public final void bc(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(203510);
    p.h(paramString, "mediaId");
    ae.i("Finder.MediaPreloadCore", "[onMediaFocusDownload] mediaId=" + paramString + " isFocused=" + paramBoolean);
    if (cEN())
    {
      if (!paramBoolean) {
        break label113;
      }
      aiy("onMediaFocusDownload#".concat(String.valueOf(paramString)));
    }
    for (boolean bool = true;; bool = false)
    {
      this.stI = bool;
      if (this.stH != null) {
        com.tencent.mm.plugin.finder.preload.worker.a.aiF(paramString);
      }
      com.tencent.mm.plugin.finder.preload.worker.b localb = this.stG;
      if (localb == null) {
        break;
      }
      localb.be(paramString, paramBoolean);
      AppMethodBeat.o(203510);
      return;
      label113:
      aix("onMediaFocusDownload#".concat(String.valueOf(paramString)));
    }
    AppMethodBeat.o(203510);
  }
  
  public final void bd(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(203511);
    p.h(paramString, "mediaId");
    ae.i("Finder.MediaPreloadCore", "[onMediaFocusForTP] mediaId=" + paramString + " isFocused=" + paramBoolean);
    if (this.stH != null) {
      com.tencent.mm.plugin.finder.preload.worker.a.aiF(paramString);
    }
    com.tencent.mm.plugin.finder.preload.worker.b localb = this.stG;
    if (localb != null)
    {
      localb.be(paramString, paramBoolean);
      AppMethodBeat.o(203511);
      return;
    }
    AppMethodBeat.o(203511);
  }
  
  public final boolean cEN()
  {
    AppMethodBeat.i(203514);
    if ((getPreloadModel().suk >= 0) && (getPreloadModel().suj >= 0))
    {
      AppMethodBeat.o(203514);
      return true;
    }
    AppMethodBeat.o(203514);
    return false;
  }
  
  public final com.tencent.mm.plugin.finder.preload.model.a getPreloadModel()
  {
    AppMethodBeat.i(203504);
    com.tencent.mm.plugin.finder.preload.model.a locala = (com.tencent.mm.plugin.finder.preload.model.a)this.stF.getValue();
    AppMethodBeat.o(203504);
    return locala;
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(203508);
    super.onStart();
    if (!this.stI) {
      aix("Activity#onStart");
    }
    AppMethodBeat.o(203508);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(203509);
    super.onStop();
    if (!this.stI) {
      aiy("Activity#onStrop");
    }
    AppMethodBeat.o(203509);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore$Observer;", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "dataList", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "(Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;)V", "asyncHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "dispatchPreload", "", "centerFeed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "eventType", "", "isAsync", "", "isCareEvent", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onEventHappen", "ev", "onRelease", "plugin-finder_release"})
  public final class c
    extends d
  {
    private final DataBuffer<am> dataList;
    private final aq iaR;
    
    public c()
    {
      AppMethodBeat.i(203500);
      this.dataList = localObject;
      this.iaR = new aq("FinderMediaPreloadCore");
      AppMethodBeat.o(203500);
    }
    
    public final void a(com.tencent.mm.plugin.finder.event.base.b paramb)
    {
      AppMethodBeat.i(203498);
      p.h(paramb, "ev");
      if ((paramb instanceof h))
      {
        final BaseFinderFeed localBaseFinderFeed = ((h)paramb).rZP;
        final int j = ((h)paramb).type;
        if (localBaseFinderFeed != null)
        {
          long l = localBaseFinderFeed.lP();
          paramb = MediaPreloadCore.c(MediaPreloadCore.this);
          int i;
          label78:
          ArrayList localArrayList;
          label104:
          am localam;
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
            localam = (am)this.dataList.get(i);
            if (!(localam instanceof BaseFinderFeed)) {
              break label184;
            }
          }
          label179:
          label184:
          for (List localList = j.s((Collection)((BaseFinderFeed)localam).feedObject.getMediaList());; localList = (List)new ArrayList())
          {
            localArrayList.add(new o(localam, localList));
            i += 1;
            break label104;
            i = 0;
            break;
            paramb = null;
            break label78;
          }
          label199:
          localList = (List)localArrayList;
          this.iaR.post((Runnable)new a(localList, this, localBaseFinderFeed, j));
          MediaPreloadCore.a(MediaPreloadCore.this, paramb);
          AppMethodBeat.o(203498);
          return;
        }
      }
      label244:
      AppMethodBeat.o(203498);
    }
    
    public final boolean a(c paramc, com.tencent.mm.plugin.finder.event.base.b paramb)
    {
      AppMethodBeat.i(203497);
      p.h(paramc, "dispatcher");
      p.h(paramb, "event");
      if (((paramb instanceof h)) && ((((h)paramb).type == 6) || (((h)paramb).type == 7) || (((h)paramb).type == 0)))
      {
        AppMethodBeat.o(203497);
        return true;
      }
      AppMethodBeat.o(203497);
      return false;
    }
    
    public final boolean cAA()
    {
      return false;
    }
    
    public final void onRelease()
    {
      AppMethodBeat.i(203499);
      super.onRelease();
      MediaPreloadCore.a(MediaPreloadCore.this);
      com.tencent.mm.plugin.finder.preload.worker.b localb = MediaPreloadCore.b(MediaPreloadCore.this);
      if (localb != null)
      {
        localb.hmi = true;
        LinkedList localLinkedList = new LinkedList();
        localb.i("onClearAll", (d.g.a.a)new b.i(localb, localLinkedList));
        ae.i(localb.TAG, "[onClearAll] ".concat(String.valueOf(localLinkedList)));
        AppMethodBeat.o(203499);
        return;
      }
      AppMethodBeat.o(203499);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/preload/MediaPreloadCore$Observer$dispatchPreload$2$1"})
    static final class a
      implements Runnable
    {
      a(List paramList, MediaPreloadCore.c paramc, BaseFinderFeed paramBaseFinderFeed, int paramInt) {}
      
      public final void run()
      {
        AppMethodBeat.i(203496);
        com.tencent.mm.plugin.finder.preload.worker.b localb = MediaPreloadCore.b(jdField_this.stN);
        if (localb != null) {
          localb.a(localBaseFinderFeed, this.gIt, j);
        }
        if (MediaPreloadCore.a(jdField_this.stN) != null) {
          com.tencent.mm.plugin.finder.preload.worker.a.a(localBaseFinderFeed, this.gIt);
        }
        AppMethodBeat.o(203496);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.MediaPreloadCore
 * JD-Core Version:    0.7.0.1
 */