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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/view/adapter/LiveShareRoomsAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/live/view/adapter/LiveShareRoomsAdapter$LiveShareRoomsItemHolder;", "()V", "itemClickListener", "Lkotlin/Function0;", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function0;", "setItemClickListener", "(Lkotlin/jvm/functions/Function0;)V", "lastSelectedList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getLastSelectedList", "()Ljava/util/ArrayList;", "roomsList", "Lcom/tencent/mm/live/view/adapter/ShareRoomItem;", "selectedList", "getSelectedList", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "type", "reset", "updateRooms", "rooms", "", "LiveShareRoomsItemHolder", "plugin-logic_release"})
public final class f
  extends RecyclerView.a<a>
{
  public final ArrayList<h> heR;
  final ArrayList<String> heS;
  public final ArrayList<String> heT;
  public d.g.a.a<z> heU;
  
  public f()
  {
    AppMethodBeat.i(216707);
    this.heR = new ArrayList();
    this.heS = new ArrayList();
    this.heT = new ArrayList();
    AppMethodBeat.o(216707);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(216705);
    int i = this.heR.size();
    AppMethodBeat.o(216705);
    return i;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/view/adapter/LiveShareRoomsAdapter$LiveShareRoomsItemHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "avatarIcon", "Landroid/widget/ImageView;", "getAvatarIcon", "()Landroid/widget/ImageView;", "countTv", "Landroid/widget/TextView;", "getCountTv", "()Landroid/widget/TextView;", "selectIcon", "getSelectIcon", "usernameTv", "getUsernameTv", "plugin-logic_release"})
  public static final class a
    extends RecyclerView.w
  {
    final ImageView gZO;
    final ImageView heH;
    final TextView heI;
    final TextView heV;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(216702);
      View localView = paramView.findViewById(2131307780);
      p.g(localView, "itemView.findViewById(R.…hare_rooms_item_selector)");
      this.gZO = ((ImageView)localView);
      localView = paramView.findViewById(2131307778);
      p.g(localView, "itemView.findViewById(R.…e_rooms_item_avatar_icon)");
      this.heH = ((ImageView)localView);
      localView = paramView.findViewById(2131307781);
      p.g(localView, "itemView.findViewById(R.…e_rooms_item_username_tv)");
      this.heI = ((TextView)localView);
      paramView = paramView.findViewById(2131307779);
      p.g(paramView, "itemView.findViewById(R.…hare_rooms_item_count_tv)");
      this.heV = ((TextView)paramView);
      AppMethodBeat.o(216702);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(f paramf, int paramInt, f.a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(216703);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/view/adapter/LiveShareRoomsAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      paramView = ((h)f.a(this.heW).get(this.gke)).username;
      if (!this.heW.heS.contains(paramView))
      {
        if (!this.heW.heT.contains(paramView)) {
          break label143;
        }
        this.heW.heT.remove(paramView);
        this.heX.gZO.setActivated(false);
      }
      for (;;)
      {
        paramView = this.heW.heU;
        if (paramView != null) {
          paramView.invoke();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/view/adapter/LiveShareRoomsAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(216703);
        return;
        label143:
        this.heW.heT.add(paramView);
        this.heX.gZO.setActivated(true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.view.a.f
 * JD-Core Version:    0.7.0.1
 */