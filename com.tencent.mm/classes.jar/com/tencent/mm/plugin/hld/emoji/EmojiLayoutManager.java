package com.tencent.mm.plugin.hld.emoji;

import android.content.Context;
import android.graphics.Rect;
import androidx.recyclerview.widget.RecyclerView.n;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.recyclerview.WxGridLayoutManager;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/emoji/EmojiLayoutManager;", "Lcom/tencent/mm/view/recyclerview/WxGridLayoutManager;", "context", "Landroid/content/Context;", "spanCount", "", "(Landroid/content/Context;I)V", "hideRect", "Landroid/graphics/Rect;", "maxHeight", "scrollY", "tenDpHeight", "onLayoutChildren", "", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "updateChildren", "updateHideArea", "rect", "Companion", "plugin-hld_release"})
public final class EmojiLayoutManager
  extends WxGridLayoutManager
{
  public static final a DvS;
  public int DvR;
  public final Rect jLp;
  public int maxHeight;
  
  static
  {
    AppMethodBeat.i(209089);
    DvS = new a((byte)0);
    AppMethodBeat.o(209089);
  }
  
  public EmojiLayoutManager(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    AppMethodBeat.i(209087);
    this.jLp = new Rect();
    AppMethodBeat.o(209087);
  }
  
  private void eDi()
  {
    AppMethodBeat.i(209083);
    if (this.jLp.isEmpty())
    {
      AppMethodBeat.o(209083);
      return;
    }
    AppMethodBeat.o(209083);
  }
  
  public final void onLayoutChildren(RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(209079);
    super.onLayoutChildren(paramn, params);
    eDi();
    AppMethodBeat.o(209079);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/emoji/EmojiLayoutManager$Companion;", "", "()V", "TAG", "", "plugin-hld_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.emoji.EmojiLayoutManager
 * JD-Core Version:    0.7.0.1
 */