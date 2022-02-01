package com.tencent.mm.plugin.appbrand.jsapi;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.cz.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.fav.a.ad;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.snackbar.a.c;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/AddFileToFavoritesTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "()V", "handleRequest", "", "request", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "plugin-appbrand-integration_release"})
final class a
  extends AppBrandProxyUIProcessTask
{
  public final void a(final AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    AppMethodBeat.i(228235);
    if (!(paramProcessRequest instanceof AddFileToFavoritesRequest))
    {
      Log.w("MicroMsg.AppBrand.JsApiAddFileToFavorites", "handleRequest#AddFileToFavoritesTask, request is not AddFileToFavoritesRequest");
      AppMethodBeat.o(228235);
      return;
    }
    cz localcz = new cz();
    ((ad)g.af(ad.class)).a(localcz, 6, ((AddFileToFavoritesRequest)paramProcessRequest).filePath, db.D(((AddFileToFavoritesRequest)paramProcessRequest).filePath, ((AddFileToFavoritesRequest)paramProcessRequest).gCr, ((AddFileToFavoritesRequest)paramProcessRequest).fileName), "");
    EventCenter.instance.publish((IEvent)localcz);
    if (localcz.dGa.ret == 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.AppBrand.JsApiAddFileToFavorites", "handleRequest#AddFileToFavoritesTask, success: ".concat(String.valueOf(bool)));
      paramProcessRequest = new AddToFavoritesResult(bool);
      e.a(localcz.dGa.ret, (Activity)bDF(), (a.c)new a(this, paramProcessRequest), (DialogInterface.OnClickListener)new b(this, paramProcessRequest), null);
      AppMethodBeat.o(228235);
      return;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/jsapi/AddFileToFavoritesTask$handleRequest$1", "Lcom/tencent/mm/ui/widget/snackbar/SnackBar$OnVisibilityChangeListener;", "onHide", "", "onShow", "startHide", "plugin-appbrand-integration_release"})
  public static final class a
    implements a.c
  {
    a(AddToFavoritesResult paramAddToFavoritesResult) {}
    
    public final void bDY() {}
    
    public final void onHide()
    {
      AppMethodBeat.i(228233);
      a.a(this.lxg, (AppBrandProxyUIProcessTask.ProcessResult)paramProcessRequest);
      AppMethodBeat.o(228233);
    }
    
    public final void onShow() {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
  static final class b
    implements DialogInterface.OnClickListener
  {
    b(a parama, AddToFavoritesResult paramAddToFavoritesResult) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(228234);
      paramDialogInterface.dismiss();
      a.a(this.lxg, (AppBrandProxyUIProcessTask.ProcessResult)paramProcessRequest);
      AppMethodBeat.o(228234);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.a
 * JD-Core Version:    0.7.0.1
 */