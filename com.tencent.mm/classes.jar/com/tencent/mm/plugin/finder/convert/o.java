package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.g;
import com.tencent.mm.plugin.finder.model.w;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.protocal.protobuf.bco;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedFriendLikeConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLike;", "feedId", "", "(J)V", "TAG", "", "getFeedId", "()J", "onBlackClickListener", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "", "getOnBlackClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnBlackClickListener", "(Lkotlin/jvm/functions/Function1;)V", "onLikeClickListener", "getOnLikeClickListener", "setOnLikeClickListener", "unlikeToast", "Landroid/widget/Toast;", "cancelToast", "clickLike", "vh", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "likeInfo", "clickUnLike", "getLayoutId", "", "initLikeView", "contact", "initUnLikeView", "onBindViewHolder", "holder", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "setLikeGray", "setLikeRed", "setUnLikeBlack", "needToast", "setUnLikeGray", "showCenterToast", "context", "Landroid/content/Context;", "text", "resource", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
  extends f<w>
{
  public kotlin.g.a.b<? super bco, ah> AIb;
  public kotlin.g.a.b<? super bco, ah> AIc;
  private Toast AId;
  final String TAG;
  private final long feedId;
  
  public o(long paramLong)
  {
    this.feedId = paramLong;
    this.TAG = "Finder.FinderFeedFriendLikeConvert";
  }
  
  private static final void a(o paramo, j paramj, bco parambco, View paramView)
  {
    AppMethodBeat.i(350425);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramo);
    localb.cH(paramj);
    localb.cH(parambco);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedFriendLikeConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramo, "this$0");
    s.u(paramj, "$holder");
    s.u(parambco, "$likedUser");
    s.u(paramj, "vh");
    s.u(parambco, "likeInfo");
    if (parambco.ZNz == 1) {
      paramo.c(paramj);
    }
    for (;;)
    {
      parambco.ZNz = ((parambco.ZNz + 1) % 2);
      paramo = paramo.AIc;
      if (paramo != null) {
        paramo.invoke(parambco);
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedFriendLikeConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(350425);
      return;
      b(paramj);
    }
  }
  
  private static final void a(bco parambco, j paramj, o paramo, w paramw, View paramView)
  {
    AppMethodBeat.i(350436);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parambco);
    localb.cH(paramj);
    localb.cH(paramo);
    localb.cH(paramw);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedFriendLikeConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parambco, "$likedUser");
    s.u(paramj, "$holder");
    s.u(paramo, "this$0");
    s.u(paramw, "$item");
    paramView = av.GiL;
    if (!av.isFriend(parambco.hLv))
    {
      paramView = av.GiL;
      if (!av.aBI(parambco.hLv)) {}
    }
    else
    {
      paramView = com.tencent.mm.plugin.finder.utils.a.GfO;
      paramView = parambco.hLv;
      localObject = paramj.context;
      s.s(localObject, "holder.context");
      com.tencent.mm.plugin.finder.utils.a.e(paramView, (Context)localObject);
      paramView = as.GSQ;
      paramView = paramj.context;
      s.s(paramView, "holder.context");
      paramView = as.a.hu(paramView);
      if (paramView != null)
      {
        localObject = z.FrZ;
        z.a(paramView.fou(), paramo.feedId, 6, parambco.hLv);
      }
      parambco = as.GSQ;
      parambco = paramj.context;
      s.s(parambco, "holder.context");
      parambco = as.a.hu(parambco);
      if (parambco != null) {
        break label283;
      }
    }
    label283:
    for (int i = 0;; i = parambco.AJo)
    {
      parambco = z.FrZ;
      z.a(2, paramo.feedId, i, 2, paramw.ECH.hLv);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedFriendLikeConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(350436);
      return;
    }
  }
  
  private static void b(j paramj)
  {
    AppMethodBeat.i(350412);
    s.u(paramj, "holder");
    ((WeImageView)paramj.UH(e.e.finder_unliked_iv)).setImageResource(e.g.icons_outlined_eyes_off);
    ((WeImageView)paramj.UH(e.e.finder_unliked_iv)).setIconColor(paramj.context.getResources().getColor(e.b.Red_100));
    AppMethodBeat.o(350412);
  }
  
  private void c(j paramj)
  {
    AppMethodBeat.i(350420);
    s.u(paramj, "holder");
    ((WeImageView)paramj.UH(e.e.finder_unliked_iv)).setImageResource(e.g.icons_outlined_eyes_on);
    ((WeImageView)paramj.UH(e.e.finder_unliked_iv)).setIconColor(paramj.context.getResources().getColor(e.b.FG_1));
    paramj = this.AId;
    if (paramj != null) {
      paramj.cancel();
    }
    this.AId = null;
    AppMethodBeat.o(350420);
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(350459);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    AppMethodBeat.o(350459);
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_liked_list_item_layout;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.o
 * JD-Core Version:    0.7.0.1
 */