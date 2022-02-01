package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import com.tencent.luggage.h.e.c;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.base.h;

public final class j
  extends com.tencent.mm.plugin.appbrand.jsapi.a<c>
{
  public static final int CTRL_INDEX = 74;
  public static final String NAME = "shareTimeline";
  private static boolean llX = false;
  private final int llY;
  
  public j()
  {
    AppMethodBeat.i(180273);
    this.llY = com.tencent.luggage.sdk.g.a.aC(this);
    AppMethodBeat.o(180273);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.j
 * JD-Core Version:    0.7.0.1
 */