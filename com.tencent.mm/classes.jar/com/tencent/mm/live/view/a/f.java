package com.tencent.mm.live.view.a;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import d.g.b.p;
import d.l;
import d.z;
import java.util.ArrayList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/view/adapter/LiveShareRoomsAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/live/view/adapter/LiveShareRoomsAdapter$LiveShareRoomsItemHolder;", "()V", "itemClickListener", "Lkotlin/Function0;", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function0;", "setItemClickListener", "(Lkotlin/jvm/functions/Function0;)V", "lastSelectedList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getLastSelectedList", "()Ljava/util/ArrayList;", "roomsList", "Lcom/tencent/mm/live/view/adapter/ShareRoomItem;", "selectedList", "getSelectedList", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "type", "reset", "updateRooms", "rooms", "", "LiveShareRoomsItemHolder", "plugin-logic_release"})
public final class f
  extends RecyclerView.a<a>
{
  public final ArrayList<h> hcd;
  final ArrayList<String> hce;
  public final ArrayList<String> hcf;
  public d.g.a.a<z> hcg;
  
  public f()
  {
    AppMethodBeat.i(213077);
    this.hcd = new ArrayList();
    this.hce = new ArrayList();
    this.hcf = new ArrayList();
    AppMethodBeat.o(213077);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(213075);
    int i = this.hcd.size();
    AppMethodBeat.o(213075);
    return i;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/view/adapter/LiveShareRoomsAdapter$LiveShareRoomsItemHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "avatarIcon", "Landroid/widget/ImageView;", "getAvatarIcon", "()Landroid/widget/ImageView;", "countTv", "Landroid/widget/TextView;", "getCountTv", "()Landroid/widget/TextView;", "selectIcon", "getSelectIcon", "usernameTv", "getUsernameTv", "plugin-logic_release"})
  public static final class a
    extends RecyclerView.w
  {
    final ImageView gXb;
    final ImageView hbT;
    final TextView hbU;
    final TextView hch;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(213072);
      View localView = paramView.findViewById(2131307780);
      p.g(localView, "itemView.findViewById(R.…hare_rooms_item_selector)");
      this.gXb = ((ImageView)localView);
      localView = paramView.findViewById(2131307778);
      p.g(localView, "itemView.findViewById(R.…e_rooms_item_avatar_icon)");
      this.hbT = ((ImageView)localView);
      localView = paramView.findViewById(2131307781);
      p.g(localView, "itemView.findViewById(R.…e_rooms_item_username_tv)");
      this.hbU = ((TextView)localView);
      paramView = paramView.findViewById(2131307779);
      p.g(paramView, "itemView.findViewById(R.…hare_rooms_item_count_tv)");
      this.hch = ((TextView)paramView);
      AppMethodBeat.o(213072);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(f paramf, int paramInt, f.a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(213073);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/view/adapter/LiveShareRoomsAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      paramView = ((h)f.a(this.hci).get(this.ghM)).username;
      if (!this.hci.hce.contains(paramView))
      {
        if (!this.hci.hcf.contains(paramView)) {
          break label143;
        }
        this.hci.hcf.remove(paramView);
        this.hcj.gXb.setActivated(false);
      }
      for (;;)
      {
        paramView = this.hci.hcg;
        if (paramView != null) {
          paramView.invoke();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/view/adapter/LiveShareRoomsAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(213073);
        return;
        label143:
        this.hci.hcf.add(paramView);
        this.hcj.gXb.setActivated(true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.view.a.f
 * JD-Core Version:    0.7.0.1
 */