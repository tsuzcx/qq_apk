package com.tencent.mm.plugin.appbrand.jsapi.e;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.d.d;

final class l
  extends d
{
  Bundle fPG;
  final b hNj;
  public l.a hNk;
  final com.tencent.mm.sdk.d.c hNl;
  final com.tencent.mm.sdk.d.c hNm;
  final com.tencent.mm.sdk.d.c hNn;
  
  l(com.tencent.mm.plugin.appbrand.jsapi.c paramc)
  {
    super("RuntimeLocationUpdateStateManager[" + paramc.getAppId() + "]", Looper.getMainLooper());
    AppMethodBeat.i(93837);
    this.hNl = new l.1(this);
    this.hNm = new l.2(this);
    this.hNn = new l.3(this);
    this.hNj = new b(paramc);
    a(this.hNl);
    a(this.hNm);
    a(this.hNn);
    b(this.hNl);
    AppMethodBeat.o(93837);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.e.l
 * JD-Core Version:    0.7.0.1
 */