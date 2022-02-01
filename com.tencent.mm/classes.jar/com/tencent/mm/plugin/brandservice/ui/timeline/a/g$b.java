package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.lg;
import com.tencent.mm.sdk.b.c;
import d.l;
import java.lang.ref.WeakReference;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardItem$IListenerImpl;", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ModNewContactEvent;", "ref", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardItem;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardItem;)V", "value", "", "username", "getUsername", "()Ljava/lang/String;", "setUsername", "(Ljava/lang/String;)V", "weakRef", "Ljava/lang/ref/WeakReference;", "callback", "", "event", "plugin-brandservice_release"})
final class g$b
  extends c<lg>
{
  private final WeakReference<g> mZt;
  private String username;
  
  public g$b(g paramg)
  {
    AppMethodBeat.i(193061);
    this.mZt = new WeakReference(paramg);
    this.username = "";
    AppMethodBeat.o(193061);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.g.b
 * JD-Core Version:    0.7.0.1
 */