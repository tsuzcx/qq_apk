package com.tencent.mm.plugin.ipcall.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import java.util.Iterator;
import java.util.Set;

final class IPCallMsgUI$a$1
  implements MMSlideDelView.d
{
  IPCallMsgUI$a$1(IPCallMsgUI.a parama) {}
  
  public final void a(MMSlideDelView paramMMSlideDelView, boolean paramBoolean)
  {
    AppMethodBeat.i(25813);
    if (paramBoolean)
    {
      uSl.add(paramMMSlideDelView);
      AppMethodBeat.o(25813);
      return;
    }
    uSl.remove(paramMMSlideDelView);
    AppMethodBeat.o(25813);
  }
  
  public final boolean deB()
  {
    AppMethodBeat.i(25814);
    if (uSl.size() > 0)
    {
      AppMethodBeat.o(25814);
      return true;
    }
    AppMethodBeat.o(25814);
    return false;
  }
  
  public final void deC()
  {
    AppMethodBeat.i(25815);
    Iterator localIterator = uSl.iterator();
    while (localIterator.hasNext())
    {
      MMSlideDelView localMMSlideDelView = (MMSlideDelView)localIterator.next();
      if (localMMSlideDelView != null) {
        localMMSlideDelView.fyX();
      }
    }
    uSl.clear();
    AppMethodBeat.o(25815);
  }
  
  public final void deD()
  {
    AppMethodBeat.i(25816);
    Iterator localIterator = uSl.iterator();
    while (localIterator.hasNext())
    {
      MMSlideDelView localMMSlideDelView = (MMSlideDelView)localIterator.next();
      if (localMMSlideDelView != null) {
        localMMSlideDelView.fyW();
      }
    }
    uSl.clear();
    AppMethodBeat.o(25816);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallMsgUI.a.1
 * JD-Core Version:    0.7.0.1
 */