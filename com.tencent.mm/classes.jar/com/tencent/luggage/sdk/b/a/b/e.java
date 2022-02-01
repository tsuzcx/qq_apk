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
import com.tencent.mm.plugin.appbrand.r.a.a.o;
import com.tencent.mm.plugin.appbrand.r.a.c;
import com.tencent.mm.plugin.appbrand.r.a.e.b;
import com.tencent.mm.plugin.appbrand.utils.ad;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.b.a;

public final class e
{
  public final aa caw;
  public boolean ceb;
  private int cec;
  private int ced;
  public final Map<String, Object> cee;
  public boolean cef;
  private final x ceg;
  public boolean foreground;
  
  public e(aa paramaa)
  {
    AppMethodBeat.i(146782);
    this.ceb = false;
    this.foreground = false;
    this.cee = new HashMap();
    this.cef = false;
    this.ceg = new x();
    this.caw = paramaa;
    AppMethodBeat.o(146782);
  }
  
  private Map<String, Object> Db()
  {
    AppMethodBeat.i(146783);
    HashMap localHashMap = new HashMap(this.cee);
    this.cee.clear();
    AppMethodBeat.o(146783);
    return localHashMap;
  }
  
  private String Dc()
  {
    AppMethodBeat.i(146784);
    Object localObject = (d)this.caw.Q(d.class);
    if (localObject != null)
    {
      localObject = ((d)localObject).Ca();
      AppMethodBeat.o(146784);
      return localObject;
    }
    AppMethodBeat.o(146784);
    return null;
  }
  
  private <EVENT extends x> void a(EVENT paramEVENT)
  {
    AppMethodBeat.i(146787);
    a.d locald = this.caw.getPageConfig();
    if (locald == null)
    {
      AppMethodBeat.o(146787);
      return;
    }
    int[] arrayOfInt = ad.g(this.caw.CX());
    Map localMap = Db();
    localMap.put("originalPageOrientation", locald.jCo);
    localMap.put("lastPageOrientation", Dc());
    paramEVENT.a(this.caw, this.caw.aUT(), this.caw.lAi.getWidth(), this.caw.lAi.getHeight(), arrayOfInt[0], arrayOfInt[1], this.caw.jgX.getOrientationHandler().aUB(), localMap);
    AppMethodBeat.o(146787);
  }
  
  private boolean bR(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(146785);
    e.b localb2 = e.b.Qz(Dc());
    e.b localb1 = localb2;
    if (localb2 == null) {
      localb1 = e.b.lOQ;
    }
    if (a.contains(e.b.lOX, localb1))
    {
      if (paramInt1 > paramInt2)
      {
        AppMethodBeat.o(146785);
        return true;
      }
      AppMethodBeat.o(146785);
      return false;
    }
    if (e.b.lOQ == localb1)
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
      if ((this.caw.jgX instanceof o)) {
        if ((Build.VERSION.SDK_INT >= 24) && (this.caw.getActivity() != null) && (this.caw.getActivity().isInMultiWindowMode()))
        {
          i = 1;
          if (i == 0) {
            break label278;
          }
          if ((this.caw.jgX.getOrientationHandler().aUB() != e.b.lOQ) && (this.caw.getActivity().getRequestedOrientation() != 1)) {
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
        ac.i("Luggage.AppBrandPageViewResizedEmitter[pageOrientation]", "isViewSizeMatchedByRequestedOrientation, activityInMultiWindowMode width[%d] height[%d] ret[%b]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
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
  
  public final void Dd()
  {
    AppMethodBeat.i(185218);
    int i = this.caw.lAi.getWidth();
    int j = this.caw.lAi.getHeight();
    if ((i <= 0) || (j <= 0))
    {
      ac.e("Luggage.AppBrandPageViewResizedEmitter[pageOrientation]", "onPageLayout wtf invalid window size [%d %d], appId[%s], url[%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), this.caw.getAppId(), this.caw.jZJ });
      AppMethodBeat.o(185218);
      return;
    }
    boolean bool1;
    boolean bool2;
    label150:
    boolean bool3;
    if ((i != this.cec) || (j != this.ced))
    {
      bool1 = true;
      this.cec = i;
      this.ced = j;
      int[] arrayOfInt = ad.g(this.caw);
      if ((!bR(i, j)) || (!bR(arrayOfInt[0], arrayOfInt[1]))) {
        break label297;
      }
      bool2 = true;
      if ((this.cec == 0) || (this.ced == 0)) {
        break label303;
      }
      bool3 = true;
      label167:
      ac.i("Luggage.AppBrandPageViewResizedEmitter[pageOrientation]", "onPageLayout appId[%s], url[%s], hadInit[%b], winSizeChanged[%b], winSizeMatched[%b], foreground[%b], needDispatch[%b]", new Object[] { this.caw.getAppId(), this.caw.jZJ, Boolean.valueOf(bool3), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(this.foreground), Boolean.valueOf(this.ceb) });
      if (((!bool3) || (!bool1) || (!bool2)) && ((!this.cef) || (!bool2))) {
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
          De();
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
        this.ceb = true;
        AppMethodBeat.o(185218);
        return;
      }
    }
    this.ceb = false;
    AppMethodBeat.o(185218);
  }
  
  public final void De()
  {
    AppMethodBeat.i(146786);
    if (!this.caw.isRunning())
    {
      AppMethodBeat.o(146786);
      return;
    }
    if (this.cef)
    {
      a(new a((byte)0));
      this.cef = false;
      ac.i("Luggage.AppBrandPageViewResizedEmitter[pageOrientation]", "tryDispatchViewDidResize, appId[%s], url[%s], now_orientation[%s], send onAppRouteResized instead", new Object[] { this.caw.getAppId(), this.caw.jZJ, Dc() });
      AppMethodBeat.o(146786);
      return;
    }
    a(this.ceg);
    AppMethodBeat.o(146786);
  }
  
  static final class a
    extends x
  {
    private static final int CTRL_INDEX = -2;
    private static final String NAME = "onAppRouteResized";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.b.e
 * JD-Core Version:    0.7.0.1
 */