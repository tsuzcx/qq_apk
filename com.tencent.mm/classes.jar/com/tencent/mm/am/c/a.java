package com.tencent.mm.am.c;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.q;
import com.tencent.mm.bx.b;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.protocal.protobuf.eay;
import com.tencent.mm.protocal.protobuf.eaz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.ref.WeakReference;

public final class a
{
  static String EF(String paramString)
  {
    AppMethodBeat.i(207211);
    paramString = "com.tencent.wework.".concat(String.valueOf(paramString));
    AppMethodBeat.o(207211);
    return paramString;
  }
  
  static void a(Activity paramActivity, SendMessageToWX.Req paramReq)
  {
    AppMethodBeat.i(207209);
    Bundle localBundle = new Bundle();
    paramReq.toBundle(localBundle);
    Intent localIntent = new Intent();
    localIntent.putExtras(localBundle);
    localIntent.putExtra("_mmessage_appPackage", "com.tencent.wework");
    localIntent.putExtra("_mmessage_sdkVersion", 637928960);
    localIntent.putExtra("_mmessage_content", "weixin://sendreq?appid=wx4706a9fcbbca10f2");
    localIntent.putExtra("SendAppMessageWrapper_BlockInvalidToken", false);
    localIntent.putExtra("SendAppMessageWrapper_NoNeedStayInWeixin", true);
    try
    {
      a(paramActivity, paramReq, localIntent.getExtras(), "com.tencent.wework");
      paramActivity.overridePendingTransition(2130772144, 2130771987);
      AppMethodBeat.o(207209);
      return;
    }
    catch (Throwable paramActivity)
    {
      AppMethodBeat.o(207209);
    }
  }
  
  private static void a(Activity paramActivity, SendMessageToWX.Req paramReq, Bundle paramBundle, String paramString)
  {
    AppMethodBeat.i(207210);
    Intent localIntent = new Intent(paramActivity, Class.forName("com.tencent.mm.ui.transmit.SelectConversationUI"));
    localIntent.putExtra("Select_Conv_NextStep", new Intent(paramActivity, Class.forName("com.tencent.mm.ui.transmit.SendAppMessageWrapperUI")).putExtras(paramBundle).putExtra("SendAppMessageWrapper_Scene", paramReq.scene));
    localIntent.putExtra("Select_App_Id", paramString);
    localIntent.putExtra("Select_Open_Id", paramReq.openId);
    localIntent.putExtra("Select_Conv_Type", 3);
    boolean bool;
    if ((paramReq.message.getType() == 36) || (paramReq.message.getType() == 46)) {
      if (!((WXMiniProgramObject)paramReq.message.mediaObject).withShareTicket)
      {
        bool = true;
        localIntent.putExtra("mutil_select_is_ret", bool);
      }
    }
    for (;;)
    {
      if (paramReq.message.getType() == 45) {
        localIntent.putExtra("Select_Send_Card", true);
      }
      localIntent.putExtra("MMActivity.OverrideExitAnimation", 2130772145);
      localIntent.putExtra("MMActivity.OverrideEnterAnimation", 2130771987);
      paramReq = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramReq.ahp(), "com/tencent/mm/modelbiz/ww/OpenSdkBridge", "dealSendMsgToWx", "(Landroid/app/Activity;Lcom/tencent/mm/opensdk/modelmsg/SendMessageToWX$Req;Landroid/os/Bundle;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramActivity.startActivity((Intent)paramReq.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/modelbiz/ww/OpenSdkBridge", "dealSendMsgToWx", "(Landroid/app/Activity;Lcom/tencent/mm/opensdk/modelmsg/SendMessageToWX$Req;Landroid/os/Bundle;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(207210);
      return;
      bool = false;
      break;
      localIntent.putExtra("mutil_select_is_ret", true);
    }
  }
  
  public static void a(final Activity paramActivity, eay parameay)
  {
    AppMethodBeat.i(207207);
    if (parameay == null)
    {
      AppMethodBeat.o(207207);
      return;
    }
    String str = parameay.FFn;
    if (bt.isNullOrNil(str)) {}
    for (str = null; str == null; str = ((StringBuilder)localObject).toString())
    {
      ad.w("MicroMsg.OpenSdkBridge", "doSendImage bad img_url=" + parameay.FFn);
      AppMethodBeat.o(207207);
      return;
      localObject = new StringBuilder(com.tencent.mm.plugin.image.d.azB());
      ((StringBuilder)localObject).append(com.tencent.mm.b.g.getMessageDigest(str.getBytes()));
    }
    Object localObject = new c.a();
    ((c.a)localObject).hdP = str;
    ((c.a)localObject).idr = true;
    ((c.a)localObject).idp = true;
    ad.w("MicroMsg.OpenSdkBridge", "doSendImage fullPath=%s", new Object[] { str });
    paramActivity = new WeakReference(paramActivity);
    q.aIJ().a(parameay.FFn, ((c.a)localObject).aJc(), new com.tencent.mm.aw.a.c.d()
    {
      public final void eK(boolean paramAnonymousVarArgs)
      {
        AppMethodBeat.i(207206);
        ad.w("MicroMsg.OpenSdkBridge", "doSendImage onImageDownload success? %s=%b", new Object[] { this.hSW, Boolean.valueOf(paramAnonymousVarArgs) });
        if (paramAnonymousVarArgs)
        {
          Object localObject1 = com.tencent.mm.sdk.platformtools.g.decodeFile(this.hSW, null);
          Activity localActivity = (Activity)paramActivity.get();
          if (localObject1 == null) {
            ad.w("MicroMsg.OpenSdkBridge", "doSendImage null bitmap");
          }
          if ((localActivity == null) || (localActivity.isFinishing()) || (localActivity.isDestroyed()))
          {
            ad.w("MicroMsg.OpenSdkBridge", "doSendImage null or finished context");
            AppMethodBeat.o(207206);
            return;
          }
          Object localObject2 = new WXImageObject((Bitmap)localObject1);
          localObject1 = new WXMediaMessage();
          ((WXMediaMessage)localObject1).mediaObject = ((WXMediaMessage.IMediaObject)localObject2);
          localObject2 = new SendMessageToWX.Req();
          ((SendMessageToWX.Req)localObject2).transaction = a.EF("img");
          ((SendMessageToWX.Req)localObject2).message = ((WXMediaMessage)localObject1);
          ((SendMessageToWX.Req)localObject2).scene = 0;
          a.a(localActivity, (SendMessageToWX.Req)localObject2);
        }
        AppMethodBeat.o(207206);
      }
    });
    AppMethodBeat.o(207207);
  }
  
  public static void a(Activity paramActivity, eaz parameaz)
  {
    AppMethodBeat.i(207208);
    Object localObject = new WXWebpageObject();
    ((WXWebpageObject)localObject).webpageUrl = parameaz.qeQ;
    localObject = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject);
    ((WXMediaMessage)localObject).title = parameaz.title;
    ((WXMediaMessage)localObject).description = parameaz.description;
    try
    {
      ((WXMediaMessage)localObject).thumbData = Base64.decode(parameaz.HNG.zr, 0);
      label62:
      parameaz = new SendMessageToWX.Req();
      parameaz.transaction = EF("webpage");
      parameaz.message = ((WXMediaMessage)localObject);
      parameaz.scene = 0;
      a(paramActivity, parameaz);
      AppMethodBeat.o(207208);
      return;
    }
    catch (Throwable parameaz)
    {
      break label62;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.am.c.a
 * JD-Core Version:    0.7.0.1
 */