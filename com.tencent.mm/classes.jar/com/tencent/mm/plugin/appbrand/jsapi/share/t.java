package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.tencent.luggage.sdk.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.k.c;
import com.tencent.mm.model.ab;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.messenger.a.d;
import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareFileToConversationLogic;", "", "()V", "SHARE_FILE_REQUEST_CODE", "", "buildMediaMsg", "Lcom/tencent/mm/opensdk/modelmsg/WXMediaMessage;", "filePath", "", "fileName", "buildSelectConversationIntent", "Landroid/content/Intent;", "doShare", "", "activity", "Landroid/app/Activity;", "shareCallBack", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareResult;", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareCallBack;", "doShareFileAfterSelectConversation", "selectedUsers", "", "customSendText", "onFileSent", "Ljava/lang/Runnable;", "isFileLegal2Share", "isFileLegalCallback", "Lkotlin/Function2;", "", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/IsFileLegalCallback;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class t
{
  public static final t svt;
  private static final int svu;
  
  static
  {
    AppMethodBeat.i(326418);
    t localt = new t();
    svt = localt;
    svu = a.ce(localt);
    AppMethodBeat.o(326418);
  }
  
  public static void a(final Activity paramActivity, final String paramString1, final String paramString2, b<? super aa, ah> paramb)
  {
    AppMethodBeat.i(326393);
    s.u(paramActivity, "activity");
    s.u(paramString1, "filePath");
    s.u(paramString2, "fileName");
    s.u(paramb, "shareCallBack");
    paramString2 = (m)new a(paramb, paramActivity, paramString2, paramString1);
    paramString1 = new com.tencent.mm.vfs.u(paramString1);
    if (paramString1.jKS()) {}
    for (paramString1 = Long.valueOf(paramString1.length());; paramString1 = null)
    {
      Log.d("MicroMsg.AppBrand.JsApiShareFileMessage", s.X("isFileLegal2Share, fileSize: ", paramString1));
      if ((paramString1 != null) && (0L < paramString1.longValue())) {
        break;
      }
      k.a((Context)paramActivity, paramActivity.getString(ba.i.favorite_share_file_not_exists), "", paramActivity.getString(ba.i.i_know_it), new t..ExternalSyntheticLambda0(paramString2));
      AppMethodBeat.o(326393);
      return;
    }
    long l = c.aRk();
    if (l < paramString1.longValue())
    {
      k.a((Context)paramActivity, paramActivity.getString(ba.i.appbrand_file_too_big_to_send, new Object[] { Util.getSizeKB(l) }), "", paramActivity.getString(ba.i.i_know_it), new t..ExternalSyntheticLambda1(paramString2));
      AppMethodBeat.o(326393);
      return;
    }
    paramString2.invoke(Boolean.TRUE, null);
    AppMethodBeat.o(326393);
  }
  
  public static void a(String paramString1, String paramString2, List<String> paramList, String paramString3, Runnable paramRunnable)
  {
    int j = 1;
    AppMethodBeat.i(326400);
    s.u(paramString1, "filePath");
    s.u(paramString2, "fileName");
    s.u(paramList, "selectedUsers");
    s.u(paramRunnable, "onFileSent");
    WXMediaMessage localWXMediaMessage = new WXMediaMessage();
    WXFileObject localWXFileObject = new WXFileObject();
    localWXFileObject.setFilePath(paramString1);
    paramString1 = ah.aiuX;
    localWXMediaMessage.mediaObject = ((WXMediaMessage.IMediaObject)localWXFileObject);
    localWXMediaMessage.title = paramString2;
    localWXMediaMessage.description = paramString2;
    paramString1 = (CharSequence)paramString3;
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      i = 1;
      if (i != 0) {
        break label197;
      }
    }
    label197:
    for (int i = j;; i = 0)
    {
      paramString1 = paramList.iterator();
      while (paramString1.hasNext())
      {
        paramString2 = (String)paramString1.next();
        paramList = new com.tencent.mm.autogen.a.u();
        paramList.hzE.hzF = localWXMediaMessage;
        paramList.hzE.toUser = paramString2;
        paramList.publish();
        if (i != 0) {
          g.gaI().ap(paramString2, paramString3, ab.IX(paramString2));
        }
      }
      i = 0;
      break;
    }
    paramRunnable.run();
    AppMethodBeat.o(326400);
  }
  
  private static final void a(m paramm, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(326403);
    s.u(paramm, "$isFileLegalCallback");
    paramm.invoke(Boolean.FALSE, null);
    AppMethodBeat.o(326403);
  }
  
  private static final void b(m paramm, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(326408);
    s.u(paramm, "$isFileLegalCallback");
    paramm.invoke(Boolean.FALSE, null);
    AppMethodBeat.o(326408);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "isFileLegal", "", "<anonymous parameter 1>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.g.b.u
    implements m
  {
    a(b<? super aa, ah> paramb, Activity paramActivity, String paramString1, String paramString2)
    {
      super();
    }
    
    private static final void T(b paramb)
    {
      AppMethodBeat.i(326358);
      s.u(paramb, "$shareCallBack");
      paramb.invoke(aa.svN);
      AppMethodBeat.o(326358);
    }
    
    private static final boolean a(b paramb, String paramString1, String paramString2, int paramInt1, int paramInt2, Intent paramIntent)
    {
      int i = 0;
      AppMethodBeat.i(326366);
      s.u(paramb, "$shareCallBack");
      s.u(paramString1, "$filePath");
      s.u(paramString2, "$fileName");
      Object localObject1 = new StringBuilder("doShare, requestCode: ").append(paramInt1).append(", resultCode: ").append(paramInt2).append(", data exists: ");
      if (paramIntent != null) {}
      for (boolean bool = true;; bool = false)
      {
        Log.i("MicroMsg.AppBrand.JsApiShareFileMessage", bool);
        if (t.cuG() == paramInt1) {
          break;
        }
        AppMethodBeat.o(326366);
        return false;
      }
      if (paramInt2 != -1)
      {
        Log.i("MicroMsg.AppBrand.JsApiShareFileMessage", "doShare, cancel");
        paramb.invoke(aa.svO);
        AppMethodBeat.o(326366);
        return true;
      }
      if (paramIntent == null)
      {
        Log.i("MicroMsg.AppBrand.JsApiShareFileMessage", "doShare, fail since data is null");
        paramb.invoke(aa.svP);
        AppMethodBeat.o(326366);
        return true;
      }
      localObject1 = paramIntent.getStringExtra("Select_Conv_User");
      Log.d("MicroMsg.AppBrand.JsApiShareFileMessage", s.X("doShare, selectedUsersStr: ", localObject1));
      Object localObject2 = (CharSequence)localObject1;
      if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {}
      for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
      {
        Log.i("MicroMsg.AppBrand.JsApiShareFileMessage", "doShare, fail since selectedUsers is empty 1");
        paramb.invoke(aa.svP);
        AppMethodBeat.o(326366);
        return true;
      }
      localObject1 = Util.stringToList((String)localObject1, ",");
      localObject2 = (Collection)localObject1;
      if (localObject2 != null)
      {
        paramInt1 = i;
        if (!((Collection)localObject2).isEmpty()) {}
      }
      else
      {
        paramInt1 = 1;
      }
      if (paramInt1 != 0)
      {
        Log.i("MicroMsg.AppBrand.JsApiShareFileMessage", "doShare, fail since selectedUsers is empty 2");
        paramb.invoke(aa.svP);
        AppMethodBeat.o(326366);
        return true;
      }
      paramIntent = paramIntent.getStringExtra("custom_send_text");
      Log.d("MicroMsg.AppBrand.JsApiShareFileMessage", s.X("doShare, customSendText: ", paramIntent));
      localObject2 = t.svt;
      s.s(localObject1, "selectedUsers");
      t.a(paramString1, paramString2, (List)localObject1, paramIntent, new t.a..ExternalSyntheticLambda1(paramb));
      AppMethodBeat.o(326366);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.t
 * JD-Core Version:    0.7.0.1
 */