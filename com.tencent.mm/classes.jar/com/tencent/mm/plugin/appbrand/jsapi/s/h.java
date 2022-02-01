package com.tencent.mm.plugin.appbrand.jsapi.s;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import org.json.JSONObject;

public final class h
  extends a
{
  private static final int CTRL_INDEX = 96;
  private static final String NAME = "showPickerView";
  
  public final void b(g paramg, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(137593);
    new j().a(this, paramg, paramJSONObject, paramInt, bTV());
    AppMethodBeat.o(137593);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.s.h
 * JD-Core Version:    0.7.0.1
 */