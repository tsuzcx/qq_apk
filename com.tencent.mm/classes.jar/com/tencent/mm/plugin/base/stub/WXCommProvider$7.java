package com.tencent.mm.plugin.base.stub;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.bk.a;
import com.tencent.mm.network.e;
import com.tencent.mm.pluginsdk.d.a.b;
import com.tencent.mm.sdk.platformtools.ab;

final class WXCommProvider$7
  implements Runnable
{
  WXCommProvider$7(WXCommProvider paramWXCommProvider, b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(18171);
    try
    {
      boolean bool = aw.RG();
      if (!bool)
      {
        AppMethodBeat.o(18171);
        return;
      }
      aw.Rc().a(new bk(new bk.a()
      {
        public final void a(e paramAnonymouse)
        {
          AppMethodBeat.i(18170);
          ab.i("MicroMsg.WXCommProvider", "checkIsLogin() onSceneEnd()");
          WXCommProvider.7.this.jMg.countDown();
          AppMethodBeat.o(18170);
        }
      }), 0);
      AppMethodBeat.o(18171);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.WXCommProvider", "exception in NetSceneLocalProxy");
      this.jMg.countDown();
      AppMethodBeat.o(18171);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.WXCommProvider.7
 * JD-Core Version:    0.7.0.1
 */