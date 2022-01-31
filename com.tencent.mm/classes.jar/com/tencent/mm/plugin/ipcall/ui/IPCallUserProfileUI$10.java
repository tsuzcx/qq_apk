package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;

final class IPCallUserProfileUI$10
  implements View.OnClickListener
{
  IPCallUserProfileUI$10(IPCallUserProfileUI paramIPCallUserProfileUI) {}
  
  public final void onClick(View paramView)
  {
    try
    {
      h.nFQ.f(12061, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
      paramView = new Intent("android.intent.action.INSERT");
      paramView.setType("vnd.android.cursor.dir/contact");
      paramView.putExtra("phone", IPCallUserProfileUI.f(this.lzF));
      this.lzF.startActivity(paramView);
      return;
    }
    catch (Exception paramView)
    {
      y.e("MicroMsg.IPCallUserProfileUI", paramView.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallUserProfileUI.10
 * JD-Core Version:    0.7.0.1
 */