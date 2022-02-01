package com.tencent.mm.plugin.label.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;

final class ContactLabelManagerUI$7
  implements MStorage.IOnStorageChange
{
  ContactLabelManagerUI$7(ContactLabelManagerUI paramContactLabelManagerUI) {}
  
  public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(26214);
    if (!Util.isNullOrNil(paramString)) {
      ContactLabelManagerUI.a(this.yCF);
    }
    AppMethodBeat.o(26214);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelManagerUI.7
 * JD-Core Version:    0.7.0.1
 */