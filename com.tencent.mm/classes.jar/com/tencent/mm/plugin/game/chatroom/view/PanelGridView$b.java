package com.tencent.mm.plugin.game.chatroom.view;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.autogen.chatroom.Panel;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/game/chatroom/view/PanelGridView$PanelAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/game/chatroom/view/PanelGridView$PanelViewHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "panelList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/game/autogen/chatroom/Panel;", "Lkotlin/collections/ArrayList;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "", "game-chatroom_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PanelGridView$b
  extends RecyclerView.a<PanelGridView.d>
{
  ArrayList<Panel> Isd;
  private Context context;
  
  public PanelGridView$b(Context paramContext)
  {
    AppMethodBeat.i(276450);
    this.Isd = new ArrayList();
    this.context = paramContext;
    AppMethodBeat.o(276450);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(276457);
    int i = this.Isd.size();
    AppMethodBeat.o(276457);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.view.PanelGridView.b
 * JD-Core Version:    0.7.0.1
 */