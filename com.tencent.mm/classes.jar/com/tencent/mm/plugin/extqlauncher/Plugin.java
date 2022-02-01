package com.tencent.mm.plugin.extqlauncher;

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
    AppMethodBeat.i(24548);
    a locala = new a();
    AppMethodBeat.o(24548);
    return locala;
  }
  
  public be createSubCore()
  {
    AppMethodBeat.i(24547);
    SubCoreExtQLauncher localSubCoreExtQLauncher = new SubCoreExtQLauncher();
    AppMethodBeat.o(24547);
    return localSubCoreExtQLauncher;
  }
  
  public c getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.extqlauncher.Plugin
 * JD-Core Version:    0.7.0.1
 */