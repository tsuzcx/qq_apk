package com.tencent.mm.plugin.finder.convert;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.feed.bb.a;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.loader.x;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.g;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.plugin.finder.view.FinderPostProgressView;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.asg;
import com.tencent.mm.protocal.protobuf.bfv;
import com.tencent.mm.protocal.protobuf.bfz;
import com.tencent.mm.protocal.protobuf.bkr;
import com.tencent.mm.protocal.protobuf.csh;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.List;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedRoundCornerConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "layoutResId", "", "(I)V", "progressAnimator", "Landroid/animation/ValueAnimator;", "getProgressAnimator", "()Landroid/animation/ValueAnimator;", "setProgressAnimator", "(Landroid/animation/ValueAnimator;)V", "wrapper", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$FinderTopicInfoWrapper;", "getWrapper", "()Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$FinderTopicInfoWrapper;", "setWrapper", "(Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$FinderTopicInfoWrapper;)V", "bindTopPlace", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "feed", "existCampaignWithCover", "", "item", "getLayoutId", "jumpProfile", "context", "Landroid/content/Context;", "feedId", "", "username", "", "onBindViewHolder", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-finder_release"})
public abstract class ag
  extends com.tencent.mm.view.recyclerview.e<BaseFinderFeed>
{
  private ValueAnimator opx;
  public bb.a xmb;
  private final int xmc;
  
  public ag(int paramInt)
  {
    this.xmc = paramInt;
  }
  
  protected static void c(Context paramContext, long paramLong, String paramString)
  {
    p.k(paramContext, "context");
    p.k(paramString, "username");
    Object localObject1 = new Intent();
    ((Intent)localObject1).putExtra("finder_username", paramString);
    Object localObject2 = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
    aj.a.a(paramContext, (Intent)localObject1, paramLong, 1, false, 64);
    localObject2 = com.tencent.mm.plugin.finder.utils.a.ACH;
    com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI(paramContext, (Intent)localObject1);
    localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
    paramContext = aj.a.fZ(paramContext);
    if (paramContext != null)
    {
      localObject1 = n.zWF;
      n.a(4, paramLong, paramContext.xkX, 1, paramString);
    }
  }
  
  protected static void l(com.tencent.mm.view.recyclerview.i parami, BaseFinderFeed paramBaseFinderFeed)
  {
    p.k(parami, "holder");
    p.k(paramBaseFinderFeed, "feed");
    parami = (LinearLayout)parami.RD(b.f.finder_top_place_layout);
    if (parami != null) {
      parami.setVisibility(8);
    }
    if (paramBaseFinderFeed.feedObject.getStickyTime() > 0) {
      if (parami != null) {
        parami.setVisibility(0);
      }
    }
    while (parami == null) {
      return;
    }
    parami.setVisibility(8);
  }
  
  public void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.i parami, int paramInt)
  {
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
  }
  
  public void a(final com.tencent.mm.view.recyclerview.i parami, final BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    p.k(parami, "holder");
    p.k(paramBaseFinderFeed, "item");
    Object localObject2 = (ImageView)parami.RD(b.f.finder_avatar);
    paramList = com.tencent.mm.plugin.finder.loader.t.ztT;
    Object localObject1 = com.tencent.mm.plugin.finder.loader.t.dJh();
    paramList = paramBaseFinderFeed.contact;
    Object localObject3;
    label189:
    label346:
    Object localObject4;
    label259:
    label286:
    Object localObject5;
    if (paramList != null)
    {
      paramList = paramList.Mm();
      paramList = new com.tencent.mm.plugin.finder.loader.e(Util.nullAsNil(paramList), u.AlQ);
      p.j(localObject2, "avatar");
      localObject3 = com.tencent.mm.plugin.finder.loader.t.ztT;
      ((d)localObject1).a(paramList, (ImageView)localObject2, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztX));
      localObject1 = (TextView)parami.RD(b.f.finder_nickname);
      p.j(localObject1, "nickname");
      ((TextView)localObject1).setText((CharSequence)paramBaseFinderFeed.feedObject.getNickNameSpan());
      ar.a((Paint)((TextView)localObject1).getPaint(), 0.8F);
      localObject3 = (TextView)parami.RD(b.f.like_count_tv);
      p.j(localObject3, "likeTv");
      if (paramBaseFinderFeed.feedObject.getLikeCount() <= 0) {
        break label880;
      }
      paramList = (CharSequence)m.gY(2, paramBaseFinderFeed.feedObject.getLikeCount());
      ((TextView)localObject3).setText(paramList);
      ((TextView)localObject3).setTextSize(1, 10.0F);
      paramList = (TextView)parami.RD(b.f.finder_desc);
      if (Util.isNullOrNil(paramBaseFinderFeed.feedObject.getDescription())) {
        break label891;
      }
      p.j(paramList, "descTv");
      paramList.setVisibility(0);
      paramList.setText((CharSequence)paramBaseFinderFeed.feedObject.getDescriptionSpan());
      if (!paramBaseFinderFeed.currentUsed) {
        break label909;
      }
      localObject3 = parami.RD(b.f.finder_used_container);
      if (localObject3 != null) {
        ((View)localObject3).setVisibility(0);
      }
      if ((paramInt1 != 0) || (!paramBaseFinderFeed.isOriginFeed)) {
        break label933;
      }
      localObject3 = parami.RD(b.f.line);
      p.j(localObject3, "holder.getView<View>(R.id.line)");
      ((View)localObject3).setVisibility(0);
      localObject3 = parami.RD(b.f.origin_feed);
      p.j(localObject3, "holder.getView<TextView>(R.id.origin_feed)");
      ((TextView)localObject3).setVisibility(0);
      localObject3 = paramBaseFinderFeed.contact;
      if (localObject3 != null)
      {
        localObject4 = com.tencent.mm.plugin.finder.utils.aj.AGc;
        localObject4 = parami.RD(b.f.auth_icon);
        p.j(localObject4, "holder.getView<ImageView>(R.id.auth_icon)");
        com.tencent.mm.plugin.finder.utils.aj.a((ImageView)localObject4, ((com.tencent.mm.plugin.finder.api.i)localObject3).field_authInfo);
      }
      ((ImageView)localObject2).setOnClickListener((View.OnClickListener)new a(this, parami, paramBaseFinderFeed));
      ((TextView)localObject1).setOnClickListener((View.OnClickListener)new b(this, parami, paramBaseFinderFeed));
      localObject2 = new aa.f();
      ((aa.f)localObject2).aaBC = ((FinderPostProgressView)parami.RD(b.f.profile_upload_progress));
      localObject3 = parami.RD(b.f.profile_upload_area);
      localObject4 = parami.RD(b.f.profile_item_failed_area);
      localObject5 = parami.RD(b.f.finder_media_bottom);
      if (!paramBaseFinderFeed.feedObject.isPostFailed()) {
        break label987;
      }
      p.j(localObject4, "failedArea");
      ((View)localObject4).setVisibility(0);
      p.j(localObject3, "progressArea");
      ((View)localObject3).setVisibility(8);
      p.j(localObject5, "normalView");
      ((View)localObject5).setVisibility(8);
      label533:
      localObject2 = (ImageView)parami.RD(b.f.like_icon_iv);
      localObject3 = g.AnT;
      localObject3 = g.Qt(paramBaseFinderFeed.feedObject.getFeedObject().objectType);
      if (localObject3 != null)
      {
        localObject4 = (CharSequence)((bfz)localObject3).SQL;
        if ((localObject4 != null) && (((CharSequence)localObject4).length() != 0)) {
          break label1193;
        }
        paramInt1 = 1;
        label597:
        if (paramInt1 == 0) {
          break label1198;
        }
      }
      localObject3 = parami.getContext();
      paramInt1 = b.i.icon_filled_awesome;
      localObject4 = parami.getContext();
      p.j(localObject4, "holder.context");
      ((ImageView)localObject2).setImageDrawable(au.o((Context)localObject3, paramInt1, ((Context)localObject4).getResources().getColor(b.c.White)));
      p.j(localObject2, "likeIv");
      ((ImageView)localObject2).setEnabled(false);
    }
    for (;;)
    {
      if (h(paramBaseFinderFeed))
      {
        paramBaseFinderFeed = parami.getContext();
        p.j(paramBaseFinderFeed, "holder.context");
        paramInt1 = paramBaseFinderFeed.getResources().getColor(b.c.finder_activity_covered_icon_cover);
        paramBaseFinderFeed = parami.getContext();
        p.j(paramBaseFinderFeed, "holder.context");
        paramInt2 = paramBaseFinderFeed.getResources().getColor(b.c.finder_activity_covered_white);
        paramBaseFinderFeed = parami.getContext();
        p.j(paramBaseFinderFeed, "holder.context");
        int i = paramBaseFinderFeed.getResources().getColor(b.c.finder_activity_item_covered_background);
        ((TextView)localObject1).setTextColor(paramInt1);
        paramList.setTextColor(paramInt1);
        paramBaseFinderFeed = (TextView)parami.RD(b.f.finder_posting_text);
        if (paramBaseFinderFeed != null) {
          paramBaseFinderFeed.setTextColor(paramInt1);
        }
        paramBaseFinderFeed = (TextView)parami.RD(b.f.finder_post_failed_text);
        if (paramBaseFinderFeed != null) {
          paramBaseFinderFeed.setTextColor(paramInt1);
        }
        paramBaseFinderFeed = parami.RD(b.f.finder_media_bottom);
        if (paramBaseFinderFeed != null) {
          paramBaseFinderFeed.setBackgroundColor(i);
        }
        paramBaseFinderFeed = parami.RD(b.f.profile_upload_area);
        if (paramBaseFinderFeed != null) {
          paramBaseFinderFeed.setBackgroundColor(i);
        }
        paramBaseFinderFeed = parami.RD(b.f.profile_item_failed_area);
        if (paramBaseFinderFeed != null) {
          paramBaseFinderFeed.setBackgroundColor(i);
        }
        parami.RD(b.f.profile_feed_icon_divider).setBackgroundColor(paramInt2);
        ((WeImageView)parami.RD(b.f.profile_feed_icon_iv)).setIconColor(paramInt2);
      }
      return;
      paramList = null;
      break;
      label880:
      paramList = (CharSequence)"0";
      break label189;
      label891:
      p.j(paramList, "descTv");
      paramList.setVisibility(8);
      break label259;
      label909:
      localObject3 = parami.RD(b.f.finder_used_container);
      if (localObject3 == null) {
        break label286;
      }
      ((View)localObject3).setVisibility(8);
      break label286;
      label933:
      localObject3 = parami.RD(b.f.line);
      p.j(localObject3, "holder.getView<View>(R.id.line)");
      ((View)localObject3).setVisibility(8);
      localObject3 = parami.RD(b.f.origin_feed);
      p.j(localObject3, "holder.getView<TextView>(R.id.origin_feed)");
      ((TextView)localObject3).setVisibility(8);
      break label346;
      label987:
      if (paramBaseFinderFeed.feedObject.isPostFinish())
      {
        p.j(localObject4, "failedArea");
        ((View)localObject4).setVisibility(8);
        p.j(localObject3, "progressArea");
        ((View)localObject3).setVisibility(8);
        p.j(localObject5, "normalView");
        ((View)localObject5).setVisibility(0);
        break label533;
      }
      p.j(localObject4, "failedArea");
      ((View)localObject4).setVisibility(8);
      p.j(localObject3, "progressArea");
      ((View)localObject3).setVisibility(0);
      p.j(localObject5, "normalView");
      ((View)localObject5).setVisibility(8);
      this.opx = ValueAnimator.ofInt(new int[] { ((FinderPostProgressView)((aa.f)localObject2).aaBC).getProgress(), paramBaseFinderFeed.feedObject.getPostInfo().TAi });
      localObject3 = this.opx;
      if (localObject3 == null) {
        p.iCn();
      }
      ((ValueAnimator)localObject3).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new c((aa.f)localObject2));
      localObject2 = this.opx;
      if (localObject2 == null) {
        p.iCn();
      }
      localObject2 = ((ValueAnimator)localObject2).setDuration(400L);
      if (localObject2 == null) {
        break label533;
      }
      ((ValueAnimator)localObject2).start();
      break label533;
      label1193:
      paramInt1 = 0;
      break label597;
      label1198:
      localObject4 = com.tencent.mm.plugin.finder.loader.t.ztT;
      localObject4 = com.tencent.mm.plugin.finder.loader.t.dJe();
      localObject3 = new x(((bfz)localObject3).SQL, u.Aly);
      p.j(localObject2, "likeIv");
      localObject5 = com.tencent.mm.plugin.finder.loader.t.ztT;
      ((d)localObject4).a(localObject3, (ImageView)localObject2, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztU));
      ((ImageView)localObject2).setColorFilter(com.tencent.mm.ci.a.w(parami.getContext(), b.c.White), PorterDuff.Mode.SRC_ATOP);
    }
  }
  
  public final int getLayoutId()
  {
    return this.xmc;
  }
  
  public final boolean h(BaseFinderFeed paramBaseFinderFeed)
  {
    Object localObject2 = null;
    p.k(paramBaseFinderFeed, "item");
    Object localObject1 = paramBaseFinderFeed.feedObject.getFeedObject().objectDesc;
    if (localObject1 != null)
    {
      localObject1 = ((FinderObjectDesc)localObject1).event;
      if (localObject1 == null) {}
    }
    for (localObject1 = ((bfv)localObject1).eventName; !Util.isNullOrNil((String)localObject1); localObject1 = null)
    {
      paramBaseFinderFeed = paramBaseFinderFeed.feedObject.getFeedObject().objectDesc;
      if (paramBaseFinderFeed != null)
      {
        paramBaseFinderFeed = paramBaseFinderFeed.event;
        if ((paramBaseFinderFeed != null) && (paramBaseFinderFeed.xdR == 0L)) {
          break;
        }
      }
      localObject1 = this.xmb;
      paramBaseFinderFeed = localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((bb.a)localObject1).fGc;
        paramBaseFinderFeed = localObject2;
        if (localObject1 != null)
        {
          localObject1 = ((bkr)localObject1).SVJ;
          paramBaseFinderFeed = localObject2;
          if (localObject1 != null) {
            paramBaseFinderFeed = ((asg)localObject1).coverImgUrl;
          }
        }
      }
      if (Util.isNullOrNil(paramBaseFinderFeed)) {
        break;
      }
      return true;
    }
    return false;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(ag paramag, com.tencent.mm.view.recyclerview.i parami, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(272845);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedRoundCornerConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = parami.getContext();
      p.j(paramView, "holder.context");
      ag.c(paramView, paramBaseFinderFeed.mf(), paramBaseFinderFeed.feedObject.getUserName());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedRoundCornerConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(272845);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(ag paramag, com.tencent.mm.view.recyclerview.i parami, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(237886);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedRoundCornerConvert$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = parami.getContext();
      p.j(paramView, "holder.context");
      ag.c(paramView, paramBaseFinderFeed.mf(), paramBaseFinderFeed.feedObject.getUserName());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedRoundCornerConvert$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(237886);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class c
    implements ValueAnimator.AnimatorUpdateListener
  {
    c(aa.f paramf) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(244276);
      FinderPostProgressView localFinderPostProgressView = (FinderPostProgressView)this.xme.aaBC;
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new kotlin.t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(244276);
        throw paramValueAnimator;
      }
      localFinderPostProgressView.setProgress(((Integer)paramValueAnimator).intValue());
      ((FinderPostProgressView)this.xme.aaBC).invalidate();
      AppMethodBeat.o(244276);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.ag
 * JD-Core Version:    0.7.0.1
 */