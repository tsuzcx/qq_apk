package com.tencent.mm.plugin.ext.provider;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.fj;
import com.tencent.mm.g.a.fj.b;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;

final class ExtControlProviderMsg$2
  implements Runnable
{
  ExtControlProviderMsg$2(ExtControlProviderMsg paramExtControlProviderMsg, ad paramad, String[] paramArrayOfString, com.tencent.mm.pluginsdk.d.a.b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(20350);
    Object localObject = new fj();
    ((fj)localObject).ctr.toUserName = this.meA.field_username;
    ((fj)localObject).ctr.content = this.eut[1];
    ((fj)localObject).ctr.type = t.oF(this.meA.field_username);
    ((fj)localObject).ctr.flags = 0;
    if (!com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject))
    {
      this.mez.vA(4);
      this.jMg.countDown();
      AppMethodBeat.o(20350);
      return;
    }
    m localm = ((fj)localObject).cts.ctt;
    try
    {
      localObject = new ExtControlProviderMsg.2.1(this, com.tencent.mm.plugin.ext.a.a.jF(((fj)localObject).cts.cpO));
      aw.Rc().a(522, (f)localObject);
      aw.Rc().a(localm, 0);
      AppMethodBeat.o(20350);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.ExtControlProviderMsg", localException.getMessage());
      ab.printErrStackTrace("MicroMsg.ExtControlProviderMsg", localException, "", new Object[0]);
      this.mez.vA(4);
      this.jMg.countDown();
      AppMethodBeat.o(20350);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.provider.ExtControlProviderMsg.2
 * JD-Core Version:    0.7.0.1
 */