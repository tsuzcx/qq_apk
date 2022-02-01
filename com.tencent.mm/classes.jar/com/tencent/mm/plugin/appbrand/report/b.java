package com.tencent.mm.plugin.appbrand.report;

import android.content.Context;
import android.media.AudioManager;
import android.os.Looper;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.IPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.protocal.protobuf.blu;
import com.tencent.mm.protocal.protobuf.blv;
import com.tencent.mm.protocal.protobuf.egy;
import com.tencent.mm.protocal.protobuf.egz;
import com.tencent.mm.protocal.protobuf.eha;
import com.tencent.mm.protocal.protobuf.ehb;
import com.tencent.mm.protocal.protobuf.ehd;
import com.tencent.mm.protocal.protobuf.ehe;
import com.tencent.mm.protocal.protobuf.eis;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;

public final class b
{
  public ap knP;
  public egz mqp;
  public egy mqq;
  public ehd mqr;
  public ehe mqs;
  public ehb mqt;
  public eis mqu;
  
  public b()
  {
    AppMethodBeat.i(48014);
    this.mqp = null;
    this.mqq = null;
    this.mqr = null;
    this.mqs = null;
    this.mqt = null;
    this.mqu = null;
    this.knP = new ap(Looper.getMainLooper());
    AppMethodBeat.o(48014);
  }
  
  public static abstract interface a
  {
    public abstract void dL(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.b
 * JD-Core Version:    0.7.0.1
 */