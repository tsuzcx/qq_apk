package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.splash.a;
import com.tencent.mm.splash.h;
import com.tencent.mm.splash.o.a;
import java.io.File;

final class WeChatSplashStartup$4
  implements com.tencent.mm.kernel.api.g
{
  WeChatSplashStartup$4(WeChatSplashStartup paramWeChatSplashStartup, boolean paramBoolean, o.a parama) {}
  
  public final void BN()
  {
    AppMethodBeat.i(137943);
    com.tencent.mm.kernel.g.RM().b(this);
    if (!this.bZv)
    {
      this.bZq.done();
      AppMethodBeat.o(137943);
      return;
    }
    h.c("MicroMsg.FigLeaf", "deleteRequest ", new Object[0]);
    Object localObject = a.dvl();
    if (!new File((String)localObject).exists())
    {
      h.c("MicroMsg.FigLeaf", "deleteRequest dex opt dir not exists.", new Object[0]);
      AppMethodBeat.o(137943);
      return;
    }
    localObject = new File((String)localObject + "/main-process-blocking");
    if (((File)localObject).exists()) {
      h.c("MicroMsg.FigLeaf", "deleteRequest result %s.", new Object[] { Boolean.valueOf(((File)localObject).delete()) });
    }
    AppMethodBeat.o(137943);
  }
  
  public final void br(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.WeChatSplashStartup.4
 * JD-Core Version:    0.7.0.1
 */