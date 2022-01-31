package com.tencent.kinda.framework;

import com.tencent.kinda.framework.api.IPluginWxKindaApi;
import com.tencent.kinda.framework.app.SubCoreKinda;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.model.q;
import com.tencent.mm.pluginsdk.wallet.b;

public class PluginWxKindaApi
  extends f
  implements IPluginWxKindaApi
{
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(144237);
    if (paramg.SD())
    {
      pin(new q(SubCoreKinda.class));
      com.tencent.mm.kernel.g.b(b.class, new WxCrossServices());
    }
    AppMethodBeat.o(144237);
  }
  
  public void dependency() {}
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(144238);
    paramg.SD();
    AppMethodBeat.o(144238);
  }
  
  public void installed()
  {
    AppMethodBeat.i(144236);
    alias(PluginWxKindaApi.class);
    AppMethodBeat.o(144236);
  }
  
  public String name()
  {
    return "plugin-wxkindaapi";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.PluginWxKindaApi
 * JD-Core Version:    0.7.0.1
 */