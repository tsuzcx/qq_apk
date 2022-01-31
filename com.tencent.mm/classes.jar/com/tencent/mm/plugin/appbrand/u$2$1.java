package com.tencent.mm.plugin.appbrand;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.xweb.WebView.c;

final class u$2$1
  implements WebView.c
{
  u$2$1(u.2 param2, ah paramah) {}
  
  public final void onCoreInitFinished()
  {
    this.fAs.post(this.fAt.fAr);
  }
  
  public final void tc()
  {
    u.access$100();
    Looper.myLooper().quit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.2.1
 * JD-Core Version:    0.7.0.1
 */