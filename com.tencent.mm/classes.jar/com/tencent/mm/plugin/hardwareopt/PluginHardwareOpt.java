package com.tencent.mm.plugin.hardwareopt;

import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.hardwareopt.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.sdk.platformtools.y;

public class PluginHardwareOpt
  extends f
  implements c, b
{
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    if (!paramg.Ex()) {
      return;
    }
    y.v("MicroMsg.PluginHardwareOpt", "hy: on config");
    com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.hardwareopt.a.a.a.class, new com.tencent.mm.plugin.hardwareopt.a.a());
  }
  
  public void dependency()
  {
    dependsOn(p.class);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    if (paramg.Ex()) {
      y.i("MicroMsg.PluginHardwareOpt", "hy: on execute. ");
    }
  }
  
  public void installed()
  {
    alias(b.class);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    y.v("MicroMsg.PluginHardwareOpt", "hy: on onAccountInitialized");
    ((com.tencent.mm.plugin.hardwareopt.a.a.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.hardwareopt.a.a.a.class)).gF(false);
  }
  
  public void onAccountRelease()
  {
    y.v("MicroMsg.PluginHardwareOpt", "hy: on onAccountRelease");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.hardwareopt.PluginHardwareOpt
 * JD-Core Version:    0.7.0.1
 */