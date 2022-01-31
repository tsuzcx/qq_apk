package com.tencent.mm.plugin.bottle.ui;

import android.os.Message;
import com.tencent.mm.ay.f;
import com.tencent.mm.ay.j;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.bottle.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.r;

final class e$3
  extends ah
{
  e$3(boolean paramBoolean) {}
  
  public final void handleMessage(Message paramMessage)
  {
    boolean bool = this.hZO;
    int i = q.Gn();
    int j = q.Gu();
    if (bool)
    {
      i |= 0x1000;
      j &= 0xFFFFFFBF;
      au.Hx();
      c.Fv().b(new f(11, 1));
    }
    for (;;)
    {
      au.Hx();
      c.Dz().o(7, Integer.valueOf(i));
      au.Hx();
      c.Dz().o(34, Integer.valueOf(j));
      au.Hx();
      c.Fv().b(new j("", "", "", "", "", "", "", "", j, "", ""));
      if (!this.hZO) {
        i.awO();
      }
      if (this.hZP != null) {
        this.hZP.a(null, null);
      }
      return;
      i &= 0xFFFFEFFF;
      j |= 0x40;
      au.Hx();
      c.Fv().b(new f(11, 2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.ui.e.3
 * JD-Core Version:    0.7.0.1
 */