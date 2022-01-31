package com.tencent.mm.chatroom.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.u;

final class SeeAccessVerifyInfoUI$2
  implements View.OnClickListener
{
  SeeAccessVerifyInfoUI$2(SeeAccessVerifyInfoUI paramSeeAccessVerifyInfoUI) {}
  
  public final void onClick(View paramView)
  {
    ad localad = ((j)g.r(j.class)).Fw().abl(bk.pm(SeeAccessVerifyInfoUI.a(this.dqZ)));
    String str = localad.field_nickname;
    paramView = null;
    if (SeeAccessVerifyInfoUI.b(this.dqZ) != null) {
      paramView = SeeAccessVerifyInfoUI.b(this.dqZ).gV(SeeAccessVerifyInfoUI.a(this.dqZ));
    }
    Object localObject = paramView;
    if (bk.bl(paramView)) {
      localObject = localad.Bq();
    }
    SeeAccessVerifyInfoUI.a(this.dqZ, SeeAccessVerifyInfoUI.a(this.dqZ), (String)localObject, str, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SeeAccessVerifyInfoUI.2
 * JD-Core Version:    0.7.0.1
 */