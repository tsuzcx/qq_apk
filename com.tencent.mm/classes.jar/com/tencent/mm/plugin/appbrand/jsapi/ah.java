package com.tencent.mm.plugin.appbrand.jsapi;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.game.l;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.u.h;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.statusbar.a;
import java.util.Map;

public final class ah
  extends ai<p>
{
  public static final int CTRL_INDEX = 40;
  public static final String NAME = "getSystemInfo";
  private float ggb = -1.0F;
  
  private Map<String, Object> d(p paramp)
  {
    Map localMap = super.b(paramp);
    if ((paramp.getRuntime() != null) && (paramp.getRuntime().ZH()))
    {
      Point localPoint = new Point();
      l.gav.d(localPoint);
      localMap.put("screenWidth", Integer.valueOf(h.mx(localPoint.x)));
      localMap.put("screenHeight", Integer.valueOf(h.mx(localPoint.y)));
    }
    int j = a.ae(paramp.F(Activity.class));
    int i = j;
    if (j <= 0) {
      i = s.gO(paramp.getContext());
    }
    localMap.put("statusBarHeight", Integer.valueOf(h.mx(i)));
    localMap.put("language", x.fB(paramp.getContext()));
    localMap.put("version", e.ag(null, d.spa));
    localMap.put("benchmarkLevel", Integer.valueOf(paramp.getRuntime().aaa().fQo));
    i = paramp.getContext().getResources().getConfiguration().orientation;
    if (2 == i) {
      localMap.put("deviceOrientation", "landscape");
    }
    while (this.ggb != -1.0F)
    {
      localMap.put("fontSizeSetting", Integer.valueOf((int)(this.ggb * 16.0F)));
      return localMap;
      if (1 == i) {
        localMap.put("deviceOrientation", "portrait");
      }
    }
    float f = paramp.getContext().getSharedPreferences(ae.cqR(), 0).getFloat("text_size_scale_key", 1.0F);
    localMap.put("fontSizeSetting", Integer.valueOf((int)(f * 16.0F)));
    this.ggb = f;
    return localMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ah
 * JD-Core Version:    0.7.0.1
 */