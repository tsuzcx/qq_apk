package com.tencent.mm.plugin.finder.convert;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.g;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.feed.bi.a;
import com.tencent.mm.plugin.finder.feed.ui.FinderPoiFeedUI;
import com.tencent.mm.plugin.finder.loader.p;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.h;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.utils.r;
import com.tencent.mm.plugin.finder.view.FinderPostProgressView;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.awt;
import com.tencent.mm.protocal.protobuf.brk;
import com.tencent.mm.protocal.protobuf.bxv;
import com.tencent.mm.protocal.protobuf.djj;
import com.tencent.mm.protocal.protobuf.pu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedRoundCornerConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "layoutResId", "", "(I)V", "progressAnimator", "Landroid/animation/ValueAnimator;", "getProgressAnimator", "()Landroid/animation/ValueAnimator;", "setProgressAnimator", "(Landroid/animation/ValueAnimator;)V", "wrapper", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$FinderTopicInfoWrapper;", "getWrapper", "()Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$FinderTopicInfoWrapper;", "setWrapper", "(Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$FinderTopicInfoWrapper;)V", "bindTopPlace", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "feed", "existCampaignWithCover", "", "getLayoutId", "jumpBizProfile", "context", "Landroid/content/Context;", "bizUsername", "", "jumpProfile", "username", "onBindViewHolder", "item", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "refreshFriendsLike", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class ac
  extends f<BaseFinderFeed>
{
  public static final a AKx = new a((byte)0);
  private final int AKy;
  public bi.a AKz;
  private ValueAnimator rtf;
  
  public ac(int paramInt)
  {
    this.AKy = paramInt;
  }
  
  private static void a(Context paramContext, BaseFinderFeed paramBaseFinderFeed, String paramString)
  {
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
    kotlin.g.b.s.u(paramString, "username");
    Object localObject1 = paramBaseFinderFeed.feedObject.getBizInfo();
    Object localObject2;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 == null)
      {
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("finder_username", paramString);
        localObject2 = as.GSQ;
        as.a.a(paramContext, (Intent)localObject1, paramBaseFinderFeed.bZA(), 1, false, 64);
        com.tencent.mm.plugin.finder.utils.a.GfO.enterFinderProfileUI(paramContext, (Intent)localObject1);
      }
      localObject1 = as.GSQ;
      paramContext = as.a.hu(paramContext);
      if (paramContext != null)
      {
        localObject1 = z.FrZ;
        z.a(4, paramBaseFinderFeed.bZA(), paramContext.AJo, 1, paramString);
      }
      return;
    }
    Log.i("FinderFeedRoundCornerConvert", kotlin.g.b.s.X("jumpBizProfile: bizUsername = ", ((pu)localObject1).ADE));
    localObject1 = ((pu)localObject1).ADE;
    if (localObject1 == null) {
      localObject1 = "";
    }
    for (;;)
    {
      localObject2 = new Intent();
      as.a locala = as.GSQ;
      as.a.a(paramContext, (Intent)localObject2, paramBaseFinderFeed.bZA(), 5, false, 64);
      ((Intent)localObject2).putExtra("Contact_User", (String)localObject1);
      ((Intent)localObject2).putExtra("Contact_Scene", 214);
      ((Intent)localObject2).putExtra("biz_profile_enter_from_finder", true);
      ((Intent)localObject2).putExtra("force_get_contact", true);
      ((Intent)localObject2).putExtra("key_use_new_contact_profile", true);
      ((Intent)localObject2).putExtra("biz_profile_tab_type", 1);
      ((Intent)localObject2).putExtra("Contact_Scene_Note", paramBaseFinderFeed.feedObject.getFeedObject().sessionBuffer);
      com.tencent.mm.br.c.b(paramContext, "profile", ".ui.ContactInfoUI", (Intent)localObject2);
      localObject1 = ah.aiuX;
      break;
    }
  }
  
  private static final void a(ac paramac, j paramj, BaseFinderFeed paramBaseFinderFeed, View paramView)
  {
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramac);
    localb.cH(paramj);
    localb.cH(paramBaseFinderFeed);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedRoundCornerConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramac, "this$0");
    kotlin.g.b.s.u(paramj, "$holder");
    kotlin.g.b.s.u(paramBaseFinderFeed, "$item");
    paramac = paramj.context;
    kotlin.g.b.s.s(paramac, "holder.context");
    a(paramac, paramBaseFinderFeed, paramBaseFinderFeed.feedObject.getUserName());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedRoundCornerConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
  }
  
  private static final void b(ac paramac, j paramj, BaseFinderFeed paramBaseFinderFeed, View paramView)
  {
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramac);
    localb.cH(paramj);
    localb.cH(paramBaseFinderFeed);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedRoundCornerConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramac, "this$0");
    kotlin.g.b.s.u(paramj, "$holder");
    kotlin.g.b.s.u(paramBaseFinderFeed, "$item");
    paramac = paramj.context;
    kotlin.g.b.s.s(paramac, "holder.context");
    a(paramac, paramBaseFinderFeed, paramBaseFinderFeed.feedObject.getUserName());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedRoundCornerConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
  }
  
  private static final void c(FinderPostProgressView paramFinderPostProgressView, ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null) {
      throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }
    paramFinderPostProgressView.setProgress(((Integer)paramValueAnimator).intValue());
    paramFinderPostProgressView.invalidate();
  }
  
  protected static void i(j paramj, BaseFinderFeed paramBaseFinderFeed)
  {
    kotlin.g.b.s.u(paramj, "holder");
    kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
    paramj = (LinearLayout)paramj.UH(e.e.finder_top_place_layout);
    if (paramj != null) {
      paramj.setVisibility(8);
    }
    if (paramBaseFinderFeed.feedObject.getStickyTime() > 0) {
      if (paramj != null) {
        paramj.setVisibility(0);
      }
    }
    while (paramj == null) {
      return;
    }
    paramj.setVisibility(8);
  }
  
  public void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
    kotlin.g.b.s.u(paramj, "holder");
  }
  
  public void a(j paramj, BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    kotlin.g.b.s.u(paramj, "holder");
    kotlin.g.b.s.u(paramBaseFinderFeed, "item");
    Object localObject2 = (ImageView)paramj.UH(e.e.finder_avatar);
    paramList = p.ExI;
    Object localObject1 = p.eCp();
    paramList = paramBaseFinderFeed.contact;
    Object localObject3;
    label174:
    label236:
    Object localObject4;
    label263:
    label299:
    label322:
    View localView;
    if (paramList == null)
    {
      paramList = null;
      paramList = new com.tencent.mm.plugin.finder.loader.b(Util.nullAsNil(paramList), v.FLG);
      kotlin.g.b.s.s(localObject2, "avatar");
      localObject3 = p.ExI;
      ((com.tencent.mm.loader.d)localObject1).a(paramList, (ImageView)localObject2, p.a(p.a.ExM));
      localObject1 = (TextView)paramj.UH(e.e.finder_nickname);
      ((TextView)localObject1).setText((CharSequence)paramBaseFinderFeed.feedObject.getNickNameSpan());
      aw.a((Paint)((TextView)localObject1).getPaint(), 0.8F);
      localObject3 = (TextView)paramj.UH(e.e.like_count_tv);
      if (paramBaseFinderFeed.feedObject.getLikeCount() <= 0) {
        break label868;
      }
      paramList = (CharSequence)r.ip(2, paramBaseFinderFeed.feedObject.getLikeCount());
      ((TextView)localObject3).setText(paramList);
      ((TextView)localObject3).setTextSize(1, 10.0F);
      paramList = (TextView)paramj.UH(e.e.finder_desc);
      if (Util.isNullOrNil(paramBaseFinderFeed.feedObject.getDescription())) {
        break label879;
      }
      paramList.setVisibility(0);
      paramList.setText((CharSequence)paramBaseFinderFeed.feedObject.getDescriptionSpan());
      if (!paramBaseFinderFeed.currentUsed) {
        break label899;
      }
      localObject3 = paramj.UH(e.e.finder_used_container);
      if (localObject3 != null) {
        ((View)localObject3).setVisibility(0);
      }
      if ((paramInt1 != 0) || (!paramBaseFinderFeed.isOriginFeed)) {
        break label923;
      }
      paramj.UH(e.e.line).setVisibility(0);
      ((TextView)paramj.UH(e.e.origin_feed)).setVisibility(0);
      localObject3 = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eYF().bmg()).intValue() != 1) {
        break label953;
      }
      paramInt1 = 1;
      if ((!(paramj.context instanceof FinderPoiFeedUI)) || (paramBaseFinderFeed.msgEventFriendLikeCount <= 0) || (paramInt1 == 0)) {
        break label958;
      }
      localObject3 = paramj.UH(e.e.line_two);
      if (localObject3 != null) {
        ((View)localObject3).setVisibility(0);
      }
      localObject3 = (TextView)paramj.UH(e.e.friends_like_count_tv);
      if (localObject3 != null)
      {
        ((TextView)localObject3).setVisibility(0);
        ((TextView)localObject3).setText((CharSequence)paramj.context.getResources().getString(e.h.finder_real_name_recommend_desc4, new Object[] { Integer.valueOf(paramBaseFinderFeed.msgEventFriendLikeCount) }));
      }
      label421:
      localObject3 = paramBaseFinderFeed.contact;
      if (localObject3 != null)
      {
        localObject4 = av.GiL;
        localObject4 = paramj.UH(e.e.auth_icon);
        kotlin.g.b.s.s(localObject4, "holder.getView<ImageView>(R.id.auth_icon)");
        av.a((ImageView)localObject4, ((m)localObject3).field_authInfo, 0, com.tencent.mm.plugin.finder.api.c.a((m)localObject3, false), 4);
      }
      ((ImageView)localObject2).setOnClickListener(new ac..ExternalSyntheticLambda2(this, paramj, paramBaseFinderFeed));
      ((TextView)localObject1).setOnClickListener(new ac..ExternalSyntheticLambda1(this, paramj, paramBaseFinderFeed));
      localObject2 = (FinderPostProgressView)paramj.UH(e.e.profile_upload_progress);
      localObject3 = paramj.UH(e.e.profile_upload_area);
      localObject4 = paramj.UH(e.e.profile_item_failed_area);
      localView = paramj.UH(e.e.finder_media_bottom);
      if (!paramBaseFinderFeed.feedObject.isPostFailed()) {
        break label1006;
      }
      ((View)localObject4).setVisibility(0);
      ((View)localObject3).setVisibility(8);
      localView.setVisibility(8);
      label574:
      localObject2 = (ImageView)paramj.UH(e.e.like_icon_iv);
      localObject3 = h.FNM;
      paramBaseFinderFeed = h.TA(paramBaseFinderFeed.feedObject.getFeedObject().objectType);
      if (paramBaseFinderFeed != null)
      {
        localObject3 = (CharSequence)paramBaseFinderFeed.ZZy;
        if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
          break label1149;
        }
        paramInt1 = 1;
        label635:
        if (paramInt1 == 0) {
          break label1154;
        }
      }
      ((ImageView)localObject2).setImageDrawable(bb.m(paramj.context, e.g.icon_filled_awesome, paramj.context.getResources().getColor(e.b.White)));
      ((ImageView)localObject2).setEnabled(false);
    }
    for (;;)
    {
      if (dXH())
      {
        paramInt1 = paramj.context.getResources().getColor(e.b.finder_activity_covered_icon_cover);
        paramInt2 = paramj.context.getResources().getColor(e.b.finder_activity_covered_white);
        int i = paramj.context.getResources().getColor(e.b.finder_activity_item_covered_background);
        ((TextView)localObject1).setTextColor(paramInt1);
        paramList.setTextColor(paramInt1);
        paramBaseFinderFeed = (TextView)paramj.UH(e.e.finder_posting_text);
        if (paramBaseFinderFeed != null) {
          paramBaseFinderFeed.setTextColor(paramInt1);
        }
        paramBaseFinderFeed = (TextView)paramj.UH(e.e.finder_post_failed_text);
        if (paramBaseFinderFeed != null) {
          paramBaseFinderFeed.setTextColor(paramInt1);
        }
        paramBaseFinderFeed = paramj.UH(e.e.finder_media_bottom);
        if (paramBaseFinderFeed != null) {
          paramBaseFinderFeed.setBackgroundColor(i);
        }
        paramBaseFinderFeed = paramj.UH(e.e.profile_upload_area);
        if (paramBaseFinderFeed != null) {
          paramBaseFinderFeed.setBackgroundColor(i);
        }
        paramBaseFinderFeed = paramj.UH(e.e.profile_item_failed_area);
        if (paramBaseFinderFeed != null) {
          paramBaseFinderFeed.setBackgroundColor(i);
        }
        paramj.UH(e.e.profile_feed_icon_divider).setBackgroundColor(paramInt2);
        ((WeImageView)paramj.UH(e.e.profile_feed_icon_iv)).setIconColor(paramInt2);
      }
      return;
      paramList = paramList.amx();
      break;
      label868:
      paramList = (CharSequence)"0";
      break label174;
      label879:
      paramList.setVisibility(8);
      paramList.setText((CharSequence)"");
      break label236;
      label899:
      localObject3 = paramj.UH(e.e.finder_used_container);
      if (localObject3 == null) {
        break label263;
      }
      ((View)localObject3).setVisibility(8);
      break label263;
      label923:
      paramj.UH(e.e.line).setVisibility(8);
      ((TextView)paramj.UH(e.e.origin_feed)).setVisibility(8);
      break label299;
      label953:
      paramInt1 = 0;
      break label322;
      label958:
      localObject3 = paramj.UH(e.e.line_two);
      if (localObject3 != null) {
        ((View)localObject3).setVisibility(8);
      }
      localObject3 = (TextView)paramj.UH(e.e.friends_like_count_tv);
      if (localObject3 == null) {
        break label421;
      }
      ((TextView)localObject3).setVisibility(8);
      break label421;
      label1006:
      if (paramBaseFinderFeed.feedObject.isPostFinish())
      {
        ((View)localObject4).setVisibility(8);
        ((View)localObject3).setVisibility(8);
        localView.setVisibility(0);
        break label574;
      }
      ((View)localObject4).setVisibility(8);
      ((View)localObject3).setVisibility(0);
      localView.setVisibility(8);
      this.rtf = ValueAnimator.ofInt(new int[] { ((FinderPostProgressView)localObject2).getProgress(), paramBaseFinderFeed.feedObject.getPostInfo().aaPw });
      localObject3 = this.rtf;
      kotlin.g.b.s.checkNotNull(localObject3);
      ((ValueAnimator)localObject3).addUpdateListener(new ac..ExternalSyntheticLambda0((FinderPostProgressView)localObject2));
      localObject2 = this.rtf;
      kotlin.g.b.s.checkNotNull(localObject2);
      localObject2 = ((ValueAnimator)localObject2).setDuration(400L);
      if (localObject2 == null) {
        break label574;
      }
      ((ValueAnimator)localObject2).start();
      break label574;
      label1149:
      paramInt1 = 0;
      break label635;
      label1154:
      localObject3 = p.ExI;
      localObject3 = p.eCl();
      paramBaseFinderFeed = new com.tencent.mm.plugin.finder.loader.s(paramBaseFinderFeed.ZZy, v.FKY);
      kotlin.g.b.s.s(localObject2, "likeIv");
      localObject4 = p.ExI;
      ((com.tencent.mm.loader.d)localObject3).a(paramBaseFinderFeed, (ImageView)localObject2, p.a(p.a.ExJ));
      ((ImageView)localObject2).setColorFilter(com.tencent.mm.cd.a.w(paramj.context, e.b.White), PorterDuff.Mode.SRC_ATOP);
    }
  }
  
  public final boolean dXH()
  {
    Object localObject2 = null;
    Object localObject1 = this.AKz;
    if (localObject1 == null) {
      localObject1 = localObject2;
    }
    while (!Util.isNullOrNil((String)localObject1))
    {
      return true;
      Object localObject3 = ((bi.a)localObject1).hLt;
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject3 = ((bxv)localObject3).aagK;
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = ((awt)localObject3).coverImgUrl;
        }
      }
    }
    return false;
  }
  
  public final int getLayoutId()
  {
    return this.AKy;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedRoundCornerConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.ac
 * JD-Core Version:    0.7.0.1
 */