package com.tencent.mm.plugin.collect.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dqj;
import com.tencent.mm.protocal.protobuf.ql;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import java.util.Iterator;
import java.util.LinkedList;

final class CollectMainUI$17
  implements q.f
{
  CollectMainUI$17(CollectMainUI paramCollectMainUI, ql paramql) {}
  
  public final void onCreateMMMenu(o paramo)
  {
    AppMethodBeat.i(271456);
    Iterator localIterator = this.uaX.RYI.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      dqj localdqj = (dqj)localIterator.next();
      if ((localdqj != null) && (localdqj.wording != null))
      {
        paramo.d(i, localdqj.wording);
        i += 1;
      }
    }
    AppMethodBeat.o(271456);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectMainUI.17
 * JD-Core Version:    0.7.0.1
 */