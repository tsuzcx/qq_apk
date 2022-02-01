package com.tencent.mm.plugin.finder.preload;

import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.event.base.h;
import com.tencent.mm.plugin.finder.feed.au;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.ca;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.preload.worker.b.l;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.FeedData.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.component.UIComponent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "commentScene", "", "focusMediaId", "", "imagePreloadWorker", "Lcom/tencent/mm/plugin/finder/preload/worker/ImagePreloadWorker;", "isWaitingPreload", "", "lastCenterFeed", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "preloadModel", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "getPreloadModel", "()Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "preloadModel$delegate", "Lkotlin/Lazy;", "videoDownloadProgressChangeListener", "com/tencent/mm/plugin/finder/preload/MediaPreloadCore$videoDownloadProgressChangeListener$1", "Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore$videoDownloadProgressChangeListener$1;", "videoPreloadWorker", "Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;", "checkProgressToAdjustPreload", "", "mediaId", "offset", "", "total", "bitrate", "curPlayPos", "isEnableWaitPreload", "onMediaFocusDownload", "isFocused", "onMediaFocusForTP", "onOnlineCachePlaying", "cacheTime", "timeDuration", "onPreloadStart", "source", "onPreloadStop", "onStart", "onStop", "registerCallback", "callback", "Lcom/tencent/mm/plugin/finder/preload/IVideoPreloadCallback;", "setup", "dataList", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "startPreloadForTP", "stopPreloadForTP", "unregisterCallback", "Companion", "MoovReadyInfo", "Observer", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends UIComponent
{
  private static boolean AAj;
  public static final f.a EUC;
  private int AJo;
  private final MediaPreloadCore.videoDownloadProgressChangeListener.1 EUD;
  private final j EUE;
  public final com.tencent.mm.plugin.finder.preload.worker.b EUF;
  private final com.tencent.mm.plugin.finder.preload.worker.a EUG;
  public boolean EUH;
  private String EUI;
  private FeedData EUJ;
  
  static
  {
    AppMethodBeat.i(346429);
    EUC = new f.a((byte)0);
    com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
    AAj = ((Boolean)com.tencent.mm.plugin.finder.storage.d.eSb().bmg()).booleanValue();
    AppMethodBeat.o(346429);
  }
  
  public f(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(346321);
    this.EUD = new MediaPreloadCore.videoDownloadProgressChangeListener.1(this, com.tencent.mm.app.f.hfK);
    this.EUE = k.cm((kotlin.g.a.a)d.EUM);
    paramAppCompatActivity = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (com.tencent.mm.plugin.finder.storage.d.eRh()) {}
    for (paramAppCompatActivity = new com.tencent.mm.plugin.finder.preload.worker.b(getPreloadModel());; paramAppCompatActivity = null)
    {
      this.EUF = paramAppCompatActivity;
      paramAppCompatActivity = com.tencent.mm.plugin.finder.storage.d.FAy;
      paramAppCompatActivity = localObject;
      if (com.tencent.mm.plugin.finder.storage.d.eRi()) {
        paramAppCompatActivity = new com.tencent.mm.plugin.finder.preload.worker.a();
      }
      this.EUG = paramAppCompatActivity;
      this.EUI = "";
      AppMethodBeat.o(346321);
      return;
    }
  }
  
  private final void azh(String paramString)
  {
    AppMethodBeat.i(346331);
    Log.i("Finder.MediaPreloadCore", s.X("[onPreloadStop] source=", paramString));
    paramString = this.EUF;
    if ((paramString != null) && (paramString.hue.compareAndSet(false, true))) {
      paramString.s("resetRunningTask", (kotlin.g.a.a)new b.l(paramString));
    }
    AppMethodBeat.o(346331);
  }
  
  public final void a(DataBuffer<cc> paramDataBuffer, int paramInt, c paramc)
  {
    AppMethodBeat.i(346446);
    s.u(paramDataBuffer, "dataList");
    Object localObject = new StringBuilder("[CREATE] commentScene=").append(paramInt).append(" isPreloadMediaEnable=");
    com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
    localObject = ((StringBuilder)localObject).append(com.tencent.mm.plugin.finder.storage.d.eRh()).append(" isPreloadImageEnable=");
    locald = com.tencent.mm.plugin.finder.storage.d.FAy;
    Log.i("Finder.MediaPreloadCore", com.tencent.mm.plugin.finder.storage.d.eRi() + " isShowPreloadView=" + AAj);
    this.AJo = paramInt;
    localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (!com.tencent.mm.plugin.finder.storage.d.eRh())
    {
      localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (!com.tencent.mm.plugin.finder.storage.d.eRi()) {}
    }
    else if (paramc != null)
    {
      paramc.a((com.tencent.mm.plugin.finder.event.base.d)new c(paramDataBuffer));
    }
    AppMethodBeat.o(346446);
  }
  
  public final void azg(String paramString)
  {
    AppMethodBeat.i(346457);
    Log.i("Finder.MediaPreloadCore", s.X("[onPreloadStart] source=", paramString));
    paramString = this.EUF;
    if ((paramString != null) && (paramString.hue.compareAndSet(true, false))) {
      paramString.eHV();
    }
    AppMethodBeat.o(346457);
  }
  
  public final void azi(String paramString)
  {
    AppMethodBeat.i(346496);
    s.u(paramString, "mediaId");
    Log.i("Finder.MediaPreloadCore", s.X("[stopPreloadForTP] mediaId=", paramString));
    if (!this.EUH)
    {
      azh(s.X("onMediaFocusForTP#", paramString));
      this.EUH = true;
    }
    AppMethodBeat.o(346496);
  }
  
  public final void bH(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(346478);
    s.u(paramString, "mediaId");
    Log.i("Finder.MediaPreloadCore", "[onMediaFocusDownload] mediaId=" + paramString + " isFocused=" + paramBoolean);
    if (eHH())
    {
      if (!paramBoolean) {
        break label110;
      }
      azh(s.X("onMediaFocusDownload#", paramString));
    }
    for (boolean bool = true;; bool = false)
    {
      this.EUH = bool;
      if (this.EUG != null) {
        com.tencent.mm.plugin.finder.preload.worker.a.azo(paramString);
      }
      com.tencent.mm.plugin.finder.preload.worker.b localb = this.EUF;
      if (localb != null) {
        localb.bJ(paramString, paramBoolean);
      }
      AppMethodBeat.o(346478);
      return;
      label110:
      azg(s.X("onMediaFocusDownload#", paramString));
    }
  }
  
  public final void bI(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(346487);
    s.u(paramString, "mediaId");
    Log.i("Finder.MediaPreloadCore", "[onMediaFocusForTP] mediaId=" + paramString + " isFocused=" + paramBoolean);
    if (paramBoolean) {
      this.EUI = paramString;
    }
    if (this.EUG != null) {
      com.tencent.mm.plugin.finder.preload.worker.a.azo(paramString);
    }
    com.tencent.mm.plugin.finder.preload.worker.b localb = this.EUF;
    if (localb != null) {
      localb.bJ(paramString, paramBoolean);
    }
    AppMethodBeat.o(346487);
  }
  
  public final boolean eHH()
  {
    AppMethodBeat.i(346504);
    if ((getPreloadModel().EVr >= 0) && (getPreloadModel().EVq >= 0))
    {
      AppMethodBeat.o(346504);
      return true;
    }
    AppMethodBeat.o(346504);
    return false;
  }
  
  public final com.tencent.mm.plugin.finder.preload.model.b getPreloadModel()
  {
    AppMethodBeat.i(346436);
    com.tencent.mm.plugin.finder.preload.model.b localb = (com.tencent.mm.plugin.finder.preload.model.b)this.EUE.getValue();
    AppMethodBeat.o(346436);
    return localb;
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(346465);
    super.onStart();
    if (!this.EUH) {
      azg("Activity#onStart");
    }
    this.EUD.alive();
    AppMethodBeat.o(346465);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(346471);
    super.onStop();
    if (!this.EUH) {
      azh("Activity#onStrop");
    }
    this.EUD.dead();
    AppMethodBeat.o(346471);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore$Observer;", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "dataList", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "(Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;)V", "asyncHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "dispatchPreload", "", "centerFeed", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "eventType", "", "findMediaList", "", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "feed", "isAsync", "", "isCareEvent", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onEventHappen", "ev", "onRelease", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class c
    extends com.tencent.mm.plugin.finder.event.base.d
  {
    private final DataBuffer<cc> dataList;
    private final MMHandler oEQ;
    
    public c()
    {
      AppMethodBeat.i(346229);
      this.dataList = localObject;
      this.oEQ = new MMHandler("FinderMediaPreloadCore");
      AppMethodBeat.o(346229);
    }
    
    private static final void a(f paramf, FeedData paramFeedData, List paramList, int paramInt)
    {
      AppMethodBeat.i(346235);
      s.u(paramf, "this$0");
      s.u(paramList, "$list");
      com.tencent.mm.plugin.finder.preload.worker.b localb = f.b(paramf);
      if (localb != null) {
        localb.a(f.d(paramf), paramFeedData, paramList, paramInt);
      }
      if (f.a(paramf) != null)
      {
        f.d(paramf);
        com.tencent.mm.plugin.finder.preload.worker.a.a(paramFeedData, paramList);
      }
      AppMethodBeat.o(346235);
    }
    
    public final void a(com.tencent.mm.plugin.finder.event.base.b paramb)
    {
      AppMethodBeat.i(346265);
      s.u(paramb, "ev");
      if ((paramb instanceof h))
      {
        FeedData localFeedData2 = ((h)paramb).AOy;
        int j = ((h)paramb).type;
        if (localFeedData2 != null)
        {
          paramb = f.this;
          long l = localFeedData2.getId();
          paramb = f.c(paramb);
          int i;
          label79:
          FeedData localFeedData1;
          label87:
          f localf;
          ArrayList localArrayList;
          label120:
          cc localcc;
          if ((paramb != null) && (l == paramb.getId()))
          {
            i = 1;
            if (i != 0) {
              break label193;
            }
            i = 1;
            if (i == 0) {
              break label198;
            }
            localFeedData1 = localFeedData2;
            if (localFeedData1 == null) {
              break label424;
            }
            localf = f.this;
            int k = this.dataList.getTotalSize();
            localArrayList = new ArrayList(k);
            i = 0;
            if (i >= k) {
              break label390;
            }
            localcc = (cc)this.dataList.get(i);
            if (!(localcc instanceof ca)) {
              break label204;
            }
            paramb = (List)((ca)localcc).eDE();
          }
          for (;;)
          {
            localArrayList.add(new r(localcc, p.J((Collection)paramb)));
            i += 1;
            break label120;
            i = 0;
            break;
            label193:
            i = 0;
            break label79;
            label198:
            localFeedData1 = null;
            break label87;
            label204:
            Object localObject;
            if ((localcc instanceof BaseFinderFeed))
            {
              paramb = new LinkedList();
              ((BaseFinderFeed)localcc).feedObject.setReplaceLongVideoToNormal(true);
              localObject = FeedData.Companion;
              localObject = (dji)p.oL((List)FeedData.a.l((BaseFinderFeed)localcc).getMediaList());
              if (localObject != null) {
                paramb.add(localObject);
              }
              paramb = (List)paramb;
            }
            else
            {
              if ((localcc instanceof au))
              {
                paramb = (BaseFinderFeed)p.oL((List)((au)localcc).rvFeedList);
                if (paramb == null) {
                  localObject = null;
                }
                for (;;)
                {
                  paramb = (com.tencent.mm.plugin.finder.event.base.b)localObject;
                  if (localObject != null) {
                    break;
                  }
                  paramb = (List)new LinkedList();
                  break;
                  paramb = paramb.feedObject;
                  if (paramb == null)
                  {
                    localObject = null;
                  }
                  else
                  {
                    paramb = paramb.getMediaList();
                    if (paramb == null) {
                      localObject = null;
                    } else {
                      localObject = p.J((Collection)paramb);
                    }
                  }
                }
              }
              paramb = (List)new LinkedList();
            }
          }
          label390:
          paramb = (List)localArrayList;
          this.oEQ.post(new f.c..ExternalSyntheticLambda0(localf, localFeedData2, paramb, j));
          f.a(localf, localFeedData1);
        }
      }
      label424:
      AppMethodBeat.o(346265);
    }
    
    public final boolean a(c paramc, com.tencent.mm.plugin.finder.event.base.b paramb)
    {
      AppMethodBeat.i(346247);
      s.u(paramc, "dispatcher");
      s.u(paramb, "event");
      if (((paramb instanceof h)) && ((((h)paramb).type == 6) || (((h)paramb).type == 7) || (((h)paramb).type == 0)))
      {
        AppMethodBeat.o(346247);
        return true;
      }
      AppMethodBeat.o(346247);
      return false;
    }
    
    public final boolean dXA()
    {
      return false;
    }
    
    public final void onRelease()
    {
      AppMethodBeat.i(346270);
      super.onRelease();
      f.a(f.this);
      com.tencent.mm.plugin.finder.preload.worker.b localb = f.b(f.this);
      if (localb != null)
      {
        localb.nzB = true;
        localb.eHU();
      }
      AppMethodBeat.o(346270);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.preload.model.b>
  {
    public static final d EUM;
    
    static
    {
      AppMethodBeat.i(346228);
      EUM = new d();
      AppMethodBeat.o(346228);
    }
    
    d()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.f
 * JD-Core Version:    0.7.0.1
 */