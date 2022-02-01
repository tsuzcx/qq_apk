package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.on;
import com.tencent.mm.sdk.event.IListener;
import java.lang.ref.WeakReference;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardItem$IListenerImpl;", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ModNewContactEvent;", "ref", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardItem;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardItem;)V", "value", "", "username", "getUsername", "()Ljava/lang/String;", "setUsername", "(Ljava/lang/String;)V", "weakRef", "Ljava/lang/ref/WeakReference;", "callback", "", "event", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
final class BizTLRecCardItem$IListenerImpl
  extends IListener<on>
{
  private String username;
  private final WeakReference<BizTLRecCardItem> vKQ;
  
  public BizTLRecCardItem$IListenerImpl(BizTLRecCardItem paramBizTLRecCardItem)
  {
    super((q)f.hfK);
    AppMethodBeat.i(302800);
    this.vKQ = new WeakReference(paramBizTLRecCardItem);
    this.username = "";
    AppMethodBeat.o(302800);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.BizTLRecCardItem.IListenerImpl
 * JD-Core Version:    0.7.0.1
 */