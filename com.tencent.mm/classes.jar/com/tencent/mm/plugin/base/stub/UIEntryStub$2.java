package com.tencent.mm.plugin.base.stub;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.pluginsdk.model.app.ReportUtil.ReportArgs;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.transmit.SendAppMessageWrapperUI;

final class UIEntryStub$2
  implements d.a
{
  UIEntryStub$2(UIEntryStub paramUIEntryStub, Bundle paramBundle, SendMessageToWX.Req paramReq) {}
  
  public final void em(boolean paramBoolean)
  {
    boolean bool = this.hRY.isFinishing();
    y.d("MicroMsg.UIEntryStub", "onCheckEnd, isPass = " + paramBoolean + ", isFinishing = " + bool);
    Object localObject;
    if ((paramBoolean) && (!bool))
    {
      localObject = new Intent(this.hRY, SendAppMessageWrapperUI.class);
      ((Intent)localObject).putExtras(this.byv);
      ((Intent)localObject).putExtra("Select_Conv_User", "weixinfile");
      ((Intent)localObject).putExtra("SendAppMessageWrapper_Scene", this.hRZ.scene);
      this.hRY.startActivity((Intent)localObject);
    }
    for (;;)
    {
      new ah().postDelayed(new UIEntryStub.2.1(this), 1000L);
      return;
      localObject = ReportUtil.c(this.hRY.getIntent().getExtras(), -3);
      ReportUtil.a(this.hRY, (ReportUtil.ReportArgs)localObject, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.UIEntryStub.2
 * JD-Core Version:    0.7.0.1
 */