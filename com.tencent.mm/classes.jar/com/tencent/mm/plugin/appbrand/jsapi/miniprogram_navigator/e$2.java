package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPreInitTask;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.widget.a.c;

final class e$2
  implements com.tencent.mm.model.gdpr.b
{
  e$2(AppBrandPreInitTask paramAppBrandPreInitTask, d paramd) {}
  
  public final void hX(int paramInt)
  {
    if (paramInt == 0)
    {
      this.gxd.alC();
      return;
    }
    ai.d(new Runnable()
    {
      public final void run()
      {
        com.tencent.mm.plugin.appbrand.widget.b.b localb = new com.tencent.mm.plugin.appbrand.widget.b.b(e.2.this.gwW.getContext());
        localb.setTitle(y.j.appbrand_gdpr_deny_alert_title);
        int i = y.j.appbrand_gdpr_deny_alert_message;
        localb.uMb.setVisibility(0);
        localb.uLZ.setVisibility(0);
        localb.uLZ.setText(i);
        localb.setCanceledOnTouchOutside(false);
        localb.a(y.j.app_ok, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            paramAnonymous2DialogInterface.dismiss();
          }
        });
        e.2.this.gwW.getRuntime().fys.b(localb);
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.e.2
 * JD-Core Version:    0.7.0.1
 */