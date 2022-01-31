package com.tencent.mm.plugin.base.stub;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.pluginsdk.model.app.ReportUtil.ReportArgs;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.transmit.SendAppMessageWrapperUI;

final class UIEntryStub$2
  implements d.a
{
  UIEntryStub$2(UIEntryStub paramUIEntryStub, Bundle paramBundle, SendMessageToWX.Req paramReq) {}
  
  public final void fH(boolean paramBoolean)
  {
    AppMethodBeat.i(18128);
    boolean bool = this.jLD.isFinishing();
    ab.d("MicroMsg.UIEntryStub", "onCheckEnd, isPass = " + paramBoolean + ", isFinishing = " + bool);
    Object localObject;
    if ((paramBoolean) && (!bool))
    {
      localObject = new Intent(this.jLD, SendAppMessageWrapperUI.class);
      ((Intent)localObject).putExtras(this.cax);
      ((Intent)localObject).putExtra("Select_Conv_User", "weixinfile");
      ((Intent)localObject).putExtra("SendAppMessageWrapper_Scene", this.jLE.scene);
      this.jLD.startActivity((Intent)localObject);
    }
    for (;;)
    {
      new ak().postDelayed(new UIEntryStub.2.1(this), 1000L);
      AppMethodBeat.o(18128);
      return;
      localObject = ReportUtil.c(this.jLD.getIntent().getExtras(), -3);
      ReportUtil.a(this.jLD, (ReportUtil.ReportArgs)localObject, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.UIEntryStub.2
 * JD-Core Version:    0.7.0.1
 */