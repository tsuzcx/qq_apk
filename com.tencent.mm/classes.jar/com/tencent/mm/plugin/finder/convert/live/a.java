package com.tencent.mm.plugin.finder.convert.live;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.utils.at;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.view.FinderLiveOnliveWidget;
import com.tencent.mm.plugin.findersdk.a.ap;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.plugin.g;
import com.tencent.mm.plugin.g.a;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import java.util.List;
import java.util.List<Ljava.lang.Object;>;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/live/FinderLiveSquareLiveFeedConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "dividerWidth", "", "forceNightMode", "", "isLocalCityPage", "jumProfileCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "feedId", "", "username", "", "(FZZLkotlin/jvm/functions/Function2;)V", "getDividerWidth", "()F", "getForceNightMode", "()Z", "getJumProfileCallback", "()Lkotlin/jvm/functions/Function2;", "screenWidth", "", "getScreenWidth", "()I", "bindCover", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "localFinderMedia", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "feed", "bindDesc", "mediaObj", "item", "bindLive", "bindUserInfo", "getImageLoadOption", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "getLayoutId", "jumpProfile", "context", "Landroid/content/Context;", "onBindViewHolder", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public class a
  extends f<BaseFinderFeed>
{
  private final float ANa;
  private final boolean ANb;
  private final boolean ANc;
  private final kotlin.g.a.m<Long, String, ah> ANd;
  private final int sJv;
  
  public a(float paramFloat, boolean paramBoolean1, boolean paramBoolean2, kotlin.g.a.m<? super Long, ? super String, ah> paramm)
  {
    AppMethodBeat.i(350058);
    this.ANa = paramFloat;
    this.ANb = paramBoolean1;
    this.ANc = paramBoolean2;
    this.ANd = paramm;
    paramm = at.GiI;
    this.sJv = at.getScreenWidth();
    AppMethodBeat.o(350058);
  }
  
  private final void B(long paramLong, String paramString)
  {
    AppMethodBeat.i(350064);
    this.ANd.invoke(Long.valueOf(paramLong), paramString);
    AppMethodBeat.o(350064);
  }
  
  private static final void a(BaseFinderFeed paramBaseFinderFeed, j paramj, a parama, View paramView)
  {
    AppMethodBeat.i(350074);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramBaseFinderFeed);
    localb.cH(paramj);
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/live/FinderLiveSquareLiveFeedConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramBaseFinderFeed, "$item");
    kotlin.g.b.s.u(paramj, "$holder");
    kotlin.g.b.s.u(parama, "this$0");
    ((ce)h.ax(ce.class)).a(paramBaseFinderFeed, paramj.KJ(), "94");
    kotlin.g.b.s.s(paramj.context, "holder.context");
    parama.B(paramBaseFinderFeed.bZA(), paramBaseFinderFeed.feedObject.getUserName());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/live/FinderLiveSquareLiveFeedConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(350074);
  }
  
  private static final void b(BaseFinderFeed paramBaseFinderFeed, j paramj, a parama, View paramView)
  {
    AppMethodBeat.i(350080);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramBaseFinderFeed);
    localb.cH(paramj);
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/live/FinderLiveSquareLiveFeedConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramBaseFinderFeed, "$item");
    kotlin.g.b.s.u(paramj, "$holder");
    kotlin.g.b.s.u(parama, "this$0");
    ((ce)h.ax(ce.class)).a(paramBaseFinderFeed, paramj.KJ(), "94");
    kotlin.g.b.s.s(paramj.context, "holder.context");
    parama.B(paramBaseFinderFeed.bZA(), paramBaseFinderFeed.feedObject.getUserName());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/live/FinderLiveSquareLiveFeedConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(350080);
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(350099);
    kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
    kotlin.g.b.s.u(paramj, "holder");
    paramRecyclerView = com.tencent.mm.plugin.finder.accessibility.a.Ate;
    paramRecyclerView = paramj.UH(e.e.finder_avatar);
    kotlin.g.b.s.s(paramRecyclerView, "holder.getView<ImageView>(R.id.finder_avatar)");
    com.tencent.mm.plugin.finder.accessibility.a.fk(paramRecyclerView);
    paramRecyclerView = com.tencent.mm.plugin.finder.accessibility.a.Ate;
    paramRecyclerView = paramj.UH(e.e.finder_nickname);
    kotlin.g.b.s.s(paramRecyclerView, "holder.getView<TextView>(R.id.finder_nickname)");
    com.tencent.mm.plugin.finder.accessibility.a.fk(paramRecyclerView);
    paramRecyclerView = com.tencent.mm.plugin.finder.accessibility.a.Ate;
    paramRecyclerView = paramj.UH(e.e.auth_icon);
    kotlin.g.b.s.s(paramRecyclerView, "holder.getView<ImageView>(R.id.auth_icon)");
    com.tencent.mm.plugin.finder.accessibility.a.fk(paramRecyclerView);
    paramRecyclerView = com.tencent.mm.plugin.finder.accessibility.a.Ate;
    paramRecyclerView = paramj.UH(e.e.watch_count_history_tv);
    kotlin.g.b.s.s(paramRecyclerView, "holder.getView<TextView>…d.watch_count_history_tv)");
    com.tencent.mm.plugin.finder.accessibility.a.fk(paramRecyclerView);
    AppMethodBeat.o(350099);
  }
  
  public void a(j paramj, BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(350128);
    kotlin.g.b.s.u(paramj, "holder");
    kotlin.g.b.s.u(paramBaseFinderFeed, "item");
    paramj.caK.setTag(e.e.nearby_live_card_is_enhanced_expose, "");
    paramj.caK.setTag(e.e.nearby_live_card_is_enhanced_click, "");
    paramj.caK.setTag(e.e.nearby_live_card_click_timing, "");
    if (paramBaseFinderFeed.feedObject.isLiveFeed())
    {
      localObject1 = (dji)kotlin.a.p.oK((List)paramBaseFinderFeed.feedObject.getLiveMediaList());
      localObject2 = (ViewGroup)paramj.caK.findViewById(e.e.nearby_live_convert_root);
      localObject3 = (ImageView)paramj.UH(e.e.finder_avatar);
      paramList = com.tencent.mm.plugin.finder.loader.p.ExI;
      localObject4 = com.tencent.mm.plugin.finder.loader.p.eCp();
      paramList = paramBaseFinderFeed.contact;
      if (paramList != null) {
        break label785;
      }
      paramList = null;
      label137:
      paramList = new com.tencent.mm.plugin.finder.loader.b(Util.nullAsNil(paramList), v.FLG);
      kotlin.g.b.s.s(localObject3, "avatar");
      com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
      ((d)localObject4).a(paramList, (ImageView)localObject3, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExM));
      ((ImageView)localObject3).setOnClickListener(new a..ExternalSyntheticLambda1(paramBaseFinderFeed, paramj, this));
      paramList = (TextView)paramj.UH(e.e.finder_nickname);
      localObject3 = (TextView)paramj.UH(e.e.finder_desc);
      localObject4 = com.tencent.mm.plugin.finder.accessibility.a.Ate;
      localObject4 = paramj.context;
      kotlin.g.b.s.s(localObject4, "holder.context");
      com.tencent.mm.plugin.finder.accessibility.a.a((Context)localObject4, paramList, 14.0F);
      paramList.setText((CharSequence)paramBaseFinderFeed.feedObject.getNickNameSpan());
      ((ViewGroup)localObject2).setTag(e.e.finder_accessibility_nickname_tag, paramList.getText());
      aw.a((Paint)((TextView)localObject3).getPaint(), 0.8F);
      aw.a((Paint)paramList.getPaint(), 0.8F);
      paramList.setOnClickListener(new a..ExternalSyntheticLambda0(paramBaseFinderFeed, paramj, this));
      paramList = paramBaseFinderFeed.contact;
      if (paramList != null)
      {
        localObject3 = paramList.field_authInfo;
        if (localObject3 != null) {
          break label795;
        }
        paramInt1 = 0;
        label345:
        ((ViewGroup)localObject2).setTag(e.e.finder_accessibility_auth_icon_type_tag, Integer.valueOf(paramInt1));
        localObject2 = av.GiL;
        localObject2 = paramj.UH(e.e.auth_icon);
        kotlin.g.b.s.s(localObject2, "holder.getView<ImageView>(R.id.auth_icon)");
        av.a((ImageView)localObject2, paramList.field_authInfo, 0, c.a(paramList, false), 4);
      }
      paramList = (TextView)paramj.UH(e.e.finder_desc);
      if (Util.isNullOrNil(paramBaseFinderFeed.feedObject.getDescription())) {
        break label804;
      }
      paramList.setVisibility(0);
      paramList.setText((CharSequence)paramBaseFinderFeed.feedObject.getDescriptionSpan());
    }
    for (;;)
    {
      try
      {
        localObject3 = (ImageView)paramj.UH(e.e.thumb_iv);
        paramList = paramj.UH(e.e.live_player_container);
        if (localObject3 != null) {
          continue;
        }
        Log.w("Finder.Loader", "bindCover return for thumbIv is null.");
      }
      finally
      {
        long l2;
        label785:
        label795:
        label804:
        Log.w("Finder.Loader", "bindCover throw Throwable.");
        continue;
        paramInt1 = this.sJv;
        continue;
        localObject4 = av.GiL;
        paramInt1 = av.a(paramBaseFinderFeed, (dji)localObject1, paramInt2);
        continue;
        paramList = com.tencent.mm.plugin.finder.loader.p.ExI;
        paramList = com.tencent.mm.plugin.finder.loader.p.a(p.a.ExJ);
        continue;
        localObject1 = h.ax(g.class);
        kotlin.g.b.s.s(localObject1, "service(IFinderCommonLiveService::class.java)");
        g.a.a((g)localObject1, (ImageView)localObject3, paramList);
        continue;
        paramInt1 = 0;
        continue;
        paramList.setVisibility(0);
        ((View)localObject1).setVisibility(8);
        continue;
        paramList.setVisibility(8);
        ((View)localObject1).setVisibility(8);
        continue;
        paramj = null;
        continue;
        long l1 = ((bip)localObject2).liveId;
        continue;
        paramj = Integer.valueOf(paramj.liveStatus);
        continue;
        paramj = Integer.valueOf(paramj.liveStatus);
        continue;
        continue;
        paramInt1 = 0;
        continue;
      }
      paramList = (FinderLiveOnliveWidget)paramj.UH(e.e.finder_live_mask_view);
      localObject1 = paramj.UH(e.e.finder_live_online_layout);
      localObject2 = (TextView)paramj.UH(e.e.finder_desc);
      if (!paramBaseFinderFeed.feedObject.isLiveFeed()) {
        continue;
      }
      localObject3 = paramBaseFinderFeed.feedObject.getLiveInfo();
      if ((localObject3 == null) || (((bip)localObject3).liveStatus != 1)) {
        continue;
      }
      paramInt1 = 1;
      if (paramInt1 == 0) {
        continue;
      }
      paramList.setVisibility(8);
      ((View)localObject1).setVisibility(0);
      ((TextView)localObject2).setVisibility(8);
      paramj = paramj.caK.getContext();
      if (!(paramj instanceof MMFinderUI)) {
        continue;
      }
      paramj = (MMFinderUI)paramj;
      if (paramj != null)
      {
        paramList = k.aeZF;
        paramList = (ap)k.d((AppCompatActivity)paramj).cq(ap.class);
        l2 = paramBaseFinderFeed.feedObject.getId();
        localObject1 = paramBaseFinderFeed.feedObject.getObjectNonceId();
        localObject2 = paramBaseFinderFeed.feedObject.getLiveInfo();
        if (localObject2 != null) {
          continue;
        }
        l1 = 0L;
        paramList.a(l2, (String)localObject1, l1, (Context)paramj);
      }
      paramList = new StringBuilder("mediaType:").append(paramBaseFinderFeed.feedObject.getMediaType()).append(",liveStatus:");
      paramj = paramBaseFinderFeed.feedObject.getLiveInfo();
      if (paramj != null) {
        continue;
      }
      paramj = null;
      paramList = paramList.append(paramj).append(",contact liveStatus:");
      paramj = paramBaseFinderFeed.feedObject.getRefObjectContact();
      if (paramj != null) {
        continue;
      }
      paramj = null;
      Log.i("FinderFeedVideoLiveFriendsConvert", paramj);
      AppMethodBeat.o(350128);
      return;
      localObject1 = (dji)kotlin.a.p.oK((List)paramBaseFinderFeed.feedObject.getMediaList());
      break;
      paramList = paramList.amx();
      break label137;
      paramInt1 = ((FinderAuthInfo)localObject3).authIconType;
      break label345;
      paramList.setVisibility(8);
      continue;
      localObject2 = ((ImageView)localObject3).getLayoutParams();
      if (!aw.ato()) {
        continue;
      }
      localObject4 = MMApplicationContext.getContext();
      paramInt1 = bd.fromDPToPix((Context)localObject4, ((Context)localObject4).getResources().getConfiguration().screenWidthDp);
      paramInt2 = (paramInt1 - (int)this.ANa) / 2;
      if (!paramBaseFinderFeed.feedObject.isLiveFeed()) {
        continue;
      }
      paramInt1 = (int)(1.7776F * paramInt2);
      if (paramInt1 > 0)
      {
        ((ViewGroup.LayoutParams)localObject2).width = paramInt2;
        ((ViewGroup.LayoutParams)localObject2).height = paramInt1;
        ((ImageView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        paramList.getLayoutParams().width = ((ViewGroup.LayoutParams)localObject2).width;
        paramList.getLayoutParams().height = ((ViewGroup.LayoutParams)localObject2).height;
      }
      localObject2 = ((dji)localObject1).coverUrl;
      paramList = (List<Object>)localObject2;
      if (localObject2 == null) {
        paramList = "";
      }
      if (!Util.isNullOrNil(paramList)) {
        continue;
      }
      paramList = kotlin.g.b.s.X(((dji)localObject1).thumbUrl, Util.nullAsNil(((dji)localObject1).thumb_url_token));
      localObject1 = paramBaseFinderFeed.feedObject.getLiveInfo();
      if ((localObject1 == null) || (((bip)localObject1).liveStatus != 1)) {
        continue;
      }
      paramInt1 = 1;
      if (paramInt1 == 0) {
        continue;
      }
      localObject1 = com.tencent.mm.plugin.finder.loader.p.ExI;
      localObject1 = com.tencent.mm.plugin.finder.loader.p.eCl();
      localObject2 = new com.tencent.mm.plugin.finder.loader.s(paramList, v.FKY);
      if (!this.ANb) {
        continue;
      }
      paramList = com.tencent.mm.plugin.finder.loader.p.ExI;
      paramList = com.tencent.mm.plugin.finder.loader.p.a(p.a.ExX);
      ((d)localObject1).a(localObject2, (ImageView)localObject3, paramList);
    }
  }
  
  public final int getLayoutId()
  {
    if (this.ANc) {
      return e.f.nearby_feed_live_friends_item_new;
    }
    if (this.ANb) {
      return e.f.nearby_feed_live_friends_item_night_mode;
    }
    return e.f.nearby_feed_live_friends_item;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.live.a
 * JD-Core Version:    0.7.0.1
 */