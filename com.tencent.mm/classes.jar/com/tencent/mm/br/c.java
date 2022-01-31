package com.tencent.mm.br;

import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.p;
import com.tencent.mm.model.p.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.y;

public final class c
{
  public static m som;
  public static l son;
  
  public static void Xg(String paramString)
  {
    if (((h)g.DM().Dr()).Ex()) {
      d.a(paramString, som, son);
    }
  }
  
  public static p.a Xh(String paramString)
  {
    c.2 local2 = new c.2(paramString);
    y.i("MicroMsg.PluginCompatHelper", "CompatSubCore creator %s for plugin %s", new Object[] { local2, paramString });
    return local2;
  }
  
  public static void b(String paramString, p paramp)
  {
    new c.1(paramString, paramp).alone();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.br.c
 * JD-Core Version:    0.7.0.1
 */