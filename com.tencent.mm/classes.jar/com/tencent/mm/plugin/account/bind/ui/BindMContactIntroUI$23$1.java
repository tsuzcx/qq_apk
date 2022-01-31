package com.tencent.mm.plugin.account.bind.ui;

import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class BindMContactIntroUI$23$1
  implements n.c
{
  BindMContactIntroUI$23$1(BindMContactIntroUI.23 param23) {}
  
  public final void a(l paraml)
  {
    paraml.setHeaderTitle(a.i.bind_mcontact_list_menu_title);
    if ((this.fbJ.fbI & 0x2) != 0) {
      paraml.fq(0, a.i.bind_mcontact_unbind_mobile_text);
    }
    if ((this.fbJ.fbI & 0x1) != 0) {
      paraml.fq(1, a.i.bind_mcontact_change_privacy);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI.23.1
 * JD-Core Version:    0.7.0.1
 */