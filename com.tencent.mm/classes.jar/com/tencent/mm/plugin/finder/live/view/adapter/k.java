package com.tencent.mm.plugin.finder.live.view.adapter;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.live.model.aq;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveCommentAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveCommentAdapter$LiveCommentItemHolder;", "roomData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "TAG", "", "commentList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveMsg;", "Lkotlin/collections/ArrayList;", "getCommentList", "()Ljava/util/ArrayList;", "onItemClickListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "msg", "Landroid/view/View;", "view", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "getRoomData", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "setRoomData", "appendComment", "comment", "getItemCount", "", "needCustomAccessibilityContent", "", "type", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "removeComment", "updateComments", "", "reset", "LiveCommentItemHolder", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  extends RecyclerView.a<a>
{
  public m<? super aq, ? super View, ah> CyZ;
  private com.tencent.mm.plugin.finder.live.model.context.a DQs;
  private final String TAG;
  public final ArrayList<aq> nnY;
  
  public k(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    AppMethodBeat.i(358542);
    this.DQs = parama;
    this.TAG = "Finder.FinderLiveCommentAdapter";
    this.nnY = new ArrayList();
    AppMethodBeat.o(358542);
  }
  
  private static final void a(aq paramaq, k paramk, int paramInt, a parama, View paramView)
  {
    AppMethodBeat.i(358556);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramaq);
    localb.cH(paramk);
    localb.sc(paramInt);
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveCommentAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramk, "this$0");
    s.u(parama, "$holder");
    if (paramaq != null)
    {
      Log.i(paramk.TAG, "topComment,content:" + paramaq.getContent() + ",position:" + paramInt);
      paramk = paramk.CyZ;
      if (paramk != null)
      {
        parama = parama.caK;
        s.s(parama, "holder.itemView");
        paramk.invoke(paramaq, parama);
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveCommentAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(358556);
      return;
      Log.w(paramk.TAG, "OnClick IndexOutOfBounds! position:" + paramInt + " commentList.size:" + paramk.nnY.size() + " view:" + paramView);
    }
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(358579);
    int i = this.nnY.size();
    AppMethodBeat.o(358579);
    return i;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveCommentAdapter$LiveCommentItemHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "arrow", "getArrow", "()Landroid/view/View;", "bgView", "getBgView", "contentTv", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "getContentTv", "()Lcom/tencent/mm/ui/widget/MMNeat7extView;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends RecyclerView.v
  {
    public final View AhP;
    public final MMNeat7extView DQt;
    public final View DmL;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(359090);
      View localView = paramView.findViewById(p.e.live_comment_item_content_tv);
      s.s(localView, "itemView.findViewById(R.…_comment_item_content_tv)");
      this.DQt = ((MMNeat7extView)localView);
      localView = paramView.findViewById(p.e.BWA);
      s.s(localView, "itemView.findViewById(R.id.live_comment_container)");
      this.AhP = localView;
      paramView = paramView.findViewById(p.e.BWz);
      s.s(paramView, "itemView.findViewById(R.id.live_comment_arrow)");
      this.DmL = paramView;
      AppMethodBeat.o(359090);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.k
 * JD-Core Version:    0.7.0.1
 */