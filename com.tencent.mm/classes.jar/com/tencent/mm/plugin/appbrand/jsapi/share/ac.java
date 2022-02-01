package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.app.Activity;
import android.content.Context;
import com.tencent.luggage.sdk.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.a.d.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.snackbar.a.c;
import com.tencent.mm.ui.widget.snackbar.b;
import kotlin.g.b.z.d;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareVideoToConversationLogic;", "", "()V", "SHARE_VIDEO_REQUEST_CODE", "", "buildSelectConversationIntent", "Landroid/content/Intent;", "videoPath", "", "doShare", "", "activity", "Landroid/app/Activity;", "thumbPath", "shareCallBack", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareResult;", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareCallBack;", "doShareVideoAfterSelectConversation", "durationS", "selectedUsers", "", "customSendText", "onVideoSent", "Ljava/lang/Runnable;", "isVideoLegal2Share", "isVideoLegalCallback", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/IsFileLegalCallback;", "plugin-appbrand-integration_release"})
final class ac
{
  private static final int msZ;
  public static final ac mta;
  
  static
  {
    AppMethodBeat.i(228564);
    ac localac = new ac();
    mta = localac;
    msZ = a.aK(localac);
    AppMethodBeat.o(228564);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onSent"})
  static final class b
    implements d.a
  {
    b(String paramString, z.d paramd, Activity paramActivity, Runnable paramRunnable) {}
    
    public final void bIM()
    {
      AppMethodBeat.i(228561);
      Log.d("MicroMsg.AppBrand.JsApiShareVideoMessage", "doShareVideoAfterSelectConversation, send video to " + this.mtf + " done");
      z.d locald = this.mtg;
      locald.SYE -= 1;
      if (this.mtg.SYE <= 0)
      {
        Log.i("MicroMsg.AppBrand.JsApiShareVideoMessage", "doShareVideoAfterSelectConversation, send video done");
        b.a((Context)this.msB, null, this.msB.getString(2131760708), (a.c)new v()
        {
          public final void onHide()
          {
            AppMethodBeat.i(228560);
            Log.i("MicroMsg.AppBrand.JsApiShareVideoMessage", "doShareVideoAfterSelectConversation, snackBar hide");
            this.mth.msG.run();
            AppMethodBeat.o(228560);
          }
        });
      }
      AppMethodBeat.o(228561);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.ac
 * JD-Core Version:    0.7.0.1
 */