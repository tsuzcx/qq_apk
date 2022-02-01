package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Point;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.api.i;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.loader.e;
import com.tencent.mm.plugin.finder.loader.t;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.plugin.finder.view.FinderLiveOnliveWidget;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.ax;
import java.util.Arrays;
import java.util.List;
import kotlin.g.b.af;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderProfileUIMediaLiveViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "searchScene", "", "(Landroid/view/View;I)V", "screenWidth", "getScreenWidth", "()I", "getSearchScene", "bindCover", "", "holder", "localFinderMedia", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "bindDesc", "query", "", "mediaObj", "item", "bindLive", "bindMedia", "dataPos", "bindImage", "", "fromSearch", "itemClickListener", "Lkotlin/Function1;", "bindUserInfo", "isFinderLiveSearch", "jumpProfile", "context", "Landroid/content/Context;", "feedId", "", "username", "Companion", "plugin-finder_release"})
public final class cg
  extends RecyclerView.v
{
  public static final a xoE;
  private final int ptD;
  
  static
  {
    AppMethodBeat.i(286475);
    xoE = new a((byte)0);
    AppMethodBeat.o(286475);
  }
  
  public cg(View paramView, int paramInt)
  {
    super(paramView);
    AppMethodBeat.i(286473);
    this.ptD = paramInt;
    AppMethodBeat.o(286473);
  }
  
  private final boolean dpJ()
  {
    return this.ptD == 13;
  }
  
  private final int getScreenWidth()
  {
    AppMethodBeat.i(286471);
    if (ar.hIH())
    {
      View localView = this.amk;
      p.j(localView, "itemView");
      i = ax.au(localView.getContext()).x;
      AppMethodBeat.o(286471);
      return i;
    }
    int i = ax.au(MMApplicationContext.getContext()).x;
    AppMethodBeat.o(286471);
    return i;
  }
  
  public final void a(String paramString, final BaseFinderFeed paramBaseFinderFeed, kotlin.g.a.b<? super Integer, kotlin.x> paramb)
  {
    AppMethodBeat.i(286472);
    p.k(paramString, "query");
    p.k(paramBaseFinderFeed, "feed");
    p.k(paramb, "itemClickListener");
    Object localObject2;
    Object localObject3;
    Object localObject4;
    Object localObject1;
    Object localObject5;
    label105:
    label362:
    int i;
    label323:
    label348:
    int j;
    if (paramBaseFinderFeed.feedObject.isLiveFeed())
    {
      localObject2 = (csg)kotlin.a.j.lo((List)paramBaseFinderFeed.feedObject.getLiveMediaList());
      localObject3 = this.amk;
      p.j(localObject3, "itemView");
      localObject4 = (ImageView)((View)localObject3).findViewById(b.f.finder_avatar);
      localObject1 = t.ztT;
      localObject5 = t.dJh();
      localObject1 = paramBaseFinderFeed.contact;
      if (localObject1 == null) {
        break label1037;
      }
      localObject1 = ((i)localObject1).Mm();
      localObject1 = new e(Util.nullAsNil((String)localObject1));
      p.j(localObject4, "avatar");
      t localt = t.ztT;
      ((d)localObject5).a(localObject1, (ImageView)localObject4, t.a(t.a.ztX));
      ((ImageView)localObject4).setOnClickListener((View.OnClickListener)new c(this, (View)localObject3, paramBaseFinderFeed));
      localObject1 = (TextView)((View)localObject3).findViewById(b.f.finder_nickname);
      p.j(localObject1, "nickname");
      ((TextView)localObject1).setText((CharSequence)paramBaseFinderFeed.feedObject.getNickNameSpan());
      ar.a((Paint)((TextView)localObject1).getPaint(), 0.8F);
      ((TextView)localObject1).setOnClickListener((View.OnClickListener)new d(this, (View)localObject3, paramBaseFinderFeed));
      localObject1 = paramBaseFinderFeed.contact;
      if (localObject1 != null)
      {
        localObject4 = aj.AGc;
        localObject3 = ((View)localObject3).findViewById(b.f.auth_icon);
        p.j(localObject3, "holder.findViewById<ImageView>(R.id.auth_icon)");
        aj.a((ImageView)localObject3, ((i)localObject1).field_authInfo);
      }
      localObject1 = this.amk;
      p.j(localObject1, "itemView");
      localObject4 = (TextView)((View)localObject1).findViewById(b.f.finder_desc);
      if (!Util.isNullOrNil(paramString)) {
        break label1043;
      }
      localObject1 = paramBaseFinderFeed.feedObject.getDescription();
      if (!Util.isNullOrNil(paramString)) {
        break label1084;
      }
      p.j(localObject4, "descTv");
      ((TextView)localObject4).setText((CharSequence)localObject1);
      if (Util.isNullOrNil((String)localObject1)) {
        break label1203;
      }
      ((TextView)localObject4).setVisibility(0);
      localObject4 = this.amk;
      p.j(localObject4, "itemView");
      localObject3 = (ImageView)((View)localObject4).findViewById(b.f.thumb_iv);
      paramString = ((View)localObject4).findViewById(b.f.live_player_container);
      p.j(localObject3, "thumbIv");
      localObject1 = ((ImageView)localObject3).getLayoutParams();
      if (!dpJ()) {
        break label1213;
      }
      i = getScreenWidth();
      localObject4 = ((View)localObject4).getContext();
      p.j(localObject4, "holder.context");
      i = (i - (int)((Context)localObject4).getResources().getDimension(b.d.finder_0_25_A) * 6) / 2;
      label462:
      if (!paramBaseFinderFeed.feedObject.isLiveFeed()) {
        break label1259;
      }
      j = (int)(1.7776F * i);
      label482:
      if (j > 0)
      {
        ((ViewGroup.LayoutParams)localObject1).width = i;
        ((ViewGroup.LayoutParams)localObject1).height = j;
        ((ImageView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        p.j(paramString, "liveContainer");
        paramString.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      localObject1 = ((csg)localObject2).coverUrl;
      paramString = (String)localObject1;
      if (localObject1 == null) {
        paramString = "";
      }
      p.j(paramString, "localFinderMedia.coverUrl ?: \"\"");
      localObject1 = paramString;
      if (Util.isNullOrNil(paramString)) {
        localObject1 = p.I(((csg)localObject2).thumbUrl, Util.nullAsNil(((csg)localObject2).thumb_url_token));
      }
      paramString = paramBaseFinderFeed.feedObject.getLiveInfo();
      if ((paramString == null) || (paramString.liveStatus != 1)) {
        break label1291;
      }
      paramString = t.ztT;
      localObject2 = t.dJe();
      localObject1 = new com.tencent.mm.plugin.finder.loader.x((String)localObject1, u.Aly);
      if (!dpJ()) {
        break label1277;
      }
      paramString = t.ztT;
      paramString = t.a(t.a.zuh);
      label636:
      ((d)localObject2).a(localObject1, (ImageView)localObject3, paramString);
      label646:
      paramString = this.amk;
      p.j(paramString, "itemView");
      localObject1 = (FinderLiveOnliveWidget)paramString.findViewById(b.f.finder_live_mask_view);
      localObject2 = paramString.findViewById(b.f.finder_live_online_layout);
      if (!paramBaseFinderFeed.feedObject.isLiveFeed()) {
        break label1322;
      }
      localObject3 = paramBaseFinderFeed.feedObject.getLiveInfo();
      if ((localObject3 == null) || (((bac)localObject3).liveStatus != 1)) {
        break label1305;
      }
      p.j(localObject1, "liveFinishView");
      ((FinderLiveOnliveWidget)localObject1).setVisibility(8);
      label726:
      localObject3 = (TextView)paramString.findViewById(b.f.rec_reason_tv);
      localObject4 = (TextView)paramString.findViewById(b.f.watch_count_history_tv);
      paramString = paramBaseFinderFeed.feedObject.getLiveInfo();
      if ((paramString != null) && (paramString.liveStatus == 1))
      {
        p.j(localObject2, "onLiveWidgetLayout");
        ((View)localObject2).setVisibility(0);
        localObject1 = paramBaseFinderFeed.feedObject.getFeedObject().recommendReason;
        paramString = (String)localObject1;
        if (localObject1 == null) {
          paramString = "";
        }
        p.j(paramString, "feed.feedObject.feedObject.recommendReason ?: \"\"");
        if (!TextUtils.isEmpty((CharSequence)paramString)) {
          break label1340;
        }
        ((View)localObject2).setVisibility(8);
        label832:
        paramString = paramBaseFinderFeed.feedObject.getLiveInfo();
        if (paramString == null) {
          break label1366;
        }
        i = paramString.SFG;
        label850:
        if (i <= 0) {
          break label1372;
        }
        p.j(localObject4, "watchCountHistoryTv");
        ((TextView)localObject4).setText((CharSequence)String.valueOf(m.QI(i)));
        ((TextView)localObject4).setVisibility(0);
      }
      label885:
      i = paramBaseFinderFeed.feedObject.getMediaType();
      this.amk.setOnClickListener((View.OnClickListener)new cg.b(paramb, i));
      paramb = new StringBuilder("mediaType:").append(paramBaseFinderFeed.feedObject.getMediaType()).append(",liveStatus:");
      paramString = paramBaseFinderFeed.feedObject.getLiveInfo();
      if (paramString == null) {
        break label1390;
      }
      paramString = Integer.valueOf(paramString.liveStatus);
      label961:
      paramb = paramb.append(paramString).append(",contact liveStatus:");
      paramString = paramBaseFinderFeed.feedObject.getRefObjectContact();
      if (paramString == null) {
        break label1395;
      }
    }
    label1037:
    label1043:
    label1084:
    label1213:
    label1259:
    label1390:
    label1395:
    for (paramString = Integer.valueOf(paramString.liveStatus);; paramString = null)
    {
      Log.i("Finder.FinderProfileUIMediaLiveViewHolder", paramString.intValue());
      AppMethodBeat.o(286472);
      return;
      localObject2 = (csg)kotlin.a.j.lo((List)paramBaseFinderFeed.feedObject.getMediaList());
      break;
      localObject1 = null;
      break label105;
      localObject1 = paramBaseFinderFeed.feedObject.getFeedObject().objectDesc;
      if (localObject1 != null)
      {
        localObject3 = ((FinderObjectDesc)localObject1).description;
        localObject1 = localObject3;
        if (localObject3 != null) {
          break label323;
        }
      }
      localObject1 = "";
      break label323;
      p.j(localObject4, "descTv");
      paramString = MMApplicationContext.getContext();
      localObject3 = com.tencent.mm.plugin.finder.search.j.Acs;
      localObject3 = ((TextView)localObject4).getPaint();
      p.j(localObject3, "descTv.paint");
      localObject5 = com.tencent.mm.plugin.finder.search.j.Acs;
      i = com.tencent.mm.plugin.finder.search.j.dRg() / 2;
      localObject5 = af.aaBG;
      localObject5 = String.format("#%06X", Arrays.copyOf(new Object[] { Integer.valueOf(0xFFFFFF & ((TextView)localObject4).getCurrentTextColor()) }, 1));
      p.j(localObject5, "java.lang.String.format(format, *args)");
      ((TextView)localObject4).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.d(paramString, (CharSequence)com.tencent.mm.plugin.finder.search.j.a((String)localObject1, (TextPaint)localObject3, i, (String)localObject5, false), 0.0F));
      break label348;
      ((TextView)localObject4).setVisibility(8);
      break label362;
      i = getScreenWidth();
      localObject4 = ((View)localObject4).getContext();
      p.j(localObject4, "holder.context");
      i = (i - (int)((Context)localObject4).getResources().getDimension(b.d.Edge_0_5_A) * 6) / 2;
      break label462;
      localObject4 = aj.AGc;
      j = aj.a(paramBaseFinderFeed, (csg)localObject2, i);
      break label482;
      label1277:
      paramString = t.ztT;
      paramString = t.a(t.a.ztU);
      break label636;
      paramString = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      com.tencent.mm.plugin.finder.live.utils.a.g((ImageView)localObject3, (String)localObject1);
      break label646;
      p.j(localObject1, "liveFinishView");
      ((FinderLiveOnliveWidget)localObject1).setVisibility(0);
      break label726;
      p.j(localObject1, "liveFinishView");
      ((FinderLiveOnliveWidget)localObject1).setVisibility(8);
      break label726;
      p.j(localObject3, "recReasonTv");
      ((TextView)localObject3).setText((CharSequence)paramString);
      ((View)localObject2).setVisibility(0);
      break label832;
      i = 0;
      break label850;
      p.j(localObject4, "watchCountHistoryTv");
      ((TextView)localObject4).setVisibility(8);
      break label885;
      paramString = null;
      break label961;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderProfileUIMediaLiveViewHolder$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(cg paramcg, View paramView, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(239999);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderProfileUIMediaLiveViewHolder$bindUserInfo$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = this.xoI.getContext();
      p.j(paramView, "holder.context");
      paramBaseFinderFeed.mf();
      cg.aA(paramView, paramBaseFinderFeed.feedObject.getUserName());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderProfileUIMediaLiveViewHolder$bindUserInfo$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(239999);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(cg paramcg, View paramView, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(275605);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderProfileUIMediaLiveViewHolder$bindUserInfo$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = this.xoI.getContext();
      p.j(paramView, "holder.context");
      paramBaseFinderFeed.mf();
      cg.aA(paramView, paramBaseFinderFeed.feedObject.getUserName());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderProfileUIMediaLiveViewHolder$bindUserInfo$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(275605);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.cg
 * JD-Core Version:    0.7.0.1
 */