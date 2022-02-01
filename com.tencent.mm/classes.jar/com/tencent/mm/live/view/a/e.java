package com.tencent.mm.live.view.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.live.b.e;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/view/adapter/LiveShareRoomsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/live/view/adapter/LiveShareRoomsAdapter$LiveShareRoomsItemHolder;", "()V", "itemClickListener", "Lkotlin/Function0;", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function0;", "setItemClickListener", "(Lkotlin/jvm/functions/Function0;)V", "lastSelectedList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getLastSelectedList", "()Ljava/util/ArrayList;", "roomsList", "Lcom/tencent/mm/live/view/adapter/ShareRoomItem;", "selectedList", "getSelectedList", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "type", "reset", "updateRooms", "rooms", "", "LiveShareRoomsItemHolder", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends RecyclerView.a<a>
{
  public final ArrayList<g> noe;
  private final ArrayList<String> nof;
  public final ArrayList<String> nog;
  public kotlin.g.a.a<ah> noh;
  
  public e()
  {
    AppMethodBeat.i(246203);
    this.noe = new ArrayList();
    this.nof = new ArrayList();
    this.nog = new ArrayList();
    AppMethodBeat.o(246203);
  }
  
  private static final void a(e parame, int paramInt, a parama, View paramView)
  {
    AppMethodBeat.i(246213);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(parame);
    localb.sc(paramInt);
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/view/adapter/LiveShareRoomsAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parame, "this$0");
    s.u(parama, "$holder");
    paramView = ((g)parame.noe.get(paramInt)).username;
    if (!parame.nof.contains(paramView))
    {
      if (!parame.nog.contains(paramView)) {
        break label171;
      }
      parame.nog.remove(paramView);
      parama.njX.setActivated(false);
    }
    for (;;)
    {
      parame = parame.noh;
      if (parame != null) {
        parame.invoke();
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/view/adapter/LiveShareRoomsAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(246213);
      return;
      label171:
      parame.nog.add(paramView);
      parama.njX.setActivated(true);
    }
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(246232);
    int i = this.noe.size();
    AppMethodBeat.o(246232);
    return i;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/live/view/adapter/LiveShareRoomsAdapter$LiveShareRoomsItemHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "avatarIcon", "Landroid/widget/ImageView;", "getAvatarIcon", "()Landroid/widget/ImageView;", "countTv", "Landroid/widget/TextView;", "getCountTv", "()Landroid/widget/TextView;", "selectIcon", "getSelectIcon", "usernameTv", "getUsernameTv", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends RecyclerView.v
  {
    final ImageView njX;
    final ImageView nnV;
    final TextView nnW;
    final TextView noi;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(246194);
      View localView = paramView.findViewById(b.e.live_share_rooms_item_selector);
      s.s(localView, "itemView.findViewById(R.…hare_rooms_item_selector)");
      this.njX = ((ImageView)localView);
      localView = paramView.findViewById(b.e.live_share_rooms_item_avatar_icon);
      s.s(localView, "itemView.findViewById(R.…e_rooms_item_avatar_icon)");
      this.nnV = ((ImageView)localView);
      localView = paramView.findViewById(b.e.live_share_rooms_item_username_tv);
      s.s(localView, "itemView.findViewById(R.…e_rooms_item_username_tv)");
      this.nnW = ((TextView)localView);
      paramView = paramView.findViewById(b.e.live_share_rooms_item_count_tv);
      s.s(paramView, "itemView.findViewById(R.…hare_rooms_item_count_tv)");
      this.noi = ((TextView)paramView);
      AppMethodBeat.o(246194);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.live.view.a.e
 * JD-Core Version:    0.7.0.1
 */