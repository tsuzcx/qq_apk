package com.tencent.mm.plugin.finder.live.view.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Vibrator;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.LeadingMarginSpan.Standard;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.f.e;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.protocal.protobuf.auy;
import com.tencent.mm.protocal.protobuf.awq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.at;
import com.tencent.mm.view.HardTouchableLayout.b;
import com.tencent.mm.view.HardTouchableLayout.c;
import com.tencent.mm.view.HardTouchableLayout.d;
import com.tencent.mm.view.HardTouchableLayout.g;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.util.ArrayList;
import java.util.List;
import kotlin.a.j;
import kotlin.f;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z.f;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveCommentAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveCommentAdapter$LiveCommentItemHolder;", "roomData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;)V", "GIFT_ICON_SIZE", "", "getGIFT_ICON_SIZE", "()I", "GIFT_ICON_SIZE$delegate", "Lkotlin/Lazy;", "TAG", "", "TEXT_PADDING_LEFT", "getTEXT_PADDING_LEFT", "TEXT_PADDING_LEFT$delegate", "annoucement", "getAnnoucement", "()Ljava/lang/String;", "annoucement$delegate", "commentList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveMsg;", "Lkotlin/collections/ArrayList;", "getCommentList", "()Ljava/util/ArrayList;", "contentFontSize", "giftStr", "getGiftStr", "giftStr$delegate", "onItemClickListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "msg", "Landroid/view/View;", "view", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "onItemDoubleClickListener", "Lkotlin/Function1;", "getOnItemDoubleClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnItemDoubleClickListener", "(Lkotlin/jvm/functions/Function1;)V", "onItemLongClickListener", "comment", "getOnItemLongClickListener", "setOnItemLongClickListener", "rankNoticeImageSpan", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveRoundImageSpan;", "getRankNoticeImageSpan", "()Lcom/tencent/mm/plugin/finder/live/model/FinderLiveRoundImageSpan;", "rankNoticeImageSpan$delegate", "rewardImageSpan", "getRewardImageSpan", "rewardImageSpan$delegate", "getRoomData", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "setRoomData", "sysAnnoucementImageSpan", "getSysAnnoucementImageSpan", "sysAnnoucementImageSpan$delegate", "userNameSpan", "Landroid/text/style/ForegroundColorSpan;", "vibrator", "Landroid/os/Vibrator;", "getVibrator", "()Landroid/os/Vibrator;", "vibrator$delegate", "welcomeImageSpan", "getWelcomeImageSpan", "welcomeImageSpan$delegate", "welcomeTag", "getWelcomeTag", "welcomeTag$delegate", "appendComment", "getItemCount", "onBindAtMsg", "context", "Landroid/content/Context;", "holder", "commentData", "onBindComboLiveRewardMsg", "payloadContent", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsgComboLiveRewardInfo;", "onBindRewardRankNoticeMsg", "onBindSysMsg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;", "onBindTextMsg", "onBindTickleMsg", "onBindViewHolder", "position", "onBindVisistorJoinLive", "onBindWelcomeMsg", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "type", "removeComment", "updateComments", "", "LiveCommentItemHolder", "LiveHeightSpan", "plugin-finder_release"})
public final class c
  extends RecyclerView.a<b>
{
  private final String TAG;
  public final ArrayList<com.tencent.mm.plugin.finder.live.model.t> hXy;
  private final f uAd;
  private final f uAe;
  private final int uAf;
  private final ForegroundColorSpan uAg;
  private final f uAh;
  kotlin.g.a.m<? super com.tencent.mm.plugin.finder.live.model.t, ? super String, x> uAi;
  public kotlin.g.a.m<? super com.tencent.mm.plugin.finder.live.model.t, ? super View, x> uAj;
  public b<? super com.tencent.mm.plugin.finder.live.model.t, x> uAk;
  private final f uAl;
  private final f uAm;
  private final f uAn;
  private final f uAo;
  private final f uAp;
  private final f uAq;
  private final f uAr;
  private com.tencent.mm.plugin.finder.live.viewmodel.g uAs;
  
  public c(com.tencent.mm.plugin.finder.live.viewmodel.g paramg)
  {
    AppMethodBeat.i(247770);
    this.uAs = paramg;
    this.TAG = "Finder.FinderLiveCommentAdapter";
    this.uAd = kotlin.g.ah((a)c.uAv);
    this.uAe = kotlin.g.ah((a)a.uAt);
    this.hXy = new ArrayList();
    paramg = MMApplicationContext.getContext();
    p.g(paramg, "MMApplicationContext.getContext()");
    this.uAg = new ForegroundColorSpan(paramg.getResources().getColor(2131100585));
    this.uAh = kotlin.g.ah((a)q.uAI);
    paramg = com.tencent.mm.plugin.finder.utils.m.vVH;
    if (com.tencent.mm.plugin.finder.utils.m.dBP()) {}
    for (int i = 17;; i = 15)
    {
      this.uAf = i;
      this.uAl = kotlin.g.ah((a)d.uAw);
      this.uAm = kotlin.g.ah((a)new p(this));
      this.uAn = kotlin.g.ah((a)s.uAJ);
      this.uAo = kotlin.g.ah((a)new r(this));
      this.uAp = kotlin.g.ah((a)e.uAx);
      this.uAq = kotlin.g.ah((a)new o(this));
      this.uAr = kotlin.g.ah((a)new n(this));
      AppMethodBeat.o(247770);
      return;
    }
  }
  
  private final void a(Context paramContext, b paramb, final awq paramawq)
  {
    AppMethodBeat.i(247763);
    paramawq = new com.tencent.mm.pluginsdk.ui.span.m(com.tencent.mm.pluginsdk.ui.span.l.c(paramContext, (CharSequence)paramContext.getString(2131759879, new Object[] { paramawq.content })));
    paramawq.a((com.tencent.mm.plugin.finder.live.model.m)this.uAm.getValue(), (CharSequence)diG(), 0);
    final z.f localf = new z.f();
    ViewParent localViewParent = paramb.uAu.getParent();
    if (localViewParent == null)
    {
      paramContext = new kotlin.t("null cannot be cast to non-null type android.widget.RelativeLayout");
      AppMethodBeat.o(247763);
      throw paramContext;
    }
    localf.SYG = ((RelativeLayout)localViewParent);
    paramb.uAu.aw((CharSequence)paramawq);
    paramb.uAu.setTextSize(this.uAf);
    paramb.uAu.post((Runnable)new g(paramb, localf, paramawq));
    paramb.cBH.setBackground(paramContext.getResources().getDrawable(2131232593));
    AppMethodBeat.o(247763);
  }
  
  private int diE()
  {
    AppMethodBeat.i(247760);
    int i = ((Number)this.uAd.getValue()).intValue();
    AppMethodBeat.o(247760);
    return i;
  }
  
  private com.tencent.mm.plugin.finder.live.model.m diI()
  {
    AppMethodBeat.i(247765);
    com.tencent.mm.plugin.finder.live.model.m localm = (com.tencent.mm.plugin.finder.live.model.m)this.uAo.getValue();
    AppMethodBeat.o(247765);
    return localm;
  }
  
  public final int diF()
  {
    AppMethodBeat.i(247761);
    int i = ((Number)this.uAe.getValue()).intValue();
    AppMethodBeat.o(247761);
    return i;
  }
  
  public final String diG()
  {
    AppMethodBeat.i(247762);
    String str = (String)this.uAl.getValue();
    AppMethodBeat.o(247762);
    return str;
  }
  
  public final String diH()
  {
    AppMethodBeat.i(247764);
    String str = (String)this.uAn.getValue();
    AppMethodBeat.o(247764);
    return str;
  }
  
  public final String diJ()
  {
    AppMethodBeat.i(247766);
    String str = (String)this.uAp.getValue();
    AppMethodBeat.o(247766);
    return str;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(247768);
    int i = this.hXy.size();
    AppMethodBeat.o(247768);
    return i;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<Integer>
  {
    public static final a uAt;
    
    static
    {
      AppMethodBeat.i(247735);
      uAt = new a();
      AppMethodBeat.o(247735);
    }
    
    a()
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveCommentAdapter$LiveCommentItemHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "bgView", "getBgView", "()Landroid/view/View;", "contentTv", "Lcom/tencent/neattextview/textview/view/NeatTextView;", "getContentTv", "()Lcom/tencent/neattextview/textview/view/NeatTextView;", "plugin-finder_release"})
  public static final class b
    extends RecyclerView.v
  {
    final View cBH;
    final NeatTextView uAu;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(247736);
      View localView = paramView.findViewById(2131303363);
      p.g(localView, "itemView.findViewById(R.…_comment_item_content_tv)");
      this.uAu = ((NeatTextView)localView);
      paramView = paramView.findViewById(2131303360);
      p.g(paramView, "itemView.findViewById(R.id.live_comment_container)");
      this.cBH = paramView;
      AppMethodBeat.o(247736);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements a<Integer>
  {
    public static final c uAv;
    
    static
    {
      AppMethodBeat.i(247738);
      uAv = new c();
      AppMethodBeat.o(247738);
    }
    
    c()
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements a<String>
  {
    public static final d uAw;
    
    static
    {
      AppMethodBeat.i(247740);
      uAw = new d();
      AppMethodBeat.o(247740);
    }
    
    d()
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements a<String>
  {
    public static final e uAx;
    
    static
    {
      AppMethodBeat.i(247742);
      uAx = new e();
      AppMethodBeat.o(247742);
    }
    
    e()
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "onImageLoadComplete", "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveCommentAdapter$onBindComboLiveRewardMsg$1$1"})
  static final class f<T, R>
    implements e<o, Bitmap>
  {
    f(c paramc, String paramString, c.b paramb, auy paramauy, Context paramContext, z.f paramf1, z.f paramf2, com.tencent.mm.pluginsdk.ui.span.m paramm) {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(c.b paramb, z.f paramf, com.tencent.mm.pluginsdk.ui.span.m paramm) {}
    
    public final void run()
    {
      AppMethodBeat.i(247745);
      if (this.uAG.uAu.getLineCount() > 1)
      {
        ((RelativeLayout)localf.SYG).setPadding(0, ((RelativeLayout)localf.SYG).getPaddingTop(), 0, ((RelativeLayout)localf.SYG).getPaddingBottom());
        this.uAG.uAu.setSpacingAdd(5);
        SpannableStringBuilder localSpannableStringBuilder = SpannableStringBuilder.valueOf((CharSequence)paramawq);
        localSpannableStringBuilder.setSpan(new LeadingMarginSpan.Standard(0, at.fromDPToPix(MMApplicationContext.getContext(), 6)), 0, paramawq.length(), 33);
        this.uAG.uAu.aw((CharSequence)localSpannableStringBuilder);
        AppMethodBeat.o(247745);
        return;
      }
      ((RelativeLayout)localf.SYG).setPadding(0, ((RelativeLayout)localf.SYG).getPaddingTop(), ((RelativeLayout)localf.SYG).getPaddingRight(), ((RelativeLayout)localf.SYG).getPaddingBottom());
      AppMethodBeat.o(247745);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(c.b paramb, z.f paramf, com.tencent.mm.pluginsdk.ui.span.m paramm) {}
    
    public final void run()
    {
      AppMethodBeat.i(247746);
      if (this.uAG.uAu.getLineCount() > 1)
      {
        Object localObject = this.uAG.uAu.getParent();
        if (localObject == null)
        {
          localObject = new kotlin.t("null cannot be cast to non-null type android.widget.RelativeLayout");
          AppMethodBeat.o(247746);
          throw ((Throwable)localObject);
        }
        ((RelativeLayout)localObject).setPadding(0, ((RelativeLayout)this.uoL.SYG).getPaddingTop(), 0, ((RelativeLayout)this.uoL.SYG).getPaddingBottom());
        this.uAG.uAu.setSpacingAdd(5);
        localObject = SpannableStringBuilder.valueOf((CharSequence)this.uoM);
        ((SpannableStringBuilder)localObject).setSpan(new LeadingMarginSpan.Standard(0, at.fromDPToPix(MMApplicationContext.getContext(), 11)), 0, this.uoM.length(), 33);
        this.uAG.uAu.aw((CharSequence)localObject);
      }
      AppMethodBeat.o(247746);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveCommentAdapter$onBindViewHolder$1", "Lcom/tencent/mm/view/HardTouchableLayout$OnSingleClickListener;", "onSingleClick", "", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "plugin-finder_release"})
  public static final class i
    implements HardTouchableLayout.g
  {
    i(com.tencent.mm.plugin.finder.live.model.t paramt, int paramInt, c.b paramb) {}
    
    public final void b(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(247747);
      p.h(paramView, "view");
      if (this.uAH != null)
      {
        Log.i(c.a(this.uAy), "topComment,content:" + this.uAH.getContent() + ",position:" + this.gUj);
        paramView = this.uAy.uAj;
        if (paramView != null)
        {
          paramMotionEvent = this.uAH;
          View localView = this.uAG.aus;
          p.g(localView, "holder.itemView");
          paramView.invoke(paramMotionEvent, localView);
          AppMethodBeat.o(247747);
          return;
        }
        AppMethodBeat.o(247747);
        return;
      }
      Log.w(c.a(this.uAy), "OnClick IndexOutOfBounds! position:" + this.gUj + " commentList.size:" + this.uAy.hXy.size() + " view:" + paramView);
      AppMethodBeat.o(247747);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveCommentAdapter$onBindViewHolder$2", "Lcom/tencent/mm/view/HardTouchableLayout$OnLongClickListener;", "onLongClick", "", "view", "Landroid/view/View;", "plugin-finder_release"})
  public static final class j
    implements HardTouchableLayout.d
  {
    j(c.b paramb, com.tencent.mm.plugin.finder.live.model.t paramt, int paramInt) {}
    
    public final void ea(View paramView)
    {
      AppMethodBeat.i(247748);
      p.h(paramView, "view");
      String str = this.uAG.uAu.hiT().toString();
      if (this.uAH != null)
      {
        paramView = this.uAy.uAi;
        if (paramView != null)
        {
          paramView.invoke(this.uAH, str);
          AppMethodBeat.o(247748);
          return;
        }
        AppMethodBeat.o(247748);
        return;
      }
      Log.w(c.a(this.uAy), "OnLongClick IndexOutOfBounds! position:" + this.gUj + " commentList.size:" + this.uAy.hXy.size() + " view:" + paramView);
      AppMethodBeat.o(247748);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveCommentAdapter$onBindViewHolder$3", "Lcom/tencent/mm/view/HardTouchableLayout$OnDoubleClickListener;", "onDoubleClick", "", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "plugin-finder_release"})
  public static final class k
    implements HardTouchableLayout.b
  {
    k(int paramInt) {}
    
    public final void a(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(247749);
      p.h(paramView, "view");
      p.h(paramMotionEvent, "e");
      paramMotionEvent = (com.tencent.mm.plugin.finder.live.model.t)j.L((List)this.uAy.hXy, this.gUj);
      if (paramMotionEvent != null)
      {
        paramView = this.uAy.uAk;
        if (paramView != null)
        {
          paramView.invoke(paramMotionEvent);
          AppMethodBeat.o(247749);
          return;
        }
        AppMethodBeat.o(247749);
        return;
      }
      Log.w(c.a(this.uAy), "onDoubleClick IndexOutOfBounds! position:" + this.gUj + " commentList.size:" + this.uAy.hXy.size() + " view:" + paramView);
      AppMethodBeat.o(247749);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class l
    implements Runnable
  {
    l(c.b paramb, z.f paramf, com.tencent.mm.pluginsdk.ui.span.m paramm) {}
    
    public final void run()
    {
      AppMethodBeat.i(247750);
      if (this.uAG.uAu.getLineCount() > 1)
      {
        ((RelativeLayout)this.uoL.SYG).setPadding(0, ((RelativeLayout)this.uoL.SYG).getPaddingTop(), 0, ((RelativeLayout)this.uoL.SYG).getPaddingBottom());
        this.uAG.uAu.setSpacingAdd(5);
        SpannableStringBuilder localSpannableStringBuilder = SpannableStringBuilder.valueOf((CharSequence)this.uoM);
        localSpannableStringBuilder.setSpan(new LeadingMarginSpan.Standard(0, at.fromDPToPix(MMApplicationContext.getContext(), 11)), 0, this.uoM.length(), 33);
        this.uAG.uAu.aw((CharSequence)localSpannableStringBuilder);
        AppMethodBeat.o(247750);
        return;
      }
      ((RelativeLayout)this.uoL.SYG).setPadding(0, ((RelativeLayout)this.uoL.SYG).getPaddingTop(), ((RelativeLayout)this.uoL.SYG).getPaddingRight(), ((RelativeLayout)this.uoL.SYG).getPaddingBottom());
      AppMethodBeat.o(247750);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveCommentAdapter$onCreateViewHolder$1", "Lcom/tencent/mm/view/HardTouchableLayout$OnInterceptTouchEventCallback;", "isIntercept", "", "event", "Landroid/view/MotionEvent;", "plugin-finder_release"})
  public static final class m
    implements HardTouchableLayout.c
  {
    public final boolean S(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(247751);
      p.h(paramMotionEvent, "event");
      AppMethodBeat.o(247751);
      return false;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveRoundImageSpan;", "invoke"})
  static final class n
    extends q
    implements a<com.tencent.mm.plugin.finder.live.model.m>
  {
    n(c paramc)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveRoundImageSpan;", "invoke"})
  static final class o
    extends q
    implements a<com.tencent.mm.plugin.finder.live.model.m>
  {
    o(c paramc)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveRoundImageSpan;", "invoke"})
  static final class p
    extends q
    implements a<com.tencent.mm.plugin.finder.live.model.m>
  {
    p(c paramc)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/os/Vibrator;", "invoke"})
  static final class q
    extends q
    implements a<Vibrator>
  {
    public static final q uAI;
    
    static
    {
      AppMethodBeat.i(247756);
      uAI = new q();
      AppMethodBeat.o(247756);
    }
    
    q()
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveRoundImageSpan;", "invoke"})
  static final class r
    extends q
    implements a<com.tencent.mm.plugin.finder.live.model.m>
  {
    r(c paramc)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class s
    extends q
    implements a<String>
  {
    public static final s uAJ;
    
    static
    {
      AppMethodBeat.i(247759);
      uAJ = new s();
      AppMethodBeat.o(247759);
    }
    
    s()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.c
 * JD-Core Version:    0.7.0.1
 */