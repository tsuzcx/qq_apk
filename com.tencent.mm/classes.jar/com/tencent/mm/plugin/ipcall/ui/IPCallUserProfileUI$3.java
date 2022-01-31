package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.bk;

final class IPCallUserProfileUI$3
  implements View.OnClickListener
{
  IPCallUserProfileUI$3(IPCallUserProfileUI paramIPCallUserProfileUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent(this.lzF, IPCallAllRecordUI.class);
    if (!bk.bl(IPCallUserProfileUI.e(this.lzF))) {
      paramView.putExtra("IPCallAllRecordUI_contactId", IPCallUserProfileUI.e(this.lzF));
    }
    for (;;)
    {
      paramView.putExtra("IPCallAllRecordUI_isSinglePhoneNumber", IPCallUserProfileUI.g(this.lzF));
      this.lzF.startActivity(paramView);
      return;
      if (!bk.bl(IPCallUserProfileUI.f(this.lzF))) {
        paramView.putExtra("IPCallAllRecordUI_phoneNumber", IPCallUserProfileUI.f(this.lzF));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallUserProfileUI.3
 * JD-Core Version:    0.7.0.1
 */