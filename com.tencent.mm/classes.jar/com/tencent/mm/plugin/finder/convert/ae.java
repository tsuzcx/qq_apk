package com.tencent.mm.plugin.finder.convert;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.FinderPostProgressView;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.azs;
import com.tencent.mm.protocal.protobuf.azu;
import com.tencent.mm.protocal.protobuf.cjm;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ar;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import java.util.List;
import kotlin.g.b.z.f;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedRoundCornerConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "layoutResId", "", "(I)V", "isBlockActivity", "", "()Z", "progressAnimator", "Landroid/animation/ValueAnimator;", "getProgressAnimator", "()Landroid/animation/ValueAnimator;", "setProgressAnimator", "(Landroid/animation/ValueAnimator;)V", "bindTopPlace", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "feed", "getLayoutId", "jumpProfile", "context", "Landroid/content/Context;", "feedId", "", "username", "", "onBindViewHolder", "item", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
public abstract class ae
  extends e<BaseFinderFeed>
{
  private ValueAnimator luz;
  private final boolean tDA;
  private final int tDB;
  
  public ae(int paramInt)
  {
    this.tDB = paramInt;
    this.tDA = true;
  }
  
  protected static void a(Context paramContext, long paramLong, String paramString)
  {
    kotlin.g.b.p.h(paramContext, "context");
    kotlin.g.b.p.h(paramString, "username");
    Object localObject1 = new Intent();
    ((Intent)localObject1).putExtra("finder_username", paramString);
    Object localObject2 = FinderReporterUIC.wzC;
    FinderReporterUIC.a.a(paramContext, (Intent)localObject1, paramLong, 1, false, 64);
    localObject2 = com.tencent.mm.plugin.finder.utils.a.vUU;
    com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI(paramContext, (Intent)localObject1);
    localObject1 = FinderReporterUIC.wzC;
    paramContext = FinderReporterUIC.a.fH(paramContext);
    if (paramContext != null)
    {
      localObject1 = com.tencent.mm.plugin.finder.report.k.vfA;
      com.tencent.mm.plugin.finder.report.k.a(4, paramLong, paramContext.tCE, 1, paramString);
    }
  }
  
  public void a(RecyclerView paramRecyclerView, h paramh, int paramInt)
  {
    kotlin.g.b.p.h(paramRecyclerView, "recyclerView");
    kotlin.g.b.p.h(paramh, "holder");
  }
  
  public void a(final h paramh, final BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    kotlin.g.b.p.h(paramh, "holder");
    kotlin.g.b.p.h(paramBaseFinderFeed, "item");
    Object localObject2 = (ImageView)paramh.Mn(2131300773);
    paramList = m.uJa;
    Object localObject1 = m.dka();
    paramList = paramBaseFinderFeed.contact;
    Object localObject3;
    label182:
    label249:
    Object localObject4;
    label309:
    Object localObject5;
    if (paramList != null)
    {
      paramList = paramList.cXH();
      paramList = new com.tencent.mm.plugin.finder.loader.a(Util.nullAsNil(paramList));
      kotlin.g.b.p.g(localObject2, "avatar");
      localObject3 = m.uJa;
      ((d)localObject1).a(paramList, (ImageView)localObject2, m.a(m.a.uJe));
      localObject1 = (TextView)paramh.Mn(2131301380);
      kotlin.g.b.p.g(localObject1, "nickname");
      ((TextView)localObject1).setText((CharSequence)paramBaseFinderFeed.feedObject.getNickNameSpan());
      ao.a((Paint)((TextView)localObject1).getPaint(), 0.8F);
      localObject3 = (TextView)paramh.Mn(2131303177);
      kotlin.g.b.p.g(localObject3, "likeTv");
      if (paramBaseFinderFeed.feedObject.getLikeCount() <= 0) {
        break label825;
      }
      paramList = (CharSequence)com.tencent.mm.plugin.finder.utils.k.gm(2, paramBaseFinderFeed.feedObject.getLikeCount());
      ((TextView)localObject3).setText(paramList);
      ((TextView)localObject3).setTextSize(1, 10.0F);
      paramList = (TextView)paramh.Mn(2131300801);
      if (Util.isNullOrNil(paramBaseFinderFeed.feedObject.getDescription())) {
        break label836;
      }
      kotlin.g.b.p.g(paramList, "descTv");
      paramList.setVisibility(0);
      paramList.setText((CharSequence)paramBaseFinderFeed.feedObject.getDescriptionSpan());
      if ((paramInt1 != 0) || (!paramBaseFinderFeed.isOriginFeed)) {
        break label853;
      }
      localObject3 = paramh.Mn(2131303194);
      kotlin.g.b.p.g(localObject3, "holder.getView<View>(R.id.line)");
      ((View)localObject3).setVisibility(0);
      localObject3 = paramh.Mn(2131305697);
      kotlin.g.b.p.g(localObject3, "holder.getView<TextView>(R.id.origin_feed)");
      ((TextView)localObject3).setVisibility(0);
      localObject3 = paramBaseFinderFeed.contact;
      if (localObject3 != null)
      {
        localObject4 = y.vXH;
        localObject4 = paramh.Mn(2131297096);
        kotlin.g.b.p.g(localObject4, "holder.getView<ImageView>(R.id.auth_icon)");
        y.a((ImageView)localObject4, ((com.tencent.mm.plugin.finder.api.g)localObject3).field_authInfo);
      }
      ((ImageView)localObject2).setOnClickListener((View.OnClickListener)new a(this, paramh, paramBaseFinderFeed));
      ((TextView)localObject1).setOnClickListener((View.OnClickListener)new b(this, paramh, paramBaseFinderFeed));
      localObject2 = new z.f();
      ((z.f)localObject2).SYG = ((FinderPostProgressView)paramh.Mn(2131306271));
      localObject3 = paramh.Mn(2131306270);
      localObject4 = paramh.Mn(2131306206);
      localObject5 = paramh.Mn(2131301356);
      if (!paramBaseFinderFeed.feedObject.isPostFailed()) {
        break label907;
      }
      kotlin.g.b.p.g(localObject4, "failedArea");
      ((View)localObject4).setVisibility(0);
      kotlin.g.b.p.g(localObject3, "progressArea");
      ((View)localObject3).setVisibility(8);
      kotlin.g.b.p.g(localObject5, "normalView");
      ((View)localObject5).setVisibility(8);
      label496:
      localObject2 = (ImageView)paramh.Mn(2131303182);
      localObject3 = com.tencent.mm.plugin.finder.storage.logic.g.vGW;
      localObject3 = com.tencent.mm.plugin.finder.storage.logic.g.Lj(paramBaseFinderFeed.feedObject.getFeedObject().objectType);
      if (localObject3 != null)
      {
        localObject4 = (CharSequence)((azu)localObject3).LJF;
        if ((localObject4 != null) && (((CharSequence)localObject4).length() != 0)) {
          break label1113;
        }
        paramInt1 = 1;
        label560:
        if (paramInt1 == 0) {
          break label1118;
        }
      }
      localObject3 = paramh.getContext();
      localObject4 = paramh.getContext();
      kotlin.g.b.p.g(localObject4, "holder.context");
      ((ImageView)localObject2).setImageDrawable(ar.m((Context)localObject3, 2131690436, ((Context)localObject4).getResources().getColor(2131099844)));
      kotlin.g.b.p.g(localObject2, "likeIv");
      ((ImageView)localObject2).setEnabled(false);
      label622:
      if (!this.tDA)
      {
        paramBaseFinderFeed = paramBaseFinderFeed.feedObject.getFeedObject().objectDesc;
        if (paramBaseFinderFeed == null) {
          break label1194;
        }
        paramBaseFinderFeed = paramBaseFinderFeed.event;
        if (paramBaseFinderFeed == null) {
          break label1194;
        }
      }
    }
    label907:
    label1194:
    for (paramBaseFinderFeed = paramBaseFinderFeed.eventName;; paramBaseFinderFeed = null)
    {
      if (!Util.isNullOrNil(paramBaseFinderFeed))
      {
        paramBaseFinderFeed = paramh.getContext();
        kotlin.g.b.p.g(paramBaseFinderFeed, "holder.context");
        paramInt1 = paramBaseFinderFeed.getResources().getColor(2131100404);
        paramBaseFinderFeed = paramh.getContext();
        kotlin.g.b.p.g(paramBaseFinderFeed, "holder.context");
        paramInt2 = paramBaseFinderFeed.getResources().getColor(2131100403);
        ((TextView)localObject1).setTextColor(paramInt1);
        paramList.setTextColor(paramInt1);
        paramBaseFinderFeed = (TextView)paramh.Mn(2131301403);
        if (paramBaseFinderFeed != null) {
          paramBaseFinderFeed.setTextColor(paramInt1);
        }
        paramBaseFinderFeed = (TextView)paramh.Mn(2131301390);
        if (paramBaseFinderFeed != null) {
          paramBaseFinderFeed.setTextColor(paramInt1);
        }
        paramBaseFinderFeed = paramh.Mn(2131301356);
        if (paramBaseFinderFeed != null) {
          paramBaseFinderFeed.setBackgroundColor(paramInt2);
        }
        paramBaseFinderFeed = paramh.Mn(2131306270);
        if (paramBaseFinderFeed != null) {
          paramBaseFinderFeed.setBackgroundColor(paramInt2);
        }
        paramh = paramh.Mn(2131306206);
        if (paramh != null) {
          paramh.setBackgroundColor(paramInt2);
        }
      }
      return;
      paramList = null;
      break;
      label825:
      paramList = (CharSequence)"0";
      break label182;
      label836:
      kotlin.g.b.p.g(paramList, "descTv");
      paramList.setVisibility(8);
      break label249;
      label853:
      localObject3 = paramh.Mn(2131303194);
      kotlin.g.b.p.g(localObject3, "holder.getView<View>(R.id.line)");
      ((View)localObject3).setVisibility(8);
      localObject3 = paramh.Mn(2131305697);
      kotlin.g.b.p.g(localObject3, "holder.getView<TextView>(R.id.origin_feed)");
      ((TextView)localObject3).setVisibility(8);
      break label309;
      if (paramBaseFinderFeed.feedObject.isPostFinish())
      {
        kotlin.g.b.p.g(localObject4, "failedArea");
        ((View)localObject4).setVisibility(8);
        kotlin.g.b.p.g(localObject3, "progressArea");
        ((View)localObject3).setVisibility(8);
        kotlin.g.b.p.g(localObject5, "normalView");
        ((View)localObject5).setVisibility(0);
        break label496;
      }
      kotlin.g.b.p.g(localObject4, "failedArea");
      ((View)localObject4).setVisibility(8);
      kotlin.g.b.p.g(localObject3, "progressArea");
      ((View)localObject3).setVisibility(0);
      kotlin.g.b.p.g(localObject5, "normalView");
      ((View)localObject5).setVisibility(8);
      this.luz = ValueAnimator.ofInt(new int[] { ((FinderPostProgressView)((z.f)localObject2).SYG).getProgress(), paramBaseFinderFeed.feedObject.getPostInfo().Mpc });
      localObject3 = this.luz;
      if (localObject3 == null) {
        kotlin.g.b.p.hyc();
      }
      ((ValueAnimator)localObject3).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new c((z.f)localObject2));
      localObject2 = this.luz;
      if (localObject2 == null) {
        kotlin.g.b.p.hyc();
      }
      localObject2 = ((ValueAnimator)localObject2).setDuration(400L);
      if (localObject2 == null) {
        break label496;
      }
      ((ValueAnimator)localObject2).start();
      break label496;
      label1113:
      paramInt1 = 0;
      break label560;
      label1118:
      localObject4 = m.uJa;
      localObject4 = m.djY();
      localObject3 = new com.tencent.mm.plugin.finder.loader.p(((azu)localObject3).LJF, x.vEn);
      kotlin.g.b.p.g(localObject2, "likeIv");
      localObject5 = m.uJa;
      ((d)localObject4).a(localObject3, (ImageView)localObject2, m.a(m.a.uJb));
      ((ImageView)localObject2).setColorFilter(com.tencent.mm.cb.a.n(paramh.getContext(), 2131099844), PorterDuff.Mode.SRC_ATOP);
      break label622;
    }
  }
  
  public final int getLayoutId()
  {
    return this.tDB;
  }
  
  protected final void j(h paramh, BaseFinderFeed paramBaseFinderFeed)
  {
    kotlin.g.b.p.h(paramh, "holder");
    kotlin.g.b.p.h(paramBaseFinderFeed, "feed");
    paramh = (LinearLayout)paramh.Mn(2131301499);
    if (paramh != null) {
      paramh.setVisibility(8);
    }
    if (this.tDA) {}
    do
    {
      do
      {
        return;
        if (paramBaseFinderFeed.feedObject.getStickyTime() <= 0) {
          break;
        }
      } while (paramh == null);
      paramh.setVisibility(0);
      return;
    } while (paramh == null);
    paramh.setVisibility(8);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(ae paramae, h paramh, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(243084);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedRoundCornerConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = paramh.getContext();
      kotlin.g.b.p.g(paramView, "holder.context");
      ae.a(paramView, paramBaseFinderFeed.lT(), paramBaseFinderFeed.feedObject.getUserName());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedRoundCornerConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(243084);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(ae paramae, h paramh, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(243085);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedRoundCornerConvert$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = paramh.getContext();
      kotlin.g.b.p.g(paramView, "holder.context");
      ae.a(paramView, paramBaseFinderFeed.lT(), paramBaseFinderFeed.feedObject.getUserName());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedRoundCornerConvert$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(243085);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class c
    implements ValueAnimator.AnimatorUpdateListener
  {
    c(z.f paramf) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(243086);
      FinderPostProgressView localFinderPostProgressView = (FinderPostProgressView)this.tDD.SYG;
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(243086);
        throw paramValueAnimator;
      }
      localFinderPostProgressView.setProgress(((Integer)paramValueAnimator).intValue());
      ((FinderPostProgressView)this.tDD.SYG).invalidate();
      AppMethodBeat.o(243086);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.ae
 * JD-Core Version:    0.7.0.1
 */