package com.tencent.mm.live.view.a;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/view/adapter/LiveAfterMembersStatesAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/live/view/adapter/LiveAfterMembersStatesAdapter$LiveMemberItemHolder;", "()V", "membersList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/live/view/adapter/MembersData;", "Lkotlin/collections/ArrayList;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "type", "updateMembers", "members", "", "LiveMemberItemHolder", "plugin-logic_release"})
public final class b
  extends RecyclerView.a<a>
{
  private final ArrayList<g> gIi;
  
  public b()
  {
    AppMethodBeat.i(190766);
    this.gIi = new ArrayList();
    AppMethodBeat.o(190766);
  }
  
  public final void Z(List<g> paramList)
  {
    AppMethodBeat.i(190762);
    k.h(paramList, "members");
    this.gIi.clear();
    this.gIi.addAll((Collection)paramList);
    AppMethodBeat.o(190762);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(190764);
    int i = this.gIi.size();
    AppMethodBeat.o(190764);
    return i;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/view/adapter/LiveAfterMembersStatesAdapter$LiveMemberItemHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "arrow", "Landroid/widget/ImageView;", "getArrow", "()Landroid/widget/ImageView;", "avatarIcon", "getAvatarIcon", "usernameTv", "Landroid/widget/TextView;", "getUsernameTv", "()Landroid/widget/TextView;", "plugin-logic_release"})
  public static final class a
    extends RecyclerView.w
  {
    final ImageView gIj;
    final TextView gIk;
    private final ImageView gIl;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(190760);
      View localView = paramView.findViewById(2131307544);
      k.g(localView, "itemView.findViewById(R.…_member_item_avatar_icon)");
      this.gIj = ((ImageView)localView);
      localView = paramView.findViewById(2131307545);
      k.g(localView, "itemView.findViewById(R.…_member_item_username_tv)");
      this.gIk = ((TextView)localView);
      paramView = paramView.findViewById(2131307543);
      k.g(paramView, "itemView.findViewById(R.…states_member_item_arrow)");
      this.gIl = ((ImageView)paramView);
      AppMethodBeat.o(190760);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.view.a.b
 * JD-Core Version:    0.7.0.1
 */