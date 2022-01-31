package com.tencent.mm.app;

import com.tencent.mm.splash.a;
import com.tencent.mm.splash.i;
import com.tencent.mm.splash.p.a;
import java.io.File;

final class WeChatSplashStartup$3
  implements com.tencent.mm.kernel.api.g
{
  WeChatSplashStartup$3(WeChatSplashStartup paramWeChatSplashStartup, boolean paramBoolean, p.a parama) {}
  
  public final void aP(boolean paramBoolean) {}
  
  public final void tj()
  {
    com.tencent.mm.kernel.g.DQ().b(this);
    if (!this.bxu) {
      this.bxo.done();
    }
    Object localObject;
    do
    {
      return;
      i.c("MicroMsg.FigLeaf", "deleteRequest ", new Object[0]);
      localObject = a.csN();
      if (!new File((String)localObject).exists())
      {
        i.c("MicroMsg.FigLeaf", "deleteRequest dex opt dir not exists.", new Object[0]);
        return;
      }
      localObject = new File((String)localObject + "/main-process-blocking");
    } while (!((File)localObject).exists());
    i.c("MicroMsg.FigLeaf", "deleteRequest result %s.", new Object[] { Boolean.valueOf(((File)localObject).delete()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.app.WeChatSplashStartup.3
 * JD-Core Version:    0.7.0.1
 */