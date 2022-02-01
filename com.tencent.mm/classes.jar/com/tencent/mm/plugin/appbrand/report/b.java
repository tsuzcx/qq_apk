package com.tencent.mm.plugin.appbrand.report;

import android.content.Context;
import android.media.AudioManager;
import android.os.Looper;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.d.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.IPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.protocal.protobuf.bmm;
import com.tencent.mm.protocal.protobuf.bmn;
import com.tencent.mm.protocal.protobuf.eip;
import com.tencent.mm.protocal.protobuf.eiq;
import com.tencent.mm.protocal.protobuf.eir;
import com.tencent.mm.protocal.protobuf.eis;
import com.tencent.mm.protocal.protobuf.eiu;
import com.tencent.mm.protocal.protobuf.eiv;
import com.tencent.mm.protocal.protobuf.ekj;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;

public final class b
{
  public aq krf;
  public eiq mvn;
  public eip mvo;
  public eiu mvp;
  public eiv mvq;
  public eis mvr;
  public ekj mvs;
  
  public b()
  {
    AppMethodBeat.i(48014);
    this.mvn = null;
    this.mvo = null;
    this.mvp = null;
    this.mvq = null;
    this.mvr = null;
    this.mvs = null;
    this.krf = new aq(Looper.getMainLooper());
    AppMethodBeat.o(48014);
  }
  
  public static abstract interface a
  {
    public abstract void dL(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.b
 * JD-Core Version:    0.7.0.1
 */