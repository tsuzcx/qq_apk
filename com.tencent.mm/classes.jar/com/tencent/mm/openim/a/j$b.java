package com.tencent.mm.openim.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.openim.api.c;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.au;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/openim/contact/OpenIMKefuConversationExtension$onContactChange$1", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "onNotifyChange", "", "event", "", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j$b
  implements MStorage.IOnStorageChange
{
  public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(236084);
    if (paramMStorageEventData == null)
    {
      AppMethodBeat.o(236084);
      return;
    }
    if (!(paramMStorageEventData.obj instanceof String))
    {
      AppMethodBeat.o(236084);
      return;
    }
    if ((paramMStorageEventData.eventId == 2) || (paramMStorageEventData.eventId == 3) || (paramMStorageEventData.eventId == 4))
    {
      paramMStorageEventData = (String)paramMStorageEventData.obj;
      paramString = paramMStorageEventData;
      if (paramMStorageEventData != null) {}
    }
    for (paramString = "";; paramString = "")
    {
      if (!au.bwQ(paramString))
      {
        AppMethodBeat.o(236084);
        return;
      }
      ((c)h.ax(c.class)).RE(paramString);
      AppMethodBeat.o(236084);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.openim.a.j.b
 * JD-Core Version:    0.7.0.1
 */