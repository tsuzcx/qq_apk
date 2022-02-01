package com.tencent.mm.live.view.a;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.g.b.p;
import d.l;
import d.z;
import java.util.ArrayList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/view/adapter/LiveMemberAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/live/view/adapter/LiveMemberAdapter$LiveMemberItemHolder;", "()V", "itemClickListener", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function1;", "setItemClickListener", "(Lkotlin/jvm/functions/Function1;)V", "membersList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/live/view/adapter/MembersData;", "Lkotlin/collections/ArrayList;", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "type", "updateMembers", "members", "", "LiveMemberItemHolder", "plugin-logic_release"})
public final class d
  extends RecyclerView.a<a>
{
  public final ArrayList<g> hbS;
  public b<? super View, z> hcb;
  
  public d()
  {
    AppMethodBeat.i(213071);
    this.hbS = new ArrayList();
    AppMethodBeat.o(213071);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(213069);
    int i = this.hbS.size();
    AppMethodBeat.o(213069);
    return i;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/view/adapter/LiveMemberAdapter$LiveMemberItemHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "avatarIcon", "Landroid/widget/ImageView;", "getAvatarIcon", "()Landroid/widget/ImageView;", "usernameTv", "Landroid/widget/TextView;", "getUsernameTv", "()Landroid/widget/TextView;", "plugin-logic_release"})
  public static final class a
    extends RecyclerView.w
  {
    final ImageView hbT;
    final TextView hbU;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(213066);
      View localView = paramView.findViewById(2131307660);
      p.g(localView, "itemView.findViewById(R.…_member_item_avatar_icon)");
      this.hbT = ((ImageView)localView);
      paramView = paramView.findViewById(2131307661);
      p.g(paramView, "itemView.findViewById(R.…_member_item_username_tv)");
      this.hbU = ((TextView)paramView);
      AppMethodBeat.o(213066);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.view.a.d
 * JD-Core Version:    0.7.0.1
 */