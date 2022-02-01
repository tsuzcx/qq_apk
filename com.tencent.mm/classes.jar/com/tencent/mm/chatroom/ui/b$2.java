package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.chatroom.d.x;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.chatroom.a.b;
import com.tencent.mm.storage.ah;

final class b$2
  implements i
{
  b$2(ProgressDialog paramProgressDialog, Activity paramActivity, b.a parama) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(12766);
    h.aHF().kcd.b(482, this);
    if (!this.jiK) {
      this.iYO.cancel();
    }
    boolean bool2 = false;
    this.val$activity.getString(a.i.jgW);
    x localx = (x)paramq;
    boolean bool1 = bool2;
    if (paramInt1 == 0)
    {
      bool1 = bool2;
      if (paramInt2 == 0)
      {
        paramq = ((b)h.ae(b.class)).bbV().Rw(localx.chatroomName);
        paramString = paramq;
        if (paramq == null) {
          paramString = new ah();
        }
        paramString.nH(z.bcZ(), localx.iWG);
        v.a(paramString);
        bool1 = true;
      }
    }
    if (this.jiL != null) {
      this.jiL.i(bool1, localx.iWI);
    }
    AppMethodBeat.o(12766);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.b.2
 * JD-Core Version:    0.7.0.1
 */