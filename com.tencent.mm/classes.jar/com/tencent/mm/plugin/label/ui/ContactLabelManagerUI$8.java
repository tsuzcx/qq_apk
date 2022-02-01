package com.tencent.mm.plugin.label.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;

final class ContactLabelManagerUI$8
  implements MStorage.IOnStorageChange
{
  ContactLabelManagerUI$8(ContactLabelManagerUI paramContactLabelManagerUI) {}
  
  public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(26214);
    if (!Util.isNullOrNil(paramString)) {
      ContactLabelManagerUI.a(this.EdX);
    }
    AppMethodBeat.o(26214);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelManagerUI.8
 * JD-Core Version:    0.7.0.1
 */