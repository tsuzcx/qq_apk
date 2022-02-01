package com.tencent.mm.plugin.finder.cgi.fetcher;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.aq.a;
import com.tencent.mm.plugin.finder.cgi.aq.c;
import com.tencent.mm.plugin.finder.cgi.aq.d;
import com.tencent.mm.plugin.finder.cgi.aq.e;
import com.tencent.mm.plugin.finder.cgi.ar.a;
import com.tencent.mm.plugin.finder.cgi.ar.c;
import com.tencent.mm.plugin.finder.cgi.interceptor.g;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.ay;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.avb;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bwf;
import com.tencent.mm.protocal.protobuf.bwg;
import com.tencent.mm.protocal.protobuf.bwj;
import com.tencent.mm.protocal.protobuf.bwl;
import com.tencent.mm.protocal.protobuf.dvl;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.component.k.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.f.c;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.ac;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.cb;
import kotlinx.coroutines.cx;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher;", "Lcom/tencent/mm/plugin/finder/life/SupportLifecycle;", "tabType", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "requestArgs", "Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderStreamRequestArgs;", "(ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderStreamRequestArgs;)V", "TAG", "", "curPullType", "getCurPullType", "()I", "setCurPullType", "(I)V", "enterSourceType", "getEnterSourceType", "isForPushScene", "", "()Z", "isGetHistory", "isLoading", "setLoading", "(Z)V", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "getLifeCycleKeeper", "()Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "setLifeCycleKeeper", "(Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;)V", "pageDataBuffer", "Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "getPageDataBuffer", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer;", "getRequestArgs", "()Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderStreamRequestArgs;", "setRequestArgs", "(Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderStreamRequestArgs;)V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "stateCache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM$Cache;", "tabStateVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "getTabType", "fetch", "", "callback", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "pullType", "consume", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "isPreloadMore", "isAuto", "unreadList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "innerFetch", "lb", "interceptAfterStore", "loadedInfo", "interceptors", "Lcom/tencent/mm/plugin/finder/cgi/interceptor/IFinderStreamInterceptor;", "interceptBeforeStore", "uniqueId", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends com.tencent.mm.plugin.finder.life.a
{
  final int AAd;
  public com.tencent.mm.vending.e.c<com.tencent.mm.vending.e.a> AAh;
  public d AEF;
  private final com.tencent.mm.plugin.finder.feed.model.internal.p<cc, com.tencent.mm.plugin.finder.feed.model.d> AEG;
  final com.tencent.mm.plugin.finder.viewmodel.d AEH;
  final com.tencent.mm.plugin.finder.viewmodel.d.a AEI;
  public volatile int AEJ;
  volatile boolean AEi;
  final bui Auc;
  final String TAG;
  public final int hJx;
  public volatile boolean isLoading;
  public final kotlinx.coroutines.aq scope;
  
  public e(int paramInt, bui parambui, d paramd)
  {
    AppMethodBeat.i(336828);
    this.hJx = paramInt;
    this.Auc = parambui;
    this.AEF = paramd;
    this.AAh = new com.tencent.mm.vending.e.c();
    this.scope = ar.d(cx.g(null).plus((kotlin.d.f)bg.kCi()));
    parambui = this.AEF;
    if (parambui == null) {}
    for (paramInt = 0;; paramInt = parambui.AAd)
    {
      this.AAd = paramInt;
      this.AEG = new com.tencent.mm.plugin.finder.feed.model.internal.p(null, String.valueOf(this.hJx), 1);
      parambui = com.tencent.mm.ui.component.k.aeZF;
      parambui = com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.d.class);
      s.s(parambui, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
      this.AEH = ((com.tencent.mm.plugin.finder.viewmodel.d)parambui);
      this.AEI = this.AEH.UV(this.hJx);
      this.TAG = s.X("Finder.TimelineFeedFetcher#", Integer.valueOf(this.hJx));
      AppMethodBeat.o(336828);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher$fetch$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "onFetchDone", "", "info", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "pullType", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements ar.a
  {
    a(ar.a parama) {}
    
    public final void a(com.tencent.mm.plugin.finder.feed.model.d paramd, int paramInt)
    {
      AppMethodBeat.i(336845);
      s.u(paramd, "info");
      this.AEw.a(paramd, paramInt);
      AppMethodBeat.o(336845);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.d.b.a.k
    implements m<kotlinx.coroutines.aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    b(e parame, int paramInt, com.tencent.mm.bx.b paramb, List<? extends BaseFinderFeed> paramList, boolean paramBoolean1, ar.c paramc, boolean paramBoolean2, ar.a parama, kotlin.d.d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(336853);
      paramd = new b(this.AEK, this.AEt, this.AEL, this.AEM, this.AEN, this.AEr, this.AEO, this.AEw, paramd);
      paramd.L$0 = paramObject;
      paramObject = (kotlin.d.d)paramd;
      AppMethodBeat.o(336853);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(336849);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(336849);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (kotlinx.coroutines.aq)this.L$0;
        Object localObject = (kotlin.g.a.a)new a(this.AEK, this.AEt, this.AEL, this.AEM, this.AEN, this.AEr, this.AEO, this.AEw);
        this.AEK.AEJ = this.AEt;
        this.AEK.isLoading = true;
        paramObject = (com.tencent.mm.plugin.datapreloader.a)new com.tencent.mm.plugin.finder.cgi.loadertask.b((kotlin.g.a.a)localObject, (cb)paramObject.getCoroutineContext().get((f.c)cb.ajws), (byte)0);
        localObject = (kotlin.d.d)this;
        this.label = 1;
        if (paramObject.e(true, (kotlin.d.d)localObject) == locala)
        {
          AppMethodBeat.o(336849);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      this.AEK.isLoading = false;
      paramObject = ah.aiuX;
      AppMethodBeat.o(336849);
      return paramObject;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<com.tencent.mm.plugin.finder.cgi.aq>
    {
      a(e parame, int paramInt, com.tencent.mm.bx.b paramb, List<? extends BaseFinderFeed> paramList, boolean paramBoolean1, ar.c paramc, boolean paramBoolean2, ar.a parama)
      {
        super();
      }
      
      @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher$innerFetch$1$initTask$1$2$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$IConfig;", "isBeginHistory", "", "isResultConsume", "errType", "", "errCode", "resp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "onBuildRequest", "", "request", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamRequestEx;", "onLoadFinish", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
      public static final class a
        implements aq.e
      {
        a(e parame, ar.c paramc, int paramInt, com.tencent.mm.plugin.finder.cgi.aq paramaq) {}
        
        public final boolean a(esc paramesc)
        {
          AppMethodBeat.i(336872);
          s.u(paramesc, "resp");
          ar.c localc = this.AEr;
          if (localc == null)
          {
            AppMethodBeat.o(336872);
            return false;
          }
          boolean bool = localc.b(paramesc);
          AppMethodBeat.o(336872);
          return bool;
        }
        
        public final void b(aq.c paramc)
        {
          AppMethodBeat.i(336918);
          s.u(paramc, "request");
          Object localObject1 = this.AEK.AEF;
          if (localObject1 != null)
          {
            localObject1 = ((d)localObject1).AEA;
            if (localObject1 != null) {
              paramc.AEA = ((com.tencent.mm.bx.b)localObject1);
            }
          }
          localObject1 = this.AEK.AEF;
          if (localObject1 != null)
          {
            localObject1 = ((d)localObject1).AEz;
            if (localObject1 != null) {
              paramc.aaeU = ((Number)localObject1).longValue();
            }
          }
          localObject1 = this.AEK.AEF;
          if (localObject1 != null)
          {
            localObject1 = ((d)localObject1).AEB;
            if (localObject1 != null) {
              paramc.tabTipsByPassInfo = ((com.tencent.mm.bx.b)localObject1);
            }
          }
          localObject1 = this.AEK.AEF;
          Object localObject2;
          label147:
          Object localObject3;
          int i;
          long l;
          label311:
          label333:
          label354:
          label485:
          boolean bool;
          if (localObject1 == null)
          {
            localObject2 = null;
            localObject1 = this.AEK.AEF;
            if (localObject1 != null) {
              break label869;
            }
            localObject1 = null;
            localObject3 = this.AEK;
            Object localObject4;
            if ((localObject2 != null) && (localObject1 != null))
            {
              i = ((Number)localObject2).intValue();
              localObject2 = new avb();
              ((avb)localObject2).ZFr = i;
              ((avb)localObject2).ZFs = ((com.tencent.mm.bx.b)localObject1);
              localObject4 = ah.aiuX;
              paramc.ZKG = ((avb)localObject2);
              localObject2 = ((e)localObject3).TAG;
              localObject3 = new StringBuilder("byPassInfoType=").append(i).append(" byPassInfo=");
              localObject1 = ((com.tencent.mm.bx.b)localObject1).toByteArray();
              s.s(localObject1, "v2.toByteArray()");
              Log.i((String)localObject2, new String((byte[])localObject1, kotlin.n.d.UTF_8));
            }
            if (this.AEK.AAd == 1)
            {
              localObject3 = new bwg();
              localObject4 = this.AEK;
              localObject1 = ((e)localObject4).AEF;
              if (localObject1 != null) {
                break label879;
              }
              l = 0L;
              ((bwg)localObject3).object_id = l;
              localObject1 = ((e)localObject4).AEF;
              if (localObject1 != null) {
                break label888;
              }
              localObject1 = "";
              ((bwg)localObject3).object_nonce_id = ((String)localObject1);
              localObject1 = ((e)localObject4).AEF;
              if (localObject1 != null) {
                break label911;
              }
              i = 0;
              ((bwg)localObject3).aaeL = i;
              Log.i(((e)localObject4).TAG, s.X("related_info=", com.tencent.mm.ae.d.hF(((bwg)localObject3).object_id)));
              localObject1 = ah.aiuX;
              paramc.aaeZ = ((bwg)localObject3);
            }
            localObject1 = this.AEK.AEF;
            if (localObject1 != null) {
              break label920;
            }
            i = 0;
            label408:
            if (i > 0)
            {
              localObject3 = paramc.aaeV;
              localObject4 = new bwl();
              e locale = this.AEK;
              LinkedList localLinkedList = ((bwl)localObject4).ZIQ;
              dvl localdvl = new dvl();
              localObject1 = locale.AEF;
              if (localObject1 != null) {
                break label929;
              }
              l = 0L;
              label463:
              localdvl.object_id = l;
              localObject1 = locale.AEF;
              if (localObject1 != null) {
                break label938;
              }
              localObject1 = "";
              localdvl.object_nonce_id = ((String)localObject1);
              Log.i(locale.TAG, s.X("top_objects=", com.tencent.mm.ae.d.hF(localdvl.object_id)));
              localObject1 = ah.aiuX;
              localLinkedList.add(localdvl);
              localObject1 = locale.AEF;
              if (localObject1 != null) {
                break label961;
              }
              i = 0;
              label540:
              ((bwl)localObject4).ZFJ = i;
              localObject1 = ah.aiuX;
              ((LinkedList)localObject3).add(localObject4);
            }
            if ((this.AEt == 0) || (this.AEt == 1))
            {
              localObject2 = new bwj();
              localObject1 = this.AEK;
              localObject3 = this.AEP;
              ((bwj)localObject2).ZJy = ((e)localObject1).AEH.GKo.ZJy;
              ((bwj)localObject2).aafr = ((e)localObject1).AEH.GKo.aafr;
              localObject4 = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager();
              if (((i)localObject4).Su("TLRecommendTab") == null) {
                break label970;
              }
              bool = true;
              label655:
              ((bwj)localObject2).aafq = bool;
              if (((i)localObject4).Su("TLFollow") == null) {
                break label976;
              }
              bool = true;
              label676:
              ((bwj)localObject2).aafp = bool;
              if (((i)localObject4).Su("finder_tl_hot_tab") == null) {
                break label982;
              }
              bool = true;
              label697:
              ((bwj)localObject2).aafo = bool;
              localObject4 = ((e)localObject1).AEF;
              if ((localObject4 == null) || (((d)localObject4).AED != true)) {
                break label988;
              }
              i = 1;
              label727:
              if (i == 0) {
                break label993;
              }
              i = 0;
              label733:
              ((bwj)localObject2).aafs = i;
              localObject3 = ((e)localObject1).TAG;
              localObject4 = new StringBuilder("[onBuildRequest] FinderStream, from_tab_type = ").append(((bwj)localObject2).aafs).append(", requestArgs?.isFirstEnterFetch = ");
              localObject1 = ((e)localObject1).AEF;
              if (localObject1 != null) {
                break label1002;
              }
              localObject1 = null;
              label787:
              Log.i((String)localObject3, localObject1);
              localObject1 = ah.aiuX;
              paramc.aaeY = ((bwj)localObject2);
              localObject1 = this.AEK.TAG;
              paramc = paramc.aaeY;
              if (paramc != null) {
                break label1015;
              }
            }
          }
          label869:
          label879:
          label1015:
          for (paramc = null;; paramc = com.tencent.mm.ae.f.dh(paramc))
          {
            Log.i((String)localObject1, s.X("[onBuildRequest] FinderStream scene_status=", paramc));
            this.AEK.AEF = null;
            AppMethodBeat.o(336918);
            return;
            localObject2 = ((d)localObject1).AEC;
            break;
            localObject1 = ((d)localObject1).AEB;
            break label147;
            l = ((d)localObject1).hKN;
            break label311;
            label888:
            localObject2 = ((d)localObject1).nonceId;
            localObject1 = localObject2;
            if (localObject2 != null) {
              break label333;
            }
            localObject1 = "";
            break label333;
            i = ((d)localObject1).ACA;
            break label354;
            i = ((d)localObject1).sourceType;
            break label408;
            l = ((d)localObject1).hKN;
            break label463;
            localObject2 = ((d)localObject1).nonceId;
            localObject1 = localObject2;
            if (localObject2 != null) {
              break label485;
            }
            localObject1 = "";
            break label485;
            i = ((d)localObject1).sourceType;
            break label540;
            bool = false;
            break label655;
            bool = false;
            break label676;
            bool = false;
            break label697;
            i = 0;
            break label727;
            i = ((com.tencent.mm.plugin.finder.cgi.aq)localObject3).hJx;
            break label733;
            localObject1 = Boolean.valueOf(((d)localObject1).AED);
            break label787;
          }
        }
        
        public final boolean dVn()
        {
          return this.AEK.AEi;
        }
        
        public final void dVo()
        {
          this.AEK.isLoading = false;
        }
      }
      
      @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher$innerFetch$1$initTask$1$2$2", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$Callback;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "interceptors", "", "Lcom/tencent/mm/plugin/finder/cgi/interceptor/IFinderStreamInterceptor;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
      public static final class b
        implements aq.a
      {
        b(int paramInt, e parame, com.tencent.mm.plugin.finder.cgi.aq paramaq, boolean paramBoolean, ar.a parama) {}
        
        public final void a(int paramInt1, int paramInt2, String paramString, final aq.d paramd, List<? extends g> paramList)
        {
          AppMethodBeat.i(336870);
          s.u(paramd, "resp");
          s.u(paramList, "interceptors");
          label316:
          boolean bool2;
          if ((paramInt1 == 0) && (paramInt2 == 0))
          {
            if (this.AEt == 0)
            {
              Log.i(this.AEK.TAG, "tabType=" + this.AEP.hJx + " headWording=" + paramd.aafa + " endWording=" + paramd.aafb + " prefetch_last_feed_count=" + paramd.aafe + '}');
              h.baE().ban().set(at.a.adcl, paramd.aafa);
              h.baE().ban().set(at.a.adcm, paramd.aafb);
              h.baE().ban().set(at.a.adcp, Integer.valueOf(paramd.aafe));
            }
            if (paramd.aafk != null)
            {
              localObject2 = h.baE().ban();
              localObject3 = at.a.adcn;
              localObject1 = paramd.aafk;
              if (localObject1 != null) {
                break label316;
              }
            }
            for (Object localObject1 = null;; localObject1 = ((bwf)localObject1).toByteArray())
            {
              ((com.tencent.mm.storage.aq)localObject2).set((at.a)localObject3, Util.encodeHexString((byte[])localObject1));
              localObject1 = com.tencent.mm.ui.component.k.aeZF;
              ((com.tencent.mm.plugin.finder.preload.tabPreload.c)com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.preload.tabPreload.c.class)).Ro(this.AEP.hJx);
              localObject1 = this.AEK.AEF;
              if (localObject1 != null) {
                ((d)localObject1).AEz = null;
              }
              localObject1 = MMApplicationContext.getResources().getString(e.h.finder_timeline_history_header_tip);
              s.s(localObject1, "getResources()\n         …eline_history_header_tip)");
              localObject1 = h.baE().ban().get(at.a.adcl, localObject1);
              if (localObject1 != null) {
                break;
              }
              paramString = new NullPointerException("null cannot be cast to non-null type kotlin.String");
              AppMethodBeat.o(336870);
              throw paramString;
            }
            localObject1 = (String)localObject1;
            Object localObject2 = MMApplicationContext.getResources().getString(e.h.finder_timeline_history_footer_tip);
            s.s(localObject2, "getResources()\n         …eline_history_footer_tip)");
            localObject2 = h.baE().ban().get(at.a.adcm, localObject2);
            if (localObject2 == null)
            {
              paramString = new NullPointerException("null cannot be cast to non-null type kotlin.String");
              AppMethodBeat.o(336870);
              throw paramString;
            }
            Object localObject3 = (String)localObject2;
            localObject2 = paramd.object;
            s.s(localObject2, "resp.`object`");
            Object localObject4 = (Iterable)localObject2;
            localObject2 = (Collection)new ArrayList();
            localObject4 = ((Iterable)localObject4).iterator();
            Object localObject6;
            Object localObject7;
            while (((Iterator)localObject4).hasNext())
            {
              localObject5 = ((Iterator)localObject4).next();
              localObject6 = (FinderObject)localObject5;
              localObject7 = av.GiL;
              s.s(localObject6, "it");
              if (av.y((FinderObject)localObject6)) {
                ((Collection)localObject2).add(localObject5);
              }
            }
            Object localObject5 = (List)localObject2;
            if (((List)localObject5).size() < paramd.object.size())
            {
              Log.e(this.AEK.TAG, "[onCgiBack] has filter some feed. valid=" + ((List)localObject5).size() + " raw=" + paramd.object.size());
              com.tencent.mm.ae.e.a.a((com.tencent.mm.ae.e)com.tencent.mm.plugin.findersdk.b.HbT, "finderStreamReturnInvalidFeed", true, (kotlin.g.a.a)new a(this.AEP, this.AEt, (List)localObject5, paramd));
            }
            if (paramd.aafc > 0) {}
            for (boolean bool1 = true;; bool1 = false)
            {
              localObject2 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
              localObject2 = av.GiL;
              localObject4 = (Iterable)com.tencent.mm.plugin.finder.storage.logic.d.a.a((List)localObject5, av.Ui(this.AEP.hJx), this.AEK.Auc);
              localObject2 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject4, 10));
              localObject4 = ((Iterable)localObject4).iterator();
              while (((Iterator)localObject4).hasNext())
              {
                localObject6 = (FinderItem)((Iterator)localObject4).next();
                localObject7 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
                ((Collection)localObject2).add(com.tencent.mm.plugin.finder.storage.logic.d.a.a((FinderItem)localObject6));
              }
            }
            localObject2 = new LinkedList((Collection)localObject2);
            localObject4 = new com.tencent.mm.plugin.finder.feed.model.d((List)localObject2, paramInt1, paramInt2, paramString);
            ((com.tencent.mm.plugin.finder.feed.model.d)localObject4).hJx = this.AEP.hJx;
            ((com.tencent.mm.plugin.finder.feed.model.d)localObject4).AAs = Math.min(paramd.AAs, ((List)localObject5).size());
            ((com.tencent.mm.plugin.finder.feed.model.d)localObject4).qpb = Math.min(paramd.qpb, ((List)localObject5).size());
            ((com.tencent.mm.plugin.finder.feed.model.d)localObject4).AAt = paramd.AAt;
            ((com.tencent.mm.plugin.finder.feed.model.d)localObject4).pullType = this.AEt;
            ((com.tencent.mm.plugin.finder.feed.model.d)localObject4).BeH = ((String)localObject1);
            ((com.tencent.mm.plugin.finder.feed.model.d)localObject4).AZa = ((String)localObject3);
            ((com.tencent.mm.plugin.finder.feed.model.d)localObject4).BeA = paramd.continueFlag;
            ((com.tencent.mm.plugin.finder.feed.model.d)localObject4).Bey = ((List)localObject5);
            ((com.tencent.mm.plugin.finder.feed.model.d)localObject4).BeB = paramd.AAu;
            ((com.tencent.mm.plugin.finder.feed.model.d)localObject4).AEi = this.AEK.AEi;
            ((com.tencent.mm.plugin.finder.feed.model.d)localObject4).lastBuffer = paramd.lastBuffer;
            ((com.tencent.mm.plugin.finder.feed.model.d)localObject4).preloadInfo = paramd.preloadInfo;
            ((com.tencent.mm.plugin.finder.feed.model.d)localObject4).BeD = paramd.aafi;
            ((com.tencent.mm.plugin.finder.feed.model.d)localObject4).Bez = paramd.Bez;
            if (paramd.aafc != 0)
            {
              bool2 = true;
              ((com.tencent.mm.plugin.finder.feed.model.d)localObject4).isNeedClear = bool2;
              ((com.tencent.mm.plugin.finder.feed.model.d)localObject4).BeF = paramd.BeF;
              ((com.tencent.mm.plugin.finder.feed.model.d)localObject4).BeG = paramd;
              e.a(this.AEK, (com.tencent.mm.plugin.finder.feed.model.d)localObject4, paramList);
              if ((this.AEt != 2) && (this.AEK.AAd != 1))
              {
                paramString = com.tencent.mm.plugin.finder.storage.logic.d.FND;
                paramString = (List)localObject2;
                localObject1 = av.GiL;
                com.tencent.mm.plugin.finder.storage.logic.d.a.c(paramString, av.Ui(this.AEP.hJx), bool1);
              }
              e.b(this.AEK, (com.tencent.mm.plugin.finder.feed.model.d)localObject4, paramList);
              if ((this.AEt == 0) || (this.AEt == 1))
              {
                paramString = ay.EDk;
                ay.D(this.AEP.hJx, (List)localObject5);
              }
              if (this.AEO)
              {
                paramList = h.baE().ban();
                paramString = av.GiL;
                localObject1 = av.Uh(this.AEP.hJx);
                if (paramd.lastBuffer != null) {
                  break label1230;
                }
                paramString = null;
                paramList.set((at.a)localObject1, paramString);
              }
              this.AEK.AEi = paramd.AAu;
              this.AEw.a((com.tencent.mm.plugin.finder.feed.model.d)localObject4, this.AEt);
              if ((this.AEt == 0) || (this.AEt == 1) || (this.AEt == 4))
              {
                paramString = com.tencent.mm.plugin.finder.extension.reddot.d.APW;
                com.tencent.mm.plugin.finder.extension.reddot.d.a(paramd, (List)localObject2);
              }
            }
          }
          for (;;)
          {
            paramString = this.AEK.AEF;
            if (paramString != null) {
              paramString.AEA = null;
            }
            paramString = this.AEK.AEF;
            if (paramString != null) {
              paramString.AED = false;
            }
            AppMethodBeat.o(336870);
            return;
            bool2 = false;
            break;
            label1230:
            paramString = paramd.lastBuffer;
            if (paramString == null) {}
            for (paramString = null;; paramString = paramString.toByteArray())
            {
              paramString = Util.encodeHexString(paramString);
              break;
            }
            paramString = new com.tencent.mm.plugin.finder.feed.model.d((List)new LinkedList(), paramInt1, paramInt2, paramString);
            paramString.hJx = this.AEP.hJx;
            paramString.pullType = this.AEt;
            paramString.BeA = 1;
            paramString.BeB = paramd.AAu;
            paramString.lastBuffer = paramd.lastBuffer;
            this.AEw.a(paramString, this.AEt);
          }
        }
        
        @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
        static final class a
          extends u
          implements kotlin.g.a.a<String>
        {
          a(com.tencent.mm.plugin.finder.cgi.aq paramaq, int paramInt, List<? extends FinderObject> paramList, aq.d paramd)
          {
            super();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.fetcher.e
 * JD-Core Version:    0.7.0.1
 */