package com.tencent.mm.plugin.location_soso;

import com.tencent.mm.model.ar;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.y;

public class Plugin
  implements c
{
  public static final String TAG = "MicroMsg.Plugin";
  
  public Plugin()
  {
    y.d("MicroMsg.Plugin", "initLoctionInit");
  }
  
  public n createApplication()
  {
    return null;
  }
  
  public ar createSubCore()
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