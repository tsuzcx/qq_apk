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
import com.tencent.mm.protocal.protobuf.ewx;
import com.tencent.mm.protocal.protobuf.ewy;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;

public final class a
{
  static String NR(String paramString)
  {
    AppMethodBeat.i(212207);
    paramString = "com.tencent.wework.".concat(String.valueOf(paramString));
    AppMethodBeat.o(212207);
    return paramString;
  }
  
  static void a(Activity paramActivity, SendMessageToWX.Req paramReq)
  {
    AppMethodBeat.i(212205);
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
      paramActivity.overridePendingTransition(2130772169, 2130771987);
      AppMethodBeat.o(212205);
      return;
    }
    catch (Throwable paramActivity)
    {
      AppMethodBeat.o(212205);
    }
  }
  
  private static void a(Activity paramActivity, SendMessageToWX.Req paramReq, Bundle paramBundle, String paramString)
  {
    AppMethodBeat.i(212206);
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
      localIntent.putExtra("MMActivity.OverrideExitAnimation", 2130772170);
      localIntent.putExtra("MMActivity.OverrideEnterAnimation", 2130771987);
      paramReq = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramReq.axQ(), "com/tencent/mm/modelbiz/ww/OpenSdkBridge", "dealSendMsgToWx", "(Landroid/app/Activity;Lcom/tencent/mm/opensdk/modelmsg/SendMessageToWX$Req;Landroid/os/Bundle;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramActivity.startActivity((Intent)paramReq.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/modelbiz/ww/OpenSdkBridge", "dealSendMsgToWx", "(Landroid/app/Activity;Lcom/tencent/mm/opensdk/modelmsg/SendMessageToWX$Req;Landroid/os/Bundle;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(212206);
      return;
      bool = false;
      break;
      localIntent.putExtra("mutil_select_is_ret", true);
    }
  }
  
  public static void a(final Activity paramActivity, ewx paramewx)
  {
    AppMethodBeat.i(212203);
    if (paramewx == null)
    {
      AppMethodBeat.o(212203);
      return;
    }
    String str = paramewx.KRv;
    if (Util.isNullOrNil(str)) {}
    for (str = null; str == null; str = ((StringBuilder)localObject).toString())
    {
      Log.w("MicroMsg.OpenSdkBridge", "doSendImage bad img_url=" + paramewx.KRv);
      AppMethodBeat.o(212203);
      return;
      localObject = new StringBuilder(com.tencent.mm.plugin.image.d.aSZ());
      ((StringBuilder)localObject).append(g.getMessageDigest(str.getBytes()));
    }
    Object localObject = new c.a();
    ((c.a)localObject).fullPath = str;
    ((c.a)localObject).jbf = true;
    ((c.a)localObject).jbd = true;
    Log.w("MicroMsg.OpenSdkBridge", "doSendImage fullPath=%s", new Object[] { str });
    paramActivity = new WeakReference(paramActivity);
    q.bcV().a(paramewx.KRv, ((c.a)localObject).bdv(), new com.tencent.mm.av.a.c.d()
    {
      public final void a(boolean paramAnonymousBoolean, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(212202);
        Log.w("MicroMsg.OpenSdkBridge", "doSendImage onImageDownload success? %s=%b", new Object[] { this.iQM, Boolean.valueOf(paramAnonymousBoolean) });
        if (paramAnonymousBoolean)
        {
          Object localObject1 = BitmapUtil.decodeFile(this.iQM, null);
          paramAnonymousVarArgs = (Activity)paramActivity.get();
          if (localObject1 == null) {
            Log.w("MicroMsg.OpenSdkBridge", "doSendImage null bitmap");
          }
          if ((paramAnonymousVarArgs == null) || (paramAnonymousVarArgs.isFinishing()) || (paramAnonymousVarArgs.isDestroyed()))
          {
            Log.w("MicroMsg.OpenSdkBridge", "doSendImage null or finished context");
            AppMethodBeat.o(212202);
            return;
          }
          Object localObject2 = new WXImageObject((Bitmap)localObject1);
          localObject1 = new WXMediaMessage();
          ((WXMediaMessage)localObject1).mediaObject = ((WXMediaMessage.IMediaObject)localObject2);
          localObject2 = new SendMessageToWX.Req();
          ((SendMessageToWX.Req)localObject2).transaction = a.NR("img");
          ((SendMessageToWX.Req)localObject2).message = ((WXMediaMessage)localObject1);
          ((SendMessageToWX.Req)localObject2).scene = 0;
          a.a(paramAnonymousVarArgs, (SendMessageToWX.Req)localObject2);
        }
        AppMethodBeat.o(212202);
      }
    });
    AppMethodBeat.o(212203);
  }
  
  public static void a(Activity paramActivity, ewy paramewy)
  {
    AppMethodBeat.i(212204);
    Object localObject = new WXWebpageObject();
    ((WXWebpageObject)localObject).webpageUrl = paramewy.rCq;
    localObject = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject);
    ((WXMediaMessage)localObject).title = paramewy.title;
    ((WXMediaMessage)localObject).description = paramewy.description;
    try
    {
      ((WXMediaMessage)localObject).thumbData = Base64.decode(paramewy.Nur.zy, 0);
      label62:
      paramewy = new SendMessageToWX.Req();
      paramewy.transaction = NR("webpage");
      paramewy.message = ((WXMediaMessage)localObject);
      paramewy.scene = 0;
      a(paramActivity, paramewy);
      AppMethodBeat.o(212204);
      return;
    }
    catch (Throwable paramewy)
    {
      break label62;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.al.c.a
 * JD-Core Version:    0.7.0.1
 */