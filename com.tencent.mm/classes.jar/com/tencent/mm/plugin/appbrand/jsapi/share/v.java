package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.luggage.k.f.c;
import com.tencent.luggage.sdk.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.s;
import com.tencent.mm.model.ab;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.plugin.messenger.a.d;
import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareFileToConversationLogic;", "", "()V", "SHARE_FILE_REQUEST_CODE", "", "buildMediaMsg", "Lcom/tencent/mm/opensdk/modelmsg/WXMediaMessage;", "filePath", "", "fileName", "buildSelectConversationIntent", "Landroid/content/Intent;", "doShare", "", "activity", "Landroid/app/Activity;", "shareCallBack", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareResult;", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareCallBack;", "doShareFileAfterSelectConversation", "selectedUsers", "", "customSendText", "onFileSent", "Ljava/lang/Runnable;", "isFileLegal2Share", "isFileLegalCallback", "Lkotlin/Function2;", "", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/IsFileLegalCallback;", "plugin-appbrand-integration_release"})
final class v
{
  private static final int pqG;
  public static final v pqH;
  
  static
  {
    AppMethodBeat.i(274350);
    v localv = new v();
    pqH = localv;
    pqG = a.aI(localv);
    AppMethodBeat.o(274350);
  }
  
  public static void a(String paramString1, String paramString2, List<String> paramList, String paramString3, Runnable paramRunnable)
  {
    int j = 0;
    AppMethodBeat.i(274349);
    p.k(paramString1, "filePath");
    p.k(paramString2, "fileName");
    p.k(paramList, "selectedUsers");
    p.k(paramRunnable, "onFileSent");
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
        localObject = new s();
        ((s)localObject).fvk.fvl = localWXMediaMessage;
        ((s)localObject).fvk.toUser = paramString2;
        paramList.publish((IEvent)localObject);
        if (j != 0) {
          g.eRW().ai(paramString2, paramString3, ab.QZ(paramString2));
        }
      }
    }
    paramRunnable.run();
    AppMethodBeat.o(274349);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "isFileLegal", "", "<anonymous parameter 1>", "", "invoke"})
  static final class a
    extends q
    implements m
  {
    a(b paramb, Activity paramActivity, String paramString1, String paramString2)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
  static final class b
    implements DialogInterface.OnClickListener
  {
    b(m paramm) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(273891);
      this.pqM.invoke(Boolean.FALSE, null);
      AppMethodBeat.o(273891);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
  static final class c
    implements DialogInterface.OnClickListener
  {
    c(m paramm) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(282409);
      this.pqM.invoke(Boolean.FALSE, null);
      AppMethodBeat.o(282409);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.v
 * JD-Core Version:    0.7.0.1
 */