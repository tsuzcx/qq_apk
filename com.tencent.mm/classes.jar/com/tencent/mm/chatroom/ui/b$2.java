package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.af;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.storage.u;

final class b$2
  implements f
{
  b$2(ProgressDialog paramProgressDialog, Activity paramActivity, b.a parama) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    g.DO().dJT.b(482, this);
    if (!this.dqo) {
      this.doh.cancel();
    }
    boolean bool2 = false;
    this.val$activity.getString(a.i.room_upgrade_result_failed);
    com.tencent.mm.chatroom.c.q localq = (com.tencent.mm.chatroom.c.q)paramm;
    boolean bool1 = bool2;
    if (paramInt1 == 0)
    {
      bool1 = bool2;
      if (paramInt2 == 0)
      {
        paramm = ((c)g.r(c.class)).FF().in(localq.chatroomName);
        paramString = paramm;
        if (paramm == null) {
          paramString = new u();
        }
        paramString.gn(com.tencent.mm.model.q.Gj(), localq.dnf);
        com.tencent.mm.model.m.a(paramString);
        bool1 = true;
      }
    }
    if (this.dqp != null) {
      this.dqp.c(bool1, localq.dnh);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.b.2
 * JD-Core Version:    0.7.0.1
 */