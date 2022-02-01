package com.tencent.mm.msgsubscription.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Listener;", "", "onEvent", "", "event", "", "resultData", "", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Item;", "Companion", "wxbiz-msgsubscription-sdk_release"})
public abstract interface b$d
{
  public static final a iGD = a.iGE;
  
  public abstract void c(int paramInt, List<b.b> paramList);
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Listener$Companion;", "", "()V", "EVENT_ALWAYS_REJECT", "", "EVENT_CANCEL", "EVENT_OK", "wxbiz-msgsubscription-sdk_release"})
  public static final class a
  {
    static
    {
      AppMethodBeat.i(149753);
      iGE = new a();
      AppMethodBeat.o(149753);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.ui.b.d
 * JD-Core Version:    0.7.0.1
 */