package com.tencent.mm.plugin.base.stub;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.pluginsdk.model.app.ReportUtil.ReportArgs;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.chatting.ChattingUI;

final class UIEntryStub$3
  implements d.a
{
  UIEntryStub$3(UIEntryStub paramUIEntryStub, Bundle paramBundle, SendMessageToWX.Req paramReq) {}
  
  public final void em(boolean paramBoolean)
  {
    boolean bool = this.hRY.isFinishing();
    Object localObject = this.byv.getString("SendAppMessageWrapper_UserName", "");
    y.i("MicroMsg.UIEntryStub", "onCheckEnd, isPass = " + paramBoolean + ", isFinishing = " + bool + ", username = " + (String)localObject);
    if ((paramBoolean) && (!bool) && (!bk.bl((String)localObject)))
    {
      Intent localIntent = new Intent(this.hRY, ChattingUI.class);
      localIntent.putExtras(this.byv);
      localIntent.putExtra("finish_direct", false);
      localIntent.putExtra("Chat_User", (String)localObject);
      localIntent.putExtra("SendAppMessageWrapper_Scene", this.hRZ.scene);
      this.hRY.startActivity(localIntent);
    }
    for (;;)
    {
      new ah().postDelayed(new UIEntryStub.3.1(this), 1000L);
      return;
      localObject = ReportUtil.c(this.hRY.getIntent().getExtras(), -3);
      ReportUtil.a(this.hRY, (ReportUtil.ReportArgs)localObject, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.UIEntryStub.3
 * JD-Core Version:    0.7.0.1
 */