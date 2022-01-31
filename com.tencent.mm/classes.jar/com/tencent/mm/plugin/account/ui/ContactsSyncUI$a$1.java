package com.tencent.mm.plugin.account.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.w.a;

final class ContactsSyncUI$a$1
  implements w.a
{
  ContactsSyncUI$a$1(ContactsSyncUI.a parama) {}
  
  public final void t(Bundle paramBundle)
  {
    AppMethodBeat.i(124744);
    ContactsSyncUI localContactsSyncUI = this.gCD.gCA;
    localContactsSyncUI.gCy = paramBundle;
    localContactsSyncUI.finish();
    AppMethodBeat.o(124744);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.ContactsSyncUI.a.1
 * JD-Core Version:    0.7.0.1
 */