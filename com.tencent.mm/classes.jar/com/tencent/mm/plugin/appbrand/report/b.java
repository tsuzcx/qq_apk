package com.tencent.mm.plugin.appbrand.report;

import android.content.Context;
import android.media.AudioManager;
import android.os.Looper;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.IPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.protocal.protobuf.bzd;
import com.tencent.mm.protocal.protobuf.bze;
import com.tencent.mm.protocal.protobuf.fdh;
import com.tencent.mm.protocal.protobuf.fdi;
import com.tencent.mm.protocal.protobuf.fdj;
import com.tencent.mm.protocal.protobuf.fdk;
import com.tencent.mm.protocal.protobuf.fdm;
import com.tencent.mm.protocal.protobuf.fdn;
import com.tencent.mm.protocal.protobuf.ffc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;

public final class b
{
  public MMHandler luO;
  public fdi nGb;
  public fdh nGc;
  public fdm nGd;
  public fdn nGe;
  public fdk nGf;
  public ffc nGg;
  
  public b()
  {
    AppMethodBeat.i(48014);
    this.nGb = null;
    this.nGc = null;
    this.nGd = null;
    this.nGe = null;
    this.nGf = null;
    this.nGg = null;
    this.luO = new MMHandler(Looper.getMainLooper());
    AppMethodBeat.o(48014);
  }
  
  public static abstract interface a
  {
    public abstract void dW(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.b
 * JD-Core Version:    0.7.0.1
 */