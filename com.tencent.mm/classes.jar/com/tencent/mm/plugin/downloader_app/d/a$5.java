package com.tencent.mm.plugin.downloader_app.d;

import android.app.ProgressDialog;
import android.content.Context;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.c.bev;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.z;

final class a$5
  implements Runnable
{
  a$5(a parama, boolean paramBoolean, ProgressDialog paramProgressDialog, Context paramContext) {}
  
  public final void run()
  {
    boolean bool = this.hZO;
    int i = q.Gu();
    bev localbev;
    if (bool)
    {
      i &= 0xF7FFFFFF;
      g.DP().Dz().o(34, Integer.valueOf(i));
      localbev = new bev();
      localbev.stP = 134217728;
      if (!bool) {
        break label142;
      }
    }
    label142:
    for (i = 0;; i = 1)
    {
      localbev.tzI = i;
      ((j)g.r(j.class)).Fv().b(new i.a(39, localbev));
      if (!this.hZO)
      {
        bd.iL("downloaderapp");
        ((j)g.r(j.class)).FB().abu("downloaderapp");
      }
      ai.l(new a.5.1(this), 1000L);
      return;
      i |= 0x8000000;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.d.a.5
 * JD-Core Version:    0.7.0.1
 */