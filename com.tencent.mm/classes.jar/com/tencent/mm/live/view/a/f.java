package com.tencent.mm.live.view.a;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.w;
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

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/view/adapter/LiveShareRoomsAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/live/view/adapter/LiveShareRoomsAdapter$LiveShareRoomsItemHolder;", "()V", "itemClickListener", "Lkotlin/Function0;", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function0;", "setItemClickListener", "(Lkotlin/jvm/functions/Function0;)V", "lastSelectedList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getLastSelectedList", "()Ljava/util/ArrayList;", "roomsList", "Lcom/tencent/mm/live/view/adapter/ShareRoomItem;", "selectedList", "getSelectedList", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "type", "reset", "updateRooms", "rooms", "", "LiveShareRoomsItemHolder", "plugin-logic_release"})
public final class f
  extends RecyclerView.a<a>
{
  public final ArrayList<h> gIt;
  final ArrayList<String> gIu;
  public final ArrayList<String> gIv;
  public a<y> gIw;
  
  public f()
  {
    AppMethodBeat.i(190786);
    this.gIt = new ArrayList();
    this.gIu = new ArrayList();
    this.gIv = new ArrayList();
    AppMethodBeat.o(190786);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(190784);
    int i = this.gIt.size();
    AppMethodBeat.o(190784);
    return i;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/view/adapter/LiveShareRoomsAdapter$LiveShareRoomsItemHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "avatarIcon", "Landroid/widget/ImageView;", "getAvatarIcon", "()Landroid/widget/ImageView;", "countTv", "Landroid/widget/TextView;", "getCountTv", "()Landroid/widget/TextView;", "selectIcon", "getSelectIcon", "usernameTv", "getUsernameTv", "plugin-logic_release"})
  public static final class a
    extends RecyclerView.w
  {
    final ImageView gDr;
    final ImageView gIj;
    final TextView gIk;
    final TextView gIx;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(190781);
      View localView = paramView.findViewById(2131307780);
      k.g(localView, "itemView.findViewById(R.…hare_rooms_item_selector)");
      this.gDr = ((ImageView)localView);
      localView = paramView.findViewById(2131307778);
      k.g(localView, "itemView.findViewById(R.…e_rooms_item_avatar_icon)");
      this.gIj = ((ImageView)localView);
      localView = paramView.findViewById(2131307781);
      k.g(localView, "itemView.findViewById(R.…e_rooms_item_username_tv)");
      this.gIk = ((TextView)localView);
      paramView = paramView.findViewById(2131307779);
      k.g(paramView, "itemView.findViewById(R.…hare_rooms_item_count_tv)");
      this.gIx = ((TextView)paramView);
      AppMethodBeat.o(190781);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(f paramf, int paramInt, f.a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(190782);
      paramView = ((h)f.a(this.gIy).get(this.fOm)).username;
      if (!this.gIy.gIu.contains(paramView))
      {
        if (this.gIy.gIv.contains(paramView))
        {
          this.gIy.gIv.remove(paramView);
          this.gIz.gDr.setActivated(false);
        }
        for (;;)
        {
          paramView = this.gIy.gIw;
          if (paramView == null) {
            break;
          }
          paramView.invoke();
          AppMethodBeat.o(190782);
          return;
          this.gIy.gIv.add(paramView);
          this.gIz.gDr.setActivated(true);
        }
      }
      AppMethodBeat.o(190782);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.view.a.f
 * JD-Core Version:    0.7.0.1
 */