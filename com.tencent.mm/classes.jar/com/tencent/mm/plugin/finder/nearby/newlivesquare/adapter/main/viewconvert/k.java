package com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.viewconvert;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.d.a.a.a.b.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.b.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.loader.p;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.l;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/RelatedLivingConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/convertdata/RelatedLivingOfLiveConvertData;", "forceNightMode", "", "width", "", "aspectRatio", "", "outsideOperator", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/InnerAdapterLinkOutsideOperator;", "jumProfileCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "feedId", "", "username", "", "(ZIFLcom/tencent/mm/plugin/finder/nearby/newlivesquare/InnerAdapterLinkOutsideOperator;Lkotlin/jvm/functions/Function2;)V", "getAspectRatio", "()F", "getForceNightMode", "()Z", "getJumProfileCallback", "()Lkotlin/jvm/functions/Function2;", "getOutsideOperator", "()Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/InnerAdapterLinkOutsideOperator;", "rootLayout", "Landroid/view/ViewGroup;", "getWidth", "()I", "bindCover", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "localFinderMedia", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "feed", "bindDesc", "mediaObj", "item", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/convertdata/base/LiveConvertData;", "bindLive", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "bindUserInfo", "clear", "getImageLoadOption", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "getLayoutId", "jumpProfile", "context", "Landroid/content/Context;", "onBindViewHolder", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onViewRecycled", "refreshLiveStatusInfo", "tagObject", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/RelatedLivingConvert$TagObject;", "TagObject", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  extends f<l>
{
  private final boolean ANb;
  private final m<Long, String, ah> ANd;
  private final com.tencent.mm.plugin.finder.nearby.newlivesquare.b ENg;
  private final float aspectRatio;
  private final int width;
  private ViewGroup xcW;
  
  private k(int paramInt, com.tencent.mm.plugin.finder.nearby.newlivesquare.b paramb, m<? super Long, ? super String, ah> paramm)
  {
    AppMethodBeat.i(340512);
    this.ANb = true;
    this.width = paramInt;
    this.aspectRatio = 1.7776F;
    this.ENg = paramb;
    this.ANd = paramm;
    AppMethodBeat.o(340512);
  }
  
  private final void B(long paramLong, String paramString)
  {
    AppMethodBeat.i(340517);
    this.ANd.invoke(Long.valueOf(paramLong), paramString);
    AppMethodBeat.o(340517);
  }
  
  static void F(j paramj)
  {
    AppMethodBeat.i(370559);
    Object localObject = paramj.tag;
    Application.ActivityLifecycleCallbacks localActivityLifecycleCallbacks;
    if ((localObject != null) && ((localObject instanceof a)))
    {
      ((a)localObject).akhV = null;
      localActivityLifecycleCallbacks = ((a)localObject).ENK;
      if (localActivityLifecycleCallbacks != null)
      {
        localObject = MMApplicationContext.getContext().getApplicationContext();
        if (!(localObject instanceof Application)) {
          break label80;
        }
      }
    }
    label80:
    for (localObject = (Application)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((Application)localObject).unregisterActivityLifecycleCallbacks(localActivityLifecycleCallbacks);
      }
      paramj.tag = null;
      AppMethodBeat.o(370559);
      return;
    }
  }
  
  private static final void a(BaseFinderFeed paramBaseFinderFeed, j paramj, k paramk, View paramView)
  {
    AppMethodBeat.i(370560);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramBaseFinderFeed);
    localb.cH(paramj);
    localb.cH(paramk);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/RelatedLivingConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramBaseFinderFeed, "$item");
    s.u(paramj, "$holder");
    s.u(paramk, "this$0");
    ((ce)h.ax(ce.class)).a(paramBaseFinderFeed, paramj.KJ(), "94");
    s.s(paramj.context, "holder.context");
    paramk.B(paramBaseFinderFeed.bZA(), paramBaseFinderFeed.feedObject.getUserName());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/RelatedLivingConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(370560);
  }
  
  private static final void b(BaseFinderFeed paramBaseFinderFeed, j paramj, k paramk, View paramView)
  {
    AppMethodBeat.i(370562);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramBaseFinderFeed);
    localb.cH(paramj);
    localb.cH(paramk);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/RelatedLivingConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramBaseFinderFeed, "$item");
    s.u(paramj, "$holder");
    s.u(paramk, "this$0");
    ((ce)h.ax(ce.class)).a(paramBaseFinderFeed, paramj.KJ(), "94");
    s.s(paramj.context, "holder.context");
    paramk.B(paramBaseFinderFeed.bZA(), paramBaseFinderFeed.feedObject.getUserName());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/RelatedLivingConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(370562);
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(340596);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    AppMethodBeat.o(340596);
  }
  
  final void a(l paraml, a parama, j paramj)
  {
    AppMethodBeat.i(370567);
    com.tencent.d.a.a.a.b localb = (com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class);
    Object localObject = paraml.feedObject.getLiveInfo();
    if (localObject == null) {}
    for (long l = 0L;; l = ((bip)localObject).liveId)
    {
      localObject = paramj.context;
      if (localObject != null) {
        break;
      }
      paraml = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(370567);
      throw paraml;
    }
    localb.getLiveInfo(l, false, (com.tencent.mm.vending.e.b)localObject, (b.d)new k.c(parama, paraml, paramj, this));
    AppMethodBeat.o(370567);
  }
  
  public final int getLayoutId()
  {
    return e.f.nearby_feed_live_live_of_related_live_item;
  }
  
  final e kLv()
  {
    AppMethodBeat.i(370568);
    if (this.ANb)
    {
      localObject = p.ExI;
      localObject = p.a(p.a.ExX);
      AppMethodBeat.o(370568);
      return localObject;
    }
    Object localObject = p.ExI;
    localObject = p.a(p.a.ExJ);
    AppMethodBeat.o(370568);
    return localObject;
  }
  
  public final void m(j paramj)
  {
    AppMethodBeat.i(370569);
    s.u(paramj, "holder");
    super.m(paramj);
    Log.i("Finder.Loader", s.X("#onViewRecycled holder=", paramj));
    F(paramj);
    AppMethodBeat.o(370569);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/RelatedLivingConvert$TagObject;", "", "(Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/RelatedLivingConvert;)V", "item", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/convertdata/RelatedLivingOfLiveConvertData;", "getItem", "()Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/convertdata/RelatedLivingOfLiveConvertData;", "setItem", "(Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/convertdata/RelatedLivingOfLiveConvertData;)V", "lifeCallback", "Landroid/app/Application$ActivityLifecycleCallbacks;", "getLifeCallback", "()Landroid/app/Application$ActivityLifecycleCallbacks;", "setLifeCallback", "(Landroid/app/Application$ActivityLifecycleCallbacks;)V", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  final class a
  {
    Application.ActivityLifecycleCallbacks ENK;
    l akhV;
    
    public a()
    {
      AppMethodBeat.i(370521);
      AppMethodBeat.o(370521);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/RelatedLivingConvert$onBindViewHolder$1", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/tools/SampleLifecycleCallbacks;", "onActivityDestroyed", "", "activity", "Landroid/app/Activity;", "onActivityResumed", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.viewconvert.tools.a
  {
    b(k paramk, j paramj, l paraml, k.a parama) {}
    
    public final void onActivityDestroyed(Activity paramActivity)
    {
      AppMethodBeat.i(370524);
      s.u(paramActivity, "activity");
      if (aH(paramActivity))
      {
        Log.i("Finder.Loader", "#lifeCallback-onActivityDestroyed");
        k.F(this.wHm);
      }
      AppMethodBeat.o(370524);
    }
    
    public final void onActivityResumed(Activity paramActivity)
    {
      AppMethodBeat.i(370526);
      s.u(paramActivity, "activity");
      super.onActivityResumed(paramActivity);
      if (aH(paramActivity))
      {
        Log.i("Finder.Loader", "#lifeCallback-onActivityResumed");
        this.akhW.a(this.akhX, this.akhY, this.wHm);
      }
      AppMethodBeat.o(370526);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.viewconvert.k
 * JD-Core Version:    0.7.0.1
 */