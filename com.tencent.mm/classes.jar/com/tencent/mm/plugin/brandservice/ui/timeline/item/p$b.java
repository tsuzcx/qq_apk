package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ly;
import com.tencent.mm.sdk.b.c;
import d.l;
import java.lang.ref.WeakReference;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardItem$IListenerImpl;", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ModNewContactEvent;", "ref", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardItem;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardItem;)V", "value", "", "username", "getUsername", "()Ljava/lang/String;", "setUsername", "(Ljava/lang/String;)V", "weakRef", "Ljava/lang/ref/WeakReference;", "callback", "", "event", "plugin-brandservice_release"})
final class p$b
  extends c<ly>
{
  private final WeakReference<p> oeg;
  private String username;
  
  public p$b(p paramp)
  {
    AppMethodBeat.i(209769);
    this.oeg = new WeakReference(paramp);
    this.username = "";
    AppMethodBeat.o(209769);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.p.b
 * JD-Core Version:    0.7.0.1
 */