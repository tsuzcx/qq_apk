package com.tencent.mm.live.view.a;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/view/adapter/LiveAfterMembersStatesAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/live/view/adapter/LiveAfterMembersStatesAdapter$LiveMemberItemHolder;", "()V", "membersList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/live/view/adapter/MembersData;", "Lkotlin/collections/ArrayList;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "type", "updateMembers", "members", "", "LiveMemberItemHolder", "plugin-logic_release"})
public final class b
  extends RecyclerView.a<a>
{
  private final ArrayList<g> sSg;
  
  public b()
  {
    AppMethodBeat.i(203526);
    this.sSg = new ArrayList();
    AppMethodBeat.o(203526);
  }
  
  public final void dx(List<g> paramList)
  {
    AppMethodBeat.i(203522);
    k.h(paramList, "members");
    this.sSg.clear();
    this.sSg.addAll((Collection)paramList);
    AppMethodBeat.o(203522);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(203524);
    int i = this.sSg.size();
    AppMethodBeat.o(203524);
    return i;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/view/adapter/LiveAfterMembersStatesAdapter$LiveMemberItemHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "arrow", "Landroid/widget/ImageView;", "getArrow", "()Landroid/widget/ImageView;", "avatarIcon", "getAvatarIcon", "usernameTv", "Landroid/widget/TextView;", "getUsernameTv", "()Landroid/widget/TextView;", "plugin-logic_release"})
  public static final class a
    extends RecyclerView.v
  {
    final ImageView KBu;
    final TextView icz;
    private final ImageView uFE;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(203520);
      View localView = paramView.findViewById(2131307468);
      k.g(localView, "itemView.findViewById(R.…_member_item_avatar_icon)");
      this.KBu = ((ImageView)localView);
      localView = paramView.findViewById(2131307469);
      k.g(localView, "itemView.findViewById(R.…_member_item_username_tv)");
      this.icz = ((TextView)localView);
      paramView = paramView.findViewById(2131307467);
      k.g(paramView, "itemView.findViewById(R.…states_member_item_arrow)");
      this.uFE = ((ImageView)paramView);
      AppMethodBeat.o(203520);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    public static final b KBv;
    
    static
    {
      AppMethodBeat.i(203521);
      KBv = new b();
      AppMethodBeat.o(203521);
    }
    
    public final void onClick(View paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.view.a.b
 * JD-Core Version:    0.7.0.1
 */