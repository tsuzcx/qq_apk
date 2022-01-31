package com.tencent.mm.plugin.base.stub;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.pluginsdk.model.app.ReportUtil.ReportArgs;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.chatting.ChattingUI;

final class UIEntryStub$3
  implements d.a
{
  UIEntryStub$3(UIEntryStub paramUIEntryStub, Bundle paramBundle, SendMessageToWX.Req paramReq) {}
  
  public final void fH(boolean paramBoolean)
  {
    AppMethodBeat.i(18130);
    boolean bool = this.jLD.isFinishing();
    Object localObject = this.cax.getString("SendAppMessageWrapper_UserName", "");
    ab.i("MicroMsg.UIEntryStub", "onCheckEnd, isPass = " + paramBoolean + ", isFinishing = " + bool + ", username = " + (String)localObject);
    if ((paramBoolean) && (!bool) && (!bo.isNullOrNil((String)localObject)))
    {
      Intent localIntent = new Intent(this.jLD, ChattingUI.class);
      localIntent.putExtras(this.cax);
      localIntent.putExtra("finish_direct", false);
      localIntent.putExtra("Chat_User", (String)localObject);
      localIntent.putExtra("SendAppMessageWrapper_Scene", this.jLE.scene);
      if (this.jLE.message.getType() == 45) {
        localIntent.putExtra("Select_Send_Card", true);
      }
      this.jLD.startActivity(localIntent);
    }
    for (;;)
    {
      new ak().postDelayed(new UIEntryStub.3.1(this), 1000L);
      AppMethodBeat.o(18130);
      return;
      localObject = ReportUtil.c(this.jLD.getIntent().getExtras(), -3);
      ReportUtil.a(this.jLD, (ReportUtil.ReportArgs)localObject, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.UIEntryStub.3
 * JD-Core Version:    0.7.0.1
 */