package com.tencent.mm.plugin.masssend.ui;

import android.os.Message;
import com.tencent.mm.ay.j;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.r;

final class a$3
  extends ah
{
  a$3(boolean paramBoolean) {}
  
  public final void handleMessage(Message paramMessage)
  {
    int i = q.Gu();
    if (this.hZO) {
      i &= 0xFFFEFFFF;
    }
    for (;;)
    {
      au.Hx();
      c.Dz().o(34, Integer.valueOf(i));
      au.Hx();
      c.Fv().b(new j("", "", "", "", "", "", "", "", i, "", ""));
      if (!this.hZO) {
        a.adg();
      }
      if (this.hZP != null) {
        this.hZP.a(null, null);
      }
      return;
      i |= 0x10000;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.a.3
 * JD-Core Version:    0.7.0.1
 */