package com.tencent.mm.plugin.ext.provider;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bk;
import com.tencent.mm.pluginsdk.d.a.b;
import com.tencent.mm.sdk.platformtools.ab;

final class ExtContentProviderBase$1
  implements Runnable
{
  ExtContentProviderBase$1(ExtContentProviderBase paramExtContentProviderBase, b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(20325);
    try
    {
      boolean bool = aw.RG();
      if (!bool)
      {
        AppMethodBeat.o(20325);
        return;
      }
      aw.Rc().a(new bk(new ExtContentProviderBase.1.1(this)), 0);
      AppMethodBeat.o(20325);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.ExtContentProviderBase", "exception in NetSceneLocalProxy");
      this.jMg.countDown();
      AppMethodBeat.o(20325);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.provider.ExtContentProviderBase.1
 * JD-Core Version:    0.7.0.1
 */