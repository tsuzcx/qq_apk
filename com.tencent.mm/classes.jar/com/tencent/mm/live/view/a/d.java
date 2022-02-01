package com.tencent.mm.live.view.a;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.g.b.k;
import d.l;
import d.y;
import java.util.ArrayList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/view/adapter/LiveMemberAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/live/view/adapter/LiveMemberAdapter$LiveMemberItemHolder;", "()V", "itemClickListener", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function1;", "setItemClickListener", "(Lkotlin/jvm/functions/Function1;)V", "membersList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/live/view/adapter/MembersData;", "Lkotlin/collections/ArrayList;", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "type", "updateMembers", "members", "", "LiveMemberItemHolder", "plugin-logic_release"})
public final class d
  extends RecyclerView.a<a>
{
  public b<? super View, y> KBy;
  public final ArrayList<g> sSg;
  
  public d()
  {
    AppMethodBeat.i(203542);
    this.sSg = new ArrayList();
    AppMethodBeat.o(203542);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(203540);
    int i = this.sSg.size();
    AppMethodBeat.o(203540);
    return i;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/view/adapter/LiveMemberAdapter$LiveMemberItemHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "avatarIcon", "Landroid/widget/ImageView;", "getAvatarIcon", "()Landroid/widget/ImageView;", "usernameTv", "Landroid/widget/TextView;", "getUsernameTv", "()Landroid/widget/TextView;", "plugin-logic_release"})
  public static final class a
    extends RecyclerView.v
  {
    final ImageView KBu;
    final TextView icz;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(203537);
      View localView = paramView.findViewById(2131307577);
      k.g(localView, "itemView.findViewById(R.…_member_item_avatar_icon)");
      this.KBu = ((ImageView)localView);
      paramView = paramView.findViewById(2131307578);
      k.g(paramView, "itemView.findViewById(R.…_member_item_username_tv)");
      this.icz = ((TextView)paramView);
      AppMethodBeat.o(203537);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.view.a.d
 * JD-Core Version:    0.7.0.1
 */