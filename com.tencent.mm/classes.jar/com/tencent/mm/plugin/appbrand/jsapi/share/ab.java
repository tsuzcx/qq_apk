package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.tencent.luggage.sdk.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.k.c;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.jsapi.dn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.ah.d;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareVideoToConversationLogic;", "", "()V", "SHARE_VIDEO_REQUEST_CODE", "", "buildSelectConversationIntent", "Landroid/content/Intent;", "videoPath", "", "doShare", "", "activity", "Landroid/app/Activity;", "thumbPath", "shareCallBack", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareResult;", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareCallBack;", "doShareVideoAfterSelectConversation", "durationS", "selectedUsers", "", "customSendText", "onVideoSent", "Ljava/lang/Runnable;", "isVideoLegal2Share", "isVideoLegalCallback", "Lkotlin/Function2;", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareVideoToConversationLogic$VideoInfo;", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/IsFileLegalCallback;", "VideoInfo", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class ab
{
  public static final ab svR;
  private static final int svS;
  
  static
  {
    AppMethodBeat.i(326385);
    ab localab = new ab();
    svR = localab;
    svS = a.ce(localab);
    AppMethodBeat.o(326385);
  }
  
  public static void a(final Activity paramActivity, final String paramString1, final String paramString2, b<? super aa, ah> paramb)
  {
    Object localObject = null;
    AppMethodBeat.i(326353);
    s.u(paramActivity, "activity");
    s.u(paramString1, "videoPath");
    s.u(paramb, "shareCallBack");
    paramString2 = (m)new b(paramb, paramActivity, paramString1, paramString2);
    int i = dn.ZT(paramString1);
    if (i <= 0)
    {
      Log.w("MicroMsg.AppBrand.JsApiShareVideoMessage", s.X("isVideoLegal2Share, durationS: ", Integer.valueOf(i)));
      paramString2.invoke(Boolean.FALSE, null);
      AppMethodBeat.o(326353);
      return;
    }
    paramb = new com.tencent.mm.vfs.u(paramString1);
    paramString1 = localObject;
    if (paramb.jKS()) {
      paramString1 = Long.valueOf(paramb.length());
    }
    Log.d("MicroMsg.AppBrand.JsApiShareVideoMessage", s.X("isVideoLegal2Share, videoSize: ", paramString1));
    if ((paramString1 == null) || (0L >= paramString1.longValue()))
    {
      k.a((Context)paramActivity, paramActivity.getString(ba.i.gallery_pic_video_too_short_title), "", paramActivity.getString(ba.i.i_know_it), new ab..ExternalSyntheticLambda0(paramString2));
      AppMethodBeat.o(326353);
      return;
    }
    if (c.aRj() < paramString1.longValue())
    {
      k.a((Context)paramActivity, paramActivity.getString(ba.i.gallery_send_video_over_size), "", paramActivity.getString(ba.i.i_know_it), new ab..ExternalSyntheticLambda1(paramString2));
      AppMethodBeat.o(326353);
      return;
    }
    paramString2.invoke(Boolean.TRUE, new ab.a(i));
    AppMethodBeat.o(326353);
  }
  
  private static final void a(String paramString, ah.d paramd, Runnable paramRunnable)
  {
    AppMethodBeat.i(326369);
    s.u(paramString, "$selectedUser");
    s.u(paramd, "$pendingSendCount");
    s.u(paramRunnable, "$onVideoSent");
    Log.d("MicroMsg.AppBrand.JsApiShareVideoMessage", "doShareVideoAfterSelectConversation, send video to " + paramString + " done");
    paramd.aixb -= 1;
    if (paramd.aixb <= 0)
    {
      Log.i("MicroMsg.AppBrand.JsApiShareVideoMessage", "doShareVideoAfterSelectConversation, send video done");
      paramRunnable.run();
    }
    AppMethodBeat.o(326369);
  }
  
  private static final void c(m paramm, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(326360);
    s.u(paramm, "$isVideoLegalCallback");
    paramm.invoke(Boolean.FALSE, null);
    AppMethodBeat.o(326360);
  }
  
  private static final void d(m paramm, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(326365);
    s.u(paramm, "$isVideoLegalCallback");
    paramm.invoke(Boolean.FALSE, null);
    AppMethodBeat.o(326365);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "isVideoLegal", "", "videoInfo", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareVideoToConversationLogic$VideoInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements m<Boolean, ab.a, ah>
  {
    b(b<? super aa, ah> paramb, Activity paramActivity, String paramString1, String paramString2)
    {
      super();
    }
    
    private static final void T(b paramb)
    {
      AppMethodBeat.i(326398);
      s.u(paramb, "$shareCallBack");
      paramb.invoke(aa.svN);
      AppMethodBeat.o(326398);
    }
    
    private static final boolean a(b paramb, ab.a parama, String paramString1, String paramString2, Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(326405);
      s.u(paramb, "$shareCallBack");
      s.u(paramString1, "$videoPath");
      s.u(paramActivity, "$activity");
      Object localObject1 = new StringBuilder("doShare, requestCode: ").append(paramInt1).append(", resultCode: ").append(paramInt2).append(", data exists: ");
      if (paramIntent != null) {}
      for (boolean bool = true;; bool = false)
      {
        Log.i("MicroMsg.AppBrand.JsApiShareVideoMessage", bool);
        if (ab.cuH() == paramInt1) {
          break;
        }
        AppMethodBeat.o(326405);
        return false;
      }
      if (paramInt2 != -1)
      {
        Log.i("MicroMsg.AppBrand.JsApiShareVideoMessage", "doShare, cancel");
        paramb.invoke(aa.svO);
        AppMethodBeat.o(326405);
        return true;
      }
      if (paramIntent == null)
      {
        Log.i("MicroMsg.AppBrand.JsApiShareVideoMessage", "doShare, fail since data is null");
        paramb.invoke(aa.svP);
        AppMethodBeat.o(326405);
        return true;
      }
      localObject1 = paramIntent.getStringExtra("Select_Conv_User");
      Log.d("MicroMsg.AppBrand.JsApiShareVideoMessage", s.X("doShare, selectedUsersStr: ", localObject1));
      Object localObject2 = (CharSequence)localObject1;
      if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {}
      for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
      {
        Log.i("MicroMsg.AppBrand.JsApiShareVideoMessage", "doShare, fail since selectedUsers is empty 1");
        paramb.invoke(aa.svP);
        AppMethodBeat.o(326405);
        return true;
      }
      localObject1 = Util.stringToList((String)localObject1, ",");
      localObject2 = (Collection)localObject1;
      if ((localObject2 == null) || (((Collection)localObject2).isEmpty())) {}
      for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
      {
        Log.i("MicroMsg.AppBrand.JsApiShareVideoMessage", "doShare, fail since selectedUsers is empty 2");
        paramb.invoke(aa.svP);
        AppMethodBeat.o(326405);
        return true;
      }
      paramIntent = paramIntent.getStringExtra("custom_send_text");
      Log.d("MicroMsg.AppBrand.JsApiShareVideoMessage", s.X("doShare, customSendText: ", paramIntent));
      s.checkNotNull(parama);
      paramInt2 = parama.svT;
      parama = dn.dO(paramString1, paramString2);
      paramString2 = (CharSequence)parama;
      if ((paramString2 == null) || (paramString2.length() == 0)) {}
      for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
      {
        Log.w("MicroMsg.AppBrand.JsApiShareVideoMessage", "doShare, thumbPath is empty");
        paramb.invoke(aa.svP);
        AppMethodBeat.o(326405);
        return true;
      }
      paramString2 = ab.svR;
      s.s(localObject1, "selectedUsers");
      ab.a(paramActivity, paramString1, parama, paramInt2, (List)localObject1, paramIntent, new ab.b..ExternalSyntheticLambda1(paramb));
      AppMethodBeat.o(326405);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.ab
 * JD-Core Version:    0.7.0.1
 */