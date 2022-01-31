package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R.l;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.ipcall.a.e.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ad;

final class IPCallUserProfileUI$9
  implements View.OnClickListener
{
  IPCallUserProfileUI$9(IPCallUserProfileUI paramIPCallUserProfileUI) {}
  
  public final void onClick(View paramView)
  {
    IPCallUserProfileUI.d(this.lzF).start();
    IPCallUserProfileUI.d(this.lzF).lrY = 1L;
    IPCallUserProfileUI.d(this.lzF).lrZ = 5L;
    IPCallUserProfileUI.d(this.lzF).finish();
    h.nFQ.f(12766, new Object[] { Integer.valueOf(3) });
    if (!bk.bl(IPCallUserProfileUI.e(this.lzF)))
    {
      paramView = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + IPCallUserProfileUI.FT(IPCallUserProfileUI.e(this.lzF))));
      paramView.putExtra("sms_body", this.lzF.getString(R.l.ip_call_invite_wechat_friend_sms, new Object[] { q.GQ().Bp() }));
      this.lzF.startActivity(paramView);
    }
    while (bk.bl(IPCallUserProfileUI.f(this.lzF))) {
      return;
    }
    paramView = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + IPCallUserProfileUI.f(this.lzF)));
    paramView.putExtra("sms_body", this.lzF.getString(R.l.ip_call_invite_wechat_friend_sms, new Object[] { q.GQ().Bp() }));
    this.lzF.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallUserProfileUI.9
 * JD-Core Version:    0.7.0.1
 */