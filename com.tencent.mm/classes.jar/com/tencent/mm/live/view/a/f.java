package com.tencent.mm.live.view.a;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.live.b.e;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/view/adapter/LiveShareRoomsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/live/view/adapter/LiveShareRoomsAdapter$LiveShareRoomsItemHolder;", "()V", "itemClickListener", "Lkotlin/Function0;", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function0;", "setItemClickListener", "(Lkotlin/jvm/functions/Function0;)V", "lastSelectedList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getLastSelectedList", "()Ljava/util/ArrayList;", "roomsList", "Lcom/tencent/mm/live/view/adapter/ShareRoomItem;", "selectedList", "getSelectedList", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "type", "reset", "updateRooms", "rooms", "", "LiveShareRoomsItemHolder", "plugin-logic_release"})
public final class f
  extends RecyclerView.a<a>
{
  public final ArrayList<h> kMl;
  final ArrayList<String> kMm;
  public final ArrayList<String> kMn;
  public kotlin.g.a.a<x> kMo;
  
  public f()
  {
    AppMethodBeat.i(192313);
    this.kMl = new ArrayList();
    this.kMm = new ArrayList();
    this.kMn = new ArrayList();
    AppMethodBeat.o(192313);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(192293);
    int i = this.kMl.size();
    AppMethodBeat.o(192293);
    return i;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/view/adapter/LiveShareRoomsAdapter$LiveShareRoomsItemHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "avatarIcon", "Landroid/widget/ImageView;", "getAvatarIcon", "()Landroid/widget/ImageView;", "countTv", "Landroid/widget/TextView;", "getCountTv", "()Landroid/widget/TextView;", "selectIcon", "getSelectIcon", "usernameTv", "getUsernameTv", "plugin-logic_release"})
  public static final class a
    extends RecyclerView.v
  {
    final ImageView kHe;
    final ImageView kLZ;
    final TextView kMa;
    final TextView kMp;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(191082);
      View localView = paramView.findViewById(b.e.live_share_rooms_item_selector);
      p.j(localView, "itemView.findViewById(R.…hare_rooms_item_selector)");
      this.kHe = ((ImageView)localView);
      localView = paramView.findViewById(b.e.live_share_rooms_item_avatar_icon);
      p.j(localView, "itemView.findViewById(R.…e_rooms_item_avatar_icon)");
      this.kLZ = ((ImageView)localView);
      localView = paramView.findViewById(b.e.live_share_rooms_item_username_tv);
      p.j(localView, "itemView.findViewById(R.…e_rooms_item_username_tv)");
      this.kMa = ((TextView)localView);
      paramView = paramView.findViewById(b.e.live_share_rooms_item_count_tv);
      p.j(paramView, "itemView.findViewById(R.…hare_rooms_item_count_tv)");
      this.kMp = ((TextView)paramView);
      AppMethodBeat.o(191082);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(f paramf, int paramInt, f.a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(193795);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/view/adapter/LiveShareRoomsAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = ((h)f.a(this.kMq).get(this.jEN)).username;
      if (!this.kMq.kMm.contains(paramView))
      {
        if (!this.kMq.kMn.contains(paramView)) {
          break label143;
        }
        this.kMq.kMn.remove(paramView);
        this.kMr.kHe.setActivated(false);
      }
      for (;;)
      {
        paramView = this.kMq.kMo;
        if (paramView != null) {
          paramView.invoke();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/view/adapter/LiveShareRoomsAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(193795);
        return;
        label143:
        this.kMq.kMn.add(paramView);
        this.kMr.kHe.setActivated(true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.view.a.f
 * JD-Core Version:    0.7.0.1
 */