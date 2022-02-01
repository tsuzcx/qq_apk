package com.tencent.mm.openim.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.au;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/openim/contact/OpenIMKefuConversationChangeListener;", "Lcom/tencent/mm/sdk/storage/MStorageEx$IOnStorageChange;", "()V", "deleteAllOpenImKefuConversation", "", "onNotifyChange", "event", "", "stg", "Lcom/tencent/mm/sdk/storage/MStorageEx;", "obj", "", "Companion", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  implements MStorageEx.IOnStorageChange
{
  public static final i.a psd;
  
  static
  {
    AppMethodBeat.i(236047);
    psd = new i.a((byte)0);
    AppMethodBeat.o(236047);
  }
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(236053);
    if ((paramInt == 5) && ((paramObject instanceof String)) && (au.bwD((String)paramObject)))
    {
      Log.i("MicroMsg.OpenIMKefuConversationChangeListener", "alvinluo openImKfConversationChangedListener onNotifyChange delete %s", new Object[] { paramObject });
      k.bSd();
    }
    AppMethodBeat.o(236053);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.openim.a.i
 * JD-Core Version:    0.7.0.1
 */