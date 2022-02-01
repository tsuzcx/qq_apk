package com.tencent.mm.plugin.finder.uniComments.convert;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.g;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.view.FinderCollapsibleTextView;
import com.tencent.mm.plugin.finder.view.animation.c;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.protocal.protobuf.pu;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/uniComments/convert/UniFeedCommentLevel2Convert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/uniComments/storge/UniFeedComment;", "presenter", "Lcom/tencent/mm/plugin/finder/uniComments/UniCommentDrawerContract$NPresenter;", "(Lcom/tencent/mm/plugin/finder/uniComments/UniCommentDrawerContract$NPresenter;)V", "getLayoutId", "", "initTipsLayout", "", "tipsLayout", "Landroid/view/View;", "tip", "", "rootComment", "down", "", "isWxScene", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "refreshAwesomeIv", "isLike", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends f<com.tencent.mm.plugin.finder.uniComments.storge.d>
{
  public static final b.a GaK;
  private final com.tencent.mm.plugin.finder.uniComments.e.b FZO;
  
  static
  {
    AppMethodBeat.i(341783);
    GaK = new b.a((byte)0);
    AppMethodBeat.o(341783);
  }
  
  public b(com.tencent.mm.plugin.finder.uniComments.e.b paramb)
  {
    AppMethodBeat.i(341680);
    this.FZO = paramb;
    AppMethodBeat.o(341680);
  }
  
  private static final void a(View paramView1, View paramView2, b paramb, com.tencent.mm.plugin.finder.uniComments.storge.d paramd, boolean paramBoolean, View paramView3)
  {
    AppMethodBeat.i(341762);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView1);
    localb.cH(paramView2);
    localb.cH(paramb);
    localb.cH(paramd);
    localb.fv(paramBoolean);
    localb.cH(paramView3);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/uniComments/convert/UniFeedCommentLevel2Convert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "this$0");
    s.u(paramd, "$rootComment");
    paramView1.setVisibility(8);
    paramView2.setVisibility(0);
    paramb.FZO.a(paramd, paramBoolean);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/uniComments/convert/UniFeedCommentLevel2Convert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(341762);
  }
  
  private final void a(View paramView, String paramString, com.tencent.mm.plugin.finder.uniComments.storge.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(341688);
    paramView.setVisibility(0);
    ((TextView)paramView.findViewById(e.e.show_level2_tips_tv)).setText((CharSequence)paramString);
    paramString = paramView.findViewById(e.e.show_level2_arrow_iv);
    paramString.setVisibility(0);
    View localView = paramView.findViewById(e.e.show_level2_loading);
    localView.setVisibility(8);
    paramView.setOnClickListener(new b..ExternalSyntheticLambda0(paramString, localView, this, paramd, paramBoolean));
    AppMethodBeat.o(341688);
  }
  
  private static final void a(b paramb, TextView paramTextView, j paramj, View paramView)
  {
    AppMethodBeat.i(341754);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramTextView);
    localb.cH(paramj);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/uniComments/convert/UniFeedCommentLevel2Convert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "this$0");
    s.u(paramj, "$holder");
    paramb = paramb.FZO;
    s.s(paramTextView, "commentFailTV");
    paramb.as((View)paramTextView, paramj.KJ());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/uniComments/convert/UniFeedCommentLevel2Convert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(341754);
  }
  
  private static final void a(b paramb, j paramj, View paramView)
  {
    AppMethodBeat.i(341775);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramb);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramj);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/uniComments/convert/UniFeedCommentLevel2Convert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramb, "this$0");
    s.u(paramj, "$holder");
    if (paramb.FZO.isCommentClose())
    {
      aa.makeText(paramj.context, e.h.finder_comment_closed_warning3, 0).show();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/uniComments/convert/UniFeedCommentLevel2Convert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(341775);
      return;
    }
    if (paramView == null)
    {
      paramb = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.widget.imageview.WeImageView");
      AppMethodBeat.o(341775);
      throw paramb;
    }
    paramView = (WeImageView)paramView;
    localObject1 = (com.tencent.mm.plugin.finder.uniComments.storge.d)paramj.CSA;
    localObject2 = com.tencent.mm.plugin.finder.uniComments.action.d.Gao;
    int i;
    if (!com.tencent.mm.plugin.finder.uniComments.action.d.fdB().a(paramb.FZO.fdi().field_id, ((com.tencent.mm.plugin.finder.uniComments.storge.d)localObject1).Gbp, paramb.FZO.ebS()))
    {
      i = 1;
      if (i == 0) {
        break label411;
      }
      paramView.setImageResource(e.g.icon_filled_awesome);
      paramView.setIconColor(paramj.context.getResources().getColor(com.tencent.mm.plugin.finder.e.b.Red_90));
      label227:
      paramb.FZO.b((ImageView)paramView, paramj.KJ());
      localObject2 = com.tencent.mm.plugin.finder.uniComments.action.d.Gao;
      int j = com.tencent.mm.plugin.finder.uniComments.action.d.fdB().b(paramb.FZO.fdi().field_id, ((com.tencent.mm.plugin.finder.uniComments.storge.d)localObject1).Gbp, paramb.FZO.ebS());
      if (j <= 0) {
        break label438;
      }
      paramj.pt(e.e.awesome_num, 0);
      paramj.d(e.e.awesome_num, (CharSequence)String.valueOf(j));
      label313:
      if (i == 0) {
        break label465;
      }
      ((TextView)paramj.UH(e.e.awesome_num)).setTextColor(paramj.context.getResources().getColor(com.tencent.mm.plugin.finder.e.b.Red_100));
    }
    for (;;)
    {
      if (i != 0)
      {
        paramb = c.GGo;
        c.hd((View)paramView);
      }
      ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).i(paramj.UH(e.e.awesome_iv), "finder_feed_second_comment_awesome_iv");
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/uniComments/convert/UniFeedCommentLevel2Convert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(341775);
      return;
      i = 0;
      break;
      label411:
      paramView.setImageResource(e.g.icon_outlined_awesome);
      paramView.setIconColor(paramj.context.getResources().getColor(com.tencent.mm.plugin.finder.e.b.black_color));
      break label227;
      label438:
      paramj.pt(e.e.awesome_num, 8);
      paramj.d(e.e.awesome_num, (CharSequence)"");
      break label313;
      label465:
      ((TextView)paramj.UH(e.e.awesome_num)).setTextColor(paramj.context.getResources().getColor(com.tencent.mm.plugin.finder.e.b.BW_0_Alpha_0_3));
    }
  }
  
  private static final void a(com.tencent.mm.plugin.finder.uniComments.storge.d paramd, b paramb, j paramj, View paramView)
  {
    AppMethodBeat.i(341727);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramd);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramb);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramj);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/uniComments/convert/UniFeedCommentLevel2Convert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramd, "$item");
    s.u(paramb, "this$0");
    s.u(paramj, "$holder");
    paramView = paramd.Gbp.getBizInfo();
    if (paramView == null) {}
    for (paramView = null;; paramView = ah.aiuX)
    {
      if (paramView == null)
      {
        paramView = com.tencent.mm.plugin.finder.convert.d.AHD;
        paramView = paramd.Gbp.getUsername();
        paramj = paramj.context;
        s.s(paramj, "holder.context");
        com.tencent.mm.plugin.finder.convert.d.a(paramView, paramd, paramj, paramb.FZO.getCommentScene());
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/uniComments/convert/UniFeedCommentLevel2Convert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(341727);
      return;
      localObject1 = com.tencent.mm.plugin.finder.convert.d.AHD;
      localObject2 = paramj.context;
      s.s(localObject2, "holder.context");
      localObject1 = paramView.ADE;
      paramView = (View)localObject1;
      if (localObject1 == null) {
        paramView = "";
      }
      com.tencent.mm.plugin.finder.convert.d.a((Context)localObject2, paramView, paramb.FZO.getCommentScene(), paramd);
    }
  }
  
  private static final void b(com.tencent.mm.plugin.finder.uniComments.storge.d paramd, b paramb, j paramj, View paramView)
  {
    AppMethodBeat.i(341737);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramd);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramb);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramj);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/uniComments/convert/UniFeedCommentLevel2Convert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramd, "$item");
    s.u(paramb, "this$0");
    s.u(paramj, "$holder");
    paramView = paramd.Gbp.getBizInfo();
    if (paramView == null) {}
    for (paramView = null;; paramView = ah.aiuX)
    {
      if (paramView == null)
      {
        paramView = com.tencent.mm.plugin.finder.convert.d.AHD;
        paramView = paramd.Gbp.getUsername();
        paramj = paramj.context;
        s.s(paramj, "holder.context");
        com.tencent.mm.plugin.finder.convert.d.a(paramView, paramd, paramj, paramb.FZO.getCommentScene());
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/uniComments/convert/UniFeedCommentLevel2Convert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(341737);
      return;
      localObject1 = com.tencent.mm.plugin.finder.convert.d.AHD;
      localObject2 = paramj.context;
      s.s(localObject2, "holder.context");
      localObject1 = paramView.ADE;
      paramView = (View)localObject1;
      if (localObject1 == null) {
        paramView = "";
      }
      com.tencent.mm.plugin.finder.convert.d.a((Context)localObject2, paramView, paramb.FZO.getCommentScene(), paramd);
    }
  }
  
  private static final void c(View paramView, int paramInt, com.tencent.mm.ui.as paramas)
  {
    AppMethodBeat.i(341691);
    s.u(paramView, "$it");
    s.u(paramas, "$touchDelegateGroup");
    Rect localRect = new Rect();
    paramView.getHitRect(localRect);
    localRect.inset(-paramInt, -paramInt);
    paramas.a(new at(localRect, paramView));
    AppMethodBeat.o(341691);
  }
  
  private static final void c(com.tencent.mm.plugin.finder.uniComments.storge.d paramd, b paramb, j paramj, View paramView)
  {
    AppMethodBeat.i(341745);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramd);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramb);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramj);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/uniComments/convert/UniFeedCommentLevel2Convert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramd, "$item");
    s.u(paramb, "this$0");
    s.u(paramj, "$holder");
    paramView = paramd.Gbp.getBizInfo();
    if (paramView == null) {}
    for (paramView = null;; paramView = ah.aiuX)
    {
      if (paramView == null)
      {
        paramView = com.tencent.mm.plugin.finder.convert.d.AHD;
        paramView = paramd.Gbp.getUsername();
        paramj = paramj.context;
        s.s(paramj, "holder.context");
        com.tencent.mm.plugin.finder.convert.d.a(paramView, paramd, paramj, paramb.FZO.getCommentScene());
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/uniComments/convert/UniFeedCommentLevel2Convert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(341745);
      return;
      localObject1 = com.tencent.mm.plugin.finder.convert.d.AHD;
      localObject2 = paramj.context;
      s.s(localObject2, "holder.context");
      localObject1 = paramView.ADE;
      paramView = (View)localObject1;
      if (localObject1 == null) {
        paramView = "";
      }
      com.tencent.mm.plugin.finder.convert.d.a((Context)localObject2, paramView, paramb.FZO.getCommentScene(), paramd);
    }
  }
  
  private static final void c(com.tencent.mm.plugin.finder.uniComments.storge.d paramd, j paramj, View paramView)
  {
    AppMethodBeat.i(341714);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramd);
    localb.cH(paramj);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/uniComments/convert/UniFeedCommentLevel2Convert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramd, "$item");
    s.u(paramj, "$holder");
    paramView = com.tencent.mm.plugin.finder.utils.a.GfO;
    paramView = paramd.Gbp.getUsername();
    localObject = paramj.context;
    s.s(localObject, "holder.context");
    com.tencent.mm.plugin.finder.utils.a.e(paramView, (Context)localObject);
    paramView = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
    paramj = paramj.context;
    s.s(paramj, "holder.context");
    paramj = as.a.hu(paramj);
    if (paramj != null)
    {
      paramView = z.FrZ;
      z.a(1, paramd.Gbp.field_feedId, paramj.AJo, 2, paramd.Gbp.getUsername());
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/uniComments/convert/UniFeedCommentLevel2Convert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(341714);
  }
  
  private static final void c(j paramj, String paramString, com.tencent.mm.plugin.finder.uniComments.storge.d paramd, View paramView)
  {
    AppMethodBeat.i(341702);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramj);
    localb.cH(paramString);
    localb.cH(paramd);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/uniComments/convert/UniFeedCommentLevel2Convert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramj, "$holder");
    s.u(paramString, "$feedUser");
    s.u(paramd, "$item");
    paramView = av.GiL;
    av.a(paramj, paramString, paramd);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/uniComments/convert/UniFeedCommentLevel2Convert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(341702);
  }
  
  private static final void d(com.tencent.mm.plugin.finder.uniComments.storge.d paramd, j paramj, View paramView)
  {
    AppMethodBeat.i(341721);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramd);
    localb.cH(paramj);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/uniComments/convert/UniFeedCommentLevel2Convert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramd, "$item");
    s.u(paramj, "$holder");
    paramView = com.tencent.mm.plugin.finder.utils.a.GfO;
    paramView = paramd.Gbp.getUsername();
    localObject = paramj.context;
    s.s(localObject, "holder.context");
    com.tencent.mm.plugin.finder.utils.a.e(paramView, (Context)localObject);
    paramView = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
    paramj = paramj.context;
    s.s(paramj, "holder.context");
    paramj = as.a.hu(paramj);
    if (paramj != null)
    {
      paramView = z.FrZ;
      z.a(1, paramd.Gbp.field_feedId, paramj.AJo, 2, paramd.Gbp.getUsername());
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/uniComments/convert/UniFeedCommentLevel2Convert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(341721);
  }
  
  private static final void d(j paramj, String paramString, com.tencent.mm.plugin.finder.uniComments.storge.d paramd, View paramView)
  {
    AppMethodBeat.i(341708);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramj);
    localb.cH(paramString);
    localb.cH(paramd);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/uniComments/convert/UniFeedCommentLevel2Convert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramj, "$holder");
    s.u(paramString, "$feedUser");
    s.u(paramd, "$item");
    paramView = av.GiL;
    av.a(paramj, paramString, paramd);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/uniComments/convert/UniFeedCommentLevel2Convert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(341708);
  }
  
  private final boolean dXw()
  {
    AppMethodBeat.i(341684);
    if (this.FZO.ebS() == 2)
    {
      AppMethodBeat.o(341684);
      return true;
    }
    AppMethodBeat.o(341684);
    return false;
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(341892);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    paramRecyclerView = (FinderCollapsibleTextView)paramj.UH(e.e.commend_content);
    paramRecyclerView.setLimitLine(4);
    paramRecyclerView.setCollapse(true);
    paramRecyclerView.uT(false);
    paramRecyclerView.setOnCollapse((kotlin.g.a.b)new d(paramj));
    View localView = paramj.UH(e.e.level2_main_area);
    paramRecyclerView = new com.tencent.mm.ui.as(localView);
    localView.setTouchDelegate((TouchDelegate)paramRecyclerView);
    paramInt = com.tencent.mm.cd.a.bs(paramj.context, e.c.Edge_2A);
    paramj = paramj.UH(e.e.awesome_iv);
    if (paramj != null) {
      paramj.post(new b..ExternalSyntheticLambda10(paramj, paramInt, paramRecyclerView));
    }
    AppMethodBeat.o(341892);
  }
  
  public final int getLayoutId()
  {
    return e.f._uni_comment_item_level_two;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "username", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<String, ah>
  {
    b(com.tencent.mm.plugin.finder.uniComments.storge.d paramd, b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "collapse", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    d(j paramj)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.uniComments.convert.b
 * JD-Core Version:    0.7.0.1
 */