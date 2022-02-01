package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.chatroom.d.x;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.storage.ah;

final class b$2
  implements i
{
  b$2(ProgressDialog paramProgressDialog, Activity paramActivity, b.a parama) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(12766);
    g.aAg().hqi.b(482, this);
    if (!this.gyH) {
      this.guD.cancel();
    }
    boolean bool2 = false;
    this.val$activity.getString(2131764809);
    x localx = (x)paramq;
    boolean bool1 = bool2;
    if (paramInt1 == 0)
    {
      bool1 = bool2;
      if (paramInt2 == 0)
      {
        paramq = ((c)g.af(c.class)).aSX().Kd(localx.chatroomName);
        paramString = paramq;
        if (paramq == null) {
          paramString = new ah();
        }
        paramString.mQ(z.aTY(), localx.gsv);
        v.a(paramString);
        bool1 = true;
      }
    }
    if (this.gyI != null) {
      this.gyI.g(bool1, localx.gsw);
    }
    AppMethodBeat.o(12766);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.b.2
 * JD-Core Version:    0.7.0.1
 */