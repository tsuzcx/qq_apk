package com.tencent.kinda.framework;

import com.tencent.kinda.framework.api.IPluginWxKindaApi;
import com.tencent.kinda.framework.app.SubCoreKinda;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.model.t;
import com.tencent.mm.pluginsdk.wallet.a;

public class PluginWxKindaApi
  extends f
  implements IPluginWxKindaApi
{
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(18262);
    if (paramg.ahL())
    {
      pin(new t(SubCoreKinda.class));
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.framework.PluginWxKindaApi
 * JD-Core Version:    0.7.0.1
 */