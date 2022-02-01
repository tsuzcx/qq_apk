package com.tencent.mm.emoji.panel.layout;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/panel/layout/EmojiPanelLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "orientation", "", "(Landroid/content/Context;I)V", "(Landroid/content/Context;)V", "reverseLayout", "", "(Landroid/content/Context;IZ)V", "TAG", "", "isScrollEnabled", "()Z", "setScrollEnabled", "(Z)V", "canScrollHorizontally", "canScrollVertically", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class EmojiPanelLayoutManager
  extends LinearLayoutManager
{
  private final String TAG;
  public boolean mmg;
  
  public EmojiPanelLayoutManager(Context paramContext)
  {
    super(0, false);
    AppMethodBeat.i(105717);
    this.TAG = "MicroMsg.EmojiPanelLayoutManager";
    this.mmg = true;
    AppMethodBeat.o(105717);
  }
  
  public final boolean canScrollHorizontally()
  {
    AppMethodBeat.i(105715);
    if ((this.mmg) && (super.canScrollHorizontally()))
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
    if ((this.mmg) && (super.canScrollVertically()))
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