package com.tencent.mm.br;

import com.tencent.mm.sdk.platformtools.y;

final class d$6
  implements b
{
  d$6(String paramString) {}
  
  public final void d(Exception paramException)
  {
    y.e("MicroMsg.PluginHelper", "start wizard activity failed, plugin(%s) not loaded", new Object[] { this.soo });
    y.e("MicroMsg.PluginHelper", "start wizard activity with exception:%s", new Object[] { paramException });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.br.d.6
 * JD-Core Version:    0.7.0.1
 */