package com.tencent.mm.plugin.appbrand.jsapi.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import org.json.JSONObject;

public final class c
  extends com.tencent.mm.plugin.appbrand.jsapi.c
{
  public static final int CTRL_INDEX = 72;
  public static final String NAME = "chooseContact";
  private final d rSt;
  
  public c()
  {
    AppMethodBeat.i(137497);
    this.rSt = new d();
    AppMethodBeat.o(137497);
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(137498);
    this.rSt.a(paramf, paramJSONObject, paramInt);
    AppMethodBeat.o(137498);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.c
 * JD-Core Version:    0.7.0.1
 */