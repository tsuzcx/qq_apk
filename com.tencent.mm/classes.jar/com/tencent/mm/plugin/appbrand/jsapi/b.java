package com.tencent.mm.plugin.appbrand.jsapi;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.cz.b;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.fav.a.ad;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.snackbar.a.b;
import com.tencent.mm.ui.widget.snackbar.a.c;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/AddImageToFavoritesTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "()V", "handleRequest", "", "request", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "plugin-appbrand-integration_release"})
final class b
  extends AppBrandProxyUIProcessTask
{
  public final void a(final AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    AppMethodBeat.i(228245);
    if (!(paramProcessRequest instanceof AddImageToFavoritesRequest))
    {
      Log.w("MicroMsg.AppBrand.JsApiAddImageToFavorites", "handleRequest#AddImageToFavoritesTask, request is not AddImageToFavoritesRequest");
      AppMethodBeat.o(228245);
      return;
    }
    cz localcz = new cz();
    ((ad)g.af(ad.class)).a(localcz, 6, ((AddImageToFavoritesRequest)paramProcessRequest).imagePath);
    EventCenter.instance.publish((IEvent)localcz);
    if (localcz.dGa.ret == 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.AppBrand.JsApiAddImageToFavorites", "handleRequest#AddImageToFavoritesTask, success: ".concat(String.valueOf(bool)));
      paramProcessRequest = new AddToFavoritesResult(bool);
      e.a(localcz.dGa.ret, (Activity)bDF(), (a.c)new a(this, paramProcessRequest), (DialogInterface.OnClickListener)new b(this, paramProcessRequest), (a.b)new c(this));
      AppMethodBeat.o(228245);
      return;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/jsapi/AddImageToFavoritesTask$handleRequest$1", "Lcom/tencent/mm/ui/widget/snackbar/SnackBar$OnVisibilityChangeListener;", "onHide", "", "onShow", "startHide", "plugin-appbrand-integration_release"})
  public static final class a
    implements a.c
  {
    a(AddToFavoritesResult paramAddToFavoritesResult) {}
    
    public final void bDY() {}
    
    public final void onHide()
    {
      AppMethodBeat.i(228242);
      b.a(this.lxi, (AppBrandProxyUIProcessTask.ProcessResult)paramProcessRequest);
      AppMethodBeat.o(228242);
    }
    
    public final void onShow() {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
  static final class b
    implements DialogInterface.OnClickListener
  {
    b(b paramb, AddToFavoritesResult paramAddToFavoritesResult) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(228243);
      paramDialogInterface.dismiss();
      b.a(this.lxi, (AppBrandProxyUIProcessTask.ProcessResult)paramProcessRequest);
      AppMethodBeat.o(228243);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onMessageClick"})
  static final class c
    implements a.b
  {
    c(b paramb) {}
    
    public final void bDZ()
    {
      AppMethodBeat.i(228244);
      hb localhb = new hb();
      localhb.dLm.type = 35;
      localhb.dLm.context = ((Context)b.a(this.lxi));
      EventCenter.instance.publish((IEvent)localhb);
      AppMethodBeat.o(228244);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.b
 * JD-Core Version:    0.7.0.1
 */