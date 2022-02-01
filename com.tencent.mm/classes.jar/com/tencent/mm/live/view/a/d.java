package com.tencent.mm.live.view.a;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/view/adapter/LiveMemberAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/live/view/adapter/LiveMemberAdapter$LiveMemberItemHolder;", "()V", "itemClickListener", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function1;", "setItemClickListener", "(Lkotlin/jvm/functions/Function1;)V", "membersList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/live/view/adapter/MembersData;", "Lkotlin/collections/ArrayList;", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "type", "updateMembers", "members", "", "LiveMemberItemHolder", "plugin-logic_release"})
public final class d
  extends RecyclerView.a<a>
{
  public b<? super View, x> hXE;
  public final ArrayList<g> hXt;
  
  public d()
  {
    AppMethodBeat.i(208675);
    this.hXt = new ArrayList();
    AppMethodBeat.o(208675);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(208673);
    int i = this.hXt.size();
    AppMethodBeat.o(208673);
    return i;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/view/adapter/LiveMemberAdapter$LiveMemberItemHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "avatarIcon", "Landroid/widget/ImageView;", "getAvatarIcon", "()Landroid/widget/ImageView;", "usernameTv", "Landroid/widget/TextView;", "getUsernameTv", "()Landroid/widget/TextView;", "plugin-logic_release"})
  public static final class a
    extends RecyclerView.v
  {
    final ImageView hXu;
    final TextView hXv;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(208670);
      View localView = paramView.findViewById(2131303440);
      p.g(localView, "itemView.findViewById(R.…_member_item_avatar_icon)");
      this.hXu = ((ImageView)localView);
      paramView = paramView.findViewById(2131303443);
      p.g(paramView, "itemView.findViewById(R.…_member_item_username_tv)");
      this.hXv = ((TextView)paramView);
      AppMethodBeat.o(208670);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.view.a.d
 * JD-Core Version:    0.7.0.1
 */