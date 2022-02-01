package com.tencent.mm.plugin.location;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.be;
import com.tencent.mm.plugin.location.model.SubCoreLocation;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.c.d;
import com.tencent.mm.pluginsdk.n;

public class Plugin
  implements d
{
  public n createApplication()
  {
    AppMethodBeat.i(55666);
    a locala = new a();
    AppMethodBeat.o(55666);
    return locala;
  }
  
  public be createSubCore()
  {
    AppMethodBeat.i(55667);
    SubCoreLocation localSubCoreLocation = new SubCoreLocation();
    AppMethodBeat.o(55667);
    return localSubCoreLocation;
  }
  
  public c getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.Plugin
 * JD-Core Version:    0.7.0.1
 */