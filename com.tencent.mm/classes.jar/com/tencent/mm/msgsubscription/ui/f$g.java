package com.tencent.mm.msgsubscription.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Listener;", "", "onEvent", "", "event", "", "resultData", "", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Item;", "onSwitchChanged", "switch", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Listener$Companion$SwitchType;", "isOn", "", "item", "userAction", "Companion", "wxbiz-msgsubscription-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface f$g
{
  public static final a pml = a.pmm;
  
  public abstract void a(f.g.a.a parama, boolean paramBoolean1, f.c paramc, boolean paramBoolean2);
  
  public abstract void r(int paramInt, List<? extends f.c> paramList);
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Listener$Companion;", "", "()V", "EVENT_ALWAYS_REJECT", "", "EVENT_CANCEL", "EVENT_OK", "SwitchType", "wxbiz-msgsubscription-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    static
    {
      AppMethodBeat.i(149753);
      pmm = new a();
      AppMethodBeat.o(149753);
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Listener$Companion$SwitchType;", "", "(Ljava/lang/String;I)V", "SWITCH_FORCE_NOTIFY", "wxbiz-msgsubscription-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static enum a
    {
      static
      {
        AppMethodBeat.i(236604);
        pmn = new a("SWITCH_FORCE_NOTIFY");
        pmo = new a[] { pmn };
        AppMethodBeat.o(236604);
      }
      
      private a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.ui.f.g
 * JD-Core Version:    0.7.0.1
 */