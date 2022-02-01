package com.tencent.mm.msgsubscription.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Listener;", "", "onEvent", "", "event", "", "resultData", "", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Item;", "Companion", "wxbiz-msgsubscription-sdk_release"})
public abstract interface c$f
{
  public static final a msL = a.msM;
  
  public abstract void c(int paramInt, List<? extends c.c> paramList);
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Listener$Companion;", "", "()V", "EVENT_ALWAYS_REJECT", "", "EVENT_CANCEL", "EVENT_OK", "wxbiz-msgsubscription-sdk_release"})
  public static final class a
  {
    static
    {
      AppMethodBeat.i(149753);
      msM = new a();
      AppMethodBeat.o(149753);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.ui.c.f
 * JD-Core Version:    0.7.0.1
 */