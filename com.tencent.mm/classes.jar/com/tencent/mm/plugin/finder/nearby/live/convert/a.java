package com.tencent.mm.plugin.finder.nearby.live.convert;

import android.graphics.Paint;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.loader.t;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.finder.view.FinderLiveOnliveWidget;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import java.util.List;
import java.util.List<Ljava.lang.Object;>;
import kotlin.a.j;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/live/convert/NearbyLiveFeedsConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "dividerWidth", "", "forceNightMode", "", "isLocalCityPage", "jumProfileCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "feedId", "", "username", "", "(IZZLkotlin/jvm/functions/Function2;)V", "getDividerWidth", "()I", "getForceNightMode", "()Z", "getJumProfileCallback", "()Lkotlin/jvm/functions/Function2;", "screenWidth", "getScreenWidth", "screenWidth$delegate", "Lkotlin/Lazy;", "bindCover", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "localFinderMedia", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "feed", "bindDesc", "mediaObj", "item", "bindLive", "bindUserInfo", "getImageLoadOption", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "getLayoutId", "jumpProfile", "context", "Landroid/content/Context;", "onBindViewHolder", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-finder-nearby_release"})
public class a
  extends com.tencent.mm.view.recyclerview.e<BaseFinderFeed>
{
  private final f xlu;
  private final boolean zEL;
  private final int zEU;
  private final boolean zEV;
  private final m<Long, String, kotlin.x> zEW;
  
  public a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, m<? super Long, ? super String, kotlin.x> paramm)
  {
    AppMethodBeat.i(203760);
    this.zEU = paramInt;
    this.zEV = paramBoolean1;
    this.zEL = paramBoolean2;
    this.zEW = paramm;
    this.xlu = g.ar((kotlin.g.a.a)c.zEY);
    AppMethodBeat.o(203760);
  }
  
  public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.i parami, int paramInt)
  {
    AppMethodBeat.i(203736);
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    AppMethodBeat.o(203736);
  }
  
  public void a(final com.tencent.mm.view.recyclerview.i parami, final BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(203758);
    p.k(parami, "holder");
    p.k(paramBaseFinderFeed, "item");
    Object localObject1;
    Object localObject2;
    Object localObject3;
    label85:
    Object localObject4;
    if (paramBaseFinderFeed.feedObject.isLiveFeed())
    {
      localObject1 = (csg)j.lo((List)paramBaseFinderFeed.feedObject.getLiveMediaList());
      localObject2 = (ImageView)parami.RD(b.f.finder_avatar);
      paramList = t.ztT;
      localObject3 = t.dJh();
      paramList = paramBaseFinderFeed.contact;
      if (paramList == null) {
        break label839;
      }
      paramList = paramList.Mm();
      paramList = new com.tencent.mm.plugin.finder.loader.e(Util.nullAsNil(paramList), u.AlQ);
      p.j(localObject2, "avatar");
      localObject4 = t.ztT;
      ((d)localObject3).a(paramList, (ImageView)localObject2, t.a(t.a.ztX));
      ((ImageView)localObject2).setOnClickListener((View.OnClickListener)new a(this, paramBaseFinderFeed, parami));
      paramList = (TextView)parami.RD(b.f.finder_nickname);
      localObject2 = (TextView)parami.RD(b.f.finder_desc);
      p.j(paramList, "nickname");
      paramList.setText((CharSequence)paramBaseFinderFeed.feedObject.getNickNameSpan());
      p.j(localObject2, "desc");
      ar.a((Paint)((TextView)localObject2).getPaint(), 0.8F);
      ar.a((Paint)paramList.getPaint(), 0.8F);
      paramList.setOnClickListener((View.OnClickListener)new b(this, paramBaseFinderFeed, parami));
      paramList = paramBaseFinderFeed.contact;
      if (paramList != null)
      {
        localObject2 = aj.AGc;
        localObject2 = parami.RD(b.f.auth_icon);
        p.j(localObject2, "holder.getView<ImageView>(R.id.auth_icon)");
        aj.a((ImageView)localObject2, paramList.field_authInfo);
      }
      paramList = (TextView)parami.RD(b.f.finder_desc);
      if (Util.isNullOrNil(paramBaseFinderFeed.feedObject.getDescription())) {
        break label845;
      }
      p.j(paramList, "descTv");
      paramList.setVisibility(0);
      paramList.setText((CharSequence)paramBaseFinderFeed.feedObject.getDescriptionSpan());
      label348:
      localObject3 = (ImageView)parami.RD(b.f.thumb_iv);
      paramList = parami.RD(b.f.live_player_container);
      p.j(localObject3, "thumbIv");
      localObject2 = ((ImageView)localObject3).getLayoutParams();
      paramInt2 = (((Number)this.xlu.getValue()).intValue() - this.zEU * 3) / 2;
      if (!paramBaseFinderFeed.feedObject.isLiveFeed()) {
        break label863;
      }
      paramInt1 = (int)(1.7776F * paramInt2);
      label429:
      if (paramInt1 > 0)
      {
        ((ViewGroup.LayoutParams)localObject2).width = paramInt2;
        ((ViewGroup.LayoutParams)localObject2).height = paramInt1;
        ((ImageView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        p.j(paramList, "liveContainer");
        paramList.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      localObject2 = ((csg)localObject1).coverUrl;
      paramList = (List<Object>)localObject2;
      if (localObject2 == null) {
        paramList = "";
      }
      p.j(paramList, "localFinderMedia.coverUrl ?: \"\"");
      localObject2 = paramList;
      if (Util.isNullOrNil(paramList)) {
        localObject2 = p.I(((csg)localObject1).thumbUrl, Util.nullAsNil(((csg)localObject1).thumb_url_token));
      }
      paramList = paramBaseFinderFeed.feedObject.getLiveInfo();
      if ((paramList == null) || (paramList.liveStatus != 1)) {
        break label896;
      }
      paramList = t.ztT;
      localObject1 = t.dJe();
      localObject2 = new com.tencent.mm.plugin.finder.loader.x((String)localObject2, u.Aly);
      if (!this.zEV) {
        break label880;
      }
      paramList = t.ztT;
      paramList = t.a(t.a.zuh);
      label594:
      ((d)localObject1).a(localObject2, (ImageView)localObject3, paramList);
      label605:
      paramList = (FinderLiveOnliveWidget)parami.RD(b.f.finder_live_mask_view);
      localObject1 = parami.RD(b.f.finder_live_online_layout);
      parami = (TextView)parami.RD(b.f.finder_desc);
      if (!paramBaseFinderFeed.feedObject.isLiveFeed()) {
        break label943;
      }
      localObject2 = paramBaseFinderFeed.feedObject.getLiveInfo();
      if ((localObject2 == null) || (((bac)localObject2).liveStatus != 1)) {
        break label911;
      }
      p.j(paramList, "liveFinishView");
      paramList.setVisibility(8);
      p.j(localObject1, "onLiveWidgetLayout");
      ((View)localObject1).setVisibility(0);
      p.j(parami, "desc");
      parami.setVisibility(8);
      label712:
      paramList = new StringBuilder("mediaType:").append(paramBaseFinderFeed.feedObject.getMediaType()).append(",liveStatus:");
      parami = paramBaseFinderFeed.feedObject.getLiveInfo();
      if (parami == null) {
        break label976;
      }
      parami = Integer.valueOf(parami.liveStatus);
      label760:
      paramList = paramList.append(parami).append(",contact liveStatus:");
      parami = paramBaseFinderFeed.feedObject.getRefObjectContact();
      if (parami == null) {
        break label981;
      }
    }
    label839:
    label845:
    label976:
    label981:
    for (parami = Integer.valueOf(parami.liveStatus);; parami = null)
    {
      Log.i("FinderFeedVideoLiveFriendsConvert", parami.intValue());
      AppMethodBeat.o(203758);
      return;
      localObject1 = (csg)j.lo((List)paramBaseFinderFeed.feedObject.getMediaList());
      break;
      paramList = null;
      break label85;
      p.j(paramList, "descTv");
      paramList.setVisibility(8);
      break label348;
      label863:
      localObject4 = aj.AGc;
      paramInt1 = aj.a(paramBaseFinderFeed, (csg)localObject1, paramInt2);
      break label429;
      label880:
      paramList = t.ztT;
      paramList = t.a(t.a.ztU);
      break label594;
      paramList = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      com.tencent.mm.plugin.finder.live.utils.a.g((ImageView)localObject3, (String)localObject2);
      break label605;
      p.j(paramList, "liveFinishView");
      paramList.setVisibility(0);
      p.j(localObject1, "onLiveWidgetLayout");
      ((View)localObject1).setVisibility(8);
      break label712;
      p.j(paramList, "liveFinishView");
      paramList.setVisibility(8);
      p.j(localObject1, "onLiveWidgetLayout");
      ((View)localObject1).setVisibility(8);
      break label712;
      parami = null;
      break label760;
    }
  }
  
  public final int getLayoutId()
  {
    if (this.zEL) {
      return b.g.nearby_feed_live_friends_item_new;
    }
    if (this.zEV) {
      return b.g.nearby_feed_live_friends_item_night_mode;
    }
    return b.g.nearby_feed_live_friends_item;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(a parama, BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.view.recyclerview.i parami) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(203178);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/nearby/live/convert/NearbyLiveFeedsConvert$bindUserInfo$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      k.yBj.a(paramBaseFinderFeed, parami.md(), "94");
      paramView = this.zEX;
      p.j(parami.getContext(), "holder.context");
      a.a(paramView, paramBaseFinderFeed.mf(), paramBaseFinderFeed.feedObject.getUserName());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/live/convert/NearbyLiveFeedsConvert$bindUserInfo$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(203178);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(a parama, BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.view.recyclerview.i parami) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(203892);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/nearby/live/convert/NearbyLiveFeedsConvert$bindUserInfo$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      k.yBj.a(paramBaseFinderFeed, parami.md(), "94");
      paramView = this.zEX;
      p.j(parami.getContext(), "holder.context");
      a.a(paramView, paramBaseFinderFeed.mf(), paramBaseFinderFeed.feedObject.getUserName());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/live/convert/NearbyLiveFeedsConvert$bindUserInfo$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(203892);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<Integer>
  {
    public static final c zEY;
    
    static
    {
      AppMethodBeat.i(202744);
      zEY = new c();
      AppMethodBeat.o(202744);
    }
    
    c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.convert.a
 * JD-Core Version:    0.7.0.1
 */