package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.chatroom.d.x;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.al;
import com.tencent.mm.model.r;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.storage.ac;

final class b$2
  implements f
{
  b$2(ProgressDialog paramProgressDialog, Activity paramActivity, b.a parama) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(12766);
    g.ajQ().gDv.b(482, this);
    if (!this.fTA) {
      this.fPt.cancel();
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
        paramn = ((c)g.ab(c.class)).azP().Bx(localx.chatroomName);
        paramString = paramn;
        if (paramn == null) {
          paramString = new ac();
        }
        paramString.mc(v.aAC(), localx.fNk);
        r.a(paramString);
        bool1 = true;
      }
    }
    if (this.fTB != null) {
      this.fTB.h(bool1, localx.fNl);
    }
    AppMethodBeat.o(12766);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.b.2
 * JD-Core Version:    0.7.0.1
 */