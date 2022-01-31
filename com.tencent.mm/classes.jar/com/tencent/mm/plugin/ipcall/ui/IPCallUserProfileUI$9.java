package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.ipcall.a.e.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;

final class IPCallUserProfileUI$9
  implements View.OnClickListener
{
  IPCallUserProfileUI$9(IPCallUserProfileUI paramIPCallUserProfileUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(22381);
    IPCallUserProfileUI.d(this.nWR).start();
    IPCallUserProfileUI.d(this.nWR).nPu = 1L;
    IPCallUserProfileUI.d(this.nWR).nPv = 5L;
    IPCallUserProfileUI.d(this.nWR).finish();
    h.qsU.e(12766, new Object[] { Integer.valueOf(3) });
    if (!bo.isNullOrNil(IPCallUserProfileUI.e(this.nWR)))
    {
      paramView = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + IPCallUserProfileUI.Rv(IPCallUserProfileUI.e(this.nWR))));
      paramView.putExtra("sms_body", this.nWR.getString(2131300852, new Object[] { r.ZS().Oe() }));
      this.nWR.startActivity(paramView);
      AppMethodBeat.o(22381);
      return;
    }
    if (!bo.isNullOrNil(IPCallUserProfileUI.f(this.nWR)))
    {
      paramView = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + IPCallUserProfileUI.f(this.nWR)));
      paramView.putExtra("sms_body", this.nWR.getString(2131300852, new Object[] { r.ZS().Oe() }));
      this.nWR.startActivity(paramView);
    }
    AppMethodBeat.o(22381);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallUserProfileUI.9
 * JD-Core Version:    0.7.0.1
 */