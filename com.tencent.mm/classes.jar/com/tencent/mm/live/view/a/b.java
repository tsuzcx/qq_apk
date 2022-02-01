package com.tencent.mm.live.view.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/view/adapter/LiveAfterMembersStatesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/live/view/adapter/LiveAfterMembersStatesAdapter$LiveMemberItemHolder;", "()V", "membersList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/live/view/adapter/MembersData;", "Lkotlin/collections/ArrayList;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "type", "updateMembers", "members", "", "LiveMemberItemHolder", "plugin-logic_release"})
public final class b
  extends RecyclerView.a<a>
{
  private final ArrayList<g> kLY;
  
  public b()
  {
    AppMethodBeat.i(192633);
    this.kLY = new ArrayList();
    AppMethodBeat.o(192633);
  }
  
  public final void ag(List<g> paramList)
  {
    AppMethodBeat.i(192615);
    p.k(paramList, "members");
    this.kLY.clear();
    this.kLY.addAll((Collection)paramList);
    AppMethodBeat.o(192615);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(192621);
    int i = this.kLY.size();
    AppMethodBeat.o(192621);
    return i;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/view/adapter/LiveAfterMembersStatesAdapter$LiveMemberItemHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "arrow", "Landroid/widget/ImageView;", "getArrow", "()Landroid/widget/ImageView;", "avatarIcon", "getAvatarIcon", "usernameTv", "Landroid/widget/TextView;", "getUsernameTv", "()Landroid/widget/TextView;", "plugin-logic_release"})
  public static final class a
    extends RecyclerView.v
  {
    final ImageView kLZ;
    final TextView kMa;
    private final ImageView kMb;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(195754);
      View localView = paramView.findViewById(b.e.live_after_states_member_item_avatar_icon);
      p.j(localView, "itemView.findViewById(R.…_member_item_avatar_icon)");
      this.kLZ = ((ImageView)localView);
      localView = paramView.findViewById(b.e.live_after_states_member_item_username_tv);
      p.j(localView, "itemView.findViewById(R.…_member_item_username_tv)");
      this.kMa = ((TextView)localView);
      paramView = paramView.findViewById(b.e.live_after_states_member_item_arrow);
      p.j(paramView, "itemView.findViewById(R.…states_member_item_arrow)");
      this.kMb = ((ImageView)paramView);
      AppMethodBeat.o(195754);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.view.a.b
 * JD-Core Version:    0.7.0.1
 */