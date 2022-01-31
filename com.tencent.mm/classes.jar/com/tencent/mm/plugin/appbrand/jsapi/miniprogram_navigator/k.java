package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import android.app.Activity;
import android.content.Context;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cm.g;
import com.tencent.mm.model.gdpr.a;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.widget.b.k.a;

public class k
  extends h
{
  public static final k hTv;
  
  static
  {
    AppMethodBeat.i(131360);
    hTv = new k();
    AppMethodBeat.o(131360);
  }
  
  protected final k.a B(i parami)
  {
    AppMethodBeat.i(143420);
    Activity localActivity = parami.getContext();
    Object localObject = localActivity;
    if (localActivity == null) {
      localObject = parami.mContext;
    }
    parami = new com.tencent.mm.plugin.appbrand.widget.b.h((Context)localObject);
    AppMethodBeat.o(143420);
    return parami;
  }
  
  public final com.tencent.mm.vending.g.c<AppBrandInitConfigLU> a(d paramd, LaunchParcel paramLaunchParcel)
  {
    AppMethodBeat.i(131359);
    String str = com.tencent.mm.plugin.appbrand.report.quality.f.b(paramd, paramLaunchParcel);
    paramd = g.dTg().b(new k.2(this, paramd, paramLaunchParcel, str));
    AppMethodBeat.o(131359);
    return paramd;
  }
  
  public boolean a(d paramd, LaunchParcel paramLaunchParcel, c.b paramb)
  {
    AppMethodBeat.i(131358);
    if (com.tencent.mm.model.gdpr.c.abL())
    {
      com.tencent.mm.model.gdpr.c.a(paramd.getContext(), a.foy, paramLaunchParcel.appId, new k.1(this, paramb, paramd));
      AppMethodBeat.o(131358);
      return true;
    }
    AppMethodBeat.o(131358);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.k
 * JD-Core Version:    0.7.0.1
 */