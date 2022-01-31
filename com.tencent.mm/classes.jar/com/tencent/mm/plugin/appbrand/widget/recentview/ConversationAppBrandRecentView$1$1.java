package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.content.Context;
import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ConversationAppBrandRecentView$1$1
  implements View.OnCreateContextMenuListener
{
  ConversationAppBrandRecentView$1$1(ConversationAppBrandRecentView.1 param1) {}
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(134356);
    if (ConversationAppBrandRecentView.b(this.jvJ.jvI) != null) {
      ConversationAppBrandRecentView.b(this.jvJ.jvI).onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    }
    paramContextMenu.add(0, 1, paramContextMenu.size() + 1, this.jvJ.jvI.getContext().getResources().getString(2131298946));
    AppMethodBeat.o(134356);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recentview.ConversationAppBrandRecentView.1.1
 * JD-Core Version:    0.7.0.1
 */