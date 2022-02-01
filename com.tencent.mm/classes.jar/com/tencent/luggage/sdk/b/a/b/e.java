package com.tencent.luggage.sdk.b.a.b;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.b.d;
import com.tencent.mm.plugin.appbrand.jsapi.aa;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.platform.window.a.o;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.plugin.appbrand.platform.window.e.b;
import com.tencent.mm.plugin.appbrand.utils.ai;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.b.a;

public final class e
{
  private int cAA;
  public final Map<String, Object> cAB;
  public boolean cAC;
  private final aa cAD;
  public boolean cAy;
  private int cAz;
  public final ac cwK;
  public boolean foreground;
  
  public e(ac paramac)
  {
    AppMethodBeat.i(146782);
    this.cAy = false;
    this.foreground = false;
    this.cAB = new HashMap();
    this.cAC = false;
    this.cAD = new aa();
    this.cwK = paramac;
    AppMethodBeat.o(146782);
  }
  
  private Map<String, Object> Od()
  {
    AppMethodBeat.i(146783);
    HashMap localHashMap = new HashMap(this.cAB);
    this.cAB.clear();
    AppMethodBeat.o(146783);
    return localHashMap;
  }
  
  private <EVENT extends aa> void a(EVENT paramEVENT)
  {
    AppMethodBeat.i(146787);
    b.d locald = this.cwK.getPageConfig();
    if (locald == null)
    {
      AppMethodBeat.o(146787);
      return;
    }
    int[] arrayOfInt = ai.f(this.cwK.NY());
    Map localMap = Od();
    localMap.put("originalPageOrientation", locald.lcB);
    localMap.put("lastPageOrientation", this.cwK.bRx());
    paramEVENT.a(this.cwK, this.cwK.getComponentId(), this.cwK.noq.getWidth(), this.cwK.noq.getHeight(), arrayOfInt[0], arrayOfInt[1], this.cwK.kEb.getOrientationHandler().btm(), localMap);
    AppMethodBeat.o(146787);
  }
  
  private boolean bT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(146785);
    e.b localb2 = e.b.aeE(this.cwK.bRx());
    e.b localb1 = localb2;
    if (localb2 == null) {
      localb1 = e.b.nEl;
    }
    if (a.contains(e.b.nEs, localb1))
    {
      if (paramInt1 > paramInt2)
      {
        AppMethodBeat.o(146785);
        return true;
      }
      AppMethodBeat.o(146785);
      return false;
    }
    if (e.b.nEl == localb1)
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
      if ((this.cwK.kEb instanceof o)) {
        if ((Build.VERSION.SDK_INT >= 24) && (this.cwK.getActivity() != null) && (this.cwK.getActivity().isInMultiWindowMode()))
        {
          i = 1;
          if (i == 0) {
            break label281;
          }
          if ((this.cwK.kEb.getOrientationHandler().btm() != e.b.nEl) && (this.cwK.getActivity().getRequestedOrientation() != 1)) {
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
  
  public final void Oe()
  {
    AppMethodBeat.i(185218);
    int i = this.cwK.noq.getWidth();
    int j = this.cwK.noq.getHeight();
    if ((i <= 0) || (j <= 0))
    {
      Log.e("Luggage.AppBrandPageViewResizedEmitter[pageOrientation]", "onPageLayout wtf invalid window size [%d %d], appId[%s], url[%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), this.cwK.getAppId(), this.cwK.lBI });
      AppMethodBeat.o(185218);
      return;
    }
    boolean bool1;
    boolean bool2;
    label150:
    boolean bool3;
    if ((i != this.cAz) || (j != this.cAA))
    {
      bool1 = true;
      this.cAz = i;
      this.cAA = j;
      int[] arrayOfInt = ai.f(this.cwK);
      if ((!bT(i, j)) || (!bT(arrayOfInt[0], arrayOfInt[1]))) {
        break label297;
      }
      bool2 = true;
      if ((this.cAz == 0) || (this.cAA == 0)) {
        break label303;
      }
      bool3 = true;
      label167:
      Log.i("Luggage.AppBrandPageViewResizedEmitter[pageOrientation]", "onPageLayout appId[%s], url[%s], hadInit[%b], winSizeChanged[%b], winSizeMatched[%b], foreground[%b], needDispatch[%b]", new Object[] { this.cwK.getAppId(), this.cwK.lBI, Boolean.valueOf(bool3), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(this.foreground), Boolean.valueOf(this.cAy) });
      if (((!bool3) || (!bool1) || (!bool2)) && ((!this.cAC) || (!bool2))) {
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
          Of();
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
        this.cAy = true;
        AppMethodBeat.o(185218);
        return;
      }
    }
    this.cAy = false;
    AppMethodBeat.o(185218);
  }
  
  public final void Of()
  {
    AppMethodBeat.i(146786);
    if (!this.cwK.isRunning())
    {
      AppMethodBeat.o(146786);
      return;
    }
    if (this.cAC)
    {
      a(new a((byte)0));
      this.cAC = false;
      Log.i("Luggage.AppBrandPageViewResizedEmitter[pageOrientation]", "tryDispatchViewDidResize, appId[%s], url[%s], now_orientation[%s], send onAppRouteResized instead", new Object[] { this.cwK.getAppId(), this.cwK.lBI, this.cwK.bRx() });
      AppMethodBeat.o(146786);
      return;
    }
    a(this.cAD);
    AppMethodBeat.o(146786);
  }
  
  static final class a
    extends aa
  {
    private static final int CTRL_INDEX = -2;
    private static final String NAME = "onAppRouteResized";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.b.e
 * JD-Core Version:    0.7.0.1
 */