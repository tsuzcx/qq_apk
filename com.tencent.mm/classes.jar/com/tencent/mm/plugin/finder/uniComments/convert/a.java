package com.tencent.mm.plugin.finder.uniComments.convert;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.bb;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/uniComments/convert/UniFeedCommentConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/uniComments/storge/UniFeedComment;", "presenter", "Lcom/tencent/mm/plugin/finder/uniComments/UniCommentDrawerContract$NPresenter;", "oldVersion", "", "(Lcom/tencent/mm/plugin/finder/uniComments/UniCommentDrawerContract$NPresenter;Z)V", "getOldVersion", "()Z", "getLayoutId", "", "isWxScene", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "refreshAwesomeIv", "isLike", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends f<com.tencent.mm.plugin.finder.uniComments.storge.d>
{
  public static final a GaJ;
  private final boolean AHL;
  private final com.tencent.mm.plugin.finder.uniComments.e.b FZO;
  
  static
  {
    AppMethodBeat.i(341780);
    GaJ = new a((byte)0);
    AppMethodBeat.o(341780);
  }
  
  public a(com.tencent.mm.plugin.finder.uniComments.e.b paramb)
  {
    AppMethodBeat.i(341673);
    this.FZO = paramb;
    this.AHL = false;
    AppMethodBeat.o(341673);
  }
  
  private static final void a(View paramView, int paramInt, com.tencent.mm.ui.as paramas)
  {
    AppMethodBeat.i(341686);
    s.u(paramView, "$it");
    s.u(paramas, "$touchDelegateGroup");
    Rect localRect = new Rect();
    paramView.getHitRect(localRect);
    localRect.inset(-paramInt, -paramInt);
    paramas.a(new at(localRect, paramView));
    AppMethodBeat.o(341686);
  }
  
  private static final void a(View paramView1, View paramView2, a parama, com.tencent.mm.plugin.finder.uniComments.storge.d paramd, View paramView3)
  {
    AppMethodBeat.i(341761);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView1);
    localb.cH(paramView2);
    localb.cH(parama);
    localb.cH(paramd);
    localb.cH(paramView3);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/uniComments/convert/UniFeedCommentConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    s.u(paramd, "$item");
    paramView1.setVisibility(8);
    paramView2.setVisibility(0);
    parama.FZO.a(paramd, true);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/uniComments/convert/UniFeedCommentConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(341761);
  }
  
  private static final void a(a parama, TextView paramTextView, j paramj, View paramView)
  {
    AppMethodBeat.i(341744);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramTextView);
    localb.cH(paramj);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/uniComments/convert/UniFeedCommentConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    s.u(paramj, "$holder");
    parama = parama.FZO;
    s.s(paramTextView, "commentFailTV");
    parama.as((View)paramTextView, paramj.KJ());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/uniComments/convert/UniFeedCommentConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(341744);
  }
  
  private static final void a(a parama, j paramj, View paramView)
  {
    AppMethodBeat.i(341774);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(parama);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramj);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/uniComments/convert/UniFeedCommentConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(parama, "this$0");
    s.u(paramj, "$holder");
    if (parama.FZO.isCommentClose())
    {
      aa.makeText(paramj.context, e.h.finder_comment_closed_warning3, 0).show();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/uniComments/convert/UniFeedCommentConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(341774);
      return;
    }
    if (paramView == null)
    {
      parama = new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(341774);
      throw parama;
    }
    localObject1 = (ImageView)paramView;
    localObject2 = (com.tencent.mm.plugin.finder.uniComments.storge.d)paramj.CSA;
    paramView = com.tencent.mm.plugin.finder.uniComments.action.d.Gao;
    int i;
    if (!com.tencent.mm.plugin.finder.uniComments.action.d.fdB().a(parama.FZO.fdi().field_id, ((com.tencent.mm.plugin.finder.uniComments.storge.d)localObject2).Gbp, parama.FZO.ebS()))
    {
      i = 1;
      if (i == 0) {
        break label391;
      }
      paramView = bb.m(paramj.context, e.g.icon_filled_awesome, paramj.context.getResources().getColor(com.tencent.mm.plugin.finder.e.b.Red_90));
      label227:
      ((ImageView)localObject1).setImageDrawable(paramView);
      parama.FZO.b((ImageView)localObject1, paramj.KJ());
      paramView = com.tencent.mm.plugin.finder.uniComments.action.d.Gao;
      int j = com.tencent.mm.plugin.finder.uniComments.action.d.fdB().b(parama.FZO.fdi().field_id, ((com.tencent.mm.plugin.finder.uniComments.storge.d)localObject2).Gbp, parama.FZO.ebS());
      if (j <= 0) {
        break label418;
      }
      paramj.pt(e.e.awesome_num, 0);
      paramj.d(e.e.awesome_num, (CharSequence)String.valueOf(j));
      label316:
      if (i == 0) {
        break label445;
      }
      ((TextView)paramj.UH(e.e.awesome_num)).setTextColor(paramj.context.getResources().getColor(com.tencent.mm.plugin.finder.e.b.Red_90));
    }
    for (;;)
    {
      if (i != 0)
      {
        parama = c.GGo;
        c.hd((View)localObject1);
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/uniComments/convert/UniFeedCommentConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(341774);
      return;
      i = 0;
      break;
      label391:
      paramView = bb.m(paramj.context, e.g.icon_outlined_awesome, paramj.context.getResources().getColor(com.tencent.mm.plugin.finder.e.b.black_color));
      break label227;
      label418:
      paramj.pt(e.e.awesome_num, 8);
      paramj.d(e.e.awesome_num, (CharSequence)"");
      break label316;
      label445:
      ((TextView)paramj.UH(e.e.awesome_num)).setTextColor(paramj.context.getResources().getColor(com.tencent.mm.plugin.finder.e.b.BW_0_Alpha_0_3));
    }
  }
  
  private static final void a(a parama, j paramj, com.tencent.mm.plugin.finder.uniComments.storge.d paramd, View paramView)
  {
    AppMethodBeat.i(341752);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramj);
    localb.cH(paramd);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/uniComments/convert/UniFeedCommentConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    s.u(paramj, "$holder");
    s.u(paramd, "$item");
    parama = parama.FZO;
    paramj = paramj.caK;
    s.s(paramj, "holder.itemView");
    parama.a(paramj, paramd);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/uniComments/convert/UniFeedCommentConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(341752);
  }
  
  private static final void a(com.tencent.mm.plugin.finder.uniComments.storge.d paramd, a parama, j paramj, View paramView)
  {
    AppMethodBeat.i(341722);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramd);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(parama);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramj);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/uniComments/convert/UniFeedCommentConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramd, "$item");
    s.u(parama, "this$0");
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
        com.tencent.mm.plugin.finder.convert.d.a(paramView, paramd, paramj, parama.FZO.getCommentScene());
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/uniComments/convert/UniFeedCommentConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(341722);
      return;
      localObject1 = com.tencent.mm.plugin.finder.convert.d.AHD;
      localObject2 = paramj.context;
      s.s(localObject2, "holder.context");
      localObject1 = paramView.ADE;
      paramView = (View)localObject1;
      if (localObject1 == null) {
        paramView = "";
      }
      com.tencent.mm.plugin.finder.convert.d.a((Context)localObject2, paramView, parama.FZO.getCommentScene(), paramd);
    }
  }
  
  private static final void a(com.tencent.mm.plugin.finder.uniComments.storge.d paramd, j paramj, View paramView)
  {
    AppMethodBeat.i(341696);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramd);
    localb.cH(paramj);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/uniComments/convert/UniFeedCommentConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
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
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/uniComments/convert/UniFeedCommentConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(341696);
  }
  
  private static final void a(j paramj, String paramString, com.tencent.mm.plugin.finder.uniComments.storge.d paramd, View paramView)
  {
    AppMethodBeat.i(341709);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramj);
    localb.cH(paramString);
    localb.cH(paramd);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/uniComments/convert/UniFeedCommentConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramj, "$holder");
    s.u(paramString, "$feedUser");
    s.u(paramd, "$item");
    paramView = av.GiL;
    av.a(paramj, paramString, paramd);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/uniComments/convert/UniFeedCommentConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(341709);
  }
  
  private static final void b(View paramView, int paramInt, com.tencent.mm.ui.as paramas)
  {
    AppMethodBeat.i(341687);
    s.u(paramView, "$it");
    s.u(paramas, "$touchDelegateGroup");
    Rect localRect = new Rect();
    paramView.getHitRect(localRect);
    localRect.inset(-paramInt, -paramInt);
    paramas.a(new at(localRect, paramView));
    AppMethodBeat.o(341687);
  }
  
  private static final void b(com.tencent.mm.plugin.finder.uniComments.storge.d paramd, a parama, j paramj, View paramView)
  {
    AppMethodBeat.i(341729);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramd);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(parama);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramj);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/uniComments/convert/UniFeedCommentConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramd, "$item");
    s.u(parama, "this$0");
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
        com.tencent.mm.plugin.finder.convert.d.a(paramView, paramd, paramj, parama.FZO.getCommentScene());
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/uniComments/convert/UniFeedCommentConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(341729);
      return;
      localObject1 = com.tencent.mm.plugin.finder.convert.d.AHD;
      localObject2 = paramj.context;
      s.s(localObject2, "holder.context");
      localObject1 = paramView.ADE;
      paramView = (View)localObject1;
      if (localObject1 == null) {
        paramView = "";
      }
      com.tencent.mm.plugin.finder.convert.d.a((Context)localObject2, paramView, parama.FZO.getCommentScene(), paramd);
    }
  }
  
  private static final void b(com.tencent.mm.plugin.finder.uniComments.storge.d paramd, j paramj, View paramView)
  {
    AppMethodBeat.i(341703);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramd);
    localb.cH(paramj);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/uniComments/convert/UniFeedCommentConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
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
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/uniComments/convert/UniFeedCommentConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(341703);
  }
  
  private static final void b(j paramj, String paramString, com.tencent.mm.plugin.finder.uniComments.storge.d paramd, View paramView)
  {
    AppMethodBeat.i(341715);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramj);
    localb.cH(paramString);
    localb.cH(paramd);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/uniComments/convert/UniFeedCommentConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramj, "$holder");
    s.u(paramString, "$feedUser");
    s.u(paramd, "$item");
    paramView = av.GiL;
    av.a(paramj, paramString, paramd);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/uniComments/convert/UniFeedCommentConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(341715);
  }
  
  private static final void c(com.tencent.mm.plugin.finder.uniComments.storge.d paramd, a parama, j paramj, View paramView)
  {
    AppMethodBeat.i(341738);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramd);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(parama);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramj);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/uniComments/convert/UniFeedCommentConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramd, "$item");
    s.u(parama, "this$0");
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
        com.tencent.mm.plugin.finder.convert.d.a(paramView, paramd, paramj, parama.FZO.getCommentScene());
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/uniComments/convert/UniFeedCommentConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(341738);
      return;
      localObject1 = com.tencent.mm.plugin.finder.convert.d.AHD;
      localObject2 = paramj.context;
      s.s(localObject2, "holder.context");
      localObject1 = paramView.ADE;
      paramView = (View)localObject1;
      if (localObject1 == null) {
        paramView = "";
      }
      com.tencent.mm.plugin.finder.convert.d.a((Context)localObject2, paramView, parama.FZO.getCommentScene(), paramd);
    }
  }
  
  private final boolean dXw()
  {
    AppMethodBeat.i(341681);
    if (this.FZO.ebS() == 2)
    {
      AppMethodBeat.o(341681);
      return true;
    }
    AppMethodBeat.o(341681);
    return false;
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(341887);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    View localView = paramj.UH(e.e.feed_comment_layout);
    paramRecyclerView = new com.tencent.mm.ui.as(localView);
    localView.setTouchDelegate((TouchDelegate)paramRecyclerView);
    paramInt = com.tencent.mm.cd.a.bs(paramj.context, e.c.Edge_2A);
    localView = paramj.UH(e.e.comment_more_iv);
    if (localView != null) {
      localView.post(new a..ExternalSyntheticLambda12(localView, paramInt, paramRecyclerView));
    }
    localView = paramj.UH(e.e.awesome_iv);
    if (localView != null) {
      localView.post(new a..ExternalSyntheticLambda11(localView, paramInt, paramRecyclerView));
    }
    ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).i(paramj.UH(e.e.awesome_iv), "finder_feed_first_comment_awesome_iv");
    paramRecyclerView = (FinderCollapsibleTextView)paramj.UH(e.e.reply_comment_content);
    paramRecyclerView.setLimitLine(2);
    paramRecyclerView.setCollapse(true);
    paramRecyclerView.uT(false);
    paramRecyclerView.setOnCollapse((kotlin.g.a.b)new a.c(paramj));
    paramRecyclerView.setTextColor(paramj.context.getResources().getColor(com.tencent.mm.plugin.finder.e.b.BW_0_Alpha_0_3));
    paramRecyclerView = (FinderCollapsibleTextView)paramj.UH(e.e.commend_content);
    paramRecyclerView.setLimitLine(4);
    paramRecyclerView.setCollapse(true);
    paramRecyclerView.uT(false);
    paramRecyclerView.setOnCollapse((kotlin.g.a.b)new d(paramj));
    AppMethodBeat.o(341887);
  }
  
  public final int getLayoutId()
  {
    return e.f._uni_comment_item;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/uniComments/convert/UniFeedCommentConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/uniComments/convert/UniFeedCommentConvert$onBindViewHolder$12", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Animator.AnimatorListener
  {
    b(View paramView, int paramInt) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(341623);
      this.AHM.setVisibility(8);
      Log.i("Finder.FinderFeedCommentConvert", s.X("maskView gone ", Integer.valueOf(this.qkg)));
      AppMethodBeat.o(341623);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
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
 * Qualified Name:     com.tencent.mm.plugin.finder.uniComments.convert.a
 * JD-Core Version:    0.7.0.1
 */