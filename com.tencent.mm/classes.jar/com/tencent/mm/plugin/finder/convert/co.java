package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.loader.k;
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.FinderLiveOnliveWidget;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import java.util.List;
import java.util.List<Ljava.lang.Object;>;
import kotlin.a.j;
import kotlin.f;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/NearbyLiveFeedsConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "()V", "screenWidth", "", "getScreenWidth", "()I", "screenWidth$delegate", "Lkotlin/Lazy;", "bindCover", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "mediaObj", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "item", "bindDesc", "bindLive", "localFinderMedia", "feed", "bindUserInfo", "getLayoutId", "jumpProfile", "context", "Landroid/content/Context;", "feedId", "", "username", "", "onBindViewHolder", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
public class co
  extends e<BaseFinderFeed>
{
  private final f tCY;
  
  public co()
  {
    AppMethodBeat.i(243386);
    this.tCY = kotlin.g.ah((kotlin.g.a.a)c.tHi);
    AppMethodBeat.o(243386);
  }
  
  public final void a(RecyclerView paramRecyclerView, h paramh, int paramInt)
  {
    AppMethodBeat.i(243383);
    kotlin.g.b.p.h(paramRecyclerView, "recyclerView");
    kotlin.g.b.p.h(paramh, "holder");
    AppMethodBeat.o(243383);
  }
  
  public void a(final h paramh, final BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(243384);
    kotlin.g.b.p.h(paramh, "holder");
    kotlin.g.b.p.h(paramBaseFinderFeed, "item");
    Object localObject1;
    Object localObject2;
    Object localObject3;
    label84:
    Object localObject4;
    if (paramBaseFinderFeed.feedObject.isLiveFeed())
    {
      localObject1 = (cjl)j.ks((List)paramBaseFinderFeed.feedObject.getLiveMediaList());
      localObject2 = (ImageView)paramh.Mn(2131300773);
      paramList = com.tencent.mm.plugin.finder.loader.m.uJa;
      localObject3 = com.tencent.mm.plugin.finder.loader.m.dka();
      paramList = paramBaseFinderFeed.contact;
      if (paramList == null) {
        break label898;
      }
      paramList = paramList.cXH();
      paramList = new com.tencent.mm.plugin.finder.loader.a(Util.nullAsNil(paramList));
      kotlin.g.b.p.g(localObject2, "avatar");
      localObject4 = com.tencent.mm.plugin.finder.loader.m.uJa;
      ((d)localObject3).a(paramList, (ImageView)localObject2, com.tencent.mm.plugin.finder.loader.m.a(m.a.uJe));
      ((ImageView)localObject2).setOnClickListener((View.OnClickListener)new a(this, paramh, paramBaseFinderFeed));
      paramList = (TextView)paramh.Mn(2131301380);
      localObject2 = (TextView)paramh.Mn(2131300801);
      kotlin.g.b.p.g(paramList, "nickname");
      paramList.setText((CharSequence)paramBaseFinderFeed.feedObject.getNickNameSpan());
      kotlin.g.b.p.g(localObject2, "desc");
      ao.a((Paint)((TextView)localObject2).getPaint(), 0.8F);
      paramList.setOnClickListener((View.OnClickListener)new b(this, paramh, paramBaseFinderFeed));
      paramList = paramBaseFinderFeed.contact;
      if (paramList != null)
      {
        localObject2 = y.vXH;
        localObject2 = paramh.Mn(2131297096);
        kotlin.g.b.p.g(localObject2, "holder.getView<ImageView>(R.id.auth_icon)");
        y.a((ImageView)localObject2, paramList.field_authInfo);
      }
      paramList = (TextView)paramh.Mn(2131300801);
      if (Util.isNullOrNil(paramBaseFinderFeed.feedObject.getDescription())) {
        break label904;
      }
      kotlin.g.b.p.g(paramList, "descTv");
      paramList.setVisibility(0);
      paramList.setText((CharSequence)paramBaseFinderFeed.feedObject.getDescriptionSpan());
      label326:
      paramList = (ImageView)paramh.Mn(2131309073);
      kotlin.g.b.p.g(paramList, "thumbIv");
      localObject2 = paramList.getLayoutParams();
      paramInt1 = ((Number)this.tCY.getValue()).intValue();
      localObject3 = paramh.getContext();
      kotlin.g.b.p.g(localObject3, "holder.context");
      paramInt2 = (paramInt1 - (int)((Context)localObject3).getResources().getDimension(2131166346)) / 2;
      if (!paramBaseFinderFeed.feedObject.isLiveFeed()) {
        break label922;
      }
      paramInt1 = (int)(1.3317F * paramInt2);
      label420:
      if (paramInt1 > 0)
      {
        ((ViewGroup.LayoutParams)localObject2).width = paramInt2;
        ((ViewGroup.LayoutParams)localObject2).height = paramInt1;
        paramList.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      if (!Util.isNullOrNil(((cjl)localObject1).coverUrl)) {
        break label939;
      }
      localObject2 = new k((cjl)localObject1, x.vEo, null, null, 12);
      localObject3 = com.tencent.mm.plugin.finder.loader.m.uJa;
      localObject3 = com.tencent.mm.plugin.finder.loader.m.djY();
      localObject4 = com.tencent.mm.plugin.finder.loader.m.uJa;
      ((d)localObject3).a(localObject2, paramList, com.tencent.mm.plugin.finder.loader.m.a(m.a.uJb));
      Log.i("NearbyLiveFeedsConvert", "name:" + paramBaseFinderFeed.feedObject.getNickNameSpan() + " videoThumb:" + ((k)localObject2).aBE());
      label546:
      localObject3 = (ImageView)paramh.Mn(2131309073);
      localObject2 = ((cjl)localObject1).coverUrl;
      paramList = (List<Object>)localObject2;
      if (localObject2 == null) {
        paramList = "";
      }
      kotlin.g.b.p.g(paramList, "localFinderMedia.coverUrl ?: \"\"");
      if (!Util.isNullOrNil(paramList)) {
        break label1123;
      }
      paramList = kotlin.g.b.p.I(((cjl)localObject1).thumbUrl, Util.nullAsNil(((cjl)localObject1).thumb_url_token));
    }
    label771:
    label819:
    label1113:
    label1118:
    label1123:
    for (;;)
    {
      localObject1 = (FinderLiveOnliveWidget)paramh.Mn(2131301145);
      localObject2 = paramh.Mn(2131301214);
      paramh = (TextView)paramh.Mn(2131300801);
      if (paramBaseFinderFeed.feedObject.isLiveFeed())
      {
        localObject4 = paramBaseFinderFeed.feedObject.getLiveInfo();
        if ((localObject4 != null) && (((awe)localObject4).liveStatus == 1))
        {
          localObject4 = com.tencent.mm.plugin.finder.loader.m.uJa;
          localObject4 = com.tencent.mm.plugin.finder.loader.m.djY();
          paramList = new com.tencent.mm.plugin.finder.loader.p(paramList, x.vEn);
          kotlin.g.b.p.g(localObject3, "thumbIv");
          com.tencent.mm.plugin.finder.loader.m localm = com.tencent.mm.plugin.finder.loader.m.uJa;
          ((d)localObject4).a(paramList, (ImageView)localObject3, com.tencent.mm.plugin.finder.loader.m.a(m.a.uJb));
          kotlin.g.b.p.g(localObject1, "liveFinishView");
          ((FinderLiveOnliveWidget)localObject1).setVisibility(8);
          kotlin.g.b.p.g(localObject2, "onLiveWidgetLayout");
          ((View)localObject2).setVisibility(0);
          kotlin.g.b.p.g(paramh, "desc");
          paramh.setVisibility(8);
          paramList = new StringBuilder("mediaType:").append(paramBaseFinderFeed.feedObject.getMediaType()).append(",liveStatus:");
          paramh = paramBaseFinderFeed.feedObject.getLiveInfo();
          if (paramh == null) {
            break label1113;
          }
          paramh = Integer.valueOf(paramh.liveStatus);
          paramList = paramList.append(paramh).append(",contact liveStatus:");
          paramh = paramBaseFinderFeed.feedObject.getRefObjectContact();
          if (paramh == null) {
            break label1118;
          }
        }
      }
      for (paramh = Integer.valueOf(paramh.liveStatus);; paramh = null)
      {
        Log.i("FinderFeedVideoLiveFriendsConvert", paramh.intValue());
        AppMethodBeat.o(243384);
        return;
        localObject1 = (cjl)j.ks((List)paramBaseFinderFeed.feedObject.getMediaList());
        break;
        paramList = null;
        break label84;
        kotlin.g.b.p.g(paramList, "descTv");
        paramList.setVisibility(8);
        break label326;
        localObject3 = y.vXH;
        paramInt1 = y.a(paramBaseFinderFeed, (cjl)localObject1, paramInt2);
        break label420;
        localObject2 = new com.tencent.mm.plugin.finder.loader.q((cjl)localObject1, x.vEn);
        localObject3 = com.tencent.mm.plugin.finder.loader.m.uJa;
        localObject3 = com.tencent.mm.plugin.finder.loader.m.djY();
        localObject4 = com.tencent.mm.plugin.finder.loader.m.uJa;
        ((d)localObject3).a(localObject2, paramList, com.tencent.mm.plugin.finder.loader.m.a(m.a.uJb));
        Log.i("NearbyLiveFeedsConvert", "name:" + paramBaseFinderFeed.feedObject.getNickNameSpan() + " videoCover:" + ((com.tencent.mm.plugin.finder.loader.q)localObject2).aBE());
        break label546;
        paramh = com.tencent.mm.plugin.finder.utils.m.vVH;
        kotlin.g.b.p.g(localObject3, "thumbIv");
        com.tencent.mm.plugin.finder.utils.m.h((ImageView)localObject3, paramList);
        kotlin.g.b.p.g(localObject1, "liveFinishView");
        ((FinderLiveOnliveWidget)localObject1).setVisibility(0);
        kotlin.g.b.p.g(localObject2, "onLiveWidgetLayout");
        ((View)localObject2).setVisibility(8);
        break label771;
        kotlin.g.b.p.g(localObject1, "liveFinishView");
        ((FinderLiveOnliveWidget)localObject1).setVisibility(8);
        kotlin.g.b.p.g(localObject2, "onLiveWidgetLayout");
        ((View)localObject2).setVisibility(8);
        break label771;
        paramh = null;
        break label819;
      }
    }
  }
  
  public final int getLayoutId()
  {
    return 2131495813;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(co paramco, h paramh, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(243379);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/NearbyLiveFeedsConvert$bindUserInfo$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = paramh.getContext();
      kotlin.g.b.p.g(paramView, "holder.context");
      paramBaseFinderFeed.lT();
      co.aB(paramView, paramBaseFinderFeed.feedObject.getUserName());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/NearbyLiveFeedsConvert$bindUserInfo$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(243379);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(co paramco, h paramh, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(243380);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/NearbyLiveFeedsConvert$bindUserInfo$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = paramh.getContext();
      kotlin.g.b.p.g(paramView, "holder.context");
      paramBaseFinderFeed.lT();
      co.aB(paramView, paramBaseFinderFeed.feedObject.getUserName());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/NearbyLiveFeedsConvert$bindUserInfo$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(243380);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Integer>
  {
    public static final c tHi;
    
    static
    {
      AppMethodBeat.i(243382);
      tHi = new c();
      AppMethodBeat.o(243382);
    }
    
    c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.co
 * JD-Core Version:    0.7.0.1
 */