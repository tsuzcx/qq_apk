package com.tencent.mm.plugin.finder.live.b;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.af;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.plugin.cy;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.am;
import kotlin.g.b.u;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/comment/BoxCommentViewCallback;", "", "plugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveBoxCommentPlugin;", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveBoxCommentPlugin;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "newTipGroup", "Landroid/view/ViewGroup;", "getNewTipGroup", "()Landroid/view/ViewGroup;", "newTipGroup$delegate", "Lkotlin/Lazy;", "newTipTv", "Landroid/widget/TextView;", "getNewTipTv", "()Landroid/widget/TextView;", "newTipTv$delegate", "getPlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveBoxCommentPlugin;", "business", "T", "Landroidx/lifecycle/ViewModel;", "bu", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "hideNewCommentTip", "", "showNewCommentTip", "count", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  private final String TAG;
  final cy Zut;
  private final j ZvL;
  private final j Zvm;
  
  public e(cy paramcy)
  {
    AppMethodBeat.i(370933);
    this.Zut = paramcy;
    this.TAG = "BoxCommentViewCallback";
    this.Zvm = kotlin.k.cm((kotlin.g.a.a)new a(this));
    this.ZvL = kotlin.k.cm((kotlin.g.a.a)new b(this));
    ivr().setOnClickListener(new e..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(370933);
  }
  
  private static final void a(e parame, View paramView)
  {
    AppMethodBeat.i(370966);
    localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parame);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/comment/BoxCommentViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(parame, "this$0");
    parame.bjj();
    try
    {
      if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)parame.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.class)).akgU <= 0) {
        break label319;
      }
      i = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)parame.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.class)).akgS;
      int j = parame.Zut.jdy();
      int k = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)parame.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.class)).akgU;
      if (i + 1 > k) {
        break label268;
      }
      if (k > j - 1) {
        break label263;
      }
      i = 1;
      if (i == 0) {
        break label284;
      }
      parame.Zut.jdu().b(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)parame.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.class)).akgU, Boolean.TRUE);
      paramView = parame.Zut.agxw;
      if (paramView != null) {
        break label273;
      }
      paramView = null;
      label174:
      if (paramView != null) {
        break label332;
      }
      paramView = (List)new ArrayList();
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        int i;
        label263:
        label268:
        label273:
        label284:
        localObject = aw.Gjk;
        aw.a(paramView, kotlin.g.b.s.X(parame.TAG, "-newTipGroupClick"));
        continue;
        d.a(parame.Zut.jdu());
      }
    }
    paramView = (com.tencent.mm.plugin.finder.live.viewmodel.data.a.b)paramView.get(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)parame.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.class)).akgU);
    com.tencent.mm.plugin.finder.live.report.k.Doi.Z(paramView.aJO(), 1, paramView.kKZ());
    for (;;)
    {
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)parame.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.class)).aNA(0);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/comment/BoxCommentViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(370966);
      return;
      i = 0;
      break;
      i = 0;
      break;
      paramView = (List)paramView.data;
      break label174;
      d.a(parame.Zut.jdu());
    }
  }
  
  private <T extends af> T business(Class<T> paramClass)
  {
    AppMethodBeat.i(370941);
    kotlin.g.b.s.u(paramClass, "bu");
    paramClass = this.Zut.getBuContext().business(paramClass);
    AppMethodBeat.o(370941);
    return paramClass;
  }
  
  private final ViewGroup ivr()
  {
    AppMethodBeat.i(370946);
    Object localObject = this.Zvm.getValue();
    kotlin.g.b.s.s(localObject, "<get-newTipGroup>(...)");
    localObject = (ViewGroup)localObject;
    AppMethodBeat.o(370946);
    return localObject;
  }
  
  private final TextView ivs()
  {
    AppMethodBeat.i(370952);
    Object localObject = this.ZvL.getValue();
    kotlin.g.b.s.s(localObject, "<get-newTipTv>(...)");
    localObject = (TextView)localObject;
    AppMethodBeat.o(370952);
    return localObject;
  }
  
  public final void bjj()
  {
    AppMethodBeat.i(370981);
    ivr().setVisibility(8);
    AppMethodBeat.o(370981);
  }
  
  public final void op(long paramLong)
  {
    AppMethodBeat.i(370976);
    if (paramLong > 0L)
    {
      ivr().setVisibility(0);
      Object localObject1;
      Object localObject2;
      if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.class)).akgU > 0)
      {
        localObject1 = ivs();
        localObject2 = am.aixg;
        localObject2 = this.Zut.mJe.getContext().getResources().getString(p.h.Cjq);
        kotlin.g.b.s.s(localObject2, "plugin.root.context.reso…_live_comment_at_me_tips)");
        localObject2 = String.format((String)localObject2, Arrays.copyOf(new Object[0], 0));
        kotlin.g.b.s.s(localObject2, "java.lang.String.format(format, *args)");
        ((TextView)localObject1).setText((CharSequence)localObject2);
        AppMethodBeat.o(370976);
        return;
      }
      if (paramLong <= 99L) {
        localObject1 = String.valueOf(paramLong);
      }
      for (;;)
      {
        localObject2 = ivs();
        Object localObject3 = am.aixg;
        localObject3 = this.Zut.mJe.getContext().getResources().getString(p.h.CoM);
        kotlin.g.b.s.s(localObject3, "plugin.root.context.reso…der_live_new_comment_tip)");
        localObject1 = String.format((String)localObject3, Arrays.copyOf(new Object[] { localObject1 }, 1));
        kotlin.g.b.s.s(localObject1, "java.lang.String.format(format, *args)");
        ((TextView)localObject2).setText((CharSequence)localObject1);
        AppMethodBeat.o(370976);
        return;
        localObject1 = this.Zut.mJe.getContext().getResources().getString(p.h.YMt);
        kotlin.g.b.s.s(localObject1, "{\n                    pl…nt_tip)\n                }");
      }
    }
    bjj();
    AppMethodBeat.o(370976);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ViewGroup>
  {
    a(e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<TextView>
  {
    b(e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.b.e
 * JD-Core Version:    0.7.0.1
 */