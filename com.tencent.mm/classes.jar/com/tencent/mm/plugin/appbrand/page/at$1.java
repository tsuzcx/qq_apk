package com.tencent.mm.plugin.appbrand.page;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.widget.FrameLayout;
import com.tencent.luggage.g.d;
import com.tencent.luggage.sdk.b.a.b.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ConcurrentModificationException;

final class at$1
  implements View.OnLayoutChangeListener
{
  at$1(at paramat) {}
  
  public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    AppMethodBeat.i(140874);
    if (TextUtils.isEmpty(at.a(this.izc).hzM))
    {
      AppMethodBeat.o(140874);
      return;
    }
    if (at.b(this.izc)) {
      try
      {
        at.a(this.izc).ivI.removeOnLayoutChangeListener(this);
        AppMethodBeat.o(140874);
        return;
      }
      catch (ConcurrentModificationException paramView)
      {
        at.a(this.izc).post(new at.1.1(this, this));
        AppMethodBeat.o(140874);
        return;
      }
    }
    d.i("Luggage.MPPageViewOrientationExtensionImpl", "pageArea onLayoutChange appId[%s], url[%s]", new Object[] { at.a(this.izc).getAppId(), at.a(this.izc).hzM });
    if (at.a(this.izc).ws() == null)
    {
      AppMethodBeat.o(140874);
      return;
    }
    paramView = at.c(this.izc);
    paramInt1 = paramView.bBK.ivI.getWidth();
    paramInt2 = paramView.bBK.ivI.getHeight();
    if ((paramInt1 <= 0) || (paramInt2 <= 0))
    {
      d.e("Luggage.AppBrandPageViewResizedEmitter[pageOrientation]", "onPageLayout wtf invalid window size [%d %d], appId[%s], url[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramView.bBK.getAppId(), paramView.bBK.hzM });
      AppMethodBeat.o(140874);
      return;
    }
    boolean bool1;
    boolean bool2;
    label293:
    boolean bool3;
    if ((paramInt1 != paramView.bEq) || (paramInt2 != paramView.bEr))
    {
      bool1 = true;
      paramView.bEq = paramInt1;
      paramView.bEr = paramInt2;
      int[] arrayOfInt = com.tencent.mm.plugin.appbrand.t.v.d(paramView.bBK);
      if ((!paramView.bD(paramInt1, paramInt2)) || (!paramView.bD(arrayOfInt[0], arrayOfInt[1]))) {
        break label443;
      }
      bool2 = true;
      if ((paramView.bEq == 0) || (paramView.bEr == 0)) {
        break label449;
      }
      bool3 = true;
      label310:
      d.i("Luggage.AppBrandPageViewResizedEmitter[pageOrientation]", "onPageLayout appId[%s], url[%s], hadInit[%b], winSizeChanged[%b], winSizeMatched[%b], foreground[%b], needDispatch[%b]", new Object[] { paramView.bBK.getAppId(), paramView.bBK.hzM, Boolean.valueOf(bool3), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(paramView.foreground), Boolean.valueOf(paramView.bEp) });
      if (((!bool3) || (!bool1) || (!bool2)) && ((!paramView.bEt) || (!bool2))) {
        break label455;
      }
      paramInt1 = 1;
    }
    for (;;)
    {
      if (paramInt1 != 0)
      {
        if (paramView.foreground)
        {
          paramView.wv();
          AppMethodBeat.o(140874);
          return;
          bool1 = false;
          break;
          label443:
          bool2 = false;
          break label293;
          label449:
          bool3 = false;
          break label310;
          label455:
          paramInt1 = 0;
          continue;
        }
        paramView.bEp = true;
        AppMethodBeat.o(140874);
        return;
      }
    }
    paramView.bEp = false;
    AppMethodBeat.o(140874);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.at.1
 * JD-Core Version:    0.7.0.1
 */