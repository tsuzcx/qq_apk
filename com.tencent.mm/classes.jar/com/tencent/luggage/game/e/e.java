package com.tencent.luggage.game.e;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.ViewGroup;
import android.view.WindowInsets;
import com.tencent.luggage.game.e.a.a.a;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.ah;
import java.util.Map;

public final class e
  extends ar<com.tencent.luggage.sdk.b.a.c.c>
{
  public static final int CTRL_INDEX = 40;
  public static final String NAME = "getSystemInfo";
  private boolean bBc = false;
  
  public final Map<String, Object> a(com.tencent.luggage.sdk.b.a.c.c paramc)
  {
    int n = 1;
    AppMethodBeat.i(140419);
    Map localMap = super.a(paramc);
    int i;
    int i1;
    int i2;
    if ((paramc.wj() != null) && (paramc.x(a.class) != null))
    {
      Object localObject1 = (com.tencent.luggage.game.e.a.a.b)paramc.x(com.tencent.luggage.game.e.a.a.b.class);
      if (localObject1 == null) {
        break label394;
      }
      if (Build.VERSION.SDK_INT < 21) {
        break label327;
      }
      Object localObject2 = paramc.X(Activity.class);
      if (localObject2 != null)
      {
        localObject2 = ah.aC((Activity)localObject2);
        if (localObject2 != null)
        {
          i = ((WindowInsets)localObject2).getStableInsetTop();
          if (i > 0) {
            localMap.put("statusBarHeight", Integer.valueOf(g.pM(i)));
          }
        }
      }
      localObject1 = ((com.tencent.luggage.game.e.a.a.b)localObject1).getMBRuntime();
      i1 = ((MBRuntime)localObject1).getSystemDisplayWidth();
      i2 = ((MBRuntime)localObject1).getSystemDisplayHeight();
      localMap.put("screenWidth", Integer.valueOf(i1));
      localMap.put("screenHeight", Integer.valueOf(i2));
      if ((paramc != null) && (!this.bBc)) {
        this.bBc = true;
      }
    }
    for (;;)
    {
      try
      {
        paramc = paramc.wj().gPC;
        boolean bool = paramc.isLaidOut();
        if (!bool) {
          break label429;
        }
      }
      catch (Exception paramc)
      {
        label327:
        j = 0;
        i = 0;
      }
      try
      {
        i = g.pM(paramc.getMeasuredWidth());
      }
      catch (Exception paramc)
      {
        for (;;)
        {
          j = 1;
          i = 0;
        }
      }
      try
      {
        j = g.pM(paramc.getMeasuredHeight());
        k = 1;
        if ((i != i1) || (j != i2)) {
          break label376;
        }
        m = 1;
        paramc = (com.tencent.mm.plugin.appbrand.o.b)com.tencent.luggage.a.e.r(com.tencent.mm.plugin.appbrand.o.b.class);
        if (paramc != null)
        {
          if (m == 0) {
            break label382;
          }
          m = 1;
          if (k == 0) {
            break label388;
          }
          k = n;
          paramc.e(16892, new Object[] { Integer.valueOf(m), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j) });
        }
        AppMethodBeat.o(140419);
        return localMap;
      }
      catch (Exception paramc)
      {
        j = 1;
        break label364;
      }
      i = af.hU(paramc.getContext());
      if (i <= 0) {
        break;
      }
      localMap.put("statusBarHeight", Integer.valueOf(g.pM(i)));
      break;
      label364:
      int m = 0;
      int k = j;
      int j = m;
      continue;
      label376:
      m = 0;
      continue;
      label382:
      m = -1;
      continue;
      label388:
      k = -1;
      continue;
      label394:
      ab.printErrStackTrace("MicroMsg.WAGameJsApiGetSystemInfo", new com.tencent.luggage.game.e.a.a.c(), "hy: not game service", new Object[0]);
      continue;
      label429:
      k = 0;
      j = 0;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.game.e.e
 * JD-Core Version:    0.7.0.1
 */