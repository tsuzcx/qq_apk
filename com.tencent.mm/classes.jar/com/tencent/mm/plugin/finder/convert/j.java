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
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.f;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$NPresenter;", "oldVersion", "", "(Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$NPresenter;Z)V", "getOldVersion", "()Z", "getLayoutId", "", "isWxScene", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "refreshAwesomeIv", "isLike", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  extends f<t>
{
  public static final a AHJ;
  private final CommentDrawerContract.NPresenter AHK;
  private final boolean AHL;
  
  static
  {
    AppMethodBeat.i(165328);
    AHJ = new a((byte)0);
    AppMethodBeat.o(165328);
  }
  
  public j(CommentDrawerContract.NPresenter paramNPresenter, boolean paramBoolean)
  {
    AppMethodBeat.i(178106);
    this.AHK = paramNPresenter;
    this.AHL = paramBoolean;
    AppMethodBeat.o(178106);
  }
  
  private static final void a(View paramView, int paramInt, com.tencent.mm.ui.as paramas)
  {
    AppMethodBeat.i(350432);
    s.u(paramView, "$it");
    s.u(paramas, "$touchDelegateGroup");
    Rect localRect = new Rect();
    paramView.getHitRect(localRect);
    localRect.inset(-paramInt, -paramInt);
    paramas.a(new at(localRect, paramView));
    AppMethodBeat.o(350432);
  }
  
  private static final void a(View paramView1, View paramView2, j paramj, t paramt, View paramView3)
  {
    AppMethodBeat.i(350513);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView1);
    localb.cH(paramView2);
    localb.cH(paramj);
    localb.cH(paramt);
    localb.cH(paramView3);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramj, "this$0");
    s.u(paramt, "$item");
    paramView1.setVisibility(8);
    paramView2.setVisibility(0);
    paramj.AHK.a(paramt, true);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(350513);
  }
  
  private static final void a(j paramj, TextView paramTextView, com.tencent.mm.view.recyclerview.j paramj1, View paramView)
  {
    AppMethodBeat.i(350504);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramj);
    localb.cH(paramTextView);
    localb.cH(paramj1);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramj, "this$0");
    s.u(paramj1, "$holder");
    paramj = paramj.AHK;
    s.s(paramTextView, "commentFailTV");
    paramj.as((View)paramTextView, paramj1.KJ());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(350504);
  }
  
  private static final void a(j paramj, com.tencent.mm.view.recyclerview.j paramj1, View paramView)
  {
    AppMethodBeat.i(350522);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramj);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramj1);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramj, "this$0");
    s.u(paramj1, "$holder");
    if (paramj.AHK.isCommentClose())
    {
      aa.makeText(paramj1.context, e.h.finder_comment_closed_warning3, 0).show();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(350522);
      return;
    }
    localObject1 = (WeImageView)paramj1.UH(e.e.awesome_iv);
    localObject2 = (t)paramj1.CSA;
    paramView = l.Gdj;
    int i;
    if (!l.fek().a(paramj.AHK.ebT().field_id, ((t)localObject2).ECu, paramj.AHK.ebS()))
    {
      i = 1;
      if (i == 0) {
        break label388;
      }
      paramView = bb.m(paramj1.context, e.g.icon_filled_awesome, paramj1.context.getResources().getColor(e.b.Red_90));
      label211:
      ((WeImageView)localObject1).setImageDrawable(paramView);
      paramView = paramj.AHK;
      s.s(localObject1, "iv");
      paramView.b((ImageView)localObject1, paramj1.KJ());
      paramView = l.Gdj;
      int j = l.fek().b(paramj.AHK.ebT().field_id, ((t)localObject2).ECu, paramj.AHK.ebS());
      if (j <= 0) {
        break label415;
      }
      paramj1.pt(e.e.awesome_num, 0);
      paramj1.d(e.e.awesome_num, (CharSequence)String.valueOf(j));
      label313:
      if (i == 0) {
        break label442;
      }
      ((TextView)paramj1.UH(e.e.awesome_num)).setTextColor(paramj1.context.getResources().getColor(e.b.Red_90));
    }
    for (;;)
    {
      if (i != 0)
      {
        paramj = c.GGo;
        c.hd((View)localObject1);
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(350522);
      return;
      i = 0;
      break;
      label388:
      paramView = bb.m(paramj1.context, e.g.icon_outlined_awesome, paramj1.context.getResources().getColor(e.b.black_color));
      break label211;
      label415:
      paramj1.pt(e.e.awesome_num, 8);
      paramj1.d(e.e.awesome_num, (CharSequence)"");
      break label313;
      label442:
      ((TextView)paramj1.UH(e.e.awesome_num)).setTextColor(paramj1.context.getResources().getColor(e.b.BW_0_Alpha_0_3));
    }
  }
  
  private static final void a(j paramj, com.tencent.mm.view.recyclerview.j paramj1, t paramt, View paramView)
  {
    AppMethodBeat.i(350509);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramj);
    localb.cH(paramj1);
    localb.cH(paramt);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramj, "this$0");
    s.u(paramj1, "$holder");
    s.u(paramt, "$item");
    paramj = paramj.AHK;
    paramj1 = paramj1.caK;
    s.s(paramj1, "holder.itemView");
    paramj.a(paramj1, paramt);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(350509);
  }
  
  private static final void a(t paramt, j paramj, com.tencent.mm.view.recyclerview.j paramj1, View paramView)
  {
    AppMethodBeat.i(350477);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramt);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramj);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramj1);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramt, "$item");
    s.u(paramj, "this$0");
    s.u(paramj1, "$holder");
    paramView = paramt.ECu.getBizInfo();
    if (paramView == null) {}
    for (paramView = null;; paramView = ah.aiuX)
    {
      if (paramView == null)
      {
        paramView = d.AHD;
        paramView = paramt.ECu.getUsername();
        paramj1 = paramj1.context;
        s.s(paramj1, "holder.context");
        d.a(paramView, paramt, paramj1, paramj.AHK.getCommentScene());
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(350477);
      return;
      localObject1 = d.AHD;
      localObject2 = paramj1.context;
      s.s(localObject2, "holder.context");
      localObject1 = paramView.ADE;
      paramView = (View)localObject1;
      if (localObject1 == null) {
        paramView = "";
      }
      d.a((Context)localObject2, paramView, paramj.AHK.getCommentScene(), paramt, paramj.AHK.ebT());
    }
  }
  
  private static final void a(t paramt, com.tencent.mm.view.recyclerview.j paramj, View paramView)
  {
    AppMethodBeat.i(350448);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramt);
    localb.cH(paramj);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
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
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(350448);
  }
  
  private static final void a(com.tencent.mm.view.recyclerview.j paramj, String paramString, t paramt, View paramView)
  {
    AppMethodBeat.i(350462);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramj);
    localb.cH(paramString);
    localb.cH(paramt);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramj, "$holder");
    s.u(paramString, "$feedUser");
    s.u(paramt, "$item");
    paramView = av.GiL;
    av.a(paramj, paramString, paramt);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(350462);
  }
  
  private static final void b(View paramView, int paramInt, com.tencent.mm.ui.as paramas)
  {
    AppMethodBeat.i(350441);
    s.u(paramView, "$it");
    s.u(paramas, "$touchDelegateGroup");
    Rect localRect = new Rect();
    paramView.getHitRect(localRect);
    localRect.inset(-paramInt, -paramInt);
    paramas.a(new at(localRect, paramView));
    AppMethodBeat.o(350441);
  }
  
  private static final void b(t paramt, j paramj, com.tencent.mm.view.recyclerview.j paramj1, View paramView)
  {
    AppMethodBeat.i(350485);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramt);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramj);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramj1);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramt, "$item");
    s.u(paramj, "this$0");
    s.u(paramj1, "$holder");
    paramView = paramt.ECu.getBizInfo();
    if (paramView == null) {}
    for (paramView = null;; paramView = ah.aiuX)
    {
      if (paramView == null)
      {
        paramView = d.AHD;
        paramView = paramt.ECu.getUsername();
        paramj1 = paramj1.context;
        s.s(paramj1, "holder.context");
        d.a(paramView, paramt, paramj1, paramj.AHK.getCommentScene());
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(350485);
      return;
      localObject1 = d.AHD;
      localObject2 = paramj1.context;
      s.s(localObject2, "holder.context");
      localObject1 = paramView.ADE;
      paramView = (View)localObject1;
      if (localObject1 == null) {
        paramView = "";
      }
      d.a((Context)localObject2, paramView, paramj.AHK.getCommentScene(), paramt, paramj.AHK.ebT());
    }
  }
  
  private static final void b(t paramt, com.tencent.mm.view.recyclerview.j paramj, View paramView)
  {
    AppMethodBeat.i(350454);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramt);
    localb.cH(paramj);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
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
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(350454);
  }
  
  private static final void b(com.tencent.mm.view.recyclerview.j paramj, String paramString, t paramt, View paramView)
  {
    AppMethodBeat.i(350469);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramj);
    localb.cH(paramString);
    localb.cH(paramt);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramj, "$holder");
    s.u(paramString, "$feedUser");
    s.u(paramt, "$item");
    paramView = av.GiL;
    av.a(paramj, paramString, paramt);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(350469);
  }
  
  private static final void c(t paramt, j paramj, com.tencent.mm.view.recyclerview.j paramj1, View paramView)
  {
    AppMethodBeat.i(350495);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramt);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramj);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramj1);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramt, "$item");
    s.u(paramj, "this$0");
    s.u(paramj1, "$holder");
    paramView = paramt.ECu.getBizInfo();
    if (paramView == null) {}
    for (paramView = null;; paramView = ah.aiuX)
    {
      if (paramView == null)
      {
        paramView = d.AHD;
        paramView = paramt.ECu.getUsername();
        paramj1 = paramj1.context;
        s.s(paramj1, "holder.context");
        d.a(paramView, paramt, paramj1, paramj.AHK.getCommentScene());
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(350495);
      return;
      localObject1 = d.AHD;
      localObject2 = paramj1.context;
      s.s(localObject2, "holder.context");
      localObject1 = paramView.ADE;
      paramView = (View)localObject1;
      if (localObject1 == null) {
        paramView = "";
      }
      d.a((Context)localObject2, paramView, paramj.AHK.getCommentScene(), paramt, paramj.AHK.ebT());
    }
  }
  
  private final boolean dXw()
  {
    AppMethodBeat.i(165325);
    if (this.AHK.ebS() == 2)
    {
      AppMethodBeat.o(165325);
      return true;
    }
    AppMethodBeat.o(165325);
    return false;
  }
  
  public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.j paramj, int paramInt)
  {
    AppMethodBeat.i(350624);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    View localView = paramj.UH(e.e.feed_comment_layout);
    paramRecyclerView = new com.tencent.mm.ui.as(localView);
    localView.setTouchDelegate((TouchDelegate)paramRecyclerView);
    paramInt = com.tencent.mm.cd.a.bs(paramj.context, e.c.Edge_2A);
    localView = paramj.UH(e.e.comment_more_iv);
    if (localView != null) {
      localView.post(new j..ExternalSyntheticLambda12(localView, paramInt, paramRecyclerView));
    }
    localView = paramj.UH(e.e.awesome_iv);
    if (localView != null) {
      localView.post(new j..ExternalSyntheticLambda11(localView, paramInt, paramRecyclerView));
    }
    ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).i(paramj.UH(e.e.awesome_iv), "finder_feed_first_comment_awesome_iv");
    paramRecyclerView = (FinderCollapsibleTextView)paramj.UH(e.e.reply_comment_content);
    paramRecyclerView.setLimitLine(2);
    paramRecyclerView.setCollapse(true);
    paramRecyclerView.uT(false);
    paramRecyclerView.setOnCollapse((kotlin.g.a.b)new c(paramj));
    paramRecyclerView.setTextColor(paramj.context.getResources().getColor(e.b.BW_0_Alpha_0_3));
    paramRecyclerView = (FinderCollapsibleTextView)paramj.UH(e.e.commend_content);
    paramRecyclerView.setLimitLine(4);
    paramRecyclerView.setCollapse(true);
    paramRecyclerView.uT(false);
    paramRecyclerView.setOnCollapse((kotlin.g.a.b)new d(paramj));
    AppMethodBeat.o(350624);
  }
  
  public final int getLayoutId()
  {
    return e.f._feed_comment_item;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "collapse", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    c(com.tencent.mm.view.recyclerview.j paramj)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "collapse", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    d(com.tencent.mm.view.recyclerview.j paramj)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.j
 * JD-Core Version:    0.7.0.1
 */