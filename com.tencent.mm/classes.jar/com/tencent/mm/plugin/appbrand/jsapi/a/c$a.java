package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.content.res.Resources;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.y.j;

final class c$a
  extends CountDownTimer
{
  public c$a(c paramc)
  {
    super(60000L, 1000L);
  }
  
  public final void onFinish()
  {
    this.gkx.aig();
  }
  
  public final void onTick(long paramLong)
  {
    this.gkx.gkp.setText(this.gkx.gkh.getContentView().getResources().getString(y.j.app_brand_get_phone_number_repeat_send_after_second, new Object[] { paramLong / 1000L }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.a.c.a
 * JD-Core Version:    0.7.0.1
 */