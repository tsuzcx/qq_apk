package com.tencent.mm.emoji.panel.layout;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/panel/layout/EmojiPanelLayoutManager;", "Landroid/support/v7/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "orientation", "", "(Landroid/content/Context;I)V", "(Landroid/content/Context;)V", "reverseLayout", "", "(Landroid/content/Context;IZ)V", "TAG", "", "isScrollEnabled", "()Z", "setScrollEnabled", "(Z)V", "canScrollHorizontally", "canScrollVertically", "plugin-emojisdk_release"})
public final class EmojiPanelLayoutManager
  extends LinearLayoutManager
{
  private final String TAG;
  public boolean fQW;
  
  public EmojiPanelLayoutManager(Context paramContext)
  {
    super(0);
    AppMethodBeat.i(105717);
    this.TAG = "MicroMsg.EmojiPanelLayoutManager";
    this.fQW = true;
    AppMethodBeat.o(105717);
  }
  
  public final boolean jE()
  {
    AppMethodBeat.i(105715);
    if ((this.fQW) && (super.jE()))
    {
      AppMethodBeat.o(105715);
      return true;
    }
    AppMethodBeat.o(105715);
    return false;
  }
  
  public final boolean jF()
  {
    AppMethodBeat.i(105716);
    if ((this.fQW) && (super.jF()))
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