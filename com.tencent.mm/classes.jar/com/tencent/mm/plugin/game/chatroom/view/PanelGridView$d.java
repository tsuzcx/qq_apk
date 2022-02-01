package com.tencent.mm.plugin.game.chatroom.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.autogen.chatroom.Panel;
import com.tencent.mm.plugin.game.chatroom.e;
import com.tencent.mm.plugin.game.chatroom.h.e;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/game/chatroom/view/PanelGridView$PanelViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "icon", "Landroid/widget/ImageView;", "panelItem", "Lcom/tencent/mm/plugin/game/autogen/chatroom/Panel;", "title", "Landroid/widget/TextView;", "onBindData", "", "game-chatroom_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PanelGridView$d
  extends RecyclerView.v
{
  Panel Isg;
  ImageView dpM;
  TextView mll;
  
  public PanelGridView$d(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(276442);
    View localView = this.caK.findViewById(h.e.IgL);
    s.s(localView, "itemView.findViewById(R.id.panel_icon)");
    this.dpM = ((ImageView)localView);
    localView = this.caK.findViewById(h.e.IgM);
    s.s(localView, "itemView.findViewById(R.id.panel_title)");
    this.mll = ((TextView)localView);
    paramView.setOnClickListener(new PanelGridView.d..ExternalSyntheticLambda0(this, paramView));
    AppMethodBeat.o(276442);
  }
  
  private static final void a(d paramd, View paramView1, View paramView2)
  {
    AppMethodBeat.i(276449);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramd);
    localb.cH(paramView1);
    localb.cH(paramView2);
    a.c("com/tencent/mm/plugin/game/chatroom/view/PanelGridView$PanelViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramd, "this$0");
    s.u(paramView1, "$itemView");
    paramView2 = paramd.Isg;
    if (paramView2 != null)
    {
      paramView2 = paramView2.jump_info;
      if (paramView2 != null)
      {
        paramd = paramd.Isg;
        s.checkNotNull(paramd);
        if (paramd.type == 1) {
          e.a(paramView1.getContext(), paramView2, 0, null);
        }
      }
    }
    a.a(new Object(), "com/tencent/mm/plugin/game/chatroom/view/PanelGridView$PanelViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(276449);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.view.PanelGridView.d
 * JD-Core Version:    0.7.0.1
 */