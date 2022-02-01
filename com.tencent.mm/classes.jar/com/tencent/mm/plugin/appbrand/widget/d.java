package com.tencent.mm.plugin.appbrand.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.page.k;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/AppBrandExternalCoverWidgetManager;", "Lcom/tencent/mm/plugin/appbrand/widget/IAppBrandExternalCoverWidgetManager;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;)V", "capsuleBarLayoutListener", "Lkotlin/Function0;", "", "hasInstallCapsuleBarLayoutListener", "", "adjustExternalWidgetContainer", "configExternalCoverWidget", "initConfigWC", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "destory", "installExternalCoverWidget", "onAppBrandInit", "initConfig", "onInitConfigUpdated", "removeCapsuleBarLayoutListener", "removeExternalCoverWidget", "setupCapsuleBarLayoutListener", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d.a uwc;
  public final w qxC;
  private boolean uwd;
  private final a<ah> uwe;
  
  static
  {
    AppMethodBeat.i(323954);
    uwc = new d.a((byte)0);
    AppMethodBeat.o(323954);
  }
  
  public d(w paramw)
  {
    AppMethodBeat.i(323933);
    this.qxC = paramw;
    this.uwe = ((a)new b(this));
    AppMethodBeat.o(323933);
  }
  
  private static final void aA(a parama)
  {
    AppMethodBeat.i(323948);
    s.u(parama, "$tmp0");
    parama.invoke();
    AppMethodBeat.o(323948);
  }
  
  private static final void az(a parama)
  {
    AppMethodBeat.i(323944);
    s.u(parama, "$tmp0");
    parama.invoke();
    AppMethodBeat.o(323944);
  }
  
  private final void cOD()
  {
    AppMethodBeat.i(323936);
    if (!this.uwd)
    {
      this.qxC.qsP.dU(1).getViewTreeObserver().addOnGlobalLayoutListener(new d..ExternalSyntheticLambda0(this.uwe));
      this.uwd = true;
    }
    AppMethodBeat.o(323936);
  }
  
  private final void cOF()
  {
    AppMethodBeat.i(323940);
    View localView1 = this.qxC.qsP.dU(1);
    View localView2 = this.qxC.qsP.dU(2);
    if ((localView1 != null) && (localView2 != null))
    {
      if (localView2.getTop() == localView1.getMeasuredHeight())
      {
        AppMethodBeat.o(323940);
        return;
      }
      localView2.setY(localView1.getMeasuredHeight());
      Log.i("MicroMsg.AppBrandExternalCoverWidgetManager", "set widgetContainer setY[" + localView2.getTop() + ']');
    }
    AppMethodBeat.o(323940);
  }
  
  public final void cOE()
  {
    AppMethodBeat.i(323969);
    if (this.uwd)
    {
      this.qxC.qsP.dU(1).getViewTreeObserver().removeOnGlobalLayoutListener(new d..ExternalSyntheticLambda1(this.uwe));
      this.uwd = false;
    }
    AppMethodBeat.o(323969);
  }
  
  public final void n(AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(323964);
    Object localObject2 = AndroidContextUtil.castActivityOrNull(this.qxC.mContext);
    if (localObject2 == null)
    {
      AppMethodBeat.o(323964);
      return;
    }
    try
    {
      if (!TextUtils.isEmpty((CharSequence)paramAppBrandInitConfigWC.qYy))
      {
        localObject1 = Class.forName(paramAppBrandInitConfigWC.qYy);
        if (localObject1 == null)
        {
          paramAppBrandInitConfigWC = new NullPointerException("null cannot be cast to non-null type java.lang.Class<out com.tencent.mm.plugin.appbrand.widget.IAppBrandExternalCoverWidget>");
          AppMethodBeat.o(323964);
          throw paramAppBrandInitConfigWC;
        }
      }
    }
    catch (ClassNotFoundException paramAppBrandInitConfigWC)
    {
      Log.printErrStackTrace("MicroMsg.AppBrandExternalCoverWidgetManager", (Throwable)paramAppBrandInitConfigWC, "", new Object[] { "" });
      AppMethodBeat.o(323964);
      return;
      Object localObject1 = (j)((Class)localObject1).newInstance();
      localObject2 = (Context)localObject2;
      paramAppBrandInitConfigWC = paramAppBrandInitConfigWC.qBa;
      s.s(paramAppBrandInitConfigWC, "initConfigWC.coverWidgetBuildData");
      paramAppBrandInitConfigWC = ((j)localObject1).ah((Context)localObject2, paramAppBrandInitConfigWC);
      paramAppBrandInitConfigWC.setLayoutParams((ViewGroup.LayoutParams)((j)localObject1).cON());
      this.qxC.qsP.cDQ();
      this.qxC.qsP.V(paramAppBrandInitConfigWC, ((j)localObject1).cOO());
      cOF();
      cOD();
      AppMethodBeat.o(323964);
      return;
    }
    catch (IllegalAccessException paramAppBrandInitConfigWC)
    {
      Log.printErrStackTrace("MicroMsg.AppBrandExternalCoverWidgetManager", (Throwable)paramAppBrandInitConfigWC, "", new Object[] { "" });
      AppMethodBeat.o(323964);
      return;
      this.qxC.qsP.cDQ();
      cOE();
      AppMethodBeat.o(323964);
      return;
    }
    catch (InstantiationException paramAppBrandInitConfigWC)
    {
      Log.printErrStackTrace("MicroMsg.AppBrandExternalCoverWidgetManager", (Throwable)paramAppBrandInitConfigWC, "", new Object[] { "" });
      AppMethodBeat.o(323964);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<ah>
  {
    b(d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.d
 * JD-Core Version:    0.7.0.1
 */