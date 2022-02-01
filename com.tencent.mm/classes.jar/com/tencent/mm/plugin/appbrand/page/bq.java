package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.a.h;
import com.tencent.mm.plugin.appbrand.page.c.a;
import com.tencent.mm.plugin.appbrand.page.c.c.b;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/MPPageViewStatusBarExtensionImpl;", "Lcom/tencent/mm/plugin/appbrand/page/extensions/AppBrandPageViewStatusBarExtension;", "Lcom/tencent/mm/plugin/appbrand/page/extensions/AppBrandPageViewExtensionLifecycle;", "page", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;)V", "H", "Lcom/tencent/mm/plugin/appbrand/page/statusbar/IPageStatusBarHelper;", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;Lcom/tencent/mm/plugin/appbrand/page/statusbar/IPageStatusBarHelper;)V", "hideStatusBar", "", "isStatusBarHidden", "", "onActionbarInstalled", "actionBar", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar;", "onBackground", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDestroy", "onForeground", "showStatusBar", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public class bq
  implements com.tencent.mm.plugin.appbrand.page.a.b, h
{
  private final ad enX;
  private final com.tencent.mm.plugin.appbrand.page.c.c tAV;
  
  public bq(ad paramad)
  {
    this(paramad, localc);
    AppMethodBeat.i(148006);
    AppMethodBeat.o(148006);
  }
  
  public bq(ad paramad, com.tencent.mm.plugin.appbrand.page.c.c paramc)
  {
    AppMethodBeat.i(148005);
    this.enX = paramad;
    this.tAV = paramc;
    AppMethodBeat.o(148005);
  }
  
  private static final void a(a parama, bq parambq, Configuration paramConfiguration)
  {
    AppMethodBeat.i(324995);
    s.u(parama, "$H21");
    s.u(parambq, "this$0");
    s.u(paramConfiguration, "$newConfig");
    parama.v(parambq.enX.qwF.asq(), paramConfiguration.orientation);
    AppMethodBeat.o(324995);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.widget.actionbar.b paramb)
  {
    AppMethodBeat.i(325025);
    s.u(paramb, "actionBar");
    AppMethodBeat.o(325025);
  }
  
  public final void aql()
  {
    AppMethodBeat.i(148000);
    Object localObject = (e)this.enX;
    if (MMHandlerThread.isMainThread())
    {
      this.tAV.aql();
      AppMethodBeat.o(148000);
      return;
    }
    localObject = ((e)localObject).getContentView();
    if (localObject != null) {
      ((View)localObject).post((Runnable)new b(this));
    }
    AppMethodBeat.o(148000);
  }
  
  public final void aqm()
  {
    AppMethodBeat.i(148001);
    Object localObject = (e)this.enX;
    if (MMHandlerThread.isMainThread())
    {
      this.tAV.aqm();
      AppMethodBeat.o(148001);
      return;
    }
    localObject = ((e)localObject).getContentView();
    if (localObject != null) {
      ((View)localObject).post((Runnable)new a(this));
    }
    AppMethodBeat.o(148001);
  }
  
  public final boolean aqo()
  {
    AppMethodBeat.i(148004);
    if (this.tAV.aqn() == c.b.tDc)
    {
      AppMethodBeat.o(148004);
      return true;
    }
    AppMethodBeat.o(148004);
    return false;
  }
  
  public final void onBackground() {}
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(148003);
    s.u(paramConfiguration, "newConfig");
    Object localObject = this.tAV;
    if ((localObject instanceof a)) {}
    for (localObject = (a)localObject;; localObject = null)
    {
      if (localObject != null) {
        this.enX.post(new bq..ExternalSyntheticLambda0((a)localObject, this, paramConfiguration));
      }
      AppMethodBeat.o(148003);
      return;
    }
  }
  
  public final void onDestroy() {}
  
  public final void onForeground()
  {
    AppMethodBeat.i(148002);
    this.tAV.apW();
    Object localObject = this.tAV;
    if ((localObject instanceof a)) {}
    for (localObject = (a)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((a)localObject).v(this.enX.qwF.asq(), this.enX.getContext().getResources().getConfiguration().orientation);
      }
      AppMethodBeat.o(148002);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "com/tencent/mm/plugin/appbrand/page/AppBrandComponentViewWxa$runOnUiThread$1"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Runnable
  {
    public a(bq parambq) {}
    
    public final void run()
    {
      AppMethodBeat.i(147997);
      bq.a(this.tAW).aqm();
      AppMethodBeat.o(147997);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "com/tencent/mm/plugin/appbrand/page/AppBrandComponentViewWxa$runOnUiThread$1"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Runnable
  {
    public b(bq parambq) {}
    
    public final void run()
    {
      AppMethodBeat.i(147999);
      bq.a(this.tAW).aql();
      AppMethodBeat.o(147999);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bq
 * JD-Core Version:    0.7.0.1
 */