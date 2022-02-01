package com.tencent.mm.plugin.finder.convert;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.feed.f;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.FinderCollapsibleTextView;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.pluginsdk.ui.span.h;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bfv;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.e.b;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.i;
import com.tencent.neattextview.textview.view.NeatTextView;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedCommentHeaderContent;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter;", "(Lcom/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter;)V", "lastReportTime", "", "getPresenter", "()Lcom/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter;", "checkPostOk", "", "item", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getLayoutId", "", "handleLinkTvOnClick", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "link", "", "handlePoiOnClick", "poiText", "isNewsObject", "isSelfScene", "context", "Landroid/content/Context;", "onBindViewHolder", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "refreshActivity", "refreshAvatar", "refreshCloseCommentTips", "refreshContentTime", "refreshDescContent", "refreshLink", "refreshLoadingLayout", "refreshNickName", "refreshPoi", "report21464", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "feed", "actionType", "Companion", "plugin-finder_release"})
public final class k
  extends e<com.tencent.mm.plugin.finder.model.t>
{
  public static final a xhq;
  private long lastReportTime;
  final f xhp;
  
  static
  {
    AppMethodBeat.i(267631);
    xhq = new a((byte)0);
    AppMethodBeat.o(267631);
  }
  
  public k(f paramf)
  {
    AppMethodBeat.i(267630);
    this.xhp = paramf;
    AppMethodBeat.o(267630);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public final void a(RecyclerView paramRecyclerView, i parami, int paramInt)
  {
    AppMethodBeat.i(267628);
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    paramRecyclerView = (FinderCollapsibleTextView)parami.RD(b.f.text_content);
    paramRecyclerView.getContentTextView().setOnTouchListener((View.OnTouchListener)new h(paramRecyclerView.getContentTextView(), (View.OnTouchListener)new o(parami.getContext())));
    NeatTextView localNeatTextView = paramRecyclerView.getContentTextView();
    parami = parami.getContext();
    p.j(parami, "holder.context");
    localNeatTextView.setTextColor(parami.getResources().getColor(b.c.BW_0_Alpha_0_9));
    paramRecyclerView.setLimitLine(10);
    AppMethodBeat.o(267628);
  }
  
  public final int getLayoutId()
  {
    return b.g._feed_comment_header_content_layout;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert$refreshActivity$1$1$1", "com/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert$$special$$inlined$apply$lambda$1"})
  static final class c
    implements View.OnClickListener
  {
    c(bfv parambfv1, i parami, com.tencent.mm.plugin.finder.model.t paramt, bfv parambfv2) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(273896);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert$refreshActivity$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      paramView = new Intent();
      paramView.putExtra("key_activity_id", this.xhs.xdR);
      paramView.putExtra("key_activity_name", this.xhs.eventName);
      paramView.putExtra("key_nick_name", this.xhs.SQA);
      paramView.putExtra("key_feed_ref_id", this.xht.xpY.getFeedObject().id);
      Log.i("Finder.FeedConvert", "eventTopicId :" + this.xhs.xdR + " eventName:" + this.xhs.eventName + " refId: " + this.xht.xpY.getFeedObject().id);
      localObject = com.tencent.mm.plugin.finder.utils.a.ACH;
      localObject = this.xhb.getContext();
      if (localObject == null)
      {
        paramView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(273896);
        throw paramView;
      }
      com.tencent.mm.plugin.finder.utils.a.aa((Context)localObject, paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert$refreshActivity$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(273896);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(com.tencent.mm.plugin.finder.model.t paramt, i parami) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(269836);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert$refreshAvatar$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      paramView = new Intent();
      paramView.putExtra("finder_username", this.xhv.xpY.getUserName());
      paramView.putExtra("finder_read_feed_id", this.xhv.xpY.getId());
      localObject = aj.Bnu;
      localObject = this.tDl.getContext();
      p.j(localObject, "holder.context");
      aj.a.a((Context)localObject, paramView, this.xhv.xpY.field_id, 1, false, 64);
      localObject = com.tencent.mm.plugin.finder.utils.a.ACH;
      localObject = this.tDl.getContext();
      p.j(localObject, "holder.context");
      com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI((Context)localObject, paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert$refreshAvatar$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(269836);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "isCollapse", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.b<Boolean, x>
  {
    f(k paramk, com.tencent.mm.plugin.finder.model.t paramt, i parami)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert$refreshLink$1$1"})
  static final class g
    implements Runnable
  {
    g(TextView paramTextView, String paramString, k paramk, i parami, View paramView, com.tencent.mm.plugin.finder.model.t paramt) {}
    
    public final void run()
    {
      AppMethodBeat.i(275172);
      Object localObject = this.xhA;
      p.j(localObject, "linkLayout");
      int i = ((View)localObject).getWidth();
      if (i > 0)
      {
        int j = com.tencent.mm.ci.a.fromDPToPix(this.xhb.getContext(), 20);
        localObject = this.xhy;
        p.j(localObject, "linkTv");
        if (((TextView)localObject).getPaint().measureText(this.xhz) + j > i)
        {
          localObject = this.xhy;
          p.j(localObject, "linkTv");
          CharSequence localCharSequence = (CharSequence)this.xhz;
          TextView localTextView = this.xhy;
          p.j(localTextView, "linkTv");
          ((TextView)localObject).setText(TextUtils.ellipsize(localCharSequence, localTextView.getPaint(), i - j, TextUtils.TruncateAt.END));
        }
      }
      AppMethodBeat.o(275172);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert$refreshLink$1$2", "Lcom/tencent/mm/view/ExposeElves$OnViewExposedListener;", "getExposedId", "", "view", "Landroid/view/View;", "onViewExposed", "", "oldExposedId", "newExposedId", "isExposed", "", "plugin-finder_release"})
  public static final class h
    extends e.b
  {
    h(bid parambid, k paramk, i parami, View paramView, com.tencent.mm.plugin.finder.model.t paramt) {}
    
    public final long er(View paramView)
    {
      AppMethodBeat.i(270719);
      p.k(paramView, "view");
      long l = this.xht.xpY.field_id;
      AppMethodBeat.o(270719);
      return l;
    }
    
    public final void p(View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(270717);
      p.k(paramView, "view");
      if (paramBoolean) {
        k.a(this.xhx, this.$contextObj, this.xht.xpY, 1L);
      }
      AppMethodBeat.o(270717);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert$refreshLink$1$3"})
  static final class i
    implements View.OnClickListener
  {
    i(String paramString, bid parambid, k paramk, i parami, View paramView, com.tencent.mm.plugin.finder.model.t paramt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(288917);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert$refreshLink$$inlined$let$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      k.a(this.xhb, this.xht.xpY, this.qQa);
      k.a(this.xhx, this.$contextObj, this.xht.xpY, 2L);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert$refreshLink$$inlined$let$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(288917);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class j
    implements Runnable
  {
    j(k paramk, i parami) {}
    
    public final void run()
    {
      AppMethodBeat.i(224377);
      Object localObject = this.xhx.xhp.xwG;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.finder.view.builder.b)localObject).getLoadingLayout();
        if (localObject != null)
        {
          int i = ((FrameLayout)localObject).getPaddingLeft();
          View localView = this.tDl.amk;
          p.j(localView, "holder.itemView");
          ((FrameLayout)localObject).setPadding(i, localView.getHeight(), ((FrameLayout)localObject).getPaddingRight(), ((FrameLayout)localObject).getPaddingBottom());
          AppMethodBeat.o(224377);
          return;
        }
      }
      AppMethodBeat.o(224377);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class k
    implements View.OnClickListener
  {
    k(i parami) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(229577);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert$refreshNickName$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = this.tDl.RD(b.f.avatar_iv);
      if (paramView != null) {
        paramView.callOnClick();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert$refreshNickName$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(229577);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert$refreshPoi$1$1"})
  static final class l
    implements Runnable
  {
    l(View paramView, TextView paramTextView, String paramString, k paramk, i parami, com.tencent.mm.plugin.finder.model.t paramt) {}
    
    public final void run()
    {
      AppMethodBeat.i(256991);
      Object localObject = this.xhB;
      p.j(localObject, "positionLayout");
      int i = ((View)localObject).getWidth();
      if (i > 0)
      {
        int j = com.tencent.mm.ci.a.fromDPToPix(this.xhb.getContext(), 20);
        localObject = this.xhC;
        p.j(localObject, "poiTv");
        if (((TextView)localObject).getPaint().measureText(this.xhD) + j > i)
        {
          localObject = this.xhC;
          p.j(localObject, "poiTv");
          CharSequence localCharSequence = (CharSequence)this.xhD;
          TextView localTextView = this.xhC;
          p.j(localTextView, "poiTv");
          ((TextView)localObject).setText(TextUtils.ellipsize(localCharSequence, localTextView.getPaint(), i - j, TextUtils.TruncateAt.END));
        }
      }
      AppMethodBeat.o(256991);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert$refreshPoi$1$2"})
  static final class m
    implements View.OnClickListener
  {
    m(String paramString, k paramk, i parami, com.tencent.mm.plugin.finder.model.t paramt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(278404);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert$refreshPoi$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      k.b(this.xhb, this.xht.xpY, this.xhD);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert$refreshPoi$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(278404);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.k
 * JD-Core Version:    0.7.0.1
 */