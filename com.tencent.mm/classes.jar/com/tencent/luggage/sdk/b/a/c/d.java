package com.tencent.luggage.sdk.b.a.c;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.b.d;
import com.tencent.mm.plugin.appbrand.jsapi.aa;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.platform.window.a.o;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.plugin.appbrand.platform.window.e;
import com.tencent.mm.plugin.appbrand.platform.window.e.b;
import com.tencent.mm.plugin.appbrand.utils.aq;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.c.a;

public final class d
{
  public final ad enm;
  public boolean erZ;
  private int esa;
  private int esb;
  private final Map<String, Object> esc;
  public boolean esd;
  private final aa ese;
  public boolean foreground;
  
  public d(ad paramad)
  {
    AppMethodBeat.i(146782);
    this.erZ = false;
    this.foreground = false;
    this.esc = new HashMap();
    this.esd = false;
    this.ese = new aa();
    this.enm = paramad;
    AppMethodBeat.o(146782);
  }
  
  private <EVENT extends aa> void a(EVENT paramEVENT)
  {
    AppMethodBeat.i(146787);
    b.d locald = this.enm.getPageConfig();
    if (locald == null)
    {
      AppMethodBeat.o(146787);
      return;
    }
    int[] arrayOfInt = aq.d(this.enm.ari());
    Map localMap = arr();
    localMap.put("originalPageOrientation", locald.qWy);
    localMap.put("lastPageOrientation", this.enm.cES());
    paramEVENT.a(this.enm, this.enm.getComponentId(), this.enm.tuD.getWidth(), this.enm.tuD.getHeight(), arrayOfInt[0], arrayOfInt[1], this.enm.qwF.getOrientationHandler().cHQ(), localMap);
    AppMethodBeat.o(146787);
  }
  
  private Map<String, Object> arr()
  {
    AppMethodBeat.i(146783);
    HashMap localHashMap = new HashMap(this.esc);
    this.esc.clear();
    AppMethodBeat.o(146783);
    return localHashMap;
  }
  
  private boolean db(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(146785);
    e.b localb2 = e.b.afK(this.enm.cES());
    e.b localb1 = localb2;
    if (localb2 == null) {
      localb1 = e.b.tLh;
    }
    if (a.contains(e.b.tLo, localb1))
    {
      if (paramInt1 > paramInt2)
      {
        AppMethodBeat.o(146785);
        return true;
      }
      AppMethodBeat.o(146785);
      return false;
    }
    if (e.b.tLh == localb1)
    {
      if (paramInt2 > paramInt1) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(146785);
        return true;
      }
      label181:
      label191:
      int j;
      if ((this.enm.qwF instanceof o)) {
        if ((Build.VERSION.SDK_INT >= 24) && (this.enm.getActivity() != null) && (this.enm.getActivity().isInMultiWindowMode()))
        {
          i = 1;
          if (i == 0) {
            break label281;
          }
          if ((this.enm.qwF.getOrientationHandler().cHQ() != e.b.tLh) && (this.enm.getActivity().getRequestedOrientation() != 1)) {
            break label259;
          }
          i = 1;
          if (i == 0) {
            break label275;
          }
          if (paramInt1 <= 0) {
            break label264;
          }
          i = 1;
          if (paramInt2 <= 0) {
            break label269;
          }
          j = 1;
          label198:
          if ((j & i) == 0) {
            break label275;
          }
        }
      }
      label259:
      label264:
      label269:
      label275:
      for (boolean bool = true;; bool = false)
      {
        Log.i("Luggage.AppBrandPageViewResizedEmitter[pageOrientation]", "isViewSizeMatchedByRequestedOrientation, activityInMultiWindowMode width[%d] height[%d] ret[%b]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
        AppMethodBeat.o(146785);
        return bool;
        i = 0;
        break;
        i = 0;
        break;
        i = 0;
        break label181;
        i = 0;
        break label191;
        j = 0;
        break label198;
      }
      label281:
      AppMethodBeat.o(146785);
      return false;
    }
    AppMethodBeat.o(146785);
    return true;
  }
  
  public final void ars()
  {
    AppMethodBeat.i(185218);
    int i = this.enm.tuD.getWidth();
    int j = this.enm.tuD.getHeight();
    if ((i <= 0) || (j <= 0))
    {
      Log.e("Luggage.AppBrandPageViewResizedEmitter[pageOrientation]", "onPageLayout wtf invalid window size [%d %d], appId[%s], url[%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), this.enm.getAppId(), this.enm.cgR() });
      AppMethodBeat.o(185218);
      return;
    }
    boolean bool1;
    boolean bool2;
    label150:
    boolean bool3;
    if ((i != this.esa) || (j != this.esb))
    {
      bool1 = true;
      this.esa = i;
      this.esb = j;
      int[] arrayOfInt = aq.d(this.enm);
      if ((!db(i, j)) || (!db(arrayOfInt[0], arrayOfInt[1]))) {
        break label297;
      }
      bool2 = true;
      if ((this.esa == 0) || (this.esb == 0)) {
        break label303;
      }
      bool3 = true;
      label167:
      Log.i("Luggage.AppBrandPageViewResizedEmitter[pageOrientation]", "onPageLayout appId[%s], url[%s], hadInit[%b], winSizeChanged[%b], winSizeMatched[%b], foreground[%b], needDispatch[%b]", new Object[] { this.enm.getAppId(), this.enm.cgR(), Boolean.valueOf(bool3), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(this.foreground), Boolean.valueOf(this.erZ) });
      if (((!bool3) || (!bool1) || (!bool2)) && ((!this.esd) || (!bool2))) {
        break label309;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        if (this.foreground)
        {
          art();
          AppMethodBeat.o(185218);
          return;
          bool1 = false;
          break;
          label297:
          bool2 = false;
          break label150;
          label303:
          bool3 = false;
          break label167;
          label309:
          i = 0;
          continue;
        }
        this.erZ = true;
        AppMethodBeat.o(185218);
        return;
      }
    }
    this.erZ = false;
    AppMethodBeat.o(185218);
  }
  
  public final void art()
  {
    AppMethodBeat.i(146786);
    if (!this.enm.isRunning())
    {
      AppMethodBeat.o(146786);
      return;
    }
    if (this.esd)
    {
      a(new a((byte)0));
      this.esd = false;
      Log.i("Luggage.AppBrandPageViewResizedEmitter[pageOrientation]", "tryDispatchViewDidResize, appId[%s], url[%s], now_orientation[%s], send onAppRouteResized instead", new Object[] { this.enm.getAppId(), this.enm.cgR(), this.enm.cES() });
      AppMethodBeat.o(146786);
      return;
    }
    a(this.ese);
    AppMethodBeat.o(146786);
  }
  
  public final void j(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(220368);
    if (paramMap != null) {
      this.esc.putAll(paramMap);
    }
    AppMethodBeat.o(220368);
  }
  
  static final class a
    extends aa
  {
    private static final int CTRL_INDEX = -2;
    private static final String NAME = "onAppRouteResized";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.c.d
 * JD-Core Version:    0.7.0.1
 */