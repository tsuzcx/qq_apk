package com.tencent.mm.plugin.finder.post;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.publish.l.e;
import com.tencent.mm.plugin.finder.upload.postui.e;
import com.tencent.mm.plugin.finder.upload.postui.i;
import com.tencent.mm.plugin.finder.upload.postui.j;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.view.FinderEmojiChooseView;
import com.tencent.mm.plugin.finder.view.FinderExtendReadingView;
import com.tencent.mm.plugin.finder.view.FinderTencentVideoChooseView;
import com.tencent.mm.protocal.protobuf.FinderJumpInfo;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.an;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/post/PostExtendLinkUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "emojiWidget", "Lcom/tencent/mm/plugin/finder/upload/postui/FinderEmojiWidget;", "extendLinkLayout", "Landroid/view/View;", "linkWidget", "Lcom/tencent/mm/plugin/finder/upload/postui/FinderExtendLinkWidget;", "onClickBizListener", "Lkotlin/Function0;", "", "onClickEmojiListener", "onClickGoodsListener", "onClickRepackListener", "onClickTencentVideoListener", "tencentVideoWidget", "Lcom/tencent/mm/plugin/finder/upload/postui/FinderTencentVideoWidget;", "checkGoodsVisible", "getEmojiData", "Lcom/tencent/mm/protocal/protobuf/FinderJumpInfo;", "getJumpInfoList", "Ljava/util/LinkedList;", "isSave", "", "getTencentVideoWidget", "gotoStore", "hideLinkView", "initViews", "view", "onDeleteTencentVideo", "onSelectEmoji", "resultCode", "", "data", "Landroid/content/Intent;", "onSelectItem", "isSelected", "onSelectTencentVideo", "title", "", "link", "style", "html5Style", "optionalInfo", "postJumpInfoUIC", "Lcom/tencent/mm/plugin/finder/post/PostJumpInfoUIC;", "report21875", "isClick", "hasProduct", "reset", "restore", "setListener", "showLinkView", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends UIComponent
{
  private View ETf;
  com.tencent.mm.plugin.finder.upload.postui.d ETg;
  i ETh;
  private e ETi;
  public kotlin.g.a.a<ah> ETj;
  public kotlin.g.a.a<ah> ETk;
  public kotlin.g.a.a<ah> ETl;
  public kotlin.g.a.a<ah> ETm;
  public kotlin.g.a.a<ah> ETn;
  
  public c(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(349423);
    AppMethodBeat.o(349423);
  }
  
  private static final void a(c paramc, View paramView)
  {
    AppMethodBeat.i(349474);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramc);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/post/PostExtendLinkUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramc, "this$0");
    paramc = paramc.ETj;
    if (paramc != null) {
      paramc.invoke();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/post/PostExtendLinkUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(349474);
  }
  
  private static final void b(c paramc, View paramView)
  {
    AppMethodBeat.i(349486);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramc);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/post/PostExtendLinkUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramc, "this$0");
    paramc = paramc.ETk;
    if (paramc != null) {
      paramc.invoke();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/post/PostExtendLinkUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(349486);
  }
  
  private static final void c(c paramc, View paramView)
  {
    AppMethodBeat.i(349501);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramc);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/post/PostExtendLinkUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramc, "this$0");
    paramc = paramc.ETn;
    if (paramc != null) {
      paramc.invoke();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/post/PostExtendLinkUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(349501);
  }
  
  private static final void d(c paramc, View paramView)
  {
    AppMethodBeat.i(349516);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramc);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/post/PostExtendLinkUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramc, "this$0");
    paramc = paramc.ETl;
    if (paramc != null) {
      paramc.invoke();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/post/PostExtendLinkUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(349516);
  }
  
  private static final void e(c paramc, View paramView)
  {
    AppMethodBeat.i(349528);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramc);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/post/PostExtendLinkUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramc, "this$0");
    paramc.sX(true);
    paramView = paramc.eHg().ETq;
    if ((paramView != null) && ((paramView instanceof com.tencent.mm.plugin.finder.upload.postui.b)) && (((com.tencent.mm.plugin.finder.upload.postui.b)paramView).feE())) {
      ((com.tencent.mm.plugin.finder.upload.postui.b)paramView).feD();
    }
    paramc = paramc.ETm;
    if (paramc != null) {
      paramc.invoke();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/post/PostExtendLinkUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(349528);
  }
  
  private void eHh()
  {
    AppMethodBeat.i(349440);
    Object localObject = eHg().ETq;
    if ((localObject != null) && ((localObject instanceof com.tencent.mm.plugin.finder.upload.postui.b)) && (((com.tencent.mm.plugin.finder.upload.postui.b)localObject).feE()))
    {
      localObject = this.ETf;
      if (localObject != null) {
        break label81;
      }
    }
    label81:
    for (localObject = null;; localObject = ((View)localObject).findViewById(l.e.rl_extend_goods))
    {
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      sX(false);
      if (localObject != null) {
        ((View)localObject).setOnClickListener(new c..ExternalSyntheticLambda3(this));
      }
      AppMethodBeat.o(349440);
      return;
    }
  }
  
  private final void sX(boolean paramBoolean)
  {
    AppMethodBeat.i(349458);
    String str3 = ((com.tencent.mm.plugin.expt.b.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHN();
    String str2 = getActivity().getIntent().getStringExtra("key_context_id");
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    long l = System.currentTimeMillis();
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.plugin.report.service.h.OAn.b(21875, new Object[] { str3, str1, Integer.valueOf(74), Integer.valueOf(i), String.valueOf(l), "post_good_icon", "{\"if_have_good\":2}" });
      AppMethodBeat.o(349458);
      return;
    }
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(349605);
    s.u(parame, "linkWidget");
    this.ETi = parame;
    parame = getActivity();
    View localView = getActivity().findViewById(l.e.choose_emoji_view);
    s.s(localView, "activity.findViewById(R.id.choose_emoji_view)");
    this.ETg = new com.tencent.mm.plugin.finder.upload.postui.d(parame, (FinderEmojiChooseView)localView);
    parame = eHg();
    parame.ETr = ((kotlin.g.a.b)new c(this));
    parame.restore();
    eHh();
    AppMethodBeat.o(349605);
  }
  
  final d eHg()
  {
    AppMethodBeat.i(349584);
    Object localObject = k.aeZF;
    localObject = k.d(getActivity()).q(d.class);
    s.s(localObject, "UICProvider.of(activity)…tJumpInfoUIC::class.java)");
    localObject = (d)localObject;
    AppMethodBeat.o(349584);
    return localObject;
  }
  
  public final void eHi()
  {
    AppMethodBeat.i(349620);
    Object localObject = this.ETi;
    if (localObject != null)
    {
      localObject = ((e)localObject).Gfv;
      if (localObject != null) {
        ((FinderExtendReadingView)localObject).fkx();
      }
    }
    localObject = this.ETi;
    if (localObject != null) {
      ((e)localObject).bU("", true);
    }
    localObject = this.ETi;
    if (localObject != null) {
      ((e)localObject).aa("", "", 2);
    }
    eHj();
    AppMethodBeat.o(349620);
  }
  
  public final void eHj()
  {
    AppMethodBeat.i(349660);
    Object localObject = this.ETi;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((e)localObject).Gfv)
    {
      if (localObject != null) {
        ((FinderExtendReadingView)localObject).setVisibility(0);
      }
      AppMethodBeat.o(349660);
      return;
    }
  }
  
  public final void eHk()
  {
    AppMethodBeat.i(349672);
    Object localObject = this.ETi;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((e)localObject).Gfv)
    {
      if (localObject != null) {
        ((FinderExtendReadingView)localObject).setVisibility(8);
      }
      AppMethodBeat.o(349672);
      return;
    }
  }
  
  public final void gA(View paramView)
  {
    AppMethodBeat.i(349594);
    s.u(paramView, "view");
    this.ETf = paramView;
    paramView.findViewById(l.e.rl_extend_biz).setOnClickListener(new c..ExternalSyntheticLambda0(this));
    paramView.findViewById(l.e.rl_extend_redpack).setOnClickListener(new c..ExternalSyntheticLambda2(this));
    Object localObject = paramView.findViewById(l.e.rl_extend_tencent_video);
    av localav = av.GiL;
    if (!av.ffY()) {
      ((View)localObject).setVisibility(8);
    }
    ((View)localObject).setOnClickListener(new c..ExternalSyntheticLambda1(this));
    localObject = com.tencent.mm.plugin.finder.widget.post.d.Haf;
    if (com.tencent.mm.plugin.finder.widget.post.d.fqD())
    {
      paramView = paramView.findViewById(l.e.rl_extend_emoji);
      paramView.setVisibility(0);
      paramView.setOnClickListener(new c..ExternalSyntheticLambda4(this));
    }
    eHh();
    AppMethodBeat.o(349594);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(349633);
    eHi();
    Object localObject1 = this.ETi;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((e)localObject1).Gfy;
      if (localObject2 != null) {
        ((Bundle)localObject2).remove("post_extend_reading");
      }
      localObject2 = ((e)localObject1).intent;
      if (localObject2 != null) {
        ((Intent)localObject2).removeExtra("saveExtendReadingLink");
      }
      localObject2 = ((e)localObject1).intent;
      if (localObject2 != null) {
        ((Intent)localObject2).removeExtra("post_extend_reading");
      }
      localObject1 = ((e)localObject1).intent;
      if (localObject1 != null) {
        ((Intent)localObject1).removeExtra("post_extend_reading");
      }
    }
    localObject1 = this.ETi;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        ((FinderExtendReadingView)localObject1).setVisibility(8);
      }
      localObject1 = this.ETg;
      if (localObject1 != null) {
        break label233;
      }
      localObject1 = null;
      label115:
      if (localObject1 != null) {
        ((FinderEmojiChooseView)localObject1).setVisibility(8);
      }
      localObject2 = this.ETg;
      if (localObject2 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.upload.postui.d)localObject2).Gfq;
        if (!an.hC(localObject1)) {
          break label241;
        }
        label146:
        if (localObject1 != null) {
          ((List)localObject1).clear();
        }
        ((com.tencent.mm.plugin.finder.upload.postui.d)localObject2).Gfq = null;
      }
      localObject1 = this.ETh;
      if (localObject1 != null) {
        break label246;
      }
      localObject1 = null;
      label172:
      if (localObject1 != null) {
        ((FinderTencentVideoChooseView)localObject1).setVisibility(8);
      }
      localObject2 = this.ETh;
      if (localObject2 != null)
      {
        localObject1 = ((i)localObject2).GfM;
        if (!an.hC(localObject1)) {
          break label254;
        }
      }
    }
    for (;;)
    {
      if (localObject1 != null) {
        ((List)localObject1).clear();
      }
      ((i)localObject2).GfM = null;
      AppMethodBeat.o(349633);
      return;
      localObject1 = ((e)localObject1).Gfv;
      break;
      label233:
      localObject1 = ((com.tencent.mm.plugin.finder.upload.postui.d)localObject1).Gfr;
      break label115;
      label241:
      localObject1 = null;
      break label146;
      label246:
      localObject1 = ((i)localObject1).GfK;
      break label172;
      label254:
      localObject1 = null;
    }
  }
  
  public final LinkedList<FinderJumpInfo> sW(boolean paramBoolean)
  {
    AppMethodBeat.i(349650);
    LinkedList localLinkedList = new LinkedList();
    Object localObject = eHg().ETq;
    if (localObject == null)
    {
      localObject = null;
      if (localObject != null) {
        localLinkedList.addAll((Collection)localObject);
      }
      localObject = this.ETg;
      if (localObject != null) {
        break label84;
      }
      localObject = null;
    }
    for (;;)
    {
      if ((localObject != null) && (!paramBoolean)) {
        localLinkedList.add(localObject);
      }
      AppMethodBeat.o(349650);
      return localLinkedList;
      localObject = ((j)localObject).feF();
      break;
      label84:
      localObject = ((com.tencent.mm.plugin.finder.upload.postui.d)localObject).Gfq;
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = (FinderJumpInfo)p.oL((List)localObject);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "isSelected", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    c(c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.post.c
 * JD-Core Version:    0.7.0.1
 */