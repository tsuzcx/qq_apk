package com.tencent.mm.plugin.finder.view.emoji;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.panel.a.ac;
import com.tencent.mm.emoji.panel.a.g;
import com.tencent.mm.emoji.panel.a.q;
import com.tencent.mm.w.a.a.a.f;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/emoji/FinderEmojiPanelItemAdapter;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemAdapter;", "()V", "onCreateViewHolder", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends g
{
  public final q<?> f(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(345255);
    s.u(paramViewGroup, "parent");
    LayoutInflater localLayoutInflater = LayoutInflater.from(paramViewGroup.getContext());
    if (paramInt == 1)
    {
      paramViewGroup = localLayoutInflater.inflate(a.f.finder_emoji_panel_item_smiley, paramViewGroup, false);
      s.s(paramViewGroup, "itemView");
      paramViewGroup = (q)new ac(paramViewGroup, this.mkY);
      AppMethodBeat.o(345255);
      return paramViewGroup;
    }
    paramViewGroup = localLayoutInflater.inflate(a.f.finder_emoji_panel_item_smiley, paramViewGroup, false);
    s.s(paramViewGroup, "itemView");
    paramViewGroup = (q)new ac(paramViewGroup, this.mkY);
    AppMethodBeat.o(345255);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.emoji.a
 * JD-Core Version:    0.7.0.1
 */