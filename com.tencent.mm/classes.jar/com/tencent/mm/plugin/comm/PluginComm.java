package com.tencent.mm.plugin.comm;

import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.pluginsdk.g.a.c.o;
import com.tencent.mm.sdk.platformtools.an;

public class PluginComm
  extends f
  implements com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.comm.a.a
{
  public void configure(com.tencent.mm.kernel.b.g paramg) {}
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    if (paramg.Ex())
    {
      pin(com.tencent.mm.plugin.a.Vh());
      pin(com.tencent.mm.plugin.i.a.aDq());
      pin(com.tencent.mm.plugin.k.a.aFH());
      pin(com.tencent.mm.plugin.n.c.bbt());
      pin(com.tencent.mm.plugin.n.b.bbs());
      pin(com.tencent.mm.plugin.ab.a.brM());
      pin(com.tencent.mm.plugin.r.b.bhF());
      pin(com.tencent.mm.plugin.c.a.YT());
      pin(com.tencent.mm.plugin.z.a.brj());
      pin(com.tencent.mm.plugin.y.a.bos());
      pin(o.rXK);
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.r.a.a.class, new com.tencent.mm.plugin.r.a());
      ((com.tencent.mm.plugin.auth.a.b)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.auth.a.b.class)).addHandleAuthResponse(com.tencent.mm.plugin.i.a.aDq());
      com.tencent.mm.ui.e.a.a.a(new PluginComm.1(this));
    }
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    an.a(new PluginComm.2(this));
  }
  
  public void onAccountRelease()
  {
    an.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.comm.PluginComm
 * JD-Core Version:    0.7.0.1
 */