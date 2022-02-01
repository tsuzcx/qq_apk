package com.tencent.mm.plugin.finder.feed.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.d.a.a.a.b.b.e;
import com.tencent.d.a.a.a.b.b.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.d.b.g;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.feed.jumper.l;
import com.tencent.mm.plugin.finder.feed.jumper.r;
import com.tencent.mm.plugin.finder.loader.p;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.plugin.finder.utils.af;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderJumpInfo;
import com.tencent.mm.protocal.protobuf.FinderJumpInfoRedDot;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.NativeInfo;
import com.tencent.mm.protocal.protobuf.brs;
import com.tencent.mm.protocal.protobuf.dwa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.f;
import kotlin.g.b.u;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/component/FeedAdHotSpotJumperObserver;", "Lcom/tencent/mm/plugin/finder/feed/component/FinderBaseAdFeedJumperUIC$FeedJumperObserver;", "()V", "handleIconLoad", "", "iconLayout", "Landroid/view/View;", "success", "", "loadImage", "info", "Lcom/tencent/mm/protocal/protobuf/FinderJumpInfo;", "iconView", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "onBindView", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "jumpView", "infoEx", "Lcom/tencent/mm/plugin/finder/feed/jumper/FinderJumpInfoEx;", "source", "", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends f.b
{
  public static final a BbY;
  
  static
  {
    AppMethodBeat.i(364109);
    BbY = new a((byte)0);
    AppMethodBeat.o(364109);
  }
  
  private static final void a(c paramc, View paramView, com.tencent.mm.loader.g.a.a parama, g paramg, Bitmap paramBitmap)
  {
    AppMethodBeat.i(364095);
    kotlin.g.b.s.u(paramc, "this$0");
    kotlin.g.b.s.u(paramView, "$iconLayout");
    if (paramBitmap != null) {}
    for (boolean bool = true;; bool = false)
    {
      r(paramView, bool);
      AppMethodBeat.o(364095);
      return;
    }
  }
  
  private static final void a(c paramc, View paramView, String paramString, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(364106);
    kotlin.g.b.s.u(paramc, "this$0");
    kotlin.g.b.s.u(paramView, "$iconLayout");
    r(paramView, false);
    AppMethodBeat.o(364106);
  }
  
  private static final void a(c paramc, View paramView, boolean paramBoolean, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(364102);
    kotlin.g.b.s.u(paramc, "this$0");
    kotlin.g.b.s.u(paramView, "$iconLayout");
    r(paramView, paramBoolean);
    AppMethodBeat.o(364102);
  }
  
  private static final void a(com.tencent.mm.view.recyclerview.j paramj, String paramString1, View paramView1, int paramInt, String paramString2, ah.f paramf1, ah.f paramf2, BaseFinderFeed paramBaseFinderFeed, View paramView2)
  {
    AppMethodBeat.i(364091);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramj);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramString1);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView1);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).sc(paramInt);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramString2);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramf1);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramf2);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramBaseFinderFeed);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView2);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/component/FeedAdHotSpotJumperObserver", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(paramj, "$holder");
    kotlin.g.b.s.u(paramView1, "$jumpView");
    kotlin.g.b.s.u(paramf1, "$avatarUrl");
    kotlin.g.b.s.u(paramf2, "$nickname");
    kotlin.g.b.s.u(paramBaseFinderFeed, "$feed");
    paramView2 = (com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class);
    localObject1 = paramj.context;
    kotlin.g.b.s.s(localObject1, "holder.context");
    localObject2 = new brs();
    ((brs)localObject2).ZVq = String.valueOf(paramInt);
    ((brs)localObject2).ZVp = paramString2;
    ((brs)localObject2).ZVs = ((String)paramf1.aqH);
    ((brs)localObject2).ZVr = ((String)paramf2.aqH);
    paramString2 = paramBaseFinderFeed.feedObject.getFeedObject().contact;
    if (paramString2 == null)
    {
      paramString2 = "";
      ((brs)localObject2).finderUsername = paramString2;
      paramString2 = ah.aiuX;
      paramf2 = new dwa();
      paramString2 = b.e.ahon;
      paramf2.abbK = b.e.a.jVX();
      paramString2 = paramBaseFinderFeed.feedObject.getFeedObject().contact;
      if (paramString2 != null) {
        break label385;
      }
      paramString2 = "";
    }
    for (;;)
    {
      paramf2.finderUsername = paramString2;
      paramf2.hJW = paramj.context.getClass().getName();
      paramf2.CRV = 999;
      paramj = ah.aiuX;
      paramView2.gotoLive((Context)localObject1, paramString1, (brs)localObject2, paramf2);
      paramView1.performClick();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/feed/component/FeedAdHotSpotJumperObserver", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(364091);
      return;
      paramf1 = paramString2.username;
      paramString2 = paramf1;
      if (paramf1 != null) {
        break;
      }
      paramString2 = "";
      break;
      label385:
      paramf1 = paramString2.username;
      paramString2 = paramf1;
      if (paramf1 == null) {
        paramString2 = "";
      }
    }
  }
  
  private static void r(final View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(364072);
    kotlin.g.b.s.u(paramView, "iconLayout");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(paramBoolean, paramView));
    AppMethodBeat.o(364072);
  }
  
  public final void a(BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.view.recyclerview.j paramj, View paramView, com.tencent.mm.plugin.finder.feed.jumper.k paramk, String paramString)
  {
    AppMethodBeat.i(364160);
    kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
    kotlin.g.b.s.u(paramj, "holder");
    kotlin.g.b.s.u(paramView, "jumpView");
    kotlin.g.b.s.u(paramk, "infoEx");
    kotlin.g.b.s.u(paramString, "source");
    paramString = paramk.hVf;
    Log.i("Finder.FeedAdHotSpotJumperObserver", "[onBindView] feedId=" + com.tencent.mm.ae.d.hF(this.feedId) + " jumpType=" + paramString.jumpinfo_type + " title=" + paramString.recommend_reason + '|' + paramString.wording + " icon_url=" + paramString.icon_url + " ext_info=" + paramString.ext_info + ' ');
    int i;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    label359:
    label365:
    int j;
    label479:
    Object localObject4;
    if (paramString.business_type == 16)
    {
      i = 1;
      localObject1 = paramView.findViewById(e.e.hotspot_normal_layout);
      localObject2 = paramView.findViewById(e.e.hotspot_oly_layout);
      if (i != 0)
      {
        ((View)localObject2).setVisibility(0);
        ((View)localObject1).setVisibility(8);
        paramk = af.Ghj;
        af.a(paramj, paramView.getVisibility(), 1);
      }
    }
    else
    {
      for (;;)
      {
        try
        {
          paramk = com.tencent.mm.ui.component.k.aeZF;
          paramk = com.tencent.mm.ui.component.k.cn(cn.class).q(com.tencent.mm.plugin.finder.feed.jumper.i.class);
          kotlin.g.b.s.s(paramk, "UICProvider.of(IPluginFi…perGlobalUIC::class.java)");
          paramk = (com.tencent.mm.plugin.finder.feed.jumper.i)paramk;
          localObject1 = (CharSequence)paramString.jump_id;
          if (localObject1 == null) {
            break label1543;
          }
          if (((CharSequence)localObject1).length() != 0) {
            break label359;
          }
        }
        finally
        {
          Log.printErrStackTrace("Finder.FeedAdHotSpotJumperObserver", paramBaseFinderFeed, "oly bindview error", new Object[0]);
          ((View)localObject2).setVisibility(8);
          AppMethodBeat.o(364160);
          return;
        }
        if (i != 0) {
          break label850;
        }
        localObject1 = (Map)paramk.BdI;
        localObject3 = paramString.jump_id;
        if (localObject1 != null) {
          break label365;
        }
        paramBaseFinderFeed = new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
        AppMethodBeat.o(364160);
        throw paramBaseFinderFeed;
        i = 0;
        break;
        i = 0;
      }
      if (((Map)localObject1).containsKey(localObject3))
      {
        paramk = (Map)paramk.BdI;
        localObject1 = paramString.jump_id;
        if (paramk == null)
        {
          paramBaseFinderFeed = new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, V>");
          AppMethodBeat.o(364160);
          throw paramBaseFinderFeed;
        }
        paramk = (FinderJumpInfo)paramk.getOrDefault(localObject1, paramString);
        localObject1 = (TextView)((View)localObject2).findViewById(e.e.feed_oly_title);
        localObject3 = (TextView)((View)localObject2).findViewById(e.e.feed_oly_desc);
        paramString = paramk.recommend_reason;
        if (paramString != null) {
          break label857;
        }
        paramString = (CharSequence)"";
        ((TextView)localObject1).setText(paramString);
        kotlin.g.b.s.s(localObject1, "titleTv");
        com.tencent.mm.plugin.finder.utils.i.setTextBold((TextView)localObject1);
        localObject1 = paramk.wording;
        paramString = (String)localObject1;
        if (localObject1 == null) {
          paramString = "";
        }
        ((TextView)localObject3).setText((CharSequence)paramString);
        if (((CharSequence)paramString).length() != 0) {
          break label1561;
        }
        i = 1;
        label545:
        if (i != 0) {
          ((TextView)localObject3).setVisibility(8);
        }
        paramk = paramk.native_info;
        if (paramk != null) {
          break label867;
        }
        paramk = null;
        label572:
        Log.i("Finder.FeedAdHotSpotJumperObserver", kotlin.g.b.s.X("oly bindview, json:", paramk));
        paramk = new JSONObject(paramk);
        paramk.getString("live_nickname");
        paramString = paramk.getString("live_username");
        j = paramk.getInt("relay_index");
        localObject1 = paramk.optString("by_pass_info_string", "");
        localObject3 = new ah.f();
        paramk = paramBaseFinderFeed.contact;
        if (paramk != null) {
          break label877;
        }
        paramk = null;
        label661:
        ((ah.f)localObject3).aqH = paramk;
        paramk = (CharSequence)((ah.f)localObject3).aqH;
        if (paramk == null) {
          break label1549;
        }
        if (paramk.length() != 0) {
          break label1567;
        }
        break label1549;
        label696:
        if (i != 0)
        {
          paramk = paramBaseFinderFeed.feedObject.getFeedObject().contact;
          if (paramk != null) {
            break label887;
          }
          paramk = null;
          label721:
          ((ah.f)localObject3).aqH = paramk;
        }
        localObject4 = new ah.f();
        paramk = paramBaseFinderFeed.contact;
        if (paramk != null) {
          break label897;
        }
        paramk = null;
        label751:
        ((ah.f)localObject4).aqH = paramk;
        paramk = (CharSequence)((ah.f)localObject4).aqH;
        if (paramk == null) {
          break label1555;
        }
        if (paramk.length() != 0) {
          break label1573;
        }
        break label1555;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        paramk = paramBaseFinderFeed.feedObject.getFeedObject().contact;
        if (paramk != null) {
          break label907;
        }
      }
      label897:
      label907:
      for (paramk = null;; paramk = paramk.nickname)
      {
        ((ah.f)localObject4).aqH = paramk;
        ((View)localObject2).setOnClickListener(new c..ExternalSyntheticLambda0(paramj, paramString, paramView, j, (String)localObject1, (ah.f)localObject3, (ah.f)localObject4, paramBaseFinderFeed));
        AppMethodBeat.o(364160);
        return;
        label850:
        paramk = paramString;
        break;
        label857:
        paramString = (CharSequence)paramString;
        break label479;
        label867:
        paramk = paramk.necessary_params;
        break label572;
        label877:
        paramk = paramk.dUs();
        break label661;
        label887:
        paramk = paramk.headUrl;
        break label721;
        paramk = paramk.dUr();
        break label751;
      }
      ((View)localObject2).setVisibility(8);
      ((View)localObject1).setVisibility(0);
      if (paramString.business_type == 2) {}
      for (i = 1; i == 0; i = 0)
      {
        paramBaseFinderFeed = af.Ghj;
        if (af.iq(paramj.hashCode(), 16)) {
          break;
        }
        paramView.setVisibility(8);
        Log.i("Finder.FeedAdHotSpotJumperObserver", "[onBindView] priority not ok");
        AppMethodBeat.o(364160);
        return;
      }
      localObject3 = (RoundedCornerFrameLayout)paramView.findViewById(e.e.finder_feed_jump_icon_layout);
      localObject2 = (WeImageView)paramView.findViewById(e.e.finder_feed_ad_icon);
      localObject1 = (TextView)paramView.findViewById(e.e.finder_feed_ad_wording);
      ((WeImageView)localObject2).clearColorFilter();
      ((WeImageView)localObject2).setLayerPaint(null);
      ((WeImageView)localObject2).setIconColor(0);
      paramBaseFinderFeed = paramk.Bea;
      if (paramBaseFinderFeed == null)
      {
        paramBaseFinderFeed = null;
        if (paramBaseFinderFeed == null)
        {
          paramBaseFinderFeed = (c)this;
          kotlin.g.b.s.s(localObject3, "iconLayout");
          localObject3 = (View)localObject3;
          kotlin.g.b.s.s(localObject2, "iconView");
          kotlin.g.b.s.u(paramString, "info");
          kotlin.g.b.s.u(localObject3, "iconLayout");
          kotlin.g.b.s.u(localObject2, "iconView");
          localObject4 = (CharSequence)paramString.icon_url;
          if ((localObject4 != null) && (((CharSequence)localObject4).length() != 0)) {
            break label1355;
          }
          j = 1;
          label1140:
          if (j == 0) {
            break label1361;
          }
          ((View)localObject3).setVisibility(8);
          label1152:
          paramBaseFinderFeed = r.Bej;
          paramBaseFinderFeed = paramj.context;
          kotlin.g.b.s.s(paramBaseFinderFeed, "holder.context");
          ((TextView)localObject1).setText((CharSequence)r.a(paramBaseFinderFeed, paramString));
          paramBaseFinderFeed = paramString.red_dot;
          if ((paramBaseFinderFeed != null) && (1L == paramBaseFinderFeed.red_dot_type))
          {
            paramBaseFinderFeed = (WeImageView)paramView.findViewById(e.e.finder_feed_jumper_arrow);
            if (paramBaseFinderFeed != null) {
              paramBaseFinderFeed.setVisibility(8);
            }
            paramBaseFinderFeed = (LinearLayout)paramView.findViewById(e.e.finder_feed_jumper_red_dot_layout);
            if (paramBaseFinderFeed != null) {
              paramBaseFinderFeed.setVisibility(0);
            }
          }
        }
        paramBaseFinderFeed = ((TextView)localObject1).getText();
        if ((paramBaseFinderFeed != null) && (paramBaseFinderFeed.length() != 0)) {
          break label1468;
        }
      }
      label1468:
      for (j = 1;; j = 0)
      {
        if (j == 0) {
          break label1474;
        }
        paramView.setVisibility(8);
        Log.w("Finder.FeedAdHotSpotJumperObserver", "title is null.");
        AppMethodBeat.o(364160);
        return;
        localObject4 = r.Bej;
        kotlin.g.b.s.s(localObject2, "iconView");
        r.a(paramBaseFinderFeed, (WeImageView)localObject2, paramj);
        if ((paramBaseFinderFeed instanceof l)) {
          localObject4 = r.Bej;
        }
        for (paramBaseFinderFeed = (CharSequence)r.a(paramj, (l)paramBaseFinderFeed);; paramBaseFinderFeed = paramBaseFinderFeed.title)
        {
          ((TextView)localObject1).setText(paramBaseFinderFeed);
          paramBaseFinderFeed = ah.aiuX;
          break;
        }
        label1355:
        j = 0;
        break label1140;
        label1361:
        ((View)localObject3).setVisibility(0);
        localObject4 = p.ExI;
        localObject4 = p.eCl();
        com.tencent.mm.plugin.finder.loader.s locals = new com.tencent.mm.plugin.finder.loader.s(paramString.icon_url, v.FKZ);
        p localp = p.ExI;
        ((com.tencent.mm.loader.d)localObject4).a(locals, p.a(p.a.ExR)).a(new c..ExternalSyntheticLambda3(paramBaseFinderFeed, (View)localObject3)).a(new c..ExternalSyntheticLambda1(paramBaseFinderFeed, (View)localObject3)).a(new c..ExternalSyntheticLambda2(paramBaseFinderFeed, (View)localObject3)).d((ImageView)localObject2);
        break label1152;
      }
      label1474:
      paramView.setVisibility(0);
      if (i != 0) {}
      for (i = 2;; i = 16)
      {
        paramBaseFinderFeed = af.Ghj;
        af.a(paramj, paramView.getVisibility(), i);
        paramBaseFinderFeed = z.FrZ;
        paramBaseFinderFeed = paramj.context;
        kotlin.g.b.s.s(paramBaseFinderFeed, "holder.context");
        z.a(paramBaseFinderFeed, this.feedId, "operational_jumpinfo", paramk);
        AppMethodBeat.o(364160);
        return;
      }
      label1543:
      i = 1;
      break;
      label1549:
      i = 1;
      break label696;
      label1555:
      i = 1;
      continue;
      label1561:
      i = 0;
      break label545;
      label1567:
      i = 0;
      break label696;
      label1573:
      i = 0;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/component/FeedAdHotSpotJumperObserver$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(boolean paramBoolean, View paramView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.component.c
 * JD-Core Version:    0.7.0.1
 */