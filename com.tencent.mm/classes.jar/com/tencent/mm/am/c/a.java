package com.tencent.mm.am.c;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.o;
import com.tencent.mm.b.g;
import com.tencent.mm.bx.b;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.protocal.protobuf.dpn;
import com.tencent.mm.protocal.protobuf.dpo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
import java.lang.ref.WeakReference;

public final class a
{
  static void a(Activity paramActivity, SendMessageToWX.Req paramReq)
  {
    AppMethodBeat.i(191080);
    Bundle localBundle = new Bundle();
    paramReq.toBundle(localBundle);
    Intent localIntent = new Intent();
    localIntent.putExtras(localBundle);
    localIntent.putExtra("_mmessage_appPackage", "com.tencent.wework");
    localIntent.putExtra("_mmessage_sdkVersion", 637927424);
    localIntent.putExtra("_mmessage_content", "weixin://sendreq?appid=wx4706a9fcbbca10f2");
    localIntent.putExtra("SendAppMessageWrapper_BlockInvalidToken", false);
    localIntent.putExtra("SendAppMessageWrapper_NoNeedStayInWeixin", true);
    try
    {
      a(paramActivity, paramReq, localIntent.getExtras(), "com.tencent.wework");
      paramActivity.overridePendingTransition(2130772144, 2130771987);
      AppMethodBeat.o(191080);
      return;
    }
    catch (Throwable paramActivity)
    {
      AppMethodBeat.o(191080);
    }
  }
  
  private static void a(Activity paramActivity, SendMessageToWX.Req paramReq, Bundle paramBundle, String paramString)
  {
    AppMethodBeat.i(191081);
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
      paramReq = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramReq.adn(), "com/tencent/mm/modelbiz/ww/OpenSdkBridge", "dealSendMsgToWx", "(Landroid/app/Activity;Lcom/tencent/mm/opensdk/modelmsg/SendMessageToWX$Req;Landroid/os/Bundle;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramActivity.startActivity((Intent)paramReq.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/modelbiz/ww/OpenSdkBridge", "dealSendMsgToWx", "(Landroid/app/Activity;Lcom/tencent/mm/opensdk/modelmsg/SendMessageToWX$Req;Landroid/os/Bundle;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(191081);
      return;
      bool = false;
      break;
      localIntent.putExtra("mutil_select_is_ret", true);
    }
  }
  
  public static void a(final Activity paramActivity, dpn paramdpn)
  {
    AppMethodBeat.i(191078);
    if (paramdpn == null)
    {
      AppMethodBeat.o(191078);
      return;
    }
    String str = paramdpn.CHl;
    if (bt.isNullOrNil(str)) {}
    for (str = null; str == null; str = ((StringBuilder)localObject).toString())
    {
      ad.w("MicroMsg.OpenSdkBridge", "doSendImage bad img_url=" + paramdpn.CHl);
      AppMethodBeat.o(191078);
      return;
      localObject = new StringBuilder(com.tencent.mm.plugin.image.d.apX());
      ((StringBuilder)localObject).append(g.getMessageDigest(str.getBytes()));
    }
    Object localObject = new c.a();
    ((c.a)localObject).gjt = str;
    ((c.a)localObject).hjU = true;
    ((c.a)localObject).hjS = true;
    ad.w("MicroMsg.OpenSdkBridge", "doSendImage fullPath=%s", new Object[] { str });
    paramActivity = new WeakReference(paramActivity);
    o.ayJ().a(paramdpn.CHl, ((c.a)localObject).azc(), new com.tencent.mm.aw.a.c.d()
    {
      public final void en(boolean paramAnonymousVarArgs)
      {
        AppMethodBeat.i(191077);
        ad.w("MicroMsg.OpenSdkBridge", "doSendImage onImageDownload success? %s=%b", new Object[] { this.hac, Boolean.valueOf(paramAnonymousVarArgs) });
        if (paramAnonymousVarArgs)
        {
          Object localObject1 = f.decodeFile(this.hac, null);
          Activity localActivity = (Activity)paramActivity.get();
          if (localObject1 == null) {
            ad.w("MicroMsg.OpenSdkBridge", "doSendImage null bitmap");
          }
          if ((localActivity == null) || (localActivity.isFinishing()) || (localActivity.isDestroyed()))
          {
            ad.w("MicroMsg.OpenSdkBridge", "doSendImage null or finished context");
            AppMethodBeat.o(191077);
            return;
          }
          Object localObject2 = new WXImageObject((Bitmap)localObject1);
          localObject1 = new WXMediaMessage();
          ((WXMediaMessage)localObject1).mediaObject = ((WXMediaMessage.IMediaObject)localObject2);
          localObject2 = new SendMessageToWX.Req();
          ((SendMessageToWX.Req)localObject2).transaction = a.xA("img");
          ((SendMessageToWX.Req)localObject2).message = ((WXMediaMessage)localObject1);
          ((SendMessageToWX.Req)localObject2).scene = 0;
          a.a(localActivity, (SendMessageToWX.Req)localObject2);
        }
        AppMethodBeat.o(191077);
      }
    });
    AppMethodBeat.o(191078);
  }
  
  public static void a(Activity paramActivity, dpo paramdpo)
  {
    AppMethodBeat.i(191079);
    Object localObject = new WXWebpageObject();
    ((WXWebpageObject)localObject).webpageUrl = paramdpo.oYa;
    localObject = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject);
    ((WXMediaMessage)localObject).title = paramdpo.title;
    ((WXMediaMessage)localObject).description = paramdpo.description;
    try
    {
      ((WXMediaMessage)localObject).thumbData = Base64.decode(paramdpo.EFx.wA, 0);
      label62:
      paramdpo = new SendMessageToWX.Req();
      paramdpo.transaction = xA("webpage");
      paramdpo.message = ((WXMediaMessage)localObject);
      paramdpo.scene = 0;
      a(paramActivity, paramdpo);
      AppMethodBeat.o(191079);
      return;
    }
    catch (Throwable paramdpo)
    {
      break label62;
    }
  }
  
  static String xA(String paramString)
  {
    AppMethodBeat.i(191082);
    paramString = "com.tencent.wework.".concat(String.valueOf(paramString));
    AppMethodBeat.o(191082);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.am.c.a
 * JD-Core Version:    0.7.0.1
 */