package com.tencent.mm.plugin.label.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

final class ContactLabelManagerUI$8
  implements n.b
{
  ContactLabelManagerUI$8(ContactLabelManagerUI paramContactLabelManagerUI) {}
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(22593);
    ab.d("MicroMsg.Label.ContactLabelManagerUI", "event:%d, obj:%s", new Object[] { Integer.valueOf(paramInt), paramObject });
    if (ContactLabelManagerUI.c(this.nYI) != null)
    {
      ContactLabelManagerUI.c(this.nYI).removeMessages(5001);
      ContactLabelManagerUI.c(this.nYI).sendEmptyMessageDelayed(5001, 400L);
    }
    AppMethodBeat.o(22593);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelManagerUI.8
 * JD-Core Version:    0.7.0.1
 */