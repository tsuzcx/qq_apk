package com.tencent.mm.br;

import com.tencent.mm.sdk.platformtools.y;

final class d$3
  implements b
{
  d$3(String paramString) {}
  
  public final void d(Exception paramException)
  {
    y.f("MicroMsg.PluginHelper", "start activity failed, plugin(%s) not loaded", new Object[] { this.soo });
    y.e("MicroMsg.PluginHelper", "start activity failed,%s", new Object[] { paramException });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.br.d.3
 * JD-Core Version:    0.7.0.1
 */