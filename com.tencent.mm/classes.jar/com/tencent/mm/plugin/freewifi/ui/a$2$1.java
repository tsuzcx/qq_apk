package com.tencent.mm.plugin.freewifi.ui;

import android.view.View;
import com.tencent.mm.h.a.bj;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

final class a$2$1
  implements Runnable
{
  a$2$1(a.2 param2, View paramView) {}
  
  public final void run()
  {
    bj localbj = new bj();
    long l = System.currentTimeMillis();
    a.udP.m(localbj);
    y.i("MicroMsg.FreeWifi.FreeWifiBanner", "summeranrt CheckWechatFreeWifiEvent take[%d]ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    ai.d(new a.2.1.1(this, localbj));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.a.2.1
 * JD-Core Version:    0.7.0.1
 */