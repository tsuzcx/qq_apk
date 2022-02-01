package com.tencent.mm.live.view.a;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/view/adapter/LiveShareRoomsAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/live/view/adapter/LiveShareRoomsAdapter$LiveShareRoomsItemHolder;", "()V", "itemClickListener", "Lkotlin/Function0;", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function0;", "setItemClickListener", "(Lkotlin/jvm/functions/Function0;)V", "lastSelectedList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getLastSelectedList", "()Ljava/util/ArrayList;", "roomsList", "Lcom/tencent/mm/live/view/adapter/ShareRoomItem;", "selectedList", "getSelectedList", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "type", "reset", "updateRooms", "rooms", "", "LiveShareRoomsItemHolder", "plugin-logic_release"})
public final class f
  extends RecyclerView.a<a>
{
  public final ArrayList<h> hXG;
  final ArrayList<String> hXH;
  public final ArrayList<String> hXI;
  public kotlin.g.a.a<x> hXJ;
  
  public f()
  {
    AppMethodBeat.i(208681);
    this.hXG = new ArrayList();
    this.hXH = new ArrayList();
    this.hXI = new ArrayList();
    AppMethodBeat.o(208681);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(208679);
    int i = this.hXG.size();
    AppMethodBeat.o(208679);
    return i;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/view/adapter/LiveShareRoomsAdapter$LiveShareRoomsItemHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "avatarIcon", "Landroid/widget/ImageView;", "getAvatarIcon", "()Landroid/widget/ImageView;", "countTv", "Landroid/widget/TextView;", "getCountTv", "()Landroid/widget/TextView;", "selectIcon", "getSelectIcon", "usernameTv", "getUsernameTv", "plugin-logic_release"})
  public static final class a
    extends RecyclerView.v
  {
    final ImageView hSH;
    final TextView hXK;
    final ImageView hXu;
    final TextView hXv;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(208676);
      View localView = paramView.findViewById(2131303567);
      p.g(localView, "itemView.findViewById(R.…hare_rooms_item_selector)");
      this.hSH = ((ImageView)localView);
      localView = paramView.findViewById(2131303565);
      p.g(localView, "itemView.findViewById(R.…e_rooms_item_avatar_icon)");
      this.hXu = ((ImageView)localView);
      localView = paramView.findViewById(2131303568);
      p.g(localView, "itemView.findViewById(R.…e_rooms_item_username_tv)");
      this.hXv = ((TextView)localView);
      paramView = paramView.findViewById(2131303566);
      p.g(paramView, "itemView.findViewById(R.…hare_rooms_item_count_tv)");
      this.hXK = ((TextView)paramView);
      AppMethodBeat.o(208676);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(f paramf, int paramInt, f.a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(208677);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/view/adapter/LiveShareRoomsAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = ((h)f.a(this.hXL).get(this.gUj)).username;
      if (!this.hXL.hXH.contains(paramView))
      {
        if (!this.hXL.hXI.contains(paramView)) {
          break label143;
        }
        this.hXL.hXI.remove(paramView);
        this.hXM.hSH.setActivated(false);
      }
      for (;;)
      {
        paramView = this.hXL.hXJ;
        if (paramView != null) {
          paramView.invoke();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/view/adapter/LiveShareRoomsAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(208677);
        return;
        label143:
        this.hXL.hXI.add(paramView);
        this.hXM.hSH.setActivated(true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.view.a.f
 * JD-Core Version:    0.7.0.1
 */