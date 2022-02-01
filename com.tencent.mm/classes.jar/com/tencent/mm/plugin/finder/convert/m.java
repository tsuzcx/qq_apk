package com.tencent.mm.plugin.finder.convert;

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
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.g;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.model.t;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.NPresenter;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.au;
import com.tencent.mm.plugin.finder.upload.action.l;
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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$NPresenter;", "(Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$NPresenter;)V", "getLayoutId", "", "initTipsLayout", "", "tipsLayout", "Landroid/view/View;", "tip", "", "rootComment", "down", "", "isWxScene", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "refreshAwesomeIv", "isLike", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  extends f<t>
{
  public static final a AHT;
  private final CommentDrawerContract.NPresenter AHK;
  
  static
  {
    AppMethodBeat.i(178121);
    AHT = new a((byte)0);
    AppMethodBeat.o(178121);
  }
  
  public m(CommentDrawerContract.NPresenter paramNPresenter)
  {
    AppMethodBeat.i(178120);
    this.AHK = paramNPresenter;
    AppMethodBeat.o(178120);
  }
  
  private static final void a(View paramView1, View paramView2, m paramm, t paramt, boolean paramBoolean, View paramView3)
  {
    AppMethodBeat.i(350506);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView1);
    localb.cH(paramView2);
    localb.cH(paramm);
    localb.cH(paramt);
    localb.fv(paramBoolean);
    localb.cH(paramView3);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramm, "this$0");
    s.u(paramt, "$rootComment");
    paramView1.setVisibility(8);
    paramView2.setVisibility(0);
    paramm.AHK.a(paramt, paramBoolean);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(350506);
  }
  
  private final void a(View paramView, String paramString, t paramt, boolean paramBoolean)
  {
    AppMethodBeat.i(178119);
    paramView.setVisibility(0);
    ((TextView)paramView.findViewById(e.e.show_level2_tips_tv)).setText((CharSequence)paramString);
    paramString = paramView.findViewById(e.e.show_level2_arrow_iv);
    paramString.setVisibility(0);
    View localView = paramView.findViewById(e.e.show_level2_loading);
    localView.setVisibility(8);
    paramView.setOnClickListener(new m..ExternalSyntheticLambda0(paramString, localView, this, paramt, paramBoolean));
    AppMethodBeat.o(178119);
  }
  
  private static final void a(m paramm, TextView paramTextView, j paramj, View paramView)
  {
    AppMethodBeat.i(350488);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramm);
    localb.cH(paramTextView);
    localb.cH(paramj);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramm, "this$0");
    s.u(paramj, "$holder");
    paramm = paramm.AHK;
    s.s(paramTextView, "commentFailTV");
    paramm.as((View)paramTextView, paramj.KJ());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(350488);
  }
  
  private static final void a(m paramm, j paramj, View paramView)
  {
    AppMethodBeat.i(350515);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramm);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramj);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramm, "this$0");
    s.u(paramj, "$holder");
    if (paramm.AHK.isCommentClose())
    {
      aa.makeText(paramj.context, e.h.finder_comment_closed_warning3, 0).show();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(350515);
      return;
    }
    paramView = (WeImageView)paramj.UH(e.e.awesome_iv);
    localObject1 = (t)paramj.CSA;
    localObject2 = l.Gdj;
    int i;
    if (!l.fek().a(paramm.AHK.ebT().field_id, ((t)localObject1).ECu, paramm.AHK.ebS()))
    {
      i = 1;
      if (i == 0) {
        break label406;
      }
      paramView.setImageResource(e.g.icon_filled_awesome);
      paramView.setIconColor(paramj.context.getResources().getColor(e.b.Red_90));
      label211:
      localObject2 = paramm.AHK;
      s.s(paramView, "iv");
      ((CommentDrawerContract.NPresenter)localObject2).b((ImageView)paramView, paramj.KJ());
      localObject2 = l.Gdj;
      int j = l.fek().b(paramm.AHK.ebT().field_id, ((t)localObject1).ECu, paramm.AHK.ebS());
      if (j <= 0) {
        break label433;
      }
      paramj.pt(e.e.awesome_num, 0);
      paramj.d(e.e.awesome_num, (CharSequence)String.valueOf(j));
      label308:
      if (i == 0) {
        break label460;
      }
      ((TextView)paramj.UH(e.e.awesome_num)).setTextColor(paramj.context.getResources().getColor(e.b.Red_100));
    }
    for (;;)
    {
      if (i != 0)
      {
        paramm = c.GGo;
        c.hd((View)paramView);
      }
      ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).i(paramj.UH(e.e.awesome_iv), "finder_feed_second_comment_awesome_iv");
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(350515);
      return;
      i = 0;
      break;
      label406:
      paramView.setImageResource(e.g.icon_outlined_awesome);
      paramView.setIconColor(paramj.context.getResources().getColor(e.b.black_color));
      break label211;
      label433:
      paramj.pt(e.e.awesome_num, 8);
      paramj.d(e.e.awesome_num, (CharSequence)"");
      break label308;
      label460:
      ((TextView)paramj.UH(e.e.awesome_num)).setTextColor(paramj.context.getResources().getColor(e.b.BW_0_Alpha_0_3));
    }
  }
  
  private static final void a(m paramm, j paramj, t paramt, View paramView)
  {
    AppMethodBeat.i(350498);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramm);
    localb.cH(paramj);
    localb.cH(paramt);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramm, "this$0");
    s.u(paramj, "$holder");
    s.u(paramt, "$item");
    paramm = paramm.AHK;
    paramj = paramj.caK;
    s.s(paramj, "holder.itemView");
    paramm.a(paramj, paramt);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(350498);
  }
  
  private static final void a(t paramt, m paramm, j paramj, View paramView)
  {
    AppMethodBeat.i(350464);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramt);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramm);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramj);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramt, "$item");
    s.u(paramm, "this$0");
    s.u(paramj, "$holder");
    paramView = paramt.ECu.getBizInfo();
    if (paramView == null) {}
    for (paramView = null;; paramView = ah.aiuX)
    {
      if (paramView == null)
      {
        paramView = d.AHD;
        paramView = paramt.ECu.getUsername();
        paramj = paramj.context;
        s.s(paramj, "holder.context");
        d.a(paramView, paramt, paramj, paramm.AHK.getCommentScene());
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(350464);
      return;
      localObject1 = d.AHD;
      localObject2 = paramj.context;
      s.s(localObject2, "holder.context");
      localObject1 = paramView.ADE;
      paramView = (View)localObject1;
      if (localObject1 == null) {
        paramView = "";
      }
      d.a((Context)localObject2, paramView, paramm.AHK.getCommentScene(), paramt, paramm.AHK.ebT());
    }
  }
  
  private static final void b(t paramt, m paramm, j paramj, View paramView)
  {
    AppMethodBeat.i(350471);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramt);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramm);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramj);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramt, "$item");
    s.u(paramm, "this$0");
    s.u(paramj, "$holder");
    paramView = paramt.ECu.getBizInfo();
    if (paramView == null) {}
    for (paramView = null;; paramView = ah.aiuX)
    {
      if (paramView == null)
      {
        paramView = d.AHD;
        paramView = paramt.ECu.getUsername();
        paramj = paramj.context;
        s.s(paramj, "holder.context");
        d.a(paramView, paramt, paramj, paramm.AHK.getCommentScene());
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(350471);
      return;
      localObject1 = d.AHD;
      localObject2 = paramj.context;
      s.s(localObject2, "holder.context");
      localObject1 = paramView.ADE;
      paramView = (View)localObject1;
      if (localObject1 == null) {
        paramView = "";
      }
      d.a((Context)localObject2, paramView, paramm.AHK.getCommentScene(), paramt, paramm.AHK.ebT());
    }
  }
  
  private static final void c(View paramView, int paramInt, com.tencent.mm.ui.as paramas)
  {
    AppMethodBeat.i(350426);
    s.u(paramView, "$it");
    s.u(paramas, "$touchDelegateGroup");
    Rect localRect = new Rect();
    paramView.getHitRect(localRect);
    localRect.inset(-paramInt, -paramInt);
    paramas.a(new at(localRect, paramView));
    AppMethodBeat.o(350426);
  }
  
  private static final void c(t paramt, m paramm, j paramj, View paramView)
  {
    AppMethodBeat.i(350478);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramt);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramm);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramj);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramt, "$item");
    s.u(paramm, "this$0");
    s.u(paramj, "$holder");
    paramView = paramt.ECu.getBizInfo();
    if (paramView == null) {}
    for (paramView = null;; paramView = ah.aiuX)
    {
      if (paramView == null)
      {
        paramView = d.AHD;
        paramView = paramt.ECu.getUsername();
        paramj = paramj.context;
        s.s(paramj, "holder.context");
        d.a(paramView, paramt, paramj, paramm.AHK.getCommentScene());
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(350478);
      return;
      localObject1 = d.AHD;
      localObject2 = paramj.context;
      s.s(localObject2, "holder.context");
      localObject1 = paramView.ADE;
      paramView = (View)localObject1;
      if (localObject1 == null) {
        paramView = "";
      }
      d.a((Context)localObject2, paramView, paramm.AHK.getCommentScene(), paramt, paramm.AHK.ebT());
    }
  }
  
  private static final void c(t paramt, j paramj, View paramView)
  {
    AppMethodBeat.i(350449);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramt);
    localb.cH(paramj);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramt, "$item");
    s.u(paramj, "$holder");
    paramView = com.tencent.mm.plugin.finder.utils.a.GfO;
    paramView = paramt.ECu.getUsername();
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
      z.a(1, paramt.ECu.field_feedId, paramj.AJo, 2, paramt.ECu.getUsername());
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(350449);
  }
  
  private static final void c(j paramj, String paramString, t paramt, View paramView)
  {
    AppMethodBeat.i(350434);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramj);
    localb.cH(paramString);
    localb.cH(paramt);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramj, "$holder");
    s.u(paramString, "$feedUser");
    s.u(paramt, "$item");
    paramView = av.GiL;
    av.a(paramj, paramString, paramt);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(350434);
  }
  
  private static final void d(t paramt, j paramj, View paramView)
  {
    AppMethodBeat.i(350456);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramt);
    localb.cH(paramj);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramt, "$item");
    s.u(paramj, "$holder");
    paramView = com.tencent.mm.plugin.finder.utils.a.GfO;
    paramView = paramt.ECu.getUsername();
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
      z.a(1, paramt.ECu.field_feedId, paramj.AJo, 2, paramt.ECu.getUsername());
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(350456);
  }
  
  private static final void d(j paramj, String paramString, t paramt, View paramView)
  {
    AppMethodBeat.i(350442);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramj);
    localb.cH(paramString);
    localb.cH(paramt);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramj, "$holder");
    s.u(paramString, "$feedUser");
    s.u(paramt, "$item");
    paramView = av.GiL;
    av.a(paramj, paramString, paramt);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(350442);
  }
  
  private final boolean dXw()
  {
    AppMethodBeat.i(178117);
    if (this.AHK.ebS() == 2)
    {
      AppMethodBeat.o(178117);
      return true;
    }
    AppMethodBeat.o(178117);
    return false;
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(350612);
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
    localView = paramj.UH(e.e.awesome_iv);
    if (localView != null) {
      localView.post(new m..ExternalSyntheticLambda11(localView, paramInt, paramRecyclerView));
    }
    ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).i(paramj.UH(e.e.awesome_iv), "finder_feed_second_comment_awesome_iv");
    AppMethodBeat.o(350612);
  }
  
  public final int getLayoutId()
  {
    return e.f._feed_comment_item_level_two;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "username", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<String, ah>
  {
    b(t paramt, m paramm, j paramj)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.m
 * JD-Core Version:    0.7.0.1
 */