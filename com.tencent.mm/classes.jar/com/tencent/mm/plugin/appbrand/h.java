package com.tencent.mm.plugin.appbrand;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.page.n;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.ui.ag;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/AppBrandEntryPageFastLoadHelper;", "", "()V", "TAG", "", "createFastLoadPrompt", "Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", "tryFastLoadEntryPage", "", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
{
  public static final h qrq;
  
  static
  {
    AppMethodBeat.i(316823);
    qrq = new h();
    AppMethodBeat.o(316823);
  }
  
  public static final void a(ah paramah)
  {
    AppMethodBeat.i(316804);
    s.u(paramah, "<this>");
    if (paramah.getRuntime() == null)
    {
      AppMethodBeat.o(316804);
      return;
    }
    if (paramah.getRuntime().qsE.get())
    {
      AppMethodBeat.o(316804);
      return;
    }
    if (paramah.getRuntime().aqJ())
    {
      AppMethodBeat.o(316804);
      return;
    }
    if (AppBrandRuntimeWCAccessible.H((AppBrandRuntime)paramah.getRuntime()))
    {
      AppMethodBeat.o(316804);
      return;
    }
    if (!paramah.txm)
    {
      AppMethodBeat.o(316804);
      return;
    }
    if (paramah.getRuntime().getInitConfig().aqE() == com.tencent.mm.plugin.appbrand.config.z.raW)
    {
      AppMethodBeat.o(316804);
      return;
    }
    if ((paramah.getRuntime().cbM() instanceof ag))
    {
      AppMethodBeat.o(316804);
      return;
    }
    if (!paramah.getRuntime().ccB())
    {
      int i;
      if ((!paramah.cEC().cOX()) || ((paramah.txk instanceof n)))
      {
        i = 1;
        if (i != 0) {
          break label208;
        }
        localObject = com.tencent.mm.plugin.appbrand.report.quality.b.afZ(paramah.getAppId());
        if (localObject != null) {
          break label200;
        }
      }
      label200:
      for (localObject = null;; localObject = ((QualitySessionRuntime)localObject).tSx)
      {
        if (localObject == com.tencent.mm.plugin.appbrand.report.quality.i.tRO) {
          break label208;
        }
        AppMethodBeat.o(316804);
        return;
        i = 0;
        break;
      }
    }
    label208:
    Object localObject = new Boolean[1];
    localObject[0] = Boolean.FALSE;
    View[] arrayOfView = new View[1];
    Long[] arrayOfLong = new Long[1];
    arrayOfLong[0] = Long.valueOf(0L);
    paramah.a(new h..ExternalSyntheticLambda0((Boolean[])localObject, arrayOfLong, paramah, arrayOfView));
    View localView = paramah.getContentView();
    if (localView != null) {
      localView.post(new h..ExternalSyntheticLambda1((Boolean[])localObject, paramah, arrayOfView, arrayOfLong));
    }
    AppMethodBeat.o(316804);
  }
  
  private static final void a(Boolean[] paramArrayOfBoolean, ah paramah, View[] paramArrayOfView, Long[] paramArrayOfLong)
  {
    AppMethodBeat.i(316815);
    s.u(paramArrayOfBoolean, "$pageOnReadyCalled");
    s.u(paramah, "$this_tryFastLoadEntryPage");
    s.u(paramArrayOfView, "$promptViewRef");
    s.u(paramArrayOfLong, "$promptTick");
    if (paramArrayOfBoolean[0].booleanValue())
    {
      AppMethodBeat.o(316815);
      return;
    }
    paramArrayOfBoolean = paramah.getContentView();
    if ((paramArrayOfBoolean instanceof ViewGroup)) {}
    for (paramArrayOfBoolean = (ViewGroup)paramArrayOfBoolean; paramArrayOfBoolean == null; paramArrayOfBoolean = null)
    {
      AppMethodBeat.o(316815);
      return;
    }
    paramArrayOfBoolean = paramArrayOfBoolean.getContext();
    s.s(paramArrayOfBoolean, "parent.context");
    paramArrayOfBoolean = new ProgressBar((Context)new com.tencent.mm.ui.z(paramArrayOfBoolean, ba.j.mediumCustomProgressBar));
    paramArrayOfBoolean.setIndeterminateDrawable(androidx.core.content.a.m(paramArrayOfBoolean.getContext(), ba.e.progress_medium_holo));
    int i = kotlin.h.a.eH(paramArrayOfBoolean.getContext().getResources().getDisplayMetrics().density * 36.0F);
    paramArrayOfBoolean.setLayoutParams(new ViewGroup.LayoutParams(i, i));
    paramArrayOfBoolean = (View)paramArrayOfBoolean;
    Log.i("MicroMsg.AppBrandEntryPageFastLoadHelper", "tryFastLoadEntryPage, show promptView, appId[" + paramah.getRuntime().mAppId + ']');
    paramArrayOfView[0] = paramArrayOfBoolean;
    paramArrayOfLong[0] = Long.valueOf(Util.currentTicks());
    paramah.txj.a(paramArrayOfBoolean, 10000L);
    paramah.getRuntime().cbx();
    AppMethodBeat.o(316815);
  }
  
  private static final void a(Boolean[] paramArrayOfBoolean, Long[] paramArrayOfLong, ah paramah, View[] paramArrayOfView)
  {
    AppMethodBeat.i(316808);
    s.u(paramArrayOfBoolean, "$pageOnReadyCalled");
    s.u(paramArrayOfLong, "$promptTick");
    s.u(paramah, "$this_tryFastLoadEntryPage");
    s.u(paramArrayOfView, "$promptViewRef");
    paramArrayOfBoolean[0] = Boolean.TRUE;
    if (paramArrayOfLong[0].longValue() > 0L)
    {
      long l = paramArrayOfLong[0].longValue();
      Log.i("MicroMsg.AppBrandEntryPageFastLoadHelper", "tryFastLoadEntryPage, onReady called with promptView shown, appId[" + paramah.getRuntime().mAppId + "], time diff: " + (Util.currentTicks() - l));
    }
    paramArrayOfBoolean = paramArrayOfView[0];
    if (paramArrayOfBoolean != null)
    {
      com.tencent.mm.plugin.appbrand.ui.i.dI(paramArrayOfBoolean);
      if (!(paramArrayOfBoolean instanceof ThreeDotsLoadingView)) {
        break label138;
      }
    }
    label138:
    for (paramArrayOfBoolean = (ThreeDotsLoadingView)paramArrayOfBoolean;; paramArrayOfBoolean = null)
    {
      if (paramArrayOfBoolean != null) {
        paramArrayOfBoolean.jFf();
      }
      AppMethodBeat.o(316808);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.h
 * JD-Core Version:    0.7.0.1
 */