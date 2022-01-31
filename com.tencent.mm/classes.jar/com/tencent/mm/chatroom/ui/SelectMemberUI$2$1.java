package com.tencent.mm.chatroom.ui;

import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMEditText;

final class SelectMemberUI$2$1
  implements am.a
{
  SelectMemberUI$2$1(SelectMemberUI.2 param2) {}
  
  public final boolean tC()
  {
    y.d("MicroMsg.SelectMemberUI", "searchEvent onTimerExpired");
    SelectMemberUI.b localb = this.dsd.dsb.drW;
    String str = SelectMemberUI.b(this.dsd.dsb).getText().toString();
    y.i("MicroMsg.SelectMemberAdapter", "search:%s isLoading:%s", new Object[] { bk.aac(str), Boolean.valueOf(localb.isLoading) });
    if (!localb.isLoading)
    {
      localb.drv = str;
      localb.eV(str);
      ai.d(new SelectMemberUI.b.2(localb));
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectMemberUI.2.1
 * JD-Core Version:    0.7.0.1
 */