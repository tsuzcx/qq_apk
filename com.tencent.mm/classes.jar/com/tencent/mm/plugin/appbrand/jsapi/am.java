package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.luggage.h.f.c;
import com.tencent.luggage.sdk.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

public final class am
  extends d<k>
{
  public static final int CTRL_INDEX = 58;
  public static final String NAME = "addCard";
  int csv;
  final int lyj;
  
  public am()
  {
    AppMethodBeat.i(174749);
    this.lyj = a.aK(this);
    AppMethodBeat.o(174749);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.am
 * JD-Core Version:    0.7.0.1
 */