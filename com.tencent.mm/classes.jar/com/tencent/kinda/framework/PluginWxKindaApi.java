package com.tencent.kinda.framework;

import com.tencent.kinda.framework.api.IPluginWxKindaApi;
import com.tencent.kinda.framework.app.SubCoreKinda;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.u;
import com.tencent.mm.pluginsdk.wallet.a;

public class PluginWxKindaApi
  extends f
  implements IPluginWxKindaApi, c
{
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(18262);
    if (paramg.akL())
    {
      pin(new u(SubCoreKinda.class));
      com.tencent.mm.kernel.g.b(a.class, new WxCrossServices());
    }
    AppMethodBeat.o(18262);
  }
  
  public void dependency() {}
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(18263);
    AppMethodBeat.o(18263);
  }
  
  public void installed()
  {
    AppMethodBeat.i(18261);
    alias(PluginWxKindaApi.class);
    AppMethodBeat.o(18261);
  }
  
  public String name()
  {
    return "plugin-wxkindaapi";
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(193126);
    WxCrossServices.judgeReprot();
    AppMethodBeat.o(193126);
  }
  
  public void onAccountRelease() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.framework.PluginWxKindaApi
 * JD-Core Version:    0.7.0.1
 */