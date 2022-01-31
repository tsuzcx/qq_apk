package com.tencent.mm.chatroom.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.u;
import java.util.List;

final class SeeAccessVerifyInfoUI$b$1
  implements View.OnClickListener
{
  SeeAccessVerifyInfoUI$b$1(SeeAccessVerifyInfoUI.b paramb, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    String str = ((SeeAccessVerifyInfoUI.a)this.dre.drc.get(this.kX)).nickname;
    paramView = null;
    if (SeeAccessVerifyInfoUI.b(this.dre.dqZ) != null) {
      paramView = SeeAccessVerifyInfoUI.b(this.dre.dqZ).gV(((SeeAccessVerifyInfoUI.a)this.dre.drc.get(this.kX)).username);
    }
    if (bk.bl(paramView)) {
      paramView = ((j)g.r(j.class)).Fw().abl(bk.pm(((SeeAccessVerifyInfoUI.a)this.dre.drc.get(this.kX)).username)).Bq();
    }
    for (;;)
    {
      SeeAccessVerifyInfoUI.a(this.dre.dqZ, ((SeeAccessVerifyInfoUI.a)this.dre.drc.get(this.kX)).username, paramView, str, true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SeeAccessVerifyInfoUI.b.1
 * JD-Core Version:    0.7.0.1
 */