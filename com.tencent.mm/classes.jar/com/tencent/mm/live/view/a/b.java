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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/view/adapter/LiveAfterMembersStatesAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/live/view/adapter/LiveAfterMembersStatesAdapter$LiveMemberItemHolder;", "()V", "membersList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/live/view/adapter/MembersData;", "Lkotlin/collections/ArrayList;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "type", "updateMembers", "members", "", "LiveMemberItemHolder", "plugin-logic_release"})
public final class b
  extends RecyclerView.a<a>
{
  private final ArrayList<g> heG;
  
  public b()
  {
    AppMethodBeat.i(216687);
    this.heG = new ArrayList();
    AppMethodBeat.o(216687);
  }
  
  public final void aa(List<g> paramList)
  {
    AppMethodBeat.i(216683);
    p.h(paramList, "members");
    this.heG.clear();
    this.heG.addAll((Collection)paramList);
    AppMethodBeat.o(216683);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(216685);
    int i = this.heG.size();
    AppMethodBeat.o(216685);
    return i;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/view/adapter/LiveAfterMembersStatesAdapter$LiveMemberItemHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "arrow", "Landroid/widget/ImageView;", "getArrow", "()Landroid/widget/ImageView;", "avatarIcon", "getAvatarIcon", "usernameTv", "Landroid/widget/TextView;", "getUsernameTv", "()Landroid/widget/TextView;", "plugin-logic_release"})
  public static final class a
    extends RecyclerView.w
  {
    final ImageView heH;
    final TextView heI;
    private final ImageView heJ;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(216680);
      View localView = paramView.findViewById(2131307544);
      p.g(localView, "itemView.findViewById(R.…_member_item_avatar_icon)");
      this.heH = ((ImageView)localView);
      localView = paramView.findViewById(2131307545);
      p.g(localView, "itemView.findViewById(R.…_member_item_username_tv)");
      this.heI = ((TextView)localView);
      paramView = paramView.findViewById(2131307543);
      p.g(paramView, "itemView.findViewById(R.…states_member_item_arrow)");
      this.heJ = ((ImageView)paramView);
      AppMethodBeat.o(216680);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    public static final b heK;
    
    static
    {
      AppMethodBeat.i(216682);
      heK = new b();
      AppMethodBeat.o(216682);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(216681);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      a.b("com/tencent/mm/live/view/adapter/LiveAfterMembersStatesAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      a.a(this, "com/tencent/mm/live/view/adapter/LiveAfterMembersStatesAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(216681);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.view.a.b
 * JD-Core Version:    0.7.0.1
 */