package com.tencent.mm.al.c;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.q;
import com.tencent.mm.b.g;
import com.tencent.mm.bw.b;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.protocal.protobuf.ecp;
import com.tencent.mm.protocal.protobuf.ecq;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import java.lang.ref.WeakReference;

public final class a
{
  static String Fh(String paramString)
  {
    AppMethodBeat.i(188909);
    paramString = "com.tencent.wework.".concat(String.valueOf(paramString));
    AppMethodBeat.o(188909);
    return paramString;
  }
  
  static void a(Activity paramActivity, SendMessageToWX.Req paramReq)
  {
    AppMethodBeat.i(188907);
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
      AppMethodBeat.o(188907);
      return;
    }
    catch (Throwable paramActivity)
    {
      AppMethodBeat.o(188907);
    }
  }
  
  private static void a(Activity paramActivity, SendMessageToWX.Req paramReq, Bundle paramBundle, String paramString)
  {
    AppMethodBeat.i(188908);
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
      com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramReq.ahE(), "com/tencent/mm/modelbiz/ww/OpenSdkBridge", "dealSendMsgToWx", "(Landroid/app/Activity;Lcom/tencent/mm/opensdk/modelmsg/SendMessageToWX$Req;Landroid/os/Bundle;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramActivity.startActivity((Intent)paramReq.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/modelbiz/ww/OpenSdkBridge", "dealSendMsgToWx", "(Landroid/app/Activity;Lcom/tencent/mm/opensdk/modelmsg/SendMessageToWX$Req;Landroid/os/Bundle;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(188908);
      return;
      bool = false;
      break;
      localIntent.putExtra("mutil_select_is_ret", true);
    }
  }
  
  public static void a(final Activity paramActivity, ecp paramecp)
  {
    AppMethodBeat.i(188905);
    if (paramecp == null)
    {
      AppMethodBeat.o(188905);
      return;
    }
    String str = paramecp.FXI;
    if (bu.isNullOrNil(str)) {}
    for (str = null; str == null; str = ((StringBuilder)localObject).toString())
    {
      ae.w("MicroMsg.OpenSdkBridge", "doSendImage bad img_url=" + paramecp.FXI);
      AppMethodBeat.o(188905);
      return;
      localObject = new StringBuilder(com.tencent.mm.plugin.image.d.azR());
      ((StringBuilder)localObject).append(g.getMessageDigest(str.getBytes()));
    }
    Object localObject = new c.a();
    ((c.a)localObject).hgD = str;
    ((c.a)localObject).igk = true;
    ((c.a)localObject).igi = true;
    ae.w("MicroMsg.OpenSdkBridge", "doSendImage fullPath=%s", new Object[] { str });
    paramActivity = new WeakReference(paramActivity);
    q.aJb().a(paramecp.FXI, ((c.a)localObject).aJu(), new com.tencent.mm.av.a.c.d()
    {
      public final void eM(boolean paramAnonymousVarArgs)
      {
        AppMethodBeat.i(188904);
        ae.w("MicroMsg.OpenSdkBridge", "doSendImage onImageDownload success? %s=%b", new Object[] { this.hVO, Boolean.valueOf(paramAnonymousVarArgs) });
        if (paramAnonymousVarArgs)
        {
          Object localObject1 = h.decodeFile(this.hVO, null);
          Activity localActivity = (Activity)paramActivity.get();
          if (localObject1 == null) {
            ae.w("MicroMsg.OpenSdkBridge", "doSendImage null bitmap");
          }
          if ((localActivity == null) || (localActivity.isFinishing()) || (localActivity.isDestroyed()))
          {
            ae.w("MicroMsg.OpenSdkBridge", "doSendImage null or finished context");
            AppMethodBeat.o(188904);
            return;
          }
          Object localObject2 = new WXImageObject((Bitmap)localObject1);
          localObject1 = new WXMediaMessage();
          ((WXMediaMessage)localObject1).mediaObject = ((WXMediaMessage.IMediaObject)localObject2);
          localObject2 = new SendMessageToWX.Req();
          ((SendMessageToWX.Req)localObject2).transaction = a.Fh("img");
          ((SendMessageToWX.Req)localObject2).message = ((WXMediaMessage)localObject1);
          ((SendMessageToWX.Req)localObject2).scene = 0;
          a.a(localActivity, (SendMessageToWX.Req)localObject2);
        }
        AppMethodBeat.o(188904);
      }
    });
    AppMethodBeat.o(188905);
  }
  
  public static void a(Activity paramActivity, ecq paramecq)
  {
    AppMethodBeat.i(188906);
    Object localObject = new WXWebpageObject();
    ((WXWebpageObject)localObject).webpageUrl = paramecq.qlv;
    localObject = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject);
    ((WXMediaMessage)localObject).title = paramecq.title;
    ((WXMediaMessage)localObject).description = paramecq.description;
    try
    {
      ((WXMediaMessage)localObject).thumbData = Base64.decode(paramecq.IhN.zr, 0);
      label62:
      paramecq = new SendMessageToWX.Req();
      paramecq.transaction = Fh("webpage");
      paramecq.message = ((WXMediaMessage)localObject);
      paramecq.scene = 0;
      a(paramActivity, paramecq);
      AppMethodBeat.o(188906);
      return;
    }
    catch (Throwable paramecq)
    {
      break label62;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.al.c.a
 * JD-Core Version:    0.7.0.1
 */