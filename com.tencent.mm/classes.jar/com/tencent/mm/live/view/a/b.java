package com.tencent.mm.live.view.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.live.b.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/view/adapter/LiveAfterMembersStatesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/live/view/adapter/LiveAfterMembersStatesAdapter$LiveMemberItemHolder;", "()V", "membersList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/live/view/adapter/MembersData;", "Lkotlin/collections/ArrayList;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "type", "updateMembers", "members", "", "LiveMemberItemHolder", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends RecyclerView.a<a>
{
  private final ArrayList<f> nnU;
  
  public b()
  {
    AppMethodBeat.i(246209);
    this.nnU = new ArrayList();
    AppMethodBeat.o(246209);
  }
  
  private static final void dj(View paramView)
  {
    AppMethodBeat.i(246219);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    a.c("com/tencent/mm/live/view/adapter/LiveAfterMembersStatesAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    a.a(new Object(), "com/tencent/mm/live/view/adapter/LiveAfterMembersStatesAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(246219);
  }
  
  public final void bH(List<f> paramList)
  {
    AppMethodBeat.i(246236);
    s.u(paramList, "members");
    this.nnU.clear();
    this.nnU.addAll((Collection)paramList);
    AppMethodBeat.o(246236);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(246243);
    int i = this.nnU.size();
    AppMethodBeat.o(246243);
    return i;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/live/view/adapter/LiveAfterMembersStatesAdapter$LiveMemberItemHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "arrow", "Landroid/widget/ImageView;", "getArrow", "()Landroid/widget/ImageView;", "avatarIcon", "getAvatarIcon", "usernameTv", "Landroid/widget/TextView;", "getUsernameTv", "()Landroid/widget/TextView;", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends RecyclerView.v
  {
    final ImageView nnV;
    final TextView nnW;
    private final ImageView nnX;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(246178);
      View localView = paramView.findViewById(b.e.live_after_states_member_item_avatar_icon);
      s.s(localView, "itemView.findViewById(R.…_member_item_avatar_icon)");
      this.nnV = ((ImageView)localView);
      localView = paramView.findViewById(b.e.live_after_states_member_item_username_tv);
      s.s(localView, "itemView.findViewById(R.…_member_item_username_tv)");
      this.nnW = ((TextView)localView);
      paramView = paramView.findViewById(b.e.live_after_states_member_item_arrow);
      s.s(paramView, "itemView.findViewById(R.…states_member_item_arrow)");
      this.nnX = ((ImageView)paramView);
      AppMethodBeat.o(246178);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.view.a.b
 * JD-Core Version:    0.7.0.1
 */