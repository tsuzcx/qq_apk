package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.model.v;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.protocal.protobuf.awr;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.i;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedFriendLikeConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLike;", "feedId", "", "(J)V", "TAG", "", "getFeedId", "()J", "onBlackClickListener", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "", "getOnBlackClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnBlackClickListener", "(Lkotlin/jvm/functions/Function1;)V", "onLikeClickListener", "getOnLikeClickListener", "setOnLikeClickListener", "unlikeToast", "Landroid/widget/Toast;", "cancelToast", "clickLike", "vh", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "likeInfo", "clickUnLike", "getLayoutId", "", "initLikeView", "contact", "initUnLikeView", "onBindViewHolder", "holder", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "setLikeGray", "setLikeRed", "setUnLikeBlack", "needToast", "setUnLikeGray", "showCenterToast", "context", "Landroid/content/Context;", "text", "resource", "plugin-finder_release"})
public final class o
  extends e<v>
{
  final String TAG;
  final long feedId;
  public kotlin.g.a.b<? super awr, x> xjj;
  public kotlin.g.a.b<? super awr, x> xjk;
  private Toast xjl;
  
  public o(long paramLong)
  {
    this.feedId = paramLong;
    this.TAG = "Finder.FinderFeedFriendLikeConvert";
  }
  
  private final void dpt()
  {
    AppMethodBeat.i(224253);
    Toast localToast = this.xjl;
    if (localToast != null) {
      localToast.cancel();
    }
    this.xjl = null;
    AppMethodBeat.o(224253);
  }
  
  public static void e(i parami)
  {
    AppMethodBeat.i(224243);
    p.k(parami, "holder");
    ((WeImageView)parami.RD(b.f.finder_unliked_iv)).setImageResource(b.i.icons_outlined_eyes_off);
    WeImageView localWeImageView = (WeImageView)parami.RD(b.f.finder_unliked_iv);
    parami = parami.getContext();
    p.j(parami, "holder.context");
    localWeImageView.setIconColor(parami.getResources().getColor(b.c.Red_100));
    AppMethodBeat.o(224243);
  }
  
  public final void a(RecyclerView paramRecyclerView, i parami, int paramInt)
  {
    AppMethodBeat.i(224228);
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    AppMethodBeat.o(224228);
  }
  
  public final void f(i parami)
  {
    AppMethodBeat.i(224248);
    p.k(parami, "holder");
    ((WeImageView)parami.RD(b.f.finder_unliked_iv)).setImageResource(b.i.icons_outlined_eyes_on);
    WeImageView localWeImageView = (WeImageView)parami.RD(b.f.finder_unliked_iv);
    parami = parami.getContext();
    p.j(parami, "holder.context");
    localWeImageView.setIconColor(parami.getResources().getColor(b.c.FG_1));
    dpt();
    AppMethodBeat.o(224248);
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_liked_list_item_layout;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(o paramo, i parami, awr paramawr) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(287543);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedFriendLikeConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      localObject = this.xjm;
      i locali = this.tDl;
      paramView = this.xjn;
      p.k(locali, "vh");
      p.k(paramView, "likeInfo");
      if (paramView.SJo == 1) {
        ((o)localObject).f(locali);
      }
      for (;;)
      {
        paramView.SJo = ((paramView.SJo + 1) % 2);
        localObject = ((o)localObject).xjk;
        if (localObject != null) {
          ((kotlin.g.a.b)localObject).invoke(paramView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedFriendLikeConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(287543);
        return;
        o.e(locali);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(o paramo, awr paramawr, i parami, v paramv) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(282898);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedFriendLikeConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      paramView = com.tencent.mm.plugin.finder.utils.aj.AGc;
      if (!com.tencent.mm.plugin.finder.utils.aj.isFriend(this.xjn.fGe))
      {
        paramView = com.tencent.mm.plugin.finder.utils.aj.AGc;
        if (!com.tencent.mm.plugin.finder.utils.aj.aFJ(this.xjn.fGe)) {}
      }
      else
      {
        paramView = com.tencent.mm.plugin.finder.utils.a.ACH;
        paramView = this.xjn.fGe;
        localObject = this.tDl.getContext();
        p.j(localObject, "holder.context");
        com.tencent.mm.plugin.finder.utils.a.e(paramView, (Context)localObject);
        paramView = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
        paramView = this.tDl.getContext();
        p.j(paramView, "holder.context");
        paramView = aj.a.fZ(paramView);
        if (paramView != null)
        {
          localObject = n.zWF;
          n.a(paramView.ekY(), this.xjm.feedId, 6, this.xjn.fGe);
        }
        paramView = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
        paramView = this.tDl.getContext();
        p.j(paramView, "holder.context");
        paramView = aj.a.fZ(paramView);
        if (paramView == null) {
          break label230;
        }
      }
      label230:
      for (int i = paramView.xkX;; i = 0)
      {
        paramView = n.zWF;
        n.a(2, this.xjm.feedId, i, 2, this.xjo.zAz.fGe);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedFriendLikeConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(282898);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.o
 * JD-Core Version:    0.7.0.1
 */