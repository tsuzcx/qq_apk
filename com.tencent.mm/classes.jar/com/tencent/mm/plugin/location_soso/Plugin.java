package com.tencent.mm.plugin.location_soso;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.o;
import com.tencent.mm.sdk.platformtools.ab;

public class Plugin
  implements c
{
  public static final String TAG = "MicroMsg.Plugin";
  
  public Plugin()
  {
    AppMethodBeat.i(113762);
    ab.d("MicroMsg.Plugin", "initLoctionInit");
    AppMethodBeat.o(113762);
  }
  
  public o createApplication()
  {
    return null;
  }
  
  public at createSubCore()
  {
    return null;
  }
  
  public b getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.location_soso.Plugin
 * JD-Core Version:    0.7.0.1
 */