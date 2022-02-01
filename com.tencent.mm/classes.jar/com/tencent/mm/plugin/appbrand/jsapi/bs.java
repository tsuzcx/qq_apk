package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.luggage.k.f.c;
import com.tencent.luggage.sdk.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class bs
  extends c<j>
{
  public static final int CTRL_INDEX = 62;
  public static final String NAME = "openAddress";
  private final int owi;
  
  public bs()
  {
    AppMethodBeat.i(174754);
    this.owi = a.aI(this);
    AppMethodBeat.o(174754);
  }
  
  protected void a(Intent paramIntent, j paramj, JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bs
 * JD-Core Version:    0.7.0.1
 */