package com.tencent.mm.chatroom.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.u;

final class SeeAccessVerifyInfoUI$2
  implements View.OnClickListener
{
  SeeAccessVerifyInfoUI$2(SeeAccessVerifyInfoUI paramSeeAccessVerifyInfoUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(104262);
    ad localad = ((j)g.E(j.class)).YA().arw(bo.nullAsNil(SeeAccessVerifyInfoUI.a(this.eiF)));
    String str = localad.field_nickname;
    paramView = null;
    if (SeeAccessVerifyInfoUI.b(this.eiF) != null) {
      paramView = SeeAccessVerifyInfoUI.b(this.eiF).nE(SeeAccessVerifyInfoUI.a(this.eiF));
    }
    Object localObject = paramView;
    if (bo.isNullOrNil(paramView)) {
      localObject = localad.Of();
    }
    SeeAccessVerifyInfoUI.a(this.eiF, SeeAccessVerifyInfoUI.a(this.eiF), (String)localObject, str, false);
    AppMethodBeat.o(104262);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SeeAccessVerifyInfoUI.2
 * JD-Core Version:    0.7.0.1
 */