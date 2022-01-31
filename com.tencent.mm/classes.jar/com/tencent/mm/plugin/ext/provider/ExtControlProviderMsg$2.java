package com.tencent.mm.plugin.ext.provider;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.fg;
import com.tencent.mm.h.a.fg.b;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.model.s;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;

final class ExtControlProviderMsg$2
  implements Runnable
{
  ExtControlProviderMsg$2(ExtControlProviderMsg paramExtControlProviderMsg, ad paramad, String[] paramArrayOfString, com.tencent.mm.pluginsdk.d.a.b paramb) {}
  
  public final void run()
  {
    Object localObject = new fg();
    ((fg)localObject).bLX.toUserName = this.jKw.field_username;
    ((fg)localObject).bLX.content = this.dAS[1];
    ((fg)localObject).bLX.type = s.hW(this.jKw.field_username);
    ((fg)localObject).bLX.flags = 0;
    if (!com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject))
    {
      this.jKv.qF(4);
      this.hSx.countDown();
      return;
    }
    m localm = ((fg)localObject).bLY.bLZ;
    try
    {
      localObject = new ExtControlProviderMsg.2.1(this, com.tencent.mm.plugin.ext.a.a.ei(((fg)localObject).bLY.bIt));
      au.Dk().a(522, (f)localObject);
      au.Dk().a(localm, 0);
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.ExtControlProviderMsg", localException.getMessage());
      y.printErrStackTrace("MicroMsg.ExtControlProviderMsg", localException, "", new Object[0]);
      this.jKv.qF(4);
      this.hSx.countDown();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.provider.ExtControlProviderMsg.2
 * JD-Core Version:    0.7.0.1
 */