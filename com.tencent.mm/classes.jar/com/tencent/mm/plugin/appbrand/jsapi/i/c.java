package com.tencent.mm.plugin.appbrand.jsapi.i;

import android.content.Intent;
import com.tencent.luggage.h.f.c;
import com.tencent.luggage.sdk.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;

public final class c
  extends d<s>
{
  public static final int CTRL_INDEX = 103;
  public static final String NAME = "chooseLocation";
  final int lWV;
  
  public c()
  {
    AppMethodBeat.i(174838);
    this.lWV = a.aK(this);
    AppMethodBeat.o(174838);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.c
 * JD-Core Version:    0.7.0.1
 */