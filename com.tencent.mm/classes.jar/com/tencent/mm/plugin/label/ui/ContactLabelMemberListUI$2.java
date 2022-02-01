package com.tencent.mm.plugin.label.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;

final class ContactLabelMemberListUI$2
  implements MStorageEx.IOnStorageChange
{
  ContactLabelMemberListUI$2(ContactLabelMemberListUI paramContactLabelMemberListUI) {}
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(26262);
    Log.d("MicroMsg.Label.ContactLabelMemberListUI", "event:%d, obj:%s", new Object[] { Integer.valueOf(paramInt), paramObject });
    if (ContactLabelMemberListUI.b(this.JWc) != null)
    {
      ContactLabelMemberListUI.b(this.JWc).removeMessages(5001);
      ContactLabelMemberListUI.b(this.JWc).sendEmptyMessageDelayed(5001, 300L);
    }
    AppMethodBeat.o(26262);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelMemberListUI.2
 * JD-Core Version:    0.7.0.1
 */