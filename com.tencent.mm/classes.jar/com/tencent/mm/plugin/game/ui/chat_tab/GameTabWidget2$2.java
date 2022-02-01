package com.tencent.mm.plugin.game.ui.chat_tab;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.List;

final class GameTabWidget2$2
  implements Runnable
{
  GameTabWidget2$2(GameTabWidget2 paramGameTabWidget2, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(276677);
    if (Util.isNullOrNil(this.IvY))
    {
      AppMethodBeat.o(276677);
      return;
    }
    Iterator localIterator = GameTabWidget2.b(this.IWu).iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      if ((localView != null) && ((localView.getTag() instanceof GameTabData2.TabItem)))
      {
        GameTabData2.TabItem localTabItem = (GameTabData2.TabItem)localView.getTag();
        if (this.IvY.equals(localTabItem.IFL))
        {
          localView.performClick();
          AppMethodBeat.o(276677);
          return;
        }
      }
    }
    AppMethodBeat.o(276677);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.chat_tab.GameTabWidget2.2
 * JD-Core Version:    0.7.0.1
 */