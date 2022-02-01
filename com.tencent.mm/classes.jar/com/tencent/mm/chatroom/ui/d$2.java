package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.chatroom.d.aa;
import com.tencent.mm.kernel.c;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.chatroom.a.b;
import com.tencent.mm.storage.aj;

final class d$2
  implements com.tencent.mm.am.h
{
  d$2(ProgressDialog paramProgressDialog, Activity paramActivity, d.a parama) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(12766);
    com.tencent.mm.kernel.h.baD().mCm.b(482, this);
    if (!this.lLp) {
      this.lAK.cancel();
    }
    boolean bool2 = false;
    this.val$activity.getString(a.i.lJm);
    aa localaa = (aa)paramp;
    boolean bool1 = bool2;
    if (paramInt1 == 0)
    {
      bool1 = bool2;
      if (paramInt2 == 0)
      {
        paramp = ((b)com.tencent.mm.kernel.h.ax(b.class)).bzK().Ju(localaa.chatroomName);
        paramString = paramp;
        if (paramp == null) {
          paramString = new aj();
        }
        paramString.pG(z.bAM(), localaa.lyK);
        v.a(paramString);
        bool1 = true;
      }
    }
    if (this.lLq != null) {
      this.lLq.f(bool1, localaa.lyM);
    }
    AppMethodBeat.o(12766);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.d.2
 * JD-Core Version:    0.7.0.1
 */