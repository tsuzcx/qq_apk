package com.tencent.mm.plugin.location_soso;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.be;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.c.d;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.Log;

public class Plugin
  implements d
{
  public static final String TAG = "MicroMsg.Plugin";
  
  public Plugin()
  {
    AppMethodBeat.i(56228);
    Log.d("MicroMsg.Plugin", "initLoctionInit");
    AppMethodBeat.o(56228);
  }
  
  public n createApplication()
  {
    return null;
  }
  
  public be createSubCore()
  {
    return null;
  }
  
  public c getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.location_soso.Plugin
 * JD-Core Version:    0.7.0.1
 */