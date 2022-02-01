package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Point;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.d.a.b.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.search.k;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.utils.r;
import com.tencent.mm.plugin.finder.view.FinderLiveOnliveWidget;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.g;
import com.tencent.mm.plugin.g.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.protocal.protobuf.pu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bf;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.am;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderProfileUIMediaLiveViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "searchScene", "", "(Landroid/view/View;I)V", "screenWidth", "getScreenWidth", "()I", "getSearchScene", "bindCover", "", "holder", "localFinderMedia", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "bindDesc", "query", "", "mediaObj", "item", "bindLive", "bindMedia", "dataPos", "bindImage", "", "fromSearch", "itemClickListener", "Lkotlin/Function1;", "bindUserInfo", "isFinderLiveSearch", "jumpProfile", "context", "Landroid/content/Context;", "username", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class cg
  extends RecyclerView.v
{
  public static final a AMi;
  private final int syO;
  
  static
  {
    AppMethodBeat.i(349777);
    AMi = new a((byte)0);
    AppMethodBeat.o(349777);
  }
  
  public cg(View paramView, int paramInt)
  {
    super(paramView);
    AppMethodBeat.i(349726);
    this.syO = paramInt;
    AppMethodBeat.o(349726);
  }
  
  private static void a(Context paramContext, BaseFinderFeed paramBaseFinderFeed, String paramString)
  {
    AppMethodBeat.i(349741);
    paramBaseFinderFeed = paramBaseFinderFeed.feedObject.getBizInfo();
    if (paramBaseFinderFeed == null) {}
    for (paramBaseFinderFeed = null;; paramBaseFinderFeed = ah.aiuX)
    {
      if (paramBaseFinderFeed == null)
      {
        paramBaseFinderFeed = new Intent();
        paramBaseFinderFeed.putExtra("finder_username", paramString);
        ((cn)h.az(cn.class)).fillContextIdToIntent(((e)h.az(e.class)).getNearbyTabLifecycleReporter().eeL(), paramBaseFinderFeed);
        com.tencent.mm.plugin.finder.utils.a.GfO.enterFinderProfileUI(paramContext, paramBaseFinderFeed);
      }
      AppMethodBeat.o(349741);
      return;
      Intent localIntent = new Intent();
      String str = paramBaseFinderFeed.ADE;
      paramBaseFinderFeed = str;
      if (str == null) {
        paramBaseFinderFeed = "";
      }
      localIntent.putExtra("Contact_User", paramBaseFinderFeed);
      localIntent.putExtra("Contact_Scene", 213);
      localIntent.putExtra("biz_profile_enter_from_finder", true);
      localIntent.putExtra("force_get_contact", true);
      localIntent.putExtra("key_use_new_contact_profile", true);
      localIntent.putExtra("biz_profile_tab_type", 1);
      com.tencent.mm.br.c.b(paramContext, "profile", ".ui.ContactInfoUI", localIntent);
    }
  }
  
  private static final void a(cg paramcg, View paramView1, BaseFinderFeed paramBaseFinderFeed, View paramView2)
  {
    AppMethodBeat.i(349759);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramcg);
    localb.cH(paramView1);
    localb.cH(paramBaseFinderFeed);
    localb.cH(paramView2);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderProfileUIMediaLiveViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramcg, "this$0");
    kotlin.g.b.s.u(paramView1, "$holder");
    kotlin.g.b.s.u(paramBaseFinderFeed, "$item");
    paramcg = paramView1.getContext();
    kotlin.g.b.s.s(paramcg, "holder.context");
    a(paramcg, paramBaseFinderFeed, paramBaseFinderFeed.feedObject.getUserName());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderProfileUIMediaLiveViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(349759);
  }
  
  private static final void a(kotlin.g.a.b paramb, int paramInt, View paramView)
  {
    AppMethodBeat.i(349751);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.sc(paramInt);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderProfileUIMediaLiveViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramb, "$itemClickListener");
    paramb.invoke(Integer.valueOf(paramInt));
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderProfileUIMediaLiveViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(349751);
  }
  
  private static final void b(cg paramcg, View paramView1, BaseFinderFeed paramBaseFinderFeed, View paramView2)
  {
    AppMethodBeat.i(349771);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramcg);
    localb.cH(paramView1);
    localb.cH(paramBaseFinderFeed);
    localb.cH(paramView2);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderProfileUIMediaLiveViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramcg, "this$0");
    kotlin.g.b.s.u(paramView1, "$holder");
    kotlin.g.b.s.u(paramBaseFinderFeed, "$item");
    paramcg = paramView1.getContext();
    kotlin.g.b.s.s(paramcg, "holder.context");
    a(paramcg, paramBaseFinderFeed, paramBaseFinderFeed.feedObject.getUserName());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderProfileUIMediaLiveViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(349771);
  }
  
  private final boolean dXY()
  {
    return this.syO == 13;
  }
  
  private final int getScreenWidth()
  {
    AppMethodBeat.i(349733);
    if (aw.jkS())
    {
      i = bf.bf(this.caK.getContext()).x;
      AppMethodBeat.o(349733);
      return i;
    }
    int i = bf.bf(MMApplicationContext.getContext()).x;
    AppMethodBeat.o(349733);
    return i;
  }
  
  public final void a(String paramString, BaseFinderFeed paramBaseFinderFeed, kotlin.g.a.b<? super Integer, ah> paramb)
  {
    AppMethodBeat.i(349843);
    kotlin.g.b.s.u(paramString, "query");
    kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
    kotlin.g.b.s.u(paramb, "itemClickListener");
    Object localObject2;
    Object localObject3;
    Object localObject4;
    Object localObject1;
    Object localObject5;
    label105:
    int i;
    label331:
    label354:
    label492:
    int j;
    if (paramBaseFinderFeed.feedObject.isLiveFeed())
    {
      localObject2 = (dji)kotlin.a.p.oK((List)paramBaseFinderFeed.feedObject.getLiveMediaList());
      localObject3 = this.caK;
      kotlin.g.b.s.s(localObject3, "itemView");
      localObject4 = (ImageView)((View)localObject3).findViewById(e.e.finder_avatar);
      localObject1 = com.tencent.mm.plugin.finder.loader.p.ExI;
      localObject5 = com.tencent.mm.plugin.finder.loader.p.eCp();
      localObject1 = paramBaseFinderFeed.contact;
      if (localObject1 != null) {
        break label1048;
      }
      localObject1 = null;
      localObject1 = new com.tencent.mm.plugin.finder.loader.b(Util.nullAsNil((String)localObject1));
      kotlin.g.b.s.s(localObject4, "avatar");
      com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
      ((com.tencent.mm.loader.d)localObject5).a(localObject1, (ImageView)localObject4, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExM));
      ((ImageView)localObject4).setOnClickListener(new cg..ExternalSyntheticLambda1(this, (View)localObject3, paramBaseFinderFeed));
      localObject1 = (TextView)((View)localObject3).findViewById(e.e.finder_nickname);
      ((TextView)localObject1).setText((CharSequence)paramBaseFinderFeed.feedObject.getNickNameSpan());
      aw.a((Paint)((TextView)localObject1).getPaint(), 0.8F);
      ((TextView)localObject1).setOnClickListener(new cg..ExternalSyntheticLambda0(this, (View)localObject3, paramBaseFinderFeed));
      localObject1 = paramBaseFinderFeed.contact;
      if (localObject1 != null)
      {
        localObject4 = av.GiL;
        localObject3 = ((View)localObject3).findViewById(e.e.auth_icon);
        kotlin.g.b.s.s(localObject3, "holder.findViewById<ImageView>(R.id.auth_icon)");
        av.a((ImageView)localObject3, ((m)localObject1).field_authInfo, 0, com.tencent.mm.plugin.finder.api.c.a((m)localObject1, false), 4);
      }
      localObject1 = this.caK;
      kotlin.g.b.s.s(localObject1, "itemView");
      localObject4 = (TextView)((View)localObject1).findViewById(e.e.finder_desc);
      if (localObject4 != null)
      {
        localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
        if (((Number)com.tencent.mm.plugin.finder.storage.d.eYb().bmg()).intValue() != 1) {
          break label1058;
        }
        i = 2;
        ((TextView)localObject4).setMaxLines(i);
      }
      if (!Util.isNullOrNil(paramString)) {
        break label1064;
      }
      localObject1 = paramBaseFinderFeed.feedObject.getDescription();
      localObject3 = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eYb().bmg()).intValue() != 1) {
        break label1111;
      }
      localObject3 = k.FxZ;
      i = k.ePd();
      label385:
      if (!Util.isNullOrNil(paramString)) {
        break label1126;
      }
      ((TextView)localObject4).setText((CharSequence)localObject1);
      label402:
      if (Util.isNullOrNil((String)localObject1)) {
        break label1225;
      }
      ((TextView)localObject4).setVisibility(0);
      label416:
      localObject4 = this.caK;
      kotlin.g.b.s.s(localObject4, "itemView");
      localObject3 = (ImageView)((View)localObject4).findViewById(e.e.thumb_iv);
      paramString = ((View)localObject4).findViewById(e.e.live_player_container);
      localObject1 = ((ImageView)localObject3).getLayoutParams();
      if (!dXY()) {
        break label1235;
      }
      i = (getScreenWidth() - (int)((View)localObject4).getContext().getResources().getDimension(e.c.finder_0_25_A) * 6) / 2;
      if (!paramBaseFinderFeed.feedObject.isLiveFeed()) {
        break label1265;
      }
      j = (int)(1.7776F * i);
      label512:
      if (j > 0)
      {
        ((ViewGroup.LayoutParams)localObject1).width = i;
        ((ViewGroup.LayoutParams)localObject1).height = j;
        ((ImageView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        paramString.getLayoutParams().width = ((ViewGroup.LayoutParams)localObject1).width;
        paramString.getLayoutParams().height = ((ViewGroup.LayoutParams)localObject1).height;
      }
      localObject1 = ((dji)localObject2).coverUrl;
      paramString = (String)localObject1;
      if (localObject1 == null) {
        paramString = "";
      }
      if (!Util.isNullOrNil(paramString)) {
        break label1426;
      }
      paramString = kotlin.g.b.s.X(((dji)localObject2).thumbUrl, Util.nullAsNil(((dji)localObject2).thumb_url_token));
    }
    label773:
    label913:
    label1426:
    for (;;)
    {
      localObject1 = paramBaseFinderFeed.feedObject.getLiveInfo();
      if ((localObject1 != null) && (((bip)localObject1).liveStatus == 1))
      {
        i = 1;
        label630:
        if (i == 0) {
          break label1303;
        }
        localObject1 = com.tencent.mm.plugin.finder.loader.p.ExI;
        localObject1 = com.tencent.mm.plugin.finder.loader.p.eCl();
        localObject2 = new com.tencent.mm.plugin.finder.loader.s(paramString, v.FKY);
        kotlin.g.b.s.s(localObject3, "thumbIv");
        if (!dXY()) {
          break label1289;
        }
        paramString = com.tencent.mm.plugin.finder.loader.p.ExI;
        paramString = com.tencent.mm.plugin.finder.loader.p.a(p.a.ExX);
        label684:
        ((com.tencent.mm.loader.d)localObject1).a(localObject2, (ImageView)localObject3, paramString);
        label694:
        paramString = this.caK;
        kotlin.g.b.s.s(paramString, "itemView");
        localObject1 = (FinderLiveOnliveWidget)paramString.findViewById(e.e.finder_live_mask_view);
        localObject2 = paramString.findViewById(e.e.finder_live_online_layout);
        if (!paramBaseFinderFeed.feedObject.isLiveFeed()) {
          break label1351;
        }
        localObject3 = paramBaseFinderFeed.feedObject.getLiveInfo();
        if ((localObject3 == null) || (((bip)localObject3).liveStatus != 1)) {
          break label1345;
        }
        i = 1;
        label762:
        if (i != 0) {
          break label1351;
        }
        ((FinderLiveOnliveWidget)localObject1).setVisibility(0);
        localObject3 = (TextView)paramString.findViewById(e.e.rec_reason_tv);
        localObject4 = (TextView)paramString.findViewById(e.e.watch_count_history_tv);
        paramString = paramBaseFinderFeed.feedObject.getLiveInfo();
        if ((paramString == null) || (paramString.liveStatus != 1)) {
          break label1361;
        }
        i = 1;
        label820:
        if (i != 0)
        {
          ((View)localObject2).setVisibility(0);
          localObject1 = paramBaseFinderFeed.feedObject.getFeedObject().recommendReason;
          paramString = (String)localObject1;
          if (localObject1 == null) {
            paramString = "";
          }
          if (!TextUtils.isEmpty((CharSequence)paramString)) {
            break label1367;
          }
          ((View)localObject2).setVisibility(8);
          label871:
          paramString = paramBaseFinderFeed.feedObject.getLiveInfo();
          if (paramString != null) {
            break label1385;
          }
          i = 0;
          label886:
          if (i <= 0) {
            break label1394;
          }
          ((TextView)localObject4).setText((CharSequence)String.valueOf(r.TS(i)));
          ((TextView)localObject4).setVisibility(0);
        }
        i = paramBaseFinderFeed.feedObject.getMediaType();
        this.caK.setOnClickListener(new cg..ExternalSyntheticLambda2(paramb, i));
        paramb = new StringBuilder("mediaType:").append(paramBaseFinderFeed.feedObject.getMediaType()).append(",liveStatus:");
        paramString = paramBaseFinderFeed.feedObject.getLiveInfo();
        if (paramString != null) {
          break label1404;
        }
        paramString = null;
        label980:
        paramb = paramb.append(paramString).append(",contact liveStatus:");
        paramString = paramBaseFinderFeed.feedObject.getRefObjectContact();
        if (paramString != null) {
          break label1415;
        }
      }
      for (paramString = null;; paramString = Integer.valueOf(paramString.liveStatus))
      {
        Log.i("Finder.FinderProfileUIMediaLiveViewHolder", paramString);
        AppMethodBeat.o(349843);
        return;
        localObject2 = (dji)kotlin.a.p.oK((List)paramBaseFinderFeed.feedObject.getMediaList());
        break;
        label1048:
        localObject1 = ((m)localObject1).amx();
        break label105;
        label1058:
        i = 1;
        break label331;
        label1064:
        localObject1 = paramBaseFinderFeed.feedObject.getFeedObject().objectDesc;
        if (localObject1 == null)
        {
          localObject1 = "";
          break label354;
        }
        localObject3 = ((FinderObjectDesc)localObject1).description;
        localObject1 = localObject3;
        if (localObject3 != null) {
          break label354;
        }
        localObject1 = "";
        break label354;
        label1111:
        localObject3 = k.FxZ;
        i = k.ePd() / 2;
        break label385;
        label1126:
        paramString = MMApplicationContext.getContext();
        localObject3 = k.FxZ;
        localObject3 = ((TextView)localObject4).getPaint();
        kotlin.g.b.s.s(localObject3, "descTv.paint");
        localObject5 = am.aixg;
        localObject5 = String.format("#%06X", Arrays.copyOf(new Object[] { Integer.valueOf(0xFFFFFF & ((TextView)localObject4).getCurrentTextColor()) }, 1));
        kotlin.g.b.s.s(localObject5, "java.lang.String.format(format, *args)");
        ((TextView)localObject4).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.d(paramString, (CharSequence)k.a((String)localObject1, (TextPaint)localObject3, i, (String)localObject5, false), 0.0F));
        break label402;
        label1225:
        ((TextView)localObject4).setVisibility(8);
        break label416;
        label1235:
        i = (getScreenWidth() - (int)((View)localObject4).getContext().getResources().getDimension(e.c.Edge_0_5_A) * 6) / 2;
        break label492;
        label1265:
        localObject4 = av.GiL;
        j = av.a(paramBaseFinderFeed, (dji)localObject2, i);
        break label512;
        i = 0;
        break label630;
        paramString = com.tencent.mm.plugin.finder.loader.p.ExI;
        paramString = com.tencent.mm.plugin.finder.loader.p.a(p.a.ExJ);
        break label684;
        label1303:
        localObject1 = h.ax(g.class);
        kotlin.g.b.s.s(localObject1, "service(IFinderCommonLiveService::class.java)");
        localObject1 = (g)localObject1;
        kotlin.g.b.s.s(localObject3, "thumbIv");
        g.a.a((g)localObject1, (ImageView)localObject3, paramString);
        break label694;
        label1345:
        i = 0;
        break label762;
        label1351:
        ((FinderLiveOnliveWidget)localObject1).setVisibility(8);
        break label773;
        label1361:
        i = 0;
        break label820;
        label1367:
        ((TextView)localObject3).setText((CharSequence)paramString);
        ((View)localObject2).setVisibility(0);
        break label871;
        label1385:
        i = paramString.EOg;
        break label886;
        label1394:
        ((TextView)localObject4).setVisibility(8);
        break label913;
        label1404:
        paramString = Integer.valueOf(paramString.liveStatus);
        break label980;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderProfileUIMediaLiveViewHolder$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.cg
 * JD-Core Version:    0.7.0.1
 */