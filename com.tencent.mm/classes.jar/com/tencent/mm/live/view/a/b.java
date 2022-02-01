package com.tencent.mm.live.view.a;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/view/adapter/LiveAfterMembersStatesAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/live/view/adapter/LiveAfterMembersStatesAdapter$LiveMemberItemHolder;", "()V", "membersList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/live/view/adapter/MembersData;", "Lkotlin/collections/ArrayList;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "type", "updateMembers", "members", "", "LiveMemberItemHolder", "plugin-logic_release"})
public final class b
  extends RecyclerView.a<a>
{
  private final ArrayList<g> hXt;
  
  public b()
  {
    AppMethodBeat.i(208660);
    this.hXt = new ArrayList();
    AppMethodBeat.o(208660);
  }
  
  public final void ai(List<g> paramList)
  {
    AppMethodBeat.i(208656);
    p.h(paramList, "members");
    this.hXt.clear();
    this.hXt.addAll((Collection)paramList);
    AppMethodBeat.o(208656);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(208658);
    int i = this.hXt.size();
    AppMethodBeat.o(208658);
    return i;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/view/adapter/LiveAfterMembersStatesAdapter$LiveMemberItemHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "arrow", "Landroid/widget/ImageView;", "getArrow", "()Landroid/widget/ImageView;", "avatarIcon", "getAvatarIcon", "usernameTv", "Landroid/widget/TextView;", "getUsernameTv", "()Landroid/widget/TextView;", "plugin-logic_release"})
  public static final class a
    extends RecyclerView.v
  {
    final ImageView hXu;
    final TextView hXv;
    private final ImageView hXw;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(208653);
      View localView = paramView.findViewById(2131303302);
      p.g(localView, "itemView.findViewById(R.…_member_item_avatar_icon)");
      this.hXu = ((ImageView)localView);
      localView = paramView.findViewById(2131303303);
      p.g(localView, "itemView.findViewById(R.…_member_item_username_tv)");
      this.hXv = ((TextView)localView);
      paramView = paramView.findViewById(2131303301);
      p.g(paramView, "itemView.findViewById(R.…states_member_item_arrow)");
      this.hXw = ((ImageView)paramView);
      AppMethodBeat.o(208653);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    public static final b hXx;
    
    static
    {
      AppMethodBeat.i(208655);
      hXx = new b();
      AppMethodBeat.o(208655);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(208654);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      a.b("com/tencent/mm/live/view/adapter/LiveAfterMembersStatesAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      a.a(this, "com/tencent/mm/live/view/adapter/LiveAfterMembersStatesAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(208654);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.view.a.b
 * JD-Core Version:    0.7.0.1
 */