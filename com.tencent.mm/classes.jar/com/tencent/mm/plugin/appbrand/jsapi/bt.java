package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.luggage.h.f.c;
import com.tencent.luggage.sdk.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class bt
  extends d<k>
{
  public static final int CTRL_INDEX = 62;
  public static final String NAME = "openAddress";
  private final int lAS;
  
  public bt()
  {
    AppMethodBeat.i(174754);
    this.lAS = a.aK(this);
    AppMethodBeat.o(174754);
  }
  
  protected void a(Intent paramIntent, k paramk, JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bt
 * JD-Core Version:    0.7.0.1
 */