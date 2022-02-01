package com.tencent.luggage.sdk.b.a.b;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.x;
import com.tencent.mm.plugin.appbrand.page.a.d;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.platform.window.a.o;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.plugin.appbrand.platform.window.e.b;
import com.tencent.mm.plugin.appbrand.utils.ai;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.b.a;

public final class e
{
  public final z ckP;
  public boolean cot;
  private int cou;
  private int cov;
  public final Map<String, Object> cow;
  public boolean cox;
  private final x coy;
  public boolean foreground;
  
  public e(z paramz)
  {
    AppMethodBeat.i(146782);
    this.cot = false;
    this.foreground = false;
    this.cow = new HashMap();
    this.cox = false;
    this.coy = new x();
    this.ckP = paramz;
    AppMethodBeat.o(146782);
  }
  
  private Map<String, Object> EC()
  {
    AppMethodBeat.i(146783);
    HashMap localHashMap = new HashMap(this.cow);
    this.cow.clear();
    AppMethodBeat.o(146783);
    return localHashMap;
  }
  
  private String ED()
  {
    AppMethodBeat.i(146784);
    Object localObject = (d)this.ckP.Q(d.class);
    if (localObject != null)
    {
      localObject = ((d)localObject).DC();
      AppMethodBeat.o(146784);
      return localObject;
    }
    AppMethodBeat.o(146784);
    return null;
  }
  
  private <EVENT extends x> void a(EVENT paramEVENT)
  {
    AppMethodBeat.i(146787);
    a.d locald = this.ckP.getPageConfig();
    if (locald == null)
    {
      AppMethodBeat.o(146787);
      return;
    }
    int[] arrayOfInt = ai.f(this.ckP.Ey());
    Map localMap = EC();
    localMap.put("originalPageOrientation", locald.jZz);
    localMap.put("lastPageOrientation", ED());
    paramEVENT.a(this.ckP, this.ckP.aXX(), this.ckP.mdY.getWidth(), this.ckP.mdY.getHeight(), arrayOfInt[0], arrayOfInt[1], this.ckP.jDa.getOrientationHandler().aYg(), localMap);
    AppMethodBeat.o(146787);
  }
  
  private boolean bT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(146785);
    e.b localb2 = e.b.UP(ED());
    e.b localb1 = localb2;
    if (localb2 == null) {
      localb1 = e.b.mtD;
    }
    if (a.contains(e.b.mtK, localb1))
    {
      if (paramInt1 > paramInt2)
      {
        AppMethodBeat.o(146785);
        return true;
      }
      AppMethodBeat.o(146785);
      return false;
    }
    if (e.b.mtD == localb1)
    {
      if (paramInt2 > paramInt1) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(146785);
        return true;
      }
      label178:
      label188:
      int j;
      if ((this.ckP.jDa instanceof o)) {
        if ((Build.VERSION.SDK_INT >= 24) && (this.ckP.getActivity() != null) && (this.ckP.getActivity().isInMultiWindowMode()))
        {
          i = 1;
          if (i == 0) {
            break label278;
          }
          if ((this.ckP.jDa.getOrientationHandler().aYg() != e.b.mtD) && (this.ckP.getActivity().getRequestedOrientation() != 1)) {
            break label256;
          }
          i = 1;
          if (i == 0) {
            break label272;
          }
          if (paramInt1 <= 0) {
            break label261;
          }
          i = 1;
          if (paramInt2 <= 0) {
            break label266;
          }
          j = 1;
          label195:
          if ((j & i) == 0) {
            break label272;
          }
        }
      }
      label256:
      label261:
      label266:
      label272:
      for (boolean bool = true;; bool = false)
      {
        ae.i("Luggage.AppBrandPageViewResizedEmitter[pageOrientation]", "isViewSizeMatchedByRequestedOrientation, activityInMultiWindowMode width[%d] height[%d] ret[%b]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
        AppMethodBeat.o(146785);
        return bool;
        i = 0;
        break;
        i = 0;
        break;
        i = 0;
        break label178;
        i = 0;
        break label188;
        j = 0;
        break label195;
      }
      label278:
      AppMethodBeat.o(146785);
      return false;
    }
    AppMethodBeat.o(146785);
    return true;
  }
  
  public final void EE()
  {
    AppMethodBeat.i(185218);
    int i = this.ckP.mdY.getWidth();
    int j = this.ckP.mdY.getHeight();
    if ((i <= 0) || (j <= 0))
    {
      ae.e("Luggage.AppBrandPageViewResizedEmitter[pageOrientation]", "onPageLayout wtf invalid window size [%d %d], appId[%s], url[%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), this.ckP.getAppId(), this.ckP.kxv });
      AppMethodBeat.o(185218);
      return;
    }
    boolean bool1;
    boolean bool2;
    label150:
    boolean bool3;
    if ((i != this.cou) || (j != this.cov))
    {
      bool1 = true;
      this.cou = i;
      this.cov = j;
      int[] arrayOfInt = ai.f(this.ckP);
      if ((!bT(i, j)) || (!bT(arrayOfInt[0], arrayOfInt[1]))) {
        break label297;
      }
      bool2 = true;
      if ((this.cou == 0) || (this.cov == 0)) {
        break label303;
      }
      bool3 = true;
      label167:
      ae.i("Luggage.AppBrandPageViewResizedEmitter[pageOrientation]", "onPageLayout appId[%s], url[%s], hadInit[%b], winSizeChanged[%b], winSizeMatched[%b], foreground[%b], needDispatch[%b]", new Object[] { this.ckP.getAppId(), this.ckP.kxv, Boolean.valueOf(bool3), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(this.foreground), Boolean.valueOf(this.cot) });
      if (((!bool3) || (!bool1) || (!bool2)) && ((!this.cox) || (!bool2))) {
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
          EF();
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
        this.cot = true;
        AppMethodBeat.o(185218);
        return;
      }
    }
    this.cot = false;
    AppMethodBeat.o(185218);
  }
  
  public final void EF()
  {
    AppMethodBeat.i(146786);
    if (!this.ckP.isRunning())
    {
      AppMethodBeat.o(146786);
      return;
    }
    if (this.cox)
    {
      a(new a((byte)0));
      this.cox = false;
      ae.i("Luggage.AppBrandPageViewResizedEmitter[pageOrientation]", "tryDispatchViewDidResize, appId[%s], url[%s], now_orientation[%s], send onAppRouteResized instead", new Object[] { this.ckP.getAppId(), this.ckP.kxv, ED() });
      AppMethodBeat.o(146786);
      return;
    }
    a(this.coy);
    AppMethodBeat.o(146786);
  }
  
  static final class a
    extends x
  {
    private static final int CTRL_INDEX = -2;
    private static final String NAME = "onAppRouteResized";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.b.e
 * JD-Core Version:    0.7.0.1
 */