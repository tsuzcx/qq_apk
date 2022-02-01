package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.chatroom.d.x;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.storage.w;

final class b$2
  implements com.tencent.mm.al.g
{
  b$2(ProgressDialog paramProgressDialog, Activity paramActivity, b.a parama) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(12766);
    com.tencent.mm.kernel.g.afA().gcy.b(482, this);
    if (!this.fuA) {
      this.fqF.cancel();
    }
    boolean bool2 = false;
    this.val$activity.getString(2131762726);
    x localx = (x)paramn;
    boolean bool1 = bool2;
    if (paramInt1 == 0)
    {
      bool1 = bool2;
      if (paramInt2 == 0)
      {
        paramn = ((c)com.tencent.mm.kernel.g.ab(c.class)).apV().tH(localx.chatroomName);
        paramString = paramn;
        if (paramn == null) {
          paramString = new w();
        }
        paramString.la(u.aqG(), localx.fpg);
        com.tencent.mm.model.q.a(paramString);
        bool1 = true;
      }
    }
    if (this.fuB != null) {
      this.fuB.h(bool1, localx.fph);
    }
    AppMethodBeat.o(12766);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.b.2
 * JD-Core Version:    0.7.0.1
 */