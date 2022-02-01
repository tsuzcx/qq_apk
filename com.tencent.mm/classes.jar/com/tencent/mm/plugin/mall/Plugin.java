package com.tencent.mm.plugin.mall;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ax;
import com.tencent.mm.plugin.mall.a.k;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.n;

public class Plugin
  implements d
{
  public n createApplication()
  {
    return null;
  }
  
  public ax createSubCore()
  {
    AppMethodBeat.i(65986);
    k localk = new k();
    AppMethodBeat.o(65986);
    return localk;
  }
  
  public c getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.Plugin
 * JD-Core Version:    0.7.0.1
 */