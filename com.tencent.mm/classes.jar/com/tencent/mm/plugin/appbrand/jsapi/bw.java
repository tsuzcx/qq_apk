package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.luggage.l.e.c;
import com.tencent.luggage.sdk.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class bw
  extends c<k>
{
  public static final int CTRL_INDEX = 62;
  public static final String NAME = "openAddress";
  private final int rzC;
  
  public bw()
  {
    AppMethodBeat.i(174754);
    this.rzC = a.ce(this);
    AppMethodBeat.o(174754);
  }
  
  protected void a(Intent paramIntent, k paramk, JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bw
 * JD-Core Version:    0.7.0.1
 */