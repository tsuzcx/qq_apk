package com.tencent.mm.live.view.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.e;
import java.util.ArrayList;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/view/adapter/LiveMemberAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/live/view/adapter/LiveMemberAdapter$LiveMemberItemHolder;", "()V", "itemClickListener", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function1;", "setItemClickListener", "(Lkotlin/jvm/functions/Function1;)V", "membersList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/live/view/adapter/MembersData;", "Lkotlin/collections/ArrayList;", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "type", "updateMembers", "members", "", "LiveMemberItemHolder", "plugin-logic_release"})
public final class d
  extends RecyclerView.a<a>
{
  public final ArrayList<g> kLY;
  public b<? super View, x> kMj;
  
  public d()
  {
    AppMethodBeat.i(188649);
    this.kLY = new ArrayList();
    AppMethodBeat.o(188649);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(188646);
    int i = this.kLY.size();
    AppMethodBeat.o(188646);
    return i;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/view/adapter/LiveMemberAdapter$LiveMemberItemHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "avatarIcon", "Landroid/widget/ImageView;", "getAvatarIcon", "()Landroid/widget/ImageView;", "usernameTv", "Landroid/widget/TextView;", "getUsernameTv", "()Landroid/widget/TextView;", "plugin-logic_release"})
  public static final class a
    extends RecyclerView.v
  {
    final ImageView kLZ;
    final TextView kMa;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(189670);
      View localView = paramView.findViewById(b.e.live_member_item_avatar_icon);
      p.j(localView, "itemView.findViewById(R.…_member_item_avatar_icon)");
      this.kLZ = ((ImageView)localView);
      paramView = paramView.findViewById(b.e.live_member_item_username_tv);
      p.j(paramView, "itemView.findViewById(R.…_member_item_username_tv)");
      this.kMa = ((TextView)paramView);
      AppMethodBeat.o(189670);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.view.a.d
 * JD-Core Version:    0.7.0.1
 */