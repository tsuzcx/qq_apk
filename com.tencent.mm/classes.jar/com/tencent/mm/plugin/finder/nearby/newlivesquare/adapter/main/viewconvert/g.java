package com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.viewconvert;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.d.a.a.a.b.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.b.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.loader.p;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.r;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.protocal.protobuf.aub;
import com.tencent.mm.protocal.protobuf.azl;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.bb;
import kotlinx.coroutines.cb;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/LivingConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/convertdata/base/LiveConvertData;", "forceNightMode", "", "width", "", "aspectRatio", "", "outsideOperator", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/InnerAdapterLinkOutsideOperator;", "jumProfileCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "feedId", "", "username", "", "(ZIFLcom/tencent/mm/plugin/finder/nearby/newlivesquare/InnerAdapterLinkOutsideOperator;Lkotlin/jvm/functions/Function2;)V", "getAspectRatio", "()F", "getForceNightMode", "()Z", "getJumProfileCallback", "()Lkotlin/jvm/functions/Function2;", "getOutsideOperator", "()Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/InnerAdapterLinkOutsideOperator;", "rootLayout", "Landroid/view/ViewGroup;", "getWidth", "()I", "bindCover", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "localFinderMedia", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "feed", "bindDesc", "mediaObj", "item", "bindLive", "tagObject", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/LivingConvert$TagObject;", "bindUserInfo", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "clear", "getImageLoadOption", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "getLayoutId", "jumpProfile", "context", "Landroid/content/Context;", "onBindViewHolder", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onViewRecycled", "refreshLiveStatusInfo", "renderWatchCountHistoryTv", "watchCountHistoryTv", "Landroid/widget/TextView;", "participantCountString", "participantCount", "requestParticipantCount", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/LivingConvert$RequestAndRefreshLiveInfo;", "nonceId", "(Landroid/content/Context;JLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "RequestAndRefreshLiveInfo", "TagObject", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends f<com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.base.b>
{
  public static final a EOf;
  private final boolean ANb;
  private final m<Long, String, ah> ANd;
  private final com.tencent.mm.plugin.finder.nearby.newlivesquare.b ENg;
  private final float aspectRatio;
  private final int width;
  private ViewGroup xcW;
  
  static
  {
    AppMethodBeat.i(340633);
    EOf = new a((byte)0);
    AppMethodBeat.o(340633);
  }
  
  public g(int paramInt, float paramFloat, com.tencent.mm.plugin.finder.nearby.newlivesquare.b paramb, m<? super Long, ? super String, ah> paramm)
  {
    AppMethodBeat.i(340527);
    this.ANb = true;
    this.width = paramInt;
    this.aspectRatio = paramFloat;
    this.ENg = paramb;
    this.ANd = paramm;
    AppMethodBeat.o(340527);
  }
  
  private final void B(long paramLong, String paramString)
  {
    AppMethodBeat.i(340577);
    this.ANd.invoke(Long.valueOf(paramLong), paramString);
    AppMethodBeat.o(340577);
  }
  
  private static void F(j paramj)
  {
    AppMethodBeat.i(340586);
    Object localObject = paramj.tag;
    Application.ActivityLifecycleCallbacks localActivityLifecycleCallbacks;
    if ((localObject != null) && ((localObject instanceof c)))
    {
      ((c)localObject).akhS = null;
      ar.a(((c)localObject).scope, null);
      localActivityLifecycleCallbacks = ((c)localObject).ENK;
      if (localActivityLifecycleCallbacks != null)
      {
        localObject = MMApplicationContext.getContext().getApplicationContext();
        if (!(localObject instanceof Application)) {
          break label91;
        }
      }
    }
    label91:
    for (localObject = (Application)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((Application)localObject).unregisterActivityLifecycleCallbacks(localActivityLifecycleCallbacks);
      }
      paramj.tag = null;
      AppMethodBeat.o(340586);
      return;
    }
  }
  
  private static final void a(BaseFinderFeed paramBaseFinderFeed, j paramj, g paramg, View paramView)
  {
    AppMethodBeat.i(370513);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramBaseFinderFeed);
    localb.cH(paramj);
    localb.cH(paramg);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/LivingConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramBaseFinderFeed, "$item");
    s.u(paramj, "$holder");
    s.u(paramg, "this$0");
    ((ce)h.ax(ce.class)).a(paramBaseFinderFeed, paramj.KJ(), "94");
    s.s(paramj.context, "holder.context");
    paramg.B(paramBaseFinderFeed.bZA(), paramBaseFinderFeed.feedObject.getUserName());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/LivingConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(370513);
  }
  
  private final void a(final com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.base.b paramb, c paramc, final j paramj)
  {
    AppMethodBeat.i(370506);
    com.tencent.d.a.a.a.b localb = (com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class);
    Object localObject = paramb.feedObject.getLiveInfo();
    if (localObject == null) {}
    for (long l = 0L;; l = ((bip)localObject).liveId)
    {
      localObject = paramj.context;
      if (localObject != null) {
        break;
      }
      paramb = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(370506);
      throw paramb;
    }
    localb.getLiveInfo(l, false, (com.tencent.mm.vending.e.b)localObject, (b.d)new g(paramc, paramb, paramj, this));
    AppMethodBeat.o(370506);
  }
  
  private static void b(TextView paramTextView, String paramString, int paramInt)
  {
    AppMethodBeat.i(340570);
    CharSequence localCharSequence = (CharSequence)paramString;
    int i;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if ((i == 0) || (paramInt <= 0)) {
        break label112;
      }
      paramString = r.TT(paramInt);
    }
    label99:
    label112:
    for (;;)
    {
      localCharSequence = (CharSequence)paramString;
      if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
      for (paramInt = 1;; paramInt = 0)
      {
        if (paramInt != 0) {
          break label99;
        }
        paramTextView.setText((CharSequence)paramString);
        paramTextView.setVisibility(0);
        AppMethodBeat.o(340570);
        return;
        i = 0;
        break;
      }
      paramTextView.setVisibility(8);
      AppMethodBeat.o(340570);
      return;
    }
  }
  
  private static final void b(BaseFinderFeed paramBaseFinderFeed, j paramj, g paramg, View paramView)
  {
    AppMethodBeat.i(370514);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramBaseFinderFeed);
    localb.cH(paramj);
    localb.cH(paramg);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/LivingConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramBaseFinderFeed, "$item");
    s.u(paramj, "$holder");
    s.u(paramg, "this$0");
    ((ce)h.ax(ce.class)).a(paramBaseFinderFeed, paramj.KJ(), "94");
    s.s(paramj.context, "holder.context");
    paramg.B(paramBaseFinderFeed.bZA(), paramBaseFinderFeed.feedObject.getUserName());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/LivingConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(370514);
  }
  
  private final e kLv()
  {
    AppMethodBeat.i(370510);
    if (this.ANb)
    {
      localObject = p.ExI;
      localObject = p.a(p.a.ExX);
      AppMethodBeat.o(370510);
      return localObject;
    }
    Object localObject = p.ExI;
    localObject = p.a(p.a.ExJ);
    AppMethodBeat.o(370510);
    return localObject;
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(340655);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    AppMethodBeat.o(340655);
  }
  
  public final int getLayoutId()
  {
    return e.f.nearby_feed_live_live_of_normal_live_item;
  }
  
  public final void m(j paramj)
  {
    AppMethodBeat.i(370540);
    s.u(paramj, "holder");
    super.m(paramj);
    Log.i("Finder.LivingConvert", s.X("#onViewRecycled holder=", paramj));
    F(paramj);
    AppMethodBeat.o(370540);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/LivingConvert$Companion;", "", "()V", "TAG", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/LivingConvert$RequestAndRefreshLiveInfo;", "", "interval", "", "participantCount", "(II)V", "getInterval", "()I", "getParticipantCount", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    final int EOg;
    final int interval;
    
    public b(int paramInt1, int paramInt2)
    {
      this.interval = paramInt1;
      this.EOg = paramInt2;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof b)) {
          return false;
        }
        paramObject = (b)paramObject;
        if (this.interval != paramObject.interval) {
          return false;
        }
      } while (this.EOg == paramObject.EOg);
      return false;
    }
    
    public final int hashCode()
    {
      return this.interval * 31 + this.EOg;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(340502);
      String str = "RequestAndRefreshLiveInfo(interval=" + this.interval + ", participantCount=" + this.EOg + ')';
      AppMethodBeat.o(340502);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/LivingConvert$TagObject;", "", "(Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/LivingConvert;)V", "item", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/convertdata/base/LiveConvertData;", "getItem", "()Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/convertdata/base/LiveConvertData;", "setItem", "(Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/convertdata/base/LiveConvertData;)V", "lifeCallback", "Landroid/app/Application$ActivityLifecycleCallbacks;", "getLifeCallback", "()Landroid/app/Application$ActivityLifecycleCallbacks;", "setLifeCallback", "(Landroid/app/Application$ActivityLifecycleCallbacks;)V", "refreshWatchCountJpb", "Lkotlinx/coroutines/Job;", "getRefreshWatchCountJpb", "()Lkotlinx/coroutines/Job;", "setRefreshWatchCountJpb", "(Lkotlinx/coroutines/Job;)V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  final class c
  {
    Application.ActivityLifecycleCallbacks ENK;
    cb akhR;
    com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.base.b akhS;
    final aq scope;
    
    public c()
    {
      AppMethodBeat.i(340482);
      this.scope = ar.kBZ();
      AppMethodBeat.o(340482);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends k
    implements m<aq, d<? super ah>, Object>
  {
    int label;
    
    d(g paramg, j paramj, com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.base.b paramb, TextView paramTextView, d<? super d> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(340495);
      paramObject = (d)new d(this.EOh, this.wHm, this.EOi, this.EOj, paramd);
      AppMethodBeat.o(340495);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(340492);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(340492);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
      }
      for (;;)
      {
        paramObject = this.wHm.context;
        s.s(paramObject, "holder.context");
        long l = this.EOi.bZA();
        Object localObject = this.EOi.feedObject.getObjectNonceId();
        d locald = (d)this;
        this.label = 1;
        localObject = g.a(paramObject, l, (String)localObject, locald);
        paramObject = localObject;
        if (localObject == locala)
        {
          AppMethodBeat.o(340492);
          return locala;
          ResultKt.throwOnFailure(paramObject);
        }
        paramObject = (g.b)paramObject;
        Log.i("Finder.LivingConvert", s.X("#bindLive async requestParticipantCount interval=", paramObject));
        if (paramObject.interval <= 0)
        {
          paramObject = ah.aiuX;
          AppMethodBeat.o(340492);
          return paramObject;
        }
        localObject = this.EOj;
        s.s(localObject, "watchCountHistoryTv");
        g.c((TextView)localObject, "", paramObject.EOg);
        l = paramObject.interval;
        paramObject = (d)this;
        this.label = 2;
        if (bb.e(l * 1000L, paramObject) == locala)
        {
          AppMethodBeat.o(340492);
          return locala;
          ResultKt.throwOnFailure(paramObject);
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/LivingConvert$onBindViewHolder$1", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/tools/SampleLifecycleCallbacks;", "onActivityDestroyed", "", "activity", "Landroid/app/Activity;", "onActivityResumed", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.viewconvert.tools.a
  {
    e(g paramg, j paramj, com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.base.b paramb, g.c paramc) {}
    
    public final void onActivityDestroyed(Activity paramActivity)
    {
      AppMethodBeat.i(340486);
      s.u(paramActivity, "activity");
      if (aH(paramActivity))
      {
        Log.i("Finder.LivingConvert", "#lifeCallback-onActivityDestroyed");
        g.G(this.wHm);
      }
      AppMethodBeat.o(340486);
    }
    
    public final void onActivityResumed(Activity paramActivity)
    {
      AppMethodBeat.i(370544);
      s.u(paramActivity, "activity");
      super.onActivityResumed(paramActivity);
      if (aH(paramActivity))
      {
        Log.i("Finder.LivingConvert", "#lifeCallback-onActivityResumed");
        g.a(this.EOh, this.akhT, this.akhU, this.wHm);
      }
      AppMethodBeat.o(370544);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderBatchGetObjectAsyncLoadInfoResponse;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.b<b.a<aub>, ah>
  {
    f(String paramString, d<? super g.b> paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/LivingConvert$refreshLiveStatusInfo$1", "Lcom/tencent/plugin/finder/live/api/IPluginFinderLive$FinderLiveStatusCallback;", "onLiveStatusCallback", "", "respLiveId", "", "status", "", "liveInfoResp", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements b.d
  {
    g(g.c paramc, com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.base.b paramb, j paramj, g paramg) {}
    
    public final void onLiveStatusCallback(long paramLong, int paramInt, Object paramObject)
    {
      long l2 = 0L;
      Object localObject2 = null;
      AppMethodBeat.i(370533);
      Object localObject1 = this.akhU.akhS;
      long l1;
      if (localObject1 == null) {
        l1 = l2;
      }
      while (l1 != paramLong)
      {
        Log.i("Finder.LivingConvert", "#refreshLiveStatus oh, return live id " + paramLong + " is not you.");
        AppMethodBeat.o(370533);
        return;
        localObject1 = ((BaseFinderFeed)localObject1).feedObject;
        l1 = l2;
        if (localObject1 != null)
        {
          localObject1 = ((FinderItem)localObject1).getLiveInfo();
          l1 = l2;
          if (localObject1 != null) {
            l1 = ((bip)localObject1).liveId;
          }
        }
      }
      if (!(paramObject instanceof azl))
      {
        AppMethodBeat.o(370533);
        return;
      }
      localObject1 = this.akhU.akhS;
      if (localObject1 == null)
      {
        localObject1 = null;
        if (localObject1 != null)
        {
          paramObject = ((azl)paramObject).liveInfo;
          if (paramObject != null) {
            break label307;
          }
          paramObject = localObject2;
          label165:
          ((bip)localObject1).liveStatus = paramObject.intValue();
        }
        paramObject = this.akhU.akhS;
        if (paramObject == null) {
          break label320;
        }
        paramObject = paramObject.feedObject;
        if (paramObject == null) {
          break label320;
        }
        paramObject = paramObject.getLiveInfo();
        if ((paramObject == null) || (paramObject.liveStatus != 1)) {
          break label320;
        }
      }
      label307:
      label320:
      for (boolean bool = true;; bool = false)
      {
        g.a(paramb, paramj, jdField_this, bool);
        Log.i("Finder.LivingConvert", "#refreshLiveStatus return live id " + paramLong + " is you. is living? " + bool);
        AppMethodBeat.o(370533);
        return;
        localObject1 = ((BaseFinderFeed)localObject1).feedObject;
        if (localObject1 == null)
        {
          localObject1 = null;
          break;
        }
        localObject1 = ((FinderItem)localObject1).getLiveInfo();
        break;
        paramObject = Integer.valueOf(paramObject.liveStatus);
        break label165;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.viewconvert.g
 * JD-Core Version:    0.7.0.1
 */