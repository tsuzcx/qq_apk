package com.tencent.luggage.sdk.b.a.b;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.x;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.b.d;
import com.tencent.mm.plugin.appbrand.s.a.a.o;
import com.tencent.mm.plugin.appbrand.s.a.c;
import com.tencent.mm.plugin.appbrand.s.a.e.b;
import com.tencent.mm.plugin.appbrand.utils.ac;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.b.a;

public final class e
{
  public final aa cdz;
  public boolean chg;
  private int chh;
  private int chi;
  public final Map<String, Object> chj;
  public boolean chk;
  private final x chl;
  public boolean foreground;
  
  public e(aa paramaa)
  {
    AppMethodBeat.i(146782);
    this.chg = false;
    this.foreground = false;
    this.chj = new HashMap();
    this.chk = false;
    this.chl = new x();
    this.cdz = paramaa;
    AppMethodBeat.o(146782);
  }
  
  private Map<String, Object> Dy()
  {
    AppMethodBeat.i(146783);
    HashMap localHashMap = new HashMap(this.chj);
    this.chj.clear();
    AppMethodBeat.o(146783);
    return localHashMap;
  }
  
  private String Dz()
  {
    AppMethodBeat.i(146784);
    Object localObject = (d)this.cdz.Q(d.class);
    if (localObject != null)
    {
      localObject = ((d)localObject).Cw();
      AppMethodBeat.o(146784);
      return localObject;
    }
    AppMethodBeat.o(146784);
    return null;
  }
  
  private <EVENT extends x> void a(EVENT paramEVENT)
  {
    AppMethodBeat.i(146787);
    a.d locald = this.cdz.getPageConfig();
    if (locald == null)
    {
      AppMethodBeat.o(146787);
      return;
    }
    int[] arrayOfInt = ac.g(this.cdz.Du());
    Map localMap = Dy();
    localMap.put("originalPageOrientation", locald.jcb);
    localMap.put("lastPageOrientation", Dz());
    paramEVENT.a(this.cdz, this.cdz.aOd(), this.cdz.kYy.getWidth(), this.cdz.kYy.getHeight(), arrayOfInt[0], arrayOfInt[1], this.cdz.iGU.getOrientationHandler().aNL(), localMap);
    AppMethodBeat.o(146787);
  }
  
  private boolean bU(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(146785);
    e.b localb2 = e.b.Mq(Dz());
    e.b localb1 = localb2;
    if (localb2 == null) {
      localb1 = e.b.lmO;
    }
    if (a.contains(e.b.lmV, localb1))
    {
      if (paramInt1 > paramInt2)
      {
        AppMethodBeat.o(146785);
        return true;
      }
      AppMethodBeat.o(146785);
      return false;
    }
    if (e.b.lmO == localb1)
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
      if ((this.cdz.iGU instanceof o)) {
        if ((Build.VERSION.SDK_INT >= 24) && (this.cdz.getActivity() != null) && (this.cdz.getActivity().isInMultiWindowMode()))
        {
          i = 1;
          if (i == 0) {
            break label278;
          }
          if ((this.cdz.iGU.getOrientationHandler().aNL() != e.b.lmO) && (this.cdz.getActivity().getRequestedOrientation() != 1)) {
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
        ad.i("Luggage.AppBrandPageViewResizedEmitter[pageOrientation]", "isViewSizeMatchedByRequestedOrientation, activityInMultiWindowMode width[%d] height[%d] ret[%b]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
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
  
  public final void DA()
  {
    AppMethodBeat.i(185218);
    int i = this.cdz.kYy.getWidth();
    int j = this.cdz.kYy.getHeight();
    if ((i <= 0) || (j <= 0))
    {
      ad.e("Luggage.AppBrandPageViewResizedEmitter[pageOrientation]", "onPageLayout wtf invalid window size [%d %d], appId[%s], url[%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), this.cdz.getAppId(), this.cdz.jzm });
      AppMethodBeat.o(185218);
      return;
    }
    boolean bool1;
    boolean bool2;
    label150:
    boolean bool3;
    if ((i != this.chh) || (j != this.chi))
    {
      bool1 = true;
      this.chh = i;
      this.chi = j;
      int[] arrayOfInt = ac.g(this.cdz);
      if ((!bU(i, j)) || (!bU(arrayOfInt[0], arrayOfInt[1]))) {
        break label297;
      }
      bool2 = true;
      if ((this.chh == 0) || (this.chi == 0)) {
        break label303;
      }
      bool3 = true;
      label167:
      ad.i("Luggage.AppBrandPageViewResizedEmitter[pageOrientation]", "onPageLayout appId[%s], url[%s], hadInit[%b], winSizeChanged[%b], winSizeMatched[%b], foreground[%b], needDispatch[%b]", new Object[] { this.cdz.getAppId(), this.cdz.jzm, Boolean.valueOf(bool3), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(this.foreground), Boolean.valueOf(this.chg) });
      if (((!bool3) || (!bool1) || (!bool2)) && ((!this.chk) || (!bool2))) {
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
          DB();
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
        this.chg = true;
        AppMethodBeat.o(185218);
        return;
      }
    }
    this.chg = false;
    AppMethodBeat.o(185218);
  }
  
  public final void DB()
  {
    AppMethodBeat.i(146786);
    if (!this.cdz.isRunning())
    {
      AppMethodBeat.o(146786);
      return;
    }
    if (this.chk)
    {
      a(new a((byte)0));
      this.chk = false;
      ad.i("Luggage.AppBrandPageViewResizedEmitter[pageOrientation]", "tryDispatchViewDidResize, appId[%s], url[%s], now_orientation[%s], send onAppRouteResized instead", new Object[] { this.cdz.getAppId(), this.cdz.jzm, Dz() });
      AppMethodBeat.o(146786);
      return;
    }
    a(this.chl);
    AppMethodBeat.o(146786);
  }
  
  static final class a
    extends x
  {
    private static final int CTRL_INDEX = -2;
    private static final String NAME = "onAppRouteResized";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.b.e
 * JD-Core Version:    0.7.0.1
 */