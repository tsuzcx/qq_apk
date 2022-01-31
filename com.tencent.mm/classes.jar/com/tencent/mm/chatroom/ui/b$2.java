package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.chatroom.c.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.n;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.storage.u;

final class b$2
  implements f
{
  b$2(ProgressDialog paramProgressDialog, Activity paramActivity, b.a parama) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(104218);
    g.RK().eHt.b(482, this);
    if (!this.ehM) {
      this.efE.cancel();
    }
    boolean bool2 = false;
    this.val$activity.getString(2131302814);
    q localq = (q)paramm;
    boolean bool1 = bool2;
    if (paramInt1 == 0)
    {
      bool1 = bool2;
      if (paramInt2 == 0)
      {
        paramm = ((c)g.E(c.class)).YJ().oU(localq.chatroomName);
        paramString = paramm;
        if (paramm == null) {
          paramString = new u();
        }
        paramString.io(r.Zn(), localq.eeG);
        n.a(paramString);
        bool1 = true;
      }
    }
    if (this.ehN != null) {
      this.ehN.f(bool1, localq.eeI);
    }
    AppMethodBeat.o(104218);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.b.2
 * JD-Core Version:    0.7.0.1
 */