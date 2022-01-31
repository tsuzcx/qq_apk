package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

final class IPCallUserProfileUI$3
  implements View.OnClickListener
{
  IPCallUserProfileUI$3(IPCallUserProfileUI paramIPCallUserProfileUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(22373);
    paramView = new Intent(this.nWR, IPCallAllRecordUI.class);
    if (!bo.isNullOrNil(IPCallUserProfileUI.e(this.nWR))) {
      paramView.putExtra("IPCallAllRecordUI_contactId", IPCallUserProfileUI.e(this.nWR));
    }
    for (;;)
    {
      paramView.putExtra("IPCallAllRecordUI_isSinglePhoneNumber", IPCallUserProfileUI.g(this.nWR));
      this.nWR.startActivity(paramView);
      AppMethodBeat.o(22373);
      return;
      if (!bo.isNullOrNil(IPCallUserProfileUI.f(this.nWR))) {
        paramView.putExtra("IPCallAllRecordUI_phoneNumber", IPCallUserProfileUI.f(this.nWR));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallUserProfileUI.3
 * JD-Core Version:    0.7.0.1
 */