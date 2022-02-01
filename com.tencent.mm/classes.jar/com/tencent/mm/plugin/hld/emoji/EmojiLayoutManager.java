package com.tencent.mm.plugin.hld.emoji;

import android.content.Context;
import android.graphics.Rect;
import androidx.recyclerview.widget.RecyclerView.n;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.recyclerview.WxGridLayoutManager;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/emoji/EmojiLayoutManager;", "Lcom/tencent/mm/view/recyclerview/WxGridLayoutManager;", "context", "Landroid/content/Context;", "spanCount", "", "(Landroid/content/Context;I)V", "hideRect", "Landroid/graphics/Rect;", "maxHeight", "scrollY", "tenDpHeight", "onLayoutChildren", "", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "updateChildren", "updateHideArea", "rect", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class EmojiLayoutManager
  extends WxGridLayoutManager
{
  public static final EmojiLayoutManager.a JoX;
  public int JoY;
  public int maxHeight;
  public final Rect mkA;
  
  static
  {
    AppMethodBeat.i(312742);
    JoX = new EmojiLayoutManager.a((byte)0);
    AppMethodBeat.o(312742);
  }
  
  public EmojiLayoutManager(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    AppMethodBeat.i(312723);
    this.mkA = new Rect();
    AppMethodBeat.o(312723);
  }
  
  private void fLi()
  {
    AppMethodBeat.i(312728);
    if (this.mkA.isEmpty())
    {
      AppMethodBeat.o(312728);
      return;
    }
    AppMethodBeat.o(312728);
  }
  
  public final void onLayoutChildren(RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(312747);
    super.onLayoutChildren(paramn, params);
    fLi();
    AppMethodBeat.o(312747);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.emoji.EmojiLayoutManager
 * JD-Core Version:    0.7.0.1
 */