package com.tencent.mm.plugin.appbrand.share.a;

import android.os.Bundle;
import com.tencent.mm.plugin.appbrand.share.widget.WxaShareMessagePage;
import com.tencent.mm.sdk.platformtools.y;

final class a$3$1
  implements Runnable
{
  a$3$1(a.3 param3, Bundle paramBundle) {}
  
  public final void run()
  {
    String str = this.byv.getString("delay_load_img_path");
    this.haV.haT.setImageUrl(str);
    y.i("MicroMsg.WxaShareMessageService", "onLoadImageFinishedAction(%s)", new Object[] { str });
    a.a(this.haV.haU);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.share.a.a.3.1
 * JD-Core Version:    0.7.0.1
 */