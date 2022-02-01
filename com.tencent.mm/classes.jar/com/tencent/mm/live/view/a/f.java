package com.tencent.mm.live.view.a;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import d.g.b.k;
import d.l;
import d.y;
import java.util.ArrayList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/view/adapter/LiveShareRoomsAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/live/view/adapter/LiveShareRoomsAdapter$LiveShareRoomsItemHolder;", "()V", "itemClickListener", "Lkotlin/Function0;", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function0;", "setItemClickListener", "(Lkotlin/jvm/functions/Function0;)V", "lastSelectedList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getLastSelectedList", "()Ljava/util/ArrayList;", "roomsList", "Lcom/tencent/mm/live/view/adapter/ShareRoomItem;", "selectedList", "getSelectedList", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "type", "reset", "updateRooms", "rooms", "", "LiveShareRoomsItemHolder", "plugin-logic_release"})
public final class f
  extends RecyclerView.a<a>
{
  final ArrayList<String> KBA;
  public final ArrayList<h> KBz;
  public final ArrayList<String> rDa;
  public a<y> ytV;
  
  public f()
  {
    AppMethodBeat.i(203548);
    this.KBz = new ArrayList();
    this.KBA = new ArrayList();
    this.rDa = new ArrayList();
    AppMethodBeat.o(203548);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(203546);
    int i = this.KBz.size();
    AppMethodBeat.o(203546);
    return i;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/view/adapter/LiveShareRoomsAdapter$LiveShareRoomsItemHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "avatarIcon", "Landroid/widget/ImageView;", "getAvatarIcon", "()Landroid/widget/ImageView;", "countTv", "Landroid/widget/TextView;", "getCountTv", "()Landroid/widget/TextView;", "selectIcon", "getSelectIcon", "usernameTv", "getUsernameTv", "plugin-logic_release"})
  public static final class a
    extends RecyclerView.v
  {
    final ImageView KBu;
    final ImageView KwW;
    final TextView icz;
    final TextView sIt;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(203543);
      View localView = paramView.findViewById(2131307699);
      k.g(localView, "itemView.findViewById(R.…hare_rooms_item_selector)");
      this.KwW = ((ImageView)localView);
      localView = paramView.findViewById(2131307697);
      k.g(localView, "itemView.findViewById(R.…e_rooms_item_avatar_icon)");
      this.KBu = ((ImageView)localView);
      localView = paramView.findViewById(2131307700);
      k.g(localView, "itemView.findViewById(R.…e_rooms_item_username_tv)");
      this.icz = ((TextView)localView);
      paramView = paramView.findViewById(2131307698);
      k.g(paramView, "itemView.findViewById(R.…hare_rooms_item_count_tv)");
      this.sIt = ((TextView)paramView);
      AppMethodBeat.o(203543);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(f paramf, int paramInt, f.a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(203544);
      paramView = ((h)f.a(this.KBB).get(this.fKG)).username;
      if (!this.KBB.KBA.contains(paramView))
      {
        if (this.KBB.rDa.contains(paramView))
        {
          this.KBB.rDa.remove(paramView);
          this.KBC.KwW.setActivated(false);
        }
        for (;;)
        {
          paramView = this.KBB.ytV;
          if (paramView == null) {
            break;
          }
          paramView.invoke();
          AppMethodBeat.o(203544);
          return;
          this.KBB.rDa.add(paramView);
          this.KBC.KwW.setActivated(true);
        }
      }
      AppMethodBeat.o(203544);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.view.a.f
 * JD-Core Version:    0.7.0.1
 */