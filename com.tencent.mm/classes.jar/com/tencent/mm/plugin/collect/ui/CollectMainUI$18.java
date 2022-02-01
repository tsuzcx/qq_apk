package com.tencent.mm.plugin.collect.ui;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dqj;
import com.tencent.mm.protocal.protobuf.ql;
import com.tencent.mm.ui.base.q.g;
import java.util.LinkedList;

final class CollectMainUI$18
  implements q.g
{
  CollectMainUI$18(CollectMainUI paramCollectMainUI, ql paramql) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(274099);
    paramInt = paramMenuItem.getItemId();
    paramMenuItem = (dqj)this.uaX.RYI.get(paramInt);
    CollectMainUI.d(this.uaM, 2);
    CollectMainUI.a(this.uaM, paramMenuItem);
    AppMethodBeat.o(274099);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectMainUI.18
 * JD-Core Version:    0.7.0.1
 */