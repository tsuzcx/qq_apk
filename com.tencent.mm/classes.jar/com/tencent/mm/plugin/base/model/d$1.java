package com.tencent.mm.plugin.base.model;

import android.content.Context;
import com.tencent.mm.model.am.b.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;

final class d$1
  implements am.b.a
{
  d$1(d.a parama, String paramString1, Context paramContext, String paramString2) {}
  
  public final void m(String paramString, boolean paramBoolean)
  {
    y.i("MicroMsg.WebviewShrotcutManager", "getContactCallBack, suc = %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean) {
      if (this.hRN != null) {
        this.hRN.el(false);
      }
    }
    do
    {
      return;
      au.Hx();
      paramString = c.Fw().abl(this.dol);
      if ((paramString != null) && (!bk.bl(paramString.Bp()))) {
        break;
      }
    } while (this.hRN == null);
    this.hRN.el(false);
    return;
    d.a(this.val$context, this.dol, this.gge, paramString.Bp(), this.hRN);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.base.model.d.1
 * JD-Core Version:    0.7.0.1
 */