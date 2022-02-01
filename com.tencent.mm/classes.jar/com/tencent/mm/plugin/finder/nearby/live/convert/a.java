package com.tencent.mm.plugin.finder.nearby.live.convert;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.feed.bk;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/convert/NearbyFinderRelatedLivingConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/feed/RelatedLivingOfLiveFeed;", "forceNightMode", "", "screenWidth", "", "aspectRatio", "", "jumProfileCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "feedId", "", "username", "", "(ZIFLkotlin/jvm/functions/Function2;)V", "getAspectRatio", "()F", "dividerWidth", "getDividerWidth", "getForceNightMode", "()Z", "getJumProfileCallback", "()Lkotlin/jvm/functions/Function2;", "rootLayout", "Landroid/view/ViewGroup;", "getScreenWidth", "()I", "bindCover", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "localFinderMedia", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "feed", "bindDesc", "mediaObj", "item", "bindLive", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "bindUserInfo", "getImageLoadOption", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "getLayoutId", "jumpProfile", "context", "Landroid/content/Context;", "onBindViewHolder", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends f<bk>
{
  private final float ANa;
  private final boolean ANb;
  private final m<Long, String, ah> ANd;
  private final float aspectRatio;
  private final int sJv;
  private ViewGroup xcW;
  
  private a(int paramInt, m<? super Long, ? super String, ah> paramm)
  {
    AppMethodBeat.i(340875);
    this.ANb = true;
    this.sJv = paramInt;
    this.aspectRatio = 1.7776F;
    this.ANd = paramm;
    this.ANa = MMApplicationContext.getContext().getResources().getDimension(e.c.Edge_1_5_A);
    AppMethodBeat.o(340875);
  }
  
  private final void B(long paramLong, String paramString)
  {
    AppMethodBeat.i(340888);
    this.ANd.invoke(Long.valueOf(paramLong), paramString);
    AppMethodBeat.o(340888);
  }
  
  private static final void a(BaseFinderFeed paramBaseFinderFeed, j paramj, a parama, View paramView)
  {
    AppMethodBeat.i(340896);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramBaseFinderFeed);
    localb.cH(paramj);
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/nearby/live/convert/NearbyFinderRelatedLivingConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramBaseFinderFeed, "$item");
    s.u(paramj, "$holder");
    s.u(parama, "this$0");
    ((ce)h.ax(ce.class)).a(paramBaseFinderFeed, paramj.KJ(), "94");
    s.s(paramj.context, "holder.context");
    parama.B(paramBaseFinderFeed.bZA(), paramBaseFinderFeed.feedObject.getUserName());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/nearby/live/convert/NearbyFinderRelatedLivingConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(340896);
  }
  
  private static final void b(BaseFinderFeed paramBaseFinderFeed, j paramj, a parama, View paramView)
  {
    AppMethodBeat.i(340907);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramBaseFinderFeed);
    localb.cH(paramj);
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/nearby/live/convert/NearbyFinderRelatedLivingConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramBaseFinderFeed, "$item");
    s.u(paramj, "$holder");
    s.u(parama, "this$0");
    ((ce)h.ax(ce.class)).a(paramBaseFinderFeed, paramj.KJ(), "94");
    s.s(paramj.context, "holder.context");
    parama.B(paramBaseFinderFeed.bZA(), paramBaseFinderFeed.feedObject.getUserName());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/nearby/live/convert/NearbyFinderRelatedLivingConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(340907);
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(340930);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    AppMethodBeat.o(340930);
  }
  
  public final int getLayoutId()
  {
    return e.f.nearby_feed_live_live_of_related_live_item;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.convert.a
 * JD-Core Version:    0.7.0.1
 */