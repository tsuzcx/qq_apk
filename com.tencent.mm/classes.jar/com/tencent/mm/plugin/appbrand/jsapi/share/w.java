package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.app.Activity;
import android.content.Context;
import com.tencent.luggage.sdk.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.r;
import com.tencent.mm.model.ab;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.plugin.messenger.a.d;
import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.snackbar.a.c;
import com.tencent.mm.ui.widget.snackbar.b;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareFileToConversationLogic;", "", "()V", "SHARE_FILE_REQUEST_CODE", "", "buildMediaMsg", "Lcom/tencent/mm/opensdk/modelmsg/WXMediaMessage;", "filePath", "", "fileName", "buildSelectConversationIntent", "Landroid/content/Intent;", "doShare", "", "activity", "Landroid/app/Activity;", "shareCallBack", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareResult;", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareCallBack;", "doShareFileAfterSelectConversation", "selectedUsers", "", "customSendText", "onVideoSent", "Ljava/lang/Runnable;", "isFileLegal2Share", "isFileLegalCallback", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/IsFileLegalCallback;", "plugin-appbrand-integration_release"})
final class w
{
  private static final int msy;
  public static final w msz;
  
  static
  {
    AppMethodBeat.i(228534);
    w localw = new w();
    msz = localw;
    msy = a.aK(localw);
    AppMethodBeat.o(228534);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, List<String> paramList, String paramString3, Runnable paramRunnable)
  {
    int j = 0;
    AppMethodBeat.i(228533);
    p.h(paramActivity, "activity");
    p.h(paramString1, "filePath");
    p.h(paramString2, "fileName");
    p.h(paramList, "selectedUsers");
    p.h(paramRunnable, "onVideoSent");
    WXMediaMessage localWXMediaMessage = new WXMediaMessage();
    Object localObject = new WXFileObject();
    ((WXFileObject)localObject).setFilePath(paramString1);
    localWXMediaMessage.mediaObject = ((WXMediaMessage.IMediaObject)localObject);
    localWXMediaMessage.title = paramString2;
    localWXMediaMessage.description = paramString2;
    paramString1 = (CharSequence)paramString3;
    if ((paramString1 == null) || (paramString1.length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        j = 1;
      }
      paramString1 = paramList.iterator();
      while (paramString1.hasNext())
      {
        paramString2 = (String)paramString1.next();
        paramList = EventCenter.instance;
        localObject = new r();
        ((r)localObject).dCD.dCE = localWXMediaMessage;
        ((r)localObject).dCD.toUser = paramString2;
        paramList.publish((IEvent)localObject);
        if (j != 0) {
          g.eir().ad(paramString2, paramString3, ab.JG(paramString2));
        }
      }
    }
    b.a((Context)paramActivity, null, paramActivity.getString(2131760708), (a.c)new b(paramRunnable));
    AppMethodBeat.o(228533);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/jsapi/share/ShareFileToConversationLogic$doShareFileAfterSelectConversation$2", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/OnSnackBarVisibilityChangeListenerAdapter;", "onHide", "", "plugin-appbrand-integration_release"})
  public static final class b
    extends v
  {
    b(Runnable paramRunnable) {}
    
    public final void onHide()
    {
      AppMethodBeat.i(228530);
      Log.i("MicroMsg.AppBrand.JsApiShareFileMessage", "doShareFileAfterSelectConversation, snackBar hide");
      this.msG.run();
      AppMethodBeat.o(228530);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.w
 * JD-Core Version:    0.7.0.1
 */