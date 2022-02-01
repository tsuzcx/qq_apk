package com.tencent.mm.live.view.a;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/view/adapter/LiveAfterMembersStatesAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/live/view/adapter/LiveAfterMembersStatesAdapter$LiveMemberItemHolder;", "()V", "membersList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/live/view/adapter/MembersData;", "Lkotlin/collections/ArrayList;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "type", "updateMembers", "members", "", "LiveMemberItemHolder", "plugin-logic_release"})
public final class b
  extends RecyclerView.a<a>
{
  private final ArrayList<g> hbS;
  
  public b()
  {
    AppMethodBeat.i(213057);
    this.hbS = new ArrayList();
    AppMethodBeat.o(213057);
  }
  
  public final void aa(List<g> paramList)
  {
    AppMethodBeat.i(213053);
    p.h(paramList, "members");
    this.hbS.clear();
    this.hbS.addAll((Collection)paramList);
    AppMethodBeat.o(213053);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(213055);
    int i = this.hbS.size();
    AppMethodBeat.o(213055);
    return i;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/view/adapter/LiveAfterMembersStatesAdapter$LiveMemberItemHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "arrow", "Landroid/widget/ImageView;", "getArrow", "()Landroid/widget/ImageView;", "avatarIcon", "getAvatarIcon", "usernameTv", "Landroid/widget/TextView;", "getUsernameTv", "()Landroid/widget/TextView;", "plugin-logic_release"})
  public static final class a
    extends RecyclerView.w
  {
    final ImageView hbT;
    final TextView hbU;
    private final ImageView hbV;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(213050);
      View localView = paramView.findViewById(2131307544);
      p.g(localView, "itemView.findViewById(R.…_member_item_avatar_icon)");
      this.hbT = ((ImageView)localView);
      localView = paramView.findViewById(2131307545);
      p.g(localView, "itemView.findViewById(R.…_member_item_username_tv)");
      this.hbU = ((TextView)localView);
      paramView = paramView.findViewById(2131307543);
      p.g(paramView, "itemView.findViewById(R.…states_member_item_arrow)");
      this.hbV = ((ImageView)paramView);
      AppMethodBeat.o(213050);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    public static final b hbW;
    
    static
    {
      AppMethodBeat.i(213052);
      hbW = new b();
      AppMethodBeat.o(213052);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(213051);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      a.b("com/tencent/mm/live/view/adapter/LiveAfterMembersStatesAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      a.a(this, "com/tencent/mm/live/view/adapter/LiveAfterMembersStatesAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(213051);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.view.a.b
 * JD-Core Version:    0.7.0.1
 */