package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;

final class DisasterUI$1
  implements View.OnClickListener
{
  DisasterUI$1(DisasterUI paramDisasterUI, String paramString) {}
  
  public final void onClick(View paramView)
  {
    y.i("MicroMsg.DisasterUI", "summerdiz jump link");
    h.nFQ.f(13939, new Object[] { Integer.valueOf(1) });
    paramView = new Intent("android.intent.action.VIEW");
    paramView.setData(Uri.parse(this.val$url));
    this.flo.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.DisasterUI.1
 * JD-Core Version:    0.7.0.1
 */