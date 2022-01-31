package com.tencent.luggage.sdk.b.a.b;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.widget.FrameLayout;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.a.d;
import com.tencent.mm.plugin.appbrand.config.a.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.t;
import java.util.HashMap;
import java.util.Map;

public final class c
{
  public final com.tencent.mm.plugin.appbrand.page.v bBK;
  public boolean bEp;
  public int bEq;
  public int bEr;
  public final Map<String, Object> bEs;
  public boolean bEt;
  private final a.b[] bEu;
  private final t bEv;
  public boolean foreground;
  
  public c(com.tencent.mm.plugin.appbrand.page.v paramv)
  {
    AppMethodBeat.i(140715);
    this.bEp = false;
    this.foreground = false;
    this.bEs = new HashMap();
    this.bEt = false;
    this.bEu = new a.b[] { a.b.hkH, a.b.hkI, a.b.hkG, a.b.hkF };
    this.bEv = new t();
    this.bBK = paramv;
    AppMethodBeat.o(140715);
  }
  
  private <EVENT extends t> void a(EVENT paramEVENT)
  {
    AppMethodBeat.i(140720);
    a.d locald = this.bBK.getPageConfig();
    if (locald == null)
    {
      AppMethodBeat.o(140720);
      return;
    }
    int[] arrayOfInt = com.tencent.mm.plugin.appbrand.t.v.d(this.bBK.ws());
    Map localMap = wt();
    localMap.put("originalPageOrientation", locald.hhw);
    localMap.put("lastPageOrientation", wu());
    paramEVENT.a(this.bBK, this.bBK.hashCode(), this.bBK.ivI.getWidth(), this.bBK.ivI.getHeight(), arrayOfInt[0], arrayOfInt[1], this.bBK.getContext().getResources().getConfiguration().orientation, localMap);
    AppMethodBeat.o(140720);
  }
  
  private Map<String, Object> wt()
  {
    AppMethodBeat.i(140716);
    HashMap localHashMap = new HashMap(this.bEs);
    this.bEs.clear();
    AppMethodBeat.o(140716);
    return localHashMap;
  }
  
  private String wu()
  {
    AppMethodBeat.i(140717);
    Object localObject = (com.tencent.mm.plugin.appbrand.page.b.c)this.bBK.x(com.tencent.mm.plugin.appbrand.page.b.c.class);
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.appbrand.page.b.c)localObject).vz();
      AppMethodBeat.o(140717);
      return localObject;
    }
    AppMethodBeat.o(140717);
    return null;
  }
  
  public final boolean bD(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140718);
    a.b localb2 = com.tencent.mm.plugin.appbrand.config.a.a.zX(wu());
    a.b localb1 = localb2;
    if (localb2 == null) {
      localb1 = a.b.hkD;
    }
    if (org.apache.commons.b.a.contains(this.bEu, localb1))
    {
      if (paramInt1 > paramInt2)
      {
        AppMethodBeat.o(140718);
        return true;
      }
      AppMethodBeat.o(140718);
      return false;
    }
    if (a.b.hkD == localb1)
    {
      if (paramInt2 > paramInt1) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(140718);
        return true;
      }
      label177:
      label187:
      int j;
      if ((Build.VERSION.SDK_INT >= 24) && (com.tencent.mm.sdk.f.a.hr(this.bBK.mContext) != null) && (com.tencent.mm.sdk.f.a.hr(this.bBK.mContext).isInMultiWindowMode()))
      {
        i = 1;
        if (i == 0) {
          break label272;
        }
        if ((com.tencent.mm.plugin.appbrand.config.a.a.s(com.tencent.mm.sdk.f.a.hr(this.bBK.mContext)).dQ(com.tencent.mm.plugin.appbrand.config.a.a.ayK()) != a.b.hkD) && (com.tencent.mm.sdk.f.a.hr(this.bBK.mContext).getRequestedOrientation() != 1)) {
          break label250;
        }
        i = 1;
        if (i == 0) {
          break label266;
        }
        if (paramInt1 <= 0) {
          break label255;
        }
        i = 1;
        if (paramInt2 <= 0) {
          break label260;
        }
        j = 1;
        label194:
        if ((j & i) == 0) {
          break label266;
        }
      }
      label260:
      label266:
      for (boolean bool = true;; bool = false)
      {
        d.i("Luggage.AppBrandPageViewResizedEmitter[pageOrientation]", "isViewSizeMatchedByRequestedOrientation, activityInMultiWindowMode width[%d] height[%d] ret[%b]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
        AppMethodBeat.o(140718);
        return bool;
        i = 0;
        break;
        label250:
        i = 0;
        break label177;
        label255:
        i = 0;
        break label187;
        j = 0;
        break label194;
      }
      label272:
      AppMethodBeat.o(140718);
      return false;
    }
    AppMethodBeat.o(140718);
    return true;
  }
  
  public final void wv()
  {
    AppMethodBeat.i(140719);
    if (!this.bBK.isRunning())
    {
      AppMethodBeat.o(140719);
      return;
    }
    if (this.bEt)
    {
      a(new c.a((byte)0));
      this.bEt = false;
      d.i("Luggage.AppBrandPageViewResizedEmitter[pageOrientation]", "tryDispatchViewDidResize, appId[%s], url[%s], now_orientation[%s], send onAppRouteResized instead", new Object[] { this.bBK.getAppId(), this.bBK.hzM, wu() });
      AppMethodBeat.o(140719);
      return;
    }
    a(this.bEv);
    AppMethodBeat.o(140719);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.b.c
 * JD-Core Version:    0.7.0.1
 */