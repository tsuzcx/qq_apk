package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.chatroom.a.c;

final class b$2
  implements com.tencent.mm.ak.g
{
  b$2(ProgressDialog paramProgressDialog, Activity paramActivity, b.a parama) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(12766);
    com.tencent.mm.kernel.g.agQ().ghe.b(482, this);
    if (!this.fyh) {
      this.fuk.cancel();
    }
    boolean bool2 = false;
    this.val$activity.getString(2131762726);
    com.tencent.mm.chatroom.d.x localx = (com.tencent.mm.chatroom.d.x)paramn;
    boolean bool1 = bool2;
    if (paramInt1 == 0)
    {
      bool1 = bool2;
      if (paramInt2 == 0)
      {
        paramn = ((c)com.tencent.mm.kernel.g.ab(c.class)).awK().xN(localx.chatroomName);
        paramString = paramn;
        if (paramn == null) {
          paramString = new com.tencent.mm.storage.x();
        }
        paramString.lx(u.axw(), localx.fsG);
        com.tencent.mm.model.q.a(paramString);
        bool1 = true;
      }
    }
    if (this.fyi != null) {
      this.fyi.h(bool1, localx.fsH);
    }
    AppMethodBeat.o(12766);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.b.2
 * JD-Core Version:    0.7.0.1
 */