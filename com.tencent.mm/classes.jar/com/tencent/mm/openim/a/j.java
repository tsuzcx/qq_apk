package com.tencent.mm.openim.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.openim.api.c;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.by.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/openim/contact/OpenIMKefuConversationExtension;", "Lcom/tencent/mm/storage/IConversationStorage$IConversationExtension;", "()V", "onContactChange", "com/tencent/mm/openim/contact/OpenIMKefuConversationExtension$onContactChange$1", "Lcom/tencent/mm/openim/contact/OpenIMKefuConversationExtension$onContactChange$1;", "onMsgChangeNotify", "", "cvs", "Lcom/tencent/mm/storage/Conversation;", "stg", "Lcom/tencent/mm/storage/IConversationStorage;", "Companion", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  implements by.a
{
  public static final j.a pse;
  private final j.b psf;
  
  static
  {
    AppMethodBeat.i(236060);
    pse = new j.a((byte)0);
    AppMethodBeat.o(236060);
  }
  
  public j()
  {
    AppMethodBeat.i(236056);
    this.psf = new j.b();
    ((PluginOpenIM)com.tencent.mm.kernel.h.az(PluginOpenIM.class)).getContactStorage().add((MStorage.IOnStorageChange)this.psf);
    AppMethodBeat.o(236056);
  }
  
  public final void a(bb parambb, by paramby)
  {
    AppMethodBeat.i(236066);
    if (parambb == null)
    {
      AppMethodBeat.o(236066);
      return;
    }
    paramby = parambb.field_username;
    if (au.bwQ(paramby))
    {
      Log.i("MicroMsg.OpenIMKefuConversationExtension", "alvinluo onMsgChangeNotify conversation is openim kefu username: %s", new Object[] { paramby });
      parambb.BH("opencustomerservicemsg");
      ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().c(parambb, paramby);
      ((c)com.tencent.mm.kernel.h.ax(c.class)).d(parambb);
      AppMethodBeat.o(236066);
      return;
    }
    if (au.bwD(paramby)) {
      Log.i("MicroMsg.OpenIMKefuConversationExtension", "openImKeService is created");
    }
    AppMethodBeat.o(236066);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.openim.a.j
 * JD-Core Version:    0.7.0.1
 */