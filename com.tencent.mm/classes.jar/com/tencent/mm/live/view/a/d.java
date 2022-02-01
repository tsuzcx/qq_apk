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
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/view/adapter/LiveMemberAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/live/view/adapter/LiveMemberAdapter$LiveMemberItemHolder;", "()V", "itemClickListener", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function1;", "setItemClickListener", "(Lkotlin/jvm/functions/Function1;)V", "membersList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/live/view/adapter/MembersData;", "Lkotlin/collections/ArrayList;", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "type", "updateMembers", "members", "", "LiveMemberItemHolder", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends RecyclerView.a<a>
{
  public final ArrayList<f> nnU;
  public kotlin.g.a.b<? super View, ah> nod;
  
  public d()
  {
    AppMethodBeat.i(246208);
    this.nnU = new ArrayList();
    AppMethodBeat.o(246208);
  }
  
  private static final void a(kotlin.g.a.b paramb, View paramView)
  {
    AppMethodBeat.i(246221);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    a.c("com/tencent/mm/live/view/adapter/LiveMemberAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    paramb.invoke(paramView);
    a.a(new Object(), "com/tencent/mm/live/view/adapter/LiveMemberAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(246221);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(246235);
    int i = this.nnU.size();
    AppMethodBeat.o(246235);
    return i;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/live/view/adapter/LiveMemberAdapter$LiveMemberItemHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "avatarIcon", "Landroid/widget/ImageView;", "getAvatarIcon", "()Landroid/widget/ImageView;", "usernameTv", "Landroid/widget/TextView;", "getUsernameTv", "()Landroid/widget/TextView;", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends RecyclerView.v
  {
    final ImageView nnV;
    final TextView nnW;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(246179);
      View localView = paramView.findViewById(b.e.live_member_item_avatar_icon);
      s.s(localView, "itemView.findViewById(R.…_member_item_avatar_icon)");
      this.nnV = ((ImageView)localView);
      paramView = paramView.findViewById(b.e.live_member_item_username_tv);
      s.s(paramView, "itemView.findViewById(R.…_member_item_username_tv)");
      this.nnW = ((TextView)paramView);
      AppMethodBeat.o(246179);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.view.a.d
 * JD-Core Version:    0.7.0.1
 */