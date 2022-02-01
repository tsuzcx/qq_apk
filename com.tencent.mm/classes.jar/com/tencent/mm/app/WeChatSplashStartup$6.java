package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.splash.a;
import com.tencent.mm.splash.h;
import com.tencent.mm.splash.o.a;
import com.tencent.mm.vfs.e;

final class WeChatSplashStartup$6
  implements com.tencent.mm.kernel.api.g
{
  WeChatSplashStartup$6(WeChatSplashStartup paramWeChatSplashStartup, boolean paramBoolean, o.a parama) {}
  
  public final void MP()
  {
    AppMethodBeat.i(160049);
    com.tencent.mm.kernel.g.ajD().b(this);
    if (!this.cVw)
    {
      this.cVs.done();
      AppMethodBeat.o(160049);
      return;
    }
    h.b("MicroMsg.FigLeaf", "deleteRequest ", new Object[0]);
    Object localObject = a.fnh();
    if (!new e((String)localObject).exists())
    {
      h.b("MicroMsg.FigLeaf", "deleteRequest dex opt dir not exists.", new Object[0]);
      AppMethodBeat.o(160049);
      return;
    }
    localObject = new e((String)localObject + "/main-process-blocking");
    if (((e)localObject).exists()) {
      h.b("MicroMsg.FigLeaf", "deleteRequest result %s.", new Object[] { Boolean.valueOf(((e)localObject).delete()) });
    }
    AppMethodBeat.o(160049);
  }
  
  public final void cg(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.WeChatSplashStartup.6
 * JD-Core Version:    0.7.0.1
 */