package com.tencent.mm.plugin.finder.view;

import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.ui.widget.MMEditText;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/view/FinderCommentFooter$onFinishInflate$1", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "append", "", "text", "", "del", "onToSendTextEnable", "enable", "", "performSend", "plugin-finder_release"})
public final class FinderCommentFooter$h
  implements ChatFooterPanel.a
{
  public final void aDN() {}
  
  public final void aDO()
  {
    AppMethodBeat.i(168257);
    if (this.AWd.getEditText().getInputConnection() != null)
    {
      this.AWd.getEditText().getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
      this.AWd.getEditText().getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
    }
    AppMethodBeat.o(168257);
  }
  
  public final void append(String paramString)
  {
    AppMethodBeat.i(168256);
    this.AWd.getEditText().bBa(paramString);
    AppMethodBeat.o(168256);
  }
  
  public final void eE(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderCommentFooter.h
 * JD-Core Version:    0.7.0.1
 */