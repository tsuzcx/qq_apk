package com.tencent.mm.plugin.favorite;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.n;

public class Plugin
  implements d
{
  public n createApplication()
  {
    AppMethodBeat.i(24609);
    b localb = new b();
    AppMethodBeat.o(24609);
    return localb;
  }
  
  public az createSubCore()
  {
    AppMethodBeat.i(24610);
    f localf = new f();
    AppMethodBeat.o(24610);
    return localf;
  }
  
  public c getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.favorite.Plugin
 * JD-Core Version:    0.7.0.1
 */