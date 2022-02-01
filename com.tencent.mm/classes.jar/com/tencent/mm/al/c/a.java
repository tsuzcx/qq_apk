package com.tencent.mm.al.c;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.o;
import com.tencent.mm.b.g;
import com.tencent.mm.bw.b;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.protocal.protobuf.dve;
import com.tencent.mm.protocal.protobuf.dvf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;
import java.lang.ref.WeakReference;

public final class a
{
  static String BG(String paramString)
  {
    AppMethodBeat.i(209558);
    paramString = "com.tencent.wework.".concat(String.valueOf(paramString));
    AppMethodBeat.o(209558);
    return paramString;
  }
  
  static void a(Activity paramActivity, SendMessageToWX.Req paramReq)
  {
    AppMethodBeat.i(209556);
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
      AppMethodBeat.o(209556);
      return;
    }
    catch (Throwable paramActivity)
    {
      AppMethodBeat.o(209556);
    }
  }
  
  private static void a(Activity paramActivity, SendMessageToWX.Req paramReq, Bundle paramBundle, String paramString)
  {
    AppMethodBeat.i(209557);
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
      paramReq = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramReq.aeD(), "com/tencent/mm/modelbiz/ww/OpenSdkBridge", "dealSendMsgToWx", "(Landroid/app/Activity;Lcom/tencent/mm/opensdk/modelmsg/SendMessageToWX$Req;Landroid/os/Bundle;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramActivity.startActivity((Intent)paramReq.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/modelbiz/ww/OpenSdkBridge", "dealSendMsgToWx", "(Landroid/app/Activity;Lcom/tencent/mm/opensdk/modelmsg/SendMessageToWX$Req;Landroid/os/Bundle;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(209557);
      return;
      bool = false;
      break;
      localIntent.putExtra("mutil_select_is_ret", true);
    }
  }
  
  public static void a(final Activity paramActivity, dve paramdve)
  {
    AppMethodBeat.i(209554);
    if (paramdve == null)
    {
      AppMethodBeat.o(209554);
      return;
    }
    String str = paramdve.DZN;
    if (bs.isNullOrNil(str)) {}
    for (str = null; str == null; str = ((StringBuilder)localObject).toString())
    {
      ac.w("MicroMsg.OpenSdkBridge", "doSendImage bad img_url=" + paramdve.DZN);
      AppMethodBeat.o(209554);
      return;
      localObject = new StringBuilder(com.tencent.mm.plugin.image.d.awM());
      ((StringBuilder)localObject).append(g.getMessageDigest(str.getBytes()));
    }
    Object localObject = new c.a();
    ((c.a)localObject).gKe = str;
    ((c.a)localObject).hKx = true;
    ((c.a)localObject).hKv = true;
    ac.w("MicroMsg.OpenSdkBridge", "doSendImage fullPath=%s", new Object[] { str });
    paramActivity = new WeakReference(paramActivity);
    o.aFB().a(paramdve.DZN, ((c.a)localObject).aFT(), new com.tencent.mm.av.a.c.d()
    {
      public final void eI(boolean paramAnonymousVarArgs)
      {
        AppMethodBeat.i(209553);
        ac.w("MicroMsg.OpenSdkBridge", "doSendImage onImageDownload success? %s=%b", new Object[] { this.hAB, Boolean.valueOf(paramAnonymousVarArgs) });
        if (paramAnonymousVarArgs)
        {
          Object localObject1 = f.decodeFile(this.hAB, null);
          Activity localActivity = (Activity)paramActivity.get();
          if (localObject1 == null) {
            ac.w("MicroMsg.OpenSdkBridge", "doSendImage null bitmap");
          }
          if ((localActivity == null) || (localActivity.isFinishing()) || (localActivity.isDestroyed()))
          {
            ac.w("MicroMsg.OpenSdkBridge", "doSendImage null or finished context");
            AppMethodBeat.o(209553);
            return;
          }
          Object localObject2 = new WXImageObject((Bitmap)localObject1);
          localObject1 = new WXMediaMessage();
          ((WXMediaMessage)localObject1).mediaObject = ((WXMediaMessage.IMediaObject)localObject2);
          localObject2 = new SendMessageToWX.Req();
          ((SendMessageToWX.Req)localObject2).transaction = a.BG("img");
          ((SendMessageToWX.Req)localObject2).message = ((WXMediaMessage)localObject1);
          ((SendMessageToWX.Req)localObject2).scene = 0;
          a.a(localActivity, (SendMessageToWX.Req)localObject2);
        }
        AppMethodBeat.o(209553);
      }
    });
    AppMethodBeat.o(209554);
  }
  
  public static void a(Activity paramActivity, dvf paramdvf)
  {
    AppMethodBeat.i(209555);
    Object localObject = new WXWebpageObject();
    ((WXWebpageObject)localObject).webpageUrl = paramdvf.pBl;
    localObject = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject);
    ((WXMediaMessage)localObject).title = paramdvf.title;
    ((WXMediaMessage)localObject).description = paramdvf.description;
    try
    {
      ((WXMediaMessage)localObject).thumbData = Base64.decode(paramdvf.GcJ.xy, 0);
      label62:
      paramdvf = new SendMessageToWX.Req();
      paramdvf.transaction = BG("webpage");
      paramdvf.message = ((WXMediaMessage)localObject);
      paramdvf.scene = 0;
      a(paramActivity, paramdvf);
      AppMethodBeat.o(209555);
      return;
    }
    catch (Throwable paramdvf)
    {
      break label62;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.al.c.a
 * JD-Core Version:    0.7.0.1
 */