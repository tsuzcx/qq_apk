package com.tencent.mm.emoji.panel.layout;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/panel/layout/EmojiPanelLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "orientation", "", "(Landroid/content/Context;I)V", "(Landroid/content/Context;)V", "reverseLayout", "", "(Landroid/content/Context;IZ)V", "TAG", "", "isScrollEnabled", "()Z", "setScrollEnabled", "(Z)V", "canScrollHorizontally", "canScrollVertically", "plugin-emojisdk_release"})
public final class EmojiPanelLayoutManager
  extends LinearLayoutManager
{
  private final String TAG;
  public boolean jNh;
  
  public EmojiPanelLayoutManager(Context paramContext)
  {
    super(0, false);
    AppMethodBeat.i(105717);
    this.TAG = "MicroMsg.EmojiPanelLayoutManager";
    this.jNh = true;
    AppMethodBeat.o(105717);
  }
  
  public final boolean canScrollHorizontally()
  {
    AppMethodBeat.i(105715);
    if ((this.jNh) && (super.canScrollHorizontally()))
    {
      AppMethodBeat.o(105715);
      return true;
    }
    AppMethodBeat.o(105715);
    return false;
  }
  
  public final boolean canScrollVertically()
  {
    AppMethodBeat.i(105716);
    if ((this.jNh) && (super.canScrollVertically()))
    {
      AppMethodBeat.o(105716);
      return true;
    }
    AppMethodBeat.o(105716);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.layout.EmojiPanelLayoutManager
 * JD-Core Version:    0.7.0.1
 */