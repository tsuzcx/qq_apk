package com.tencent.mm.plugin.appbrand.appcache.predownload.storage;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.plugin.appbrand.config.ae;
import com.tencent.mm.sdk.event.IListener;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/appcache/predownload/storage/WxaSyncCmdPersistentStorage$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttrStorageNotifyEvent;", "callback", "", "event", "data-storage_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class WxaSyncCmdPersistentStorage$1
  extends IListener<ae>
{
  WxaSyncCmdPersistentStorage$1(l paraml, f paramf)
  {
    super((q)paramf);
    AppMethodBeat.i(320439);
    AppMethodBeat.o(320439);
  }
  
  private static final void a(l paraml, String paramString)
  {
    AppMethodBeat.i(320443);
    s.u(paraml, "this$0");
    paraml.VR(paramString);
    AppMethodBeat.o(320443);
  }
  
  private static final void a(List paramList, l paraml)
  {
    AppMethodBeat.i(320447);
    s.u(paraml, "this$0");
    paramList = ((Iterable)paramList).iterator();
    label79:
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      CharSequence localCharSequence = (CharSequence)str;
      if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label79;
        }
        paraml.VR(str);
        break;
      }
    }
    AppMethodBeat.o(320447);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.storage.WxaSyncCmdPersistentStorage.1
 * JD-Core Version:    0.7.0.1
 */