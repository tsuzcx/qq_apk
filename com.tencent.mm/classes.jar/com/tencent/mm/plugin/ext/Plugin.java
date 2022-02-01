package com.tencent.mm.plugin.ext;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.be;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.c.d;
import com.tencent.mm.pluginsdk.n;

public class Plugin
  implements d
{
  public n createApplication()
  {
    AppMethodBeat.i(24334);
    a locala = new a();
    AppMethodBeat.o(24334);
    return locala;
  }
  
  public be createSubCore()
  {
    AppMethodBeat.i(24333);
    SubCoreExt localSubCoreExt = new SubCoreExt();
    AppMethodBeat.o(24333);
    return localSubCoreExt;
  }
  
  public c getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.Plugin
 * JD-Core Version:    0.7.0.1
 */