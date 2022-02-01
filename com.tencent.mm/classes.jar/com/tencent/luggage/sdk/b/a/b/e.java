package com.tencent.luggage.sdk.b.a.b;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.b.d;
import com.tencent.mm.plugin.appbrand.jsapi.z;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.platform.window.a.o;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.plugin.appbrand.platform.window.e.b;
import com.tencent.mm.plugin.appbrand.utils.ak;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.b.a;

public final class e
{
  public final ad cvo;
  public boolean czE;
  private int czF;
  private int czG;
  public final Map<String, Object> czH;
  public boolean czI;
  private final z czJ;
  public boolean foreground;
  
  public e(ad paramad)
  {
    AppMethodBeat.i(146782);
    this.czE = false;
    this.foreground = false;
    this.czH = new HashMap();
    this.czI = false;
    this.czJ = new z();
    this.cvo = paramad;
    AppMethodBeat.o(146782);
  }
  
  private Map<String, Object> Rb()
  {
    AppMethodBeat.i(146783);
    HashMap localHashMap = new HashMap(this.czH);
    this.czH.clear();
    AppMethodBeat.o(146783);
    return localHashMap;
  }
  
  private <EVENT extends z> void a(EVENT paramEVENT)
  {
    AppMethodBeat.i(146787);
    b.d locald = this.cvo.getPageConfig();
    if (locald == null)
    {
      AppMethodBeat.o(146787);
      return;
    }
    int[] arrayOfInt = ak.f(this.cvo.QW());
    Map localMap = Rb();
    localMap.put("originalPageOrientation", locald.nWK);
    localMap.put("lastPageOrientation", this.cvo.ceo());
    paramEVENT.a(this.cvo, this.cvo.getComponentId(), this.cvo.qpZ.getWidth(), this.cvo.qpZ.getHeight(), arrayOfInt[0], arrayOfInt[1], this.cvo.nxr.getOrientationHandler().cgS(), localMap);
    AppMethodBeat.o(146787);
  }
  
  private boolean cm(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(146785);
    e.b localb2 = e.b.amy(this.cvo.ceo());
    e.b localb1 = localb2;
    if (localb2 == null) {
      localb1 = e.b.qGv;
    }
    if (a.contains(e.b.qGC, localb1))
    {
      if (paramInt1 > paramInt2)
      {
        AppMethodBeat.o(146785);
        return true;
      }
      AppMethodBeat.o(146785);
      return false;
    }
    if (e.b.qGv == localb1)
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
      if ((this.cvo.nxr instanceof o)) {
        if ((Build.VERSION.SDK_INT >= 24) && (this.cvo.getActivity() != null) && (this.cvo.getActivity().isInMultiWindowMode()))
        {
          i = 1;
          if (i == 0) {
            break label281;
          }
          if ((this.cvo.nxr.getOrientationHandler().cgS() != e.b.qGv) && (this.cvo.getActivity().getRequestedOrientation() != 1)) {
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
  
  public final void Rc()
  {
    AppMethodBeat.i(185218);
    int i = this.cvo.qpZ.getWidth();
    int j = this.cvo.qpZ.getHeight();
    if ((i <= 0) || (j <= 0))
    {
      Log.e("Luggage.AppBrandPageViewResizedEmitter[pageOrientation]", "onPageLayout wtf invalid window size [%d %d], appId[%s], url[%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), this.cvo.getAppId(), this.cvo.oxe });
      AppMethodBeat.o(185218);
      return;
    }
    boolean bool1;
    boolean bool2;
    label150:
    boolean bool3;
    if ((i != this.czF) || (j != this.czG))
    {
      bool1 = true;
      this.czF = i;
      this.czG = j;
      int[] arrayOfInt = ak.f(this.cvo);
      if ((!cm(i, j)) || (!cm(arrayOfInt[0], arrayOfInt[1]))) {
        break label297;
      }
      bool2 = true;
      if ((this.czF == 0) || (this.czG == 0)) {
        break label303;
      }
      bool3 = true;
      label167:
      Log.i("Luggage.AppBrandPageViewResizedEmitter[pageOrientation]", "onPageLayout appId[%s], url[%s], hadInit[%b], winSizeChanged[%b], winSizeMatched[%b], foreground[%b], needDispatch[%b]", new Object[] { this.cvo.getAppId(), this.cvo.oxe, Boolean.valueOf(bool3), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(this.foreground), Boolean.valueOf(this.czE) });
      if (((!bool3) || (!bool1) || (!bool2)) && ((!this.czI) || (!bool2))) {
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
          Rd();
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
        this.czE = true;
        AppMethodBeat.o(185218);
        return;
      }
    }
    this.czE = false;
    AppMethodBeat.o(185218);
  }
  
  public final void Rd()
  {
    AppMethodBeat.i(146786);
    if (!this.cvo.isRunning())
    {
      AppMethodBeat.o(146786);
      return;
    }
    if (this.czI)
    {
      a(new a((byte)0));
      this.czI = false;
      Log.i("Luggage.AppBrandPageViewResizedEmitter[pageOrientation]", "tryDispatchViewDidResize, appId[%s], url[%s], now_orientation[%s], send onAppRouteResized instead", new Object[] { this.cvo.getAppId(), this.cvo.oxe, this.cvo.ceo() });
      AppMethodBeat.o(146786);
      return;
    }
    a(this.czJ);
    AppMethodBeat.o(146786);
  }
  
  static final class a
    extends z
  {
    private static final int CTRL_INDEX = -2;
    private static final String NAME = "onAppRouteResized";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.b.e
 * JD-Core Version:    0.7.0.1
 */