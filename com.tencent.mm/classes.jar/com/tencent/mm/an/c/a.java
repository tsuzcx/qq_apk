package com.tencent.mm.an.c;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.bx.b;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.biz.b.a;
import com.tencent.mm.protocal.protobuf.gdv;
import com.tencent.mm.protocal.protobuf.gdw;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;

public final class a
{
  static String Nn(String paramString)
  {
    AppMethodBeat.i(239459);
    paramString = "com.tencent.wework.".concat(String.valueOf(paramString));
    AppMethodBeat.o(239459);
    return paramString;
  }
  
  static void a(Activity paramActivity, SendMessageToWX.Req paramReq)
  {
    AppMethodBeat.i(239450);
    Bundle localBundle = new Bundle();
    paramReq.toBundle(localBundle);
    Intent localIntent = new Intent();
    localIntent.putExtras(localBundle);
    localIntent.putExtra("_mmessage_appPackage", "com.tencent.wework");
    localIntent.putExtra("_mmessage_sdkVersion", 638058496);
    localIntent.putExtra("_mmessage_content", "weixin://sendreq?appid=wx4706a9fcbbca10f2");
    localIntent.putExtra("SendAppMessageWrapper_BlockInvalidToken", false);
    localIntent.putExtra("SendAppMessageWrapper_NoNeedStayInWeixin", true);
    try
    {
      a(paramActivity, paramReq, localIntent.getExtras(), "com.tencent.wework");
      paramActivity.overridePendingTransition(b.a.slide_right_in, b.a.anim_not_change_for_slide);
      return;
    }
    finally
    {
      AppMethodBeat.o(239450);
    }
  }
  
  private static void a(Activity paramActivity, SendMessageToWX.Req paramReq, Bundle paramBundle, String paramString)
  {
    AppMethodBeat.i(239456);
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
      localIntent.putExtra("MMActivity.OverrideExitAnimation", b.a.slide_right_out);
      localIntent.putExtra("MMActivity.OverrideEnterAnimation", b.a.anim_not_change_for_slide);
      paramReq = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramActivity, paramReq.aYi(), "com/tencent/mm/modelbiz/ww/OpenSdkBridge", "dealSendMsgToWx", "(Landroid/app/Activity;Lcom/tencent/mm/opensdk/modelmsg/SendMessageToWX$Req;Landroid/os/Bundle;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramActivity.startActivity((Intent)paramReq.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "com/tencent/mm/modelbiz/ww/OpenSdkBridge", "dealSendMsgToWx", "(Landroid/app/Activity;Lcom/tencent/mm/opensdk/modelmsg/SendMessageToWX$Req;Landroid/os/Bundle;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(239456);
      return;
      bool = false;
      break;
      localIntent.putExtra("mutil_select_is_ret", true);
    }
  }
  
  public static void a(final Activity paramActivity, gdv paramgdv)
  {
    AppMethodBeat.i(239442);
    if (paramgdv == null)
    {
      AppMethodBeat.o(239442);
      return;
    }
    String str = paramgdv.DUR;
    if (Util.isNullOrNil(str)) {}
    for (str = null; str == null; str = ((StringBuilder)localObject).toString())
    {
      Log.w("MicroMsg.OpenSdkBridge", "doSendImage bad img_url=" + paramgdv.DUR);
      AppMethodBeat.o(239442);
      return;
      localObject = new StringBuilder(com.tencent.mm.plugin.image.d.bzM());
      ((StringBuilder)localObject).append(g.getMessageDigest(str.getBytes()));
    }
    Object localObject = new c.a();
    ((c.a)localObject).fullPath = str;
    ((c.a)localObject).oKp = true;
    ((c.a)localObject).oKn = true;
    Log.w("MicroMsg.OpenSdkBridge", "doSendImage fullPath=%s", new Object[] { str });
    paramActivity = new WeakReference(paramActivity);
    r.bKe().a(paramgdv.DUR, ((c.a)localObject).bKx(), new com.tencent.mm.modelimage.loader.b.d()
    {
      public final void onImageDownload(boolean paramAnonymousBoolean, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(239440);
        Log.w("MicroMsg.OpenSdkBridge", "doSendImage onImageDownload success? %s=%b", new Object[] { a.this, Boolean.valueOf(paramAnonymousBoolean) });
        if (paramAnonymousBoolean)
        {
          Object localObject1 = BitmapUtil.decodeFile(a.this, null);
          paramAnonymousVarArgs = (Activity)paramActivity.get();
          if (localObject1 == null) {
            Log.w("MicroMsg.OpenSdkBridge", "doSendImage null bitmap");
          }
          if ((paramAnonymousVarArgs == null) || (paramAnonymousVarArgs.isFinishing()) || (paramAnonymousVarArgs.isDestroyed()))
          {
            Log.w("MicroMsg.OpenSdkBridge", "doSendImage null or finished context");
            AppMethodBeat.o(239440);
            return;
          }
          Object localObject2 = new WXImageObject((Bitmap)localObject1);
          localObject1 = new WXMediaMessage();
          ((WXMediaMessage)localObject1).mediaObject = ((WXMediaMessage.IMediaObject)localObject2);
          localObject2 = new SendMessageToWX.Req();
          ((SendMessageToWX.Req)localObject2).transaction = a.Nn("img");
          ((SendMessageToWX.Req)localObject2).message = ((WXMediaMessage)localObject1);
          ((SendMessageToWX.Req)localObject2).scene = 0;
          a.a(paramAnonymousVarArgs, (SendMessageToWX.Req)localObject2);
        }
        AppMethodBeat.o(239440);
      }
    });
    AppMethodBeat.o(239442);
  }
  
  public static void a(Activity paramActivity, gdw paramgdw)
  {
    AppMethodBeat.i(239447);
    Object localObject = new WXWebpageObject();
    ((WXWebpageObject)localObject).webpageUrl = paramgdw.ytZ;
    localObject = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject);
    ((WXMediaMessage)localObject).title = paramgdw.title;
    ((WXMediaMessage)localObject).description = paramgdw.description;
    try
    {
      ((WXMediaMessage)localObject).thumbData = Base64.decode(paramgdw.acbB.Op, 0);
      label62:
      paramgdw = new SendMessageToWX.Req();
      paramgdw.transaction = Nn("webpage");
      paramgdw.message = ((WXMediaMessage)localObject);
      paramgdw.scene = 0;
      a(paramActivity, paramgdw);
      AppMethodBeat.o(239447);
      return;
    }
    finally
    {
      break label62;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.an.c.a
 * JD-Core Version:    0.7.0.1
 */