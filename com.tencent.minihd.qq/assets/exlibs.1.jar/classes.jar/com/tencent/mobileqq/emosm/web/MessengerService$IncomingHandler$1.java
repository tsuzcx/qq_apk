package com.tencent.mobileqq.emosm.web;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.QQUtils;
import java.util.HashMap;
import java.util.Map;

class MessengerService$IncomingHandler$1
  implements Runnable
{
  MessengerService$IncomingHandler$1(MessengerService.IncomingHandler paramIncomingHandler, String paramString1, String paramString2, QQAppInterface paramQQAppInterface, String paramString3, String paramString4, Bundle paramBundle) {}
  
  public void run()
  {
    Bitmap localBitmap = QQUtils.a(this.val$iconUrl, this.val$starId, null, this.val$qqapp, false);
    Bundle localBundle = new Bundle();
    if (localBitmap != null)
    {
      Object localObject = new HashMap();
      ((Map)localObject).put("starHomeUrl", this.val$starHomeUrl);
      ((Map)localObject).put("nickname", this.val$nickname);
      ((Map)localObject).put("starId", this.val$starId);
      localObject = QQUtils.a(this.val$qqapp, "sid", (Map)localObject);
      QQUtils.a(this.val$qqapp, (Intent)localObject, this.val$nickname, localBitmap);
      localBundle.putInt("ret", 0);
    }
    for (;;)
    {
      this.val$reqbundle.putBundle("response", localBundle);
      this.this$1.this$0.onRespToClient(this.val$reqbundle);
      return;
      localBundle.putInt("ret", -4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.IncomingHandler.1
 * JD-Core Version:    0.7.0.1
 */