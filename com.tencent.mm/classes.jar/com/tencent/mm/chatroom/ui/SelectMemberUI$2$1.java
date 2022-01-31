package com.tencent.mm.chatroom.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMEditText;

final class SelectMemberUI$2$1
  implements ap.a
{
  SelectMemberUI$2$1(SelectMemberUI.2 param2) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(104408);
    ab.d("MicroMsg.SelectMemberUI", "searchEvent onTimerExpired");
    SelectMemberUI.b localb = this.ejL.ejJ.ejE;
    String str = SelectMemberUI.b(this.ejL.ejJ).getText().toString();
    ab.i("MicroMsg.SelectMemberAdapter", "search:%s isLoading:%s", new Object[] { bo.aqg(str), Boolean.valueOf(localb.isLoading) });
    if (!localb.isLoading)
    {
      localb.ejd = str;
      localb.ld(str);
      al.d(new SelectMemberUI.b.2(localb));
    }
    AppMethodBeat.o(104408);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectMemberUI.2.1
 * JD-Core Version:    0.7.0.1
 */