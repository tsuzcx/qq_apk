package com.tencent.mm.plugin.appbrand.jsapi.e;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.mm.sdk.d.d;

final class l
  extends d
{
  Bundle ezQ;
  final b grL;
  public l.a grM;
  final com.tencent.mm.sdk.d.c grN = new l.1(this);
  final com.tencent.mm.sdk.d.c grO = new l.2(this);
  final com.tencent.mm.sdk.d.c grP = new l.3(this);
  
  l(com.tencent.mm.plugin.appbrand.jsapi.c paramc)
  {
    super("RuntimeLocationUpdateStateManager[" + paramc.getAppId() + "]", Looper.getMainLooper());
    this.grL = new b(paramc);
    a(this.grN);
    a(this.grO);
    a(this.grP);
    b(this.grN);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.e.l
 * JD-Core Version:    0.7.0.1
 */