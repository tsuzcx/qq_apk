package com.tencent.mm.plugin.appbrand.jsapi.container;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class b
  extends com.tencent.mm.plugin.appbrand.jsapi.base.b
{
  public static final int CTRL_INDEX = 512;
  public static final String NAME = "removePositioningContainer";
  
  public final int A(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137508);
    int i = paramJSONObject.getInt("containerId");
    AppMethodBeat.o(137508);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.container.b
 * JD-Core Version:    0.7.0.1
 */