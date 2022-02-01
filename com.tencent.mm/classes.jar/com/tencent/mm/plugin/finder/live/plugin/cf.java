package com.tencent.mm.plugin.finder.live.plugin;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Message;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.k.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.view.FinderLiveInterceptTouchRelativeLayout;
import com.tencent.mm.protocal.protobuf.bke;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveTopCommentPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "GET_COMMENT", "", "INIT_VIEW", "IN_ANIM", "OUT_ANIM", "STAY_DURATION", "", "TAG", "", "contextTv", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getContextTv", "()Landroid/widget/TextView;", "contextTv$delegate", "Lkotlin/Lazy;", "contextTvSv", "Landroid/widget/ScrollView;", "getContextTvSv", "()Landroid/widget/ScrollView;", "contextTvSv$delegate", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handler$delegate", "inAnim", "Landroid/animation/ObjectAnimator;", "getInAnim", "()Landroid/animation/ObjectAnimator;", "inAnim$delegate", "nicknameTv", "getNicknameTv", "nicknameTv$delegate", "outAnim", "getOutAnim", "outAnim$delegate", "canClearScreen", "", "getRootMaxHeight", "initPosition", "", "aboveView", "Landroid/view/View;", "initTopComment", "msg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;", "isAssistant", "badgeInfos", "", "Lcom/tencent/mm/protocal/protobuf/FinderLiveBadgeInfo;", "onClearForSideBar", "clear", "unMount", "updateMessages", "msgList", "", "visibleInCurrentLiveMode", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class cf
  extends b
{
  private final j DkO;
  private final j DkP;
  private final j DkQ;
  private final int DkR;
  private final int DkS;
  private final int DkT;
  private final int DkU;
  private final long DkV;
  private final j DkW;
  private final j DkX;
  private final String TAG;
  private final com.tencent.mm.live.b.b nfT;
  private final j rdm;
  
  public cf(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(354263);
    this.nfT = paramb;
    this.TAG = "FinderLiveTopCommentPlugin";
    this.DkO = k.cm((kotlin.g.a.a)new f(paramViewGroup));
    this.DkP = k.cm((kotlin.g.a.a)new a(paramViewGroup));
    this.DkQ = k.cm((kotlin.g.a.a)new b(paramViewGroup));
    this.DkR = 1;
    this.DkS = 2;
    this.DkT = 3;
    this.DkU = 4;
    this.DkV = (((com.tencent.mm.plugin.zero.b.a)h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getInt("FinderLiveTopCommentDisplayTimeSec", 10) * 1000L);
    if (!isLandscape())
    {
      int i = paramViewGroup.getContext().getResources().getDimensionPixelSize(p.c.Edge_8A);
      paramViewGroup.setPadding(i, paramViewGroup.getPaddingTop(), i, paramViewGroup.getPaddingBottom());
    }
    Log.i(this.TAG, s.X("STAY_DURATION:", Long.valueOf(this.DkV)));
    ((FinderLiveInterceptTouchRelativeLayout)paramViewGroup.findViewById(p.e.BTn)).setInterceptTouch(true);
    this.rdm = k.cm((kotlin.g.a.a)new c(this));
    this.DkW = k.cm((kotlin.g.a.a)new d(paramViewGroup, this));
    this.DkX = k.cm((kotlin.g.a.a)new g(paramViewGroup, this));
    AppMethodBeat.o(354263);
  }
  
  private final MMHandler getHandler()
  {
    AppMethodBeat.i(354270);
    MMHandler localMMHandler = (MMHandler)this.rdm.getValue();
    AppMethodBeat.o(354270);
    return localMMHandler;
  }
  
  private static final String rH(boolean paramBoolean)
  {
    AppMethodBeat.i(354275);
    if (paramBoolean)
    {
      str = MMApplicationContext.getContext().getResources().getString(p.h.Cix);
      s.s(str, "{\n                MMAppl…_assistant)\n            }");
      AppMethodBeat.o(354275);
      return str;
    }
    String str = MMApplicationContext.getContext().getResources().getString(p.h.Cir);
    s.s(str, "{\n                MMAppl…or_tag_txt)\n            }");
    AppMethodBeat.o(354275);
    return str;
  }
  
  public final boolean eoI()
  {
    return false;
  }
  
  public final boolean eoJ()
  {
    return true;
  }
  
  public final void gF(List<bke> paramList)
  {
    AppMethodBeat.i(354447);
    s.u(paramList, "msgList");
    Message localMessage = getHandler().obtainMessage();
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll((Collection)paramList);
    paramList = ah.aiuX;
    localMessage.obj = localArrayList;
    localMessage.what = this.DkU;
    getHandler().sendMessage(localMessage);
    AppMethodBeat.o(354447);
  }
  
  public final void gc(View paramView)
  {
    AppMethodBeat.i(354432);
    s.u(paramView, "aboveView");
    int j = paramView.getBottom();
    int i;
    if (isLandscape()) {
      i = 0;
    }
    while ((this.mJe.getLayoutParams() instanceof RelativeLayout.LayoutParams))
    {
      paramView = this.mJe.getLayoutParams();
      if (paramView == null)
      {
        paramView = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        AppMethodBeat.o(354432);
        throw paramView;
        i = paramView.getContext().getResources().getDimensionPixelOffset(p.c.Edge_2A);
      }
      else
      {
        paramView = (RelativeLayout.LayoutParams)paramView;
        paramView.setMargins(paramView.leftMargin, j + i, paramView.rightMargin, paramView.bottomMargin);
        this.mJe.setLayoutParams((ViewGroup.LayoutParams)paramView);
      }
    }
    AppMethodBeat.o(354432);
  }
  
  public final void qU(boolean paramBoolean)
  {
    AppMethodBeat.i(354471);
    if (paramBoolean)
    {
      this.mJe.setVisibility(8);
      AppMethodBeat.o(354471);
      return;
    }
    tO(this.CTl);
    AppMethodBeat.o(354471);
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(354452);
    super.unMount();
    getHandler().removeMessages(this.DkR);
    getHandler().removeMessages(this.DkS);
    getHandler().removeMessages(this.DkT);
    AppMethodBeat.o(354452);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<TextView>
  {
    a(ViewGroup paramViewGroup)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ScrollView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ScrollView>
  {
    b(ViewGroup paramViewGroup)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MMHandler;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<MMHandler>
  {
    c(cf paramcf)
    {
      super();
    }
    
    private static final boolean a(cf paramcf, Message paramMessage)
    {
      AppMethodBeat.i(355602);
      s.u(paramcf, "this$0");
      s.u(paramMessage, "msg");
      Object localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      com.tencent.mm.plugin.finder.live.utils.a.hQ(cf.h(paramcf), s.X("msg.what:", Integer.valueOf(paramMessage.what)));
      int i = paramMessage.what;
      if (i == cf.i(paramcf))
      {
        paramMessage = paramMessage.obj;
        if (paramMessage == null)
        {
          paramcf = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLiveMsg");
          AppMethodBeat.o(355602);
          throw paramcf;
        }
        cf.a(paramcf, (bke)paramMessage);
      }
      label289:
      for (;;)
      {
        AppMethodBeat.o(355602);
        return true;
        if (i == cf.e(paramcf))
        {
          d.uiThread((kotlin.g.a.a)new b(paramcf));
        }
        else if (i == cf.d(paramcf))
        {
          d.uiThread((kotlin.g.a.a)new c(paramcf));
        }
        else if (i == cf.l(paramcf))
        {
          paramMessage = paramMessage.obj;
          if (paramMessage == null)
          {
            paramcf = new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<com.tencent.mm.protocal.protobuf.FinderLiveMsg>{ kotlin.collections.TypeAliasesKt.ArrayList<com.tencent.mm.protocal.protobuf.FinderLiveMsg> }");
            AppMethodBeat.o(355602);
            throw paramcf;
          }
          paramMessage = (ArrayList)paramMessage;
          if (!((Collection)paramMessage).isEmpty())
          {
            i = 1;
            label197:
            if (i == 0) {
              break label245;
            }
            label201:
            if (paramMessage != null) {
              break label250;
            }
            paramMessage = null;
          }
          for (;;)
          {
            if (paramMessage == null) {
              break label289;
            }
            localObject = cf.c(paramcf).obtainMessage(cf.i(paramcf));
            ((Message)localObject).obj = paramMessage;
            cf.c(paramcf).sendMessage((Message)localObject);
            break;
            i = 0;
            break label197;
            label245:
            paramMessage = null;
            break label201;
            label250:
            paramMessage = kotlin.a.p.a((Iterable)paramMessage, (Comparator)new a());
            if (paramMessage == null) {
              paramMessage = null;
            } else {
              paramMessage = (bke)paramMessage.get(0);
            }
          }
        }
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k=3, mv={1, 5, 1})
    public static final class a<T>
      implements Comparator
    {
      public final int compare(T paramT1, T paramT2)
      {
        AppMethodBeat.i(353358);
        int i = kotlin.b.a.b((Comparable)Long.valueOf(((bke)paramT2).seq), (Comparable)Long.valueOf(((bke)paramT1).seq));
        AppMethodBeat.o(353358);
        return i;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements kotlin.g.a.a<ah>
    {
      b(cf paramcf)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class c
      extends u
      implements kotlin.g.a.a<ah>
    {
      c(cf paramcf)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/animation/ObjectAnimator;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ObjectAnimator>
  {
    d(ViewGroup paramViewGroup, cf paramcf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(cf paramcf, bke parambke, boolean paramBoolean)
    {
      super();
    }
    
    private static final void b(cf paramcf, bke parambke)
    {
      AppMethodBeat.i(355689);
      s.u(paramcf, "this$0");
      s.u(parambke, "$msg");
      int j = cf.b(paramcf).getWidth();
      StaticLayout localStaticLayout = new StaticLayout((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b(paramcf.mJe.getContext(), (CharSequence)parambke.content), cf.b(paramcf).getPaint(), j, Layout.Alignment.ALIGN_NORMAL, cf.b(paramcf).getLineSpacingMultiplier(), cf.b(paramcf).getLineSpacingExtra(), true);
      int k = paramcf.mJe.getHeight() - cf.f(paramcf).getHeight();
      int m = cf.g(paramcf) - k;
      int n;
      if (localStaticLayout.getHeight() > m)
      {
        cf.b(paramcf).setTextSize(0, com.tencent.mm.cd.a.br(paramcf.mJe.getContext(), p.c.BodyTextSize));
        n = (int)(new StaticLayout((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b(paramcf.mJe.getContext(), (CharSequence)parambke.content), cf.b(paramcf).getPaint(), j, Layout.Alignment.ALIGN_NORMAL, cf.b(paramcf).getLineSpacingMultiplier(), cf.b(paramcf).getLineSpacingExtra(), true).getHeight() / localStaticLayout.getLineCount() * 2 * 1.2F);
        parambke = paramcf.mJe.getLayoutParams();
        if (n <= m) {
          break label325;
        }
      }
      label325:
      for (int i = n + k;; i = m + k)
      {
        parambke.height = i;
        Log.v(cf.h(paramcf), "topComment width:" + j + " restHeight:" + k + " contextTvSv.height:" + cf.f(paramcf).getHeight() + " atLeastTwoLinesHeight:" + n + "  maxContentHeight:" + m);
        cf.b(paramcf).post(new cf.e..ExternalSyntheticLambda0(paramcf));
        AppMethodBeat.o(355689);
        return;
      }
    }
    
    private static final void n(cf paramcf)
    {
      AppMethodBeat.i(355672);
      s.u(paramcf, "this$0");
      if (paramcf.mJe.getVisibility() == 0) {
        paramcf.tO(8);
      }
      cf.c(paramcf).removeMessages(cf.d(paramcf));
      cf.c(paramcf).sendEmptyMessage(cf.e(paramcf));
      AppMethodBeat.o(355672);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<TextView>
  {
    f(ViewGroup paramViewGroup)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/animation/ObjectAnimator;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<ObjectAnimator>
  {
    g(ViewGroup paramViewGroup, cf paramcf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.cf
 * JD-Core Version:    0.7.0.1
 */