package com.tencent.mm.plugin.account.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.q.f;
import java.util.Iterator;
import java.util.List;

final class WelcomeActivity$5
  implements q.f
{
  WelcomeActivity$5(WelcomeActivity paramWelcomeActivity, List paramList) {}
  
  public final void onCreateMMMenu(o paramo)
  {
    AppMethodBeat.i(128803);
    if (paramo.hJO())
    {
      Iterator localIterator = this.nen.iterator();
      while (localIterator.hasNext()) {
        paramo.h((p)localIterator.next());
      }
    }
    AppMethodBeat.o(128803);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.WelcomeActivity.5
 * JD-Core Version:    0.7.0.1
 */