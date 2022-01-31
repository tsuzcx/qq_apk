package com.tencent.mm.plugin.appbrand.launching.precondition;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.report.quality.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class i
  extends a
{
  private static long gMG = 0L;
  
  protected final boolean b(Context paramContext, LaunchParcel paramLaunchParcel)
  {
    Object localObject2 = paramLaunchParcel.appId;
    int i = paramLaunchParcel.fJy;
    Object localObject1 = localObject2;
    if (bk.bl((String)localObject2)) {
      localObject1 = com.tencent.mm.plugin.appbrand.config.g.aed().sj(paramLaunchParcel.username);
    }
    if ((!bk.bl((String)localObject1)) && (i == 0) && (com.tencent.mm.plugin.appbrand.task.g.ba((String)localObject1, i)))
    {
      localObject2 = com.tencent.mm.plugin.appbrand.config.g.aed().sl((String)localObject1);
      if ((localObject2 != null) && (((AppBrandInitConfigWC)localObject2).fEL == i))
      {
        paramLaunchParcel.a((AppBrandInitConfigWC)localObject2);
        ((AppBrandInitConfigWC)localObject2).fPC = new QualitySession(d.aox(), (AppBrandInitConfigWC)localObject2, paramLaunchParcel.gMm);
        ((AppBrandInitConfigWC)localObject2).fPD = false;
        k.a(paramContext, (AppBrandInitConfigWC)localObject2, paramLaunchParcel.gMm);
        return true;
      }
    }
    if (Math.abs(System.currentTimeMillis() - gMG) < 200L)
    {
      y.w("MicroMsg.AppBrand.Precondition.MMLaunchEntry", "start in 200 ms, just return");
      return false;
    }
    gMG = bk.UY();
    y.v("MicroMsg.AppBrand.Precondition.MMLaunchEntry", "[applaunch] start entered %s %d", new Object[] { localObject1, Integer.valueOf(i) });
    localObject2 = "Token@" + i.class.hashCode() + "#" + System.nanoTime();
    new e(paramContext, (String)localObject2).a(paramLaunchParcel);
    y.v("MicroMsg.AppBrand.Precondition.MMLaunchEntry", "start we app with username(%s) and appId(%s) and statObj(%s)", new Object[] { paramLaunchParcel.username, localObject1, paramLaunchParcel.gMm });
    paramLaunchParcel = new Intent(paramContext, AppBrandLaunchProxyUI.class);
    if (!(paramContext instanceof Activity)) {
      paramLaunchParcel.addFlags(268435456);
    }
    paramLaunchParcel.putExtra("extra_from_mm", true);
    paramLaunchParcel.putExtra("extra_entry_token", (String)localObject2);
    paramContext.startActivity(paramLaunchParcel);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.precondition.i
 * JD-Core Version:    0.7.0.1
 */